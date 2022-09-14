package com.baidu.tieba;

import android.content.Context;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nadcore.widget.bubble.BubblePosition;
import com.baidu.tieba.g21;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class j61 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean a;
    public float b;
    public float c;
    public boolean d;
    public BubblePosition e;
    public boolean f;

    /* loaded from: classes4.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public static final /* synthetic */ int[] a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-736190553, "Lcom/baidu/tieba/j61$a;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-736190553, "Lcom/baidu/tieba/j61$a;");
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

    public j61() {
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

    public int[] a(r61 r61Var, int[] iArr, BubblePosition bubblePosition) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, r61Var, iArr, bubblePosition)) == null) {
            if (r61Var == null) {
                return new int[]{0, 0};
            }
            if (bubblePosition == BubblePosition.INVALID) {
                return iArr;
            }
            Context context = r61Var.a.getContext();
            int i = iArr[0];
            int i2 = iArr[1];
            int[] iArr2 = new int[2];
            int measuredWidth = r61Var.b.getMeasuredWidth();
            int measuredHeight = r61Var.b.getMeasuredHeight();
            int measuredWidth2 = r61Var.a.getMeasuredWidth();
            int measuredHeight2 = r61Var.a.getMeasuredHeight();
            float f = this.f ? 0.0f : 15.0f;
            if (bubblePosition != BubblePosition.UP && bubblePosition != BubblePosition.DOWN) {
                if (bubblePosition == BubblePosition.LEFT || bubblePosition == BubblePosition.RIGHT) {
                    int i3 = measuredHeight / 2;
                    if (i3 >= i2) {
                        iArr2[1] = g21.c.a(context, f);
                    } else if (i3 >= measuredHeight2 - i2) {
                        iArr2[1] = (measuredHeight2 - measuredHeight) - g21.c.a(context, f);
                    } else {
                        iArr2[1] = iArr[1] - (r61Var.b.getMeasuredHeight() / 2);
                    }
                    if (bubblePosition == BubblePosition.LEFT) {
                        iArr2[0] = iArr[0] - r61Var.b.getMeasuredWidth();
                    } else {
                        iArr2[0] = iArr[0];
                    }
                }
            } else {
                int i4 = measuredWidth / 2;
                if (i4 >= i) {
                    iArr2[0] = g21.c.a(context, f);
                } else if (i4 >= measuredWidth2 - i) {
                    iArr2[0] = (measuredWidth2 - measuredWidth) - g21.c.a(context, f);
                } else {
                    iArr2[0] = iArr[0] - (r61Var.b.getMeasuredWidth() / 2);
                }
                if (bubblePosition == BubblePosition.UP) {
                    iArr2[1] = iArr[1] - r61Var.b.getMeasuredHeight();
                } else {
                    iArr2[1] = iArr[1];
                }
            }
            return iArr2;
        }
        return (int[]) invokeLLL.objValue;
    }

    public BubblePosition b(r61 r61Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, r61Var)) == null) {
            if (!r61Var.i()) {
                return BubblePosition.INVALID;
            }
            if (this.d) {
                if (n(r61Var)) {
                    return BubblePosition.UP;
                }
                if (j(r61Var)) {
                    return BubblePosition.DOWN;
                }
                if (k(r61Var)) {
                    return BubblePosition.LEFT;
                }
                if (m(r61Var)) {
                    return BubblePosition.RIGHT;
                }
                return BubblePosition.INVALID;
            } else if (l(r61Var, this.e)) {
                return this.e;
            } else {
                return BubblePosition.INVALID;
            }
        }
        return (BubblePosition) invokeL.objValue;
    }

    public final int c(r61 r61Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, r61Var)) == null) ? (r61Var.a.getMeasuredHeight() - g(r61Var)[1]) - (r61Var.c.getMeasuredHeight() / 2) : invokeL.intValue;
    }

    public final int d(r61 r61Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, r61Var)) == null) ? g(r61Var)[0] + (r61Var.c.getMeasuredWidth() / 2) : invokeL.intValue;
    }

    public int e(r61 r61Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, r61Var)) == null) ? (r61Var.a.getMeasuredWidth() - g(r61Var)[0]) - (r61Var.c.getMeasuredWidth() / 2) : invokeL.intValue;
    }

    public final int f(r61 r61Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, r61Var)) == null) ? g(r61Var)[1] + (r61Var.c.getMeasuredHeight() / 2) : invokeL.intValue;
    }

    public final int[] g(r61 r61Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, r61Var)) == null) {
            int[] iArr = new int[2];
            r61Var.c.getLocationOnScreen(iArr);
            int[] iArr2 = new int[2];
            r61Var.a.getLocationOnScreen(iArr2);
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

    public int[] i(BubblePosition bubblePosition, r61 r61Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, bubblePosition, r61Var)) == null) {
            if (bubblePosition == null || r61Var == null) {
                return new int[]{0, 0};
            }
            int[] iArr = new int[2];
            r61Var.c.getLocationOnScreen(iArr);
            int[] iArr2 = new int[2];
            r61Var.a.getLocationOnScreen(iArr2);
            int[] iArr3 = new int[2];
            if (bubblePosition == BubblePosition.UP) {
                iArr3[0] = iArr[0] - iArr2[0];
                if (!this.a) {
                    iArr3[0] = iArr3[0] + (r61Var.c.getMeasuredWidth() / 2);
                }
                iArr3[1] = (iArr[1] - iArr2[1]) - g21.c.a(r61Var.c.getContext(), this.b);
            } else if (bubblePosition == BubblePosition.DOWN) {
                iArr3[0] = iArr[0] - iArr2[0];
                if (!this.a) {
                    iArr3[0] = iArr3[0] + (r61Var.c.getMeasuredWidth() / 2);
                }
                iArr3[1] = (iArr[1] - iArr2[1]) + r61Var.c.getMeasuredHeight() + g21.c.a(r61Var.c.getContext(), this.b);
            } else if (bubblePosition == BubblePosition.LEFT) {
                iArr3[0] = ((iArr[0] - iArr2[0]) - (r61Var.i.getMeasuredWidth() / 2)) - g21.c.a(r61Var.c.getContext(), this.b);
                iArr3[1] = (iArr[1] - iArr2[1]) + (r61Var.c.getMeasuredHeight() / 2);
            } else if (bubblePosition == BubblePosition.RIGHT) {
                iArr3[0] = (iArr[0] - iArr2[0]) + r61Var.c.getMeasuredWidth() + g21.c.a(r61Var.c.getContext(), this.b);
                iArr3[1] = (iArr[1] - iArr2[1]) + (r61Var.c.getMeasuredHeight() / 2);
            }
            int[] a2 = a(r61Var, iArr3, bubblePosition);
            if (bubblePosition != BubblePosition.UP && bubblePosition != BubblePosition.DOWN) {
                if (bubblePosition == BubblePosition.LEFT || bubblePosition == BubblePosition.RIGHT) {
                    r61Var.g.setY(((iArr3[1] - a2[1]) - Math.max(r61Var.j.getMeasuredHeight() / 2, r61Var.k.getMeasuredHeight() / 2)) + this.c);
                }
            } else {
                r61Var.g.setX(((iArr3[0] - a2[0]) - Math.max(r61Var.i.getMeasuredWidth() / 2, r61Var.h.getMeasuredWidth() / 2)) + this.c);
            }
            return a2;
        }
        return (int[]) invokeLL.objValue;
    }

    public final boolean j(r61 r61Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, r61Var)) == null) ? r61Var.b.getMeasuredHeight() + g21.c.a(r61Var.c.getContext(), this.b) <= (r61Var.a.getMeasuredHeight() - r61Var.c.getMeasuredHeight()) - g(r61Var)[1] && p(r61Var) : invokeL.booleanValue;
    }

    public final boolean k(r61 r61Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, r61Var)) == null) ? r61Var.b.getMeasuredWidth() + g21.c.a(r61Var.c.getContext(), this.b) <= g(r61Var)[0] && o(r61Var) : invokeL.booleanValue;
    }

    public final boolean l(r61 r61Var, BubblePosition bubblePosition) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048587, this, r61Var, bubblePosition)) == null) {
            int i = a.a[bubblePosition.ordinal()];
            if (i != 1) {
                if (i != 2) {
                    if (i != 3) {
                        if (i != 4) {
                            return false;
                        }
                        return m(r61Var);
                    }
                    return k(r61Var);
                }
                return j(r61Var);
            }
            return n(r61Var);
        }
        return invokeLL.booleanValue;
    }

    public final boolean m(r61 r61Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, r61Var)) == null) ? r61Var.b.getMeasuredWidth() + g21.c.a(r61Var.c.getContext(), this.b) <= (r61Var.a.getMeasuredWidth() - r61Var.c.getMeasuredWidth()) - g(r61Var)[0] && o(r61Var) : invokeL.booleanValue;
    }

    public final boolean n(r61 r61Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048589, this, r61Var)) == null) ? r61Var.b.getMeasuredHeight() + g21.c.a(r61Var.c.getContext(), this.b) <= g(r61Var)[1] && p(r61Var) : invokeL.booleanValue;
    }

    public final boolean o(r61 r61Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048590, this, r61Var)) == null) {
            float f = this.f ? 0.0f : 15.0f;
            Context context = r61Var.c.getContext();
            int a2 = g21.c.a(context, f) + context.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f07050d) + (context.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f070507) / 2);
            return a2 <= f(r61Var) && a2 <= c(r61Var);
        }
        return invokeL.booleanValue;
    }

    public final boolean p(r61 r61Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048591, this, r61Var)) == null) {
            float f = this.f ? 0.0f : 15.0f;
            Context context = r61Var.c.getContext();
            int a2 = g21.c.a(context, f) + (h(context) / 2) + (context.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f070514) / 2);
            return a2 <= d(r61Var) && a2 <= e(r61Var);
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
