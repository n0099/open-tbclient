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
/* loaded from: classes8.dex */
public class xi0 {
    public static /* synthetic */ Interceptable $ic;
    public static final List<zi0> d;
    public static final List<bj0> e;
    public transient /* synthetic */ FieldHolder $fh;
    public final Map<String, zi0> a;
    public final Map<String, bj0> b;
    public final ArrayList<String> c;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948301194, "Lcom/baidu/tieba/xi0;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948301194, "Lcom/baidu/tieba/xi0;");
                return;
            }
        }
        ij0 ij0Var = new ij0();
        d = ij0Var.a.getList();
        e = ij0Var.b.getList();
    }

    public xi0() {
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
        synchronized (xi0.class) {
            if (d != null && this.a.isEmpty()) {
                for (zi0 zi0Var : d) {
                    if (zi0Var != null) {
                        if (c31.b(this.a, zi0Var.a()) == null) {
                            c31.e(this.a, zi0Var.a(), zi0Var);
                        }
                        if (!TextUtils.isEmpty(zi0Var.a())) {
                            a31.b(this.c, zi0Var.a());
                        }
                    }
                }
            }
            if (e != null && this.b.isEmpty()) {
                for (bj0 bj0Var : e) {
                    this.b.put(bj0Var.b(), bj0Var);
                }
            }
        }
    }

    public boolean a(@NonNull Context context, @NonNull dj0 dj0Var, @Nullable Map<String, Object> map, @Nullable hj0 hj0Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048576, this, context, dj0Var, map, hj0Var)) == null) {
            if (b(context, dj0Var, map, hj0Var)) {
                mj0.b(hj0Var, dj0Var, 0, true);
                return true;
            }
            zi0 zi0Var = null;
            if (mj0.f(dj0Var.a())) {
                zi0Var = (zi0) c31.b(this.a, dj0Var.a());
            }
            if (mj0.g(dj0Var.c()) && zi0Var != null) {
                dj0Var.f();
                return zi0Var.b(context, dj0Var, map, hj0Var);
            }
            return ej0.a().a(context, dj0Var.b(), map, hj0Var);
        }
        return invokeLLLL.booleanValue;
    }

    public boolean b(Context context, dj0 dj0Var, @Nullable Map<String, Object> map, @Nullable hj0 hj0Var) {
        InterceptResult invokeLLLL;
        String a;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, dj0Var, map, hj0Var)) == null) {
            if (this.b.isEmpty()) {
                return false;
            }
            bj0 bj0Var = null;
            try {
                for (Map.Entry<String, bj0> entry : this.b.entrySet()) {
                    String a2 = dj0Var.a();
                    if (entry == null || ((bj0Var = entry.getValue()) != null && (a = bj0Var.a()) != null && TextUtils.equals(a2, a))) {
                        if (bj0Var != null && bj0Var.d(context, dj0Var, map, hj0Var)) {
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
