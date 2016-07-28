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
    private static final String flu = String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.POST_THREAD_ADDRESS;
    private static final String flv = String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.REPLY_THREAD_ADDRESS;
    public static final String flw = String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.POST_THREAD_FOR_SHARE_ADDRESS;
    private ab afX = null;
    private boolean avL = false;
    private c avy;
    private InterfaceC0075a flA;
    private ErrorData flx;
    private AntiData fly;
    private com.baidu.tieba.tbadkCore.videoupload.a flz;

    /* renamed from: com.baidu.tieba.tbadkCore.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0075a {
        void rb(int i);
    }

    /* loaded from: classes.dex */
    public static class b {
        public static int flD = 1;
    }

    public a() {
        this.flx = null;
        this.flx = new ErrorData();
    }

    public void a(InterfaceC0075a interfaceC0075a) {
        this.flA = interfaceC0075a;
    }

    public ImageUploadResult d(ImageFileInfo imageFileInfo, boolean z) {
        if (imageFileInfo == null) {
            return null;
        }
        if (this.avy == null) {
            this.avy = new c("HTTPWriteService.postImageData");
        }
        return this.avy.c(imageFileInfo, z);
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
        this.afX = new ab();
        this.afX.tx().uu().mIsNeedTbs = true;
        if (writeData.getType() == 3) {
            if (writeData.getVcode() != null && writeData.getVcode().length() > 0) {
                this.afX.n("vcode", writeData.getVcode());
            }
            if (TbadkCoreApplication.m10getInst().getNewVcodeWebviewCrashCount() < 3) {
                this.afX.n("tag", "11");
            }
            this.afX.n("newVcode", "1");
            this.afX.n(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_CONTENT, writeData.getContent());
            this.afX.setUrl(flw);
            this.afX.n(ImageViewerConfig.FORUM_NAME, writeData.getForumName());
            this.afX.n("title", writeData.getTitle());
            this.afX.n("apiKey", writeData.getShareApiKey());
            this.afX.n("appName", writeData.getShareAppName());
            this.afX.n("signKey", writeData.getShareSignKey());
            this.afX.n("summary_title", writeData.getShareSummaryTitle());
            this.afX.n("summary_content", writeData.getShareSummaryContent());
            this.afX.n("summary_img", writeData.getShareSummaryImg());
            this.afX.n(WriteShareActivityConfig.SHARE_SUMMARY_IMG_WIDTH, String.valueOf(writeData.getShareSummaryImgWidth()));
            this.afX.n(WriteShareActivityConfig.SHARE_SUMMARY_IMG_HEIGHT, String.valueOf(writeData.getShareSummaryImgHeight()));
            this.afX.n(WriteShareActivityConfig.SHARE_SUMMARY_IMG_TYPE, writeData.getShareSummaryImgType());
            this.afX.n("referUrl", writeData.getShareReferUrl());
        } else if (!qn(writeData.getGraffitiFileName())) {
            this.flx.setError_code(-53);
            this.flx.setError_msg(TbadkCoreApplication.m10getInst().getString(u.j.graffiti_valid_fail));
            return null;
        } else {
            if (z && writeData.isHasImages()) {
                if (this.avy == null) {
                    this.avy = new c("HTTPWriteService.postWriteData");
                }
                if (writeData.getType() == 6) {
                    if (!this.avy.b(writeData.getWriteImagesInfo(), true)) {
                        this.flx.setError_code(-53);
                        this.flx.setError_msg(TbadkCoreApplication.m10getInst().getString(u.j.upload_error));
                        return null;
                    }
                } else {
                    this.avy.c(writeData.getWriteImagesInfo(), true);
                }
            }
            if (!StringUtils.isNull(writeData.getGraffitiFileName())) {
                if (this.avy == null) {
                    this.avy = new c("HTTPWriteService.postWriteData");
                }
                CustomResponsedMessage runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_GRAFFITI_COMMON_MANAGER, p.class);
                String jU = (runTask == null || runTask.getData() == null) ? null : ((p) runTask.getData()).jU(writeData.getGraffitiFileName());
                if (!StringUtils.isNull(jU)) {
                    ImageFileInfo imageFileInfo = new ImageFileInfo();
                    imageFileInfo.setFilePath(jU);
                    ImageUploadResult a = this.avy.a(imageFileInfo, true, false);
                    if (a != null) {
                        UploadedImageInfo uploadedPicInfo = a.getUploadedPicInfo();
                        writeData.setGraffitiWriteCode(d.a(uploadedPicInfo));
                        if (uploadedPicInfo != null) {
                            writeData.setGraffitiImageId(uploadedPicInfo.getPic_id());
                        }
                    }
                }
            }
            if (this.avL) {
                return null;
            }
            if (writeData.getIsBaobao()) {
                if (this.avy == null) {
                    this.avy = new c("HTTPWriteService.postWriteData");
                }
                this.avy.c(writeData.getBaobaoImagesInfo(), true);
            }
            if (this.avL) {
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
                e dY = cVar.dY(r);
                if (dY != null && dY.isSuccess()) {
                    com.baidu.tbadk.coreExtra.data.d wx = dY.wx();
                    if (wx != null) {
                        returnVoiceMd5 = wx.getMd5();
                        com.baidu.tbadk.core.voice.a.b.ag(writeData.getVoice(), returnVoiceMd5);
                        writeData.setReturnVoiceMd5(returnVoiceMd5);
                    } else {
                        l lVar = new l();
                        lVar.n("ErrCode", Integer.valueOf(dY.getErrorCode()));
                        lVar.n("ErrMsg", dY.getErrorString());
                        TiebaStatic.voiceError(TbErrInfo.ERR_VOI_SEND, "audioUploadData is null", lVar.toString());
                        this.flx.setError_code(dY.getErrorCode());
                        this.flx.setError_msg(dY.getErrorString());
                        return null;
                    }
                } else {
                    l lVar2 = new l();
                    lVar2.n("audioFile", r);
                    TiebaStatic.voiceError(TbErrInfo.ERR_VOI_SEND, "uploadService.upload null or fail", lVar2.toString());
                    this.flx.setError_code(dY.getErrorCode());
                    this.flx.setError_msg(dY.getErrorString());
                    return null;
                }
            }
            if (this.avL) {
                return null;
            }
            VideoInfo videoInfo = writeData.getVideoInfo();
            if (videoInfo != null) {
                if (videoInfo.needUploadVideo()) {
                    this.flz = new com.baidu.tieba.tbadkCore.videoupload.a();
                    VideoFinishResult a2 = this.flz.a(writeData.getForumId(), videoInfo.getVideoPath(), new com.baidu.tieba.tbadkCore.c.b(this));
                    if (a2 == null) {
                        this.flx.setError_code(-53);
                        this.flx.setError_msg(TbadkCoreApplication.m10getInst().getString(u.j.upload_error));
                        return null;
                    } else if (a2.isSuccess()) {
                        videoInfo.setVideoMd5(a2.getVideoMd5());
                        videoInfo.setVideoUrl(a2.getVideoUrl());
                    } else {
                        this.flx.setError_code(a2.getErrorNo());
                        this.flx.setError_msg(a2.getUserMessage());
                        return null;
                    }
                }
                if (videoInfo.needUploadThunmb()) {
                    if (this.avy == null) {
                        this.avy = new c("HTTPWriteService.postWriteData");
                    }
                    ImageUploadResult s = this.avy.s(videoInfo.getThumbPath(), false);
                    if (s != null) {
                        videoInfo.setThumbId(s.picId);
                    }
                }
            }
            if (this.avL) {
                return null;
            }
            this.afX.n("anonymous", "1");
            this.afX.n("fid", writeData.getForumId());
            if (returnVoiceMd5 != null) {
                this.afX.n("voice_md5", returnVoiceMd5);
                this.afX.n("during_time", String.valueOf(voiceDuringTime));
            }
            String imagesCodeForPost = writeData.getImagesCodeForPost();
            if (writeData.getType() != 6 && ((writeData.getType() != 0 || (writeData.getType() == 0 && TextUtils.isEmpty(writeData.getTitle()))) && TextUtils.isEmpty(returnVoiceMd5) && TextUtils.isEmpty(imagesCodeForPost) && TextUtils.isEmpty(writeData.getContent()) && writeData.getVideoInfo() == null && TextUtils.isEmpty(writeData.getGraffitiWriteCode()))) {
                this.flx.setError_code(-53);
                this.flx.setError_msg(TbadkCoreApplication.m10getInst().getString(u.j.sand_fail));
                return null;
            }
            if (writeData.getVcode() != null && writeData.getVcode().length() > 0) {
                this.afX.n("vcode", writeData.getVcode());
            }
            if (!StringUtils.isNull(writeData.getVcodeMD5())) {
                this.afX.n(GraffitiVcodeActivityConfig.VCODE_MD5, writeData.getVcodeMD5());
            }
            if (!StringUtils.isNull(writeData.getVcodeType())) {
                this.afX.n("vcode_type", writeData.getVcodeType());
            }
            if (TbadkCoreApplication.m10getInst().getNewVcodeWebviewCrashCount() < 3) {
                this.afX.n("vcode_tag", "12");
            }
            Address z3 = com.baidu.adp.lib.e.a.cZ().z(false);
            this.afX.n("new_vcode", "1");
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
            this.afX.n(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_CONTENT, str);
            this.afX.n("reply_uid", writeData.getReplyId());
            if (writeData.getIsBaobaoImageUploaded()) {
                this.afX.n("tail_type", String.valueOf(b.flD));
                this.afX.n("tail_content", writeData.getBaobaoContent());
                writeData.setBabaoPosted(true);
            } else {
                writeData.setBabaoPosted(false);
            }
            switch (writeData.getType()) {
                case 0:
                    this.afX.setUrl(flu);
                    this.afX.n("kw", writeData.getForumName());
                    this.afX.n("title", writeData.getTitle());
                    this.afX.n("is_ntitle", writeData.isNoTitle() ? "1" : "0");
                    if (writeData.isNoTitle()) {
                        this.afX.n("st_type", "notitle");
                    }
                    String hiAlbumId = writeData.getHiAlbumId();
                    if (hiAlbumId != null) {
                        this.afX.n("17hi_album_id", hiAlbumId);
                    }
                    if (z3 != null && TbadkCoreApplication.m10getInst().getIsLocationOn() && !TbConfig.getPositionPagerId().equals(writeData.getForumId())) {
                        this.afX.n("lbs", String.valueOf(String.valueOf(z3.getLatitude())) + "," + String.valueOf(z3.getLongitude()));
                    }
                    com.baidu.tieba.tbadkCore.writeModel.e.a(this.afX, writeData);
                    if (writeData.getCategoryFrom() >= 0) {
                        this.afX.n("fromCategoryId", String.valueOf(writeData.getCategoryFrom()));
                    }
                    if (writeData.getCategoryTo() >= 0) {
                        this.afX.n("toCategoryId", String.valueOf(writeData.getCategoryTo()));
                        str2 = imagesCodeForPost;
                        break;
                    }
                    str2 = imagesCodeForPost;
                    break;
                case 1:
                    this.afX.setUrl(flv);
                    this.afX.n("tid", writeData.getThreadId());
                    this.afX.n("kw", writeData.getForumName());
                    this.afX.n("is_ad", writeData.getIsAd() ? "1" : "0");
                    if (writeData.isFrsReply()) {
                        this.afX.n("st_param", "frs");
                    }
                    if (com.baidu.tbadk.editortools.d.b.BM().getStatus() == 1) {
                        this.afX.n("ptype", "4");
                    }
                    com.baidu.tieba.tbadkCore.writeModel.e.a(this.afX, writeData);
                    str2 = imagesCodeForPost;
                    break;
                case 2:
                    this.afX.setUrl(flv);
                    this.afX.n("tid", writeData.getThreadId());
                    this.afX.n("kw", writeData.getForumName());
                    this.afX.n("quote_id", String.valueOf(writeData.getFloor()));
                    this.afX.n("is_twzhibo_thread", String.valueOf(0));
                    this.afX.n("floor_num", String.valueOf(writeData.getFloorNum()));
                    if (writeData.getRepostId() != null) {
                        this.afX.n("repostid", writeData.getRepostId());
                    }
                    this.afX.n("is_ad", writeData.getIsAd() ? "1" : "0");
                    this.afX.n("is_addition", writeData.isAddition() ? "1" : "0");
                    this.afX.n("is_giftpost", writeData.isGiftPost() ? "1" : "0");
                    this.afX.n("is_giftpost", writeData.isGiftPost() ? "1" : "0");
                    if (writeData.isAddition()) {
                        this.afX.n("st_type", "conadd");
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
                    this.afX.setUrl(flu);
                    this.afX.n("kw", writeData.getForumName());
                    this.afX.n("title", writeData.getTitle());
                    this.afX.n("thread_type", "33");
                    com.baidu.tieba.tbadkCore.writeModel.e.a(this.afX, writeData);
                    str2 = imagesCodeForPost;
                    break;
                case 5:
                    this.afX.setUrl(flv);
                    this.afX.n("tid", writeData.getThreadId());
                    this.afX.n("kw", writeData.getForumName());
                    this.afX.n("is_twzhibo_thread", String.valueOf(1));
                    com.baidu.tieba.tbadkCore.writeModel.e.a(this.afX, writeData);
                    str2 = imagesCodeForPost;
                    break;
                case 6:
                    this.afX.setUrl(flu);
                    this.afX.n("kw", writeData.getForumName());
                    this.afX.n("thread_type", String.valueOf(36));
                    this.afX.n("title", writeData.getTitle());
                    this.afX.n("is_ntitle", writeData.isNoTitle() ? "1" : "0");
                    if (writeData.isNoTitle()) {
                        this.afX.n("st_type", "notitle");
                    }
                    com.baidu.tieba.tbadkCore.writeModel.e.a(this.afX, writeData);
                    str2 = imagesCodeForPost;
                    break;
                case 7:
                    this.afX.setUrl(flu);
                    this.afX.n("is_ntitle", writeData.isNoTitle() ? "1" : "0");
                    if (writeData.isNoTitle()) {
                        this.afX.n("st_type", "notitle");
                    }
                    this.afX.n("kw", writeData.getForumName());
                    this.afX.n("title", writeData.getTitle());
                    this.afX.n("product_id", new StringBuilder(String.valueOf(writeData.productId)).toString());
                    com.baidu.tieba.tbadkCore.writeModel.e.a(this.afX, writeData);
                    str2 = imagesCodeForPost;
                    break;
            }
        }
        String sZ = this.afX.sZ();
        ra(95);
        if (this.afX.tx().uv().nJ()) {
            this.flx.parserJson(sZ);
        } else {
            this.flx.setError_code(this.afX.tA() ? this.afX.tB() : this.afX.tC());
            this.flx.setError_msg(this.afX.getErrorString());
        }
        if (this.flx.error_code != 0 && !i.fq()) {
            this.flx.setError_msg(TbadkCoreApplication.m10getInst().getApp().getString(u.j.neterror));
        } else if (this.flx.error_code != 0 && ((writeData.isHasImages() || writeData.getIsBaobao()) && j.isEmpty(String.valueOf(writeData.getContent()) + str2))) {
            this.flx.setError_msg(TbadkCoreApplication.m10getInst().getApp().getString(u.j.img_upload_error));
        }
        try {
            this.fly = new AntiData();
            this.fly.parserJson(new JSONObject(sZ).optJSONObject("anti_stat"));
        } catch (Exception e) {
        }
        ra(100);
        return sZ;
    }

    private boolean qn(String str) {
        p pVar;
        if (StringUtils.isNull(str)) {
            return true;
        }
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_GRAFFITI_COMMON_MANAGER, p.class);
        return runTask == null || (pVar = (p) runTask.getData()) == null || pVar.jW(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ra(int i) {
        if (this.flA != null) {
            this.flA.rb(i);
        }
    }

    public boolean nJ() {
        if (this.afX == null) {
            return false;
        }
        return this.afX.tx().uv().nJ();
    }

    public void cancel() {
        this.avL = true;
        if (this.afX != null) {
            this.afX.dl();
        }
        if (this.avy != null) {
            this.avy.cancel();
        }
        if (this.flz != null) {
            this.flz.bgE();
        }
    }

    public AntiData bfU() {
        return this.fly;
    }

    public ErrorData bfV() {
        return this.flx;
    }
}
