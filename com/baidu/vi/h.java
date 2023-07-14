package com.baidu.vi;

import android.location.GpsStatus;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Handler;
import android.os.Message;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes9.dex */
public final class h extends Handler {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public h() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        VGps vGps;
        int i;
        int i2;
        LocationManager locationManager;
        GpsStatus.Listener listener;
        LocationManager locationManager2;
        LocationManager locationManager3;
        GpsStatus.Listener listener2;
        LocationManager locationManager4;
        LocationListener locationListener;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048576, this, message) != null) || (vGps = (VGps) message.obj) == null) {
            return;
        }
        int i3 = message.what;
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 != 3) {
                    return;
                }
                locationManager2 = vGps.c;
                if (locationManager2 == null) {
                    return;
                }
                locationManager3 = vGps.c;
                listener2 = vGps.a;
                locationManager3.removeGpsStatusListener(listener2);
                locationManager4 = vGps.c;
                locationListener = vGps.b;
                locationManager4.removeUpdates(locationListener);
                return;
            } else if (VIContext.getContext() == null) {
                return;
            } else {
                vGps.c = (LocationManager) VIContext.getContext().getSystemService("location");
                locationManager = vGps.c;
                listener = vGps.a;
                locationManager.addGpsStatusListener(listener);
                return;
            }
        }
        i = vGps.f;
        i2 = VGps.e;
        if (i < i2) {
            vGps.updateGps(0.0d, 0.0d, 0.0f, 0.0f, 0.0f, 0);
        }
    }
}
