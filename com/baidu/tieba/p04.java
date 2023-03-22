package com.baidu.tieba;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.View;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.tieba.c72;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class p04 implements jw3 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public p04() {
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

    @Override // com.baidu.tieba.jw3
    public boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return s04.b();
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.jw3
    @SuppressLint({"SourceLockedOrientationActivity"})
    public void e() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048580, this) == null) && b()) {
            SwanAppActivity activity = gt2.U().getActivity();
            if (activity != null) {
                activity.setRequestedOrientation(1);
            }
            gt2.U().W().g(true);
        }
    }

    @Override // com.baidu.tieba.jw3
    public void a(String str, JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, str, jSONObject) == null) {
            c72 V = gt2.U().V();
            Context appContext = AppRuntime.getAppContext();
            if (V == null) {
                if (appContext != null) {
                    l73.f(appContext, R.string.obfuscated_res_0x7f0f01a8).G();
                    return;
                }
                return;
            }
            tx2 d = tx2.d(str, str);
            d.h(jSONObject.toString());
            c72.b i = V.i("adLanding");
            i.n(c72.g, c72.i);
            i.k("adLanding", d).b();
        }
    }

    @Override // com.baidu.tieba.jw3
    public boolean c(View view2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, view2)) == null) {
            return s04.c(view2);
        }
        return invokeL.booleanValue;
    }

    @Override // com.baidu.tieba.jw3
    public boolean removeView(View view2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, view2)) == null) {
            return s04.d(view2);
        }
        return invokeL.booleanValue;
    }

    @Override // com.baidu.tieba.jw3
    public boolean d(View view2, dv3 dv3Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, view2, dv3Var)) == null) {
            return s04.a(view2, new zx2(dv3Var.c(), dv3Var.d(), dv3Var.e(), dv3Var.b()));
        }
        return invokeLL.booleanValue;
    }

    @Override // com.baidu.tieba.jw3
    public boolean f(View view2, dv3 dv3Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048581, this, view2, dv3Var)) == null) {
            kp1 W = gt2.U().W();
            if (W != null && W.a(view2, new zx2(dv3Var.c(), dv3Var.d(), dv3Var.e(), dv3Var.b()))) {
                return true;
            }
            return false;
        }
        return invokeLL.booleanValue;
    }
}
