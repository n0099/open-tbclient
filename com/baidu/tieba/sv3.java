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
public class sv3 implements gp1 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean b;
    public transient /* synthetic */ FieldHolder $fh;
    public HashMap<String, rv3> a;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948164825, "Lcom/baidu/tieba/sv3;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948164825, "Lcom/baidu/tieba/sv3;");
                return;
            }
        }
        b = vj1.a;
    }

    public sv3() {
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

    @Override // com.baidu.tieba.gp1
    public lv1 a(@NonNull String str, @NonNull JSONObject jSONObject, @NonNull pg2 pg2Var) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, str, jSONObject, pg2Var)) == null) ? b(str, jSONObject, pg2Var) : (lv1) invokeLLL.objValue;
    }

    public final lv1 b(String str, JSONObject jSONObject, pg2 pg2Var) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, jSONObject, pg2Var)) == null) {
            rv3 rv3Var = this.a.get(str);
            if (rv3Var != null) {
                if (b) {
                    Log.i("GameCenterDispatcher", "action: " + str + " params: " + jSONObject);
                }
                return rv3Var.a(jSONObject, pg2Var);
            }
            if (b) {
                Log.i("GameCenterDispatcher", "action has not found: " + str + ", params: " + jSONObject);
            }
            return new lv1(10002, "no such api.");
        }
        return (lv1) invokeLLL.objValue;
    }

    public final void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            d(new pv3());
            d(new qv3());
            d(new nu3());
            d(new ru3());
            d(new ou3());
            d(new gw3());
            d(new pu3());
            d(new wv3());
            d(new dw3());
            d(new mu3());
            d(new tu3());
            d(new qu3());
            d(new su3());
            d(new zv3());
            d(new fw3());
            d(new aw3());
            d(new cw3());
            d(new bw3());
        }
    }

    public void d(rv3 rv3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, rv3Var) == null) {
            if (b && TextUtils.isEmpty(rv3Var.a)) {
                throw new IllegalArgumentException("action name is null");
            }
            if (b && this.a.containsKey(rv3Var.a)) {
                throw new IllegalArgumentException("duplicate action: " + rv3Var);
            }
            this.a.put(rv3Var.a, rv3Var);
        }
    }
}
