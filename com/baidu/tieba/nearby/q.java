package com.baidu.tieba.nearby;

import android.content.DialogInterface;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class q implements DialogInterface.OnClickListener {
    final /* synthetic */ NearbyPbActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(NearbyPbActivity nearbyPbActivity) {
        this.a = nearbyPbActivity;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        ae aeVar;
        int i2;
        aeVar = this.a.l;
        i2 = this.a.v;
        com.baidu.tieba.a.aq aqVar = (com.baidu.tieba.a.aq) aeVar.getItem(i2);
        if (aqVar != null && i == 0) {
            aqVar.f(this.a);
        }
    }
}
