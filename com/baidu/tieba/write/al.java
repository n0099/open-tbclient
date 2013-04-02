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
        com.baidu.tieba.b.z zVar;
        com.baidu.tieba.b.z zVar2;
        if (i == 0) {
            bb.a(this.a);
            zVar2 = this.a.c;
            zVar2.c(2);
        } else if (i == 1) {
            bb.b(this.a);
            zVar = this.a.c;
            zVar.c(1);
        }
    }
}
