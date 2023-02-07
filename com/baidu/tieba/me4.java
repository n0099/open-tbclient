package com.baidu.tieba;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.map.location.model.SelectedLocationInfo;
import com.baidu.tieba.he4;
import com.baidu.tieba.xd4;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class me4 extends id4<gv2> implements he4.b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public fv2 a;
    public gv2 b;

    /* loaded from: classes5.dex */
    public class a implements xd4.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ fv2 a;
        public final /* synthetic */ String b;
        public final /* synthetic */ me4 c;

        public a(me4 me4Var, fv2 fv2Var, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {me4Var, fv2Var, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = me4Var;
            this.a = fv2Var;
            this.b = str;
        }

        @Override // com.baidu.tieba.xd4.c
        public void onFail() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                w52.o("map", "location permission fail");
                this.a.b(this.b, 1003, "location permission fail");
            }
        }

        @Override // com.baidu.tieba.xd4.c
        public void onSuccess() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                w52.o("map", "location permission success");
                this.c.g();
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947969773, "Lcom/baidu/tieba/me4;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947969773, "Lcom/baidu/tieba/me4;");
                return;
            }
        }
        boolean z = gp1.a;
    }

    public me4() {
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

    public static me4 h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            return new me4();
        }
        return (me4) invokeV.objValue;
    }

    public final void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            he4 b3 = he4.b3(null);
            b3.g3(this);
            b3.i3();
        }
    }

    @Override // com.baidu.tieba.he4.b
    public void onCancel() {
        gv2 gv2Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            w52.i("map", "choose location cancel");
            fv2 fv2Var = this.a;
            if (fv2Var != null && (gv2Var = this.b) != null) {
                fv2Var.b(gv2Var.z, 1002, "choose location canceled");
            }
        }
    }

    @Override // com.baidu.tieba.he4.b
    public void onError() {
        gv2 gv2Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            w52.i("map", "choose location fail");
            fv2 fv2Var = this.a;
            if (fv2Var != null && (gv2Var = this.b) != null) {
                fv2Var.b(gv2Var.z, 1007, "choose location failed");
            }
        }
    }

    @Override // com.baidu.tieba.he4.b
    public void a(SelectedLocationInfo selectedLocationInfo) {
        fv2 fv2Var;
        gv2 gv2Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, selectedLocationInfo) == null) && (fv2Var = this.a) != null && (gv2Var = this.b) != null) {
            fv2Var.c(gv2Var.z, selectedLocationInfo.toJson());
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.id4
    /* renamed from: f */
    public boolean b(Context context, gv2 gv2Var, fv2 fv2Var, w83 w83Var, JSONObject jSONObject) {
        InterceptResult invokeLLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(1048579, this, context, gv2Var, fv2Var, w83Var, jSONObject)) == null) {
            return e(context, gv2Var, fv2Var, w83Var);
        }
        return invokeLLLLL.booleanValue;
    }

    public final boolean e(Context context, gv2 gv2Var, fv2 fv2Var, w83 w83Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(Constants.METHOD_SEND_USER_MSG, this, context, gv2Var, fv2Var, w83Var)) == null) {
            w52.i("map", "ChooseLocationAction start");
            if (!gv2Var.isValid()) {
                w52.c("map", "model is invalid");
                return false;
            }
            String str = gv2Var.z;
            if (TextUtils.isEmpty(str)) {
                w52.c("map", "cb is empty");
                return false;
            }
            this.a = fv2Var;
            this.b = gv2Var;
            xd4.b(context, new a(this, fv2Var, str));
            w52.i("map", "ChooseLocationAction end");
            return true;
        }
        return invokeLLLL.booleanValue;
    }
}
