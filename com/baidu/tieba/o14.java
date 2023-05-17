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
public class o14 implements bv1 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile o14 c;
    public transient /* synthetic */ FieldHolder $fh;
    public j14 a;
    public n14 b;

    public o14() {
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

    public static o14 b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (c == null) {
                synchronized (o14.class) {
                    if (c == null) {
                        c = new o14();
                    }
                }
            }
            return c;
        }
        return (o14) invokeV.objValue;
    }

    public final void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.a = new j14();
            this.b = new n14();
        }
    }

    @Override // com.baidu.tieba.bv1
    public g12 a(@NonNull String str, @NonNull JSONObject jSONObject, @NonNull km2 km2Var) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, str, jSONObject, km2Var)) == null) {
            if (this.a.e(str)) {
                return this.a.a(str, jSONObject, km2Var);
            }
            if (this.a.f()) {
                return this.b.a(str, jSONObject, km2Var);
            }
            return new g12(10001, "authorize fail.");
        }
        return (g12) invokeLLL.objValue;
    }
}
