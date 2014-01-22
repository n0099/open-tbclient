package com.baidu.tieba.write;

import android.location.Address;
import android.widget.EditText;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.android.pushservice.PushConstants;
import com.baidu.cloudsdk.social.core.SocialConstants;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.data.ErrorData;
import com.baidu.tieba.data.WriteData;
import com.baidu.tieba.data.bf;
import com.slidingmenu.lib.R;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class s extends BdAsyncTask<Integer, Integer, bf> {
    final /* synthetic */ VcodeActivity a;
    private WriteData b;
    private com.baidu.tieba.util.ax c = null;
    private String d = null;

    public s(VcodeActivity vcodeActivity, WriteData writeData) {
        this.a = vcodeActivity;
        this.b = null;
        this.b = writeData;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public bf a(Integer... numArr) {
        EditText editText;
        Address aO;
        this.c = new com.baidu.tieba.util.ax();
        this.c.a("anonymous", SocialConstants.FALSE);
        this.c.a("fid", this.b.getForumId());
        this.c.a("kw", this.b.getForumName());
        String str = "";
        if (this.b.getBitmapId() != null && this.b.getBitmapId().getPic_id() != null && this.b.getBitmapId().getPic_id().length() > 0) {
            str = String.format("#(pic,%s,%d,%d)", this.b.getBitmapId().getPic_id(), Integer.valueOf(this.b.getBitmapId().getWidth()), Integer.valueOf(this.b.getBitmapId().getHeight()));
        }
        this.c.a("new_vcode", SocialConstants.TRUE);
        this.c.a(PushConstants.EXTRA_CONTENT, this.b.getContent() + str);
        this.c.a("vcode_md5", this.b.getVcodeMD5());
        editText = this.a.f;
        String obj = editText.getText().toString();
        if (obj.length() > 0) {
            this.c.a("vcode", obj);
        }
        this.c.e(true);
        if (this.b.getVoice() != null) {
            this.c.a("voice_md5", this.b.getVoice());
            this.c.a("during_time", String.valueOf(this.b.getVoiceDuringTime()));
        }
        if (this.b.getType() == 0) {
            this.c.a(com.baidu.tieba.data.h.a + "c/c/thread/add");
            this.c.a("title", this.b.getTitle());
            if (!com.baidu.tieba.data.h.h().equals(this.a.getIntent().getStringExtra("forum_id")) && TiebaApplication.h().t() && (aO = TiebaApplication.h().aO()) != null) {
                this.c.a("lbs", String.valueOf(aO.getLatitude()) + "," + String.valueOf(aO.getLongitude()));
            }
        } else {
            this.c.a(com.baidu.tieba.data.h.a + "c/c/post/add");
            this.c.a("tid", this.b.getThreadId());
            this.c.a("is_ad", this.a.getIntent().getBooleanExtra("is_ad", false) ? SocialConstants.TRUE : SocialConstants.FALSE);
            if (this.b.getType() == 2) {
                this.c.a("quote_id", String.valueOf(this.b.getFloor()));
                this.c.a("floor_num", String.valueOf(this.b.getFloorNum()));
            }
        }
        this.d = this.c.m();
        return null;
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        this.a.h = null;
        this.a.closeLoadingDialog();
        if (this.c != null) {
            this.c.k();
        }
        super.cancel(true);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void a(bf bfVar) {
        EditText editText;
        WriteData writeData;
        WriteData writeData2;
        WriteData writeData3;
        this.a.closeLoadingDialog();
        this.a.h = null;
        if (this.c != null) {
            if (this.c.d()) {
                ErrorData errorData = new ErrorData();
                errorData.parserJson(this.d);
                if (errorData.getError_msg() == null || errorData.getError_msg().length() <= 0) {
                    this.a.showToast(TiebaApplication.h().getString(R.string.send_success));
                } else {
                    this.a.showToast(errorData.getError_msg());
                }
                this.a.setResult(-1, this.a.getIntent());
                this.a.finish();
            } else {
                if (this.c.f() == 5 || this.c.f() == 6) {
                    bf bfVar2 = new bf();
                    bfVar2.a(this.d);
                    if (bfVar2.b() != null) {
                        writeData = this.a.b;
                        writeData.setVcodeMD5(bfVar2.a());
                        writeData2 = this.a.b;
                        writeData2.setVcodeUrl(bfVar2.b());
                        VcodeActivity vcodeActivity = this.a;
                        writeData3 = this.a.b;
                        vcodeActivity.a(writeData3.getVcodeUrl());
                    }
                    editText = this.a.f;
                    editText.setText((CharSequence) null);
                }
                this.a.showToast(this.c.j());
            }
        }
        super.a((s) bfVar);
    }
}
