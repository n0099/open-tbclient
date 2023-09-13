package com.baidu.tieba;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class o34 implements cx1 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean b;
    public transient /* synthetic */ FieldHolder $fh;
    public HashMap<String, n34> a;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947981305, "Lcom/baidu/tieba/o34;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947981305, "Lcom/baidu/tieba/o34;");
                return;
            }
        }
        b = rr1.a;
    }

    public o34() {
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
        this.a = new HashMap<>();
        c();
    }

    @Override // com.baidu.tieba.cx1
    public h32 a(@NonNull String str, @NonNull JSONObject jSONObject, @NonNull lo2 lo2Var) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, str, jSONObject, lo2Var)) == null) {
            return b(str, jSONObject, lo2Var);
        }
        return (h32) invokeLLL.objValue;
    }

    public final h32 b(String str, JSONObject jSONObject, lo2 lo2Var) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, jSONObject, lo2Var)) == null) {
            n34 n34Var = this.a.get(str);
            if (n34Var != null) {
                if (b) {
                    Log.i("GameCenterDispatcher", "action: " + str + " params: " + jSONObject);
                }
                return n34Var.a(jSONObject, lo2Var);
            }
            if (b) {
                Log.i("GameCenterDispatcher", "action has not found: " + str + ", params: " + jSONObject);
            }
            return new h32(10002, "no such api.");
        }
        return (h32) invokeLLL.objValue;
    }

    public final void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            d(new l34());
            d(new m34());
            d(new j24());
            d(new n24());
            d(new k24());
            d(new c44());
            d(new l24());
            d(new s34());
            d(new z34());
            d(new i24());
            d(new p24());
            d(new m24());
            d(new o24());
            d(new v34());
            d(new b44());
            d(new w34());
            d(new y34());
            d(new x34());
        }
    }

    public void d(n34 n34Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, n34Var) == null) {
            if (b && TextUtils.isEmpty(n34Var.a)) {
                throw new IllegalArgumentException("action name is null");
            }
            if (b && this.a.containsKey(n34Var.a)) {
                throw new IllegalArgumentException("duplicate action: " + n34Var);
            }
            this.a.put(n34Var.a, n34Var);
        }
    }
}
