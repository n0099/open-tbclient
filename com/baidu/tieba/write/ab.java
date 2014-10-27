package com.baidu.tieba.write;

import android.location.Address;
import android.widget.EditText;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.atomData.AddFriendActivityConfig;
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
public class ab extends BdAsyncTask<Integer, Integer, com.baidu.tbadk.coreExtra.data.f> {
    final /* synthetic */ VcodeActivity bTr;
    private WriteData bTt;
    private com.baidu.tbadk.core.util.ac yV = null;
    private String KX = null;

    public ab(VcodeActivity vcodeActivity, WriteData writeData) {
        this.bTr = vcodeActivity;
        this.bTt = null;
        this.bTt = writeData;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: f */
    public com.baidu.tbadk.coreExtra.data.f doInBackground(Integer... numArr) {
        EditText editText;
        Address address;
        if (this.bTt != null) {
            this.yV = new com.baidu.tbadk.core.util.ac();
            editText = this.bTr.bBX;
            String editable = editText.getText().toString();
            String imagesCodeForPost = this.bTt.getImagesCodeForPost();
            if (this.bTt.getType() == 3) {
                this.yV.k("newVcode", "1");
                this.yV.k("content", String.valueOf(this.bTt.getContent()) + imagesCodeForPost);
                this.yV.k("vcodeMd5", this.bTt.getVcodeMD5());
                if (editable.length() > 0) {
                    this.yV.k("vcode", editable);
                }
                this.yV.k("tag", "11");
                this.yV.mc().na().mIsNeedTbs = true;
                this.yV.k("content", String.valueOf(this.bTt.getContent()) + imagesCodeForPost);
                this.yV.setUrl(com.baidu.tieba.a.c.amJ);
                this.yV.k(ImageViewerConfig.FORUM_NAME, this.bTt.getForumName());
                this.yV.k("title", this.bTt.getTitle());
                this.yV.k("apiKey", this.bTt.getShareApiKey());
                this.yV.k("appName", this.bTt.getShareAppName());
                this.yV.k("signKey", this.bTt.getShareSignKey());
                this.yV.k("summary_title", this.bTt.getShareSummaryTitle());
                this.yV.k("summary_content", this.bTt.getShareSummaryContent());
                this.yV.k("summary_img", this.bTt.getShareSummaryImg());
                this.yV.k(WriteShareActivityConfig.SHARE_SUMMARY_IMG_WIDTH, String.valueOf(this.bTt.getShareSummaryImgWidth()));
                this.yV.k(WriteShareActivityConfig.SHARE_SUMMARY_IMG_HEIGHT, String.valueOf(this.bTt.getShareSummaryImgHeight()));
                this.yV.k(WriteShareActivityConfig.SHARE_SUMMARY_IMG_TYPE, this.bTt.getShareSummaryImgType());
                this.yV.k("referUrl", this.bTt.getShareReferUrl());
            } else {
                this.yV.k("anonymous", "0");
                this.yV.k(ImageViewerConfig.FORUM_ID, this.bTt.getForumId());
                this.yV.k("kw", this.bTt.getForumName());
                this.yV.k("new_vcode", "1");
                this.yV.k("content", String.valueOf(this.bTt.getContent()) + imagesCodeForPost);
                if (this.bTt.getIsBaobaoImageUploaded()) {
                    this.yV.k("tail_type", String.valueOf(com.baidu.tieba.a.d.amM));
                    this.yV.k("tail_content", this.bTt.getBaobaoContent());
                    this.bTt.setBabaoPosted(true);
                } else {
                    this.bTt.setBabaoPosted(false);
                }
                ck.a(this.yV, this.bTt);
                this.yV.k("vcode_md5", this.bTt.getVcodeMD5());
                if (editable.length() > 0) {
                    this.yV.k("vcode", editable);
                }
                this.yV.mc().na().mIsNeedTbs = true;
                if (this.bTt.getVoice() != null) {
                    this.yV.k("voice_md5", this.bTt.getVoice());
                    this.yV.k("during_time", String.valueOf(this.bTt.getVoiceDuringTime()));
                }
                if (this.bTt.getType() == 0) {
                    this.yV.setUrl(String.valueOf(TbConfig.SERVER_ADDRESS) + "c/c/thread/add");
                    this.yV.k("title", this.bTt.getTitle());
                    this.yV.k("is_ntitle", this.bTt.isNoTitle() ? "1" : "0");
                    if (this.bTt.getLiveCardData() != null) {
                        this.yV.k("group_id", String.valueOf(this.bTt.getLiveCardData().getGroupId()));
                        this.yV.k("start_time", String.valueOf(this.bTt.getLiveCardData().getStartTime()));
                    }
                    if (!TbConfig.getPositionPagerId().equals(this.bTr.getIntent().getStringExtra("forum_id")) && com.baidu.tieba.aj.wk().wu() && (address = com.baidu.adp.lib.d.a.dE().getAddress(false)) != null) {
                        this.yV.k("lbs", String.valueOf(String.valueOf(address.getLatitude())) + "," + String.valueOf(address.getLongitude()));
                    }
                } else {
                    this.yV.setUrl(String.valueOf(TbConfig.SERVER_ADDRESS) + "c/c/post/add");
                    this.yV.k("tid", this.bTt.getThreadId());
                    this.yV.k("is_ad", this.bTr.getIntent().getBooleanExtra("is_ad", false) ? "1" : "0");
                    if (this.bTt.getType() == 2) {
                        this.yV.k("quote_id", String.valueOf(this.bTt.getFloor()));
                        this.yV.k(WriteActivityConfig.FLOOR_NUM, String.valueOf(this.bTt.getFloorNum()));
                        this.yV.k(WriteActivityConfig.IS_ADDITION, this.bTt.isAddition() ? "1" : "0");
                        if (this.bTt.getRepostId() != null) {
                            this.yV.k("repostid", this.bTt.getRepostId());
                        }
                    }
                }
            }
            this.KX = this.yV.lA();
        }
        return null;
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        this.bTr.bTp = null;
        this.bTr.closeLoadingDialog();
        if (this.yV != null) {
            this.yV.dM();
        }
        super.cancel(true);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: a */
    public void onPostExecute(com.baidu.tbadk.coreExtra.data.f fVar) {
        EditText editText;
        WriteData writeData;
        WriteData writeData2;
        WriteData writeData3;
        String str = null;
        this.bTr.closeLoadingDialog();
        this.bTr.bTp = null;
        if (this.yV != null) {
            if (this.yV.mc().nb().jq()) {
                ErrorData errorData = new ErrorData();
                errorData.parserJson(this.KX);
                if (errorData.error_code == 0) {
                    try {
                        str = new JSONObject(this.KX).optString(AddFriendActivityConfig.MSG);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    if (StringUtils.isNull(str)) {
                        str = TbadkApplication.m251getInst().getString(com.baidu.tieba.y.send_success);
                    }
                    ck.J(this.bTr, str);
                    this.bTt.deleteUploadedTempImages();
                    if (this.bTt != null && this.bTt.isBabaoPosted()) {
                        com.baidu.tieba.e.a.adI();
                    }
                } else if ((this.bTt.isHasImages() || this.bTt.getIsBaobao()) && com.baidu.adp.lib.util.l.aA(String.valueOf(this.bTt.getContent()) + this.bTt.getImagesCodeForPost())) {
                    this.bTr.showToast(com.baidu.tieba.aj.wk().getApp().getString(com.baidu.tieba.y.img_upload_error));
                } else {
                    this.bTr.showToast(errorData.getError_msg());
                }
                this.bTr.setResult(-1, this.bTr.getIntent());
                if (this.bTt.getLiveCardData() != null) {
                    this.bTr.sendMessage(new CustomMessage(2003001, new FrsActivityConfig(this.bTr).createRefreshCfgShowContent(this.bTt.getForumName(), "post live's thread")));
                }
                this.bTr.finish();
            } else if (this.bTt.isHasImages() && com.baidu.adp.lib.util.l.aA(String.valueOf(this.bTt.getContent()) + this.bTt.getImagesCodeForPost())) {
                this.bTr.showToast(com.baidu.tieba.aj.wk().getApp().getString(com.baidu.tieba.y.img_upload_error));
            } else {
                if (this.yV.mg() == 5 || this.yV.mg() == 6) {
                    com.baidu.tbadk.coreExtra.data.f fVar2 = new com.baidu.tbadk.coreExtra.data.f();
                    fVar2.parserJson(this.KX);
                    if (fVar2.getVcode_pic_url() != null) {
                        writeData = this.bTr.bTb;
                        writeData.setVcodeMD5(fVar2.getVcode_md5());
                        writeData2 = this.bTr.bTb;
                        writeData2.setVcodeUrl(fVar2.getVcode_pic_url());
                        VcodeActivity vcodeActivity = this.bTr;
                        writeData3 = this.bTr.bTb;
                        vcodeActivity.cm(writeData3.getVcodeUrl());
                    }
                    editText = this.bTr.bBX;
                    editText.setText((CharSequence) null);
                }
                this.bTr.showToast(this.yV.getErrorString());
            }
        }
        super.onPostExecute(fVar);
    }
}
