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
public class mi0 {
    public static /* synthetic */ Interceptable $ic;
    public static final List<oi0> d;
    public static final List<qi0> e;
    public transient /* synthetic */ FieldHolder $fh;
    public final Map<String, oi0> a;
    public final Map<String, qi0> b;
    public final ArrayList<String> c;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947973493, "Lcom/baidu/tieba/mi0;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947973493, "Lcom/baidu/tieba/mi0;");
                return;
            }
        }
        xi0 xi0Var = new xi0();
        d = xi0Var.a.getList();
        e = xi0Var.b.getList();
    }

    public mi0() {
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
        synchronized (mi0.class) {
            if (d != null && this.a.isEmpty()) {
                for (oi0 oi0Var : d) {
                    if (oi0Var != null) {
                        if (v01.b(this.a, oi0Var.a()) == null) {
                            v01.e(this.a, oi0Var.a(), oi0Var);
                        }
                        if (!TextUtils.isEmpty(oi0Var.a())) {
                            t01.b(this.c, oi0Var.a());
                        }
                    }
                }
            }
            if (e != null && this.b.isEmpty()) {
                for (qi0 qi0Var : e) {
                    this.b.put(qi0Var.b(), qi0Var);
                }
            }
        }
    }

    public boolean a(@NonNull Context context, @NonNull si0 si0Var, @Nullable Map<String, Object> map, @Nullable wi0 wi0Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048576, this, context, si0Var, map, wi0Var)) == null) {
            if (b(context, si0Var, map, wi0Var)) {
                bj0.b(wi0Var, si0Var, 403, false);
                return false;
            }
            oi0 oi0Var = null;
            if (bj0.f(si0Var.a())) {
                oi0Var = (oi0) v01.b(this.a, si0Var.a());
            }
            if (bj0.g(si0Var.c()) && oi0Var != null) {
                si0Var.f();
                return oi0Var.b(context, si0Var, map, wi0Var);
            }
            return ti0.a().a(context, si0Var.b(), map, wi0Var);
        }
        return invokeLLLL.booleanValue;
    }

    public boolean b(Context context, si0 si0Var, @Nullable Map<String, Object> map, @Nullable wi0 wi0Var) {
        InterceptResult invokeLLLL;
        String a;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, si0Var, map, wi0Var)) == null) {
            if (this.b.isEmpty()) {
                return false;
            }
            qi0 qi0Var = null;
            try {
                for (Map.Entry<String, qi0> entry : this.b.entrySet()) {
                    String a2 = si0Var.a();
                    if (entry == null || ((qi0Var = entry.getValue()) != null && (a = qi0Var.a()) != null && TextUtils.equals(a2, a))) {
                        if (qi0Var != null && qi0Var.c(context, si0Var, map, wi0Var)) {
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
