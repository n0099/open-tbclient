package com.baidu.tieba.write;

import android.location.Address;
import android.widget.EditText;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.data.ErrorData;
import com.baidu.tbadk.coreExtra.data.WriteData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ab extends BdAsyncTask<Integer, Integer, com.baidu.tbadk.coreExtra.data.f> {
    final /* synthetic */ VcodeActivity a;
    private WriteData b;
    private com.baidu.tbadk.core.util.aq c = null;
    private String d = null;

    public ab(VcodeActivity vcodeActivity, WriteData writeData) {
        this.a = vcodeActivity;
        this.b = null;
        this.b = writeData;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: a */
    public com.baidu.tbadk.coreExtra.data.f doInBackground(Integer... numArr) {
        EditText editText;
        Address b;
        this.c = new com.baidu.tbadk.core.util.aq();
        this.c.a("anonymous", "0");
        this.c.a("fid", this.b.getForumId());
        this.c.a("kw", this.b.getForumName());
        String imagesCodeForPost = this.b.getImagesCodeForPost();
        this.c.a("new_vcode", TbConfig.ST_PARAM_TAB_MSG_PERSONAL_CHAT_CLICK);
        this.c.a("content", String.valueOf(this.b.getContent()) + imagesCodeForPost);
        if (this.b.getIsBaobaoImageUploaded()) {
            this.c.a("tail_type", String.valueOf(com.baidu.tieba.a.e.a));
            this.c.a("tail_content", this.b.getBaobaoContent());
            this.b.setBabaoPosted(true);
        } else {
            this.b.setBabaoPosted(false);
        }
        this.c.a("vcode_md5", this.b.getVcodeMD5());
        editText = this.a.e;
        String editable = editText.getText().toString();
        if (editable.length() > 0) {
            this.c.a("vcode", editable);
        }
        this.c.a().a().a = true;
        if (this.b.getVoice() != null) {
            this.c.a("voice_md5", this.b.getVoice());
            this.c.a("during_time", String.valueOf(this.b.getVoiceDuringTime()));
        }
        if (this.b.getType() == 0) {
            this.c.a(String.valueOf(TbConfig.SERVER_ADDRESS) + "c/c/thread/add");
            this.c.a("title", this.b.getTitle());
            this.c.a("is_ntitle", this.b.isNoTitle() ? TbConfig.ST_PARAM_TAB_MSG_PERSONAL_CHAT_CLICK : "0");
            if (this.b.getLiveCardData() != null) {
                this.c.a(com.baidu.tbadk.core.frameworkData.a.GROUP_ID, String.valueOf(this.b.getLiveCardData().getGroupId()));
                this.c.a("start_time", String.valueOf(this.b.getLiveCardData().getStartTime()));
            }
            if (!TbConfig.getPositionPagerId().equals(this.a.getIntent().getStringExtra(com.baidu.tbadk.core.frameworkData.a.FORUM_ID)) && com.baidu.tieba.ai.c().m() && (b = com.baidu.adp.lib.c.a.a().b(false)) != null) {
                this.c.a("lbs", String.valueOf(String.valueOf(b.getLatitude())) + "," + String.valueOf(b.getLongitude()));
            }
        } else {
            this.c.a(String.valueOf(TbConfig.SERVER_ADDRESS) + "c/c/post/add");
            this.c.a("tid", this.b.getThreadId());
            this.c.a("is_ad", this.a.getIntent().getBooleanExtra("is_ad", false) ? TbConfig.ST_PARAM_TAB_MSG_PERSONAL_CHAT_CLICK : "0");
            if (this.b.getType() == 2) {
                this.c.a("quote_id", String.valueOf(this.b.getFloor()));
                this.c.a("floor_num", String.valueOf(this.b.getFloorNum()));
                this.c.a("is_addition", this.b.isAddition() ? TbConfig.ST_PARAM_TAB_MSG_PERSONAL_CHAT_CLICK : "0");
            }
        }
        this.d = this.c.i();
        return null;
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        this.a.g = null;
        this.a.closeLoadingDialog();
        if (this.c != null) {
            this.c.g();
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
        this.a.closeLoadingDialog();
        this.a.g = null;
        if (this.c != null) {
            if (this.c.a().b().b()) {
                ErrorData errorData = new ErrorData();
                errorData.parserJson(this.d);
                if (errorData.getError_msg() == null || errorData.getError_msg().length() <= 0) {
                    this.a.showToast(com.baidu.tieba.ai.c().d().getString(com.baidu.tieba.y.send_success));
                    this.b.deleteUploadedTempImages();
                    if (this.b != null && this.b.isBabaoPosted()) {
                        com.baidu.tieba.d.a.d();
                    }
                } else if ((this.b.isHasImages() || this.b.getIsBaobao()) && com.baidu.adp.lib.util.i.b(String.valueOf(this.b.getContent()) + this.b.getImagesCodeForPost())) {
                    this.a.showToast(com.baidu.tieba.ai.c().d().getString(com.baidu.tieba.y.img_upload_error));
                } else {
                    this.a.showToast(errorData.getError_msg());
                }
                this.a.setResult(-1, this.a.getIntent());
                if (this.b.getLiveCardData() != null) {
                    this.a.sendMessage(new CustomMessage(2003001, new com.baidu.tbadk.core.atomData.r(this.a).c(this.b.getForumName(), "post live's thread")));
                }
                this.a.finish();
            } else if (this.b.isHasImages() && com.baidu.adp.lib.util.i.b(String.valueOf(this.b.getContent()) + this.b.getImagesCodeForPost())) {
                this.a.showToast(com.baidu.tieba.ai.c().d().getString(com.baidu.tieba.y.img_upload_error));
            } else {
                if (this.c.d() == 5 || this.c.d() == 6) {
                    com.baidu.tbadk.coreExtra.data.f fVar2 = new com.baidu.tbadk.coreExtra.data.f();
                    fVar2.a(this.d);
                    if (fVar2.b() != null) {
                        writeData = this.a.b;
                        writeData.setVcodeMD5(fVar2.a());
                        writeData2 = this.a.b;
                        writeData2.setVcodeUrl(fVar2.b());
                        VcodeActivity vcodeActivity = this.a;
                        writeData3 = this.a.b;
                        vcodeActivity.a(writeData3.getVcodeUrl());
                    }
                    editText = this.a.e;
                    editText.setText((CharSequence) null);
                }
                this.a.showToast(this.c.f());
            }
        }
        super.onPostExecute(fVar);
    }
}
