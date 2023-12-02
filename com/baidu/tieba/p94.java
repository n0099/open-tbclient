package com.baidu.tieba;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class p94 {
    public static /* synthetic */ Interceptable $ic;
    public static final int g;
    public static volatile p94 h;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;
    public int b;
    public int c;
    public boolean d;
    public int e;
    public ViewTreeObserver.OnGlobalLayoutListener f;

    /* loaded from: classes7.dex */
    public class a implements ViewTreeObserver.OnGlobalLayoutListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ View a;
        public final /* synthetic */ o94 b;
        public final /* synthetic */ p94 c;

        public a(p94 p94Var, View view2, o94 o94Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {p94Var, view2, o94Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = p94Var;
            this.a = view2;
            this.b = o94Var;
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                Rect rect = new Rect();
                View view2 = this.a;
                if (view2 == null) {
                    return;
                }
                view2.getWindowVisibleDisplayFrame(rect);
                int i = rect.bottom - rect.top;
                int n = bk3.n(AppRuntime.getAppContext());
                int t = bk3.t();
                if (!this.c.d) {
                    this.c.d = true;
                    this.c.c = (n - i) - t;
                    if (this.c.c < 0) {
                        this.c.c = 0;
                    }
                }
                if (i > 0) {
                    if (i >= this.c.e || this.a.getHeight() - i <= 200) {
                        if (i <= this.c.e || this.a.getHeight() - i >= 200) {
                            return;
                        }
                        this.c.e = i;
                        this.c.s(this.b);
                        return;
                    }
                    this.c.e = i;
                    this.c.b = i - p94.g;
                    p94 p94Var = this.c;
                    p94Var.a = ((n - i) - t) - p94Var.c;
                    if (this.c.a > 0) {
                        p94 p94Var2 = this.c;
                        if (!p94Var2.t(this.b, p94Var2.a, this.c.b)) {
                            this.c.s(this.b);
                        }
                    }
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948016862, "Lcom/baidu/tieba/p94;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948016862, "Lcom/baidu/tieba/p94;");
                return;
            }
        }
        g = a94.a(42.0f);
        h = null;
    }

    public p94() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f = null;
    }

    public static p94 p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65550, null)) == null) {
            if (h == null) {
                synchronized (p94.class) {
                    if (h == null) {
                        h = new p94();
                    }
                }
            }
            return h;
        }
        return (p94) invokeV.objValue;
    }

    public final qw2 o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            qw2 qw2Var = new qw2();
            qw2Var.k(true);
            qw2Var.n(-1);
            qw2Var.j(-2);
            return qw2Var;
        }
        return (qw2) invokeV.objValue;
    }

    public final qw2 q(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i)) == null) {
            qw2 qw2Var = new qw2();
            qw2Var.k(true);
            qw2Var.m(i);
            qw2Var.n(-1);
            qw2Var.j(-2);
            return qw2Var;
        }
        return (qw2) invokeI.objValue;
    }

    public final boolean r(View view2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, view2)) == null) {
            co1 Y = xr2.V().Y();
            if (Y != null && Y.d(view2)) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public final void m(View view2, o94 o94Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048576, this, view2, o94Var) == null) && view2 != null && o94Var != null) {
            this.e = view2.getHeight();
            this.f = new a(this, view2, o94Var);
            view2.getViewTreeObserver().addOnGlobalLayoutListener(this.f);
        }
    }

    public boolean n(o94 o94Var) {
        InterceptResult invokeL;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, o94Var)) == null) {
            co1 Y = xr2.V().Y();
            if (Y != null && !r(o94Var.f()) && Y.c(o94Var.f(), o())) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                if (!o94Var.l() || Y == null) {
                    return false;
                }
                m(Y.getRootView(), o94Var);
            }
            return z;
        }
        return invokeL.booleanValue;
    }

    public boolean s(o94 o94Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, o94Var)) == null) {
            co1 Y = xr2.V().Y();
            if (Y == null) {
                return false;
            }
            FrameLayout rootView = Y.getRootView();
            if (rootView != null && this.f != null) {
                rootView.getViewTreeObserver().removeOnGlobalLayoutListener(this.f);
            }
            o94Var.h();
            this.f = null;
            this.a = -1;
            this.b = -1;
            this.c = -1;
            this.d = false;
            this.e = -1;
            return Y.removeView(o94Var.f());
        }
        return invokeL.booleanValue;
    }

    public final boolean t(o94 o94Var, int i, int i2) {
        InterceptResult invokeLII;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(1048582, this, o94Var, i, i2)) == null) {
            co1 Y = xr2.V().Y();
            if (Y != null && Y.a(o94Var.f(), q(i2))) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                o94Var.k(i);
            }
            return z;
        }
        return invokeLII.booleanValue;
    }
}
