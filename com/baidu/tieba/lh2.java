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
/* loaded from: classes6.dex */
public class lh2 implements jh2 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean b;
    public transient /* synthetic */ FieldHolder $fh;
    public final lk3 a;

    /* loaded from: classes6.dex */
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
                    new lk3("swan_prelink_by_preload_recorder").clear().apply();
                    if (lh2.b) {
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947942803, "Lcom/baidu/tieba/lh2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947942803, "Lcom/baidu/tieba/lh2;");
                return;
            }
        }
        b = is1.a;
    }

    public lh2() {
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
        this.a = new lk3("swan_prelink_by_preload_recorder");
        d();
    }

    public final void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            l83.c(a.class, null);
        }
    }

    @Override // com.baidu.tieba.jh2
    public kh2 a(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, str, str2)) == null) {
            if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
                return null;
            }
            if (b) {
                Log.d("SwanPrelinkGlobalRecorder", "get record : appId-" + str + ", url-" + str2);
            }
            String string = this.a.getString(e(str, str2), "");
            if (TextUtils.isEmpty(string)) {
                return null;
            }
            kh2 g = g(string, str, str2);
            if (b) {
                Log.d("SwanPrelinkGlobalRecorder", "find record - " + string);
            }
            return g;
        }
        return (kh2) invokeLL.objValue;
    }

    @Override // com.baidu.tieba.jh2
    public void b(String str, String str2, boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, str2, z) == null) && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            if (b) {
                Log.d("SwanPrelinkGlobalRecorder", "record : appId-" + str + ", url-" + str2);
            }
            String e = e(str, str2);
            String f = f(str, str2);
            if (TextUtils.isEmpty(this.a.getString(e, "")) || z) {
                this.a.putString(e, f);
            }
        }
    }

    public final String e(@NonNull String str, @NonNull String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, str, str2)) == null) {
            String str3 = str + "_##_" + str2.hashCode();
            if (b) {
                Log.d("SwanPrelinkGlobalRecorder", "generateKey - " + str3);
            }
            return str3;
        }
        return (String) invokeLL.objValue;
    }

    public final String f(@NonNull String str, @NonNull String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048580, this, str, str2)) == null) {
            String str3 = ProcessUtils.getCurProcessName() + "_##_" + System.currentTimeMillis();
            if (b) {
                Log.d("SwanPrelinkGlobalRecorder", "generateValue - " + str3);
            }
            return str3;
        }
        return (String) invokeLL.objValue;
    }

    public final kh2 g(@NonNull String str, @NonNull String str2, @NonNull String str3) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048581, this, str, str2, str3)) == null) {
            String[] split = str.split("_##_");
            if (split != null && split.length >= 2) {
                kh2 kh2Var = new kh2();
                kh2Var.a = split[0];
                kh2Var.b = h(split[1]);
                return kh2Var;
            }
            return null;
        }
        return (kh2) invokeLLL.objValue;
    }

    public final long h(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, str)) == null) {
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
}
