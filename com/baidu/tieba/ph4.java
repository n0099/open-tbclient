package com.baidu.tieba;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.map.location.model.SelectedLocationInfo;
import com.baidu.tieba.ah4;
import com.baidu.tieba.kh4;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class ph4 extends lg4<jy2> implements kh4.b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public iy2 a;
    public jy2 b;

    /* loaded from: classes7.dex */
    public class a implements ah4.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ iy2 a;
        public final /* synthetic */ String b;
        public final /* synthetic */ ph4 c;

        public a(ph4 ph4Var, iy2 iy2Var, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ph4Var, iy2Var, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = ph4Var;
            this.a = iy2Var;
            this.b = str;
        }

        @Override // com.baidu.tieba.ah4.c
        public void onFail() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                z82.o("map", "location permission fail");
                this.a.b(this.b, 1003, "location permission fail");
            }
        }

        @Override // com.baidu.tieba.ah4.c
        public void onSuccess() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                z82.o("map", "location permission success");
                this.c.g();
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948062029, "Lcom/baidu/tieba/ph4;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948062029, "Lcom/baidu/tieba/ph4;");
                return;
            }
        }
        boolean z = js1.a;
    }

    public ph4() {
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

    public static ph4 h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            return new ph4();
        }
        return (ph4) invokeV.objValue;
    }

    public final void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            kh4 d3 = kh4.d3(null);
            d3.i3(this);
            d3.k3();
        }
    }

    @Override // com.baidu.tieba.kh4.b
    public void onCancel() {
        jy2 jy2Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            z82.i("map", "choose location cancel");
            iy2 iy2Var = this.a;
            if (iy2Var != null && (jy2Var = this.b) != null) {
                iy2Var.b(jy2Var.z, 1002, "choose location canceled");
            }
        }
    }

    @Override // com.baidu.tieba.kh4.b
    public void onError() {
        jy2 jy2Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            z82.i("map", "choose location fail");
            iy2 iy2Var = this.a;
            if (iy2Var != null && (jy2Var = this.b) != null) {
                iy2Var.b(jy2Var.z, 1007, "choose location failed");
            }
        }
    }

    @Override // com.baidu.tieba.kh4.b
    public void a(SelectedLocationInfo selectedLocationInfo) {
        iy2 iy2Var;
        jy2 jy2Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, selectedLocationInfo) == null) && (iy2Var = this.a) != null && (jy2Var = this.b) != null) {
            iy2Var.c(jy2Var.z, selectedLocationInfo.toJson());
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.lg4
    /* renamed from: f */
    public boolean b(Context context, jy2 jy2Var, iy2 iy2Var, zb3 zb3Var, JSONObject jSONObject) {
        InterceptResult invokeLLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(1048579, this, context, jy2Var, iy2Var, zb3Var, jSONObject)) == null) {
            return e(context, jy2Var, iy2Var, zb3Var);
        }
        return invokeLLLLL.booleanValue;
    }

    public final boolean e(Context context, jy2 jy2Var, iy2 iy2Var, zb3 zb3Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(Constants.METHOD_SEND_USER_MSG, this, context, jy2Var, iy2Var, zb3Var)) == null) {
            z82.i("map", "ChooseLocationAction start");
            if (!jy2Var.isValid()) {
                z82.c("map", "model is invalid");
                return false;
            }
            String str = jy2Var.z;
            if (TextUtils.isEmpty(str)) {
                z82.c("map", "cb is empty");
                return false;
            }
            this.a = iy2Var;
            this.b = jy2Var;
            ah4.b(context, new a(this, iy2Var, str));
            z82.i("map", "ChooseLocationAction end");
            return true;
        }
        return invokeLLLL.booleanValue;
    }
}
