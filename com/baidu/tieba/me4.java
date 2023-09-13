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
public class me4 {
    public static /* synthetic */ Interceptable $ic;
    public static final int g;
    public static volatile me4 h;
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
        public final /* synthetic */ le4 b;
        public final /* synthetic */ me4 c;

        public a(me4 me4Var, View view2, le4 le4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {me4Var, view2, le4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = me4Var;
            this.a = view2;
            this.b = le4Var;
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
                int n = yo3.n(AppRuntime.getAppContext());
                int t = yo3.t();
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
                    this.c.b = i - me4.g;
                    me4 me4Var = this.c;
                    me4Var.a = ((n - i) - t) - me4Var.c;
                    if (this.c.a > 0) {
                        me4 me4Var2 = this.c;
                        if (!me4Var2.t(this.b, me4Var2.a, this.c.b)) {
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947969773, "Lcom/baidu/tieba/me4;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947969773, "Lcom/baidu/tieba/me4;");
                return;
            }
        }
        g = xd4.a(42.0f);
        h = null;
    }

    public me4() {
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

    public static me4 p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65550, null)) == null) {
            if (h == null) {
                synchronized (me4.class) {
                    if (h == null) {
                        h = new me4();
                    }
                }
            }
            return h;
        }
        return (me4) invokeV.objValue;
    }

    public final n13 o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            n13 n13Var = new n13();
            n13Var.k(true);
            n13Var.n(-1);
            n13Var.j(-2);
            return n13Var;
        }
        return (n13) invokeV.objValue;
    }

    public final n13 q(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i)) == null) {
            n13 n13Var = new n13();
            n13Var.k(true);
            n13Var.m(i);
            n13Var.n(-1);
            n13Var.j(-2);
            return n13Var;
        }
        return (n13) invokeI.objValue;
    }

    public final boolean r(View view2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, view2)) == null) {
            ys1 W = uw2.T().W();
            if (W != null && W.d(view2)) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public final void m(View view2, le4 le4Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048576, this, view2, le4Var) == null) && view2 != null && le4Var != null) {
            this.e = view2.getHeight();
            this.f = new a(this, view2, le4Var);
            view2.getViewTreeObserver().addOnGlobalLayoutListener(this.f);
        }
    }

    public boolean n(le4 le4Var) {
        InterceptResult invokeL;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, le4Var)) == null) {
            ys1 W = uw2.T().W();
            if (W != null && !r(le4Var.f()) && W.c(le4Var.f(), o())) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                if (!le4Var.l() || W == null) {
                    return false;
                }
                m(W.getRootView(), le4Var);
            }
            return z;
        }
        return invokeL.booleanValue;
    }

    public boolean s(le4 le4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, le4Var)) == null) {
            ys1 W = uw2.T().W();
            if (W == null) {
                return false;
            }
            FrameLayout rootView = W.getRootView();
            if (rootView != null && this.f != null) {
                rootView.getViewTreeObserver().removeOnGlobalLayoutListener(this.f);
            }
            le4Var.h();
            this.f = null;
            this.a = -1;
            this.b = -1;
            this.c = -1;
            this.d = false;
            this.e = -1;
            return W.removeView(le4Var.f());
        }
        return invokeL.booleanValue;
    }

    public final boolean t(le4 le4Var, int i, int i2) {
        InterceptResult invokeLII;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(1048582, this, le4Var, i, i2)) == null) {
            ys1 W = uw2.T().W();
            if (W != null && W.a(le4Var.f(), q(i2))) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                le4Var.k(i);
            }
            return z;
        }
        return invokeLII.booleanValue;
    }
}
