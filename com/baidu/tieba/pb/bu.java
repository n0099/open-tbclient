package com.baidu.tieba.pb;

import android.os.AsyncTask;
import com.baidu.tieba.R;
import java.util.ArrayList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bu extends AsyncTask {
    final /* synthetic */ PbActivity a;
    private com.baidu.tieba.c.t b = null;
    private String c;
    private String d;
    private String e;
    private String f;
    private int g;
    private int h;

    public bu(PbActivity pbActivity, String str, String str2, String str3, String str4, int i, int i2) {
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
        com.baidu.tieba.b.q qVar;
        if (this.b != null) {
            this.b.g();
        }
        this.a.ab = null;
        qVar = this.a.p;
        qVar.d(false);
        super.cancel(true);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a */
    public void onPostExecute(String str) {
        com.baidu.tieba.b.q qVar;
        com.baidu.tieba.b.q qVar2;
        com.baidu.tieba.b.q qVar3;
        com.baidu.tieba.b.q qVar4;
        super.onPostExecute(str);
        this.a.ab = null;
        qVar = this.a.p;
        qVar.d(false);
        if (this.b != null) {
            if (str == null) {
                this.a.b(this.a.getString(R.string.success));
                if (this.g == 0) {
                    qVar2 = this.a.p;
                    if (qVar2 != null) {
                        qVar3 = this.a.p;
                        if (qVar3.a() != null) {
                            qVar4 = this.a.p;
                            ArrayList d = qVar4.a().d();
                            int size = d.size();
                            int i = 0;
                            while (true) {
                                if (i >= size) {
                                    break;
                                } else if (!this.f.equals(((com.baidu.tieba.a.al) d.get(i)).a())) {
                                    i++;
                                } else {
                                    d.remove(i);
                                    break;
                                }
                            }
                            this.a.D();
                            return;
                        }
                        return;
                    }
                    return;
                }
                String stringExtra = this.a.getIntent().getStringExtra("st_type");
                if (stringExtra != null && stringExtra.equals("tb_frslist")) {
                    this.a.setResult(-1);
                }
                this.a.a();
                return;
            }
            this.a.b(str);
        }
    }
}
