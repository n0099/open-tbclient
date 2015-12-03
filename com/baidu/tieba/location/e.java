package com.baidu.tieba.location;

import android.location.Location;
import android.location.LocationListener;
import android.os.Bundle;
import android.os.Handler;
import com.baidu.tieba.location.c;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e implements LocationListener {
    final /* synthetic */ c ckD;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(c cVar) {
        this.ckD = cVar;
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
        handler = this.ckD.mHandler;
        if (handler.hasMessages(0)) {
            handler4 = this.ckD.mHandler;
            handler4.removeMessages(0);
        }
        handler2 = this.ckD.mHandler;
        runnable = this.ckD.ckA;
        handler2.removeCallbacks(runnable);
        handler3 = this.ckD.mHandler;
        runnable2 = this.ckD.ckz;
        handler3.removeCallbacks(runnable2);
        aVar = this.ckD.ckw;
        if (aVar == null) {
            this.ckD.ckw = new c.a(this.ckD, null);
            aVar2 = this.ckD.ckw;
            aVar2.setSelfExecute(true);
            aVar3 = this.ckD.ckw;
            aVar3.execute(location);
        }
    }
}
