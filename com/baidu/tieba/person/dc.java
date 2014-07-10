package com.baidu.tieba.person;

import android.content.DialogInterface;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class dc implements DialogInterface.OnClickListener {
    final /* synthetic */ cr a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public dc(cr crVar) {
        this.a = crVar;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        com.baidu.tieba.model.au auVar;
        com.baidu.tieba.model.c cVar;
        com.baidu.tieba.model.c cVar2;
        com.baidu.tieba.model.c cVar3;
        auVar = this.a.e;
        int a = com.baidu.adp.lib.f.b.a(auVar.h(), -1);
        if (a > 0) {
            cVar = this.a.f;
            if (cVar.a() == 1) {
                cVar3 = this.a.f;
                cVar3.b(a);
                return;
            }
            cVar2 = this.a.f;
            cVar2.a(a);
        }
    }
}
