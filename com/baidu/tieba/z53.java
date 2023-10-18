package com.baidu.tieba;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.util.Map;
import java.util.TreeMap;
/* loaded from: classes9.dex */
public final class z53 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean b;
    public transient /* synthetic */ FieldHolder $fh;
    public Map<String, e63> a;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948310897, "Lcom/baidu/tieba/z53;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948310897, "Lcom/baidu/tieba/z53;");
                return;
            }
        }
        b = am1.a;
    }

    public z53() {
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
        this.a = null;
    }

    public static String c(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, str, str2)) == null) {
            File d = w03.d(str2);
            if (d == null || !d.exists()) {
                if (str.endsWith(File.separator)) {
                    d = new File(str + str2 + ".json");
                } else {
                    d = new File(str + File.separator + str2 + ".json");
                }
            }
            if (b) {
                Log.d("PageConfigData", "parseConfigFile baseUrl : " + str + " ,page: " + str2 + " file exist:" + d.exists());
            }
            if (!d.exists()) {
                return null;
            }
            return lo2.m(d);
        }
        return (String) invokeLL.objValue;
    }

    public e63 a(String str, @NonNull String str2, @NonNull e63 e63Var) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, str, str2, e63Var)) == null) {
            if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
                e63 d = d(str, str2, e63Var);
                this.a.put(str2, d);
                return d;
            }
            return e63Var;
        }
        return (e63) invokeLLL.objValue;
    }

    public final e63 d(String str, String str2, @NonNull e63 e63Var) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, str, str2, e63Var)) == null) {
            String c = c(str, str2);
            if (TextUtils.isEmpty(c)) {
                return e63Var;
            }
            return e63.b(c, e63Var);
        }
        return (e63) invokeLLL.objValue;
    }

    public e63 b(String str, String str2, @NonNull e63 e63Var) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, str2, e63Var)) == null) {
            if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
                if (this.a == null) {
                    this.a = new TreeMap();
                }
                e63 e63Var2 = this.a.get(str2);
                if (e63Var2 != null) {
                    return e63Var2;
                }
                e63 d = d(str, str2, e63Var);
                this.a.put(str2, d);
                return d;
            }
            return e63Var;
        }
        return (e63) invokeLLL.objValue;
    }
}
