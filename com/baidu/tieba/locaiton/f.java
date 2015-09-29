package com.baidu.tieba.locaiton;

import android.location.LocationListener;
import android.location.LocationManager;
import com.baidu.adp.lib.util.BdLog;
/* loaded from: classes.dex */
class f implements Runnable {
    final /* synthetic */ c bTJ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(c cVar) {
        this.bTJ = cVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        LocationManager locationManager;
        LocationManager locationManager2;
        LocationListener locationListener;
        locationManager = this.bTJ.bTD;
        if (locationManager != null) {
            try {
                locationManager2 = this.bTJ.bTD;
                locationListener = this.bTJ.bTH;
                locationManager2.requestLocationUpdates("network", 10000L, 100.0f, locationListener);
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }
}
