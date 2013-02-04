package com.baidu.tieba.person;

import android.content.DialogInterface;
import android.content.Intent;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aa implements DialogInterface.OnClickListener {
    final /* synthetic */ PersonChangeActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aa(PersonChangeActivity personChangeActivity) {
        this.a = personChangeActivity;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        com.baidu.tieba.b.o oVar;
        com.baidu.tieba.b.o oVar2;
        oVar = this.a.p;
        if (oVar.d()) {
            Intent intent = new Intent();
            oVar2 = this.a.p;
            intent.putExtra("data", oVar2);
            this.a.setResult(-1, intent);
        }
        this.a.finish();
    }
}
