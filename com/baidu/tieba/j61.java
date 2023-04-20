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
import com.baidu.tieba.b41;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes5.dex */
public final class j61 implements n61, z71, y71 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public u61 a;
    public r61 b;
    public s61 c;
    public final Activity d;

    @Override // com.baidu.tieba.z71, com.baidu.tieba.k91
    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
        }
    }

    @Override // com.baidu.tieba.z71, com.baidu.tieba.k91
    public boolean f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }

    /* loaded from: classes5.dex */
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
                    outline.setRoundRect(rect, b41.c.a(ra1.a(), 0.0f));
                }
            }
        }
    }

    /* loaded from: classes5.dex */
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
                    outline.setRoundRect(rect, b41.c.a(ra1.a(), 18.0f));
                }
            }
        }
    }

    public j61(Activity activity) {
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

    @Override // com.baidu.tieba.n61
    public void g(int i) {
        u61 u61Var;
        LinearLayout e;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048582, this, i) == null) && (u61Var = this.a) != null && (e = u61Var.e()) != null && (e.getLayoutParams() instanceof FrameLayout.LayoutParams)) {
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

    @Override // com.baidu.tieba.n61
    public void p(l61 controlHelper) {
        s61 s61Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, controlHelper) == null) {
            Intrinsics.checkNotNullParameter(controlHelper, "controlHelper");
            u61 u61Var = this.a;
            if (u61Var != null) {
                s61 s61Var2 = new s61(u61Var);
                this.c = s61Var2;
                if (s61Var2 != null) {
                    s61Var2.q(this.b);
                }
                s61 s61Var3 = this.c;
                if (s61Var3 != null) {
                    s61Var3.o(controlHelper);
                }
                r61 r61Var = this.b;
                if (r61Var != null && r61Var.t() && (s61Var = this.c) != null) {
                    s61Var.k();
                }
                u61Var.n(this.c);
            }
        }
    }

    @Override // com.baidu.tieba.n61
    public void a() {
        s61 s61Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && (s61Var = this.c) != null) {
            s61Var.j();
        }
    }

    @Override // com.baidu.tieba.n61
    public ViewGroup.LayoutParams b() {
        InterceptResult invokeV;
        LinearLayout e;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            u61 u61Var = this.a;
            if (u61Var != null && (e = u61Var.e()) != null) {
                return e.getLayoutParams();
            }
            return null;
        }
        return (ViewGroup.LayoutParams) invokeV.objValue;
    }

    @Override // com.baidu.tieba.n61
    public void e() {
        u61 u61Var;
        LinearLayout e;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048580, this) == null) && (u61Var = this.a) != null && (e = u61Var.e()) != null && Build.VERSION.SDK_INT >= 21) {
            e.setOutlineProvider(new a(e));
            e.setClipToOutline(true);
        }
    }

    @Override // com.baidu.tieba.z71, com.baidu.tieba.k91
    public Activity getActivity() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.d;
        }
        return (Activity) invokeV.objValue;
    }

    @Override // com.baidu.tieba.n61
    public boolean h() {
        InterceptResult invokeV;
        AbsNadBrowserView m;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            u61 u61Var = this.a;
            if (u61Var != null && (m = u61Var.m()) != null && m.d()) {
                u61 u61Var2 = this.a;
                if (u61Var2 != null) {
                    u61Var2.g();
                }
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.n61
    public boolean j() {
        InterceptResult invokeV;
        AbsNadBrowserView m;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            u61 u61Var = this.a;
            if (u61Var != null && (m = u61Var.m()) != null) {
                return m.w();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.n61
    public boolean n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            s61 s61Var = this.c;
            if (s61Var != null) {
                return s61Var.h();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.n61
    public void onDestroy() {
        s61 s61Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            r61 r61Var = this.b;
            if (r61Var != null && r61Var.t() && (s61Var = this.c) != null) {
                s61Var.t();
            }
            u61 u61Var = this.a;
            if (u61Var != null) {
                u61Var.onPause();
            }
            u61 u61Var2 = this.a;
            if (u61Var2 != null) {
                u61Var2.onDestroy();
            }
        }
    }

    @Override // com.baidu.tieba.y71
    public void q() {
        s61 s61Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048595, this) == null) && (s61Var = this.c) != null) {
            s61Var.g();
        }
    }

    @Override // com.baidu.tieba.n61
    public void v() {
        u61 u61Var;
        LinearLayout e;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048600, this) == null) && (u61Var = this.a) != null && (e = u61Var.e()) != null && Build.VERSION.SDK_INT >= 21) {
            e.setOutlineProvider(new b(e));
            e.setClipToOutline(true);
        }
    }

    @Override // com.baidu.tieba.n61
    public void c(View.OnLayoutChangeListener onLayoutChangeListener) {
        u61 u61Var;
        LinearLayout e;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, onLayoutChangeListener) == null) && (u61Var = this.a) != null && (e = u61Var.e()) != null) {
            e.removeOnLayoutChangeListener(onLayoutChangeListener);
        }
    }

    @Override // com.baidu.tieba.n61
    public void i(FrameLayout.LayoutParams params) {
        LinearLayout e;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, params) == null) {
            Intrinsics.checkNotNullParameter(params, "params");
            u61 u61Var = this.a;
            if (u61Var != null && (e = u61Var.e()) != null) {
                e.setLayoutParams(params);
            }
        }
    }

    @Override // com.baidu.tieba.n61
    public void k(int i) {
        u61 u61Var;
        LinearLayout e;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048588, this, i) == null) && (u61Var = this.a) != null && (e = u61Var.e()) != null) {
            ViewGroup.LayoutParams layoutParams = e.getLayoutParams();
            layoutParams.height = i;
            e.setLayoutParams(layoutParams);
        }
    }

    @Override // com.baidu.tieba.n61
    public void l(r61 r61Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, r61Var) == null) {
            this.b = r61Var;
        }
    }

    @Override // com.baidu.tieba.n61
    public void m(boolean z) {
        s61 s61Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048590, this, z) == null) && (s61Var = this.c) != null) {
            s61Var.n(z);
        }
    }

    @Override // com.baidu.tieba.n61
    public void r(String str) {
        u61 u61Var;
        AbsNadBrowserView m;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048596, this, str) == null) && (u61Var = this.a) != null && (m = u61Var.m()) != null) {
            AbsNadBrowserView.B(m, str, null, 2, null);
        }
    }

    @Override // com.baidu.tieba.n61
    public void s(View.OnLayoutChangeListener onLayoutChangeListener) {
        u61 u61Var;
        LinearLayout e;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048597, this, onLayoutChangeListener) == null) && (u61Var = this.a) != null && (e = u61Var.e()) != null) {
            e.addOnLayoutChangeListener(onLayoutChangeListener);
        }
    }

    @Override // com.baidu.tieba.n61
    public void u(p61 p61Var) {
        s61 s61Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048599, this, p61Var) == null) && (s61Var = this.c) != null) {
            s61Var.p(p61Var);
        }
    }

    @Override // com.baidu.tieba.z71, com.baidu.tieba.k91
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
            r61 r61Var = this.b;
            if (r61Var != null && (i = r61Var.i()) != null) {
                hashMap.put("url", i);
                hashMap.put("lp_real_url", i);
                intent.putExtra("url", i);
                intent.putExtra("lp_real_url", i);
            }
            r61 r61Var2 = this.b;
            if (r61Var2 != null && (h = r61Var2.h()) != null) {
                hashMap.put("sdk_script", h);
                intent.putExtra("sdk_script", h);
            }
            r61 r61Var3 = this.b;
            if (r61Var3 != null && (f = r61Var3.f()) != null) {
                hashMap.put("log_switch", f);
                intent.putExtra("log_switch", f);
            }
            r61 r61Var4 = this.b;
            if (r61Var4 != null && (c = r61Var4.c()) != null) {
                hashMap.put("ext_info", c);
                intent.putExtra("ext_info", c);
            }
            r61 r61Var5 = this.b;
            if (r61Var5 != null && (b2 = r61Var5.b()) != null) {
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

    @Override // com.baidu.tieba.n61
    public void o(ViewGroup parent) {
        ViewParent viewParent;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, parent) == null) {
            Intrinsics.checkNotNullParameter(parent, "parent");
            ViewGroup viewGroup = null;
            WebPanelBrowserContainer webPanelBrowserContainer = new WebPanelBrowserContainer(this, new a71(), null);
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

    @Override // com.baidu.tieba.n61
    public void t(int i, boolean z) {
        s61 s61Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048598, this, new Object[]{Integer.valueOf(i), Boolean.valueOf(z)}) == null) && (s61Var = this.c) != null) {
            s61Var.i(i, z);
        }
    }
}
