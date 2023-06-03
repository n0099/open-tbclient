package com.baidu.tieba;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.map.location.model.SelectedLocationInfo;
import com.baidu.tieba.jh4;
import com.baidu.tieba.zg4;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class oh4 extends kg4<iy2> implements jh4.b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public hy2 a;
    public iy2 b;

    /* loaded from: classes7.dex */
    public class a implements zg4.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ hy2 a;
        public final /* synthetic */ String b;
        public final /* synthetic */ oh4 c;

        public a(oh4 oh4Var, hy2 hy2Var, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {oh4Var, hy2Var, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = oh4Var;
            this.a = hy2Var;
            this.b = str;
        }

        @Override // com.baidu.tieba.zg4.c
        public void onFail() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                y82.o("map", "location permission fail");
                this.a.b(this.b, 1003, "location permission fail");
            }
        }

        @Override // com.baidu.tieba.zg4.c
        public void onSuccess() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                y82.o("map", "location permission success");
                this.c.g();
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948032238, "Lcom/baidu/tieba/oh4;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948032238, "Lcom/baidu/tieba/oh4;");
                return;
            }
        }
        boolean z = is1.a;
    }

    public oh4() {
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

    public static oh4 h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            return new oh4();
        }
        return (oh4) invokeV.objValue;
    }

    public final void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            jh4 d3 = jh4.d3(null);
            d3.i3(this);
            d3.k3();
        }
    }

    @Override // com.baidu.tieba.jh4.b
    public void onCancel() {
        iy2 iy2Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            y82.i("map", "choose location cancel");
            hy2 hy2Var = this.a;
            if (hy2Var != null && (iy2Var = this.b) != null) {
                hy2Var.b(iy2Var.z, 1002, "choose location canceled");
            }
        }
    }

    @Override // com.baidu.tieba.jh4.b
    public void onError() {
        iy2 iy2Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            y82.i("map", "choose location fail");
            hy2 hy2Var = this.a;
            if (hy2Var != null && (iy2Var = this.b) != null) {
                hy2Var.b(iy2Var.z, 1007, "choose location failed");
            }
        }
    }

    @Override // com.baidu.tieba.jh4.b
    public void a(SelectedLocationInfo selectedLocationInfo) {
        hy2 hy2Var;
        iy2 iy2Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, selectedLocationInfo) == null) && (hy2Var = this.a) != null && (iy2Var = this.b) != null) {
            hy2Var.c(iy2Var.z, selectedLocationInfo.toJson());
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.kg4
    /* renamed from: f */
    public boolean b(Context context, iy2 iy2Var, hy2 hy2Var, yb3 yb3Var, JSONObject jSONObject) {
        InterceptResult invokeLLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(1048579, this, context, iy2Var, hy2Var, yb3Var, jSONObject)) == null) {
            return e(context, iy2Var, hy2Var, yb3Var);
        }
        return invokeLLLLL.booleanValue;
    }

    public final boolean e(Context context, iy2 iy2Var, hy2 hy2Var, yb3 yb3Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(Constants.METHOD_SEND_USER_MSG, this, context, iy2Var, hy2Var, yb3Var)) == null) {
            y82.i("map", "ChooseLocationAction start");
            if (!iy2Var.isValid()) {
                y82.c("map", "model is invalid");
                return false;
            }
            String str = iy2Var.z;
            if (TextUtils.isEmpty(str)) {
                y82.c("map", "cb is empty");
                return false;
            }
            this.a = hy2Var;
            this.b = iy2Var;
            zg4.b(context, new a(this, hy2Var, str));
            y82.i("map", "ChooseLocationAction end");
            return true;
        }
        return invokeLLLL.booleanValue;
    }
}
