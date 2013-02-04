package com.baidu.tieba.pb;

import android.os.AsyncTask;
import com.baidu.tieba.R;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bs extends AsyncTask {
    final /* synthetic */ PbActivity b;
    private String d;
    private String e;
    private String f;
    private int g;
    private com.baidu.tieba.c.t c = null;
    String a = null;

    public bs(PbActivity pbActivity, String str, String str2, String str3, int i) {
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
                str = this.b.X;
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

    public void a() {
        com.baidu.tieba.b.n nVar;
        if (this.c != null) {
            this.c.g();
        }
        this.b.aa = null;
        nVar = this.b.n;
        nVar.f(false);
        super.cancel(true);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a */
    public void onPostExecute(Boolean bool) {
        com.baidu.tieba.b.n nVar;
        super.onPostExecute(bool);
        this.b.aa = null;
        nVar = this.b.n;
        nVar.f(false);
        if (this.c == null) {
            return;
        }
        if (!bool.booleanValue()) {
            this.b.b(this.c.f());
        } else if (this.g == 5) {
            this.b.d(this.a);
        } else {
            this.b.b(this.b.getString(R.string.success));
        }
    }
}
