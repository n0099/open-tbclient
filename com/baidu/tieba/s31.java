package com.baidu.tieba;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nadcore.rotation.NadSensorAbsHelper;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes7.dex */
public final class s31 extends NadSensorAbsHelper {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Float[] i;
    public Boolean[] j;
    public Integer[] k;
    public Float[] l;
    public float m;
    public float n;
    public float o;

    @Override // com.baidu.nadcore.rotation.NadSensorAbsHelper
    public int f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return 2;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.nadcore.rotation.NadSensorAbsHelper
    public int j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return 9;
        }
        return invokeV.intValue;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public s31(Context context, t31 listener) {
        super(context, listener);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, listener};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (t31) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(listener, "listener");
        Float valueOf = Float.valueOf(-1.0f);
        this.i = new Float[]{valueOf, valueOf, valueOf};
        Boolean bool = Boolean.FALSE;
        this.j = new Boolean[]{bool, bool, bool};
        this.k = new Integer[]{45, 45, 45, 45, 45, 45};
        Float valueOf2 = Float.valueOf(0.0f);
        this.l = new Float[]{valueOf2, valueOf2, valueOf2};
    }

    public final float t(int i, float f) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048582, this, new Object[]{Integer.valueOf(i), Float.valueOf(f)})) == null) {
            float floatValue = this.i[i].floatValue();
            if (this.j[i].booleanValue()) {
                if (floatValue == -1.0f) {
                    this.i[i] = Float.valueOf(f);
                    floatValue = f;
                }
            } else {
                floatValue = 180.0f;
            }
            int i2 = i * 2;
            int intValue = this.k[i2].intValue();
            float intValue2 = this.k[i2 + 1].intValue() + floatValue;
            float f2 = floatValue - intValue;
            if (f > intValue2) {
                f = intValue2;
            }
            if (f < f2) {
                f = f2;
            }
            if (intValue2 == f2) {
                return 0.0f;
            }
            return (f - f2) / (intValue2 - f2);
        }
        return invokeCommon.floatValue;
    }

    @Override // com.baidu.nadcore.rotation.NadSensorAbsHelper
    public void k(SensorEvent sensorEvent) {
        Sensor sensor;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, sensorEvent) == null) && sensorEvent != null && (sensor = sensorEvent.sensor) != null && sensor.getType() == 9) {
            float[] fArr = sensorEvent.values;
            float f = fArr[0];
            float f2 = fArr[1];
            float f3 = fArr[2];
            float abs = Math.abs(this.m - f);
            float abs2 = Math.abs(this.n - f2);
            float abs3 = Math.abs(this.o - f3);
            if (abs > 0.01d || abs2 > 0.01d || abs3 > 0.01d) {
                r(f, f2, f3);
            }
            this.m = f;
            this.n = f2;
            this.o = f3;
        }
    }

    @Override // com.baidu.nadcore.rotation.NadSensorAbsHelper
    public void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            super.q();
            Float valueOf = Float.valueOf(-1.0f);
            this.i = new Float[]{valueOf, valueOf, valueOf};
        }
    }

    public final void r(float f, float f2, float f3) {
        t31 d;
        t31 d2;
        t31 d3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{Float.valueOf(f), Float.valueOf(f2), Float.valueOf(f3)}) == null) {
            float floatValue = this.l[0].floatValue() * 9.80665f;
            float abs = Math.abs(f3);
            if (abs >= 0.0f && abs <= floatValue) {
                float t = t(0, s(0, f, f2, f3));
                t31 d4 = d();
                if (d4 != null) {
                    d4.b(t);
                }
                if (t == 0.0f) {
                    t31 d5 = d();
                    if (d5 != null) {
                        d5.e(0);
                    }
                } else if (t == 1.0f && (d3 = d()) != null) {
                    d3.e(1);
                }
            }
            float floatValue2 = this.l[1].floatValue() * 9.80665f;
            float abs2 = Math.abs(f2);
            if (abs2 >= 0.0f && abs2 <= floatValue2) {
                float t2 = t(1, s(1, f, f2, f3));
                t31 d6 = d();
                if (d6 != null) {
                    d6.c(t2);
                }
                if (t2 == 0.0f) {
                    t31 d7 = d();
                    if (d7 != null) {
                        d7.f(0);
                    }
                } else if (t2 == 1.0f && (d2 = d()) != null) {
                    d2.f(1);
                }
            }
            float floatValue3 = this.l[2].floatValue() * 9.80665f;
            float abs3 = Math.abs(f);
            if (abs3 >= 0.0f && abs3 <= floatValue3) {
                float t3 = t(2, s(2, f, f2, f3));
                t31 d8 = d();
                if (d8 != null) {
                    d8.d(t3);
                }
                if (t3 == 0.0f) {
                    t31 d9 = d();
                    if (d9 != null) {
                        d9.g(0);
                    }
                } else if (t3 == 1.0f && (d = d()) != null) {
                    d.g(1);
                }
            }
        }
    }

    public final float s(int i, float f, float f2, float f3) {
        InterceptResult invokeCommon;
        double degrees;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048581, this, new Object[]{Integer.valueOf(i), Float.valueOf(f), Float.valueOf(f2), Float.valueOf(f3)})) == null) {
            if (i != 0) {
                if (i != 1) {
                    if (i != 2) {
                        return 180.0f;
                    }
                    degrees = Math.toDegrees(Math.atan2(f, f3));
                } else {
                    degrees = Math.toDegrees(Math.atan2(f2, f3));
                }
            } else {
                degrees = Math.toDegrees(Math.atan2(f, f2));
            }
            return 180.0f - ((float) degrees);
        }
        return invokeCommon.floatValue;
    }

    public final void u(int i, int i2, int i3, float f, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048583, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Float.valueOf(f), Boolean.valueOf(z)}) == null) {
            int i4 = i * 2;
            this.k[i4] = Integer.valueOf(i2);
            this.k[i4 + 1] = Integer.valueOf(i3);
            this.l[i] = Float.valueOf(f);
            this.j[i] = Boolean.valueOf(z);
        }
    }
}
