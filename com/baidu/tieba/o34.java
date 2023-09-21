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
public class o34 implements bx1 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile o34 c;
    public transient /* synthetic */ FieldHolder $fh;
    public j34 a;
    public n34 b;

    public o34() {
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

    public static o34 b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (c == null) {
                synchronized (o34.class) {
                    if (c == null) {
                        c = new o34();
                    }
                }
            }
            return c;
        }
        return (o34) invokeV.objValue;
    }

    public final void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.a = new j34();
            this.b = new n34();
        }
    }

    @Override // com.baidu.tieba.bx1
    public g32 a(@NonNull String str, @NonNull JSONObject jSONObject, @NonNull ko2 ko2Var) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, str, jSONObject, ko2Var)) == null) {
            if (this.a.e(str)) {
                return this.a.a(str, jSONObject, ko2Var);
            }
            if (this.a.f()) {
                return this.b.a(str, jSONObject, ko2Var);
            }
            return new g32(10001, "authorize fail.");
        }
        return (g32) invokeLLL.objValue;
    }
}
