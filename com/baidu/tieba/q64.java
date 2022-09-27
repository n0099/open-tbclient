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
/* loaded from: classes5.dex */
public class q64 {
    public static /* synthetic */ Interceptable $ic;
    public static final int g;
    public static volatile q64 h;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;
    public int b;
    public int c;
    public boolean d;
    public int e;
    public ViewTreeObserver.OnGlobalLayoutListener f;

    /* loaded from: classes5.dex */
    public class a implements ViewTreeObserver.OnGlobalLayoutListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ View a;
        public final /* synthetic */ p64 b;
        public final /* synthetic */ q64 c;

        public a(q64 q64Var, View view2, p64 p64Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {q64Var, view2, p64Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = q64Var;
            this.a = view2;
            this.b = p64Var;
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
                int n = ch3.n(AppRuntime.getAppContext());
                int t = ch3.t();
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
                    this.c.b = i - q64.g;
                    q64 q64Var = this.c;
                    q64Var.a = ((n - i) - t) - q64Var.c;
                    if (this.c.a > 0) {
                        q64 q64Var2 = this.c;
                        if (q64Var2.t(this.b, q64Var2.a, this.c.b)) {
                            return;
                        }
                        this.c.s(this.b);
                    }
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948043770, "Lcom/baidu/tieba/q64;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948043770, "Lcom/baidu/tieba/q64;");
                return;
            }
        }
        g = b64.a(42.0f);
        h = null;
    }

    public q64() {
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

    public static q64 p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65550, null)) == null) {
            if (h == null) {
                synchronized (q64.class) {
                    if (h == null) {
                        h = new q64();
                    }
                }
            }
            return h;
        }
        return (q64) invokeV.objValue;
    }

    public final void m(View view2, p64 p64Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048576, this, view2, p64Var) == null) || view2 == null || p64Var == null) {
            return;
        }
        this.e = view2.getHeight();
        this.f = new a(this, view2, p64Var);
        view2.getViewTreeObserver().addOnGlobalLayoutListener(this.f);
    }

    public boolean n(p64 p64Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, p64Var)) == null) {
            cl1 X = yo2.U().X();
            boolean z = (X == null || r(p64Var.f()) || !X.c(p64Var.f(), o())) ? false : true;
            if (z) {
                if (!p64Var.l() || X == null) {
                    return false;
                }
                m(X.getRootView(), p64Var);
            }
            return z;
        }
        return invokeL.booleanValue;
    }

    public final rt2 o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            rt2 rt2Var = new rt2();
            rt2Var.k(true);
            rt2Var.n(-1);
            rt2Var.j(-2);
            return rt2Var;
        }
        return (rt2) invokeV.objValue;
    }

    public final rt2 q(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i)) == null) {
            rt2 rt2Var = new rt2();
            rt2Var.k(true);
            rt2Var.m(i);
            rt2Var.n(-1);
            rt2Var.j(-2);
            return rt2Var;
        }
        return (rt2) invokeI.objValue;
    }

    public final boolean r(View view2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, view2)) == null) {
            cl1 X = yo2.U().X();
            return X != null && X.d(view2);
        }
        return invokeL.booleanValue;
    }

    public boolean s(p64 p64Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, p64Var)) == null) {
            cl1 X = yo2.U().X();
            if (X == null) {
                return false;
            }
            FrameLayout rootView = X.getRootView();
            if (rootView != null && this.f != null) {
                rootView.getViewTreeObserver().removeOnGlobalLayoutListener(this.f);
            }
            p64Var.h();
            this.f = null;
            this.a = -1;
            this.b = -1;
            this.c = -1;
            this.d = false;
            this.e = -1;
            return X.removeView(p64Var.f());
        }
        return invokeL.booleanValue;
    }

    public final boolean t(p64 p64Var, int i, int i2) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(1048582, this, p64Var, i, i2)) == null) {
            cl1 X = yo2.U().X();
            boolean z = X != null && X.a(p64Var.f(), q(i2));
            if (z) {
                p64Var.k(i);
            }
            return z;
        }
        return invokeLII.booleanValue;
    }
}
