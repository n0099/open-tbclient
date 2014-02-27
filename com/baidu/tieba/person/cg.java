package com.baidu.tieba.person;

import android.content.DialogInterface;
import android.content.Intent;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.util.DatabaseService;
import com.slidingmenu.lib.R;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class cg extends BdAsyncTask<String, Integer, String> {
    final /* synthetic */ PersonChangeActivity a;
    private com.baidu.tieba.util.ba b = null;
    private com.baidu.tieba.model.bo c;

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object[]] */
    /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public final /* synthetic */ String a(String... strArr) {
        if (this.c != null) {
            this.b = new com.baidu.tieba.util.ba(String.valueOf(com.baidu.tieba.data.i.a) + "c/c/profile/modify");
            this.b.a("sex", String.valueOf(this.c.a().getSex()));
            this.b.a("intro", this.c.a().getIntro());
            this.b.m();
            if (this.b.c()) {
                DatabaseService.d();
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
        this.a.z = null;
        this.a.closeLoadingDialog();
        if (this.b != null) {
            if (this.b.c()) {
                this.a.showToast(this.a.getString(R.string.success));
                Intent intent = new Intent();
                bool = this.a.b;
                if (bool.booleanValue()) {
                    intent.putExtra("person_change_data", this.c.a());
                } else {
                    intent.putExtra("data", this.c.a());
                }
                TiebaApplication.g().a(this.c.a());
                this.a.setResult(-1, intent);
                this.a.finish();
            } else {
                this.a.showToast(this.b.i());
            }
        }
        super.a((cg) str2);
    }

    public cg(PersonChangeActivity personChangeActivity, com.baidu.tieba.model.bo boVar) {
        this.a = personChangeActivity;
        this.c = null;
        this.c = boVar;
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public final void cancel() {
        this.a.z = null;
        if (this.b != null) {
            this.b.j();
        }
        super.cancel(true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public final void b() {
        DialogInterface.OnCancelListener onCancelListener;
        PersonChangeActivity personChangeActivity = this.a;
        String string = this.a.getString(R.string.saving);
        onCancelListener = this.a.B;
        personChangeActivity.showLoadingDialog(string, onCancelListener);
        super.b();
    }
}
