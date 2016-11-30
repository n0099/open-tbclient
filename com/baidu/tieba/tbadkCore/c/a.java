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
    private static final String fDc = String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.POST_THREAD_ADDRESS;
    private static final String fDd = String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.REPLY_THREAD_ADDRESS;
    public static final String fDe = String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.POST_THREAD_FOR_SHARE_ADDRESS;
    private c aza;
    private ErrorData fDf;
    private AntiData fDg;
    private com.baidu.tieba.tbadkCore.videoupload.a fDh;
    private InterfaceC0079a fDi;
    private z ajm = null;
    private boolean azn = false;

    /* renamed from: com.baidu.tieba.tbadkCore.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0079a {
        void sh(int i);
    }

    public a() {
        this.fDf = null;
        this.fDf = new ErrorData();
    }

    public void a(InterfaceC0079a interfaceC0079a) {
        this.fDi = interfaceC0079a;
    }

    public ImageUploadResult d(ImageFileInfo imageFileInfo, boolean z) {
        if (imageFileInfo == null) {
            return null;
        }
        if (this.aza == null) {
            this.aza = new c("HTTPWriteService.postImageData");
        }
        return this.aza.c(imageFileInfo, z);
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
        this.ajm = new z();
        this.ajm.uW().vR().mIsNeedTbs = true;
        if (writeData.getType() == 3) {
            if (writeData.getVcode() != null && writeData.getVcode().length() > 0) {
                this.ajm.n("vcode", writeData.getVcode());
            }
            if (TbadkCoreApplication.m9getInst().getNewVcodeWebviewCrashCount() < 3) {
                this.ajm.n("tag", "11");
            }
            this.ajm.n("newVcode", "1");
            this.ajm.n(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_CONTENT, writeData.getContent());
            this.ajm.setUrl(fDe);
            this.ajm.n(ImageViewerConfig.FORUM_NAME, writeData.getForumName());
            this.ajm.n(VrPlayerActivityConfig.TITLE, writeData.getTitle());
            this.ajm.n("apiKey", writeData.getShareApiKey());
            this.ajm.n("appName", writeData.getShareAppName());
            this.ajm.n("signKey", writeData.getShareSignKey());
            this.ajm.n("summary_title", writeData.getShareSummaryTitle());
            this.ajm.n("summary_content", writeData.getShareSummaryContent());
            this.ajm.n("summary_img", writeData.getShareSummaryImg());
            this.ajm.n(WriteShareActivityConfig.SHARE_SUMMARY_IMG_WIDTH, String.valueOf(writeData.getShareSummaryImgWidth()));
            this.ajm.n(WriteShareActivityConfig.SHARE_SUMMARY_IMG_HEIGHT, String.valueOf(writeData.getShareSummaryImgHeight()));
            this.ajm.n(WriteShareActivityConfig.SHARE_SUMMARY_IMG_TYPE, writeData.getShareSummaryImgType());
            this.ajm.n("referUrl", writeData.getShareReferUrl());
        } else if (!rH(writeData.getGraffitiFileName())) {
            this.fDf.setError_code(-53);
            this.fDf.setError_msg(TbadkCoreApplication.m9getInst().getString(r.j.graffiti_valid_fail));
            return null;
        } else {
            if (z && writeData.isHasImages()) {
                if (this.aza == null) {
                    this.aza = new c("HTTPWriteService.postWriteData");
                }
                if (writeData.getType() == 6) {
                    if (!this.aza.b(writeData.getWriteImagesInfo(), true)) {
                        this.fDf.setError_code(-53);
                        this.fDf.setError_msg(TbadkCoreApplication.m9getInst().getString(r.j.upload_error));
                        return null;
                    }
                } else {
                    this.aza.c(writeData.getWriteImagesInfo(), true);
                }
            }
            if (!StringUtils.isNull(writeData.getGraffitiFileName())) {
                if (this.aza == null) {
                    this.aza = new c("HTTPWriteService.postWriteData");
                }
                CustomResponsedMessage runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_GRAFFITI_COMMON_MANAGER, o.class);
                String kU = (runTask == null || runTask.getData() == null) ? null : ((o) runTask.getData()).kU(writeData.getGraffitiFileName());
                if (!StringUtils.isNull(kU)) {
                    ImageFileInfo imageFileInfo = new ImageFileInfo();
                    imageFileInfo.setFilePath(kU);
                    ImageUploadResult a = this.aza.a(imageFileInfo, true, false);
                    if (a != null) {
                        UploadedImageInfo uploadedPicInfo = a.getUploadedPicInfo();
                        writeData.setGraffitiWriteCode(d.a(uploadedPicInfo));
                        if (uploadedPicInfo != null) {
                            writeData.setGraffitiImageId(uploadedPicInfo.getPic_id());
                        }
                    }
                }
            }
            if (this.azn) {
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
                h eg = cVar.eg(r);
                if (eg != null && eg.isSuccess()) {
                    g xQ = eg.xQ();
                    if (xQ != null) {
                        returnVoiceMd5 = xQ.getMd5();
                        com.baidu.tbadk.core.voice.a.b.ah(writeData.getVoice(), returnVoiceMd5);
                        writeData.setReturnVoiceMd5(returnVoiceMd5);
                    } else {
                        l lVar = new l();
                        lVar.n("ErrCode", Integer.valueOf(eg.getErrorCode()));
                        lVar.n("ErrMsg", eg.getErrorString());
                        TiebaStatic.voiceError(TbErrInfo.ERR_VOI_SEND, "audioUploadData is null", lVar.toString());
                        this.fDf.setError_code(eg.getErrorCode());
                        this.fDf.setError_msg(eg.getErrorString());
                        return null;
                    }
                } else {
                    l lVar2 = new l();
                    lVar2.n("audioFile", r);
                    TiebaStatic.voiceError(TbErrInfo.ERR_VOI_SEND, "uploadService.upload null or fail", lVar2.toString());
                    this.fDf.setError_code(eg.getErrorCode());
                    this.fDf.setError_msg(eg.getErrorString());
                    return null;
                }
            }
            if (this.azn) {
                return null;
            }
            VideoInfo videoInfo = writeData.getVideoInfo();
            if (videoInfo != null) {
                if (videoInfo.needUploadVideo()) {
                    this.fDh = new com.baidu.tieba.tbadkCore.videoupload.a();
                    VideoFinishResult a2 = this.fDh.a(writeData.getForumId(), videoInfo.getVideoPath(), videoInfo.getVideoDuration(), new b(this));
                    if (a2 == null) {
                        this.fDf.setError_code(-53);
                        this.fDf.setError_msg(TbadkCoreApplication.m9getInst().getString(r.j.upload_error));
                        return null;
                    } else if (a2.isSuccess()) {
                        videoInfo.setVideoMd5(a2.getVideoMd5());
                        videoInfo.setVideoUrl(a2.getVideoUrl());
                    } else {
                        this.fDf.setError_code(a2.getErrorNo());
                        this.fDf.setError_msg(a2.getUserMessage());
                        return null;
                    }
                }
                if (videoInfo.needUploadThunmb()) {
                    if (this.aza == null) {
                        this.aza = new c("HTTPWriteService.postWriteData");
                    }
                    ImageUploadResult u = this.aza.u(videoInfo.getThumbPath(), false);
                    if (u != null) {
                        videoInfo.setThumbId(u.picId);
                    }
                }
            }
            if (this.azn) {
                return null;
            }
            this.ajm.n("anonymous", "1");
            this.ajm.n("fid", writeData.getForumId());
            if (returnVoiceMd5 != null) {
                this.ajm.n("voice_md5", returnVoiceMd5);
                this.ajm.n("during_time", String.valueOf(voiceDuringTime));
            }
            String imagesCodeForPost = writeData.getImagesCodeForPost();
            if (writeData.getType() != 6 && ((writeData.getType() != 0 || (writeData.getType() == 0 && TextUtils.isEmpty(writeData.getTitle()))) && TextUtils.isEmpty(returnVoiceMd5) && TextUtils.isEmpty(imagesCodeForPost) && TextUtils.isEmpty(writeData.getContent()) && writeData.getVideoInfo() == null && TextUtils.isEmpty(writeData.getGraffitiWriteCode()))) {
                this.fDf.setError_code(-53);
                this.fDf.setError_msg(TbadkCoreApplication.m9getInst().getString(r.j.sand_fail));
                return null;
            }
            if (writeData.getVcode() != null && writeData.getVcode().length() > 0) {
                this.ajm.n("vcode", writeData.getVcode());
            }
            if (!StringUtils.isNull(writeData.getVcodeMD5())) {
                this.ajm.n(GraffitiVcodeActivityConfig.VCODE_MD5, writeData.getVcodeMD5());
            }
            if (!StringUtils.isNull(writeData.getVcodeType())) {
                this.ajm.n("vcode_type", writeData.getVcodeType());
            }
            if (TbadkCoreApplication.m9getInst().getNewVcodeWebviewCrashCount() < 3) {
                this.ajm.n("vcode_tag", "12");
            }
            Address B = com.baidu.adp.lib.e.a.dU().B(false);
            this.ajm.n("new_vcode", "1");
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
            this.ajm.n(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_CONTENT, str);
            this.ajm.n("reply_uid", writeData.getReplyId());
            switch (writeData.getType()) {
                case 0:
                    this.ajm.setUrl(fDc);
                    this.ajm.n("kw", writeData.getForumName());
                    this.ajm.n(VrPlayerActivityConfig.TITLE, writeData.getTitle());
                    this.ajm.n("is_ntitle", writeData.isNoTitle() ? "1" : "0");
                    if (writeData.isNoTitle()) {
                        this.ajm.n("st_type", "notitle");
                    }
                    String hiAlbumId = writeData.getHiAlbumId();
                    if (hiAlbumId != null) {
                        this.ajm.n("17hi_album_id", hiAlbumId);
                    }
                    if (B != null && TbadkCoreApplication.m9getInst().getIsLocationOn() && !TbConfig.getPositionPagerId().equals(writeData.getForumId())) {
                        this.ajm.n("lbs", String.valueOf(String.valueOf(B.getLatitude())) + "," + String.valueOf(B.getLongitude()));
                    }
                    f.a(this.ajm, writeData);
                    if (writeData.getCategoryFrom() >= 0) {
                        this.ajm.n("fromCategoryId", String.valueOf(writeData.getCategoryFrom()));
                    }
                    if (writeData.getCategoryTo() >= 0) {
                        this.ajm.n("toCategoryId", String.valueOf(writeData.getCategoryTo()));
                        str2 = imagesCodeForPost;
                        break;
                    }
                    str2 = imagesCodeForPost;
                    break;
                case 1:
                    this.ajm.setUrl(fDd);
                    this.ajm.n("tid", writeData.getThreadId());
                    this.ajm.n("kw", writeData.getForumName());
                    this.ajm.n("is_ad", writeData.getIsAd() ? "1" : "0");
                    this.ajm.n("is_barrage", writeData.isBarrage() ? "1" : "0");
                    this.ajm.n("barrage_time", String.valueOf(writeData.getBarrageTime()));
                    if (writeData.isFrsReply()) {
                        this.ajm.n("st_param", "frs");
                    }
                    if (com.baidu.tbadk.editortools.e.b.Dp().getStatus() == 1) {
                        this.ajm.n("ptype", "4");
                    }
                    f.a(this.ajm, writeData);
                    str2 = imagesCodeForPost;
                    break;
                case 2:
                    this.ajm.setUrl(fDd);
                    this.ajm.n("tid", writeData.getThreadId());
                    this.ajm.n("kw", writeData.getForumName());
                    this.ajm.n("quote_id", String.valueOf(writeData.getFloor()));
                    this.ajm.n("is_twzhibo_thread", String.valueOf(0));
                    this.ajm.n("floor_num", String.valueOf(writeData.getFloorNum()));
                    if (writeData.getRepostId() != null) {
                        this.ajm.n("repostid", writeData.getRepostId());
                    }
                    this.ajm.n("is_ad", writeData.getIsAd() ? "1" : "0");
                    this.ajm.n("is_addition", writeData.isAddition() ? "1" : "0");
                    this.ajm.n("is_giftpost", writeData.isGiftPost() ? "1" : "0");
                    this.ajm.n("is_giftpost", writeData.isGiftPost() ? "1" : "0");
                    if (writeData.isAddition()) {
                        this.ajm.n("st_type", "conadd");
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
                    this.ajm.setUrl(fDc);
                    this.ajm.n("kw", writeData.getForumName());
                    this.ajm.n(VrPlayerActivityConfig.TITLE, writeData.getTitle());
                    this.ajm.n("thread_type", "33");
                    f.a(this.ajm, writeData);
                    str2 = imagesCodeForPost;
                    break;
                case 5:
                    this.ajm.setUrl(fDd);
                    this.ajm.n("tid", writeData.getThreadId());
                    this.ajm.n("kw", writeData.getForumName());
                    this.ajm.n("is_twzhibo_thread", String.valueOf(1));
                    f.a(this.ajm, writeData);
                    str2 = imagesCodeForPost;
                    break;
                case 6:
                    this.ajm.setUrl(fDc);
                    this.ajm.n("kw", writeData.getForumName());
                    this.ajm.n("thread_type", String.valueOf(36));
                    this.ajm.n(VrPlayerActivityConfig.TITLE, writeData.getTitle());
                    this.ajm.n("is_ntitle", writeData.isNoTitle() ? "1" : "0");
                    if (writeData.isNoTitle()) {
                        this.ajm.n("st_type", "notitle");
                    }
                    f.a(this.ajm, writeData);
                    str2 = imagesCodeForPost;
                    break;
                case 7:
                    this.ajm.setUrl(fDc);
                    this.ajm.n("is_ntitle", writeData.isNoTitle() ? "1" : "0");
                    if (writeData.isNoTitle()) {
                        this.ajm.n("st_type", "notitle");
                    }
                    this.ajm.n("kw", writeData.getForumName());
                    this.ajm.n(VrPlayerActivityConfig.TITLE, writeData.getTitle());
                    this.ajm.n("product_id", new StringBuilder(String.valueOf(writeData.productId)).toString());
                    f.a(this.ajm, writeData);
                    str2 = imagesCodeForPost;
                    break;
            }
        }
        String uy = this.ajm.uy();
        sg(95);
        if (this.ajm.uW().vS().oH()) {
            this.fDf.parserJson(uy);
        } else {
            this.fDf.setError_code(this.ajm.uZ() ? this.ajm.va() : this.ajm.vb());
            this.fDf.setError_msg(this.ajm.getErrorString());
        }
        if (this.fDf.error_code != 0 && !i.gm()) {
            this.fDf.setError_msg(TbadkCoreApplication.m9getInst().getApp().getString(r.j.neterror));
        } else if (this.fDf.error_code != 0 && writeData.isHasImages() && j.isEmpty(String.valueOf(writeData.getContent()) + str2)) {
            this.fDf.setError_msg(TbadkCoreApplication.m9getInst().getApp().getString(r.j.img_upload_error));
        }
        try {
            this.fDg = new AntiData();
            this.fDg.parserJson(new JSONObject(uy).optJSONObject("anti_stat"));
        } catch (Exception e) {
        }
        sg(100);
        return uy;
    }

    private boolean rH(String str) {
        o oVar;
        if (StringUtils.isNull(str)) {
            return true;
        }
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_GRAFFITI_COMMON_MANAGER, o.class);
        return runTask == null || (oVar = (o) runTask.getData()) == null || oVar.kW(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sg(int i) {
        if (this.fDi != null) {
            this.fDi.sh(i);
        }
    }

    public boolean oH() {
        if (this.ajm == null) {
            return false;
        }
        return this.ajm.uW().vS().oH();
    }

    public void cancel() {
        this.azn = true;
        if (this.ajm != null) {
            this.ajm.eg();
        }
        if (this.aza != null) {
            this.aza.cancel();
        }
        if (this.fDh != null) {
            this.fDh.bnh();
        }
    }

    public AntiData bmx() {
        return this.fDg;
    }

    public ErrorData bmy() {
        return this.fDf;
    }
}
