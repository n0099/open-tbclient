package com.baidu.tieba.pb;

import android.content.DialogInterface;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class as implements DialogInterface.OnClickListener {
    final /* synthetic */ PbActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public as(PbActivity pbActivity) {
        this.a = pbActivity;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        bt btVar;
        int i2;
        com.baidu.tieba.b.n nVar;
        com.baidu.tieba.a.ae l;
        com.baidu.tieba.a.ae aeVar;
        boolean z;
        com.baidu.tieba.b.n nVar2;
        com.baidu.tieba.b.n nVar3;
        btVar = this.a.l;
        i2 = this.a.ae;
        com.baidu.tieba.a.am amVar = (com.baidu.tieba.a.am) btVar.getItem(i2);
        if (amVar == null) {
            return;
        }
        if (i == 0) {
            amVar.d(this.a);
        } else if (i == 1) {
            nVar = this.a.n;
            if (nVar != null) {
                nVar2 = this.a.n;
                if (nVar2.j() != null) {
                    nVar3 = this.a.n;
                    if (nVar3.j().equals(amVar.a())) {
                        this.a.ag = false;
                    }
                }
                this.a.ag = true;
            }
            PbActivity pbActivity = this.a;
            l = this.a.l();
            pbActivity.af = l;
            PbActivity pbActivity2 = this.a;
            aeVar = this.a.af;
            z = this.a.ag;
            pbActivity2.a(aeVar, z);
        }
    }
}
