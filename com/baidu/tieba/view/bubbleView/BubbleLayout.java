package com.baidu.tieba.view.bubbleView;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class BubbleLayout extends FrameLayout {
    public static /* synthetic */ Interceptable $ic = null;
    public static float j = -1.0f;
    public transient /* synthetic */ FieldHolder $fh;
    public ArrowDirection a;

    /* renamed from: b  reason: collision with root package name */
    public c.a.p0.q4.k.a f37022b;

    /* renamed from: c  reason: collision with root package name */
    public float f37023c;

    /* renamed from: d  reason: collision with root package name */
    public float f37024d;

    /* renamed from: e  reason: collision with root package name */
    public float f37025e;

    /* renamed from: f  reason: collision with root package name */
    public float f37026f;

    /* renamed from: g  reason: collision with root package name */
    public int f37027g;

    /* renamed from: h  reason: collision with root package name */
    public float f37028h;
    public int i;

    /* loaded from: classes6.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public static final /* synthetic */ int[] a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-458754618, "Lcom/baidu/tieba/view/bubbleView/BubbleLayout$a;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-458754618, "Lcom/baidu/tieba/view/bubbleView/BubbleLayout$a;");
                    return;
                }
            }
            int[] iArr = new int[ArrowDirection.values().length];
            a = iArr;
            try {
                iArr[ArrowDirection.LEFT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[ArrowDirection.RIGHT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[ArrowDirection.TOP.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[ArrowDirection.BOTTOM.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1626336483, "Lcom/baidu/tieba/view/bubbleView/BubbleLayout;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1626336483, "Lcom/baidu/tieba/view/bubbleView/BubbleLayout;");
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public BubbleLayout(Context context) {
        this(context, null, 0);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    public static float a(float f2, Context context) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, null, new Object[]{Float.valueOf(f2), context})) == null) ? f2 * (context.getResources().getDisplayMetrics().densityDpi / 160.0f) : invokeCommon.floatValue;
    }

    public final void b(int i, int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIIII(1048576, this, i, i2, i3, i4) == null) || i2 < i || i4 < i3) {
            return;
        }
        this.f37022b = new c.a.p0.q4.k.a(new RectF(i, i3, i2, i4), this.f37023c, this.f37024d, this.f37025e, this.f37026f, this.f37028h, this.i, this.f37027g, this.a);
    }

    public final void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            int paddingLeft = getPaddingLeft();
            int paddingRight = getPaddingRight();
            int paddingTop = getPaddingTop();
            int paddingBottom = getPaddingBottom();
            int i = a.a[this.a.ordinal()];
            if (i == 1) {
                paddingLeft = (int) (paddingLeft + this.f37023c);
            } else if (i == 2) {
                paddingRight = (int) (paddingRight + this.f37023c);
            } else if (i == 3) {
                paddingTop = (int) (paddingTop + this.f37025e);
            } else if (i == 4) {
                paddingBottom = (int) (paddingBottom + this.f37025e);
            }
            float f2 = this.f37028h;
            if (f2 > 0.0f) {
                paddingLeft = (int) (paddingLeft + f2);
                paddingRight = (int) (paddingRight + f2);
                paddingTop = (int) (paddingTop + f2);
                paddingBottom = (int) (paddingBottom + f2);
            }
            setPadding(paddingLeft, paddingTop, paddingRight, paddingBottom);
        }
    }

    public BubbleLayout d(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i)) == null) {
            this.f37027g = i;
            requestLayout();
            return this;
        }
        return (BubbleLayout) invokeI.objValue;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, canvas) == null) {
            c.a.p0.q4.k.a aVar = this.f37022b;
            if (aVar != null) {
                aVar.draw(canvas);
            }
            super.dispatchDraw(canvas);
        }
    }

    public ArrowDirection getArrowDirection() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.a : (ArrowDirection) invokeV.objValue;
    }

    public float getArrowHeight() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f37025e : invokeV.floatValue;
    }

    public float getArrowPosition() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f37026f : invokeV.floatValue;
    }

    public float getArrowWidth() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f37023c : invokeV.floatValue;
    }

    public int getBubbleColor() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.f37027g : invokeV.intValue;
    }

    public float getCornersRadius() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.f37024d : invokeV.floatValue;
    }

    public int getStrokeColor() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.i : invokeV.intValue;
    }

    public float getStrokeWidth() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.f37028h : invokeV.floatValue;
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048588, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)}) == null) {
            super.onLayout(z, i, i2, i3, i4);
            b(0, getWidth(), 0, getHeight());
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public BubbleLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65538, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BubbleLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i)};
            interceptable.invokeUnInit(65539, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65539, newInitContext);
                return;
            }
        }
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, new int[]{R.attr.obfuscated_res_0x7f0400d5, R.attr.obfuscated_res_0x7f0400d6, R.attr.obfuscated_res_0x7f0400d7, R.attr.obfuscated_res_0x7f0400d8, R.attr.obfuscated_res_0x7f0400d9, R.attr.obfuscated_res_0x7f0400da, R.attr.obfuscated_res_0x7f0400db, R.attr.obfuscated_res_0x7f0405d6});
        this.f37023c = obtainStyledAttributes.getDimension(2, a(8.0f, context));
        this.f37025e = obtainStyledAttributes.getDimension(0, a(8.0f, context));
        this.f37024d = obtainStyledAttributes.getDimension(4, 0.0f);
        this.f37026f = obtainStyledAttributes.getDimension(1, a(12.0f, context));
        this.f37027g = obtainStyledAttributes.getColor(3, -1);
        this.f37028h = obtainStyledAttributes.getDimension(6, j);
        this.i = obtainStyledAttributes.getColor(5, -7829368);
        this.a = ArrowDirection.fromInt(obtainStyledAttributes.getInt(7, ArrowDirection.LEFT.getValue()));
        obtainStyledAttributes.recycle();
        c();
    }
}
