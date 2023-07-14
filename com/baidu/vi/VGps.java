package com.baidu.vi;

import android.annotation.SuppressLint;
import android.location.GpsStatus;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Handler;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes9.dex */
public class VGps {
    public static /* synthetic */ Interceptable $ic = null;
    public static int e = 3;
    @SuppressLint({"HandlerLeak"})
    public static Handler h;
    public transient /* synthetic */ FieldHolder $fh;
    public GpsStatus.Listener a;
    public LocationListener b;
    public LocationManager c;
    public GpsStatus d;
    public int f;
    public int g;

    public native void updateGps(double d, double d2, float f, float f2, float f3, int i);

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-2043300615, "Lcom/baidu/vi/VGps;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-2043300615, "Lcom/baidu/vi/VGps;");
                return;
            }
        }
        h = new h();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65544, this) == null) {
            synchronized (this) {
                if (!h.hasMessages(1)) {
                    h.sendMessageDelayed(h.obtainMessage(1, this), 3000L);
                }
            }
        }
    }

    public int getGpsSatellitesNum() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.f;
        }
        return invokeV.intValue;
    }

    public boolean init() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            h.removeMessages(2);
            Handler handler = h;
            handler.sendMessage(handler.obtainMessage(2, this));
            return true;
        }
        return invokeV.booleanValue;
    }

    public boolean unInit() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            h.removeMessages(1);
            h.removeMessages(3);
            Handler handler = h;
            handler.sendMessage(handler.obtainMessage(3, this));
            return true;
        }
        return invokeV.booleanValue;
    }

    public VGps() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = new f(this);
        this.b = new g(this);
        this.c = null;
        this.d = null;
        this.f = 0;
        this.g = 0;
    }
}
