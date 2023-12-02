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
import com.baidu.tieba.t52;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class ln1 implements av3 {
    public static /* synthetic */ Interceptable $ic;
    public static final ViewGroup.LayoutParams c;
    public transient /* synthetic */ FieldHolder $fh;
    public s52 a;
    public FrameLayout b;

    @Override // com.baidu.tieba.av3
    public boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.av3
    public boolean c(View view2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, view2)) == null) {
            return false;
        }
        return invokeL.booleanValue;
    }

    @Override // com.baidu.tieba.av3
    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
        }
    }

    @Override // com.baidu.tieba.av3
    public boolean f(View view2, ut3 ut3Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048581, this, view2, ut3Var)) == null) {
            return false;
        }
        return invokeLL.booleanValue;
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947948538, "Lcom/baidu/tieba/ln1;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947948538, "Lcom/baidu/tieba/ln1;");
                return;
            }
        }
        c = new FrameLayout.LayoutParams(-1, -1);
    }

    public ln1() {
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

    @Override // com.baidu.tieba.av3
    public void a(String str, JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, str, jSONObject) == null) {
            t52 W = xr2.V().W();
            Context appContext = AppRuntime.getAppContext();
            if (W == null) {
                if (appContext != null) {
                    c63.f(appContext, R.string.obfuscated_res_0x7f0f01dd).G();
                    return;
                }
                return;
            }
            kw2 d = kw2.d(str, str);
            d.h(jSONObject.toString());
            t52.b i = W.i("adLanding");
            i.n(t52.g, t52.i);
            i.k("adLanding", d).b();
        }
    }

    @Override // com.baidu.tieba.av3
    public boolean d(View view2, ut3 ut3Var) {
        InterceptResult invokeLL;
        t52 W;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, view2, ut3Var)) == null) {
            xr2 V = xr2.V();
            SwanAppActivity activity = V.getActivity();
            if (activity == null || activity.isFinishing() || (W = V.W()) == null) {
                return false;
            }
            s52 o = W.o();
            this.a = o;
            if (o.N3()) {
                int t = bk3.t();
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
            r53 floatLayer = o.getFloatLayer();
            if (floatLayer == null) {
                return false;
            }
            floatLayer.n(true);
            bk3.b(activity);
            floatLayer.o(this.b);
            return true;
        }
        return invokeLL.booleanValue;
    }

    @Override // com.baidu.tieba.av3
    public boolean removeView(View view2) {
        InterceptResult invokeL;
        r53 floatLayer;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, view2)) == null) {
            this.b.removeAllViews();
            s52 s52Var = this.a;
            if (s52Var == null || (floatLayer = s52Var.getFloatLayer()) == null) {
                return false;
            }
            floatLayer.n(false);
            floatLayer.h();
            return true;
        }
        return invokeL.booleanValue;
    }
}
