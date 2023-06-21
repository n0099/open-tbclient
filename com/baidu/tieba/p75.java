package com.baidu.tieba;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.elementsMaven.Direction;
import com.baidu.tbadk.core.elementsMaven.view.EMTextView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class p75 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public View a;
    public Drawable b;

    /* loaded from: classes7.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ int a;
        public final /* synthetic */ p75 b;

        public a(p75 p75Var, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {p75Var, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = p75Var;
            this.a = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                p75 p75Var = this.b;
                p75Var.b = n75.F(p75Var.b, this.a, this.b.a.getMeasuredHeight());
                this.b.a.setBackgroundDrawable(this.b.b);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ int a;
        public final /* synthetic */ int b;
        public final /* synthetic */ p75 c;

        public b(p75 p75Var, int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {p75Var, Integer.valueOf(i), Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = p75Var;
            this.a = i;
            this.b = i2;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                p75 p75Var = this.c;
                p75Var.b = n75.G(p75Var.b, this.a, this.b, this.c.a.getMeasuredHeight());
                this.c.a.setBackgroundDrawable(this.c.b);
            }
        }
    }

    public p75(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {view2};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = view2;
        this.b = n75.e(view2);
    }

    public p75 B(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i)) == null) {
            if (!(this.a instanceof TextView)) {
                return this;
            }
            float[] E = n75.E(i);
            ((TextView) this.a).setShadowLayer(E[1], E[2], E[3], (int) E[0]);
            return this;
        }
        return (p75) invokeI.objValue;
    }

    public p75 z(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048601, this, i)) == null) {
            View view2 = this.a;
            if (view2 instanceof EMTextView) {
                ((EMTextView) view2).setLineSpacing(n75.p(i), ((EMTextView) this.a).getLineSpacingMultiplier());
                return this;
            }
            throw new ClassCastException("When setting line spacing, use EMTextView to ensure UI effect.");
        }
        return (p75) invokeI.objValue;
    }

    public static p75 d(View view2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, view2)) == null) {
            return new p75(view2);
        }
        return (p75) invokeL.objValue;
    }

    public p75 A(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i)) == null) {
            View view2 = this.a;
            if (!(view2 instanceof TextView)) {
                return this;
            }
            ((TextView) view2).setTextColor(n75.J(i));
            return this;
        }
        return (p75) invokeI.objValue;
    }

    public p75 C(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i)) == null) {
            View view2 = this.a;
            if (!(view2 instanceof TextView)) {
                return this;
            }
            ((TextView) view2).setTextSize(0, n75.p(i));
            return this;
        }
        return (p75) invokeI.objValue;
    }

    public p75 D(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i)) == null) {
            View view2 = this.a;
            if (!(view2 instanceof TextView)) {
                return this;
            }
            ((TextView) view2).setTypeface(n75.K(n75.H(i)));
            return this;
        }
        return (p75) invokeI.objValue;
    }

    public p75 e(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048580, this, i)) == null) {
            if (this.a == null) {
                return this;
            }
            this.b = n75.c(this.b, i);
            return this;
        }
        return (p75) invokeI.objValue;
    }

    public void f(int i) {
        Drawable k;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeI(1048581, this, i) != null) || this.a == null || (k = n75.k(this.b, i)) == null) {
            return;
        }
        this.b = k;
        this.a.setBackgroundDrawable(k);
    }

    public void g(String str) {
        Drawable l;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048582, this, str) != null) || this.a == null || (l = n75.l(this.b, str)) == null) {
            return;
        }
        this.b = l;
        this.a.setBackgroundDrawable(l);
    }

    public void h(int i) {
        Drawable z;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeI(1048583, this, i) != null) || this.a == null || (z = n75.z(this.b, i)) == null) {
            return;
        }
        this.b = z;
        this.a.setBackgroundDrawable(z);
    }

    public void i(int i) {
        View view2;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i) != null) || (view2 = this.a) == null) {
            return;
        }
        view2.post(new a(this, i));
    }

    public p75 k(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048586, this, i)) == null) {
            if (this.a == null) {
                return this;
            }
            Drawable f = n75.f(this.b, i);
            if (f == null) {
                return this;
            }
            this.b = f;
            this.a.setBackgroundDrawable(f);
            return this;
        }
        return (p75) invokeI.objValue;
    }

    public p75 l(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048587, this, i)) == null) {
            if (this.a == null) {
                return this;
            }
            Drawable g = n75.g(this.b, i);
            if (g == null) {
                return this;
            }
            this.b = g;
            this.a.setBackgroundDrawable(g);
            return this;
        }
        return (p75) invokeI.objValue;
    }

    public p75 m(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048588, this, i)) == null) {
            if (this.a == null) {
                return this;
            }
            this.b = n75.h(this.b, i);
            return this;
        }
        return (p75) invokeI.objValue;
    }

    public p75 n(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048589, this, i)) == null) {
            if (this.a == null) {
                return this;
            }
            this.b = n75.o(this.b, i);
            return this;
        }
        return (p75) invokeI.objValue;
    }

    public p75 o(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048590, this, i)) == null) {
            if (this.a == null) {
                return this;
            }
            this.b = n75.n(this.b, i);
            return this;
        }
        return (p75) invokeI.objValue;
    }

    public void p(int[] iArr) {
        Drawable s;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048591, this, iArr) != null) || this.a == null || (s = n75.s(this.b, Direction.BOTTOM, iArr)) == null) {
            return;
        }
        this.b = s;
        this.a.setBackgroundDrawable(s);
    }

    public p75 s(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048594, this, i)) == null) {
            View view2 = this.a;
            if (view2 == null) {
                return this;
            }
            view2.setLayerType(i, null);
            return this;
        }
        return (p75) invokeI.objValue;
    }

    public p75 t(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048595, this, i)) == null) {
            View view2 = this.a;
            if (!(view2 instanceof TextView)) {
                return this;
            }
            ((TextView) view2).setLinkTextColor(n75.i(i));
            return this;
        }
        return (p75) invokeI.objValue;
    }

    public void u(int i) {
        Drawable w;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeI(1048596, this, i) != null) || this.a == null || (w = n75.w(this.b, n75.I(i))) == null) {
            return;
        }
        this.b = w;
        this.a.setBackgroundDrawable(w);
    }

    public p75 v(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048597, this, i)) == null) {
            if (this.a == null) {
                return this;
            }
            Drawable y = n75.y(this.b, i);
            if (y == null) {
                return this;
            }
            this.b = y;
            this.a.setBackgroundDrawable(y);
            return this;
        }
        return (p75) invokeI.objValue;
    }

    public p75 w(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048598, this, i)) == null) {
            View view2 = this.a;
            if (view2 == null) {
                return this;
            }
            Drawable D = n75.D(view2, this.b, n75.I(i));
            if (D == null) {
                return this;
            }
            this.b = D;
            this.a.setBackgroundDrawable(D);
            s(1);
            return this;
        }
        return (p75) invokeI.objValue;
    }

    public p75 x(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048599, this, i)) == null) {
            View view2 = this.a;
            if (!(view2 instanceof TextView)) {
                return this;
            }
            ((TextView) view2).setTextColor(n75.i(i));
            return this;
        }
        return (p75) invokeI.objValue;
    }

    public p75 y(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048600, this, str)) == null) {
            View view2 = this.a;
            if (!(view2 instanceof TextView)) {
                return this;
            }
            ((TextView) view2).setTextColor(n75.j(str));
            return this;
        }
        return (p75) invokeL.objValue;
    }

    public void j(int i, int i2) {
        View view2;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeII(1048585, this, i, i2) != null) || (view2 = this.a) == null) {
            return;
        }
        view2.post(new b(this, i, i2));
    }

    public void q(int[] iArr, Direction direction) {
        Drawable s;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(1048592, this, iArr, direction) != null) || this.a == null || (s = n75.s(this.b, direction, iArr)) == null) {
            return;
        }
        this.b = s;
        this.a.setBackgroundDrawable(s);
    }

    public void r(int[] iArr, Direction direction) {
        Drawable L;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(1048593, this, iArr, direction) != null) || this.a == null || (L = n75.L(this.b, direction, iArr)) == null) {
            return;
        }
        this.b = L;
        this.a.setBackgroundDrawable(L);
    }
}
