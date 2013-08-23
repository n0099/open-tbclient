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
    final /* synthetic */ PersonChangeActivity f1619a;
    private com.baidu.tieba.util.v b = null;
    private com.baidu.tieba.model.bl c;

    public ax(PersonChangeActivity personChangeActivity, com.baidu.tieba.model.bl blVar) {
        this.f1619a = personChangeActivity;
        this.c = null;
        this.c = blVar;
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        this.f1619a.D = null;
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
        this.f1619a.D = null;
        this.f1619a.h();
        if (this.b != null) {
            if (this.b.c()) {
                this.f1619a.a(this.f1619a.getString(R.string.success));
                Intent intent = new Intent();
                bool = this.f1619a.f1592a;
                if (bool.booleanValue()) {
                    intent.putExtra("person_change_data", this.c.a());
                } else {
                    intent.putExtra("data", this.c.a());
                }
                this.f1619a.setResult(-1, intent);
                this.f1619a.finish();
            } else {
                this.f1619a.a(this.b.g());
            }
        }
        super.a((Object) str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void b() {
        DialogInterface.OnCancelListener onCancelListener;
        PersonChangeActivity personChangeActivity = this.f1619a;
        String string = this.f1619a.getString(R.string.saving);
        onCancelListener = this.f1619a.F;
        personChangeActivity.a(string, onCancelListener);
        super.b();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public String a(String... strArr) {
        if (this.c != null) {
            this.b = new com.baidu.tieba.util.v(String.valueOf(com.baidu.tieba.data.g.f1014a) + "c/c/profile/modify");
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
