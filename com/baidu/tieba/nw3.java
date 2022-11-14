package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class nw3 implements aq1 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile nw3 c;
    public transient /* synthetic */ FieldHolder $fh;
    public iw3 a;
    public mw3 b;

    public nw3() {
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

    public static nw3 b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (c == null) {
                synchronized (nw3.class) {
                    if (c == null) {
                        c = new nw3();
                    }
                }
            }
            return c;
        }
        return (nw3) invokeV.objValue;
    }

    public final void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.a = new iw3();
            this.b = new mw3();
        }
    }

    @Override // com.baidu.tieba.aq1
    public fw1 a(@NonNull String str, @NonNull JSONObject jSONObject, @NonNull jh2 jh2Var) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, str, jSONObject, jh2Var)) == null) {
            if (this.a.e(str)) {
                return this.a.a(str, jSONObject, jh2Var);
            }
            if (this.a.f()) {
                return this.b.a(str, jSONObject, jh2Var);
            }
            return new fw1(10001, "authorize fail.");
        }
        return (fw1) invokeLLL.objValue;
    }
}
