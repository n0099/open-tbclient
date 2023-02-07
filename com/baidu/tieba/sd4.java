package com.baidu.tieba;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mapapi.model.LatLng;
import com.baidu.tieba.fe4;
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
public class sd4 extends id4<lv2> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes6.dex */
    public class a implements fe4.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ lv2 a;
        public final /* synthetic */ fv2 b;

        public a(sd4 sd4Var, lv2 lv2Var, fv2 fv2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sd4Var, lv2Var, fv2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = lv2Var;
            this.b = fv2Var;
        }

        @Override // com.baidu.tieba.fe4.b
        public void onAnimationEnd() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (!TextUtils.isEmpty(this.a.y)) {
                    this.b.c(this.a.y, null);
                }
                w52.i("map", "TranslateMarkerAction animation end");
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948147558, "Lcom/baidu/tieba/sd4;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948147558, "Lcom/baidu/tieba/sd4;");
                return;
            }
        }
        boolean z = gp1.a;
    }

    public sd4() {
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

    public static sd4 e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            return new sd4();
        }
        return (sd4) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.id4
    /* renamed from: d */
    public boolean b(Context context, lv2 lv2Var, fv2 fv2Var, w83 w83Var, JSONObject jSONObject) {
        InterceptResult invokeLLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, lv2Var, fv2Var, w83Var, jSONObject)) == null) {
            return f(context, lv2Var, fv2Var, w83Var);
        }
        return invokeLLLLL.booleanValue;
    }

    public final boolean f(Context context, lv2 lv2Var, fv2 fv2Var, w83 w83Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(Constants.METHOD_SEND_USER_MSG, this, context, lv2Var, fv2Var, w83Var)) == null) {
            w52.i("map", "TranslateMarkerAction start");
            ev1 A = ju2.U().A(lv2Var.c);
            if (!(A instanceof cv1)) {
                w52.c("map", "WebViewManager is null");
                return false;
            }
            ge4 d = fd4.b().c((cv1) A).d(lv2Var.b);
            if (d == null) {
                w52.c("map", "can not find map by id " + lv2Var.b);
                return false;
            }
            return g(lv2Var, d, fv2Var);
        }
        return invokeLLLL.booleanValue;
    }

    public final boolean g(lv2 lv2Var, ge4 ge4Var, fv2 fv2Var) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048579, this, lv2Var, ge4Var, fv2Var)) == null) {
            if (!lv2Var.isValid()) {
                return false;
            }
            pv2 pv2Var = lv2Var.A;
            LatLng latLng = new LatLng(pv2Var.a, pv2Var.b);
            List<fe4> I = ge4Var.I(lv2Var.z);
            w52.i("map", "TranslateMarkerAction animation start");
            if (I != null) {
                for (fe4 fe4Var : I) {
                    fe4Var.c(ge4Var, latLng, lv2Var, new a(this, lv2Var, fv2Var));
                }
            }
            w52.i("map", "TranslateMarkerAction end");
            return true;
        }
        return invokeLLL.booleanValue;
    }
}
