package com.baidu.tieba.person;

import android.content.DialogInterface;
import android.content.Intent;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tieba.util.DatabaseService;
import com.slidingmenu.lib.R;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aw extends BdAsyncTask<String, Integer, String> {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ PersonChangeActivity f1668a;
    private com.baidu.tieba.util.z b = null;
    private com.baidu.tieba.model.bn c;

    public aw(PersonChangeActivity personChangeActivity, com.baidu.tieba.model.bn bnVar) {
        this.f1668a = personChangeActivity;
        this.c = null;
        this.c = bnVar;
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        this.f1668a.D = null;
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
        this.f1668a.D = null;
        this.f1668a.i();
        if (this.b != null) {
            if (this.b.c()) {
                this.f1668a.a(this.f1668a.getString(R.string.success));
                Intent intent = new Intent();
                bool = this.f1668a.b;
                if (bool.booleanValue()) {
                    intent.putExtra("person_change_data", this.c.a());
                } else {
                    intent.putExtra("data", this.c.a());
                }
                this.f1668a.setResult(-1, intent);
                this.f1668a.finish();
            } else {
                this.f1668a.a(this.b.g());
            }
        }
        super.a((aw) str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void b() {
        DialogInterface.OnCancelListener onCancelListener;
        PersonChangeActivity personChangeActivity = this.f1668a;
        String string = this.f1668a.getString(R.string.saving);
        onCancelListener = this.f1668a.F;
        personChangeActivity.a(string, onCancelListener);
        super.b();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public String a(String... strArr) {
        if (this.c != null) {
            this.b = new com.baidu.tieba.util.z(String.valueOf(com.baidu.tieba.data.g.f1032a) + "c/c/profile/modify");
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
