package com.baidu.tieba;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.map.location.model.SelectedLocationInfo;
import com.baidu.tieba.f94;
import com.baidu.tieba.p94;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class u94 extends q84<oq2> implements p94.b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public nq2 a;
    public oq2 b;

    /* loaded from: classes6.dex */
    public class a implements f94.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ nq2 a;
        public final /* synthetic */ String b;
        public final /* synthetic */ u94 c;

        public a(u94 u94Var, nq2 nq2Var, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {u94Var, nq2Var, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = u94Var;
            this.a = nq2Var;
            this.b = str;
        }

        @Override // com.baidu.tieba.f94.c
        public void onFail() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                e12.o("map", "location permission fail");
                this.a.b(this.b, 1003, "location permission fail");
            }
        }

        @Override // com.baidu.tieba.f94.c
        public void onSuccess() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                e12.o("map", "location permission success");
                this.c.g();
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948165817, "Lcom/baidu/tieba/u94;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948165817, "Lcom/baidu/tieba/u94;");
                return;
            }
        }
        boolean z = ok1.a;
    }

    public u94() {
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

    public static u94 h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            return new u94();
        }
        return (u94) invokeV.objValue;
    }

    public final void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            p94 b3 = p94.b3(null);
            b3.g3(this);
            b3.i3();
        }
    }

    @Override // com.baidu.tieba.p94.b
    public void onCancel() {
        oq2 oq2Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            e12.i("map", "choose location cancel");
            nq2 nq2Var = this.a;
            if (nq2Var != null && (oq2Var = this.b) != null) {
                nq2Var.b(oq2Var.z, 1002, "choose location canceled");
            }
        }
    }

    @Override // com.baidu.tieba.p94.b
    public void onError() {
        oq2 oq2Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            e12.i("map", "choose location fail");
            nq2 nq2Var = this.a;
            if (nq2Var != null && (oq2Var = this.b) != null) {
                nq2Var.b(oq2Var.z, 1007, "choose location failed");
            }
        }
    }

    @Override // com.baidu.tieba.p94.b
    public void a(SelectedLocationInfo selectedLocationInfo) {
        nq2 nq2Var;
        oq2 oq2Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, selectedLocationInfo) == null) && (nq2Var = this.a) != null && (oq2Var = this.b) != null) {
            nq2Var.c(oq2Var.z, selectedLocationInfo.toJson());
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.q84
    /* renamed from: f */
    public boolean b(Context context, oq2 oq2Var, nq2 nq2Var, e43 e43Var, JSONObject jSONObject) {
        InterceptResult invokeLLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(1048579, this, context, oq2Var, nq2Var, e43Var, jSONObject)) == null) {
            return e(context, oq2Var, nq2Var, e43Var);
        }
        return invokeLLLLL.booleanValue;
    }

    public final boolean e(Context context, oq2 oq2Var, nq2 nq2Var, e43 e43Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(Constants.METHOD_SEND_USER_MSG, this, context, oq2Var, nq2Var, e43Var)) == null) {
            e12.i("map", "ChooseLocationAction start");
            if (!oq2Var.isValid()) {
                e12.c("map", "model is invalid");
                return false;
            }
            String str = oq2Var.z;
            if (TextUtils.isEmpty(str)) {
                e12.c("map", "cb is empty");
                return false;
            }
            this.a = nq2Var;
            this.b = oq2Var;
            f94.b(context, new a(this, nq2Var, str));
            e12.i("map", "ChooseLocationAction end");
            return true;
        }
        return invokeLLLL.booleanValue;
    }
}
