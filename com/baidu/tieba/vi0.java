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
public class vi0 {
    public static /* synthetic */ Interceptable $ic;
    public static final List<xi0> d;
    public static final List<zi0> e;
    public transient /* synthetic */ FieldHolder $fh;
    public final Map<String, xi0> a;
    public final Map<String, zi0> b;
    public final ArrayList<String> c;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948241612, "Lcom/baidu/tieba/vi0;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948241612, "Lcom/baidu/tieba/vi0;");
                return;
            }
        }
        gj0 gj0Var = new gj0();
        d = gj0Var.a.getList();
        e = gj0Var.b.getList();
    }

    public vi0() {
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
        synchronized (vi0.class) {
            if (d != null && this.a.isEmpty()) {
                for (xi0 xi0Var : d) {
                    if (xi0Var != null) {
                        if (z11.b(this.a, xi0Var.a()) == null) {
                            z11.e(this.a, xi0Var.a(), xi0Var);
                        }
                        if (!TextUtils.isEmpty(xi0Var.a())) {
                            x11.b(this.c, xi0Var.a());
                        }
                    }
                }
            }
            if (e != null && this.b.isEmpty()) {
                for (zi0 zi0Var : e) {
                    this.b.put(zi0Var.b(), zi0Var);
                }
            }
        }
    }

    public boolean a(@NonNull Context context, @NonNull bj0 bj0Var, @Nullable Map<String, Object> map, @Nullable fj0 fj0Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048576, this, context, bj0Var, map, fj0Var)) == null) {
            if (b(context, bj0Var, map, fj0Var)) {
                kj0.b(fj0Var, bj0Var, 0, true);
                return true;
            }
            xi0 xi0Var = null;
            if (kj0.f(bj0Var.a())) {
                xi0Var = (xi0) z11.b(this.a, bj0Var.a());
            }
            if (kj0.g(bj0Var.c()) && xi0Var != null) {
                bj0Var.f();
                return xi0Var.b(context, bj0Var, map, fj0Var);
            }
            return cj0.a().a(context, bj0Var.b(), map, fj0Var);
        }
        return invokeLLLL.booleanValue;
    }

    public boolean b(Context context, bj0 bj0Var, @Nullable Map<String, Object> map, @Nullable fj0 fj0Var) {
        InterceptResult invokeLLLL;
        String a;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, bj0Var, map, fj0Var)) == null) {
            if (this.b.isEmpty()) {
                return false;
            }
            zi0 zi0Var = null;
            try {
                for (Map.Entry<String, zi0> entry : this.b.entrySet()) {
                    String a2 = bj0Var.a();
                    if (entry == null || ((zi0Var = entry.getValue()) != null && (a = zi0Var.a()) != null && TextUtils.equals(a2, a))) {
                        if (zi0Var != null && zi0Var.d(context, bj0Var, map, fj0Var)) {
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
