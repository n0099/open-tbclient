package com.baidu.tieba.person;

import android.content.DialogInterface;
import android.content.Intent;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class al implements DialogInterface.OnClickListener {
    final /* synthetic */ PersonChangeActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public al(PersonChangeActivity personChangeActivity) {
        this.a = personChangeActivity;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        com.baidu.tieba.b.q qVar;
        com.baidu.tieba.b.q qVar2;
        qVar = this.a.z;
        if (qVar.d()) {
            Intent intent = new Intent();
            qVar2 = this.a.z;
            intent.putExtra("data", qVar2);
            this.a.setResult(-1, intent);
        }
        this.a.finish();
    }
}
