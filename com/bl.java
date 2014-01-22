package com;

import android.location.Location;
import android.location.LocationListener;
import android.os.Bundle;
import com.baidu.cloudsdk.common.util.PositionManager;
/* loaded from: classes.dex */
public class bl implements LocationListener {
    final /* synthetic */ PositionManager.a a;

    public bl(PositionManager.a aVar) {
        this.a = aVar;
    }

    @Override // android.location.LocationListener
    public void onLocationChanged(Location location) {
        PositionManager.this.b = location;
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
