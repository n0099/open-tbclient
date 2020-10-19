package com.baidu.vi;

import android.location.GpsSatellite;
import android.location.GpsStatus;
import android.location.LocationManager;
/* loaded from: classes7.dex */
class f implements GpsStatus.Listener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ VGps f3907a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(VGps vGps) {
        this.f3907a = vGps;
    }

    @Override // android.location.GpsStatus.Listener
    public void onGpsStatusChanged(int i) {
        LocationManager locationManager;
        GpsStatus gpsStatus;
        int i2;
        int i3;
        int i4;
        GpsStatus gpsStatus2;
        LocationManager locationManager2;
        GpsStatus gpsStatus3;
        LocationManager locationManager3;
        int i5 = 0;
        switch (i) {
            case 2:
                this.f3907a.updateGps(0.0d, 0.0d, 0.0f, 0.0f, 0.0f, 0);
                return;
            case 3:
            default:
                return;
            case 4:
                locationManager = this.f3907a.c;
                if (locationManager != null) {
                    gpsStatus2 = this.f3907a.d;
                    if (gpsStatus2 == null) {
                        VGps vGps = this.f3907a;
                        locationManager3 = this.f3907a.c;
                        vGps.d = locationManager3.getGpsStatus(null);
                    } else {
                        locationManager2 = this.f3907a.c;
                        gpsStatus3 = this.f3907a.d;
                        locationManager2.getGpsStatus(gpsStatus3);
                    }
                }
                gpsStatus = this.f3907a.d;
                for (GpsSatellite gpsSatellite : gpsStatus.getSatellites()) {
                    if (gpsSatellite.usedInFix()) {
                        i5++;
                    }
                }
                i2 = VGps.e;
                if (i5 < i2) {
                    i3 = this.f3907a.f;
                    i4 = VGps.e;
                    if (i3 >= i4) {
                        this.f3907a.b();
                    }
                }
                this.f3907a.f = i5;
                return;
        }
    }
}
