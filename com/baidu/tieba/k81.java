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
import com.baidu.tieba.c61;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes6.dex */
public final class k81 implements o81, aa1, z91 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public v81 a;
    public s81 b;
    public t81 c;
    public final Activity d;

    @Override // com.baidu.tieba.aa1, com.baidu.tieba.lb1
    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
        }
    }

    @Override // com.baidu.tieba.aa1, com.baidu.tieba.lb1
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
                    outline.setRoundRect(rect, c61.c.a(sc1.a(), 0.0f));
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
                    outline.setRoundRect(rect, c61.c.a(sc1.a(), 18.0f));
                }
            }
        }
    }

    public k81(Activity activity) {
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

    @Override // com.baidu.tieba.o81
    public void g(int i) {
        v81 v81Var;
        LinearLayout e;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048582, this, i) == null) && (v81Var = this.a) != null && (e = v81Var.e()) != null && (e.getLayoutParams() instanceof FrameLayout.LayoutParams)) {
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

    @Override // com.baidu.tieba.o81
    public void p(m81 controlHelper) {
        t81 t81Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, controlHelper) == null) {
            Intrinsics.checkNotNullParameter(controlHelper, "controlHelper");
            v81 v81Var = this.a;
            if (v81Var != null) {
                t81 t81Var2 = new t81(v81Var);
                this.c = t81Var2;
                if (t81Var2 != null) {
                    t81Var2.q(this.b);
                }
                t81 t81Var3 = this.c;
                if (t81Var3 != null) {
                    t81Var3.o(controlHelper);
                }
                s81 s81Var = this.b;
                if (s81Var != null && s81Var.t() && (t81Var = this.c) != null) {
                    t81Var.k();
                }
                v81Var.n(this.c);
            }
        }
    }

    @Override // com.baidu.tieba.o81
    public void a() {
        t81 t81Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && (t81Var = this.c) != null) {
            t81Var.j();
        }
    }

    @Override // com.baidu.tieba.o81
    public ViewGroup.LayoutParams b() {
        InterceptResult invokeV;
        LinearLayout e;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            v81 v81Var = this.a;
            if (v81Var != null && (e = v81Var.e()) != null) {
                return e.getLayoutParams();
            }
            return null;
        }
        return (ViewGroup.LayoutParams) invokeV.objValue;
    }

    @Override // com.baidu.tieba.o81
    public void e() {
        v81 v81Var;
        LinearLayout e;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048580, this) == null) && (v81Var = this.a) != null && (e = v81Var.e()) != null && Build.VERSION.SDK_INT >= 21) {
            e.setOutlineProvider(new a(e));
            e.setClipToOutline(true);
        }
    }

    @Override // com.baidu.tieba.aa1, com.baidu.tieba.lb1
    public Activity getActivity() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.d;
        }
        return (Activity) invokeV.objValue;
    }

    @Override // com.baidu.tieba.o81
    public boolean h() {
        InterceptResult invokeV;
        AbsNadBrowserView m;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            v81 v81Var = this.a;
            if (v81Var != null && (m = v81Var.m()) != null && m.d()) {
                v81 v81Var2 = this.a;
                if (v81Var2 != null) {
                    v81Var2.g();
                }
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.o81
    public boolean j() {
        InterceptResult invokeV;
        AbsNadBrowserView m;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            v81 v81Var = this.a;
            if (v81Var != null && (m = v81Var.m()) != null) {
                return m.w();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.o81
    public boolean n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            t81 t81Var = this.c;
            if (t81Var != null) {
                return t81Var.h();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.o81
    public void onDestroy() {
        t81 t81Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            s81 s81Var = this.b;
            if (s81Var != null && s81Var.t() && (t81Var = this.c) != null) {
                t81Var.t();
            }
            v81 v81Var = this.a;
            if (v81Var != null) {
                v81Var.onPause();
            }
            v81 v81Var2 = this.a;
            if (v81Var2 != null) {
                v81Var2.onDestroy();
            }
        }
    }

    @Override // com.baidu.tieba.z91
    public void q() {
        t81 t81Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048595, this) == null) && (t81Var = this.c) != null) {
            t81Var.g();
        }
    }

    @Override // com.baidu.tieba.o81
    public void v() {
        v81 v81Var;
        LinearLayout e;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048600, this) == null) && (v81Var = this.a) != null && (e = v81Var.e()) != null && Build.VERSION.SDK_INT >= 21) {
            e.setOutlineProvider(new b(e));
            e.setClipToOutline(true);
        }
    }

    @Override // com.baidu.tieba.o81
    public void c(View.OnLayoutChangeListener onLayoutChangeListener) {
        v81 v81Var;
        LinearLayout e;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, onLayoutChangeListener) == null) && (v81Var = this.a) != null && (e = v81Var.e()) != null) {
            e.removeOnLayoutChangeListener(onLayoutChangeListener);
        }
    }

    @Override // com.baidu.tieba.o81
    public void i(FrameLayout.LayoutParams params) {
        LinearLayout e;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, params) == null) {
            Intrinsics.checkNotNullParameter(params, "params");
            v81 v81Var = this.a;
            if (v81Var != null && (e = v81Var.e()) != null) {
                e.setLayoutParams(params);
            }
        }
    }

    @Override // com.baidu.tieba.o81
    public void k(int i) {
        v81 v81Var;
        LinearLayout e;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048588, this, i) == null) && (v81Var = this.a) != null && (e = v81Var.e()) != null) {
            ViewGroup.LayoutParams layoutParams = e.getLayoutParams();
            layoutParams.height = i;
            e.setLayoutParams(layoutParams);
        }
    }

    @Override // com.baidu.tieba.o81
    public void l(s81 s81Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, s81Var) == null) {
            this.b = s81Var;
        }
    }

    @Override // com.baidu.tieba.o81
    public void m(boolean z) {
        t81 t81Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048590, this, z) == null) && (t81Var = this.c) != null) {
            t81Var.n(z);
        }
    }

    @Override // com.baidu.tieba.o81
    public void r(String str) {
        v81 v81Var;
        AbsNadBrowserView m;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048596, this, str) == null) && (v81Var = this.a) != null && (m = v81Var.m()) != null) {
            AbsNadBrowserView.B(m, str, null, 2, null);
        }
    }

    @Override // com.baidu.tieba.o81
    public void s(View.OnLayoutChangeListener onLayoutChangeListener) {
        v81 v81Var;
        LinearLayout e;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048597, this, onLayoutChangeListener) == null) && (v81Var = this.a) != null && (e = v81Var.e()) != null) {
            e.addOnLayoutChangeListener(onLayoutChangeListener);
        }
    }

    @Override // com.baidu.tieba.o81
    public void u(q81 q81Var) {
        t81 t81Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048599, this, q81Var) == null) && (t81Var = this.c) != null) {
            t81Var.p(q81Var);
        }
    }

    @Override // com.baidu.tieba.aa1, com.baidu.tieba.lb1
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
            s81 s81Var = this.b;
            if (s81Var != null && (i = s81Var.i()) != null) {
                hashMap.put("url", i);
                hashMap.put("lp_real_url", i);
                intent.putExtra("url", i);
                intent.putExtra("lp_real_url", i);
            }
            s81 s81Var2 = this.b;
            if (s81Var2 != null && (h = s81Var2.h()) != null) {
                hashMap.put("sdk_script", h);
                intent.putExtra("sdk_script", h);
            }
            s81 s81Var3 = this.b;
            if (s81Var3 != null && (f = s81Var3.f()) != null) {
                hashMap.put("log_switch", f);
                intent.putExtra("log_switch", f);
            }
            s81 s81Var4 = this.b;
            if (s81Var4 != null && (c = s81Var4.c()) != null) {
                hashMap.put(MigrateStatisticUtils.EXT_INFO, c);
                intent.putExtra(MigrateStatisticUtils.EXT_INFO, c);
            }
            s81 s81Var5 = this.b;
            if (s81Var5 != null && (b2 = s81Var5.b()) != null) {
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

    @Override // com.baidu.tieba.o81
    public void o(ViewGroup parent) {
        ViewParent viewParent;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, parent) == null) {
            Intrinsics.checkNotNullParameter(parent, "parent");
            ViewGroup viewGroup = null;
            WebPanelBrowserContainer webPanelBrowserContainer = new WebPanelBrowserContainer(this, new b91(), null);
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

    @Override // com.baidu.tieba.o81
    public void t(int i, boolean z) {
        t81 t81Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048598, this, new Object[]{Integer.valueOf(i), Boolean.valueOf(z)}) == null) && (t81Var = this.c) != null) {
            t81Var.i(i, z);
        }
    }
}
