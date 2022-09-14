package com.baidu.tieba;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.map.location.model.SelectedLocationInfo;
import com.baidu.tieba.j84;
import com.baidu.tieba.z74;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class o84 extends k74<ip2> implements j84.b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public hp2 a;
    public ip2 b;

    /* loaded from: classes5.dex */
    public class a implements z74.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ hp2 a;
        public final /* synthetic */ String b;
        public final /* synthetic */ o84 c;

        public a(o84 o84Var, hp2 hp2Var, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {o84Var, hp2Var, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = o84Var;
            this.a = hp2Var;
            this.b = str;
        }

        @Override // com.baidu.tieba.z74.c
        public void onFail() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                yz1.o("map", "location permission fail");
                this.a.b(this.b, 1003, "location permission fail");
            }
        }

        @Override // com.baidu.tieba.z74.c
        public void onSuccess() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                yz1.o("map", "location permission success");
                this.c.g();
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947986110, "Lcom/baidu/tieba/o84;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947986110, "Lcom/baidu/tieba/o84;");
                return;
            }
        }
        boolean z = ij1.a;
    }

    public o84() {
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

    public static o84 h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? new o84() : (o84) invokeV.objValue;
    }

    @Override // com.baidu.tieba.j84.b
    public void a(SelectedLocationInfo selectedLocationInfo) {
        hp2 hp2Var;
        ip2 ip2Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, selectedLocationInfo) == null) || (hp2Var = this.a) == null || (ip2Var = this.b) == null) {
            return;
        }
        hp2Var.c(ip2Var.z, selectedLocationInfo.toJson());
    }

    public final boolean e(Context context, ip2 ip2Var, hp2 hp2Var, y23 y23Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(Constants.METHOD_SEND_USER_MSG, this, context, ip2Var, hp2Var, y23Var)) == null) {
            yz1.i("map", "ChooseLocationAction start");
            if (!ip2Var.isValid()) {
                yz1.c("map", "model is invalid");
                return false;
            }
            String str = ip2Var.z;
            if (TextUtils.isEmpty(str)) {
                yz1.c("map", "cb is empty");
                return false;
            }
            this.a = hp2Var;
            this.b = ip2Var;
            z74.b(context, new a(this, hp2Var, str));
            yz1.i("map", "ChooseLocationAction end");
            return true;
        }
        return invokeLLLL.booleanValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.k74
    /* renamed from: f */
    public boolean b(Context context, ip2 ip2Var, hp2 hp2Var, y23 y23Var, JSONObject jSONObject) {
        InterceptResult invokeLLLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(1048579, this, context, ip2Var, hp2Var, y23Var, jSONObject)) == null) ? e(context, ip2Var, hp2Var, y23Var) : invokeLLLLL.booleanValue;
    }

    public final void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            j84 b3 = j84.b3(null);
            b3.g3(this);
            b3.i3();
        }
    }

    @Override // com.baidu.tieba.j84.b
    public void onCancel() {
        ip2 ip2Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            yz1.i("map", "choose location cancel");
            hp2 hp2Var = this.a;
            if (hp2Var == null || (ip2Var = this.b) == null) {
                return;
            }
            hp2Var.b(ip2Var.z, 1002, "choose location canceled");
        }
    }

    @Override // com.baidu.tieba.j84.b
    public void onError() {
        ip2 ip2Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            yz1.i("map", "choose location fail");
            hp2 hp2Var = this.a;
            if (hp2Var == null || (ip2Var = this.b) == null) {
                return;
            }
            hp2Var.b(ip2Var.z, 1007, "choose location failed");
        }
    }
}
