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
public class wj0 {
    public static /* synthetic */ Interceptable $ic;
    public static final List<yj0> d;
    public static final List<ak0> e;
    public transient /* synthetic */ FieldHolder $fh;
    public final Map<String, yj0> a;
    public final Map<String, ak0> b;
    public final ArrayList<String> c;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948272364, "Lcom/baidu/tieba/wj0;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948272364, "Lcom/baidu/tieba/wj0;");
                return;
            }
        }
        hk0 hk0Var = new hk0();
        d = hk0Var.a.getList();
        e = hk0Var.b.getList();
    }

    public wj0() {
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
        synchronized (wj0.class) {
            if (d != null && this.a.isEmpty()) {
                for (yj0 yj0Var : d) {
                    if (yj0Var != null) {
                        if (d31.b(this.a, yj0Var.a()) == null) {
                            d31.e(this.a, yj0Var.a(), yj0Var);
                        }
                        if (!TextUtils.isEmpty(yj0Var.a())) {
                            b31.b(this.c, yj0Var.a());
                        }
                    }
                }
            }
            if (e != null && this.b.isEmpty()) {
                for (ak0 ak0Var : e) {
                    this.b.put(ak0Var.b(), ak0Var);
                }
            }
        }
    }

    public boolean a(@NonNull Context context, @NonNull ck0 ck0Var, @Nullable Map<String, Object> map, @Nullable gk0 gk0Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048576, this, context, ck0Var, map, gk0Var)) == null) {
            if (b(context, ck0Var, map, gk0Var)) {
                lk0.b(gk0Var, ck0Var, 0, true);
                return true;
            }
            yj0 yj0Var = null;
            if (lk0.f(ck0Var.a())) {
                yj0Var = (yj0) d31.b(this.a, ck0Var.a());
            }
            if (lk0.g(ck0Var.c()) && yj0Var != null) {
                ck0Var.f();
                return yj0Var.b(context, ck0Var, map, gk0Var);
            }
            return dk0.a().a(context, ck0Var.b(), map, gk0Var);
        }
        return invokeLLLL.booleanValue;
    }

    public boolean b(Context context, ck0 ck0Var, @Nullable Map<String, Object> map, @Nullable gk0 gk0Var) {
        InterceptResult invokeLLLL;
        String a;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, ck0Var, map, gk0Var)) == null) {
            if (this.b.isEmpty()) {
                return false;
            }
            ak0 ak0Var = null;
            try {
                for (Map.Entry<String, ak0> entry : this.b.entrySet()) {
                    String a2 = ck0Var.a();
                    if (entry == null || ((ak0Var = entry.getValue()) != null && (a = ak0Var.a()) != null && TextUtils.equals(a2, a))) {
                        if (ak0Var != null && ak0Var.d(context, ck0Var, map, gk0Var)) {
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
