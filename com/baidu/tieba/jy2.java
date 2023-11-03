package com.baidu.tieba;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.performance.HybridUbcFlow;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import org.json.JSONArray;
/* loaded from: classes6.dex */
public class jy2 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean e;
    public static final jy2 f;
    public transient /* synthetic */ FieldHolder $fh;
    public final List<ly2> a;
    public final Map<String, ly2> b;
    public boolean c;
    public iy2 d;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947899558, "Lcom/baidu/tieba/jy2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947899558, "Lcom/baidu/tieba/jy2;");
                return;
            }
        }
        e = rm1.a;
        f = new jy2();
    }

    public static jy2 f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            return f;
        }
        return (jy2) invokeV.objValue;
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.c = true;
            synchronized (this.a) {
                this.a.clear();
                this.b.clear();
            }
            if (e) {
                Log.d("MaUpdateRecorder", "done");
            }
        }
    }

    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.c = false;
            synchronized (this.a) {
                this.a.clear();
                this.b.clear();
            }
            if (e) {
                Log.d("MaUpdateRecorder", "reset");
            }
        }
    }

    public jy2() {
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
        this.a = new ArrayList();
        this.b = new HashMap();
        this.c = false;
    }

    public void a(HybridUbcFlow hybridUbcFlow) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048576, this, hybridUbcFlow) != null) || hybridUbcFlow == null) {
            return;
        }
        JSONArray e2 = e();
        if (e2 != null && e2.length() > 0) {
            hybridUbcFlow.D("ma_update_recorder", e2.toString());
        }
        c();
    }

    public void h(iy2 iy2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, iy2Var) == null) {
            this.d = iy2Var;
        }
    }

    public String b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            if (this.c) {
                return null;
            }
            if (e) {
                Log.d("MaUpdateRecorder", "begin update scope id - " + str);
            }
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            long currentTimeMillis = System.currentTimeMillis();
            String str2 = Thread.currentThread().getName() + "-" + UUID.randomUUID().toString();
            ly2 ly2Var = new ly2(str);
            ly2Var.a(currentTimeMillis);
            synchronized (this.a) {
                this.b.put(str2, ly2Var);
            }
            if (e) {
                Log.d("MaUpdateRecorder", "begin update uni tag - " + str2);
                Log.d("MaUpdateRecorder", "begin update ts - " + currentTimeMillis);
            }
            return str2;
        }
        return (String) invokeL.objValue;
    }

    public void d(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048579, this, str) != null) || this.c) {
            return;
        }
        if (e) {
            Log.d("MaUpdateRecorder", "end update uni tag - " + str);
        }
        if (TextUtils.isEmpty(str)) {
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        synchronized (this.a) {
            ly2 ly2Var = this.b.get(str);
            if (ly2Var != null) {
                ly2Var.c(currentTimeMillis);
                this.a.add(ly2Var);
                this.b.remove(str);
            }
        }
        if (e) {
            Log.d("MaUpdateRecorder", "end update ts - " + currentTimeMillis);
        }
    }

    public final JSONArray e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            JSONArray jSONArray = new JSONArray();
            synchronized (this.a) {
                try {
                    for (ly2 ly2Var : this.a) {
                        if (ly2Var != null && (this.d == null || this.d.a(ly2Var))) {
                            jSONArray.put(ly2Var.d());
                        }
                    }
                } catch (Exception e2) {
                    if (e) {
                        e2.printStackTrace();
                    }
                }
            }
            if (e) {
                Log.d("MaUpdateRecorder", jSONArray.toString());
            }
            return jSONArray;
        }
        return (JSONArray) invokeV.objValue;
    }
}
