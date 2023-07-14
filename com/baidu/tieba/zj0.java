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
public class zj0 {
    public static /* synthetic */ Interceptable $ic;
    public static final List<bk0> d;
    public static final List<dk0> e;
    public transient /* synthetic */ FieldHolder $fh;
    public final Map<String, bk0> a;
    public final Map<String, dk0> b;
    public final ArrayList<String> c;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948361737, "Lcom/baidu/tieba/zj0;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948361737, "Lcom/baidu/tieba/zj0;");
                return;
            }
        }
        kk0 kk0Var = new kk0();
        d = kk0Var.a.getList();
        e = kk0Var.b.getList();
    }

    public zj0() {
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
        synchronized (zj0.class) {
            if (d != null && this.a.isEmpty()) {
                for (bk0 bk0Var : d) {
                    if (bk0Var != null) {
                        if (z31.b(this.a, bk0Var.a()) == null) {
                            z31.e(this.a, bk0Var.a(), bk0Var);
                        }
                        if (!TextUtils.isEmpty(bk0Var.a())) {
                            x31.b(this.c, bk0Var.a());
                        }
                    }
                }
            }
            if (e != null && this.b.isEmpty()) {
                for (dk0 dk0Var : e) {
                    this.b.put(dk0Var.b(), dk0Var);
                }
            }
        }
    }

    public boolean a(@NonNull Context context, @NonNull fk0 fk0Var, @Nullable Map<String, Object> map, @Nullable jk0 jk0Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048576, this, context, fk0Var, map, jk0Var)) == null) {
            if (b(context, fk0Var, map, jk0Var)) {
                ok0.b(jk0Var, fk0Var, 0, true);
                return true;
            }
            bk0 bk0Var = null;
            if (ok0.f(fk0Var.a())) {
                bk0Var = (bk0) z31.b(this.a, fk0Var.a());
            }
            if (ok0.g(fk0Var.c()) && bk0Var != null) {
                fk0Var.f();
                return bk0Var.b(context, fk0Var, map, jk0Var);
            }
            return gk0.a().a(context, fk0Var.b(), map, jk0Var);
        }
        return invokeLLLL.booleanValue;
    }

    public boolean b(Context context, fk0 fk0Var, @Nullable Map<String, Object> map, @Nullable jk0 jk0Var) {
        InterceptResult invokeLLLL;
        String a;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, fk0Var, map, jk0Var)) == null) {
            if (this.b.isEmpty()) {
                return false;
            }
            dk0 dk0Var = null;
            try {
                for (Map.Entry<String, dk0> entry : this.b.entrySet()) {
                    String a2 = fk0Var.a();
                    if (entry == null || ((dk0Var = entry.getValue()) != null && (a = dk0Var.a()) != null && TextUtils.equals(a2, a))) {
                        if (dk0Var != null && dk0Var.d(context, fk0Var, map, jk0Var)) {
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
