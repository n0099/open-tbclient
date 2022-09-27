package com.baidu.tieba;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.payment.PaymentManager;
import com.baidu.pyramid.annotation.Service;
import com.baidu.pyramid.annotation.Singleton;
import com.baidu.searchbox.unitedscheme.SchemeConfig;
import com.baidu.searchbox.unitedscheme.SchemeRouter;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
@Singleton
@Service
/* loaded from: classes4.dex */
public class ja1 implements la1 {
    public static /* synthetic */ Interceptable $ic;
    public static final String a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947876463, "Lcom/baidu/tieba/ja1;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947876463, "Lcom/baidu/tieba/ja1;");
                return;
            }
        }
        a = SchemeConfig.getSchemeHead() + "://swan/";
    }

    public ja1() {
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

    @Override // com.baidu.tieba.la1
    public void a(Activity activity, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048576, this, activity, str, str2) == null) {
            sm2.S().a(activity, str, str2);
        }
    }

    @Override // com.baidu.tieba.la1
    public void aLiAuth(Activity activity, String str, sa1<JSONObject> sa1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, activity, str, sa1Var) == null) {
            sm2.S().f(activity, str, sa1Var);
        }
    }

    @Override // com.baidu.tieba.la1
    public boolean b(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, context)) == null) ? sm2.S().b(context) : invokeL.booleanValue;
    }

    @Override // com.baidu.tieba.la1
    public void c(Activity activity, String str, ga1 ga1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048579, this, activity, str, ga1Var) == null) {
            sm2.S().c(activity, str, ga1Var);
        }
    }

    @Override // com.baidu.tieba.la1
    public void d(Context context, JSONObject jSONObject, ga1 ga1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048580, this, context, jSONObject, ga1Var) == null) {
            sm2.S().d(context, jSONObject, ga1Var);
        }
    }

    @Override // com.baidu.tieba.la1
    public void e(Activity activity, String str, ga1 ga1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048581, this, activity, str, ga1Var) == null) {
            sm2.S().e(activity, str, ga1Var);
        }
    }

    @Override // com.baidu.tieba.la1
    public void f(Context context, JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048582, this, context, jSONObject) == null) {
            if (jSONObject == null) {
                PaymentManager.i(3, "支付信息不能为空");
                return;
            }
            String optString = jSONObject.optString("appKey");
            String optString2 = jSONObject.optString("redirectUrl");
            if (!TextUtils.isEmpty(optString) && !TextUtils.isEmpty(optString2)) {
                SchemeRouter.invoke(context, a + optString + optString2);
                return;
            }
            PaymentManager.i(3, "支付信息不能为空");
        }
    }

    @Override // com.baidu.tieba.la1
    public void g(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, bundle) == null) {
            String str = zv2.b().a;
            if (TextUtils.isEmpty(str)) {
                da1.a(bundle);
                return;
            }
            b03 e = b03.e();
            d03 d03Var = new d03(119, bundle);
            d03Var.c(str);
            d03Var.p(true);
            e.h(d03Var);
        }
    }

    @Override // com.baidu.tieba.la1
    public void h(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str) == null) {
            zv2.b().a = str;
        }
    }

    @Override // com.baidu.tieba.la1
    public void i(Activity activity, JSONObject jSONObject, ga1 ga1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048585, this, activity, jSONObject, ga1Var) == null) {
        }
    }

    @Override // com.baidu.tieba.la1
    public String j(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, context)) == null) ? sm2.G0().a(context) : (String) invokeL.objValue;
    }
}
