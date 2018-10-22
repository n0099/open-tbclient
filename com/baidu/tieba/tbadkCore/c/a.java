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
    private static final String hdV = TbConfig.SERVER_ADDRESS + TbConfig.POST_THREAD_ADDRESS;
    private static final String hdW = TbConfig.SERVER_ADDRESS + TbConfig.REPLY_THREAD_ADDRESS;
    public static final String hdX = TbConfig.SERVER_ADDRESS + TbConfig.POST_THREAD_FOR_SHARE_ADDRESS;
    private f aYn;
    private AntiData hdY;
    private com.baidu.tieba.tbadkCore.videoupload.a hdZ;
    private InterfaceC0276a hea;
    private h heb;
    private ErrorData mErrorData;
    private x mNetwork = null;
    private boolean isCancelled = false;

    /* renamed from: com.baidu.tieba.tbadkCore.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0276a {
        void onUploadProgress(int i);
    }

    public a() {
        this.mErrorData = null;
        this.mErrorData = new ErrorData();
    }

    public void a(h hVar) {
        this.heb = hVar;
    }

    public void a(InterfaceC0276a interfaceC0276a) {
        this.hea = interfaceC0276a;
    }

    public ImageUploadResult e(ImageFileInfo imageFileInfo, boolean z) {
        if (imageFileInfo == null) {
            return null;
        }
        if (this.aYn == null) {
            this.aYn = new f("HTTPWriteService.postImageData");
        }
        return this.aYn.d(imageFileInfo, z);
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
            this.mNetwork.BY().CW().mIsNeedTbs = true;
            this.mNetwork.bb(true);
            this.mNetwork.x("authsid", writeData.getAuthSid());
            if (writeData.getType() == 3) {
                if (writeData.getVcode() != null && writeData.getVcode().length() > 0) {
                    this.mNetwork.x("vcode", writeData.getVcode());
                }
                if (TbadkCoreApplication.getInst().getNewVcodeWebviewCrashCount() < 3) {
                    this.mNetwork.x("tag", Constants.VIA_REPORT_TYPE_SHARE_TO_QZONE);
                }
                this.mNetwork.x("newVcode", "1");
                this.mNetwork.x("content", writeData.getContent());
                this.mNetwork.setUrl(hdX);
                this.mNetwork.x(ImageViewerConfig.FORUM_NAME, writeData.getForumName());
                this.mNetwork.x("title", writeData.getTitle());
                if (!StringUtils.isNull(writeData.getPostPrefix())) {
                    this.mNetwork.x("post_prefix", writeData.getPostPrefix());
                }
                this.mNetwork.x("apiKey", writeData.getShareApiKey());
                this.mNetwork.x("appName", writeData.getShareAppName());
                this.mNetwork.x("signKey", writeData.getShareSignKey());
                this.mNetwork.x("summary_title", writeData.getShareSummaryTitle());
                this.mNetwork.x("summary_content", writeData.getShareSummaryContent());
                this.mNetwork.x("summary_img", writeData.getShareSummaryImg());
                this.mNetwork.x(WriteShareActivityConfig.SHARE_SUMMARY_IMG_WIDTH, String.valueOf(writeData.getShareSummaryImgWidth()));
                this.mNetwork.x(WriteShareActivityConfig.SHARE_SUMMARY_IMG_HEIGHT, String.valueOf(writeData.getShareSummaryImgHeight()));
                this.mNetwork.x(WriteShareActivityConfig.SHARE_SUMMARY_IMG_TYPE, writeData.getShareSummaryImgType());
                this.mNetwork.x("referUrl", writeData.getShareReferUrl());
                str3 = null;
            } else {
                if (z && writeData.isHasImages()) {
                    if (this.aYn == null) {
                        this.aYn = new f("HTTPWriteService.postWriteData");
                    }
                    if (writeData.getType() == 6) {
                        if (this.aYn.b(writeData.getWriteImagesInfo(), true) != null) {
                            this.mErrorData.setError_code(-53);
                            this.mErrorData.setError_msg(TbadkCoreApplication.getInst().getString(e.j.upload_error));
                        }
                    } else {
                        ErrorData b = this.aYn.b(writeData.getWriteImagesInfo(), true);
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
                        bVar.D("type", 1);
                        String w = l.w(voice, 1);
                        k ge = bVar.ge(w);
                        if (ge != null && ge.isSuccess()) {
                            j Fs = ge.Fs();
                            if (Fs != null) {
                                String Fq = Fs.Fq();
                                com.baidu.tbadk.core.voice.a.b.renameFile(writeData.getVoice(), Fq);
                                writeData.setReturnVoiceMd5(Fq);
                                str = Fq;
                            } else {
                                com.baidu.tbadk.core.util.k kVar = new com.baidu.tbadk.core.util.k();
                                kVar.h("ErrCode", Integer.valueOf(ge.getErrorCode()));
                                kVar.h("ErrMsg", ge.getErrorString());
                                TiebaStatic.voiceError(TbErrInfo.ERR_VOI_SEND, "audioUploadData is null", kVar.toString());
                                this.mErrorData.setError_code(ge.getErrorCode());
                                this.mErrorData.setError_msg(ge.getErrorString());
                            }
                        } else {
                            com.baidu.tbadk.core.util.k kVar2 = new com.baidu.tbadk.core.util.k();
                            kVar2.h("audioFile", w);
                            TiebaStatic.voiceError(TbErrInfo.ERR_VOI_SEND, "uploadService.upload null or fail", kVar2.toString());
                            this.mErrorData.setError_code(ge.getErrorCode());
                            this.mErrorData.setError_msg(ge.getErrorString());
                        }
                    }
                    if (!this.isCancelled) {
                        VideoInfo videoInfo = writeData.getVideoInfo();
                        if (videoInfo != null) {
                            if (videoInfo.needUploadVideo()) {
                                this.hdZ = new com.baidu.tieba.tbadkCore.videoupload.a(this.heb);
                                VideoFinishResult a = this.hdZ.a(writeData.getForumId(), videoInfo.getVideoPath(), videoInfo.getVideoDuration(), new com.baidu.tieba.tbadkCore.videoupload.a.e() { // from class: com.baidu.tieba.tbadkCore.c.a.1
                                    int hec = 0;

                                    @Override // com.baidu.tieba.tbadkCore.videoupload.a.e
                                    public void ax(float f) {
                                        int i = (int) (90.0f * f);
                                        if (i != this.hec) {
                                            this.hec = i;
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
                                if (this.aYn == null) {
                                    this.aYn = new f("HTTPWriteService.postWriteData");
                                }
                                ImageUploadResult u = this.aYn.u(videoInfo.getThumbPath(), false);
                                if (u != null) {
                                    videoInfo.setThumbId(u.picId);
                                }
                            }
                            JSONObject jSONObject = new JSONObject();
                            try {
                                if (!v.J(videoInfo.getStickListInfo())) {
                                    JSONArray jSONArray = new JSONArray();
                                    for (String str5 : videoInfo.getStickListInfo()) {
                                        jSONArray.put(str5);
                                    }
                                    jSONObject.put("sticker_id", jSONArray);
                                }
                                if (!v.J(videoInfo.getBeautifyListInfo())) {
                                    JSONArray jSONArray2 = new JSONArray();
                                    for (String str6 : videoInfo.getBeautifyListInfo()) {
                                        jSONArray2.put(str6);
                                    }
                                    jSONObject.put("beautify_level", jSONArray2);
                                }
                                if (!v.J(videoInfo.getFilterListInfo())) {
                                    JSONArray jSONArray3 = new JSONArray();
                                    for (String str7 : videoInfo.getFilterListInfo()) {
                                        jSONArray3.put(str7);
                                    }
                                    jSONObject.put("filter_id", jSONArray3);
                                }
                                if (!v.J(videoInfo.getMusicListInfo())) {
                                    JSONArray jSONArray4 = new JSONArray();
                                    for (String str8 : videoInfo.getMusicListInfo()) {
                                        jSONArray4.put(str8);
                                    }
                                    jSONObject.put("music_id", jSONArray4);
                                }
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                            this.mNetwork.x("video_other", jSONObject.toString());
                        }
                        if (!this.isCancelled) {
                            this.mNetwork.x("anonymous", "1");
                            this.mNetwork.x("can_no_forum", writeData.isCanNoForum() ? "1" : "0");
                            this.mNetwork.x("is_feedback", writeData.isUserFeedback() ? "1" : "0");
                            this.mNetwork.x("takephoto_num", String.valueOf(writeData.getTakePhotoNum()));
                            this.mNetwork.x("entrance_type", String.valueOf(writeData.getEntranceType()));
                            if (str != null) {
                                this.mNetwork.x("voice_md5", str);
                                this.mNetwork.x("during_time", String.valueOf(voiceDuringTime));
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
                                this.mNetwork.x("vcode", writeData.getVcode());
                            }
                            if (!StringUtils.isNull(writeData.getVcodeMD5())) {
                                this.mNetwork.x("vcode_md5", writeData.getVcodeMD5());
                            }
                            if (!StringUtils.isNull(writeData.getVcodeType())) {
                                this.mNetwork.x("vcode_type", writeData.getVcodeType());
                            }
                            if (TbadkCoreApplication.getInst().getNewVcodeWebviewCrashCount() < 3) {
                                this.mNetwork.x("vcode_tag", Constants.VIA_REPORT_TYPE_SET_AVATAR);
                            }
                            Address R = com.baidu.adp.lib.d.a.iX().R(false);
                            this.mNetwork.x("new_vcode", "1");
                            if (writeData.getVideoInfo() == null || !writeData.getVideoInfo().hasUpload()) {
                                str2 = writeData.getContent() + imagesCodeForPost;
                            } else {
                                str2 = writeData.getContent() + writeData.getVideoInfo().buildContent() + imagesCodeForPost;
                            }
                            i.ey(str2);
                            this.mNetwork.x("content", com.baidu.tieba.face.a.mF(str2));
                            this.mNetwork.x("reply_uid", writeData.getReplyId());
                            if (!TextUtils.isEmpty(writeData.getMemeText())) {
                                this.mNetwork.x("meme_text", writeData.getMemeText());
                            }
                            if (!TextUtils.isEmpty(writeData.getMemeContSign())) {
                                this.mNetwork.x("meme_cont_sign", writeData.getMemeContSign());
                            }
                            switch (writeData.getType()) {
                                case 0:
                                case 7:
                                case 9:
                                    this.mNetwork.setUrl(hdV);
                                    if (writeData.isCanNoForum()) {
                                        this.mNetwork.x(ImageViewerConfig.FORUM_ID, "0");
                                        this.mNetwork.x("kw", "");
                                        this.mNetwork.x("transform_forums", writeData.getTransmitForumData());
                                    } else {
                                        this.mNetwork.x(ImageViewerConfig.FORUM_ID, writeData.getForumId());
                                        this.mNetwork.x("kw", writeData.getForumName());
                                    }
                                    this.mNetwork.x("is_hide", writeData.isPrivacy() ? "1" : "0");
                                    if (writeData.getVideoId() != null) {
                                        this.mNetwork.x("video_id", writeData.getVideoId());
                                        if (writeData.getOriginalVideoCover() != null) {
                                            this.mNetwork.x("origin_video_cover", writeData.getOriginalVideoCover());
                                        }
                                        if (writeData.getOriginalVideoTitle() != null) {
                                            this.mNetwork.x("origin_video_title", writeData.getOriginalVideoTitle());
                                        }
                                    }
                                    if (writeData.isShareThread()) {
                                        this.mNetwork.x("is_share", "1");
                                        this.mNetwork.x("from_tid", writeData.getOriginalThreadId());
                                    }
                                    this.mNetwork.x(IntentConfig.CALL_FROM, writeData.getCallFrom());
                                    this.mNetwork.x("title", writeData.getTitle());
                                    if (!StringUtils.isNull(writeData.getPostPrefix())) {
                                        this.mNetwork.x("post_prefix", writeData.getPostPrefix());
                                    }
                                    this.mNetwork.x("is_ntitle", writeData.isNoTitle() ? "1" : "0");
                                    if (writeData.isNoTitle()) {
                                        this.mNetwork.x("st_type", "notitle");
                                    }
                                    if (R != null && TbadkCoreApplication.getInst().getIsLocationOn() && !TbConfig.getPositionPagerId().equals(writeData.getForumId())) {
                                        this.mNetwork.x("lbs", String.valueOf(R.getLatitude()) + "," + String.valueOf(R.getLongitude()));
                                    }
                                    c.a(this.mNetwork, writeData);
                                    if (writeData.getCategoryFrom() >= 0) {
                                        this.mNetwork.x("fromCategoryId", String.valueOf(writeData.getCategoryFrom()));
                                    }
                                    if (writeData.getCategoryTo() >= 0) {
                                        this.mNetwork.x("toCategoryId", String.valueOf(writeData.getCategoryTo()));
                                    }
                                    if (writeData.getType() == 7) {
                                        this.mNetwork.x("is_bottle", String.valueOf(1));
                                    }
                                    if (writeData.getRecommendExt() != null) {
                                        this.mNetwork.x("recommend_ext", writeData.getRecommendExt());
                                    }
                                    if (writeData.isLinkThread()) {
                                        this.mNetwork.x("link_url", writeData.getLinkUrl());
                                        this.mNetwork.x("link_url_code", writeData.getLinkUrlCode() == null ? "" : writeData.getLinkUrlCode());
                                    }
                                    this.mNetwork.x("is_link_thread", writeData.isLinkThread() ? "1" : "0");
                                    str3 = imagesCodeForPost;
                                    break;
                                case 1:
                                    this.mNetwork.setUrl(hdW);
                                    this.mNetwork.x(ImageViewerConfig.FORUM_ID, writeData.getForumId());
                                    this.mNetwork.x("from_fourm_id", writeData.getFromForumId());
                                    this.mNetwork.x("v_fid", writeData.getVForumId());
                                    this.mNetwork.x("v_fname", writeData.getVForumName());
                                    this.mNetwork.x("tid", writeData.getThreadId());
                                    this.mNetwork.x("kw", writeData.getForumName());
                                    this.mNetwork.x("is_ad", writeData.getIsAd() ? "1" : "0");
                                    this.mNetwork.x("is_barrage", writeData.isBarrage() ? "1" : "0");
                                    this.mNetwork.x("barrage_time", String.valueOf(writeData.getBarrageTime()));
                                    if (writeData.isFrsReply()) {
                                        this.mNetwork.x("st_param", "frs");
                                    }
                                    if (com.baidu.tbadk.editortools.pb.a.Ld().getStatus() == 1) {
                                        this.mNetwork.x("ptype", "4");
                                    }
                                    if (!StringUtils.isNull(writeData.sourceFrom)) {
                                        this.mNetwork.x("post_from", writeData.sourceFrom);
                                    }
                                    c.a(this.mNetwork, writeData);
                                    str3 = imagesCodeForPost;
                                    break;
                                case 2:
                                    this.mNetwork.setUrl(hdW);
                                    this.mNetwork.x(ImageViewerConfig.FORUM_ID, writeData.getForumId());
                                    this.mNetwork.x("from_fourm_id", writeData.getFromForumId());
                                    this.mNetwork.x("v_fid", writeData.getVForumId());
                                    this.mNetwork.x("v_fname", writeData.getVForumName());
                                    this.mNetwork.x("tid", writeData.getThreadId());
                                    this.mNetwork.x("kw", writeData.getForumName());
                                    this.mNetwork.x("quote_id", String.valueOf(writeData.getFloor()));
                                    this.mNetwork.x("is_twzhibo_thread", String.valueOf(0));
                                    this.mNetwork.x("floor_num", String.valueOf(writeData.getFloorNum()));
                                    if (writeData.getRepostId() != null) {
                                        this.mNetwork.x("repostid", writeData.getRepostId());
                                    }
                                    this.mNetwork.x("is_ad", writeData.getIsAd() ? "1" : "0");
                                    this.mNetwork.x(WriteActivityConfig.IS_ADDITION, writeData.isAddition() ? "1" : "0");
                                    this.mNetwork.x("is_giftpost", writeData.isGiftPost() ? "1" : "0");
                                    this.mNetwork.x("is_giftpost", writeData.isGiftPost() ? "1" : "0");
                                    if (writeData.isAddition()) {
                                        this.mNetwork.x("st_type", "conadd");
                                    }
                                    if (!StringUtils.isNull(writeData.sourceFrom)) {
                                        this.mNetwork.x("post_from", writeData.sourceFrom);
                                        str3 = imagesCodeForPost;
                                        break;
                                    }
                                    str3 = imagesCodeForPost;
                                    break;
                                case 3:
                                case 8:
                                default:
                                    if (writeData.isCanNoForum()) {
                                        this.mNetwork.x(ImageViewerConfig.FORUM_ID, "0");
                                        this.mNetwork.x("kw", "");
                                        this.mNetwork.x("transform_forums", writeData.getTransmitForumData());
                                        str3 = imagesCodeForPost;
                                        break;
                                    } else {
                                        this.mNetwork.x(ImageViewerConfig.FORUM_ID, writeData.getForumId());
                                        this.mNetwork.x("kw", writeData.getForumName());
                                        str3 = imagesCodeForPost;
                                        break;
                                    }
                                case 4:
                                    this.mNetwork.setUrl(hdV);
                                    this.mNetwork.x(ImageViewerConfig.FORUM_ID, writeData.getForumId());
                                    this.mNetwork.x("kw", writeData.getForumName());
                                    this.mNetwork.x("title", writeData.getTitle());
                                    if (!StringUtils.isNull(writeData.getPostPrefix())) {
                                        this.mNetwork.x("post_prefix", writeData.getPostPrefix());
                                    }
                                    this.mNetwork.x("thread_type", "33");
                                    c.a(this.mNetwork, writeData);
                                    str3 = imagesCodeForPost;
                                    break;
                                case 5:
                                    this.mNetwork.setUrl(hdW);
                                    this.mNetwork.x(ImageViewerConfig.FORUM_ID, writeData.getForumId());
                                    this.mNetwork.x("tid", writeData.getThreadId());
                                    this.mNetwork.x("kw", writeData.getForumName());
                                    this.mNetwork.x("is_twzhibo_thread", String.valueOf(1));
                                    c.a(this.mNetwork, writeData);
                                    str3 = imagesCodeForPost;
                                    break;
                                case 6:
                                    this.mNetwork.setUrl(hdV);
                                    this.mNetwork.x(ImageViewerConfig.FORUM_ID, writeData.getForumId());
                                    this.mNetwork.x("kw", writeData.getForumName());
                                    this.mNetwork.x("thread_type", String.valueOf(36));
                                    this.mNetwork.x("title", writeData.getTitle());
                                    if (!StringUtils.isNull(writeData.getPostPrefix())) {
                                        this.mNetwork.x("post_prefix", writeData.getPostPrefix());
                                    }
                                    this.mNetwork.x("is_ntitle", writeData.isNoTitle() ? "1" : "0");
                                    if (writeData.isNoTitle()) {
                                        this.mNetwork.x("st_type", "notitle");
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
                this.mNetwork.x("real_lat", lat);
                this.mNetwork.x("real_lng", lng);
            }
            if (TbadkCoreApplication.getCurrentAccountInfo() != null) {
                this.mNetwork.x("name_show", TbadkCoreApplication.getCurrentAccountNameShow());
            }
            str4 = this.mNetwork.BA();
            notifyUploadProgress(95);
            if (this.mNetwork.BY().CX().isRequestSuccess()) {
                this.mErrorData.parserJson(str4);
            } else {
                this.mErrorData.setError_code(this.mNetwork.Cb() ? this.mNetwork.Cc() : this.mNetwork.Cd());
                this.mErrorData.setError_msg(this.mNetwork.getErrorString());
            }
            if (this.mErrorData.error_code != 0 && !com.baidu.adp.lib.util.j.kX()) {
                this.mErrorData.setError_msg(TbadkCoreApplication.getInst().getApp().getString(e.j.neterror));
            } else if (this.mErrorData.error_code != 0 && writeData.isHasImages() && com.baidu.adp.lib.util.k.isEmpty(writeData.getContent() + str3)) {
                this.mErrorData.setError_msg(TbadkCoreApplication.getInst().getApp().getString(e.j.img_upload_error));
            }
            try {
                this.hdY = new AntiData();
                this.hdY.parserJson(new JSONObject(str4).optJSONObject("anti_stat"));
            } catch (Exception e2) {
            }
            if (this.hdY.getBlock_stat() == 0 && this.mErrorData.error_code == 0 && this.mNetwork.BY() != null && this.mNetwork.BY().CW() != null) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921344, this.mNetwork.BY().CW().CZ()));
            }
            notifyUploadProgress(100);
        }
        return str4;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifyUploadProgress(int i) {
        if (this.hea != null) {
            this.hea.onUploadProgress(i);
        }
    }

    public boolean isRequestSuccess() {
        if (this.mNetwork == null) {
            return false;
        }
        return this.mNetwork.BY().CX().isRequestSuccess();
    }

    public void cancel() {
        this.isCancelled = true;
        if (this.mNetwork != null) {
            this.mNetwork.ji();
        }
        if (this.aYn != null) {
            this.aYn.cancel();
        }
        if (this.hdZ != null) {
            this.hdZ.qJ();
        }
    }

    public AntiData bCr() {
        return this.hdY;
    }

    public ErrorData getErrorData() {
        return this.mErrorData;
    }
}
