package com.baidu.tieba;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.map.location.model.SelectedLocationInfo;
import com.baidu.tieba.ed4;
import com.baidu.tieba.uc4;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class jd4 extends fc4<du2> implements ed4.b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public cu2 a;
    public du2 b;

    /* loaded from: classes5.dex */
    public class a implements uc4.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ cu2 a;
        public final /* synthetic */ String b;
        public final /* synthetic */ jd4 c;

        public a(jd4 jd4Var, cu2 cu2Var, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jd4Var, cu2Var, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = jd4Var;
            this.a = cu2Var;
            this.b = str;
        }

        @Override // com.baidu.tieba.uc4.c
        public void onFail() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                t42.o("map", "location permission fail");
                this.a.b(this.b, 1003, "location permission fail");
            }
        }

        @Override // com.baidu.tieba.uc4.c
        public void onSuccess() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                t42.o("map", "location permission success");
                this.c.g();
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947879439, "Lcom/baidu/tieba/jd4;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947879439, "Lcom/baidu/tieba/jd4;");
                return;
            }
        }
        boolean z = do1.a;
    }

    public jd4() {
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

    public static jd4 h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            return new jd4();
        }
        return (jd4) invokeV.objValue;
    }

    public final void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            ed4 e3 = ed4.e3(null);
            e3.j3(this);
            e3.l3();
        }
    }

    @Override // com.baidu.tieba.ed4.b
    public void onCancel() {
        du2 du2Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            t42.i("map", "choose location cancel");
            cu2 cu2Var = this.a;
            if (cu2Var != null && (du2Var = this.b) != null) {
                cu2Var.b(du2Var.z, 1002, "choose location canceled");
            }
        }
    }

    @Override // com.baidu.tieba.ed4.b
    public void onError() {
        du2 du2Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            t42.i("map", "choose location fail");
            cu2 cu2Var = this.a;
            if (cu2Var != null && (du2Var = this.b) != null) {
                cu2Var.b(du2Var.z, 1007, "choose location failed");
            }
        }
    }

    @Override // com.baidu.tieba.ed4.b
    public void a(SelectedLocationInfo selectedLocationInfo) {
        cu2 cu2Var;
        du2 du2Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, selectedLocationInfo) == null) && (cu2Var = this.a) != null && (du2Var = this.b) != null) {
            cu2Var.c(du2Var.z, selectedLocationInfo.toJson());
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.fc4
    /* renamed from: f */
    public boolean b(Context context, du2 du2Var, cu2 cu2Var, t73 t73Var, JSONObject jSONObject) {
        InterceptResult invokeLLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(1048579, this, context, du2Var, cu2Var, t73Var, jSONObject)) == null) {
            return e(context, du2Var, cu2Var, t73Var);
        }
        return invokeLLLLL.booleanValue;
    }

    public final boolean e(Context context, du2 du2Var, cu2 cu2Var, t73 t73Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(Constants.METHOD_SEND_USER_MSG, this, context, du2Var, cu2Var, t73Var)) == null) {
            t42.i("map", "ChooseLocationAction start");
            if (!du2Var.isValid()) {
                t42.c("map", "model is invalid");
                return false;
            }
            String str = du2Var.z;
            if (TextUtils.isEmpty(str)) {
                t42.c("map", "cb is empty");
                return false;
            }
            this.a = cu2Var;
            this.b = du2Var;
            uc4.b(context, new a(this, cu2Var, str));
            t42.i("map", "ChooseLocationAction end");
            return true;
        }
        return invokeLLLL.booleanValue;
    }
}
