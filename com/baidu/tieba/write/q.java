package com.baidu.tieba.write;

import android.content.DialogInterface;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class q implements DialogInterface.OnCancelListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ VcodeActivity f2668a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(VcodeActivity vcodeActivity) {
        this.f2668a = vcodeActivity;
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialogInterface) {
        v vVar;
        v vVar2;
        this.f2668a.i();
        vVar = this.f2668a.g;
        if (vVar != null) {
            vVar2 = this.f2668a.g;
            vVar2.cancel();
        }
    }
}
