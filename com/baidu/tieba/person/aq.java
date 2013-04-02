package com.baidu.tieba.person;

import android.content.DialogInterface;
import android.content.Intent;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aq implements DialogInterface.OnClickListener {
    final /* synthetic */ PersonChangeActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aq(PersonChangeActivity personChangeActivity) {
        this.a = personChangeActivity;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        com.baidu.tieba.b.s sVar;
        com.baidu.tieba.b.s sVar2;
        sVar = this.a.z;
        if (sVar.d()) {
            Intent intent = new Intent();
            sVar2 = this.a.z;
            intent.putExtra("data", sVar2);
            this.a.setResult(-1, intent);
        }
        this.a.finish();
    }
}
