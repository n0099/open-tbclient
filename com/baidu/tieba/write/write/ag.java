package com.baidu.tieba.write.write;

import android.content.Intent;
import android.location.Address;
import android.os.Bundle;
import android.widget.EditText;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AddFriendActivityConfig;
import com.baidu.tbadk.core.atomData.CreateGroupActivityActivityConfig;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.atomData.WriteActivityConfig;
import com.baidu.tbadk.core.atomData.WriteShareActivityConfig;
import com.baidu.tbadk.core.data.ErrorData;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.game.GameInfoData;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import org.json.JSONException;
import org.json.JSONObject;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ag extends BdAsyncTask<Integer, Integer, com.baidu.tbadk.coreExtra.data.l> {
    private com.baidu.tbadk.core.util.aa ZF = null;
    private String axk = null;
    final /* synthetic */ VcodeActivity cxP;
    private WriteData cxR;

    public ag(VcodeActivity vcodeActivity, WriteData writeData) {
        this.cxP = vcodeActivity;
        this.cxR = null;
        this.cxR = writeData;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: g */
    public com.baidu.tbadk.coreExtra.data.l doInBackground(Integer... numArr) {
        EditText editText;
        Address z;
        if (this.cxR != null) {
            this.ZF = new com.baidu.tbadk.core.util.aa();
            editText = this.cxP.mEdit;
            String editable = editText.getText().toString();
            String imagesCodeForPost = this.cxR.getImagesCodeForPost();
            if (this.cxR.getType() == 3) {
                this.ZF.o("newVcode", "1");
                this.ZF.o(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_CONTENT, String.valueOf(this.cxR.getContent()) + imagesCodeForPost);
                this.ZF.o("vcodeMd5", this.cxR.getVcodeMD5());
                if (editable.length() > 0) {
                    this.ZF.o("vcode", editable);
                }
                this.ZF.o("tag", "11");
                this.ZF.sp().tp().mIsNeedTbs = true;
                this.ZF.o(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_CONTENT, String.valueOf(this.cxR.getContent()) + imagesCodeForPost);
                this.ZF.setUrl(com.baidu.tieba.tbadkCore.d.a.coy);
                this.ZF.o(ImageViewerConfig.FORUM_NAME, this.cxR.getForumName());
                this.ZF.o("title", this.cxR.getTitle());
                this.ZF.o("apiKey", this.cxR.getShareApiKey());
                this.ZF.o("appName", this.cxR.getShareAppName());
                this.ZF.o("signKey", this.cxR.getShareSignKey());
                this.ZF.o("summary_title", this.cxR.getShareSummaryTitle());
                this.ZF.o("summary_content", this.cxR.getShareSummaryContent());
                this.ZF.o("summary_img", this.cxR.getShareSummaryImg());
                this.ZF.o(WriteShareActivityConfig.SHARE_SUMMARY_IMG_WIDTH, String.valueOf(this.cxR.getShareSummaryImgWidth()));
                this.ZF.o(WriteShareActivityConfig.SHARE_SUMMARY_IMG_HEIGHT, String.valueOf(this.cxR.getShareSummaryImgHeight()));
                this.ZF.o(WriteShareActivityConfig.SHARE_SUMMARY_IMG_TYPE, this.cxR.getShareSummaryImgType());
                this.ZF.o("referUrl", this.cxR.getShareReferUrl());
            } else {
                this.ZF.o("anonymous", GameInfoData.NOT_FROM_DETAIL);
                this.ZF.o(ImageViewerConfig.FORUM_ID, this.cxR.getForumId());
                this.ZF.o("kw", this.cxR.getForumName());
                this.ZF.o("new_vcode", "1");
                this.ZF.o(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_CONTENT, String.valueOf(this.cxR.getContent()) + imagesCodeForPost);
                if (this.cxR.getIsBaobaoImageUploaded()) {
                    this.ZF.o("tail_type", String.valueOf(com.baidu.tieba.tbadkCore.d.b.coB));
                    this.ZF.o("tail_content", this.cxR.getBaobaoContent());
                    this.cxR.setBabaoPosted(true);
                } else {
                    this.cxR.setBabaoPosted(false);
                }
                com.baidu.tieba.tbadkCore.writeModel.h.a(this.ZF, this.cxR);
                this.ZF.o("vcode_md5", this.cxR.getVcodeMD5());
                if (editable.length() > 0) {
                    this.ZF.o("vcode", editable);
                }
                this.ZF.sp().tp().mIsNeedTbs = true;
                if (this.cxR.getVoice() != null) {
                    this.ZF.o("voice_md5", this.cxR.getVoice());
                    this.ZF.o("during_time", String.valueOf(this.cxR.getVoiceDuringTime()));
                }
                if (this.cxR.getType() == 0) {
                    this.ZF.setUrl(String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.POST_THREAD_ADDRESS);
                    this.ZF.o("title", this.cxR.getTitle());
                    this.ZF.o("is_ntitle", this.cxR.isNoTitle() ? "1" : GameInfoData.NOT_FROM_DETAIL);
                    if (this.cxR.getLiveCardData() != null) {
                        this.ZF.o("group_id", String.valueOf(this.cxR.getLiveCardData().getGroupId()));
                        this.ZF.o("start_time", String.valueOf(this.cxR.getLiveCardData().getStartTime()));
                    }
                    if (!TbConfig.getPositionPagerId().equals(this.cxP.getIntent().getStringExtra("forum_id")) && TbadkCoreApplication.m411getInst().getIsLocationOn() && (z = com.baidu.adp.lib.d.a.gZ().z(false)) != null) {
                        this.ZF.o("lbs", String.valueOf(String.valueOf(z.getLatitude())) + "," + String.valueOf(z.getLongitude()));
                    }
                } else {
                    this.ZF.setUrl(String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.REPLY_THREAD_ADDRESS);
                    this.ZF.o("tid", this.cxR.getThreadId());
                    this.ZF.o("is_ad", this.cxP.getIntent().getBooleanExtra("is_ad", false) ? "1" : GameInfoData.NOT_FROM_DETAIL);
                    if (this.cxR.getType() == 2) {
                        this.ZF.o("quote_id", String.valueOf(this.cxR.getFloor()));
                        this.ZF.o(WriteActivityConfig.FLOOR_NUM, String.valueOf(this.cxR.getFloorNum()));
                        this.ZF.o(WriteActivityConfig.IS_ADDITION, this.cxR.isAddition() ? "1" : GameInfoData.NOT_FROM_DETAIL);
                        if (this.cxR.getRepostId() != null) {
                            this.ZF.o("repostid", this.cxR.getRepostId());
                        }
                    }
                }
            }
            this.axk = this.ZF.rO();
        }
        return null;
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        this.cxP.cxN = null;
        this.cxP.closeLoadingDialog();
        if (this.ZF != null) {
            this.ZF.hh();
        }
        super.cancel(true);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00bd  */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onPostExecute(com.baidu.tbadk.coreExtra.data.l lVar) {
        EditText editText;
        WriteData writeData;
        WriteData writeData2;
        WriteData writeData3;
        String str;
        String str2;
        JSONException e;
        this.cxP.closeLoadingDialog();
        this.cxP.cxN = null;
        if (this.ZF != null) {
            if (this.ZF.sp().tq().pv()) {
                ErrorData errorData = new ErrorData();
                errorData.parserJson(this.axk);
                if (errorData.error_code == 0) {
                    try {
                        str = new JSONObject(this.axk).optString(AddFriendActivityConfig.MSG);
                    } catch (JSONException e2) {
                        e2.printStackTrace();
                        str = null;
                    }
                    if (StringUtils.isNull(str)) {
                        str = TbadkCoreApplication.m411getInst().getString(com.baidu.tieba.y.send_success);
                    }
                    if (this.cxR.getType() != 3) {
                        com.baidu.tieba.tbadkCore.writeModel.h.L(this.cxP.getPageContext().getPageActivity(), str);
                    }
                    this.cxR.deleteUploadedTempImages();
                    if (this.cxR != null && this.cxR.isBabaoPosted()) {
                        com.baidu.tieba.tbadkCore.PbEditor.a.aln();
                    }
                } else if ((this.cxR.isHasImages() || this.cxR.getIsBaobao()) && com.baidu.adp.lib.util.m.isEmpty(String.valueOf(this.cxR.getContent()) + this.cxR.getImagesCodeForPost())) {
                    this.cxP.showToast(TbadkCoreApplication.m411getInst().getString(com.baidu.tieba.y.img_upload_error));
                } else if (this.cxR.getType() != 3) {
                    this.cxP.showToast(errorData.getError_msg());
                }
                PostWriteCallBackData postWriteCallBackData = new PostWriteCallBackData(null, null, null);
                String str3 = "";
                try {
                    str2 = new JSONObject(this.axk).optString("tid");
                    try {
                        str3 = new JSONObject(this.axk).optString("pid");
                    } catch (JSONException e3) {
                        e = e3;
                        e.printStackTrace();
                        postWriteCallBackData.setThreadId(str2);
                        postWriteCallBackData.setPostId(str3);
                        Intent intent = new Intent();
                        Bundle bundle = new Bundle();
                        bundle.putSerializable("post_write_callback_data", postWriteCallBackData);
                        intent.putExtras(bundle);
                        this.cxP.setResult(-1, intent);
                        if (this.cxR.getLiveCardData() != null) {
                        }
                        this.cxP.finish();
                        super.onPostExecute(lVar);
                    }
                } catch (JSONException e4) {
                    str2 = "";
                    e = e4;
                }
                postWriteCallBackData.setThreadId(str2);
                postWriteCallBackData.setPostId(str3);
                Intent intent2 = new Intent();
                Bundle bundle2 = new Bundle();
                bundle2.putSerializable("post_write_callback_data", postWriteCallBackData);
                intent2.putExtras(bundle2);
                this.cxP.setResult(-1, intent2);
                if (this.cxR.getLiveCardData() != null) {
                    this.cxP.sendMessage(new CustomMessage(2003001, new FrsActivityConfig(this.cxP.getPageContext().getPageActivity()).createRefreshCfgShowContent(this.cxR.getForumName(), "post live's thread")));
                }
                this.cxP.finish();
            } else if (this.cxR.isHasImages() && com.baidu.adp.lib.util.m.isEmpty(String.valueOf(this.cxR.getContent()) + this.cxR.getImagesCodeForPost())) {
                this.cxP.showToast(TbadkCoreApplication.m411getInst().getString(com.baidu.tieba.y.img_upload_error));
            } else {
                if (this.ZF.st() == 5 || this.ZF.st() == 6) {
                    com.baidu.tbadk.coreExtra.data.l lVar2 = new com.baidu.tbadk.coreExtra.data.l();
                    lVar2.parserJson(this.axk);
                    if (lVar2.getVcode_pic_url() != null) {
                        writeData = this.cxP.cxz;
                        writeData.setVcodeMD5(lVar2.getVcode_md5());
                        writeData2 = this.cxP.cxz;
                        writeData2.setVcodeUrl(lVar2.getVcode_pic_url());
                        VcodeActivity vcodeActivity = this.cxP;
                        writeData3 = this.cxP.cxz;
                        vcodeActivity.eV(writeData3.getVcodeUrl());
                    }
                    editText = this.cxP.mEdit;
                    editText.setText((CharSequence) null);
                }
                this.cxP.showToast(this.ZF.getErrorString());
            }
        }
        super.onPostExecute(lVar);
    }
}
