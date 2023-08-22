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
/* loaded from: classes8.dex */
public final class v81 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public c91 a;
    public PanelScrollView b;
    public final Activity c;
    public final ViewGroup d;

    public v81(Activity activity, ViewGroup rootView) {
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
        this.a = w81.a().a(this.c);
        this.b = new PanelScrollView(this.c);
    }

    public final void a(e91 listener) {
        PanelScrollView panelScrollView;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, listener) == null) {
            Intrinsics.checkNotNullParameter(listener, "listener");
            c91 c91Var = this.a;
            if (c91Var != null && (panelScrollView = this.b) != null) {
                panelScrollView.k(c91Var, listener);
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
            c91 c91Var = this.a;
            if (c91Var != null) {
                c91Var.onDestroy();
            }
        }
    }

    public final boolean g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            c91 c91Var = this.a;
            if (c91Var != null) {
                return c91Var.f();
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
            c91 c91Var = this.a;
            if (c91Var != null) {
                c91Var.q(javaScript);
            }
        }
    }

    public final void f(g91 nadWebPanelModel) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, nadWebPanelModel) == null) {
            Intrinsics.checkNotNullParameter(nadWebPanelModel, "nadWebPanelModel");
            c91 c91Var = this.a;
            if (c91Var != null) {
                c91Var.j(nadWebPanelModel);
            }
            PanelScrollView panelScrollView = this.b;
            if (panelScrollView != null) {
                panelScrollView.setPanelData(nadWebPanelModel);
            }
        }
    }
}
