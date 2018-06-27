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
import com.baidu.tbadk.core.util.k;
import com.baidu.tbadk.core.util.l;
import com.baidu.tbadk.core.util.w;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.core.voice.service.b;
import com.baidu.tbadk.coreExtra.data.VideoInfo;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.coreExtra.data.i;
import com.baidu.tbadk.coreExtra.data.j;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tbadk.img.ImageUploadResult;
import com.baidu.tbadk.img.f;
import com.baidu.tieba.d;
import com.baidu.tieba.j.h;
import com.baidu.tieba.tbadkCore.videoupload.VideoFinishResult;
import com.baidu.tieba.tbadkCore.videoupload.a.e;
import com.baidu.tieba.tbadkCore.writeModel.c;
import com.tencent.connect.common.Constants;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class a {
    private static final String gNU = TbConfig.SERVER_ADDRESS + TbConfig.POST_THREAD_ADDRESS;
    private static final String gNV = TbConfig.SERVER_ADDRESS + TbConfig.REPLY_THREAD_ADDRESS;
    public static final String gNW = TbConfig.SERVER_ADDRESS + TbConfig.POST_THREAD_FOR_SHARE_ADDRESS;
    private f aQz;
    private AntiData gNX;
    private com.baidu.tieba.tbadkCore.videoupload.a gNY;
    private InterfaceC0235a gNZ;
    private h gOa;
    private ErrorData mErrorData;
    private y mNetwork = null;
    private boolean isCancelled = false;

    /* renamed from: com.baidu.tieba.tbadkCore.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0235a {
        void onUploadProgress(int i);
    }

    public a() {
        this.mErrorData = null;
        this.mErrorData = new ErrorData();
    }

    public void a(h hVar) {
        this.gOa = hVar;
    }

    public void a(InterfaceC0235a interfaceC0235a) {
        this.gNZ = interfaceC0235a;
    }

    public ImageUploadResult e(ImageFileInfo imageFileInfo, boolean z) {
        if (imageFileInfo == null) {
            return null;
        }
        if (this.aQz == null) {
            this.aQz = new f("HTTPWriteService.postImageData");
        }
        return this.aQz.d(imageFileInfo, z);
    }

    public String a(WriteData writeData, boolean z) {
        String returnVoiceMd5;
        boolean z2;
        String str;
        String str2;
        String str3;
        String str4 = null;
        if (writeData != null) {
            this.mNetwork = new y();
            this.mNetwork.yX().zX().mIsNeedTbs = true;
            if (writeData.getType() == 3) {
                if (writeData.getVcode() != null && writeData.getVcode().length() > 0) {
                    this.mNetwork.o("vcode", writeData.getVcode());
                }
                if (TbadkCoreApplication.getInst().getNewVcodeWebviewCrashCount() < 3) {
                    this.mNetwork.o("tag", Constants.VIA_REPORT_TYPE_SHARE_TO_QZONE);
                }
                this.mNetwork.o("newVcode", "1");
                this.mNetwork.o("content", writeData.getContent());
                this.mNetwork.setUrl(gNW);
                this.mNetwork.o(ImageViewerConfig.FORUM_NAME, writeData.getForumName());
                this.mNetwork.o("title", writeData.getTitle());
                if (!StringUtils.isNull(writeData.getPostPrefix())) {
                    this.mNetwork.o("post_prefix", writeData.getPostPrefix());
                }
                this.mNetwork.o("apiKey", writeData.getShareApiKey());
                this.mNetwork.o("appName", writeData.getShareAppName());
                this.mNetwork.o("signKey", writeData.getShareSignKey());
                this.mNetwork.o("summary_title", writeData.getShareSummaryTitle());
                this.mNetwork.o("summary_content", writeData.getShareSummaryContent());
                this.mNetwork.o("summary_img", writeData.getShareSummaryImg());
                this.mNetwork.o(WriteShareActivityConfig.SHARE_SUMMARY_IMG_WIDTH, String.valueOf(writeData.getShareSummaryImgWidth()));
                this.mNetwork.o(WriteShareActivityConfig.SHARE_SUMMARY_IMG_HEIGHT, String.valueOf(writeData.getShareSummaryImgHeight()));
                this.mNetwork.o(WriteShareActivityConfig.SHARE_SUMMARY_IMG_TYPE, writeData.getShareSummaryImgType());
                this.mNetwork.o("referUrl", writeData.getShareReferUrl());
                str3 = null;
            } else {
                if (z && writeData.isHasImages()) {
                    if (this.aQz == null) {
                        this.aQz = new f("HTTPWriteService.postWriteData");
                    }
                    if (writeData.getType() == 6) {
                        if (this.aQz.b(writeData.getWriteImagesInfo(), true) != null) {
                            this.mErrorData.setError_code(-53);
                            this.mErrorData.setError_msg(TbadkCoreApplication.getInst().getString(d.k.upload_error));
                        }
                    } else {
                        ErrorData b = this.aQz.b(writeData.getWriteImagesInfo(), true);
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
                        bVar.x("type", 1);
                        String q = l.q(voice, 1);
                        j fx = bVar.fx(q);
                        if (fx != null && fx.isSuccess()) {
                            i Cp = fx.Cp();
                            if (Cp != null) {
                                String Cn = Cp.Cn();
                                com.baidu.tbadk.core.voice.a.b.renameFile(writeData.getVoice(), Cn);
                                writeData.setReturnVoiceMd5(Cn);
                                str = Cn;
                            } else {
                                k kVar = new k();
                                kVar.h("ErrCode", Integer.valueOf(fx.getErrorCode()));
                                kVar.h("ErrMsg", fx.getErrorString());
                                TiebaStatic.voiceError(TbErrInfo.ERR_VOI_SEND, "audioUploadData is null", kVar.toString());
                                this.mErrorData.setError_code(fx.getErrorCode());
                                this.mErrorData.setError_msg(fx.getErrorString());
                            }
                        } else {
                            k kVar2 = new k();
                            kVar2.h("audioFile", q);
                            TiebaStatic.voiceError(TbErrInfo.ERR_VOI_SEND, "uploadService.upload null or fail", kVar2.toString());
                            this.mErrorData.setError_code(fx.getErrorCode());
                            this.mErrorData.setError_msg(fx.getErrorString());
                        }
                    }
                    if (!this.isCancelled) {
                        VideoInfo videoInfo = writeData.getVideoInfo();
                        if (videoInfo != null) {
                            if (videoInfo.needUploadVideo()) {
                                this.gNY = new com.baidu.tieba.tbadkCore.videoupload.a(this.gOa);
                                VideoFinishResult a = this.gNY.a(writeData.getForumId(), videoInfo.getVideoPath(), videoInfo.getVideoDuration(), new e() { // from class: com.baidu.tieba.tbadkCore.c.a.1
                                    int gOb = 0;

                                    @Override // com.baidu.tieba.tbadkCore.videoupload.a.e
                                    public void aC(float f) {
                                        int i = (int) (90.0f * f);
                                        if (i != this.gOb) {
                                            this.gOb = i;
                                            a.this.notifyUploadProgress(i);
                                        }
                                    }
                                });
                                if (a == null) {
                                    this.mErrorData.setError_code(-53);
                                    this.mErrorData.setError_msg(TbadkCoreApplication.getInst().getString(d.k.upload_error));
                                } else if (a.isSuccess()) {
                                    videoInfo.setVideoMd5(a.getVideoMd5());
                                    videoInfo.setVideoUrl(a.getVideoUrl());
                                } else {
                                    this.mErrorData.setError_code(a.getErrorNo());
                                    this.mErrorData.setError_msg(a.getUserMessage());
                                }
                            }
                            if (videoInfo.needUploadThunmb()) {
                                if (this.aQz == null) {
                                    this.aQz = new f("HTTPWriteService.postWriteData");
                                }
                                ImageUploadResult m = this.aQz.m(videoInfo.getThumbPath(), false);
                                if (m != null) {
                                    videoInfo.setThumbId(m.picId);
                                }
                            }
                            JSONObject jSONObject = new JSONObject();
                            try {
                                if (!w.A(videoInfo.getStickListInfo())) {
                                    JSONArray jSONArray = new JSONArray();
                                    for (String str5 : videoInfo.getStickListInfo()) {
                                        jSONArray.put(str5);
                                    }
                                    jSONObject.put("sticker_id", jSONArray);
                                }
                                if (!w.A(videoInfo.getBeautifyListInfo())) {
                                    JSONArray jSONArray2 = new JSONArray();
                                    for (String str6 : videoInfo.getBeautifyListInfo()) {
                                        jSONArray2.put(str6);
                                    }
                                    jSONObject.put("beautify_level", jSONArray2);
                                }
                                if (!w.A(videoInfo.getFilterListInfo())) {
                                    JSONArray jSONArray3 = new JSONArray();
                                    for (String str7 : videoInfo.getFilterListInfo()) {
                                        jSONArray3.put(str7);
                                    }
                                    jSONObject.put("filter_id", jSONArray3);
                                }
                                if (!w.A(videoInfo.getMusicListInfo())) {
                                    JSONArray jSONArray4 = new JSONArray();
                                    for (String str8 : videoInfo.getMusicListInfo()) {
                                        jSONArray4.put(str8);
                                    }
                                    jSONObject.put("music_id", jSONArray4);
                                }
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                            this.mNetwork.o("video_other", jSONObject.toString());
                        }
                        if (!this.isCancelled) {
                            this.mNetwork.o("anonymous", "1");
                            this.mNetwork.o("can_no_forum", writeData.isCanNoForum() ? "1" : "0");
                            this.mNetwork.o("is_feedback", writeData.isUserFeedback() ? "1" : "0");
                            this.mNetwork.o("takephoto_num", String.valueOf(writeData.getTakePhotoNum()));
                            this.mNetwork.o("entrance_type", String.valueOf(writeData.getEntranceType()));
                            if (str != null) {
                                this.mNetwork.o("voice_md5", str);
                                this.mNetwork.o("during_time", String.valueOf(voiceDuringTime));
                            }
                            String imagesCodeForPost = writeData.getImagesCodeForPost();
                            if (writeData.getType() != 6) {
                                if (writeData.getType() == 7 && TextUtils.isEmpty(writeData.getTitle()) && TextUtils.isEmpty(str) && TextUtils.isEmpty(imagesCodeForPost) && TextUtils.isEmpty(writeData.getContent()) && writeData.getVideoInfo() == null) {
                                    this.mErrorData.setError_code(-53);
                                    this.mErrorData.setError_msg(TbadkCoreApplication.getInst().getString(d.k.sand_fail));
                                } else if ((!(writeData.getType() == 0 || writeData.getType() == 9) || TextUtils.isEmpty(writeData.getTitle())) && TextUtils.isEmpty(str) && TextUtils.isEmpty(imagesCodeForPost) && TextUtils.isEmpty(writeData.getContent()) && writeData.getVideoInfo() == null && writeData.getType() != 7 && !writeData.isLinkThread()) {
                                    this.mErrorData.setError_code(-53);
                                    this.mErrorData.setError_msg(TbadkCoreApplication.getInst().getString(d.k.sand_fail));
                                }
                            }
                            if (writeData.getVcode() != null && writeData.getVcode().length() > 0) {
                                this.mNetwork.o("vcode", writeData.getVcode());
                            }
                            if (!StringUtils.isNull(writeData.getVcodeMD5())) {
                                this.mNetwork.o("vcode_md5", writeData.getVcodeMD5());
                            }
                            if (!StringUtils.isNull(writeData.getVcodeType())) {
                                this.mNetwork.o("vcode_type", writeData.getVcodeType());
                            }
                            if (TbadkCoreApplication.getInst().getNewVcodeWebviewCrashCount() < 3) {
                                this.mNetwork.o("vcode_tag", Constants.VIA_REPORT_TYPE_SET_AVATAR);
                            }
                            Address I = com.baidu.adp.lib.d.a.hB().I(false);
                            this.mNetwork.o("new_vcode", "1");
                            if (writeData.getVideoInfo() == null || !writeData.getVideoInfo().hasUpload()) {
                                str2 = writeData.getContent() + imagesCodeForPost;
                            } else {
                                str2 = writeData.getContent() + writeData.getVideoInfo().buildContent() + imagesCodeForPost;
                            }
                            com.baidu.tbadk.core.util.i.dT(str2);
                            this.mNetwork.o("content", com.baidu.tieba.face.a.lA(str2));
                            this.mNetwork.o("reply_uid", writeData.getReplyId());
                            if (!TextUtils.isEmpty(writeData.getMemeText())) {
                                this.mNetwork.o("meme_text", writeData.getMemeText());
                            }
                            if (!TextUtils.isEmpty(writeData.getMemeContSign())) {
                                this.mNetwork.o("meme_cont_sign", writeData.getMemeContSign());
                            }
                            switch (writeData.getType()) {
                                case 0:
                                case 7:
                                case 9:
                                    this.mNetwork.setUrl(gNU);
                                    if (writeData.isCanNoForum()) {
                                        this.mNetwork.o(ImageViewerConfig.FORUM_ID, "0");
                                        this.mNetwork.o("kw", "");
                                        this.mNetwork.o("transform_forums", writeData.getTransmitForumData());
                                    } else {
                                        this.mNetwork.o(ImageViewerConfig.FORUM_ID, writeData.getForumId());
                                        this.mNetwork.o("kw", writeData.getForumName());
                                    }
                                    this.mNetwork.o("is_hide", writeData.isPrivacy() ? "1" : "0");
                                    if (writeData.getVideoId() != null) {
                                        this.mNetwork.o("video_id", writeData.getVideoId());
                                        if (writeData.getOriginalVideoCover() != null) {
                                            this.mNetwork.o("origin_video_cover", writeData.getOriginalVideoCover());
                                        }
                                        if (writeData.getOriginalVideoTitle() != null) {
                                            this.mNetwork.o("origin_video_title", writeData.getOriginalVideoTitle());
                                        }
                                    }
                                    if (writeData.isShareThread()) {
                                        this.mNetwork.o("is_share", "1");
                                        this.mNetwork.o("from_tid", writeData.getOriginalThreadId());
                                    }
                                    this.mNetwork.o(IntentConfig.CALL_FROM, writeData.getCallFrom());
                                    this.mNetwork.o("title", writeData.getTitle());
                                    if (!StringUtils.isNull(writeData.getPostPrefix())) {
                                        this.mNetwork.o("post_prefix", writeData.getPostPrefix());
                                    }
                                    this.mNetwork.o("is_ntitle", writeData.isNoTitle() ? "1" : "0");
                                    if (writeData.isNoTitle()) {
                                        this.mNetwork.o("st_type", "notitle");
                                    }
                                    if (I != null && TbadkCoreApplication.getInst().getIsLocationOn() && !TbConfig.getPositionPagerId().equals(writeData.getForumId())) {
                                        this.mNetwork.o("lbs", String.valueOf(I.getLatitude()) + "," + String.valueOf(I.getLongitude()));
                                    }
                                    c.a(this.mNetwork, writeData);
                                    if (writeData.getCategoryFrom() >= 0) {
                                        this.mNetwork.o("fromCategoryId", String.valueOf(writeData.getCategoryFrom()));
                                    }
                                    if (writeData.getCategoryTo() >= 0) {
                                        this.mNetwork.o("toCategoryId", String.valueOf(writeData.getCategoryTo()));
                                    }
                                    if (writeData.getType() == 7) {
                                        this.mNetwork.o("is_bottle", String.valueOf(1));
                                    }
                                    if (writeData.getRecommendExt() != null) {
                                        this.mNetwork.o("recommend_ext", writeData.getRecommendExt());
                                    }
                                    if (writeData.isLinkThread()) {
                                        this.mNetwork.o("link_url", writeData.getLinkUrl());
                                        this.mNetwork.o("link_url_code", writeData.getLinkUrlCode() == null ? "" : writeData.getLinkUrlCode());
                                    }
                                    this.mNetwork.o("is_link_thread", writeData.isLinkThread() ? "1" : "0");
                                    str3 = imagesCodeForPost;
                                    break;
                                case 1:
                                    this.mNetwork.setUrl(gNV);
                                    this.mNetwork.o(ImageViewerConfig.FORUM_ID, writeData.getForumId());
                                    this.mNetwork.o("from_fourm_id", writeData.getFromForumId());
                                    this.mNetwork.o("v_fid", writeData.getVForumId());
                                    this.mNetwork.o("v_fname", writeData.getVForumName());
                                    this.mNetwork.o("tid", writeData.getThreadId());
                                    this.mNetwork.o("kw", writeData.getForumName());
                                    this.mNetwork.o("is_ad", writeData.getIsAd() ? "1" : "0");
                                    this.mNetwork.o("is_barrage", writeData.isBarrage() ? "1" : "0");
                                    this.mNetwork.o("barrage_time", String.valueOf(writeData.getBarrageTime()));
                                    if (writeData.isFrsReply()) {
                                        this.mNetwork.o("st_param", "frs");
                                    }
                                    if (com.baidu.tbadk.editortools.pb.a.HU().getStatus() == 1) {
                                        this.mNetwork.o("ptype", "4");
                                    }
                                    if (!StringUtils.isNull(writeData.sourceFrom)) {
                                        this.mNetwork.o("post_from", writeData.sourceFrom);
                                    }
                                    c.a(this.mNetwork, writeData);
                                    str3 = imagesCodeForPost;
                                    break;
                                case 2:
                                    this.mNetwork.setUrl(gNV);
                                    this.mNetwork.o(ImageViewerConfig.FORUM_ID, writeData.getForumId());
                                    this.mNetwork.o("from_fourm_id", writeData.getFromForumId());
                                    this.mNetwork.o("v_fid", writeData.getVForumId());
                                    this.mNetwork.o("v_fname", writeData.getVForumName());
                                    this.mNetwork.o("tid", writeData.getThreadId());
                                    this.mNetwork.o("kw", writeData.getForumName());
                                    this.mNetwork.o("quote_id", String.valueOf(writeData.getFloor()));
                                    this.mNetwork.o("is_twzhibo_thread", String.valueOf(0));
                                    this.mNetwork.o("floor_num", String.valueOf(writeData.getFloorNum()));
                                    if (writeData.getRepostId() != null) {
                                        this.mNetwork.o("repostid", writeData.getRepostId());
                                    }
                                    this.mNetwork.o("is_ad", writeData.getIsAd() ? "1" : "0");
                                    this.mNetwork.o(WriteActivityConfig.IS_ADDITION, writeData.isAddition() ? "1" : "0");
                                    this.mNetwork.o("is_giftpost", writeData.isGiftPost() ? "1" : "0");
                                    this.mNetwork.o("is_giftpost", writeData.isGiftPost() ? "1" : "0");
                                    if (writeData.isAddition()) {
                                        this.mNetwork.o("st_type", "conadd");
                                    }
                                    if (!StringUtils.isNull(writeData.sourceFrom)) {
                                        this.mNetwork.o("post_from", writeData.sourceFrom);
                                        str3 = imagesCodeForPost;
                                        break;
                                    }
                                    str3 = imagesCodeForPost;
                                    break;
                                case 3:
                                case 8:
                                default:
                                    if (writeData.isCanNoForum()) {
                                        this.mNetwork.o(ImageViewerConfig.FORUM_ID, "0");
                                        this.mNetwork.o("kw", "");
                                        this.mNetwork.o("transform_forums", writeData.getTransmitForumData());
                                        str3 = imagesCodeForPost;
                                        break;
                                    } else {
                                        this.mNetwork.o(ImageViewerConfig.FORUM_ID, writeData.getForumId());
                                        this.mNetwork.o("kw", writeData.getForumName());
                                        str3 = imagesCodeForPost;
                                        break;
                                    }
                                case 4:
                                    this.mNetwork.setUrl(gNU);
                                    this.mNetwork.o(ImageViewerConfig.FORUM_ID, writeData.getForumId());
                                    this.mNetwork.o("kw", writeData.getForumName());
                                    this.mNetwork.o("title", writeData.getTitle());
                                    if (!StringUtils.isNull(writeData.getPostPrefix())) {
                                        this.mNetwork.o("post_prefix", writeData.getPostPrefix());
                                    }
                                    this.mNetwork.o("thread_type", "33");
                                    c.a(this.mNetwork, writeData);
                                    str3 = imagesCodeForPost;
                                    break;
                                case 5:
                                    this.mNetwork.setUrl(gNV);
                                    this.mNetwork.o(ImageViewerConfig.FORUM_ID, writeData.getForumId());
                                    this.mNetwork.o("tid", writeData.getThreadId());
                                    this.mNetwork.o("kw", writeData.getForumName());
                                    this.mNetwork.o("is_twzhibo_thread", String.valueOf(1));
                                    c.a(this.mNetwork, writeData);
                                    str3 = imagesCodeForPost;
                                    break;
                                case 6:
                                    this.mNetwork.setUrl(gNU);
                                    this.mNetwork.o(ImageViewerConfig.FORUM_ID, writeData.getForumId());
                                    this.mNetwork.o("kw", writeData.getForumName());
                                    this.mNetwork.o("thread_type", String.valueOf(36));
                                    this.mNetwork.o("title", writeData.getTitle());
                                    if (!StringUtils.isNull(writeData.getPostPrefix())) {
                                        this.mNetwork.o("post_prefix", writeData.getPostPrefix());
                                    }
                                    this.mNetwork.o("is_ntitle", writeData.isNoTitle() ? "1" : "0");
                                    if (writeData.isNoTitle()) {
                                        this.mNetwork.o("st_type", "notitle");
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
                this.mNetwork.o("real_lat", lat);
                this.mNetwork.o("real_lng", lng);
            }
            if (TbadkCoreApplication.getCurrentAccountInfo() != null) {
                this.mNetwork.o("name_show", TbadkCoreApplication.getCurrentAccountNameShow());
            }
            str4 = this.mNetwork.yz();
            notifyUploadProgress(95);
            if (this.mNetwork.yX().zY().isRequestSuccess()) {
                this.mErrorData.parserJson(str4);
            } else {
                this.mErrorData.setError_code(this.mNetwork.za() ? this.mNetwork.zb() : this.mNetwork.zc());
                this.mErrorData.setError_msg(this.mNetwork.getErrorString());
            }
            if (this.mErrorData.error_code != 0 && !com.baidu.adp.lib.util.j.jD()) {
                this.mErrorData.setError_msg(TbadkCoreApplication.getInst().getApp().getString(d.k.neterror));
            } else if (this.mErrorData.error_code != 0 && writeData.isHasImages() && com.baidu.adp.lib.util.k.isEmpty(writeData.getContent() + str3)) {
                this.mErrorData.setError_msg(TbadkCoreApplication.getInst().getApp().getString(d.k.img_upload_error));
            }
            try {
                this.gNX = new AntiData();
                this.gNX.parserJson(new JSONObject(str4).optJSONObject("anti_stat"));
            } catch (Exception e2) {
            }
            if (this.gNX.getBlock_stat() == 0 && this.mErrorData.error_code == 0 && this.mNetwork.yX() != null && this.mNetwork.yX().zX() != null) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921344, this.mNetwork.yX().zX().Aa()));
            }
            notifyUploadProgress(100);
        }
        return str4;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifyUploadProgress(int i) {
        if (this.gNZ != null) {
            this.gNZ.onUploadProgress(i);
        }
    }

    public boolean isRequestSuccess() {
        if (this.mNetwork == null) {
            return false;
        }
        return this.mNetwork.yX().zY().isRequestSuccess();
    }

    public void cancel() {
        this.isCancelled = true;
        if (this.mNetwork != null) {
            this.mNetwork.hN();
        }
        if (this.aQz != null) {
            this.aQz.cancel();
        }
        if (this.gNY != null) {
            this.gNY.byF();
        }
    }

    public AntiData bxU() {
        return this.gNX;
    }

    public ErrorData getErrorData() {
        return this.mErrorData;
    }
}
