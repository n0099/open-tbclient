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
public class xd0 {
    public static /* synthetic */ Interceptable $ic;
    public static final List<zd0> d;
    public static final List<be0> e;
    public transient /* synthetic */ FieldHolder $fh;
    public final Map<String, zd0> a;
    public final Map<String, be0> b;
    public final ArrayList<String> c;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948296389, "Lcom/baidu/tieba/xd0;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948296389, "Lcom/baidu/tieba/xd0;");
                return;
            }
        }
        ie0 ie0Var = new ie0();
        d = ie0Var.a.getList();
        e = ie0Var.b.getList();
    }

    public xd0() {
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
        synchronized (xd0.class) {
            if (d != null && this.a.isEmpty()) {
                for (zd0 zd0Var : d) {
                    if (zd0Var != null) {
                        if (vx0.b(this.a, zd0Var.a()) == null) {
                            vx0.e(this.a, zd0Var.a(), zd0Var);
                        }
                        if (!TextUtils.isEmpty(zd0Var.a())) {
                            tx0.b(this.c, zd0Var.a());
                        }
                    }
                }
            }
            if (e != null && this.b.isEmpty()) {
                for (be0 be0Var : e) {
                    this.b.put(be0Var.b(), be0Var);
                }
            }
        }
    }

    public boolean a(@NonNull Context context, @NonNull de0 de0Var, @Nullable Map<String, Object> map, @Nullable he0 he0Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048576, this, context, de0Var, map, he0Var)) == null) {
            if (b(context, de0Var, map, he0Var)) {
                me0.b(he0Var, de0Var, 0, true);
                return true;
            }
            zd0 zd0Var = null;
            if (me0.f(de0Var.a())) {
                zd0Var = (zd0) vx0.b(this.a, de0Var.a());
            }
            if (me0.g(de0Var.c()) && zd0Var != null) {
                de0Var.f();
                return zd0Var.b(context, de0Var, map, he0Var);
            }
            return ee0.a().a(context, de0Var.b(), map, he0Var);
        }
        return invokeLLLL.booleanValue;
    }

    public boolean b(Context context, de0 de0Var, @Nullable Map<String, Object> map, @Nullable he0 he0Var) {
        InterceptResult invokeLLLL;
        String a;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, de0Var, map, he0Var)) == null) {
            if (this.b.isEmpty()) {
                return false;
            }
            be0 be0Var = null;
            try {
                for (Map.Entry<String, be0> entry : this.b.entrySet()) {
                    String a2 = de0Var.a();
                    if (entry == null || ((be0Var = entry.getValue()) != null && (a = be0Var.a()) != null && TextUtils.equals(a2, a))) {
                        if (be0Var != null && be0Var.d(context, de0Var, map, he0Var)) {
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
