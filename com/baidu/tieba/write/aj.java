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
        com.baidu.tieba.b.w wVar;
        com.baidu.tieba.b.w wVar2;
        if (i == 0) {
            ba.a(this.a);
            wVar2 = this.a.c;
            wVar2.c(2);
        } else if (i == 1) {
            ba.b(this.a);
            wVar = this.a.c;
            wVar.c(1);
        }
    }
}
