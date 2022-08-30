package com.baidu.tieba;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.map.location.model.SelectedLocationInfo;
import com.baidu.tieba.a64;
import com.baidu.tieba.k64;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class p64 extends l54<kn2> implements k64.b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public jn2 a;
    public kn2 b;

    /* loaded from: classes5.dex */
    public class a implements a64.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ jn2 a;
        public final /* synthetic */ String b;
        public final /* synthetic */ p64 c;

        public a(p64 p64Var, jn2 jn2Var, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {p64Var, jn2Var, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = p64Var;
            this.a = jn2Var;
            this.b = str;
        }

        @Override // com.baidu.tieba.a64.c
        public void onFail() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                ay1.o("map", "location permission fail");
                this.a.b(this.b, 1003, "location permission fail");
            }
        }

        @Override // com.baidu.tieba.a64.c
        public void onSuccess() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                ay1.o("map", "location permission success");
                this.c.g();
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948013979, "Lcom/baidu/tieba/p64;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948013979, "Lcom/baidu/tieba/p64;");
                return;
            }
        }
        boolean z = kh1.a;
    }

    public p64() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static p64 h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? new p64() : (p64) invokeV.objValue;
    }

    @Override // com.baidu.tieba.k64.b
    public void a(SelectedLocationInfo selectedLocationInfo) {
        jn2 jn2Var;
        kn2 kn2Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, selectedLocationInfo) == null) || (jn2Var = this.a) == null || (kn2Var = this.b) == null) {
            return;
        }
        jn2Var.c(kn2Var.z, selectedLocationInfo.toJson());
    }

    public final boolean e(Context context, kn2 kn2Var, jn2 jn2Var, a13 a13Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(Constants.METHOD_SEND_USER_MSG, this, context, kn2Var, jn2Var, a13Var)) == null) {
            ay1.i("map", "ChooseLocationAction start");
            if (!kn2Var.isValid()) {
                ay1.c("map", "model is invalid");
                return false;
            }
            String str = kn2Var.z;
            if (TextUtils.isEmpty(str)) {
                ay1.c("map", "cb is empty");
                return false;
            }
            this.a = jn2Var;
            this.b = kn2Var;
            a64.b(context, new a(this, jn2Var, str));
            ay1.i("map", "ChooseLocationAction end");
            return true;
        }
        return invokeLLLL.booleanValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.l54
    /* renamed from: f */
    public boolean b(Context context, kn2 kn2Var, jn2 jn2Var, a13 a13Var, JSONObject jSONObject) {
        InterceptResult invokeLLLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(1048579, this, context, kn2Var, jn2Var, a13Var, jSONObject)) == null) ? e(context, kn2Var, jn2Var, a13Var) : invokeLLLLL.booleanValue;
    }

    public final void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            k64 b3 = k64.b3(null);
            b3.g3(this);
            b3.i3();
        }
    }

    @Override // com.baidu.tieba.k64.b
    public void onCancel() {
        kn2 kn2Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            ay1.i("map", "choose location cancel");
            jn2 jn2Var = this.a;
            if (jn2Var == null || (kn2Var = this.b) == null) {
                return;
            }
            jn2Var.b(kn2Var.z, 1002, "choose location canceled");
        }
    }

    @Override // com.baidu.tieba.k64.b
    public void onError() {
        kn2 kn2Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            ay1.i("map", "choose location fail");
            jn2 jn2Var = this.a;
            if (jn2Var == null || (kn2Var = this.b) == null) {
                return;
            }
            jn2Var.b(kn2Var.z, 1007, "choose location failed");
        }
    }
}
