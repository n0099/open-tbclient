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
/* loaded from: classes5.dex */
public class mg0 {
    public static /* synthetic */ Interceptable $ic;
    public static final List<og0> d;
    public static final List<qg0> e;
    public transient /* synthetic */ FieldHolder $fh;
    public final Map<String, og0> a;
    public final Map<String, qg0> b;
    public final ArrayList<String> c;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947971571, "Lcom/baidu/tieba/mg0;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947971571, "Lcom/baidu/tieba/mg0;");
                return;
            }
        }
        xg0 xg0Var = new xg0();
        d = xg0Var.a.getList();
        e = xg0Var.b.getList();
    }

    public mg0() {
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
        synchronized (mg0.class) {
            if (d != null && this.a.isEmpty()) {
                for (og0 og0Var : d) {
                    if (og0Var != null) {
                        if (zx0.b(this.a, og0Var.a()) == null) {
                            zx0.e(this.a, og0Var.a(), og0Var);
                        }
                        if (!TextUtils.isEmpty(og0Var.a())) {
                            xx0.b(this.c, og0Var.a());
                        }
                    }
                }
            }
            if (e != null && this.b.isEmpty()) {
                for (qg0 qg0Var : e) {
                    this.b.put(qg0Var.b(), qg0Var);
                }
            }
        }
    }

    public boolean a(@NonNull Context context, @NonNull sg0 sg0Var, @Nullable Map<String, Object> map, @Nullable wg0 wg0Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048576, this, context, sg0Var, map, wg0Var)) == null) {
            if (b(context, sg0Var, map, wg0Var)) {
                bh0.b(wg0Var, sg0Var, 403, false);
                return false;
            }
            og0 og0Var = bh0.f(sg0Var.a()) ? (og0) zx0.b(this.a, sg0Var.a()) : null;
            if (bh0.g(sg0Var.c()) && og0Var != null) {
                sg0Var.f();
                return og0Var.b(context, sg0Var, map, wg0Var);
            }
            return tg0.a().a(context, sg0Var.b(), map, wg0Var);
        }
        return invokeLLLL.booleanValue;
    }

    public boolean b(Context context, sg0 sg0Var, @Nullable Map<String, Object> map, @Nullable wg0 wg0Var) {
        InterceptResult invokeLLLL;
        String a;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, sg0Var, map, wg0Var)) == null) {
            if (this.b.isEmpty()) {
                return false;
            }
            qg0 qg0Var = null;
            try {
                for (Map.Entry<String, qg0> entry : this.b.entrySet()) {
                    String a2 = sg0Var.a();
                    if (entry == null || ((qg0Var = entry.getValue()) != null && (a = qg0Var.a()) != null && TextUtils.equals(a2, a))) {
                        if (qg0Var != null && qg0Var.c(context, sg0Var, map, wg0Var)) {
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
