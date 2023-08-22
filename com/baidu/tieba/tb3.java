package com.baidu.tieba;

import android.annotation.SuppressLint;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.vb3;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes8.dex */
public class tb3 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean d;
    public transient /* synthetic */ FieldHolder $fh;
    public vb3.d a;
    public vb3.d b;
    public Map<String, vb3.d> c;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948175396, "Lcom/baidu/tieba/tb3;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948175396, "Lcom/baidu/tieba/tb3;");
                return;
            }
        }
        d = nr1.a;
    }

    public tb3() {
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
        this.c = new ConcurrentHashMap();
    }

    public List<String> b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return vb3.d();
        }
        return (List) invokeV.objValue;
    }

    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            vb3.d dVar = this.a;
            if (dVar != null) {
                dVar.c();
                this.a = null;
            }
            vb3.d dVar2 = this.b;
            if (dVar2 != null) {
                dVar2.c();
                this.b = null;
            }
            d82.k("SwanAppWebSafe", "release cache done");
        }
    }

    public static boolean a(vb3.d dVar, String str) {
        InterceptResult invokeLL;
        boolean z;
        List<String> list;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, dVar, str)) == null) {
            if (dVar != null && (list = dVar.b) != null && !list.isEmpty()) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                File file = new File(str);
                if (file.exists() && file.lastModified() == dVar.c) {
                    return true;
                }
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    public vb3.d c(String str, String str2, boolean z) {
        InterceptResult invokeLLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, str2, z)) == null) {
            vb3.d dVar = this.c.get(str2);
            if (a(dVar, vb3.i(str))) {
                d82.k("SwanAppWebSafe", "read from cache: serverDomains.data=" + dVar.b);
                return dVar;
            }
            if (dVar != null) {
                dVar.c();
            } else {
                dVar = new vb3.d();
            }
            vb3.h(z, str, str2, dVar);
            this.c.put(str2, dVar);
            return dVar;
        }
        return (vb3.d) invokeLLZ.objValue;
    }

    public List<String> d(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z)) == null) {
            if (a(this.b, vb3.j())) {
                d82.k("SwanAppWebSafe", "read from cache: webActions.data=" + this.b.b);
                return this.b.b;
            }
            vb3.d dVar = this.b;
            if (dVar != null) {
                dVar.c();
            } else {
                this.b = new vb3.d();
            }
            vb3.k(z, this.b);
            return this.b.b;
        }
        return (List) invokeZ.objValue;
    }

    public List<String> e(@NonNull String str, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048579, this, str, z)) == null) {
            if (a(this.a, vb3.m(str))) {
                d82.k("SwanAppWebSafe", "read from cache: webDomains.data=" + this.a.b);
                return this.a.b;
            }
            vb3.d dVar = this.a;
            if (dVar != null) {
                dVar.c();
            } else {
                this.a = new vb3.d();
            }
            vb3.l(z, str, this.a);
            return this.a.b;
        }
        return (List) invokeLZ.objValue;
    }

    @SuppressLint({"BDThrowableCheck"})
    public void f(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
            if (TextUtils.isEmpty(str)) {
                if (!d) {
                    return;
                }
                throw new RuntimeException("appId can not be empty");
            }
            d(true);
            e(str, true);
        }
    }
}
