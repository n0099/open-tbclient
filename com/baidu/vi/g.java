package com.baidu.vi;

import android.location.Location;
import android.location.LocationListener;
import android.os.Bundle;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes9.dex */
public class g implements LocationListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final /* synthetic */ VGps a;

    @Override // android.location.LocationListener
    public void onProviderEnabled(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
        }
    }

    public g(VGps vGps) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {vGps};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = vGps;
    }

    @Override // android.location.LocationListener
    public void onProviderDisabled(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
            this.a.updateGps(0.0d, 0.0d, 0.0f, 0.0f, 0.0f, 0);
        }
    }

    @Override // android.location.LocationListener
    public void onLocationChanged(Location location) {
        float f;
        int i;
        int i2;
        int i3;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, location) == null) && location != null) {
            if (location.hasAccuracy()) {
                f = location.getAccuracy();
            } else {
                f = 0.0f;
            }
            i = this.a.f;
            i2 = VGps.e;
            if (i >= i2) {
                float bearing = location.getBearing();
                i3 = this.a.f;
                this.a.updateGps(location.getLongitude(), location.getLatitude(), (float) (location.getSpeed() * 3.6d), bearing, f, i3);
                return;
            }
            this.a.b();
        }
    }

    @Override // android.location.LocationListener
    public void onStatusChanged(String str, int i, Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(1048579, this, str, i, bundle) == null) {
            if (i == 0 || i == 1) {
                this.a.updateGps(0.0d, 0.0d, 0.0f, 0.0f, 0.0f, 0);
            }
        }
    }
}
