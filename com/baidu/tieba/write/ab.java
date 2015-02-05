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
    private com.baidu.tbadk.core.util.ad CU = null;
    private String QH = null;
    final /* synthetic */ VcodeActivity cgl;
    private WriteData cgn;

    public ab(VcodeActivity vcodeActivity, WriteData writeData) {
        this.cgl = vcodeActivity;
        this.cgn = null;
        this.cgn = writeData;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: g */
    public com.baidu.tbadk.coreExtra.data.j doInBackground(Integer... numArr) {
        EditText editText;
        Address z;
        if (this.cgn != null) {
            this.CU = new com.baidu.tbadk.core.util.ad();
            editText = this.cgl.mEdit;
            String editable = editText.getText().toString();
            String imagesCodeForPost = this.cgn.getImagesCodeForPost();
            if (this.cgn.getType() == 3) {
                this.CU.o("newVcode", "1");
                this.CU.o(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_CONTENT, String.valueOf(this.cgn.getContent()) + imagesCodeForPost);
                this.CU.o("vcodeMd5", this.cgn.getVcodeMD5());
                if (editable.length() > 0) {
                    this.CU.o("vcode", editable);
                }
                this.CU.o("tag", "11");
                this.CU.oS().pZ().mIsNeedTbs = true;
                this.CU.o(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_CONTENT, String.valueOf(this.cgn.getContent()) + imagesCodeForPost);
                this.CU.setUrl(com.baidu.tieba.tbadkCore.c.a.bZe);
                this.CU.o(ImageViewerConfig.FORUM_NAME, this.cgn.getForumName());
                this.CU.o("title", this.cgn.getTitle());
                this.CU.o("apiKey", this.cgn.getShareApiKey());
                this.CU.o("appName", this.cgn.getShareAppName());
                this.CU.o("signKey", this.cgn.getShareSignKey());
                this.CU.o("summary_title", this.cgn.getShareSummaryTitle());
                this.CU.o("summary_content", this.cgn.getShareSummaryContent());
                this.CU.o("summary_img", this.cgn.getShareSummaryImg());
                this.CU.o(WriteShareActivityConfig.SHARE_SUMMARY_IMG_WIDTH, String.valueOf(this.cgn.getShareSummaryImgWidth()));
                this.CU.o(WriteShareActivityConfig.SHARE_SUMMARY_IMG_HEIGHT, String.valueOf(this.cgn.getShareSummaryImgHeight()));
                this.CU.o(WriteShareActivityConfig.SHARE_SUMMARY_IMG_TYPE, this.cgn.getShareSummaryImgType());
                this.CU.o("referUrl", this.cgn.getShareReferUrl());
            } else {
                this.CU.o("anonymous", "0");
                this.CU.o(ImageViewerConfig.FORUM_ID, this.cgn.getForumId());
                this.CU.o("kw", this.cgn.getForumName());
                this.CU.o("new_vcode", "1");
                this.CU.o(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_CONTENT, String.valueOf(this.cgn.getContent()) + imagesCodeForPost);
                if (this.cgn.getIsBaobaoImageUploaded()) {
                    this.CU.o("tail_type", String.valueOf(com.baidu.tieba.tbadkCore.c.b.bZh));
                    this.CU.o("tail_content", this.cgn.getBaobaoContent());
                    this.cgn.setBabaoPosted(true);
                } else {
                    this.cgn.setBabaoPosted(false);
                }
                com.baidu.tieba.tbadkCore.f.g.a(this.CU, this.cgn);
                this.CU.o("vcode_md5", this.cgn.getVcodeMD5());
                if (editable.length() > 0) {
                    this.CU.o("vcode", editable);
                }
                this.CU.oS().pZ().mIsNeedTbs = true;
                if (this.cgn.getVoice() != null) {
                    this.CU.o("voice_md5", this.cgn.getVoice());
                    this.CU.o("during_time", String.valueOf(this.cgn.getVoiceDuringTime()));
                }
                if (this.cgn.getType() == 0) {
                    this.CU.setUrl(String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.POST_THREAD_ADDRESS);
                    this.CU.o("title", this.cgn.getTitle());
                    this.CU.o("is_ntitle", this.cgn.isNoTitle() ? "1" : "0");
                    if (this.cgn.getLiveCardData() != null) {
                        this.CU.o("group_id", String.valueOf(this.cgn.getLiveCardData().getGroupId()));
                        this.CU.o("start_time", String.valueOf(this.cgn.getLiveCardData().getStartTime()));
                    }
                    if (!TbConfig.getPositionPagerId().equals(this.cgl.getIntent().getStringExtra("forum_id")) && TbadkCoreApplication.m255getInst().getIsLocationOn() && (z = com.baidu.adp.lib.d.a.dB().z(false)) != null) {
                        this.CU.o("lbs", String.valueOf(String.valueOf(z.getLatitude())) + "," + String.valueOf(z.getLongitude()));
                    }
                } else {
                    this.CU.setUrl(String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.REPLY_THREAD_ADDRESS);
                    this.CU.o("tid", this.cgn.getThreadId());
                    this.CU.o("is_ad", this.cgl.getIntent().getBooleanExtra("is_ad", false) ? "1" : "0");
                    if (this.cgn.getType() == 2) {
                        this.CU.o("quote_id", String.valueOf(this.cgn.getFloor()));
                        this.CU.o(WriteActivityConfig.FLOOR_NUM, String.valueOf(this.cgn.getFloorNum()));
                        this.CU.o(WriteActivityConfig.IS_ADDITION, this.cgn.isAddition() ? "1" : "0");
                        if (this.cgn.getRepostId() != null) {
                            this.CU.o("repostid", this.cgn.getRepostId());
                        }
                    }
                }
            }
            this.QH = this.CU.or();
        }
        return null;
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        this.cgl.cgj = null;
        this.cgl.closeLoadingDialog();
        if (this.CU != null) {
            this.CU.dJ();
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
        this.cgl.closeLoadingDialog();
        this.cgl.cgj = null;
        if (this.CU != null) {
            if (this.CU.oS().qa().lT()) {
                ErrorData errorData = new ErrorData();
                errorData.parserJson(this.QH);
                if (errorData.error_code == 0) {
                    try {
                        str = new JSONObject(this.QH).optString(AddFriendActivityConfig.MSG);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    if (StringUtils.isNull(str)) {
                        str = TbadkCoreApplication.m255getInst().getString(com.baidu.tieba.z.send_success);
                    }
                    if (this.cgn.getType() != 3) {
                        com.baidu.tieba.tbadkCore.f.g.M(this.cgl.getPageContext().getPageActivity(), str);
                    }
                    this.cgn.deleteUploadedTempImages();
                    if (this.cgn != null && this.cgn.isBabaoPosted()) {
                        com.baidu.tieba.tbadkCore.PbEditor.a.afj();
                    }
                } else if ((this.cgn.isHasImages() || this.cgn.getIsBaobao()) && com.baidu.adp.lib.util.k.isEmpty(String.valueOf(this.cgn.getContent()) + this.cgn.getImagesCodeForPost())) {
                    this.cgl.showToast(TbadkCoreApplication.m255getInst().getString(com.baidu.tieba.z.img_upload_error));
                } else if (this.cgn.getType() != 3) {
                    this.cgl.showToast(errorData.getError_msg());
                }
                this.cgl.setResult(-1, this.cgl.getIntent());
                if (this.cgn.getLiveCardData() != null) {
                    this.cgl.sendMessage(new CustomMessage(2003001, new FrsActivityConfig(this.cgl.getPageContext().getPageActivity()).createRefreshCfgShowContent(this.cgn.getForumName(), "post live's thread")));
                }
                this.cgl.finish();
            } else if (this.cgn.isHasImages() && com.baidu.adp.lib.util.k.isEmpty(String.valueOf(this.cgn.getContent()) + this.cgn.getImagesCodeForPost())) {
                this.cgl.showToast(TbadkCoreApplication.m255getInst().getString(com.baidu.tieba.z.img_upload_error));
            } else {
                if (this.CU.oW() == 5 || this.CU.oW() == 6) {
                    com.baidu.tbadk.coreExtra.data.j jVar2 = new com.baidu.tbadk.coreExtra.data.j();
                    jVar2.parserJson(this.QH);
                    if (jVar2.getVcode_pic_url() != null) {
                        writeData = this.cgl.cfV;
                        writeData.setVcodeMD5(jVar2.getVcode_md5());
                        writeData2 = this.cgl.cfV;
                        writeData2.setVcodeUrl(jVar2.getVcode_pic_url());
                        VcodeActivity vcodeActivity = this.cgl;
                        writeData3 = this.cgl.cfV;
                        vcodeActivity.db(writeData3.getVcodeUrl());
                    }
                    editText = this.cgl.mEdit;
                    editText.setText((CharSequence) null);
                }
                this.cgl.showToast(this.CU.getErrorString());
            }
        }
        super.onPostExecute(jVar);
    }
}
