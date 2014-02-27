package com.baidu.tieba.person;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.slidingmenu.lib.R;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class aa extends BdAsyncTask<String, Integer, String> {
    final /* synthetic */ EditHeadActivity a;
    private com.baidu.tieba.util.ba b;

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object[]] */
    /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public final /* synthetic */ String a(String... strArr) {
        return d();
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public final /* synthetic */ void a(String str) {
        this.a.closeLoadingDialog();
        if (this.b != null) {
            if (!this.b.c()) {
                this.a.showToast(this.b.i());
                return;
            }
            this.a.setResult(-1);
            this.a.finish();
            this.a.showToast(this.a.getString(R.string.upload_head_ok));
        }
    }

    private aa(EditHeadActivity editHeadActivity) {
        this.a = editHeadActivity;
        this.b = null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ aa(EditHeadActivity editHeadActivity, byte b) {
        this(editHeadActivity);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public final void b() {
        this.a.showLoadingDialog(this.a.getString(R.string.upload_head));
    }

    private String d() {
        String str;
        Exception e;
        this.b = new com.baidu.tieba.util.ba(String.valueOf(com.baidu.tieba.data.i.a) + "c/c/img/portrait");
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
            com.baidu.adp.lib.util.e.b(getClass().getName(), "doInBackground", e.getMessage());
            return str;
        }
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public final void cancel() {
        this.a.closeLoadingDialog();
        this.a.u = null;
        if (this.b != null) {
            this.b.j();
        }
        super.cancel(true);
    }
}
