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
    private static final String bZd = String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.POST_THREAD_ADDRESS;
    private static final String bZe = String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.REPLY_THREAD_ADDRESS;
    public static final String bZf = String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.POST_THREAD_FOR_SHARE_ADDRESS;
    private h abF;
    private ErrorData bZg;
    private AntiData bZh;
    private ad CX = null;
    private boolean isCancelled = false;

    public a() {
        this.bZg = null;
        this.bZg = new ErrorData();
    }

    public String a(WriteData writeData, boolean z) {
        String returnVoiceMd5;
        boolean z2;
        String str;
        if (writeData == null) {
            return null;
        }
        this.CX = new ad();
        this.CX.oZ().qg().mIsNeedTbs = true;
        if (writeData.getType() == 3) {
            if (writeData.getVcode() != null && writeData.getVcode().length() > 0) {
                this.CX.o("vcode", writeData.getVcode());
            }
            if (TbadkCoreApplication.m255getInst().getNewVcodeWebviewCrashCount() < 3) {
                this.CX.o("tag", "11");
            }
            this.CX.o("newVcode", "1");
            this.CX.o(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_CONTENT, writeData.getContent());
            this.CX.setUrl(bZf);
            this.CX.o(ImageViewerConfig.FORUM_NAME, writeData.getForumName());
            this.CX.o("title", writeData.getTitle());
            this.CX.o("apiKey", writeData.getShareApiKey());
            this.CX.o("appName", writeData.getShareAppName());
            this.CX.o("signKey", writeData.getShareSignKey());
            this.CX.o("summary_title", writeData.getShareSummaryTitle());
            this.CX.o("summary_content", writeData.getShareSummaryContent());
            this.CX.o("summary_img", writeData.getShareSummaryImg());
            this.CX.o(WriteShareActivityConfig.SHARE_SUMMARY_IMG_WIDTH, String.valueOf(writeData.getShareSummaryImgWidth()));
            this.CX.o(WriteShareActivityConfig.SHARE_SUMMARY_IMG_HEIGHT, String.valueOf(writeData.getShareSummaryImgHeight()));
            this.CX.o(WriteShareActivityConfig.SHARE_SUMMARY_IMG_TYPE, writeData.getShareSummaryImgType());
            this.CX.o("referUrl", writeData.getShareReferUrl());
            str = null;
        } else {
            if (z && writeData.isHasImages()) {
                if (this.abF == null) {
                    this.abF = new h("HTTPWriteService.postWriteData");
                }
                this.abF.a(writeData.getWriteImagesInfo());
            }
            if (this.isCancelled) {
                return null;
            }
            if (writeData.getIsBaobao()) {
                if (this.abF == null) {
                    this.abF = new h("HTTPWriteService.postWriteData");
                }
                this.abF.a(writeData.getBaobaoImagesInfo());
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
                com.baidu.tbadk.coreExtra.data.c cZ = cVar.cZ(n);
                if (cZ != null && cZ.isSuccess()) {
                    com.baidu.tbadk.coreExtra.data.b rI = cZ.rI();
                    if (rI != null) {
                        returnVoiceMd5 = rI.rG();
                        com.baidu.tbadk.core.voice.a.b.ad(writeData.getVoice(), returnVoiceMd5);
                        writeData.setReturnVoiceMd5(returnVoiceMd5);
                    } else {
                        r rVar = new r();
                        rVar.h("ErrCode", Integer.valueOf(cZ.getErrorCode()));
                        rVar.h("ErrMsg", cZ.getErrorString());
                        TiebaStatic.voiceError("", TbErrInfo.ERR_VOI_SEND, "audioUploadData is null", rVar.toString());
                        this.bZg.setError_code(cZ.getErrorCode());
                        this.bZg.setError_msg(cZ.getErrorString());
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
                this.CX.o("anonymous", "1");
                this.CX.o(ImageViewerConfig.FORUM_ID, writeData.getForumId());
                if (returnVoiceMd5 != null) {
                    this.CX.o("voice_md5", returnVoiceMd5);
                    this.CX.o("during_time", String.valueOf(voiceDuringTime));
                }
                String imagesCodeForPost = writeData.getImagesCodeForPost();
                if (writeData.getVcode() != null && writeData.getVcode().length() > 0) {
                    this.CX.o("vcode", writeData.getVcode());
                }
                if (TbadkCoreApplication.m255getInst().getNewVcodeWebviewCrashCount() < 3) {
                    this.CX.o("vcode_tag", "11");
                }
                Address z3 = com.baidu.adp.lib.d.a.dB().z(false);
                this.CX.o("new_vcode", "1");
                this.CX.o(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_CONTENT, String.valueOf(writeData.getContent()) + imagesCodeForPost);
                if (writeData.getIsBaobaoImageUploaded()) {
                    this.CX.o("tail_type", String.valueOf(b.bZi));
                    this.CX.o("tail_content", writeData.getBaobaoContent());
                    writeData.setBabaoPosted(true);
                } else {
                    writeData.setBabaoPosted(false);
                }
                switch (writeData.getType()) {
                    case 0:
                        this.CX.setUrl(bZd);
                        this.CX.o("kw", writeData.getForumName());
                        this.CX.o("title", writeData.getTitle());
                        this.CX.o("is_ntitle", writeData.isNoTitle() ? "1" : "0");
                        if (writeData.isNoTitle()) {
                            this.CX.o("st_type", "notitle");
                        }
                        if (writeData.getLiveCardData() != null) {
                            this.CX.o("group_id", String.valueOf(writeData.getLiveCardData().getGroupId()));
                            this.CX.o("start_time", String.valueOf(writeData.getLiveCardData().getStartTime()));
                        }
                        if (z3 != null && TbadkCoreApplication.m255getInst().getIsLocationOn() && !TbConfig.getPositionPagerId().equals(writeData.getForumId())) {
                            this.CX.o("lbs", String.valueOf(String.valueOf(z3.getLatitude())) + "," + String.valueOf(z3.getLongitude()));
                        }
                        g.a(this.CX, writeData);
                        str = imagesCodeForPost;
                        break;
                    case 1:
                        this.CX.setUrl(bZe);
                        this.CX.o("tid", writeData.getThreadId());
                        this.CX.o("kw", writeData.getForumName());
                        this.CX.o("is_ad", writeData.getIsAd() ? "1" : "0");
                        if (writeData.isFrsReply()) {
                            this.CX.o("st_param", "frs");
                        }
                        g.a(this.CX, writeData);
                        str = imagesCodeForPost;
                        break;
                    case 2:
                        this.CX.setUrl(bZe);
                        this.CX.o("tid", writeData.getThreadId());
                        this.CX.o("kw", writeData.getForumName());
                        this.CX.o("quote_id", String.valueOf(writeData.getFloor()));
                        this.CX.o(WriteActivityConfig.FLOOR_NUM, String.valueOf(writeData.getFloorNum()));
                        if (writeData.getRepostId() != null) {
                            this.CX.o("repostid", writeData.getRepostId());
                        }
                        this.CX.o("is_ad", writeData.getIsAd() ? "1" : "0");
                        this.CX.o(WriteActivityConfig.IS_ADDITION, writeData.isAddition() ? "1" : "0");
                        if (writeData.isAddition()) {
                            this.CX.o("st_type", "conadd");
                        }
                    default:
                        str = imagesCodeForPost;
                        break;
                }
            } else {
                return null;
            }
        }
        String oy = this.CX.oy();
        if (this.CX.oZ().qh().ma()) {
            this.bZg.parserJson(oy);
        } else {
            this.bZg.setError_code(this.CX.pc() ? this.CX.pd() : this.CX.pe());
            this.bZg.setError_msg(this.CX.getErrorString());
        }
        if (this.bZg.error_code != 0 && ((writeData.isHasImages() || writeData.getIsBaobao()) && k.isEmpty(String.valueOf(writeData.getContent()) + str))) {
            this.bZg.setError_msg(TbadkCoreApplication.m255getInst().getApp().getString(z.img_upload_error));
        }
        try {
            this.bZh = new AntiData();
            this.bZh.parserJson(new JSONObject(oy).optJSONObject("anti_stat"));
        } catch (Exception e) {
        }
        return oy;
    }

    public boolean ma() {
        if (this.CX == null) {
            return false;
        }
        return this.CX.oZ().qh().ma();
    }

    public void cancel() {
        this.isCancelled = true;
        if (this.CX != null) {
            this.CX.dJ();
        }
        if (this.abF != null) {
            this.abF.cancel();
        }
    }

    public AntiData ahN() {
        return this.bZh;
    }

    public ErrorData ahO() {
        return this.bZg;
    }
}
