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
public class qh0 {
    public static /* synthetic */ Interceptable $ic;
    public static final List<sh0> d;
    public static final List<uh0> e;
    public transient /* synthetic */ FieldHolder $fh;
    public final Map<String, sh0> a;
    public final Map<String, uh0> b;
    public final ArrayList<String> c;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948091696, "Lcom/baidu/tieba/qh0;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948091696, "Lcom/baidu/tieba/qh0;");
                return;
            }
        }
        bi0 bi0Var = new bi0();
        d = bi0Var.a.getList();
        e = bi0Var.b.getList();
    }

    public qh0() {
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
        synchronized (qh0.class) {
            if (d != null && this.a.isEmpty()) {
                for (sh0 sh0Var : d) {
                    if (sh0Var != null) {
                        if (x01.b(this.a, sh0Var.a()) == null) {
                            x01.e(this.a, sh0Var.a(), sh0Var);
                        }
                        if (!TextUtils.isEmpty(sh0Var.a())) {
                            v01.b(this.c, sh0Var.a());
                        }
                    }
                }
            }
            if (e != null && this.b.isEmpty()) {
                for (uh0 uh0Var : e) {
                    this.b.put(uh0Var.b(), uh0Var);
                }
            }
        }
    }

    public boolean a(@NonNull Context context, @NonNull wh0 wh0Var, @Nullable Map<String, Object> map, @Nullable ai0 ai0Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048576, this, context, wh0Var, map, ai0Var)) == null) {
            if (b(context, wh0Var, map, ai0Var)) {
                fi0.b(ai0Var, wh0Var, 0, true);
                return true;
            }
            sh0 sh0Var = null;
            if (fi0.f(wh0Var.a())) {
                sh0Var = (sh0) x01.b(this.a, wh0Var.a());
            }
            if (fi0.g(wh0Var.c()) && sh0Var != null) {
                wh0Var.f();
                return sh0Var.b(context, wh0Var, map, ai0Var);
            }
            return xh0.a().a(context, wh0Var.b(), map, ai0Var);
        }
        return invokeLLLL.booleanValue;
    }

    public boolean b(Context context, wh0 wh0Var, @Nullable Map<String, Object> map, @Nullable ai0 ai0Var) {
        InterceptResult invokeLLLL;
        String a;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, wh0Var, map, ai0Var)) == null) {
            if (this.b.isEmpty()) {
                return false;
            }
            uh0 uh0Var = null;
            try {
                for (Map.Entry<String, uh0> entry : this.b.entrySet()) {
                    String a2 = wh0Var.a();
                    if (entry == null || ((uh0Var = entry.getValue()) != null && (a = uh0Var.a()) != null && TextUtils.equals(a2, a))) {
                        if (uh0Var != null && uh0Var.d(context, wh0Var, map, ai0Var)) {
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
