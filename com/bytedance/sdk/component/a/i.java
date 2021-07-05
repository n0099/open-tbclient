package com.bytedance.sdk.component.a;

import android.util.Log;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class i {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static boolean f27646a;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65539, null, z) == null) {
            f27646a = z;
        }
    }

    public static void b(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65540, null, str) == null) && f27646a) {
            Log.w("JsBridge2", str);
        }
    }

    public static void a(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65537, null, str) == null) && f27646a) {
            Log.i("JsBridge2", str);
        }
    }

    public static void b(String str, Throwable th) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(AdIconUtil.AD_TEXT_ID, null, str, th) == null) && f27646a) {
            Log.e("JsBridge2", str, th);
            Log.e("JsBridge2", "Stacktrace: " + Log.getStackTraceString(th));
        }
    }

    public static void a(String str, Throwable th) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65538, null, str, th) == null) && f27646a) {
            Log.w("JsBridge2", str, th);
            Log.w("JsBridge2", "Stacktrace: " + Log.getStackTraceString(th));
        }
    }

    public static void a(RuntimeException runtimeException) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65536, null, runtimeException) == null) && f27646a) {
            throw runtimeException;
        }
    }
}
