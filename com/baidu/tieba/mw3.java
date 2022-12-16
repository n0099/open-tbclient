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
public class mw3 implements zp1 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile mw3 c;
    public transient /* synthetic */ FieldHolder $fh;
    public hw3 a;
    public lw3 b;

    public mw3() {
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

    public static mw3 b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (c == null) {
                synchronized (mw3.class) {
                    if (c == null) {
                        c = new mw3();
                    }
                }
            }
            return c;
        }
        return (mw3) invokeV.objValue;
    }

    public final void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.a = new hw3();
            this.b = new lw3();
        }
    }

    @Override // com.baidu.tieba.zp1
    public ew1 a(@NonNull String str, @NonNull JSONObject jSONObject, @NonNull ih2 ih2Var) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, str, jSONObject, ih2Var)) == null) {
            if (this.a.e(str)) {
                return this.a.a(str, jSONObject, ih2Var);
            }
            if (this.a.f()) {
                return this.b.a(str, jSONObject, ih2Var);
            }
            return new ew1(10001, "authorize fail.");
        }
        return (ew1) invokeLLL.objValue;
    }
}
