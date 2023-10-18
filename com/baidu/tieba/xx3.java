package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class xx3 implements lr1 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile xx3 c;
    public transient /* synthetic */ FieldHolder $fh;
    public sx3 a;
    public wx3 b;

    public xx3() {
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

    public static xx3 b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (c == null) {
                synchronized (xx3.class) {
                    if (c == null) {
                        c = new xx3();
                    }
                }
            }
            return c;
        }
        return (xx3) invokeV.objValue;
    }

    public final void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.a = new sx3();
            this.b = new wx3();
        }
    }

    @Override // com.baidu.tieba.lr1
    public qx1 a(@NonNull String str, @NonNull JSONObject jSONObject, @NonNull ti2 ti2Var) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, str, jSONObject, ti2Var)) == null) {
            if (this.a.e(str)) {
                return this.a.a(str, jSONObject, ti2Var);
            }
            if (this.a.f()) {
                return this.b.a(str, jSONObject, ti2Var);
            }
            return new qx1(10001, "authorize fail.");
        }
        return (qx1) invokeLLL.objValue;
    }
}
