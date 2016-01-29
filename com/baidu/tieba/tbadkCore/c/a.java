package com.baidu.tieba.tbadkCore.c;

import android.location.Address;
import android.text.TextUtils;
import com.baidu.adp.lib.util.i;
import com.baidu.adp.lib.util.j;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.CreateGroupActivityActivityConfig;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.atomData.WriteActivityConfig;
import com.baidu.tbadk.core.atomData.WriteShareActivityConfig;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.ErrorData;
import com.baidu.tbadk.core.util.TbErrInfo;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aa;
import com.baidu.tbadk.core.util.l;
import com.baidu.tbadk.core.util.m;
import com.baidu.tbadk.coreExtra.data.VideoInfo;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.coreExtra.data.d;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tbadk.img.ImageUploadResult;
import com.baidu.tbadk.img.c;
import com.baidu.tieba.t;
import com.baidu.tieba.tbadkCore.videoupload.VideoFinishResult;
import com.baidu.tieba.tbadkCore.writeModel.e;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class a {
    private static final String dXD = String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.POST_THREAD_ADDRESS;
    private static final String dXE = String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.REPLY_THREAD_ADDRESS;
    public static final String dXF = String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.POST_THREAD_FOR_SHARE_ADDRESS;
    private c axl;
    private ErrorData dXG;
    private AntiData dXH;
    private com.baidu.tieba.tbadkCore.videoupload.a dXI;
    private InterfaceC0085a dXJ;
    private aa aiG = null;
    private boolean axy = false;

    /* renamed from: com.baidu.tieba.tbadkCore.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0085a {
        void om(int i);
    }

    /* loaded from: classes.dex */
    public static class b {
        public static int dXM = 1;
    }

    public a() {
        this.dXG = null;
        this.dXG = new ErrorData();
    }

    public void a(InterfaceC0085a interfaceC0085a) {
        this.dXJ = interfaceC0085a;
    }

    public ImageUploadResult d(ImageFileInfo imageFileInfo, boolean z) {
        if (imageFileInfo == null) {
            return null;
        }
        if (this.axl == null) {
            this.axl = new c("HTTPWriteService.postImageData");
        }
        return this.axl.c(imageFileInfo, z);
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
        this.aiG = new aa();
        this.aiG.vB().wv().mIsNeedTbs = true;
        if (writeData.getType() == 3) {
            if (writeData.getVcode() != null && writeData.getVcode().length() > 0) {
                this.aiG.p("vcode", writeData.getVcode());
            }
            if (TbadkCoreApplication.m411getInst().getNewVcodeWebviewCrashCount() < 3) {
                this.aiG.p("tag", "11");
            }
            this.aiG.p("newVcode", "1");
            this.aiG.p(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_CONTENT, writeData.getContent());
            this.aiG.setUrl(dXF);
            this.aiG.p(ImageViewerConfig.FORUM_NAME, writeData.getForumName());
            this.aiG.p("title", writeData.getTitle());
            this.aiG.p("apiKey", writeData.getShareApiKey());
            this.aiG.p("appName", writeData.getShareAppName());
            this.aiG.p("signKey", writeData.getShareSignKey());
            this.aiG.p("summary_title", writeData.getShareSummaryTitle());
            this.aiG.p("summary_content", writeData.getShareSummaryContent());
            this.aiG.p("summary_img", writeData.getShareSummaryImg());
            this.aiG.p(WriteShareActivityConfig.SHARE_SUMMARY_IMG_WIDTH, String.valueOf(writeData.getShareSummaryImgWidth()));
            this.aiG.p(WriteShareActivityConfig.SHARE_SUMMARY_IMG_HEIGHT, String.valueOf(writeData.getShareSummaryImgHeight()));
            this.aiG.p(WriteShareActivityConfig.SHARE_SUMMARY_IMG_TYPE, writeData.getShareSummaryImgType());
            this.aiG.p("referUrl", writeData.getShareReferUrl());
            str2 = null;
        } else {
            if (z && writeData.isHasImages()) {
                if (this.axl == null) {
                    this.axl = new c("HTTPWriteService.postWriteData");
                }
                if (writeData.getType() == 6) {
                    if (!this.axl.b(writeData.getWriteImagesInfo(), true)) {
                        this.dXG.setError_code(-53);
                        this.dXG.setError_msg(TbadkCoreApplication.m411getInst().getString(t.j.upload_error));
                        return null;
                    }
                } else {
                    this.axl.c(writeData.getWriteImagesInfo(), true);
                }
            }
            if (this.axy) {
                return null;
            }
            if (writeData.getIsBaobao()) {
                if (this.axl == null) {
                    this.axl = new c("HTTPWriteService.postWriteData");
                }
                this.axl.c(writeData.getBaobaoImagesInfo(), true);
            }
            if (this.axy) {
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
                cVar.s("type", 1);
                String q = m.q(voice, 1);
                d dS = cVar.dS(q);
                if (dS != null && dS.isSuccess()) {
                    com.baidu.tbadk.coreExtra.data.c xZ = dS.xZ();
                    if (xZ != null) {
                        returnVoiceMd5 = xZ.getMd5();
                        com.baidu.tbadk.core.voice.a.b.ad(writeData.getVoice(), returnVoiceMd5);
                        writeData.setReturnVoiceMd5(returnVoiceMd5);
                    } else {
                        l lVar = new l();
                        lVar.i("ErrCode", Integer.valueOf(dS.getErrorCode()));
                        lVar.i("ErrMsg", dS.getErrorString());
                        TiebaStatic.voiceError(TbErrInfo.ERR_VOI_SEND, "audioUploadData is null", lVar.toString());
                        this.dXG.setError_code(dS.getErrorCode());
                        this.dXG.setError_msg(dS.getErrorString());
                        return null;
                    }
                } else {
                    l lVar2 = new l();
                    lVar2.i("audioFile", q);
                    TiebaStatic.voiceError(TbErrInfo.ERR_VOI_SEND, "uploadService.upload null or fail", lVar2.toString());
                    this.dXG.setError_code(dS.getErrorCode());
                    this.dXG.setError_msg(dS.getErrorString());
                    return null;
                }
            }
            if (this.axy) {
                return null;
            }
            VideoInfo videoInfo = writeData.getVideoInfo();
            if (videoInfo != null) {
                if (videoInfo.needUploadVideo()) {
                    this.dXI = new com.baidu.tieba.tbadkCore.videoupload.a();
                    VideoFinishResult a = this.dXI.a(writeData.getForumId(), videoInfo.getVideoPath(), new com.baidu.tieba.tbadkCore.c.b(this));
                    if (a == null) {
                        this.dXG.setError_code(-53);
                        this.dXG.setError_msg(TbadkCoreApplication.m411getInst().getString(t.j.upload_error));
                        return null;
                    } else if (a.isSuccess()) {
                        videoInfo.setVideoMd5(a.getVideoMd5());
                        videoInfo.setVideoUrl(a.getVideoUrl());
                    } else {
                        this.dXG.setError_code(a.getErrorNo());
                        this.dXG.setError_msg(a.getUserMessage());
                        return null;
                    }
                }
                if (videoInfo.needUploadThunmb()) {
                    if (this.axl == null) {
                        this.axl = new c("HTTPWriteService.postWriteData");
                    }
                    ImageUploadResult s = this.axl.s(videoInfo.getThumbPath(), false);
                    if (s != null) {
                        videoInfo.setThumbId(s.picId);
                    }
                }
            }
            if (this.axy) {
                return null;
            }
            this.aiG.p("anonymous", "1");
            this.aiG.p(ImageViewerConfig.FORUM_ID, writeData.getForumId());
            if (returnVoiceMd5 != null) {
                this.aiG.p("voice_md5", returnVoiceMd5);
                this.aiG.p("during_time", String.valueOf(voiceDuringTime));
            }
            String imagesCodeForPost = writeData.getImagesCodeForPost();
            if (writeData.getType() != 6 && ((writeData.getType() != 0 || (writeData.getType() == 0 && TextUtils.isEmpty(writeData.getTitle()))) && TextUtils.isEmpty(returnVoiceMd5) && TextUtils.isEmpty(imagesCodeForPost) && TextUtils.isEmpty(writeData.getContent()) && writeData.getVideoInfo() == null)) {
                this.dXG.setError_code(-53);
                this.dXG.setError_msg(TbadkCoreApplication.m411getInst().getString(t.j.sand_fail));
                return null;
            }
            if (writeData.getVcode() != null && writeData.getVcode().length() > 0) {
                this.aiG.p("vcode", writeData.getVcode());
            }
            if (TbadkCoreApplication.m411getInst().getNewVcodeWebviewCrashCount() < 3) {
                this.aiG.p("vcode_tag", "11");
            }
            Address y = com.baidu.adp.lib.e.a.gL().y(false);
            this.aiG.p("new_vcode", "1");
            if (writeData.getVideoInfo() == null || !writeData.getVideoInfo().hasUpload()) {
                str = String.valueOf(writeData.getContent()) + imagesCodeForPost;
            } else {
                str = String.valueOf(writeData.getContent()) + writeData.getVideoInfo().buildContent() + imagesCodeForPost;
            }
            if (writeData.getType() == 6 && writeData.getVoteInfo() != null) {
                if (writeData.getWriteImagesInfo() != null) {
                    writeData.getVoteInfo().setServerImageCode(writeData.getWriteImagesInfo().getChosedFiles());
                }
                str = writeData.getVoteInfo().buildWriteContent();
            }
            this.aiG.p(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_CONTENT, str);
            if (writeData.getIsBaobaoImageUploaded()) {
                this.aiG.p("tail_type", String.valueOf(b.dXM));
                this.aiG.p("tail_content", writeData.getBaobaoContent());
                writeData.setBabaoPosted(true);
            } else {
                writeData.setBabaoPosted(false);
            }
            switch (writeData.getType()) {
                case 0:
                    this.aiG.setUrl(dXD);
                    this.aiG.p("kw", writeData.getForumName());
                    this.aiG.p("title", writeData.getTitle());
                    this.aiG.p("is_ntitle", writeData.isNoTitle() ? "1" : "0");
                    if (writeData.isNoTitle()) {
                        this.aiG.p("st_type", "notitle");
                    }
                    if (y != null && TbadkCoreApplication.m411getInst().getIsLocationOn() && !TbConfig.getPositionPagerId().equals(writeData.getForumId())) {
                        this.aiG.p("lbs", String.valueOf(String.valueOf(y.getLatitude())) + "," + String.valueOf(y.getLongitude()));
                    }
                    e.a(this.aiG, writeData);
                    if (writeData.getCategoryFrom() >= 0) {
                        this.aiG.p("fromCategoryId", String.valueOf(writeData.getCategoryFrom()));
                    }
                    if (writeData.getCategoryTo() >= 0) {
                        this.aiG.p("toCategoryId", String.valueOf(writeData.getCategoryTo()));
                        str2 = imagesCodeForPost;
                        break;
                    }
                    str2 = imagesCodeForPost;
                    break;
                case 1:
                    this.aiG.setUrl(dXE);
                    this.aiG.p("tid", writeData.getThreadId());
                    this.aiG.p("kw", writeData.getForumName());
                    this.aiG.p("is_ad", writeData.getIsAd() ? "1" : "0");
                    if (writeData.isFrsReply()) {
                        this.aiG.p("st_param", "frs");
                    }
                    if (com.baidu.tbadk.editortools.d.b.Da().getStatus() == 1) {
                        this.aiG.p("ptype", "4");
                    }
                    e.a(this.aiG, writeData);
                    str2 = imagesCodeForPost;
                    break;
                case 2:
                    this.aiG.setUrl(dXE);
                    this.aiG.p("tid", writeData.getThreadId());
                    this.aiG.p("kw", writeData.getForumName());
                    this.aiG.p("quote_id", String.valueOf(writeData.getFloor()));
                    this.aiG.p("is_twzhibo_thread", String.valueOf(0));
                    this.aiG.p("floor_num", String.valueOf(writeData.getFloorNum()));
                    if (writeData.getRepostId() != null) {
                        this.aiG.p("repostid", writeData.getRepostId());
                    }
                    this.aiG.p("is_ad", writeData.getIsAd() ? "1" : "0");
                    this.aiG.p(WriteActivityConfig.IS_ADDITION, writeData.isAddition() ? "1" : "0");
                    this.aiG.p("is_giftpost", writeData.isGiftPost() ? "1" : "0");
                    this.aiG.p("is_giftpost", writeData.isGiftPost() ? "1" : "0");
                    if (writeData.isAddition()) {
                        this.aiG.p("st_type", "conadd");
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
                    this.aiG.setUrl(dXD);
                    this.aiG.p("kw", writeData.getForumName());
                    this.aiG.p("title", writeData.getTitle());
                    this.aiG.p("thread_type", "33");
                    e.a(this.aiG, writeData);
                    str2 = imagesCodeForPost;
                    break;
                case 5:
                    this.aiG.setUrl(dXE);
                    this.aiG.p("tid", writeData.getThreadId());
                    this.aiG.p("kw", writeData.getForumName());
                    this.aiG.p("is_twzhibo_thread", String.valueOf(1));
                    e.a(this.aiG, writeData);
                    str2 = imagesCodeForPost;
                    break;
                case 6:
                    this.aiG.setUrl(dXD);
                    this.aiG.p("kw", writeData.getForumName());
                    this.aiG.p("thread_type", String.valueOf(36));
                    this.aiG.p("title", writeData.getTitle());
                    this.aiG.p("is_ntitle", writeData.isNoTitle() ? "1" : "0");
                    if (writeData.isNoTitle()) {
                        this.aiG.p("st_type", "notitle");
                    }
                    e.a(this.aiG, writeData);
                    str2 = imagesCodeForPost;
                    break;
            }
        }
        String uZ = this.aiG.uZ();
        ol(95);
        if (this.aiG.vB().ww().rl()) {
            this.dXG.parserJson(uZ);
        } else {
            this.dXG.setError_code(this.aiG.vE() ? this.aiG.vF() : this.aiG.vG());
            this.dXG.setError_msg(this.aiG.getErrorString());
        }
        if (this.dXG.error_code != 0 && !i.iZ()) {
            this.dXG.setError_msg(TbadkCoreApplication.m411getInst().getApp().getString(t.j.neterror));
        } else if (this.dXG.error_code != 0 && ((writeData.isHasImages() || writeData.getIsBaobao()) && j.isEmpty(String.valueOf(writeData.getContent()) + str2))) {
            this.dXG.setError_msg(TbadkCoreApplication.m411getInst().getApp().getString(t.j.img_upload_error));
        }
        try {
            this.dXH = new AntiData();
            this.dXH.parserJson(new JSONObject(uZ).optJSONObject("anti_stat"));
        } catch (Exception e) {
        }
        ol(100);
        return uZ;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ol(int i) {
        if (this.dXJ != null) {
            this.dXJ.om(i);
        }
    }

    public boolean rl() {
        if (this.aiG == null) {
            return false;
        }
        return this.aiG.vB().ww().rl();
    }

    public void cancel() {
        this.axy = true;
        if (this.aiG != null) {
            this.aiG.gT();
        }
        if (this.axl != null) {
            this.axl.cancel();
        }
        if (this.dXI != null) {
            this.dXI.aNw();
        }
    }

    public AntiData aML() {
        return this.dXH;
    }

    public ErrorData aMM() {
        return this.dXG;
    }
}
