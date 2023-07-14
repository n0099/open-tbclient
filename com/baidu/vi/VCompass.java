package com.baidu.vi;

import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Handler;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes9.dex */
public class VCompass {
    public static /* synthetic */ Interceptable $ic;
    public static final Handler e;
    public transient /* synthetic */ FieldHolder $fh;
    public SensorManager a;
    public float b;
    public float c;
    public int d;
    public SensorEventListener f;

    private float a(float f, float f2, float f3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65539, this, new Object[]{Float.valueOf(f), Float.valueOf(f2), Float.valueOf(f3)})) == null) {
            float f4 = f - f2;
            return (f4 > 180.0f || f4 < -180.0f) ? f2 : (f4 < (-f3) || f3 < f4) ? (f + f2) / 2.0f : f;
        }
        return invokeCommon.floatValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public native void updateCompass(int i);

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(2120302993, "Lcom/baidu/vi/VCompass;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(2120302993, "Lcom/baidu/vi/VCompass;");
                return;
            }
        }
        e = new c();
    }

    public VCompass() {
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
        this.a = null;
        this.c = 2.0f;
        this.d = 0;
        this.f = new d(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public float a(float f) {
        InterceptResult invokeF;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeF = interceptable.invokeF(65538, this, f)) == null) {
            float a = a(this.b, f, this.c);
            this.b = a;
            return a;
        }
        return invokeF.floatValue;
    }
}
