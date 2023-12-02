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
public class ry3 implements gs1 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean b;
    public transient /* synthetic */ FieldHolder $fh;
    public HashMap<String, qy3> a;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948137917, "Lcom/baidu/tieba/ry3;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948137917, "Lcom/baidu/tieba/ry3;");
                return;
            }
        }
        b = vm1.a;
    }

    public ry3() {
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

    @Override // com.baidu.tieba.gs1
    public ly1 a(@NonNull String str, @NonNull JSONObject jSONObject, @NonNull oj2 oj2Var) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, str, jSONObject, oj2Var)) == null) {
            return b(str, jSONObject, oj2Var);
        }
        return (ly1) invokeLLL.objValue;
    }

    public final ly1 b(String str, JSONObject jSONObject, oj2 oj2Var) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, jSONObject, oj2Var)) == null) {
            qy3 qy3Var = this.a.get(str);
            if (qy3Var != null) {
                if (b) {
                    Log.i("GameCenterDispatcher", "action: " + str + " params: " + jSONObject);
                }
                return qy3Var.a(jSONObject, oj2Var);
            }
            if (b) {
                Log.i("GameCenterDispatcher", "action has not found: " + str + ", params: " + jSONObject);
            }
            return new ly1(10002, "no such api.");
        }
        return (ly1) invokeLLL.objValue;
    }

    public final void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            d(new oy3());
            d(new py3());
            d(new mx3());
            d(new qx3());
            d(new nx3());
            d(new fz3());
            d(new ox3());
            d(new vy3());
            d(new cz3());
            d(new lx3());
            d(new sx3());
            d(new px3());
            d(new rx3());
            d(new yy3());
            d(new ez3());
            d(new zy3());
            d(new bz3());
            d(new az3());
        }
    }

    public void d(qy3 qy3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, qy3Var) == null) {
            if (b && TextUtils.isEmpty(qy3Var.a)) {
                throw new IllegalArgumentException("action name is null");
            }
            if (b && this.a.containsKey(qy3Var.a)) {
                throw new IllegalArgumentException("duplicate action: " + qy3Var);
            }
            this.a.put(qy3Var.a, qy3Var);
        }
    }
}
