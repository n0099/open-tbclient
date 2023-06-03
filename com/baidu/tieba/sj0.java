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
public class sj0 {
    public static /* synthetic */ Interceptable $ic;
    public static final List<uj0> d;
    public static final List<wj0> e;
    public transient /* synthetic */ FieldHolder $fh;
    public final Map<String, uj0> a;
    public final Map<String, wj0> b;
    public final ArrayList<String> c;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948153200, "Lcom/baidu/tieba/sj0;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948153200, "Lcom/baidu/tieba/sj0;");
                return;
            }
        }
        dk0 dk0Var = new dk0();
        d = dk0Var.a.getList();
        e = dk0Var.b.getList();
    }

    public sj0() {
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
        synchronized (sj0.class) {
            if (d != null && this.a.isEmpty()) {
                for (uj0 uj0Var : d) {
                    if (uj0Var != null) {
                        if (z21.b(this.a, uj0Var.a()) == null) {
                            z21.e(this.a, uj0Var.a(), uj0Var);
                        }
                        if (!TextUtils.isEmpty(uj0Var.a())) {
                            x21.b(this.c, uj0Var.a());
                        }
                    }
                }
            }
            if (e != null && this.b.isEmpty()) {
                for (wj0 wj0Var : e) {
                    this.b.put(wj0Var.b(), wj0Var);
                }
            }
        }
    }

    public boolean a(@NonNull Context context, @NonNull yj0 yj0Var, @Nullable Map<String, Object> map, @Nullable ck0 ck0Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048576, this, context, yj0Var, map, ck0Var)) == null) {
            if (b(context, yj0Var, map, ck0Var)) {
                hk0.b(ck0Var, yj0Var, 0, true);
                return true;
            }
            uj0 uj0Var = null;
            if (hk0.f(yj0Var.a())) {
                uj0Var = (uj0) z21.b(this.a, yj0Var.a());
            }
            if (hk0.g(yj0Var.c()) && uj0Var != null) {
                yj0Var.f();
                return uj0Var.b(context, yj0Var, map, ck0Var);
            }
            return zj0.a().a(context, yj0Var.b(), map, ck0Var);
        }
        return invokeLLLL.booleanValue;
    }

    public boolean b(Context context, yj0 yj0Var, @Nullable Map<String, Object> map, @Nullable ck0 ck0Var) {
        InterceptResult invokeLLLL;
        String a;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, yj0Var, map, ck0Var)) == null) {
            if (this.b.isEmpty()) {
                return false;
            }
            wj0 wj0Var = null;
            try {
                for (Map.Entry<String, wj0> entry : this.b.entrySet()) {
                    String a2 = yj0Var.a();
                    if (entry == null || ((wj0Var = entry.getValue()) != null && (a = wj0Var.a()) != null && TextUtils.equals(a2, a))) {
                        if (wj0Var != null && wj0Var.d(context, yj0Var, map, ck0Var)) {
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
