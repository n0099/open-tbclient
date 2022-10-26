package com.bun.miitmdid.core;

import android.content.Context;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bun.miitmdid.e;
import com.bun.miitmdid.interfaces.IIdentifierListener;
/* loaded from: classes7.dex */
public class MdidSdkHelper {
    public static /* synthetic */ Interceptable $ic;
    public static final int SDK_VERSION_CODE;
    public static long globalTimeout;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1700383277, "Lcom/bun/miitmdid/core/MdidSdkHelper;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1700383277, "Lcom/bun/miitmdid/core/MdidSdkHelper;");
                return;
            }
        }
        SDK_VERSION_CODE = e.a();
        globalTimeout = 5000L;
    }

    public MdidSdkHelper() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static boolean InitCert(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, context, str)) == null) {
            try {
                return e.a(context, str);
            } catch (AbstractMethodError | Error unused) {
                return false;
            }
        }
        return invokeLL.booleanValue;
    }

    public static int InitSdk(Context context, boolean z, IIdentifierListener iIdentifierListener) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65539, null, new Object[]{context, Boolean.valueOf(z), iIdentifierListener})) == null) {
            try {
                return new e(z, globalTimeout).a(context, iIdentifierListener);
            } catch (UnsatisfiedLinkError unused) {
                return 1008615;
            }
        }
        return invokeCommon.intValue;
    }

    public static int InitSdk(Context context, boolean z, boolean z2, boolean z3, boolean z4, IIdentifierListener iIdentifierListener) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, null, new Object[]{context, Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(z3), Boolean.valueOf(z4), iIdentifierListener})) == null) {
            try {
                return new e(z, globalTimeout, z2, z3, z4).a(context, iIdentifierListener);
            } catch (UnsatisfiedLinkError unused) {
                return 1008615;
            }
        }
        return invokeCommon.intValue;
    }

    public static boolean setGlobalTimeout(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(65541, null, j)) == null) {
            if (j > 0) {
                globalTimeout = j;
                return true;
            }
            return false;
        }
        return invokeJ.booleanValue;
    }
}
