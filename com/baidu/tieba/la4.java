package com.baidu.tieba;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mapapi.model.LatLng;
import com.baidu.tieba.ya4;
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
public class la4 extends ba4<es2> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes7.dex */
    public class a implements ya4.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ es2 a;
        public final /* synthetic */ yr2 b;

        public a(la4 la4Var, es2 es2Var, yr2 yr2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {la4Var, es2Var, yr2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = es2Var;
            this.b = yr2Var;
        }

        @Override // com.baidu.tieba.ya4.b
        public void onAnimationEnd() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (!TextUtils.isEmpty(this.a.y)) {
                    this.b.c(this.a.y, null);
                }
                p22.i("map", "TranslateMarkerAction animation end");
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947936138, "Lcom/baidu/tieba/la4;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947936138, "Lcom/baidu/tieba/la4;");
                return;
            }
        }
        boolean z = am1.a;
    }

    public la4() {
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

    public static la4 e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            return new la4();
        }
        return (la4) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.ba4
    /* renamed from: d */
    public boolean b(Context context, es2 es2Var, yr2 yr2Var, p53 p53Var, JSONObject jSONObject) {
        InterceptResult invokeLLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, es2Var, yr2Var, p53Var, jSONObject)) == null) {
            return f(context, es2Var, yr2Var, p53Var);
        }
        return invokeLLLLL.booleanValue;
    }

    public final boolean f(Context context, es2 es2Var, yr2 yr2Var, p53 p53Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(Constants.METHOD_SEND_USER_MSG, this, context, es2Var, yr2Var, p53Var)) == null) {
            p22.i("map", "TranslateMarkerAction start");
            yr1 B = cr2.V().B(es2Var.c);
            if (!(B instanceof wr1)) {
                p22.c("map", "WebViewManager is null");
                return false;
            }
            za4 d = y94.b().c((wr1) B).d(es2Var.b);
            if (d == null) {
                p22.c("map", "can not find map by id " + es2Var.b);
                return false;
            }
            return g(es2Var, d, yr2Var);
        }
        return invokeLLLL.booleanValue;
    }

    public final boolean g(es2 es2Var, za4 za4Var, yr2 yr2Var) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048579, this, es2Var, za4Var, yr2Var)) == null) {
            if (!es2Var.isValid()) {
                return false;
            }
            is2 is2Var = es2Var.A;
            LatLng latLng = new LatLng(is2Var.a, is2Var.b);
            List<ya4> K = za4Var.K(es2Var.z);
            p22.i("map", "TranslateMarkerAction animation start");
            if (K != null) {
                for (ya4 ya4Var : K) {
                    ya4Var.c(za4Var, latLng, es2Var, new a(this, es2Var, yr2Var));
                }
            }
            p22.i("map", "TranslateMarkerAction end");
            return true;
        }
        return invokeLLL.booleanValue;
    }
}
