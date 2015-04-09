package com.baidu.tieba.tbadkCore.d;

import android.location.Address;
import com.baidu.adp.lib.util.m;
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
import com.baidu.tbadk.core.util.n;
import com.baidu.tbadk.core.util.o;
import com.baidu.tbadk.core.voice.service.c;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.game.GameInfoData;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tbadk.img.ImageUploadResult;
import com.baidu.tbadk.img.h;
import com.baidu.tieba.y;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class a {
    private static final String cow = String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.POST_THREAD_ADDRESS;
    private static final String cox = String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.REPLY_THREAD_ADDRESS;
    public static final String coy = String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.POST_THREAD_FOR_SHARE_ADDRESS;
    private h all;
    private AntiData coA;
    private ErrorData coz;
    private aa ZF = null;
    private boolean isCancelled = false;

    public a() {
        this.coz = null;
        this.coz = new ErrorData();
    }

    public ImageUploadResult b(ImageFileInfo imageFileInfo) {
        if (imageFileInfo == null) {
            return null;
        }
        if (this.all == null) {
            this.all = new h("HTTPWriteService.postImageData");
        }
        return this.all.a(imageFileInfo);
    }

    public String a(WriteData writeData, boolean z) {
        String returnVoiceMd5;
        boolean z2;
        String str;
        if (writeData == null) {
            return null;
        }
        this.ZF = new aa();
        this.ZF.sp().tp().mIsNeedTbs = true;
        if (writeData.getType() == 3) {
            if (writeData.getVcode() != null && writeData.getVcode().length() > 0) {
                this.ZF.o("vcode", writeData.getVcode());
            }
            if (TbadkCoreApplication.m411getInst().getNewVcodeWebviewCrashCount() < 3) {
                this.ZF.o("tag", "11");
            }
            this.ZF.o("newVcode", "1");
            this.ZF.o(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_CONTENT, writeData.getContent());
            this.ZF.setUrl(coy);
            this.ZF.o(ImageViewerConfig.FORUM_NAME, writeData.getForumName());
            this.ZF.o("title", writeData.getTitle());
            this.ZF.o("apiKey", writeData.getShareApiKey());
            this.ZF.o("appName", writeData.getShareAppName());
            this.ZF.o("signKey", writeData.getShareSignKey());
            this.ZF.o("summary_title", writeData.getShareSummaryTitle());
            this.ZF.o("summary_content", writeData.getShareSummaryContent());
            this.ZF.o("summary_img", writeData.getShareSummaryImg());
            this.ZF.o(WriteShareActivityConfig.SHARE_SUMMARY_IMG_WIDTH, String.valueOf(writeData.getShareSummaryImgWidth()));
            this.ZF.o(WriteShareActivityConfig.SHARE_SUMMARY_IMG_HEIGHT, String.valueOf(writeData.getShareSummaryImgHeight()));
            this.ZF.o(WriteShareActivityConfig.SHARE_SUMMARY_IMG_TYPE, writeData.getShareSummaryImgType());
            this.ZF.o("referUrl", writeData.getShareReferUrl());
            str = null;
        } else {
            if (z && writeData.isHasImages()) {
                if (this.all == null) {
                    this.all = new h("HTTPWriteService.postWriteData");
                }
                this.all.a(writeData.getWriteImagesInfo());
            }
            if (this.isCancelled) {
                return null;
            }
            if (writeData.getIsBaobao()) {
                if (this.all == null) {
                    this.all = new h("HTTPWriteService.postWriteData");
                }
                this.all.a(writeData.getBaobaoImagesInfo());
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
                String o = o.o(voice, 1);
                com.baidu.tbadk.coreExtra.data.c df = cVar.df(o);
                if (df != null && df.isSuccess()) {
                    com.baidu.tbadk.coreExtra.data.b uz = df.uz();
                    if (uz != null) {
                        returnVoiceMd5 = uz.ux();
                        com.baidu.tbadk.core.voice.a.b.ad(writeData.getVoice(), returnVoiceMd5);
                        writeData.setReturnVoiceMd5(returnVoiceMd5);
                    } else {
                        n nVar = new n();
                        nVar.h("ErrCode", Integer.valueOf(df.getErrorCode()));
                        nVar.h("ErrMsg", df.getErrorString());
                        TiebaStatic.voiceError("", TbErrInfo.ERR_VOI_SEND, "audioUploadData is null", nVar.toString());
                        this.coz.setError_code(df.getErrorCode());
                        this.coz.setError_msg(df.getErrorString());
                        return null;
                    }
                } else {
                    n nVar2 = new n();
                    nVar2.h("audioFile", o);
                    TiebaStatic.voiceError("", TbErrInfo.ERR_VOI_SEND, "uploadService.upload null or fail", nVar2.toString());
                    return null;
                }
            }
            if (!this.isCancelled) {
                this.ZF.o("anonymous", "1");
                this.ZF.o(ImageViewerConfig.FORUM_ID, writeData.getForumId());
                if (returnVoiceMd5 != null) {
                    this.ZF.o("voice_md5", returnVoiceMd5);
                    this.ZF.o("during_time", String.valueOf(voiceDuringTime));
                }
                String imagesCodeForPost = writeData.getImagesCodeForPost();
                if (writeData.getVcode() != null && writeData.getVcode().length() > 0) {
                    this.ZF.o("vcode", writeData.getVcode());
                }
                if (TbadkCoreApplication.m411getInst().getNewVcodeWebviewCrashCount() < 3) {
                    this.ZF.o("vcode_tag", "11");
                }
                Address z3 = com.baidu.adp.lib.d.a.gZ().z(false);
                this.ZF.o("new_vcode", "1");
                this.ZF.o(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_CONTENT, String.valueOf(writeData.getContent()) + imagesCodeForPost);
                if (writeData.getIsBaobaoImageUploaded()) {
                    this.ZF.o("tail_type", String.valueOf(b.coB));
                    this.ZF.o("tail_content", writeData.getBaobaoContent());
                    writeData.setBabaoPosted(true);
                } else {
                    writeData.setBabaoPosted(false);
                }
                switch (writeData.getType()) {
                    case 0:
                        this.ZF.setUrl(cow);
                        this.ZF.o("kw", writeData.getForumName());
                        this.ZF.o("title", writeData.getTitle());
                        this.ZF.o("is_ntitle", writeData.isNoTitle() ? "1" : GameInfoData.NOT_FROM_DETAIL);
                        if (writeData.isNoTitle()) {
                            this.ZF.o("st_type", "notitle");
                        }
                        if (writeData.getLiveCardData() != null) {
                            this.ZF.o("group_id", String.valueOf(writeData.getLiveCardData().getGroupId()));
                            this.ZF.o("start_time", String.valueOf(writeData.getLiveCardData().getStartTime()));
                        }
                        if (z3 != null && TbadkCoreApplication.m411getInst().getIsLocationOn() && !TbConfig.getPositionPagerId().equals(writeData.getForumId())) {
                            this.ZF.o("lbs", String.valueOf(String.valueOf(z3.getLatitude())) + "," + String.valueOf(z3.getLongitude()));
                        }
                        com.baidu.tieba.tbadkCore.writeModel.h.a(this.ZF, writeData);
                        str = imagesCodeForPost;
                        break;
                    case 1:
                        this.ZF.setUrl(cox);
                        this.ZF.o("tid", writeData.getThreadId());
                        this.ZF.o("kw", writeData.getForumName());
                        this.ZF.o("is_ad", writeData.getIsAd() ? "1" : GameInfoData.NOT_FROM_DETAIL);
                        if (writeData.isFrsReply()) {
                            this.ZF.o("st_param", "frs");
                        }
                        com.baidu.tieba.tbadkCore.writeModel.h.a(this.ZF, writeData);
                        str = imagesCodeForPost;
                        break;
                    case 2:
                        this.ZF.setUrl(cox);
                        this.ZF.o("tid", writeData.getThreadId());
                        this.ZF.o("kw", writeData.getForumName());
                        this.ZF.o("quote_id", String.valueOf(writeData.getFloor()));
                        this.ZF.o(WriteActivityConfig.FLOOR_NUM, String.valueOf(writeData.getFloorNum()));
                        if (writeData.getRepostId() != null) {
                            this.ZF.o("repostid", writeData.getRepostId());
                        }
                        this.ZF.o("is_ad", writeData.getIsAd() ? "1" : GameInfoData.NOT_FROM_DETAIL);
                        this.ZF.o(WriteActivityConfig.IS_ADDITION, writeData.isAddition() ? "1" : GameInfoData.NOT_FROM_DETAIL);
                        if (writeData.isAddition()) {
                            this.ZF.o("st_type", "conadd");
                        }
                    default:
                        str = imagesCodeForPost;
                        break;
                }
            } else {
                return null;
            }
        }
        String rO = this.ZF.rO();
        if (this.ZF.sp().tq().pv()) {
            this.coz.parserJson(rO);
        } else {
            this.coz.setError_code(this.ZF.ss() ? this.ZF.st() : this.ZF.su());
            this.coz.setError_msg(this.ZF.getErrorString());
        }
        if (this.coz.error_code != 0 && ((writeData.isHasImages() || writeData.getIsBaobao()) && m.isEmpty(String.valueOf(writeData.getContent()) + str))) {
            this.coz.setError_msg(TbadkCoreApplication.m411getInst().getApp().getString(y.img_upload_error));
        }
        try {
            this.coA = new AntiData();
            this.coA.parserJson(new JSONObject(rO).optJSONObject("anti_stat"));
        } catch (Exception e) {
        }
        return rO;
    }

    public boolean pv() {
        if (this.ZF == null) {
            return false;
        }
        return this.ZF.sp().tq().pv();
    }

    public void cancel() {
        this.isCancelled = true;
        if (this.ZF != null) {
            this.ZF.hh();
        }
        if (this.all != null) {
            this.all.cancel();
        }
    }

    public AntiData amY() {
        return this.coA;
    }

    public ErrorData amZ() {
        return this.coz;
    }
}
