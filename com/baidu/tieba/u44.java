package com.baidu.tieba;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.View;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.tieba.hb2;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class u44 implements o04 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public u44() {
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

    @Override // com.baidu.tieba.o04
    public boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return x44.b();
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.o04
    @SuppressLint({"SourceLockedOrientationActivity"})
    public void e() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048580, this) == null) && b()) {
            SwanAppActivity activity = lx2.T().getActivity();
            if (activity != null) {
                activity.setRequestedOrientation(1);
            }
            lx2.T().V().g(true);
        }
    }

    @Override // com.baidu.tieba.o04
    public void a(String str, JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, str, jSONObject) == null) {
            hb2 U = lx2.T().U();
            Context appContext = AppRuntime.getAppContext();
            if (U == null) {
                if (appContext != null) {
                    qb3.f(appContext, R.string.obfuscated_res_0x7f0f01d0).G();
                    return;
                }
                return;
            }
            y13 d = y13.d(str, str);
            d.h(jSONObject.toString());
            hb2.b i = U.i("adLanding");
            i.n(hb2.g, hb2.i);
            i.k("adLanding", d).b();
        }
    }

    @Override // com.baidu.tieba.o04
    public boolean c(View view2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, view2)) == null) {
            return x44.c(view2);
        }
        return invokeL.booleanValue;
    }

    @Override // com.baidu.tieba.o04
    public boolean removeView(View view2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, view2)) == null) {
            return x44.d(view2);
        }
        return invokeL.booleanValue;
    }

    @Override // com.baidu.tieba.o04
    public boolean d(View view2, iz3 iz3Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, view2, iz3Var)) == null) {
            return x44.a(view2, new e23(iz3Var.c(), iz3Var.d(), iz3Var.e(), iz3Var.b()));
        }
        return invokeLL.booleanValue;
    }

    @Override // com.baidu.tieba.o04
    public boolean f(View view2, iz3 iz3Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048581, this, view2, iz3Var)) == null) {
            pt1 V = lx2.T().V();
            if (V != null && V.a(view2, new e23(iz3Var.c(), iz3Var.d(), iz3Var.e(), iz3Var.b()))) {
                return true;
            }
            return false;
        }
        return invokeLL.booleanValue;
    }
}
