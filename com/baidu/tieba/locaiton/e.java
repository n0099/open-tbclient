package com.baidu.tieba.locaiton;

import android.location.Location;
import android.location.LocationListener;
import android.os.Bundle;
import android.os.Handler;
import com.baidu.tieba.locaiton.c;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e implements LocationListener {
    final /* synthetic */ c bQh;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(c cVar) {
        this.bQh = cVar;
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
        handler = this.bQh.mHandler;
        if (handler.hasMessages(0)) {
            handler4 = this.bQh.mHandler;
            handler4.removeMessages(0);
        }
        handler2 = this.bQh.mHandler;
        runnable = this.bQh.bQe;
        handler2.removeCallbacks(runnable);
        handler3 = this.bQh.mHandler;
        runnable2 = this.bQh.bQd;
        handler3.removeCallbacks(runnable2);
        aVar = this.bQh.bQa;
        if (aVar == null) {
            this.bQh.bQa = new c.a(this.bQh, null);
            aVar2 = this.bQh.bQa;
            aVar2.setSelfExecute(true);
            aVar3 = this.bQh.bQa;
            aVar3.execute(location);
        }
    }
}
