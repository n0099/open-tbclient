package com.baidu.tieba;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mapapi.model.LatLng;
import com.baidu.tieba.ih4;
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
public class vg4 extends lg4<oy2> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes8.dex */
    public class a implements ih4.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ oy2 a;
        public final /* synthetic */ iy2 b;

        public a(vg4 vg4Var, oy2 oy2Var, iy2 iy2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {vg4Var, oy2Var, iy2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = oy2Var;
            this.b = iy2Var;
        }

        @Override // com.baidu.tieba.ih4.b
        public void onAnimationEnd() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (!TextUtils.isEmpty(this.a.y)) {
                    this.b.c(this.a.y, null);
                }
                z82.i("map", "TranslateMarkerAction animation end");
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948239814, "Lcom/baidu/tieba/vg4;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948239814, "Lcom/baidu/tieba/vg4;");
                return;
            }
        }
        boolean z = js1.a;
    }

    public vg4() {
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

    public static vg4 e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            return new vg4();
        }
        return (vg4) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.lg4
    /* renamed from: d */
    public boolean b(Context context, oy2 oy2Var, iy2 iy2Var, zb3 zb3Var, JSONObject jSONObject) {
        InterceptResult invokeLLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, oy2Var, iy2Var, zb3Var, jSONObject)) == null) {
            return f(context, oy2Var, iy2Var, zb3Var);
        }
        return invokeLLLLL.booleanValue;
    }

    public final boolean f(Context context, oy2 oy2Var, iy2 iy2Var, zb3 zb3Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(Constants.METHOD_SEND_USER_MSG, this, context, oy2Var, iy2Var, zb3Var)) == null) {
            z82.i("map", "TranslateMarkerAction start");
            hy1 A = mx2.T().A(oy2Var.c);
            if (!(A instanceof fy1)) {
                z82.c("map", "WebViewManager is null");
                return false;
            }
            jh4 d = ig4.b().c((fy1) A).d(oy2Var.b);
            if (d == null) {
                z82.c("map", "can not find map by id " + oy2Var.b);
                return false;
            }
            return g(oy2Var, d, iy2Var);
        }
        return invokeLLLL.booleanValue;
    }

    public final boolean g(oy2 oy2Var, jh4 jh4Var, iy2 iy2Var) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048579, this, oy2Var, jh4Var, iy2Var)) == null) {
            if (!oy2Var.isValid()) {
                return false;
            }
            sy2 sy2Var = oy2Var.A;
            LatLng latLng = new LatLng(sy2Var.a, sy2Var.b);
            List<ih4> I = jh4Var.I(oy2Var.z);
            z82.i("map", "TranslateMarkerAction animation start");
            if (I != null) {
                for (ih4 ih4Var : I) {
                    ih4Var.c(jh4Var, latLng, oy2Var, new a(this, oy2Var, iy2Var));
                }
            }
            z82.i("map", "TranslateMarkerAction end");
            return true;
        }
        return invokeLLL.booleanValue;
    }
}
