package com.baidu.tieba.write;

import android.content.DialogInterface;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aj implements DialogInterface.OnClickListener {
    final /* synthetic */ WriteActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aj(WriteActivity writeActivity) {
        this.a = writeActivity;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        com.baidu.tieba.b.u uVar;
        com.baidu.tieba.b.u uVar2;
        if (i == 0) {
            ba.a(this.a);
            uVar2 = this.a.b;
            uVar2.c(2);
        } else if (i == 1) {
            ba.b(this.a);
            uVar = this.a.b;
            uVar.c(1);
        }
    }
}
