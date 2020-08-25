package com.baidu.vi;

import android.location.GpsSatellite;
import android.location.GpsStatus;
import android.location.LocationManager;
/* loaded from: classes20.dex */
class f implements GpsStatus.Listener {
    final /* synthetic */ VGps a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(VGps vGps) {
        this.a = vGps;
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
                this.a.updateGps(0.0d, 0.0d, 0.0f, 0.0f, 0.0f, 0);
                return;
            case 3:
            default:
                return;
            case 4:
                locationManager = this.a.c;
                if (locationManager != null) {
                    gpsStatus2 = this.a.d;
                    if (gpsStatus2 == null) {
                        VGps vGps = this.a;
                        locationManager3 = this.a.c;
                        vGps.d = locationManager3.getGpsStatus(null);
                    } else {
                        locationManager2 = this.a.c;
                        gpsStatus3 = this.a.d;
                        locationManager2.getGpsStatus(gpsStatus3);
                    }
                }
                gpsStatus = this.a.d;
                for (GpsSatellite gpsSatellite : gpsStatus.getSatellites()) {
                    if (gpsSatellite.usedInFix()) {
                        i5++;
                    }
                }
                i2 = VGps.e;
                if (i5 < i2) {
                    i3 = this.a.f;
                    i4 = VGps.e;
                    if (i3 >= i4) {
                        this.a.b();
                    }
                }
                this.a.f = i5;
                return;
        }
    }
}
