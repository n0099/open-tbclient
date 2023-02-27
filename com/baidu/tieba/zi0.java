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
public class zi0 {
    public static /* synthetic */ Interceptable $ic;
    public static final List<bj0> d;
    public static final List<dj0> e;
    public transient /* synthetic */ FieldHolder $fh;
    public final Map<String, bj0> a;
    public final Map<String, dj0> b;
    public final ArrayList<String> c;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948360776, "Lcom/baidu/tieba/zi0;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948360776, "Lcom/baidu/tieba/zi0;");
                return;
            }
        }
        kj0 kj0Var = new kj0();
        d = kj0Var.a.getList();
        e = kj0Var.b.getList();
    }

    public zi0() {
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
        synchronized (zi0.class) {
            if (d != null && this.a.isEmpty()) {
                for (bj0 bj0Var : d) {
                    if (bj0Var != null) {
                        if (g21.b(this.a, bj0Var.a()) == null) {
                            g21.e(this.a, bj0Var.a(), bj0Var);
                        }
                        if (!TextUtils.isEmpty(bj0Var.a())) {
                            e21.b(this.c, bj0Var.a());
                        }
                    }
                }
            }
            if (e != null && this.b.isEmpty()) {
                for (dj0 dj0Var : e) {
                    this.b.put(dj0Var.b(), dj0Var);
                }
            }
        }
    }

    public boolean a(@NonNull Context context, @NonNull fj0 fj0Var, @Nullable Map<String, Object> map, @Nullable jj0 jj0Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048576, this, context, fj0Var, map, jj0Var)) == null) {
            if (b(context, fj0Var, map, jj0Var)) {
                oj0.b(jj0Var, fj0Var, 0, true);
                return true;
            }
            bj0 bj0Var = null;
            if (oj0.f(fj0Var.a())) {
                bj0Var = (bj0) g21.b(this.a, fj0Var.a());
            }
            if (oj0.g(fj0Var.c()) && bj0Var != null) {
                fj0Var.f();
                return bj0Var.b(context, fj0Var, map, jj0Var);
            }
            return gj0.a().a(context, fj0Var.b(), map, jj0Var);
        }
        return invokeLLLL.booleanValue;
    }

    public boolean b(Context context, fj0 fj0Var, @Nullable Map<String, Object> map, @Nullable jj0 jj0Var) {
        InterceptResult invokeLLLL;
        String a;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, fj0Var, map, jj0Var)) == null) {
            if (this.b.isEmpty()) {
                return false;
            }
            dj0 dj0Var = null;
            try {
                for (Map.Entry<String, dj0> entry : this.b.entrySet()) {
                    String a2 = fj0Var.a();
                    if (entry == null || ((dj0Var = entry.getValue()) != null && (a = dj0Var.a()) != null && TextUtils.equals(a2, a))) {
                        if (dj0Var != null && dj0Var.d(context, fj0Var, map, jj0Var)) {
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
