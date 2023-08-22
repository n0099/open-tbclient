package com.baidu.tieba;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mapapi.model.LatLng;
import com.baidu.tieba.mg4;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public class zf4 extends pf4<sx2> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes9.dex */
    public class a implements mg4.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ sx2 a;
        public final /* synthetic */ mx2 b;

        public a(zf4 zf4Var, sx2 sx2Var, mx2 mx2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {zf4Var, sx2Var, mx2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = sx2Var;
            this.b = mx2Var;
        }

        @Override // com.baidu.tieba.mg4.b
        public void onAnimationEnd() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (!TextUtils.isEmpty(this.a.y)) {
                    this.b.c(this.a.y, null);
                }
                d82.i("map", "TranslateMarkerAction animation end");
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948358017, "Lcom/baidu/tieba/zf4;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948358017, "Lcom/baidu/tieba/zf4;");
                return;
            }
        }
        boolean z = nr1.a;
    }

    public zf4() {
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

    public static zf4 e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            return new zf4();
        }
        return (zf4) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.pf4
    /* renamed from: d */
    public boolean b(Context context, sx2 sx2Var, mx2 mx2Var, db3 db3Var, JSONObject jSONObject) {
        InterceptResult invokeLLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, sx2Var, mx2Var, db3Var, jSONObject)) == null) {
            return f(context, sx2Var, mx2Var, db3Var);
        }
        return invokeLLLLL.booleanValue;
    }

    public final boolean f(Context context, sx2 sx2Var, mx2 mx2Var, db3 db3Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(Constants.METHOD_SEND_USER_MSG, this, context, sx2Var, mx2Var, db3Var)) == null) {
            d82.i("map", "TranslateMarkerAction start");
            lx1 A = qw2.T().A(sx2Var.c);
            if (!(A instanceof jx1)) {
                d82.c("map", "WebViewManager is null");
                return false;
            }
            ng4 d = mf4.b().c((jx1) A).d(sx2Var.b);
            if (d == null) {
                d82.c("map", "can not find map by id " + sx2Var.b);
                return false;
            }
            return g(sx2Var, d, mx2Var);
        }
        return invokeLLLL.booleanValue;
    }

    public final boolean g(sx2 sx2Var, ng4 ng4Var, mx2 mx2Var) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048579, this, sx2Var, ng4Var, mx2Var)) == null) {
            if (!sx2Var.isValid()) {
                return false;
            }
            wx2 wx2Var = sx2Var.A;
            LatLng latLng = new LatLng(wx2Var.a, wx2Var.b);
            List<mg4> I = ng4Var.I(sx2Var.z);
            d82.i("map", "TranslateMarkerAction animation start");
            if (I != null) {
                for (mg4 mg4Var : I) {
                    mg4Var.c(ng4Var, latLng, sx2Var, new a(this, sx2Var, mx2Var));
                }
            }
            d82.i("map", "TranslateMarkerAction end");
            return true;
        }
        return invokeLLL.booleanValue;
    }
}
