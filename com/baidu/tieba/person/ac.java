package com.baidu.tieba.person;

import android.content.DialogInterface;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ac implements DialogInterface.OnCancelListener {
    final /* synthetic */ PersonChangeActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ac(PersonChangeActivity personChangeActivity) {
        this.a = personChangeActivity;
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialogInterface) {
        al alVar;
        al alVar2;
        this.a.b();
        alVar = this.a.s;
        if (alVar != null) {
            alVar2 = this.a.s;
            alVar2.a();
        }
    }
}
