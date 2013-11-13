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
    final /* synthetic */ PersonChangeActivity f2230a;
    private com.baidu.tieba.util.ap b = null;
    private bw c;

    public ay(PersonChangeActivity personChangeActivity, bw bwVar) {
        this.f2230a = personChangeActivity;
        this.c = null;
        this.c = bwVar;
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        this.f2230a.B = null;
        if (this.b != null) {
            this.b.h();
        }
        super.cancel(true);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void a(String str) {
        Boolean bool;
        this.f2230a.B = null;
        this.f2230a.closeLoadingDialog();
        if (this.b != null) {
            if (this.b.c()) {
                this.f2230a.showToast(this.f2230a.getString(R.string.success));
                Intent intent = new Intent();
                bool = this.f2230a.b;
                if (bool.booleanValue()) {
                    intent.putExtra("person_change_data", this.c.a());
                } else {
                    intent.putExtra("data", this.c.a());
                }
                this.f2230a.setResult(-1, intent);
                this.f2230a.finish();
            } else {
                this.f2230a.showToast(this.b.g());
            }
        }
        super.a((ay) str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void b() {
        DialogInterface.OnCancelListener onCancelListener;
        PersonChangeActivity personChangeActivity = this.f2230a;
        String string = this.f2230a.getString(R.string.saving);
        onCancelListener = this.f2230a.D;
        personChangeActivity.showLoadingDialog(string, onCancelListener);
        super.b();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public String a(String... strArr) {
        if (this.c != null) {
            this.b = new com.baidu.tieba.util.ap(com.baidu.tieba.data.h.f1196a + "c/c/profile/modify");
            this.b.a("sex", String.valueOf(this.c.a().getSex()));
            this.b.a("intro", this.c.a().getIntro());
            this.b.l();
            if (this.b.c()) {
                DatabaseService.f();
            }
        }
        return null;
    }
}
