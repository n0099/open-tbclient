package com.baidu.tieba;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mapapi.model.LatLng;
import com.baidu.tieba.h84;
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
public class u74 extends k74<np2> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes6.dex */
    public class a implements h84.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ np2 a;
        public final /* synthetic */ hp2 b;

        public a(u74 u74Var, np2 np2Var, hp2 hp2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {u74Var, np2Var, hp2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = np2Var;
            this.b = hp2Var;
        }

        @Override // com.baidu.tieba.h84.b
        public void onAnimationEnd() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (!TextUtils.isEmpty(this.a.y)) {
                    this.b.c(this.a.y, null);
                }
                yz1.i("map", "TranslateMarkerAction animation end");
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948163895, "Lcom/baidu/tieba/u74;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948163895, "Lcom/baidu/tieba/u74;");
                return;
            }
        }
        boolean z = ij1.a;
    }

    public u74() {
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

    public static u74 e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? new u74() : (u74) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.k74
    /* renamed from: d */
    public boolean b(Context context, np2 np2Var, hp2 hp2Var, y23 y23Var, JSONObject jSONObject) {
        InterceptResult invokeLLLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, np2Var, hp2Var, y23Var, jSONObject)) == null) ? f(context, np2Var, hp2Var, y23Var) : invokeLLLLL.booleanValue;
    }

    public final boolean f(Context context, np2 np2Var, hp2 hp2Var, y23 y23Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(Constants.METHOD_SEND_USER_MSG, this, context, np2Var, hp2Var, y23Var)) == null) {
            yz1.i("map", "TranslateMarkerAction start");
            gp1 A = lo2.U().A(np2Var.c);
            if (!(A instanceof ep1)) {
                yz1.c("map", "WebViewManager is null");
                return false;
            }
            i84 d = h74.b().c((ep1) A).d(np2Var.b);
            if (d == null) {
                yz1.c("map", "can not find map by id " + np2Var.b);
                return false;
            }
            return g(np2Var, d, hp2Var);
        }
        return invokeLLLL.booleanValue;
    }

    public final boolean g(np2 np2Var, i84 i84Var, hp2 hp2Var) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048579, this, np2Var, i84Var, hp2Var)) == null) {
            if (np2Var.isValid()) {
                rp2 rp2Var = np2Var.A;
                LatLng latLng = new LatLng(rp2Var.a, rp2Var.b);
                List<h84> I = i84Var.I(np2Var.z);
                yz1.i("map", "TranslateMarkerAction animation start");
                if (I != null) {
                    for (h84 h84Var : I) {
                        h84Var.c(i84Var, latLng, np2Var, new a(this, np2Var, hp2Var));
                    }
                }
                yz1.i("map", "TranslateMarkerAction end");
                return true;
            }
            return false;
        }
        return invokeLLL.booleanValue;
    }
}
