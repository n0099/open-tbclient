package com.baidu.tieba.person;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.slidingmenu.lib.R;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class x extends BdAsyncTask<String, Integer, String> {
    final /* synthetic */ EditHeadActivity a;
    private com.baidu.tieba.util.at b;
    private com.baidu.tieba.data.f c;
    private com.baidu.tieba.util.n d;

    private x(EditHeadActivity editHeadActivity) {
        this.a = editHeadActivity;
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
        this.a.showLoadingDialog(this.a.getString(R.string.upload_head));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public String a(String... strArr) {
        String str;
        Exception e;
        this.b = new com.baidu.tieba.util.at(com.baidu.tieba.data.h.a + "c/c/img/portrait");
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
            com.baidu.tieba.util.bo.b(getClass().getName(), "doInBackground", e.getMessage());
            return str;
        }
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        this.a.closeLoadingDialog();
        this.a.v = null;
        if (this.b != null) {
            this.b.j();
        }
        super.cancel(true);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void a(String str) {
        this.a.closeLoadingDialog();
        if (this.b != null) {
            if (this.b.c()) {
                this.a.setResult(-1);
                this.a.finish();
                this.a.showToast(this.a.getString(R.string.upload_head_ok));
                return;
            }
            this.a.showToast(this.b.i());
        }
    }
}
