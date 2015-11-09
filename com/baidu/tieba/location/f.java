package com.baidu.tieba.location;

import android.location.LocationListener;
import android.location.LocationManager;
import com.baidu.adp.lib.util.BdLog;
/* loaded from: classes.dex */
class f implements Runnable {
    final /* synthetic */ c bUp;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(c cVar) {
        this.bUp = cVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        LocationManager locationManager;
        LocationManager locationManager2;
        LocationListener locationListener;
        locationManager = this.bUp.bUj;
        if (locationManager != null) {
            try {
                locationManager2 = this.bUp.bUj;
                locationListener = this.bUp.bUn;
                locationManager2.requestLocationUpdates("network", 10000L, 100.0f, locationListener);
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }
}
