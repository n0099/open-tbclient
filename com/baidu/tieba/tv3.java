package com.baidu.tieba;

import android.text.TextUtils;
import android.util.Log;
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
/* loaded from: classes6.dex */
public class tv3 implements hp1 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean b;
    public transient /* synthetic */ FieldHolder $fh;
    public HashMap a;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948194616, "Lcom/baidu/tieba/tv3;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948194616, "Lcom/baidu/tieba/tv3;");
                return;
            }
        }
        b = wj1.a;
    }

    public tv3() {
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
        c();
    }

    @Override // com.baidu.tieba.hp1
    public mv1 a(String str, JSONObject jSONObject, qg2 qg2Var) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, str, jSONObject, qg2Var)) == null) {
            return b(str, jSONObject, qg2Var);
        }
        return (mv1) invokeLLL.objValue;
    }

    public final mv1 b(String str, JSONObject jSONObject, qg2 qg2Var) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, jSONObject, qg2Var)) == null) {
            sv3 sv3Var = (sv3) this.a.get(str);
            if (sv3Var != null) {
                if (b) {
                    Log.i("GameCenterDispatcher", "action: " + str + " params: " + jSONObject);
                }
                return sv3Var.a(jSONObject, qg2Var);
            }
            if (b) {
                Log.i("GameCenterDispatcher", "action has not found: " + str + ", params: " + jSONObject);
            }
            return new mv1(10002, "no such api.");
        }
        return (mv1) invokeLLL.objValue;
    }

    public final void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            d(new qv3());
            d(new rv3());
            d(new ou3());
            d(new su3());
            d(new pu3());
            d(new hw3());
            d(new qu3());
            d(new xv3());
            d(new ew3());
            d(new nu3());
            d(new uu3());
            d(new ru3());
            d(new tu3());
            d(new aw3());
            d(new gw3());
            d(new bw3());
            d(new dw3());
            d(new cw3());
        }
    }

    public void d(sv3 sv3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, sv3Var) == null) {
            if (b && TextUtils.isEmpty(sv3Var.a)) {
                throw new IllegalArgumentException("action name is null");
            }
            if (b && this.a.containsKey(sv3Var.a)) {
                throw new IllegalArgumentException("duplicate action: " + sv3Var);
            }
            this.a.put(sv3Var.a, sv3Var);
        }
    }
}
