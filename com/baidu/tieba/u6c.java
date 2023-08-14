package com.baidu.tieba;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Dialog;
import android.database.ContentObserver;
import android.os.Build;
import android.os.Handler;
import android.provider.Settings;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.FrameLayout;
import androidx.annotation.ColorInt;
import androidx.annotation.FloatRange;
import androidx.annotation.RequiresApi;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.ColorUtils;
import androidx.core.view.InputDeviceCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.ui.SystemBarTintManager;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.ref.WeakReference;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import tv.athena.revenue.payui.activity.immersion.BarHide;
@TargetApi(19)
/* loaded from: classes8.dex */
public class u6c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Map<String, s6c> a;
    public Map<String, s6c> b;
    public Map<String, ArrayList<String>> c;
    public Activity d;
    public Window e;
    public ViewGroup f;
    public ViewGroup g;
    public Dialog h;
    public s6c i;
    public r6c j;
    public String k;
    public String l;
    public String m;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1948164391, "Lcom/baidu/tieba/u6c;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1948164391, "Lcom/baidu/tieba/u6c;");
        }
    }

    /* loaded from: classes8.dex */
    public class a extends ContentObserver {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ u6c a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(u6c u6cVar, Handler handler) {
            super(handler);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {u6cVar, handler};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((Handler) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = u6cVar;
        }

        @Override // android.database.ContentObserver
        public void onChange(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                if (Settings.System.getInt(this.a.d.getContentResolver(), "navigationbar_is_min", 0) == 1) {
                    this.a.i.p.setVisibility(8);
                    this.a.g.setPadding(0, this.a.g.getPaddingTop(), 0, 0);
                    return;
                }
                this.a.i.p.setVisibility(0);
                if (!this.a.i.x) {
                    if (this.a.j.l()) {
                        this.a.g.setPadding(0, this.a.g.getPaddingTop(), 0, this.a.j.d());
                        return;
                    } else {
                        this.a.g.setPadding(0, this.a.g.getPaddingTop(), this.a.j.f(), 0);
                        return;
                    }
                }
                this.a.g.setPadding(0, this.a.g.getPaddingTop(), 0, 0);
            }
        }
    }

    /* loaded from: classes8.dex */
    public static /* synthetic */ class b {
        public static /* synthetic */ Interceptable $ic;
        public static final /* synthetic */ int[] a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-419780311, "Lcom/baidu/tieba/u6c$b;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-419780311, "Lcom/baidu/tieba/u6c$b;");
                    return;
                }
            }
            int[] iArr = new int[BarHide.values().length];
            a = iArr;
            try {
                iArr[BarHide.FLAG_HIDE_BAR.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[BarHide.FLAG_HIDE_STATUS_BAR.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[BarHide.FLAG_HIDE_NAVIGATION_BAR.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[BarHide.FLAG_SHOW_BAR.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    public u6c(Activity activity) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {activity};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = new HashMap();
        this.b = new HashMap();
        this.c = new HashMap();
        Activity activity2 = (Activity) new WeakReference(activity).get();
        this.d = activity2;
        this.e = activity2.getWindow();
        String name = activity.getClass().getName();
        this.k = name;
        this.m = name;
        m();
    }

    @RequiresApi(api = 21)
    public final int k(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048590, this, i)) == null) {
            int i2 = i | 1024;
            s6c s6cVar = this.i;
            if (s6cVar.e && s6cVar.v) {
                i2 |= 512;
            }
            this.e.clearFlags(67108864);
            if (this.j.k()) {
                this.e.clearFlags(SystemBarTintManager.FLAG_TRANSLUCENT_NAVIGATION);
            }
            this.e.addFlags(Integer.MIN_VALUE);
            s6c s6cVar2 = this.i;
            if (s6cVar2.i) {
                this.e.setStatusBarColor(ColorUtils.blendARGB(s6cVar2.a, s6cVar2.j, s6cVar2.c));
            } else {
                this.e.setStatusBarColor(ColorUtils.blendARGB(s6cVar2.a, 0, s6cVar2.c));
            }
            s6c s6cVar3 = this.i;
            if (s6cVar3.v) {
                this.e.setNavigationBarColor(ColorUtils.blendARGB(s6cVar3.b, s6cVar3.k, s6cVar3.d));
            }
            return i2;
        }
        return invokeI.intValue;
    }

    public static u6c H(Activity activity) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, activity)) == null) {
            return new u6c(activity);
        }
        return (u6c) invokeL.objValue;
    }

    public static boolean n(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, str)) == null) {
            if (str != null && str.trim().length() != 0) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public u6c A(@ColorInt int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i)) == null) {
            this.i.a = i;
            return this;
        }
        return (u6c) invokeI.objValue;
    }

    public u6c B(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z)) == null) {
            C(z, 0.0f);
            return this;
        }
        return (u6c) invokeZ.objValue;
    }

    public u6c g(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048586, this, z)) == null) {
            this.i.n = z;
            return this;
        }
        return (u6c) invokeZ.objValue;
    }

    public u6c q(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048594, this, z)) == null) {
            this.i.v = z;
            return this;
        }
        return (u6c) invokeZ.objValue;
    }

    public final int u(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048598, this, i)) == null) {
            if (Build.VERSION.SDK_INT >= 23 && this.i.h) {
                return i | 8192;
            }
            return i;
        }
        return invokeI.intValue;
    }

    public u6c z(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048603, this, i)) == null) {
            A(ContextCompat.getColor(this.d, i));
            return this;
        }
        return (u6c) invokeI.objValue;
    }

    public static boolean o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65544, null)) == null) {
            if (!w6c.m() && !w6c.k() && Build.VERSION.SDK_INT < 23) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public u6c F() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            this.i.a = 0;
            return this;
        }
        return (u6c) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* renamed from: e */
    public s6c clone() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return this.i;
        }
        return (s6c) invokeV.objValue;
    }

    public u6c i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            this.a.put(this.m, this.i);
            j();
            v();
            E();
            p();
            r();
            return this;
        }
        return (u6c) invokeV.objValue;
    }

    public final void v() {
        View view2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048599, this) == null) && Build.VERSION.SDK_INT >= 19 && (view2 = this.i.q) != null) {
            ViewGroup.LayoutParams layoutParams = view2.getLayoutParams();
            layoutParams.height = this.j.i();
            this.i.q.setLayoutParams(layoutParams);
        }
    }

    public u6c C(boolean z, @FloatRange(from = 0.0d, to = 1.0d) float f) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Boolean.valueOf(z), Float.valueOf(f)})) == null) {
            s6c s6cVar = this.i;
            s6cVar.h = z;
            if (!z) {
                s6cVar.r = 0;
            }
            if (o()) {
                this.i.c = 0.0f;
            } else {
                this.i.c = f;
            }
            return this;
        }
        return (u6c) invokeCommon.objValue;
    }

    public final void D() {
        ViewGroup viewGroup;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048579, this) != null) || Build.VERSION.SDK_INT < 21 || w6c.i() || (viewGroup = this.g) == null) {
            return;
        }
        int childCount = viewGroup.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.g.getChildAt(i);
            if (childAt instanceof ViewGroup) {
                this.i.x = childAt.getFitsSystemWindows();
                if (this.i.x) {
                    this.g.setPadding(0, 0, 0, 0);
                    return;
                }
            }
        }
        s6c s6cVar = this.i;
        if (s6cVar.s) {
            this.g.setPadding(0, this.j.i() + this.j.a(), 0, 0);
        } else if (s6cVar.n) {
            this.g.setPadding(0, this.j.i(), 0, 0);
        } else {
            this.g.setPadding(0, 0, 0, 0);
        }
    }

    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            G();
            s6c s6cVar = this.i;
            v6c v6cVar = s6cVar.y;
            if (v6cVar != null) {
                v6cVar.o(s6cVar.u);
                this.i.y = null;
            }
            if (this.f != null) {
                this.f = null;
            }
            if (this.g != null) {
                this.g = null;
            }
            if (this.j != null) {
                this.j = null;
            }
            if (this.e != null) {
                this.e = null;
            }
            if (this.h != null) {
                this.h = null;
            }
            if (this.d != null) {
                this.d = null;
            }
            if (!n(this.m)) {
                if (this.i != null) {
                    this.i = null;
                }
                ArrayList<String> arrayList = this.c.get(this.k);
                if (arrayList != null && arrayList.size() > 0) {
                    Iterator<String> it = arrayList.iterator();
                    while (it.hasNext()) {
                        this.b.remove(it.next());
                    }
                    this.c.remove(this.k);
                }
                this.a.remove(this.m);
            }
        }
    }

    public final void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            int i = Build.VERSION.SDK_INT;
            if (i >= 19) {
                int i2 = 256;
                if (i >= 21 && !w6c.i()) {
                    i2 = u(k(256));
                    D();
                } else {
                    l();
                    y();
                }
                this.e.getDecorView().setSystemUiVisibility(h(i2));
            }
            if (w6c.m()) {
                s(this.e, this.i.h);
            } else if (w6c.k()) {
                s6c s6cVar = this.i;
                int i3 = s6cVar.r;
                if (i3 != 0) {
                    t6c.d(this.d, i3);
                } else if (Build.VERSION.SDK_INT < 23) {
                    t6c.e(this.d, s6cVar.h);
                }
            } else if (w6c.n()) {
                t(this.i.h);
            }
        }
    }

    public final void x() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048601, this) == null) {
            s6c s6cVar = this.i;
            if (s6cVar.o == null) {
                s6cVar.o = new View(this.d);
            }
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, this.j.i());
            layoutParams.gravity = 48;
            this.i.o.setLayoutParams(layoutParams);
            s6c s6cVar2 = this.i;
            if (s6cVar2.i) {
                s6cVar2.o.setBackgroundColor(ColorUtils.blendARGB(s6cVar2.a, s6cVar2.j, s6cVar2.c));
            } else {
                s6cVar2.o.setBackgroundColor(ColorUtils.blendARGB(s6cVar2.a, 0, s6cVar2.c));
            }
            this.i.o.setVisibility(0);
            ViewGroup viewGroup = (ViewGroup) this.i.o.getParent();
            if (viewGroup != null) {
                viewGroup.removeView(this.i.o);
            }
            this.f.addView(this.i.o);
        }
    }

    public final void E() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048580, this) == null) && this.i.l.size() != 0) {
            for (Map.Entry<View, Map<Integer, Integer>> entry : this.i.l.entrySet()) {
                View key = entry.getKey();
                Integer valueOf = Integer.valueOf(this.i.a);
                Integer valueOf2 = Integer.valueOf(this.i.j);
                for (Map.Entry<Integer, Integer> entry2 : entry.getValue().entrySet()) {
                    Integer key2 = entry2.getKey();
                    valueOf2 = entry2.getValue();
                    valueOf = key2;
                }
                if (key != null) {
                    if (Math.abs(this.i.m - 0.0f) == 0.0f) {
                        key.setBackgroundColor(ColorUtils.blendARGB(valueOf.intValue(), valueOf2.intValue(), this.i.c));
                    } else {
                        key.setBackgroundColor(ColorUtils.blendARGB(valueOf.intValue(), valueOf2.intValue(), this.i.m));
                    }
                }
            }
        }
    }

    public final void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            ViewGroup viewGroup = (ViewGroup) this.e.getDecorView();
            this.f = viewGroup;
            this.g = (ViewGroup) viewGroup.findViewById(16908290);
            this.j = new r6c(this.d);
            if (this.a.get(this.m) == null) {
                this.i = new s6c();
                if (!n(this.l)) {
                    if (this.a.get(this.k) != null) {
                        if (Build.VERSION.SDK_INT == 19 || w6c.i()) {
                            this.i.o = this.a.get(this.k).o;
                            this.i.p = this.a.get(this.k).p;
                        }
                        this.i.y = this.a.get(this.k).y;
                    } else {
                        throw new IllegalArgumentException("在Fragment里使用时，请先在加载Fragment的Activity里初始化！！！");
                    }
                }
                this.a.put(this.m, this.i);
                return;
            }
            this.i = this.a.get(this.m);
        }
    }

    public final void w() {
        FrameLayout.LayoutParams layoutParams;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048600, this) == null) {
            s6c s6cVar = this.i;
            if (s6cVar.p == null) {
                s6cVar.p = new View(this.d);
            }
            if (this.j.l()) {
                layoutParams = new FrameLayout.LayoutParams(-1, this.j.d());
                layoutParams.gravity = 80;
            } else {
                layoutParams = new FrameLayout.LayoutParams(this.j.f(), -1);
                layoutParams.gravity = 8388613;
            }
            this.i.p.setLayoutParams(layoutParams);
            s6c s6cVar2 = this.i;
            if (s6cVar2.v && s6cVar2.w) {
                if (!s6cVar2.e && s6cVar2.k == 0) {
                    s6cVar2.p.setBackgroundColor(ColorUtils.blendARGB(s6cVar2.b, -16777216, s6cVar2.d));
                } else {
                    s6c s6cVar3 = this.i;
                    s6cVar3.p.setBackgroundColor(ColorUtils.blendARGB(s6cVar3.b, s6cVar3.k, s6cVar3.d));
                }
            } else {
                this.i.p.setBackgroundColor(0);
            }
            this.i.p.setVisibility(0);
            ViewGroup viewGroup = (ViewGroup) this.i.p.getParent();
            if (viewGroup != null) {
                viewGroup.removeView(this.i.p);
            }
            this.f.addView(this.i.p);
        }
    }

    public final void G() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            if ((w6c.i() || w6c.h()) && this.j.k()) {
                s6c s6cVar = this.i;
                if (s6cVar.v && s6cVar.w && s6cVar.A != null && s6cVar.p != null) {
                    this.d.getContentResolver().unregisterContentObserver(this.i.A);
                }
            }
        }
    }

    public final void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            this.e.addFlags(67108864);
            x();
            if (this.j.k()) {
                s6c s6cVar = this.i;
                if (s6cVar.v && s6cVar.w) {
                    this.e.addFlags(SystemBarTintManager.FLAG_TRANSLUCENT_NAVIGATION);
                } else {
                    this.e.clearFlags(SystemBarTintManager.FLAG_TRANSLUCENT_NAVIGATION);
                }
                w();
            }
        }
    }

    public final void p() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048593, this) == null) && Build.VERSION.SDK_INT >= 19) {
            s6c s6cVar = this.i;
            if (s6cVar.y == null) {
                s6cVar.y = v6c.q(this.d, this.e);
            }
            s6c s6cVar2 = this.i;
            s6cVar2.y.r(s6cVar2);
            s6c s6cVar3 = this.i;
            if (s6cVar3.t) {
                s6cVar3.y.p(s6cVar3.u);
            } else {
                s6cVar3.y.o(s6cVar3.u);
            }
        }
    }

    public final int h(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048587, this, i)) == null) {
            if (Build.VERSION.SDK_INT >= 16) {
                int i2 = b.a[this.i.g.ordinal()];
                if (i2 != 1) {
                    if (i2 != 2) {
                        if (i2 != 3) {
                            if (i2 == 4) {
                                i |= 0;
                            }
                        } else {
                            i |= 514;
                        }
                    } else {
                        i |= 1028;
                    }
                } else {
                    i |= 518;
                }
            }
            return i | 4096;
        }
        return invokeI.intValue;
    }

    public final void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            if ((w6c.i() || w6c.h()) && this.j.k()) {
                s6c s6cVar = this.i;
                if (s6cVar.v && s6cVar.w) {
                    if (s6cVar.A == null && s6cVar.p != null) {
                        s6cVar.A = new a(this, new Handler());
                    }
                    this.d.getContentResolver().registerContentObserver(Settings.System.getUriFor("navigationbar_is_min"), true, this.i.A);
                }
            }
        }
    }

    public final void s(Window window, boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLZ(1048596, this, window, z) == null) && window != null) {
            Class<?> cls = window.getClass();
            try {
                Class<?> cls2 = Class.forName("android.view.MiuiWindowManager$LayoutParams");
                int i = cls2.getField("EXTRA_FLAG_STATUS_BAR_DARK_MODE").getInt(cls2);
                Method method = cls.getMethod("setExtraFlags", Integer.TYPE, Integer.TYPE);
                if (z) {
                    method.invoke(window, Integer.valueOf(i), Integer.valueOf(i));
                } else {
                    method.invoke(window, 0, Integer.valueOf(i));
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public final void t(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048597, this, z) == null) {
            if (Build.VERSION.SDK_INT >= 21) {
                this.e.addFlags(Integer.MIN_VALUE);
            }
            int systemUiVisibility = this.e.getDecorView().getSystemUiVisibility();
            int i = Build.VERSION.SDK_INT;
            if (i >= 23) {
                if (z) {
                    systemUiVisibility |= 8192;
                } else {
                    systemUiVisibility &= -8193;
                }
            } else if (i >= 19) {
                if (z) {
                    systemUiVisibility |= 16;
                } else {
                    systemUiVisibility &= -17;
                }
            }
            this.e.getDecorView().setSystemUiVisibility(systemUiVisibility);
        }
    }

    public final void y() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048602, this) == null) {
            int childCount = this.g.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = this.g.getChildAt(i);
                if (childAt instanceof ViewGroup) {
                    if (childAt instanceof DrawerLayout) {
                        View childAt2 = ((DrawerLayout) childAt).getChildAt(0);
                        if (childAt2 != null) {
                            this.i.x = childAt2.getFitsSystemWindows();
                            if (this.i.x) {
                                this.g.setPadding(0, 0, 0, 0);
                                return;
                            }
                        } else {
                            continue;
                        }
                    } else {
                        this.i.x = childAt.getFitsSystemWindows();
                        if (this.i.x) {
                            this.g.setPadding(0, 0, 0, 0);
                            return;
                        }
                    }
                }
            }
            if (this.j.k()) {
                s6c s6cVar = this.i;
                if (!s6cVar.f && !s6cVar.e) {
                    if (this.j.l()) {
                        s6c s6cVar2 = this.i;
                        if (!s6cVar2.s) {
                            if (s6cVar2.v && s6cVar2.w) {
                                if (s6cVar2.n) {
                                    this.g.setPadding(0, this.j.i(), 0, this.j.d());
                                    return;
                                } else {
                                    this.g.setPadding(0, 0, 0, this.j.d());
                                    return;
                                }
                            } else if (this.i.n) {
                                this.g.setPadding(0, this.j.i(), 0, 0);
                                return;
                            } else {
                                this.g.setPadding(0, 0, 0, 0);
                                return;
                            }
                        } else if (s6cVar2.v && s6cVar2.w) {
                            this.g.setPadding(0, this.j.i() + this.j.a() + 10, 0, this.j.d());
                            return;
                        } else {
                            this.g.setPadding(0, this.j.i() + this.j.a() + 10, 0, 0);
                            return;
                        }
                    }
                    s6c s6cVar3 = this.i;
                    if (!s6cVar3.s) {
                        if (s6cVar3.v && s6cVar3.w) {
                            if (s6cVar3.n) {
                                this.g.setPadding(0, this.j.i(), this.j.f(), 0);
                                return;
                            } else {
                                this.g.setPadding(0, 0, this.j.f(), 0);
                                return;
                            }
                        } else if (this.i.n) {
                            this.g.setPadding(0, this.j.i(), 0, 0);
                            return;
                        } else {
                            this.g.setPadding(0, 0, 0, 0);
                            return;
                        }
                    } else if (s6cVar3.v && s6cVar3.w) {
                        this.g.setPadding(0, this.j.i() + this.j.a() + 10, this.j.f(), 0);
                        return;
                    } else {
                        this.g.setPadding(0, this.j.i() + this.j.a() + 10, 0, 0);
                        return;
                    }
                }
            }
            s6c s6cVar4 = this.i;
            if (!s6cVar4.s) {
                if (s6cVar4.n) {
                    this.g.setPadding(0, this.j.i(), 0, 0);
                    return;
                } else {
                    this.g.setPadding(0, 0, 0, 0);
                    return;
                }
            }
            this.g.setPadding(0, this.j.i() + this.j.a() + 10, 0, 0);
        }
    }
}
