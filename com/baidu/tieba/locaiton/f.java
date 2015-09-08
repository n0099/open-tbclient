package com.baidu.tieba.locaiton;

import android.location.LocationListener;
import android.location.LocationManager;
import com.baidu.adp.lib.util.BdLog;
/* loaded from: classes.dex */
class f implements Runnable {
    final /* synthetic */ c bQh;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(c cVar) {
        this.bQh = cVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        LocationManager locationManager;
        LocationManager locationManager2;
        LocationListener locationListener;
        locationManager = this.bQh.bQb;
        if (locationManager != null) {
            try {
                locationManager2 = this.bQh.bQb;
                locationListener = this.bQh.bQf;
                locationManager2.requestLocationUpdates("network", 10000L, 100.0f, locationListener);
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }
}
