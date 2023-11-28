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
public class pe0 {
    public static /* synthetic */ Interceptable $ic;
    public static final List<re0> d;
    public static final List<te0> e;
    public transient /* synthetic */ FieldHolder $fh;
    public final Map<String, re0> a;
    public final Map<String, te0> b;
    public final ArrayList<String> c;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948059022, "Lcom/baidu/tieba/pe0;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948059022, "Lcom/baidu/tieba/pe0;");
                return;
            }
        }
        af0 af0Var = new af0();
        d = af0Var.a.getList();
        e = af0Var.b.getList();
    }

    public pe0() {
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
        synchronized (pe0.class) {
            if (d != null && this.a.isEmpty()) {
                for (re0 re0Var : d) {
                    if (re0Var != null) {
                        if (ny0.b(this.a, re0Var.a()) == null) {
                            ny0.e(this.a, re0Var.a(), re0Var);
                        }
                        if (!TextUtils.isEmpty(re0Var.a())) {
                            ly0.b(this.c, re0Var.a());
                        }
                    }
                }
            }
            if (e != null && this.b.isEmpty()) {
                for (te0 te0Var : e) {
                    this.b.put(te0Var.b(), te0Var);
                }
            }
        }
    }

    public boolean a(@NonNull Context context, @NonNull ve0 ve0Var, @Nullable Map<String, Object> map, @Nullable ze0 ze0Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048576, this, context, ve0Var, map, ze0Var)) == null) {
            if (b(context, ve0Var, map, ze0Var)) {
                ef0.b(ze0Var, ve0Var, 0, true);
                return true;
            }
            re0 re0Var = null;
            if (ef0.f(ve0Var.a())) {
                re0Var = (re0) ny0.b(this.a, ve0Var.a());
            }
            if (ef0.g(ve0Var.c()) && re0Var != null) {
                ve0Var.f();
                return re0Var.b(context, ve0Var, map, ze0Var);
            }
            return we0.a().a(context, ve0Var.b(), map, ze0Var);
        }
        return invokeLLLL.booleanValue;
    }

    public boolean b(Context context, ve0 ve0Var, @Nullable Map<String, Object> map, @Nullable ze0 ze0Var) {
        InterceptResult invokeLLLL;
        String a;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, ve0Var, map, ze0Var)) == null) {
            if (this.b.isEmpty()) {
                return false;
            }
            te0 te0Var = null;
            try {
                for (Map.Entry<String, te0> entry : this.b.entrySet()) {
                    String a2 = ve0Var.a();
                    if (entry == null || ((te0Var = entry.getValue()) != null && (a = te0Var.a()) != null && TextUtils.equals(a2, a))) {
                        if (te0Var != null && te0Var.d(context, ve0Var, map, ze0Var)) {
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
