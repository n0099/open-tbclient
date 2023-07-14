package com.baidu.tieba;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.View;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.tieba.eb2;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class r44 implements l04 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public r44() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    @Override // com.baidu.tieba.l04
    public boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return u44.b();
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.l04
    @SuppressLint({"SourceLockedOrientationActivity"})
    public void e() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048580, this) == null) && b()) {
            SwanAppActivity activity = ix2.T().getActivity();
            if (activity != null) {
                activity.setRequestedOrientation(1);
            }
            ix2.T().V().g(true);
        }
    }

    @Override // com.baidu.tieba.l04
    public void a(String str, JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, str, jSONObject) == null) {
            eb2 U = ix2.T().U();
            Context appContext = AppRuntime.getAppContext();
            if (U == null) {
                if (appContext != null) {
                    nb3.f(appContext, R.string.obfuscated_res_0x7f0f01d2).G();
                    return;
                }
                return;
            }
            v13 d = v13.d(str, str);
            d.h(jSONObject.toString());
            eb2.b i = U.i("adLanding");
            i.n(eb2.g, eb2.i);
            i.k("adLanding", d).b();
        }
    }

    @Override // com.baidu.tieba.l04
    public boolean c(View view2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, view2)) == null) {
            return u44.c(view2);
        }
        return invokeL.booleanValue;
    }

    @Override // com.baidu.tieba.l04
    public boolean removeView(View view2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, view2)) == null) {
            return u44.d(view2);
        }
        return invokeL.booleanValue;
    }

    @Override // com.baidu.tieba.l04
    public boolean d(View view2, fz3 fz3Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, view2, fz3Var)) == null) {
            return u44.a(view2, new b23(fz3Var.c(), fz3Var.d(), fz3Var.e(), fz3Var.b()));
        }
        return invokeLL.booleanValue;
    }

    @Override // com.baidu.tieba.l04
    public boolean f(View view2, fz3 fz3Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048581, this, view2, fz3Var)) == null) {
            mt1 V = ix2.T().V();
            if (V != null && V.a(view2, new b23(fz3Var.c(), fz3Var.d(), fz3Var.e(), fz3Var.b()))) {
                return true;
            }
            return false;
        }
        return invokeLL.booleanValue;
    }
}
