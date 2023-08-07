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
import com.baidu.tieba.h61;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes7.dex */
public final class s81 implements x81, ka1, ja1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public e91 a;
    public b91 b;
    public c91 c;
    public final Activity d;

    @Override // com.baidu.tieba.ka1
    public boolean F() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.ka1
    public void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
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
                    outline.setRoundRect(rect, h61.c.a(rb1.a(), 0.0f));
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
                    outline.setRoundRect(rect, h61.c.a(rb1.a(), 18.0f));
                }
            }
        }
    }

    public s81(Activity activity) {
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

    @Override // com.baidu.tieba.x81
    public void e(int i) {
        e91 e91Var;
        LinearLayout g;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048581, this, i) == null) && (e91Var = this.a) != null && (g = e91Var.g()) != null && (g.getLayoutParams() instanceof FrameLayout.LayoutParams)) {
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

    @Override // com.baidu.tieba.x81
    public void o(u81 controlHelper) {
        c91 c91Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, controlHelper) == null) {
            Intrinsics.checkNotNullParameter(controlHelper, "controlHelper");
            e91 e91Var = this.a;
            if (e91Var != null) {
                c91 c91Var2 = new c91(e91Var);
                this.c = c91Var2;
                if (c91Var2 != null) {
                    c91Var2.q(this.b);
                }
                c91 c91Var3 = this.c;
                if (c91Var3 != null) {
                    c91Var3.o(controlHelper);
                }
                b91 b91Var = this.b;
                if (b91Var != null && b91Var.w() && (c91Var = this.c) != null) {
                    c91Var.k();
                }
                e91Var.n(this.c);
            }
        }
    }

    @Override // com.baidu.tieba.x81
    public void a() {
        c91 c91Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && (c91Var = this.c) != null) {
            c91Var.j();
        }
    }

    @Override // com.baidu.tieba.x81
    public ViewGroup.LayoutParams b() {
        InterceptResult invokeV;
        LinearLayout g;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            e91 e91Var = this.a;
            if (e91Var != null && (g = e91Var.g()) != null) {
                return g.getLayoutParams();
            }
            return null;
        }
        return (ViewGroup.LayoutParams) invokeV.objValue;
    }

    @Override // com.baidu.tieba.x81
    public void d() {
        e91 e91Var;
        LinearLayout g;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048580, this) == null) && (e91Var = this.a) != null && (g = e91Var.g()) != null && Build.VERSION.SDK_INT >= 21) {
            g.setOutlineProvider(new a(g));
            g.setClipToOutline(true);
        }
    }

    @Override // com.baidu.tieba.x81
    public boolean f() {
        InterceptResult invokeV;
        AbsNadBrowserView m;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            e91 e91Var = this.a;
            if (e91Var != null && (m = e91Var.m()) != null && m.c()) {
                e91 e91Var2 = this.a;
                if (e91Var2 != null) {
                    e91Var2.i();
                }
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.ka1
    public Activity getActivity() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return this.d;
        }
        return (Activity) invokeV.objValue;
    }

    @Override // com.baidu.tieba.x81
    public boolean h() {
        InterceptResult invokeV;
        AbsNadBrowserView m;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            e91 e91Var = this.a;
            if (e91Var != null && (m = e91Var.m()) != null) {
                return m.x();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.x81
    public boolean l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            c91 c91Var = this.c;
            if (c91Var != null) {
                return c91Var.h();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.x81
    public void onDestroy() {
        c91 c91Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            b91 b91Var = this.b;
            if (b91Var != null && b91Var.w() && (c91Var = this.c) != null) {
                c91Var.t();
            }
            e91 e91Var = this.a;
            if (e91Var != null) {
                e91Var.onPause();
            }
            e91 e91Var2 = this.a;
            if (e91Var2 != null) {
                e91Var2.onDestroy();
            }
        }
    }

    @Override // com.baidu.tieba.ja1
    public void p() {
        c91 c91Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048595, this) == null) && (c91Var = this.c) != null) {
            c91Var.g();
        }
    }

    @Override // com.baidu.tieba.x81
    public void u() {
        e91 e91Var;
        LinearLayout g;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048600, this) == null) && (e91Var = this.a) != null && (g = e91Var.g()) != null && Build.VERSION.SDK_INT >= 21) {
            g.setOutlineProvider(new b(g));
            g.setClipToOutline(true);
        }
    }

    @Override // com.baidu.tieba.x81
    public void c(View.OnLayoutChangeListener onLayoutChangeListener) {
        e91 e91Var;
        LinearLayout g;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048579, this, onLayoutChangeListener) == null) && (e91Var = this.a) != null && (g = e91Var.g()) != null) {
            g.removeOnLayoutChangeListener(onLayoutChangeListener);
        }
    }

    @Override // com.baidu.tieba.x81
    public void g(FrameLayout.LayoutParams params) {
        LinearLayout g;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, params) == null) {
            Intrinsics.checkNotNullParameter(params, "params");
            e91 e91Var = this.a;
            if (e91Var != null && (g = e91Var.g()) != null) {
                g.setLayoutParams(params);
            }
        }
    }

    @Override // com.baidu.tieba.x81
    public void i(int i) {
        e91 e91Var;
        LinearLayout g;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048587, this, i) == null) && (e91Var = this.a) != null && (g = e91Var.g()) != null) {
            ViewGroup.LayoutParams layoutParams = g.getLayoutParams();
            layoutParams.height = i;
            g.setLayoutParams(layoutParams);
        }
    }

    @Override // com.baidu.tieba.x81
    public void j(b91 b91Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, b91Var) == null) {
            this.b = b91Var;
        }
    }

    @Override // com.baidu.tieba.x81
    public void k(boolean z) {
        c91 c91Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048589, this, z) == null) && (c91Var = this.c) != null) {
            c91Var.n(z);
        }
    }

    @Override // com.baidu.tieba.x81
    public void q(String str) {
        e91 e91Var;
        AbsNadBrowserView m;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048596, this, str) == null) && (e91Var = this.a) != null && (m = e91Var.m()) != null) {
            AbsNadBrowserView.B(m, str, null, 2, null);
        }
    }

    @Override // com.baidu.tieba.x81
    public void r(View.OnLayoutChangeListener onLayoutChangeListener) {
        e91 e91Var;
        LinearLayout g;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048597, this, onLayoutChangeListener) == null) && (e91Var = this.a) != null && (g = e91Var.g()) != null) {
            g.addOnLayoutChangeListener(onLayoutChangeListener);
        }
    }

    @Override // com.baidu.tieba.x81
    public void t(z81 z81Var) {
        c91 c91Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048599, this, z81Var) == null) && (c91Var = this.c) != null) {
            c91Var.p(z81Var);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:34:0x0083, code lost:
        if (r0.putExtra("lp_org_type", r2) != null) goto L34;
     */
    @Override // com.baidu.tieba.ka1
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
            b91 b91Var = this.b;
            if (b91Var != null && (k = b91Var.k()) != null) {
                hashMap.put("url", k);
                hashMap.put("lp_real_url", k);
                intent.putExtra("url", k);
                intent.putExtra("lp_real_url", k);
            }
            b91 b91Var2 = this.b;
            if (b91Var2 != null && (j = b91Var2.j()) != null) {
                hashMap.put("sdk_script", j);
                intent.putExtra("sdk_script", j);
            }
            b91 b91Var3 = this.b;
            if (b91Var3 != null && (g = b91Var3.g()) != null) {
                hashMap.put("log_switch", g);
                intent.putExtra("log_switch", g);
            }
            b91 b91Var4 = this.b;
            if (b91Var4 != null && (d = b91Var4.d()) != null) {
                hashMap.put(MigrateStatisticUtils.EXT_INFO, d);
                intent.putExtra(MigrateStatisticUtils.EXT_INFO, d);
            }
            b91 b91Var5 = this.b;
            if (b91Var5 != null && (c = b91Var5.c()) != null) {
                hashMap.put("charge_url", c);
                intent.putExtra("charge_url", c);
            }
            b91 b91Var6 = this.b;
            if (b91Var6 != null && (h = b91Var6.h()) != null) {
                hashMap.put("lp_org_type", h);
            }
            hashMap.put("lp_org_type", "pop_web");
            intent.putExtra("lp_org_type", "pop_web");
            b91 b91Var7 = this.b;
            if (b91Var7 != null && (b2 = b91Var7.b()) != null) {
                hashMap.put("ad_invoke_flag", b2);
                intent.putExtra("ad_invoke_flag", b2);
            }
            intent.putExtra("map", hashMap);
            return intent;
        }
        return (Intent) invokeV.objValue;
    }

    @Override // com.baidu.tieba.x81
    public void n(ViewGroup parent) {
        ViewParent viewParent;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, parent) == null) {
            Intrinsics.checkNotNullParameter(parent, "parent");
            ViewGroup viewGroup = null;
            WebPanelBrowserContainer webPanelBrowserContainer = new WebPanelBrowserContainer(this, new l91(), null);
            this.a = webPanelBrowserContainer;
            webPanelBrowserContainer.u0(false);
            webPanelBrowserContainer.t0(false);
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

    @Override // com.baidu.tieba.x81
    public void s(int i, boolean z) {
        c91 c91Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048598, this, new Object[]{Integer.valueOf(i), Boolean.valueOf(z)}) == null) && (c91Var = this.c) != null) {
            c91Var.i(i, z);
        }
    }
}
