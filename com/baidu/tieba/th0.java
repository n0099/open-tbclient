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
public class th0 {
    public static /* synthetic */ Interceptable $ic;
    public static final List<vh0> d;
    public static final List<xh0> e;
    public transient /* synthetic */ FieldHolder $fh;
    public final Map<String, vh0> a;
    public final Map<String, xh0> b;
    public final ArrayList<String> c;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948181069, "Lcom/baidu/tieba/th0;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948181069, "Lcom/baidu/tieba/th0;");
                return;
            }
        }
        ei0 ei0Var = new ei0();
        d = ei0Var.a.getList();
        e = ei0Var.b.getList();
    }

    public th0() {
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
        synchronized (th0.class) {
            if (d != null && this.a.isEmpty()) {
                for (vh0 vh0Var : d) {
                    if (vh0Var != null) {
                        if (a11.b(this.a, vh0Var.a()) == null) {
                            a11.e(this.a, vh0Var.a(), vh0Var);
                        }
                        if (!TextUtils.isEmpty(vh0Var.a())) {
                            y01.b(this.c, vh0Var.a());
                        }
                    }
                }
            }
            if (e != null && this.b.isEmpty()) {
                for (xh0 xh0Var : e) {
                    this.b.put(xh0Var.b(), xh0Var);
                }
            }
        }
    }

    public boolean a(@NonNull Context context, @NonNull zh0 zh0Var, @Nullable Map<String, Object> map, @Nullable di0 di0Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048576, this, context, zh0Var, map, di0Var)) == null) {
            if (b(context, zh0Var, map, di0Var)) {
                ii0.b(di0Var, zh0Var, 0, true);
                return true;
            }
            vh0 vh0Var = null;
            if (ii0.f(zh0Var.a())) {
                vh0Var = (vh0) a11.b(this.a, zh0Var.a());
            }
            if (ii0.g(zh0Var.c()) && vh0Var != null) {
                zh0Var.f();
                return vh0Var.b(context, zh0Var, map, di0Var);
            }
            return ai0.a().a(context, zh0Var.b(), map, di0Var);
        }
        return invokeLLLL.booleanValue;
    }

    public boolean b(Context context, zh0 zh0Var, @Nullable Map<String, Object> map, @Nullable di0 di0Var) {
        InterceptResult invokeLLLL;
        String a;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, zh0Var, map, di0Var)) == null) {
            if (this.b.isEmpty()) {
                return false;
            }
            xh0 xh0Var = null;
            try {
                for (Map.Entry<String, xh0> entry : this.b.entrySet()) {
                    String a2 = zh0Var.a();
                    if (entry == null || ((xh0Var = entry.getValue()) != null && (a = xh0Var.a()) != null && TextUtils.equals(a2, a))) {
                        if (xh0Var != null && xh0Var.d(context, zh0Var, map, di0Var)) {
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
