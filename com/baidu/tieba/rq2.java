package com.baidu.tieba;

import android.graphics.Color;
import android.text.TextUtils;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class rq2 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static int a(String str, int i) {
        InterceptResult invokeLI;
        long parseLong;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65536, null, str, i)) == null) {
            if (TextUtils.isEmpty(str)) {
                e12.o("map", "color string is empty, use default " + Integer.toHexString(i));
                return i;
            }
            try {
                if (str.charAt(0) == '#') {
                    String substring = str.substring(1);
                    if (substring.length() != 6 && substring.length() != 8) {
                        throw new IllegalArgumentException("char count not right");
                    }
                    if (substring.length() == 6) {
                        parseLong = Long.parseLong(substring, 16) | (-16777216);
                    } else {
                        parseLong = Long.parseLong(substring.substring(6) + substring.substring(0, 6), 16);
                    }
                    return (int) parseLong;
                }
                return Color.parseColor(str);
            } catch (IllegalArgumentException unused) {
                e12.o("map", "parse color error, use default " + Integer.toHexString(i));
                return i;
            }
        }
        return invokeLI.intValue;
    }

    public static float b(double d) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65537, null, new Object[]{Double.valueOf(d)})) == null) {
            return (float) (d * vh3.l(AppRuntime.getAppContext()));
        }
        return invokeCommon.floatValue;
    }
}
