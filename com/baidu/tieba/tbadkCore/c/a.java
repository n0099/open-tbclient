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
import com.baidu.tbadk.coreExtra.data.e;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tbadk.img.ImageUploadResult;
import com.baidu.tbadk.img.UploadedImageInfo;
import com.baidu.tbadk.img.c;
import com.baidu.tieba.graffiti.d;
import com.baidu.tieba.tbadkCore.util.p;
import com.baidu.tieba.tbadkCore.videoupload.VideoFinishResult;
import com.baidu.tieba.u;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class a {
    private static final String eYr = String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.POST_THREAD_ADDRESS;
    private static final String eYs = String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.REPLY_THREAD_ADDRESS;
    public static final String eYt = String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.POST_THREAD_FOR_SHARE_ADDRESS;
    private c auJ;
    private ErrorData eYu;
    private AntiData eYv;
    private com.baidu.tieba.tbadkCore.videoupload.a eYw;
    private InterfaceC0076a eYx;
    private ab afj = null;
    private boolean auW = false;

    /* renamed from: com.baidu.tieba.tbadkCore.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0076a {
        void qG(int i);
    }

    /* loaded from: classes.dex */
    public static class b {
        public static int eYA = 1;
    }

    public a() {
        this.eYu = null;
        this.eYu = new ErrorData();
    }

    public void a(InterfaceC0076a interfaceC0076a) {
        this.eYx = interfaceC0076a;
    }

    public ImageUploadResult d(ImageFileInfo imageFileInfo, boolean z) {
        if (imageFileInfo == null) {
            return null;
        }
        if (this.auJ == null) {
            this.auJ = new c("HTTPWriteService.postImageData");
        }
        return this.auJ.c(imageFileInfo, z);
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
        this.afj = new ab();
        this.afj.ty().uu().mIsNeedTbs = true;
        if (writeData.getType() == 3) {
            if (writeData.getVcode() != null && writeData.getVcode().length() > 0) {
                this.afj.n("vcode", writeData.getVcode());
            }
            if (TbadkCoreApplication.m9getInst().getNewVcodeWebviewCrashCount() < 3) {
                this.afj.n("tag", "11");
            }
            this.afj.n("newVcode", "1");
            this.afj.n(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_CONTENT, writeData.getContent());
            this.afj.setUrl(eYt);
            this.afj.n(ImageViewerConfig.FORUM_NAME, writeData.getForumName());
            this.afj.n("title", writeData.getTitle());
            this.afj.n("apiKey", writeData.getShareApiKey());
            this.afj.n("appName", writeData.getShareAppName());
            this.afj.n("signKey", writeData.getShareSignKey());
            this.afj.n("summary_title", writeData.getShareSummaryTitle());
            this.afj.n("summary_content", writeData.getShareSummaryContent());
            this.afj.n("summary_img", writeData.getShareSummaryImg());
            this.afj.n(WriteShareActivityConfig.SHARE_SUMMARY_IMG_WIDTH, String.valueOf(writeData.getShareSummaryImgWidth()));
            this.afj.n(WriteShareActivityConfig.SHARE_SUMMARY_IMG_HEIGHT, String.valueOf(writeData.getShareSummaryImgHeight()));
            this.afj.n(WriteShareActivityConfig.SHARE_SUMMARY_IMG_TYPE, writeData.getShareSummaryImgType());
            this.afj.n("referUrl", writeData.getShareReferUrl());
        } else if (!pD(writeData.getGraffitiFileName())) {
            this.eYu.setError_code(-53);
            this.eYu.setError_msg(TbadkCoreApplication.m9getInst().getString(u.j.graffiti_valid_fail));
            return null;
        } else {
            if (z && writeData.isHasImages()) {
                if (this.auJ == null) {
                    this.auJ = new c("HTTPWriteService.postWriteData");
                }
                if (writeData.getType() == 6) {
                    if (!this.auJ.b(writeData.getWriteImagesInfo(), true)) {
                        this.eYu.setError_code(-53);
                        this.eYu.setError_msg(TbadkCoreApplication.m9getInst().getString(u.j.upload_error));
                        return null;
                    }
                } else {
                    this.auJ.c(writeData.getWriteImagesInfo(), true);
                }
            }
            if (!StringUtils.isNull(writeData.getGraffitiFileName())) {
                if (this.auJ == null) {
                    this.auJ = new c("HTTPWriteService.postWriteData");
                }
                CustomResponsedMessage runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_GRAFFITI_COMMON_MANAGER, p.class);
                String jO = (runTask == null || runTask.getData() == null) ? null : ((p) runTask.getData()).jO(writeData.getGraffitiFileName());
                if (!StringUtils.isNull(jO)) {
                    ImageFileInfo imageFileInfo = new ImageFileInfo();
                    imageFileInfo.setFilePath(jO);
                    ImageUploadResult a = this.auJ.a(imageFileInfo, true, false);
                    if (a != null) {
                        UploadedImageInfo uploadedPicInfo = a.getUploadedPicInfo();
                        writeData.setGraffitiWriteCode(d.a(uploadedPicInfo));
                        if (uploadedPicInfo != null) {
                            writeData.setGraffitiImageId(uploadedPicInfo.getPic_id());
                        }
                    }
                }
            }
            if (this.auW) {
                return null;
            }
            if (writeData.getIsBaobao()) {
                if (this.auJ == null) {
                    this.auJ = new c("HTTPWriteService.postWriteData");
                }
                this.auJ.c(writeData.getBaobaoImagesInfo(), true);
            }
            if (this.auW) {
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
                cVar.w("type", 1);
                String r = m.r(voice, 1);
                e dZ = cVar.dZ(r);
                if (dZ != null && dZ.isSuccess()) {
                    com.baidu.tbadk.coreExtra.data.d wx = dZ.wx();
                    if (wx != null) {
                        returnVoiceMd5 = wx.getMd5();
                        com.baidu.tbadk.core.voice.a.b.ag(writeData.getVoice(), returnVoiceMd5);
                        writeData.setReturnVoiceMd5(returnVoiceMd5);
                    } else {
                        l lVar = new l();
                        lVar.h("ErrCode", Integer.valueOf(dZ.getErrorCode()));
                        lVar.h("ErrMsg", dZ.getErrorString());
                        TiebaStatic.voiceError(TbErrInfo.ERR_VOI_SEND, "audioUploadData is null", lVar.toString());
                        this.eYu.setError_code(dZ.getErrorCode());
                        this.eYu.setError_msg(dZ.getErrorString());
                        return null;
                    }
                } else {
                    l lVar2 = new l();
                    lVar2.h("audioFile", r);
                    TiebaStatic.voiceError(TbErrInfo.ERR_VOI_SEND, "uploadService.upload null or fail", lVar2.toString());
                    this.eYu.setError_code(dZ.getErrorCode());
                    this.eYu.setError_msg(dZ.getErrorString());
                    return null;
                }
            }
            if (this.auW) {
                return null;
            }
            VideoInfo videoInfo = writeData.getVideoInfo();
            if (videoInfo != null) {
                if (videoInfo.needUploadVideo()) {
                    this.eYw = new com.baidu.tieba.tbadkCore.videoupload.a();
                    VideoFinishResult a2 = this.eYw.a(writeData.getForumId(), videoInfo.getVideoPath(), new com.baidu.tieba.tbadkCore.c.b(this));
                    if (a2 == null) {
                        this.eYu.setError_code(-53);
                        this.eYu.setError_msg(TbadkCoreApplication.m9getInst().getString(u.j.upload_error));
                        return null;
                    } else if (a2.isSuccess()) {
                        videoInfo.setVideoMd5(a2.getVideoMd5());
                        videoInfo.setVideoUrl(a2.getVideoUrl());
                    } else {
                        this.eYu.setError_code(a2.getErrorNo());
                        this.eYu.setError_msg(a2.getUserMessage());
                        return null;
                    }
                }
                if (videoInfo.needUploadThunmb()) {
                    if (this.auJ == null) {
                        this.auJ = new c("HTTPWriteService.postWriteData");
                    }
                    ImageUploadResult s = this.auJ.s(videoInfo.getThumbPath(), false);
                    if (s != null) {
                        videoInfo.setThumbId(s.picId);
                    }
                }
            }
            if (this.auW) {
                return null;
            }
            this.afj.n("anonymous", "1");
            this.afj.n("fid", writeData.getForumId());
            if (returnVoiceMd5 != null) {
                this.afj.n("voice_md5", returnVoiceMd5);
                this.afj.n("during_time", String.valueOf(voiceDuringTime));
            }
            String imagesCodeForPost = writeData.getImagesCodeForPost();
            if (writeData.getType() != 6 && ((writeData.getType() != 0 || (writeData.getType() == 0 && TextUtils.isEmpty(writeData.getTitle()))) && TextUtils.isEmpty(returnVoiceMd5) && TextUtils.isEmpty(imagesCodeForPost) && TextUtils.isEmpty(writeData.getContent()) && writeData.getVideoInfo() == null && TextUtils.isEmpty(writeData.getGraffitiWriteCode()))) {
                this.eYu.setError_code(-53);
                this.eYu.setError_msg(TbadkCoreApplication.m9getInst().getString(u.j.sand_fail));
                return null;
            }
            if (writeData.getVcode() != null && writeData.getVcode().length() > 0) {
                this.afj.n("vcode", writeData.getVcode());
            }
            if (!StringUtils.isNull(writeData.getVcodeMD5())) {
                this.afj.n(GraffitiVcodeActivityConfig.VCODE_MD5, writeData.getVcodeMD5());
            }
            if (!StringUtils.isNull(writeData.getVcodeType())) {
                this.afj.n("vcode_type", writeData.getVcodeType());
            }
            if (TbadkCoreApplication.m9getInst().getNewVcodeWebviewCrashCount() < 3) {
                this.afj.n("vcode_tag", "12");
            }
            Address x = com.baidu.adp.lib.e.a.da().x(false);
            this.afj.n("new_vcode", "1");
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
            this.afj.n(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_CONTENT, str);
            this.afj.n("reply_uid", writeData.getReplyId());
            if (writeData.getIsBaobaoImageUploaded()) {
                this.afj.n("tail_type", String.valueOf(b.eYA));
                this.afj.n("tail_content", writeData.getBaobaoContent());
                writeData.setBabaoPosted(true);
            } else {
                writeData.setBabaoPosted(false);
            }
            switch (writeData.getType()) {
                case 0:
                    this.afj.setUrl(eYr);
                    this.afj.n("kw", writeData.getForumName());
                    this.afj.n("title", writeData.getTitle());
                    this.afj.n("is_ntitle", writeData.isNoTitle() ? "1" : "0");
                    if (writeData.isNoTitle()) {
                        this.afj.n("st_type", "notitle");
                    }
                    String hiAlbumId = writeData.getHiAlbumId();
                    if (hiAlbumId != null) {
                        this.afj.n("17hi_album_id", hiAlbumId);
                    }
                    if (x != null && TbadkCoreApplication.m9getInst().getIsLocationOn() && !TbConfig.getPositionPagerId().equals(writeData.getForumId())) {
                        this.afj.n("lbs", String.valueOf(String.valueOf(x.getLatitude())) + "," + String.valueOf(x.getLongitude()));
                    }
                    com.baidu.tieba.tbadkCore.writeModel.e.a(this.afj, writeData);
                    if (writeData.getCategoryFrom() >= 0) {
                        this.afj.n("fromCategoryId", String.valueOf(writeData.getCategoryFrom()));
                    }
                    if (writeData.getCategoryTo() >= 0) {
                        this.afj.n("toCategoryId", String.valueOf(writeData.getCategoryTo()));
                        str2 = imagesCodeForPost;
                        break;
                    }
                    str2 = imagesCodeForPost;
                    break;
                case 1:
                    this.afj.setUrl(eYs);
                    this.afj.n("tid", writeData.getThreadId());
                    this.afj.n("kw", writeData.getForumName());
                    this.afj.n("is_ad", writeData.getIsAd() ? "1" : "0");
                    if (writeData.isFrsReply()) {
                        this.afj.n("st_param", "frs");
                    }
                    if (com.baidu.tbadk.editortools.d.b.BM().getStatus() == 1) {
                        this.afj.n("ptype", "4");
                    }
                    com.baidu.tieba.tbadkCore.writeModel.e.a(this.afj, writeData);
                    str2 = imagesCodeForPost;
                    break;
                case 2:
                    this.afj.setUrl(eYs);
                    this.afj.n("tid", writeData.getThreadId());
                    this.afj.n("kw", writeData.getForumName());
                    this.afj.n("quote_id", String.valueOf(writeData.getFloor()));
                    this.afj.n("is_twzhibo_thread", String.valueOf(0));
                    this.afj.n("floor_num", String.valueOf(writeData.getFloorNum()));
                    if (writeData.getRepostId() != null) {
                        this.afj.n("repostid", writeData.getRepostId());
                    }
                    this.afj.n("is_ad", writeData.getIsAd() ? "1" : "0");
                    this.afj.n("is_addition", writeData.isAddition() ? "1" : "0");
                    this.afj.n("is_giftpost", writeData.isGiftPost() ? "1" : "0");
                    this.afj.n("is_giftpost", writeData.isGiftPost() ? "1" : "0");
                    if (writeData.isAddition()) {
                        this.afj.n("st_type", "conadd");
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
                    this.afj.setUrl(eYr);
                    this.afj.n("kw", writeData.getForumName());
                    this.afj.n("title", writeData.getTitle());
                    this.afj.n("thread_type", "33");
                    com.baidu.tieba.tbadkCore.writeModel.e.a(this.afj, writeData);
                    str2 = imagesCodeForPost;
                    break;
                case 5:
                    this.afj.setUrl(eYs);
                    this.afj.n("tid", writeData.getThreadId());
                    this.afj.n("kw", writeData.getForumName());
                    this.afj.n("is_twzhibo_thread", String.valueOf(1));
                    com.baidu.tieba.tbadkCore.writeModel.e.a(this.afj, writeData);
                    str2 = imagesCodeForPost;
                    break;
                case 6:
                    this.afj.setUrl(eYr);
                    this.afj.n("kw", writeData.getForumName());
                    this.afj.n("thread_type", String.valueOf(36));
                    this.afj.n("title", writeData.getTitle());
                    this.afj.n("is_ntitle", writeData.isNoTitle() ? "1" : "0");
                    if (writeData.isNoTitle()) {
                        this.afj.n("st_type", "notitle");
                    }
                    com.baidu.tieba.tbadkCore.writeModel.e.a(this.afj, writeData);
                    str2 = imagesCodeForPost;
                    break;
                case 7:
                    this.afj.setUrl(eYr);
                    this.afj.n("is_ntitle", writeData.isNoTitle() ? "1" : "0");
                    if (writeData.isNoTitle()) {
                        this.afj.n("st_type", "notitle");
                    }
                    this.afj.n("kw", writeData.getForumName());
                    this.afj.n("title", writeData.getTitle());
                    this.afj.n("product_id", new StringBuilder(String.valueOf(writeData.productId)).toString());
                    com.baidu.tieba.tbadkCore.writeModel.e.a(this.afj, writeData);
                    str2 = imagesCodeForPost;
                    break;
            }
        }
        String ta = this.afj.ta();
        qF(95);
        if (this.afj.ty().uv().nU()) {
            this.eYu.parserJson(ta);
        } else {
            this.eYu.setError_code(this.afj.tB() ? this.afj.tC() : this.afj.tD());
            this.eYu.setError_msg(this.afj.getErrorString());
        }
        if (this.eYu.error_code != 0 && !i.fr()) {
            this.eYu.setError_msg(TbadkCoreApplication.m9getInst().getApp().getString(u.j.neterror));
        } else if (this.eYu.error_code != 0 && ((writeData.isHasImages() || writeData.getIsBaobao()) && j.isEmpty(String.valueOf(writeData.getContent()) + str2))) {
            this.eYu.setError_msg(TbadkCoreApplication.m9getInst().getApp().getString(u.j.img_upload_error));
        }
        try {
            this.eYv = new AntiData();
            this.eYv.parserJson(new JSONObject(ta).optJSONObject("anti_stat"));
        } catch (Exception e) {
        }
        qF(100);
        return ta;
    }

    private boolean pD(String str) {
        p pVar;
        if (StringUtils.isNull(str)) {
            return true;
        }
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_GRAFFITI_COMMON_MANAGER, p.class);
        return runTask == null || (pVar = (p) runTask.getData()) == null || pVar.jQ(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void qF(int i) {
        if (this.eYx != null) {
            this.eYx.qG(i);
        }
    }

    public boolean nU() {
        if (this.afj == null) {
            return false;
        }
        return this.afj.ty().uv().nU();
    }

    public void cancel() {
        this.auW = true;
        if (this.afj != null) {
            this.afj.dm();
        }
        if (this.auJ != null) {
            this.auJ.cancel();
        }
        if (this.eYw != null) {
            this.eYw.bdm();
        }
    }

    public AntiData bcF() {
        return this.eYv;
    }

    public ErrorData bcG() {
        return this.eYu;
    }
}
