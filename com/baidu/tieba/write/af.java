package com.baidu.tieba.write;

import android.content.DialogInterface;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class af implements DialogInterface.OnCancelListener {
    final /* synthetic */ WriteActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public af(WriteActivity writeActivity) {
        this.a = writeActivity;
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialogInterface) {
        ao aoVar;
        ao aoVar2;
        this.a.c();
        aoVar = this.a.u;
        if (aoVar != null) {
            aoVar2 = this.a.u;
            aoVar2.a();
        }
    }
}
