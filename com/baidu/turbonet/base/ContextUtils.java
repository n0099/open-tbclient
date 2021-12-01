package com.baidu.turbonet.base;

import android.content.Context;
import androidx.core.view.InputDeviceCompat;
import c.a.s0.a.a;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.turbonet.base.annotations.JNINamespace;
@JNINamespace
/* loaded from: classes11.dex */
public class ContextUtils {
    public static /* synthetic */ Interceptable $ic;
    public static Context a;
    public transient /* synthetic */ FieldHolder $fh;

    public ContextUtils() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static Context a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) ? a : (Context) invokeV.objValue;
    }

    public static void b(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, null, context) == null) {
            Context context2 = a;
            if (context2 != null && context2 != context) {
                a.a(org.webrtc.ContextUtils.TAG, "Multiple contexts detected, ignoring new application context.");
            } else {
                d(context);
            }
        }
    }

    public static void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65539, null) == null) {
            Context context = a;
            if (context != null) {
                nativeInitNativeSideApplicationContext(context);
                return;
            }
            throw new RuntimeException("Cannot have native global application context be null.");
        }
    }

    public static void d(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, context) == null) {
            if (context != null) {
                a = context;
                return;
            }
            throw new RuntimeException("Global application context cannot be set to null.");
        }
    }

    public static native void nativeInitNativeSideApplicationContext(Context context);
}
