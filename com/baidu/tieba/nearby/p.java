package com.baidu.tieba.nearby;

import android.content.DialogInterface;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class p implements DialogInterface.OnCancelListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ NearbyPbActivity f1173a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(NearbyPbActivity nearbyPbActivity) {
        this.f1173a = nearbyPbActivity;
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialogInterface) {
        ad adVar;
        ad adVar2;
        this.f1173a.g();
        adVar = this.f1173a.k;
        if (adVar != null) {
            adVar2 = this.f1173a.k;
            adVar2.cancel();
        }
    }
}
