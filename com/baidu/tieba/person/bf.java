package com.baidu.tieba.person;

import android.content.DialogInterface;
import android.content.Intent;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.util.DatabaseService;
import com.slidingmenu.lib.R;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bf extends BdAsyncTask<String, Integer, String> {
    final /* synthetic */ PersonChangeActivity a;
    private com.baidu.tieba.util.ax b = null;
    private com.baidu.tieba.model.bw c;

    public bf(PersonChangeActivity personChangeActivity, com.baidu.tieba.model.bw bwVar) {
        this.a = personChangeActivity;
        this.c = null;
        this.c = bwVar;
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        this.a.B = null;
        if (this.b != null) {
            this.b.k();
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
            if (this.b.d()) {
                this.a.showToast(this.a.getString(R.string.success));
                Intent intent = new Intent();
                bool = this.a.b;
                if (bool.booleanValue()) {
                    intent.putExtra("person_change_data", this.c.a());
                } else {
                    intent.putExtra("data", this.c.a());
                }
                TiebaApplication.h().a(this.c.a());
                this.a.setResult(-1, intent);
                this.a.finish();
            } else {
                this.a.showToast(this.b.j());
            }
        }
        super.a((bf) str);
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
            this.b = new com.baidu.tieba.util.ax(com.baidu.tieba.data.h.a + "c/c/profile/modify");
            this.b.a("sex", String.valueOf(this.c.a().getSex()));
            this.b.a("intro", this.c.a().getIntro());
            this.b.o();
            if (this.b.d()) {
                DatabaseService.f();
            }
        }
        return null;
    }
}
