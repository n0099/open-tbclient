package com.baidu.tieba;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.View;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.tieba.d72;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class q04 implements kw3 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public q04() {
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

    @Override // com.baidu.tieba.kw3
    public boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return t04.b();
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.kw3
    @SuppressLint({"SourceLockedOrientationActivity"})
    public void e() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048580, this) == null) && b()) {
            SwanAppActivity activity = ht2.U().getActivity();
            if (activity != null) {
                activity.setRequestedOrientation(1);
            }
            ht2.U().W().g(true);
        }
    }

    @Override // com.baidu.tieba.kw3
    public void a(String str, JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, str, jSONObject) == null) {
            d72 V = ht2.U().V();
            Context appContext = AppRuntime.getAppContext();
            if (V == null) {
                if (appContext != null) {
                    m73.f(appContext, R.string.obfuscated_res_0x7f0f01a8).G();
                    return;
                }
                return;
            }
            ux2 d = ux2.d(str, str);
            d.h(jSONObject.toString());
            d72.b i = V.i("adLanding");
            i.n(d72.g, d72.i);
            i.k("adLanding", d).b();
        }
    }

    @Override // com.baidu.tieba.kw3
    public boolean c(View view2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, view2)) == null) {
            return t04.c(view2);
        }
        return invokeL.booleanValue;
    }

    @Override // com.baidu.tieba.kw3
    public boolean removeView(View view2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, view2)) == null) {
            return t04.d(view2);
        }
        return invokeL.booleanValue;
    }

    @Override // com.baidu.tieba.kw3
    public boolean d(View view2, ev3 ev3Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, view2, ev3Var)) == null) {
            return t04.a(view2, new ay2(ev3Var.c(), ev3Var.d(), ev3Var.e(), ev3Var.b()));
        }
        return invokeLL.booleanValue;
    }

    @Override // com.baidu.tieba.kw3
    public boolean f(View view2, ev3 ev3Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048581, this, view2, ev3Var)) == null) {
            lp1 W = ht2.U().W();
            if (W != null && W.a(view2, new ay2(ev3Var.c(), ev3Var.d(), ev3Var.e(), ev3Var.b()))) {
                return true;
            }
            return false;
        }
        return invokeLL.booleanValue;
    }
}
