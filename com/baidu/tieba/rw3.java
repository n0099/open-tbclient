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
public class rw3 implements eq1 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile rw3 c;
    public transient /* synthetic */ FieldHolder $fh;
    public mw3 a;
    public qw3 b;

    public rw3() {
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

    public static rw3 b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (c == null) {
                synchronized (rw3.class) {
                    if (c == null) {
                        c = new rw3();
                    }
                }
            }
            return c;
        }
        return (rw3) invokeV.objValue;
    }

    public final void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.a = new mw3();
            this.b = new qw3();
        }
    }

    @Override // com.baidu.tieba.eq1
    public jw1 a(@NonNull String str, @NonNull JSONObject jSONObject, @NonNull nh2 nh2Var) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, str, jSONObject, nh2Var)) == null) {
            if (this.a.e(str)) {
                return this.a.a(str, jSONObject, nh2Var);
            }
            if (this.a.f()) {
                return this.b.a(str, jSONObject, nh2Var);
            }
            return new jw1(10001, "authorize fail.");
        }
        return (jw1) invokeLLL.objValue;
    }
}
