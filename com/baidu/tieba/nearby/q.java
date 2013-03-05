package com.baidu.tieba.nearby;

import android.content.DialogInterface;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class q implements DialogInterface.OnCancelListener {
    final /* synthetic */ NearbyPbActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(NearbyPbActivity nearbyPbActivity) {
        this.a = nearbyPbActivity;
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialogInterface) {
        ae aeVar;
        ae aeVar2;
        this.a.c();
        aeVar = this.a.l;
        if (aeVar != null) {
            aeVar2 = this.a.l;
            aeVar2.a();
        }
    }
}
