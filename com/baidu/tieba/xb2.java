package com.baidu.tieba;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.process.ipc.delegate.provider.ProviderDelegation;
import com.baidu.searchbox.process.ipc.util.ProcessUtils;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes9.dex */
public class xb2 implements vb2 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean b;
    public transient /* synthetic */ FieldHolder $fh;
    public final xe3 a;

    /* loaded from: classes9.dex */
    public static class a extends ProviderDelegation {
        public static /* synthetic */ Interceptable $ic;
        public static boolean a;
        public transient /* synthetic */ FieldHolder $fh;

        public a() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.baidu.searchbox.process.ipc.delegate.provider.ProviderDelegation
        public Bundle execCall(Bundle bundle) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, bundle)) == null) {
                if (!a && ProcessUtils.isMainProcess()) {
                    a = true;
                    new xe3("swan_prelink_by_preload_recorder").clear().apply();
                    if (xb2.b) {
                        Log.d("SwanPrelinkGlobalRecorder", "clean old data in main process");
                    }
                }
                return null;
            }
            return (Bundle) invokeL.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948294529, "Lcom/baidu/tieba/xb2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948294529, "Lcom/baidu/tieba/xb2;");
                return;
            }
        }
        b = vm1.a;
    }

    public xb2() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = new xe3("swan_prelink_by_preload_recorder");
        c();
    }

    public final void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            x23.c(a.class, null);
        }
    }

    @Override // com.baidu.tieba.vb2
    public void a(String str, String str2, boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLZ(1048576, this, str, str2, z) == null) && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            if (b) {
                Log.d("SwanPrelinkGlobalRecorder", "record : appId-" + str + ", url-" + str2);
            }
            String d = d(str, str2);
            String e = e(str, str2);
            if (TextUtils.isEmpty(this.a.getString(d, "")) || z) {
                this.a.putString(d, e);
            }
        }
    }

    public final String d(@NonNull String str, @NonNull String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, str2)) == null) {
            String str3 = str + "_##_" + str2.hashCode();
            if (b) {
                Log.d("SwanPrelinkGlobalRecorder", "generateKey - " + str3);
            }
            return str3;
        }
        return (String) invokeLL.objValue;
    }

    public final String e(@NonNull String str, @NonNull String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, str, str2)) == null) {
            String str3 = ProcessUtils.getCurProcessName() + "_##_" + System.currentTimeMillis();
            if (b) {
                Log.d("SwanPrelinkGlobalRecorder", "generateValue - " + str3);
            }
            return str3;
        }
        return (String) invokeLL.objValue;
    }

    public final wb2 f(@NonNull String str, @NonNull String str2, @NonNull String str3) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048580, this, str, str2, str3)) == null) {
            String[] split = str.split("_##_");
            if (split != null && split.length >= 2) {
                wb2 wb2Var = new wb2();
                wb2Var.a = split[0];
                wb2Var.b = g(split[1]);
                return wb2Var;
            }
            return null;
        }
        return (wb2) invokeLLL.objValue;
    }

    public final long g(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return 0L;
            }
            try {
                return Long.parseLong(str);
            } catch (Exception e) {
                if (b) {
                    e.printStackTrace();
                }
                return 0L;
            }
        }
        return invokeL.longValue;
    }

    @Override // com.baidu.tieba.vb2
    public wb2 get(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048582, this, str, str2)) == null) {
            if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
                return null;
            }
            if (b) {
                Log.d("SwanPrelinkGlobalRecorder", "get record : appId-" + str + ", url-" + str2);
            }
            String string = this.a.getString(d(str, str2), "");
            if (TextUtils.isEmpty(string)) {
                return null;
            }
            wb2 f = f(string, str, str2);
            if (b) {
                Log.d("SwanPrelinkGlobalRecorder", "find record - " + string);
            }
            return f;
        }
        return (wb2) invokeLL.objValue;
    }
}
