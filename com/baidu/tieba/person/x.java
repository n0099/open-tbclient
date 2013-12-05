package com.baidu.tieba.person;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.slidingmenu.lib.R;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class x extends BdAsyncTask<String, Integer, String> {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ EditHeadActivity f2397a;
    private com.baidu.tieba.util.am b;
    private com.baidu.tieba.data.f c;
    private com.baidu.tieba.util.n d;

    private x(EditHeadActivity editHeadActivity) {
        this.f2397a = editHeadActivity;
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
        this.f2397a.showLoadingDialog(this.f2397a.getString(R.string.upload_head));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public String a(String... strArr) {
        String str;
        Exception e;
        this.b = new com.baidu.tieba.util.am(com.baidu.tieba.data.h.f1248a + "c/c/img/portrait");
        try {
            str = this.b.b("tieba_head_image");
        } catch (Exception e2) {
            str = null;
            e = e2;
        }
        try {
            if (this.b.c()) {
                return str;
            }
            return null;
        } catch (Exception e3) {
            e = e3;
            com.baidu.tieba.util.bd.b(getClass().getName(), "doInBackground", e.getMessage());
            return str;
        }
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        this.f2397a.closeLoadingDialog();
        this.f2397a.v = null;
        if (this.b != null) {
            this.b.j();
        }
        super.cancel(true);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void a(String str) {
        this.f2397a.closeLoadingDialog();
        if (this.b != null) {
            if (this.b.c()) {
                this.f2397a.setResult(-1);
                this.f2397a.finish();
                this.f2397a.showToast(this.f2397a.getString(R.string.upload_head_ok));
                return;
            }
            this.f2397a.showToast(this.b.i());
        }
    }
}
