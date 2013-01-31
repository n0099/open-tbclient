package com.baidu.tieba.person;

import android.os.AsyncTask;
import com.baidu.tieba.R;
import java.io.File;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class v extends AsyncTask {
    final /* synthetic */ EditHeadActivity a;
    private com.baidu.tieba.c.t b;
    private com.baidu.tieba.a.g c;
    private com.baidu.tieba.c.f d;

    private v(EditHeadActivity editHeadActivity) {
        this.a = editHeadActivity;
        this.b = null;
        this.c = null;
        this.d = null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ v(EditHeadActivity editHeadActivity, v vVar) {
        this(editHeadActivity);
    }

    @Override // android.os.AsyncTask
    protected void onPreExecute() {
        this.a.a(this.a.getString(R.string.upload_head));
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
        com.baidu.tieba.a.f fVar;
        long j;
        this.b = new com.baidu.tieba.c.t("http://c.tieba.baidu.com/c/c/img/portrait");
        try {
            File c = com.baidu.tieba.c.o.c("tieba_head_image");
            str = (c.length() > 102400L ? 1 : (c.length() == 102400L ? 0 : -1));
            try {
                if (str <= 0 || (com.baidu.tieba.a.i.j() == 0 && this.b.e() != null && !this.b.e().equals("2"))) {
                    com.baidu.tieba.c.af.e("PostThreadTask", "doInBackground", "image size is less than 100K");
                    String b = this.b.b("tieba_head_image");
                    if (this.b.b()) {
                        return b;
                    }
                    return null;
                }
                com.baidu.tieba.c.af.e("PostThreadTask", "doInBackground", "image size is more than 100K");
                String a = com.baidu.tieba.c.ae.a(com.baidu.tieba.c.o.a(c));
                com.baidu.tieba.a.f o = com.baidu.tieba.c.k.o(a);
                if (o == null) {
                    com.baidu.tieba.c.af.e("PostThreadTask", "doInBackground", "upload data is null");
                    com.baidu.tieba.a.f fVar2 = new com.baidu.tieba.a.f();
                    fVar2.a(a);
                    fVar2.a(0);
                    fVar2.a(c.length());
                    fVar = fVar2;
                } else {
                    fVar = o;
                }
                this.d = new com.baidu.tieba.c.f("tieba_head_image", fVar, "http://c.tieba.baidu.com/c/c/img/chunkupload");
                this.c = this.d.b();
                if (this.c.a()) {
                    this.b = new com.baidu.tieba.c.t("http://c.tieba.baidu.com/c/c/img/finupload");
                    this.b.a("md5", fVar.a());
                    String i = this.b.i();
                    if (i == null || !this.b.b()) {
                        long b2 = fVar.b();
                        if (b2 % 102400 == 0) {
                            j = b2 / 102400;
                        } else {
                            j = (b2 / 102400) + 1;
                        }
                        fVar.a((int) j);
                        com.baidu.tieba.c.k.a(fVar);
                        return null;
                    }
                    com.baidu.tieba.c.k.n(a);
                    return i;
                }
                return null;
            } catch (Exception e2) {
                e = e2;
                com.baidu.tieba.c.af.b(getClass().getName(), "doInBackground", e.getMessage());
                return str;
            }
        } catch (Exception e3) {
            str = 0;
            e = e3;
        }
    }

    public void a() {
        this.a.d();
        this.a.u = null;
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
        this.a.d();
        if (this.b != null) {
            if (this.b.b()) {
                this.a.setResult(-1);
                this.a.finish();
                this.a.b(this.a.getString(R.string.upload_head_ok));
                return;
            }
            this.a.b(this.b.f());
        }
    }
}
