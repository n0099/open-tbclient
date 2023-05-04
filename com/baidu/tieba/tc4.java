package com.baidu.tieba;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mapapi.model.LatLng;
import com.baidu.tieba.gd4;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class tc4 extends jc4<mu2> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes6.dex */
    public class a implements gd4.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ mu2 a;
        public final /* synthetic */ gu2 b;

        public a(tc4 tc4Var, mu2 mu2Var, gu2 gu2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tc4Var, mu2Var, gu2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = mu2Var;
            this.b = gu2Var;
        }

        @Override // com.baidu.tieba.gd4.b
        public void onAnimationEnd() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (!TextUtils.isEmpty(this.a.y)) {
                    this.b.c(this.a.y, null);
                }
                x42.i("map", "TranslateMarkerAction animation end");
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948176388, "Lcom/baidu/tieba/tc4;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948176388, "Lcom/baidu/tieba/tc4;");
                return;
            }
        }
        boolean z = ho1.a;
    }

    public tc4() {
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

    public static tc4 e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            return new tc4();
        }
        return (tc4) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.jc4
    /* renamed from: d */
    public boolean b(Context context, mu2 mu2Var, gu2 gu2Var, x73 x73Var, JSONObject jSONObject) {
        InterceptResult invokeLLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, mu2Var, gu2Var, x73Var, jSONObject)) == null) {
            return f(context, mu2Var, gu2Var, x73Var);
        }
        return invokeLLLLL.booleanValue;
    }

    public final boolean f(Context context, mu2 mu2Var, gu2 gu2Var, x73 x73Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(Constants.METHOD_SEND_USER_MSG, this, context, mu2Var, gu2Var, x73Var)) == null) {
            x42.i("map", "TranslateMarkerAction start");
            fu1 A = kt2.U().A(mu2Var.c);
            if (!(A instanceof du1)) {
                x42.c("map", "WebViewManager is null");
                return false;
            }
            hd4 d = gc4.b().c((du1) A).d(mu2Var.b);
            if (d == null) {
                x42.c("map", "can not find map by id " + mu2Var.b);
                return false;
            }
            return g(mu2Var, d, gu2Var);
        }
        return invokeLLLL.booleanValue;
    }

    public final boolean g(mu2 mu2Var, hd4 hd4Var, gu2 gu2Var) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048579, this, mu2Var, hd4Var, gu2Var)) == null) {
            if (!mu2Var.isValid()) {
                return false;
            }
            qu2 qu2Var = mu2Var.A;
            LatLng latLng = new LatLng(qu2Var.a, qu2Var.b);
            List<gd4> I = hd4Var.I(mu2Var.z);
            x42.i("map", "TranslateMarkerAction animation start");
            if (I != null) {
                for (gd4 gd4Var : I) {
                    gd4Var.c(hd4Var, latLng, mu2Var, new a(this, mu2Var, gu2Var));
                }
            }
            x42.i("map", "TranslateMarkerAction end");
            return true;
        }
        return invokeLLL.booleanValue;
    }
}
