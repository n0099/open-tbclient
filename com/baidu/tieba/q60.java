package com.baidu.tieba;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.util.devices.RomUtils;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.material.internal.ManufacturerUtils;
/* loaded from: classes7.dex */
public class q60 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile q60 a;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes7.dex */
    public interface a {
        void a(boolean z, String str);
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1948043646, "Lcom/baidu/tieba/q60;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1948043646, "Lcom/baidu/tieba/q60;");
        }
    }

    public q60() {
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

    public static q60 a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            if (a == null) {
                synchronized (q60.class) {
                    if (a == null) {
                        a = new q60();
                        return a;
                    }
                    return null;
                }
            }
            return null;
        }
        return (q60) invokeV.objValue;
    }

    public static boolean c(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, context)) == null) {
            try {
                return context.getPackageManager().getPackageInfo("com.huawei.hwid", 0) != null;
            } catch (Throwable unused) {
                return false;
            }
        }
        return invokeL.booleanValue;
    }

    public static boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            try {
                String str = Build.BRAND;
                boolean equalsIgnoreCase = !TextUtils.isEmpty(str) ? str.equalsIgnoreCase("vivo") : false;
                try {
                    if (Build.VERSION.SDK_INT < 28) {
                        return false;
                    }
                } catch (Throwable unused) {
                }
                return equalsIgnoreCase;
            } catch (Throwable unused2) {
                return false;
            }
        }
        return invokeV.booleanValue;
    }

    public static boolean e(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, context)) == null) {
            try {
                if (Build.VERSION.SDK_INT < 29) {
                    return false;
                }
                return context.getPackageManager().getPackageInfo("com.meizu.flyme.openidsdk", 0) != null;
            } catch (Throwable unused) {
                return false;
            }
        }
        return invokeL.booleanValue;
    }

    public static boolean f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65542, null)) == null) {
            try {
                String str = Build.BRAND;
                boolean equalsIgnoreCase = !TextUtils.isEmpty(str) ? str.equalsIgnoreCase(ManufacturerUtils.SAMSUNG) : false;
                try {
                    if (Build.VERSION.SDK_INT < 29) {
                        return false;
                    }
                } catch (Throwable unused) {
                }
                return equalsIgnoreCase;
            } catch (Throwable unused2) {
                return false;
            }
        }
        return invokeV.booleanValue;
    }

    public static boolean g(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, context)) == null) {
            try {
                if (Build.VERSION.SDK_INT < 29) {
                    return false;
                }
                return context.getPackageManager().getPackageInfo("com.zui.deviceidservice", 0) != null;
            } catch (Throwable unused) {
                return false;
            }
        }
        return invokeL.booleanValue;
    }

    public static boolean h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65544, null)) == null) {
            try {
                if (Build.VERSION.SDK_INT < 29) {
                    return false;
                }
                String str = Build.BRAND;
                if (TextUtils.isEmpty(str)) {
                    return false;
                }
                return str.equalsIgnoreCase(RomUtils.MANUFACTURER_NUBIA);
            } catch (Throwable unused) {
                return false;
            }
        }
        return invokeV.booleanValue;
    }

    public static boolean i(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, null, context)) == null) {
            try {
                if (Build.VERSION.SDK_INT < 29) {
                    return false;
                }
                return context.getPackageManager().getPackageInfo("com.asus.msa.SupplementaryDID", 0) != null;
            } catch (Throwable unused) {
                return false;
            }
        }
        return invokeL.booleanValue;
    }

    public void b(Context context, a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, context, aVar) == null) {
            if (k()) {
                r60.a(context, aVar);
            } else if (d()) {
                t60.a(context, aVar);
            } else if (c(context)) {
                l60.a(context, aVar);
            } else if (j()) {
                o60.a(context, aVar);
            } else if (f()) {
                s60.a(context, aVar);
            } else if (e(context)) {
                n60.a(context, aVar);
            } else if (h()) {
                p60.a(context, aVar);
            } else if (g(context)) {
                m60.a(context, aVar);
            } else if (i(context)) {
                k60.a(context, aVar);
            } else {
                aVar.a(false, null);
            }
        }
    }

    public final boolean j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            try {
                String str = Build.BRAND;
                if (TextUtils.isEmpty(str)) {
                    return false;
                }
                if (!str.equalsIgnoreCase(RomUtils.MANUFACTURER_XIAOMI) && !str.equalsIgnoreCase("redmi")) {
                    if (!str.equalsIgnoreCase("blackshark")) {
                        return false;
                    }
                }
                return true;
            } catch (Throwable unused) {
                return false;
            }
        }
        return invokeV.booleanValue;
    }

    /* JADX WARN: Can't wrap try/catch for region: R(11:3|4|5|(9:7|(1:11)|14|15|16|17|(1:22)|19|20)|25|15|16|17|(0)|19|20) */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x0023, code lost:
        if (r1.equalsIgnoreCase("oneplus") != false) goto L14;
     */
    /* JADX WARN: Removed duplicated region for block: B:31:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean k() {
        InterceptResult invokeV;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            try {
                String str = Build.BRAND;
                if (!TextUtils.isEmpty(str)) {
                    if (!str.equalsIgnoreCase("oppo") && !str.equalsIgnoreCase("realme")) {
                    }
                    z = true;
                    if (Build.VERSION.SDK_INT < 28) {
                        return false;
                    }
                    return z;
                }
                z = false;
                if (Build.VERSION.SDK_INT < 28) {
                }
                return z;
            } catch (Throwable unused) {
                return false;
            }
        }
        return invokeV.booleanValue;
    }
}
