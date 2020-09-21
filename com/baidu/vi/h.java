package com.baidu.vi;

import android.location.GpsStatus;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Handler;
import android.os.Message;
/* loaded from: classes3.dex */
final class h extends Handler {
    @Override // android.os.Handler
    public void handleMessage(Message message) {
        LocationManager locationManager;
        LocationManager locationManager2;
        GpsStatus.Listener listener;
        LocationManager locationManager3;
        LocationListener locationListener;
        LocationManager locationManager4;
        GpsStatus.Listener listener2;
        int i;
        int i2;
        VGps vGps = (VGps) message.obj;
        if (vGps == null) {
            return;
        }
        switch (message.what) {
            case 1:
                i = vGps.f;
                i2 = VGps.e;
                if (i < i2) {
                    vGps.updateGps(0.0d, 0.0d, 0.0f, 0.0f, 0.0f, 0);
                    return;
                }
                return;
            case 2:
                if (VIContext.getContext() != null) {
                    vGps.c = (LocationManager) VIContext.getContext().getSystemService("location");
                    locationManager4 = vGps.c;
                    listener2 = vGps.a;
                    locationManager4.addGpsStatusListener(listener2);
                    return;
                }
                return;
            case 3:
                locationManager = vGps.c;
                if (locationManager != null) {
                    locationManager2 = vGps.c;
                    listener = vGps.a;
                    locationManager2.removeGpsStatusListener(listener);
                    locationManager3 = vGps.c;
                    locationListener = vGps.b;
                    locationManager3.removeUpdates(locationListener);
                    return;
                }
                return;
            default:
                return;
        }
    }
}
