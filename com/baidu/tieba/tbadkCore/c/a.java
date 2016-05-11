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
    private static final String etB = String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.POST_THREAD_ADDRESS;
    private static final String etC = String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.REPLY_THREAD_ADDRESS;
    public static final String etD = String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.POST_THREAD_FOR_SHARE_ADDRESS;
    private c atT;
    private ErrorData etE;
    private AntiData etF;
    private com.baidu.tieba.tbadkCore.videoupload.a etG;
    private InterfaceC0074a etH;
    private ab aeI = null;
    private boolean aug = false;

    /* renamed from: com.baidu.tieba.tbadkCore.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0074a {
        void pr(int i);
    }

    /* loaded from: classes.dex */
    public static class b {
        public static int etK = 1;
    }

    public a() {
        this.etE = null;
        this.etE = new ErrorData();
    }

    public void a(InterfaceC0074a interfaceC0074a) {
        this.etH = interfaceC0074a;
    }

    public ImageUploadResult d(ImageFileInfo imageFileInfo, boolean z) {
        if (imageFileInfo == null) {
            return null;
        }
        if (this.atT == null) {
            this.atT = new c("HTTPWriteService.postImageData");
        }
        return this.atT.c(imageFileInfo, z);
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
        this.aeI = new ab();
        this.aeI.tA().uu().mIsNeedTbs = true;
        if (writeData.getType() == 3) {
            if (writeData.getVcode() != null && writeData.getVcode().length() > 0) {
                this.aeI.n("vcode", writeData.getVcode());
            }
            if (TbadkCoreApplication.m11getInst().getNewVcodeWebviewCrashCount() < 3) {
                this.aeI.n("tag", "11");
            }
            this.aeI.n("newVcode", "1");
            this.aeI.n(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_CONTENT, writeData.getContent());
            this.aeI.setUrl(etD);
            this.aeI.n(ImageViewerConfig.FORUM_NAME, writeData.getForumName());
            this.aeI.n("title", writeData.getTitle());
            this.aeI.n("apiKey", writeData.getShareApiKey());
            this.aeI.n("appName", writeData.getShareAppName());
            this.aeI.n("signKey", writeData.getShareSignKey());
            this.aeI.n("summary_title", writeData.getShareSummaryTitle());
            this.aeI.n("summary_content", writeData.getShareSummaryContent());
            this.aeI.n("summary_img", writeData.getShareSummaryImg());
            this.aeI.n(WriteShareActivityConfig.SHARE_SUMMARY_IMG_WIDTH, String.valueOf(writeData.getShareSummaryImgWidth()));
            this.aeI.n(WriteShareActivityConfig.SHARE_SUMMARY_IMG_HEIGHT, String.valueOf(writeData.getShareSummaryImgHeight()));
            this.aeI.n(WriteShareActivityConfig.SHARE_SUMMARY_IMG_TYPE, writeData.getShareSummaryImgType());
            this.aeI.n("referUrl", writeData.getShareReferUrl());
        } else if (!nV(writeData.getGraffitiFileName())) {
            this.etE.setError_code(-53);
            this.etE.setError_msg(TbadkCoreApplication.m11getInst().getString(t.j.graffiti_valid_fail));
            return null;
        } else {
            if (z && writeData.isHasImages()) {
                if (this.atT == null) {
                    this.atT = new c("HTTPWriteService.postWriteData");
                }
                if (writeData.getType() == 6) {
                    if (!this.atT.b(writeData.getWriteImagesInfo(), true)) {
                        this.etE.setError_code(-53);
                        this.etE.setError_msg(TbadkCoreApplication.m11getInst().getString(t.j.upload_error));
                        return null;
                    }
                } else {
                    this.atT.c(writeData.getWriteImagesInfo(), true);
                }
            }
            if (!StringUtils.isNull(writeData.getGraffitiFileName())) {
                if (this.atT == null) {
                    this.atT = new c("HTTPWriteService.postWriteData");
                }
                CustomResponsedMessage runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_GRAFFITI_COMMON_MANAGER, p.class);
                String iB = (runTask == null || runTask.getData() == null) ? null : ((p) runTask.getData()).iB(writeData.getGraffitiFileName());
                if (!StringUtils.isNull(iB)) {
                    ImageFileInfo imageFileInfo = new ImageFileInfo();
                    imageFileInfo.setFilePath(iB);
                    ImageUploadResult a = this.atT.a(imageFileInfo, true, false);
                    if (a != null) {
                        UploadedImageInfo uploadedPicInfo = a.getUploadedPicInfo();
                        writeData.setGraffitiWriteCode(d.a(uploadedPicInfo));
                        if (uploadedPicInfo != null) {
                            writeData.setGraffitiImageId(uploadedPicInfo.getPic_id());
                        }
                    }
                }
            }
            if (this.aug) {
                return null;
            }
            if (writeData.getIsBaobao()) {
                if (this.atT == null) {
                    this.atT = new c("HTTPWriteService.postWriteData");
                }
                this.atT.c(writeData.getBaobaoImagesInfo(), true);
            }
            if (this.aug) {
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
                com.baidu.tbadk.coreExtra.data.d dV = cVar.dV(r);
                if (dV != null && dV.isSuccess()) {
                    com.baidu.tbadk.coreExtra.data.c wt = dV.wt();
                    if (wt != null) {
                        returnVoiceMd5 = wt.getMd5();
                        com.baidu.tbadk.core.voice.a.b.ah(writeData.getVoice(), returnVoiceMd5);
                        writeData.setReturnVoiceMd5(returnVoiceMd5);
                    } else {
                        l lVar = new l();
                        lVar.h("ErrCode", Integer.valueOf(dV.getErrorCode()));
                        lVar.h("ErrMsg", dV.getErrorString());
                        TiebaStatic.voiceError(TbErrInfo.ERR_VOI_SEND, "audioUploadData is null", lVar.toString());
                        this.etE.setError_code(dV.getErrorCode());
                        this.etE.setError_msg(dV.getErrorString());
                        return null;
                    }
                } else {
                    l lVar2 = new l();
                    lVar2.h("audioFile", r);
                    TiebaStatic.voiceError(TbErrInfo.ERR_VOI_SEND, "uploadService.upload null or fail", lVar2.toString());
                    this.etE.setError_code(dV.getErrorCode());
                    this.etE.setError_msg(dV.getErrorString());
                    return null;
                }
            }
            if (this.aug) {
                return null;
            }
            VideoInfo videoInfo = writeData.getVideoInfo();
            if (videoInfo != null) {
                if (videoInfo.needUploadVideo()) {
                    this.etG = new com.baidu.tieba.tbadkCore.videoupload.a();
                    VideoFinishResult a2 = this.etG.a(writeData.getForumId(), videoInfo.getVideoPath(), new com.baidu.tieba.tbadkCore.c.b(this));
                    if (a2 == null) {
                        this.etE.setError_code(-53);
                        this.etE.setError_msg(TbadkCoreApplication.m11getInst().getString(t.j.upload_error));
                        return null;
                    } else if (a2.isSuccess()) {
                        videoInfo.setVideoMd5(a2.getVideoMd5());
                        videoInfo.setVideoUrl(a2.getVideoUrl());
                    } else {
                        this.etE.setError_code(a2.getErrorNo());
                        this.etE.setError_msg(a2.getUserMessage());
                        return null;
                    }
                }
                if (videoInfo.needUploadThunmb()) {
                    if (this.atT == null) {
                        this.atT = new c("HTTPWriteService.postWriteData");
                    }
                    ImageUploadResult s = this.atT.s(videoInfo.getThumbPath(), false);
                    if (s != null) {
                        videoInfo.setThumbId(s.picId);
                    }
                }
            }
            if (this.aug) {
                return null;
            }
            this.aeI.n("anonymous", "1");
            this.aeI.n("fid", writeData.getForumId());
            if (returnVoiceMd5 != null) {
                this.aeI.n("voice_md5", returnVoiceMd5);
                this.aeI.n("during_time", String.valueOf(voiceDuringTime));
            }
            String imagesCodeForPost = writeData.getImagesCodeForPost();
            if (writeData.getType() != 6 && ((writeData.getType() != 0 || (writeData.getType() == 0 && TextUtils.isEmpty(writeData.getTitle()))) && TextUtils.isEmpty(returnVoiceMd5) && TextUtils.isEmpty(imagesCodeForPost) && TextUtils.isEmpty(writeData.getContent()) && writeData.getVideoInfo() == null && TextUtils.isEmpty(writeData.getGraffitiWriteCode()))) {
                this.etE.setError_code(-53);
                this.etE.setError_msg(TbadkCoreApplication.m11getInst().getString(t.j.sand_fail));
                return null;
            }
            if (writeData.getVcode() != null && writeData.getVcode().length() > 0) {
                this.aeI.n("vcode", writeData.getVcode());
            }
            if (!StringUtils.isNull(writeData.getVcodeMD5())) {
                this.aeI.n(CommonVcodeActivityConfig.VCODE_MD5, writeData.getVcodeMD5());
            }
            if (TbadkCoreApplication.m11getInst().getNewVcodeWebviewCrashCount() < 3) {
                this.aeI.n("vcode_tag", "11");
            }
            Address x = com.baidu.adp.lib.e.a.cZ().x(false);
            this.aeI.n("new_vcode", "1");
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
            this.aeI.n(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_CONTENT, str);
            this.aeI.n("reply_uid", writeData.getReplyId());
            if (writeData.getIsBaobaoImageUploaded()) {
                this.aeI.n("tail_type", String.valueOf(b.etK));
                this.aeI.n("tail_content", writeData.getBaobaoContent());
                writeData.setBabaoPosted(true);
            } else {
                writeData.setBabaoPosted(false);
            }
            switch (writeData.getType()) {
                case 0:
                    this.aeI.setUrl(etB);
                    this.aeI.n("kw", writeData.getForumName());
                    this.aeI.n("title", writeData.getTitle());
                    this.aeI.n("is_ntitle", writeData.isNoTitle() ? "1" : "0");
                    if (writeData.isNoTitle()) {
                        this.aeI.n("st_type", "notitle");
                    }
                    String hiAlbumId = writeData.getHiAlbumId();
                    if (hiAlbumId != null) {
                        this.aeI.n("17hi_album_id", hiAlbumId);
                    }
                    if (x != null && TbadkCoreApplication.m11getInst().getIsLocationOn() && !TbConfig.getPositionPagerId().equals(writeData.getForumId())) {
                        this.aeI.n("lbs", String.valueOf(String.valueOf(x.getLatitude())) + "," + String.valueOf(x.getLongitude()));
                    }
                    e.a(this.aeI, writeData);
                    if (writeData.getCategoryFrom() >= 0) {
                        this.aeI.n("fromCategoryId", String.valueOf(writeData.getCategoryFrom()));
                    }
                    if (writeData.getCategoryTo() >= 0) {
                        this.aeI.n("toCategoryId", String.valueOf(writeData.getCategoryTo()));
                        str2 = imagesCodeForPost;
                        break;
                    }
                    str2 = imagesCodeForPost;
                    break;
                case 1:
                    this.aeI.setUrl(etC);
                    this.aeI.n("tid", writeData.getThreadId());
                    this.aeI.n("kw", writeData.getForumName());
                    this.aeI.n("is_ad", writeData.getIsAd() ? "1" : "0");
                    if (writeData.isFrsReply()) {
                        this.aeI.n("st_param", "frs");
                    }
                    if (com.baidu.tbadk.editortools.d.b.BC().getStatus() == 1) {
                        this.aeI.n("ptype", "4");
                    }
                    e.a(this.aeI, writeData);
                    str2 = imagesCodeForPost;
                    break;
                case 2:
                    this.aeI.setUrl(etC);
                    this.aeI.n("tid", writeData.getThreadId());
                    this.aeI.n("kw", writeData.getForumName());
                    this.aeI.n("quote_id", String.valueOf(writeData.getFloor()));
                    this.aeI.n("is_twzhibo_thread", String.valueOf(0));
                    this.aeI.n("floor_num", String.valueOf(writeData.getFloorNum()));
                    if (writeData.getRepostId() != null) {
                        this.aeI.n("repostid", writeData.getRepostId());
                    }
                    this.aeI.n("is_ad", writeData.getIsAd() ? "1" : "0");
                    this.aeI.n(WriteActivityConfig.IS_ADDITION, writeData.isAddition() ? "1" : "0");
                    this.aeI.n("is_giftpost", writeData.isGiftPost() ? "1" : "0");
                    this.aeI.n("is_giftpost", writeData.isGiftPost() ? "1" : "0");
                    if (writeData.isAddition()) {
                        this.aeI.n("st_type", "conadd");
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
                    this.aeI.setUrl(etB);
                    this.aeI.n("kw", writeData.getForumName());
                    this.aeI.n("title", writeData.getTitle());
                    this.aeI.n("thread_type", "33");
                    e.a(this.aeI, writeData);
                    str2 = imagesCodeForPost;
                    break;
                case 5:
                    this.aeI.setUrl(etC);
                    this.aeI.n("tid", writeData.getThreadId());
                    this.aeI.n("kw", writeData.getForumName());
                    this.aeI.n("is_twzhibo_thread", String.valueOf(1));
                    e.a(this.aeI, writeData);
                    str2 = imagesCodeForPost;
                    break;
                case 6:
                    this.aeI.setUrl(etB);
                    this.aeI.n("kw", writeData.getForumName());
                    this.aeI.n("thread_type", String.valueOf(36));
                    this.aeI.n("title", writeData.getTitle());
                    this.aeI.n("is_ntitle", writeData.isNoTitle() ? "1" : "0");
                    if (writeData.isNoTitle()) {
                        this.aeI.n("st_type", "notitle");
                    }
                    e.a(this.aeI, writeData);
                    str2 = imagesCodeForPost;
                    break;
            }
        }
        String tc = this.aeI.tc();
        pq(95);
        if (this.aeI.tA().uv().nZ()) {
            this.etE.parserJson(tc);
        } else {
            this.etE.setError_code(this.aeI.tD() ? this.aeI.tE() : this.aeI.tF());
            this.etE.setError_msg(this.aeI.getErrorString());
        }
        if (this.etE.error_code != 0 && !i.fq()) {
            this.etE.setError_msg(TbadkCoreApplication.m11getInst().getApp().getString(t.j.neterror));
        } else if (this.etE.error_code != 0 && ((writeData.isHasImages() || writeData.getIsBaobao()) && j.isEmpty(String.valueOf(writeData.getContent()) + str2))) {
            this.etE.setError_msg(TbadkCoreApplication.m11getInst().getApp().getString(t.j.img_upload_error));
        }
        try {
            this.etF = new AntiData();
            this.etF.parserJson(new JSONObject(tc).optJSONObject("anti_stat"));
        } catch (Exception e) {
        }
        pq(100);
        return tc;
    }

    private boolean nV(String str) {
        p pVar;
        if (StringUtils.isNull(str)) {
            return true;
        }
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_GRAFFITI_COMMON_MANAGER, p.class);
        return runTask == null || (pVar = (p) runTask.getData()) == null || pVar.iD(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pq(int i) {
        if (this.etH != null) {
            this.etH.pr(i);
        }
    }

    public boolean nZ() {
        if (this.aeI == null) {
            return false;
        }
        return this.aeI.tA().uv().nZ();
    }

    public void cancel() {
        this.aug = true;
        if (this.aeI != null) {
            this.aeI.dl();
        }
        if (this.atT != null) {
            this.atT.cancel();
        }
        if (this.etG != null) {
            this.etG.aUS();
        }
    }

    public AntiData aUl() {
        return this.etF;
    }

    public ErrorData aUm() {
        return this.etE;
    }
}
