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
        cd cdVar;
        int i2;
        cdVar = this.a.m;
        i2 = this.a.aj;
        com.baidu.tieba.a.an anVar = (com.baidu.tieba.a.an) cdVar.getItem(i2);
        if (anVar != null && i == 0) {
            anVar.d(this.a);
        }
    }
}
