package com.baidu.tieba.person;

import android.content.DialogInterface;
import android.content.Intent;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tieba.util.DatabaseService;
import com.slidingmenu.lib.R;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ax extends BdAsyncTask {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ PersonChangeActivity f1581a;
    private com.baidu.tieba.util.u b = null;
    private com.baidu.tieba.model.bm c;

    public ax(PersonChangeActivity personChangeActivity, com.baidu.tieba.model.bm bmVar) {
        this.f1581a = personChangeActivity;
        this.c = null;
        this.c = bmVar;
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        this.f1581a.C = null;
        if (this.b != null) {
            this.b.i();
        }
        super.cancel(true);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void a(String str) {
        this.f1581a.C = null;
        this.f1581a.h();
        if (this.b != null) {
            if (this.b.d()) {
                this.f1581a.a(this.f1581a.getString(R.string.success));
                Intent intent = new Intent();
                intent.putExtra("data", this.c.a());
                this.f1581a.setResult(-1, intent);
                this.f1581a.finish();
            } else {
                this.f1581a.a(this.b.h());
            }
        }
        super.a((Object) str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void b() {
        DialogInterface.OnCancelListener onCancelListener;
        PersonChangeActivity personChangeActivity = this.f1581a;
        String string = this.f1581a.getString(R.string.saving);
        onCancelListener = this.f1581a.E;
        personChangeActivity.a(string, onCancelListener);
        super.b();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public String a(String... strArr) {
        if (this.c != null) {
            this.b = new com.baidu.tieba.util.u(String.valueOf(com.baidu.tieba.data.g.f1011a) + "c/c/profile/modify");
            this.b.a("sex", String.valueOf(this.c.a().getSex()));
            this.b.a("intro", this.c.a().getIntro());
            this.b.m();
            if (this.b.d()) {
                DatabaseService.h();
            }
        }
        return null;
    }
}
