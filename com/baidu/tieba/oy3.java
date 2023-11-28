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
public class oy3 implements ds1 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean b;
    public transient /* synthetic */ FieldHolder $fh;
    public HashMap<String, ny3> a;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948048544, "Lcom/baidu/tieba/oy3;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948048544, "Lcom/baidu/tieba/oy3;");
                return;
            }
        }
        b = sm1.a;
    }

    public oy3() {
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

    @Override // com.baidu.tieba.ds1
    public iy1 a(@NonNull String str, @NonNull JSONObject jSONObject, @NonNull lj2 lj2Var) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, str, jSONObject, lj2Var)) == null) {
            return b(str, jSONObject, lj2Var);
        }
        return (iy1) invokeLLL.objValue;
    }

    public final iy1 b(String str, JSONObject jSONObject, lj2 lj2Var) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, jSONObject, lj2Var)) == null) {
            ny3 ny3Var = this.a.get(str);
            if (ny3Var != null) {
                if (b) {
                    Log.i("GameCenterDispatcher", "action: " + str + " params: " + jSONObject);
                }
                return ny3Var.a(jSONObject, lj2Var);
            }
            if (b) {
                Log.i("GameCenterDispatcher", "action has not found: " + str + ", params: " + jSONObject);
            }
            return new iy1(10002, "no such api.");
        }
        return (iy1) invokeLLL.objValue;
    }

    public final void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            d(new ly3());
            d(new my3());
            d(new jx3());
            d(new nx3());
            d(new kx3());
            d(new cz3());
            d(new lx3());
            d(new sy3());
            d(new zy3());
            d(new ix3());
            d(new px3());
            d(new mx3());
            d(new ox3());
            d(new vy3());
            d(new bz3());
            d(new wy3());
            d(new yy3());
            d(new xy3());
        }
    }

    public void d(ny3 ny3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, ny3Var) == null) {
            if (b && TextUtils.isEmpty(ny3Var.a)) {
                throw new IllegalArgumentException("action name is null");
            }
            if (b && this.a.containsKey(ny3Var.a)) {
                throw new IllegalArgumentException("duplicate action: " + ny3Var);
            }
            this.a.put(ny3Var.a, ny3Var);
        }
    }
}
