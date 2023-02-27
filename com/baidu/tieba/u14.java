package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class u14 implements hv1 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile u14 c;
    public transient /* synthetic */ FieldHolder $fh;
    public p14 a;
    public t14 b;

    public u14() {
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

    public static u14 b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (c == null) {
                synchronized (u14.class) {
                    if (c == null) {
                        c = new u14();
                    }
                }
            }
            return c;
        }
        return (u14) invokeV.objValue;
    }

    public final void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.a = new p14();
            this.b = new t14();
        }
    }

    @Override // com.baidu.tieba.hv1
    public m12 a(@NonNull String str, @NonNull JSONObject jSONObject, @NonNull qm2 qm2Var) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, str, jSONObject, qm2Var)) == null) {
            if (this.a.e(str)) {
                return this.a.a(str, jSONObject, qm2Var);
            }
            if (this.a.f()) {
                return this.b.a(str, jSONObject, qm2Var);
            }
            return new m12(10001, "authorize fail.");
        }
        return (m12) invokeLLL.objValue;
    }
}
