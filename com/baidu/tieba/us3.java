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
/* loaded from: classes8.dex */
public class us3 implements ul4 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948221524, "Lcom/baidu/tieba/us3;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948221524, "Lcom/baidu/tieba/us3;");
                return;
            }
        }
        a = sm1.a;
    }

    public us3() {
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

    @Override // com.baidu.tieba.ul4
    public boolean a(JSONArray jSONArray) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, jSONArray)) == null) {
            if (a) {
                Log.d("OpenBehaviorUploader", "upload stat data -> " + jSONArray.toString());
            }
            zs3 zs3Var = new zs3();
            HashMap hashMap = new HashMap(2);
            hashMap.put("cuid", ml4.h().getDeviceId(AppRuntime.getApplication()));
            hashMap.put("uuid", ml4.h().o(AppRuntime.getApplication()));
            ys3.d().g(hashMap, jSONArray.toString().getBytes(), null, zs3Var);
            if (a) {
                Log.d("OpenBehaviorUploader", "errorCode : " + zs3Var.a);
                Log.d("OpenBehaviorUploader", "errorMsg : " + zs3Var.b);
            }
            int i = zs3Var.a;
            if (i != 1 && i != 2 && i != 4) {
                return true;
            }
            fm4.a();
            return false;
        }
        return invokeL.booleanValue;
    }
}
