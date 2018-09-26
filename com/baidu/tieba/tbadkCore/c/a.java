package com.baidu.tieba.tbadkCore.c;

import android.location.Address;
import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.atomData.WriteActivityConfig;
import com.baidu.tbadk.core.atomData.WriteShareActivityConfig;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.ErrorData;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.TbErrInfo;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.i;
import com.baidu.tbadk.core.util.l;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.core.util.x;
import com.baidu.tbadk.core.voice.service.b;
import com.baidu.tbadk.coreExtra.data.VideoInfo;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.coreExtra.data.j;
import com.baidu.tbadk.coreExtra.data.k;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tbadk.img.ImageUploadResult;
import com.baidu.tbadk.img.f;
import com.baidu.tieba.e;
import com.baidu.tieba.j.h;
import com.baidu.tieba.tbadkCore.videoupload.VideoFinishResult;
import com.baidu.tieba.tbadkCore.writeModel.c;
import com.tencent.connect.common.Constants;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class a {
    private f aTO;
    private AntiData gWC;
    private com.baidu.tieba.tbadkCore.videoupload.a gWD;
    private InterfaceC0241a gWE;
    private h gWF;
    private ErrorData mErrorData;
    private static final String gWz = TbConfig.SERVER_ADDRESS + TbConfig.POST_THREAD_ADDRESS;
    private static final String gWA = TbConfig.SERVER_ADDRESS + TbConfig.REPLY_THREAD_ADDRESS;
    public static final String gWB = TbConfig.SERVER_ADDRESS + TbConfig.POST_THREAD_FOR_SHARE_ADDRESS;
    private x mNetwork = null;
    private boolean isCancelled = false;

    /* renamed from: com.baidu.tieba.tbadkCore.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0241a {
        void onUploadProgress(int i);
    }

    public a() {
        this.mErrorData = null;
        this.mErrorData = new ErrorData();
    }

    public void a(h hVar) {
        this.gWF = hVar;
    }

    public void a(InterfaceC0241a interfaceC0241a) {
        this.gWE = interfaceC0241a;
    }

    public ImageUploadResult e(ImageFileInfo imageFileInfo, boolean z) {
        if (imageFileInfo == null) {
            return null;
        }
        if (this.aTO == null) {
            this.aTO = new f("HTTPWriteService.postImageData");
        }
        return this.aTO.d(imageFileInfo, z);
    }

    public String a(WriteData writeData, boolean z) {
        String returnVoiceMd5;
        boolean z2;
        String str;
        String str2;
        String str3;
        String str4 = null;
        if (writeData != null) {
            this.mNetwork = new x();
            this.mNetwork.zR().AP().mIsNeedTbs = true;
            this.mNetwork.aR(true);
            this.mNetwork.u("authsid", writeData.getAuthSid());
            if (writeData.getType() == 3) {
                if (writeData.getVcode() != null && writeData.getVcode().length() > 0) {
                    this.mNetwork.u("vcode", writeData.getVcode());
                }
                if (TbadkCoreApplication.getInst().getNewVcodeWebviewCrashCount() < 3) {
                    this.mNetwork.u("tag", Constants.VIA_REPORT_TYPE_SHARE_TO_QZONE);
                }
                this.mNetwork.u("newVcode", "1");
                this.mNetwork.u("content", writeData.getContent());
                this.mNetwork.setUrl(gWB);
                this.mNetwork.u(ImageViewerConfig.FORUM_NAME, writeData.getForumName());
                this.mNetwork.u("title", writeData.getTitle());
                if (!StringUtils.isNull(writeData.getPostPrefix())) {
                    this.mNetwork.u("post_prefix", writeData.getPostPrefix());
                }
                this.mNetwork.u("apiKey", writeData.getShareApiKey());
                this.mNetwork.u("appName", writeData.getShareAppName());
                this.mNetwork.u("signKey", writeData.getShareSignKey());
                this.mNetwork.u("summary_title", writeData.getShareSummaryTitle());
                this.mNetwork.u("summary_content", writeData.getShareSummaryContent());
                this.mNetwork.u("summary_img", writeData.getShareSummaryImg());
                this.mNetwork.u(WriteShareActivityConfig.SHARE_SUMMARY_IMG_WIDTH, String.valueOf(writeData.getShareSummaryImgWidth()));
                this.mNetwork.u(WriteShareActivityConfig.SHARE_SUMMARY_IMG_HEIGHT, String.valueOf(writeData.getShareSummaryImgHeight()));
                this.mNetwork.u(WriteShareActivityConfig.SHARE_SUMMARY_IMG_TYPE, writeData.getShareSummaryImgType());
                this.mNetwork.u("referUrl", writeData.getShareReferUrl());
                str3 = null;
            } else {
                if (z && writeData.isHasImages()) {
                    if (this.aTO == null) {
                        this.aTO = new f("HTTPWriteService.postWriteData");
                    }
                    if (writeData.getType() == 6) {
                        if (this.aTO.b(writeData.getWriteImagesInfo(), true) != null) {
                            this.mErrorData.setError_code(-53);
                            this.mErrorData.setError_msg(TbadkCoreApplication.getInst().getString(e.j.upload_error));
                        }
                    } else {
                        ErrorData b = this.aTO.b(writeData.getWriteImagesInfo(), true);
                        if (b != null) {
                            this.mErrorData.setError_code(-53);
                            this.mErrorData.setError_msg(b.getError_msg());
                        }
                    }
                }
                if (!this.isCancelled) {
                    String voice = writeData.getVoice();
                    int voiceDuringTime = writeData.getVoiceDuringTime();
                    if (writeData.getReturnVoiceMd5() == null) {
                        z2 = false;
                        returnVoiceMd5 = null;
                    } else {
                        returnVoiceMd5 = writeData.getReturnVoiceMd5();
                        z2 = true;
                    }
                    if (voice == null || z2) {
                        str = returnVoiceMd5;
                    } else {
                        b bVar = new b(TbConfig.UPLOAD_CHUNK_AUDIO_ADDRESS, TbConfig.FINISH_UPLOAD_CHUNK_AUDIO_ADDRESS);
                        bVar.C("type", 1);
                        String v = l.v(voice, 1);
                        k fQ = bVar.fQ(v);
                        if (fQ != null && fQ.isSuccess()) {
                            j Dr = fQ.Dr();
                            if (Dr != null) {
                                String Dp = Dr.Dp();
                                com.baidu.tbadk.core.voice.a.b.renameFile(writeData.getVoice(), Dp);
                                writeData.setReturnVoiceMd5(Dp);
                                str = Dp;
                            } else {
                                com.baidu.tbadk.core.util.k kVar = new com.baidu.tbadk.core.util.k();
                                kVar.h("ErrCode", Integer.valueOf(fQ.getErrorCode()));
                                kVar.h("ErrMsg", fQ.getErrorString());
                                TiebaStatic.voiceError(TbErrInfo.ERR_VOI_SEND, "audioUploadData is null", kVar.toString());
                                this.mErrorData.setError_code(fQ.getErrorCode());
                                this.mErrorData.setError_msg(fQ.getErrorString());
                            }
                        } else {
                            com.baidu.tbadk.core.util.k kVar2 = new com.baidu.tbadk.core.util.k();
                            kVar2.h("audioFile", v);
                            TiebaStatic.voiceError(TbErrInfo.ERR_VOI_SEND, "uploadService.upload null or fail", kVar2.toString());
                            this.mErrorData.setError_code(fQ.getErrorCode());
                            this.mErrorData.setError_msg(fQ.getErrorString());
                        }
                    }
                    if (!this.isCancelled) {
                        VideoInfo videoInfo = writeData.getVideoInfo();
                        if (videoInfo != null) {
                            if (videoInfo.needUploadVideo()) {
                                this.gWD = new com.baidu.tieba.tbadkCore.videoupload.a(this.gWF);
                                VideoFinishResult a = this.gWD.a(writeData.getForumId(), videoInfo.getVideoPath(), videoInfo.getVideoDuration(), new com.baidu.tieba.tbadkCore.videoupload.a.e() { // from class: com.baidu.tieba.tbadkCore.c.a.1
                                    int gWG = 0;

                                    @Override // com.baidu.tieba.tbadkCore.videoupload.a.e
                                    public void aw(float f) {
                                        int i = (int) (90.0f * f);
                                        if (i != this.gWG) {
                                            this.gWG = i;
                                            a.this.notifyUploadProgress(i);
                                        }
                                    }
                                });
                                if (a == null) {
                                    this.mErrorData.setError_code(-53);
                                    this.mErrorData.setError_msg(TbadkCoreApplication.getInst().getString(e.j.upload_error));
                                } else if (a.isSuccess()) {
                                    videoInfo.setVideoMd5(a.getVideoMd5());
                                    videoInfo.setVideoUrl(a.getVideoUrl());
                                } else {
                                    this.mErrorData.setError_code(a.getErrorNo());
                                    this.mErrorData.setError_msg(a.getUserMessage());
                                }
                            }
                            if (videoInfo.needUploadThunmb()) {
                                if (this.aTO == null) {
                                    this.aTO = new f("HTTPWriteService.postWriteData");
                                }
                                ImageUploadResult n = this.aTO.n(videoInfo.getThumbPath(), false);
                                if (n != null) {
                                    videoInfo.setThumbId(n.picId);
                                }
                            }
                            JSONObject jSONObject = new JSONObject();
                            try {
                                if (!v.z(videoInfo.getStickListInfo())) {
                                    JSONArray jSONArray = new JSONArray();
                                    for (String str5 : videoInfo.getStickListInfo()) {
                                        jSONArray.put(str5);
                                    }
                                    jSONObject.put("sticker_id", jSONArray);
                                }
                                if (!v.z(videoInfo.getBeautifyListInfo())) {
                                    JSONArray jSONArray2 = new JSONArray();
                                    for (String str6 : videoInfo.getBeautifyListInfo()) {
                                        jSONArray2.put(str6);
                                    }
                                    jSONObject.put("beautify_level", jSONArray2);
                                }
                                if (!v.z(videoInfo.getFilterListInfo())) {
                                    JSONArray jSONArray3 = new JSONArray();
                                    for (String str7 : videoInfo.getFilterListInfo()) {
                                        jSONArray3.put(str7);
                                    }
                                    jSONObject.put("filter_id", jSONArray3);
                                }
                                if (!v.z(videoInfo.getMusicListInfo())) {
                                    JSONArray jSONArray4 = new JSONArray();
                                    for (String str8 : videoInfo.getMusicListInfo()) {
                                        jSONArray4.put(str8);
                                    }
                                    jSONObject.put("music_id", jSONArray4);
                                }
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                            this.mNetwork.u("video_other", jSONObject.toString());
                        }
                        if (!this.isCancelled) {
                            this.mNetwork.u("anonymous", "1");
                            this.mNetwork.u("can_no_forum", writeData.isCanNoForum() ? "1" : "0");
                            this.mNetwork.u("is_feedback", writeData.isUserFeedback() ? "1" : "0");
                            this.mNetwork.u("takephoto_num", String.valueOf(writeData.getTakePhotoNum()));
                            this.mNetwork.u("entrance_type", String.valueOf(writeData.getEntranceType()));
                            if (str != null) {
                                this.mNetwork.u("voice_md5", str);
                                this.mNetwork.u("during_time", String.valueOf(voiceDuringTime));
                            }
                            String imagesCodeForPost = writeData.getImagesCodeForPost();
                            if (writeData.getType() != 6) {
                                if (writeData.getType() == 7 && TextUtils.isEmpty(writeData.getTitle()) && TextUtils.isEmpty(str) && TextUtils.isEmpty(imagesCodeForPost) && TextUtils.isEmpty(writeData.getContent()) && writeData.getVideoInfo() == null) {
                                    this.mErrorData.setError_code(-53);
                                    this.mErrorData.setError_msg(TbadkCoreApplication.getInst().getString(e.j.sand_fail));
                                } else if ((!(writeData.getType() == 0 || writeData.getType() == 9) || TextUtils.isEmpty(writeData.getTitle())) && TextUtils.isEmpty(str) && TextUtils.isEmpty(imagesCodeForPost) && TextUtils.isEmpty(writeData.getContent()) && writeData.getVideoInfo() == null && writeData.getType() != 7 && !writeData.isLinkThread()) {
                                    this.mErrorData.setError_code(-53);
                                    this.mErrorData.setError_msg(TbadkCoreApplication.getInst().getString(e.j.sand_fail));
                                }
                            }
                            if (writeData.getVcode() != null && writeData.getVcode().length() > 0) {
                                this.mNetwork.u("vcode", writeData.getVcode());
                            }
                            if (!StringUtils.isNull(writeData.getVcodeMD5())) {
                                this.mNetwork.u("vcode_md5", writeData.getVcodeMD5());
                            }
                            if (!StringUtils.isNull(writeData.getVcodeType())) {
                                this.mNetwork.u("vcode_type", writeData.getVcodeType());
                            }
                            if (TbadkCoreApplication.getInst().getNewVcodeWebviewCrashCount() < 3) {
                                this.mNetwork.u("vcode_tag", Constants.VIA_REPORT_TYPE_SET_AVATAR);
                            }
                            Address R = com.baidu.adp.lib.d.a.iH().R(false);
                            this.mNetwork.u("new_vcode", "1");
                            if (writeData.getVideoInfo() == null || !writeData.getVideoInfo().hasUpload()) {
                                str2 = writeData.getContent() + imagesCodeForPost;
                            } else {
                                str2 = writeData.getContent() + writeData.getVideoInfo().buildContent() + imagesCodeForPost;
                            }
                            i.ei(str2);
                            this.mNetwork.u("content", com.baidu.tieba.face.a.md(str2));
                            this.mNetwork.u("reply_uid", writeData.getReplyId());
                            if (!TextUtils.isEmpty(writeData.getMemeText())) {
                                this.mNetwork.u("meme_text", writeData.getMemeText());
                            }
                            if (!TextUtils.isEmpty(writeData.getMemeContSign())) {
                                this.mNetwork.u("meme_cont_sign", writeData.getMemeContSign());
                            }
                            switch (writeData.getType()) {
                                case 0:
                                case 7:
                                case 9:
                                    this.mNetwork.setUrl(gWz);
                                    if (writeData.isCanNoForum()) {
                                        this.mNetwork.u(ImageViewerConfig.FORUM_ID, "0");
                                        this.mNetwork.u("kw", "");
                                        this.mNetwork.u("transform_forums", writeData.getTransmitForumData());
                                    } else {
                                        this.mNetwork.u(ImageViewerConfig.FORUM_ID, writeData.getForumId());
                                        this.mNetwork.u("kw", writeData.getForumName());
                                    }
                                    this.mNetwork.u("is_hide", writeData.isPrivacy() ? "1" : "0");
                                    if (writeData.getVideoId() != null) {
                                        this.mNetwork.u("video_id", writeData.getVideoId());
                                        if (writeData.getOriginalVideoCover() != null) {
                                            this.mNetwork.u("origin_video_cover", writeData.getOriginalVideoCover());
                                        }
                                        if (writeData.getOriginalVideoTitle() != null) {
                                            this.mNetwork.u("origin_video_title", writeData.getOriginalVideoTitle());
                                        }
                                    }
                                    if (writeData.isShareThread()) {
                                        this.mNetwork.u("is_share", "1");
                                        this.mNetwork.u("from_tid", writeData.getOriginalThreadId());
                                    }
                                    this.mNetwork.u(IntentConfig.CALL_FROM, writeData.getCallFrom());
                                    this.mNetwork.u("title", writeData.getTitle());
                                    if (!StringUtils.isNull(writeData.getPostPrefix())) {
                                        this.mNetwork.u("post_prefix", writeData.getPostPrefix());
                                    }
                                    this.mNetwork.u("is_ntitle", writeData.isNoTitle() ? "1" : "0");
                                    if (writeData.isNoTitle()) {
                                        this.mNetwork.u("st_type", "notitle");
                                    }
                                    if (R != null && TbadkCoreApplication.getInst().getIsLocationOn() && !TbConfig.getPositionPagerId().equals(writeData.getForumId())) {
                                        this.mNetwork.u("lbs", String.valueOf(R.getLatitude()) + "," + String.valueOf(R.getLongitude()));
                                    }
                                    c.a(this.mNetwork, writeData);
                                    if (writeData.getCategoryFrom() >= 0) {
                                        this.mNetwork.u("fromCategoryId", String.valueOf(writeData.getCategoryFrom()));
                                    }
                                    if (writeData.getCategoryTo() >= 0) {
                                        this.mNetwork.u("toCategoryId", String.valueOf(writeData.getCategoryTo()));
                                    }
                                    if (writeData.getType() == 7) {
                                        this.mNetwork.u("is_bottle", String.valueOf(1));
                                    }
                                    if (writeData.getRecommendExt() != null) {
                                        this.mNetwork.u("recommend_ext", writeData.getRecommendExt());
                                    }
                                    if (writeData.isLinkThread()) {
                                        this.mNetwork.u("link_url", writeData.getLinkUrl());
                                        this.mNetwork.u("link_url_code", writeData.getLinkUrlCode() == null ? "" : writeData.getLinkUrlCode());
                                    }
                                    this.mNetwork.u("is_link_thread", writeData.isLinkThread() ? "1" : "0");
                                    str3 = imagesCodeForPost;
                                    break;
                                case 1:
                                    this.mNetwork.setUrl(gWA);
                                    this.mNetwork.u(ImageViewerConfig.FORUM_ID, writeData.getForumId());
                                    this.mNetwork.u("from_fourm_id", writeData.getFromForumId());
                                    this.mNetwork.u("v_fid", writeData.getVForumId());
                                    this.mNetwork.u("v_fname", writeData.getVForumName());
                                    this.mNetwork.u("tid", writeData.getThreadId());
                                    this.mNetwork.u("kw", writeData.getForumName());
                                    this.mNetwork.u("is_ad", writeData.getIsAd() ? "1" : "0");
                                    this.mNetwork.u("is_barrage", writeData.isBarrage() ? "1" : "0");
                                    this.mNetwork.u("barrage_time", String.valueOf(writeData.getBarrageTime()));
                                    if (writeData.isFrsReply()) {
                                        this.mNetwork.u("st_param", "frs");
                                    }
                                    if (com.baidu.tbadk.editortools.pb.a.Jf().getStatus() == 1) {
                                        this.mNetwork.u("ptype", "4");
                                    }
                                    if (!StringUtils.isNull(writeData.sourceFrom)) {
                                        this.mNetwork.u("post_from", writeData.sourceFrom);
                                    }
                                    c.a(this.mNetwork, writeData);
                                    str3 = imagesCodeForPost;
                                    break;
                                case 2:
                                    this.mNetwork.setUrl(gWA);
                                    this.mNetwork.u(ImageViewerConfig.FORUM_ID, writeData.getForumId());
                                    this.mNetwork.u("from_fourm_id", writeData.getFromForumId());
                                    this.mNetwork.u("v_fid", writeData.getVForumId());
                                    this.mNetwork.u("v_fname", writeData.getVForumName());
                                    this.mNetwork.u("tid", writeData.getThreadId());
                                    this.mNetwork.u("kw", writeData.getForumName());
                                    this.mNetwork.u("quote_id", String.valueOf(writeData.getFloor()));
                                    this.mNetwork.u("is_twzhibo_thread", String.valueOf(0));
                                    this.mNetwork.u("floor_num", String.valueOf(writeData.getFloorNum()));
                                    if (writeData.getRepostId() != null) {
                                        this.mNetwork.u("repostid", writeData.getRepostId());
                                    }
                                    this.mNetwork.u("is_ad", writeData.getIsAd() ? "1" : "0");
                                    this.mNetwork.u(WriteActivityConfig.IS_ADDITION, writeData.isAddition() ? "1" : "0");
                                    this.mNetwork.u("is_giftpost", writeData.isGiftPost() ? "1" : "0");
                                    this.mNetwork.u("is_giftpost", writeData.isGiftPost() ? "1" : "0");
                                    if (writeData.isAddition()) {
                                        this.mNetwork.u("st_type", "conadd");
                                    }
                                    if (!StringUtils.isNull(writeData.sourceFrom)) {
                                        this.mNetwork.u("post_from", writeData.sourceFrom);
                                        str3 = imagesCodeForPost;
                                        break;
                                    }
                                    str3 = imagesCodeForPost;
                                    break;
                                case 3:
                                case 8:
                                default:
                                    if (writeData.isCanNoForum()) {
                                        this.mNetwork.u(ImageViewerConfig.FORUM_ID, "0");
                                        this.mNetwork.u("kw", "");
                                        this.mNetwork.u("transform_forums", writeData.getTransmitForumData());
                                        str3 = imagesCodeForPost;
                                        break;
                                    } else {
                                        this.mNetwork.u(ImageViewerConfig.FORUM_ID, writeData.getForumId());
                                        this.mNetwork.u("kw", writeData.getForumName());
                                        str3 = imagesCodeForPost;
                                        break;
                                    }
                                case 4:
                                    this.mNetwork.setUrl(gWz);
                                    this.mNetwork.u(ImageViewerConfig.FORUM_ID, writeData.getForumId());
                                    this.mNetwork.u("kw", writeData.getForumName());
                                    this.mNetwork.u("title", writeData.getTitle());
                                    if (!StringUtils.isNull(writeData.getPostPrefix())) {
                                        this.mNetwork.u("post_prefix", writeData.getPostPrefix());
                                    }
                                    this.mNetwork.u("thread_type", "33");
                                    c.a(this.mNetwork, writeData);
                                    str3 = imagesCodeForPost;
                                    break;
                                case 5:
                                    this.mNetwork.setUrl(gWA);
                                    this.mNetwork.u(ImageViewerConfig.FORUM_ID, writeData.getForumId());
                                    this.mNetwork.u("tid", writeData.getThreadId());
                                    this.mNetwork.u("kw", writeData.getForumName());
                                    this.mNetwork.u("is_twzhibo_thread", String.valueOf(1));
                                    c.a(this.mNetwork, writeData);
                                    str3 = imagesCodeForPost;
                                    break;
                                case 6:
                                    this.mNetwork.setUrl(gWz);
                                    this.mNetwork.u(ImageViewerConfig.FORUM_ID, writeData.getForumId());
                                    this.mNetwork.u("kw", writeData.getForumName());
                                    this.mNetwork.u("thread_type", String.valueOf(36));
                                    this.mNetwork.u("title", writeData.getTitle());
                                    if (!StringUtils.isNull(writeData.getPostPrefix())) {
                                        this.mNetwork.u("post_prefix", writeData.getPostPrefix());
                                    }
                                    this.mNetwork.u("is_ntitle", writeData.isNoTitle() ? "1" : "0");
                                    if (writeData.isNoTitle()) {
                                        this.mNetwork.u("st_type", "notitle");
                                    }
                                    c.a(this.mNetwork, writeData);
                                    str3 = imagesCodeForPost;
                                    break;
                            }
                        }
                    }
                }
            }
            if (writeData.isPostLatLng()) {
                String lat = writeData.getLat() == null ? "" : writeData.getLat();
                String lng = writeData.getLng() == null ? "" : writeData.getLng();
                this.mNetwork.u("real_lat", lat);
                this.mNetwork.u("real_lng", lng);
            }
            if (TbadkCoreApplication.getCurrentAccountInfo() != null) {
                this.mNetwork.u("name_show", TbadkCoreApplication.getCurrentAccountNameShow());
            }
            str4 = this.mNetwork.zt();
            notifyUploadProgress(95);
            if (this.mNetwork.zR().AQ().isRequestSuccess()) {
                this.mErrorData.parserJson(str4);
            } else {
                this.mErrorData.setError_code(this.mNetwork.zU() ? this.mNetwork.zV() : this.mNetwork.zW());
                this.mErrorData.setError_msg(this.mNetwork.getErrorString());
            }
            if (this.mErrorData.error_code != 0 && !com.baidu.adp.lib.util.j.kK()) {
                this.mErrorData.setError_msg(TbadkCoreApplication.getInst().getApp().getString(e.j.neterror));
            } else if (this.mErrorData.error_code != 0 && writeData.isHasImages() && com.baidu.adp.lib.util.k.isEmpty(writeData.getContent() + str3)) {
                this.mErrorData.setError_msg(TbadkCoreApplication.getInst().getApp().getString(e.j.img_upload_error));
            }
            try {
                this.gWC = new AntiData();
                this.gWC.parserJson(new JSONObject(str4).optJSONObject("anti_stat"));
            } catch (Exception e2) {
            }
            if (this.gWC.getBlock_stat() == 0 && this.mErrorData.error_code == 0 && this.mNetwork.zR() != null && this.mNetwork.zR().AP() != null) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921344, this.mNetwork.zR().AP().AS()));
            }
            notifyUploadProgress(100);
        }
        return str4;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifyUploadProgress(int i) {
        if (this.gWE != null) {
            this.gWE.onUploadProgress(i);
        }
    }

    public boolean isRequestSuccess() {
        if (this.mNetwork == null) {
            return false;
        }
        return this.mNetwork.zR().AQ().isRequestSuccess();
    }

    public void cancel() {
        this.isCancelled = true;
        if (this.mNetwork != null) {
            this.mNetwork.iT();
        }
        if (this.aTO != null) {
            this.aTO.cancel();
        }
        if (this.gWD != null) {
            this.gWD.bzR();
        }
    }

    public AntiData bzc() {
        return this.gWC;
    }

    public ErrorData getErrorData() {
        return this.mErrorData;
    }
}
