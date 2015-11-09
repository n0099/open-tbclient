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
    private static final String dbo = String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.POST_THREAD_ADDRESS;
    private static final String dbp = String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.REPLY_THREAD_ADDRESS;
    public static final String dbq = String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.POST_THREAD_FOR_SHARE_ADDRESS;
    private c asN;
    private ErrorData dbr;
    private AntiData dbs;
    private w afm = null;
    private boolean asZ = false;

    /* renamed from: com.baidu.tieba.tbadkCore.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0076a {
        public static int dbt = 1;
    }

    public a() {
        this.dbr = null;
        this.dbr = new ErrorData();
    }

    public ImageUploadResult b(ImageFileInfo imageFileInfo) {
        if (imageFileInfo == null) {
            return null;
        }
        if (this.asN == null) {
            this.asN = new c("HTTPWriteService.postImageData");
        }
        return this.asN.a(imageFileInfo);
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
        this.afm = new w();
        this.afm.uh().uZ().mIsNeedTbs = true;
        if (writeData.getType() == 3) {
            if (writeData.getVcode() != null && writeData.getVcode().length() > 0) {
                this.afm.o("vcode", writeData.getVcode());
            }
            if (TbadkCoreApplication.m411getInst().getNewVcodeWebviewCrashCount() < 3) {
                this.afm.o("tag", "11");
            }
            this.afm.o("newVcode", "1");
            this.afm.o(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_CONTENT, writeData.getContent());
            this.afm.setUrl(dbq);
            this.afm.o(ImageViewerConfig.FORUM_NAME, writeData.getForumName());
            this.afm.o("title", writeData.getTitle());
            this.afm.o("apiKey", writeData.getShareApiKey());
            this.afm.o("appName", writeData.getShareAppName());
            this.afm.o("signKey", writeData.getShareSignKey());
            this.afm.o("summary_title", writeData.getShareSummaryTitle());
            this.afm.o("summary_content", writeData.getShareSummaryContent());
            this.afm.o("summary_img", writeData.getShareSummaryImg());
            this.afm.o(WriteShareActivityConfig.SHARE_SUMMARY_IMG_WIDTH, String.valueOf(writeData.getShareSummaryImgWidth()));
            this.afm.o(WriteShareActivityConfig.SHARE_SUMMARY_IMG_HEIGHT, String.valueOf(writeData.getShareSummaryImgHeight()));
            this.afm.o(WriteShareActivityConfig.SHARE_SUMMARY_IMG_TYPE, writeData.getShareSummaryImgType());
            this.afm.o("referUrl", writeData.getShareReferUrl());
            str2 = null;
        } else {
            if (z && writeData.isHasImages()) {
                if (this.asN == null) {
                    this.asN = new c("HTTPWriteService.postWriteData");
                }
                if (writeData.getType() == 6) {
                    if (!this.asN.b(writeData.getWriteImagesInfo())) {
                        this.dbr.setError_code(-53);
                        this.dbr.setError_msg(TbadkCoreApplication.m411getInst().getString(i.h.upload_error));
                        return null;
                    }
                } else {
                    this.asN.c(writeData.getWriteImagesInfo());
                }
            }
            if (this.asZ) {
                return null;
            }
            if (writeData.getIsBaobao()) {
                if (this.asN == null) {
                    this.asN = new c("HTTPWriteService.postWriteData");
                }
                this.asN.c(writeData.getBaobaoImagesInfo());
            }
            if (this.asZ) {
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
                    b wj = dI.wj();
                    if (wj != null) {
                        returnVoiceMd5 = wj.wh();
                        com.baidu.tbadk.core.voice.a.b.ah(writeData.getVoice(), returnVoiceMd5);
                        writeData.setReturnVoiceMd5(returnVoiceMd5);
                    } else {
                        m mVar = new m();
                        mVar.h("ErrCode", Integer.valueOf(dI.getErrorCode()));
                        mVar.h("ErrMsg", dI.getErrorString());
                        TiebaStatic.voiceError(TbErrInfo.ERR_VOI_SEND, "audioUploadData is null", mVar.toString());
                        this.dbr.setError_code(dI.getErrorCode());
                        this.dbr.setError_msg(dI.getErrorString());
                        return null;
                    }
                } else {
                    m mVar2 = new m();
                    mVar2.h("audioFile", q);
                    TiebaStatic.voiceError(TbErrInfo.ERR_VOI_SEND, "uploadService.upload null or fail", mVar2.toString());
                    this.dbr.setError_code(dI.getErrorCode());
                    this.dbr.setError_msg(dI.getErrorString());
                    return null;
                }
            }
            if (this.asZ) {
                return null;
            }
            this.afm.o("anonymous", "1");
            this.afm.o(ImageViewerConfig.FORUM_ID, writeData.getForumId());
            if (returnVoiceMd5 != null) {
                this.afm.o("voice_md5", returnVoiceMd5);
                this.afm.o("during_time", String.valueOf(voiceDuringTime));
            }
            String imagesCodeForPost = writeData.getImagesCodeForPost();
            if (writeData.getType() != 6 && ((writeData.getType() != 0 || (writeData.getType() == 0 && TextUtils.isEmpty(writeData.getTitle()))) && TextUtils.isEmpty(returnVoiceMd5) && TextUtils.isEmpty(imagesCodeForPost) && TextUtils.isEmpty(writeData.getContent()) && writeData.getVideoInfo() == null)) {
                this.dbr.setError_code(-53);
                this.dbr.setError_msg(TbadkCoreApplication.m411getInst().getString(i.h.sand_fail));
                return null;
            }
            if (writeData.getVcode() != null && writeData.getVcode().length() > 0) {
                this.afm.o("vcode", writeData.getVcode());
            }
            if (TbadkCoreApplication.m411getInst().getNewVcodeWebviewCrashCount() < 3) {
                this.afm.o("vcode_tag", "11");
            }
            Address y = com.baidu.adp.lib.d.a.gC().y(false);
            this.afm.o("new_vcode", "1");
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
            this.afm.o(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_CONTENT, str);
            if (writeData.getIsBaobaoImageUploaded()) {
                this.afm.o("tail_type", String.valueOf(C0076a.dbt));
                this.afm.o("tail_content", writeData.getBaobaoContent());
                writeData.setBabaoPosted(true);
            } else {
                writeData.setBabaoPosted(false);
            }
            switch (writeData.getType()) {
                case 0:
                    this.afm.setUrl(dbo);
                    this.afm.o("kw", writeData.getForumName());
                    this.afm.o("title", writeData.getTitle());
                    this.afm.o("is_ntitle", writeData.isNoTitle() ? "1" : "0");
                    if (writeData.isNoTitle()) {
                        this.afm.o("st_type", "notitle");
                    }
                    if (writeData.getLiveCardData() != null) {
                        this.afm.o("group_id", String.valueOf(writeData.getLiveCardData().getGroupId()));
                        this.afm.o("start_time", String.valueOf(writeData.getLiveCardData().getStartTime()));
                    }
                    if (y != null && TbadkCoreApplication.m411getInst().getIsLocationOn() && !TbConfig.getPositionPagerId().equals(writeData.getForumId())) {
                        this.afm.o("lbs", String.valueOf(String.valueOf(y.getLatitude())) + "," + String.valueOf(y.getLongitude()));
                    }
                    e.a(this.afm, writeData);
                    if (writeData.getCategoryFrom() >= 0) {
                        this.afm.o("fromCategoryId", String.valueOf(writeData.getCategoryFrom()));
                    }
                    if (writeData.getCategoryTo() >= 0) {
                        this.afm.o("toCategoryId", String.valueOf(writeData.getCategoryTo()));
                        str2 = imagesCodeForPost;
                        break;
                    }
                    str2 = imagesCodeForPost;
                    break;
                case 1:
                    this.afm.setUrl(dbp);
                    this.afm.o("tid", writeData.getThreadId());
                    this.afm.o("kw", writeData.getForumName());
                    this.afm.o("is_ad", writeData.getIsAd() ? "1" : "0");
                    if (writeData.isFrsReply()) {
                        this.afm.o("st_param", "frs");
                    }
                    if (com.baidu.tbadk.editortools.c.b.AW().getStatus() == 1) {
                        this.afm.o("ptype", "4");
                    }
                    e.a(this.afm, writeData);
                    str2 = imagesCodeForPost;
                    break;
                case 2:
                    this.afm.setUrl(dbp);
                    this.afm.o("tid", writeData.getThreadId());
                    this.afm.o("kw", writeData.getForumName());
                    this.afm.o("quote_id", String.valueOf(writeData.getFloor()));
                    this.afm.o("is_twzhibo_thread", String.valueOf(0));
                    this.afm.o("floor_num", String.valueOf(writeData.getFloorNum()));
                    if (writeData.getRepostId() != null) {
                        this.afm.o("repostid", writeData.getRepostId());
                    }
                    this.afm.o("is_ad", writeData.getIsAd() ? "1" : "0");
                    this.afm.o(WriteActivityConfig.IS_ADDITION, writeData.isAddition() ? "1" : "0");
                    this.afm.o("is_giftpost", writeData.isGiftPost() ? "1" : "0");
                    this.afm.o("is_giftpost", writeData.isGiftPost() ? "1" : "0");
                    if (writeData.isAddition()) {
                        this.afm.o("st_type", "conadd");
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
                    this.afm.setUrl(dbo);
                    this.afm.o("kw", writeData.getForumName());
                    this.afm.o("title", writeData.getTitle());
                    this.afm.o("thread_type", "33");
                    e.a(this.afm, writeData);
                    str2 = imagesCodeForPost;
                    break;
                case 5:
                    this.afm.setUrl(dbp);
                    this.afm.o("tid", writeData.getThreadId());
                    this.afm.o("kw", writeData.getForumName());
                    this.afm.o("is_twzhibo_thread", String.valueOf(1));
                    e.a(this.afm, writeData);
                    str2 = imagesCodeForPost;
                    break;
                case 6:
                    this.afm.setUrl(dbo);
                    this.afm.o("kw", writeData.getForumName());
                    this.afm.o("thread_type", String.valueOf(36));
                    this.afm.o("title", writeData.getTitle());
                    this.afm.o("is_ntitle", writeData.isNoTitle() ? "1" : "0");
                    if (writeData.isNoTitle()) {
                        this.afm.o("st_type", "notitle");
                    }
                    e.a(this.afm, writeData);
                    str2 = imagesCodeForPost;
                    break;
            }
        }
        String tG = this.afm.tG();
        if (this.afm.uh().va().qT()) {
            this.dbr.parserJson(tG);
        } else {
            this.dbr.setError_code(this.afm.uk() ? this.afm.ul() : this.afm.um());
            this.dbr.setError_msg(this.afm.getErrorString());
        }
        if (this.dbr.error_code != 0 && !com.baidu.adp.lib.util.i.iN()) {
            this.dbr.setError_msg(TbadkCoreApplication.m411getInst().getApp().getString(i.h.neterror));
        } else if (this.dbr.error_code != 0 && ((writeData.isHasImages() || writeData.getIsBaobao()) && j.isEmpty(String.valueOf(writeData.getContent()) + str2))) {
            this.dbr.setError_msg(TbadkCoreApplication.m411getInst().getApp().getString(i.h.img_upload_error));
        }
        try {
            this.dbs = new AntiData();
            this.dbs.parserJson(new JSONObject(tG).optJSONObject("anti_stat"));
        } catch (Exception e) {
        }
        return tG;
    }

    public boolean qT() {
        if (this.afm == null) {
            return false;
        }
        return this.afm.uh().va().qT();
    }

    public void cancel() {
        this.asZ = true;
        if (this.afm != null) {
            this.afm.gJ();
        }
        if (this.asN != null) {
            this.asN.cancel();
        }
    }

    public AntiData axI() {
        return this.dbs;
    }

    public ErrorData axJ() {
        return this.dbr;
    }
}
