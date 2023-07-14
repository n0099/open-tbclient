package com.baidu.tieba;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mapapi.model.LatLng;
import com.baidu.tieba.eh4;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class rg4 extends hg4<ky2> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes7.dex */
    public class a implements eh4.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ky2 a;
        public final /* synthetic */ ey2 b;

        public a(rg4 rg4Var, ky2 ky2Var, ey2 ey2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {rg4Var, ky2Var, ey2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ky2Var;
            this.b = ey2Var;
        }

        @Override // com.baidu.tieba.eh4.b
        public void onAnimationEnd() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (!TextUtils.isEmpty(this.a.y)) {
                    this.b.c(this.a.y, null);
                }
                v82.i("map", "TranslateMarkerAction animation end");
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948120650, "Lcom/baidu/tieba/rg4;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948120650, "Lcom/baidu/tieba/rg4;");
                return;
            }
        }
        boolean z = fs1.a;
    }

    public rg4() {
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

    public static rg4 e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            return new rg4();
        }
        return (rg4) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.hg4
    /* renamed from: d */
    public boolean b(Context context, ky2 ky2Var, ey2 ey2Var, vb3 vb3Var, JSONObject jSONObject) {
        InterceptResult invokeLLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, ky2Var, ey2Var, vb3Var, jSONObject)) == null) {
            return f(context, ky2Var, ey2Var, vb3Var);
        }
        return invokeLLLLL.booleanValue;
    }

    public final boolean f(Context context, ky2 ky2Var, ey2 ey2Var, vb3 vb3Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(Constants.METHOD_SEND_USER_MSG, this, context, ky2Var, ey2Var, vb3Var)) == null) {
            v82.i("map", "TranslateMarkerAction start");
            dy1 A = ix2.T().A(ky2Var.c);
            if (!(A instanceof by1)) {
                v82.c("map", "WebViewManager is null");
                return false;
            }
            fh4 d = eg4.b().c((by1) A).d(ky2Var.b);
            if (d == null) {
                v82.c("map", "can not find map by id " + ky2Var.b);
                return false;
            }
            return g(ky2Var, d, ey2Var);
        }
        return invokeLLLL.booleanValue;
    }

    public final boolean g(ky2 ky2Var, fh4 fh4Var, ey2 ey2Var) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048579, this, ky2Var, fh4Var, ey2Var)) == null) {
            if (!ky2Var.isValid()) {
                return false;
            }
            oy2 oy2Var = ky2Var.A;
            LatLng latLng = new LatLng(oy2Var.a, oy2Var.b);
            List<eh4> I = fh4Var.I(ky2Var.z);
            v82.i("map", "TranslateMarkerAction animation start");
            if (I != null) {
                for (eh4 eh4Var : I) {
                    eh4Var.c(fh4Var, latLng, ky2Var, new a(this, ky2Var, ey2Var));
                }
            }
            v82.i("map", "TranslateMarkerAction end");
            return true;
        }
        return invokeLLL.booleanValue;
    }
}
