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
public class uh0 {
    public static /* synthetic */ Interceptable $ic;
    public static final List<wh0> d;
    public static final List<yh0> e;
    public transient /* synthetic */ FieldHolder $fh;
    public final Map<String, wh0> a;
    public final Map<String, yh0> b;
    public final ArrayList<String> c;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948210860, "Lcom/baidu/tieba/uh0;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948210860, "Lcom/baidu/tieba/uh0;");
                return;
            }
        }
        fi0 fi0Var = new fi0();
        d = fi0Var.a.getList();
        e = fi0Var.b.getList();
    }

    public uh0() {
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
        synchronized (uh0.class) {
            if (d != null && this.a.isEmpty()) {
                for (wh0 wh0Var : d) {
                    if (wh0Var != null) {
                        if (lz0.b(this.a, wh0Var.a()) == null) {
                            lz0.e(this.a, wh0Var.a(), wh0Var);
                        }
                        if (!TextUtils.isEmpty(wh0Var.a())) {
                            jz0.b(this.c, wh0Var.a());
                        }
                    }
                }
            }
            if (e != null && this.b.isEmpty()) {
                for (yh0 yh0Var : e) {
                    this.b.put(yh0Var.b(), yh0Var);
                }
            }
        }
    }

    public boolean a(@NonNull Context context, @NonNull ai0 ai0Var, @Nullable Map<String, Object> map, @Nullable ei0 ei0Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048576, this, context, ai0Var, map, ei0Var)) == null) {
            if (b(context, ai0Var, map, ei0Var)) {
                ji0.b(ei0Var, ai0Var, 403, false);
                return false;
            }
            wh0 wh0Var = ji0.f(ai0Var.a()) ? (wh0) lz0.b(this.a, ai0Var.a()) : null;
            if (ji0.g(ai0Var.c()) && wh0Var != null) {
                ai0Var.f();
                return wh0Var.b(context, ai0Var, map, ei0Var);
            }
            return bi0.a().a(context, ai0Var.b(), map, ei0Var);
        }
        return invokeLLLL.booleanValue;
    }

    public boolean b(Context context, ai0 ai0Var, @Nullable Map<String, Object> map, @Nullable ei0 ei0Var) {
        InterceptResult invokeLLLL;
        String a;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, ai0Var, map, ei0Var)) == null) {
            if (this.b.isEmpty()) {
                return false;
            }
            yh0 yh0Var = null;
            try {
                for (Map.Entry<String, yh0> entry : this.b.entrySet()) {
                    String a2 = ai0Var.a();
                    if (entry == null || ((yh0Var = entry.getValue()) != null && (a = yh0Var.a()) != null && TextUtils.equals(a2, a))) {
                        if (yh0Var != null && yh0Var.c(context, ai0Var, map, ei0Var)) {
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
