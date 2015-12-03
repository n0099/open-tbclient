package com.baidu.tieba.location;

import android.location.LocationListener;
import android.location.LocationManager;
import com.baidu.adp.lib.util.BdLog;
/* loaded from: classes.dex */
class g implements Runnable {
    final /* synthetic */ c ckD;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(c cVar) {
        this.ckD = cVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        LocationManager locationManager;
        LocationManager locationManager2;
        LocationListener locationListener;
        locationManager = this.ckD.ckx;
        if (locationManager != null) {
            try {
                locationManager2 = this.ckD.ckx;
                locationListener = this.ckD.ckC;
                locationManager2.requestLocationUpdates("gps", 10000L, 100.0f, locationListener);
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }
}
