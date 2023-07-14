package com.baidu.vi;

import android.net.NetworkInfo;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes9.dex */
public /* synthetic */ class i {
    public static /* synthetic */ Interceptable $ic;
    public static final /* synthetic */ int[] a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(356320128, "Lcom/baidu/vi/i;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(356320128, "Lcom/baidu/vi/i;");
                return;
            }
        }
        int[] iArr = new int[NetworkInfo.State.values().length];
        a = iArr;
        try {
            iArr[NetworkInfo.State.CONNECTED.ordinal()] = 1;
        } catch (NoSuchFieldError unused) {
        }
        try {
            a[NetworkInfo.State.CONNECTING.ordinal()] = 2;
        } catch (NoSuchFieldError unused2) {
        }
        try {
            a[NetworkInfo.State.DISCONNECTED.ordinal()] = 3;
        } catch (NoSuchFieldError unused3) {
        }
        try {
            a[NetworkInfo.State.DISCONNECTING.ordinal()] = 4;
        } catch (NoSuchFieldError unused4) {
        }
        try {
            a[NetworkInfo.State.SUSPENDED.ordinal()] = 5;
        } catch (NoSuchFieldError unused5) {
        }
    }
}
