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
/* loaded from: classes5.dex */
public class mw3 implements aq1 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean b;
    public transient /* synthetic */ FieldHolder $fh;
    public HashMap<String, lw3> a;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947987040, "Lcom/baidu/tieba/mw3;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947987040, "Lcom/baidu/tieba/mw3;");
                return;
            }
        }
        b = pk1.a;
    }

    public mw3() {
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

    @Override // com.baidu.tieba.aq1
    public fw1 a(@NonNull String str, @NonNull JSONObject jSONObject, @NonNull jh2 jh2Var) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, str, jSONObject, jh2Var)) == null) {
            return b(str, jSONObject, jh2Var);
        }
        return (fw1) invokeLLL.objValue;
    }

    public final fw1 b(String str, JSONObject jSONObject, jh2 jh2Var) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, jSONObject, jh2Var)) == null) {
            lw3 lw3Var = this.a.get(str);
            if (lw3Var != null) {
                if (b) {
                    Log.i("GameCenterDispatcher", "action: " + str + " params: " + jSONObject);
                }
                return lw3Var.a(jSONObject, jh2Var);
            }
            if (b) {
                Log.i("GameCenterDispatcher", "action has not found: " + str + ", params: " + jSONObject);
            }
            return new fw1(10002, "no such api.");
        }
        return (fw1) invokeLLL.objValue;
    }

    public final void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            d(new jw3());
            d(new kw3());
            d(new hv3());
            d(new lv3());
            d(new iv3());
            d(new ax3());
            d(new jv3());
            d(new qw3());
            d(new xw3());
            d(new gv3());
            d(new nv3());
            d(new kv3());
            d(new mv3());
            d(new tw3());
            d(new zw3());
            d(new uw3());
            d(new ww3());
            d(new vw3());
        }
    }

    public void d(lw3 lw3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, lw3Var) == null) {
            if (b && TextUtils.isEmpty(lw3Var.a)) {
                throw new IllegalArgumentException("action name is null");
            }
            if (b && this.a.containsKey(lw3Var.a)) {
                throw new IllegalArgumentException("duplicate action: " + lw3Var);
            }
            this.a.put(lw3Var.a, lw3Var);
        }
    }
}
