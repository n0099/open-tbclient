package com.baidu.webkit.sdk;

import android.location.LocationListener;
/* loaded from: classes12.dex */
public abstract class GeolocationServiceClient {
    public abstract void onSetEnableGps(boolean z);

    public abstract boolean onStart(LocationListener locationListener);

    public abstract void onStop(LocationListener locationListener);
}
