package com.baidu.tieba.view.bubbleView;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.R$styleable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class BubbleLayout extends FrameLayout {
    public static /* synthetic */ Interceptable $ic = null;
    public static float DEFAULT_STROKE_WIDTH = -1.0f;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public ArrowDirection f57987e;

    /* renamed from: f  reason: collision with root package name */
    public c.a.p0.a4.i.a f57988f;

    /* renamed from: g  reason: collision with root package name */
    public float f57989g;

    /* renamed from: h  reason: collision with root package name */
    public float f57990h;

    /* renamed from: i  reason: collision with root package name */
    public float f57991i;

    /* renamed from: j  reason: collision with root package name */
    public float f57992j;
    public int k;
    public float l;
    public int m;

    /* loaded from: classes7.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f57993a;
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
            f57993a = iArr;
            try {
                iArr[ArrowDirection.LEFT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f57993a[ArrowDirection.RIGHT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f57993a[ArrowDirection.TOP.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f57993a[ArrowDirection.BOTTOM.ordinal()] = 4;
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
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

    public final void b(int i2, int i3, int i4, int i5) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIIII(1048576, this, i2, i3, i4, i5) == null) || i3 < i2 || i5 < i4) {
            return;
        }
        this.f57988f = new c.a.p0.a4.i.a(new RectF(i2, i4, i3, i5), this.f57989g, this.f57990h, this.f57991i, this.f57992j, this.l, this.m, this.k, this.f57987e);
    }

    public final void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            int paddingLeft = getPaddingLeft();
            int paddingRight = getPaddingRight();
            int paddingTop = getPaddingTop();
            int paddingBottom = getPaddingBottom();
            int i2 = a.f57993a[this.f57987e.ordinal()];
            if (i2 == 1) {
                paddingLeft = (int) (paddingLeft + this.f57989g);
            } else if (i2 == 2) {
                paddingRight = (int) (paddingRight + this.f57989g);
            } else if (i2 == 3) {
                paddingTop = (int) (paddingTop + this.f57991i);
            } else if (i2 == 4) {
                paddingBottom = (int) (paddingBottom + this.f57991i);
            }
            float f2 = this.l;
            if (f2 > 0.0f) {
                paddingLeft = (int) (paddingLeft + f2);
                paddingRight = (int) (paddingRight + f2);
                paddingTop = (int) (paddingTop + f2);
                paddingBottom = (int) (paddingBottom + f2);
            }
            setPadding(paddingLeft, paddingTop, paddingRight, paddingBottom);
        }
    }

    public final void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            int paddingLeft = getPaddingLeft();
            int paddingRight = getPaddingRight();
            int paddingTop = getPaddingTop();
            int paddingBottom = getPaddingBottom();
            int i2 = a.f57993a[this.f57987e.ordinal()];
            if (i2 == 1) {
                paddingLeft = (int) (paddingLeft - this.f57989g);
            } else if (i2 == 2) {
                paddingRight = (int) (paddingRight - this.f57989g);
            } else if (i2 == 3) {
                paddingTop = (int) (paddingTop - this.f57991i);
            } else if (i2 == 4) {
                paddingBottom = (int) (paddingBottom - this.f57991i);
            }
            float f2 = this.l;
            if (f2 > 0.0f) {
                paddingLeft = (int) (paddingLeft - f2);
                paddingRight = (int) (paddingRight - f2);
                paddingTop = (int) (paddingTop - f2);
                paddingBottom = (int) (paddingBottom - f2);
            }
            setPadding(paddingLeft, paddingTop, paddingRight, paddingBottom);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, canvas) == null) {
            c.a.p0.a4.i.a aVar = this.f57988f;
            if (aVar != null) {
                aVar.draw(canvas);
            }
            super.dispatchDraw(canvas);
        }
    }

    public ArrowDirection getArrowDirection() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f57987e : (ArrowDirection) invokeV.objValue;
    }

    public float getArrowHeight() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f57991i : invokeV.floatValue;
    }

    public float getArrowPosition() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f57992j : invokeV.floatValue;
    }

    public float getArrowWidth() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f57989g : invokeV.floatValue;
    }

    public int getBubbleColor() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.k : invokeV.intValue;
    }

    public float getCornersRadius() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.f57990h : invokeV.floatValue;
    }

    public int getStrokeColor() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.m : invokeV.intValue;
    }

    public float getStrokeWidth() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.l : invokeV.floatValue;
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048588, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5)}) == null) {
            super.onLayout(z, i2, i3, i4, i5);
            b(0, getWidth(), 0, getHeight());
        }
    }

    public BubbleLayout setArrowDirection(ArrowDirection arrowDirection) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048589, this, arrowDirection)) == null) {
            d();
            this.f57987e = arrowDirection;
            c();
            return this;
        }
        return (BubbleLayout) invokeL.objValue;
    }

    public BubbleLayout setArrowHeight(float f2) {
        InterceptResult invokeF;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeF = interceptable.invokeF(1048590, this, f2)) == null) {
            d();
            this.f57991i = f2;
            c();
            return this;
        }
        return (BubbleLayout) invokeF.objValue;
    }

    public BubbleLayout setArrowPosition(float f2) {
        InterceptResult invokeF;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeF = interceptable.invokeF(1048591, this, f2)) == null) {
            d();
            this.f57992j = f2;
            c();
            return this;
        }
        return (BubbleLayout) invokeF.objValue;
    }

    public BubbleLayout setArrowWidth(float f2) {
        InterceptResult invokeF;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeF = interceptable.invokeF(1048592, this, f2)) == null) {
            d();
            this.f57989g = f2;
            c();
            return this;
        }
        return (BubbleLayout) invokeF.objValue;
    }

    public BubbleLayout setBubbleColor(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048593, this, i2)) == null) {
            this.k = i2;
            requestLayout();
            return this;
        }
        return (BubbleLayout) invokeI.objValue;
    }

    public BubbleLayout setCornersRadius(float f2) {
        InterceptResult invokeF;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeF = interceptable.invokeF(1048594, this, f2)) == null) {
            this.f57990h = f2;
            requestLayout();
            return this;
        }
        return (BubbleLayout) invokeF.objValue;
    }

    public BubbleLayout setStrokeColor(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048595, this, i2)) == null) {
            this.m = i2;
            requestLayout();
            return this;
        }
        return (BubbleLayout) invokeI.objValue;
    }

    public BubbleLayout setStrokeWidth(float f2) {
        InterceptResult invokeF;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeF = interceptable.invokeF(1048596, this, f2)) == null) {
            d();
            this.l = f2;
            c();
            return this;
        }
        return (BubbleLayout) invokeF.objValue;
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BubbleLayout(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65539, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65539, newInitContext);
                return;
            }
        }
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R$styleable.BubbleLayout);
        this.f57989g = obtainStyledAttributes.getDimension(R$styleable.BubbleLayout_bl_arrowWidth, a(8.0f, context));
        this.f57991i = obtainStyledAttributes.getDimension(R$styleable.BubbleLayout_bl_arrowHeight, a(8.0f, context));
        this.f57990h = obtainStyledAttributes.getDimension(R$styleable.BubbleLayout_bl_cornersRadius, 0.0f);
        this.f57992j = obtainStyledAttributes.getDimension(R$styleable.BubbleLayout_bl_arrowPosition, a(12.0f, context));
        this.k = obtainStyledAttributes.getColor(R$styleable.BubbleLayout_bl_bubbleColor, -1);
        this.l = obtainStyledAttributes.getDimension(R$styleable.BubbleLayout_bl_strokeWidth, DEFAULT_STROKE_WIDTH);
        this.m = obtainStyledAttributes.getColor(R$styleable.BubbleLayout_bl_strokeColor, -7829368);
        this.f57987e = ArrowDirection.fromInt(obtainStyledAttributes.getInt(R$styleable.BubbleLayout_tb_bl_arrowDirection, ArrowDirection.LEFT.getValue()));
        obtainStyledAttributes.recycle();
        c();
    }
}
