package com.baidu.tieba;

import android.graphics.PointF;
import android.view.MotionEvent;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes4.dex */
public class li5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static float a(float f, float f2, float f3, float f4) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65536, null, new Object[]{Float.valueOf(f), Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4)})) == null) {
            return (float) Math.sqrt(Math.pow(f - f3, 2.0d) + Math.pow(f2 - f4, 2.0d));
        }
        return invokeCommon.floatValue;
    }

    public static PointF b(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, motionEvent)) == null) {
            if (motionEvent == null) {
                return null;
            }
            PointF pointF = new PointF();
            pointF.set((motionEvent.getX(0) + motionEvent.getX(1)) / 2.0f, (motionEvent.getY(0) + motionEvent.getY(1)) / 2.0f);
            return pointF;
        }
        return (PointF) invokeL.objValue;
    }

    public static float c(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, motionEvent)) == null) {
            if (motionEvent == null) {
                return 0.0f;
            }
            return (float) Math.toDegrees(Math.atan2(motionEvent.getY(0) - motionEvent.getY(1), motionEvent.getX(0) - motionEvent.getX(1)));
        }
        return invokeL.floatValue;
    }

    public static float d(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, motionEvent)) == null) {
            if (motionEvent == null) {
                return 0.0f;
            }
            float x = motionEvent.getX(0) - motionEvent.getX(1);
            float y = motionEvent.getY(0) - motionEvent.getY(1);
            return (float) Math.sqrt((x * x) + (y * y));
        }
        return invokeL.floatValue;
    }

    public static boolean e(float[] fArr, float f, float f2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, null, new Object[]{fArr, Float.valueOf(f), Float.valueOf(f2)})) == null) {
            if (fArr != null && fArr.length == 8) {
                float f3 = fArr[0];
                float f4 = fArr[1];
                float f5 = fArr[2];
                float f6 = fArr[3];
                float f7 = fArr[4];
                float f8 = fArr[5];
                float f9 = fArr[6];
                float f10 = fArr[7];
                float a = a(f3, f4, f5, f6);
                float f11 = f(f3, f4, f5, f6, f, f2);
                float a2 = a(f5, f6, f9, f10);
                float f12 = f(f5, f6, f9, f10, f, f2);
                float f13 = f(f9, f10, f7, f8, f, f2);
                float f14 = f(f7, f8, f3, f4, f, f2);
                if (a > 0.0f && a2 > 0.0f && f11 <= a2 && f13 <= a2 && f12 <= a && f14 <= a) {
                    return true;
                }
            }
            return false;
        }
        return invokeCommon.booleanValue;
    }

    public static float f(float f, float f2, float f3, float f4, float f5, float f6) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65541, null, new Object[]{Float.valueOf(f), Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4), Float.valueOf(f5), Float.valueOf(f6)})) == null) {
            float a = a(f, f2, f3, f4);
            float a2 = a(f, f2, f5, f6);
            float a3 = a(f3, f4, f5, f6);
            if (a == 0.0f) {
                return a2;
            }
            if (a2 == 0.0f || a3 == 0.0f) {
                return 0.0f;
            }
            float f7 = ((a + a2) + a3) / 2.0f;
            return (((float) Math.sqrt((((f7 - a) * f7) * (f7 - a2)) * (f7 - a3))) * 2.0f) / a;
        }
        return invokeCommon.floatValue;
    }
}
