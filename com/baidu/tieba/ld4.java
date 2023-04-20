package com.baidu.tieba;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.map.location.model.SelectedLocationInfo;
import com.baidu.tieba.gd4;
import com.baidu.tieba.wc4;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class ld4 extends hc4<fu2> implements gd4.b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public eu2 a;
    public fu2 b;

    /* loaded from: classes5.dex */
    public class a implements wc4.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ eu2 a;
        public final /* synthetic */ String b;
        public final /* synthetic */ ld4 c;

        public a(ld4 ld4Var, eu2 eu2Var, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ld4Var, eu2Var, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = ld4Var;
            this.a = eu2Var;
            this.b = str;
        }

        @Override // com.baidu.tieba.wc4.c
        public void onFail() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                v42.o("map", "location permission fail");
                this.a.b(this.b, 1003, "location permission fail");
            }
        }

        @Override // com.baidu.tieba.wc4.c
        public void onSuccess() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                v42.o("map", "location permission success");
                this.c.g();
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947939021, "Lcom/baidu/tieba/ld4;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947939021, "Lcom/baidu/tieba/ld4;");
                return;
            }
        }
        boolean z = fo1.a;
    }

    public ld4() {
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

    public static ld4 h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            return new ld4();
        }
        return (ld4) invokeV.objValue;
    }

    public final void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            gd4 e3 = gd4.e3(null);
            e3.j3(this);
            e3.l3();
        }
    }

    @Override // com.baidu.tieba.gd4.b
    public void onCancel() {
        fu2 fu2Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            v42.i("map", "choose location cancel");
            eu2 eu2Var = this.a;
            if (eu2Var != null && (fu2Var = this.b) != null) {
                eu2Var.b(fu2Var.z, 1002, "choose location canceled");
            }
        }
    }

    @Override // com.baidu.tieba.gd4.b
    public void onError() {
        fu2 fu2Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            v42.i("map", "choose location fail");
            eu2 eu2Var = this.a;
            if (eu2Var != null && (fu2Var = this.b) != null) {
                eu2Var.b(fu2Var.z, 1007, "choose location failed");
            }
        }
    }

    @Override // com.baidu.tieba.gd4.b
    public void a(SelectedLocationInfo selectedLocationInfo) {
        eu2 eu2Var;
        fu2 fu2Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, selectedLocationInfo) == null) && (eu2Var = this.a) != null && (fu2Var = this.b) != null) {
            eu2Var.c(fu2Var.z, selectedLocationInfo.toJson());
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.hc4
    /* renamed from: f */
    public boolean b(Context context, fu2 fu2Var, eu2 eu2Var, v73 v73Var, JSONObject jSONObject) {
        InterceptResult invokeLLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(1048579, this, context, fu2Var, eu2Var, v73Var, jSONObject)) == null) {
            return e(context, fu2Var, eu2Var, v73Var);
        }
        return invokeLLLLL.booleanValue;
    }

    public final boolean e(Context context, fu2 fu2Var, eu2 eu2Var, v73 v73Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(Constants.METHOD_SEND_USER_MSG, this, context, fu2Var, eu2Var, v73Var)) == null) {
            v42.i("map", "ChooseLocationAction start");
            if (!fu2Var.isValid()) {
                v42.c("map", "model is invalid");
                return false;
            }
            String str = fu2Var.z;
            if (TextUtils.isEmpty(str)) {
                v42.c("map", "cb is empty");
                return false;
            }
            this.a = eu2Var;
            this.b = fu2Var;
            wc4.b(context, new a(this, eu2Var, str));
            v42.i("map", "ChooseLocationAction end");
            return true;
        }
        return invokeLLLL.booleanValue;
    }
}
