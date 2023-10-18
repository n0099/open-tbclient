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
/* loaded from: classes8.dex */
public class u84 {
    public static /* synthetic */ Interceptable $ic;
    public static final int g;
    public static volatile u84 h;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;
    public int b;
    public int c;
    public boolean d;
    public int e;
    public ViewTreeObserver.OnGlobalLayoutListener f;

    /* loaded from: classes8.dex */
    public class a implements ViewTreeObserver.OnGlobalLayoutListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ View a;
        public final /* synthetic */ t84 b;
        public final /* synthetic */ u84 c;

        public a(u84 u84Var, View view2, t84 t84Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {u84Var, view2, t84Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = u84Var;
            this.a = view2;
            this.b = t84Var;
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
                int n = gj3.n(AppRuntime.getAppContext());
                int t = gj3.t();
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
                    this.c.b = i - u84.g;
                    u84 u84Var = this.c;
                    u84Var.a = ((n - i) - t) - u84Var.c;
                    if (this.c.a > 0) {
                        u84 u84Var2 = this.c;
                        if (!u84Var2.t(this.b, u84Var2.a, this.c.b)) {
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948164856, "Lcom/baidu/tieba/u84;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948164856, "Lcom/baidu/tieba/u84;");
                return;
            }
        }
        g = f84.a(42.0f);
        h = null;
    }

    public u84() {
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

    public static u84 p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65550, null)) == null) {
            if (h == null) {
                synchronized (u84.class) {
                    if (h == null) {
                        h = new u84();
                    }
                }
            }
            return h;
        }
        return (u84) invokeV.objValue;
    }

    public final vv2 o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            vv2 vv2Var = new vv2();
            vv2Var.k(true);
            vv2Var.n(-1);
            vv2Var.j(-2);
            return vv2Var;
        }
        return (vv2) invokeV.objValue;
    }

    public final vv2 q(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i)) == null) {
            vv2 vv2Var = new vv2();
            vv2Var.k(true);
            vv2Var.m(i);
            vv2Var.n(-1);
            vv2Var.j(-2);
            return vv2Var;
        }
        return (vv2) invokeI.objValue;
    }

    public final boolean r(View view2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, view2)) == null) {
            hn1 Y = cr2.V().Y();
            if (Y != null && Y.d(view2)) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public final void m(View view2, t84 t84Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048576, this, view2, t84Var) == null) && view2 != null && t84Var != null) {
            this.e = view2.getHeight();
            this.f = new a(this, view2, t84Var);
            view2.getViewTreeObserver().addOnGlobalLayoutListener(this.f);
        }
    }

    public boolean n(t84 t84Var) {
        InterceptResult invokeL;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, t84Var)) == null) {
            hn1 Y = cr2.V().Y();
            if (Y != null && !r(t84Var.f()) && Y.c(t84Var.f(), o())) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                if (!t84Var.l() || Y == null) {
                    return false;
                }
                m(Y.getRootView(), t84Var);
            }
            return z;
        }
        return invokeL.booleanValue;
    }

    public boolean s(t84 t84Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, t84Var)) == null) {
            hn1 Y = cr2.V().Y();
            if (Y == null) {
                return false;
            }
            FrameLayout rootView = Y.getRootView();
            if (rootView != null && this.f != null) {
                rootView.getViewTreeObserver().removeOnGlobalLayoutListener(this.f);
            }
            t84Var.h();
            this.f = null;
            this.a = -1;
            this.b = -1;
            this.c = -1;
            this.d = false;
            this.e = -1;
            return Y.removeView(t84Var.f());
        }
        return invokeL.booleanValue;
    }

    public final boolean t(t84 t84Var, int i, int i2) {
        InterceptResult invokeLII;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(1048582, this, t84Var, i, i2)) == null) {
            hn1 Y = cr2.V().Y();
            if (Y != null && Y.a(t84Var.f(), q(i2))) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                t84Var.k(i);
            }
            return z;
        }
        return invokeLII.booleanValue;
    }
}
