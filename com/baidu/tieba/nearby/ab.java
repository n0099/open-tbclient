package com.baidu.tieba.nearby;

import android.content.DialogInterface;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ab implements DialogInterface.OnClickListener {
    final /* synthetic */ aa a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ab(aa aaVar) {
        this.a = aaVar;
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
