package com.baidu.tieba.person;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tieba.util.DatabaseService;
import com.slidingmenu.lib.R;
import java.io.File;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class w extends BdAsyncTask {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ EditHeadActivity f1663a;
    private com.baidu.tieba.util.v b;
    private com.baidu.tieba.data.e c;
    private com.baidu.tieba.util.f d;

    private w(EditHeadActivity editHeadActivity) {
        this.f1663a = editHeadActivity;
        this.b = null;
        this.c = null;
        this.d = null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ w(EditHeadActivity editHeadActivity, w wVar) {
        this(editHeadActivity);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void b() {
        this.f1663a.b(this.f1663a.getString(R.string.upload_head));
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:32:0x0128 */
    /* JADX DEBUG: Method merged with bridge method */
    /* JADX DEBUG: Multi-variable search result rejected for r0v3, resolved type: java.lang.String */
    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v2 */
    /* JADX WARN: Type inference failed for: r0v5, types: [int] */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public String a(String... strArr) {
        String str;
        Exception e;
        File c;
        com.baidu.tieba.data.d dVar;
        long j;
        this.b = new com.baidu.tieba.util.v(String.valueOf(com.baidu.tieba.data.g.f1014a) + "c/c/img/portrait");
        try {
            c = com.baidu.tieba.util.p.c("tieba_head_image");
            str = (c.length() > 102400L ? 1 : (c.length() == 102400L ? 0 : -1));
        } catch (Exception e2) {
            str = 0;
            e = e2;
        }
        try {
            if (str <= 0 || (com.baidu.tieba.data.g.n() == 0 && this.b.f() != null && !this.b.f().equals("2"))) {
                com.baidu.tieba.util.aq.e("PostThreadTask", "doInBackground", "image size is less than 100K");
                String b = this.b.b("tieba_head_image");
                if (this.b.c()) {
                    return b;
                }
                return null;
            }
            com.baidu.tieba.util.aq.e("PostThreadTask", "doInBackground", "image size is more than 100K");
            String a2 = com.baidu.tieba.util.ap.a(com.baidu.tieba.util.p.a(c));
            com.baidu.tieba.data.d o = DatabaseService.o(a2);
            if (o == null) {
                com.baidu.tieba.util.aq.e("PostThreadTask", "doInBackground", "upload data is null");
                com.baidu.tieba.data.d dVar2 = new com.baidu.tieba.data.d();
                dVar2.a(a2);
                dVar2.a(0);
                dVar2.a(c.length());
                dVar = dVar2;
            } else {
                dVar = o;
            }
            this.d = new com.baidu.tieba.util.f("tieba_head_image", dVar, String.valueOf(com.baidu.tieba.data.g.f1014a) + "c/c/img/chunkupload");
            this.c = this.d.b();
            if (this.c.a()) {
                this.b = new com.baidu.tieba.util.v(String.valueOf(com.baidu.tieba.data.g.f1014a) + "c/c/img/finupload");
                this.b.a("md5", dVar.a());
                String j2 = this.b.j();
                if (j2 == null || !this.b.c()) {
                    long b2 = dVar.b();
                    if (b2 % 102400 == 0) {
                        j = b2 / 102400;
                    } else {
                        j = (b2 / 102400) + 1;
                    }
                    dVar.a((int) j);
                    DatabaseService.a(dVar);
                    return null;
                }
                DatabaseService.n(a2);
                return j2;
            }
            return null;
        } catch (Exception e3) {
            e = e3;
            com.baidu.tieba.util.aq.b(getClass().getName(), "doInBackground", e.getMessage());
            return str;
        }
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        this.f1663a.h();
        this.f1663a.u = null;
        if (this.b != null) {
            this.b.h();
        }
        super.cancel(true);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void a(String str) {
        this.f1663a.h();
        if (this.b != null) {
            if (this.b.c()) {
                this.f1663a.setResult(-1);
                this.f1663a.finish();
                this.f1663a.a(this.f1663a.getString(R.string.upload_head_ok));
                return;
            }
            this.f1663a.a(this.b.g());
        }
    }
}
