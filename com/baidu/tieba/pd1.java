package com.baidu.tieba;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.os.Build;
import android.os.Process;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.lang.reflect.Method;
/* loaded from: classes7.dex */
public class pd1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Class a;
    public Class b;
    public Method c;
    public Method d;
    public Method e;
    public Method f;
    public boolean g;

    public pd1() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        e();
    }

    public static boolean g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            int i = Build.VERSION.SDK_INT;
            if (i >= 23) {
                return Process.is64Bit();
            }
            if (i < 21) {
                return false;
            }
            String[] strArr = Build.SUPPORTED_64_BIT_ABIS;
            if (strArr.length <= 0) {
                return false;
            }
            return Build.CPU_ABI.equals(strArr[0]);
        }
        return invokeV.booleanValue;
    }

    public boolean h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.g;
        }
        return invokeV.booleanValue;
    }

    public final void a(Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, obj) == null) {
            try {
                this.f.invoke(obj, new Object[0]);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    @SuppressLint({"PrivateApi"})
    public final Object c(File file) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, file)) == null) {
            try {
                return this.c.invoke(null, file);
            } catch (Throwable th) {
                th.printStackTrace();
                return null;
            }
        }
        return invokeL.objValue;
    }

    @TargetApi(21)
    public boolean b(Object obj, String str, File file) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, obj, str, file)) == null) {
            try {
                if (((Integer) this.e.invoke(null, obj, file, str)).intValue() != 1) {
                    return false;
                }
                return true;
            } catch (Throwable th) {
                th.printStackTrace();
                return false;
            }
        }
        return invokeLLL.booleanValue;
    }

    public int d(Object obj, String[] strArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, obj, strArr)) == null) {
            try {
                System.currentTimeMillis();
                return ((Integer) this.d.invoke(null, obj, strArr)).intValue();
            } catch (Throwable th) {
                th.printStackTrace();
                return -1;
            }
        }
        return invokeLL.intValue;
    }

    public final void e() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048580, this) != null) || !ud1.d()) {
            return;
        }
        try {
            Class<?> a = ud1.a("com.android.internal.content.NativeLibraryHelper$Handle");
            this.a = a;
            Method b = ud1.b(a, "create", File.class);
            this.c = b;
            b.setAccessible(true);
            Method b2 = ud1.b(this.a, "close", new Class[0]);
            this.f = b2;
            b2.setAccessible(true);
            Class<?> a2 = ud1.a("com.android.internal.content.NativeLibraryHelper");
            this.b = a2;
            Method b3 = ud1.b(a2, "copyNativeBinaries", this.a, File.class, String.class);
            this.e = b3;
            b3.setAccessible(true);
            Method b4 = ud1.b(this.b, "findSupportedAbi", this.a, String[].class);
            this.d = b4;
            b4.setAccessible(true);
            this.g = true;
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public boolean f(String str, File file) {
        InterceptResult invokeLL;
        String[] strArr;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048581, this, str, file)) == null) {
            Object c = c(new File(str));
            if (c == null) {
                return false;
            }
            if (Build.VERSION.SDK_INT >= 21) {
                if (g()) {
                    strArr = Build.SUPPORTED_64_BIT_ABIS;
                } else {
                    strArr = Build.SUPPORTED_32_BIT_ABIS;
                }
            } else {
                strArr = new String[]{Build.CPU_ABI, Build.CPU_ABI2};
            }
            int d = d(c, strArr);
            if (d == -114) {
                a(c);
                return true;
            }
            if (d >= 0 && d < strArr.length) {
                str2 = strArr[d];
            } else {
                str2 = null;
            }
            boolean b = b(c, str2, file);
            a(c);
            return b;
        }
        return invokeLL.booleanValue;
    }
}
