package com.baidu.tieba;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mapapi.model.LatLng;
import com.baidu.tieba.hg4;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class uf4 extends kf4<nx2> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes8.dex */
    public class a implements hg4.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ nx2 a;
        public final /* synthetic */ hx2 b;

        public a(uf4 uf4Var, nx2 nx2Var, hx2 hx2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {uf4Var, nx2Var, hx2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = nx2Var;
            this.b = hx2Var;
        }

        @Override // com.baidu.tieba.hg4.b
        public void onAnimationEnd() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (!TextUtils.isEmpty(this.a.y)) {
                    this.b.c(this.a.y, null);
                }
                y72.i("map", "TranslateMarkerAction animation end");
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948209062, "Lcom/baidu/tieba/uf4;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948209062, "Lcom/baidu/tieba/uf4;");
                return;
            }
        }
        boolean z = ir1.a;
    }

    public uf4() {
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

    public static uf4 e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            return new uf4();
        }
        return (uf4) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.kf4
    /* renamed from: d */
    public boolean b(Context context, nx2 nx2Var, hx2 hx2Var, ya3 ya3Var, JSONObject jSONObject) {
        InterceptResult invokeLLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, nx2Var, hx2Var, ya3Var, jSONObject)) == null) {
            return f(context, nx2Var, hx2Var, ya3Var);
        }
        return invokeLLLLL.booleanValue;
    }

    public final boolean f(Context context, nx2 nx2Var, hx2 hx2Var, ya3 ya3Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(Constants.METHOD_SEND_USER_MSG, this, context, nx2Var, hx2Var, ya3Var)) == null) {
            y72.i("map", "TranslateMarkerAction start");
            gx1 A = lw2.T().A(nx2Var.c);
            if (!(A instanceof ex1)) {
                y72.c("map", "WebViewManager is null");
                return false;
            }
            ig4 d = hf4.b().c((ex1) A).d(nx2Var.b);
            if (d == null) {
                y72.c("map", "can not find map by id " + nx2Var.b);
                return false;
            }
            return g(nx2Var, d, hx2Var);
        }
        return invokeLLLL.booleanValue;
    }

    public final boolean g(nx2 nx2Var, ig4 ig4Var, hx2 hx2Var) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048579, this, nx2Var, ig4Var, hx2Var)) == null) {
            if (!nx2Var.isValid()) {
                return false;
            }
            rx2 rx2Var = nx2Var.A;
            LatLng latLng = new LatLng(rx2Var.a, rx2Var.b);
            List<hg4> I = ig4Var.I(nx2Var.z);
            y72.i("map", "TranslateMarkerAction animation start");
            if (I != null) {
                for (hg4 hg4Var : I) {
                    hg4Var.c(ig4Var, latLng, nx2Var, new a(this, nx2Var, hx2Var));
                }
            }
            y72.i("map", "TranslateMarkerAction end");
            return true;
        }
        return invokeLLL.booleanValue;
    }
}
