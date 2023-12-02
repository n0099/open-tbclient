package com.baidu.tieba;

import android.graphics.Bitmap;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nadcore.webview.view.AbsNadBrowserView;
import com.baidu.tieba.v51;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes7.dex */
public final class o51 extends h51 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final String a;
    public ViewTreeObserver.OnGlobalLayoutListener b;
    public View.OnLayoutChangeListener c;
    public boolean d;
    public final d61 e;
    public final l51 f;

    /* loaded from: classes7.dex */
    public static final class a implements View.OnLayoutChangeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int a;
        public final /* synthetic */ o51 b;

        /* JADX DEBUG: Incorrect args count in method signature: ()V */
        public a(o51 o51Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {o51Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = o51Var;
        }

        @Override // android.view.View.OnLayoutChangeListener
        public void onLayoutChange(View v, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{v, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6), Integer.valueOf(i7), Integer.valueOf(i8)}) == null) {
                Intrinsics.checkNotNullParameter(v, "v");
                Rect rect = new Rect();
                v.getWindowVisibleDisplayFrame(rect);
                String str = this.b.a;
                p61.a(str, "preBottom: " + this.a + " bottom: " + rect.bottom);
                int i9 = rect.bottom;
                int i10 = this.a;
                if (i9 != i10 && i10 != 0) {
                    AbsNadBrowserView m = this.b.f.m();
                    if (m != null) {
                        int i11 = this.a - rect.bottom;
                        if (i11 <= 200) {
                            if (i3 == i7 && this.b.d) {
                                t51.b(this.b.e, m.getHeight(), 0, m.getHeight(), 0);
                                o51 o51Var = this.b;
                                o51Var.w(o51Var.f.m(), -1, -1);
                            }
                            this.b.d = false;
                        } else {
                            this.b.d = true;
                            if (i3 == i7) {
                                t51.b(this.b.e, m.getHeight() - i11, i11, m.getHeight(), 0);
                                o51 o51Var2 = this.b;
                                o51Var2.w(o51Var2.f.m(), -1, -1);
                            }
                        }
                        this.a = rect.bottom;
                        return;
                    }
                    return;
                }
                this.a = rect.bottom;
            }
        }
    }

    /* loaded from: classes7.dex */
    public static final class b implements d61 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ o51 a;

        public b(o51 o51Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {o51Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = o51Var;
        }

        @Override // com.baidu.tieba.d61
        public final void loadUrl(String str, Map<String, String> map) {
            AbsNadBrowserView m;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLL(1048576, this, str, map) == null) && (m = this.a.f.m()) != null) {
                AbsNadBrowserView.E(m, str, map, false, 4, null);
            }
        }
    }

    public o51(l51 container) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {container};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        Intrinsics.checkNotNullParameter(container, "container");
        this.f = container;
        this.a = "KeyboardPlugin";
        this.e = new b(this);
    }

    @Override // com.baidu.tieba.h51
    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            s();
            t();
            super.d();
        }
    }

    @Override // com.baidu.tieba.h51
    public void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            if (h61.c()) {
                s();
                t();
            } else {
                v();
                u();
            }
            super.m();
        }
    }

    public final void t() {
        LinearLayout d;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048581, this) == null) && this.f.d() != null && this.c != null && (d = this.f.d()) != null) {
            d.removeOnLayoutChangeListener(this.c);
        }
    }

    public final void v() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.c = new a(this);
            LinearLayout d = this.f.d();
            if (d != null) {
                d.addOnLayoutChangeListener(this.c);
            }
        }
    }

    @Override // com.baidu.tieba.h51
    public void h(AbsNadBrowserView webView, String str, Bitmap bitmap) {
        String str2;
        AbsNadBrowserView m;
        String str3;
        v51.e j;
        v51.e j2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, webView, str, bitmap) == null) {
            Intrinsics.checkNotNullParameter(webView, "webView");
            v51.d l = this.f.l();
            if (l != null && (j2 = l.j()) != null) {
                str2 = j2.b();
            } else {
                str2 = null;
            }
            if (str2 != null && (m = this.f.m()) != null) {
                v51.d l2 = this.f.l();
                if (l2 != null && (j = l2.j()) != null) {
                    str3 = j.b();
                } else {
                    str3 = null;
                }
                AbsNadBrowserView.C(m, str3, null, 2, null);
            }
            super.h(webView, str, bitmap);
        }
    }

    public final void w(View view2, int i, int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLII(InputDeviceCompat.SOURCE_TOUCHPAD, this, view2, i, i2) != null) || view2 == null) {
            return;
        }
        ViewGroup.LayoutParams layoutParams = view2.getLayoutParams();
        if (layoutParams instanceof FrameLayout.LayoutParams) {
            view2.setLayoutParams(new FrameLayout.LayoutParams(i, i2));
        } else if (layoutParams instanceof LinearLayout.LayoutParams) {
            view2.setLayoutParams(new LinearLayout.LayoutParams(i, i2));
        } else if (layoutParams instanceof RelativeLayout.LayoutParams) {
            view2.setLayoutParams(new RelativeLayout.LayoutParams(i, i2));
        } else if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            view2.setLayoutParams(new ViewGroup.MarginLayoutParams(i, i2));
        } else if (layoutParams instanceof ViewGroup.LayoutParams) {
            view2.setLayoutParams(new ViewGroup.LayoutParams(i, i2));
        }
    }

    @Override // com.baidu.tieba.h51
    public void k(AbsNadBrowserView webView, String str) {
        String str2;
        AbsNadBrowserView m;
        String str3;
        v51.e j;
        v51.e j2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, webView, str) == null) {
            Intrinsics.checkNotNullParameter(webView, "webView");
            v51.d l = this.f.l();
            if (l != null && (j2 = l.j()) != null) {
                str2 = j2.a();
            } else {
                str2 = null;
            }
            if (str2 != null && (m = this.f.m()) != null) {
                v51.d l2 = this.f.l();
                if (l2 != null && (j = l2.j()) != null) {
                    str3 = j.a();
                } else {
                    str3 = null;
                }
                AbsNadBrowserView.C(m, str3, null, 2, null);
            }
            super.k(webView, str);
        }
    }

    public final void s() {
        ViewTreeObserver viewTreeObserver;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048580, this) == null) && this.f.d() != null && this.b != null) {
            LinearLayout d = this.f.d();
            if (d != null) {
                viewTreeObserver = d.getViewTreeObserver();
            } else {
                viewTreeObserver = null;
            }
            if (viewTreeObserver != null && viewTreeObserver.isAlive()) {
                viewTreeObserver.removeOnGlobalLayoutListener(this.b);
            }
        }
    }

    public final void u() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            if (this.f.d() == null) {
                p61.a(this.a, "init keyboard config failed");
                return;
            }
            LinearLayout d = this.f.d();
            if (d != null) {
                if (this.b == null) {
                    this.b = new n51(d);
                }
                ViewTreeObserver viewTreeObserver = d.getViewTreeObserver();
                Intrinsics.checkNotNullExpressionValue(viewTreeObserver, "it.viewTreeObserver");
                if (viewTreeObserver.isAlive()) {
                    p61.a(this.a, "add layout listener");
                    viewTreeObserver.addOnGlobalLayoutListener(this.b);
                }
            }
        }
    }
}
