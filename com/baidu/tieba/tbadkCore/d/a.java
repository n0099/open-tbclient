package com.baidu.tieba.tbadkCore.d;

import android.location.Address;
import android.text.TextUtils;
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
import com.baidu.tieba.t;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class a {
    private static final String csx = String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.POST_THREAD_ADDRESS;
    private static final String csy = String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.REPLY_THREAD_ADDRESS;
    public static final String csz = String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.POST_THREAD_FOR_SHARE_ADDRESS;
    private h amm;
    private ErrorData csA;
    private AntiData csB;
    private aa aaG = null;
    private boolean isCancelled = false;

    public a() {
        this.csA = null;
        this.csA = new ErrorData();
    }

    public ImageUploadResult b(ImageFileInfo imageFileInfo) {
        if (imageFileInfo == null) {
            return null;
        }
        if (this.amm == null) {
            this.amm = new h("HTTPWriteService.postImageData");
        }
        return this.amm.a(imageFileInfo);
    }

    public String a(WriteData writeData, boolean z) {
        String returnVoiceMd5;
        boolean z2;
        String str;
        if (writeData == null) {
            return null;
        }
        this.aaG = new aa();
        this.aaG.sX().tS().mIsNeedTbs = true;
        if (writeData.getType() == 3) {
            if (writeData.getVcode() != null && writeData.getVcode().length() > 0) {
                this.aaG.o("vcode", writeData.getVcode());
            }
            if (TbadkCoreApplication.m411getInst().getNewVcodeWebviewCrashCount() < 3) {
                this.aaG.o("tag", "11");
            }
            this.aaG.o("newVcode", "1");
            this.aaG.o(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_CONTENT, writeData.getContent());
            this.aaG.setUrl(csz);
            this.aaG.o(ImageViewerConfig.FORUM_NAME, writeData.getForumName());
            this.aaG.o("title", writeData.getTitle());
            this.aaG.o("apiKey", writeData.getShareApiKey());
            this.aaG.o("appName", writeData.getShareAppName());
            this.aaG.o("signKey", writeData.getShareSignKey());
            this.aaG.o("summary_title", writeData.getShareSummaryTitle());
            this.aaG.o("summary_content", writeData.getShareSummaryContent());
            this.aaG.o("summary_img", writeData.getShareSummaryImg());
            this.aaG.o(WriteShareActivityConfig.SHARE_SUMMARY_IMG_WIDTH, String.valueOf(writeData.getShareSummaryImgWidth()));
            this.aaG.o(WriteShareActivityConfig.SHARE_SUMMARY_IMG_HEIGHT, String.valueOf(writeData.getShareSummaryImgHeight()));
            this.aaG.o(WriteShareActivityConfig.SHARE_SUMMARY_IMG_TYPE, writeData.getShareSummaryImgType());
            this.aaG.o("referUrl", writeData.getShareReferUrl());
            str = null;
        } else {
            if (z && writeData.isHasImages()) {
                if (this.amm == null) {
                    this.amm = new h("HTTPWriteService.postWriteData");
                }
                this.amm.a(writeData.getWriteImagesInfo());
            }
            if (this.isCancelled) {
                return null;
            }
            if (writeData.getIsBaobao()) {
                if (this.amm == null) {
                    this.amm = new h("HTTPWriteService.postWriteData");
                }
                this.amm.a(writeData.getBaobaoImagesInfo());
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
                com.baidu.tbadk.coreExtra.data.c dw = cVar.dw(o);
                if (dw != null && dw.isSuccess()) {
                    com.baidu.tbadk.coreExtra.data.b vi = dw.vi();
                    if (vi != null) {
                        returnVoiceMd5 = vi.vg();
                        com.baidu.tbadk.core.voice.a.b.ai(writeData.getVoice(), returnVoiceMd5);
                        writeData.setReturnVoiceMd5(returnVoiceMd5);
                    } else {
                        n nVar = new n();
                        nVar.h("ErrCode", Integer.valueOf(dw.getErrorCode()));
                        nVar.h("ErrMsg", dw.getErrorString());
                        TiebaStatic.voiceError("", TbErrInfo.ERR_VOI_SEND, "audioUploadData is null", nVar.toString());
                        this.csA.setError_code(dw.getErrorCode());
                        this.csA.setError_msg(dw.getErrorString());
                        return null;
                    }
                } else {
                    n nVar2 = new n();
                    nVar2.h("audioFile", o);
                    TiebaStatic.voiceError("", TbErrInfo.ERR_VOI_SEND, "uploadService.upload null or fail", nVar2.toString());
                    this.csA.setError_code(dw.getErrorCode());
                    this.csA.setError_msg(dw.getErrorString());
                    return null;
                }
            }
            if (!this.isCancelled) {
                this.aaG.o("anonymous", "1");
                this.aaG.o(ImageViewerConfig.FORUM_ID, writeData.getForumId());
                if (returnVoiceMd5 != null) {
                    this.aaG.o("voice_md5", returnVoiceMd5);
                    this.aaG.o("during_time", String.valueOf(voiceDuringTime));
                }
                String imagesCodeForPost = writeData.getImagesCodeForPost();
                if ((writeData.getType() != 0 || (writeData.getType() == 0 && TextUtils.isEmpty(writeData.getTitle()))) && TextUtils.isEmpty(returnVoiceMd5) && TextUtils.isEmpty(imagesCodeForPost) && TextUtils.isEmpty(writeData.getContent())) {
                    this.csA.setError_code(-53);
                    this.csA.setError_msg(TbadkCoreApplication.m411getInst().getString(t.sand_fail));
                    return null;
                }
                if (writeData.getVcode() != null && writeData.getVcode().length() > 0) {
                    this.aaG.o("vcode", writeData.getVcode());
                }
                if (TbadkCoreApplication.m411getInst().getNewVcodeWebviewCrashCount() < 3) {
                    this.aaG.o("vcode_tag", "11");
                }
                Address z3 = com.baidu.adp.lib.d.a.gK().z(false);
                this.aaG.o("new_vcode", "1");
                this.aaG.o(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_CONTENT, String.valueOf(writeData.getContent()) + imagesCodeForPost);
                if (writeData.getIsBaobaoImageUploaded()) {
                    this.aaG.o("tail_type", String.valueOf(b.csC));
                    this.aaG.o("tail_content", writeData.getBaobaoContent());
                    writeData.setBabaoPosted(true);
                } else {
                    writeData.setBabaoPosted(false);
                }
                switch (writeData.getType()) {
                    case 0:
                        this.aaG.setUrl(csx);
                        this.aaG.o("kw", writeData.getForumName());
                        this.aaG.o("title", writeData.getTitle());
                        this.aaG.o("is_ntitle", writeData.isNoTitle() ? "1" : GameInfoData.NOT_FROM_DETAIL);
                        if (writeData.isNoTitle()) {
                            this.aaG.o("st_type", "notitle");
                        }
                        if (writeData.getLiveCardData() != null) {
                            this.aaG.o("group_id", String.valueOf(writeData.getLiveCardData().getGroupId()));
                            this.aaG.o("start_time", String.valueOf(writeData.getLiveCardData().getStartTime()));
                        }
                        if (z3 != null && TbadkCoreApplication.m411getInst().getIsLocationOn() && !TbConfig.getPositionPagerId().equals(writeData.getForumId())) {
                            this.aaG.o("lbs", String.valueOf(String.valueOf(z3.getLatitude())) + "," + String.valueOf(z3.getLongitude()));
                        }
                        com.baidu.tieba.tbadkCore.writeModel.h.a(this.aaG, writeData);
                        str = imagesCodeForPost;
                        break;
                    case 1:
                        this.aaG.setUrl(csy);
                        this.aaG.o("tid", writeData.getThreadId());
                        this.aaG.o("kw", writeData.getForumName());
                        this.aaG.o("is_ad", writeData.getIsAd() ? "1" : GameInfoData.NOT_FROM_DETAIL);
                        if (writeData.isFrsReply()) {
                            this.aaG.o("st_param", "frs");
                        }
                        com.baidu.tieba.tbadkCore.writeModel.h.a(this.aaG, writeData);
                        str = imagesCodeForPost;
                        break;
                    case 2:
                        this.aaG.setUrl(csy);
                        this.aaG.o("tid", writeData.getThreadId());
                        this.aaG.o("kw", writeData.getForumName());
                        this.aaG.o("quote_id", String.valueOf(writeData.getFloor()));
                        this.aaG.o(WriteActivityConfig.FLOOR_NUM, String.valueOf(writeData.getFloorNum()));
                        if (writeData.getRepostId() != null) {
                            this.aaG.o("repostid", writeData.getRepostId());
                        }
                        this.aaG.o("is_ad", writeData.getIsAd() ? "1" : GameInfoData.NOT_FROM_DETAIL);
                        this.aaG.o(WriteActivityConfig.IS_ADDITION, writeData.isAddition() ? "1" : GameInfoData.NOT_FROM_DETAIL);
                        if (writeData.isAddition()) {
                            this.aaG.o("st_type", "conadd");
                        }
                    default:
                        str = imagesCodeForPost;
                        break;
                }
            } else {
                return null;
            }
        }
        String sw = this.aaG.sw();
        if (this.aaG.sX().tT().qa()) {
            this.csA.parserJson(sw);
        } else {
            this.csA.setError_code(this.aaG.ta() ? this.aaG.tb() : this.aaG.tc());
            this.csA.setError_msg(this.aaG.getErrorString());
        }
        if (this.csA.error_code != 0 && ((writeData.isHasImages() || writeData.getIsBaobao()) && m.isEmpty(String.valueOf(writeData.getContent()) + str))) {
            this.csA.setError_msg(TbadkCoreApplication.m411getInst().getApp().getString(t.img_upload_error));
        }
        try {
            this.csB = new AntiData();
            this.csB.parserJson(new JSONObject(sw).optJSONObject("anti_stat"));
        } catch (Exception e) {
        }
        return sw;
    }

    public boolean qa() {
        if (this.aaG == null) {
            return false;
        }
        return this.aaG.sX().tT().qa();
    }

    public void cancel() {
        this.isCancelled = true;
        if (this.aaG != null) {
            this.aaG.gS();
        }
        if (this.amm != null) {
            this.amm.cancel();
        }
    }

    public AntiData aoP() {
        return this.csB;
    }

    public ErrorData aoQ() {
        return this.csA;
    }
}
