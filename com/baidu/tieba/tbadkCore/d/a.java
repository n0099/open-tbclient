package com.baidu.tieba.tbadkCore.d;

import android.location.Address;
import android.text.TextUtils;
import com.baidu.adp.lib.util.j;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.CreateGroupActivityActivityConfig;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.atomData.TailEditActivityConfig;
import com.baidu.tbadk.core.atomData.WriteActivityConfig;
import com.baidu.tbadk.core.atomData.WriteShareActivityConfig;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.ErrorData;
import com.baidu.tbadk.core.util.TbErrInfo;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.m;
import com.baidu.tbadk.core.util.n;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.coreExtra.data.b;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tbadk.img.ImageUploadResult;
import com.baidu.tbadk.img.c;
import com.baidu.tieba.i;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class a {
    private static final String cRA = String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.POST_THREAD_ADDRESS;
    private static final String cRB = String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.REPLY_THREAD_ADDRESS;
    public static final String cRC = String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.POST_THREAD_FOR_SHARE_ADDRESS;
    private c avB;
    private ErrorData cRD;
    private AntiData cRE;
    private v afT = null;
    private boolean avN = false;

    /* renamed from: com.baidu.tieba.tbadkCore.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0072a {
        public static int cRF = 1;
    }

    public a() {
        this.cRD = null;
        this.cRD = new ErrorData();
    }

    public ImageUploadResult b(ImageFileInfo imageFileInfo) {
        if (imageFileInfo == null) {
            return null;
        }
        if (this.avB == null) {
            this.avB = new c("HTTPWriteService.postImageData");
        }
        return this.avB.a(imageFileInfo);
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
        this.afT = new v();
        this.afT.uj().uZ().mIsNeedTbs = true;
        if (writeData.getType() == 3) {
            if (writeData.getVcode() != null && writeData.getVcode().length() > 0) {
                this.afT.o("vcode", writeData.getVcode());
            }
            if (TbadkCoreApplication.m411getInst().getNewVcodeWebviewCrashCount() < 3) {
                this.afT.o("tag", "11");
            }
            this.afT.o("newVcode", "1");
            this.afT.o(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_CONTENT, writeData.getContent());
            this.afT.setUrl(cRC);
            this.afT.o(ImageViewerConfig.FORUM_NAME, writeData.getForumName());
            this.afT.o("title", writeData.getTitle());
            this.afT.o("apiKey", writeData.getShareApiKey());
            this.afT.o("appName", writeData.getShareAppName());
            this.afT.o("signKey", writeData.getShareSignKey());
            this.afT.o("summary_title", writeData.getShareSummaryTitle());
            this.afT.o("summary_content", writeData.getShareSummaryContent());
            this.afT.o("summary_img", writeData.getShareSummaryImg());
            this.afT.o(WriteShareActivityConfig.SHARE_SUMMARY_IMG_WIDTH, String.valueOf(writeData.getShareSummaryImgWidth()));
            this.afT.o(WriteShareActivityConfig.SHARE_SUMMARY_IMG_HEIGHT, String.valueOf(writeData.getShareSummaryImgHeight()));
            this.afT.o(WriteShareActivityConfig.SHARE_SUMMARY_IMG_TYPE, writeData.getShareSummaryImgType());
            this.afT.o("referUrl", writeData.getShareReferUrl());
            str2 = null;
        } else {
            if (z && writeData.isHasImages()) {
                if (this.avB == null) {
                    this.avB = new c("HTTPWriteService.postWriteData");
                }
                this.avB.b(writeData.getWriteImagesInfo());
            }
            if (this.avN) {
                return null;
            }
            if (writeData.getIsBaobao()) {
                if (this.avB == null) {
                    this.avB = new c("HTTPWriteService.postWriteData");
                }
                this.avB.b(writeData.getBaobaoImagesInfo());
            }
            if (this.avN) {
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
                com.baidu.tbadk.coreExtra.data.c dE = cVar.dE(q);
                if (dE != null && dE.isSuccess()) {
                    b ww = dE.ww();
                    if (ww != null) {
                        returnVoiceMd5 = ww.wu();
                        com.baidu.tbadk.core.voice.a.b.ai(writeData.getVoice(), returnVoiceMd5);
                        writeData.setReturnVoiceMd5(returnVoiceMd5);
                    } else {
                        m mVar = new m();
                        mVar.h("ErrCode", Integer.valueOf(dE.getErrorCode()));
                        mVar.h("ErrMsg", dE.getErrorString());
                        TiebaStatic.voiceError(TbErrInfo.ERR_VOI_SEND, "audioUploadData is null", mVar.toString());
                        this.cRD.setError_code(dE.getErrorCode());
                        this.cRD.setError_msg(dE.getErrorString());
                        return null;
                    }
                } else {
                    m mVar2 = new m();
                    mVar2.h("audioFile", q);
                    TiebaStatic.voiceError(TbErrInfo.ERR_VOI_SEND, "uploadService.upload null or fail", mVar2.toString());
                    this.cRD.setError_code(dE.getErrorCode());
                    this.cRD.setError_msg(dE.getErrorString());
                    return null;
                }
            }
            if (!this.avN) {
                this.afT.o("anonymous", "1");
                this.afT.o(ImageViewerConfig.FORUM_ID, writeData.getForumId());
                if (returnVoiceMd5 != null) {
                    this.afT.o("voice_md5", returnVoiceMd5);
                    this.afT.o("during_time", String.valueOf(voiceDuringTime));
                }
                String imagesCodeForPost = writeData.getImagesCodeForPost();
                if ((writeData.getType() != 0 || (writeData.getType() == 0 && TextUtils.isEmpty(writeData.getTitle()))) && TextUtils.isEmpty(returnVoiceMd5) && TextUtils.isEmpty(imagesCodeForPost) && TextUtils.isEmpty(writeData.getContent()) && writeData.getVideoInfo() == null) {
                    this.cRD.setError_code(-53);
                    this.cRD.setError_msg(TbadkCoreApplication.m411getInst().getString(i.h.sand_fail));
                    return null;
                }
                if (writeData.getVcode() != null && writeData.getVcode().length() > 0) {
                    this.afT.o("vcode", writeData.getVcode());
                }
                if (TbadkCoreApplication.m411getInst().getNewVcodeWebviewCrashCount() < 3) {
                    this.afT.o("vcode_tag", "11");
                }
                Address y = com.baidu.adp.lib.d.a.gC().y(false);
                this.afT.o("new_vcode", "1");
                if (writeData.getVideoInfo() == null) {
                    str = String.valueOf(writeData.getContent()) + imagesCodeForPost;
                } else {
                    str = String.valueOf(writeData.getContent()) + writeData.getVideoInfo().buildWriteContent(writeData.getForumName()) + imagesCodeForPost;
                }
                this.afT.o(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_CONTENT, str);
                if (writeData.getIsBaobaoImageUploaded()) {
                    this.afT.o("tail_type", String.valueOf(C0072a.cRF));
                    this.afT.o(TailEditActivityConfig.TAIL_CONTENT, writeData.getBaobaoContent());
                    writeData.setBabaoPosted(true);
                } else {
                    writeData.setBabaoPosted(false);
                }
                switch (writeData.getType()) {
                    case 0:
                        this.afT.setUrl(cRA);
                        this.afT.o("kw", writeData.getForumName());
                        this.afT.o("title", writeData.getTitle());
                        this.afT.o("is_ntitle", writeData.isNoTitle() ? "1" : "0");
                        if (writeData.isNoTitle()) {
                            this.afT.o("st_type", "notitle");
                        }
                        if (writeData.getLiveCardData() != null) {
                            this.afT.o("group_id", String.valueOf(writeData.getLiveCardData().getGroupId()));
                            this.afT.o("start_time", String.valueOf(writeData.getLiveCardData().getStartTime()));
                        }
                        if (y != null && TbadkCoreApplication.m411getInst().getIsLocationOn() && !TbConfig.getPositionPagerId().equals(writeData.getForumId())) {
                            this.afT.o("lbs", String.valueOf(String.valueOf(y.getLatitude())) + "," + String.valueOf(y.getLongitude()));
                        }
                        com.baidu.tieba.tbadkCore.writeModel.c.a(this.afT, writeData);
                        str2 = imagesCodeForPost;
                        break;
                    case 1:
                        this.afT.setUrl(cRB);
                        this.afT.o("tid", writeData.getThreadId());
                        this.afT.o("kw", writeData.getForumName());
                        this.afT.o("is_ad", writeData.getIsAd() ? "1" : "0");
                        if (writeData.isFrsReply()) {
                            this.afT.o("st_param", "frs");
                        }
                        com.baidu.tieba.tbadkCore.writeModel.c.a(this.afT, writeData);
                        str2 = imagesCodeForPost;
                        break;
                    case 2:
                        this.afT.setUrl(cRB);
                        this.afT.o("tid", writeData.getThreadId());
                        this.afT.o("kw", writeData.getForumName());
                        this.afT.o("quote_id", String.valueOf(writeData.getFloor()));
                        this.afT.o("is_twzhibo_thread", String.valueOf(0));
                        this.afT.o("floor_num", String.valueOf(writeData.getFloorNum()));
                        if (writeData.getRepostId() != null) {
                            this.afT.o("repostid", writeData.getRepostId());
                        }
                        this.afT.o("is_ad", writeData.getIsAd() ? "1" : "0");
                        this.afT.o(WriteActivityConfig.IS_ADDITION, writeData.isAddition() ? "1" : "0");
                        this.afT.o("is_giftpost", writeData.isGiftPost() ? "1" : "0");
                        if (writeData.isAddition()) {
                            this.afT.o("st_type", "conadd");
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
                        this.afT.setUrl(cRA);
                        this.afT.o("kw", writeData.getForumName());
                        this.afT.o("title", writeData.getTitle());
                        this.afT.o("thread_type", "33");
                        com.baidu.tieba.tbadkCore.writeModel.c.a(this.afT, writeData);
                        str2 = imagesCodeForPost;
                        break;
                    case 5:
                        this.afT.setUrl(cRB);
                        this.afT.o("tid", writeData.getThreadId());
                        this.afT.o("kw", writeData.getForumName());
                        this.afT.o("is_twzhibo_thread", String.valueOf(1));
                        com.baidu.tieba.tbadkCore.writeModel.c.a(this.afT, writeData);
                        str2 = imagesCodeForPost;
                        break;
                }
            } else {
                return null;
            }
        }
        String tI = this.afT.tI();
        if (this.afT.uj().va().qZ()) {
            this.cRD.parserJson(tI);
        } else {
            this.cRD.setError_code(this.afT.um() ? this.afT.un() : this.afT.uo());
            this.cRD.setError_msg(this.afT.getErrorString());
        }
        if (this.cRD.error_code != 0 && ((writeData.isHasImages() || writeData.getIsBaobao()) && j.isEmpty(String.valueOf(writeData.getContent()) + str2))) {
            this.cRD.setError_msg(TbadkCoreApplication.m411getInst().getApp().getString(i.h.img_upload_error));
        }
        try {
            this.cRE = new AntiData();
            this.cRE.parserJson(new JSONObject(tI).optJSONObject("anti_stat"));
        } catch (Exception e) {
        }
        return tI;
    }

    public boolean qZ() {
        if (this.afT == null) {
            return false;
        }
        return this.afT.uj().va().qZ();
    }

    public void cancel() {
        this.avN = true;
        if (this.afT != null) {
            this.afT.gJ();
        }
        if (this.avB != null) {
            this.avB.cancel();
        }
    }

    public AntiData aux() {
        return this.cRE;
    }

    public ErrorData auy() {
        return this.cRD;
    }
}
