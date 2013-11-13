package com.baidu.tieba.person;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tieba.util.DatabaseService;
import com.slidingmenu.lib.R;
import java.io.File;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class x extends BdAsyncTask<String, Integer, String> {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ EditHeadActivity f2294a;
    private com.baidu.tieba.util.ap b;
    private com.baidu.tieba.data.f c;
    private com.baidu.tieba.util.n d;

    private x(EditHeadActivity editHeadActivity) {
        this.f2294a = editHeadActivity;
        this.b = null;
        this.c = null;
        this.d = null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ x(EditHeadActivity editHeadActivity, l lVar) {
        this(editHeadActivity);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void b() {
        this.f2294a.showLoadingDialog(this.f2294a.getString(R.string.upload_head));
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
        File d;
        com.baidu.tieba.data.e eVar;
        this.b = new com.baidu.tieba.util.ap(com.baidu.tieba.data.h.f1196a + "c/c/img/portrait");
        try {
            d = com.baidu.tieba.util.af.d("tieba_head_image");
            str = (d.length() > 102400L ? 1 : (d.length() == 102400L ? 0 : -1));
        } catch (Exception e2) {
            str = 0;
            e = e2;
        }
        try {
            if (str <= 0 || (com.baidu.tieba.data.h.n() == 0 && this.b.f() != null && !this.b.f().equals("2"))) {
                com.baidu.tieba.util.bg.e("PostThreadTask", "doInBackground", "image size is less than 100K");
                String b = this.b.b("tieba_head_image");
                if (this.b.c()) {
                    return b;
                }
                return null;
            }
            com.baidu.tieba.util.bg.e("PostThreadTask", "doInBackground", "image size is more than 100K");
            String a2 = com.baidu.tieba.util.be.a(com.baidu.tieba.util.af.a(d));
            com.baidu.tieba.data.e p = DatabaseService.p(a2);
            if (p == null) {
                com.baidu.tieba.util.bg.e("PostThreadTask", "doInBackground", "upload data is null");
                com.baidu.tieba.data.e eVar2 = new com.baidu.tieba.data.e();
                eVar2.a(a2);
                eVar2.a(0);
                eVar2.a(d.length());
                eVar = eVar2;
            } else {
                eVar = p;
            }
            this.d = new com.baidu.tieba.util.n("tieba_head_image", eVar, com.baidu.tieba.data.h.f1196a + "c/c/img/chunkupload");
            this.c = this.d.b();
            if (this.c.b()) {
                this.b = new com.baidu.tieba.util.ap(com.baidu.tieba.data.h.f1196a + "c/c/img/finupload");
                this.b.a("md5", eVar.a());
                String j = this.b.j();
                if (j == null || !this.b.c()) {
                    long b2 = eVar.b();
                    eVar.a((int) (b2 % 102400 == 0 ? b2 / 102400 : (b2 / 102400) + 1));
                    DatabaseService.a(eVar);
                    return null;
                }
                DatabaseService.o(a2);
                return j;
            }
            return null;
        } catch (Exception e3) {
            e = e3;
            com.baidu.tieba.util.bg.b(getClass().getName(), "doInBackground", e.getMessage());
            return str;
        }
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        this.f2294a.closeLoadingDialog();
        this.f2294a.v = null;
        if (this.b != null) {
            this.b.h();
        }
        super.cancel(true);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void a(String str) {
        this.f2294a.closeLoadingDialog();
        if (this.b != null) {
            if (this.b.c()) {
                this.f2294a.setResult(-1);
                this.f2294a.finish();
                this.f2294a.showToast(this.f2294a.getString(R.string.upload_head_ok));
                return;
            }
            this.f2294a.showToast(this.b.g());
        }
    }
}
