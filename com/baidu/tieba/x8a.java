package com.baidu.tieba;

import android.app.Activity;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.os.Handler;
import android.os.Looper;
import android.provider.Settings;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.u8a;
import com.baidu.tieba.y8a;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.ref.WeakReference;
/* loaded from: classes9.dex */
public class x8a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public WeakReference<Activity> a;
    public SensorManager b;
    public u8a c;
    public Sensor d;
    public boolean e;
    public boolean f;
    public y8a g;
    public boolean h;
    public boolean i;
    public u8a.a j;
    public y8a.a k;

    /* loaded from: classes9.dex */
    public class a implements u8a.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ x8a a;

        public a(x8a x8aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {x8aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = x8aVar;
        }

        @Override // com.baidu.tieba.u8a.a
        public void a(int i) {
            Activity activity;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeI(1048576, this, i) != null) || this.a.a == null || (activity = (Activity) this.a.a.get()) == null || !this.a.i) {
                return;
            }
            int requestedOrientation = activity.getRequestedOrientation();
            if (!this.a.h) {
                if (i > 225 && i < 315) {
                    if (requestedOrientation == 8) {
                        activity.setRequestedOrientation(0);
                    }
                } else if (i > 45 && i < 135 && requestedOrientation == 0) {
                    activity.setRequestedOrientation(8);
                }
            } else if ((i > 235 && i < 305) || (i > 55 && i < 125)) {
                if (!this.a.f) {
                    if (i > 55 && i < 125) {
                        if (requestedOrientation != 8) {
                            activity.setRequestedOrientation(8);
                        }
                    } else if (requestedOrientation != 0) {
                        activity.setRequestedOrientation(0);
                    }
                }
                this.a.e = false;
            } else if ((i > 325 && i < 360) || (i >= 0 && i < 35)) {
                if (!this.a.e && requestedOrientation != 1) {
                    activity.setRequestedOrientation(1);
                }
                this.a.f = false;
            }
        }
    }

    /* loaded from: classes9.dex */
    public class b implements y8a.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ x8a a;

        public b(x8a x8aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {x8aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = x8aVar;
        }

        @Override // com.baidu.tieba.y8a.a
        public void onChange(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeZ(1048576, this, z) != null) {
                return;
            }
            this.a.h = z;
        }
    }

    public x8a(Activity activity) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {activity};
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
        this.f = false;
        this.h = false;
        this.i = false;
        this.j = new a(this);
        this.k = new b(this);
        if (activity == null) {
            return;
        }
        this.a = new WeakReference<>(activity);
        this.b = (SensorManager) activity.getApplicationContext().getSystemService("sensor");
        this.d = TbadkCoreApplication.getInst().getDefaultSensor(1);
        this.c = new u8a(this.j);
        if (activity.getClass().getName().contains("SwanAppActivity")) {
            activity.setRequestedOrientation(1);
        }
    }

    public void i(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
            this.i = z;
        }
    }

    public void j() {
        Activity activity;
        Sensor sensor;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            SensorManager sensorManager = this.b;
            if (sensorManager != null && (sensor = this.d) != null) {
                sensorManager.registerListener(this.c, sensor, 2);
            }
            WeakReference<Activity> weakReference = this.a;
            if (weakReference != null && (activity = weakReference.get()) != null) {
                y8a y8aVar = new y8a(activity.getApplicationContext(), new Handler(Looper.getMainLooper()));
                this.g = y8aVar;
                y8aVar.b(this.k);
                activity.getContentResolver().registerContentObserver(Settings.System.getUriFor("accelerometer_rotation"), true, this.g);
            }
        }
    }

    public void k() {
        Activity activity;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            SensorManager sensorManager = this.b;
            if (sensorManager != null) {
                sensorManager.unregisterListener(this.c);
            }
            WeakReference<Activity> weakReference = this.a;
            if (weakReference != null && this.g != null && (activity = weakReference.get()) != null) {
                activity.getContentResolver().unregisterContentObserver(this.g);
            }
        }
    }

    public void l() {
        WeakReference<Activity> weakReference;
        Activity activity;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048579, this) != null) || (weakReference = this.a) == null || (activity = weakReference.get()) == null) {
            return;
        }
        if (activity.getRequestedOrientation() == 1) {
            activity.setRequestedOrientation(0);
            this.e = true;
            return;
        }
        activity.setRequestedOrientation(1);
        this.f = true;
    }
}
