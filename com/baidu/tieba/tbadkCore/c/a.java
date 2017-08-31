package com.baidu.tieba.tbadkCore.c;

import android.location.Address;
import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.i;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.GraffitiVcodeActivityConfig;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.atomData.VrPlayerActivityConfig;
import com.baidu.tbadk.core.atomData.WriteActivityConfig;
import com.baidu.tbadk.core.atomData.WriteShareActivityConfig;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.ErrorData;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.TbErrInfo;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.j;
import com.baidu.tbadk.core.util.k;
import com.baidu.tbadk.core.util.x;
import com.baidu.tbadk.coreExtra.data.VideoInfo;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.coreExtra.data.g;
import com.baidu.tbadk.coreExtra.data.h;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tbadk.img.ImageUploadResult;
import com.baidu.tbadk.img.UploadedImageInfo;
import com.baidu.tbadk.img.d;
import com.baidu.tieba.d;
import com.baidu.tieba.graffiti.b;
import com.baidu.tieba.tbadkCore.videoupload.VideoFinishResult;
import com.baidu.tieba.tbadkCore.videoupload.a.e;
import com.baidu.tieba.tbadkCore.writeModel.c;
import com.xiaomi.mipush.sdk.Constants;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class a {
    private static final String gjb = TbConfig.SERVER_ADDRESS + TbConfig.POST_THREAD_ADDRESS;
    private static final String gjc = TbConfig.SERVER_ADDRESS + TbConfig.REPLY_THREAD_ADDRESS;
    public static final String gjd = TbConfig.SERVER_ADDRESS + TbConfig.POST_THREAD_FOR_SHARE_ADDRESS;
    private d aFR;
    private AntiData gje;
    private com.baidu.tieba.tbadkCore.videoupload.a gjf;
    private InterfaceC0123a gjg;
    private ErrorData mErrorData;
    private x mNetwork = null;
    private boolean isCancelled = false;

    /* renamed from: com.baidu.tieba.tbadkCore.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0123a {
        void onUploadProgress(int i);
    }

    public a() {
        this.mErrorData = null;
        this.mErrorData = new ErrorData();
    }

    public void a(InterfaceC0123a interfaceC0123a) {
        this.gjg = interfaceC0123a;
    }

    public ImageUploadResult d(ImageFileInfo imageFileInfo, boolean z) {
        if (imageFileInfo == null) {
            return null;
        }
        if (this.aFR == null) {
            this.aFR = new d("HTTPWriteService.postImageData");
        }
        return this.aFR.c(imageFileInfo, z);
    }

    public String a(WriteData writeData, boolean z) {
        String returnVoiceMd5;
        boolean z2;
        String str;
        String str2 = null;
        if (writeData == null) {
            return null;
        }
        this.mNetwork = new x();
        this.mNetwork.vj().wf().mIsNeedTbs = true;
        if (writeData.getType() == 3) {
            if (writeData.getVcode() != null && writeData.getVcode().length() > 0) {
                this.mNetwork.n("vcode", writeData.getVcode());
            }
            if (TbadkCoreApplication.getInst().getNewVcodeWebviewCrashCount() < 3) {
                this.mNetwork.n("tag", "11");
            }
            this.mNetwork.n("newVcode", "1");
            this.mNetwork.n("content", writeData.getContent());
            this.mNetwork.setUrl(gjd);
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
        } else if (!checkGraffitiValid(writeData.getGraffitiFileName())) {
            this.mErrorData.setError_code(-53);
            this.mErrorData.setError_msg(TbadkCoreApplication.getInst().getString(d.l.graffiti_valid_fail));
            return null;
        } else {
            if (z && writeData.isHasImages()) {
                if (this.aFR == null) {
                    this.aFR = new com.baidu.tbadk.img.d("HTTPWriteService.postWriteData");
                }
                if (writeData.getType() == 6) {
                    if (!this.aFR.b(writeData.getWriteImagesInfo(), true)) {
                        this.mErrorData.setError_code(-53);
                        this.mErrorData.setError_msg(TbadkCoreApplication.getInst().getString(d.l.upload_error));
                        return null;
                    }
                } else {
                    this.aFR.c(writeData.getWriteImagesInfo(), true);
                }
            }
            if (!StringUtils.isNull(writeData.getGraffitiFileName())) {
                if (this.aFR == null) {
                    this.aFR = new com.baidu.tbadk.img.d("HTTPWriteService.postWriteData");
                }
                CustomResponsedMessage runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_GRAFFITI_COMMON_MANAGER, com.baidu.tieba.tbadkCore.util.d.class);
                String lw = (runTask == null || runTask.getData() == null) ? null : ((com.baidu.tieba.tbadkCore.util.d) runTask.getData()).lw(writeData.getGraffitiFileName());
                if (!StringUtils.isNull(lw)) {
                    ImageFileInfo imageFileInfo = new ImageFileInfo();
                    imageFileInfo.setFilePath(lw);
                    ImageUploadResult a = this.aFR.a(imageFileInfo, true, false);
                    if (a != null) {
                        UploadedImageInfo uploadedPicInfo = a.getUploadedPicInfo();
                        writeData.setGraffitiWriteCode(b.a(uploadedPicInfo));
                        if (uploadedPicInfo != null) {
                            writeData.setGraffitiImageId(uploadedPicInfo.getPic_id());
                        }
                    }
                }
            }
            if (this.isCancelled) {
                return null;
            }
            String voice = writeData.getVoice();
            int voiceDuringTime = writeData.getVoiceDuringTime();
            if (writeData.getReturnVoiceMd5() == null) {
                z2 = false;
                returnVoiceMd5 = null;
            } else {
                returnVoiceMd5 = writeData.getReturnVoiceMd5();
                z2 = true;
            }
            if (voice != null && !z2) {
                com.baidu.tbadk.core.voice.service.b bVar = new com.baidu.tbadk.core.voice.service.b(TbConfig.UPLOAD_CHUNK_AUDIO_ADDRESS, TbConfig.FINISH_UPLOAD_CHUNK_AUDIO_ADDRESS);
                bVar.v("type", 1);
                String q = k.q(voice, 1);
                h ey = bVar.ey(q);
                if (ey != null && ey.isSuccess()) {
                    g yo = ey.yo();
                    if (yo != null) {
                        returnVoiceMd5 = yo.ym();
                        com.baidu.tbadk.core.voice.a.b.ai(writeData.getVoice(), returnVoiceMd5);
                        writeData.setReturnVoiceMd5(returnVoiceMd5);
                    } else {
                        j jVar = new j();
                        jVar.h("ErrCode", Integer.valueOf(ey.getErrorCode()));
                        jVar.h("ErrMsg", ey.getErrorString());
                        TiebaStatic.voiceError(TbErrInfo.ERR_VOI_SEND, "audioUploadData is null", jVar.toString());
                        this.mErrorData.setError_code(ey.getErrorCode());
                        this.mErrorData.setError_msg(ey.getErrorString());
                        return null;
                    }
                } else {
                    j jVar2 = new j();
                    jVar2.h("audioFile", q);
                    TiebaStatic.voiceError(TbErrInfo.ERR_VOI_SEND, "uploadService.upload null or fail", jVar2.toString());
                    this.mErrorData.setError_code(ey.getErrorCode());
                    this.mErrorData.setError_msg(ey.getErrorString());
                    return null;
                }
            }
            if (this.isCancelled) {
                return null;
            }
            VideoInfo videoInfo = writeData.getVideoInfo();
            if (videoInfo != null) {
                if (videoInfo.needUploadVideo()) {
                    this.gjf = new com.baidu.tieba.tbadkCore.videoupload.a();
                    VideoFinishResult a2 = this.gjf.a(writeData.getForumId(), videoInfo.getVideoPath(), videoInfo.getVideoDuration(), new e() { // from class: com.baidu.tieba.tbadkCore.c.a.1
                        int gjh = 0;

                        @Override // com.baidu.tieba.tbadkCore.videoupload.a.e
                        public void aa(float f) {
                            int i = (int) (90.0f * f);
                            if (i != this.gjh) {
                                this.gjh = i;
                                a.this.notifyUploadProgress(i);
                            }
                        }
                    });
                    if (a2 == null) {
                        this.mErrorData.setError_code(-53);
                        this.mErrorData.setError_msg(TbadkCoreApplication.getInst().getString(d.l.upload_error));
                        return null;
                    } else if (a2.isSuccess()) {
                        videoInfo.setVideoMd5(a2.getVideoMd5());
                        videoInfo.setVideoUrl(a2.getVideoUrl());
                    } else {
                        this.mErrorData.setError_code(a2.getErrorNo());
                        this.mErrorData.setError_msg(a2.getUserMessage());
                        return null;
                    }
                }
                if (videoInfo.needUploadThunmb()) {
                    if (this.aFR == null) {
                        this.aFR = new com.baidu.tbadk.img.d("HTTPWriteService.postWriteData");
                    }
                    ImageUploadResult s = this.aFR.s(videoInfo.getThumbPath(), false);
                    if (s != null) {
                        videoInfo.setThumbId(s.picId);
                    }
                }
            }
            if (!this.isCancelled) {
                this.mNetwork.n("anonymous", "1");
                this.mNetwork.n("can_no_forum", writeData.isCanNoForum() ? "1" : "0");
                this.mNetwork.n("is_feedback", writeData.isUserFeedback() ? "1" : "0");
                if (returnVoiceMd5 != null) {
                    this.mNetwork.n("voice_md5", returnVoiceMd5);
                    this.mNetwork.n("during_time", String.valueOf(voiceDuringTime));
                }
                String imagesCodeForPost = writeData.getImagesCodeForPost();
                if (writeData.getType() != 6) {
                    if (writeData.getType() == 7 && TextUtils.isEmpty(writeData.getTitle()) && TextUtils.isEmpty(returnVoiceMd5) && TextUtils.isEmpty(imagesCodeForPost) && TextUtils.isEmpty(writeData.getContent()) && writeData.getVideoInfo() == null && TextUtils.isEmpty(writeData.getGraffitiWriteCode())) {
                        this.mErrorData.setError_code(-53);
                        this.mErrorData.setError_msg(TbadkCoreApplication.getInst().getString(d.l.sand_fail));
                        return null;
                    }
                    if ((!(writeData.getType() == 0 || writeData.getType() == 9) || TextUtils.isEmpty(writeData.getTitle())) && TextUtils.isEmpty(returnVoiceMd5) && TextUtils.isEmpty(imagesCodeForPost) && TextUtils.isEmpty(writeData.getContent()) && writeData.getVideoInfo() == null && TextUtils.isEmpty(writeData.getGraffitiWriteCode()) && writeData.getType() != 7 && !writeData.isLinkThread()) {
                        this.mErrorData.setError_code(-53);
                        this.mErrorData.setError_msg(TbadkCoreApplication.getInst().getString(d.l.sand_fail));
                        return null;
                    }
                }
                if (writeData.getVcode() != null && writeData.getVcode().length() > 0) {
                    this.mNetwork.n("vcode", writeData.getVcode());
                }
                if (!StringUtils.isNull(writeData.getVcodeMD5())) {
                    this.mNetwork.n(GraffitiVcodeActivityConfig.VCODE_MD5, writeData.getVcodeMD5());
                }
                if (!StringUtils.isNull(writeData.getVcodeType())) {
                    this.mNetwork.n("vcode_type", writeData.getVcodeType());
                }
                if (TbadkCoreApplication.getInst().getNewVcodeWebviewCrashCount() < 3) {
                    this.mNetwork.n("vcode_tag", "12");
                }
                Address D = com.baidu.adp.lib.d.a.fd().D(false);
                this.mNetwork.n("new_vcode", "1");
                if (writeData.getVideoInfo() == null || !writeData.getVideoInfo().hasUpload()) {
                    str = writeData.getContent() + imagesCodeForPost;
                } else {
                    str = writeData.getContent() + writeData.getVideoInfo().buildContent() + imagesCodeForPost;
                }
                if (!StringUtils.isNull(writeData.getGraffitiWriteCode())) {
                    str = str + writeData.getGraffitiWriteCode();
                }
                if (writeData.getType() == 6 && writeData.getVoteInfo() != null) {
                    if (writeData.getWriteImagesInfo() != null) {
                        writeData.getVoteInfo().setServerImageCode(writeData.getWriteImagesInfo().getChosedFiles());
                    }
                    str = writeData.getVoteInfo().buildWriteContent();
                }
                com.baidu.tbadk.core.util.h.dk(str);
                this.mNetwork.n("content", str.replaceAll(com.baidu.tbadk.imageManager.d.aFM, "meme,"));
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
                        this.mNetwork.setUrl(gjb);
                        if (writeData.isCanNoForum()) {
                            this.mNetwork.n("fid", "0");
                            this.mNetwork.n("kw", "");
                            this.mNetwork.n("transform_forums", writeData.getTransmitForumData());
                        } else {
                            this.mNetwork.n("fid", writeData.getForumId());
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
                        str2 = imagesCodeForPost;
                        break;
                    case 1:
                        this.mNetwork.setUrl(gjc);
                        this.mNetwork.n("fid", writeData.getForumId());
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
                        if (com.baidu.tbadk.editortools.pb.a.Dr().getStatus() == 1) {
                            this.mNetwork.n("ptype", "4");
                        }
                        c.a(this.mNetwork, writeData);
                        str2 = imagesCodeForPost;
                        break;
                    case 2:
                        this.mNetwork.setUrl(gjc);
                        this.mNetwork.n("fid", writeData.getForumId());
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
                            str2 = imagesCodeForPost;
                            break;
                        }
                        str2 = imagesCodeForPost;
                        break;
                    case 3:
                    case 8:
                    default:
                        if (writeData.isCanNoForum()) {
                            this.mNetwork.n("fid", "0");
                            this.mNetwork.n("kw", "");
                            this.mNetwork.n("transform_forums", writeData.getTransmitForumData());
                            str2 = imagesCodeForPost;
                            break;
                        } else {
                            this.mNetwork.n("fid", writeData.getForumId());
                            this.mNetwork.n("kw", writeData.getForumName());
                            str2 = imagesCodeForPost;
                            break;
                        }
                    case 4:
                        this.mNetwork.setUrl(gjb);
                        this.mNetwork.n("fid", writeData.getForumId());
                        this.mNetwork.n("kw", writeData.getForumName());
                        this.mNetwork.n(VrPlayerActivityConfig.TITLE, writeData.getTitle());
                        this.mNetwork.n("thread_type", "33");
                        c.a(this.mNetwork, writeData);
                        str2 = imagesCodeForPost;
                        break;
                    case 5:
                        this.mNetwork.setUrl(gjc);
                        this.mNetwork.n("fid", writeData.getForumId());
                        this.mNetwork.n("tid", writeData.getThreadId());
                        this.mNetwork.n("kw", writeData.getForumName());
                        this.mNetwork.n("is_twzhibo_thread", String.valueOf(1));
                        c.a(this.mNetwork, writeData);
                        str2 = imagesCodeForPost;
                        break;
                    case 6:
                        this.mNetwork.setUrl(gjb);
                        this.mNetwork.n("fid", writeData.getForumId());
                        this.mNetwork.n("kw", writeData.getForumName());
                        this.mNetwork.n("thread_type", String.valueOf(36));
                        this.mNetwork.n(VrPlayerActivityConfig.TITLE, writeData.getTitle());
                        this.mNetwork.n("is_ntitle", writeData.isNoTitle() ? "1" : "0");
                        if (writeData.isNoTitle()) {
                            this.mNetwork.n("st_type", "notitle");
                        }
                        c.a(this.mNetwork, writeData);
                        str2 = imagesCodeForPost;
                        break;
                }
            } else {
                return null;
            }
        }
        String uM = this.mNetwork.uM();
        notifyUploadProgress(95);
        if (this.mNetwork.vj().wg().isRequestSuccess()) {
            this.mErrorData.parserJson(uM);
        } else {
            this.mErrorData.setError_code(this.mNetwork.vm() ? this.mNetwork.vn() : this.mNetwork.vo());
            this.mErrorData.setError_msg(this.mNetwork.getErrorString());
        }
        if (this.mErrorData.error_code != 0 && !i.hi()) {
            this.mErrorData.setError_msg(TbadkCoreApplication.getInst().getApp().getString(d.l.neterror));
        } else if (this.mErrorData.error_code != 0 && writeData.isHasImages() && com.baidu.adp.lib.util.j.isEmpty(writeData.getContent() + str2)) {
            this.mErrorData.setError_msg(TbadkCoreApplication.getInst().getApp().getString(d.l.img_upload_error));
        }
        try {
            this.gje = new AntiData();
            this.gje.parserJson(new JSONObject(uM).optJSONObject("anti_stat"));
        } catch (Exception e) {
        }
        notifyUploadProgress(100);
        return uM;
    }

    private boolean checkGraffitiValid(String str) {
        com.baidu.tieba.tbadkCore.util.d dVar;
        if (StringUtils.isNull(str)) {
            return true;
        }
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_GRAFFITI_COMMON_MANAGER, com.baidu.tieba.tbadkCore.util.d.class);
        return runTask == null || (dVar = (com.baidu.tieba.tbadkCore.util.d) runTask.getData()) == null || dVar.ly(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifyUploadProgress(int i) {
        if (this.gjg != null) {
            this.gjg.onUploadProgress(i);
        }
    }

    public boolean isRequestSuccess() {
        if (this.mNetwork == null) {
            return false;
        }
        return this.mNetwork.vj().wg().isRequestSuccess();
    }

    public void cancel() {
        this.isCancelled = true;
        if (this.mNetwork != null) {
            this.mNetwork.fp();
        }
        if (this.aFR != null) {
            this.aFR.cancel();
        }
        if (this.gjf != null) {
            this.gjf.btn();
        }
    }

    public AntiData bsD() {
        return this.gje;
    }

    public ErrorData getErrorData() {
        return this.mErrorData;
    }
}
