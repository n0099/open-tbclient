package com;

import android.location.Location;
import android.location.LocationListener;
import android.os.Bundle;
import com.baidu.cloudsdk.common.util.CoordinateManager;
/* loaded from: classes.dex */
public class bj implements LocationListener {
    final /* synthetic */ CoordinateManager.a a;

    public bj(CoordinateManager.a aVar) {
        this.a = aVar;
    }

    @Override // android.location.LocationListener
    public void onLocationChanged(Location location) {
        CoordinateManager.this.c = this.a.c = location;
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
