package com.baidu.tieba;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mapapi.model.LatLng;
import com.baidu.tieba.cd4;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class pc4 extends fc4<iu2> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes5.dex */
    public class a implements cd4.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ iu2 a;
        public final /* synthetic */ cu2 b;

        public a(pc4 pc4Var, iu2 iu2Var, cu2 cu2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pc4Var, iu2Var, cu2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = iu2Var;
            this.b = cu2Var;
        }

        @Override // com.baidu.tieba.cd4.b
        public void onAnimationEnd() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (!TextUtils.isEmpty(this.a.y)) {
                    this.b.c(this.a.y, null);
                }
                t42.i("map", "TranslateMarkerAction animation end");
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948057224, "Lcom/baidu/tieba/pc4;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948057224, "Lcom/baidu/tieba/pc4;");
                return;
            }
        }
        boolean z = do1.a;
    }

    public pc4() {
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

    public static pc4 e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            return new pc4();
        }
        return (pc4) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.fc4
    /* renamed from: d */
    public boolean b(Context context, iu2 iu2Var, cu2 cu2Var, t73 t73Var, JSONObject jSONObject) {
        InterceptResult invokeLLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, iu2Var, cu2Var, t73Var, jSONObject)) == null) {
            return f(context, iu2Var, cu2Var, t73Var);
        }
        return invokeLLLLL.booleanValue;
    }

    public final boolean f(Context context, iu2 iu2Var, cu2 cu2Var, t73 t73Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(Constants.METHOD_SEND_USER_MSG, this, context, iu2Var, cu2Var, t73Var)) == null) {
            t42.i("map", "TranslateMarkerAction start");
            bu1 A = gt2.U().A(iu2Var.c);
            if (!(A instanceof zt1)) {
                t42.c("map", "WebViewManager is null");
                return false;
            }
            dd4 d = cc4.b().c((zt1) A).d(iu2Var.b);
            if (d == null) {
                t42.c("map", "can not find map by id " + iu2Var.b);
                return false;
            }
            return g(iu2Var, d, cu2Var);
        }
        return invokeLLLL.booleanValue;
    }

    public final boolean g(iu2 iu2Var, dd4 dd4Var, cu2 cu2Var) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048579, this, iu2Var, dd4Var, cu2Var)) == null) {
            if (!iu2Var.isValid()) {
                return false;
            }
            mu2 mu2Var = iu2Var.A;
            LatLng latLng = new LatLng(mu2Var.a, mu2Var.b);
            List<cd4> I = dd4Var.I(iu2Var.z);
            t42.i("map", "TranslateMarkerAction animation start");
            if (I != null) {
                for (cd4 cd4Var : I) {
                    cd4Var.c(dd4Var, latLng, iu2Var, new a(this, iu2Var, cu2Var));
                }
            }
            t42.i("map", "TranslateMarkerAction end");
            return true;
        }
        return invokeLLL.booleanValue;
    }
}
