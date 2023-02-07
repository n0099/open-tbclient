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
public class jv3 implements ko4 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947896706, "Lcom/baidu/tieba/jv3;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947896706, "Lcom/baidu/tieba/jv3;");
                return;
            }
        }
        a = gp1.a;
    }

    public jv3() {
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

    @Override // com.baidu.tieba.ko4
    public boolean a(JSONArray jSONArray) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, jSONArray)) == null) {
            if (a) {
                Log.d("OpenBehaviorUploader", "upload stat data -> " + jSONArray.toString());
            }
            ov3 ov3Var = new ov3();
            HashMap hashMap = new HashMap(2);
            hashMap.put("cuid", co4.g().getDeviceId(AppRuntime.getApplication()));
            hashMap.put("uuid", co4.g().o(AppRuntime.getApplication()));
            nv3.d().g(hashMap, jSONArray.toString().getBytes(), null, ov3Var);
            if (a) {
                Log.d("OpenBehaviorUploader", "errorCode : " + ov3Var.a);
                Log.d("OpenBehaviorUploader", "errorMsg : " + ov3Var.b);
            }
            int i = ov3Var.a;
            if (i != 1 && i != 2 && i != 4) {
                return true;
            }
            vo4.a();
            return false;
        }
        return invokeL.booleanValue;
    }
}
