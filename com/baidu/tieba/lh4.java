package com.baidu.tieba;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.map.location.model.SelectedLocationInfo;
import com.baidu.tieba.gh4;
import com.baidu.tieba.wg4;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class lh4 extends hg4<fy2> implements gh4.b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ey2 a;
    public fy2 b;

    /* loaded from: classes6.dex */
    public class a implements wg4.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ey2 a;
        public final /* synthetic */ String b;
        public final /* synthetic */ lh4 c;

        public a(lh4 lh4Var, ey2 ey2Var, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {lh4Var, ey2Var, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = lh4Var;
            this.a = ey2Var;
            this.b = str;
        }

        @Override // com.baidu.tieba.wg4.c
        public void onFail() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                v82.o("map", "location permission fail");
                this.a.b(this.b, 1003, "location permission fail");
            }
        }

        @Override // com.baidu.tieba.wg4.c
        public void onSuccess() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                v82.o("map", "location permission success");
                this.c.g();
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947942865, "Lcom/baidu/tieba/lh4;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947942865, "Lcom/baidu/tieba/lh4;");
                return;
            }
        }
        boolean z = fs1.a;
    }

    public lh4() {
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

    public static lh4 h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            return new lh4();
        }
        return (lh4) invokeV.objValue;
    }

    public final void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            gh4 d3 = gh4.d3(null);
            d3.i3(this);
            d3.k3();
        }
    }

    @Override // com.baidu.tieba.gh4.b
    public void onCancel() {
        fy2 fy2Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            v82.i("map", "choose location cancel");
            ey2 ey2Var = this.a;
            if (ey2Var != null && (fy2Var = this.b) != null) {
                ey2Var.b(fy2Var.z, 1002, "choose location canceled");
            }
        }
    }

    @Override // com.baidu.tieba.gh4.b
    public void onError() {
        fy2 fy2Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            v82.i("map", "choose location fail");
            ey2 ey2Var = this.a;
            if (ey2Var != null && (fy2Var = this.b) != null) {
                ey2Var.b(fy2Var.z, 1007, "choose location failed");
            }
        }
    }

    @Override // com.baidu.tieba.gh4.b
    public void a(SelectedLocationInfo selectedLocationInfo) {
        ey2 ey2Var;
        fy2 fy2Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, selectedLocationInfo) == null) && (ey2Var = this.a) != null && (fy2Var = this.b) != null) {
            ey2Var.c(fy2Var.z, selectedLocationInfo.toJson());
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.hg4
    /* renamed from: f */
    public boolean b(Context context, fy2 fy2Var, ey2 ey2Var, vb3 vb3Var, JSONObject jSONObject) {
        InterceptResult invokeLLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(1048579, this, context, fy2Var, ey2Var, vb3Var, jSONObject)) == null) {
            return e(context, fy2Var, ey2Var, vb3Var);
        }
        return invokeLLLLL.booleanValue;
    }

    public final boolean e(Context context, fy2 fy2Var, ey2 ey2Var, vb3 vb3Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(Constants.METHOD_SEND_USER_MSG, this, context, fy2Var, ey2Var, vb3Var)) == null) {
            v82.i("map", "ChooseLocationAction start");
            if (!fy2Var.isValid()) {
                v82.c("map", "model is invalid");
                return false;
            }
            String str = fy2Var.z;
            if (TextUtils.isEmpty(str)) {
                v82.c("map", "cb is empty");
                return false;
            }
            this.a = ey2Var;
            this.b = fy2Var;
            wg4.b(context, new a(this, ey2Var, str));
            v82.i("map", "ChooseLocationAction end");
            return true;
        }
        return invokeLLLL.booleanValue;
    }
}
