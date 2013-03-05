package com.baidu.tieba.write;

import android.content.DialogInterface;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ag implements DialogInterface.OnCancelListener {
    final /* synthetic */ WriteActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ag(WriteActivity writeActivity) {
        this.a = writeActivity;
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialogInterface) {
        ap apVar;
        ap apVar2;
        this.a.c();
        apVar = this.a.v;
        if (apVar != null) {
            apVar2 = this.a.v;
            apVar2.a();
        }
    }
}
