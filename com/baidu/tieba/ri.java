package com.baidu.tieba;

import android.graphics.Paint;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class ri {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static int a(float f, Paint paint, String str, int i) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65536, null, new Object[]{Float.valueOf(f), paint, str, Integer.valueOf(i)})) == null) {
            if (f == 0.0f || i == 0 || str == null || str.isEmpty()) {
                return 0;
            }
            if (!str.contains("\n")) {
                return Math.min((int) Math.ceil(paint.measureText(str) / f), i);
            }
            String[] split = str.split("\n");
            if (split.length > i) {
                return Math.min(split.length, i);
            }
            int i2 = 0;
            for (int i3 = 0; i3 < i && split.length > i3; i3++) {
                if (i3 < i - 1) {
                    i2 += (int) Math.ceil(paint.measureText(split[i3]) / f);
                } else {
                    i2++;
                }
            }
            return Math.min(i2, i);
        }
        return invokeCommon.intValue;
    }

    public static boolean b(float f, Paint paint, String str, int i) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65537, null, new Object[]{Float.valueOf(f), paint, str, Integer.valueOf(i)})) == null) {
            return c(f, paint, str, i, 5);
        }
        return invokeCommon.booleanValue;
    }

    public static boolean c(float f, Paint paint, String str, int i, int i2) {
        InterceptResult invokeCommon;
        float measureText;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65538, null, new Object[]{Float.valueOf(f), paint, str, Integer.valueOf(i), Integer.valueOf(i2)})) == null) {
            float f2 = 0.0f;
            if (f != 0.0f && i != 0 && str != null && !str.isEmpty() && paint != null) {
                if (!str.contains("\n")) {
                    if (paint.measureText(str) < f * i) {
                        return false;
                    }
                    return true;
                }
                String[] split = str.split("\n");
                if (split.length > i) {
                    return true;
                }
                int i3 = 0;
                for (int i4 = 0; i4 < i && split.length > i4; i4++) {
                    if (i4 < i - 1) {
                        measureText = paint.measureText(split[i4]);
                        int ceil = (int) Math.ceil(measureText / f);
                        i3 += ceil;
                        if (i3 < i2) {
                            measureText = ceil * f;
                        }
                    } else {
                        measureText = paint.measureText(split[i4]);
                        i3++;
                    }
                    f2 += measureText;
                    if (i3 >= 5) {
                        if (f2 < f * i) {
                            return false;
                        }
                        return true;
                    }
                }
            }
            return false;
        }
        return invokeCommon.booleanValue;
    }
}
