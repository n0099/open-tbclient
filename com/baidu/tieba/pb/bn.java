package com.baidu.tieba.pb;

import android.os.AsyncTask;
import com.baidu.tieba.R;
import java.util.ArrayList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bn extends AsyncTask {
    final /* synthetic */ PbActivity a;
    private com.baidu.tieba.c.t b = null;
    private String c;
    private String d;
    private String e;
    private String f;
    private int g;
    private int h;

    public bn(PbActivity pbActivity, String str, String str2, String str3, String str4, int i, int i2) {
        this.a = pbActivity;
        this.c = str;
        this.d = str2;
        this.e = str3;
        this.f = str4;
        this.g = i;
        this.h = i2;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a */
    public String doInBackground(String... strArr) {
        this.b = new com.baidu.tieba.c.t(strArr[0]);
        this.b.a("fid", this.c);
        this.b.a("word", this.d);
        this.b.a("z", this.e);
        if (this.g == 0) {
            this.b.a("pid", this.f);
            this.b.a("isfloor", "0");
            this.b.a("src", "1");
        }
        if (this.h == 0) {
            this.b.a("is_vipdel", "1");
        } else {
            this.b.a("is_vipdel", "0");
        }
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
        this.a.Y = null;
        nVar = this.a.n;
        nVar.d(false);
        super.cancel(true);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a */
    public void onPostExecute(String str) {
        com.baidu.tieba.b.n nVar;
        com.baidu.tieba.b.n nVar2;
        com.baidu.tieba.b.n nVar3;
        com.baidu.tieba.b.n nVar4;
        super.onPostExecute(str);
        this.a.Y = null;
        nVar = this.a.n;
        nVar.d(false);
        if (this.b == null) {
            return;
        }
        if (str != null) {
            this.a.b(str);
            return;
        }
        this.a.b(this.a.getString(R.string.success));
        if (this.g != 0) {
            String stringExtra = this.a.getIntent().getStringExtra("st_type");
            if (stringExtra != null && stringExtra.equals("tb_frslist")) {
                this.a.setResult(-1);
            }
            this.a.g();
            return;
        }
        nVar2 = this.a.n;
        if (nVar2 != null) {
            nVar3 = this.a.n;
            if (nVar3.a() != null) {
                nVar4 = this.a.n;
                ArrayList c = nVar4.a().c();
                int size = c.size();
                int i = 0;
                while (true) {
                    if (i >= size) {
                        break;
                    } else if (this.f.equals(((com.baidu.tieba.a.am) c.get(i)).a())) {
                        c.remove(i);
                        break;
                    } else {
                        i++;
                    }
                }
                this.a.x();
            }
        }
    }
}
