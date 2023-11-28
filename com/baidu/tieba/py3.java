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
public class py3 implements ds1 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile py3 c;
    public transient /* synthetic */ FieldHolder $fh;
    public ky3 a;
    public oy3 b;

    public py3() {
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

    public static py3 b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (c == null) {
                synchronized (py3.class) {
                    if (c == null) {
                        c = new py3();
                    }
                }
            }
            return c;
        }
        return (py3) invokeV.objValue;
    }

    public final void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.a = new ky3();
            this.b = new oy3();
        }
    }

    @Override // com.baidu.tieba.ds1
    public iy1 a(@NonNull String str, @NonNull JSONObject jSONObject, @NonNull lj2 lj2Var) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, str, jSONObject, lj2Var)) == null) {
            if (this.a.e(str)) {
                return this.a.a(str, jSONObject, lj2Var);
            }
            if (this.a.f()) {
                return this.b.a(str, jSONObject, lj2Var);
            }
            return new iy1(10001, "authorize fail.");
        }
        return (iy1) invokeLLL.objValue;
    }
}
