package com.baidu.tieba.write;

import android.location.Address;
import android.os.AsyncTask;
import android.widget.EditText;
import com.baidu.tieba.R;
import com.baidu.tieba.TiebaApplication;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class s extends AsyncTask {
    final /* synthetic */ VcodeActivity a;
    private com.baidu.tieba.b.y b;
    private com.baidu.tieba.c.t c = null;
    private String d = null;

    public s(VcodeActivity vcodeActivity, com.baidu.tieba.b.y yVar) {
        this.a = vcodeActivity;
        this.b = null;
        this.b = yVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a */
    public com.baidu.tieba.a.aw doInBackground(Integer... numArr) {
        EditText editText;
        Address ax;
        this.c = new com.baidu.tieba.c.t();
        this.c.a("anonymous", "0");
        this.c.a("fid", this.b.f());
        this.c.a("kw", this.b.g());
        String str = "";
        if (this.b.j() != null && this.b.j().a() != null && this.b.j().a().length() > 0) {
            str = String.format("#(pic,%s,%d,%d)", this.b.j().a(), Integer.valueOf(this.b.j().b()), Integer.valueOf(this.b.j().c()));
        }
        this.c.a("content", String.valueOf(this.b.c()) + str);
        this.c.a("vcode_md5", this.b.k());
        editText = this.a.g;
        String editable = editText.getText().toString();
        if (editable.length() > 0) {
            this.c.a("vcode", editable);
        }
        this.c.d(true);
        if (this.b.a() == 0 || this.b.a() == 3) {
            this.c.a("http://c.tieba.baidu.com/c/c/thread/add");
            if (this.b.a() == 0) {
                this.c.a("title", this.b.b());
            } else {
                this.c.a("thread_type", "7");
                this.c.a("st_type", "tb_suishoufa");
            }
            if (!com.baidu.tieba.a.i.f().equals(this.a.getIntent().getStringExtra("forum_id")) && TiebaApplication.b().l() && (ax = TiebaApplication.b().ax()) != null) {
                this.c.a("lbs", String.valueOf(String.valueOf(ax.getLatitude())) + "," + String.valueOf(ax.getLongitude()));
            }
        } else {
            this.c.a("http://c.tieba.baidu.com/c/c/post/add");
            this.c.a("tid", this.b.d());
            this.c.a("is_ad", this.a.getIntent().getBooleanExtra("is_ad", false) ? "1" : "0");
            if (this.b.a() == 2) {
                this.c.a("quote_id", String.valueOf(this.b.e()));
                this.c.a("floor_num", String.valueOf(this.b.h()));
            }
        }
        this.d = this.c.i();
        return null;
    }

    public void a() {
        this.a.i = null;
        this.a.d();
        if (this.c != null) {
            this.c.g();
        }
        super.cancel(true);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a */
    public void onPostExecute(com.baidu.tieba.a.aw awVar) {
        EditText editText;
        com.baidu.tieba.b.y yVar;
        com.baidu.tieba.b.y yVar2;
        com.baidu.tieba.b.y yVar3;
        this.a.d();
        this.a.i = null;
        if (this.c != null) {
            if (this.c.b()) {
                com.baidu.tieba.a.o oVar = new com.baidu.tieba.a.o();
                oVar.a(this.d);
                if (oVar.b() == null || oVar.b().length() <= 0) {
                    this.a.b(TiebaApplication.b().getString(R.string.send_success));
                } else {
                    this.a.b(oVar.b());
                }
                this.a.setResult(-1, this.a.getIntent());
                this.a.finish();
            } else {
                if (this.c.d() == 5 || this.c.d() == 6) {
                    com.baidu.tieba.a.aw awVar2 = new com.baidu.tieba.a.aw();
                    awVar2.a(this.d);
                    if (awVar2.b() != null) {
                        yVar = this.a.c;
                        yVar.h(awVar2.a());
                        yVar2 = this.a.c;
                        yVar2.i(awVar2.b());
                        VcodeActivity vcodeActivity = this.a;
                        yVar3 = this.a.c;
                        vcodeActivity.c(yVar3.l());
                    }
                    editText = this.a.g;
                    editText.setText((CharSequence) null);
                }
                this.a.b(this.c.f());
            }
        }
        super.onPostExecute(awVar);
    }
}
