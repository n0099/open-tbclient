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
public class ag extends BdAsyncTask<Integer, Integer, com.baidu.tbadk.coreExtra.data.k> {
    private com.baidu.tbadk.core.util.aa ZD = null;
    private String axc = null;
    final /* synthetic */ VcodeActivity cxw;
    private WriteData cxy;

    public ag(VcodeActivity vcodeActivity, WriteData writeData) {
        this.cxw = vcodeActivity;
        this.cxy = null;
        this.cxy = writeData;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: g */
    public com.baidu.tbadk.coreExtra.data.k doInBackground(Integer... numArr) {
        EditText editText;
        Address z;
        if (this.cxy != null) {
            this.ZD = new com.baidu.tbadk.core.util.aa();
            editText = this.cxw.mEdit;
            String editable = editText.getText().toString();
            String imagesCodeForPost = this.cxy.getImagesCodeForPost();
            if (this.cxy.getType() == 3) {
                this.ZD.o("newVcode", "1");
                this.ZD.o(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_CONTENT, String.valueOf(this.cxy.getContent()) + imagesCodeForPost);
                this.ZD.o("vcodeMd5", this.cxy.getVcodeMD5());
                if (editable.length() > 0) {
                    this.ZD.o("vcode", editable);
                }
                this.ZD.o("tag", "11");
                this.ZD.sp().tp().mIsNeedTbs = true;
                this.ZD.o(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_CONTENT, String.valueOf(this.cxy.getContent()) + imagesCodeForPost);
                this.ZD.setUrl(com.baidu.tieba.tbadkCore.d.a.coi);
                this.ZD.o(ImageViewerConfig.FORUM_NAME, this.cxy.getForumName());
                this.ZD.o("title", this.cxy.getTitle());
                this.ZD.o("apiKey", this.cxy.getShareApiKey());
                this.ZD.o("appName", this.cxy.getShareAppName());
                this.ZD.o("signKey", this.cxy.getShareSignKey());
                this.ZD.o("summary_title", this.cxy.getShareSummaryTitle());
                this.ZD.o("summary_content", this.cxy.getShareSummaryContent());
                this.ZD.o("summary_img", this.cxy.getShareSummaryImg());
                this.ZD.o(WriteShareActivityConfig.SHARE_SUMMARY_IMG_WIDTH, String.valueOf(this.cxy.getShareSummaryImgWidth()));
                this.ZD.o(WriteShareActivityConfig.SHARE_SUMMARY_IMG_HEIGHT, String.valueOf(this.cxy.getShareSummaryImgHeight()));
                this.ZD.o(WriteShareActivityConfig.SHARE_SUMMARY_IMG_TYPE, this.cxy.getShareSummaryImgType());
                this.ZD.o("referUrl", this.cxy.getShareReferUrl());
            } else {
                this.ZD.o("anonymous", GameInfoData.NOT_FROM_DETAIL);
                this.ZD.o(ImageViewerConfig.FORUM_ID, this.cxy.getForumId());
                this.ZD.o("kw", this.cxy.getForumName());
                this.ZD.o("new_vcode", "1");
                this.ZD.o(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_CONTENT, String.valueOf(this.cxy.getContent()) + imagesCodeForPost);
                if (this.cxy.getIsBaobaoImageUploaded()) {
                    this.ZD.o("tail_type", String.valueOf(com.baidu.tieba.tbadkCore.d.b.col));
                    this.ZD.o("tail_content", this.cxy.getBaobaoContent());
                    this.cxy.setBabaoPosted(true);
                } else {
                    this.cxy.setBabaoPosted(false);
                }
                com.baidu.tieba.tbadkCore.writeModel.h.a(this.ZD, this.cxy);
                this.ZD.o("vcode_md5", this.cxy.getVcodeMD5());
                if (editable.length() > 0) {
                    this.ZD.o("vcode", editable);
                }
                this.ZD.sp().tp().mIsNeedTbs = true;
                if (this.cxy.getVoice() != null) {
                    this.ZD.o("voice_md5", this.cxy.getVoice());
                    this.ZD.o("during_time", String.valueOf(this.cxy.getVoiceDuringTime()));
                }
                if (this.cxy.getType() == 0) {
                    this.ZD.setUrl(String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.POST_THREAD_ADDRESS);
                    this.ZD.o("title", this.cxy.getTitle());
                    this.ZD.o("is_ntitle", this.cxy.isNoTitle() ? "1" : GameInfoData.NOT_FROM_DETAIL);
                    if (this.cxy.getLiveCardData() != null) {
                        this.ZD.o("group_id", String.valueOf(this.cxy.getLiveCardData().getGroupId()));
                        this.ZD.o("start_time", String.valueOf(this.cxy.getLiveCardData().getStartTime()));
                    }
                    if (!TbConfig.getPositionPagerId().equals(this.cxw.getIntent().getStringExtra("forum_id")) && TbadkCoreApplication.m411getInst().getIsLocationOn() && (z = com.baidu.adp.lib.d.a.gZ().z(false)) != null) {
                        this.ZD.o("lbs", String.valueOf(String.valueOf(z.getLatitude())) + "," + String.valueOf(z.getLongitude()));
                    }
                } else {
                    this.ZD.setUrl(String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.REPLY_THREAD_ADDRESS);
                    this.ZD.o("tid", this.cxy.getThreadId());
                    this.ZD.o("is_ad", this.cxw.getIntent().getBooleanExtra("is_ad", false) ? "1" : GameInfoData.NOT_FROM_DETAIL);
                    if (this.cxy.getType() == 2) {
                        this.ZD.o("quote_id", String.valueOf(this.cxy.getFloor()));
                        this.ZD.o(WriteActivityConfig.FLOOR_NUM, String.valueOf(this.cxy.getFloorNum()));
                        this.ZD.o(WriteActivityConfig.IS_ADDITION, this.cxy.isAddition() ? "1" : GameInfoData.NOT_FROM_DETAIL);
                        if (this.cxy.getRepostId() != null) {
                            this.ZD.o("repostid", this.cxy.getRepostId());
                        }
                    }
                }
            }
            this.axc = this.ZD.rO();
        }
        return null;
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        this.cxw.cxu = null;
        this.cxw.closeLoadingDialog();
        if (this.ZD != null) {
            this.ZD.hh();
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
    public void onPostExecute(com.baidu.tbadk.coreExtra.data.k kVar) {
        EditText editText;
        WriteData writeData;
        WriteData writeData2;
        WriteData writeData3;
        String str;
        String str2;
        JSONException e;
        this.cxw.closeLoadingDialog();
        this.cxw.cxu = null;
        if (this.ZD != null) {
            if (this.ZD.sp().tq().pv()) {
                ErrorData errorData = new ErrorData();
                errorData.parserJson(this.axc);
                if (errorData.error_code == 0) {
                    try {
                        str = new JSONObject(this.axc).optString(AddFriendActivityConfig.MSG);
                    } catch (JSONException e2) {
                        e2.printStackTrace();
                        str = null;
                    }
                    if (StringUtils.isNull(str)) {
                        str = TbadkCoreApplication.m411getInst().getString(com.baidu.tieba.y.send_success);
                    }
                    if (this.cxy.getType() != 3) {
                        com.baidu.tieba.tbadkCore.writeModel.h.L(this.cxw.getPageContext().getPageActivity(), str);
                    }
                    this.cxy.deleteUploadedTempImages();
                    if (this.cxy != null && this.cxy.isBabaoPosted()) {
                        com.baidu.tieba.tbadkCore.PbEditor.a.akY();
                    }
                } else if ((this.cxy.isHasImages() || this.cxy.getIsBaobao()) && com.baidu.adp.lib.util.m.isEmpty(String.valueOf(this.cxy.getContent()) + this.cxy.getImagesCodeForPost())) {
                    this.cxw.showToast(TbadkCoreApplication.m411getInst().getString(com.baidu.tieba.y.img_upload_error));
                } else if (this.cxy.getType() != 3) {
                    this.cxw.showToast(errorData.getError_msg());
                }
                PostWriteCallBackData postWriteCallBackData = new PostWriteCallBackData(null, null, null);
                String str3 = "";
                try {
                    str2 = new JSONObject(this.axc).optString("tid");
                    try {
                        str3 = new JSONObject(this.axc).optString("pid");
                    } catch (JSONException e3) {
                        e = e3;
                        e.printStackTrace();
                        postWriteCallBackData.setThreadId(str2);
                        postWriteCallBackData.setPostId(str3);
                        Intent intent = new Intent();
                        Bundle bundle = new Bundle();
                        bundle.putSerializable("post_write_callback_data", postWriteCallBackData);
                        intent.putExtras(bundle);
                        this.cxw.setResult(-1, intent);
                        if (this.cxy.getLiveCardData() != null) {
                        }
                        this.cxw.finish();
                        super.onPostExecute(kVar);
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
                this.cxw.setResult(-1, intent2);
                if (this.cxy.getLiveCardData() != null) {
                    this.cxw.sendMessage(new CustomMessage(2003001, new FrsActivityConfig(this.cxw.getPageContext().getPageActivity()).createRefreshCfgShowContent(this.cxy.getForumName(), "post live's thread")));
                }
                this.cxw.finish();
            } else if (this.cxy.isHasImages() && com.baidu.adp.lib.util.m.isEmpty(String.valueOf(this.cxy.getContent()) + this.cxy.getImagesCodeForPost())) {
                this.cxw.showToast(TbadkCoreApplication.m411getInst().getString(com.baidu.tieba.y.img_upload_error));
            } else {
                if (this.ZD.st() == 5 || this.ZD.st() == 6) {
                    com.baidu.tbadk.coreExtra.data.k kVar2 = new com.baidu.tbadk.coreExtra.data.k();
                    kVar2.parserJson(this.axc);
                    if (kVar2.getVcode_pic_url() != null) {
                        writeData = this.cxw.cxg;
                        writeData.setVcodeMD5(kVar2.getVcode_md5());
                        writeData2 = this.cxw.cxg;
                        writeData2.setVcodeUrl(kVar2.getVcode_pic_url());
                        VcodeActivity vcodeActivity = this.cxw;
                        writeData3 = this.cxw.cxg;
                        vcodeActivity.eS(writeData3.getVcodeUrl());
                    }
                    editText = this.cxw.mEdit;
                    editText.setText((CharSequence) null);
                }
                this.cxw.showToast(this.ZD.getErrorString());
            }
        }
        super.onPostExecute(kVar);
    }
}
