package com.baidu.tieba.tbadkCore.c;

import android.location.Address;
import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.i;
import com.baidu.adp.lib.util.j;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.CreateGroupActivityActivityConfig;
import com.baidu.tbadk.core.atomData.GraffitiVcodeActivityConfig;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.atomData.VrPlayerActivityConfig;
import com.baidu.tbadk.core.atomData.WriteShareActivityConfig;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.ErrorData;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TbErrInfo;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ab;
import com.baidu.tbadk.core.util.l;
import com.baidu.tbadk.core.util.m;
import com.baidu.tbadk.coreExtra.data.VideoInfo;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.coreExtra.data.g;
import com.baidu.tbadk.coreExtra.data.h;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tbadk.img.ImageUploadResult;
import com.baidu.tbadk.img.UploadedImageInfo;
import com.baidu.tbadk.img.c;
import com.baidu.tieba.graffiti.d;
import com.baidu.tieba.r;
import com.baidu.tieba.tbadkCore.util.p;
import com.baidu.tieba.tbadkCore.videoupload.VideoFinishResult;
import com.baidu.tieba.tbadkCore.writeModel.f;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class a {
    private static final String fvU = String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.POST_THREAD_ADDRESS;
    private static final String fvV = String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.REPLY_THREAD_ADDRESS;
    public static final String fvW = String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.POST_THREAD_FOR_SHARE_ADDRESS;
    private c ayi;
    private ErrorData fvX;
    private AntiData fvY;
    private com.baidu.tieba.tbadkCore.videoupload.a fvZ;
    private InterfaceC0078a fwa;
    private ab aiu = null;
    private boolean ayv = false;

    /* renamed from: com.baidu.tieba.tbadkCore.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0078a {
        void rP(int i);
    }

    /* loaded from: classes.dex */
    public static class b {
        public static int fwd = 1;
    }

    public a() {
        this.fvX = null;
        this.fvX = new ErrorData();
    }

    public void a(InterfaceC0078a interfaceC0078a) {
        this.fwa = interfaceC0078a;
    }

    public ImageUploadResult d(ImageFileInfo imageFileInfo, boolean z) {
        if (imageFileInfo == null) {
            return null;
        }
        if (this.ayi == null) {
            this.ayi = new c("HTTPWriteService.postImageData");
        }
        return this.ayi.c(imageFileInfo, z);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public String a(WriteData writeData, boolean z) {
        String returnVoiceMd5;
        boolean z2;
        String str;
        String str2;
        if (writeData == null) {
            return null;
        }
        this.aiu = new ab();
        this.aiu.uS().vN().mIsNeedTbs = true;
        String str3 = null;
        if (writeData.getType() == 3) {
            if (writeData.getVcode() != null && writeData.getVcode().length() > 0) {
                this.aiu.n("vcode", writeData.getVcode());
            }
            if (TbadkCoreApplication.m9getInst().getNewVcodeWebviewCrashCount() < 3) {
                this.aiu.n("tag", "11");
            }
            this.aiu.n("newVcode", "1");
            this.aiu.n(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_CONTENT, writeData.getContent());
            this.aiu.setUrl(fvW);
            this.aiu.n(ImageViewerConfig.FORUM_NAME, writeData.getForumName());
            this.aiu.n(VrPlayerActivityConfig.TITLE, writeData.getTitle());
            this.aiu.n("apiKey", writeData.getShareApiKey());
            this.aiu.n("appName", writeData.getShareAppName());
            this.aiu.n("signKey", writeData.getShareSignKey());
            this.aiu.n("summary_title", writeData.getShareSummaryTitle());
            this.aiu.n("summary_content", writeData.getShareSummaryContent());
            this.aiu.n("summary_img", writeData.getShareSummaryImg());
            this.aiu.n(WriteShareActivityConfig.SHARE_SUMMARY_IMG_WIDTH, String.valueOf(writeData.getShareSummaryImgWidth()));
            this.aiu.n(WriteShareActivityConfig.SHARE_SUMMARY_IMG_HEIGHT, String.valueOf(writeData.getShareSummaryImgHeight()));
            this.aiu.n(WriteShareActivityConfig.SHARE_SUMMARY_IMG_TYPE, writeData.getShareSummaryImgType());
            this.aiu.n("referUrl", writeData.getShareReferUrl());
        } else if (!rm(writeData.getGraffitiFileName())) {
            this.fvX.setError_code(-53);
            this.fvX.setError_msg(TbadkCoreApplication.m9getInst().getString(r.j.graffiti_valid_fail));
            return null;
        } else {
            if (z && writeData.isHasImages()) {
                if (this.ayi == null) {
                    this.ayi = new c("HTTPWriteService.postWriteData");
                }
                if (writeData.getType() == 6) {
                    if (!this.ayi.b(writeData.getWriteImagesInfo(), true)) {
                        this.fvX.setError_code(-53);
                        this.fvX.setError_msg(TbadkCoreApplication.m9getInst().getString(r.j.upload_error));
                        return null;
                    }
                } else {
                    this.ayi.c(writeData.getWriteImagesInfo(), true);
                }
            }
            if (!StringUtils.isNull(writeData.getGraffitiFileName())) {
                if (this.ayi == null) {
                    this.ayi = new c("HTTPWriteService.postWriteData");
                }
                String str4 = null;
                CustomResponsedMessage runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_GRAFFITI_COMMON_MANAGER, p.class);
                if (runTask != null && runTask.getData() != null) {
                    str4 = ((p) runTask.getData()).kJ(writeData.getGraffitiFileName());
                }
                if (!StringUtils.isNull(str4)) {
                    ImageFileInfo imageFileInfo = new ImageFileInfo();
                    imageFileInfo.setFilePath(str4);
                    ImageUploadResult a = this.ayi.a(imageFileInfo, true, false);
                    if (a != null) {
                        UploadedImageInfo uploadedPicInfo = a.getUploadedPicInfo();
                        writeData.setGraffitiWriteCode(d.a(uploadedPicInfo));
                        if (uploadedPicInfo != null) {
                            writeData.setGraffitiImageId(uploadedPicInfo.getPic_id());
                        }
                    }
                }
            }
            if (this.ayv) {
                return null;
            }
            if (writeData.getIsBaobao()) {
                if (this.ayi == null) {
                    this.ayi = new c("HTTPWriteService.postWriteData");
                }
                this.ayi.c(writeData.getBaobaoImagesInfo(), true);
            }
            if (this.ayv) {
                return null;
            }
            String voice = writeData.getVoice();
            int voiceDuringTime = writeData.getVoiceDuringTime();
            if (writeData.getReturnVoiceMd5() == null) {
                returnVoiceMd5 = null;
                z2 = false;
            } else {
                returnVoiceMd5 = writeData.getReturnVoiceMd5();
                z2 = true;
            }
            if (voice == null || z2) {
                str = returnVoiceMd5;
            } else {
                com.baidu.tbadk.core.voice.service.c cVar = new com.baidu.tbadk.core.voice.service.c(TbConfig.UPLOAD_CHUNK_AUDIO_ADDRESS, TbConfig.FINISH_UPLOAD_CHUNK_AUDIO_ADDRESS);
                cVar.u("type", 1);
                String r = m.r(voice, 1);
                h ee = cVar.ee(r);
                if (ee != null && ee.isSuccess()) {
                    g xK = ee.xK();
                    if (xK != null) {
                        String md5 = xK.getMd5();
                        com.baidu.tbadk.core.voice.a.b.ag(writeData.getVoice(), md5);
                        writeData.setReturnVoiceMd5(md5);
                        str = md5;
                    } else {
                        l lVar = new l();
                        lVar.n("ErrCode", Integer.valueOf(ee.getErrorCode()));
                        lVar.n("ErrMsg", ee.getErrorString());
                        TiebaStatic.voiceError(TbErrInfo.ERR_VOI_SEND, "audioUploadData is null", lVar.toString());
                        this.fvX.setError_code(ee.getErrorCode());
                        this.fvX.setError_msg(ee.getErrorString());
                        return null;
                    }
                } else {
                    l lVar2 = new l();
                    lVar2.n("audioFile", r);
                    TiebaStatic.voiceError(TbErrInfo.ERR_VOI_SEND, "uploadService.upload null or fail", lVar2.toString());
                    this.fvX.setError_code(ee.getErrorCode());
                    this.fvX.setError_msg(ee.getErrorString());
                    return null;
                }
            }
            if (this.ayv) {
                return null;
            }
            VideoInfo videoInfo = writeData.getVideoInfo();
            if (videoInfo != null) {
                if (videoInfo.needUploadVideo()) {
                    this.fvZ = new com.baidu.tieba.tbadkCore.videoupload.a();
                    VideoFinishResult a2 = this.fvZ.a(writeData.getForumId(), videoInfo.getVideoPath(), videoInfo.getVideoDuration(), new com.baidu.tieba.tbadkCore.c.b(this));
                    if (a2 == null) {
                        this.fvX.setError_code(-53);
                        this.fvX.setError_msg(TbadkCoreApplication.m9getInst().getString(r.j.upload_error));
                        return null;
                    } else if (a2.isSuccess()) {
                        videoInfo.setVideoMd5(a2.getVideoMd5());
                        videoInfo.setVideoUrl(a2.getVideoUrl());
                    } else {
                        this.fvX.setError_code(a2.getErrorNo());
                        this.fvX.setError_msg(a2.getUserMessage());
                        return null;
                    }
                }
                if (videoInfo.needUploadThunmb()) {
                    if (this.ayi == null) {
                        this.ayi = new c("HTTPWriteService.postWriteData");
                    }
                    ImageUploadResult u = this.ayi.u(videoInfo.getThumbPath(), false);
                    if (u != null) {
                        videoInfo.setThumbId(u.picId);
                    }
                }
            }
            if (this.ayv) {
                return null;
            }
            this.aiu.n("anonymous", "1");
            this.aiu.n("fid", writeData.getForumId());
            if (str != null) {
                this.aiu.n("voice_md5", str);
                this.aiu.n("during_time", String.valueOf(voiceDuringTime));
            }
            String imagesCodeForPost = writeData.getImagesCodeForPost();
            if (writeData.getType() != 6 && ((writeData.getType() != 0 || (writeData.getType() == 0 && TextUtils.isEmpty(writeData.getTitle()))) && TextUtils.isEmpty(str) && TextUtils.isEmpty(imagesCodeForPost) && TextUtils.isEmpty(writeData.getContent()) && writeData.getVideoInfo() == null && TextUtils.isEmpty(writeData.getGraffitiWriteCode()))) {
                this.fvX.setError_code(-53);
                this.fvX.setError_msg(TbadkCoreApplication.m9getInst().getString(r.j.sand_fail));
                return null;
            }
            if (writeData.getVcode() != null && writeData.getVcode().length() > 0) {
                this.aiu.n("vcode", writeData.getVcode());
            }
            if (!StringUtils.isNull(writeData.getVcodeMD5())) {
                this.aiu.n(GraffitiVcodeActivityConfig.VCODE_MD5, writeData.getVcodeMD5());
            }
            if (!StringUtils.isNull(writeData.getVcodeType())) {
                this.aiu.n("vcode_type", writeData.getVcodeType());
            }
            if (TbadkCoreApplication.m9getInst().getNewVcodeWebviewCrashCount() < 3) {
                this.aiu.n("vcode_tag", "12");
            }
            Address B = com.baidu.adp.lib.e.a.dU().B(false);
            this.aiu.n("new_vcode", "1");
            if (writeData.getVideoInfo() == null || !writeData.getVideoInfo().hasUpload()) {
                str2 = String.valueOf(writeData.getContent()) + imagesCodeForPost;
            } else {
                str2 = String.valueOf(writeData.getContent()) + writeData.getVideoInfo().buildContent() + imagesCodeForPost;
            }
            if (!StringUtils.isNull(writeData.getGraffitiWriteCode())) {
                str2 = String.valueOf(str2) + writeData.getGraffitiWriteCode();
            }
            if (writeData.getType() == 6 && writeData.getVoteInfo() != null) {
                if (writeData.getWriteImagesInfo() != null) {
                    writeData.getVoteInfo().setServerImageCode(writeData.getWriteImagesInfo().getChosedFiles());
                }
                str2 = writeData.getVoteInfo().buildWriteContent();
            }
            this.aiu.n(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_CONTENT, str2);
            this.aiu.n("reply_uid", writeData.getReplyId());
            if (writeData.getIsBaobaoImageUploaded()) {
                this.aiu.n("tail_type", String.valueOf(b.fwd));
                this.aiu.n("tail_content", writeData.getBaobaoContent());
                writeData.setBabaoPosted(true);
            } else {
                writeData.setBabaoPosted(false);
            }
            switch (writeData.getType()) {
                case 0:
                    this.aiu.setUrl(fvU);
                    this.aiu.n("kw", writeData.getForumName());
                    this.aiu.n(VrPlayerActivityConfig.TITLE, writeData.getTitle());
                    this.aiu.n("is_ntitle", writeData.isNoTitle() ? "1" : "0");
                    if (writeData.isNoTitle()) {
                        this.aiu.n("st_type", "notitle");
                    }
                    String hiAlbumId = writeData.getHiAlbumId();
                    if (hiAlbumId != null) {
                        this.aiu.n("17hi_album_id", hiAlbumId);
                    }
                    if (B != null && TbadkCoreApplication.m9getInst().getIsLocationOn() && !TbConfig.getPositionPagerId().equals(writeData.getForumId())) {
                        this.aiu.n("lbs", String.valueOf(String.valueOf(B.getLatitude())) + "," + String.valueOf(B.getLongitude()));
                    }
                    f.a(this.aiu, writeData);
                    if (writeData.getCategoryFrom() >= 0) {
                        this.aiu.n("fromCategoryId", String.valueOf(writeData.getCategoryFrom()));
                    }
                    if (writeData.getCategoryTo() >= 0) {
                        this.aiu.n("toCategoryId", String.valueOf(writeData.getCategoryTo()));
                        str3 = imagesCodeForPost;
                        break;
                    }
                    str3 = imagesCodeForPost;
                    break;
                case 1:
                    this.aiu.setUrl(fvV);
                    this.aiu.n("tid", writeData.getThreadId());
                    this.aiu.n("kw", writeData.getForumName());
                    this.aiu.n("is_ad", writeData.getIsAd() ? "1" : "0");
                    this.aiu.n("is_barrage", writeData.isBarrage() ? "1" : "0");
                    this.aiu.n("barrage_time", String.valueOf(writeData.getBarrageTime()));
                    if (writeData.isFrsReply()) {
                        this.aiu.n("st_param", "frs");
                    }
                    if (com.baidu.tbadk.editortools.e.b.Dh().getStatus() == 1) {
                        this.aiu.n("ptype", "4");
                    }
                    f.a(this.aiu, writeData);
                    str3 = imagesCodeForPost;
                    break;
                case 2:
                    this.aiu.setUrl(fvV);
                    this.aiu.n("tid", writeData.getThreadId());
                    this.aiu.n("kw", writeData.getForumName());
                    this.aiu.n("quote_id", String.valueOf(writeData.getFloor()));
                    this.aiu.n("is_twzhibo_thread", String.valueOf(0));
                    this.aiu.n("floor_num", String.valueOf(writeData.getFloorNum()));
                    if (writeData.getRepostId() != null) {
                        this.aiu.n("repostid", writeData.getRepostId());
                    }
                    this.aiu.n("is_ad", writeData.getIsAd() ? "1" : "0");
                    this.aiu.n("is_addition", writeData.isAddition() ? "1" : "0");
                    this.aiu.n("is_giftpost", writeData.isGiftPost() ? "1" : "0");
                    this.aiu.n("is_giftpost", writeData.isGiftPost() ? "1" : "0");
                    if (writeData.isAddition()) {
                        this.aiu.n("st_type", "conadd");
                        str3 = imagesCodeForPost;
                        break;
                    }
                    str3 = imagesCodeForPost;
                    break;
                case 3:
                default:
                    str3 = imagesCodeForPost;
                    break;
                case 4:
                    this.aiu.setUrl(fvU);
                    this.aiu.n("kw", writeData.getForumName());
                    this.aiu.n(VrPlayerActivityConfig.TITLE, writeData.getTitle());
                    this.aiu.n("thread_type", "33");
                    f.a(this.aiu, writeData);
                    str3 = imagesCodeForPost;
                    break;
                case 5:
                    this.aiu.setUrl(fvV);
                    this.aiu.n("tid", writeData.getThreadId());
                    this.aiu.n("kw", writeData.getForumName());
                    this.aiu.n("is_twzhibo_thread", String.valueOf(1));
                    f.a(this.aiu, writeData);
                    str3 = imagesCodeForPost;
                    break;
                case 6:
                    this.aiu.setUrl(fvU);
                    this.aiu.n("kw", writeData.getForumName());
                    this.aiu.n("thread_type", String.valueOf(36));
                    this.aiu.n(VrPlayerActivityConfig.TITLE, writeData.getTitle());
                    this.aiu.n("is_ntitle", writeData.isNoTitle() ? "1" : "0");
                    if (writeData.isNoTitle()) {
                        this.aiu.n("st_type", "notitle");
                    }
                    f.a(this.aiu, writeData);
                    str3 = imagesCodeForPost;
                    break;
                case 7:
                    this.aiu.setUrl(fvU);
                    this.aiu.n("is_ntitle", writeData.isNoTitle() ? "1" : "0");
                    if (writeData.isNoTitle()) {
                        this.aiu.n("st_type", "notitle");
                    }
                    this.aiu.n("kw", writeData.getForumName());
                    this.aiu.n(VrPlayerActivityConfig.TITLE, writeData.getTitle());
                    this.aiu.n("product_id", new StringBuilder(String.valueOf(writeData.productId)).toString());
                    f.a(this.aiu, writeData);
                    str3 = imagesCodeForPost;
                    break;
            }
        }
        String uu = this.aiu.uu();
        rO(95);
        if (this.aiu.uS().vO().oF()) {
            this.fvX.parserJson(uu);
        } else {
            this.fvX.setError_code(this.aiu.uV() ? this.aiu.uW() : this.aiu.uX());
            this.fvX.setError_msg(this.aiu.getErrorString());
        }
        if (this.fvX.error_code != 0 && !i.gm()) {
            this.fvX.setError_msg(TbadkCoreApplication.m9getInst().getApp().getString(r.j.neterror));
        } else if (this.fvX.error_code != 0 && ((writeData.isHasImages() || writeData.getIsBaobao()) && j.isEmpty(String.valueOf(writeData.getContent()) + str3))) {
            this.fvX.setError_msg(TbadkCoreApplication.m9getInst().getApp().getString(r.j.img_upload_error));
        }
        try {
            this.fvY = new AntiData();
            this.fvY.parserJson(new JSONObject(uu).optJSONObject("anti_stat"));
        } catch (Exception e) {
        }
        rO(100);
        return uu;
    }

    private boolean rm(String str) {
        p pVar;
        if (StringUtils.isNull(str)) {
            return true;
        }
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_GRAFFITI_COMMON_MANAGER, p.class);
        return runTask == null || (pVar = (p) runTask.getData()) == null || pVar.kL(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void rO(int i) {
        if (this.fwa != null) {
            this.fwa.rP(i);
        }
    }

    public boolean oF() {
        if (this.aiu == null) {
            return false;
        }
        return this.aiu.uS().vO().oF();
    }

    public void cancel() {
        this.ayv = true;
        if (this.aiu != null) {
            this.aiu.eg();
        }
        if (this.ayi != null) {
            this.ayi.cancel();
        }
        if (this.fvZ != null) {
            this.fvZ.bkR();
        }
    }

    public AntiData bkh() {
        return this.fvY;
    }

    public ErrorData bki() {
        return this.fvX;
    }
}
