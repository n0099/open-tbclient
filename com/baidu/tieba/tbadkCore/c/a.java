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
import com.baidu.tbadk.core.atomData.CommonVcodeActivityConfig;
import com.baidu.tbadk.core.atomData.CreateGroupActivityActivityConfig;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.atomData.WriteActivityConfig;
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
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tbadk.img.ImageUploadResult;
import com.baidu.tbadk.img.UploadedImageInfo;
import com.baidu.tbadk.img.c;
import com.baidu.tieba.graffiti.d;
import com.baidu.tieba.t;
import com.baidu.tieba.tbadkCore.util.p;
import com.baidu.tieba.tbadkCore.videoupload.VideoFinishResult;
import com.baidu.tieba.tbadkCore.writeModel.e;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class a {
    private static final String eqp = String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.POST_THREAD_ADDRESS;
    private static final String eqq = String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.REPLY_THREAD_ADDRESS;
    public static final String eqr = String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.POST_THREAD_FOR_SHARE_ADDRESS;
    private c axS;
    private ErrorData eqs;
    private AntiData eqt;
    private com.baidu.tieba.tbadkCore.videoupload.a equ;
    private InterfaceC0082a eqv;
    private ab aiW = null;
    private boolean ayf = false;

    /* renamed from: com.baidu.tieba.tbadkCore.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0082a {
        void pw(int i);
    }

    /* loaded from: classes.dex */
    public static class b {
        public static int eqy = 1;
    }

    public a() {
        this.eqs = null;
        this.eqs = new ErrorData();
    }

    public void a(InterfaceC0082a interfaceC0082a) {
        this.eqv = interfaceC0082a;
    }

    public ImageUploadResult d(ImageFileInfo imageFileInfo, boolean z) {
        if (imageFileInfo == null) {
            return null;
        }
        if (this.axS == null) {
            this.axS = new c("HTTPWriteService.postImageData");
        }
        return this.axS.c(imageFileInfo, z);
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
        this.aiW = new ab();
        this.aiW.vU().wO().mIsNeedTbs = true;
        if (writeData.getType() == 3) {
            if (writeData.getVcode() != null && writeData.getVcode().length() > 0) {
                this.aiW.p("vcode", writeData.getVcode());
            }
            if (TbadkCoreApplication.m411getInst().getNewVcodeWebviewCrashCount() < 3) {
                this.aiW.p("tag", "11");
            }
            this.aiW.p("newVcode", "1");
            this.aiW.p(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_CONTENT, writeData.getContent());
            this.aiW.setUrl(eqr);
            this.aiW.p(ImageViewerConfig.FORUM_NAME, writeData.getForumName());
            this.aiW.p("title", writeData.getTitle());
            this.aiW.p("apiKey", writeData.getShareApiKey());
            this.aiW.p("appName", writeData.getShareAppName());
            this.aiW.p("signKey", writeData.getShareSignKey());
            this.aiW.p("summary_title", writeData.getShareSummaryTitle());
            this.aiW.p("summary_content", writeData.getShareSummaryContent());
            this.aiW.p("summary_img", writeData.getShareSummaryImg());
            this.aiW.p(WriteShareActivityConfig.SHARE_SUMMARY_IMG_WIDTH, String.valueOf(writeData.getShareSummaryImgWidth()));
            this.aiW.p(WriteShareActivityConfig.SHARE_SUMMARY_IMG_HEIGHT, String.valueOf(writeData.getShareSummaryImgHeight()));
            this.aiW.p(WriteShareActivityConfig.SHARE_SUMMARY_IMG_TYPE, writeData.getShareSummaryImgType());
            this.aiW.p("referUrl", writeData.getShareReferUrl());
        } else if (!nW(writeData.getGraffitiFileName())) {
            this.eqs.setError_code(-53);
            this.eqs.setError_msg(TbadkCoreApplication.m411getInst().getString(t.j.graffiti_valid_fail));
            return null;
        } else {
            if (z && writeData.isHasImages()) {
                if (this.axS == null) {
                    this.axS = new c("HTTPWriteService.postWriteData");
                }
                if (writeData.getType() == 6) {
                    if (!this.axS.b(writeData.getWriteImagesInfo(), true)) {
                        this.eqs.setError_code(-53);
                        this.eqs.setError_msg(TbadkCoreApplication.m411getInst().getString(t.j.upload_error));
                        return null;
                    }
                } else {
                    this.axS.c(writeData.getWriteImagesInfo(), true);
                }
            }
            if (!StringUtils.isNull(writeData.getGraffitiFileName())) {
                if (this.axS == null) {
                    this.axS = new c("HTTPWriteService.postWriteData");
                }
                CustomResponsedMessage runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_GRAFFITI_COMMON_MANAGER, p.class);
                String iA = (runTask == null || runTask.getData() == null) ? null : ((p) runTask.getData()).iA(writeData.getGraffitiFileName());
                if (!StringUtils.isNull(iA)) {
                    ImageFileInfo imageFileInfo = new ImageFileInfo();
                    imageFileInfo.setFilePath(iA);
                    ImageUploadResult a = this.axS.a(imageFileInfo, true, false);
                    if (a != null) {
                        UploadedImageInfo uploadedPicInfo = a.getUploadedPicInfo();
                        writeData.setGraffitiWriteCode(d.a(uploadedPicInfo));
                        if (uploadedPicInfo != null) {
                            writeData.setGraffitiId(uploadedPicInfo.getPic_id());
                        }
                    }
                }
            }
            if (this.ayf) {
                return null;
            }
            if (writeData.getIsBaobao()) {
                if (this.axS == null) {
                    this.axS = new c("HTTPWriteService.postWriteData");
                }
                this.axS.c(writeData.getBaobaoImagesInfo(), true);
            }
            if (this.ayf) {
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
                cVar.t("type", 1);
                String q = m.q(voice, 1);
                com.baidu.tbadk.coreExtra.data.d dZ = cVar.dZ(q);
                if (dZ != null && dZ.isSuccess()) {
                    com.baidu.tbadk.coreExtra.data.c yA = dZ.yA();
                    if (yA != null) {
                        returnVoiceMd5 = yA.getMd5();
                        com.baidu.tbadk.core.voice.a.b.ah(writeData.getVoice(), returnVoiceMd5);
                        writeData.setReturnVoiceMd5(returnVoiceMd5);
                    } else {
                        l lVar = new l();
                        lVar.h("ErrCode", Integer.valueOf(dZ.getErrorCode()));
                        lVar.h("ErrMsg", dZ.getErrorString());
                        TiebaStatic.voiceError(TbErrInfo.ERR_VOI_SEND, "audioUploadData is null", lVar.toString());
                        this.eqs.setError_code(dZ.getErrorCode());
                        this.eqs.setError_msg(dZ.getErrorString());
                        return null;
                    }
                } else {
                    l lVar2 = new l();
                    lVar2.h("audioFile", q);
                    TiebaStatic.voiceError(TbErrInfo.ERR_VOI_SEND, "uploadService.upload null or fail", lVar2.toString());
                    this.eqs.setError_code(dZ.getErrorCode());
                    this.eqs.setError_msg(dZ.getErrorString());
                    return null;
                }
            }
            if (this.ayf) {
                return null;
            }
            VideoInfo videoInfo = writeData.getVideoInfo();
            if (videoInfo != null) {
                if (videoInfo.needUploadVideo()) {
                    this.equ = new com.baidu.tieba.tbadkCore.videoupload.a();
                    VideoFinishResult a2 = this.equ.a(writeData.getForumId(), videoInfo.getVideoPath(), new com.baidu.tieba.tbadkCore.c.b(this));
                    if (a2 == null) {
                        this.eqs.setError_code(-53);
                        this.eqs.setError_msg(TbadkCoreApplication.m411getInst().getString(t.j.upload_error));
                        return null;
                    } else if (a2.isSuccess()) {
                        videoInfo.setVideoMd5(a2.getVideoMd5());
                        videoInfo.setVideoUrl(a2.getVideoUrl());
                    } else {
                        this.eqs.setError_code(a2.getErrorNo());
                        this.eqs.setError_msg(a2.getUserMessage());
                        return null;
                    }
                }
                if (videoInfo.needUploadThunmb()) {
                    if (this.axS == null) {
                        this.axS = new c("HTTPWriteService.postWriteData");
                    }
                    ImageUploadResult r = this.axS.r(videoInfo.getThumbPath(), false);
                    if (r != null) {
                        videoInfo.setThumbId(r.picId);
                    }
                }
            }
            if (this.ayf) {
                return null;
            }
            this.aiW.p("anonymous", "1");
            this.aiW.p("fid", writeData.getForumId());
            if (returnVoiceMd5 != null) {
                this.aiW.p("voice_md5", returnVoiceMd5);
                this.aiW.p("during_time", String.valueOf(voiceDuringTime));
            }
            String imagesCodeForPost = writeData.getImagesCodeForPost();
            if (writeData.getType() != 6 && ((writeData.getType() != 0 || (writeData.getType() == 0 && TextUtils.isEmpty(writeData.getTitle()))) && TextUtils.isEmpty(returnVoiceMd5) && TextUtils.isEmpty(imagesCodeForPost) && TextUtils.isEmpty(writeData.getContent()) && writeData.getVideoInfo() == null && TextUtils.isEmpty(writeData.getGraffitiWriteCode()))) {
                this.eqs.setError_code(-53);
                this.eqs.setError_msg(TbadkCoreApplication.m411getInst().getString(t.j.sand_fail));
                return null;
            }
            if (writeData.getVcode() != null && writeData.getVcode().length() > 0) {
                this.aiW.p("vcode", writeData.getVcode());
            }
            if (!StringUtils.isNull(writeData.getVcodeMD5())) {
                this.aiW.p(CommonVcodeActivityConfig.VCODE_MD5, writeData.getVcodeMD5());
            }
            if (TbadkCoreApplication.m411getInst().getNewVcodeWebviewCrashCount() < 3) {
                this.aiW.p("vcode_tag", "11");
            }
            Address x = com.baidu.adp.lib.e.a.gL().x(false);
            this.aiW.p("new_vcode", "1");
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
            this.aiW.p(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_CONTENT, str);
            this.aiW.p("reply_uid", writeData.getReplyId());
            if (writeData.getIsBaobaoImageUploaded()) {
                this.aiW.p("tail_type", String.valueOf(b.eqy));
                this.aiW.p("tail_content", writeData.getBaobaoContent());
                writeData.setBabaoPosted(true);
            } else {
                writeData.setBabaoPosted(false);
            }
            switch (writeData.getType()) {
                case 0:
                    this.aiW.setUrl(eqp);
                    this.aiW.p("kw", writeData.getForumName());
                    this.aiW.p("title", writeData.getTitle());
                    this.aiW.p("is_ntitle", writeData.isNoTitle() ? "1" : "0");
                    if (writeData.isNoTitle()) {
                        this.aiW.p("st_type", "notitle");
                    }
                    if (x != null && TbadkCoreApplication.m411getInst().getIsLocationOn() && !TbConfig.getPositionPagerId().equals(writeData.getForumId())) {
                        this.aiW.p("lbs", String.valueOf(String.valueOf(x.getLatitude())) + "," + String.valueOf(x.getLongitude()));
                    }
                    e.a(this.aiW, writeData);
                    if (writeData.getCategoryFrom() >= 0) {
                        this.aiW.p("fromCategoryId", String.valueOf(writeData.getCategoryFrom()));
                    }
                    if (writeData.getCategoryTo() >= 0) {
                        this.aiW.p("toCategoryId", String.valueOf(writeData.getCategoryTo()));
                        str2 = imagesCodeForPost;
                        break;
                    }
                    str2 = imagesCodeForPost;
                    break;
                case 1:
                    this.aiW.setUrl(eqq);
                    this.aiW.p("tid", writeData.getThreadId());
                    this.aiW.p("kw", writeData.getForumName());
                    this.aiW.p("is_ad", writeData.getIsAd() ? "1" : "0");
                    if (writeData.isFrsReply()) {
                        this.aiW.p("st_param", "frs");
                    }
                    if (com.baidu.tbadk.editortools.d.b.DI().getStatus() == 1) {
                        this.aiW.p("ptype", "4");
                    }
                    e.a(this.aiW, writeData);
                    str2 = imagesCodeForPost;
                    break;
                case 2:
                    this.aiW.setUrl(eqq);
                    this.aiW.p("tid", writeData.getThreadId());
                    this.aiW.p("kw", writeData.getForumName());
                    this.aiW.p("quote_id", String.valueOf(writeData.getFloor()));
                    this.aiW.p("is_twzhibo_thread", String.valueOf(0));
                    this.aiW.p("floor_num", String.valueOf(writeData.getFloorNum()));
                    if (writeData.getRepostId() != null) {
                        this.aiW.p("repostid", writeData.getRepostId());
                    }
                    this.aiW.p("is_ad", writeData.getIsAd() ? "1" : "0");
                    this.aiW.p(WriteActivityConfig.IS_ADDITION, writeData.isAddition() ? "1" : "0");
                    this.aiW.p("is_giftpost", writeData.isGiftPost() ? "1" : "0");
                    this.aiW.p("is_giftpost", writeData.isGiftPost() ? "1" : "0");
                    if (writeData.isAddition()) {
                        this.aiW.p("st_type", "conadd");
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
                    this.aiW.setUrl(eqp);
                    this.aiW.p("kw", writeData.getForumName());
                    this.aiW.p("title", writeData.getTitle());
                    this.aiW.p("thread_type", "33");
                    e.a(this.aiW, writeData);
                    str2 = imagesCodeForPost;
                    break;
                case 5:
                    this.aiW.setUrl(eqq);
                    this.aiW.p("tid", writeData.getThreadId());
                    this.aiW.p("kw", writeData.getForumName());
                    this.aiW.p("is_twzhibo_thread", String.valueOf(1));
                    e.a(this.aiW, writeData);
                    str2 = imagesCodeForPost;
                    break;
                case 6:
                    this.aiW.setUrl(eqp);
                    this.aiW.p("kw", writeData.getForumName());
                    this.aiW.p("thread_type", String.valueOf(36));
                    this.aiW.p("title", writeData.getTitle());
                    this.aiW.p("is_ntitle", writeData.isNoTitle() ? "1" : "0");
                    if (writeData.isNoTitle()) {
                        this.aiW.p("st_type", "notitle");
                    }
                    e.a(this.aiW, writeData);
                    str2 = imagesCodeForPost;
                    break;
            }
        }
        String vw = this.aiW.vw();
        pv(95);
        if (this.aiW.vU().wP().qC()) {
            this.eqs.parserJson(vw);
        } else {
            this.eqs.setError_code(this.aiW.vX() ? this.aiW.vY() : this.aiW.vZ());
            this.eqs.setError_msg(this.aiW.getErrorString());
        }
        if (this.eqs.error_code != 0 && !i.jf()) {
            this.eqs.setError_msg(TbadkCoreApplication.m411getInst().getApp().getString(t.j.neterror));
        } else if (this.eqs.error_code != 0 && ((writeData.isHasImages() || writeData.getIsBaobao()) && j.isEmpty(String.valueOf(writeData.getContent()) + str2))) {
            this.eqs.setError_msg(TbadkCoreApplication.m411getInst().getApp().getString(t.j.img_upload_error));
        }
        try {
            this.eqt = new AntiData();
            this.eqt.parserJson(new JSONObject(vw).optJSONObject("anti_stat"));
        } catch (Exception e) {
        }
        pv(100);
        return vw;
    }

    private boolean nW(String str) {
        p pVar;
        if (StringUtils.isNull(str)) {
            return true;
        }
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_GRAFFITI_COMMON_MANAGER, p.class);
        return runTask == null || (pVar = (p) runTask.getData()) == null || pVar.iC(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pv(int i) {
        if (this.eqv != null) {
            this.eqv.pw(i);
        }
    }

    public boolean qC() {
        if (this.aiW == null) {
            return false;
        }
        return this.aiW.vU().wP().qC();
    }

    public void cancel() {
        this.ayf = true;
        if (this.aiW != null) {
            this.aiW.gX();
        }
        if (this.axS != null) {
            this.axS.cancel();
        }
        if (this.equ != null) {
            this.equ.aUx();
        }
    }

    public AntiData aTL() {
        return this.eqt;
    }

    public ErrorData aTM() {
        return this.eqs;
    }
}
