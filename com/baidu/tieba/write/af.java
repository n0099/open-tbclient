package com.baidu.tieba.write;

import android.content.DialogInterface;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class af implements DialogInterface.OnCancelListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ WriteActivity f1905a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public af(WriteActivity writeActivity) {
        this.f1905a = writeActivity;
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialogInterface) {
        ao aoVar;
        ao aoVar2;
        this.f1905a.g();
        aoVar = this.f1905a.v;
        if (aoVar != null) {
            aoVar2 = this.f1905a.v;
            aoVar2.cancel();
        }
    }
}
