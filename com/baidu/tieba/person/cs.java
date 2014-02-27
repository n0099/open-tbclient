package com.baidu.tieba.person;

import android.content.DialogInterface;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class cs implements DialogInterface.OnClickListener {
    final /* synthetic */ cm a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cs(cm cmVar) {
        this.a = cmVar;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i) {
        com.baidu.tieba.model.bp bpVar;
        com.baidu.tieba.im.model.b bVar;
        com.baidu.tieba.im.model.b bVar2;
        com.baidu.tieba.im.model.b bVar3;
        bpVar = this.a.c;
        int a = com.baidu.adp.lib.f.b.a(bpVar.d(), -1);
        if (a > 0) {
            bVar = this.a.d;
            if (bVar.b() == 1) {
                bVar3 = this.a.d;
                bVar3.b(a);
                return;
            }
            bVar2 = this.a.d;
            bVar2.a(a);
        }
    }
}
