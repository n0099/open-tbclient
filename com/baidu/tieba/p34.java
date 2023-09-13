package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class p34 implements cx1 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile p34 c;
    public transient /* synthetic */ FieldHolder $fh;
    public k34 a;
    public o34 b;

    public p34() {
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

    public static p34 b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (c == null) {
                synchronized (p34.class) {
                    if (c == null) {
                        c = new p34();
                    }
                }
            }
            return c;
        }
        return (p34) invokeV.objValue;
    }

    public final void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.a = new k34();
            this.b = new o34();
        }
    }

    @Override // com.baidu.tieba.cx1
    public h32 a(@NonNull String str, @NonNull JSONObject jSONObject, @NonNull lo2 lo2Var) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, str, jSONObject, lo2Var)) == null) {
            if (this.a.e(str)) {
                return this.a.a(str, jSONObject, lo2Var);
            }
            if (this.a.f()) {
                return this.b.a(str, jSONObject, lo2Var);
            }
            return new h32(10001, "authorize fail.");
        }
        return (h32) invokeLLL.objValue;
    }
}
