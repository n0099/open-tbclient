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
/* loaded from: classes7.dex */
public class tj0 {
    public static /* synthetic */ Interceptable $ic;
    public static final List<vj0> d;
    public static final List<xj0> e;
    public transient /* synthetic */ FieldHolder $fh;
    public final Map<String, vj0> a;
    public final Map<String, xj0> b;
    public final ArrayList<String> c;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948182991, "Lcom/baidu/tieba/tj0;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948182991, "Lcom/baidu/tieba/tj0;");
                return;
            }
        }
        ek0 ek0Var = new ek0();
        d = ek0Var.a.getList();
        e = ek0Var.b.getList();
    }

    public tj0() {
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
        synchronized (tj0.class) {
            if (d != null && this.a.isEmpty()) {
                for (vj0 vj0Var : d) {
                    if (vj0Var != null) {
                        if (a31.b(this.a, vj0Var.a()) == null) {
                            a31.e(this.a, vj0Var.a(), vj0Var);
                        }
                        if (!TextUtils.isEmpty(vj0Var.a())) {
                            y21.b(this.c, vj0Var.a());
                        }
                    }
                }
            }
            if (e != null && this.b.isEmpty()) {
                for (xj0 xj0Var : e) {
                    this.b.put(xj0Var.b(), xj0Var);
                }
            }
        }
    }

    public boolean a(@NonNull Context context, @NonNull zj0 zj0Var, @Nullable Map<String, Object> map, @Nullable dk0 dk0Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048576, this, context, zj0Var, map, dk0Var)) == null) {
            if (b(context, zj0Var, map, dk0Var)) {
                ik0.b(dk0Var, zj0Var, 0, true);
                return true;
            }
            vj0 vj0Var = null;
            if (ik0.f(zj0Var.a())) {
                vj0Var = (vj0) a31.b(this.a, zj0Var.a());
            }
            if (ik0.g(zj0Var.c()) && vj0Var != null) {
                zj0Var.f();
                return vj0Var.b(context, zj0Var, map, dk0Var);
            }
            return ak0.a().a(context, zj0Var.b(), map, dk0Var);
        }
        return invokeLLLL.booleanValue;
    }

    public boolean b(Context context, zj0 zj0Var, @Nullable Map<String, Object> map, @Nullable dk0 dk0Var) {
        InterceptResult invokeLLLL;
        String a;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, zj0Var, map, dk0Var)) == null) {
            if (this.b.isEmpty()) {
                return false;
            }
            xj0 xj0Var = null;
            try {
                for (Map.Entry<String, xj0> entry : this.b.entrySet()) {
                    String a2 = zj0Var.a();
                    if (entry == null || ((xj0Var = entry.getValue()) != null && (a = xj0Var.a()) != null && TextUtils.equals(a2, a))) {
                        if (xj0Var != null && xj0Var.d(context, zj0Var, map, dk0Var)) {
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
