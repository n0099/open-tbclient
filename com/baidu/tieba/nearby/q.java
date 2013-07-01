package com.baidu.tieba.nearby;

import android.content.DialogInterface;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class q implements DialogInterface.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ NearbyPbActivity f1174a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(NearbyPbActivity nearbyPbActivity) {
        this.f1174a = nearbyPbActivity;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        ae aeVar;
        int i2;
        aeVar = this.f1174a.l;
        i2 = this.f1174a.v;
        com.baidu.tieba.data.an anVar = (com.baidu.tieba.data.an) aeVar.getItem(i2);
        if (anVar != null && i == 0) {
            anVar.e(this.f1174a);
        }
    }
}
