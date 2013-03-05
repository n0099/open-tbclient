package com.baidu.tieba.pb;

import android.content.DialogInterface;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bd implements DialogInterface.OnClickListener {
    final /* synthetic */ PbActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bd(PbActivity pbActivity) {
        this.a = pbActivity;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        ca caVar;
        int i2;
        com.baidu.tieba.b.q qVar;
        com.baidu.tieba.a.ac o;
        com.baidu.tieba.a.ac acVar;
        boolean z;
        com.baidu.tieba.b.q qVar2;
        com.baidu.tieba.b.q qVar3;
        caVar = this.a.n;
        i2 = this.a.ah;
        com.baidu.tieba.a.al alVar = (com.baidu.tieba.a.al) caVar.getItem(i2);
        if (alVar != null) {
            if (i == 0) {
                alVar.d(this.a);
            } else if (i == 1) {
                qVar = this.a.p;
                if (qVar != null) {
                    qVar2 = this.a.p;
                    if (qVar2.j() != null) {
                        qVar3 = this.a.p;
                        if (qVar3.j().equals(alVar.a())) {
                            this.a.aj = false;
                        }
                    }
                    this.a.aj = true;
                }
                PbActivity pbActivity = this.a;
                o = this.a.o();
                pbActivity.ai = o;
                PbActivity pbActivity2 = this.a;
                acVar = this.a.ai;
                z = this.a.aj;
                pbActivity2.a(acVar, z);
            }
        }
    }
}
