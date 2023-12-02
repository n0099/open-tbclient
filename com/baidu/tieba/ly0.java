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
public final class ly0 extends NadSensorAbsHelper {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public float g;
    public int h;

    @Override // com.baidu.nadcore.rotation.NadSensorAbsHelper
    public int h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return 1;
        }
        return invokeV.intValue;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ly0(Context context, jy0 listener) {
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
                super((Context) objArr2[0], (jy0) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.g = 1.0f;
    }

    @Override // com.baidu.nadcore.rotation.NadSensorAbsHelper
    public int d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            int c = c().c();
            if (c >= 0 && 66 >= c) {
                return 1;
            }
            if ((67 <= c && 199 >= c) || c < 200) {
                return 2;
            }
            return 3;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.nadcore.rotation.NadSensorAbsHelper
    public void i(SensorEvent sensorEvent) {
        Sensor sensor;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, sensorEvent) == null) && sensorEvent != null && (sensor = sensorEvent.sensor) != null && sensor.getType() == 1) {
            float[] fArr = sensorEvent.values;
            float f = fArr[0];
            if (Math.pow(f, 2.0d) + Math.pow(fArr[1], 2.0d) + Math.pow(fArr[2], 2.0d) < Math.pow(c().b(), 2.0d)) {
                return;
            }
            if (this.g * f >= 0) {
                this.g = f;
                return;
            }
            this.g = f;
            int i = this.h + 1;
            this.h = i;
            if (i >= c().a()) {
                b().h();
            }
        }
    }

    @Override // com.baidu.nadcore.rotation.NadSensorAbsHelper
    public void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            super.o();
            this.h = 0;
            this.g = 1.0f;
        }
    }
}
