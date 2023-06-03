package com.baidu.tieba;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mapapi.model.LatLng;
import com.baidu.tieba.hh4;
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
public class ug4 extends kg4<ny2> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes8.dex */
    public class a implements hh4.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ny2 a;
        public final /* synthetic */ hy2 b;

        public a(ug4 ug4Var, ny2 ny2Var, hy2 hy2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ug4Var, ny2Var, hy2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ny2Var;
            this.b = hy2Var;
        }

        @Override // com.baidu.tieba.hh4.b
        public void onAnimationEnd() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (!TextUtils.isEmpty(this.a.y)) {
                    this.b.c(this.a.y, null);
                }
                y82.i("map", "TranslateMarkerAction animation end");
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948210023, "Lcom/baidu/tieba/ug4;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948210023, "Lcom/baidu/tieba/ug4;");
                return;
            }
        }
        boolean z = is1.a;
    }

    public ug4() {
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

    public static ug4 e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            return new ug4();
        }
        return (ug4) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.kg4
    /* renamed from: d */
    public boolean b(Context context, ny2 ny2Var, hy2 hy2Var, yb3 yb3Var, JSONObject jSONObject) {
        InterceptResult invokeLLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, ny2Var, hy2Var, yb3Var, jSONObject)) == null) {
            return f(context, ny2Var, hy2Var, yb3Var);
        }
        return invokeLLLLL.booleanValue;
    }

    public final boolean f(Context context, ny2 ny2Var, hy2 hy2Var, yb3 yb3Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(Constants.METHOD_SEND_USER_MSG, this, context, ny2Var, hy2Var, yb3Var)) == null) {
            y82.i("map", "TranslateMarkerAction start");
            gy1 A = lx2.T().A(ny2Var.c);
            if (!(A instanceof ey1)) {
                y82.c("map", "WebViewManager is null");
                return false;
            }
            ih4 d = hg4.b().c((ey1) A).d(ny2Var.b);
            if (d == null) {
                y82.c("map", "can not find map by id " + ny2Var.b);
                return false;
            }
            return g(ny2Var, d, hy2Var);
        }
        return invokeLLLL.booleanValue;
    }

    public final boolean g(ny2 ny2Var, ih4 ih4Var, hy2 hy2Var) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048579, this, ny2Var, ih4Var, hy2Var)) == null) {
            if (!ny2Var.isValid()) {
                return false;
            }
            ry2 ry2Var = ny2Var.A;
            LatLng latLng = new LatLng(ry2Var.a, ry2Var.b);
            List<hh4> I = ih4Var.I(ny2Var.z);
            y82.i("map", "TranslateMarkerAction animation start");
            if (I != null) {
                for (hh4 hh4Var : I) {
                    hh4Var.c(ih4Var, latLng, ny2Var, new a(this, ny2Var, hy2Var));
                }
            }
            y82.i("map", "TranslateMarkerAction end");
            return true;
        }
        return invokeLLL.booleanValue;
    }
}
