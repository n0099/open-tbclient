package com.baidu.tieba.person;

import android.content.DialogInterface;
import android.content.Intent;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tieba.model.bw;
import com.baidu.tieba.util.DatabaseService;
import com.slidingmenu.lib.R;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ay extends BdAsyncTask<String, Integer, String> {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ PersonChangeActivity f2215a;
    private com.baidu.tieba.util.ap b = null;
    private bw c;

    public ay(PersonChangeActivity personChangeActivity, bw bwVar) {
        this.f2215a = personChangeActivity;
        this.c = null;
        this.c = bwVar;
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        this.f2215a.B = null;
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
        this.f2215a.B = null;
        this.f2215a.closeLoadingDialog();
        if (this.b != null) {
            if (this.b.c()) {
                this.f2215a.showToast(this.f2215a.getString(R.string.success));
                Intent intent = new Intent();
                bool = this.f2215a.b;
                if (bool.booleanValue()) {
                    intent.putExtra("person_change_data", this.c.a());
                } else {
                    intent.putExtra("data", this.c.a());
                }
                this.f2215a.setResult(-1, intent);
                this.f2215a.finish();
            } else {
                this.f2215a.showToast(this.b.i());
            }
        }
        super.a((ay) str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void b() {
        DialogInterface.OnCancelListener onCancelListener;
        PersonChangeActivity personChangeActivity = this.f2215a;
        String string = this.f2215a.getString(R.string.saving);
        onCancelListener = this.f2215a.D;
        personChangeActivity.showLoadingDialog(string, onCancelListener);
        super.b();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public String a(String... strArr) {
        if (this.c != null) {
            this.b = new com.baidu.tieba.util.ap(com.baidu.tieba.data.h.f1201a + "c/c/profile/modify");
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
