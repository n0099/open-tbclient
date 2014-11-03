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
public class ab extends BdAsyncTask<Integer, Integer, com.baidu.tbadk.coreExtra.data.g> {
    final /* synthetic */ VcodeActivity bTG;
    private WriteData bTI;
    private com.baidu.tbadk.core.util.ac yV = null;
    private String KY = null;

    public ab(VcodeActivity vcodeActivity, WriteData writeData) {
        this.bTG = vcodeActivity;
        this.bTI = null;
        this.bTI = writeData;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: f */
    public com.baidu.tbadk.coreExtra.data.g doInBackground(Integer... numArr) {
        EditText editText;
        Address address;
        if (this.bTI != null) {
            this.yV = new com.baidu.tbadk.core.util.ac();
            editText = this.bTG.bCl;
            String editable = editText.getText().toString();
            String imagesCodeForPost = this.bTI.getImagesCodeForPost();
            if (this.bTI.getType() == 3) {
                this.yV.k("newVcode", "1");
                this.yV.k("content", String.valueOf(this.bTI.getContent()) + imagesCodeForPost);
                this.yV.k("vcodeMd5", this.bTI.getVcodeMD5());
                if (editable.length() > 0) {
                    this.yV.k("vcode", editable);
                }
                this.yV.k("tag", "11");
                this.yV.mc().na().mIsNeedTbs = true;
                this.yV.k("content", String.valueOf(this.bTI.getContent()) + imagesCodeForPost);
                this.yV.setUrl(com.baidu.tieba.a.c.amS);
                this.yV.k(ImageViewerConfig.FORUM_NAME, this.bTI.getForumName());
                this.yV.k("title", this.bTI.getTitle());
                this.yV.k("apiKey", this.bTI.getShareApiKey());
                this.yV.k("appName", this.bTI.getShareAppName());
                this.yV.k("signKey", this.bTI.getShareSignKey());
                this.yV.k("summary_title", this.bTI.getShareSummaryTitle());
                this.yV.k("summary_content", this.bTI.getShareSummaryContent());
                this.yV.k("summary_img", this.bTI.getShareSummaryImg());
                this.yV.k(WriteShareActivityConfig.SHARE_SUMMARY_IMG_WIDTH, String.valueOf(this.bTI.getShareSummaryImgWidth()));
                this.yV.k(WriteShareActivityConfig.SHARE_SUMMARY_IMG_HEIGHT, String.valueOf(this.bTI.getShareSummaryImgHeight()));
                this.yV.k(WriteShareActivityConfig.SHARE_SUMMARY_IMG_TYPE, this.bTI.getShareSummaryImgType());
                this.yV.k("referUrl", this.bTI.getShareReferUrl());
            } else {
                this.yV.k("anonymous", "0");
                this.yV.k(ImageViewerConfig.FORUM_ID, this.bTI.getForumId());
                this.yV.k("kw", this.bTI.getForumName());
                this.yV.k("new_vcode", "1");
                this.yV.k("content", String.valueOf(this.bTI.getContent()) + imagesCodeForPost);
                if (this.bTI.getIsBaobaoImageUploaded()) {
                    this.yV.k("tail_type", String.valueOf(com.baidu.tieba.a.d.amV));
                    this.yV.k("tail_content", this.bTI.getBaobaoContent());
                    this.bTI.setBabaoPosted(true);
                } else {
                    this.bTI.setBabaoPosted(false);
                }
                ck.a(this.yV, this.bTI);
                this.yV.k("vcode_md5", this.bTI.getVcodeMD5());
                if (editable.length() > 0) {
                    this.yV.k("vcode", editable);
                }
                this.yV.mc().na().mIsNeedTbs = true;
                if (this.bTI.getVoice() != null) {
                    this.yV.k("voice_md5", this.bTI.getVoice());
                    this.yV.k("during_time", String.valueOf(this.bTI.getVoiceDuringTime()));
                }
                if (this.bTI.getType() == 0) {
                    this.yV.setUrl(String.valueOf(TbConfig.SERVER_ADDRESS) + "c/c/thread/add");
                    this.yV.k("title", this.bTI.getTitle());
                    this.yV.k("is_ntitle", this.bTI.isNoTitle() ? "1" : "0");
                    if (this.bTI.getLiveCardData() != null) {
                        this.yV.k("group_id", String.valueOf(this.bTI.getLiveCardData().getGroupId()));
                        this.yV.k("start_time", String.valueOf(this.bTI.getLiveCardData().getStartTime()));
                    }
                    if (!TbConfig.getPositionPagerId().equals(this.bTG.getIntent().getStringExtra("forum_id")) && com.baidu.tieba.aj.wm().ww() && (address = com.baidu.adp.lib.d.a.dE().getAddress(false)) != null) {
                        this.yV.k("lbs", String.valueOf(String.valueOf(address.getLatitude())) + "," + String.valueOf(address.getLongitude()));
                    }
                } else {
                    this.yV.setUrl(String.valueOf(TbConfig.SERVER_ADDRESS) + "c/c/post/add");
                    this.yV.k("tid", this.bTI.getThreadId());
                    this.yV.k("is_ad", this.bTG.getIntent().getBooleanExtra("is_ad", false) ? "1" : "0");
                    if (this.bTI.getType() == 2) {
                        this.yV.k("quote_id", String.valueOf(this.bTI.getFloor()));
                        this.yV.k(WriteActivityConfig.FLOOR_NUM, String.valueOf(this.bTI.getFloorNum()));
                        this.yV.k(WriteActivityConfig.IS_ADDITION, this.bTI.isAddition() ? "1" : "0");
                        if (this.bTI.getRepostId() != null) {
                            this.yV.k("repostid", this.bTI.getRepostId());
                        }
                    }
                }
            }
            this.KY = this.yV.lA();
        }
        return null;
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        this.bTG.bTE = null;
        this.bTG.closeLoadingDialog();
        if (this.yV != null) {
            this.yV.dM();
        }
        super.cancel(true);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: a */
    public void onPostExecute(com.baidu.tbadk.coreExtra.data.g gVar) {
        EditText editText;
        WriteData writeData;
        WriteData writeData2;
        WriteData writeData3;
        String str = null;
        this.bTG.closeLoadingDialog();
        this.bTG.bTE = null;
        if (this.yV != null) {
            if (this.yV.mc().nb().jq()) {
                ErrorData errorData = new ErrorData();
                errorData.parserJson(this.KY);
                if (errorData.error_code == 0) {
                    try {
                        str = new JSONObject(this.KY).optString(AddFriendActivityConfig.MSG);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    if (StringUtils.isNull(str)) {
                        str = TbadkApplication.m251getInst().getString(com.baidu.tieba.y.send_success);
                    }
                    if (this.bTI.getType() != 3) {
                        ck.J(this.bTG, str);
                    }
                    this.bTI.deleteUploadedTempImages();
                    if (this.bTI != null && this.bTI.isBabaoPosted()) {
                        com.baidu.tieba.e.a.adL();
                    }
                } else if ((this.bTI.isHasImages() || this.bTI.getIsBaobao()) && com.baidu.adp.lib.util.l.aA(String.valueOf(this.bTI.getContent()) + this.bTI.getImagesCodeForPost())) {
                    this.bTG.showToast(com.baidu.tieba.aj.wm().getApp().getString(com.baidu.tieba.y.img_upload_error));
                } else if (this.bTI.getType() != 3) {
                    this.bTG.showToast(errorData.getError_msg());
                }
                this.bTG.setResult(-1, this.bTG.getIntent());
                if (this.bTI.getLiveCardData() != null) {
                    this.bTG.sendMessage(new CustomMessage(2003001, new FrsActivityConfig(this.bTG).createRefreshCfgShowContent(this.bTI.getForumName(), "post live's thread")));
                }
                this.bTG.finish();
            } else if (this.bTI.isHasImages() && com.baidu.adp.lib.util.l.aA(String.valueOf(this.bTI.getContent()) + this.bTI.getImagesCodeForPost())) {
                this.bTG.showToast(com.baidu.tieba.aj.wm().getApp().getString(com.baidu.tieba.y.img_upload_error));
            } else {
                if (this.yV.mg() == 5 || this.yV.mg() == 6) {
                    com.baidu.tbadk.coreExtra.data.g gVar2 = new com.baidu.tbadk.coreExtra.data.g();
                    gVar2.parserJson(this.KY);
                    if (gVar2.getVcode_pic_url() != null) {
                        writeData = this.bTG.bTq;
                        writeData.setVcodeMD5(gVar2.getVcode_md5());
                        writeData2 = this.bTG.bTq;
                        writeData2.setVcodeUrl(gVar2.getVcode_pic_url());
                        VcodeActivity vcodeActivity = this.bTG;
                        writeData3 = this.bTG.bTq;
                        vcodeActivity.cm(writeData3.getVcodeUrl());
                    }
                    editText = this.bTG.bCl;
                    editText.setText((CharSequence) null);
                }
                this.bTG.showToast(this.yV.getErrorString());
            }
        }
        super.onPostExecute(gVar);
    }
}
