package com.baidu.tieba.write;

import android.content.DialogInterface;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ad implements DialogInterface.OnCancelListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ WriteActivity f2778a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ad(WriteActivity writeActivity) {
        this.f2778a = writeActivity;
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialogInterface) {
        ao aoVar;
        ao aoVar2;
        this.f2778a.DeinitWaitingDialog();
        aoVar = this.f2778a.o;
        if (aoVar != null) {
            aoVar2 = this.f2778a.o;
            aoVar2.cancel();
        }
    }
}
