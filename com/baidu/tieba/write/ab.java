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
    private com.baidu.tbadk.core.util.ad CX = null;
    private String QK = null;
    final /* synthetic */ VcodeActivity cgm;
    private WriteData cgo;

    public ab(VcodeActivity vcodeActivity, WriteData writeData) {
        this.cgm = vcodeActivity;
        this.cgo = null;
        this.cgo = writeData;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: g */
    public com.baidu.tbadk.coreExtra.data.j doInBackground(Integer... numArr) {
        EditText editText;
        Address z;
        if (this.cgo != null) {
            this.CX = new com.baidu.tbadk.core.util.ad();
            editText = this.cgm.mEdit;
            String editable = editText.getText().toString();
            String imagesCodeForPost = this.cgo.getImagesCodeForPost();
            if (this.cgo.getType() == 3) {
                this.CX.o("newVcode", "1");
                this.CX.o(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_CONTENT, String.valueOf(this.cgo.getContent()) + imagesCodeForPost);
                this.CX.o("vcodeMd5", this.cgo.getVcodeMD5());
                if (editable.length() > 0) {
                    this.CX.o("vcode", editable);
                }
                this.CX.o("tag", "11");
                this.CX.oZ().qg().mIsNeedTbs = true;
                this.CX.o(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_CONTENT, String.valueOf(this.cgo.getContent()) + imagesCodeForPost);
                this.CX.setUrl(com.baidu.tieba.tbadkCore.c.a.bZf);
                this.CX.o(ImageViewerConfig.FORUM_NAME, this.cgo.getForumName());
                this.CX.o("title", this.cgo.getTitle());
                this.CX.o("apiKey", this.cgo.getShareApiKey());
                this.CX.o("appName", this.cgo.getShareAppName());
                this.CX.o("signKey", this.cgo.getShareSignKey());
                this.CX.o("summary_title", this.cgo.getShareSummaryTitle());
                this.CX.o("summary_content", this.cgo.getShareSummaryContent());
                this.CX.o("summary_img", this.cgo.getShareSummaryImg());
                this.CX.o(WriteShareActivityConfig.SHARE_SUMMARY_IMG_WIDTH, String.valueOf(this.cgo.getShareSummaryImgWidth()));
                this.CX.o(WriteShareActivityConfig.SHARE_SUMMARY_IMG_HEIGHT, String.valueOf(this.cgo.getShareSummaryImgHeight()));
                this.CX.o(WriteShareActivityConfig.SHARE_SUMMARY_IMG_TYPE, this.cgo.getShareSummaryImgType());
                this.CX.o("referUrl", this.cgo.getShareReferUrl());
            } else {
                this.CX.o("anonymous", "0");
                this.CX.o(ImageViewerConfig.FORUM_ID, this.cgo.getForumId());
                this.CX.o("kw", this.cgo.getForumName());
                this.CX.o("new_vcode", "1");
                this.CX.o(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_CONTENT, String.valueOf(this.cgo.getContent()) + imagesCodeForPost);
                if (this.cgo.getIsBaobaoImageUploaded()) {
                    this.CX.o("tail_type", String.valueOf(com.baidu.tieba.tbadkCore.c.b.bZi));
                    this.CX.o("tail_content", this.cgo.getBaobaoContent());
                    this.cgo.setBabaoPosted(true);
                } else {
                    this.cgo.setBabaoPosted(false);
                }
                com.baidu.tieba.tbadkCore.f.g.a(this.CX, this.cgo);
                this.CX.o("vcode_md5", this.cgo.getVcodeMD5());
                if (editable.length() > 0) {
                    this.CX.o("vcode", editable);
                }
                this.CX.oZ().qg().mIsNeedTbs = true;
                if (this.cgo.getVoice() != null) {
                    this.CX.o("voice_md5", this.cgo.getVoice());
                    this.CX.o("during_time", String.valueOf(this.cgo.getVoiceDuringTime()));
                }
                if (this.cgo.getType() == 0) {
                    this.CX.setUrl(String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.POST_THREAD_ADDRESS);
                    this.CX.o("title", this.cgo.getTitle());
                    this.CX.o("is_ntitle", this.cgo.isNoTitle() ? "1" : "0");
                    if (this.cgo.getLiveCardData() != null) {
                        this.CX.o("group_id", String.valueOf(this.cgo.getLiveCardData().getGroupId()));
                        this.CX.o("start_time", String.valueOf(this.cgo.getLiveCardData().getStartTime()));
                    }
                    if (!TbConfig.getPositionPagerId().equals(this.cgm.getIntent().getStringExtra("forum_id")) && TbadkCoreApplication.m255getInst().getIsLocationOn() && (z = com.baidu.adp.lib.d.a.dB().z(false)) != null) {
                        this.CX.o("lbs", String.valueOf(String.valueOf(z.getLatitude())) + "," + String.valueOf(z.getLongitude()));
                    }
                } else {
                    this.CX.setUrl(String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.REPLY_THREAD_ADDRESS);
                    this.CX.o("tid", this.cgo.getThreadId());
                    this.CX.o("is_ad", this.cgm.getIntent().getBooleanExtra("is_ad", false) ? "1" : "0");
                    if (this.cgo.getType() == 2) {
                        this.CX.o("quote_id", String.valueOf(this.cgo.getFloor()));
                        this.CX.o(WriteActivityConfig.FLOOR_NUM, String.valueOf(this.cgo.getFloorNum()));
                        this.CX.o(WriteActivityConfig.IS_ADDITION, this.cgo.isAddition() ? "1" : "0");
                        if (this.cgo.getRepostId() != null) {
                            this.CX.o("repostid", this.cgo.getRepostId());
                        }
                    }
                }
            }
            this.QK = this.CX.oy();
        }
        return null;
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        this.cgm.cgk = null;
        this.cgm.closeLoadingDialog();
        if (this.CX != null) {
            this.CX.dJ();
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
        this.cgm.closeLoadingDialog();
        this.cgm.cgk = null;
        if (this.CX != null) {
            if (this.CX.oZ().qh().ma()) {
                ErrorData errorData = new ErrorData();
                errorData.parserJson(this.QK);
                if (errorData.error_code == 0) {
                    try {
                        str = new JSONObject(this.QK).optString(AddFriendActivityConfig.MSG);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    if (StringUtils.isNull(str)) {
                        str = TbadkCoreApplication.m255getInst().getString(com.baidu.tieba.z.send_success);
                    }
                    if (this.cgo.getType() != 3) {
                        com.baidu.tieba.tbadkCore.f.g.M(this.cgm.getPageContext().getPageActivity(), str);
                    }
                    this.cgo.deleteUploadedTempImages();
                    if (this.cgo != null && this.cgo.isBabaoPosted()) {
                        com.baidu.tieba.tbadkCore.PbEditor.a.afo();
                    }
                } else if ((this.cgo.isHasImages() || this.cgo.getIsBaobao()) && com.baidu.adp.lib.util.k.isEmpty(String.valueOf(this.cgo.getContent()) + this.cgo.getImagesCodeForPost())) {
                    this.cgm.showToast(TbadkCoreApplication.m255getInst().getString(com.baidu.tieba.z.img_upload_error));
                } else if (this.cgo.getType() != 3) {
                    this.cgm.showToast(errorData.getError_msg());
                }
                this.cgm.setResult(-1, this.cgm.getIntent());
                if (this.cgo.getLiveCardData() != null) {
                    this.cgm.sendMessage(new CustomMessage(2003001, new FrsActivityConfig(this.cgm.getPageContext().getPageActivity()).createRefreshCfgShowContent(this.cgo.getForumName(), "post live's thread")));
                }
                this.cgm.finish();
            } else if (this.cgo.isHasImages() && com.baidu.adp.lib.util.k.isEmpty(String.valueOf(this.cgo.getContent()) + this.cgo.getImagesCodeForPost())) {
                this.cgm.showToast(TbadkCoreApplication.m255getInst().getString(com.baidu.tieba.z.img_upload_error));
            } else {
                if (this.CX.pd() == 5 || this.CX.pd() == 6) {
                    com.baidu.tbadk.coreExtra.data.j jVar2 = new com.baidu.tbadk.coreExtra.data.j();
                    jVar2.parserJson(this.QK);
                    if (jVar2.getVcode_pic_url() != null) {
                        writeData = this.cgm.cfW;
                        writeData.setVcodeMD5(jVar2.getVcode_md5());
                        writeData2 = this.cgm.cfW;
                        writeData2.setVcodeUrl(jVar2.getVcode_pic_url());
                        VcodeActivity vcodeActivity = this.cgm;
                        writeData3 = this.cgm.cfW;
                        vcodeActivity.de(writeData3.getVcodeUrl());
                    }
                    editText = this.cgm.mEdit;
                    editText.setText((CharSequence) null);
                }
                this.cgm.showToast(this.CX.getErrorString());
            }
        }
        super.onPostExecute(jVar);
    }
}
