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
public class tv3 implements gp1 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile tv3 c;
    public transient /* synthetic */ FieldHolder $fh;
    public ov3 a;
    public sv3 b;

    public tv3() {
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

    public static tv3 b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (c == null) {
                synchronized (tv3.class) {
                    if (c == null) {
                        c = new tv3();
                    }
                }
            }
            return c;
        }
        return (tv3) invokeV.objValue;
    }

    @Override // com.baidu.tieba.gp1
    public lv1 a(@NonNull String str, @NonNull JSONObject jSONObject, @NonNull pg2 pg2Var) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, str, jSONObject, pg2Var)) == null) {
            if (this.a.e(str)) {
                return this.a.a(str, jSONObject, pg2Var);
            }
            if (this.a.f()) {
                return this.b.a(str, jSONObject, pg2Var);
            }
            return new lv1(10001, "authorize fail.");
        }
        return (lv1) invokeLLL.objValue;
    }

    public final void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.a = new ov3();
            this.b = new sv3();
        }
    }
}
