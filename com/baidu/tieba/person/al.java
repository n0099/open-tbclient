package com.baidu.tieba.person;

import android.content.DialogInterface;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class al implements DialogInterface.OnCancelListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ PersonChangeActivity f2310a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public al(PersonChangeActivity personChangeActivity) {
        this.f2310a = personChangeActivity;
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialogInterface) {
        ay ayVar;
        ay ayVar2;
        this.f2310a.DeinitWaitingDialog();
        ayVar = this.f2310a.B;
        if (ayVar != null) {
            ayVar2 = this.f2310a.B;
            ayVar2.cancel();
        }
    }
}
