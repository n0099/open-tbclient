package com.baidu.tieba;

import com.badlogic.gdx.utils.JsonWriter$OutputType;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public /* synthetic */ class k7 {
    public static /* synthetic */ Interceptable $ic;
    public static final /* synthetic */ int[] a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1448307713, "Lcom/baidu/tieba/k7;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1448307713, "Lcom/baidu/tieba/k7;");
                return;
            }
        }
        int[] iArr = new int[JsonWriter$OutputType.values().length];
        a = iArr;
        try {
            iArr[JsonWriter$OutputType.minimal.ordinal()] = 1;
        } catch (NoSuchFieldError unused) {
        }
        try {
            a[JsonWriter$OutputType.javascript.ordinal()] = 2;
        } catch (NoSuchFieldError unused2) {
        }
    }
}
