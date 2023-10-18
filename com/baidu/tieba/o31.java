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
import com.baidu.tieba.c11;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes7.dex */
public final class o31 implements t31, f51, e51 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public a41 a;
    public x31 b;
    public y31 c;
    public final Activity d;

    @Override // com.baidu.tieba.f51
    public boolean B() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.f51
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
                    outline.setRoundRect(rect, c11.c.a(m61.a(), 0.0f));
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
                    outline.setRoundRect(rect, c11.c.a(m61.a(), 18.0f));
                }
            }
        }
    }

    public o31(Activity activity) {
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

    @Override // com.baidu.tieba.t31
    public void e(int i) {
        a41 a41Var;
        LinearLayout e;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048581, this, i) == null) && (a41Var = this.a) != null && (e = a41Var.e()) != null && (e.getLayoutParams() instanceof FrameLayout.LayoutParams)) {
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

    @Override // com.baidu.tieba.t31
    public void o(q31 controlHelper) {
        y31 y31Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, controlHelper) == null) {
            Intrinsics.checkNotNullParameter(controlHelper, "controlHelper");
            a41 a41Var = this.a;
            if (a41Var != null) {
                y31 y31Var2 = new y31(a41Var);
                this.c = y31Var2;
                if (y31Var2 != null) {
                    y31Var2.q(this.b);
                }
                y31 y31Var3 = this.c;
                if (y31Var3 != null) {
                    y31Var3.o(controlHelper);
                }
                x31 x31Var = this.b;
                if (x31Var != null && x31Var.z() && (y31Var = this.c) != null) {
                    y31Var.k();
                }
                a41Var.n(this.c);
            }
        }
    }

    @Override // com.baidu.tieba.t31
    public void a() {
        y31 y31Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && (y31Var = this.c) != null) {
            y31Var.j();
        }
    }

    @Override // com.baidu.tieba.t31
    public ViewGroup.LayoutParams b() {
        InterceptResult invokeV;
        LinearLayout e;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            a41 a41Var = this.a;
            if (a41Var != null && (e = a41Var.e()) != null) {
                return e.getLayoutParams();
            }
            return null;
        }
        return (ViewGroup.LayoutParams) invokeV.objValue;
    }

    @Override // com.baidu.tieba.t31
    public void d() {
        a41 a41Var;
        LinearLayout e;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048580, this) == null) && (a41Var = this.a) != null && (e = a41Var.e()) != null && Build.VERSION.SDK_INT >= 21) {
            e.setOutlineProvider(new a(e));
            e.setClipToOutline(true);
        }
    }

    @Override // com.baidu.tieba.t31
    public boolean f() {
        InterceptResult invokeV;
        AbsNadBrowserView m;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            a41 a41Var = this.a;
            if (a41Var != null && (m = a41Var.m()) != null && m.d()) {
                a41 a41Var2 = this.a;
                if (a41Var2 != null) {
                    a41Var2.i();
                }
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.f51
    public Activity getActivity() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return this.d;
        }
        return (Activity) invokeV.objValue;
    }

    @Override // com.baidu.tieba.t31
    public boolean h() {
        InterceptResult invokeV;
        AbsNadBrowserView m;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            a41 a41Var = this.a;
            if (a41Var != null && (m = a41Var.m()) != null) {
                return m.y();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.t31
    public boolean m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            y31 y31Var = this.c;
            if (y31Var != null) {
                return y31Var.h();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.t31
    public void onDestroy() {
        y31 y31Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            x31 x31Var = this.b;
            if (x31Var != null && x31Var.z() && (y31Var = this.c) != null) {
                y31Var.t();
            }
            a41 a41Var = this.a;
            if (a41Var != null) {
                a41Var.onPause();
            }
            a41 a41Var2 = this.a;
            if (a41Var2 != null) {
                a41Var2.onDestroy();
            }
        }
    }

    @Override // com.baidu.tieba.e51
    public void p() {
        y31 y31Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048595, this) == null) && (y31Var = this.c) != null) {
            y31Var.g();
        }
    }

    @Override // com.baidu.tieba.t31
    public void u() {
        a41 a41Var;
        LinearLayout e;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048600, this) == null) && (a41Var = this.a) != null && (e = a41Var.e()) != null && Build.VERSION.SDK_INT >= 21) {
            e.setOutlineProvider(new b(e));
            e.setClipToOutline(true);
        }
    }

    @Override // com.baidu.tieba.t31
    public void c(View.OnLayoutChangeListener onLayoutChangeListener) {
        a41 a41Var;
        LinearLayout e;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048579, this, onLayoutChangeListener) == null) && (a41Var = this.a) != null && (e = a41Var.e()) != null) {
            e.removeOnLayoutChangeListener(onLayoutChangeListener);
        }
    }

    @Override // com.baidu.tieba.t31
    public void g(FrameLayout.LayoutParams params) {
        LinearLayout e;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, params) == null) {
            Intrinsics.checkNotNullParameter(params, "params");
            a41 a41Var = this.a;
            if (a41Var != null && (e = a41Var.e()) != null) {
                e.setLayoutParams(params);
            }
        }
    }

    @Override // com.baidu.tieba.t31
    public void i(int i) {
        a41 a41Var;
        LinearLayout e;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048587, this, i) == null) && (a41Var = this.a) != null && (e = a41Var.e()) != null) {
            ViewGroup.LayoutParams layoutParams = e.getLayoutParams();
            layoutParams.height = i;
            e.setLayoutParams(layoutParams);
        }
    }

    @Override // com.baidu.tieba.t31
    public void j(x31 x31Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, x31Var) == null) {
            this.b = x31Var;
        }
    }

    @Override // com.baidu.tieba.t31
    public void k(boolean z) {
        y31 y31Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048589, this, z) == null) && (y31Var = this.c) != null) {
            y31Var.n(z);
        }
    }

    @Override // com.baidu.tieba.t31
    public void q(String str) {
        a41 a41Var;
        AbsNadBrowserView m;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048596, this, str) == null) && (a41Var = this.a) != null && (m = a41Var.m()) != null) {
            AbsNadBrowserView.C(m, str, null, 2, null);
        }
    }

    @Override // com.baidu.tieba.t31
    public void r(View.OnLayoutChangeListener onLayoutChangeListener) {
        a41 a41Var;
        LinearLayout e;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048597, this, onLayoutChangeListener) == null) && (a41Var = this.a) != null && (e = a41Var.e()) != null) {
            e.addOnLayoutChangeListener(onLayoutChangeListener);
        }
    }

    @Override // com.baidu.tieba.t31
    public void t(v31 v31Var) {
        y31 y31Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048599, this, v31Var) == null) && (y31Var = this.c) != null) {
            y31Var.p(v31Var);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:34:0x0083, code lost:
        if (r0.putExtra("lp_org_type", r2) != null) goto L34;
     */
    @Override // com.baidu.tieba.f51
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Intent getIntent() {
        InterceptResult invokeV;
        String b2;
        String j;
        String e;
        String f;
        String i;
        String m;
        String n;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            Intent intent = new Intent();
            HashMap hashMap = new HashMap();
            x31 x31Var = this.b;
            if (x31Var != null && (n = x31Var.n()) != null) {
                hashMap.put("url", n);
                hashMap.put("lp_real_url", n);
                intent.putExtra("url", n);
                intent.putExtra("lp_real_url", n);
            }
            x31 x31Var2 = this.b;
            if (x31Var2 != null && (m = x31Var2.m()) != null) {
                hashMap.put("sdk_script", m);
                intent.putExtra("sdk_script", m);
            }
            x31 x31Var3 = this.b;
            if (x31Var3 != null && (i = x31Var3.i()) != null) {
                hashMap.put("log_switch", i);
                intent.putExtra("log_switch", i);
            }
            x31 x31Var4 = this.b;
            if (x31Var4 != null && (f = x31Var4.f()) != null) {
                hashMap.put(MigrateStatisticUtils.EXT_INFO, f);
                intent.putExtra(MigrateStatisticUtils.EXT_INFO, f);
            }
            x31 x31Var5 = this.b;
            if (x31Var5 != null && (e = x31Var5.e()) != null) {
                hashMap.put("charge_url", e);
                intent.putExtra("charge_url", e);
            }
            x31 x31Var6 = this.b;
            if (x31Var6 != null && (j = x31Var6.j()) != null) {
                hashMap.put("lp_org_type", j);
            }
            hashMap.put("lp_org_type", "pop_web");
            intent.putExtra("lp_org_type", "pop_web");
            x31 x31Var7 = this.b;
            if (x31Var7 != null && (b2 = x31Var7.b()) != null) {
                hashMap.put("ad_invoke_flag", b2);
                intent.putExtra("ad_invoke_flag", b2);
            }
            intent.putExtra("map", hashMap);
            return intent;
        }
        return (Intent) invokeV.objValue;
    }

    @Override // com.baidu.tieba.t31
    public void n(ViewGroup parent) {
        ViewParent viewParent;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, parent) == null) {
            Intrinsics.checkNotNullParameter(parent, "parent");
            ViewGroup viewGroup = null;
            WebPanelBrowserContainer webPanelBrowserContainer = new WebPanelBrowserContainer(this, new g41(), null);
            this.a = webPanelBrowserContainer;
            webPanelBrowserContainer.w0(false);
            webPanelBrowserContainer.v0(false);
            webPanelBrowserContainer.v();
            webPanelBrowserContainer.B(this);
            webPanelBrowserContainer.y();
            u();
            LinearLayout e = webPanelBrowserContainer.e();
            if (e != null) {
                e.setPadding(0, 0, 0, PanelScrollView.B);
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

    @Override // com.baidu.tieba.t31
    public void s(int i, boolean z) {
        y31 y31Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048598, this, new Object[]{Integer.valueOf(i), Boolean.valueOf(z)}) == null) && (y31Var = this.c) != null) {
            y31Var.i(i, z);
        }
    }
}
