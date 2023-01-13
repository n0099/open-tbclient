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
/* loaded from: classes6.dex */
public class qw3 implements eq1 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean b;
    public transient /* synthetic */ FieldHolder $fh;
    public HashMap<String, pw3> a;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948106204, "Lcom/baidu/tieba/qw3;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948106204, "Lcom/baidu/tieba/qw3;");
                return;
            }
        }
        b = tk1.a;
    }

    public qw3() {
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

    @Override // com.baidu.tieba.eq1
    public jw1 a(@NonNull String str, @NonNull JSONObject jSONObject, @NonNull nh2 nh2Var) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, str, jSONObject, nh2Var)) == null) {
            return b(str, jSONObject, nh2Var);
        }
        return (jw1) invokeLLL.objValue;
    }

    public final jw1 b(String str, JSONObject jSONObject, nh2 nh2Var) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, jSONObject, nh2Var)) == null) {
            pw3 pw3Var = this.a.get(str);
            if (pw3Var != null) {
                if (b) {
                    Log.i("GameCenterDispatcher", "action: " + str + " params: " + jSONObject);
                }
                return pw3Var.a(jSONObject, nh2Var);
            }
            if (b) {
                Log.i("GameCenterDispatcher", "action has not found: " + str + ", params: " + jSONObject);
            }
            return new jw1(10002, "no such api.");
        }
        return (jw1) invokeLLL.objValue;
    }

    public final void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            d(new nw3());
            d(new ow3());
            d(new lv3());
            d(new pv3());
            d(new mv3());
            d(new ex3());
            d(new nv3());
            d(new uw3());
            d(new bx3());
            d(new kv3());
            d(new rv3());
            d(new ov3());
            d(new qv3());
            d(new xw3());
            d(new dx3());
            d(new yw3());
            d(new ax3());
            d(new zw3());
        }
    }

    public void d(pw3 pw3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, pw3Var) == null) {
            if (b && TextUtils.isEmpty(pw3Var.a)) {
                throw new IllegalArgumentException("action name is null");
            }
            if (b && this.a.containsKey(pw3Var.a)) {
                throw new IllegalArgumentException("duplicate action: " + pw3Var);
            }
            this.a.put(pw3Var.a, pw3Var);
        }
    }
}
