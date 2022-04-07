package com.bun.miitmdid;

import android.content.Context;
import android.os.Build;
import android.telephony.TelephonyManager;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class f {
    public static /* synthetic */ Interceptable $ic;
    public static final f a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-2134063299, "Lcom/bun/miitmdid/f;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-2134063299, "Lcom/bun/miitmdid/f;");
                return;
            }
        }
        a = new f();
    }

    public f() {
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

    public static f a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? a : (f) invokeV.objValue;
    }

    public int a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, context)) == null) {
            String str = Build.FINGERPRINT;
            if (str.startsWith("generic")) {
                return 11;
            }
            if (str.toLowerCase().contains("vbox")) {
                return 12;
            }
            if (str.toLowerCase().contains("test-keys")) {
                return 13;
            }
            String str2 = Build.MODEL;
            if (str2.contains("google_sdk")) {
                return 14;
            }
            if (str2.contains("Emulator")) {
                return 15;
            }
            if (str2.contains("Android SDK built for x86")) {
                return 17;
            }
            if (Build.MANUFACTURER.contains("Genymotion")) {
                return 18;
            }
            if (Build.BRAND.startsWith("generic") && Build.DEVICE.startsWith("generic")) {
                return 19;
            }
            if (Build.PRODUCT.equals("google_sdk")) {
                return 20;
            }
            return ((TelephonyManager) context.getSystemService("phone")).getNetworkOperatorName().toLowerCase().equals("android") ? 21 : 0;
        }
        return invokeL.intValue;
    }
}
