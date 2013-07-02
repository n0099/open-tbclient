package com.baidu.tieba.write;

import android.location.Address;
import android.widget.EditText;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.android.pushservice.PushConstants;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.data.be;
import com.baidu.tieba.model.WriteModel;
import com.slidingmenu.lib.R;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class s extends BdAsyncTask {
    final /* synthetic */ VcodeActivity a;
    private WriteModel b;
    private com.baidu.tieba.util.r c = null;
    private String d = null;

    public s(VcodeActivity vcodeActivity, WriteModel writeModel) {
        this.a = vcodeActivity;
        this.b = null;
        this.b = writeModel;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public be a(Integer... numArr) {
        EditText editText;
        Address aP;
        this.c = new com.baidu.tieba.util.r();
        this.c.a("anonymous", "0");
        this.c.a("fid", this.b.getForumId());
        this.c.a("kw", this.b.getForumName());
        String str = "";
        if (this.b.getBitmapId() != null && this.b.getBitmapId().getPic_id() != null && this.b.getBitmapId().getPic_id().length() > 0) {
            str = String.format("#(pic,%s,%d,%d)", this.b.getBitmapId().getPic_id(), Integer.valueOf(this.b.getBitmapId().getWidth()), Integer.valueOf(this.b.getBitmapId().getHeight()));
        }
        this.c.a(PushConstants.EXTRA_CONTENT, String.valueOf(this.b.getContent()) + str);
        this.c.a("vcode_md5", this.b.getVcodeMD5());
        editText = this.a.e;
        String editable = editText.getText().toString();
        if (editable.length() > 0) {
            this.c.a("vcode", editable);
        }
        this.c.d(true);
        if (this.b.getType() == 0 || this.b.getType() == 3) {
            this.c.a(String.valueOf(com.baidu.tieba.data.g.a) + "c/c/thread/add");
            if (this.b.getType() == 0) {
                this.c.a("title", this.b.getTitle());
            } else {
                this.c.a("thread_type", WriteModel.THREAD_TYPE_LBS);
                this.c.a("st_type", "tb_suishoufa");
            }
            if (!com.baidu.tieba.data.g.g().equals(this.a.getIntent().getStringExtra("forum_id")) && TiebaApplication.f().u() && (aP = TiebaApplication.f().aP()) != null) {
                this.c.a("lbs", String.valueOf(String.valueOf(aP.getLatitude())) + "," + String.valueOf(aP.getLongitude()));
            }
        } else {
            this.c.a(String.valueOf(com.baidu.tieba.data.g.a) + "c/c/post/add");
            this.c.a("tid", this.b.getThreadId());
            this.c.a("is_ad", this.a.getIntent().getBooleanExtra("is_ad", false) ? "1" : "0");
            if (this.b.getType() == 2) {
                this.c.a("quote_id", String.valueOf(this.b.getFloor()));
                this.c.a("floor_num", String.valueOf(this.b.getFloorNum()));
            }
        }
        this.d = this.c.j();
        return null;
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        this.a.g = null;
        this.a.h();
        if (this.c != null) {
            this.c.h();
        }
        super.cancel(true);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void a(be beVar) {
        EditText editText;
        WriteModel writeModel;
        WriteModel writeModel2;
        WriteModel writeModel3;
        this.a.h();
        this.a.g = null;
        if (this.c != null) {
            if (this.c.c()) {
                com.baidu.tieba.data.n nVar = new com.baidu.tieba.data.n();
                nVar.b(this.d);
                if (nVar.b() == null || nVar.b().length() <= 0) {
                    this.a.a(TiebaApplication.f().getString(R.string.send_success));
                } else {
                    this.a.a(nVar.b());
                }
                this.a.setResult(-1, this.a.getIntent());
                this.a.finish();
            } else {
                if (this.c.e() == 5 || this.c.e() == 6) {
                    be beVar2 = new be();
                    beVar2.a(this.d);
                    if (beVar2.b() != null) {
                        writeModel = this.a.a;
                        writeModel.setVcodeMD5(beVar2.a());
                        writeModel2 = this.a.a;
                        writeModel2.setVcodeUrl(beVar2.b());
                        VcodeActivity vcodeActivity = this.a;
                        writeModel3 = this.a.a;
                        vcodeActivity.c(writeModel3.getVcodeUrl());
                    }
                    editText = this.a.e;
                    editText.setText((CharSequence) null);
                }
                this.a.a(this.c.g());
            }
        }
        super.a((Object) beVar);
    }
}
