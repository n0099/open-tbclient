package com.baidu.tieba.locaiton;

import android.location.Location;
import android.location.LocationListener;
import android.os.Bundle;
import android.os.Handler;
import com.baidu.tieba.locaiton.c;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e implements LocationListener {
    final /* synthetic */ c bPB;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(c cVar) {
        this.bPB = cVar;
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
        handler = this.bPB.mHandler;
        if (handler.hasMessages(0)) {
            handler4 = this.bPB.mHandler;
            handler4.removeMessages(0);
        }
        handler2 = this.bPB.mHandler;
        runnable = this.bPB.bPy;
        handler2.removeCallbacks(runnable);
        handler3 = this.bPB.mHandler;
        runnable2 = this.bPB.bPx;
        handler3.removeCallbacks(runnable2);
        aVar = this.bPB.bPu;
        if (aVar == null) {
            this.bPB.bPu = new c.a(this.bPB, null);
            aVar2 = this.bPB.bPu;
            aVar2.setSelfExecute(true);
            aVar3 = this.bPB.bPu;
            aVar3.execute(location);
        }
    }
}
