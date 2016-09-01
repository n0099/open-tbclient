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
import com.baidu.tieba.t;
import com.baidu.tieba.tbadkCore.util.p;
import com.baidu.tieba.tbadkCore.videoupload.VideoFinishResult;
import com.baidu.tieba.tbadkCore.writeModel.f;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class a {
    private static final String fto = String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.POST_THREAD_ADDRESS;
    private static final String ftp = String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.REPLY_THREAD_ADDRESS;
    public static final String ftq = String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.POST_THREAD_FOR_SHARE_ADDRESS;
    private c ayF;
    private ErrorData ftr;
    private AntiData fts;
    private com.baidu.tieba.tbadkCore.videoupload.a ftt;
    private InterfaceC0075a ftu;
    private ab aiS = null;
    private boolean ayS = false;

    /* renamed from: com.baidu.tieba.tbadkCore.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0075a {
        void rB(int i);
    }

    /* loaded from: classes.dex */
    public static class b {
        public static int ftx = 1;
    }

    public a() {
        this.ftr = null;
        this.ftr = new ErrorData();
    }

    public void a(InterfaceC0075a interfaceC0075a) {
        this.ftu = interfaceC0075a;
    }

    public ImageUploadResult d(ImageFileInfo imageFileInfo, boolean z) {
        if (imageFileInfo == null) {
            return null;
        }
        if (this.ayF == null) {
            this.ayF = new c("HTTPWriteService.postImageData");
        }
        return this.ayF.c(imageFileInfo, z);
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
        this.aiS = new ab();
        this.aiS.uD().vz().mIsNeedTbs = true;
        if (writeData.getType() == 3) {
            if (writeData.getVcode() != null && writeData.getVcode().length() > 0) {
                this.aiS.n("vcode", writeData.getVcode());
            }
            if (TbadkCoreApplication.m9getInst().getNewVcodeWebviewCrashCount() < 3) {
                this.aiS.n("tag", "11");
            }
            this.aiS.n("newVcode", "1");
            this.aiS.n(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_CONTENT, writeData.getContent());
            this.aiS.setUrl(ftq);
            this.aiS.n(ImageViewerConfig.FORUM_NAME, writeData.getForumName());
            this.aiS.n(VrPlayerActivityConfig.TITLE, writeData.getTitle());
            this.aiS.n("apiKey", writeData.getShareApiKey());
            this.aiS.n("appName", writeData.getShareAppName());
            this.aiS.n("signKey", writeData.getShareSignKey());
            this.aiS.n("summary_title", writeData.getShareSummaryTitle());
            this.aiS.n("summary_content", writeData.getShareSummaryContent());
            this.aiS.n("summary_img", writeData.getShareSummaryImg());
            this.aiS.n(WriteShareActivityConfig.SHARE_SUMMARY_IMG_WIDTH, String.valueOf(writeData.getShareSummaryImgWidth()));
            this.aiS.n(WriteShareActivityConfig.SHARE_SUMMARY_IMG_HEIGHT, String.valueOf(writeData.getShareSummaryImgHeight()));
            this.aiS.n(WriteShareActivityConfig.SHARE_SUMMARY_IMG_TYPE, writeData.getShareSummaryImgType());
            this.aiS.n("referUrl", writeData.getShareReferUrl());
        } else if (!qX(writeData.getGraffitiFileName())) {
            this.ftr.setError_code(-53);
            this.ftr.setError_msg(TbadkCoreApplication.m9getInst().getString(t.j.graffiti_valid_fail));
            return null;
        } else {
            if (z && writeData.isHasImages()) {
                if (this.ayF == null) {
                    this.ayF = new c("HTTPWriteService.postWriteData");
                }
                if (writeData.getType() == 6) {
                    if (!this.ayF.b(writeData.getWriteImagesInfo(), true)) {
                        this.ftr.setError_code(-53);
                        this.ftr.setError_msg(TbadkCoreApplication.m9getInst().getString(t.j.upload_error));
                        return null;
                    }
                } else {
                    this.ayF.c(writeData.getWriteImagesInfo(), true);
                }
            }
            if (!StringUtils.isNull(writeData.getGraffitiFileName())) {
                if (this.ayF == null) {
                    this.ayF = new c("HTTPWriteService.postWriteData");
                }
                CustomResponsedMessage runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_GRAFFITI_COMMON_MANAGER, p.class);
                String kC = (runTask == null || runTask.getData() == null) ? null : ((p) runTask.getData()).kC(writeData.getGraffitiFileName());
                if (!StringUtils.isNull(kC)) {
                    ImageFileInfo imageFileInfo = new ImageFileInfo();
                    imageFileInfo.setFilePath(kC);
                    ImageUploadResult a = this.ayF.a(imageFileInfo, true, false);
                    if (a != null) {
                        UploadedImageInfo uploadedPicInfo = a.getUploadedPicInfo();
                        writeData.setGraffitiWriteCode(d.a(uploadedPicInfo));
                        if (uploadedPicInfo != null) {
                            writeData.setGraffitiImageId(uploadedPicInfo.getPic_id());
                        }
                    }
                }
            }
            if (this.ayS) {
                return null;
            }
            if (writeData.getIsBaobao()) {
                if (this.ayF == null) {
                    this.ayF = new c("HTTPWriteService.postWriteData");
                }
                this.ayF.c(writeData.getBaobaoImagesInfo(), true);
            }
            if (this.ayS) {
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
                cVar.v("type", 1);
                String r = m.r(voice, 1);
                h eb = cVar.eb(r);
                if (eb != null && eb.isSuccess()) {
                    g xH = eb.xH();
                    if (xH != null) {
                        returnVoiceMd5 = xH.getMd5();
                        com.baidu.tbadk.core.voice.a.b.ag(writeData.getVoice(), returnVoiceMd5);
                        writeData.setReturnVoiceMd5(returnVoiceMd5);
                    } else {
                        l lVar = new l();
                        lVar.n("ErrCode", Integer.valueOf(eb.getErrorCode()));
                        lVar.n("ErrMsg", eb.getErrorString());
                        TiebaStatic.voiceError(TbErrInfo.ERR_VOI_SEND, "audioUploadData is null", lVar.toString());
                        this.ftr.setError_code(eb.getErrorCode());
                        this.ftr.setError_msg(eb.getErrorString());
                        return null;
                    }
                } else {
                    l lVar2 = new l();
                    lVar2.n("audioFile", r);
                    TiebaStatic.voiceError(TbErrInfo.ERR_VOI_SEND, "uploadService.upload null or fail", lVar2.toString());
                    this.ftr.setError_code(eb.getErrorCode());
                    this.ftr.setError_msg(eb.getErrorString());
                    return null;
                }
            }
            if (this.ayS) {
                return null;
            }
            VideoInfo videoInfo = writeData.getVideoInfo();
            if (videoInfo != null) {
                if (videoInfo.needUploadVideo()) {
                    this.ftt = new com.baidu.tieba.tbadkCore.videoupload.a();
                    VideoFinishResult a2 = this.ftt.a(writeData.getForumId(), videoInfo.getVideoPath(), new com.baidu.tieba.tbadkCore.c.b(this));
                    if (a2 == null) {
                        this.ftr.setError_code(-53);
                        this.ftr.setError_msg(TbadkCoreApplication.m9getInst().getString(t.j.upload_error));
                        return null;
                    } else if (a2.isSuccess()) {
                        videoInfo.setVideoMd5(a2.getVideoMd5());
                        videoInfo.setVideoUrl(a2.getVideoUrl());
                    } else {
                        this.ftr.setError_code(a2.getErrorNo());
                        this.ftr.setError_msg(a2.getUserMessage());
                        return null;
                    }
                }
                if (videoInfo.needUploadThunmb()) {
                    if (this.ayF == null) {
                        this.ayF = new c("HTTPWriteService.postWriteData");
                    }
                    ImageUploadResult t = this.ayF.t(videoInfo.getThumbPath(), false);
                    if (t != null) {
                        videoInfo.setThumbId(t.picId);
                    }
                }
            }
            if (this.ayS) {
                return null;
            }
            this.aiS.n("anonymous", "1");
            this.aiS.n("fid", writeData.getForumId());
            if (returnVoiceMd5 != null) {
                this.aiS.n("voice_md5", returnVoiceMd5);
                this.aiS.n("during_time", String.valueOf(voiceDuringTime));
            }
            String imagesCodeForPost = writeData.getImagesCodeForPost();
            if (writeData.getType() != 6 && ((writeData.getType() != 0 || (writeData.getType() == 0 && TextUtils.isEmpty(writeData.getTitle()))) && TextUtils.isEmpty(returnVoiceMd5) && TextUtils.isEmpty(imagesCodeForPost) && TextUtils.isEmpty(writeData.getContent()) && writeData.getVideoInfo() == null && TextUtils.isEmpty(writeData.getGraffitiWriteCode()))) {
                this.ftr.setError_code(-53);
                this.ftr.setError_msg(TbadkCoreApplication.m9getInst().getString(t.j.sand_fail));
                return null;
            }
            if (writeData.getVcode() != null && writeData.getVcode().length() > 0) {
                this.aiS.n("vcode", writeData.getVcode());
            }
            if (!StringUtils.isNull(writeData.getVcodeMD5())) {
                this.aiS.n(GraffitiVcodeActivityConfig.VCODE_MD5, writeData.getVcodeMD5());
            }
            if (!StringUtils.isNull(writeData.getVcodeType())) {
                this.aiS.n("vcode_type", writeData.getVcodeType());
            }
            if (TbadkCoreApplication.m9getInst().getNewVcodeWebviewCrashCount() < 3) {
                this.aiS.n("vcode_tag", "12");
            }
            Address B = com.baidu.adp.lib.e.a.dU().B(false);
            this.aiS.n("new_vcode", "1");
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
            this.aiS.n(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_CONTENT, str);
            this.aiS.n("reply_uid", writeData.getReplyId());
            if (writeData.getIsBaobaoImageUploaded()) {
                this.aiS.n("tail_type", String.valueOf(b.ftx));
                this.aiS.n("tail_content", writeData.getBaobaoContent());
                writeData.setBabaoPosted(true);
            } else {
                writeData.setBabaoPosted(false);
            }
            switch (writeData.getType()) {
                case 0:
                    this.aiS.setUrl(fto);
                    this.aiS.n("kw", writeData.getForumName());
                    this.aiS.n(VrPlayerActivityConfig.TITLE, writeData.getTitle());
                    this.aiS.n("is_ntitle", writeData.isNoTitle() ? "1" : "0");
                    if (writeData.isNoTitle()) {
                        this.aiS.n("st_type", "notitle");
                    }
                    String hiAlbumId = writeData.getHiAlbumId();
                    if (hiAlbumId != null) {
                        this.aiS.n("17hi_album_id", hiAlbumId);
                    }
                    if (B != null && TbadkCoreApplication.m9getInst().getIsLocationOn() && !TbConfig.getPositionPagerId().equals(writeData.getForumId())) {
                        this.aiS.n("lbs", String.valueOf(String.valueOf(B.getLatitude())) + "," + String.valueOf(B.getLongitude()));
                    }
                    f.a(this.aiS, writeData);
                    if (writeData.getCategoryFrom() >= 0) {
                        this.aiS.n("fromCategoryId", String.valueOf(writeData.getCategoryFrom()));
                    }
                    if (writeData.getCategoryTo() >= 0) {
                        this.aiS.n("toCategoryId", String.valueOf(writeData.getCategoryTo()));
                        str2 = imagesCodeForPost;
                        break;
                    }
                    str2 = imagesCodeForPost;
                    break;
                case 1:
                    this.aiS.setUrl(ftp);
                    this.aiS.n("tid", writeData.getThreadId());
                    this.aiS.n("kw", writeData.getForumName());
                    this.aiS.n("is_ad", writeData.getIsAd() ? "1" : "0");
                    this.aiS.n("is_barrage", writeData.isBarrage() ? "1" : "0");
                    this.aiS.n("barrage_time", String.valueOf(writeData.getBarrageTime()));
                    if (writeData.isFrsReply()) {
                        this.aiS.n("st_param", "frs");
                    }
                    if (com.baidu.tbadk.editortools.d.b.Dh().getStatus() == 1) {
                        this.aiS.n("ptype", "4");
                    }
                    f.a(this.aiS, writeData);
                    str2 = imagesCodeForPost;
                    break;
                case 2:
                    this.aiS.setUrl(ftp);
                    this.aiS.n("tid", writeData.getThreadId());
                    this.aiS.n("kw", writeData.getForumName());
                    this.aiS.n("quote_id", String.valueOf(writeData.getFloor()));
                    this.aiS.n("is_twzhibo_thread", String.valueOf(0));
                    this.aiS.n("floor_num", String.valueOf(writeData.getFloorNum()));
                    if (writeData.getRepostId() != null) {
                        this.aiS.n("repostid", writeData.getRepostId());
                    }
                    this.aiS.n("is_ad", writeData.getIsAd() ? "1" : "0");
                    this.aiS.n("is_addition", writeData.isAddition() ? "1" : "0");
                    this.aiS.n("is_giftpost", writeData.isGiftPost() ? "1" : "0");
                    this.aiS.n("is_giftpost", writeData.isGiftPost() ? "1" : "0");
                    if (writeData.isAddition()) {
                        this.aiS.n("st_type", "conadd");
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
                    this.aiS.setUrl(fto);
                    this.aiS.n("kw", writeData.getForumName());
                    this.aiS.n(VrPlayerActivityConfig.TITLE, writeData.getTitle());
                    this.aiS.n("thread_type", "33");
                    f.a(this.aiS, writeData);
                    str2 = imagesCodeForPost;
                    break;
                case 5:
                    this.aiS.setUrl(ftp);
                    this.aiS.n("tid", writeData.getThreadId());
                    this.aiS.n("kw", writeData.getForumName());
                    this.aiS.n("is_twzhibo_thread", String.valueOf(1));
                    f.a(this.aiS, writeData);
                    str2 = imagesCodeForPost;
                    break;
                case 6:
                    this.aiS.setUrl(fto);
                    this.aiS.n("kw", writeData.getForumName());
                    this.aiS.n("thread_type", String.valueOf(36));
                    this.aiS.n(VrPlayerActivityConfig.TITLE, writeData.getTitle());
                    this.aiS.n("is_ntitle", writeData.isNoTitle() ? "1" : "0");
                    if (writeData.isNoTitle()) {
                        this.aiS.n("st_type", "notitle");
                    }
                    f.a(this.aiS, writeData);
                    str2 = imagesCodeForPost;
                    break;
                case 7:
                    this.aiS.setUrl(fto);
                    this.aiS.n("is_ntitle", writeData.isNoTitle() ? "1" : "0");
                    if (writeData.isNoTitle()) {
                        this.aiS.n("st_type", "notitle");
                    }
                    this.aiS.n("kw", writeData.getForumName());
                    this.aiS.n(VrPlayerActivityConfig.TITLE, writeData.getTitle());
                    this.aiS.n("product_id", new StringBuilder(String.valueOf(writeData.productId)).toString());
                    f.a(this.aiS, writeData);
                    str2 = imagesCodeForPost;
                    break;
            }
        }
        String ue = this.aiS.ue();
        rA(95);
        if (this.aiS.uD().vA().oE()) {
            this.ftr.parserJson(ue);
        } else {
            this.ftr.setError_code(this.aiS.uG() ? this.aiS.uH() : this.aiS.uI());
            this.ftr.setError_msg(this.aiS.getErrorString());
        }
        if (this.ftr.error_code != 0 && !i.gm()) {
            this.ftr.setError_msg(TbadkCoreApplication.m9getInst().getApp().getString(t.j.neterror));
        } else if (this.ftr.error_code != 0 && ((writeData.isHasImages() || writeData.getIsBaobao()) && j.isEmpty(String.valueOf(writeData.getContent()) + str2))) {
            this.ftr.setError_msg(TbadkCoreApplication.m9getInst().getApp().getString(t.j.img_upload_error));
        }
        try {
            this.fts = new AntiData();
            this.fts.parserJson(new JSONObject(ue).optJSONObject("anti_stat"));
        } catch (Exception e) {
        }
        rA(100);
        return ue;
    }

    private boolean qX(String str) {
        p pVar;
        if (StringUtils.isNull(str)) {
            return true;
        }
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_GRAFFITI_COMMON_MANAGER, p.class);
        return runTask == null || (pVar = (p) runTask.getData()) == null || pVar.kE(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void rA(int i) {
        if (this.ftu != null) {
            this.ftu.rB(i);
        }
    }

    public boolean oE() {
        if (this.aiS == null) {
            return false;
        }
        return this.aiS.uD().vA().oE();
    }

    public void cancel() {
        this.ayS = true;
        if (this.aiS != null) {
            this.aiS.eg();
        }
        if (this.ayF != null) {
            this.ayF.cancel();
        }
        if (this.ftt != null) {
            this.ftt.bkf();
        }
    }

    public AntiData bjv() {
        return this.fts;
    }

    public ErrorData bjw() {
        return this.ftr;
    }
}
