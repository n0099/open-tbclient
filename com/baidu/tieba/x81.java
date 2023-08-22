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
import com.baidu.tieba.m61;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes8.dex */
public final class x81 implements c91, pa1, oa1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public j91 a;
    public g91 b;
    public h91 c;
    public final Activity d;

    @Override // com.baidu.tieba.pa1
    public boolean G() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.pa1
    public void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
        }
    }

    /* loaded from: classes8.dex */
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
                    outline.setRoundRect(rect, m61.c.a(wb1.a(), 0.0f));
                }
            }
        }
    }

    /* loaded from: classes8.dex */
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
                    outline.setRoundRect(rect, m61.c.a(wb1.a(), 18.0f));
                }
            }
        }
    }

    public x81(Activity activity) {
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

    @Override // com.baidu.tieba.c91
    public void e(int i) {
        j91 j91Var;
        LinearLayout g;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048581, this, i) == null) && (j91Var = this.a) != null && (g = j91Var.g()) != null && (g.getLayoutParams() instanceof FrameLayout.LayoutParams)) {
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

    @Override // com.baidu.tieba.c91
    public void o(z81 controlHelper) {
        h91 h91Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, controlHelper) == null) {
            Intrinsics.checkNotNullParameter(controlHelper, "controlHelper");
            j91 j91Var = this.a;
            if (j91Var != null) {
                h91 h91Var2 = new h91(j91Var);
                this.c = h91Var2;
                if (h91Var2 != null) {
                    h91Var2.q(this.b);
                }
                h91 h91Var3 = this.c;
                if (h91Var3 != null) {
                    h91Var3.o(controlHelper);
                }
                g91 g91Var = this.b;
                if (g91Var != null && g91Var.w() && (h91Var = this.c) != null) {
                    h91Var.k();
                }
                j91Var.n(this.c);
            }
        }
    }

    @Override // com.baidu.tieba.c91
    public void a() {
        h91 h91Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && (h91Var = this.c) != null) {
            h91Var.j();
        }
    }

    @Override // com.baidu.tieba.c91
    public ViewGroup.LayoutParams b() {
        InterceptResult invokeV;
        LinearLayout g;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            j91 j91Var = this.a;
            if (j91Var != null && (g = j91Var.g()) != null) {
                return g.getLayoutParams();
            }
            return null;
        }
        return (ViewGroup.LayoutParams) invokeV.objValue;
    }

    @Override // com.baidu.tieba.c91
    public void d() {
        j91 j91Var;
        LinearLayout g;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048580, this) == null) && (j91Var = this.a) != null && (g = j91Var.g()) != null && Build.VERSION.SDK_INT >= 21) {
            g.setOutlineProvider(new a(g));
            g.setClipToOutline(true);
        }
    }

    @Override // com.baidu.tieba.c91
    public boolean f() {
        InterceptResult invokeV;
        AbsNadBrowserView m;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            j91 j91Var = this.a;
            if (j91Var != null && (m = j91Var.m()) != null && m.d()) {
                j91 j91Var2 = this.a;
                if (j91Var2 != null) {
                    j91Var2.i();
                }
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.pa1
    public Activity getActivity() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return this.d;
        }
        return (Activity) invokeV.objValue;
    }

    @Override // com.baidu.tieba.c91
    public boolean h() {
        InterceptResult invokeV;
        AbsNadBrowserView m;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            j91 j91Var = this.a;
            if (j91Var != null && (m = j91Var.m()) != null) {
                return m.x();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.c91
    public boolean l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            h91 h91Var = this.c;
            if (h91Var != null) {
                return h91Var.h();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.c91
    public void onDestroy() {
        h91 h91Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            g91 g91Var = this.b;
            if (g91Var != null && g91Var.w() && (h91Var = this.c) != null) {
                h91Var.t();
            }
            j91 j91Var = this.a;
            if (j91Var != null) {
                j91Var.onPause();
            }
            j91 j91Var2 = this.a;
            if (j91Var2 != null) {
                j91Var2.onDestroy();
            }
        }
    }

    @Override // com.baidu.tieba.oa1
    public void p() {
        h91 h91Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048595, this) == null) && (h91Var = this.c) != null) {
            h91Var.g();
        }
    }

    @Override // com.baidu.tieba.c91
    public void u() {
        j91 j91Var;
        LinearLayout g;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048600, this) == null) && (j91Var = this.a) != null && (g = j91Var.g()) != null && Build.VERSION.SDK_INT >= 21) {
            g.setOutlineProvider(new b(g));
            g.setClipToOutline(true);
        }
    }

    @Override // com.baidu.tieba.c91
    public void c(View.OnLayoutChangeListener onLayoutChangeListener) {
        j91 j91Var;
        LinearLayout g;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048579, this, onLayoutChangeListener) == null) && (j91Var = this.a) != null && (g = j91Var.g()) != null) {
            g.removeOnLayoutChangeListener(onLayoutChangeListener);
        }
    }

    @Override // com.baidu.tieba.c91
    public void g(FrameLayout.LayoutParams params) {
        LinearLayout g;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, params) == null) {
            Intrinsics.checkNotNullParameter(params, "params");
            j91 j91Var = this.a;
            if (j91Var != null && (g = j91Var.g()) != null) {
                g.setLayoutParams(params);
            }
        }
    }

    @Override // com.baidu.tieba.c91
    public void i(int i) {
        j91 j91Var;
        LinearLayout g;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048587, this, i) == null) && (j91Var = this.a) != null && (g = j91Var.g()) != null) {
            ViewGroup.LayoutParams layoutParams = g.getLayoutParams();
            layoutParams.height = i;
            g.setLayoutParams(layoutParams);
        }
    }

    @Override // com.baidu.tieba.c91
    public void j(g91 g91Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, g91Var) == null) {
            this.b = g91Var;
        }
    }

    @Override // com.baidu.tieba.c91
    public void k(boolean z) {
        h91 h91Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048589, this, z) == null) && (h91Var = this.c) != null) {
            h91Var.n(z);
        }
    }

    @Override // com.baidu.tieba.c91
    public void q(String str) {
        j91 j91Var;
        AbsNadBrowserView m;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048596, this, str) == null) && (j91Var = this.a) != null && (m = j91Var.m()) != null) {
            AbsNadBrowserView.C(m, str, null, 2, null);
        }
    }

    @Override // com.baidu.tieba.c91
    public void r(View.OnLayoutChangeListener onLayoutChangeListener) {
        j91 j91Var;
        LinearLayout g;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048597, this, onLayoutChangeListener) == null) && (j91Var = this.a) != null && (g = j91Var.g()) != null) {
            g.addOnLayoutChangeListener(onLayoutChangeListener);
        }
    }

    @Override // com.baidu.tieba.c91
    public void t(e91 e91Var) {
        h91 h91Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048599, this, e91Var) == null) && (h91Var = this.c) != null) {
            h91Var.p(e91Var);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:34:0x0083, code lost:
        if (r0.putExtra("lp_org_type", r2) != null) goto L34;
     */
    @Override // com.baidu.tieba.pa1
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
            g91 g91Var = this.b;
            if (g91Var != null && (k = g91Var.k()) != null) {
                hashMap.put("url", k);
                hashMap.put("lp_real_url", k);
                intent.putExtra("url", k);
                intent.putExtra("lp_real_url", k);
            }
            g91 g91Var2 = this.b;
            if (g91Var2 != null && (j = g91Var2.j()) != null) {
                hashMap.put("sdk_script", j);
                intent.putExtra("sdk_script", j);
            }
            g91 g91Var3 = this.b;
            if (g91Var3 != null && (g = g91Var3.g()) != null) {
                hashMap.put("log_switch", g);
                intent.putExtra("log_switch", g);
            }
            g91 g91Var4 = this.b;
            if (g91Var4 != null && (d = g91Var4.d()) != null) {
                hashMap.put(MigrateStatisticUtils.EXT_INFO, d);
                intent.putExtra(MigrateStatisticUtils.EXT_INFO, d);
            }
            g91 g91Var5 = this.b;
            if (g91Var5 != null && (c = g91Var5.c()) != null) {
                hashMap.put("charge_url", c);
                intent.putExtra("charge_url", c);
            }
            g91 g91Var6 = this.b;
            if (g91Var6 != null && (h = g91Var6.h()) != null) {
                hashMap.put("lp_org_type", h);
            }
            hashMap.put("lp_org_type", "pop_web");
            intent.putExtra("lp_org_type", "pop_web");
            g91 g91Var7 = this.b;
            if (g91Var7 != null && (b2 = g91Var7.b()) != null) {
                hashMap.put("ad_invoke_flag", b2);
                intent.putExtra("ad_invoke_flag", b2);
            }
            intent.putExtra("map", hashMap);
            return intent;
        }
        return (Intent) invokeV.objValue;
    }

    @Override // com.baidu.tieba.c91
    public void n(ViewGroup parent) {
        ViewParent viewParent;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, parent) == null) {
            Intrinsics.checkNotNullParameter(parent, "parent");
            ViewGroup viewGroup = null;
            WebPanelBrowserContainer webPanelBrowserContainer = new WebPanelBrowserContainer(this, new q91(), null);
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

    @Override // com.baidu.tieba.c91
    public void s(int i, boolean z) {
        h91 h91Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048598, this, new Object[]{Integer.valueOf(i), Boolean.valueOf(z)}) == null) && (h91Var = this.c) != null) {
            h91Var.i(i, z);
        }
    }
}
