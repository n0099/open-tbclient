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
/* loaded from: classes8.dex */
public final class v31 extends NadSensorAbsHelper {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public float i;
    public int j;

    @Override // com.baidu.nadcore.rotation.NadSensorAbsHelper
    public int j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return 1;
        }
        return invokeV.intValue;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public v31(Context context, t31 listener) {
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
        this.i = 1.0f;
    }

    @Override // com.baidu.nadcore.rotation.NadSensorAbsHelper
    public int f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            int c = e().c();
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
    public void k(SensorEvent sensorEvent) {
        Sensor sensor;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, sensorEvent) == null) && sensorEvent != null && (sensor = sensorEvent.sensor) != null && sensor.getType() == 1) {
            float[] fArr = sensorEvent.values;
            float f = fArr[0];
            if (Math.pow(f, 2.0d) + Math.pow(fArr[1], 2.0d) + Math.pow(fArr[2], 2.0d) < Math.pow(e().b(), 2.0d)) {
                return;
            }
            if (this.i * f >= 0) {
                this.i = f;
                return;
            }
            this.i = f;
            int i = this.j + 1;
            this.j = i;
            if (i >= e().a()) {
                d().h();
            }
        }
    }

    @Override // com.baidu.nadcore.rotation.NadSensorAbsHelper
    public void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            super.q();
            this.j = 0;
            this.i = 1.0f;
        }
    }
}
