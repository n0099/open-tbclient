package com.baidu.tieba;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mapapi.model.LatLng;
import com.baidu.tieba.dd4;
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
public class qc4 extends gc4<ju2> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes6.dex */
    public class a implements dd4.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ju2 a;
        public final /* synthetic */ du2 b;

        public a(qc4 qc4Var, ju2 ju2Var, du2 du2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {qc4Var, ju2Var, du2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ju2Var;
            this.b = du2Var;
        }

        @Override // com.baidu.tieba.dd4.b
        public void onAnimationEnd() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (!TextUtils.isEmpty(this.a.y)) {
                    this.b.c(this.a.y, null);
                }
                u42.i("map", "TranslateMarkerAction animation end");
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948087015, "Lcom/baidu/tieba/qc4;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948087015, "Lcom/baidu/tieba/qc4;");
                return;
            }
        }
        boolean z = eo1.a;
    }

    public qc4() {
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

    public static qc4 e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            return new qc4();
        }
        return (qc4) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.gc4
    /* renamed from: d */
    public boolean b(Context context, ju2 ju2Var, du2 du2Var, u73 u73Var, JSONObject jSONObject) {
        InterceptResult invokeLLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, ju2Var, du2Var, u73Var, jSONObject)) == null) {
            return f(context, ju2Var, du2Var, u73Var);
        }
        return invokeLLLLL.booleanValue;
    }

    public final boolean f(Context context, ju2 ju2Var, du2 du2Var, u73 u73Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(Constants.METHOD_SEND_USER_MSG, this, context, ju2Var, du2Var, u73Var)) == null) {
            u42.i("map", "TranslateMarkerAction start");
            cu1 A = ht2.U().A(ju2Var.c);
            if (!(A instanceof au1)) {
                u42.c("map", "WebViewManager is null");
                return false;
            }
            ed4 d = dc4.b().c((au1) A).d(ju2Var.b);
            if (d == null) {
                u42.c("map", "can not find map by id " + ju2Var.b);
                return false;
            }
            return g(ju2Var, d, du2Var);
        }
        return invokeLLLL.booleanValue;
    }

    public final boolean g(ju2 ju2Var, ed4 ed4Var, du2 du2Var) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048579, this, ju2Var, ed4Var, du2Var)) == null) {
            if (!ju2Var.isValid()) {
                return false;
            }
            nu2 nu2Var = ju2Var.A;
            LatLng latLng = new LatLng(nu2Var.a, nu2Var.b);
            List<dd4> I = ed4Var.I(ju2Var.z);
            u42.i("map", "TranslateMarkerAction animation start");
            if (I != null) {
                for (dd4 dd4Var : I) {
                    dd4Var.c(ed4Var, latLng, ju2Var, new a(this, ju2Var, du2Var));
                }
            }
            u42.i("map", "TranslateMarkerAction end");
            return true;
        }
        return invokeLLL.booleanValue;
    }
}
