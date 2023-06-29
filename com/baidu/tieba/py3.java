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
/* loaded from: classes7.dex */
public class py3 implements qr4 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948078335, "Lcom/baidu/tieba/py3;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948078335, "Lcom/baidu/tieba/py3;");
                return;
            }
        }
        a = ms1.a;
    }

    public py3() {
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

    @Override // com.baidu.tieba.qr4
    public boolean a(JSONArray jSONArray) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, jSONArray)) == null) {
            if (a) {
                Log.d("OpenBehaviorUploader", "upload stat data -> " + jSONArray.toString());
            }
            uy3 uy3Var = new uy3();
            HashMap hashMap = new HashMap(2);
            hashMap.put("cuid", ir4.g().getDeviceId(AppRuntime.getApplication()));
            hashMap.put("uuid", ir4.g().o(AppRuntime.getApplication()));
            ty3.d().g(hashMap, jSONArray.toString().getBytes(), null, uy3Var);
            if (a) {
                Log.d("OpenBehaviorUploader", "errorCode : " + uy3Var.a);
                Log.d("OpenBehaviorUploader", "errorMsg : " + uy3Var.b);
            }
            int i = uy3Var.a;
            if (i != 1 && i != 2 && i != 4) {
                return true;
            }
            bs4.a();
            return false;
        }
        return invokeL.booleanValue;
    }
}
