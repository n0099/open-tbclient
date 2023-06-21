package com.baidu.tieba;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Outline;
import android.graphics.Rect;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewOutlineProvider;
import android.view.ViewParent;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nadcore.webpanel.PanelScrollView;
import com.baidu.nadcore.webpanel.proxy.WebPanelBrowserContainer;
import com.baidu.nadcore.webview.view.AbsNadBrowserView;
import com.baidu.searchbox.download.util.MigrateStatisticUtils;
import com.baidu.tieba.d61;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes6.dex */
public final class l81 implements p81, ba1, aa1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public w81 a;
    public t81 b;
    public u81 c;
    public final Activity d;

    @Override // com.baidu.tieba.ba1, com.baidu.tieba.mb1
    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
        }
    }

    @Override // com.baidu.tieba.ba1, com.baidu.tieba.mb1
    public boolean f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }

    /* loaded from: classes6.dex */
    public static final class a extends ViewOutlineProvider {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ LinearLayout a;

        public a(LinearLayout linearLayout) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {linearLayout};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = linearLayout;
        }

        @Override // android.view.ViewOutlineProvider
        public void getOutline(View view2, Outline outline) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, view2, outline) == null) {
                Rect rect = new Rect(0, 0, this.a.getMeasuredWidth(), this.a.getMeasuredHeight());
                if (outline != null) {
                    outline.setRoundRect(rect, d61.c.a(tc1.a(), 0.0f));
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public static final class b extends ViewOutlineProvider {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ LinearLayout a;

        public b(LinearLayout linearLayout) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {linearLayout};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = linearLayout;
        }

        @Override // android.view.ViewOutlineProvider
        public void getOutline(View view2, Outline outline) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, view2, outline) == null) {
                Rect rect = new Rect(0, 0, this.a.getMeasuredWidth(), this.a.getMeasuredHeight());
                if (outline != null) {
                    outline.setRoundRect(rect, d61.c.a(tc1.a(), 18.0f));
                }
            }
        }
    }

    public l81(Activity activity) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {activity};
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
        this.d = activity;
    }

    @Override // com.baidu.tieba.p81
    public void g(int i) {
        w81 w81Var;
        LinearLayout e;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048582, this, i) == null) && (w81Var = this.a) != null && (e = w81Var.e()) != null && (e.getLayoutParams() instanceof FrameLayout.LayoutParams)) {
            ViewGroup.LayoutParams layoutParams = e.getLayoutParams();
            if (layoutParams != null) {
                FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) layoutParams;
                layoutParams2.topMargin = i;
                e.setLayoutParams(layoutParams2);
                return;
            }
            throw new NullPointerException("null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
        }
    }

    @Override // com.baidu.tieba.p81
    public void p(n81 controlHelper) {
        u81 u81Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, controlHelper) == null) {
            Intrinsics.checkNotNullParameter(controlHelper, "controlHelper");
            w81 w81Var = this.a;
            if (w81Var != null) {
                u81 u81Var2 = new u81(w81Var);
                this.c = u81Var2;
                if (u81Var2 != null) {
                    u81Var2.q(this.b);
                }
                u81 u81Var3 = this.c;
                if (u81Var3 != null) {
                    u81Var3.o(controlHelper);
                }
                t81 t81Var = this.b;
                if (t81Var != null && t81Var.t() && (u81Var = this.c) != null) {
                    u81Var.k();
                }
                w81Var.n(this.c);
            }
        }
    }

    @Override // com.baidu.tieba.p81
    public void a() {
        u81 u81Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && (u81Var = this.c) != null) {
            u81Var.j();
        }
    }

    @Override // com.baidu.tieba.p81
    public ViewGroup.LayoutParams b() {
        InterceptResult invokeV;
        LinearLayout e;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            w81 w81Var = this.a;
            if (w81Var != null && (e = w81Var.e()) != null) {
                return e.getLayoutParams();
            }
            return null;
        }
        return (ViewGroup.LayoutParams) invokeV.objValue;
    }

    @Override // com.baidu.tieba.p81
    public void e() {
        w81 w81Var;
        LinearLayout e;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048580, this) == null) && (w81Var = this.a) != null && (e = w81Var.e()) != null && Build.VERSION.SDK_INT >= 21) {
            e.setOutlineProvider(new a(e));
            e.setClipToOutline(true);
        }
    }

    @Override // com.baidu.tieba.ba1, com.baidu.tieba.mb1
    public Activity getActivity() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.d;
        }
        return (Activity) invokeV.objValue;
    }

    @Override // com.baidu.tieba.p81
    public boolean h() {
        InterceptResult invokeV;
        AbsNadBrowserView m;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            w81 w81Var = this.a;
            if (w81Var != null && (m = w81Var.m()) != null && m.d()) {
                w81 w81Var2 = this.a;
                if (w81Var2 != null) {
                    w81Var2.g();
                }
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.p81
    public boolean j() {
        InterceptResult invokeV;
        AbsNadBrowserView m;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            w81 w81Var = this.a;
            if (w81Var != null && (m = w81Var.m()) != null) {
                return m.w();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.p81
    public boolean n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            u81 u81Var = this.c;
            if (u81Var != null) {
                return u81Var.h();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.p81
    public void onDestroy() {
        u81 u81Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            t81 t81Var = this.b;
            if (t81Var != null && t81Var.t() && (u81Var = this.c) != null) {
                u81Var.t();
            }
            w81 w81Var = this.a;
            if (w81Var != null) {
                w81Var.onPause();
            }
            w81 w81Var2 = this.a;
            if (w81Var2 != null) {
                w81Var2.onDestroy();
            }
        }
    }

    @Override // com.baidu.tieba.aa1
    public void q() {
        u81 u81Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048595, this) == null) && (u81Var = this.c) != null) {
            u81Var.g();
        }
    }

    @Override // com.baidu.tieba.p81
    public void v() {
        w81 w81Var;
        LinearLayout e;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048600, this) == null) && (w81Var = this.a) != null && (e = w81Var.e()) != null && Build.VERSION.SDK_INT >= 21) {
            e.setOutlineProvider(new b(e));
            e.setClipToOutline(true);
        }
    }

    @Override // com.baidu.tieba.p81
    public void c(View.OnLayoutChangeListener onLayoutChangeListener) {
        w81 w81Var;
        LinearLayout e;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, onLayoutChangeListener) == null) && (w81Var = this.a) != null && (e = w81Var.e()) != null) {
            e.removeOnLayoutChangeListener(onLayoutChangeListener);
        }
    }

    @Override // com.baidu.tieba.p81
    public void i(FrameLayout.LayoutParams params) {
        LinearLayout e;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, params) == null) {
            Intrinsics.checkNotNullParameter(params, "params");
            w81 w81Var = this.a;
            if (w81Var != null && (e = w81Var.e()) != null) {
                e.setLayoutParams(params);
            }
        }
    }

    @Override // com.baidu.tieba.p81
    public void k(int i) {
        w81 w81Var;
        LinearLayout e;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048588, this, i) == null) && (w81Var = this.a) != null && (e = w81Var.e()) != null) {
            ViewGroup.LayoutParams layoutParams = e.getLayoutParams();
            layoutParams.height = i;
            e.setLayoutParams(layoutParams);
        }
    }

    @Override // com.baidu.tieba.p81
    public void l(t81 t81Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, t81Var) == null) {
            this.b = t81Var;
        }
    }

    @Override // com.baidu.tieba.p81
    public void m(boolean z) {
        u81 u81Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048590, this, z) == null) && (u81Var = this.c) != null) {
            u81Var.n(z);
        }
    }

    @Override // com.baidu.tieba.p81
    public void r(String str) {
        w81 w81Var;
        AbsNadBrowserView m;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048596, this, str) == null) && (w81Var = this.a) != null && (m = w81Var.m()) != null) {
            AbsNadBrowserView.B(m, str, null, 2, null);
        }
    }

    @Override // com.baidu.tieba.p81
    public void s(View.OnLayoutChangeListener onLayoutChangeListener) {
        w81 w81Var;
        LinearLayout e;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048597, this, onLayoutChangeListener) == null) && (w81Var = this.a) != null && (e = w81Var.e()) != null) {
            e.addOnLayoutChangeListener(onLayoutChangeListener);
        }
    }

    @Override // com.baidu.tieba.p81
    public void u(r81 r81Var) {
        u81 u81Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048599, this, r81Var) == null) && (u81Var = this.c) != null) {
            u81Var.p(r81Var);
        }
    }

    @Override // com.baidu.tieba.ba1, com.baidu.tieba.mb1
    public Intent getIntent() {
        InterceptResult invokeV;
        String b2;
        String c;
        String f;
        String h;
        String i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            Intent intent = new Intent();
            HashMap hashMap = new HashMap();
            t81 t81Var = this.b;
            if (t81Var != null && (i = t81Var.i()) != null) {
                hashMap.put("url", i);
                hashMap.put("lp_real_url", i);
                intent.putExtra("url", i);
                intent.putExtra("lp_real_url", i);
            }
            t81 t81Var2 = this.b;
            if (t81Var2 != null && (h = t81Var2.h()) != null) {
                hashMap.put("sdk_script", h);
                intent.putExtra("sdk_script", h);
            }
            t81 t81Var3 = this.b;
            if (t81Var3 != null && (f = t81Var3.f()) != null) {
                hashMap.put("log_switch", f);
                intent.putExtra("log_switch", f);
            }
            t81 t81Var4 = this.b;
            if (t81Var4 != null && (c = t81Var4.c()) != null) {
                hashMap.put(MigrateStatisticUtils.EXT_INFO, c);
                intent.putExtra(MigrateStatisticUtils.EXT_INFO, c);
            }
            t81 t81Var5 = this.b;
            if (t81Var5 != null && (b2 = t81Var5.b()) != null) {
                hashMap.put("charge_url", b2);
                intent.putExtra("charge_url", b2);
            }
            hashMap.put("lp_org_type", "pop_web");
            intent.putExtra("lp_org_type", "pop_web");
            intent.putExtra("map", hashMap);
            return intent;
        }
        return (Intent) invokeV.objValue;
    }

    @Override // com.baidu.tieba.p81
    public void o(ViewGroup parent) {
        ViewParent viewParent;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, parent) == null) {
            Intrinsics.checkNotNullParameter(parent, "parent");
            ViewGroup viewGroup = null;
            WebPanelBrowserContainer webPanelBrowserContainer = new WebPanelBrowserContainer(this, new c91(), null);
            this.a = webPanelBrowserContainer;
            webPanelBrowserContainer.t0(false);
            webPanelBrowserContainer.s0(false);
            webPanelBrowserContainer.t();
            webPanelBrowserContainer.z(this);
            webPanelBrowserContainer.v();
            v();
            LinearLayout e = webPanelBrowserContainer.e();
            if (e != null) {
                e.setPadding(0, 0, 0, PanelScrollView.A);
            }
            ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-1, -1);
            FrameLayout h = webPanelBrowserContainer.h();
            if (h != null) {
                viewParent = h.getParent();
            } else {
                viewParent = null;
            }
            if (viewParent instanceof ViewGroup) {
                viewGroup = viewParent;
            }
            ViewGroup viewGroup2 = viewGroup;
            if (viewGroup2 != null) {
                viewGroup2.removeView(h);
            }
            parent.addView(h, layoutParams);
        }
    }

    @Override // com.baidu.tieba.p81
    public void t(int i, boolean z) {
        u81 u81Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048598, this, new Object[]{Integer.valueOf(i), Boolean.valueOf(z)}) == null) && (u81Var = this.c) != null) {
            u81Var.i(i, z);
        }
    }
}
