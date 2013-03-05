package com.baidu.tieba.pb;

import android.os.AsyncTask;
import com.baidu.tieba.R;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bz extends AsyncTask {
    final /* synthetic */ PbActivity b;
    private String d;
    private String e;
    private String f;
    private int g;
    private com.baidu.tieba.c.t c = null;
    String a = null;

    public bz(PbActivity pbActivity, String str, String str2, String str3, int i) {
        this.b = pbActivity;
        this.d = str;
        this.e = str2;
        this.f = str3;
        this.g = i;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a */
    public Boolean doInBackground(String... strArr) {
        String str;
        this.c = new com.baidu.tieba.c.t(strArr[0]);
        this.c.a("word", this.e);
        if (this.g != 5) {
            this.c.a("fid", this.d);
            this.c.a("z", this.f);
            if (this.g == 3) {
                this.c.a("ntn", "set");
            } else if (this.g == 4) {
                this.c.a("ntn", "");
            } else if (this.g == 1) {
                this.c.a("ntn", "set");
                com.baidu.tieba.c.t tVar = this.c;
                str = this.b.aa;
                tVar.a("cid", str);
            } else {
                this.c.a("ntn", "");
            }
        }
        this.c.d(true);
        String i = this.c.i();
        if (this.c.b()) {
            if (this.g == 5) {
                this.a = i;
            }
            return true;
        }
        return false;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a */
    public void onPostExecute(Boolean bool) {
        com.baidu.tieba.b.q qVar;
        super.onPostExecute(bool);
        this.b.ad = null;
        qVar = this.b.p;
        qVar.f(false);
        if (this.c != null) {
            if (bool.booleanValue()) {
                if (this.g != 5) {
                    this.b.b(this.b.getString(R.string.success));
                    return;
                } else {
                    this.b.d(this.a);
                    return;
                }
            }
            this.b.b(this.c.f());
        }
    }

    public void a() {
        com.baidu.tieba.b.q qVar;
        if (this.c != null) {
            this.c.g();
        }
        this.b.ad = null;
        qVar = this.b.p;
        qVar.f(false);
        super.cancel(true);
    }
}
