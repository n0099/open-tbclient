package com.baidu.tieba;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
/* loaded from: classes6.dex */
public class rh0 {
    public static /* synthetic */ Interceptable $ic;
    public static final List<th0> d;
    public static final List<vh0> e;
    public transient /* synthetic */ FieldHolder $fh;
    public final Map<String, th0> a;
    public final Map<String, vh0> b;
    public final ArrayList<String> c;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948121487, "Lcom/baidu/tieba/rh0;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948121487, "Lcom/baidu/tieba/rh0;");
                return;
            }
        }
        ci0 ci0Var = new ci0();
        d = ci0Var.a.getList();
        e = ci0Var.b.getList();
    }

    public rh0() {
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
        this.a = new HashMap();
        this.b = Collections.synchronizedMap(new LinkedHashMap());
        this.c = new ArrayList<>();
        synchronized (rh0.class) {
            if (d != null && this.a.isEmpty()) {
                for (th0 th0Var : d) {
                    if (th0Var != null) {
                        if (y01.b(this.a, th0Var.a()) == null) {
                            y01.e(this.a, th0Var.a(), th0Var);
                        }
                        if (!TextUtils.isEmpty(th0Var.a())) {
                            w01.b(this.c, th0Var.a());
                        }
                    }
                }
            }
            if (e != null && this.b.isEmpty()) {
                for (vh0 vh0Var : e) {
                    this.b.put(vh0Var.b(), vh0Var);
                }
            }
        }
    }

    public boolean a(@NonNull Context context, @NonNull xh0 xh0Var, @Nullable Map<String, Object> map, @Nullable bi0 bi0Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048576, this, context, xh0Var, map, bi0Var)) == null) {
            if (b(context, xh0Var, map, bi0Var)) {
                gi0.b(bi0Var, xh0Var, 0, true);
                return true;
            }
            th0 th0Var = null;
            if (gi0.f(xh0Var.a())) {
                th0Var = (th0) y01.b(this.a, xh0Var.a());
            }
            if (gi0.g(xh0Var.c()) && th0Var != null) {
                xh0Var.f();
                return th0Var.b(context, xh0Var, map, bi0Var);
            }
            return yh0.a().a(context, xh0Var.b(), map, bi0Var);
        }
        return invokeLLLL.booleanValue;
    }

    public boolean b(Context context, xh0 xh0Var, @Nullable Map<String, Object> map, @Nullable bi0 bi0Var) {
        InterceptResult invokeLLLL;
        String a;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, xh0Var, map, bi0Var)) == null) {
            if (this.b.isEmpty()) {
                return false;
            }
            vh0 vh0Var = null;
            try {
                for (Map.Entry<String, vh0> entry : this.b.entrySet()) {
                    String a2 = xh0Var.a();
                    if (entry == null || ((vh0Var = entry.getValue()) != null && (a = vh0Var.a()) != null && TextUtils.equals(a2, a))) {
                        if (vh0Var != null && vh0Var.d(context, xh0Var, map, bi0Var)) {
                            return true;
                        }
                    }
                }
            } catch (Exception unused) {
            }
            return false;
        }
        return invokeLLLL.booleanValue;
    }
}
