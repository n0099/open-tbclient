package com.baidu.tieba.location;

import android.location.Location;
import android.location.LocationListener;
import android.os.Bundle;
import android.os.Handler;
import com.baidu.tieba.location.c;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements LocationListener {
    final /* synthetic */ c bUp;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(c cVar) {
        this.bUp = cVar;
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
        handler = this.bUp.mHandler;
        if (handler.hasMessages(0)) {
            handler4 = this.bUp.mHandler;
            handler4.removeMessages(0);
        }
        handler2 = this.bUp.mHandler;
        runnable = this.bUp.bUm;
        handler2.removeCallbacks(runnable);
        handler3 = this.bUp.mHandler;
        runnable2 = this.bUp.bUl;
        handler3.removeCallbacks(runnable2);
        aVar = this.bUp.bUi;
        if (aVar == null) {
            this.bUp.bUi = new c.a(this.bUp, null);
            aVar2 = this.bUp.bUi;
            aVar2.setSelfExecute(true);
            aVar3 = this.bUp.bUi;
            aVar3.execute(location);
        }
    }
}
