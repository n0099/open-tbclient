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
public class oe0 {
    public static /* synthetic */ Interceptable $ic;
    public static final List<qe0> d;
    public static final List<se0> e;
    public transient /* synthetic */ FieldHolder $fh;
    public final Map<String, qe0> a;
    public final Map<String, se0> b;
    public final ArrayList<String> c;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948029231, "Lcom/baidu/tieba/oe0;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948029231, "Lcom/baidu/tieba/oe0;");
                return;
            }
        }
        ze0 ze0Var = new ze0();
        d = ze0Var.a.getList();
        e = ze0Var.b.getList();
    }

    public oe0() {
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
        synchronized (oe0.class) {
            if (d != null && this.a.isEmpty()) {
                for (qe0 qe0Var : d) {
                    if (qe0Var != null) {
                        if (my0.b(this.a, qe0Var.a()) == null) {
                            my0.e(this.a, qe0Var.a(), qe0Var);
                        }
                        if (!TextUtils.isEmpty(qe0Var.a())) {
                            ky0.b(this.c, qe0Var.a());
                        }
                    }
                }
            }
            if (e != null && this.b.isEmpty()) {
                for (se0 se0Var : e) {
                    this.b.put(se0Var.b(), se0Var);
                }
            }
        }
    }

    public boolean a(@NonNull Context context, @NonNull ue0 ue0Var, @Nullable Map<String, Object> map, @Nullable ye0 ye0Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048576, this, context, ue0Var, map, ye0Var)) == null) {
            if (b(context, ue0Var, map, ye0Var)) {
                df0.b(ye0Var, ue0Var, 0, true);
                return true;
            }
            qe0 qe0Var = null;
            if (df0.f(ue0Var.a())) {
                qe0Var = (qe0) my0.b(this.a, ue0Var.a());
            }
            if (df0.g(ue0Var.c()) && qe0Var != null) {
                ue0Var.f();
                return qe0Var.b(context, ue0Var, map, ye0Var);
            }
            return ve0.a().a(context, ue0Var.b(), map, ye0Var);
        }
        return invokeLLLL.booleanValue;
    }

    public boolean b(Context context, ue0 ue0Var, @Nullable Map<String, Object> map, @Nullable ye0 ye0Var) {
        InterceptResult invokeLLLL;
        String a;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, ue0Var, map, ye0Var)) == null) {
            if (this.b.isEmpty()) {
                return false;
            }
            se0 se0Var = null;
            try {
                for (Map.Entry<String, se0> entry : this.b.entrySet()) {
                    String a2 = ue0Var.a();
                    if (entry == null || ((se0Var = entry.getValue()) != null && (a = se0Var.a()) != null && TextUtils.equals(a2, a))) {
                        if (se0Var != null && se0Var.d(context, ue0Var, map, ye0Var)) {
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
