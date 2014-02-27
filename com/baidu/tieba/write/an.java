package com.baidu.tieba.write;

import android.location.Address;
import android.widget.EditText;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.android.pushservice.PushConstants;
import com.baidu.cloudsdk.social.core.SocialConstants;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.data.ErrorData;
import com.baidu.tieba.data.WriteData;
import com.slidingmenu.lib.R;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class an extends BdAsyncTask<Integer, Integer, com.baidu.tieba.data.bd> {
    final /* synthetic */ VcodeActivity a;
    private WriteData b;
    private com.baidu.tieba.util.ba c = null;
    private String d = null;

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object[]] */
    /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public final /* synthetic */ com.baidu.tieba.data.bd a(Integer... numArr) {
        EditText editText;
        Address b;
        this.c = new com.baidu.tieba.util.ba();
        this.c.a("anonymous", SocialConstants.FALSE);
        this.c.a("fid", this.b.getForumId());
        this.c.a("kw", this.b.getForumName());
        String imagesCodeForPost = this.b.getImagesCodeForPost();
        this.c.a("new_vcode", SocialConstants.TRUE);
        this.c.a(PushConstants.EXTRA_CONTENT, String.valueOf(this.b.getContent()) + imagesCodeForPost);
        this.c.a("vcode_md5", this.b.getVcodeMD5());
        editText = this.a.e;
        String editable = editText.getText().toString();
        if (editable.length() > 0) {
            this.c.a("vcode", editable);
        }
        this.c.e(true);
        if (this.b.getVoice() != null) {
            this.c.a("voice_md5", this.b.getVoice());
            this.c.a("during_time", String.valueOf(this.b.getVoiceDuringTime()));
        }
        if (this.b.getType() == 0) {
            this.c.a(String.valueOf(com.baidu.tieba.data.i.a) + "c/c/thread/add");
            this.c.a("title", this.b.getTitle());
            if (!com.baidu.tieba.data.i.s().equals(this.a.getIntent().getStringExtra("forum_id")) && TiebaApplication.g().o() && (b = com.baidu.adp.lib.c.a.a().b(false)) != null) {
                this.c.a("lbs", String.valueOf(String.valueOf(b.getLatitude())) + "," + String.valueOf(b.getLongitude()));
            }
        } else {
            this.c.a(String.valueOf(com.baidu.tieba.data.i.a) + "c/c/post/add");
            this.c.a("tid", this.b.getThreadId());
            this.c.a("is_ad", this.a.getIntent().getBooleanExtra("is_ad", false) ? SocialConstants.TRUE : SocialConstants.FALSE);
            if (this.b.getType() == 2) {
                this.c.a("quote_id", String.valueOf(this.b.getFloor()));
                this.c.a("floor_num", String.valueOf(this.b.getFloorNum()));
            }
        }
        this.d = this.c.l();
        return null;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public final /* synthetic */ void a(com.baidu.tieba.data.bd bdVar) {
        EditText editText;
        WriteData writeData;
        WriteData writeData2;
        WriteData writeData3;
        com.baidu.tieba.data.bd bdVar2 = bdVar;
        this.a.closeLoadingDialog();
        this.a.g = null;
        if (this.c != null) {
            if (this.c.c()) {
                ErrorData errorData = new ErrorData();
                errorData.parserJson(this.d);
                if (errorData.getError_msg() == null || errorData.getError_msg().length() <= 0) {
                    this.a.showToast(TiebaApplication.g().b().getString(R.string.send_success));
                    this.b.deleteUploadedTempImages();
                } else if (this.b.isHasImages() && com.baidu.adp.lib.util.g.b(String.valueOf(this.b.getContent()) + this.b.getImagesCodeForPost())) {
                    this.a.showToast(TiebaApplication.g().b().getString(R.string.img_upload_error));
                } else {
                    this.a.showToast(errorData.getError_msg());
                }
                this.a.setResult(-1, this.a.getIntent());
                this.a.finish();
            } else if (this.b.isHasImages() && com.baidu.adp.lib.util.g.b(String.valueOf(this.b.getContent()) + this.b.getImagesCodeForPost())) {
                this.a.showToast(TiebaApplication.g().b().getString(R.string.img_upload_error));
            } else {
                if (this.c.e() == 5 || this.c.e() == 6) {
                    com.baidu.tieba.data.bd bdVar3 = new com.baidu.tieba.data.bd();
                    bdVar3.a(this.d);
                    if (bdVar3.b() != null) {
                        writeData = this.a.b;
                        writeData.setVcodeMD5(bdVar3.a());
                        writeData2 = this.a.b;
                        writeData2.setVcodeUrl(bdVar3.b());
                        VcodeActivity vcodeActivity = this.a;
                        writeData3 = this.a.b;
                        vcodeActivity.a(writeData3.getVcodeUrl());
                    }
                    editText = this.a.e;
                    editText.setText((CharSequence) null);
                }
                this.a.showToast(this.c.i());
            }
        }
        super.a((an) bdVar2);
    }

    public an(VcodeActivity vcodeActivity, WriteData writeData) {
        this.a = vcodeActivity;
        this.b = null;
        this.b = writeData;
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public final void cancel() {
        this.a.g = null;
        this.a.closeLoadingDialog();
        if (this.c != null) {
            this.c.j();
        }
        super.cancel(true);
    }
}
