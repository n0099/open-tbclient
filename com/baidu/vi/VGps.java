package com.baidu.vi;

import android.annotation.SuppressLint;
import android.location.GpsStatus;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Handler;
import com.baidu.android.imsdk.internal.IMConnection;
/* loaded from: classes15.dex */
public class VGps {
    private static int e = 3;
    @SuppressLint({"HandlerLeak"})
    private static Handler h = new h();

    /* renamed from: a  reason: collision with root package name */
    private GpsStatus.Listener f5916a = new f(this);

    /* renamed from: b  reason: collision with root package name */
    private LocationListener f5917b = new g(this);
    private LocationManager c = null;
    private GpsStatus d = null;
    private int f = 0;
    private int g = 0;

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void b() {
        if (!h.hasMessages(1)) {
            h.sendMessageDelayed(h.obtainMessage(1, this), IMConnection.RETRY_DELAY_TIMES);
        }
    }

    public int getGpsSatellitesNum() {
        return this.f;
    }

    public boolean init() {
        h.removeMessages(2);
        h.sendMessage(h.obtainMessage(2, this));
        return true;
    }

    public boolean unInit() {
        h.removeMessages(1);
        h.removeMessages(3);
        h.sendMessage(h.obtainMessage(3, this));
        return true;
    }

    public native void updateGps(double d, double d2, float f, float f2, float f3, int i);
}
