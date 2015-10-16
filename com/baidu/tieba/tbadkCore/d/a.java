package com.baidu.tieba.tbadkCore.d;

import android.location.Address;
import android.text.TextUtils;
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
import com.baidu.tbadk.core.util.m;
import com.baidu.tbadk.core.util.n;
import com.baidu.tbadk.core.util.w;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.coreExtra.data.b;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tbadk.img.ImageUploadResult;
import com.baidu.tbadk.img.c;
import com.baidu.tieba.i;
import com.baidu.tieba.tbadkCore.writeModel.e;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class a {
    private static final String cZE = String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.POST_THREAD_ADDRESS;
    private static final String cZF = String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.REPLY_THREAD_ADDRESS;
    public static final String cZG = String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.POST_THREAD_FOR_SHARE_ADDRESS;
    private c atZ;
    private ErrorData cZH;
    private AntiData cZI;
    private w afh = null;
    private boolean aul = false;

    /* renamed from: com.baidu.tieba.tbadkCore.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0075a {
        public static int cZJ = 1;
    }

    public a() {
        this.cZH = null;
        this.cZH = new ErrorData();
    }

    public ImageUploadResult b(ImageFileInfo imageFileInfo) {
        if (imageFileInfo == null) {
            return null;
        }
        if (this.atZ == null) {
            this.atZ = new c("HTTPWriteService.postImageData");
        }
        return this.atZ.a(imageFileInfo);
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
        this.afh = new w();
        this.afh.uh().uY().mIsNeedTbs = true;
        if (writeData.getType() == 3) {
            if (writeData.getVcode() != null && writeData.getVcode().length() > 0) {
                this.afh.o("vcode", writeData.getVcode());
            }
            if (TbadkCoreApplication.m411getInst().getNewVcodeWebviewCrashCount() < 3) {
                this.afh.o("tag", "11");
            }
            this.afh.o("newVcode", "1");
            this.afh.o(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_CONTENT, writeData.getContent());
            this.afh.setUrl(cZG);
            this.afh.o(ImageViewerConfig.FORUM_NAME, writeData.getForumName());
            this.afh.o("title", writeData.getTitle());
            this.afh.o("apiKey", writeData.getShareApiKey());
            this.afh.o("appName", writeData.getShareAppName());
            this.afh.o("signKey", writeData.getShareSignKey());
            this.afh.o("summary_title", writeData.getShareSummaryTitle());
            this.afh.o("summary_content", writeData.getShareSummaryContent());
            this.afh.o("summary_img", writeData.getShareSummaryImg());
            this.afh.o(WriteShareActivityConfig.SHARE_SUMMARY_IMG_WIDTH, String.valueOf(writeData.getShareSummaryImgWidth()));
            this.afh.o(WriteShareActivityConfig.SHARE_SUMMARY_IMG_HEIGHT, String.valueOf(writeData.getShareSummaryImgHeight()));
            this.afh.o(WriteShareActivityConfig.SHARE_SUMMARY_IMG_TYPE, writeData.getShareSummaryImgType());
            this.afh.o("referUrl", writeData.getShareReferUrl());
            str2 = null;
        } else {
            if (z && writeData.isHasImages()) {
                if (this.atZ == null) {
                    this.atZ = new c("HTTPWriteService.postWriteData");
                }
                if (writeData.getType() == 6) {
                    if (!this.atZ.b(writeData.getWriteImagesInfo())) {
                        this.cZH.setError_code(-53);
                        this.cZH.setError_msg(TbadkCoreApplication.m411getInst().getString(i.h.upload_error));
                        return null;
                    }
                } else {
                    this.atZ.c(writeData.getWriteImagesInfo());
                }
            }
            if (this.aul) {
                return null;
            }
            if (writeData.getIsBaobao()) {
                if (this.atZ == null) {
                    this.atZ = new c("HTTPWriteService.postWriteData");
                }
                this.atZ.c(writeData.getBaobaoImagesInfo());
            }
            if (this.aul) {
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
                String q = n.q(voice, 1);
                com.baidu.tbadk.coreExtra.data.c dI = cVar.dI(q);
                if (dI != null && dI.isSuccess()) {
                    b wh = dI.wh();
                    if (wh != null) {
                        returnVoiceMd5 = wh.wf();
                        com.baidu.tbadk.core.voice.a.b.ah(writeData.getVoice(), returnVoiceMd5);
                        writeData.setReturnVoiceMd5(returnVoiceMd5);
                    } else {
                        m mVar = new m();
                        mVar.h("ErrCode", Integer.valueOf(dI.getErrorCode()));
                        mVar.h("ErrMsg", dI.getErrorString());
                        TiebaStatic.voiceError(TbErrInfo.ERR_VOI_SEND, "audioUploadData is null", mVar.toString());
                        this.cZH.setError_code(dI.getErrorCode());
                        this.cZH.setError_msg(dI.getErrorString());
                        return null;
                    }
                } else {
                    m mVar2 = new m();
                    mVar2.h("audioFile", q);
                    TiebaStatic.voiceError(TbErrInfo.ERR_VOI_SEND, "uploadService.upload null or fail", mVar2.toString());
                    this.cZH.setError_code(dI.getErrorCode());
                    this.cZH.setError_msg(dI.getErrorString());
                    return null;
                }
            }
            if (this.aul) {
                return null;
            }
            this.afh.o("anonymous", "1");
            this.afh.o(ImageViewerConfig.FORUM_ID, writeData.getForumId());
            if (returnVoiceMd5 != null) {
                this.afh.o("voice_md5", returnVoiceMd5);
                this.afh.o("during_time", String.valueOf(voiceDuringTime));
            }
            String imagesCodeForPost = writeData.getImagesCodeForPost();
            if (writeData.getType() != 6 && ((writeData.getType() != 0 || (writeData.getType() == 0 && TextUtils.isEmpty(writeData.getTitle()))) && TextUtils.isEmpty(returnVoiceMd5) && TextUtils.isEmpty(imagesCodeForPost) && TextUtils.isEmpty(writeData.getContent()) && writeData.getVideoInfo() == null)) {
                this.cZH.setError_code(-53);
                this.cZH.setError_msg(TbadkCoreApplication.m411getInst().getString(i.h.sand_fail));
                return null;
            }
            if (writeData.getVcode() != null && writeData.getVcode().length() > 0) {
                this.afh.o("vcode", writeData.getVcode());
            }
            if (TbadkCoreApplication.m411getInst().getNewVcodeWebviewCrashCount() < 3) {
                this.afh.o("vcode_tag", "11");
            }
            Address y = com.baidu.adp.lib.d.a.gC().y(false);
            this.afh.o("new_vcode", "1");
            if (writeData.getVideoInfo() == null) {
                str = String.valueOf(writeData.getContent()) + imagesCodeForPost;
            } else {
                str = String.valueOf(writeData.getContent()) + writeData.getVideoInfo().buildWriteContent(writeData.getForumName()) + imagesCodeForPost;
            }
            if (writeData.getType() == 6 && writeData.getVoteInfo() != null) {
                if (writeData.getWriteImagesInfo() != null) {
                    writeData.getVoteInfo().setServerImageCode(writeData.getWriteImagesInfo().getChosedFiles());
                }
                str = writeData.getVoteInfo().buildWriteContent();
            }
            this.afh.o(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_CONTENT, str);
            if (writeData.getIsBaobaoImageUploaded()) {
                this.afh.o("tail_type", String.valueOf(C0075a.cZJ));
                this.afh.o("tail_content", writeData.getBaobaoContent());
                writeData.setBabaoPosted(true);
            } else {
                writeData.setBabaoPosted(false);
            }
            switch (writeData.getType()) {
                case 0:
                    this.afh.setUrl(cZE);
                    this.afh.o("kw", writeData.getForumName());
                    this.afh.o("title", writeData.getTitle());
                    this.afh.o("is_ntitle", writeData.isNoTitle() ? "1" : "0");
                    if (writeData.isNoTitle()) {
                        this.afh.o("st_type", "notitle");
                    }
                    if (writeData.getLiveCardData() != null) {
                        this.afh.o("group_id", String.valueOf(writeData.getLiveCardData().getGroupId()));
                        this.afh.o("start_time", String.valueOf(writeData.getLiveCardData().getStartTime()));
                    }
                    if (y != null && TbadkCoreApplication.m411getInst().getIsLocationOn() && !TbConfig.getPositionPagerId().equals(writeData.getForumId())) {
                        this.afh.o("lbs", String.valueOf(String.valueOf(y.getLatitude())) + "," + String.valueOf(y.getLongitude()));
                    }
                    e.a(this.afh, writeData);
                    str2 = imagesCodeForPost;
                    break;
                case 1:
                    this.afh.setUrl(cZF);
                    this.afh.o("tid", writeData.getThreadId());
                    this.afh.o("kw", writeData.getForumName());
                    this.afh.o("is_ad", writeData.getIsAd() ? "1" : "0");
                    if (writeData.isFrsReply()) {
                        this.afh.o("st_param", "frs");
                    }
                    e.a(this.afh, writeData);
                    str2 = imagesCodeForPost;
                    break;
                case 2:
                    this.afh.setUrl(cZF);
                    this.afh.o("tid", writeData.getThreadId());
                    this.afh.o("kw", writeData.getForumName());
                    this.afh.o("quote_id", String.valueOf(writeData.getFloor()));
                    this.afh.o("is_twzhibo_thread", String.valueOf(0));
                    this.afh.o("floor_num", String.valueOf(writeData.getFloorNum()));
                    if (writeData.getRepostId() != null) {
                        this.afh.o("repostid", writeData.getRepostId());
                    }
                    this.afh.o("is_ad", writeData.getIsAd() ? "1" : "0");
                    this.afh.o(WriteActivityConfig.IS_ADDITION, writeData.isAddition() ? "1" : "0");
                    this.afh.o("is_giftpost", writeData.isGiftPost() ? "1" : "0");
                    this.afh.o("is_giftpost", writeData.isGiftPost() ? "1" : "0");
                    if (writeData.isAddition()) {
                        this.afh.o("st_type", "conadd");
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
                    this.afh.setUrl(cZE);
                    this.afh.o("kw", writeData.getForumName());
                    this.afh.o("title", writeData.getTitle());
                    this.afh.o("thread_type", "33");
                    e.a(this.afh, writeData);
                    str2 = imagesCodeForPost;
                    break;
                case 5:
                    this.afh.setUrl(cZF);
                    this.afh.o("tid", writeData.getThreadId());
                    this.afh.o("kw", writeData.getForumName());
                    this.afh.o("is_twzhibo_thread", String.valueOf(1));
                    e.a(this.afh, writeData);
                    str2 = imagesCodeForPost;
                    break;
                case 6:
                    this.afh.setUrl(cZE);
                    this.afh.o("kw", writeData.getForumName());
                    this.afh.o("thread_type", String.valueOf(36));
                    this.afh.o("title", writeData.getTitle());
                    this.afh.o("is_ntitle", writeData.isNoTitle() ? "1" : "0");
                    if (writeData.isNoTitle()) {
                        this.afh.o("st_type", "notitle");
                    }
                    e.a(this.afh, writeData);
                    str2 = imagesCodeForPost;
                    break;
            }
        }
        String tG = this.afh.tG();
        if (this.afh.uh().uZ().qV()) {
            this.cZH.parserJson(tG);
        } else {
            this.cZH.setError_code(this.afh.uk() ? this.afh.ul() : this.afh.um());
            this.cZH.setError_msg(this.afh.getErrorString());
        }
        if (this.cZH.error_code != 0 && !com.baidu.adp.lib.util.i.iM()) {
            this.cZH.setError_msg(TbadkCoreApplication.m411getInst().getApp().getString(i.h.neterror));
        } else if (this.cZH.error_code != 0 && ((writeData.isHasImages() || writeData.getIsBaobao()) && j.isEmpty(String.valueOf(writeData.getContent()) + str2))) {
            this.cZH.setError_msg(TbadkCoreApplication.m411getInst().getApp().getString(i.h.img_upload_error));
        }
        try {
            this.cZI = new AntiData();
            this.cZI.parserJson(new JSONObject(tG).optJSONObject("anti_stat"));
        } catch (Exception e) {
        }
        return tG;
    }

    public boolean qV() {
        if (this.afh == null) {
            return false;
        }
        return this.afh.uh().uZ().qV();
    }

    public void cancel() {
        this.aul = true;
        if (this.afh != null) {
            this.afh.gJ();
        }
        if (this.atZ != null) {
            this.atZ.cancel();
        }
    }

    public AntiData awW() {
        return this.cZI;
    }

    public ErrorData awX() {
        return this.cZH;
    }
}
