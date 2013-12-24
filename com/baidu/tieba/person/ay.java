package com.baidu.tieba.person;

import android.content.DialogInterface;
import android.content.Intent;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tieba.util.DatabaseService;
import com.slidingmenu.lib.R;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ay extends BdAsyncTask<String, Integer, String> {
    final /* synthetic */ PersonChangeActivity a;
    private com.baidu.tieba.util.an b = null;
    private com.baidu.tieba.model.bw c;

    public ay(PersonChangeActivity personChangeActivity, com.baidu.tieba.model.bw bwVar) {
        this.a = personChangeActivity;
        this.c = null;
        this.c = bwVar;
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        this.a.B = null;
        if (this.b != null) {
            this.b.j();
        }
        super.cancel(true);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void a(String str) {
        Boolean bool;
        this.a.B = null;
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
                this.a.setResult(-1, intent);
                this.a.finish();
            } else {
                this.a.showToast(this.b.i());
            }
        }
        super.a((ay) str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void b() {
        DialogInterface.OnCancelListener onCancelListener;
        PersonChangeActivity personChangeActivity = this.a;
        String string = this.a.getString(R.string.saving);
        onCancelListener = this.a.D;
        personChangeActivity.showLoadingDialog(string, onCancelListener);
        super.b();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public String a(String... strArr) {
        if (this.c != null) {
            this.b = new com.baidu.tieba.util.an(com.baidu.tieba.data.h.a + "c/c/profile/modify");
            this.b.a("sex", String.valueOf(this.c.a().getSex()));
            this.b.a("intro", this.c.a().getIntro());
            this.b.n();
            if (this.b.c()) {
                DatabaseService.f();
            }
        }
        return null;
    }
}
