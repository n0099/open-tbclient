package com.baidu.tieba.location;

import android.location.LocationListener;
import android.location.LocationManager;
import com.baidu.adp.lib.util.BdLog;
/* loaded from: classes.dex */
class f implements Runnable {
    final /* synthetic */ c coH;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(c cVar) {
        this.coH = cVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        LocationManager locationManager;
        LocationManager locationManager2;
        LocationListener locationListener;
        locationManager = this.coH.coB;
        if (locationManager != null) {
            try {
                locationManager2 = this.coH.coB;
                locationListener = this.coH.coF;
                locationManager2.requestLocationUpdates("network", 10000L, 100.0f, locationListener);
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }
}
