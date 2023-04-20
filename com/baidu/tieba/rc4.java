package com.baidu.tieba;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mapapi.model.LatLng;
import com.baidu.tieba.ed4;
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
public class rc4 extends hc4<ku2> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes6.dex */
    public class a implements ed4.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ku2 a;
        public final /* synthetic */ eu2 b;

        public a(rc4 rc4Var, ku2 ku2Var, eu2 eu2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {rc4Var, ku2Var, eu2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ku2Var;
            this.b = eu2Var;
        }

        @Override // com.baidu.tieba.ed4.b
        public void onAnimationEnd() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (!TextUtils.isEmpty(this.a.y)) {
                    this.b.c(this.a.y, null);
                }
                v42.i("map", "TranslateMarkerAction animation end");
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948116806, "Lcom/baidu/tieba/rc4;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948116806, "Lcom/baidu/tieba/rc4;");
                return;
            }
        }
        boolean z = fo1.a;
    }

    public rc4() {
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

    public static rc4 e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            return new rc4();
        }
        return (rc4) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.hc4
    /* renamed from: d */
    public boolean b(Context context, ku2 ku2Var, eu2 eu2Var, v73 v73Var, JSONObject jSONObject) {
        InterceptResult invokeLLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, ku2Var, eu2Var, v73Var, jSONObject)) == null) {
            return f(context, ku2Var, eu2Var, v73Var);
        }
        return invokeLLLLL.booleanValue;
    }

    public final boolean f(Context context, ku2 ku2Var, eu2 eu2Var, v73 v73Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(Constants.METHOD_SEND_USER_MSG, this, context, ku2Var, eu2Var, v73Var)) == null) {
            v42.i("map", "TranslateMarkerAction start");
            du1 A = it2.U().A(ku2Var.c);
            if (!(A instanceof bu1)) {
                v42.c("map", "WebViewManager is null");
                return false;
            }
            fd4 d = ec4.b().c((bu1) A).d(ku2Var.b);
            if (d == null) {
                v42.c("map", "can not find map by id " + ku2Var.b);
                return false;
            }
            return g(ku2Var, d, eu2Var);
        }
        return invokeLLLL.booleanValue;
    }

    public final boolean g(ku2 ku2Var, fd4 fd4Var, eu2 eu2Var) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048579, this, ku2Var, fd4Var, eu2Var)) == null) {
            if (!ku2Var.isValid()) {
                return false;
            }
            ou2 ou2Var = ku2Var.A;
            LatLng latLng = new LatLng(ou2Var.a, ou2Var.b);
            List<ed4> I = fd4Var.I(ku2Var.z);
            v42.i("map", "TranslateMarkerAction animation start");
            if (I != null) {
                for (ed4 ed4Var : I) {
                    ed4Var.c(fd4Var, latLng, ku2Var, new a(this, ku2Var, eu2Var));
                }
            }
            v42.i("map", "TranslateMarkerAction end");
            return true;
        }
        return invokeLLL.booleanValue;
    }
}
