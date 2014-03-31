package com.baidu.tieba.write;

import android.location.Address;
import android.widget.EditText;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.core.data.ErrorData;
import com.baidu.tbadk.coreExtra.data.WriteData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class af extends BdAsyncTask<Integer, Integer, com.baidu.tbadk.coreExtra.data.f> {
    final /* synthetic */ VcodeActivity a;
    private WriteData b;
    private com.baidu.tbadk.core.util.ak c = null;
    private String d = null;

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object[]] */
    /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public final /* synthetic */ com.baidu.tbadk.coreExtra.data.f a(Integer... numArr) {
        EditText editText;
        com.baidu.tbadk.core.util.ak akVar;
        String str;
        String str2;
        Address b;
        this.c = new com.baidu.tbadk.core.util.ak();
        this.c.a("anonymous", "0");
        this.c.a("fid", this.b.getForumId());
        this.c.a("kw", this.b.getForumName());
        String imagesCodeForPost = this.b.getImagesCodeForPost();
        this.c.a("new_vcode", "1");
        this.c.a("content", String.valueOf(this.b.getContent()) + imagesCodeForPost);
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
            this.c.a(String.valueOf(com.baidu.tbadk.core.data.n.a) + "c/c/thread/add");
            this.c.a("title", this.b.getTitle());
            this.c.a("is_ntitle", this.b.isNoTitle() ? "1" : "0");
            if (!com.baidu.tbadk.core.data.n.y().equals(this.a.getIntent().getStringExtra("forum_id")) && com.baidu.tieba.r.c().j() && (b = com.baidu.adp.lib.c.a.a().b(false)) != null) {
                akVar = this.c;
                str = "lbs";
                str2 = String.valueOf(String.valueOf(b.getLatitude())) + "," + String.valueOf(b.getLongitude());
                akVar.a(str, str2);
            }
        } else {
            this.c.a(String.valueOf(com.baidu.tbadk.core.data.n.a) + "c/c/post/add");
            this.c.a("tid", this.b.getThreadId());
            this.c.a("is_ad", this.a.getIntent().getBooleanExtra("is_ad", false) ? "1" : "0");
            if (this.b.getType() == 2) {
                this.c.a("quote_id", String.valueOf(this.b.getFloor()));
                this.c.a("floor_num", String.valueOf(this.b.getFloorNum()));
                akVar = this.c;
                str = "is_addition";
                str2 = this.b.isAddition() ? "1" : "0";
                akVar.a(str, str2);
            }
        }
        this.d = this.c.i();
        return null;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public final /* synthetic */ void a(com.baidu.tbadk.coreExtra.data.f fVar) {
        EditText editText;
        WriteData writeData;
        WriteData writeData2;
        WriteData writeData3;
        com.baidu.tbadk.coreExtra.data.f fVar2 = fVar;
        this.a.closeLoadingDialog();
        this.a.g = null;
        if (this.c != null) {
            if (this.c.a().b().b()) {
                ErrorData errorData = new ErrorData();
                errorData.parserJson(this.d);
                if (errorData.getError_msg() == null || errorData.getError_msg().length() <= 0) {
                    VcodeActivity vcodeActivity = this.a;
                    com.baidu.tieba.r.c();
                    vcodeActivity.showToast(com.baidu.tieba.r.d().getString(com.baidu.tieba.a.k.send_success));
                    this.b.deleteUploadedTempImages();
                } else if (this.b.isHasImages() && com.baidu.adp.lib.util.h.b(String.valueOf(this.b.getContent()) + this.b.getImagesCodeForPost())) {
                    VcodeActivity vcodeActivity2 = this.a;
                    com.baidu.tieba.r.c();
                    vcodeActivity2.showToast(com.baidu.tieba.r.d().getString(com.baidu.tieba.a.k.img_upload_error));
                } else {
                    this.a.showToast(errorData.getError_msg());
                }
                this.a.setResult(-1, this.a.getIntent());
                this.a.finish();
            } else if (this.b.isHasImages() && com.baidu.adp.lib.util.h.b(String.valueOf(this.b.getContent()) + this.b.getImagesCodeForPost())) {
                VcodeActivity vcodeActivity3 = this.a;
                com.baidu.tieba.r.c();
                vcodeActivity3.showToast(com.baidu.tieba.r.d().getString(com.baidu.tieba.a.k.img_upload_error));
            } else {
                if (this.c.d() == 5 || this.c.d() == 6) {
                    com.baidu.tbadk.coreExtra.data.f fVar3 = new com.baidu.tbadk.coreExtra.data.f();
                    fVar3.a(this.d);
                    if (fVar3.b() != null) {
                        writeData = this.a.b;
                        writeData.setVcodeMD5(fVar3.a());
                        writeData2 = this.a.b;
                        writeData2.setVcodeUrl(fVar3.b());
                        VcodeActivity vcodeActivity4 = this.a;
                        writeData3 = this.a.b;
                        vcodeActivity4.a(writeData3.getVcodeUrl());
                    }
                    editText = this.a.e;
                    editText.setText((CharSequence) null);
                }
                this.a.showToast(this.c.f());
            }
        }
        super.a((af) fVar2);
    }

    public af(VcodeActivity vcodeActivity, WriteData writeData) {
        this.a = vcodeActivity;
        this.b = null;
        this.b = writeData;
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public final void cancel() {
        this.a.g = null;
        this.a.closeLoadingDialog();
        if (this.c != null) {
            this.c.g();
        }
        super.cancel(true);
    }
}
