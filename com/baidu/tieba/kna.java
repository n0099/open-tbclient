package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public abstract class kna {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static float a(String str, float f) {
        InterceptResult invokeLF;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLF = interceptable.invokeLF(65536, null, str, f)) == null) {
            if (str == null) {
                return f;
            }
            try {
                return Float.parseFloat(str);
            } catch (Exception unused) {
                return f;
            }
        }
        return invokeLF.floatValue;
    }

    public static int b(String str, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65537, null, str, i)) == null) {
            if (str == null) {
                return i;
            }
            try {
                return Integer.parseInt(str);
            } catch (Exception unused) {
                return i;
            }
        }
        return invokeLI.intValue;
    }

    public static long c(String str, long j) {
        InterceptResult invokeLJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLJ = interceptable.invokeLJ(65538, null, str, j)) == null) {
            if (str == null) {
                return j;
            }
            try {
                return Long.parseLong(str);
            } catch (Exception unused) {
                return j;
            }
        }
        return invokeLJ.longValue;
    }
}
