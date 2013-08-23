package com.baidu.tieba.person;

import android.content.DialogInterface;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ao implements DialogInterface.OnCancelListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ PersonChangeActivity f1610a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ao(PersonChangeActivity personChangeActivity) {
        this.f1610a = personChangeActivity;
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialogInterface) {
        ax axVar;
        ax axVar2;
        this.f1610a.g();
        axVar = this.f1610a.D;
        if (axVar != null) {
            axVar2 = this.f1610a.D;
            axVar2.cancel();
        }
    }
}
