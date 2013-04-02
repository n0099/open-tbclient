package com.baidu.tieba.pb;

import android.os.AsyncTask;
import com.baidu.android.pushservice.PushConstants;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.write.NewVcodeActivity;
import com.baidu.tieba.write.VcodeActivity;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class dm extends AsyncTask {
    final /* synthetic */ SubPbActivity a;
    private com.baidu.tieba.b.z b;
    private com.baidu.tieba.c.t c = null;
    private boolean d = false;

    public dm(SubPbActivity subPbActivity, com.baidu.tieba.b.z zVar) {
        this.a = subPbActivity;
        this.b = null;
        this.b = zVar;
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
        this.c.a(PushConstants.EXTRA_CONTENT, this.b.c());
        this.c.a("tid", this.b.d());
        if (this.b.i() != null && this.b.i().length() > 0) {
            this.c.a("vcode", this.b.i());
        }
        if (TiebaApplication.b().aj() < 3) {
            this.c.a("vcode_tag", "11");
        }
        this.c.a("quote_id", this.b.e());
        this.c.a("floor_num", String.valueOf(this.b.h()));
        this.c.d(true);
        return this.c.i();
    }

    private void a(int i, String str, String str2) {
        if (i == 5 || i == 6) {
            com.baidu.tieba.a.ba baVar = new com.baidu.tieba.a.ba();
            baVar.a(str2);
            if (baVar.b() != null) {
                this.b.h(baVar.a());
                this.b.i(baVar.b());
                if (baVar.c().equals("4")) {
                    NewVcodeActivity.a(this.a, this.b, 1200005);
                    return;
                } else {
                    VcodeActivity.a(this.a, this.b, 1200005);
                    return;
                }
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
        this.a.C = null;
        if (this.c != null) {
            if (this.c.b()) {
                this.a.n();
            } else {
                a(this.c.d(), this.c.f(), str);
            }
        }
    }

    public void a() {
        this.a.C = null;
        this.a.d();
        this.d = true;
        if (this.c != null) {
            this.c.g();
        }
        super.cancel(true);
    }
}
