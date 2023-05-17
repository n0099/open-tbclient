package com.baidu.tieba;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.map.location.model.SelectedLocationInfo;
import com.baidu.tieba.he4;
import com.baidu.tieba.re4;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class we4 extends sd4<qv2> implements re4.b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public pv2 a;
    public qv2 b;

    /* loaded from: classes8.dex */
    public class a implements he4.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ pv2 a;
        public final /* synthetic */ String b;
        public final /* synthetic */ we4 c;

        public a(we4 we4Var, pv2 pv2Var, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {we4Var, pv2Var, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = we4Var;
            this.a = pv2Var;
            this.b = str;
        }

        @Override // com.baidu.tieba.he4.c
        public void onFail() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                g62.o("map", "location permission fail");
                this.a.b(this.b, 1003, "location permission fail");
            }
        }

        @Override // com.baidu.tieba.he4.c
        public void onSuccess() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                g62.o("map", "location permission success");
                this.c.g();
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948267683, "Lcom/baidu/tieba/we4;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948267683, "Lcom/baidu/tieba/we4;");
                return;
            }
        }
        boolean z = qp1.a;
    }

    public we4() {
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

    public static we4 h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            return new we4();
        }
        return (we4) invokeV.objValue;
    }

    public final void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            re4 e3 = re4.e3(null);
            e3.j3(this);
            e3.l3();
        }
    }

    @Override // com.baidu.tieba.re4.b
    public void onCancel() {
        qv2 qv2Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            g62.i("map", "choose location cancel");
            pv2 pv2Var = this.a;
            if (pv2Var != null && (qv2Var = this.b) != null) {
                pv2Var.b(qv2Var.z, 1002, "choose location canceled");
            }
        }
    }

    @Override // com.baidu.tieba.re4.b
    public void onError() {
        qv2 qv2Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            g62.i("map", "choose location fail");
            pv2 pv2Var = this.a;
            if (pv2Var != null && (qv2Var = this.b) != null) {
                pv2Var.b(qv2Var.z, 1007, "choose location failed");
            }
        }
    }

    @Override // com.baidu.tieba.re4.b
    public void a(SelectedLocationInfo selectedLocationInfo) {
        pv2 pv2Var;
        qv2 qv2Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, selectedLocationInfo) == null) && (pv2Var = this.a) != null && (qv2Var = this.b) != null) {
            pv2Var.c(qv2Var.z, selectedLocationInfo.toJson());
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.sd4
    /* renamed from: f */
    public boolean b(Context context, qv2 qv2Var, pv2 pv2Var, g93 g93Var, JSONObject jSONObject) {
        InterceptResult invokeLLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(1048579, this, context, qv2Var, pv2Var, g93Var, jSONObject)) == null) {
            return e(context, qv2Var, pv2Var, g93Var);
        }
        return invokeLLLLL.booleanValue;
    }

    public final boolean e(Context context, qv2 qv2Var, pv2 pv2Var, g93 g93Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(Constants.METHOD_SEND_USER_MSG, this, context, qv2Var, pv2Var, g93Var)) == null) {
            g62.i("map", "ChooseLocationAction start");
            if (!qv2Var.isValid()) {
                g62.c("map", "model is invalid");
                return false;
            }
            String str = qv2Var.z;
            if (TextUtils.isEmpty(str)) {
                g62.c("map", "cb is empty");
                return false;
            }
            this.a = pv2Var;
            this.b = qv2Var;
            he4.b(context, new a(this, pv2Var, str));
            g62.i("map", "ChooseLocationAction end");
            return true;
        }
        return invokeLLLL.booleanValue;
    }
}
