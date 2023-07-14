package com.baidu.tieba;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.view.narootview.SwanAppInlineFullScreenContainer;
import com.baidu.tieba.eb2;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class vs1 implements l04 {
    public static /* synthetic */ Interceptable $ic;
    public static final ViewGroup.LayoutParams c;
    public transient /* synthetic */ FieldHolder $fh;
    public db2 a;
    public FrameLayout b;

    @Override // com.baidu.tieba.l04
    public boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.l04
    public boolean c(View view2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, view2)) == null) {
            return false;
        }
        return invokeL.booleanValue;
    }

    @Override // com.baidu.tieba.l04
    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
        }
    }

    @Override // com.baidu.tieba.l04
    public boolean f(View view2, fz3 fz3Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048581, this, view2, fz3Var)) == null) {
            return false;
        }
        return invokeLL.booleanValue;
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948251253, "Lcom/baidu/tieba/vs1;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948251253, "Lcom/baidu/tieba/vs1;");
                return;
            }
        }
        c = new FrameLayout.LayoutParams(-1, -1);
    }

    public vs1() {
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
    public boolean d(View view2, fz3 fz3Var) {
        InterceptResult invokeLL;
        eb2 U;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, view2, fz3Var)) == null) {
            ix2 T2 = ix2.T();
            SwanAppActivity activity = T2.getActivity();
            if (activity == null || activity.isFinishing() || (U = T2.U()) == null) {
                return false;
            }
            db2 o = U.o();
            this.a = o;
            if (o.I3()) {
                int t = mp3.t();
                if (view2 instanceof ViewGroup) {
                    ViewGroup viewGroup = (ViewGroup) view2;
                    for (int i = 0; i < viewGroup.getChildCount(); i++) {
                        View childAt = viewGroup.getChildAt(i);
                        if (childAt.getTop() < t) {
                            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) childAt.getLayoutParams();
                            layoutParams.topMargin = childAt.getTop() + t;
                            childAt.setLayoutParams(layoutParams);
                        }
                    }
                }
            }
            SwanAppInlineFullScreenContainer swanAppInlineFullScreenContainer = new SwanAppInlineFullScreenContainer(activity);
            this.b = swanAppInlineFullScreenContainer;
            swanAppInlineFullScreenContainer.addView(view2, c);
            cb3 floatLayer = o.getFloatLayer();
            if (floatLayer == null) {
                return false;
            }
            floatLayer.m(true);
            mp3.b(activity);
            floatLayer.n(this.b);
            return true;
        }
        return invokeLL.booleanValue;
    }

    @Override // com.baidu.tieba.l04
    public boolean removeView(View view2) {
        InterceptResult invokeL;
        cb3 floatLayer;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, view2)) == null) {
            this.b.removeAllViews();
            db2 db2Var = this.a;
            if (db2Var == null || (floatLayer = db2Var.getFloatLayer()) == null) {
                return false;
            }
            floatLayer.m(false);
            floatLayer.g();
            return true;
        }
        return invokeL.booleanValue;
    }
}
