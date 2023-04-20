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
/* loaded from: classes5.dex */
public class iu3 implements jn4 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947865954, "Lcom/baidu/tieba/iu3;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947865954, "Lcom/baidu/tieba/iu3;");
                return;
            }
        }
        a = fo1.a;
    }

    public iu3() {
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

    @Override // com.baidu.tieba.jn4
    public boolean a(JSONArray jSONArray) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, jSONArray)) == null) {
            if (a) {
                Log.d("OpenBehaviorUploader", "upload stat data -> " + jSONArray.toString());
            }
            nu3 nu3Var = new nu3();
            HashMap hashMap = new HashMap(2);
            hashMap.put("cuid", bn4.g().getDeviceId(AppRuntime.getApplication()));
            hashMap.put("uuid", bn4.g().o(AppRuntime.getApplication()));
            mu3.d().g(hashMap, jSONArray.toString().getBytes(), null, nu3Var);
            if (a) {
                Log.d("OpenBehaviorUploader", "errorCode : " + nu3Var.a);
                Log.d("OpenBehaviorUploader", "errorMsg : " + nu3Var.b);
            }
            int i = nu3Var.a;
            if (i != 1 && i != 2 && i != 4) {
                return true;
            }
            un4.a();
            return false;
        }
        return invokeL.booleanValue;
    }
}
