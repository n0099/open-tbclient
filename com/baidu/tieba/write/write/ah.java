package com.baidu.tieba.write.write;

import android.content.Intent;
import android.location.Address;
import android.os.Bundle;
import android.widget.EditText;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.appsearchlib.Info;
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
public class ah extends BdAsyncTask<Integer, Integer, com.baidu.tbadk.coreExtra.data.l> {
    private com.baidu.tbadk.core.util.aa aaG = null;
    private String ayS = null;
    final /* synthetic */ VcodeActivity cCi;
    private WriteData cCk;

    public ah(VcodeActivity vcodeActivity, WriteData writeData) {
        this.cCi = vcodeActivity;
        this.cCk = null;
        this.cCk = writeData;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: g */
    public com.baidu.tbadk.coreExtra.data.l doInBackground(Integer... numArr) {
        EditText editText;
        Address z;
        if (this.cCk != null) {
            this.aaG = new com.baidu.tbadk.core.util.aa();
            editText = this.cCi.mEdit;
            String editable = editText.getText().toString();
            String imagesCodeForPost = this.cCk.getImagesCodeForPost();
            if (this.cCk.getType() == 3) {
                this.aaG.o("newVcode", "1");
                this.aaG.o(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_CONTENT, String.valueOf(this.cCk.getContent()) + imagesCodeForPost);
                this.aaG.o("vcodeMd5", this.cCk.getVcodeMD5());
                if (editable.length() > 0) {
                    this.aaG.o("vcode", editable);
                }
                this.aaG.o("tag", "11");
                this.aaG.sX().tS().mIsNeedTbs = true;
                this.aaG.o(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_CONTENT, String.valueOf(this.cCk.getContent()) + imagesCodeForPost);
                this.aaG.setUrl(com.baidu.tieba.tbadkCore.d.a.csA);
                this.aaG.o(ImageViewerConfig.FORUM_NAME, this.cCk.getForumName());
                this.aaG.o("title", this.cCk.getTitle());
                this.aaG.o("apiKey", this.cCk.getShareApiKey());
                this.aaG.o("appName", this.cCk.getShareAppName());
                this.aaG.o("signKey", this.cCk.getShareSignKey());
                this.aaG.o("summary_title", this.cCk.getShareSummaryTitle());
                this.aaG.o("summary_content", this.cCk.getShareSummaryContent());
                this.aaG.o("summary_img", this.cCk.getShareSummaryImg());
                this.aaG.o(WriteShareActivityConfig.SHARE_SUMMARY_IMG_WIDTH, String.valueOf(this.cCk.getShareSummaryImgWidth()));
                this.aaG.o(WriteShareActivityConfig.SHARE_SUMMARY_IMG_HEIGHT, String.valueOf(this.cCk.getShareSummaryImgHeight()));
                this.aaG.o(WriteShareActivityConfig.SHARE_SUMMARY_IMG_TYPE, this.cCk.getShareSummaryImgType());
                this.aaG.o("referUrl", this.cCk.getShareReferUrl());
            } else {
                this.aaG.o("anonymous", GameInfoData.NOT_FROM_DETAIL);
                this.aaG.o(ImageViewerConfig.FORUM_ID, this.cCk.getForumId());
                this.aaG.o("kw", this.cCk.getForumName());
                this.aaG.o("new_vcode", "1");
                this.aaG.o(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_CONTENT, String.valueOf(this.cCk.getContent()) + imagesCodeForPost);
                if (this.cCk.getIsBaobaoImageUploaded()) {
                    this.aaG.o("tail_type", String.valueOf(com.baidu.tieba.tbadkCore.d.b.csD));
                    this.aaG.o("tail_content", this.cCk.getBaobaoContent());
                    this.cCk.setBabaoPosted(true);
                } else {
                    this.cCk.setBabaoPosted(false);
                }
                com.baidu.tieba.tbadkCore.writeModel.h.a(this.aaG, this.cCk);
                this.aaG.o("vcode_md5", this.cCk.getVcodeMD5());
                if (editable.length() > 0) {
                    this.aaG.o("vcode", editable);
                }
                this.aaG.sX().tS().mIsNeedTbs = true;
                if (this.cCk.getVoice() != null) {
                    this.aaG.o("voice_md5", this.cCk.getVoice());
                    this.aaG.o("during_time", String.valueOf(this.cCk.getVoiceDuringTime()));
                }
                if (this.cCk.getType() == 0) {
                    this.aaG.setUrl(String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.POST_THREAD_ADDRESS);
                    this.aaG.o("title", this.cCk.getTitle());
                    this.aaG.o("is_ntitle", this.cCk.isNoTitle() ? "1" : GameInfoData.NOT_FROM_DETAIL);
                    if (this.cCk.getLiveCardData() != null) {
                        this.aaG.o("group_id", String.valueOf(this.cCk.getLiveCardData().getGroupId()));
                        this.aaG.o("start_time", String.valueOf(this.cCk.getLiveCardData().getStartTime()));
                    }
                    if (!TbConfig.getPositionPagerId().equals(this.cCi.getIntent().getStringExtra("forum_id")) && TbadkCoreApplication.m411getInst().getIsLocationOn() && (z = com.baidu.adp.lib.d.a.gK().z(false)) != null) {
                        this.aaG.o("lbs", String.valueOf(String.valueOf(z.getLatitude())) + "," + String.valueOf(z.getLongitude()));
                    }
                } else {
                    this.aaG.setUrl(String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.REPLY_THREAD_ADDRESS);
                    this.aaG.o("tid", this.cCk.getThreadId());
                    this.aaG.o("is_ad", this.cCi.getIntent().getBooleanExtra("is_ad", false) ? "1" : GameInfoData.NOT_FROM_DETAIL);
                    if (this.cCk.getType() == 2) {
                        this.aaG.o("quote_id", String.valueOf(this.cCk.getFloor()));
                        this.aaG.o(WriteActivityConfig.FLOOR_NUM, String.valueOf(this.cCk.getFloorNum()));
                        this.aaG.o(WriteActivityConfig.IS_ADDITION, this.cCk.isAddition() ? "1" : GameInfoData.NOT_FROM_DETAIL);
                        if (this.cCk.getRepostId() != null) {
                            this.aaG.o("repostid", this.cCk.getRepostId());
                        }
                    }
                }
            }
            this.ayS = this.aaG.sw();
        }
        return null;
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        this.cCi.cCg = null;
        this.cCi.closeLoadingDialog();
        if (this.aaG != null) {
            this.aaG.gS();
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
        this.cCi.closeLoadingDialog();
        this.cCi.cCg = null;
        if (this.aaG != null) {
            if (this.aaG.sX().tT().qa()) {
                ErrorData errorData = new ErrorData();
                errorData.parserJson(this.ayS);
                if (errorData.error_code == 0) {
                    try {
                        str = new JSONObject(this.ayS).optString(AddFriendActivityConfig.MSG);
                    } catch (JSONException e2) {
                        e2.printStackTrace();
                        str = null;
                    }
                    if (StringUtils.isNull(str)) {
                        str = TbadkCoreApplication.m411getInst().getString(com.baidu.tieba.t.send_success);
                    }
                    if (this.cCk.getType() != 3) {
                        com.baidu.tieba.tbadkCore.writeModel.h.O(this.cCi.getPageContext().getPageActivity(), str);
                    }
                    this.cCk.deleteUploadedTempImages();
                    if (this.cCk != null && this.cCk.isBabaoPosted()) {
                        com.baidu.tieba.tbadkCore.PbEditor.a.amZ();
                    }
                } else if ((this.cCk.isHasImages() || this.cCk.getIsBaobao()) && com.baidu.adp.lib.util.m.isEmpty(String.valueOf(this.cCk.getContent()) + this.cCk.getImagesCodeForPost())) {
                    this.cCi.showToast(TbadkCoreApplication.m411getInst().getString(com.baidu.tieba.t.img_upload_error));
                } else if (this.cCk.getType() != 3) {
                    this.cCi.showToast(errorData.getError_msg());
                }
                PostWriteCallBackData postWriteCallBackData = new PostWriteCallBackData(null, null, null);
                String str3 = "";
                try {
                    str2 = new JSONObject(this.ayS).optString("tid");
                    try {
                        str3 = new JSONObject(this.ayS).optString(Info.kBaiduPIDKey);
                    } catch (JSONException e3) {
                        e = e3;
                        e.printStackTrace();
                        postWriteCallBackData.setThreadId(str2);
                        postWriteCallBackData.setPostId(str3);
                        Intent intent = new Intent();
                        Bundle bundle = new Bundle();
                        bundle.putSerializable("post_write_callback_data", postWriteCallBackData);
                        intent.putExtras(bundle);
                        this.cCi.setResult(-1, intent);
                        if (this.cCk.getLiveCardData() != null) {
                        }
                        this.cCi.finish();
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
                this.cCi.setResult(-1, intent2);
                if (this.cCk.getLiveCardData() != null) {
                    this.cCi.sendMessage(new CustomMessage(2003001, new FrsActivityConfig(this.cCi.getPageContext().getPageActivity()).createRefreshCfgShowContent(this.cCk.getForumName(), "post live's thread")));
                }
                this.cCi.finish();
            } else if (this.cCk.isHasImages() && com.baidu.adp.lib.util.m.isEmpty(String.valueOf(this.cCk.getContent()) + this.cCk.getImagesCodeForPost())) {
                this.cCi.showToast(TbadkCoreApplication.m411getInst().getString(com.baidu.tieba.t.img_upload_error));
            } else {
                if (this.aaG.tb() == 5 || this.aaG.tb() == 6) {
                    com.baidu.tbadk.coreExtra.data.l lVar2 = new com.baidu.tbadk.coreExtra.data.l();
                    lVar2.parserJson(this.ayS);
                    if (lVar2.getVcode_pic_url() != null) {
                        writeData = this.cCi.cBS;
                        writeData.setVcodeMD5(lVar2.getVcode_md5());
                        writeData2 = this.cCi.cBS;
                        writeData2.setVcodeUrl(lVar2.getVcode_pic_url());
                        VcodeActivity vcodeActivity = this.cCi;
                        writeData3 = this.cCi.cBS;
                        vcodeActivity.fq(writeData3.getVcodeUrl());
                    }
                    editText = this.cCi.mEdit;
                    editText.setText((CharSequence) null);
                }
                this.cCi.showToast(this.aaG.getErrorString());
            }
        }
        super.onPostExecute(lVar);
    }
}
