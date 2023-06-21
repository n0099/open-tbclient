package com.baidu.tieba;

import android.content.Context;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nadcore.widget.bubble.BubblePosition;
import com.baidu.tieba.d61;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class jd1 {
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
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-693708587, "Lcom/baidu/tieba/jd1$a;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-693708587, "Lcom/baidu/tieba/jd1$a;");
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

    public jd1() {
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

    public int[] a(rd1 rd1Var, int[] iArr, BubblePosition bubblePosition) {
        InterceptResult invokeLLL;
        float f;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, rd1Var, iArr, bubblePosition)) == null) {
            if (rd1Var == null) {
                return new int[]{0, 0};
            }
            if (bubblePosition == BubblePosition.INVALID) {
                return iArr;
            }
            Context context = rd1Var.a.getContext();
            int i = iArr[0];
            int i2 = iArr[1];
            int[] iArr2 = new int[2];
            int measuredWidth = rd1Var.b.getMeasuredWidth();
            int measuredHeight = rd1Var.b.getMeasuredHeight();
            int measuredWidth2 = rd1Var.a.getMeasuredWidth();
            int measuredHeight2 = rd1Var.a.getMeasuredHeight();
            if (this.f) {
                f = 0.0f;
            } else {
                f = 15.0f;
            }
            if (bubblePosition != BubblePosition.UP && bubblePosition != BubblePosition.DOWN) {
                if (bubblePosition == BubblePosition.LEFT || bubblePosition == BubblePosition.RIGHT) {
                    int i3 = measuredHeight / 2;
                    if (i3 >= i2) {
                        iArr2[1] = d61.c.a(context, f);
                    } else if (i3 >= measuredHeight2 - i2) {
                        iArr2[1] = (measuredHeight2 - measuredHeight) - d61.c.a(context, f);
                    } else {
                        iArr2[1] = iArr[1] - (rd1Var.b.getMeasuredHeight() / 2);
                    }
                    if (bubblePosition == BubblePosition.LEFT) {
                        iArr2[0] = iArr[0] - rd1Var.b.getMeasuredWidth();
                    } else {
                        iArr2[0] = iArr[0];
                    }
                }
            } else {
                int i4 = measuredWidth / 2;
                if (i4 >= i) {
                    iArr2[0] = d61.c.a(context, f);
                } else if (i4 >= measuredWidth2 - i) {
                    iArr2[0] = (measuredWidth2 - measuredWidth) - d61.c.a(context, f);
                } else {
                    iArr2[0] = iArr[0] - (rd1Var.b.getMeasuredWidth() / 2);
                }
                if (bubblePosition == BubblePosition.UP) {
                    iArr2[1] = iArr[1] - rd1Var.b.getMeasuredHeight();
                } else {
                    iArr2[1] = iArr[1];
                }
            }
            return iArr2;
        }
        return (int[]) invokeLLL.objValue;
    }

    public BubblePosition b(rd1 rd1Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, rd1Var)) == null) {
            if (!rd1Var.i()) {
                return BubblePosition.INVALID;
            }
            if (this.d) {
                if (n(rd1Var)) {
                    return BubblePosition.UP;
                }
                if (j(rd1Var)) {
                    return BubblePosition.DOWN;
                }
                if (k(rd1Var)) {
                    return BubblePosition.LEFT;
                }
                if (m(rd1Var)) {
                    return BubblePosition.RIGHT;
                }
                return BubblePosition.INVALID;
            } else if (l(rd1Var, this.e)) {
                return this.e;
            } else {
                return BubblePosition.INVALID;
            }
        }
        return (BubblePosition) invokeL.objValue;
    }

    public final boolean o(rd1 rd1Var) {
        InterceptResult invokeL;
        float f;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048590, this, rd1Var)) == null) {
            if (this.f) {
                f = 0.0f;
            } else {
                f = 15.0f;
            }
            Context context = rd1Var.c.getContext();
            int a2 = d61.c.a(context, f) + context.getResources().getDimensionPixelSize(R.dimen.nad_bubble_radius) + (context.getResources().getDimensionPixelSize(R.dimen.nad_bubble_horizontal_arrow_view_height) / 2);
            if (a2 <= f(rd1Var) && a2 <= c(rd1Var)) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public final boolean p(rd1 rd1Var) {
        InterceptResult invokeL;
        float f;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048591, this, rd1Var)) == null) {
            if (this.f) {
                f = 0.0f;
            } else {
                f = 15.0f;
            }
            Context context = rd1Var.c.getContext();
            int a2 = d61.c.a(context, f) + (h(context) / 2) + (context.getResources().getDimensionPixelSize(R.dimen.nad_bubble_vertical_arrow_view_width) / 2);
            if (a2 <= d(rd1Var) && a2 <= e(rd1Var)) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public final int c(rd1 rd1Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, rd1Var)) == null) {
            return (rd1Var.a.getMeasuredHeight() - g(rd1Var)[1]) - (rd1Var.c.getMeasuredHeight() / 2);
        }
        return invokeL.intValue;
    }

    public final int d(rd1 rd1Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, rd1Var)) == null) {
            return g(rd1Var)[0] + (rd1Var.c.getMeasuredWidth() / 2);
        }
        return invokeL.intValue;
    }

    public int e(rd1 rd1Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, rd1Var)) == null) {
            return (rd1Var.a.getMeasuredWidth() - g(rd1Var)[0]) - (rd1Var.c.getMeasuredWidth() / 2);
        }
        return invokeL.intValue;
    }

    public final int f(rd1 rd1Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, rd1Var)) == null) {
            return g(rd1Var)[1] + (rd1Var.c.getMeasuredHeight() / 2);
        }
        return invokeL.intValue;
    }

    public final int h(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, context)) == null) {
            if (this.f) {
                return context.getResources().getDimensionPixelSize(R.dimen.nad_bubble_radius_d20);
            }
            return context.getResources().getDimensionPixelSize(R.dimen.nad_bubble_radius);
        }
        return invokeL.intValue;
    }

    public void q(float f) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048592, this, f) == null) {
            this.b = f;
        }
    }

    public final int[] g(rd1 rd1Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, rd1Var)) == null) {
            int[] iArr = new int[2];
            rd1Var.c.getLocationOnScreen(iArr);
            int[] iArr2 = new int[2];
            rd1Var.a.getLocationOnScreen(iArr2);
            return new int[]{iArr[0] - iArr2[0], iArr[1] - iArr2[1]};
        }
        return (int[]) invokeL.objValue;
    }

    public final boolean j(rd1 rd1Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, rd1Var)) == null) {
            if (rd1Var.b.getMeasuredHeight() + d61.c.a(rd1Var.c.getContext(), this.b) <= (rd1Var.a.getMeasuredHeight() - rd1Var.c.getMeasuredHeight()) - g(rd1Var)[1] && p(rd1Var)) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public final boolean k(rd1 rd1Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, rd1Var)) == null) {
            if (rd1Var.b.getMeasuredWidth() + d61.c.a(rd1Var.c.getContext(), this.b) > g(rd1Var)[0] || !o(rd1Var)) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public final boolean m(rd1 rd1Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, rd1Var)) == null) {
            if (rd1Var.b.getMeasuredWidth() + d61.c.a(rd1Var.c.getContext(), this.b) > (rd1Var.a.getMeasuredWidth() - rd1Var.c.getMeasuredWidth()) - g(rd1Var)[0] || !o(rd1Var)) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public final boolean n(rd1 rd1Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048589, this, rd1Var)) == null) {
            if (rd1Var.b.getMeasuredHeight() + d61.c.a(rd1Var.c.getContext(), this.b) <= g(rd1Var)[1] && p(rd1Var)) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public int[] i(BubblePosition bubblePosition, rd1 rd1Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, bubblePosition, rd1Var)) == null) {
            if (bubblePosition != null && rd1Var != null) {
                int[] iArr = new int[2];
                rd1Var.c.getLocationOnScreen(iArr);
                int[] iArr2 = new int[2];
                rd1Var.a.getLocationOnScreen(iArr2);
                int[] iArr3 = new int[2];
                if (bubblePosition == BubblePosition.UP) {
                    iArr3[0] = iArr[0] - iArr2[0];
                    if (!this.a) {
                        iArr3[0] = iArr3[0] + (rd1Var.c.getMeasuredWidth() / 2);
                    }
                    iArr3[1] = (iArr[1] - iArr2[1]) - d61.c.a(rd1Var.c.getContext(), this.b);
                } else if (bubblePosition == BubblePosition.DOWN) {
                    iArr3[0] = iArr[0] - iArr2[0];
                    if (!this.a) {
                        iArr3[0] = iArr3[0] + (rd1Var.c.getMeasuredWidth() / 2);
                    }
                    iArr3[1] = (iArr[1] - iArr2[1]) + rd1Var.c.getMeasuredHeight() + d61.c.a(rd1Var.c.getContext(), this.b);
                } else if (bubblePosition == BubblePosition.LEFT) {
                    iArr3[0] = ((iArr[0] - iArr2[0]) - (rd1Var.i.getMeasuredWidth() / 2)) - d61.c.a(rd1Var.c.getContext(), this.b);
                    iArr3[1] = (iArr[1] - iArr2[1]) + (rd1Var.c.getMeasuredHeight() / 2);
                } else if (bubblePosition == BubblePosition.RIGHT) {
                    iArr3[0] = (iArr[0] - iArr2[0]) + rd1Var.c.getMeasuredWidth() + d61.c.a(rd1Var.c.getContext(), this.b);
                    iArr3[1] = (iArr[1] - iArr2[1]) + (rd1Var.c.getMeasuredHeight() / 2);
                }
                int[] a2 = a(rd1Var, iArr3, bubblePosition);
                if (bubblePosition != BubblePosition.UP && bubblePosition != BubblePosition.DOWN) {
                    if (bubblePosition == BubblePosition.LEFT || bubblePosition == BubblePosition.RIGHT) {
                        rd1Var.g.setY(((iArr3[1] - a2[1]) - Math.max(rd1Var.j.getMeasuredHeight() / 2, rd1Var.k.getMeasuredHeight() / 2)) + this.c);
                    }
                } else {
                    rd1Var.g.setX(((iArr3[0] - a2[0]) - Math.max(rd1Var.i.getMeasuredWidth() / 2, rd1Var.h.getMeasuredWidth() / 2)) + this.c);
                }
                return a2;
            }
            return new int[]{0, 0};
        }
        return (int[]) invokeLL.objValue;
    }

    public final boolean l(rd1 rd1Var, BubblePosition bubblePosition) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048587, this, rd1Var, bubblePosition)) == null) {
            int i = a.a[bubblePosition.ordinal()];
            if (i != 1) {
                if (i != 2) {
                    if (i != 3) {
                        if (i != 4) {
                            return false;
                        }
                        return m(rd1Var);
                    }
                    return k(rd1Var);
                }
                return j(rd1Var);
            }
            return n(rd1Var);
        }
        return invokeLL.booleanValue;
    }
}
