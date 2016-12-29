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
import com.baidu.tbadk.core.atomData.WriteActivityConfig;
import com.baidu.tbadk.core.atomData.WriteShareActivityConfig;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.ErrorData;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TbErrInfo;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.l;
import com.baidu.tbadk.core.util.m;
import com.baidu.tbadk.core.util.z;
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
import com.baidu.tieba.tbadkCore.util.o;
import com.baidu.tieba.tbadkCore.videoupload.VideoFinishResult;
import com.baidu.tieba.tbadkCore.writeModel.f;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class a {
    private static final String fhg = String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.POST_THREAD_ADDRESS;
    private static final String fhh = String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.REPLY_THREAD_ADDRESS;
    public static final String fhi = String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.POST_THREAD_FOR_SHARE_ADDRESS;
    private z aiN = null;
    private boolean ayK = false;
    private c ayx;
    private ErrorData fhj;
    private AntiData fhk;
    private com.baidu.tieba.tbadkCore.videoupload.a fhl;
    private InterfaceC0073a fhm;

    /* renamed from: com.baidu.tieba.tbadkCore.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0073a {
        void rk(int i);
    }

    public a() {
        this.fhj = null;
        this.fhj = new ErrorData();
    }

    public void a(InterfaceC0073a interfaceC0073a) {
        this.fhm = interfaceC0073a;
    }

    public ImageUploadResult d(ImageFileInfo imageFileInfo, boolean z) {
        if (imageFileInfo == null) {
            return null;
        }
        if (this.ayx == null) {
            this.ayx = new c("HTTPWriteService.postImageData");
        }
        return this.ayx.c(imageFileInfo, z);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public String a(WriteData writeData, boolean z) {
        String returnVoiceMd5;
        boolean z2;
        String str;
        String str2 = null;
        if (writeData == null) {
            return null;
        }
        this.aiN = new z();
        this.aiN.uI().vB().mIsNeedTbs = true;
        if (writeData.getType() == 3) {
            if (writeData.getVcode() != null && writeData.getVcode().length() > 0) {
                this.aiN.n("vcode", writeData.getVcode());
            }
            if (TbadkCoreApplication.m9getInst().getNewVcodeWebviewCrashCount() < 3) {
                this.aiN.n("tag", "11");
            }
            this.aiN.n("newVcode", "1");
            this.aiN.n(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_CONTENT, writeData.getContent());
            this.aiN.setUrl(fhi);
            this.aiN.n(ImageViewerConfig.FORUM_NAME, writeData.getForumName());
            this.aiN.n(VrPlayerActivityConfig.TITLE, writeData.getTitle());
            this.aiN.n("apiKey", writeData.getShareApiKey());
            this.aiN.n("appName", writeData.getShareAppName());
            this.aiN.n("signKey", writeData.getShareSignKey());
            this.aiN.n("summary_title", writeData.getShareSummaryTitle());
            this.aiN.n("summary_content", writeData.getShareSummaryContent());
            this.aiN.n("summary_img", writeData.getShareSummaryImg());
            this.aiN.n(WriteShareActivityConfig.SHARE_SUMMARY_IMG_WIDTH, String.valueOf(writeData.getShareSummaryImgWidth()));
            this.aiN.n(WriteShareActivityConfig.SHARE_SUMMARY_IMG_HEIGHT, String.valueOf(writeData.getShareSummaryImgHeight()));
            this.aiN.n(WriteShareActivityConfig.SHARE_SUMMARY_IMG_TYPE, writeData.getShareSummaryImgType());
            this.aiN.n("referUrl", writeData.getShareReferUrl());
        } else if (!ql(writeData.getGraffitiFileName())) {
            this.fhj.setError_code(-53);
            this.fhj.setError_msg(TbadkCoreApplication.m9getInst().getString(r.j.graffiti_valid_fail));
            return null;
        } else {
            if (z && writeData.isHasImages()) {
                if (this.ayx == null) {
                    this.ayx = new c("HTTPWriteService.postWriteData");
                }
                if (writeData.getType() == 6) {
                    if (!this.ayx.b(writeData.getWriteImagesInfo(), true)) {
                        this.fhj.setError_code(-53);
                        this.fhj.setError_msg(TbadkCoreApplication.m9getInst().getString(r.j.upload_error));
                        return null;
                    }
                } else {
                    this.ayx.c(writeData.getWriteImagesInfo(), true);
                }
            }
            if (!StringUtils.isNull(writeData.getGraffitiFileName())) {
                if (this.ayx == null) {
                    this.ayx = new c("HTTPWriteService.postWriteData");
                }
                CustomResponsedMessage runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_GRAFFITI_COMMON_MANAGER, o.class);
                String jy = (runTask == null || runTask.getData() == null) ? null : ((o) runTask.getData()).jy(writeData.getGraffitiFileName());
                if (!StringUtils.isNull(jy)) {
                    ImageFileInfo imageFileInfo = new ImageFileInfo();
                    imageFileInfo.setFilePath(jy);
                    ImageUploadResult a = this.ayx.a(imageFileInfo, true, false);
                    if (a != null) {
                        UploadedImageInfo uploadedPicInfo = a.getUploadedPicInfo();
                        writeData.setGraffitiWriteCode(d.a(uploadedPicInfo));
                        if (uploadedPicInfo != null) {
                            writeData.setGraffitiImageId(uploadedPicInfo.getPic_id());
                        }
                    }
                }
            }
            if (this.ayK) {
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
                com.baidu.tbadk.core.voice.service.c cVar = new com.baidu.tbadk.core.voice.service.c(TbConfig.UPLOAD_CHUNK_AUDIO_ADDRESS, TbConfig.FINISH_UPLOAD_CHUNK_AUDIO_ADDRESS);
                cVar.u("type", 1);
                String r = m.r(voice, 1);
                h ed = cVar.ed(r);
                if (ed != null && ed.isSuccess()) {
                    g xE = ed.xE();
                    if (xE != null) {
                        returnVoiceMd5 = xE.getMd5();
                        com.baidu.tbadk.core.voice.a.b.ah(writeData.getVoice(), returnVoiceMd5);
                        writeData.setReturnVoiceMd5(returnVoiceMd5);
                    } else {
                        l lVar = new l();
                        lVar.n("ErrCode", Integer.valueOf(ed.getErrorCode()));
                        lVar.n("ErrMsg", ed.getErrorString());
                        TiebaStatic.voiceError(TbErrInfo.ERR_VOI_SEND, "audioUploadData is null", lVar.toString());
                        this.fhj.setError_code(ed.getErrorCode());
                        this.fhj.setError_msg(ed.getErrorString());
                        return null;
                    }
                } else {
                    l lVar2 = new l();
                    lVar2.n("audioFile", r);
                    TiebaStatic.voiceError(TbErrInfo.ERR_VOI_SEND, "uploadService.upload null or fail", lVar2.toString());
                    this.fhj.setError_code(ed.getErrorCode());
                    this.fhj.setError_msg(ed.getErrorString());
                    return null;
                }
            }
            if (this.ayK) {
                return null;
            }
            VideoInfo videoInfo = writeData.getVideoInfo();
            if (videoInfo != null) {
                if (videoInfo.needUploadVideo()) {
                    this.fhl = new com.baidu.tieba.tbadkCore.videoupload.a();
                    VideoFinishResult a2 = this.fhl.a(writeData.getForumId(), videoInfo.getVideoPath(), videoInfo.getVideoDuration(), new b(this));
                    if (a2 == null) {
                        this.fhj.setError_code(-53);
                        this.fhj.setError_msg(TbadkCoreApplication.m9getInst().getString(r.j.upload_error));
                        return null;
                    } else if (a2.isSuccess()) {
                        videoInfo.setVideoMd5(a2.getVideoMd5());
                        videoInfo.setVideoUrl(a2.getVideoUrl());
                    } else {
                        this.fhj.setError_code(a2.getErrorNo());
                        this.fhj.setError_msg(a2.getUserMessage());
                        return null;
                    }
                }
                if (videoInfo.needUploadThunmb()) {
                    if (this.ayx == null) {
                        this.ayx = new c("HTTPWriteService.postWriteData");
                    }
                    ImageUploadResult u = this.ayx.u(videoInfo.getThumbPath(), false);
                    if (u != null) {
                        videoInfo.setThumbId(u.picId);
                    }
                }
            }
            if (this.ayK) {
                return null;
            }
            this.aiN.n("anonymous", "1");
            this.aiN.n("fid", writeData.getForumId());
            if (returnVoiceMd5 != null) {
                this.aiN.n("voice_md5", returnVoiceMd5);
                this.aiN.n("during_time", String.valueOf(voiceDuringTime));
            }
            String imagesCodeForPost = writeData.getImagesCodeForPost();
            if (writeData.getType() != 6 && ((writeData.getType() != 0 || (writeData.getType() == 0 && TextUtils.isEmpty(writeData.getTitle()))) && TextUtils.isEmpty(returnVoiceMd5) && TextUtils.isEmpty(imagesCodeForPost) && TextUtils.isEmpty(writeData.getContent()) && writeData.getVideoInfo() == null && TextUtils.isEmpty(writeData.getGraffitiWriteCode()))) {
                this.fhj.setError_code(-53);
                this.fhj.setError_msg(TbadkCoreApplication.m9getInst().getString(r.j.sand_fail));
                return null;
            }
            if (writeData.getVcode() != null && writeData.getVcode().length() > 0) {
                this.aiN.n("vcode", writeData.getVcode());
            }
            if (!StringUtils.isNull(writeData.getVcodeMD5())) {
                this.aiN.n(GraffitiVcodeActivityConfig.VCODE_MD5, writeData.getVcodeMD5());
            }
            if (!StringUtils.isNull(writeData.getVcodeType())) {
                this.aiN.n("vcode_type", writeData.getVcodeType());
            }
            if (TbadkCoreApplication.m9getInst().getNewVcodeWebviewCrashCount() < 3) {
                this.aiN.n("vcode_tag", "12");
            }
            Address B = com.baidu.adp.lib.e.a.dU().B(false);
            this.aiN.n("new_vcode", "1");
            if (writeData.getVideoInfo() == null || !writeData.getVideoInfo().hasUpload()) {
                str = String.valueOf(writeData.getContent()) + imagesCodeForPost;
            } else {
                str = String.valueOf(writeData.getContent()) + writeData.getVideoInfo().buildContent() + imagesCodeForPost;
            }
            if (!StringUtils.isNull(writeData.getGraffitiWriteCode())) {
                str = String.valueOf(str) + writeData.getGraffitiWriteCode();
            }
            if (writeData.getType() == 6 && writeData.getVoteInfo() != null) {
                if (writeData.getWriteImagesInfo() != null) {
                    writeData.getVoteInfo().setServerImageCode(writeData.getWriteImagesInfo().getChosedFiles());
                }
                str = writeData.getVoteInfo().buildWriteContent();
            }
            this.aiN.n(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_CONTENT, str);
            this.aiN.n("reply_uid", writeData.getReplyId());
            switch (writeData.getType()) {
                case 0:
                    this.aiN.setUrl(fhg);
                    this.aiN.n("kw", writeData.getForumName());
                    this.aiN.n(VrPlayerActivityConfig.TITLE, writeData.getTitle());
                    this.aiN.n("is_ntitle", writeData.isNoTitle() ? "1" : "0");
                    if (writeData.isNoTitle()) {
                        this.aiN.n("st_type", "notitle");
                    }
                    if (B != null && TbadkCoreApplication.m9getInst().getIsLocationOn() && !TbConfig.getPositionPagerId().equals(writeData.getForumId())) {
                        this.aiN.n("lbs", String.valueOf(String.valueOf(B.getLatitude())) + "," + String.valueOf(B.getLongitude()));
                    }
                    f.a(this.aiN, writeData);
                    if (writeData.getCategoryFrom() >= 0) {
                        this.aiN.n("fromCategoryId", String.valueOf(writeData.getCategoryFrom()));
                    }
                    if (writeData.getCategoryTo() >= 0) {
                        this.aiN.n("toCategoryId", String.valueOf(writeData.getCategoryTo()));
                        str2 = imagesCodeForPost;
                        break;
                    }
                    str2 = imagesCodeForPost;
                    break;
                case 1:
                    this.aiN.setUrl(fhh);
                    this.aiN.n("tid", writeData.getThreadId());
                    this.aiN.n("kw", writeData.getForumName());
                    this.aiN.n("is_ad", writeData.getIsAd() ? "1" : "0");
                    this.aiN.n("is_barrage", writeData.isBarrage() ? "1" : "0");
                    this.aiN.n("barrage_time", String.valueOf(writeData.getBarrageTime()));
                    if (writeData.isFrsReply()) {
                        this.aiN.n("st_param", "frs");
                    }
                    if (com.baidu.tbadk.editortools.e.b.CY().getStatus() == 1) {
                        this.aiN.n("ptype", "4");
                    }
                    f.a(this.aiN, writeData);
                    str2 = imagesCodeForPost;
                    break;
                case 2:
                    this.aiN.setUrl(fhh);
                    this.aiN.n("tid", writeData.getThreadId());
                    this.aiN.n("kw", writeData.getForumName());
                    this.aiN.n("quote_id", String.valueOf(writeData.getFloor()));
                    this.aiN.n("is_twzhibo_thread", String.valueOf(0));
                    this.aiN.n("floor_num", String.valueOf(writeData.getFloorNum()));
                    if (writeData.getRepostId() != null) {
                        this.aiN.n("repostid", writeData.getRepostId());
                    }
                    this.aiN.n("is_ad", writeData.getIsAd() ? "1" : "0");
                    this.aiN.n(WriteActivityConfig.IS_ADDITION, writeData.isAddition() ? "1" : "0");
                    this.aiN.n("is_giftpost", writeData.isGiftPost() ? "1" : "0");
                    this.aiN.n("is_giftpost", writeData.isGiftPost() ? "1" : "0");
                    if (writeData.isAddition()) {
                        this.aiN.n("st_type", "conadd");
                        str2 = imagesCodeForPost;
                        break;
                    }
                    str2 = imagesCodeForPost;
                    break;
                case 3:
                default:
                    str2 = imagesCodeForPost;
                    break;
                case 4:
                    this.aiN.setUrl(fhg);
                    this.aiN.n("kw", writeData.getForumName());
                    this.aiN.n(VrPlayerActivityConfig.TITLE, writeData.getTitle());
                    this.aiN.n("thread_type", "33");
                    f.a(this.aiN, writeData);
                    str2 = imagesCodeForPost;
                    break;
                case 5:
                    this.aiN.setUrl(fhh);
                    this.aiN.n("tid", writeData.getThreadId());
                    this.aiN.n("kw", writeData.getForumName());
                    this.aiN.n("is_twzhibo_thread", String.valueOf(1));
                    f.a(this.aiN, writeData);
                    str2 = imagesCodeForPost;
                    break;
                case 6:
                    this.aiN.setUrl(fhg);
                    this.aiN.n("kw", writeData.getForumName());
                    this.aiN.n("thread_type", String.valueOf(36));
                    this.aiN.n(VrPlayerActivityConfig.TITLE, writeData.getTitle());
                    this.aiN.n("is_ntitle", writeData.isNoTitle() ? "1" : "0");
                    if (writeData.isNoTitle()) {
                        this.aiN.n("st_type", "notitle");
                    }
                    f.a(this.aiN, writeData);
                    str2 = imagesCodeForPost;
                    break;
            }
        }
        String uk = this.aiN.uk();
        rj(95);
        if (this.aiN.uI().vC().oH()) {
            this.fhj.parserJson(uk);
        } else {
            this.fhj.setError_code(this.aiN.uL() ? this.aiN.uM() : this.aiN.uN());
            this.fhj.setError_msg(this.aiN.getErrorString());
        }
        if (this.fhj.error_code != 0 && !i.gm()) {
            this.fhj.setError_msg(TbadkCoreApplication.m9getInst().getApp().getString(r.j.neterror));
        } else if (this.fhj.error_code != 0 && writeData.isHasImages() && j.isEmpty(String.valueOf(writeData.getContent()) + str2)) {
            this.fhj.setError_msg(TbadkCoreApplication.m9getInst().getApp().getString(r.j.img_upload_error));
        }
        try {
            this.fhk = new AntiData();
            this.fhk.parserJson(new JSONObject(uk).optJSONObject("anti_stat"));
        } catch (Exception e) {
        }
        rj(100);
        return uk;
    }

    private boolean ql(String str) {
        o oVar;
        if (StringUtils.isNull(str)) {
            return true;
        }
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_GRAFFITI_COMMON_MANAGER, o.class);
        return runTask == null || (oVar = (o) runTask.getData()) == null || oVar.jA(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void rj(int i) {
        if (this.fhm != null) {
            this.fhm.rk(i);
        }
    }

    public boolean oH() {
        if (this.aiN == null) {
            return false;
        }
        return this.aiN.uI().vC().oH();
    }

    public void cancel() {
        this.ayK = true;
        if (this.aiN != null) {
            this.aiN.eg();
        }
        if (this.ayx != null) {
            this.ayx.cancel();
        }
        if (this.fhl != null) {
            this.fhl.bhb();
        }
    }

    public AntiData bgm() {
        return this.fhk;
    }

    public ErrorData bgn() {
        return this.fhj;
    }
}
