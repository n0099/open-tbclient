package com.baidu.tieba.write;

import android.content.DialogInterface;
import com.baidu.tieba.c.bp;
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
        bp bpVar;
        bp bpVar2;
        if (i == 0) {
            bb.a(this.a);
            bpVar2 = this.a.c;
            bpVar2.c(2);
        } else if (i == 1) {
            bb.b(this.a);
            bpVar = this.a.c;
            bpVar.c(1);
        }
    }
}
