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
    final /* synthetic */ PersonChangeActivity f1331a;
    private com.baidu.tieba.util.r b = null;
    private com.baidu.tieba.model.bh c;

    public ax(PersonChangeActivity personChangeActivity, com.baidu.tieba.model.bh bhVar) {
        this.f1331a = personChangeActivity;
        this.c = null;
        this.c = bhVar;
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        this.f1331a.C = null;
        if (this.b != null) {
            this.b.h();
        }
        super.cancel(true);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void a(String str) {
        this.f1331a.C = null;
        this.f1331a.h();
        if (this.b != null) {
            if (this.b.c()) {
                this.f1331a.a(this.f1331a.getString(R.string.success));
                Intent intent = new Intent();
                intent.putExtra("data", this.c.a());
                this.f1331a.setResult(-1, intent);
                this.f1331a.finish();
            } else {
                this.f1331a.a(this.b.g());
            }
        }
        super.a((Object) str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void b() {
        DialogInterface.OnCancelListener onCancelListener;
        PersonChangeActivity personChangeActivity = this.f1331a;
        String string = this.f1331a.getString(R.string.saving);
        onCancelListener = this.f1331a.E;
        personChangeActivity.a(string, onCancelListener);
        super.b();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public String a(String... strArr) {
        if (this.c != null) {
            this.b = new com.baidu.tieba.util.r(String.valueOf(com.baidu.tieba.data.g.f787a) + "c/c/profile/modify");
            this.b.a("sex", String.valueOf(this.c.a().getSex()));
            this.b.a("intro", this.c.a().getIntro());
            this.b.k();
            if (this.b.c()) {
                DatabaseService.h();
            }
        }
        return null;
    }
}
