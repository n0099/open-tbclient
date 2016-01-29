package com.baidu.tieba.location;

import android.location.Location;
import android.location.LocationListener;
import android.os.Bundle;
import android.os.Handler;
import com.baidu.tieba.location.c;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e implements LocationListener {
    final /* synthetic */ c cvq;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(c cVar) {
        this.cvq = cVar;
    }

    @Override // android.location.LocationListener
    public void onStatusChanged(String str, int i, Bundle bundle) {
    }

    @Override // android.location.LocationListener
    public void onProviderEnabled(String str) {
    }

    @Override // android.location.LocationListener
    public void onProviderDisabled(String str) {
    }

    @Override // android.location.LocationListener
    public void onLocationChanged(Location location) {
        Handler handler;
        Handler handler2;
        Runnable runnable;
        Handler handler3;
        Runnable runnable2;
        c.a aVar;
        c.a aVar2;
        c.a aVar3;
        Handler handler4;
        handler = this.cvq.mHandler;
        if (handler.hasMessages(0)) {
            handler4 = this.cvq.mHandler;
            handler4.removeMessages(0);
        }
        handler2 = this.cvq.mHandler;
        runnable = this.cvq.cvn;
        handler2.removeCallbacks(runnable);
        handler3 = this.cvq.mHandler;
        runnable2 = this.cvq.cvm;
        handler3.removeCallbacks(runnable2);
        aVar = this.cvq.cvj;
        if (aVar == null) {
            this.cvq.cvj = new c.a(this.cvq, null);
            aVar2 = this.cvq.cvj;
            aVar2.setSelfExecute(true);
            aVar3 = this.cvq.cvj;
            aVar3.execute(location);
        }
    }
}
