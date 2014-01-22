package com.baidu.tieba.person;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.slidingmenu.lib.R;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class x extends BdAsyncTask<String, Integer, String> {
    final /* synthetic */ EditHeadActivity a;
    private com.baidu.tieba.util.ax b;

    private x(EditHeadActivity editHeadActivity) {
        this.a = editHeadActivity;
        this.b = null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ x(EditHeadActivity editHeadActivity, l lVar) {
        this(editHeadActivity);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void b() {
        this.a.showLoadingDialog(this.a.getString(R.string.upload_head));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public String a(String... strArr) {
        String str;
        Exception e;
        this.b = new com.baidu.tieba.util.ax(com.baidu.tieba.data.h.a + "c/c/img/portrait");
        try {
            str = this.b.b("tieba_head_image");
        } catch (Exception e2) {
            str = null;
            e = e2;
        }
        try {
            if (this.b.d()) {
                return str;
            }
            return null;
        } catch (Exception e3) {
            e = e3;
            com.baidu.adp.lib.g.e.b(getClass().getName(), "doInBackground", e.getMessage());
            return str;
        }
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        this.a.closeLoadingDialog();
        this.a.u = null;
        if (this.b != null) {
            this.b.k();
        }
        super.cancel(true);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void a(String str) {
        this.a.closeLoadingDialog();
        if (this.b != null) {
            if (this.b.d()) {
                this.a.setResult(-1);
                this.a.finish();
                this.a.showToast(this.a.getString(R.string.upload_head_ok));
                return;
            }
            this.a.showToast(this.b.j());
        }
    }
}
