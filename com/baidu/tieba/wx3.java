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
/* loaded from: classes8.dex */
public class wx3 implements lr1 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean b;
    public transient /* synthetic */ FieldHolder $fh;
    public HashMap<String, vx3> a;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948285911, "Lcom/baidu/tieba/wx3;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948285911, "Lcom/baidu/tieba/wx3;");
                return;
            }
        }
        b = am1.a;
    }

    public wx3() {
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

    @Override // com.baidu.tieba.lr1
    public qx1 a(@NonNull String str, @NonNull JSONObject jSONObject, @NonNull ti2 ti2Var) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, str, jSONObject, ti2Var)) == null) {
            return b(str, jSONObject, ti2Var);
        }
        return (qx1) invokeLLL.objValue;
    }

    public final qx1 b(String str, JSONObject jSONObject, ti2 ti2Var) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, jSONObject, ti2Var)) == null) {
            vx3 vx3Var = this.a.get(str);
            if (vx3Var != null) {
                if (b) {
                    Log.i("GameCenterDispatcher", "action: " + str + " params: " + jSONObject);
                }
                return vx3Var.a(jSONObject, ti2Var);
            }
            if (b) {
                Log.i("GameCenterDispatcher", "action has not found: " + str + ", params: " + jSONObject);
            }
            return new qx1(10002, "no such api.");
        }
        return (qx1) invokeLLL.objValue;
    }

    public final void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            d(new tx3());
            d(new ux3());
            d(new rw3());
            d(new vw3());
            d(new sw3());
            d(new ky3());
            d(new tw3());
            d(new ay3());
            d(new hy3());
            d(new qw3());
            d(new xw3());
            d(new uw3());
            d(new ww3());
            d(new dy3());
            d(new jy3());
            d(new ey3());
            d(new gy3());
            d(new fy3());
        }
    }

    public void d(vx3 vx3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, vx3Var) == null) {
            if (b && TextUtils.isEmpty(vx3Var.a)) {
                throw new IllegalArgumentException("action name is null");
            }
            if (b && this.a.containsKey(vx3Var.a)) {
                throw new IllegalArgumentException("duplicate action: " + vx3Var);
            }
            this.a.put(vx3Var.a, vx3Var);
        }
    }
}
