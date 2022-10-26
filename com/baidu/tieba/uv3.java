package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class uv3 implements hp1 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile uv3 c;
    public transient /* synthetic */ FieldHolder $fh;
    public pv3 a;
    public tv3 b;

    public uv3() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        c();
    }

    public static uv3 b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (c == null) {
                synchronized (uv3.class) {
                    if (c == null) {
                        c = new uv3();
                    }
                }
            }
            return c;
        }
        return (uv3) invokeV.objValue;
    }

    public final void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.a = new pv3();
            this.b = new tv3();
        }
    }

    @Override // com.baidu.tieba.hp1
    public mv1 a(String str, JSONObject jSONObject, qg2 qg2Var) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, str, jSONObject, qg2Var)) == null) {
            if (this.a.e(str)) {
                return this.a.a(str, jSONObject, qg2Var);
            }
            if (this.a.f()) {
                return this.b.a(str, jSONObject, qg2Var);
            }
            return new mv1(10001, "authorize fail.");
        }
        return (mv1) invokeLLL.objValue;
    }
}
