package com.baidu.vi;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Handler;
import android.os.Message;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes9.dex */
public final class c extends Handler {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public c() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        VCompass vCompass;
        SensorManager sensorManager;
        SensorManager sensorManager2;
        SensorManager sensorManager3;
        SensorEventListener sensorEventListener;
        SensorManager sensorManager4;
        SensorEventListener sensorEventListener2;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048576, this, message) != null) || (vCompass = (VCompass) message.obj) == null) {
            return;
        }
        int i = message.what;
        if (i != 1) {
            if (i != 2) {
                return;
            }
            sensorManager4 = vCompass.a;
            sensorEventListener2 = vCompass.f;
            sensorManager4.unregisterListener(sensorEventListener2);
            return;
        }
        Context context = VIContext.getContext();
        sensorManager = vCompass.a;
        if (sensorManager == null) {
            vCompass.a = (SensorManager) context.getSystemService("sensor");
        }
        sensorManager2 = vCompass.a;
        List<Sensor> sensorList = sensorManager2.getSensorList(3);
        if (sensorList.size() <= 0) {
            return;
        }
        sensorManager3 = vCompass.a;
        sensorEventListener = vCompass.f;
        sensorManager3.registerListener(sensorEventListener, sensorList.get(0), 1);
    }
}
