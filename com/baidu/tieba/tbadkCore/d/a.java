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
    private static final String cJa = String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.POST_THREAD_ADDRESS;
    private static final String cJb = String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.REPLY_THREAD_ADDRESS;
    public static final String cJc = String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.POST_THREAD_FOR_SHARE_ADDRESS;
    private c atR;
    private ErrorData cJd;
    private AntiData cJe;
    private v afJ = null;
    private boolean aud = false;

    /* renamed from: com.baidu.tieba.tbadkCore.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0070a {
        public static int cJf = 1;
    }

    public a() {
        this.cJd = null;
        this.cJd = new ErrorData();
    }

    public ImageUploadResult b(ImageFileInfo imageFileInfo) {
        if (imageFileInfo == null) {
            return null;
        }
        if (this.atR == null) {
            this.atR = new c("HTTPWriteService.postImageData");
        }
        return this.atR.a(imageFileInfo);
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
        this.afJ = new v();
        this.afJ.ue().uV().mIsNeedTbs = true;
        if (writeData.getType() == 3) {
            if (writeData.getVcode() != null && writeData.getVcode().length() > 0) {
                this.afJ.o("vcode", writeData.getVcode());
            }
            if (TbadkCoreApplication.m411getInst().getNewVcodeWebviewCrashCount() < 3) {
                this.afJ.o("tag", "11");
            }
            this.afJ.o("newVcode", "1");
            this.afJ.o(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_CONTENT, writeData.getContent());
            this.afJ.setUrl(cJc);
            this.afJ.o(ImageViewerConfig.FORUM_NAME, writeData.getForumName());
            this.afJ.o("title", writeData.getTitle());
            this.afJ.o("apiKey", writeData.getShareApiKey());
            this.afJ.o("appName", writeData.getShareAppName());
            this.afJ.o("signKey", writeData.getShareSignKey());
            this.afJ.o("summary_title", writeData.getShareSummaryTitle());
            this.afJ.o("summary_content", writeData.getShareSummaryContent());
            this.afJ.o("summary_img", writeData.getShareSummaryImg());
            this.afJ.o(WriteShareActivityConfig.SHARE_SUMMARY_IMG_WIDTH, String.valueOf(writeData.getShareSummaryImgWidth()));
            this.afJ.o(WriteShareActivityConfig.SHARE_SUMMARY_IMG_HEIGHT, String.valueOf(writeData.getShareSummaryImgHeight()));
            this.afJ.o(WriteShareActivityConfig.SHARE_SUMMARY_IMG_TYPE, writeData.getShareSummaryImgType());
            this.afJ.o("referUrl", writeData.getShareReferUrl());
            str2 = null;
        } else {
            if (z && writeData.isHasImages()) {
                if (this.atR == null) {
                    this.atR = new c("HTTPWriteService.postWriteData");
                }
                this.atR.b(writeData.getWriteImagesInfo());
            }
            if (this.aud) {
                return null;
            }
            if (writeData.getIsBaobao()) {
                if (this.atR == null) {
                    this.atR = new c("HTTPWriteService.postWriteData");
                }
                this.atR.b(writeData.getBaobaoImagesInfo());
            }
            if (this.aud) {
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
                com.baidu.tbadk.coreExtra.data.c dx = cVar.dx(q);
                if (dx != null && dx.isSuccess()) {
                    b wq = dx.wq();
                    if (wq != null) {
                        returnVoiceMd5 = wq.wo();
                        com.baidu.tbadk.core.voice.a.b.ai(writeData.getVoice(), returnVoiceMd5);
                        writeData.setReturnVoiceMd5(returnVoiceMd5);
                    } else {
                        m mVar = new m();
                        mVar.h("ErrCode", Integer.valueOf(dx.getErrorCode()));
                        mVar.h("ErrMsg", dx.getErrorString());
                        TiebaStatic.voiceError(TbErrInfo.ERR_VOI_SEND, "audioUploadData is null", mVar.toString());
                        this.cJd.setError_code(dx.getErrorCode());
                        this.cJd.setError_msg(dx.getErrorString());
                        return null;
                    }
                } else {
                    m mVar2 = new m();
                    mVar2.h("audioFile", q);
                    TiebaStatic.voiceError(TbErrInfo.ERR_VOI_SEND, "uploadService.upload null or fail", mVar2.toString());
                    this.cJd.setError_code(dx.getErrorCode());
                    this.cJd.setError_msg(dx.getErrorString());
                    return null;
                }
            }
            if (!this.aud) {
                this.afJ.o("anonymous", "1");
                this.afJ.o(ImageViewerConfig.FORUM_ID, writeData.getForumId());
                if (returnVoiceMd5 != null) {
                    this.afJ.o("voice_md5", returnVoiceMd5);
                    this.afJ.o("during_time", String.valueOf(voiceDuringTime));
                }
                String imagesCodeForPost = writeData.getImagesCodeForPost();
                if ((writeData.getType() != 0 || (writeData.getType() == 0 && TextUtils.isEmpty(writeData.getTitle()))) && TextUtils.isEmpty(returnVoiceMd5) && TextUtils.isEmpty(imagesCodeForPost) && TextUtils.isEmpty(writeData.getContent()) && writeData.getVideoInfo() == null) {
                    this.cJd.setError_code(-53);
                    this.cJd.setError_msg(TbadkCoreApplication.m411getInst().getString(i.C0057i.sand_fail));
                    return null;
                }
                if (writeData.getVcode() != null && writeData.getVcode().length() > 0) {
                    this.afJ.o("vcode", writeData.getVcode());
                }
                if (TbadkCoreApplication.m411getInst().getNewVcodeWebviewCrashCount() < 3) {
                    this.afJ.o("vcode_tag", "11");
                }
                Address y = com.baidu.adp.lib.d.a.gF().y(false);
                this.afJ.o("new_vcode", "1");
                if (writeData.getVideoInfo() == null) {
                    str = String.valueOf(writeData.getContent()) + imagesCodeForPost;
                } else {
                    str = String.valueOf(writeData.getContent()) + writeData.getVideoInfo().buildWriteContent(writeData.getForumName()) + imagesCodeForPost;
                }
                this.afJ.o(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_CONTENT, str);
                if (writeData.getIsBaobaoImageUploaded()) {
                    this.afJ.o("tail_type", String.valueOf(C0070a.cJf));
                    this.afJ.o(TailEditActivityConfig.TAIL_CONTENT, writeData.getBaobaoContent());
                    writeData.setBabaoPosted(true);
                } else {
                    writeData.setBabaoPosted(false);
                }
                switch (writeData.getType()) {
                    case 0:
                        this.afJ.setUrl(cJa);
                        this.afJ.o("kw", writeData.getForumName());
                        this.afJ.o("title", writeData.getTitle());
                        this.afJ.o("is_ntitle", writeData.isNoTitle() ? "1" : "0");
                        if (writeData.isNoTitle()) {
                            this.afJ.o("st_type", "notitle");
                        }
                        if (writeData.getLiveCardData() != null) {
                            this.afJ.o("group_id", String.valueOf(writeData.getLiveCardData().getGroupId()));
                            this.afJ.o("start_time", String.valueOf(writeData.getLiveCardData().getStartTime()));
                        }
                        if (y != null && TbadkCoreApplication.m411getInst().getIsLocationOn() && !TbConfig.getPositionPagerId().equals(writeData.getForumId())) {
                            this.afJ.o("lbs", String.valueOf(String.valueOf(y.getLatitude())) + "," + String.valueOf(y.getLongitude()));
                        }
                        com.baidu.tieba.tbadkCore.writeModel.c.a(this.afJ, writeData);
                        str2 = imagesCodeForPost;
                        break;
                    case 1:
                        this.afJ.setUrl(cJb);
                        this.afJ.o("tid", writeData.getThreadId());
                        this.afJ.o("kw", writeData.getForumName());
                        this.afJ.o("is_ad", writeData.getIsAd() ? "1" : "0");
                        if (writeData.isFrsReply()) {
                            this.afJ.o("st_param", "frs");
                        }
                        com.baidu.tieba.tbadkCore.writeModel.c.a(this.afJ, writeData);
                        str2 = imagesCodeForPost;
                        break;
                    case 2:
                        this.afJ.setUrl(cJb);
                        this.afJ.o("tid", writeData.getThreadId());
                        this.afJ.o("kw", writeData.getForumName());
                        this.afJ.o("quote_id", String.valueOf(writeData.getFloor()));
                        this.afJ.o("floor_num", String.valueOf(writeData.getFloorNum()));
                        if (writeData.getRepostId() != null) {
                            this.afJ.o("repostid", writeData.getRepostId());
                        }
                        this.afJ.o("is_ad", writeData.getIsAd() ? "1" : "0");
                        this.afJ.o(WriteActivityConfig.IS_ADDITION, writeData.isAddition() ? "1" : "0");
                        if (writeData.isAddition()) {
                            this.afJ.o("st_type", "conadd");
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
                        this.afJ.setUrl(cJa);
                        this.afJ.o("kw", writeData.getForumName());
                        this.afJ.o("title", writeData.getTitle());
                        this.afJ.o("thread_type", "33");
                        if (writeData.getPhotoLiveCoverUlrData() != null) {
                            this.afJ.o("livecover_src", writeData.getPhotoLiveCoverUlrData().getToServerPhotoInfo());
                        }
                        com.baidu.tieba.tbadkCore.writeModel.c.a(this.afJ, writeData);
                        str2 = imagesCodeForPost;
                        break;
                    case 5:
                        this.afJ.setUrl(cJb);
                        this.afJ.o("tid", writeData.getThreadId());
                        this.afJ.o("kw", writeData.getForumName());
                        com.baidu.tieba.tbadkCore.writeModel.c.a(this.afJ, writeData);
                        str2 = imagesCodeForPost;
                        break;
                }
            } else {
                return null;
            }
        }
        String tD = this.afJ.tD();
        if (this.afJ.ue().uW().rb()) {
            this.cJd.parserJson(tD);
        } else {
            this.cJd.setError_code(this.afJ.uh() ? this.afJ.ui() : this.afJ.uj());
            this.cJd.setError_msg(this.afJ.getErrorString());
        }
        if (this.cJd.error_code != 0 && ((writeData.isHasImages() || writeData.getIsBaobao()) && j.isEmpty(String.valueOf(writeData.getContent()) + str2))) {
            this.cJd.setError_msg(TbadkCoreApplication.m411getInst().getApp().getString(i.C0057i.img_upload_error));
        }
        try {
            this.cJe = new AntiData();
            this.cJe.parserJson(new JSONObject(tD).optJSONObject("anti_stat"));
        } catch (Exception e) {
        }
        return tD;
    }

    public boolean rb() {
        if (this.afJ == null) {
            return false;
        }
        return this.afJ.ue().uW().rb();
    }

    public void cancel() {
        this.aud = true;
        if (this.afJ != null) {
            this.afJ.gM();
        }
        if (this.atR != null) {
            this.atR.cancel();
        }
    }

    public AntiData aqj() {
        return this.cJe;
    }

    public ErrorData aqk() {
        return this.cJd;
    }
}
