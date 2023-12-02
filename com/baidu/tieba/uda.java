package com.baidu.tieba;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.chromium.net.NetError;
/* loaded from: classes8.dex */
public class uda implements SensorEventListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public a a;

    /* loaded from: classes8.dex */
    public interface a {
        void a(int i);
    }

    @Override // android.hardware.SensorEventListener
    public void onAccuracyChanged(Sensor sensor, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048576, this, sensor, i) == null) {
        }
    }

    public uda(a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {aVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = aVar;
    }

    @Override // android.hardware.SensorEventListener
    public void onSensorChanged(SensorEvent sensorEvent) {
        float[] fArr;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, sensorEvent) == null) && sensorEvent != null && (fArr = sensorEvent.values) != null && fArr.length >= 3) {
            float f = -fArr[0];
            float f2 = -fArr[1];
            float f3 = -fArr[2];
            if ((f * f) + (f2 * f2) >= f3 * f3) {
                int round = 90 - Math.round(((float) Math.atan2(-f2, f)) * 57.29578f);
                if (round >= 360) {
                    round += NetError.ERR_HTTP2_INADEQUATE_TRANSPORT_SECURITY;
                }
                if (round < 0) {
                    round += 360;
                }
                a aVar = this.a;
                if (aVar != null) {
                    aVar.a(round);
                }
            }
        }
    }
}
