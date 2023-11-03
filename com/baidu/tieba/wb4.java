package com.baidu.tieba;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.map.location.model.SelectedLocationInfo;
import com.baidu.tieba.hb4;
import com.baidu.tieba.rb4;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class wb4 extends sa4<qs2> implements rb4.b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ps2 a;
    public qs2 b;

    /* loaded from: classes8.dex */
    public class a implements hb4.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ps2 a;
        public final /* synthetic */ String b;
        public final /* synthetic */ wb4 c;

        public a(wb4 wb4Var, ps2 ps2Var, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {wb4Var, ps2Var, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = wb4Var;
            this.a = ps2Var;
            this.b = str;
        }

        @Override // com.baidu.tieba.hb4.c
        public void onFail() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                g32.o("map", "location permission fail");
                this.a.b(this.b, 1003, "location permission fail");
            }
        }

        @Override // com.baidu.tieba.hb4.c
        public void onSuccess() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                g32.o("map", "location permission success");
                this.c.g();
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948264800, "Lcom/baidu/tieba/wb4;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948264800, "Lcom/baidu/tieba/wb4;");
                return;
            }
        }
        boolean z = rm1.a;
    }

    public wb4() {
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

    public static wb4 h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            return new wb4();
        }
        return (wb4) invokeV.objValue;
    }

    public final void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            rb4 i3 = rb4.i3(null);
            i3.n3(this);
            i3.p3();
        }
    }

    @Override // com.baidu.tieba.rb4.b
    public void onCancel() {
        qs2 qs2Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            g32.i("map", "choose location cancel");
            ps2 ps2Var = this.a;
            if (ps2Var != null && (qs2Var = this.b) != null) {
                ps2Var.b(qs2Var.z, 1002, "choose location canceled");
            }
        }
    }

    @Override // com.baidu.tieba.rb4.b
    public void onError() {
        qs2 qs2Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            g32.i("map", "choose location fail");
            ps2 ps2Var = this.a;
            if (ps2Var != null && (qs2Var = this.b) != null) {
                ps2Var.b(qs2Var.z, 1007, "choose location failed");
            }
        }
    }

    @Override // com.baidu.tieba.rb4.b
    public void a(SelectedLocationInfo selectedLocationInfo) {
        ps2 ps2Var;
        qs2 qs2Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, selectedLocationInfo) == null) && (ps2Var = this.a) != null && (qs2Var = this.b) != null) {
            ps2Var.c(qs2Var.z, selectedLocationInfo.toJson());
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.sa4
    /* renamed from: f */
    public boolean b(Context context, qs2 qs2Var, ps2 ps2Var, g63 g63Var, JSONObject jSONObject) {
        InterceptResult invokeLLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(1048579, this, context, qs2Var, ps2Var, g63Var, jSONObject)) == null) {
            return e(context, qs2Var, ps2Var, g63Var);
        }
        return invokeLLLLL.booleanValue;
    }

    public final boolean e(Context context, qs2 qs2Var, ps2 ps2Var, g63 g63Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(Constants.METHOD_SEND_USER_MSG, this, context, qs2Var, ps2Var, g63Var)) == null) {
            g32.i("map", "ChooseLocationAction start");
            if (!qs2Var.isValid()) {
                g32.c("map", "model is invalid");
                return false;
            }
            String str = qs2Var.z;
            if (TextUtils.isEmpty(str)) {
                g32.c("map", "cb is empty");
                return false;
            }
            this.a = ps2Var;
            this.b = qs2Var;
            hb4.b(context, new a(this, ps2Var, str));
            g32.i("map", "ChooseLocationAction end");
            return true;
        }
        return invokeLLLL.booleanValue;
    }
}
