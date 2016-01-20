package com.baidu.tieba.tbadkCore.c;

import android.location.Address;
import android.text.TextUtils;
import com.baidu.adp.lib.util.i;
import com.baidu.adp.lib.util.j;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.CreateGroupActivityActivityConfig;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
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
    private static final String dHG = String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.POST_THREAD_ADDRESS;
    private static final String dHH = String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.REPLY_THREAD_ADDRESS;
    public static final String dHI = String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.POST_THREAD_FOR_SHARE_ADDRESS;
    private ab ahV = null;
    private boolean awH = false;
    private c awu;
    private ErrorData dHJ;
    private AntiData dHK;
    private com.baidu.tieba.tbadkCore.videoupload.a dHL;

    /* renamed from: com.baidu.tieba.tbadkCore.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0081a {
        public static int dHM = 1;
    }

    public a() {
        this.dHJ = null;
        this.dHJ = new ErrorData();
    }

    public ImageUploadResult d(ImageFileInfo imageFileInfo, boolean z) {
        if (imageFileInfo == null) {
            return null;
        }
        if (this.awu == null) {
            this.awu = new c("HTTPWriteService.postImageData");
        }
        return this.awu.c(imageFileInfo, z);
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
        this.ahV = new ab();
        this.ahV.uw().vp().mIsNeedTbs = true;
        if (writeData.getType() == 3) {
            if (writeData.getVcode() != null && writeData.getVcode().length() > 0) {
                this.ahV.o("vcode", writeData.getVcode());
            }
            if (TbadkCoreApplication.m411getInst().getNewVcodeWebviewCrashCount() < 3) {
                this.ahV.o("tag", "11");
            }
            this.ahV.o("newVcode", "1");
            this.ahV.o(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_CONTENT, writeData.getContent());
            this.ahV.setUrl(dHI);
            this.ahV.o(ImageViewerConfig.FORUM_NAME, writeData.getForumName());
            this.ahV.o("title", writeData.getTitle());
            this.ahV.o("apiKey", writeData.getShareApiKey());
            this.ahV.o("appName", writeData.getShareAppName());
            this.ahV.o("signKey", writeData.getShareSignKey());
            this.ahV.o("summary_title", writeData.getShareSummaryTitle());
            this.ahV.o("summary_content", writeData.getShareSummaryContent());
            this.ahV.o("summary_img", writeData.getShareSummaryImg());
            this.ahV.o(WriteShareActivityConfig.SHARE_SUMMARY_IMG_WIDTH, String.valueOf(writeData.getShareSummaryImgWidth()));
            this.ahV.o(WriteShareActivityConfig.SHARE_SUMMARY_IMG_HEIGHT, String.valueOf(writeData.getShareSummaryImgHeight()));
            this.ahV.o(WriteShareActivityConfig.SHARE_SUMMARY_IMG_TYPE, writeData.getShareSummaryImgType());
            this.ahV.o("referUrl", writeData.getShareReferUrl());
            str2 = null;
        } else {
            if (z && writeData.isHasImages()) {
                if (this.awu == null) {
                    this.awu = new c("HTTPWriteService.postWriteData");
                }
                if (writeData.getType() == 6) {
                    if (!this.awu.b(writeData.getWriteImagesInfo(), true)) {
                        this.dHJ.setError_code(-53);
                        this.dHJ.setError_msg(TbadkCoreApplication.m411getInst().getString(n.j.upload_error));
                        return null;
                    }
                } else {
                    this.awu.c(writeData.getWriteImagesInfo(), true);
                }
            }
            if (this.awH) {
                return null;
            }
            if (writeData.getIsBaobao()) {
                if (this.awu == null) {
                    this.awu = new c("HTTPWriteService.postWriteData");
                }
                this.awu.c(writeData.getBaobaoImagesInfo(), true);
            }
            if (this.awH) {
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
                d dT = cVar.dT(q);
                if (dT != null && dT.isSuccess()) {
                    com.baidu.tbadk.coreExtra.data.c wM = dT.wM();
                    if (wM != null) {
                        returnVoiceMd5 = wM.wK();
                        b.ad(writeData.getVoice(), returnVoiceMd5);
                        writeData.setReturnVoiceMd5(returnVoiceMd5);
                    } else {
                        m mVar = new m();
                        mVar.h("ErrCode", Integer.valueOf(dT.getErrorCode()));
                        mVar.h("ErrMsg", dT.getErrorString());
                        TiebaStatic.voiceError(TbErrInfo.ERR_VOI_SEND, "audioUploadData is null", mVar.toString());
                        this.dHJ.setError_code(dT.getErrorCode());
                        this.dHJ.setError_msg(dT.getErrorString());
                        return null;
                    }
                } else {
                    m mVar2 = new m();
                    mVar2.h("audioFile", q);
                    TiebaStatic.voiceError(TbErrInfo.ERR_VOI_SEND, "uploadService.upload null or fail", mVar2.toString());
                    this.dHJ.setError_code(dT.getErrorCode());
                    this.dHJ.setError_msg(dT.getErrorString());
                    return null;
                }
            }
            if (this.awH) {
                return null;
            }
            VideoInfo videoInfo = writeData.getVideoInfo();
            if (videoInfo != null) {
                if (videoInfo.needUploadVideo()) {
                    this.dHL = new com.baidu.tieba.tbadkCore.videoupload.a();
                    VideoFinishResult mE = this.dHL.mE(videoInfo.getVideoPath());
                    if (mE == null) {
                        this.dHJ.setError_code(-53);
                        this.dHJ.setError_msg(TbadkCoreApplication.m411getInst().getString(n.j.upload_error));
                        return null;
                    } else if (mE.isSuccess()) {
                        videoInfo.setVideoMd5(mE.getVideoMd5());
                        videoInfo.setVideoUrl(mE.getVideoUrl());
                    } else {
                        this.dHJ.setError_code(mE.getErrorNo());
                        this.dHJ.setError_msg(mE.getUserMessage());
                        return null;
                    }
                }
                if (videoInfo.needUploadThunmb()) {
                    if (this.awu == null) {
                        this.awu = new c("HTTPWriteService.postWriteData");
                    }
                    ImageUploadResult s = this.awu.s(videoInfo.getThumbPath(), false);
                    if (s != null) {
                        videoInfo.setThumbId(s.picId);
                    }
                }
            }
            if (this.awH) {
                return null;
            }
            this.ahV.o("anonymous", "1");
            this.ahV.o(ImageViewerConfig.FORUM_ID, writeData.getForumId());
            if (returnVoiceMd5 != null) {
                this.ahV.o("voice_md5", returnVoiceMd5);
                this.ahV.o("during_time", String.valueOf(voiceDuringTime));
            }
            String imagesCodeForPost = writeData.getImagesCodeForPost();
            if (writeData.getType() != 6 && ((writeData.getType() != 0 || (writeData.getType() == 0 && TextUtils.isEmpty(writeData.getTitle()))) && TextUtils.isEmpty(returnVoiceMd5) && TextUtils.isEmpty(imagesCodeForPost) && TextUtils.isEmpty(writeData.getContent()) && writeData.getVideoInfo() == null)) {
                this.dHJ.setError_code(-53);
                this.dHJ.setError_msg(TbadkCoreApplication.m411getInst().getString(n.j.sand_fail));
                return null;
            }
            if (writeData.getVcode() != null && writeData.getVcode().length() > 0) {
                this.ahV.o("vcode", writeData.getVcode());
            }
            if (TbadkCoreApplication.m411getInst().getNewVcodeWebviewCrashCount() < 3) {
                this.ahV.o("vcode_tag", "11");
            }
            Address y = com.baidu.adp.lib.e.a.gD().y(false);
            this.ahV.o("new_vcode", "1");
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
            this.ahV.o(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_CONTENT, str);
            if (writeData.getIsBaobaoImageUploaded()) {
                this.ahV.o("tail_type", String.valueOf(C0081a.dHM));
                this.ahV.o("tail_content", writeData.getBaobaoContent());
                writeData.setBabaoPosted(true);
            } else {
                writeData.setBabaoPosted(false);
            }
            switch (writeData.getType()) {
                case 0:
                    this.ahV.setUrl(dHG);
                    this.ahV.o("kw", writeData.getForumName());
                    this.ahV.o("title", writeData.getTitle());
                    this.ahV.o("is_ntitle", writeData.isNoTitle() ? "1" : "0");
                    if (writeData.isNoTitle()) {
                        this.ahV.o("st_type", "notitle");
                    }
                    if (writeData.getLiveCardData() != null) {
                        this.ahV.o("group_id", String.valueOf(writeData.getLiveCardData().getGroupId()));
                        this.ahV.o("start_time", String.valueOf(writeData.getLiveCardData().getStartTime()));
                    }
                    if (y != null && TbadkCoreApplication.m411getInst().getIsLocationOn() && !TbConfig.getPositionPagerId().equals(writeData.getForumId())) {
                        this.ahV.o("lbs", String.valueOf(String.valueOf(y.getLatitude())) + "," + String.valueOf(y.getLongitude()));
                    }
                    e.a(this.ahV, writeData);
                    if (writeData.getCategoryFrom() >= 0) {
                        this.ahV.o("fromCategoryId", String.valueOf(writeData.getCategoryFrom()));
                    }
                    if (writeData.getCategoryTo() >= 0) {
                        this.ahV.o("toCategoryId", String.valueOf(writeData.getCategoryTo()));
                        str2 = imagesCodeForPost;
                        break;
                    }
                    str2 = imagesCodeForPost;
                    break;
                case 1:
                    this.ahV.setUrl(dHH);
                    this.ahV.o("tid", writeData.getThreadId());
                    this.ahV.o("kw", writeData.getForumName());
                    this.ahV.o("is_ad", writeData.getIsAd() ? "1" : "0");
                    if (writeData.isFrsReply()) {
                        this.ahV.o("st_param", "frs");
                    }
                    if (com.baidu.tbadk.editortools.d.b.BK().getStatus() == 1) {
                        this.ahV.o("ptype", "4");
                    }
                    e.a(this.ahV, writeData);
                    str2 = imagesCodeForPost;
                    break;
                case 2:
                    this.ahV.setUrl(dHH);
                    this.ahV.o("tid", writeData.getThreadId());
                    this.ahV.o("kw", writeData.getForumName());
                    this.ahV.o("quote_id", String.valueOf(writeData.getFloor()));
                    this.ahV.o("is_twzhibo_thread", String.valueOf(0));
                    this.ahV.o("floor_num", String.valueOf(writeData.getFloorNum()));
                    if (writeData.getRepostId() != null) {
                        this.ahV.o("repostid", writeData.getRepostId());
                    }
                    this.ahV.o("is_ad", writeData.getIsAd() ? "1" : "0");
                    this.ahV.o(WriteActivityConfig.IS_ADDITION, writeData.isAddition() ? "1" : "0");
                    this.ahV.o("is_giftpost", writeData.isGiftPost() ? "1" : "0");
                    this.ahV.o("is_giftpost", writeData.isGiftPost() ? "1" : "0");
                    if (writeData.isAddition()) {
                        this.ahV.o("st_type", "conadd");
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
                    this.ahV.setUrl(dHG);
                    this.ahV.o("kw", writeData.getForumName());
                    this.ahV.o("title", writeData.getTitle());
                    this.ahV.o(PbActivityConfig.KEY_THREAD_TYPE, "33");
                    e.a(this.ahV, writeData);
                    str2 = imagesCodeForPost;
                    break;
                case 5:
                    this.ahV.setUrl(dHH);
                    this.ahV.o("tid", writeData.getThreadId());
                    this.ahV.o("kw", writeData.getForumName());
                    this.ahV.o("is_twzhibo_thread", String.valueOf(1));
                    e.a(this.ahV, writeData);
                    str2 = imagesCodeForPost;
                    break;
                case 6:
                    this.ahV.setUrl(dHG);
                    this.ahV.o("kw", writeData.getForumName());
                    this.ahV.o(PbActivityConfig.KEY_THREAD_TYPE, String.valueOf(36));
                    this.ahV.o("title", writeData.getTitle());
                    this.ahV.o("is_ntitle", writeData.isNoTitle() ? "1" : "0");
                    if (writeData.isNoTitle()) {
                        this.ahV.o("st_type", "notitle");
                    }
                    e.a(this.ahV, writeData);
                    str2 = imagesCodeForPost;
                    break;
            }
        }
        String tV = this.ahV.tV();
        if (this.ahV.uw().vq().qO()) {
            this.dHJ.parserJson(tV);
        } else {
            this.dHJ.setError_code(this.ahV.uz() ? this.ahV.uA() : this.ahV.uB());
            this.dHJ.setError_msg(this.ahV.getErrorString());
        }
        if (this.dHJ.error_code != 0 && !i.iQ()) {
            this.dHJ.setError_msg(TbadkCoreApplication.m411getInst().getApp().getString(n.j.neterror));
        } else if (this.dHJ.error_code != 0 && ((writeData.isHasImages() || writeData.getIsBaobao()) && j.isEmpty(String.valueOf(writeData.getContent()) + str2))) {
            this.dHJ.setError_msg(TbadkCoreApplication.m411getInst().getApp().getString(n.j.img_upload_error));
        }
        try {
            this.dHK = new AntiData();
            this.dHK.parserJson(new JSONObject(tV).optJSONObject("anti_stat"));
        } catch (Exception e) {
        }
        return tV;
    }

    public boolean qO() {
        if (this.ahV == null) {
            return false;
        }
        return this.ahV.uw().vq().qO();
    }

    public void cancel() {
        this.awH = true;
        if (this.ahV != null) {
            this.ahV.gL();
        }
        if (this.awu != null) {
            this.awu.cancel();
        }
        if (this.dHL != null) {
            this.dHL.aGr();
        }
    }

    public AntiData aFG() {
        return this.dHK;
    }

    public ErrorData aFH() {
        return this.dHJ;
    }
}
