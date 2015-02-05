package com.baidu.tieba.tbadkCore.c;

import android.location.Address;
import com.baidu.adp.lib.util.k;
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
import com.baidu.tbadk.core.util.ad;
import com.baidu.tbadk.core.util.r;
import com.baidu.tbadk.core.util.s;
import com.baidu.tbadk.core.voice.service.c;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.img.h;
import com.baidu.tieba.tbadkCore.f.g;
import com.baidu.tieba.z;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class a {
    private static final String bZc = String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.POST_THREAD_ADDRESS;
    private static final String bZd = String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.REPLY_THREAD_ADDRESS;
    public static final String bZe = String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.POST_THREAD_FOR_SHARE_ADDRESS;
    private h abC;
    private ErrorData bZf;
    private AntiData bZg;
    private ad CU = null;
    private boolean isCancelled = false;

    public a() {
        this.bZf = null;
        this.bZf = new ErrorData();
    }

    public String a(WriteData writeData, boolean z) {
        String returnVoiceMd5;
        boolean z2;
        String str;
        if (writeData == null) {
            return null;
        }
        this.CU = new ad();
        this.CU.oS().pZ().mIsNeedTbs = true;
        if (writeData.getType() == 3) {
            if (writeData.getVcode() != null && writeData.getVcode().length() > 0) {
                this.CU.o("vcode", writeData.getVcode());
            }
            if (TbadkCoreApplication.m255getInst().getNewVcodeWebviewCrashCount() < 3) {
                this.CU.o("tag", "11");
            }
            this.CU.o("newVcode", "1");
            this.CU.o(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_CONTENT, writeData.getContent());
            this.CU.setUrl(bZe);
            this.CU.o(ImageViewerConfig.FORUM_NAME, writeData.getForumName());
            this.CU.o("title", writeData.getTitle());
            this.CU.o("apiKey", writeData.getShareApiKey());
            this.CU.o("appName", writeData.getShareAppName());
            this.CU.o("signKey", writeData.getShareSignKey());
            this.CU.o("summary_title", writeData.getShareSummaryTitle());
            this.CU.o("summary_content", writeData.getShareSummaryContent());
            this.CU.o("summary_img", writeData.getShareSummaryImg());
            this.CU.o(WriteShareActivityConfig.SHARE_SUMMARY_IMG_WIDTH, String.valueOf(writeData.getShareSummaryImgWidth()));
            this.CU.o(WriteShareActivityConfig.SHARE_SUMMARY_IMG_HEIGHT, String.valueOf(writeData.getShareSummaryImgHeight()));
            this.CU.o(WriteShareActivityConfig.SHARE_SUMMARY_IMG_TYPE, writeData.getShareSummaryImgType());
            this.CU.o("referUrl", writeData.getShareReferUrl());
            str = null;
        } else {
            if (z && writeData.isHasImages()) {
                if (this.abC == null) {
                    this.abC = new h("HTTPWriteService.postWriteData");
                }
                this.abC.a(writeData.getWriteImagesInfo());
            }
            if (this.isCancelled) {
                return null;
            }
            if (writeData.getIsBaobao()) {
                if (this.abC == null) {
                    this.abC = new h("HTTPWriteService.postWriteData");
                }
                this.abC.a(writeData.getBaobaoImagesInfo());
            }
            if (this.isCancelled) {
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
                c cVar = new c(TbConfig.UPLOAD_CHUNK_AUDIO_ADDRESS, TbConfig.FINISH_UPLOAD_CHUNK_AUDIO_ADDRESS);
                String n = s.n(voice, 1);
                com.baidu.tbadk.coreExtra.data.c cW = cVar.cW(n);
                if (cW != null && cW.isSuccess()) {
                    com.baidu.tbadk.coreExtra.data.b rC = cW.rC();
                    if (rC != null) {
                        returnVoiceMd5 = rC.rA();
                        com.baidu.tbadk.core.voice.a.b.ad(writeData.getVoice(), returnVoiceMd5);
                        writeData.setReturnVoiceMd5(returnVoiceMd5);
                    } else {
                        r rVar = new r();
                        rVar.h("ErrCode", Integer.valueOf(cW.getErrorCode()));
                        rVar.h("ErrMsg", cW.getErrorString());
                        TiebaStatic.voiceError("", TbErrInfo.ERR_VOI_SEND, "audioUploadData is null", rVar.toString());
                        this.bZf.setError_code(cW.getErrorCode());
                        this.bZf.setError_msg(cW.getErrorString());
                        return null;
                    }
                } else {
                    r rVar2 = new r();
                    rVar2.h("audioFile", n);
                    TiebaStatic.voiceError("", TbErrInfo.ERR_VOI_SEND, "uploadService.upload null or fail", rVar2.toString());
                    return null;
                }
            }
            if (!this.isCancelled) {
                this.CU.o("anonymous", "1");
                this.CU.o(ImageViewerConfig.FORUM_ID, writeData.getForumId());
                if (returnVoiceMd5 != null) {
                    this.CU.o("voice_md5", returnVoiceMd5);
                    this.CU.o("during_time", String.valueOf(voiceDuringTime));
                }
                String imagesCodeForPost = writeData.getImagesCodeForPost();
                if (writeData.getVcode() != null && writeData.getVcode().length() > 0) {
                    this.CU.o("vcode", writeData.getVcode());
                }
                if (TbadkCoreApplication.m255getInst().getNewVcodeWebviewCrashCount() < 3) {
                    this.CU.o("vcode_tag", "11");
                }
                Address z3 = com.baidu.adp.lib.d.a.dB().z(false);
                this.CU.o("new_vcode", "1");
                this.CU.o(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_CONTENT, String.valueOf(writeData.getContent()) + imagesCodeForPost);
                if (writeData.getIsBaobaoImageUploaded()) {
                    this.CU.o("tail_type", String.valueOf(b.bZh));
                    this.CU.o("tail_content", writeData.getBaobaoContent());
                    writeData.setBabaoPosted(true);
                } else {
                    writeData.setBabaoPosted(false);
                }
                switch (writeData.getType()) {
                    case 0:
                        this.CU.setUrl(bZc);
                        this.CU.o("kw", writeData.getForumName());
                        this.CU.o("title", writeData.getTitle());
                        this.CU.o("is_ntitle", writeData.isNoTitle() ? "1" : "0");
                        if (writeData.isNoTitle()) {
                            this.CU.o("st_type", "notitle");
                        }
                        if (writeData.getLiveCardData() != null) {
                            this.CU.o("group_id", String.valueOf(writeData.getLiveCardData().getGroupId()));
                            this.CU.o("start_time", String.valueOf(writeData.getLiveCardData().getStartTime()));
                        }
                        if (z3 != null && TbadkCoreApplication.m255getInst().getIsLocationOn() && !TbConfig.getPositionPagerId().equals(writeData.getForumId())) {
                            this.CU.o("lbs", String.valueOf(String.valueOf(z3.getLatitude())) + "," + String.valueOf(z3.getLongitude()));
                        }
                        g.a(this.CU, writeData);
                        str = imagesCodeForPost;
                        break;
                    case 1:
                        this.CU.setUrl(bZd);
                        this.CU.o("tid", writeData.getThreadId());
                        this.CU.o("kw", writeData.getForumName());
                        this.CU.o("is_ad", writeData.getIsAd() ? "1" : "0");
                        if (writeData.isFrsReply()) {
                            this.CU.o("st_param", "frs");
                        }
                        g.a(this.CU, writeData);
                        str = imagesCodeForPost;
                        break;
                    case 2:
                        this.CU.setUrl(bZd);
                        this.CU.o("tid", writeData.getThreadId());
                        this.CU.o("kw", writeData.getForumName());
                        this.CU.o("quote_id", String.valueOf(writeData.getFloor()));
                        this.CU.o(WriteActivityConfig.FLOOR_NUM, String.valueOf(writeData.getFloorNum()));
                        if (writeData.getRepostId() != null) {
                            this.CU.o("repostid", writeData.getRepostId());
                        }
                        this.CU.o("is_ad", writeData.getIsAd() ? "1" : "0");
                        this.CU.o(WriteActivityConfig.IS_ADDITION, writeData.isAddition() ? "1" : "0");
                        if (writeData.isAddition()) {
                            this.CU.o("st_type", "conadd");
                        }
                    default:
                        str = imagesCodeForPost;
                        break;
                }
            } else {
                return null;
            }
        }
        String or = this.CU.or();
        if (this.CU.oS().qa().lT()) {
            this.bZf.parserJson(or);
        } else {
            this.bZf.setError_code(this.CU.oV() ? this.CU.oW() : this.CU.oX());
            this.bZf.setError_msg(this.CU.getErrorString());
        }
        if (this.bZf.error_code != 0 && ((writeData.isHasImages() || writeData.getIsBaobao()) && k.isEmpty(String.valueOf(writeData.getContent()) + str))) {
            this.bZf.setError_msg(TbadkCoreApplication.m255getInst().getApp().getString(z.img_upload_error));
        }
        try {
            this.bZg = new AntiData();
            this.bZg.parserJson(new JSONObject(or).optJSONObject("anti_stat"));
        } catch (Exception e) {
        }
        return or;
    }

    public boolean lT() {
        if (this.CU == null) {
            return false;
        }
        return this.CU.oS().qa().lT();
    }

    public void cancel() {
        this.isCancelled = true;
        if (this.CU != null) {
            this.CU.dJ();
        }
        if (this.abC != null) {
            this.abC.cancel();
        }
    }

    public AntiData ahI() {
        return this.bZg;
    }

    public ErrorData ahJ() {
        return this.bZf;
    }
}
