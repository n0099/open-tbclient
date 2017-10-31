package com.baidu.tieba.tbadkCore.c;

import android.location.Address;
import android.text.TextUtils;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.atomData.VrPlayerActivityConfig;
import com.baidu.tbadk.core.atomData.WriteActivityConfig;
import com.baidu.tbadk.core.atomData.WriteShareActivityConfig;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.ErrorData;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.TbErrInfo;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.j;
import com.baidu.tbadk.core.util.k;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.core.util.x;
import com.baidu.tbadk.core.voice.service.b;
import com.baidu.tbadk.coreExtra.data.VideoInfo;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.coreExtra.data.g;
import com.baidu.tbadk.coreExtra.data.h;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tbadk.img.ImageUploadResult;
import com.baidu.tbadk.img.f;
import com.baidu.tieba.d;
import com.baidu.tieba.tbadkCore.videoupload.VideoFinishResult;
import com.baidu.tieba.tbadkCore.videoupload.a.e;
import com.baidu.tieba.tbadkCore.writeModel.c;
import com.xiaomi.mipush.sdk.Constants;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class a {
    private static final String gqc = TbConfig.SERVER_ADDRESS + TbConfig.POST_THREAD_ADDRESS;
    private static final String gqd = TbConfig.SERVER_ADDRESS + TbConfig.REPLY_THREAD_ADDRESS;
    public static final String gqe = TbConfig.SERVER_ADDRESS + TbConfig.POST_THREAD_FOR_SHARE_ADDRESS;
    private f aFG;
    private AntiData gqf;
    private com.baidu.tieba.tbadkCore.videoupload.a gqg;
    private InterfaceC0125a gqh;
    private ErrorData mErrorData;
    private x mNetwork = null;
    private boolean isCancelled = false;

    /* renamed from: com.baidu.tieba.tbadkCore.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0125a {
        void onUploadProgress(int i);
    }

    public a() {
        this.mErrorData = null;
        this.mErrorData = new ErrorData();
    }

    public void a(InterfaceC0125a interfaceC0125a) {
        this.gqh = interfaceC0125a;
    }

    public ImageUploadResult e(ImageFileInfo imageFileInfo, boolean z) {
        if (imageFileInfo == null) {
            return null;
        }
        if (this.aFG == null) {
            this.aFG = new f("HTTPWriteService.postImageData");
        }
        return this.aFG.d(imageFileInfo, z);
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
            this.mNetwork.uN().vK().mIsNeedTbs = true;
            if (writeData.getType() == 3) {
                if (writeData.getVcode() != null && writeData.getVcode().length() > 0) {
                    this.mNetwork.n("vcode", writeData.getVcode());
                }
                if (TbadkCoreApplication.getInst().getNewVcodeWebviewCrashCount() < 3) {
                    this.mNetwork.n("tag", "11");
                }
                this.mNetwork.n("newVcode", "1");
                this.mNetwork.n("content", writeData.getContent());
                this.mNetwork.setUrl(gqe);
                this.mNetwork.n(ImageViewerConfig.FORUM_NAME, writeData.getForumName());
                this.mNetwork.n(VrPlayerActivityConfig.TITLE, writeData.getTitle());
                this.mNetwork.n("apiKey", writeData.getShareApiKey());
                this.mNetwork.n("appName", writeData.getShareAppName());
                this.mNetwork.n("signKey", writeData.getShareSignKey());
                this.mNetwork.n("summary_title", writeData.getShareSummaryTitle());
                this.mNetwork.n("summary_content", writeData.getShareSummaryContent());
                this.mNetwork.n("summary_img", writeData.getShareSummaryImg());
                this.mNetwork.n(WriteShareActivityConfig.SHARE_SUMMARY_IMG_WIDTH, String.valueOf(writeData.getShareSummaryImgWidth()));
                this.mNetwork.n(WriteShareActivityConfig.SHARE_SUMMARY_IMG_HEIGHT, String.valueOf(writeData.getShareSummaryImgHeight()));
                this.mNetwork.n(WriteShareActivityConfig.SHARE_SUMMARY_IMG_TYPE, writeData.getShareSummaryImgType());
                this.mNetwork.n("referUrl", writeData.getShareReferUrl());
                str3 = null;
            } else {
                if (z && writeData.isHasImages()) {
                    if (this.aFG == null) {
                        this.aFG = new f("HTTPWriteService.postWriteData");
                    }
                    if (writeData.getType() == 6) {
                        if (!this.aFG.b(writeData.getWriteImagesInfo(), true)) {
                            this.mErrorData.setError_code(-53);
                            this.mErrorData.setError_msg(TbadkCoreApplication.getInst().getString(d.j.upload_error));
                        }
                    } else {
                        this.aFG.c(writeData.getWriteImagesInfo(), true);
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
                        String q = k.q(voice, 1);
                        h ey = bVar.ey(q);
                        if (ey != null && ey.isSuccess()) {
                            g xN = ey.xN();
                            if (xN != null) {
                                String xL = xN.xL();
                                com.baidu.tbadk.core.voice.a.b.renameFile(writeData.getVoice(), xL);
                                writeData.setReturnVoiceMd5(xL);
                                str = xL;
                            } else {
                                j jVar = new j();
                                jVar.h("ErrCode", Integer.valueOf(ey.getErrorCode()));
                                jVar.h("ErrMsg", ey.getErrorString());
                                TiebaStatic.voiceError(TbErrInfo.ERR_VOI_SEND, "audioUploadData is null", jVar.toString());
                                this.mErrorData.setError_code(ey.getErrorCode());
                                this.mErrorData.setError_msg(ey.getErrorString());
                            }
                        } else {
                            j jVar2 = new j();
                            jVar2.h("audioFile", q);
                            TiebaStatic.voiceError(TbErrInfo.ERR_VOI_SEND, "uploadService.upload null or fail", jVar2.toString());
                            this.mErrorData.setError_code(ey.getErrorCode());
                            this.mErrorData.setError_msg(ey.getErrorString());
                        }
                    }
                    if (!this.isCancelled) {
                        VideoInfo videoInfo = writeData.getVideoInfo();
                        if (videoInfo != null) {
                            if (videoInfo.needUploadVideo()) {
                                this.gqg = new com.baidu.tieba.tbadkCore.videoupload.a();
                                VideoFinishResult a = this.gqg.a(writeData.getForumId(), videoInfo.getVideoPath(), videoInfo.getVideoDuration(), new e() { // from class: com.baidu.tieba.tbadkCore.c.a.1
                                    int gqi = 0;

                                    @Override // com.baidu.tieba.tbadkCore.videoupload.a.e
                                    public void ac(float f) {
                                        int i = (int) (90.0f * f);
                                        if (i != this.gqi) {
                                            this.gqi = i;
                                            a.this.notifyUploadProgress(i);
                                        }
                                    }
                                });
                                if (a == null) {
                                    this.mErrorData.setError_code(-53);
                                    this.mErrorData.setError_msg(TbadkCoreApplication.getInst().getString(d.j.upload_error));
                                } else if (a.isSuccess()) {
                                    videoInfo.setVideoMd5(a.getVideoMd5());
                                    videoInfo.setVideoUrl(a.getVideoUrl());
                                } else {
                                    this.mErrorData.setError_code(a.getErrorNo());
                                    this.mErrorData.setError_msg(a.getUserMessage());
                                }
                            }
                            if (videoInfo.needUploadThunmb()) {
                                if (this.aFG == null) {
                                    this.aFG = new f("HTTPWriteService.postWriteData");
                                }
                                ImageUploadResult p = this.aFG.p(videoInfo.getThumbPath(), false);
                                if (p != null) {
                                    videoInfo.setThumbId(p.picId);
                                }
                            }
                            JSONObject jSONObject = new JSONObject();
                            try {
                                if (!v.v(videoInfo.getStickListInfo())) {
                                    JSONArray jSONArray = new JSONArray();
                                    for (String str5 : videoInfo.getStickListInfo()) {
                                        jSONArray.put(str5);
                                    }
                                    jSONObject.put("sticker_id", jSONArray);
                                }
                                if (!v.v(videoInfo.getBeautifyListInfo())) {
                                    JSONArray jSONArray2 = new JSONArray();
                                    for (String str6 : videoInfo.getBeautifyListInfo()) {
                                        jSONArray2.put(str6);
                                    }
                                    jSONObject.put("beautify_level", jSONArray2);
                                }
                                if (!v.v(videoInfo.getFilterListInfo())) {
                                    JSONArray jSONArray3 = new JSONArray();
                                    for (String str7 : videoInfo.getFilterListInfo()) {
                                        jSONArray3.put(str7);
                                    }
                                    jSONObject.put("filter_id", jSONArray3);
                                }
                                if (!v.v(videoInfo.getMusicListInfo())) {
                                    JSONArray jSONArray4 = new JSONArray();
                                    for (String str8 : videoInfo.getMusicListInfo()) {
                                        jSONArray4.put(str8);
                                    }
                                    jSONObject.put("music_id", jSONArray4);
                                }
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                            this.mNetwork.n("video_other", jSONObject.toString());
                        }
                        if (!this.isCancelled) {
                            this.mNetwork.n("anonymous", "1");
                            this.mNetwork.n("can_no_forum", writeData.isCanNoForum() ? "1" : "0");
                            this.mNetwork.n("is_feedback", writeData.isUserFeedback() ? "1" : "0");
                            if (str != null) {
                                this.mNetwork.n("voice_md5", str);
                                this.mNetwork.n("during_time", String.valueOf(voiceDuringTime));
                            }
                            String imagesCodeForPost = writeData.getImagesCodeForPost();
                            if (writeData.getType() != 6) {
                                if (writeData.getType() == 7 && TextUtils.isEmpty(writeData.getTitle()) && TextUtils.isEmpty(str) && TextUtils.isEmpty(imagesCodeForPost) && TextUtils.isEmpty(writeData.getContent()) && writeData.getVideoInfo() == null) {
                                    this.mErrorData.setError_code(-53);
                                    this.mErrorData.setError_msg(TbadkCoreApplication.getInst().getString(d.j.sand_fail));
                                } else if ((!(writeData.getType() == 0 || writeData.getType() == 9) || TextUtils.isEmpty(writeData.getTitle())) && TextUtils.isEmpty(str) && TextUtils.isEmpty(imagesCodeForPost) && TextUtils.isEmpty(writeData.getContent()) && writeData.getVideoInfo() == null && writeData.getType() != 7 && !writeData.isLinkThread()) {
                                    this.mErrorData.setError_code(-53);
                                    this.mErrorData.setError_msg(TbadkCoreApplication.getInst().getString(d.j.sand_fail));
                                }
                            }
                            if (writeData.getVcode() != null && writeData.getVcode().length() > 0) {
                                this.mNetwork.n("vcode", writeData.getVcode());
                            }
                            if (!StringUtils.isNull(writeData.getVcodeMD5())) {
                                this.mNetwork.n("vcode_md5", writeData.getVcodeMD5());
                            }
                            if (!StringUtils.isNull(writeData.getVcodeType())) {
                                this.mNetwork.n("vcode_type", writeData.getVcodeType());
                            }
                            if (TbadkCoreApplication.getInst().getNewVcodeWebviewCrashCount() < 3) {
                                this.mNetwork.n("vcode_tag", "12");
                            }
                            Address D = com.baidu.adp.lib.d.a.fc().D(false);
                            this.mNetwork.n("new_vcode", "1");
                            if (writeData.getVideoInfo() == null || !writeData.getVideoInfo().hasUpload()) {
                                str2 = writeData.getContent() + imagesCodeForPost;
                            } else {
                                str2 = writeData.getContent() + writeData.getVideoInfo().buildContent() + imagesCodeForPost;
                            }
                            if (writeData.getType() == 6 && writeData.getVoteInfo() != null) {
                                if (writeData.getWriteImagesInfo() != null) {
                                    writeData.getVoteInfo().setServerImageCode(writeData.getWriteImagesInfo().getChosedFiles());
                                }
                                str2 = writeData.getVoteInfo().buildWriteContent();
                            }
                            com.baidu.tbadk.core.util.h.dg(str2);
                            this.mNetwork.n("content", com.baidu.tieba.face.a.ki(str2));
                            this.mNetwork.n("reply_uid", writeData.getReplyId());
                            if (!TextUtils.isEmpty(writeData.getMemeText())) {
                                this.mNetwork.n("meme_text", writeData.getMemeText());
                            }
                            if (!TextUtils.isEmpty(writeData.getMemeContSign())) {
                                this.mNetwork.n("meme_cont_sign", writeData.getMemeContSign());
                            }
                            switch (writeData.getType()) {
                                case 0:
                                case 7:
                                case 9:
                                    this.mNetwork.setUrl(gqc);
                                    if (writeData.isCanNoForum()) {
                                        this.mNetwork.n(ImageViewerConfig.FORUM_ID, "0");
                                        this.mNetwork.n("kw", "");
                                        this.mNetwork.n("transform_forums", writeData.getTransmitForumData());
                                    } else {
                                        this.mNetwork.n(ImageViewerConfig.FORUM_ID, writeData.getForumId());
                                        this.mNetwork.n("kw", writeData.getForumName());
                                    }
                                    this.mNetwork.n(IntentConfig.CALL_FROM, writeData.getCallFrom());
                                    this.mNetwork.n(VrPlayerActivityConfig.TITLE, writeData.getTitle());
                                    this.mNetwork.n("is_ntitle", writeData.isNoTitle() ? "1" : "0");
                                    if (writeData.isNoTitle()) {
                                        this.mNetwork.n("st_type", "notitle");
                                    }
                                    if (writeData.getIsStory() == 1) {
                                        this.mNetwork.n("is_story", "1");
                                    }
                                    if (D != null && TbadkCoreApplication.getInst().getIsLocationOn() && !TbConfig.getPositionPagerId().equals(writeData.getForumId())) {
                                        this.mNetwork.n("lbs", String.valueOf(D.getLatitude()) + Constants.ACCEPT_TIME_SEPARATOR_SP + String.valueOf(D.getLongitude()));
                                    }
                                    c.a(this.mNetwork, writeData);
                                    if (writeData.getCategoryFrom() >= 0) {
                                        this.mNetwork.n("fromCategoryId", String.valueOf(writeData.getCategoryFrom()));
                                    }
                                    if (writeData.getCategoryTo() >= 0) {
                                        this.mNetwork.n("toCategoryId", String.valueOf(writeData.getCategoryTo()));
                                    }
                                    if (writeData.getType() == 7) {
                                        this.mNetwork.n("is_bottle", String.valueOf(1));
                                    }
                                    if (writeData.getRecommendExt() != null) {
                                        this.mNetwork.n("recommend_ext", writeData.getRecommendExt());
                                    }
                                    if (writeData.isLinkThread()) {
                                        this.mNetwork.n("link_url", writeData.getLinkUrl());
                                        this.mNetwork.n("link_url_code", writeData.getLinkUrlCode() == null ? "" : writeData.getLinkUrlCode());
                                    }
                                    this.mNetwork.n("is_link_thread", writeData.isLinkThread() ? "1" : "0");
                                    str3 = imagesCodeForPost;
                                    break;
                                case 1:
                                    this.mNetwork.setUrl(gqd);
                                    this.mNetwork.n(ImageViewerConfig.FORUM_ID, writeData.getForumId());
                                    this.mNetwork.n("v_fid", writeData.getVForumId());
                                    this.mNetwork.n("v_fname", writeData.getVForumName());
                                    this.mNetwork.n("tid", writeData.getThreadId());
                                    this.mNetwork.n("kw", writeData.getForumName());
                                    this.mNetwork.n("is_ad", writeData.getIsAd() ? "1" : "0");
                                    this.mNetwork.n("is_barrage", writeData.isBarrage() ? "1" : "0");
                                    this.mNetwork.n("barrage_time", String.valueOf(writeData.getBarrageTime()));
                                    if (writeData.isFrsReply()) {
                                        this.mNetwork.n("st_param", "frs");
                                    }
                                    if (writeData.getIsStory() == 1) {
                                        this.mNetwork.n("is_story", "1");
                                    }
                                    if (com.baidu.tbadk.editortools.pb.a.Dd().getStatus() == 1) {
                                        this.mNetwork.n("ptype", "4");
                                    }
                                    c.a(this.mNetwork, writeData);
                                    str3 = imagesCodeForPost;
                                    break;
                                case 2:
                                    this.mNetwork.setUrl(gqd);
                                    this.mNetwork.n(ImageViewerConfig.FORUM_ID, writeData.getForumId());
                                    this.mNetwork.n("v_fid", writeData.getVForumId());
                                    this.mNetwork.n("v_fname", writeData.getVForumName());
                                    this.mNetwork.n("tid", writeData.getThreadId());
                                    this.mNetwork.n("kw", writeData.getForumName());
                                    this.mNetwork.n("quote_id", String.valueOf(writeData.getFloor()));
                                    this.mNetwork.n("is_twzhibo_thread", String.valueOf(0));
                                    this.mNetwork.n("floor_num", String.valueOf(writeData.getFloorNum()));
                                    if (writeData.getRepostId() != null) {
                                        this.mNetwork.n("repostid", writeData.getRepostId());
                                    }
                                    this.mNetwork.n("is_ad", writeData.getIsAd() ? "1" : "0");
                                    this.mNetwork.n(WriteActivityConfig.IS_ADDITION, writeData.isAddition() ? "1" : "0");
                                    this.mNetwork.n("is_giftpost", writeData.isGiftPost() ? "1" : "0");
                                    this.mNetwork.n("is_giftpost", writeData.isGiftPost() ? "1" : "0");
                                    if (writeData.isAddition()) {
                                        this.mNetwork.n("st_type", "conadd");
                                        str3 = imagesCodeForPost;
                                        break;
                                    }
                                    str3 = imagesCodeForPost;
                                    break;
                                case 3:
                                case 8:
                                default:
                                    if (writeData.isCanNoForum()) {
                                        this.mNetwork.n(ImageViewerConfig.FORUM_ID, "0");
                                        this.mNetwork.n("kw", "");
                                        this.mNetwork.n("transform_forums", writeData.getTransmitForumData());
                                        str3 = imagesCodeForPost;
                                        break;
                                    } else {
                                        this.mNetwork.n(ImageViewerConfig.FORUM_ID, writeData.getForumId());
                                        this.mNetwork.n("kw", writeData.getForumName());
                                        str3 = imagesCodeForPost;
                                        break;
                                    }
                                case 4:
                                    this.mNetwork.setUrl(gqc);
                                    this.mNetwork.n(ImageViewerConfig.FORUM_ID, writeData.getForumId());
                                    this.mNetwork.n("kw", writeData.getForumName());
                                    this.mNetwork.n(VrPlayerActivityConfig.TITLE, writeData.getTitle());
                                    this.mNetwork.n("thread_type", "33");
                                    c.a(this.mNetwork, writeData);
                                    str3 = imagesCodeForPost;
                                    break;
                                case 5:
                                    this.mNetwork.setUrl(gqd);
                                    this.mNetwork.n(ImageViewerConfig.FORUM_ID, writeData.getForumId());
                                    this.mNetwork.n("tid", writeData.getThreadId());
                                    this.mNetwork.n("kw", writeData.getForumName());
                                    this.mNetwork.n("is_twzhibo_thread", String.valueOf(1));
                                    c.a(this.mNetwork, writeData);
                                    str3 = imagesCodeForPost;
                                    break;
                                case 6:
                                    this.mNetwork.setUrl(gqc);
                                    this.mNetwork.n(ImageViewerConfig.FORUM_ID, writeData.getForumId());
                                    this.mNetwork.n("kw", writeData.getForumName());
                                    this.mNetwork.n("thread_type", String.valueOf(36));
                                    this.mNetwork.n(VrPlayerActivityConfig.TITLE, writeData.getTitle());
                                    this.mNetwork.n("is_ntitle", writeData.isNoTitle() ? "1" : "0");
                                    if (writeData.isNoTitle()) {
                                        this.mNetwork.n("st_type", "notitle");
                                    }
                                    c.a(this.mNetwork, writeData);
                                    str3 = imagesCodeForPost;
                                    break;
                            }
                        }
                    }
                }
            }
            str4 = this.mNetwork.up();
            notifyUploadProgress(95);
            if (this.mNetwork.uN().vL().isRequestSuccess()) {
                this.mErrorData.parserJson(str4);
            } else {
                this.mErrorData.setError_code(this.mNetwork.uQ() ? this.mNetwork.uR() : this.mNetwork.uS());
                this.mErrorData.setError_msg(this.mNetwork.getErrorString());
            }
            if (this.mErrorData.error_code != 0 && !com.baidu.adp.lib.util.j.hh()) {
                this.mErrorData.setError_msg(TbadkCoreApplication.getInst().getApp().getString(d.j.neterror));
            } else if (this.mErrorData.error_code != 0 && writeData.isHasImages() && com.baidu.adp.lib.util.k.isEmpty(writeData.getContent() + str3)) {
                this.mErrorData.setError_msg(TbadkCoreApplication.getInst().getApp().getString(d.j.img_upload_error));
            }
            try {
                this.gqf = new AntiData();
                this.gqf.parserJson(new JSONObject(str4).optJSONObject("anti_stat"));
            } catch (Exception e2) {
            }
            notifyUploadProgress(100);
        }
        return str4;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifyUploadProgress(int i) {
        if (this.gqh != null) {
            this.gqh.onUploadProgress(i);
        }
    }

    public boolean isRequestSuccess() {
        if (this.mNetwork == null) {
            return false;
        }
        return this.mNetwork.uN().vL().isRequestSuccess();
    }

    public void cancel() {
        this.isCancelled = true;
        if (this.mNetwork != null) {
            this.mNetwork.fo();
        }
        if (this.aFG != null) {
            this.aFG.cancel();
        }
        if (this.gqg != null) {
            this.gqg.cancelUpload();
        }
    }

    public AntiData buJ() {
        return this.gqf;
    }

    public ErrorData getErrorData() {
        return this.mErrorData;
    }
}
