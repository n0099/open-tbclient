package com.baidu.tieba;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.View;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.tieba.h22;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class uv3 implements or3 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public uv3() {
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

    @Override // com.baidu.tieba.or3
    public void a(String str, JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, str, jSONObject) == null) {
            h22 V = lo2.U().V();
            Context appContext = AppRuntime.getAppContext();
            if (V == null) {
                if (appContext != null) {
                    q23.f(appContext, R.string.obfuscated_res_0x7f0f01a6).G();
                    return;
                }
                return;
            }
            ys2 d = ys2.d(str, str);
            d.h(jSONObject.toString());
            h22.b i = V.i("adLanding");
            i.n(h22.g, h22.i);
            i.k("adLanding", d).b();
        }
    }

    @Override // com.baidu.tieba.or3
    public boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? xv3.b() : invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.or3
    public boolean c(View view2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, view2)) == null) ? xv3.c(view2) : invokeL.booleanValue;
    }

    @Override // com.baidu.tieba.or3
    public boolean d(View view2, iq3 iq3Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, view2, iq3Var)) == null) ? xv3.a(view2, new et2(iq3Var.c(), iq3Var.d(), iq3Var.e(), iq3Var.b())) : invokeLL.booleanValue;
    }

    @Override // com.baidu.tieba.or3
    @SuppressLint({"SourceLockedOrientationActivity"})
    public void e() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048580, this) == null) && b()) {
            SwanAppActivity activity = lo2.U().getActivity();
            if (activity != null) {
                activity.setRequestedOrientation(1);
            }
            lo2.U().W().g(true);
        }
    }

    @Override // com.baidu.tieba.or3
    public boolean f(View view2, iq3 iq3Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048581, this, view2, iq3Var)) == null) {
            pk1 W = lo2.U().W();
            return W != null && W.a(view2, new et2(iq3Var.c(), iq3Var.d(), iq3Var.e(), iq3Var.b()));
        }
        return invokeLL.booleanValue;
    }

    @Override // com.baidu.tieba.or3
    public boolean removeView(View view2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, view2)) == null) ? xv3.d(view2) : invokeL.booleanValue;
    }
}
