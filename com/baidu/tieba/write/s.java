package com.baidu.tieba.write;

import android.os.AsyncTask;
import android.widget.EditText;
import com.baidu.tieba.R;
import com.baidu.tieba.TiebaApplication;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class s extends AsyncTask {
    final /* synthetic */ VcodeActivity a;
    private com.baidu.tieba.b.w b;
    private com.baidu.tieba.c.t c = null;
    private String d = null;

    public s(VcodeActivity vcodeActivity, com.baidu.tieba.b.w wVar) {
        this.a = vcodeActivity;
        this.b = null;
        this.b = wVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a */
    public com.baidu.tieba.a.ay doInBackground(Integer... numArr) {
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
        editText = this.a.g;
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
    public void onPostExecute(com.baidu.tieba.a.ay ayVar) {
        EditText editText;
        com.baidu.tieba.b.w wVar;
        com.baidu.tieba.b.w wVar2;
        com.baidu.tieba.b.w wVar3;
        this.a.d();
        this.a.i = null;
        if (this.c != null) {
            if (this.c.b()) {
                this.a.b(TiebaApplication.b().getString(R.string.send_success));
                this.a.setResult(-1, this.a.getIntent());
                this.a.finish();
            } else {
                if (this.c.d() == 5 || this.c.d() == 6) {
                    com.baidu.tieba.a.ay ayVar2 = new com.baidu.tieba.a.ay();
                    ayVar2.a(this.d);
                    if (ayVar2.b() != null) {
                        wVar = this.a.c;
                        wVar.h(ayVar2.a());
                        wVar2 = this.a.c;
                        wVar2.i(ayVar2.b());
                        VcodeActivity vcodeActivity = this.a;
                        wVar3 = this.a.c;
                        vcodeActivity.c(wVar3.l());
                    }
                    editText = this.a.g;
                    editText.setText((CharSequence) null);
                }
                this.a.b(this.c.f());
            }
        }
        super.onPostExecute(ayVar);
    }
}
