package com.baidu.tieba;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mapapi.model.LatLng;
import com.baidu.tieba.i64;
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
public class v54 extends l54<pn2> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes6.dex */
    public class a implements i64.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ pn2 a;
        public final /* synthetic */ jn2 b;

        public a(v54 v54Var, pn2 pn2Var, jn2 jn2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {v54Var, pn2Var, jn2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = pn2Var;
            this.b = jn2Var;
        }

        @Override // com.baidu.tieba.i64.b
        public void onAnimationEnd() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (!TextUtils.isEmpty(this.a.y)) {
                    this.b.c(this.a.y, null);
                }
                ay1.i("map", "TranslateMarkerAction animation end");
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948191764, "Lcom/baidu/tieba/v54;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948191764, "Lcom/baidu/tieba/v54;");
                return;
            }
        }
        boolean z = kh1.a;
    }

    public v54() {
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

    public static v54 e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? new v54() : (v54) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.l54
    /* renamed from: d */
    public boolean b(Context context, pn2 pn2Var, jn2 jn2Var, a13 a13Var, JSONObject jSONObject) {
        InterceptResult invokeLLLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, pn2Var, jn2Var, a13Var, jSONObject)) == null) ? f(context, pn2Var, jn2Var, a13Var) : invokeLLLLL.booleanValue;
    }

    public final boolean f(Context context, pn2 pn2Var, jn2 jn2Var, a13 a13Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(Constants.METHOD_SEND_USER_MSG, this, context, pn2Var, jn2Var, a13Var)) == null) {
            ay1.i("map", "TranslateMarkerAction start");
            in1 A = nm2.U().A(pn2Var.c);
            if (!(A instanceof gn1)) {
                ay1.c("map", "WebViewManager is null");
                return false;
            }
            j64 d = i54.b().c((gn1) A).d(pn2Var.b);
            if (d == null) {
                ay1.c("map", "can not find map by id " + pn2Var.b);
                return false;
            }
            return g(pn2Var, d, jn2Var);
        }
        return invokeLLLL.booleanValue;
    }

    public final boolean g(pn2 pn2Var, j64 j64Var, jn2 jn2Var) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048579, this, pn2Var, j64Var, jn2Var)) == null) {
            if (pn2Var.isValid()) {
                tn2 tn2Var = pn2Var.A;
                LatLng latLng = new LatLng(tn2Var.a, tn2Var.b);
                List<i64> I = j64Var.I(pn2Var.z);
                ay1.i("map", "TranslateMarkerAction animation start");
                if (I != null) {
                    for (i64 i64Var : I) {
                        i64Var.c(j64Var, latLng, pn2Var, new a(this, pn2Var, jn2Var));
                    }
                }
                ay1.i("map", "TranslateMarkerAction end");
                return true;
            }
            return false;
        }
        return invokeLLL.booleanValue;
    }
}
