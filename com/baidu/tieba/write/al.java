package com.baidu.tieba.write;

import android.content.DialogInterface;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class al implements DialogInterface.OnClickListener {
    final /* synthetic */ WriteActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public al(WriteActivity writeActivity) {
        this.a = writeActivity;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        com.baidu.tieba.b.y yVar;
        com.baidu.tieba.b.y yVar2;
        if (i == 0) {
            bb.a(this.a);
            yVar2 = this.a.c;
            yVar2.c(2);
        } else if (i == 1) {
            bb.b(this.a);
            yVar = this.a.c;
            yVar.c(1);
        }
    }
}
