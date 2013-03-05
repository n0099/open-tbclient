package com.baidu.tieba.nearby;

import android.content.DialogInterface;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class r implements DialogInterface.OnClickListener {
    final /* synthetic */ NearbyPbActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(NearbyPbActivity nearbyPbActivity) {
        this.a = nearbyPbActivity;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        af afVar;
        int i2;
        afVar = this.a.m;
        i2 = this.a.w;
        com.baidu.tieba.a.al alVar = (com.baidu.tieba.a.al) afVar.getItem(i2);
        if (alVar != null && i == 0) {
            alVar.d(this.a);
        }
    }
}
