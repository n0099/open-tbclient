package com.baidu.tieba.person;

import android.content.DialogInterface;
import android.content.Intent;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class bh extends BdAsyncTask<String, Integer, String> {
    final /* synthetic */ PersonChangeActivity a;
    private com.baidu.tbadk.core.util.ak b = null;
    private com.baidu.tieba.model.au c;

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object[]] */
    /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public final /* synthetic */ String a(String... strArr) {
        if (this.c != null) {
            this.b = new com.baidu.tbadk.core.util.ak(String.valueOf(com.baidu.tbadk.core.data.n.a) + "c/c/profile/modify");
            this.b.a("sex", String.valueOf(this.c.a().getSex()));
            this.b.a("intro", this.c.a().getIntro());
            this.b.j();
            if (this.b.a().b().b()) {
                com.baidu.tieba.util.k.c();
                return null;
            }
            return null;
        }
        return null;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public final /* synthetic */ void a(String str) {
        Boolean bool;
        String str2 = str;
        this.a.x = null;
        this.a.closeLoadingDialog();
        if (this.b != null) {
            if (this.b.a().b().b()) {
                this.a.showToast(this.a.getString(com.baidu.tieba.a.k.success));
                Intent intent = new Intent();
                bool = this.a.b;
                if (bool.booleanValue()) {
                    intent.putExtra("person_change_data", this.c.a());
                } else {
                    intent.putExtra("data", this.c.a());
                }
                com.baidu.tieba.p.c().a(this.c.a());
                this.a.setResult(-1, intent);
                this.a.finish();
            } else {
                this.a.showToast(this.b.f());
            }
        }
        super.a((bh) str2);
    }

    public bh(PersonChangeActivity personChangeActivity, com.baidu.tieba.model.au auVar) {
        this.a = personChangeActivity;
        this.c = null;
        this.c = auVar;
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public final void cancel() {
        this.a.x = null;
        if (this.b != null) {
            this.b.g();
        }
        super.cancel(true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public final void c() {
        DialogInterface.OnCancelListener onCancelListener;
        PersonChangeActivity personChangeActivity = this.a;
        String string = this.a.getString(com.baidu.tieba.a.k.saving);
        onCancelListener = this.a.z;
        personChangeActivity.showLoadingDialog(string, onCancelListener);
        super.c();
    }
}
