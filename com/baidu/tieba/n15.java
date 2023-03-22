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
/* loaded from: classes5.dex */
public class n15 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public View a;
    public Drawable b;

    /* loaded from: classes5.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ int a;
        public final /* synthetic */ n15 b;

        public a(n15 n15Var, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {n15Var, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = n15Var;
            this.a = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                n15 n15Var = this.b;
                n15Var.b = l15.F(n15Var.b, this.a, this.b.a.getMeasuredHeight());
                this.b.a.setBackgroundDrawable(this.b.b);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ int a;
        public final /* synthetic */ int b;
        public final /* synthetic */ n15 c;

        public b(n15 n15Var, int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {n15Var, Integer.valueOf(i), Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = n15Var;
            this.a = i;
            this.b = i2;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                n15 n15Var = this.c;
                n15Var.b = l15.G(n15Var.b, this.a, this.b, this.c.a.getMeasuredHeight());
                this.c.a.setBackgroundDrawable(this.c.b);
            }
        }
    }

    public n15(View view2) {
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
        this.b = l15.e(view2);
    }

    public n15 x(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048597, this, i)) == null) {
            View view2 = this.a;
            if (view2 instanceof EMTextView) {
                ((EMTextView) view2).setLineSpacing(l15.p(i), ((EMTextView) this.a).getLineSpacingMultiplier());
                return this;
            }
            throw new ClassCastException("When setting line spacing, use EMTextView to ensure UI effect.");
        }
        return (n15) invokeI.objValue;
    }

    public n15 z(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048599, this, i)) == null) {
            if (!(this.a instanceof TextView)) {
                return this;
            }
            float[] E = l15.E(i);
            ((TextView) this.a).setShadowLayer(E[1], E[2], E[3], (int) E[0]);
            return this;
        }
        return (n15) invokeI.objValue;
    }

    public static n15 d(View view2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, view2)) == null) {
            return new n15(view2);
        }
        return (n15) invokeL.objValue;
    }

    public n15 A(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i)) == null) {
            View view2 = this.a;
            if (!(view2 instanceof TextView)) {
                return this;
            }
            ((TextView) view2).setTextSize(0, l15.p(i));
            return this;
        }
        return (n15) invokeI.objValue;
    }

    public n15 B(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i)) == null) {
            View view2 = this.a;
            if (!(view2 instanceof TextView)) {
                return this;
            }
            ((TextView) view2).setTypeface(l15.K(l15.H(i)));
            return this;
        }
        return (n15) invokeI.objValue;
    }

    public n15 e(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i)) == null) {
            if (this.a == null) {
                return this;
            }
            this.b = l15.c(this.b, i);
            return this;
        }
        return (n15) invokeI.objValue;
    }

    public void f(int i) {
        Drawable k;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeI(1048579, this, i) != null) || this.a == null || (k = l15.k(this.b, i)) == null) {
            return;
        }
        this.b = k;
        this.a.setBackgroundDrawable(k);
    }

    public void g(String str) {
        Drawable l;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048580, this, str) != null) || this.a == null || (l = l15.l(this.b, str)) == null) {
            return;
        }
        this.b = l;
        this.a.setBackgroundDrawable(l);
    }

    public void h(int i) {
        Drawable z;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeI(1048581, this, i) != null) || this.a == null || (z = l15.z(this.b, i)) == null) {
            return;
        }
        this.b = z;
        this.a.setBackgroundDrawable(z);
    }

    public void i(int i) {
        View view2;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeI(1048582, this, i) != null) || (view2 = this.a) == null) {
            return;
        }
        view2.post(new a(this, i));
    }

    public n15 k(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i)) == null) {
            if (this.a == null) {
                return this;
            }
            Drawable f = l15.f(this.b, i);
            if (f == null) {
                return this;
            }
            this.b = f;
            this.a.setBackgroundDrawable(f);
            return this;
        }
        return (n15) invokeI.objValue;
    }

    public n15 l(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048585, this, i)) == null) {
            if (this.a == null) {
                return this;
            }
            Drawable g = l15.g(this.b, i);
            if (g == null) {
                return this;
            }
            this.b = g;
            this.a.setBackgroundDrawable(g);
            return this;
        }
        return (n15) invokeI.objValue;
    }

    public n15 m(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048586, this, i)) == null) {
            if (this.a == null) {
                return this;
            }
            this.b = l15.h(this.b, i);
            return this;
        }
        return (n15) invokeI.objValue;
    }

    public n15 n(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048587, this, i)) == null) {
            if (this.a == null) {
                return this;
            }
            this.b = l15.o(this.b, i);
            return this;
        }
        return (n15) invokeI.objValue;
    }

    public n15 o(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048588, this, i)) == null) {
            if (this.a == null) {
                return this;
            }
            this.b = l15.n(this.b, i);
            return this;
        }
        return (n15) invokeI.objValue;
    }

    public void p(int[] iArr) {
        Drawable s;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048589, this, iArr) != null) || this.a == null || (s = l15.s(this.b, Direction.BOTTOM, iArr)) == null) {
            return;
        }
        this.b = s;
        this.a.setBackgroundDrawable(s);
    }

    public n15 r(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048591, this, i)) == null) {
            View view2 = this.a;
            if (view2 == null) {
                return this;
            }
            view2.setLayerType(i, null);
            return this;
        }
        return (n15) invokeI.objValue;
    }

    public n15 s(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048592, this, i)) == null) {
            View view2 = this.a;
            if (!(view2 instanceof TextView)) {
                return this;
            }
            ((TextView) view2).setLinkTextColor(l15.i(i));
            return this;
        }
        return (n15) invokeI.objValue;
    }

    public void t(int i) {
        Drawable w;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeI(1048593, this, i) != null) || this.a == null || (w = l15.w(this.b, l15.I(i))) == null) {
            return;
        }
        this.b = w;
        this.a.setBackgroundDrawable(w);
    }

    public n15 u(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048594, this, i)) == null) {
            if (this.a == null) {
                return this;
            }
            Drawable y = l15.y(this.b, i);
            if (y == null) {
                return this;
            }
            this.b = y;
            this.a.setBackgroundDrawable(y);
            return this;
        }
        return (n15) invokeI.objValue;
    }

    public n15 v(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048595, this, i)) == null) {
            View view2 = this.a;
            if (view2 == null) {
                return this;
            }
            Drawable D = l15.D(view2, this.b, l15.I(i));
            if (D == null) {
                return this;
            }
            this.b = D;
            this.a.setBackgroundDrawable(D);
            r(1);
            return this;
        }
        return (n15) invokeI.objValue;
    }

    public n15 w(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048596, this, i)) == null) {
            View view2 = this.a;
            if (!(view2 instanceof TextView)) {
                return this;
            }
            ((TextView) view2).setTextColor(l15.i(i));
            return this;
        }
        return (n15) invokeI.objValue;
    }

    public n15 y(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048598, this, i)) == null) {
            View view2 = this.a;
            if (!(view2 instanceof TextView)) {
                return this;
            }
            ((TextView) view2).setTextColor(l15.J(i));
            return this;
        }
        return (n15) invokeI.objValue;
    }

    public void j(int i, int i2) {
        View view2;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeII(1048583, this, i, i2) != null) || (view2 = this.a) == null) {
            return;
        }
        view2.post(new b(this, i, i2));
    }

    public void q(int[] iArr, Direction direction) {
        Drawable s;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(1048590, this, iArr, direction) != null) || this.a == null || (s = l15.s(this.b, direction, iArr)) == null) {
            return;
        }
        this.b = s;
        this.a.setBackgroundDrawable(s);
    }
}
