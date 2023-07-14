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
import com.baidu.tieba.e71;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes7.dex */
public final class p91 implements u91, hb1, gb1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ba1 a;
    public y91 b;
    public z91 c;
    public final Activity d;

    @Override // com.baidu.tieba.hb1
    public boolean G() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.hb1
    public void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
        }
    }

    /* loaded from: classes7.dex */
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
                    outline.setRoundRect(rect, e71.c.a(oc1.a(), 0.0f));
                }
            }
        }
    }

    /* loaded from: classes7.dex */
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
                    outline.setRoundRect(rect, e71.c.a(oc1.a(), 18.0f));
                }
            }
        }
    }

    public p91(Activity activity) {
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

    @Override // com.baidu.tieba.u91
    public void e(int i) {
        ba1 ba1Var;
        LinearLayout g;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048581, this, i) == null) && (ba1Var = this.a) != null && (g = ba1Var.g()) != null && (g.getLayoutParams() instanceof FrameLayout.LayoutParams)) {
            ViewGroup.LayoutParams layoutParams = g.getLayoutParams();
            if (layoutParams != null) {
                FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) layoutParams;
                layoutParams2.topMargin = i;
                g.setLayoutParams(layoutParams2);
                return;
            }
            throw new NullPointerException("null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
        }
    }

    @Override // com.baidu.tieba.u91
    public void o(r91 controlHelper) {
        z91 z91Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, controlHelper) == null) {
            Intrinsics.checkNotNullParameter(controlHelper, "controlHelper");
            ba1 ba1Var = this.a;
            if (ba1Var != null) {
                z91 z91Var2 = new z91(ba1Var);
                this.c = z91Var2;
                if (z91Var2 != null) {
                    z91Var2.q(this.b);
                }
                z91 z91Var3 = this.c;
                if (z91Var3 != null) {
                    z91Var3.o(controlHelper);
                }
                y91 y91Var = this.b;
                if (y91Var != null && y91Var.w() && (z91Var = this.c) != null) {
                    z91Var.k();
                }
                ba1Var.n(this.c);
            }
        }
    }

    @Override // com.baidu.tieba.u91
    public void a() {
        z91 z91Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && (z91Var = this.c) != null) {
            z91Var.j();
        }
    }

    @Override // com.baidu.tieba.u91
    public ViewGroup.LayoutParams b() {
        InterceptResult invokeV;
        LinearLayout g;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            ba1 ba1Var = this.a;
            if (ba1Var != null && (g = ba1Var.g()) != null) {
                return g.getLayoutParams();
            }
            return null;
        }
        return (ViewGroup.LayoutParams) invokeV.objValue;
    }

    @Override // com.baidu.tieba.u91
    public void d() {
        ba1 ba1Var;
        LinearLayout g;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048580, this) == null) && (ba1Var = this.a) != null && (g = ba1Var.g()) != null && Build.VERSION.SDK_INT >= 21) {
            g.setOutlineProvider(new a(g));
            g.setClipToOutline(true);
        }
    }

    @Override // com.baidu.tieba.u91
    public boolean f() {
        InterceptResult invokeV;
        AbsNadBrowserView m;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            ba1 ba1Var = this.a;
            if (ba1Var != null && (m = ba1Var.m()) != null && m.d()) {
                ba1 ba1Var2 = this.a;
                if (ba1Var2 != null) {
                    ba1Var2.i();
                }
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.hb1
    public Activity getActivity() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return this.d;
        }
        return (Activity) invokeV.objValue;
    }

    @Override // com.baidu.tieba.u91
    public boolean h() {
        InterceptResult invokeV;
        AbsNadBrowserView m;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            ba1 ba1Var = this.a;
            if (ba1Var != null && (m = ba1Var.m()) != null) {
                return m.x();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.u91
    public boolean m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            z91 z91Var = this.c;
            if (z91Var != null) {
                return z91Var.h();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.u91
    public void onDestroy() {
        z91 z91Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            y91 y91Var = this.b;
            if (y91Var != null && y91Var.w() && (z91Var = this.c) != null) {
                z91Var.t();
            }
            ba1 ba1Var = this.a;
            if (ba1Var != null) {
                ba1Var.onPause();
            }
            ba1 ba1Var2 = this.a;
            if (ba1Var2 != null) {
                ba1Var2.onDestroy();
            }
        }
    }

    @Override // com.baidu.tieba.gb1
    public void p() {
        z91 z91Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048595, this) == null) && (z91Var = this.c) != null) {
            z91Var.g();
        }
    }

    @Override // com.baidu.tieba.u91
    public void u() {
        ba1 ba1Var;
        LinearLayout g;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048600, this) == null) && (ba1Var = this.a) != null && (g = ba1Var.g()) != null && Build.VERSION.SDK_INT >= 21) {
            g.setOutlineProvider(new b(g));
            g.setClipToOutline(true);
        }
    }

    @Override // com.baidu.tieba.u91
    public void c(View.OnLayoutChangeListener onLayoutChangeListener) {
        ba1 ba1Var;
        LinearLayout g;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048579, this, onLayoutChangeListener) == null) && (ba1Var = this.a) != null && (g = ba1Var.g()) != null) {
            g.removeOnLayoutChangeListener(onLayoutChangeListener);
        }
    }

    @Override // com.baidu.tieba.u91
    public void g(FrameLayout.LayoutParams params) {
        LinearLayout g;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, params) == null) {
            Intrinsics.checkNotNullParameter(params, "params");
            ba1 ba1Var = this.a;
            if (ba1Var != null && (g = ba1Var.g()) != null) {
                g.setLayoutParams(params);
            }
        }
    }

    @Override // com.baidu.tieba.u91
    public void i(int i) {
        ba1 ba1Var;
        LinearLayout g;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048587, this, i) == null) && (ba1Var = this.a) != null && (g = ba1Var.g()) != null) {
            ViewGroup.LayoutParams layoutParams = g.getLayoutParams();
            layoutParams.height = i;
            g.setLayoutParams(layoutParams);
        }
    }

    @Override // com.baidu.tieba.u91
    public void j(y91 y91Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, y91Var) == null) {
            this.b = y91Var;
        }
    }

    @Override // com.baidu.tieba.u91
    public void k(boolean z) {
        z91 z91Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048589, this, z) == null) && (z91Var = this.c) != null) {
            z91Var.n(z);
        }
    }

    @Override // com.baidu.tieba.u91
    public void q(String str) {
        ba1 ba1Var;
        AbsNadBrowserView m;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048596, this, str) == null) && (ba1Var = this.a) != null && (m = ba1Var.m()) != null) {
            AbsNadBrowserView.B(m, str, null, 2, null);
        }
    }

    @Override // com.baidu.tieba.u91
    public void r(View.OnLayoutChangeListener onLayoutChangeListener) {
        ba1 ba1Var;
        LinearLayout g;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048597, this, onLayoutChangeListener) == null) && (ba1Var = this.a) != null && (g = ba1Var.g()) != null) {
            g.addOnLayoutChangeListener(onLayoutChangeListener);
        }
    }

    @Override // com.baidu.tieba.u91
    public void t(w91 w91Var) {
        z91 z91Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048599, this, w91Var) == null) && (z91Var = this.c) != null) {
            z91Var.p(w91Var);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:34:0x0083, code lost:
        if (r0.putExtra("lp_org_type", r2) != null) goto L34;
     */
    @Override // com.baidu.tieba.hb1
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Intent getIntent() {
        InterceptResult invokeV;
        String b2;
        String h;
        String c;
        String d;
        String g;
        String j;
        String k;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            Intent intent = new Intent();
            HashMap hashMap = new HashMap();
            y91 y91Var = this.b;
            if (y91Var != null && (k = y91Var.k()) != null) {
                hashMap.put("url", k);
                hashMap.put("lp_real_url", k);
                intent.putExtra("url", k);
                intent.putExtra("lp_real_url", k);
            }
            y91 y91Var2 = this.b;
            if (y91Var2 != null && (j = y91Var2.j()) != null) {
                hashMap.put("sdk_script", j);
                intent.putExtra("sdk_script", j);
            }
            y91 y91Var3 = this.b;
            if (y91Var3 != null && (g = y91Var3.g()) != null) {
                hashMap.put("log_switch", g);
                intent.putExtra("log_switch", g);
            }
            y91 y91Var4 = this.b;
            if (y91Var4 != null && (d = y91Var4.d()) != null) {
                hashMap.put(MigrateStatisticUtils.EXT_INFO, d);
                intent.putExtra(MigrateStatisticUtils.EXT_INFO, d);
            }
            y91 y91Var5 = this.b;
            if (y91Var5 != null && (c = y91Var5.c()) != null) {
                hashMap.put("charge_url", c);
                intent.putExtra("charge_url", c);
            }
            y91 y91Var6 = this.b;
            if (y91Var6 != null && (h = y91Var6.h()) != null) {
                hashMap.put("lp_org_type", h);
            }
            hashMap.put("lp_org_type", "pop_web");
            intent.putExtra("lp_org_type", "pop_web");
            y91 y91Var7 = this.b;
            if (y91Var7 != null && (b2 = y91Var7.b()) != null) {
                hashMap.put("ad_invoke_flag", b2);
                intent.putExtra("ad_invoke_flag", b2);
            }
            intent.putExtra("map", hashMap);
            return intent;
        }
        return (Intent) invokeV.objValue;
    }

    @Override // com.baidu.tieba.u91
    public void n(ViewGroup parent) {
        ViewParent viewParent;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, parent) == null) {
            Intrinsics.checkNotNullParameter(parent, "parent");
            ViewGroup viewGroup = null;
            WebPanelBrowserContainer webPanelBrowserContainer = new WebPanelBrowserContainer(this, new ia1(), null);
            this.a = webPanelBrowserContainer;
            webPanelBrowserContainer.u0(false);
            webPanelBrowserContainer.s0(false);
            webPanelBrowserContainer.u();
            webPanelBrowserContainer.z(this);
            webPanelBrowserContainer.w();
            u();
            LinearLayout g = webPanelBrowserContainer.g();
            if (g != null) {
                g.setPadding(0, 0, 0, PanelScrollView.B);
            }
            ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-1, -1);
            FrameLayout j = webPanelBrowserContainer.j();
            if (j != null) {
                viewParent = j.getParent();
            } else {
                viewParent = null;
            }
            if (viewParent instanceof ViewGroup) {
                viewGroup = viewParent;
            }
            ViewGroup viewGroup2 = viewGroup;
            if (viewGroup2 != null) {
                viewGroup2.removeView(j);
            }
            parent.addView(j, layoutParams);
        }
    }

    @Override // com.baidu.tieba.u91
    public void s(int i, boolean z) {
        z91 z91Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048598, this, new Object[]{Integer.valueOf(i), Boolean.valueOf(z)}) == null) && (z91Var = this.c) != null) {
            z91Var.i(i, z);
        }
    }
}
