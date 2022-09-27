package com.baidu.tieba;

import android.util.Log;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import org.json.JSONArray;
/* loaded from: classes6.dex */
public class yp3 implements zi4 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948337805, "Lcom/baidu/tieba/yp3;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948337805, "Lcom/baidu/tieba/yp3;");
                return;
            }
        }
        a = vj1.a;
    }

    public yp3() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    @Override // com.baidu.tieba.zi4
    public boolean a(JSONArray jSONArray) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, jSONArray)) == null) {
            if (a) {
                Log.d("OpenBehaviorUploader", "upload stat data -> " + jSONArray.toString());
            }
            dq3 dq3Var = new dq3();
            HashMap hashMap = new HashMap(2);
            hashMap.put("cuid", ri4.g().getDeviceId(AppRuntime.getApplication()));
            hashMap.put("uuid", ri4.g().o(AppRuntime.getApplication()));
            cq3.d().g(hashMap, jSONArray.toString().getBytes(), null, dq3Var);
            if (a) {
                Log.d("OpenBehaviorUploader", "errorCode : " + dq3Var.a);
                Log.d("OpenBehaviorUploader", "errorMsg : " + dq3Var.b);
            }
            int i = dq3Var.a;
            if (i == 1 || i == 2 || i == 4) {
                kj4.a();
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }
}
