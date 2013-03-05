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
        com.baidu.tieba.b.r rVar;
        com.baidu.tieba.b.r rVar2;
        rVar = this.a.z;
        if (rVar.d()) {
            Intent intent = new Intent();
            rVar2 = this.a.z;
            intent.putExtra("data", rVar2);
            this.a.setResult(-1, intent);
        }
        this.a.finish();
    }
}
