package com.baidu.tieba;

import android.location.Location;
import android.location.LocationListener;
import android.os.Bundle;
/* loaded from: classes.dex */
class w implements LocationListener {
    final /* synthetic */ TiebaApplication a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public w(TiebaApplication tiebaApplication) {
        this.a = tiebaApplication;
    }

    @Override // android.location.LocationListener
    public void onLocationChanged(Location location) {
        aa aaVar;
        if (location != null) {
            this.a.C = 0;
            this.a.a = System.currentTimeMillis();
            this.a.F = new aa(this.a, null);
            aaVar = this.a.F;
            aaVar.execute(location);
        }
    }

    @Override // android.location.LocationListener
    public void onProviderDisabled(String str) {
    }

    @Override // android.location.LocationListener
    public void onProviderEnabled(String str) {
    }

    @Override // android.location.LocationListener
    public void onStatusChanged(String str, int i, Bundle bundle) {
    }
}
