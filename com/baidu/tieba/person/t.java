package com.baidu.tieba.person;

import android.os.AsyncTask;
import com.baidu.tieba.R;
import java.io.File;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class t extends AsyncTask {
    final /* synthetic */ EditHeadActivity a;
    private com.baidu.tieba.c.t b;
    private com.baidu.tieba.a.f c;
    private com.baidu.tieba.c.f d;

    private t(EditHeadActivity editHeadActivity) {
        this.a = editHeadActivity;
        this.b = null;
        this.c = null;
        this.d = null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ t(EditHeadActivity editHeadActivity, t tVar) {
        this(editHeadActivity);
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:32:0x00ef */
    /* JADX DEBUG: Method merged with bridge method */
    /* JADX DEBUG: Multi-variable search result rejected for r0v3, resolved type: java.lang.String */
    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v2 */
    /* JADX WARN: Type inference failed for: r0v5, types: [int] */
    @Override // android.os.AsyncTask
    /* renamed from: a */
    public String doInBackground(String... strArr) {
        String str;
        Exception e;
        com.baidu.tieba.a.e eVar;
        this.b = new com.baidu.tieba.c.t("http://c.tieba.baidu.com/c/c/img/portrait");
        try {
            File c = com.baidu.tieba.c.o.c("tieba_head_image");
            str = (c.length() > 102400L ? 1 : (c.length() == 102400L ? 0 : -1));
            try {
                if (str <= 0 || !(com.baidu.tieba.a.h.j() != 0 || this.b.e() == null || this.b.e().equals("2"))) {
                    com.baidu.tieba.c.ae.c("PostThreadTask", "doInBackground", "image size is less than 100K");
                    String b = this.b.b("tieba_head_image");
                    if (this.b.b()) {
                        return b;
                    }
                    return null;
                }
                com.baidu.tieba.c.ae.c("PostThreadTask", "doInBackground", "image size is more than 100K");
                String a = com.baidu.tieba.c.ad.a(com.baidu.tieba.c.o.a(c));
                com.baidu.tieba.a.e n = com.baidu.tieba.c.k.n(a);
                if (n == null) {
                    com.baidu.tieba.c.ae.c("PostThreadTask", "doInBackground", "upload data is null");
                    com.baidu.tieba.a.e eVar2 = new com.baidu.tieba.a.e();
                    eVar2.a(a);
                    eVar2.a(0);
                    eVar2.a(c.length());
                    eVar = eVar2;
                } else {
                    eVar = n;
                }
                this.d = new com.baidu.tieba.c.f("tieba_head_image", eVar, "http://c.tieba.baidu.com/c/c/img/chunkupload");
                this.c = this.d.b();
                if (this.c.a()) {
                    this.b = new com.baidu.tieba.c.t("http://c.tieba.baidu.com/c/c/img/finupload");
                    this.b.a("md5", eVar.a());
                    String i = this.b.i();
                    if (i != null && this.b.b()) {
                        com.baidu.tieba.c.k.m(a);
                        return i;
                    }
                    long b2 = eVar.b();
                    eVar.a((int) (b2 % 102400 == 0 ? b2 / 102400 : (b2 / 102400) + 1));
                    com.baidu.tieba.c.k.a(eVar);
                    return null;
                }
                return null;
            } catch (Exception e2) {
                e = e2;
                com.baidu.tieba.c.ae.b(getClass().getName(), "doInBackground", e.getMessage());
                return str;
            }
        } catch (Exception e3) {
            str = 0;
            e = e3;
        }
    }

    public void a() {
        this.a.c();
        this.a.t = null;
        if (this.b != null) {
            this.b.g();
        }
        super.cancel(true);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a */
    public void onPostExecute(String str) {
        this.a.c();
        if (this.b != null) {
            if (!this.b.b()) {
                this.a.b(this.b.f());
                return;
            }
            this.a.setResult(-1);
            this.a.finish();
            this.a.b(this.a.getString(R.string.upload_head_ok));
        }
    }

    @Override // android.os.AsyncTask
    protected void onPreExecute() {
        this.a.a(this.a.getString(R.string.upload_head));
    }
}
