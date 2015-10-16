package com.baidu.tieba.locaiton;

import android.location.LocationListener;
import android.location.LocationManager;
import com.baidu.adp.lib.util.BdLog;
/* loaded from: classes.dex */
class f implements Runnable {
    final /* synthetic */ c bTU;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(c cVar) {
        this.bTU = cVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        LocationManager locationManager;
        LocationManager locationManager2;
        LocationListener locationListener;
        locationManager = this.bTU.bTO;
        if (locationManager != null) {
            try {
                locationManager2 = this.bTU.bTO;
                locationListener = this.bTU.bTS;
                locationManager2.requestLocationUpdates("network", 10000L, 100.0f, locationListener);
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }
}
