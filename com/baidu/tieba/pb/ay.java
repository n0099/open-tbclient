package com.baidu.tieba.pb;

import android.content.DialogInterface;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ay implements DialogInterface.OnClickListener {
    final /* synthetic */ PbActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ay(PbActivity pbActivity) {
        this.a = pbActivity;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        bv bvVar;
        int i2;
        com.baidu.tieba.b.p pVar;
        com.baidu.tieba.a.af o;
        com.baidu.tieba.a.af afVar;
        boolean z;
        com.baidu.tieba.b.p pVar2;
        com.baidu.tieba.b.p pVar3;
        bvVar = this.a.m;
        i2 = this.a.ag;
        com.baidu.tieba.a.an anVar = (com.baidu.tieba.a.an) bvVar.getItem(i2);
        if (anVar != null) {
            if (i == 0) {
                anVar.d(this.a);
            } else if (i == 1) {
                pVar = this.a.o;
                if (pVar != null) {
                    pVar2 = this.a.o;
                    if (pVar2.j() != null) {
                        pVar3 = this.a.o;
                        if (pVar3.j().equals(anVar.a())) {
                            this.a.ai = false;
                        }
                    }
                    this.a.ai = true;
                }
                PbActivity pbActivity = this.a;
                o = this.a.o();
                pbActivity.ah = o;
                PbActivity pbActivity2 = this.a;
                afVar = this.a.ah;
                z = this.a.ai;
                pbActivity2.a(afVar, z);
            }
        }
    }
}
