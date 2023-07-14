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
/* loaded from: classes8.dex */
public class tg1 implements vg1 {
    public static /* synthetic */ Interceptable $ic;
    public static final String a;
    public transient /* synthetic */ FieldHolder $fh;

    @Override // com.baidu.tieba.vg1
    public void i(Activity activity, JSONObject jSONObject, qg1 qg1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048585, this, activity, jSONObject, qg1Var) == null) {
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948180139, "Lcom/baidu/tieba/tg1;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948180139, "Lcom/baidu/tieba/tg1;");
                return;
            }
        }
        a = SchemeConfig.getSchemeHead() + "://swan/";
    }

    public tg1() {
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

    @Override // com.baidu.tieba.vg1
    public void a(Activity activity, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048576, this, activity, str, str2) == null) {
            cv2.S().a(activity, str, str2);
        }
    }

    @Override // com.baidu.tieba.vg1
    public void aLiAuth(Activity activity, String str, ch1<JSONObject> ch1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, activity, str, ch1Var) == null) {
            cv2.S().f(activity, str, ch1Var);
        }
    }

    @Override // com.baidu.tieba.vg1
    public void c(Activity activity, String str, qg1 qg1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048579, this, activity, str, qg1Var) == null) {
            cv2.S().c(activity, str, qg1Var);
        }
    }

    @Override // com.baidu.tieba.vg1
    public void d(Context context, JSONObject jSONObject, qg1 qg1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048580, this, context, jSONObject, qg1Var) == null) {
            cv2.S().d(context, jSONObject, qg1Var);
        }
    }

    @Override // com.baidu.tieba.vg1
    public void e(Activity activity, String str, qg1 qg1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048581, this, activity, str, qg1Var) == null) {
            cv2.S().e(activity, str, qg1Var);
        }
    }

    @Override // com.baidu.tieba.vg1
    public boolean b(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, context)) == null) {
            return cv2.S().b(context);
        }
        return invokeL.booleanValue;
    }

    @Override // com.baidu.tieba.vg1
    public void h(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str) == null) {
            j43.b().a = str;
        }
    }

    @Override // com.baidu.tieba.vg1
    public String j(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, context)) == null) {
            return cv2.G0().a(context);
        }
        return (String) invokeL.objValue;
    }

    @Override // com.baidu.tieba.vg1
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

    @Override // com.baidu.tieba.vg1
    public void g(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, bundle) == null) {
            String str = j43.b().a;
            if (TextUtils.isEmpty(str)) {
                ng1.a(bundle);
                return;
            }
            l83 e = l83.e();
            n83 n83Var = new n83(119, bundle);
            n83Var.c(str);
            n83Var.p(true);
            e.h(n83Var);
        }
    }
}
