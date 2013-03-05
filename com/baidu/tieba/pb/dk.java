package com.baidu.tieba.pb;

import android.os.AsyncTask;
import com.baidu.tieba.write.VcodeActivity;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class dk extends AsyncTask {
    final /* synthetic */ SubPbActivity a;
    private com.baidu.tieba.b.y b;
    private com.baidu.tieba.c.t c = null;
    private boolean d = false;

    public dk(SubPbActivity subPbActivity, com.baidu.tieba.b.y yVar) {
        this.a = subPbActivity;
        this.b = null;
        this.b = yVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a */
    public String doInBackground(Integer... numArr) {
        if (this.d) {
            return null;
        }
        this.c = new com.baidu.tieba.c.t("http://c.tieba.baidu.com/c/c/post/add");
        this.c.a("anonymous", "0");
        this.c.a("fid", this.b.f());
        this.c.a("kw", this.b.g());
        this.c.a("content", this.b.c());
        this.c.a("tid", this.b.d());
        if (this.b.i() != null && this.b.i().length() > 0) {
            this.c.a("vcode", this.b.i());
        }
        this.c.a("quote_id", this.b.e());
        this.c.a("floor_num", String.valueOf(this.b.h()));
        this.c.d(true);
        return this.c.i();
    }

    private void a(int i, String str, String str2) {
        if (i == 5 || i == 6) {
            com.baidu.tieba.a.aw awVar = new com.baidu.tieba.a.aw();
            awVar.a(str2);
            if (awVar.b() != null) {
                this.b.h(awVar.a());
                this.b.i(awVar.b());
                VcodeActivity.a(this.a, this.b, 1200005);
                return;
            }
            this.a.b(str);
            return;
        }
        this.a.b(str);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a */
    public void onPostExecute(String str) {
        super.onPostExecute(str);
        this.a.d();
        this.a.G = null;
        if (this.c != null) {
            if (this.c.b()) {
                this.a.o();
            } else {
                a(this.c.d(), this.c.f(), str);
            }
        }
    }

    public void a() {
        this.a.G = null;
        this.a.d();
        this.d = true;
        if (this.c != null) {
            this.c.g();
        }
        super.cancel(true);
    }
}
