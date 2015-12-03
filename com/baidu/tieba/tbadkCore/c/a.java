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
import com.baidu.tbadk.core.util.ab;
import com.baidu.tbadk.core.util.m;
import com.baidu.tbadk.core.voice.a.b;
import com.baidu.tbadk.coreExtra.data.VideoInfo;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.coreExtra.data.d;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tbadk.img.ImageUploadResult;
import com.baidu.tbadk.img.c;
import com.baidu.tieba.n;
import com.baidu.tieba.tbadkCore.videoupload.VideoFinishResult;
import com.baidu.tieba.tbadkCore.writeModel.e;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class a {
    private static final String dAb = String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.POST_THREAD_ADDRESS;
    private static final String dAc = String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.REPLY_THREAD_ADDRESS;
    public static final String dAd = String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.POST_THREAD_FOR_SHARE_ADDRESS;
    private c auQ;
    private ErrorData dAe;
    private AntiData dAf;
    private com.baidu.tieba.tbadkCore.videoupload.a dAg;
    private ab agS = null;
    private boolean avd = false;

    /* renamed from: com.baidu.tieba.tbadkCore.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0085a {
        public static int dAh = 1;
    }

    public a() {
        this.dAe = null;
        this.dAe = new ErrorData();
    }

    public ImageUploadResult d(ImageFileInfo imageFileInfo, boolean z) {
        if (imageFileInfo == null) {
            return null;
        }
        if (this.auQ == null) {
            this.auQ = new c("HTTPWriteService.postImageData");
        }
        return this.auQ.c(imageFileInfo, z);
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
        this.agS = new ab();
        this.agS.uM().vF().mIsNeedTbs = true;
        if (writeData.getType() == 3) {
            if (writeData.getVcode() != null && writeData.getVcode().length() > 0) {
                this.agS.o("vcode", writeData.getVcode());
            }
            if (TbadkCoreApplication.m411getInst().getNewVcodeWebviewCrashCount() < 3) {
                this.agS.o("tag", "11");
            }
            this.agS.o("newVcode", "1");
            this.agS.o(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_CONTENT, writeData.getContent());
            this.agS.setUrl(dAd);
            this.agS.o(ImageViewerConfig.FORUM_NAME, writeData.getForumName());
            this.agS.o("title", writeData.getTitle());
            this.agS.o("apiKey", writeData.getShareApiKey());
            this.agS.o("appName", writeData.getShareAppName());
            this.agS.o("signKey", writeData.getShareSignKey());
            this.agS.o("summary_title", writeData.getShareSummaryTitle());
            this.agS.o("summary_content", writeData.getShareSummaryContent());
            this.agS.o("summary_img", writeData.getShareSummaryImg());
            this.agS.o(WriteShareActivityConfig.SHARE_SUMMARY_IMG_WIDTH, String.valueOf(writeData.getShareSummaryImgWidth()));
            this.agS.o(WriteShareActivityConfig.SHARE_SUMMARY_IMG_HEIGHT, String.valueOf(writeData.getShareSummaryImgHeight()));
            this.agS.o(WriteShareActivityConfig.SHARE_SUMMARY_IMG_TYPE, writeData.getShareSummaryImgType());
            this.agS.o("referUrl", writeData.getShareReferUrl());
            str2 = null;
        } else {
            if (z && writeData.isHasImages()) {
                if (this.auQ == null) {
                    this.auQ = new c("HTTPWriteService.postWriteData");
                }
                if (writeData.getType() == 6) {
                    if (!this.auQ.b(writeData.getWriteImagesInfo(), true)) {
                        this.dAe.setError_code(-53);
                        this.dAe.setError_msg(TbadkCoreApplication.m411getInst().getString(n.i.upload_error));
                        return null;
                    }
                } else {
                    this.auQ.c(writeData.getWriteImagesInfo(), true);
                }
            }
            if (this.avd) {
                return null;
            }
            if (writeData.getIsBaobao()) {
                if (this.auQ == null) {
                    this.auQ = new c("HTTPWriteService.postWriteData");
                }
                this.auQ.c(writeData.getBaobaoImagesInfo(), true);
            }
            if (this.avd) {
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
                String q = com.baidu.tbadk.core.util.n.q(voice, 1);
                d dQ = cVar.dQ(q);
                if (dQ != null && dQ.isSuccess()) {
                    com.baidu.tbadk.coreExtra.data.c xd = dQ.xd();
                    if (xd != null) {
                        returnVoiceMd5 = xd.xb();
                        b.ae(writeData.getVoice(), returnVoiceMd5);
                        writeData.setReturnVoiceMd5(returnVoiceMd5);
                    } else {
                        m mVar = new m();
                        mVar.h("ErrCode", Integer.valueOf(dQ.getErrorCode()));
                        mVar.h("ErrMsg", dQ.getErrorString());
                        TiebaStatic.voiceError(TbErrInfo.ERR_VOI_SEND, "audioUploadData is null", mVar.toString());
                        this.dAe.setError_code(dQ.getErrorCode());
                        this.dAe.setError_msg(dQ.getErrorString());
                        return null;
                    }
                } else {
                    m mVar2 = new m();
                    mVar2.h("audioFile", q);
                    TiebaStatic.voiceError(TbErrInfo.ERR_VOI_SEND, "uploadService.upload null or fail", mVar2.toString());
                    this.dAe.setError_code(dQ.getErrorCode());
                    this.dAe.setError_msg(dQ.getErrorString());
                    return null;
                }
            }
            if (this.avd) {
                return null;
            }
            VideoInfo videoInfo = writeData.getVideoInfo();
            if (videoInfo != null) {
                if (videoInfo.needUploadVideo()) {
                    this.dAg = new com.baidu.tieba.tbadkCore.videoupload.a();
                    VideoFinishResult mG = this.dAg.mG(videoInfo.getVideoPath());
                    if (mG == null) {
                        this.dAe.setError_code(-53);
                        this.dAe.setError_msg(TbadkCoreApplication.m411getInst().getString(n.i.upload_error));
                        return null;
                    } else if (mG.isSuccess()) {
                        videoInfo.setVideoMd5(mG.getVideoMd5());
                        videoInfo.setVideoUrl(mG.getVideoUrl());
                    } else {
                        this.dAe.setError_code(mG.getErrorNo());
                        this.dAe.setError_msg(mG.getUserMessage());
                        return null;
                    }
                }
                if (videoInfo.needUploadThunmb()) {
                    if (this.auQ == null) {
                        this.auQ = new c("HTTPWriteService.postWriteData");
                    }
                    ImageUploadResult s = this.auQ.s(videoInfo.getThumbPath(), false);
                    if (s != null) {
                        videoInfo.setThumbId(s.picId);
                    }
                }
            }
            if (this.avd) {
                return null;
            }
            this.agS.o("anonymous", "1");
            this.agS.o(ImageViewerConfig.FORUM_ID, writeData.getForumId());
            if (returnVoiceMd5 != null) {
                this.agS.o("voice_md5", returnVoiceMd5);
                this.agS.o("during_time", String.valueOf(voiceDuringTime));
            }
            String imagesCodeForPost = writeData.getImagesCodeForPost();
            if (writeData.getType() != 6 && ((writeData.getType() != 0 || (writeData.getType() == 0 && TextUtils.isEmpty(writeData.getTitle()))) && TextUtils.isEmpty(returnVoiceMd5) && TextUtils.isEmpty(imagesCodeForPost) && TextUtils.isEmpty(writeData.getContent()) && writeData.getVideoInfo() == null)) {
                this.dAe.setError_code(-53);
                this.dAe.setError_msg(TbadkCoreApplication.m411getInst().getString(n.i.sand_fail));
                return null;
            }
            if (writeData.getVcode() != null && writeData.getVcode().length() > 0) {
                this.agS.o("vcode", writeData.getVcode());
            }
            if (TbadkCoreApplication.m411getInst().getNewVcodeWebviewCrashCount() < 3) {
                this.agS.o("vcode_tag", "11");
            }
            Address y = com.baidu.adp.lib.e.a.gD().y(false);
            this.agS.o("new_vcode", "1");
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
            this.agS.o(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_CONTENT, str);
            if (writeData.getIsBaobaoImageUploaded()) {
                this.agS.o("tail_type", String.valueOf(C0085a.dAh));
                this.agS.o("tail_content", writeData.getBaobaoContent());
                writeData.setBabaoPosted(true);
            } else {
                writeData.setBabaoPosted(false);
            }
            switch (writeData.getType()) {
                case 0:
                    this.agS.setUrl(dAb);
                    this.agS.o("kw", writeData.getForumName());
                    this.agS.o("title", writeData.getTitle());
                    this.agS.o("is_ntitle", writeData.isNoTitle() ? "1" : "0");
                    if (writeData.isNoTitle()) {
                        this.agS.o("st_type", "notitle");
                    }
                    if (writeData.getLiveCardData() != null) {
                        this.agS.o("group_id", String.valueOf(writeData.getLiveCardData().getGroupId()));
                        this.agS.o("start_time", String.valueOf(writeData.getLiveCardData().getStartTime()));
                    }
                    if (y != null && TbadkCoreApplication.m411getInst().getIsLocationOn() && !TbConfig.getPositionPagerId().equals(writeData.getForumId())) {
                        this.agS.o("lbs", String.valueOf(String.valueOf(y.getLatitude())) + "," + String.valueOf(y.getLongitude()));
                    }
                    e.a(this.agS, writeData);
                    if (writeData.getCategoryFrom() >= 0) {
                        this.agS.o("fromCategoryId", String.valueOf(writeData.getCategoryFrom()));
                    }
                    if (writeData.getCategoryTo() >= 0) {
                        this.agS.o("toCategoryId", String.valueOf(writeData.getCategoryTo()));
                        str2 = imagesCodeForPost;
                        break;
                    }
                    str2 = imagesCodeForPost;
                    break;
                case 1:
                    this.agS.setUrl(dAc);
                    this.agS.o("tid", writeData.getThreadId());
                    this.agS.o("kw", writeData.getForumName());
                    this.agS.o("is_ad", writeData.getIsAd() ? "1" : "0");
                    if (writeData.isFrsReply()) {
                        this.agS.o("st_param", "frs");
                    }
                    if (com.baidu.tbadk.editortools.d.b.BV().getStatus() == 1) {
                        this.agS.o("ptype", "4");
                    }
                    e.a(this.agS, writeData);
                    str2 = imagesCodeForPost;
                    break;
                case 2:
                    this.agS.setUrl(dAc);
                    this.agS.o("tid", writeData.getThreadId());
                    this.agS.o("kw", writeData.getForumName());
                    this.agS.o("quote_id", String.valueOf(writeData.getFloor()));
                    this.agS.o("is_twzhibo_thread", String.valueOf(0));
                    this.agS.o("floor_num", String.valueOf(writeData.getFloorNum()));
                    if (writeData.getRepostId() != null) {
                        this.agS.o("repostid", writeData.getRepostId());
                    }
                    this.agS.o("is_ad", writeData.getIsAd() ? "1" : "0");
                    this.agS.o(WriteActivityConfig.IS_ADDITION, writeData.isAddition() ? "1" : "0");
                    this.agS.o("is_giftpost", writeData.isGiftPost() ? "1" : "0");
                    this.agS.o("is_giftpost", writeData.isGiftPost() ? "1" : "0");
                    if (writeData.isAddition()) {
                        this.agS.o("st_type", "conadd");
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
                    this.agS.setUrl(dAb);
                    this.agS.o("kw", writeData.getForumName());
                    this.agS.o("title", writeData.getTitle());
                    this.agS.o("thread_type", "33");
                    e.a(this.agS, writeData);
                    str2 = imagesCodeForPost;
                    break;
                case 5:
                    this.agS.setUrl(dAc);
                    this.agS.o("tid", writeData.getThreadId());
                    this.agS.o("kw", writeData.getForumName());
                    this.agS.o("is_twzhibo_thread", String.valueOf(1));
                    e.a(this.agS, writeData);
                    str2 = imagesCodeForPost;
                    break;
                case 6:
                    this.agS.setUrl(dAb);
                    this.agS.o("kw", writeData.getForumName());
                    this.agS.o("thread_type", String.valueOf(36));
                    this.agS.o("title", writeData.getTitle());
                    this.agS.o("is_ntitle", writeData.isNoTitle() ? "1" : "0");
                    if (writeData.isNoTitle()) {
                        this.agS.o("st_type", "notitle");
                    }
                    e.a(this.agS, writeData);
                    str2 = imagesCodeForPost;
                    break;
            }
        }
        String ul = this.agS.ul();
        if (this.agS.uM().vG().rf()) {
            this.dAe.parserJson(ul);
        } else {
            this.dAe.setError_code(this.agS.uP() ? this.agS.uQ() : this.agS.uR());
            this.dAe.setError_msg(this.agS.getErrorString());
        }
        if (this.dAe.error_code != 0 && !i.iP()) {
            this.dAe.setError_msg(TbadkCoreApplication.m411getInst().getApp().getString(n.i.neterror));
        } else if (this.dAe.error_code != 0 && ((writeData.isHasImages() || writeData.getIsBaobao()) && j.isEmpty(String.valueOf(writeData.getContent()) + str2))) {
            this.dAe.setError_msg(TbadkCoreApplication.m411getInst().getApp().getString(n.i.img_upload_error));
        }
        try {
            this.dAf = new AntiData();
            this.dAf.parserJson(new JSONObject(ul).optJSONObject("anti_stat"));
        } catch (Exception e) {
        }
        return ul;
    }

    public boolean rf() {
        if (this.agS == null) {
            return false;
        }
        return this.agS.uM().vG().rf();
    }

    public void cancel() {
        this.avd = true;
        if (this.agS != null) {
            this.agS.gL();
        }
        if (this.auQ != null) {
            this.auQ.cancel();
        }
        if (this.dAg != null) {
            this.dAg.aEd();
        }
    }

    public AntiData aDt() {
        return this.dAf;
    }

    public ErrorData aDu() {
        return this.dAe;
    }
}
