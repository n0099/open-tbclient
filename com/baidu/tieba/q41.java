package com.baidu.tieba;

import android.content.Context;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nadcore.widget.bubble.BubblePosition;
import com.baidu.tieba.q01;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class q41 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean a;
    public float b;
    public float c;
    public boolean d;
    public BubblePosition e;
    public boolean f;

    /* loaded from: classes5.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public static final /* synthetic */ int[] a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-537633538, "Lcom/baidu/tieba/q41$a;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-537633538, "Lcom/baidu/tieba/q41$a;");
                    return;
                }
            }
            int[] iArr = new int[BubblePosition.values().length];
            a = iArr;
            try {
                iArr[BubblePosition.UP.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[BubblePosition.DOWN.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[BubblePosition.LEFT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[BubblePosition.RIGHT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    public q41() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = false;
        this.b = 0.0f;
        this.d = true;
        this.e = BubblePosition.INVALID;
        this.f = true;
    }

    public int[] a(y41 y41Var, int[] iArr, BubblePosition bubblePosition) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, y41Var, iArr, bubblePosition)) == null) {
            if (y41Var == null) {
                return new int[]{0, 0};
            }
            if (bubblePosition == BubblePosition.INVALID) {
                return iArr;
            }
            Context context = y41Var.a.getContext();
            int i = iArr[0];
            int i2 = iArr[1];
            int[] iArr2 = new int[2];
            int measuredWidth = y41Var.b.getMeasuredWidth();
            int measuredHeight = y41Var.b.getMeasuredHeight();
            int measuredWidth2 = y41Var.a.getMeasuredWidth();
            int measuredHeight2 = y41Var.a.getMeasuredHeight();
            float f = this.f ? 0.0f : 15.0f;
            if (bubblePosition != BubblePosition.UP && bubblePosition != BubblePosition.DOWN) {
                if (bubblePosition == BubblePosition.LEFT || bubblePosition == BubblePosition.RIGHT) {
                    int i3 = measuredHeight / 2;
                    if (i3 >= i2) {
                        iArr2[1] = q01.c.a(context, f);
                    } else if (i3 >= measuredHeight2 - i2) {
                        iArr2[1] = (measuredHeight2 - measuredHeight) - q01.c.a(context, f);
                    } else {
                        iArr2[1] = iArr[1] - (y41Var.b.getMeasuredHeight() / 2);
                    }
                    if (bubblePosition == BubblePosition.LEFT) {
                        iArr2[0] = iArr[0] - y41Var.b.getMeasuredWidth();
                    } else {
                        iArr2[0] = iArr[0];
                    }
                }
            } else {
                int i4 = measuredWidth / 2;
                if (i4 >= i) {
                    iArr2[0] = q01.c.a(context, f);
                } else if (i4 >= measuredWidth2 - i) {
                    iArr2[0] = (measuredWidth2 - measuredWidth) - q01.c.a(context, f);
                } else {
                    iArr2[0] = iArr[0] - (y41Var.b.getMeasuredWidth() / 2);
                }
                if (bubblePosition == BubblePosition.UP) {
                    iArr2[1] = iArr[1] - y41Var.b.getMeasuredHeight();
                } else {
                    iArr2[1] = iArr[1];
                }
            }
            return iArr2;
        }
        return (int[]) invokeLLL.objValue;
    }

    public BubblePosition b(y41 y41Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, y41Var)) == null) {
            if (!y41Var.i()) {
                return BubblePosition.INVALID;
            }
            if (this.d) {
                if (n(y41Var)) {
                    return BubblePosition.UP;
                }
                if (j(y41Var)) {
                    return BubblePosition.DOWN;
                }
                if (k(y41Var)) {
                    return BubblePosition.LEFT;
                }
                if (m(y41Var)) {
                    return BubblePosition.RIGHT;
                }
                return BubblePosition.INVALID;
            } else if (l(y41Var, this.e)) {
                return this.e;
            } else {
                return BubblePosition.INVALID;
            }
        }
        return (BubblePosition) invokeL.objValue;
    }

    public final int c(y41 y41Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, y41Var)) == null) ? (y41Var.a.getMeasuredHeight() - g(y41Var)[1]) - (y41Var.c.getMeasuredHeight() / 2) : invokeL.intValue;
    }

    public final int d(y41 y41Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, y41Var)) == null) ? g(y41Var)[0] + (y41Var.c.getMeasuredWidth() / 2) : invokeL.intValue;
    }

    public int e(y41 y41Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, y41Var)) == null) ? (y41Var.a.getMeasuredWidth() - g(y41Var)[0]) - (y41Var.c.getMeasuredWidth() / 2) : invokeL.intValue;
    }

    public final int f(y41 y41Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, y41Var)) == null) ? g(y41Var)[1] + (y41Var.c.getMeasuredHeight() / 2) : invokeL.intValue;
    }

    public final int[] g(y41 y41Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, y41Var)) == null) {
            int[] iArr = new int[2];
            y41Var.c.getLocationOnScreen(iArr);
            int[] iArr2 = new int[2];
            y41Var.a.getLocationOnScreen(iArr2);
            return new int[]{iArr[0] - iArr2[0], iArr[1] - iArr2[1]};
        }
        return (int[]) invokeL.objValue;
    }

    public final int h(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, context)) == null) {
            if (this.f) {
                return context.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f07050e);
            }
            return context.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f07050d);
        }
        return invokeL.intValue;
    }

    public int[] i(BubblePosition bubblePosition, y41 y41Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, bubblePosition, y41Var)) == null) {
            if (bubblePosition == null || y41Var == null) {
                return new int[]{0, 0};
            }
            int[] iArr = new int[2];
            y41Var.c.getLocationOnScreen(iArr);
            int[] iArr2 = new int[2];
            y41Var.a.getLocationOnScreen(iArr2);
            int[] iArr3 = new int[2];
            if (bubblePosition == BubblePosition.UP) {
                iArr3[0] = iArr[0] - iArr2[0];
                if (!this.a) {
                    iArr3[0] = iArr3[0] + (y41Var.c.getMeasuredWidth() / 2);
                }
                iArr3[1] = (iArr[1] - iArr2[1]) - q01.c.a(y41Var.c.getContext(), this.b);
            } else if (bubblePosition == BubblePosition.DOWN) {
                iArr3[0] = iArr[0] - iArr2[0];
                if (!this.a) {
                    iArr3[0] = iArr3[0] + (y41Var.c.getMeasuredWidth() / 2);
                }
                iArr3[1] = (iArr[1] - iArr2[1]) + y41Var.c.getMeasuredHeight() + q01.c.a(y41Var.c.getContext(), this.b);
            } else if (bubblePosition == BubblePosition.LEFT) {
                iArr3[0] = ((iArr[0] - iArr2[0]) - (y41Var.i.getMeasuredWidth() / 2)) - q01.c.a(y41Var.c.getContext(), this.b);
                iArr3[1] = (iArr[1] - iArr2[1]) + (y41Var.c.getMeasuredHeight() / 2);
            } else if (bubblePosition == BubblePosition.RIGHT) {
                iArr3[0] = (iArr[0] - iArr2[0]) + y41Var.c.getMeasuredWidth() + q01.c.a(y41Var.c.getContext(), this.b);
                iArr3[1] = (iArr[1] - iArr2[1]) + (y41Var.c.getMeasuredHeight() / 2);
            }
            int[] a2 = a(y41Var, iArr3, bubblePosition);
            if (bubblePosition != BubblePosition.UP && bubblePosition != BubblePosition.DOWN) {
                if (bubblePosition == BubblePosition.LEFT || bubblePosition == BubblePosition.RIGHT) {
                    y41Var.g.setY(((iArr3[1] - a2[1]) - Math.max(y41Var.j.getMeasuredHeight() / 2, y41Var.k.getMeasuredHeight() / 2)) + this.c);
                }
            } else {
                y41Var.g.setX(((iArr3[0] - a2[0]) - Math.max(y41Var.i.getMeasuredWidth() / 2, y41Var.h.getMeasuredWidth() / 2)) + this.c);
            }
            return a2;
        }
        return (int[]) invokeLL.objValue;
    }

    public final boolean j(y41 y41Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, y41Var)) == null) ? y41Var.b.getMeasuredHeight() + q01.c.a(y41Var.c.getContext(), this.b) <= (y41Var.a.getMeasuredHeight() - y41Var.c.getMeasuredHeight()) - g(y41Var)[1] && p(y41Var) : invokeL.booleanValue;
    }

    public final boolean k(y41 y41Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, y41Var)) == null) ? y41Var.b.getMeasuredWidth() + q01.c.a(y41Var.c.getContext(), this.b) <= g(y41Var)[0] && o(y41Var) : invokeL.booleanValue;
    }

    public final boolean l(y41 y41Var, BubblePosition bubblePosition) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048587, this, y41Var, bubblePosition)) == null) {
            int i = a.a[bubblePosition.ordinal()];
            if (i != 1) {
                if (i != 2) {
                    if (i != 3) {
                        if (i != 4) {
                            return false;
                        }
                        return m(y41Var);
                    }
                    return k(y41Var);
                }
                return j(y41Var);
            }
            return n(y41Var);
        }
        return invokeLL.booleanValue;
    }

    public final boolean m(y41 y41Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, y41Var)) == null) ? y41Var.b.getMeasuredWidth() + q01.c.a(y41Var.c.getContext(), this.b) <= (y41Var.a.getMeasuredWidth() - y41Var.c.getMeasuredWidth()) - g(y41Var)[0] && o(y41Var) : invokeL.booleanValue;
    }

    public final boolean n(y41 y41Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048589, this, y41Var)) == null) ? y41Var.b.getMeasuredHeight() + q01.c.a(y41Var.c.getContext(), this.b) <= g(y41Var)[1] && p(y41Var) : invokeL.booleanValue;
    }

    public final boolean o(y41 y41Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048590, this, y41Var)) == null) {
            float f = this.f ? 0.0f : 15.0f;
            Context context = y41Var.c.getContext();
            int a2 = q01.c.a(context, f) + context.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f07050d) + (context.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f070507) / 2);
            return a2 <= f(y41Var) && a2 <= c(y41Var);
        }
        return invokeL.booleanValue;
    }

    public final boolean p(y41 y41Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048591, this, y41Var)) == null) {
            float f = this.f ? 0.0f : 15.0f;
            Context context = y41Var.c.getContext();
            int a2 = q01.c.a(context, f) + (h(context) / 2) + (context.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f070514) / 2);
            return a2 <= d(y41Var) && a2 <= e(y41Var);
        }
        return invokeL.booleanValue;
    }

    public void q(float f) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048592, this, f) == null) {
            this.b = f;
        }
    }
}
