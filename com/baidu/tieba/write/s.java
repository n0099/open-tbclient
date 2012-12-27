package com.baidu.tieba.write;

import android.os.AsyncTask;
import android.widget.EditText;
import com.baidu.tieba.R;
import com.baidu.tieba.TiebaApplication;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class s extends AsyncTask {
    final /* synthetic */ VcodeActivity a;
    private com.baidu.tieba.b.u b;
    private com.baidu.tieba.c.t c = null;
    private String d = null;

    public s(VcodeActivity vcodeActivity, com.baidu.tieba.b.u uVar) {
        this.a = vcodeActivity;
        this.b = null;
        this.b = uVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a */
    public com.baidu.tieba.a.av doInBackground(Integer... numArr) {
        EditText editText;
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
        editText = this.a.f;
        String editable = editText.getText().toString();
        if (editable.length() > 0) {
            this.c.a("vcode", editable);
        }
        this.c.d(true);
        if (this.b.a() == 0) {
            this.c.a("http://c.tieba.baidu.com/c/c/thread/add");
            this.c.a("title", this.b.b());
        } else {
            this.c.a("http://c.tieba.baidu.com/c/c/post/add");
            this.c.a("tid", this.b.d());
            if (this.b.a() == 2) {
                this.c.a("quote_id", String.valueOf(this.b.e()));
                this.c.a("floor_num", String.valueOf(this.b.h()));
            }
        }
        this.d = this.c.i();
        return null;
    }

    public void a() {
        this.a.h = null;
        this.a.c();
        if (this.c != null) {
            this.c.g();
        }
        super.cancel(true);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a */
    public void onPostExecute(com.baidu.tieba.a.av avVar) {
        EditText editText;
        com.baidu.tieba.b.u uVar;
        com.baidu.tieba.b.u uVar2;
        com.baidu.tieba.b.u uVar3;
        this.a.c();
        this.a.h = null;
        if (this.c != null) {
            if (this.c.b()) {
                this.a.b(TiebaApplication.a().getString(R.string.send_success));
                this.a.setResult(-1, this.a.getIntent());
                this.a.finish();
            } else {
                if (this.c.d() == 5 || this.c.d() == 6) {
                    com.baidu.tieba.a.av avVar2 = new com.baidu.tieba.a.av();
                    avVar2.a(this.d);
                    if (avVar2.b() != null) {
                        uVar = this.a.b;
                        uVar.h(avVar2.a());
                        uVar2 = this.a.b;
                        uVar2.i(avVar2.b());
                        VcodeActivity vcodeActivity = this.a;
                        uVar3 = this.a.b;
                        vcodeActivity.c(uVar3.l());
                    }
                    editText = this.a.f;
                    editText.setText((CharSequence) null);
                }
                this.a.b(this.c.f());
            }
        }
        super.onPostExecute(avVar);
    }
}
