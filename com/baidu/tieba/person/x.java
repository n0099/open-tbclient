package com.baidu.tieba.person;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.slidingmenu.lib.R;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class x extends BdAsyncTask<String, Integer, String> {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ EditHeadActivity f2279a;
    private com.baidu.tieba.util.ap b;
    private com.baidu.tieba.data.f c;
    private com.baidu.tieba.util.n d;

    private x(EditHeadActivity editHeadActivity) {
        this.f2279a = editHeadActivity;
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
        this.f2279a.showLoadingDialog(this.f2279a.getString(R.string.upload_head));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public String a(String... strArr) {
        String str;
        Exception e;
        this.b = new com.baidu.tieba.util.ap(com.baidu.tieba.data.h.f1201a + "c/c/img/portrait");
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
            com.baidu.tieba.util.bg.b(getClass().getName(), "doInBackground", e.getMessage());
            return str;
        }
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        this.f2279a.closeLoadingDialog();
        this.f2279a.v = null;
        if (this.b != null) {
            this.b.j();
        }
        super.cancel(true);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void a(String str) {
        this.f2279a.closeLoadingDialog();
        if (this.b != null) {
            if (this.b.c()) {
                this.f2279a.setResult(-1);
                this.f2279a.finish();
                this.f2279a.showToast(this.f2279a.getString(R.string.upload_head_ok));
                return;
            }
            this.f2279a.showToast(this.b.i());
        }
    }
}
