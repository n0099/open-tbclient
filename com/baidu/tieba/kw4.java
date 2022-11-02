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
/* loaded from: classes4.dex */
public class kw4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public View a;
    public Drawable b;

    /* loaded from: classes4.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ int a;
        public final /* synthetic */ kw4 b;

        public a(kw4 kw4Var, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {kw4Var, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = kw4Var;
            this.a = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                kw4 kw4Var = this.b;
                kw4Var.b = iw4.D(kw4Var.b, this.a, this.b.a.getMeasuredHeight());
                this.b.a.setBackgroundDrawable(this.b.b);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ int a;
        public final /* synthetic */ int b;
        public final /* synthetic */ kw4 c;

        public b(kw4 kw4Var, int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {kw4Var, Integer.valueOf(i), Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = kw4Var;
            this.a = i;
            this.b = i2;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                kw4 kw4Var = this.c;
                kw4Var.b = iw4.E(kw4Var.b, this.a, this.b, this.c.a.getMeasuredHeight());
                this.c.a.setBackgroundDrawable(this.c.b);
            }
        }
    }

    public kw4(View view2) {
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
        this.b = iw4.e(view2);
    }

    public kw4 w(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048595, this, i)) == null) {
            View view2 = this.a;
            if (view2 instanceof EMTextView) {
                ((EMTextView) view2).setLineSpacing(iw4.n(i), ((EMTextView) this.a).getLineSpacingMultiplier());
                return this;
            }
            throw new ClassCastException("When setting line spacing, use EMTextView to ensure UI effect.");
        }
        return (kw4) invokeI.objValue;
    }

    public kw4 y(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048597, this, i)) == null) {
            if (!(this.a instanceof TextView)) {
                return this;
            }
            float[] C = iw4.C(i);
            ((TextView) this.a).setShadowLayer(C[1], C[2], C[3], (int) C[0]);
            return this;
        }
        return (kw4) invokeI.objValue;
    }

    public static kw4 d(View view2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, view2)) == null) {
            return new kw4(view2);
        }
        return (kw4) invokeL.objValue;
    }

    public kw4 A(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i)) == null) {
            View view2 = this.a;
            if (!(view2 instanceof TextView)) {
                return this;
            }
            ((TextView) view2).setTypeface(iw4.I(iw4.F(i)));
            return this;
        }
        return (kw4) invokeI.objValue;
    }

    public kw4 e(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i)) == null) {
            if (this.a == null) {
                return this;
            }
            this.b = iw4.c(this.b, i);
            return this;
        }
        return (kw4) invokeI.objValue;
    }

    public void f(int i) {
        Drawable j;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i) != null) || this.a == null || (j = iw4.j(this.b, i)) == null) {
            return;
        }
        this.b = j;
        this.a.setBackgroundDrawable(j);
    }

    public void g(int i) {
        Drawable x;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeI(1048579, this, i) != null) || this.a == null || (x = iw4.x(this.b, i)) == null) {
            return;
        }
        this.b = x;
        this.a.setBackgroundDrawable(x);
    }

    public void h(int i) {
        View view2;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeI(1048580, this, i) != null) || (view2 = this.a) == null) {
            return;
        }
        view2.post(new a(this, i));
    }

    public kw4 j(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048582, this, i)) == null) {
            if (this.a == null) {
                return this;
            }
            Drawable f = iw4.f(this.b, i);
            if (f == null) {
                return this;
            }
            this.b = f;
            this.a.setBackgroundDrawable(f);
            return this;
        }
        return (kw4) invokeI.objValue;
    }

    public kw4 k(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048583, this, i)) == null) {
            if (this.a == null) {
                return this;
            }
            Drawable g = iw4.g(this.b, i);
            if (g == null) {
                return this;
            }
            this.b = g;
            this.a.setBackgroundDrawable(g);
            return this;
        }
        return (kw4) invokeI.objValue;
    }

    public kw4 l(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i)) == null) {
            if (this.a == null) {
                return this;
            }
            this.b = iw4.h(this.b, i);
            return this;
        }
        return (kw4) invokeI.objValue;
    }

    public kw4 m(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048585, this, i)) == null) {
            if (this.a == null) {
                return this;
            }
            this.b = iw4.m(this.b, i);
            return this;
        }
        return (kw4) invokeI.objValue;
    }

    public kw4 n(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048586, this, i)) == null) {
            if (this.a == null) {
                return this;
            }
            this.b = iw4.l(this.b, i);
            return this;
        }
        return (kw4) invokeI.objValue;
    }

    public void o(int[] iArr) {
        Drawable q;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048587, this, iArr) != null) || this.a == null || (q = iw4.q(this.b, Direction.BOTTOM, iArr)) == null) {
            return;
        }
        this.b = q;
        this.a.setBackgroundDrawable(q);
    }

    public kw4 q(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048589, this, i)) == null) {
            View view2 = this.a;
            if (view2 == null) {
                return this;
            }
            view2.setLayerType(i, null);
            return this;
        }
        return (kw4) invokeI.objValue;
    }

    public kw4 r(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048590, this, i)) == null) {
            View view2 = this.a;
            if (!(view2 instanceof TextView)) {
                return this;
            }
            ((TextView) view2).setLinkTextColor(iw4.i(i));
            return this;
        }
        return (kw4) invokeI.objValue;
    }

    public void s(int i) {
        Drawable u;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeI(1048591, this, i) != null) || this.a == null || (u = iw4.u(this.b, iw4.G(i))) == null) {
            return;
        }
        this.b = u;
        this.a.setBackgroundDrawable(u);
    }

    public kw4 t(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048592, this, i)) == null) {
            if (this.a == null) {
                return this;
            }
            Drawable w = iw4.w(this.b, i);
            if (w == null) {
                return this;
            }
            this.b = w;
            this.a.setBackgroundDrawable(w);
            return this;
        }
        return (kw4) invokeI.objValue;
    }

    public kw4 u(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048593, this, i)) == null) {
            View view2 = this.a;
            if (view2 == null) {
                return this;
            }
            Drawable B = iw4.B(view2, this.b, iw4.G(i));
            if (B == null) {
                return this;
            }
            this.b = B;
            this.a.setBackgroundDrawable(B);
            q(1);
            return this;
        }
        return (kw4) invokeI.objValue;
    }

    public kw4 v(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048594, this, i)) == null) {
            View view2 = this.a;
            if (!(view2 instanceof TextView)) {
                return this;
            }
            ((TextView) view2).setTextColor(iw4.i(i));
            return this;
        }
        return (kw4) invokeI.objValue;
    }

    public kw4 x(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048596, this, i)) == null) {
            View view2 = this.a;
            if (!(view2 instanceof TextView)) {
                return this;
            }
            ((TextView) view2).setTextColor(iw4.H(i));
            return this;
        }
        return (kw4) invokeI.objValue;
    }

    public kw4 z(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048598, this, i)) == null) {
            View view2 = this.a;
            if (!(view2 instanceof TextView)) {
                return this;
            }
            ((TextView) view2).setTextSize(0, iw4.n(i));
            return this;
        }
        return (kw4) invokeI.objValue;
    }

    public void i(int i, int i2) {
        View view2;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeII(1048581, this, i, i2) != null) || (view2 = this.a) == null) {
            return;
        }
        view2.post(new b(this, i, i2));
    }

    public void p(int[] iArr, Direction direction) {
        Drawable q;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(1048588, this, iArr, direction) != null) || this.a == null || (q = iw4.q(this.b, direction, iArr)) == null) {
            return;
        }
        this.b = q;
        this.a.setBackgroundDrawable(q);
    }
}
