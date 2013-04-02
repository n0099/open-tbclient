package com.baidu.tieba.pb;

import android.content.Intent;
import android.os.AsyncTask;
import com.baidu.tieba.R;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class dk extends AsyncTask {
    final /* synthetic */ SubPbActivity a;
    private com.baidu.tieba.c.t b = null;
    private String c;
    private String d;
    private String e;
    private String f;
    private int g;

    public dk(SubPbActivity subPbActivity, String str, String str2, String str3, String str4, int i) {
        this.a = subPbActivity;
        this.c = str;
        this.d = str2;
        this.e = str3;
        this.f = str4;
        this.g = i;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a */
    public String doInBackground(String... strArr) {
        int i;
        this.b = new com.baidu.tieba.c.t(strArr[0]);
        this.b.a("fid", this.c);
        this.b.a("word", this.d);
        this.b.a("z", this.e);
        this.b.a("pid", this.f);
        if (this.g == 0) {
            this.b.a("isfloor", "0");
            this.b.a("src", "1");
        } else {
            this.b.a("isfloor", "1");
            this.b.a("src", "3");
        }
        i = this.a.J;
        if (i == 0) {
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
        if (this.b != null) {
            this.b.g();
        }
        this.a.aa = null;
        super.cancel(true);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a */
    public void onPostExecute(String str) {
        com.baidu.tieba.b.w wVar;
        List list;
        Cdo cdo;
        super.onPostExecute(str);
        this.a.aa = null;
        wVar = this.a.g;
        wVar.a(false);
        if (this.b != null) {
            if (str == null) {
                this.a.b(this.a.getString(R.string.success));
                if (this.g != 0) {
                    list = this.a.G;
                    int size = list.size();
                    int i = 0;
                    while (true) {
                        if (i >= size) {
                            break;
                        } else if (!this.f.equals(((com.baidu.tieba.a.an) list.get(i)).a())) {
                            i++;
                        } else {
                            list.remove(i);
                            break;
                        }
                    }
                    cdo = this.a.h;
                    cdo.notifyDataSetChanged();
                    return;
                }
                Intent intent = new Intent(this.a, PbActivity.class);
                intent.putExtra("del_post_id", this.f);
                this.a.setResult(-1, intent);
                this.a.a();
                return;
            }
            this.a.b(str);
        }
    }
}
