package com.baidu.tieba;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.map.location.model.SelectedLocationInfo;
import com.baidu.tieba.hg4;
import com.baidu.tieba.rg4;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class wg4 extends sf4<qx2> implements rg4.b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public px2 a;
    public qx2 b;

    /* loaded from: classes8.dex */
    public class a implements hg4.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ px2 a;
        public final /* synthetic */ String b;
        public final /* synthetic */ wg4 c;

        public a(wg4 wg4Var, px2 px2Var, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {wg4Var, px2Var, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = wg4Var;
            this.a = px2Var;
            this.b = str;
        }

        @Override // com.baidu.tieba.hg4.c
        public void onFail() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                g82.o("map", "location permission fail");
                this.a.b(this.b, 1003, "location permission fail");
            }
        }

        @Override // com.baidu.tieba.hg4.c
        public void onSuccess() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                g82.o("map", "location permission success");
                this.c.g();
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948269605, "Lcom/baidu/tieba/wg4;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948269605, "Lcom/baidu/tieba/wg4;");
                return;
            }
        }
        boolean z = qr1.a;
    }

    public wg4() {
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

    public static wg4 h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            return new wg4();
        }
        return (wg4) invokeV.objValue;
    }

    public final void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            rg4 d3 = rg4.d3(null);
            d3.i3(this);
            d3.k3();
        }
    }

    @Override // com.baidu.tieba.rg4.b
    public void onCancel() {
        qx2 qx2Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            g82.i("map", "choose location cancel");
            px2 px2Var = this.a;
            if (px2Var != null && (qx2Var = this.b) != null) {
                px2Var.b(qx2Var.z, 1002, "choose location canceled");
            }
        }
    }

    @Override // com.baidu.tieba.rg4.b
    public void onError() {
        qx2 qx2Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            g82.i("map", "choose location fail");
            px2 px2Var = this.a;
            if (px2Var != null && (qx2Var = this.b) != null) {
                px2Var.b(qx2Var.z, 1007, "choose location failed");
            }
        }
    }

    @Override // com.baidu.tieba.rg4.b
    public void a(SelectedLocationInfo selectedLocationInfo) {
        px2 px2Var;
        qx2 qx2Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, selectedLocationInfo) == null) && (px2Var = this.a) != null && (qx2Var = this.b) != null) {
            px2Var.c(qx2Var.z, selectedLocationInfo.toJson());
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.sf4
    /* renamed from: f */
    public boolean b(Context context, qx2 qx2Var, px2 px2Var, gb3 gb3Var, JSONObject jSONObject) {
        InterceptResult invokeLLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(1048579, this, context, qx2Var, px2Var, gb3Var, jSONObject)) == null) {
            return e(context, qx2Var, px2Var, gb3Var);
        }
        return invokeLLLLL.booleanValue;
    }

    public final boolean e(Context context, qx2 qx2Var, px2 px2Var, gb3 gb3Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(Constants.METHOD_SEND_USER_MSG, this, context, qx2Var, px2Var, gb3Var)) == null) {
            g82.i("map", "ChooseLocationAction start");
            if (!qx2Var.isValid()) {
                g82.c("map", "model is invalid");
                return false;
            }
            String str = qx2Var.z;
            if (TextUtils.isEmpty(str)) {
                g82.c("map", "cb is empty");
                return false;
            }
            this.a = px2Var;
            this.b = qx2Var;
            hg4.b(context, new a(this, px2Var, str));
            g82.i("map", "ChooseLocationAction end");
            return true;
        }
        return invokeLLLL.booleanValue;
    }
}
