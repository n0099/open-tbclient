package com.baidu.tieba.write;

import android.location.Address;
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
import org.json.JSONException;
import org.json.JSONObject;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ab extends BdAsyncTask<Integer, Integer, com.baidu.tbadk.coreExtra.data.j> {
    private com.baidu.tbadk.core.util.ad CV = null;
    private String Qj = null;
    final /* synthetic */ VcodeActivity ceN;
    private WriteData ceP;

    public ab(VcodeActivity vcodeActivity, WriteData writeData) {
        this.ceN = vcodeActivity;
        this.ceP = null;
        this.ceP = writeData;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: g */
    public com.baidu.tbadk.coreExtra.data.j doInBackground(Integer... numArr) {
        EditText editText;
        Address z;
        if (this.ceP != null) {
            this.CV = new com.baidu.tbadk.core.util.ad();
            editText = this.ceN.mEdit;
            String editable = editText.getText().toString();
            String imagesCodeForPost = this.ceP.getImagesCodeForPost();
            if (this.ceP.getType() == 3) {
                this.CV.o("newVcode", "1");
                this.CV.o(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_CONTENT, String.valueOf(this.ceP.getContent()) + imagesCodeForPost);
                this.CV.o("vcodeMd5", this.ceP.getVcodeMD5());
                if (editable.length() > 0) {
                    this.CV.o("vcode", editable);
                }
                this.CV.o("tag", "11");
                this.CV.oW().pV().mIsNeedTbs = true;
                this.CV.o(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_CONTENT, String.valueOf(this.ceP.getContent()) + imagesCodeForPost);
                this.CV.setUrl(com.baidu.tieba.tbadkCore.c.a.bXm);
                this.CV.o(ImageViewerConfig.FORUM_NAME, this.ceP.getForumName());
                this.CV.o("title", this.ceP.getTitle());
                this.CV.o("apiKey", this.ceP.getShareApiKey());
                this.CV.o("appName", this.ceP.getShareAppName());
                this.CV.o("signKey", this.ceP.getShareSignKey());
                this.CV.o("summary_title", this.ceP.getShareSummaryTitle());
                this.CV.o("summary_content", this.ceP.getShareSummaryContent());
                this.CV.o("summary_img", this.ceP.getShareSummaryImg());
                this.CV.o(WriteShareActivityConfig.SHARE_SUMMARY_IMG_WIDTH, String.valueOf(this.ceP.getShareSummaryImgWidth()));
                this.CV.o(WriteShareActivityConfig.SHARE_SUMMARY_IMG_HEIGHT, String.valueOf(this.ceP.getShareSummaryImgHeight()));
                this.CV.o(WriteShareActivityConfig.SHARE_SUMMARY_IMG_TYPE, this.ceP.getShareSummaryImgType());
                this.CV.o("referUrl", this.ceP.getShareReferUrl());
            } else {
                this.CV.o("anonymous", "0");
                this.CV.o(ImageViewerConfig.FORUM_ID, this.ceP.getForumId());
                this.CV.o("kw", this.ceP.getForumName());
                this.CV.o("new_vcode", "1");
                this.CV.o(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_CONTENT, String.valueOf(this.ceP.getContent()) + imagesCodeForPost);
                if (this.ceP.getIsBaobaoImageUploaded()) {
                    this.CV.o("tail_type", String.valueOf(com.baidu.tieba.tbadkCore.c.b.bXp));
                    this.CV.o("tail_content", this.ceP.getBaobaoContent());
                    this.ceP.setBabaoPosted(true);
                } else {
                    this.ceP.setBabaoPosted(false);
                }
                com.baidu.tieba.tbadkCore.f.g.a(this.CV, this.ceP);
                this.CV.o("vcode_md5", this.ceP.getVcodeMD5());
                if (editable.length() > 0) {
                    this.CV.o("vcode", editable);
                }
                this.CV.oW().pV().mIsNeedTbs = true;
                if (this.ceP.getVoice() != null) {
                    this.CV.o("voice_md5", this.ceP.getVoice());
                    this.CV.o("during_time", String.valueOf(this.ceP.getVoiceDuringTime()));
                }
                if (this.ceP.getType() == 0) {
                    this.CV.setUrl(String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.POST_THREAD_ADDRESS);
                    this.CV.o("title", this.ceP.getTitle());
                    this.CV.o("is_ntitle", this.ceP.isNoTitle() ? "1" : "0");
                    if (this.ceP.getLiveCardData() != null) {
                        this.CV.o("group_id", String.valueOf(this.ceP.getLiveCardData().getGroupId()));
                        this.CV.o("start_time", String.valueOf(this.ceP.getLiveCardData().getStartTime()));
                    }
                    if (!TbConfig.getPositionPagerId().equals(this.ceN.getIntent().getStringExtra("forum_id")) && TbadkCoreApplication.m255getInst().getIsLocationOn() && (z = com.baidu.adp.lib.d.a.dD().z(false)) != null) {
                        this.CV.o("lbs", String.valueOf(String.valueOf(z.getLatitude())) + "," + String.valueOf(z.getLongitude()));
                    }
                } else {
                    this.CV.setUrl(String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.REPLY_THREAD_ADDRESS);
                    this.CV.o("tid", this.ceP.getThreadId());
                    this.CV.o("is_ad", this.ceN.getIntent().getBooleanExtra("is_ad", false) ? "1" : "0");
                    if (this.ceP.getType() == 2) {
                        this.CV.o("quote_id", String.valueOf(this.ceP.getFloor()));
                        this.CV.o(WriteActivityConfig.FLOOR_NUM, String.valueOf(this.ceP.getFloorNum()));
                        this.CV.o(WriteActivityConfig.IS_ADDITION, this.ceP.isAddition() ? "1" : "0");
                        if (this.ceP.getRepostId() != null) {
                            this.CV.o("repostid", this.ceP.getRepostId());
                        }
                    }
                }
            }
            this.Qj = this.CV.ov();
        }
        return null;
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        this.ceN.ceL = null;
        this.ceN.closeLoadingDialog();
        if (this.CV != null) {
            this.CV.dL();
        }
        super.cancel(true);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: a */
    public void onPostExecute(com.baidu.tbadk.coreExtra.data.j jVar) {
        EditText editText;
        WriteData writeData;
        WriteData writeData2;
        WriteData writeData3;
        String str = null;
        this.ceN.closeLoadingDialog();
        this.ceN.ceL = null;
        if (this.CV != null) {
            if (this.CV.oW().pW().ma()) {
                ErrorData errorData = new ErrorData();
                errorData.parserJson(this.Qj);
                if (errorData.error_code == 0) {
                    try {
                        str = new JSONObject(this.Qj).optString(AddFriendActivityConfig.MSG);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    if (StringUtils.isNull(str)) {
                        str = TbadkCoreApplication.m255getInst().getString(com.baidu.tieba.z.send_success);
                    }
                    if (this.ceP.getType() != 3) {
                        com.baidu.tieba.tbadkCore.f.g.N(this.ceN.getPageContext().getPageActivity(), str);
                    }
                    this.ceP.deleteUploadedTempImages();
                    if (this.ceP != null && this.ceP.isBabaoPosted()) {
                        com.baidu.tieba.tbadkCore.PbEditor.a.aeK();
                    }
                } else if ((this.ceP.isHasImages() || this.ceP.getIsBaobao()) && com.baidu.adp.lib.util.k.isEmpty(String.valueOf(this.ceP.getContent()) + this.ceP.getImagesCodeForPost())) {
                    this.ceN.showToast(TbadkCoreApplication.m255getInst().getString(com.baidu.tieba.z.img_upload_error));
                } else if (this.ceP.getType() != 3) {
                    this.ceN.showToast(errorData.getError_msg());
                }
                this.ceN.setResult(-1, this.ceN.getIntent());
                if (this.ceP.getLiveCardData() != null) {
                    this.ceN.sendMessage(new CustomMessage(2003001, new FrsActivityConfig(this.ceN.getPageContext().getPageActivity()).createRefreshCfgShowContent(this.ceP.getForumName(), "post live's thread")));
                }
                this.ceN.finish();
            } else if (this.ceP.isHasImages() && com.baidu.adp.lib.util.k.isEmpty(String.valueOf(this.ceP.getContent()) + this.ceP.getImagesCodeForPost())) {
                this.ceN.showToast(TbadkCoreApplication.m255getInst().getString(com.baidu.tieba.z.img_upload_error));
            } else {
                if (this.CV.pa() == 5 || this.CV.pa() == 6) {
                    com.baidu.tbadk.coreExtra.data.j jVar2 = new com.baidu.tbadk.coreExtra.data.j();
                    jVar2.parserJson(this.Qj);
                    if (jVar2.getVcode_pic_url() != null) {
                        writeData = this.ceN.cex;
                        writeData.setVcodeMD5(jVar2.getVcode_md5());
                        writeData2 = this.ceN.cex;
                        writeData2.setVcodeUrl(jVar2.getVcode_pic_url());
                        VcodeActivity vcodeActivity = this.ceN;
                        writeData3 = this.ceN.cex;
                        vcodeActivity.df(writeData3.getVcodeUrl());
                    }
                    editText = this.ceN.mEdit;
                    editText.setText((CharSequence) null);
                }
                this.ceN.showToast(this.CV.getErrorString());
            }
        }
        super.onPostExecute(jVar);
    }
}
