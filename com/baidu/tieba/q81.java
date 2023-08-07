package com.baidu.tieba;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nadcore.webpanel.PanelScrollView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes7.dex */
public final class q81 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public x81 a;
    public PanelScrollView b;
    public final Activity c;
    public final ViewGroup d;

    public q81(Activity activity, ViewGroup rootView) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {activity, rootView};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        this.c = activity;
        this.d = rootView;
        this.a = r81.a().a(this.c);
        this.b = new PanelScrollView(this.c);
    }

    public final void a(z81 listener) {
        PanelScrollView panelScrollView;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, listener) == null) {
            Intrinsics.checkNotNullParameter(listener, "listener");
            x81 x81Var = this.a;
            if (x81Var != null && (panelScrollView = this.b) != null) {
                panelScrollView.k(x81Var, listener);
            }
            PanelScrollView panelScrollView2 = this.b;
            if (panelScrollView2 != null) {
                this.d.setClipChildren(false);
                this.d.addView(panelScrollView2, new FrameLayout.LayoutParams(-1, -1));
            }
        }
    }

    public final PanelScrollView b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.b;
        }
        return (PanelScrollView) invokeV.objValue;
    }

    public final View.OnTouchListener c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.b;
        }
        return (View.OnTouchListener) invokeV.objValue;
    }

    public final void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            PanelScrollView panelScrollView = this.b;
            if (panelScrollView != null) {
                panelScrollView.r();
            }
            x81 x81Var = this.a;
            if (x81Var != null) {
                x81Var.onDestroy();
            }
        }
    }

    public final boolean g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            x81 x81Var = this.a;
            if (x81Var != null) {
                return x81Var.f();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final Activity getActivity() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.c;
        }
        return (Activity) invokeV.objValue;
    }

    public final void d(String javaScript) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, javaScript) == null) {
            Intrinsics.checkNotNullParameter(javaScript, "javaScript");
            x81 x81Var = this.a;
            if (x81Var != null) {
                x81Var.q(javaScript);
            }
        }
    }

    public final void f(b91 nadWebPanelModel) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, nadWebPanelModel) == null) {
            Intrinsics.checkNotNullParameter(nadWebPanelModel, "nadWebPanelModel");
            x81 x81Var = this.a;
            if (x81Var != null) {
                x81Var.j(nadWebPanelModel);
            }
            PanelScrollView panelScrollView = this.b;
            if (panelScrollView != null) {
                panelScrollView.setPanelData(nadWebPanelModel);
            }
        }
    }
}
