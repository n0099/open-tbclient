package com.baidu.vi;

import android.location.Location;
import android.location.LocationListener;
import android.os.Bundle;
/* loaded from: classes7.dex */
class g implements LocationListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ VGps f3908a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(VGps vGps) {
        this.f3908a = vGps;
    }

    @Override // android.location.LocationListener
    public void onLocationChanged(Location location) {
        int i;
        int i2;
        int i3;
        if (location != null) {
            float accuracy = location.hasAccuracy() ? location.getAccuracy() : 0.0f;
            i = this.f3908a.f;
            i2 = VGps.e;
            if (i < i2) {
                this.f3908a.b();
                return;
            }
            float bearing = location.getBearing();
            i3 = this.f3908a.f;
            this.f3908a.updateGps(location.getLongitude(), location.getLatitude(), (float) (location.getSpeed() * 3.6d), bearing, accuracy, i3);
        }
    }

    @Override // android.location.LocationListener
    public void onProviderDisabled(String str) {
        this.f3908a.updateGps(0.0d, 0.0d, 0.0f, 0.0f, 0.0f, 0);
    }

    @Override // android.location.LocationListener
    public void onProviderEnabled(String str) {
    }

    @Override // android.location.LocationListener
    public void onStatusChanged(String str, int i, Bundle bundle) {
        switch (i) {
            case 0:
            case 1:
                this.f3908a.updateGps(0.0d, 0.0d, 0.0f, 0.0f, 0.0f, 0);
                return;
            default:
                return;
        }
    }
}
