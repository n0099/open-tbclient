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
    private static final String cZe = String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.POST_THREAD_ADDRESS;
    private static final String cZf = String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.REPLY_THREAD_ADDRESS;
    public static final String cZg = String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.POST_THREAD_FOR_SHARE_ADDRESS;
    private c atY;
    private ErrorData cZh;
    private AntiData cZi;
    private w afg = null;
    private boolean auk = false;

    /* renamed from: com.baidu.tieba.tbadkCore.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0075a {
        public static int cZj = 1;
    }

    public a() {
        this.cZh = null;
        this.cZh = new ErrorData();
    }

    public ImageUploadResult b(ImageFileInfo imageFileInfo) {
        if (imageFileInfo == null) {
            return null;
        }
        if (this.atY == null) {
            this.atY = new c("HTTPWriteService.postImageData");
        }
        return this.atY.a(imageFileInfo);
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
        this.afg = new w();
        this.afg.uh().uX().mIsNeedTbs = true;
        if (writeData.getType() == 3) {
            if (writeData.getVcode() != null && writeData.getVcode().length() > 0) {
                this.afg.o("vcode", writeData.getVcode());
            }
            if (TbadkCoreApplication.m411getInst().getNewVcodeWebviewCrashCount() < 3) {
                this.afg.o("tag", "11");
            }
            this.afg.o("newVcode", "1");
            this.afg.o(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_CONTENT, writeData.getContent());
            this.afg.setUrl(cZg);
            this.afg.o(ImageViewerConfig.FORUM_NAME, writeData.getForumName());
            this.afg.o("title", writeData.getTitle());
            this.afg.o("apiKey", writeData.getShareApiKey());
            this.afg.o("appName", writeData.getShareAppName());
            this.afg.o("signKey", writeData.getShareSignKey());
            this.afg.o("summary_title", writeData.getShareSummaryTitle());
            this.afg.o("summary_content", writeData.getShareSummaryContent());
            this.afg.o("summary_img", writeData.getShareSummaryImg());
            this.afg.o(WriteShareActivityConfig.SHARE_SUMMARY_IMG_WIDTH, String.valueOf(writeData.getShareSummaryImgWidth()));
            this.afg.o(WriteShareActivityConfig.SHARE_SUMMARY_IMG_HEIGHT, String.valueOf(writeData.getShareSummaryImgHeight()));
            this.afg.o(WriteShareActivityConfig.SHARE_SUMMARY_IMG_TYPE, writeData.getShareSummaryImgType());
            this.afg.o("referUrl", writeData.getShareReferUrl());
            str2 = null;
        } else {
            if (z && writeData.isHasImages()) {
                if (this.atY == null) {
                    this.atY = new c("HTTPWriteService.postWriteData");
                }
                if (writeData.getType() == 6) {
                    if (!this.atY.b(writeData.getWriteImagesInfo())) {
                        this.cZh.setError_code(-53);
                        this.cZh.setError_msg(TbadkCoreApplication.m411getInst().getString(i.h.upload_error));
                        return null;
                    }
                } else {
                    this.atY.c(writeData.getWriteImagesInfo());
                }
            }
            if (this.auk) {
                return null;
            }
            if (writeData.getIsBaobao()) {
                if (this.atY == null) {
                    this.atY = new c("HTTPWriteService.postWriteData");
                }
                this.atY.c(writeData.getBaobaoImagesInfo());
            }
            if (this.auk) {
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
                        this.cZh.setError_code(dI.getErrorCode());
                        this.cZh.setError_msg(dI.getErrorString());
                        return null;
                    }
                } else {
                    m mVar2 = new m();
                    mVar2.h("audioFile", q);
                    TiebaStatic.voiceError(TbErrInfo.ERR_VOI_SEND, "uploadService.upload null or fail", mVar2.toString());
                    this.cZh.setError_code(dI.getErrorCode());
                    this.cZh.setError_msg(dI.getErrorString());
                    return null;
                }
            }
            if (this.auk) {
                return null;
            }
            this.afg.o("anonymous", "1");
            this.afg.o(ImageViewerConfig.FORUM_ID, writeData.getForumId());
            if (returnVoiceMd5 != null) {
                this.afg.o("voice_md5", returnVoiceMd5);
                this.afg.o("during_time", String.valueOf(voiceDuringTime));
            }
            String imagesCodeForPost = writeData.getImagesCodeForPost();
            if (writeData.getType() != 6 && ((writeData.getType() != 0 || (writeData.getType() == 0 && TextUtils.isEmpty(writeData.getTitle()))) && TextUtils.isEmpty(returnVoiceMd5) && TextUtils.isEmpty(imagesCodeForPost) && TextUtils.isEmpty(writeData.getContent()) && writeData.getVideoInfo() == null)) {
                this.cZh.setError_code(-53);
                this.cZh.setError_msg(TbadkCoreApplication.m411getInst().getString(i.h.sand_fail));
                return null;
            }
            if (writeData.getVcode() != null && writeData.getVcode().length() > 0) {
                this.afg.o("vcode", writeData.getVcode());
            }
            if (TbadkCoreApplication.m411getInst().getNewVcodeWebviewCrashCount() < 3) {
                this.afg.o("vcode_tag", "11");
            }
            Address y = com.baidu.adp.lib.d.a.gC().y(false);
            this.afg.o("new_vcode", "1");
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
            this.afg.o(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_CONTENT, str);
            if (writeData.getIsBaobaoImageUploaded()) {
                this.afg.o("tail_type", String.valueOf(C0075a.cZj));
                this.afg.o("tail_content", writeData.getBaobaoContent());
                writeData.setBabaoPosted(true);
            } else {
                writeData.setBabaoPosted(false);
            }
            switch (writeData.getType()) {
                case 0:
                    this.afg.setUrl(cZe);
                    this.afg.o("kw", writeData.getForumName());
                    this.afg.o("title", writeData.getTitle());
                    this.afg.o("is_ntitle", writeData.isNoTitle() ? "1" : "0");
                    if (writeData.isNoTitle()) {
                        this.afg.o("st_type", "notitle");
                    }
                    if (writeData.getLiveCardData() != null) {
                        this.afg.o("group_id", String.valueOf(writeData.getLiveCardData().getGroupId()));
                        this.afg.o("start_time", String.valueOf(writeData.getLiveCardData().getStartTime()));
                    }
                    if (y != null && TbadkCoreApplication.m411getInst().getIsLocationOn() && !TbConfig.getPositionPagerId().equals(writeData.getForumId())) {
                        this.afg.o("lbs", String.valueOf(String.valueOf(y.getLatitude())) + "," + String.valueOf(y.getLongitude()));
                    }
                    e.a(this.afg, writeData);
                    str2 = imagesCodeForPost;
                    break;
                case 1:
                    this.afg.setUrl(cZf);
                    this.afg.o("tid", writeData.getThreadId());
                    this.afg.o("kw", writeData.getForumName());
                    this.afg.o("is_ad", writeData.getIsAd() ? "1" : "0");
                    if (writeData.isFrsReply()) {
                        this.afg.o("st_param", "frs");
                    }
                    e.a(this.afg, writeData);
                    str2 = imagesCodeForPost;
                    break;
                case 2:
                    this.afg.setUrl(cZf);
                    this.afg.o("tid", writeData.getThreadId());
                    this.afg.o("kw", writeData.getForumName());
                    this.afg.o("quote_id", String.valueOf(writeData.getFloor()));
                    this.afg.o("is_twzhibo_thread", String.valueOf(0));
                    this.afg.o("floor_num", String.valueOf(writeData.getFloorNum()));
                    if (writeData.getRepostId() != null) {
                        this.afg.o("repostid", writeData.getRepostId());
                    }
                    this.afg.o("is_ad", writeData.getIsAd() ? "1" : "0");
                    this.afg.o(WriteActivityConfig.IS_ADDITION, writeData.isAddition() ? "1" : "0");
                    this.afg.o("is_giftpost", writeData.isGiftPost() ? "1" : "0");
                    this.afg.o("is_giftpost", writeData.isGiftPost() ? "1" : "0");
                    if (writeData.isAddition()) {
                        this.afg.o("st_type", "conadd");
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
                    this.afg.setUrl(cZe);
                    this.afg.o("kw", writeData.getForumName());
                    this.afg.o("title", writeData.getTitle());
                    this.afg.o("thread_type", "33");
                    e.a(this.afg, writeData);
                    str2 = imagesCodeForPost;
                    break;
                case 5:
                    this.afg.setUrl(cZf);
                    this.afg.o("tid", writeData.getThreadId());
                    this.afg.o("kw", writeData.getForumName());
                    this.afg.o("is_twzhibo_thread", String.valueOf(1));
                    e.a(this.afg, writeData);
                    str2 = imagesCodeForPost;
                    break;
                case 6:
                    this.afg.setUrl(cZe);
                    this.afg.o("kw", writeData.getForumName());
                    this.afg.o("thread_type", String.valueOf(36));
                    this.afg.o("title", writeData.getTitle());
                    this.afg.o("is_ntitle", writeData.isNoTitle() ? "1" : "0");
                    if (writeData.isNoTitle()) {
                        this.afg.o("st_type", "notitle");
                    }
                    e.a(this.afg, writeData);
                    str2 = imagesCodeForPost;
                    break;
            }
        }
        String tG = this.afg.tG();
        if (this.afg.uh().uY().qV()) {
            this.cZh.parserJson(tG);
        } else {
            this.cZh.setError_code(this.afg.uk() ? this.afg.ul() : this.afg.um());
            this.cZh.setError_msg(this.afg.getErrorString());
        }
        if (this.cZh.error_code != 0 && !com.baidu.adp.lib.util.i.iM()) {
            this.cZh.setError_msg(TbadkCoreApplication.m411getInst().getApp().getString(i.h.neterror));
        } else if (this.cZh.error_code != 0 && ((writeData.isHasImages() || writeData.getIsBaobao()) && j.isEmpty(String.valueOf(writeData.getContent()) + str2))) {
            this.cZh.setError_msg(TbadkCoreApplication.m411getInst().getApp().getString(i.h.img_upload_error));
        }
        try {
            this.cZi = new AntiData();
            this.cZi.parserJson(new JSONObject(tG).optJSONObject("anti_stat"));
        } catch (Exception e) {
        }
        return tG;
    }

    public boolean qV() {
        if (this.afg == null) {
            return false;
        }
        return this.afg.uh().uY().qV();
    }

    public void cancel() {
        this.auk = true;
        if (this.afg != null) {
            this.afg.gJ();
        }
        if (this.atY != null) {
            this.atY.cancel();
        }
    }

    public AntiData awM() {
        return this.cZi;
    }

    public ErrorData awN() {
        return this.cZh;
    }
}
