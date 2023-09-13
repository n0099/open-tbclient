package com.baidu.tieba;

import android.graphics.PointF;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes8.dex */
public class xib {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static float a(PointF pointF, PointF pointF2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65536, null, pointF, pointF2)) == null) {
            if (pointF != null && pointF2 != null) {
                float b = ((pointF.x * pointF2.x) + (pointF.y * pointF2.y)) / (b(pointF) * b(pointF2));
                if (b <= 1.0f && b >= -1.0f) {
                    return ((pointF.x * pointF2.y) - (pointF2.x * pointF.y) > 0.0f ? 1 : -1) * (360.0f - ((float) Math.toDegrees(Math.acos(b))));
                }
            }
            return 0.0f;
        }
        return invokeLL.floatValue;
    }

    public static float b(PointF pointF) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, pointF)) == null) {
            float f = pointF.x;
            float f2 = pointF.y;
            return (float) Math.sqrt((f * f) + (f2 * f2));
        }
        return invokeL.floatValue;
    }

    public static float c(PointF pointF, PointF pointF2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, pointF, pointF2)) == null) {
            float f = pointF.x;
            float f2 = pointF2.x;
            float f3 = pointF.y;
            float f4 = pointF2.y;
            return (float) Math.sqrt(((f - f2) * (f - f2)) + ((f3 - f4) * (f3 - f4)));
        }
        return invokeLL.floatValue;
    }

    public static PointF d(PointF pointF, PointF pointF2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, pointF, pointF2)) == null) ? new PointF(pointF2.x - pointF.x, pointF2.y - pointF.y) : (PointF) invokeLL.objValue;
    }

    public static float e(PointF pointF, PointF pointF2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, pointF, pointF2)) == null) {
            if (pointF == null || pointF2 == null) {
                return 1.0f;
            }
            return b(pointF2) / b(pointF);
        }
        return invokeLL.floatValue;
    }
}
