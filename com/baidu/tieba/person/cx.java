package com.baidu.tieba.person;

import android.content.DialogInterface;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class cx implements DialogInterface.OnClickListener {
    final /* synthetic */ ct a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cx(ct ctVar) {
        this.a = ctVar;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        com.baidu.tieba.model.av avVar;
        com.baidu.tieba.model.d dVar;
        com.baidu.tieba.model.d dVar2;
        com.baidu.tieba.model.d dVar3;
        avVar = this.a.e;
        int a = com.baidu.adp.lib.e.b.a(avVar.i(), -1);
        if (a > 0) {
            dVar = this.a.f;
            if (dVar.a() == 1) {
                dVar3 = this.a.f;
                dVar3.b(a);
                return;
            }
            dVar2 = this.a.f;
            dVar2.a(a);
        }
    }
}
