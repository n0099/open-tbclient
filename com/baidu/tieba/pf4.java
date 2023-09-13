package com.baidu.tieba;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Build;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.location.BDLocation;
import com.baidu.location.BDLocationListener;
import com.baidu.location.LocationClient;
import com.baidu.location.LocationClientOption;
import com.baidu.mapapi.CoordType;
import com.baidu.mapapi.map.BaiduMap;
import com.baidu.mapapi.map.MyLocationConfiguration;
import com.baidu.mapapi.map.MyLocationData;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes7.dex */
public class pf4 implements SensorEventListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public List<rg4> a;
    public SensorManager b;
    public double c;
    public LocationClient d;
    public boolean e;
    public BDLocation f;
    public boolean g;

    @Override // android.hardware.SensorEventListener
    public void onAccuracyChanged(Sensor sensor, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048589, this, sensor, i) == null) {
        }
    }

    /* loaded from: classes7.dex */
    public class a implements BDLocationListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ pf4 a;

        public a(pf4 pf4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pf4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = pf4Var;
        }

        @Override // com.baidu.location.BDLocationListener
        public void onReceiveLocation(BDLocation bDLocation) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, bDLocation) == null) {
                if (bDLocation == null || this.a.a.size() <= 0) {
                    this.a.n();
                    return;
                }
                this.a.f = bDLocation;
                for (rg4 rg4Var : this.a.a) {
                    if (rg4Var.k) {
                        MyLocationData build = new MyLocationData.Builder().direction(bDLocation.getDirection()).accuracy(bDLocation.getGpsAccuracyStatus()).latitude(bDLocation.getLatitude()).longitude(bDLocation.getLongitude()).satellitesNum(bDLocation.getSatelliteNumber()).build();
                        BaiduMap map = rg4Var.l.getMap();
                        map.setMyLocationEnabled(true);
                        map.setMyLocationConfiguration(new MyLocationConfiguration(MyLocationConfiguration.LocationMode.NORMAL, true, null));
                        map.setMyLocationData(build);
                    }
                }
            }
        }
    }

    public pf4() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.e = false;
        this.g = false;
        this.a = new ArrayList(1);
        l();
    }

    public BDLocation e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.f;
        }
        return (BDLocation) invokeV.objValue;
    }

    public boolean g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            LocationClient locationClient = this.d;
            if (locationClient != null && locationClient.isStarted()) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            n();
            for (rg4 rg4Var : this.a) {
                rg4Var.l.onPause();
            }
        }
    }

    public void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            l();
            for (rg4 rg4Var : this.a) {
                rg4Var.l.onResume();
            }
        }
    }

    public final void l() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048585, this) != null) || !this.g) {
            return;
        }
        f();
        LocationClient locationClient = this.d;
        if (locationClient != null && !locationClient.isStarted()) {
            this.d.start();
            m();
            h82.o("map", "start location");
        }
    }

    public final void m() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048586, this) == null) && !this.e) {
            SensorManager sensorManager = (SensorManager) AppRuntime.getAppContext().getSystemService("sensor");
            this.b = sensorManager;
            if (sensorManager != null) {
                sensorManager.registerListener(this, sensorManager.getDefaultSensor(3), 2);
                this.e = true;
            }
        }
    }

    public final void n() {
        LocationClient locationClient;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048587, this) == null) && this.g && (locationClient = this.d) != null && locationClient.isStarted()) {
            this.d.stop();
            o();
            h82.o("map", "stop location");
        }
    }

    public final void o() {
        SensorManager sensorManager;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048588, this) == null) && (sensorManager = this.b) != null && this.e) {
            sensorManager.unregisterListener(this);
            this.e = false;
        }
    }

    public boolean insert(rg4 rg4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, rg4Var)) == null) {
            if (rg4Var == null) {
                return false;
            }
            this.a.add(rg4Var);
            return true;
        }
        return invokeL.booleanValue;
    }

    public boolean j(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, str)) == null) {
            rg4 d = d(str);
            if (d != null) {
                this.a.remove(d);
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public void p(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048591, this, z) == null) {
            if (z) {
                this.g = true;
                l();
                return;
            }
            n();
            this.g = false;
        }
    }

    public rg4 d(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            for (rg4 rg4Var : this.a) {
                if (rg4Var != null && TextUtils.equals(rg4Var.j, str)) {
                    return rg4Var;
                }
            }
            return null;
        }
        return (rg4) invokeL.objValue;
    }

    public final void f() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && this.d == null) {
            LocationClient locationClient = new LocationClient(AppRuntime.getAppContext());
            this.d = locationClient;
            locationClient.registerLocationListener(new a(this));
            LocationClientOption locationClientOption = new LocationClientOption();
            locationClientOption.setOpenGps(true);
            locationClientOption.setCoorType(CoordType.GCJ02.name());
            locationClientOption.setScanSpan(1000);
            this.d.setLocOption(locationClientOption);
        }
    }

    public void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            n();
            this.g = false;
            if (Build.VERSION.SDK_INT > 19) {
                for (rg4 rg4Var : this.a) {
                    rg4Var.l.onDestroy();
                }
            }
            this.a.clear();
        }
    }

    @Override // android.hardware.SensorEventListener
    public void onSensorChanged(SensorEvent sensorEvent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, sensorEvent) == null) {
            double d = sensorEvent.values[0];
            if (Math.abs(d - this.c) > 1.0d) {
                for (rg4 rg4Var : this.a) {
                    MyLocationData locationData = rg4Var.l.getMap().getLocationData();
                    if (locationData != null && rg4Var.k) {
                        rg4Var.l.getMap().setMyLocationData(new MyLocationData.Builder().direction((float) d).accuracy(locationData.accuracy).latitude(locationData.latitude).longitude(locationData.longitude).satellitesNum(locationData.satellitesNum).build());
                        f();
                    }
                }
            }
            this.c = d;
        }
    }
}
