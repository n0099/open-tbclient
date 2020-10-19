package com.baidu.vi;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Handler;
import android.os.Message;
import java.util.List;
/* loaded from: classes7.dex */
final class c extends Handler {
    @Override // android.os.Handler
    public void handleMessage(Message message) {
        SensorManager sensorManager;
        SensorEventListener sensorEventListener;
        SensorManager sensorManager2;
        SensorManager sensorManager3;
        SensorManager sensorManager4;
        SensorEventListener sensorEventListener2;
        VCompass vCompass = (VCompass) message.obj;
        if (vCompass == null) {
            return;
        }
        switch (message.what) {
            case 1:
                Context context = VIContext.getContext();
                sensorManager2 = vCompass.f3901a;
                if (sensorManager2 == null) {
                    vCompass.f3901a = (SensorManager) context.getSystemService("sensor");
                }
                sensorManager3 = vCompass.f3901a;
                List<Sensor> sensorList = sensorManager3.getSensorList(3);
                if (sensorList.size() > 0) {
                    sensorManager4 = vCompass.f3901a;
                    sensorEventListener2 = vCompass.f;
                    sensorManager4.registerListener(sensorEventListener2, sensorList.get(0), 1);
                    return;
                }
                return;
            case 2:
                sensorManager = vCompass.f3901a;
                sensorEventListener = vCompass.f;
                sensorManager.unregisterListener(sensorEventListener);
                return;
            default:
                return;
        }
    }
}
