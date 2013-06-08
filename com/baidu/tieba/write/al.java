package com.baidu.tieba.write;

import android.content.DialogInterface;
import com.baidu.tieba.c.bs;
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
        bs bsVar;
        bs bsVar2;
        if (i == 0) {
            bb.a(this.a);
            bsVar2 = this.a.c;
            bsVar2.c(2);
        } else if (i == 1) {
            bb.b(this.a);
            bsVar = this.a.c;
            bsVar.c(1);
        }
    }
}
