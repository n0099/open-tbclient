package com.baidu.tieba.person;

import com.slidingmenu.lib.R;
import java.io.File;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class v extends com.baidu.adp.lib.a.a {
    final /* synthetic */ EditHeadActivity a;
    private com.baidu.tieba.d.t b;
    private com.baidu.tieba.a.g c;
    private com.baidu.tieba.d.e d;

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

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.a.a
    public void b() {
        this.a.b(this.a.getString(R.string.upload_head));
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:32:0x0128 */
    /* JADX DEBUG: Method merged with bridge method */
    /* JADX DEBUG: Multi-variable search result rejected for r0v3, resolved type: java.lang.String */
    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v2 */
    /* JADX WARN: Type inference failed for: r0v5, types: [int] */
    @Override // com.baidu.adp.lib.a.a
    public String a(String... strArr) {
        String str;
        Exception e;
        File c;
        com.baidu.tieba.a.f fVar;
        long j;
        this.b = new com.baidu.tieba.d.t(String.valueOf(com.baidu.tieba.a.i.e) + "c/c/img/portrait");
        try {
            c = com.baidu.tieba.d.o.c("tieba_head_image");
            str = (c.length() > 102400L ? 1 : (c.length() == 102400L ? 0 : -1));
        } catch (Exception e2) {
            str = 0;
            e = e2;
        }
        try {
            if (str <= 0 || (com.baidu.tieba.a.i.m() == 0 && this.b.e() != null && !this.b.e().equals("2"))) {
                com.baidu.tieba.d.ae.e("PostThreadTask", "doInBackground", "image size is less than 100K");
                String b = this.b.b("tieba_head_image");
                if (this.b.b()) {
                    return b;
                }
                return null;
            }
            com.baidu.tieba.d.ae.e("PostThreadTask", "doInBackground", "image size is more than 100K");
            String a = com.baidu.tieba.d.ad.a(com.baidu.tieba.d.o.a(c));
            com.baidu.tieba.a.f n = com.baidu.tieba.d.k.n(a);
            if (n == null) {
                com.baidu.tieba.d.ae.e("PostThreadTask", "doInBackground", "upload data is null");
                com.baidu.tieba.a.f fVar2 = new com.baidu.tieba.a.f();
                fVar2.a(a);
                fVar2.a(0);
                fVar2.a(c.length());
                fVar = fVar2;
            } else {
                fVar = n;
            }
            this.d = new com.baidu.tieba.d.e("tieba_head_image", fVar, String.valueOf(com.baidu.tieba.a.i.e) + "c/c/img/chunkupload");
            this.c = this.d.b();
            if (this.c.a()) {
                this.b = new com.baidu.tieba.d.t(String.valueOf(com.baidu.tieba.a.i.e) + "c/c/img/finupload");
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
                    com.baidu.tieba.d.k.a(fVar);
                    return null;
                }
                com.baidu.tieba.d.k.m(a);
                return i;
            }
            return null;
        } catch (Exception e3) {
            e = e3;
            com.baidu.tieba.d.ae.b(getClass().getName(), "doInBackground", e.getMessage());
            return str;
        }
    }

    @Override // com.baidu.adp.lib.a.a
    public void cancel() {
        this.a.h();
        this.a.u = null;
        if (this.b != null) {
            this.b.g();
        }
        super.cancel(true);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.a.a
    public void a(String str) {
        this.a.h();
        if (this.b != null) {
            if (this.b.b()) {
                this.a.setResult(-1);
                this.a.finish();
                this.a.a(this.a.getString(R.string.upload_head_ok));
                return;
            }
            this.a.a(this.b.f());
        }
    }
}
