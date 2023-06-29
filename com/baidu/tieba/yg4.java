package com.baidu.tieba;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mapapi.model.LatLng;
import com.baidu.tieba.lh4;
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
public class yg4 extends og4<ry2> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes8.dex */
    public class a implements lh4.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ry2 a;
        public final /* synthetic */ ly2 b;

        public a(yg4 yg4Var, ry2 ry2Var, ly2 ly2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {yg4Var, ry2Var, ly2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ry2Var;
            this.b = ly2Var;
        }

        @Override // com.baidu.tieba.lh4.b
        public void onAnimationEnd() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (!TextUtils.isEmpty(this.a.y)) {
                    this.b.c(this.a.y, null);
                }
                c92.i("map", "TranslateMarkerAction animation end");
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948329187, "Lcom/baidu/tieba/yg4;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948329187, "Lcom/baidu/tieba/yg4;");
                return;
            }
        }
        boolean z = ms1.a;
    }

    public yg4() {
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

    public static yg4 e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            return new yg4();
        }
        return (yg4) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.og4
    /* renamed from: d */
    public boolean b(Context context, ry2 ry2Var, ly2 ly2Var, cc3 cc3Var, JSONObject jSONObject) {
        InterceptResult invokeLLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, ry2Var, ly2Var, cc3Var, jSONObject)) == null) {
            return f(context, ry2Var, ly2Var, cc3Var);
        }
        return invokeLLLLL.booleanValue;
    }

    public final boolean f(Context context, ry2 ry2Var, ly2 ly2Var, cc3 cc3Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(Constants.METHOD_SEND_USER_MSG, this, context, ry2Var, ly2Var, cc3Var)) == null) {
            c92.i("map", "TranslateMarkerAction start");
            ky1 A = px2.T().A(ry2Var.c);
            if (!(A instanceof iy1)) {
                c92.c("map", "WebViewManager is null");
                return false;
            }
            mh4 d = lg4.b().c((iy1) A).d(ry2Var.b);
            if (d == null) {
                c92.c("map", "can not find map by id " + ry2Var.b);
                return false;
            }
            return g(ry2Var, d, ly2Var);
        }
        return invokeLLLL.booleanValue;
    }

    public final boolean g(ry2 ry2Var, mh4 mh4Var, ly2 ly2Var) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048579, this, ry2Var, mh4Var, ly2Var)) == null) {
            if (!ry2Var.isValid()) {
                return false;
            }
            vy2 vy2Var = ry2Var.A;
            LatLng latLng = new LatLng(vy2Var.a, vy2Var.b);
            List<lh4> I = mh4Var.I(ry2Var.z);
            c92.i("map", "TranslateMarkerAction animation start");
            if (I != null) {
                for (lh4 lh4Var : I) {
                    lh4Var.c(mh4Var, latLng, ry2Var, new a(this, ry2Var, ly2Var));
                }
            }
            c92.i("map", "TranslateMarkerAction end");
            return true;
        }
        return invokeLLL.booleanValue;
    }
}
