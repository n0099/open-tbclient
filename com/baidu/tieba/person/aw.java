package com.baidu.tieba.person;

import android.content.DialogInterface;
import android.content.Intent;
import com.slidingmenu.lib.R;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aw extends com.baidu.adp.lib.a.a {
    final /* synthetic */ PersonChangeActivity a;
    private com.baidu.tieba.d.t b = null;
    private com.baidu.tieba.c.be c;

    public aw(PersonChangeActivity personChangeActivity, com.baidu.tieba.c.be beVar) {
        this.a = personChangeActivity;
        this.c = null;
        this.c = beVar;
    }

    @Override // com.baidu.adp.lib.a.a
    public void cancel() {
        this.a.C = null;
        if (this.b != null) {
            this.b.g();
        }
        super.cancel(true);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.a.a
    public void a(String str) {
        this.a.C = null;
        this.a.h();
        if (this.b != null) {
            if (this.b.b()) {
                this.a.a(this.a.getString(R.string.success));
                Intent intent = new Intent();
                intent.putExtra("data", this.c.d());
                this.a.setResult(-1, intent);
                this.a.finish();
            } else {
                this.a.a(this.b.f());
            }
        }
        super.a((Object) str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.a.a
    public void b() {
        DialogInterface.OnCancelListener onCancelListener;
        PersonChangeActivity personChangeActivity = this.a;
        String string = this.a.getString(R.string.saving);
        onCancelListener = this.a.E;
        personChangeActivity.a(string, onCancelListener);
        super.b();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.a.a
    public String a(String... strArr) {
        if (this.c != null) {
            this.b = new com.baidu.tieba.d.t(String.valueOf(com.baidu.tieba.a.i.e) + "c/c/profile/modify");
            this.b.a("sex", String.valueOf(this.c.d().b()));
            this.b.a("intro", this.c.d().a());
            this.b.j();
            if (this.b.b()) {
                com.baidu.tieba.d.k.e();
            }
        }
        return null;
    }
}
