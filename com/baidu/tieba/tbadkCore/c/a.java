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
    private static final String bXk = String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.POST_THREAD_ADDRESS;
    private static final String bXl = String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.REPLY_THREAD_ADDRESS;
    public static final String bXm = String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.POST_THREAD_FOR_SHARE_ADDRESS;
    private h abd;
    private ErrorData bXn;
    private AntiData bXo;
    private ad CV = null;
    private boolean isCancelled = false;

    public a() {
        this.bXn = null;
        this.bXn = new ErrorData();
    }

    public String a(WriteData writeData, boolean z) {
        String returnVoiceMd5;
        boolean z2;
        String str;
        if (writeData == null) {
            return null;
        }
        this.CV = new ad();
        this.CV.oW().pV().mIsNeedTbs = true;
        if (writeData.getType() == 3) {
            if (writeData.getVcode() != null && writeData.getVcode().length() > 0) {
                this.CV.o("vcode", writeData.getVcode());
            }
            if (TbadkCoreApplication.m255getInst().getNewVcodeWebviewCrashCount() < 3) {
                this.CV.o("tag", "11");
            }
            this.CV.o("newVcode", "1");
            this.CV.o(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_CONTENT, writeData.getContent());
            this.CV.setUrl(bXm);
            this.CV.o(ImageViewerConfig.FORUM_NAME, writeData.getForumName());
            this.CV.o("title", writeData.getTitle());
            this.CV.o("apiKey", writeData.getShareApiKey());
            this.CV.o("appName", writeData.getShareAppName());
            this.CV.o("signKey", writeData.getShareSignKey());
            this.CV.o("summary_title", writeData.getShareSummaryTitle());
            this.CV.o("summary_content", writeData.getShareSummaryContent());
            this.CV.o("summary_img", writeData.getShareSummaryImg());
            this.CV.o(WriteShareActivityConfig.SHARE_SUMMARY_IMG_WIDTH, String.valueOf(writeData.getShareSummaryImgWidth()));
            this.CV.o(WriteShareActivityConfig.SHARE_SUMMARY_IMG_HEIGHT, String.valueOf(writeData.getShareSummaryImgHeight()));
            this.CV.o(WriteShareActivityConfig.SHARE_SUMMARY_IMG_TYPE, writeData.getShareSummaryImgType());
            this.CV.o("referUrl", writeData.getShareReferUrl());
            str = null;
        } else {
            if (z && writeData.isHasImages()) {
                if (this.abd == null) {
                    this.abd = new h("HTTPWriteService.postWriteData");
                }
                this.abd.a(writeData.getWriteImagesInfo());
            }
            if (this.isCancelled) {
                return null;
            }
            if (writeData.getIsBaobao()) {
                if (this.abd == null) {
                    this.abd = new h("HTTPWriteService.postWriteData");
                }
                this.abd.a(writeData.getBaobaoImagesInfo());
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
                com.baidu.tbadk.coreExtra.data.c da = cVar.da(n);
                if (da != null && da.isSuccess()) {
                    com.baidu.tbadk.coreExtra.data.b rw = da.rw();
                    if (rw != null) {
                        returnVoiceMd5 = rw.ru();
                        com.baidu.tbadk.core.voice.a.b.aa(writeData.getVoice(), returnVoiceMd5);
                        writeData.setReturnVoiceMd5(returnVoiceMd5);
                    } else {
                        r rVar = new r();
                        rVar.h("ErrCode", Integer.valueOf(da.getErrorCode()));
                        rVar.h("ErrMsg", da.getErrorString());
                        TiebaStatic.voiceError("", TbErrInfo.ERR_VOI_SEND, "audioUploadData is null", rVar.toString());
                        this.bXn.setError_code(da.getErrorCode());
                        this.bXn.setError_msg(da.getErrorString());
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
                this.CV.o("anonymous", "1");
                this.CV.o(ImageViewerConfig.FORUM_ID, writeData.getForumId());
                if (returnVoiceMd5 != null) {
                    this.CV.o("voice_md5", returnVoiceMd5);
                    this.CV.o("during_time", String.valueOf(voiceDuringTime));
                }
                String imagesCodeForPost = writeData.getImagesCodeForPost();
                if (writeData.getVcode() != null && writeData.getVcode().length() > 0) {
                    this.CV.o("vcode", writeData.getVcode());
                }
                if (TbadkCoreApplication.m255getInst().getNewVcodeWebviewCrashCount() < 3) {
                    this.CV.o("vcode_tag", "11");
                }
                Address z3 = com.baidu.adp.lib.d.a.dD().z(false);
                this.CV.o("new_vcode", "1");
                this.CV.o(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_CONTENT, String.valueOf(writeData.getContent()) + imagesCodeForPost);
                if (writeData.getIsBaobaoImageUploaded()) {
                    this.CV.o("tail_type", String.valueOf(b.bXp));
                    this.CV.o("tail_content", writeData.getBaobaoContent());
                    writeData.setBabaoPosted(true);
                } else {
                    writeData.setBabaoPosted(false);
                }
                switch (writeData.getType()) {
                    case 0:
                        this.CV.setUrl(bXk);
                        this.CV.o("kw", writeData.getForumName());
                        this.CV.o("title", writeData.getTitle());
                        this.CV.o("is_ntitle", writeData.isNoTitle() ? "1" : "0");
                        if (writeData.isNoTitle()) {
                            this.CV.o("st_type", "notitle");
                        }
                        if (writeData.getLiveCardData() != null) {
                            this.CV.o("group_id", String.valueOf(writeData.getLiveCardData().getGroupId()));
                            this.CV.o("start_time", String.valueOf(writeData.getLiveCardData().getStartTime()));
                        }
                        if (z3 != null && TbadkCoreApplication.m255getInst().getIsLocationOn() && !TbConfig.getPositionPagerId().equals(writeData.getForumId())) {
                            this.CV.o("lbs", String.valueOf(String.valueOf(z3.getLatitude())) + "," + String.valueOf(z3.getLongitude()));
                        }
                        g.a(this.CV, writeData);
                        str = imagesCodeForPost;
                        break;
                    case 1:
                        this.CV.setUrl(bXl);
                        this.CV.o("tid", writeData.getThreadId());
                        this.CV.o("kw", writeData.getForumName());
                        this.CV.o("is_ad", writeData.getIsAd() ? "1" : "0");
                        if (writeData.isFrsReply()) {
                            this.CV.o("st_param", "frs");
                        }
                        g.a(this.CV, writeData);
                        str = imagesCodeForPost;
                        break;
                    case 2:
                        this.CV.setUrl(bXl);
                        this.CV.o("tid", writeData.getThreadId());
                        this.CV.o("kw", writeData.getForumName());
                        this.CV.o("quote_id", String.valueOf(writeData.getFloor()));
                        this.CV.o(WriteActivityConfig.FLOOR_NUM, String.valueOf(writeData.getFloorNum()));
                        if (writeData.getRepostId() != null) {
                            this.CV.o("repostid", writeData.getRepostId());
                        }
                        this.CV.o("is_ad", writeData.getIsAd() ? "1" : "0");
                        this.CV.o(WriteActivityConfig.IS_ADDITION, writeData.isAddition() ? "1" : "0");
                        if (writeData.isAddition()) {
                            this.CV.o("st_type", "conadd");
                        }
                    default:
                        str = imagesCodeForPost;
                        break;
                }
            } else {
                return null;
            }
        }
        String ov = this.CV.ov();
        if (this.CV.oW().pW().ma()) {
            this.bXn.parserJson(ov);
        } else {
            this.bXn.setError_code(this.CV.oZ() ? this.CV.pa() : this.CV.pb());
            this.bXn.setError_msg(this.CV.getErrorString());
        }
        if (this.bXn.error_code != 0 && ((writeData.isHasImages() || writeData.getIsBaobao()) && k.isEmpty(String.valueOf(writeData.getContent()) + str))) {
            this.bXn.setError_msg(TbadkCoreApplication.m255getInst().getApp().getString(z.img_upload_error));
        }
        try {
            this.bXo = new AntiData();
            this.bXo.parserJson(new JSONObject(ov).optJSONObject("anti_stat"));
        } catch (Exception e) {
        }
        return ov;
    }

    public boolean ma() {
        if (this.CV == null) {
            return false;
        }
        return this.CV.oW().pW().ma();
    }

    public void cancel() {
        this.isCancelled = true;
        if (this.CV != null) {
            this.CV.dL();
        }
        if (this.abd != null) {
            this.abd.cancel();
        }
    }

    public AntiData ahi() {
        return this.bXo;
    }

    public ErrorData ahj() {
        return this.bXn;
    }
}
