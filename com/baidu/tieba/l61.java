package com.baidu.tieba;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.webkit.WebView;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nadcore.net.util.NetUtil;
import com.baidu.nadcore.webview.container.BaseNativeBrowserContainer;
import com.baidu.searchbox.perfframe.ioc.Constant;
import com.baidu.tbadk.core.atomData.LegoListActivityConfig;
import com.baidu.tieba.c51;
import com.baidu.tieba.f61;
import com.baidu.tieba.j61;
import com.baidu.tieba.k61;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class l61 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    @NonNull
    public BaseNativeBrowserContainer a;
    public WebView b;
    public j61 c;
    public g61 d;
    public final e61 e;
    public p51 f;
    public boolean g;
    public ViewTreeObserver.OnGlobalLayoutListener h;
    public View.OnLayoutChangeListener i;
    public boolean j;
    public final Object k;
    public long l;
    public int m;
    public m61 n;
    public final o61 o;

    public void E() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
        }
    }

    public void y(WebView webView, String str, Bitmap bitmap) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048603, this, webView, str, bitmap) == null) {
        }
    }

    /* loaded from: classes4.dex */
    public class d implements k61.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Activity a;
        public final /* synthetic */ l61 b;

        /* loaded from: classes4.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ d a;

            public a(d dVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {dVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = dVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    if (this.a.b.b.canGoBack()) {
                        this.a.b.b.goBack();
                    } else {
                        this.a.a.finish();
                    }
                }
            }
        }

        public d(l61 l61Var, Activity activity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {l61Var, activity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = l61Var;
            this.a = activity;
        }

        @Override // com.baidu.tieba.k61.a
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.b.b.post(new a(this));
            }
        }
    }

    /* loaded from: classes4.dex */
    public class a implements o61 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ l61 a;

        public a(l61 l61Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {l61Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = l61Var;
        }

        @Override // com.baidu.tieba.o61
        public void loadUrl(String str, Map<String, String> map) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLL(1048576, this, str, map) == null) && this.a.b != null) {
                this.a.b.loadUrl(str, map);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements c51.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ l61 a;

        public b(l61 l61Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {l61Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = l61Var;
        }

        @Override // com.baidu.tieba.c51.b
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                this.a.a.n(str);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c implements f61.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ WebView a;
        public final /* synthetic */ l61 b;

        public c(l61 l61Var, WebView webView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {l61Var, webView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = l61Var;
            this.a = webView;
        }

        @Override // com.baidu.tieba.f61.a
        public String a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                Rect rect = new Rect();
                this.a.getWindowVisibleDisplayFrame(rect);
                int i = this.b.a.getResources().getDisplayMetrics().heightPixels - rect.bottom;
                if (i < 0) {
                    i = 0;
                }
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("visibleHeight", this.a.getHeight() - i);
                    jSONObject.put("keyboardHeight", i);
                    jSONObject.put("webviewHeight", this.a.getHeight());
                    jSONObject.put("videoHeight", 0);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                return jSONObject.toString();
            }
            return (String) invokeV.objValue;
        }
    }

    /* loaded from: classes4.dex */
    public class e implements View.OnLayoutChangeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int a;
        public final /* synthetic */ l61 b;

        public e(l61 l61Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {l61Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = l61Var;
        }

        @Override // android.view.View.OnLayoutChangeListener
        public void onLayoutChange(View view2, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view2, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6), Integer.valueOf(i7), Integer.valueOf(i8)}) == null) {
                Rect rect = new Rect();
                view2.getWindowVisibleDisplayFrame(rect);
                int i9 = rect.bottom;
                int i10 = this.a;
                if (i9 != i10 && i10 != 0) {
                    LinearLayout Q = this.b.a.Q();
                    int i11 = this.a - rect.bottom;
                    if (i11 <= 200) {
                        if (i3 == i7 && this.b.j) {
                            Q.setPadding(Q.getPaddingLeft(), Q.getPaddingTop(), Q.getPaddingRight(), 0);
                            u51.b(this.b.o, Q.getHeight(), 0, Q.getHeight(), 0);
                            l61 l61Var = this.b;
                            l61Var.F(l61Var.b, -1, -1);
                        }
                        this.b.j = false;
                    } else {
                        this.b.j = true;
                        if (i3 == i7) {
                            Q.setPadding(Q.getPaddingLeft(), Q.getPaddingTop(), Q.getPaddingRight(), i11);
                            u51.b(this.b.o, Q.getHeight() - i11, i11, Q.getHeight(), 0);
                            l61 l61Var2 = this.b;
                            l61Var2.F(l61Var2.b, -1, -1);
                        }
                    }
                    this.a = rect.bottom;
                    return;
                }
                this.a = rect.bottom;
            }
        }
    }

    public l61(@NonNull BaseNativeBrowserContainer baseNativeBrowserContainer) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {baseNativeBrowserContainer};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.e = new e61();
        this.g = true;
        this.h = null;
        this.k = new Object();
        this.l = 0L;
        this.n = null;
        this.o = new a(this);
        this.a = baseNativeBrowserContainer;
    }

    public void B(String str) {
        j61 j61Var;
        j61.c cVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) && (j61Var = this.c) != null && (cVar = j61Var.b) != null && !TextUtils.isEmpty(cVar.a)) {
            this.a.n(this.c.b.a);
        }
    }

    public void n(Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, intent) == null) {
            this.c = j61.b(intent);
        }
    }

    public void x(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048602, this, str) == null) {
            if (this.l == 0) {
                this.l = System.currentTimeMillis();
            }
            m61 m61Var = this.n;
            if (m61Var != null) {
                m61Var.e(this.b);
            }
        }
    }

    public void A(WebView webView, int i, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLILL(1048576, this, webView, i, str, str2) == null) {
            if (!NetUtil.a(this.a.Q().getContext())) {
                this.m = -1000;
            } else {
                this.m = i;
            }
            m61 m61Var = this.n;
            if (m61Var != null) {
                m61Var.g(this.m);
            }
        }
    }

    public void C() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            g61 g61Var = this.d;
            if (g61Var != null) {
                g61Var.e();
            }
            m61 m61Var = this.n;
            if (m61Var != null) {
                m61Var.h();
            }
        }
    }

    public void D() {
        g61 g61Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048579, this) == null) && (g61Var = this.d) != null) {
            g61Var.f();
        }
    }

    public final void g() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048585, this) == null) && this.a.Q() != null && this.i != null) {
            this.a.Q().removeOnLayoutChangeListener(this.i);
        }
    }

    public final void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            this.d = null;
            p51 p51Var = this.f;
            if (p51Var != null) {
                p51Var.d();
                this.f = null;
            }
        }
    }

    public g61 i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return this.d;
        }
        return (g61) invokeV.objValue;
    }

    @Nullable
    public final Intent j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            return this.a.j();
        }
        return (Intent) invokeV.objValue;
    }

    public String k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            j61 j61Var = this.c;
            if (j61Var == null) {
                return null;
            }
            return j61Var.g;
        }
        return (String) invokeV.objValue;
    }

    public String l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            j61 j61Var = this.c;
            if (j61Var == null) {
                return null;
            }
            return j61Var.a;
        }
        return (String) invokeV.objValue;
    }

    public final void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            if (this.f == null) {
                this.f = new p51();
            }
            j61 j61Var = this.c;
            if (j61Var != null) {
                this.f.b(j61Var.j);
            }
        }
    }

    public final void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
            this.i = new e(this);
            if (this.a.Q() != null) {
                this.a.Q().addOnLayoutChangeListener(this.i);
            }
        }
    }

    public final void t() {
        Intent j;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048598, this) != null) || (j = j()) == null) {
            return;
        }
        n(j);
        o();
        this.d = new g61();
        h51.a().a(this.k, new b(this));
    }

    public void v() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048600, this) == null) {
            t();
            m61 m61Var = new m61(this.c);
            this.n = m61Var;
            m61Var.c();
        }
    }

    public void z() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048604, this) == null) {
            g61 g61Var = this.d;
            if (g61Var != null) {
                g61Var.d();
            }
            m61 m61Var = this.n;
            if (m61Var != null) {
                m61Var.f();
            }
        }
    }

    public void F(@NonNull View view2, int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(1048581, this, view2, i, i2) == null) {
            if (view2.getLayoutParams() instanceof FrameLayout.LayoutParams) {
                view2.setLayoutParams(new FrameLayout.LayoutParams(i, i2));
            } else if (view2.getLayoutParams() instanceof LinearLayout.LayoutParams) {
                view2.setLayoutParams(new LinearLayout.LayoutParams(i, i2));
            } else if (view2.getLayoutParams() instanceof RelativeLayout.LayoutParams) {
                view2.setLayoutParams(new RelativeLayout.LayoutParams(i, i2));
            } else if (view2.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
                view2.setLayoutParams(new ViewGroup.MarginLayoutParams(i, i2));
            } else if (view2.getLayoutParams() instanceof ViewGroup.LayoutParams) {
                view2.setLayoutParams(new ViewGroup.LayoutParams(i, i2));
            }
        }
    }

    public boolean G(@NonNull WebView webView, String str, String str2) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048582, this, webView, str, str2)) == null) {
            H(webView, str2);
            j61 j61Var = this.c;
            if (j61Var == null || !j61Var.a()) {
                return true;
            }
            return !vi0.a(webView.getContext(), str2);
        }
        return invokeLLL.booleanValue;
    }

    public final void H(@NonNull WebView webView, String str) {
        j61 j61Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048583, this, webView, str) == null) && !TextUtils.isEmpty(str) && str.startsWith("tel:") && webView.getContext() != null && (j61Var = this.c) != null && !TextUtils.isEmpty(j61Var.f)) {
            new z81().p(webView.getContext(), this.c.f, "tel");
        }
    }

    public void q(@NonNull Activity activity, @NonNull WebView webView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048595, this, activity, webView) == null) {
            f61 f61Var = new f61(0);
            f61Var.a(this.e);
            f61Var.b(new c(this, webView));
            this.a.I(f61Var, "NadJsControl");
            this.a.I(new k61(new d(this, activity)), "go_back_js_interface_name");
        }
    }

    public final void f() {
        ViewTreeObserver viewTreeObserver;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) && this.a.Q() != null && this.h != null && (viewTreeObserver = this.a.Q().getViewTreeObserver()) != null && viewTreeObserver.isAlive()) {
            viewTreeObserver.removeOnGlobalLayoutListener(this.h);
        }
    }

    public boolean m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            this.d.g();
            if (j() != null) {
                String k = k();
                if (!TextUtils.isEmpty(k)) {
                    HashMap hashMap = new HashMap();
                    hashMap.put("Referer", k);
                    this.a.i0(hashMap);
                    return true;
                }
                return false;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final void r() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048596, this) != null) || this.a.Q() == null) {
            return;
        }
        if (this.h == null) {
            this.h = new t61(this.a.Q());
        }
        ViewTreeObserver viewTreeObserver = this.a.Q().getViewTreeObserver();
        if (viewTreeObserver != null && viewTreeObserver.isAlive()) {
            viewTreeObserver.addOnGlobalLayoutListener(this.h);
        }
    }

    public final void p() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048594, this) != null) || this.a.O() == null) {
            return;
        }
        RelativeLayout relativeLayout = new RelativeLayout(this.a.Q().getContext());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
        layoutParams.gravity = 80;
        relativeLayout.setBackgroundColor(0);
        relativeLayout.setVisibility(8);
        this.a.O().addView(relativeLayout, layoutParams);
        this.a.n0(relativeLayout);
        String str = null;
        if (this.c != null) {
            JSONObject jSONObject = new JSONObject();
            q01.f(jSONObject, LegoListActivityConfig.AD_ID, this.c.c);
            q01.f(jSONObject, "lp_url", this.c.a);
            q01.f(jSONObject, "log_ext", this.c.f);
            q01.f(jSONObject, Constant.KEY_BUSINESS, "native_ads");
            j61.b bVar = this.c.k;
            if (bVar != null) {
                q01.f(jSONObject, "key", bVar.e);
                q01.f(jSONObject, "url", this.c.k.a);
                q01.f(jSONObject, "close_v_dl", this.c.k.b);
                q01.f(jSONObject, "app_icon", this.c.k.d);
                q01.f(jSONObject, "app_name", this.c.k.c);
            }
            str = jSONObject.toString();
        }
        if (!TextUtils.isEmpty(str)) {
            this.a.q0(str);
        }
    }

    public void u(Context context, ViewGroup viewGroup, WebView webView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048599, this, context, viewGroup, webView) == null) {
            this.b = webView;
            p();
            if (w51.g()) {
                f();
                g();
            } else if (this.g) {
                f();
                s();
            } else {
                r();
                g();
            }
        }
    }

    public void w() {
        g61 g61Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048601, this) == null) {
            j61 j61Var = this.c;
            if (j61Var != null && TextUtils.equals(j61Var.i, "1") && (g61Var = this.d) != null) {
                this.d.b(this.e.a(), g61Var.a(this.c.f, this.l, this.m, false), this.c.a, this.a.M(), 0L);
            }
            g61 g61Var2 = this.d;
            if (g61Var2 != null) {
                g61Var2.c();
            }
            h51.a().release();
            h();
            f();
            g();
            if (this.i != null) {
                this.a.Q().removeOnLayoutChangeListener(this.i);
            }
            cm0.a().unregister(this.k);
            m61 m61Var = this.n;
            if (m61Var != null) {
                m61Var.d();
            }
        }
    }
}
