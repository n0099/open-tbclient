package com.baidu.tieba;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.map.location.model.SelectedLocationInfo;
import com.baidu.tieba.ig4;
import com.baidu.tieba.sg4;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class xg4 extends tf4<rx2> implements sg4.b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public qx2 a;
    public rx2 b;

    /* loaded from: classes8.dex */
    public class a implements ig4.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ qx2 a;
        public final /* synthetic */ String b;
        public final /* synthetic */ xg4 c;

        public a(xg4 xg4Var, qx2 qx2Var, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xg4Var, qx2Var, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = xg4Var;
            this.a = qx2Var;
            this.b = str;
        }

        @Override // com.baidu.tieba.ig4.c
        public void onFail() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                h82.o("map", "location permission fail");
                this.a.b(this.b, 1003, "location permission fail");
            }
        }

        @Override // com.baidu.tieba.ig4.c
        public void onSuccess() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                h82.o("map", "location permission success");
                this.c.g();
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948299396, "Lcom/baidu/tieba/xg4;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948299396, "Lcom/baidu/tieba/xg4;");
                return;
            }
        }
        boolean z = rr1.a;
    }

    public xg4() {
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

    public static xg4 h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            return new xg4();
        }
        return (xg4) invokeV.objValue;
    }

    public final void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            sg4 d3 = sg4.d3(null);
            d3.i3(this);
            d3.k3();
        }
    }

    @Override // com.baidu.tieba.sg4.b
    public void onCancel() {
        rx2 rx2Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            h82.i("map", "choose location cancel");
            qx2 qx2Var = this.a;
            if (qx2Var != null && (rx2Var = this.b) != null) {
                qx2Var.b(rx2Var.z, 1002, "choose location canceled");
            }
        }
    }

    @Override // com.baidu.tieba.sg4.b
    public void onError() {
        rx2 rx2Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            h82.i("map", "choose location fail");
            qx2 qx2Var = this.a;
            if (qx2Var != null && (rx2Var = this.b) != null) {
                qx2Var.b(rx2Var.z, 1007, "choose location failed");
            }
        }
    }

    @Override // com.baidu.tieba.sg4.b
    public void a(SelectedLocationInfo selectedLocationInfo) {
        qx2 qx2Var;
        rx2 rx2Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, selectedLocationInfo) == null) && (qx2Var = this.a) != null && (rx2Var = this.b) != null) {
            qx2Var.c(rx2Var.z, selectedLocationInfo.toJson());
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.tf4
    /* renamed from: f */
    public boolean b(Context context, rx2 rx2Var, qx2 qx2Var, hb3 hb3Var, JSONObject jSONObject) {
        InterceptResult invokeLLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(1048579, this, context, rx2Var, qx2Var, hb3Var, jSONObject)) == null) {
            return e(context, rx2Var, qx2Var, hb3Var);
        }
        return invokeLLLLL.booleanValue;
    }

    public final boolean e(Context context, rx2 rx2Var, qx2 qx2Var, hb3 hb3Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(Constants.METHOD_SEND_USER_MSG, this, context, rx2Var, qx2Var, hb3Var)) == null) {
            h82.i("map", "ChooseLocationAction start");
            if (!rx2Var.isValid()) {
                h82.c("map", "model is invalid");
                return false;
            }
            String str = rx2Var.z;
            if (TextUtils.isEmpty(str)) {
                h82.c("map", "cb is empty");
                return false;
            }
            this.a = qx2Var;
            this.b = rx2Var;
            ig4.b(context, new a(this, qx2Var, str));
            h82.i("map", "ChooseLocationAction end");
            return true;
        }
        return invokeLLLL.booleanValue;
    }
}
