package com.baidu.tieba.nearby;

import android.content.DialogInterface;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ac implements DialogInterface.OnClickListener {
    final /* synthetic */ ab a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ac(ab abVar) {
        this.a = abVar;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        NearbyPbActivity nearbyPbActivity;
        int i2;
        nearbyPbActivity = this.a.b;
        i2 = this.a.d;
        nearbyPbActivity.e(i2);
    }
}
