package com.baidu.tieba;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.map.location.model.SelectedLocationInfo;
import com.baidu.tieba.jg4;
import com.baidu.tieba.zf4;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class og4 extends kf4<ix2> implements jg4.b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public hx2 a;
    public ix2 b;

    /* loaded from: classes7.dex */
    public class a implements zf4.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ hx2 a;
        public final /* synthetic */ String b;
        public final /* synthetic */ og4 c;

        public a(og4 og4Var, hx2 hx2Var, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {og4Var, hx2Var, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = og4Var;
            this.a = hx2Var;
            this.b = str;
        }

        @Override // com.baidu.tieba.zf4.c
        public void onFail() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                y72.o("map", "location permission fail");
                this.a.b(this.b, 1003, "location permission fail");
            }
        }

        @Override // com.baidu.tieba.zf4.c
        public void onSuccess() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                y72.o("map", "location permission success");
                this.c.g();
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948031277, "Lcom/baidu/tieba/og4;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948031277, "Lcom/baidu/tieba/og4;");
                return;
            }
        }
        boolean z = ir1.a;
    }

    public og4() {
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

    public static og4 h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            return new og4();
        }
        return (og4) invokeV.objValue;
    }

    public final void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            jg4 d3 = jg4.d3(null);
            d3.i3(this);
            d3.k3();
        }
    }

    @Override // com.baidu.tieba.jg4.b
    public void onCancel() {
        ix2 ix2Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            y72.i("map", "choose location cancel");
            hx2 hx2Var = this.a;
            if (hx2Var != null && (ix2Var = this.b) != null) {
                hx2Var.b(ix2Var.z, 1002, "choose location canceled");
            }
        }
    }

    @Override // com.baidu.tieba.jg4.b
    public void onError() {
        ix2 ix2Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            y72.i("map", "choose location fail");
            hx2 hx2Var = this.a;
            if (hx2Var != null && (ix2Var = this.b) != null) {
                hx2Var.b(ix2Var.z, 1007, "choose location failed");
            }
        }
    }

    @Override // com.baidu.tieba.jg4.b
    public void a(SelectedLocationInfo selectedLocationInfo) {
        hx2 hx2Var;
        ix2 ix2Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, selectedLocationInfo) == null) && (hx2Var = this.a) != null && (ix2Var = this.b) != null) {
            hx2Var.c(ix2Var.z, selectedLocationInfo.toJson());
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.kf4
    /* renamed from: f */
    public boolean b(Context context, ix2 ix2Var, hx2 hx2Var, ya3 ya3Var, JSONObject jSONObject) {
        InterceptResult invokeLLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(1048579, this, context, ix2Var, hx2Var, ya3Var, jSONObject)) == null) {
            return e(context, ix2Var, hx2Var, ya3Var);
        }
        return invokeLLLLL.booleanValue;
    }

    public final boolean e(Context context, ix2 ix2Var, hx2 hx2Var, ya3 ya3Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(Constants.METHOD_SEND_USER_MSG, this, context, ix2Var, hx2Var, ya3Var)) == null) {
            y72.i("map", "ChooseLocationAction start");
            if (!ix2Var.isValid()) {
                y72.c("map", "model is invalid");
                return false;
            }
            String str = ix2Var.z;
            if (TextUtils.isEmpty(str)) {
                y72.c("map", "cb is empty");
                return false;
            }
            this.a = hx2Var;
            this.b = ix2Var;
            zf4.b(context, new a(this, hx2Var, str));
            y72.i("map", "ChooseLocationAction end");
            return true;
        }
        return invokeLLLL.booleanValue;
    }
}
