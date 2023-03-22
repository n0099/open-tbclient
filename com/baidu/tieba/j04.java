package com.baidu.tieba;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class j04 extends zz3 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean c;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947829467, "Lcom/baidu/tieba/j04;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947829467, "Lcom/baidu/tieba/j04;");
                return;
            }
        }
        c = do1.a;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public j04() {
        super("GetSwanGameDuration");
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((String) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    public static boolean b(Long l, Long l2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, l, l2)) == null) {
            if (l.longValue() / 86400000 == l2.longValue() / 86400000) {
                return true;
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    @Override // com.baidu.tieba.zz3
    public tz1 a(@NonNull JSONObject jSONObject, @NonNull xk2 xk2Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, jSONObject, xk2Var)) == null) {
            if (jSONObject == null) {
                xk2Var.onFail(202, "params may be error");
                return null;
            }
            if (c) {
                Log.e("GetSwanGameDuration", "params is " + jSONObject.toString());
            }
            String optString = jSONObject.optString("swanGameId");
            if (TextUtils.isEmpty(optString)) {
                xk2Var.onFail(202, "params may be error");
            } else {
                bg3 a = hg3.a();
                if (!b(Long.valueOf(a.getLong(optString + "_LastPause", 0L)), Long.valueOf(System.currentTimeMillis()))) {
                    bg3 a2 = hg3.a();
                    a2.putLong(optString + "_Duration", 0L);
                }
                bg3 a3 = hg3.a();
                long j = a3.getLong(optString + "_Duration", 0L);
                JSONObject jSONObject2 = new JSONObject();
                JSONObject jSONObject3 = new JSONObject();
                try {
                    jSONObject3.put("swanGameDuration", j);
                    jSONObject2.put("data", jSONObject3);
                } catch (JSONException e) {
                    if (c) {
                        e.printStackTrace();
                    }
                }
                xk2Var.a(jSONObject2);
            }
            return null;
        }
        return (tz1) invokeLL.objValue;
    }
}
