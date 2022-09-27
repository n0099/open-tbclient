package com.baidu.tieba;

import android.content.Context;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nadcore.widget.bubble.BubblePosition;
import com.baidu.tieba.t21;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class w61 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean a;
    public float b;
    public float c;
    public boolean d;
    public BubblePosition e;
    public boolean f;

    /* loaded from: classes6.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public static final /* synthetic */ int[] a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-364011590, "Lcom/baidu/tieba/w61$a;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-364011590, "Lcom/baidu/tieba/w61$a;");
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

    public w61() {
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

    public int[] a(e71 e71Var, int[] iArr, BubblePosition bubblePosition) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, e71Var, iArr, bubblePosition)) == null) {
            if (e71Var == null) {
                return new int[]{0, 0};
            }
            if (bubblePosition == BubblePosition.INVALID) {
                return iArr;
            }
            Context context = e71Var.a.getContext();
            int i = iArr[0];
            int i2 = iArr[1];
            int[] iArr2 = new int[2];
            int measuredWidth = e71Var.b.getMeasuredWidth();
            int measuredHeight = e71Var.b.getMeasuredHeight();
            int measuredWidth2 = e71Var.a.getMeasuredWidth();
            int measuredHeight2 = e71Var.a.getMeasuredHeight();
            float f = this.f ? 0.0f : 15.0f;
            if (bubblePosition != BubblePosition.UP && bubblePosition != BubblePosition.DOWN) {
                if (bubblePosition == BubblePosition.LEFT || bubblePosition == BubblePosition.RIGHT) {
                    int i3 = measuredHeight / 2;
                    if (i3 >= i2) {
                        iArr2[1] = t21.c.a(context, f);
                    } else if (i3 >= measuredHeight2 - i2) {
                        iArr2[1] = (measuredHeight2 - measuredHeight) - t21.c.a(context, f);
                    } else {
                        iArr2[1] = iArr[1] - (e71Var.b.getMeasuredHeight() / 2);
                    }
                    if (bubblePosition == BubblePosition.LEFT) {
                        iArr2[0] = iArr[0] - e71Var.b.getMeasuredWidth();
                    } else {
                        iArr2[0] = iArr[0];
                    }
                }
            } else {
                int i4 = measuredWidth / 2;
                if (i4 >= i) {
                    iArr2[0] = t21.c.a(context, f);
                } else if (i4 >= measuredWidth2 - i) {
                    iArr2[0] = (measuredWidth2 - measuredWidth) - t21.c.a(context, f);
                } else {
                    iArr2[0] = iArr[0] - (e71Var.b.getMeasuredWidth() / 2);
                }
                if (bubblePosition == BubblePosition.UP) {
                    iArr2[1] = iArr[1] - e71Var.b.getMeasuredHeight();
                } else {
                    iArr2[1] = iArr[1];
                }
            }
            return iArr2;
        }
        return (int[]) invokeLLL.objValue;
    }

    public BubblePosition b(e71 e71Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, e71Var)) == null) {
            if (!e71Var.i()) {
                return BubblePosition.INVALID;
            }
            if (this.d) {
                if (n(e71Var)) {
                    return BubblePosition.UP;
                }
                if (j(e71Var)) {
                    return BubblePosition.DOWN;
                }
                if (k(e71Var)) {
                    return BubblePosition.LEFT;
                }
                if (m(e71Var)) {
                    return BubblePosition.RIGHT;
                }
                return BubblePosition.INVALID;
            } else if (l(e71Var, this.e)) {
                return this.e;
            } else {
                return BubblePosition.INVALID;
            }
        }
        return (BubblePosition) invokeL.objValue;
    }

    public final int c(e71 e71Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, e71Var)) == null) ? (e71Var.a.getMeasuredHeight() - g(e71Var)[1]) - (e71Var.c.getMeasuredHeight() / 2) : invokeL.intValue;
    }

    public final int d(e71 e71Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, e71Var)) == null) ? g(e71Var)[0] + (e71Var.c.getMeasuredWidth() / 2) : invokeL.intValue;
    }

    public int e(e71 e71Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, e71Var)) == null) ? (e71Var.a.getMeasuredWidth() - g(e71Var)[0]) - (e71Var.c.getMeasuredWidth() / 2) : invokeL.intValue;
    }

    public final int f(e71 e71Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, e71Var)) == null) ? g(e71Var)[1] + (e71Var.c.getMeasuredHeight() / 2) : invokeL.intValue;
    }

    public final int[] g(e71 e71Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, e71Var)) == null) {
            int[] iArr = new int[2];
            e71Var.c.getLocationOnScreen(iArr);
            int[] iArr2 = new int[2];
            e71Var.a.getLocationOnScreen(iArr2);
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

    public int[] i(BubblePosition bubblePosition, e71 e71Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, bubblePosition, e71Var)) == null) {
            if (bubblePosition == null || e71Var == null) {
                return new int[]{0, 0};
            }
            int[] iArr = new int[2];
            e71Var.c.getLocationOnScreen(iArr);
            int[] iArr2 = new int[2];
            e71Var.a.getLocationOnScreen(iArr2);
            int[] iArr3 = new int[2];
            if (bubblePosition == BubblePosition.UP) {
                iArr3[0] = iArr[0] - iArr2[0];
                if (!this.a) {
                    iArr3[0] = iArr3[0] + (e71Var.c.getMeasuredWidth() / 2);
                }
                iArr3[1] = (iArr[1] - iArr2[1]) - t21.c.a(e71Var.c.getContext(), this.b);
            } else if (bubblePosition == BubblePosition.DOWN) {
                iArr3[0] = iArr[0] - iArr2[0];
                if (!this.a) {
                    iArr3[0] = iArr3[0] + (e71Var.c.getMeasuredWidth() / 2);
                }
                iArr3[1] = (iArr[1] - iArr2[1]) + e71Var.c.getMeasuredHeight() + t21.c.a(e71Var.c.getContext(), this.b);
            } else if (bubblePosition == BubblePosition.LEFT) {
                iArr3[0] = ((iArr[0] - iArr2[0]) - (e71Var.i.getMeasuredWidth() / 2)) - t21.c.a(e71Var.c.getContext(), this.b);
                iArr3[1] = (iArr[1] - iArr2[1]) + (e71Var.c.getMeasuredHeight() / 2);
            } else if (bubblePosition == BubblePosition.RIGHT) {
                iArr3[0] = (iArr[0] - iArr2[0]) + e71Var.c.getMeasuredWidth() + t21.c.a(e71Var.c.getContext(), this.b);
                iArr3[1] = (iArr[1] - iArr2[1]) + (e71Var.c.getMeasuredHeight() / 2);
            }
            int[] a2 = a(e71Var, iArr3, bubblePosition);
            if (bubblePosition != BubblePosition.UP && bubblePosition != BubblePosition.DOWN) {
                if (bubblePosition == BubblePosition.LEFT || bubblePosition == BubblePosition.RIGHT) {
                    e71Var.g.setY(((iArr3[1] - a2[1]) - Math.max(e71Var.j.getMeasuredHeight() / 2, e71Var.k.getMeasuredHeight() / 2)) + this.c);
                }
            } else {
                e71Var.g.setX(((iArr3[0] - a2[0]) - Math.max(e71Var.i.getMeasuredWidth() / 2, e71Var.h.getMeasuredWidth() / 2)) + this.c);
            }
            return a2;
        }
        return (int[]) invokeLL.objValue;
    }

    public final boolean j(e71 e71Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, e71Var)) == null) ? e71Var.b.getMeasuredHeight() + t21.c.a(e71Var.c.getContext(), this.b) <= (e71Var.a.getMeasuredHeight() - e71Var.c.getMeasuredHeight()) - g(e71Var)[1] && p(e71Var) : invokeL.booleanValue;
    }

    public final boolean k(e71 e71Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, e71Var)) == null) ? e71Var.b.getMeasuredWidth() + t21.c.a(e71Var.c.getContext(), this.b) <= g(e71Var)[0] && o(e71Var) : invokeL.booleanValue;
    }

    public final boolean l(e71 e71Var, BubblePosition bubblePosition) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048587, this, e71Var, bubblePosition)) == null) {
            int i = a.a[bubblePosition.ordinal()];
            if (i != 1) {
                if (i != 2) {
                    if (i != 3) {
                        if (i != 4) {
                            return false;
                        }
                        return m(e71Var);
                    }
                    return k(e71Var);
                }
                return j(e71Var);
            }
            return n(e71Var);
        }
        return invokeLL.booleanValue;
    }

    public final boolean m(e71 e71Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, e71Var)) == null) ? e71Var.b.getMeasuredWidth() + t21.c.a(e71Var.c.getContext(), this.b) <= (e71Var.a.getMeasuredWidth() - e71Var.c.getMeasuredWidth()) - g(e71Var)[0] && o(e71Var) : invokeL.booleanValue;
    }

    public final boolean n(e71 e71Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048589, this, e71Var)) == null) ? e71Var.b.getMeasuredHeight() + t21.c.a(e71Var.c.getContext(), this.b) <= g(e71Var)[1] && p(e71Var) : invokeL.booleanValue;
    }

    public final boolean o(e71 e71Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048590, this, e71Var)) == null) {
            float f = this.f ? 0.0f : 15.0f;
            Context context = e71Var.c.getContext();
            int a2 = t21.c.a(context, f) + context.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f07050d) + (context.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f070507) / 2);
            return a2 <= f(e71Var) && a2 <= c(e71Var);
        }
        return invokeL.booleanValue;
    }

    public final boolean p(e71 e71Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048591, this, e71Var)) == null) {
            float f = this.f ? 0.0f : 15.0f;
            Context context = e71Var.c.getContext();
            int a2 = t21.c.a(context, f) + (h(context) / 2) + (context.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f070514) / 2);
            return a2 <= d(e71Var) && a2 <= e(e71Var);
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
