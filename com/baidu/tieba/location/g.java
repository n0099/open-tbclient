package com.baidu.tieba.location;

import android.location.LocationListener;
import android.location.LocationManager;
import com.baidu.adp.lib.util.BdLog;
/* loaded from: classes.dex */
class g implements Runnable {
    final /* synthetic */ c cvq;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(c cVar) {
        this.cvq = cVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        LocationManager locationManager;
        LocationManager locationManager2;
        LocationListener locationListener;
        locationManager = this.cvq.cvk;
        if (locationManager != null) {
            try {
                locationManager2 = this.cvq.cvk;
                locationListener = this.cvq.cvp;
                locationManager2.requestLocationUpdates("gps", 10000L, 100.0f, locationListener);
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }
}
