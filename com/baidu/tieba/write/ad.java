package com.baidu.tieba.write;

import android.content.DialogInterface;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ad implements DialogInterface.OnCancelListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ WriteActivity f2677a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ad(WriteActivity writeActivity) {
        this.f2677a = writeActivity;
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialogInterface) {
        an anVar;
        an anVar2;
        this.f2677a.DeinitWaitingDialog();
        anVar = this.f2677a.o;
        if (anVar != null) {
            anVar2 = this.f2677a.o;
            anVar2.cancel();
        }
    }
}
