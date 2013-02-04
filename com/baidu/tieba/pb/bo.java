package com.baidu.tieba.pb;

import android.os.AsyncTask;
import com.baidu.tieba.R;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bo extends AsyncTask {
    final /* synthetic */ PbActivity a;
    private com.baidu.tieba.c.t b = null;
    private String c;
    private String d;
    private String e;
    private String f;
    private String g;

    public bo(PbActivity pbActivity, String str, String str2, String str3, String str4, String str5) {
        this.a = pbActivity;
        this.c = str;
        this.d = str2;
        this.e = str3;
        this.f = str4;
        this.g = str5;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a */
    public String doInBackground(String... strArr) {
        this.b = new com.baidu.tieba.c.t(strArr[0]);
        this.b.a("day", this.g);
        this.b.a("un", this.f);
        this.b.a("fid", this.c);
        this.b.a("word", this.d);
        this.b.a("z", this.e);
        this.b.a("ntn", "banid");
        this.b.d(true);
        this.b.i();
        if (this.b.b()) {
            return null;
        }
        return this.b.f();
    }

    public void a() {
        com.baidu.tieba.b.n nVar;
        if (this.b != null) {
            this.b.g();
        }
        this.a.Z = null;
        nVar = this.a.n;
        nVar.e(false);
        super.cancel(true);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a */
    public void onPostExecute(String str) {
        com.baidu.tieba.b.n nVar;
        super.onPostExecute(str);
        this.a.Z = null;
        nVar = this.a.n;
        nVar.e(false);
        if (this.b == null) {
            return;
        }
        if (str == null) {
            this.a.b(this.a.getString(R.string.success));
        } else {
            this.a.b(str);
        }
    }
}
