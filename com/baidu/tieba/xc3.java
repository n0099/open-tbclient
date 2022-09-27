package com.baidu.tieba;

import android.annotation.SuppressLint;
import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.util.Log;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class xc3 implements SensorEventListener {
    public static /* synthetic */ Interceptable $ic;
    @SuppressLint({"StaticFieldLeak"})
    public static volatile xc3 i;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;
    public SensorManager b;
    public Sensor c;
    public a d;
    public double[] e;
    public boolean f;
    public long g;
    public int h;

    /* loaded from: classes6.dex */
    public interface a {
        void a(double[] dArr);
    }

    public xc3() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.e = new double[3];
        this.f = false;
        this.g = 0L;
    }

    public static xc3 a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (i == null) {
                synchronized (xc3.class) {
                    if (i == null) {
                        i = new xc3();
                    }
                }
            }
            return i;
        }
        return (xc3) invokeV.objValue;
    }

    public static synchronized void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65538, null) == null) {
            synchronized (xc3.class) {
                if (i == null) {
                    return;
                }
                i.c();
            }
        }
    }

    public synchronized void b(Context context, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048576, this, context, i2) == null) {
            synchronized (this) {
                this.a = context;
                this.h = i2;
            }
        }
    }

    public final synchronized void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            synchronized (this) {
                l02.i("accelerometer", "release");
                if (this.f) {
                    g();
                }
                this.a = null;
                i = null;
            }
        }
    }

    public synchronized void e(a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, aVar) == null) {
            synchronized (this) {
                this.d = aVar;
            }
        }
    }

    public synchronized void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            synchronized (this) {
                if (this.a == null) {
                    l02.c("accelerometer", "start error, none context");
                } else if (this.f) {
                    l02.o("accelerometer", "has already start");
                } else {
                    SensorManager sensorManager = (SensorManager) this.a.getSystemService("sensor");
                    this.b = sensorManager;
                    if (sensorManager != null) {
                        Sensor defaultSensor = sensorManager.getDefaultSensor(1);
                        this.c = defaultSensor;
                        this.b.registerListener(this, defaultSensor, 1);
                        this.f = true;
                        l02.i("accelerometer", "start listen");
                    } else {
                        l02.c("accelerometer", "none sensorManager");
                    }
                }
            }
        }
    }

    public synchronized void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            synchronized (this) {
                if (!this.f) {
                    l02.o("accelerometer", "has already stop");
                    return;
                }
                if (this.b != null) {
                    this.b.unregisterListener(this);
                }
                this.b = null;
                this.c = null;
                this.f = false;
            }
        }
    }

    @Override // android.hardware.SensorEventListener
    public void onAccuracyChanged(Sensor sensor, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048581, this, sensor, i2) == null) {
        }
    }

    @Override // android.hardware.SensorEventListener
    public void onSensorChanged(SensorEvent sensorEvent) {
        Sensor sensor;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048582, this, sensorEvent) == null) || sensorEvent == null || (sensor = sensorEvent.sensor) == null || sensor.getType() != 1) {
            return;
        }
        float[] fArr = sensorEvent.values;
        if (fArr != null && fArr.length == 3) {
            synchronized (this) {
                if (this.f && this.d != null && System.currentTimeMillis() - this.g > this.h) {
                    this.e[0] = (-sensorEvent.values[0]) / 9.8d;
                    this.e[1] = (-sensorEvent.values[1]) / 9.8d;
                    this.e[2] = (-sensorEvent.values[2]) / 9.8d;
                    this.d.a(this.e);
                    this.g = System.currentTimeMillis();
                }
                if (l33.v) {
                    Log.d("AccelerometerManager", "current Time : " + this.g + "current Acc x : " + this.e[0] + "current Acc y : " + this.e[1] + "current Acc z : " + this.e[2]);
                }
            }
            return;
        }
        l02.o("accelerometer", "illegal accelerometer event");
    }
}
