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
/* loaded from: classes4.dex */
public class j74 {
    public static /* synthetic */ Interceptable $ic;
    public static final int g;
    public static volatile j74 h;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;
    public int b;
    public int c;
    public boolean d;
    public int e;
    public ViewTreeObserver.OnGlobalLayoutListener f;

    /* loaded from: classes4.dex */
    public class a implements ViewTreeObserver.OnGlobalLayoutListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ View a;
        public final /* synthetic */ i74 b;
        public final /* synthetic */ j74 c;

        public a(j74 j74Var, View view2, i74 i74Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {j74Var, view2, i74Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = j74Var;
            this.a = view2;
            this.b = i74Var;
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
                int n = vh3.n(AppRuntime.getAppContext());
                int t = vh3.t();
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
                    this.c.b = i - j74.g;
                    j74 j74Var = this.c;
                    j74Var.a = ((n - i) - t) - j74Var.c;
                    if (this.c.a > 0) {
                        j74 j74Var2 = this.c;
                        if (!j74Var2.t(this.b, j74Var2.a, this.c.b)) {
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947836194, "Lcom/baidu/tieba/j74;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947836194, "Lcom/baidu/tieba/j74;");
                return;
            }
        }
        g = u64.a(42.0f);
        h = null;
    }

    public j74() {
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

    public static j74 p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65550, null)) == null) {
            if (h == null) {
                synchronized (j74.class) {
                    if (h == null) {
                        h = new j74();
                    }
                }
            }
            return h;
        }
        return (j74) invokeV.objValue;
    }

    public final ku2 o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            ku2 ku2Var = new ku2();
            ku2Var.k(true);
            ku2Var.n(-1);
            ku2Var.j(-2);
            return ku2Var;
        }
        return (ku2) invokeV.objValue;
    }

    public final ku2 q(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i)) == null) {
            ku2 ku2Var = new ku2();
            ku2Var.k(true);
            ku2Var.m(i);
            ku2Var.n(-1);
            ku2Var.j(-2);
            return ku2Var;
        }
        return (ku2) invokeI.objValue;
    }

    public final boolean r(View view2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, view2)) == null) {
            vl1 X = rp2.U().X();
            if (X != null && X.d(view2)) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public final void m(View view2, i74 i74Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048576, this, view2, i74Var) == null) && view2 != null && i74Var != null) {
            this.e = view2.getHeight();
            this.f = new a(this, view2, i74Var);
            view2.getViewTreeObserver().addOnGlobalLayoutListener(this.f);
        }
    }

    public boolean n(i74 i74Var) {
        InterceptResult invokeL;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i74Var)) == null) {
            vl1 X = rp2.U().X();
            if (X != null && !r(i74Var.f()) && X.c(i74Var.f(), o())) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                if (!i74Var.l() || X == null) {
                    return false;
                }
                m(X.getRootView(), i74Var);
            }
            return z;
        }
        return invokeL.booleanValue;
    }

    public boolean s(i74 i74Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, i74Var)) == null) {
            vl1 X = rp2.U().X();
            if (X == null) {
                return false;
            }
            FrameLayout rootView = X.getRootView();
            if (rootView != null && this.f != null) {
                rootView.getViewTreeObserver().removeOnGlobalLayoutListener(this.f);
            }
            i74Var.h();
            this.f = null;
            this.a = -1;
            this.b = -1;
            this.c = -1;
            this.d = false;
            this.e = -1;
            return X.removeView(i74Var.f());
        }
        return invokeL.booleanValue;
    }

    public final boolean t(i74 i74Var, int i, int i2) {
        InterceptResult invokeLII;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(1048582, this, i74Var, i, i2)) == null) {
            vl1 X = rp2.U().X();
            if (X != null && X.a(i74Var.f(), q(i2))) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                i74Var.k(i);
            }
            return z;
        }
        return invokeLII.booleanValue;
    }
}
