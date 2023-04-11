package com.baidu.tieba;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.map.location.model.SelectedLocationInfo;
import com.baidu.tieba.fd4;
import com.baidu.tieba.vc4;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class kd4 extends gc4<eu2> implements fd4.b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public du2 a;
    public eu2 b;

    /* loaded from: classes5.dex */
    public class a implements vc4.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ du2 a;
        public final /* synthetic */ String b;
        public final /* synthetic */ kd4 c;

        public a(kd4 kd4Var, du2 du2Var, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {kd4Var, du2Var, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = kd4Var;
            this.a = du2Var;
            this.b = str;
        }

        @Override // com.baidu.tieba.vc4.c
        public void onFail() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                u42.o("map", "location permission fail");
                this.a.b(this.b, 1003, "location permission fail");
            }
        }

        @Override // com.baidu.tieba.vc4.c
        public void onSuccess() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                u42.o("map", "location permission success");
                this.c.g();
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947909230, "Lcom/baidu/tieba/kd4;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947909230, "Lcom/baidu/tieba/kd4;");
                return;
            }
        }
        boolean z = eo1.a;
    }

    public kd4() {
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

    public static kd4 h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            return new kd4();
        }
        return (kd4) invokeV.objValue;
    }

    public final void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            fd4 e3 = fd4.e3(null);
            e3.j3(this);
            e3.l3();
        }
    }

    @Override // com.baidu.tieba.fd4.b
    public void onCancel() {
        eu2 eu2Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            u42.i("map", "choose location cancel");
            du2 du2Var = this.a;
            if (du2Var != null && (eu2Var = this.b) != null) {
                du2Var.b(eu2Var.z, 1002, "choose location canceled");
            }
        }
    }

    @Override // com.baidu.tieba.fd4.b
    public void onError() {
        eu2 eu2Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            u42.i("map", "choose location fail");
            du2 du2Var = this.a;
            if (du2Var != null && (eu2Var = this.b) != null) {
                du2Var.b(eu2Var.z, 1007, "choose location failed");
            }
        }
    }

    @Override // com.baidu.tieba.fd4.b
    public void a(SelectedLocationInfo selectedLocationInfo) {
        du2 du2Var;
        eu2 eu2Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, selectedLocationInfo) == null) && (du2Var = this.a) != null && (eu2Var = this.b) != null) {
            du2Var.c(eu2Var.z, selectedLocationInfo.toJson());
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.gc4
    /* renamed from: f */
    public boolean b(Context context, eu2 eu2Var, du2 du2Var, u73 u73Var, JSONObject jSONObject) {
        InterceptResult invokeLLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(1048579, this, context, eu2Var, du2Var, u73Var, jSONObject)) == null) {
            return e(context, eu2Var, du2Var, u73Var);
        }
        return invokeLLLLL.booleanValue;
    }

    public final boolean e(Context context, eu2 eu2Var, du2 du2Var, u73 u73Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(Constants.METHOD_SEND_USER_MSG, this, context, eu2Var, du2Var, u73Var)) == null) {
            u42.i("map", "ChooseLocationAction start");
            if (!eu2Var.isValid()) {
                u42.c("map", "model is invalid");
                return false;
            }
            String str = eu2Var.z;
            if (TextUtils.isEmpty(str)) {
                u42.c("map", "cb is empty");
                return false;
            }
            this.a = du2Var;
            this.b = eu2Var;
            vc4.b(context, new a(this, du2Var, str));
            u42.i("map", "ChooseLocationAction end");
            return true;
        }
        return invokeLLLL.booleanValue;
    }
}
