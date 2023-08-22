package com.baidu.tieba;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.map.location.model.SelectedLocationInfo;
import com.baidu.tieba.eg4;
import com.baidu.tieba.og4;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class tg4 extends pf4<nx2> implements og4.b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public mx2 a;
    public nx2 b;

    /* loaded from: classes8.dex */
    public class a implements eg4.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ mx2 a;
        public final /* synthetic */ String b;
        public final /* synthetic */ tg4 c;

        public a(tg4 tg4Var, mx2 mx2Var, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tg4Var, mx2Var, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = tg4Var;
            this.a = mx2Var;
            this.b = str;
        }

        @Override // com.baidu.tieba.eg4.c
        public void onFail() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                d82.o("map", "location permission fail");
                this.a.b(this.b, 1003, "location permission fail");
            }
        }

        @Override // com.baidu.tieba.eg4.c
        public void onSuccess() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                d82.o("map", "location permission success");
                this.c.g();
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948180232, "Lcom/baidu/tieba/tg4;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948180232, "Lcom/baidu/tieba/tg4;");
                return;
            }
        }
        boolean z = nr1.a;
    }

    public tg4() {
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

    public static tg4 h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            return new tg4();
        }
        return (tg4) invokeV.objValue;
    }

    public final void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            og4 d3 = og4.d3(null);
            d3.i3(this);
            d3.k3();
        }
    }

    @Override // com.baidu.tieba.og4.b
    public void onCancel() {
        nx2 nx2Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            d82.i("map", "choose location cancel");
            mx2 mx2Var = this.a;
            if (mx2Var != null && (nx2Var = this.b) != null) {
                mx2Var.b(nx2Var.z, 1002, "choose location canceled");
            }
        }
    }

    @Override // com.baidu.tieba.og4.b
    public void onError() {
        nx2 nx2Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            d82.i("map", "choose location fail");
            mx2 mx2Var = this.a;
            if (mx2Var != null && (nx2Var = this.b) != null) {
                mx2Var.b(nx2Var.z, 1007, "choose location failed");
            }
        }
    }

    @Override // com.baidu.tieba.og4.b
    public void a(SelectedLocationInfo selectedLocationInfo) {
        mx2 mx2Var;
        nx2 nx2Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, selectedLocationInfo) == null) && (mx2Var = this.a) != null && (nx2Var = this.b) != null) {
            mx2Var.c(nx2Var.z, selectedLocationInfo.toJson());
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.pf4
    /* renamed from: f */
    public boolean b(Context context, nx2 nx2Var, mx2 mx2Var, db3 db3Var, JSONObject jSONObject) {
        InterceptResult invokeLLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(1048579, this, context, nx2Var, mx2Var, db3Var, jSONObject)) == null) {
            return e(context, nx2Var, mx2Var, db3Var);
        }
        return invokeLLLLL.booleanValue;
    }

    public final boolean e(Context context, nx2 nx2Var, mx2 mx2Var, db3 db3Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(Constants.METHOD_SEND_USER_MSG, this, context, nx2Var, mx2Var, db3Var)) == null) {
            d82.i("map", "ChooseLocationAction start");
            if (!nx2Var.isValid()) {
                d82.c("map", "model is invalid");
                return false;
            }
            String str = nx2Var.z;
            if (TextUtils.isEmpty(str)) {
                d82.c("map", "cb is empty");
                return false;
            }
            this.a = mx2Var;
            this.b = nx2Var;
            eg4.b(context, new a(this, mx2Var, str));
            d82.i("map", "ChooseLocationAction end");
            return true;
        }
        return invokeLLLL.booleanValue;
    }
}
