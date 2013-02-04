package com.baidu.tieba;

import android.location.Location;
import android.location.LocationListener;
import android.os.Bundle;
/* loaded from: classes.dex */
class s implements LocationListener {
    final /* synthetic */ TiebaApplication a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(TiebaApplication tiebaApplication) {
        this.a = tiebaApplication;
    }

    @Override // android.location.LocationListener
    public void onLocationChanged(Location location) {
        if (location != null) {
            this.a.A = 0;
            this.a.C = location;
            this.a.as();
            this.a.a = System.currentTimeMillis();
            this.a.a(this.a.A, "", location);
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
