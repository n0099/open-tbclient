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
public class ji0 {
    public static /* synthetic */ Interceptable $ic;
    public static final List<li0> d;
    public static final List<ni0> e;
    public transient /* synthetic */ FieldHolder $fh;
    public final Map<String, li0> a;
    public final Map<String, ni0> b;
    public final ArrayList<String> c;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947884120, "Lcom/baidu/tieba/ji0;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947884120, "Lcom/baidu/tieba/ji0;");
                return;
            }
        }
        ui0 ui0Var = new ui0();
        d = ui0Var.a.getList();
        e = ui0Var.b.getList();
    }

    public ji0() {
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
        synchronized (ji0.class) {
            if (d != null && this.a.isEmpty()) {
                for (li0 li0Var : d) {
                    if (li0Var != null) {
                        if (q11.b(this.a, li0Var.a()) == null) {
                            q11.e(this.a, li0Var.a(), li0Var);
                        }
                        if (!TextUtils.isEmpty(li0Var.a())) {
                            o11.b(this.c, li0Var.a());
                        }
                    }
                }
            }
            if (e != null && this.b.isEmpty()) {
                for (ni0 ni0Var : e) {
                    this.b.put(ni0Var.b(), ni0Var);
                }
            }
        }
    }

    public boolean a(@NonNull Context context, @NonNull pi0 pi0Var, @Nullable Map<String, Object> map, @Nullable ti0 ti0Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048576, this, context, pi0Var, map, ti0Var)) == null) {
            if (b(context, pi0Var, map, ti0Var)) {
                yi0.b(ti0Var, pi0Var, 0, true);
                return true;
            }
            li0 li0Var = null;
            if (yi0.f(pi0Var.a())) {
                li0Var = (li0) q11.b(this.a, pi0Var.a());
            }
            if (yi0.g(pi0Var.c()) && li0Var != null) {
                pi0Var.f();
                return li0Var.b(context, pi0Var, map, ti0Var);
            }
            return qi0.a().a(context, pi0Var.b(), map, ti0Var);
        }
        return invokeLLLL.booleanValue;
    }

    public boolean b(Context context, pi0 pi0Var, @Nullable Map<String, Object> map, @Nullable ti0 ti0Var) {
        InterceptResult invokeLLLL;
        String a;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, pi0Var, map, ti0Var)) == null) {
            if (this.b.isEmpty()) {
                return false;
            }
            ni0 ni0Var = null;
            try {
                for (Map.Entry<String, ni0> entry : this.b.entrySet()) {
                    String a2 = pi0Var.a();
                    if (entry == null || ((ni0Var = entry.getValue()) != null && (a = ni0Var.a()) != null && TextUtils.equals(a2, a))) {
                        if (ni0Var != null && ni0Var.d(context, pi0Var, map, ti0Var)) {
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
