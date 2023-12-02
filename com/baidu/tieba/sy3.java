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
public class sy3 implements gs1 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile sy3 c;
    public transient /* synthetic */ FieldHolder $fh;
    public ny3 a;
    public ry3 b;

    public sy3() {
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

    public static sy3 b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (c == null) {
                synchronized (sy3.class) {
                    if (c == null) {
                        c = new sy3();
                    }
                }
            }
            return c;
        }
        return (sy3) invokeV.objValue;
    }

    public final void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.a = new ny3();
            this.b = new ry3();
        }
    }

    @Override // com.baidu.tieba.gs1
    public ly1 a(@NonNull String str, @NonNull JSONObject jSONObject, @NonNull oj2 oj2Var) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, str, jSONObject, oj2Var)) == null) {
            if (this.a.e(str)) {
                return this.a.a(str, jSONObject, oj2Var);
            }
            if (this.a.f()) {
                return this.b.a(str, jSONObject, oj2Var);
            }
            return new ly1(10001, "authorize fail.");
        }
        return (ly1) invokeLLL.objValue;
    }
}
