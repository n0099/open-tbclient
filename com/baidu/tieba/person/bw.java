package com.baidu.tieba.person;

import android.content.DialogInterface;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bw implements DialogInterface.OnClickListener {
    final /* synthetic */ bm a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bw(bm bmVar) {
        this.a = bmVar;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        com.baidu.tieba.model.av avVar;
        com.baidu.tieba.model.e eVar;
        com.baidu.tieba.model.e eVar2;
        com.baidu.tieba.model.e eVar3;
        avVar = this.a.c;
        int a = com.baidu.adp.lib.f.b.a(avVar.f(), -1);
        if (a > 0) {
            eVar = this.a.d;
            if (eVar.a() == 1) {
                eVar3 = this.a.d;
                eVar3.b(a);
                return;
            }
            eVar2 = this.a.d;
            eVar2.a(a);
        }
    }
}
