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
/* loaded from: classes5.dex */
public class BubbleLayout extends FrameLayout {
    public static /* synthetic */ Interceptable $ic = null;
    public static float n = -1.0f;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public ArrowDirection f22168e;

    /* renamed from: f  reason: collision with root package name */
    public d.a.s0.z3.j.a f22169f;

    /* renamed from: g  reason: collision with root package name */
    public float f22170g;

    /* renamed from: h  reason: collision with root package name */
    public float f22171h;

    /* renamed from: i  reason: collision with root package name */
    public float f22172i;
    public float j;
    public int k;
    public float l;
    public int m;

    /* loaded from: classes5.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f22173a;
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
            f22173a = iArr;
            try {
                iArr[ArrowDirection.LEFT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f22173a[ArrowDirection.RIGHT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f22173a[ArrowDirection.TOP.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f22173a[ArrowDirection.BOTTOM.ordinal()] = 4;
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
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65540, null, new Object[]{Float.valueOf(f2), context})) == null) ? f2 * (context.getResources().getDisplayMetrics().densityDpi / 160.0f) : invokeCommon.floatValue;
    }

    public final void b(int i2, int i3, int i4, int i5) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIIII(1048576, this, i2, i3, i4, i5) == null) || i3 < i2 || i5 < i4) {
            return;
        }
        this.f22169f = new d.a.s0.z3.j.a(new RectF(i2, i4, i3, i5), this.f22170g, this.f22171h, this.f22172i, this.j, this.l, this.m, this.k, this.f22168e);
    }

    public final void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            int paddingLeft = getPaddingLeft();
            int paddingRight = getPaddingRight();
            int paddingTop = getPaddingTop();
            int paddingBottom = getPaddingBottom();
            int i2 = a.f22173a[this.f22168e.ordinal()];
            if (i2 == 1) {
                paddingLeft = (int) (paddingLeft + this.f22170g);
            } else if (i2 == 2) {
                paddingRight = (int) (paddingRight + this.f22170g);
            } else if (i2 == 3) {
                paddingTop = (int) (paddingTop + this.f22172i);
            } else if (i2 == 4) {
                paddingBottom = (int) (paddingBottom + this.f22172i);
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

    public BubbleLayout d(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2)) == null) {
            this.k = i2;
            requestLayout();
            return this;
        }
        return (BubbleLayout) invokeI.objValue;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, canvas) == null) {
            d.a.s0.z3.j.a aVar = this.f22169f;
            if (aVar != null) {
                aVar.draw(canvas);
            }
            super.dispatchDraw(canvas);
        }
    }

    public ArrowDirection getArrowDirection() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f22168e : (ArrowDirection) invokeV.objValue;
    }

    public float getArrowHeight() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f22172i : invokeV.floatValue;
    }

    public float getArrowPosition() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.j : invokeV.floatValue;
    }

    public float getArrowWidth() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f22170g : invokeV.floatValue;
    }

    public int getBubbleColor() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.k : invokeV.intValue;
    }

    public float getCornersRadius() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.f22171h : invokeV.floatValue;
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
        this.f22170g = obtainStyledAttributes.getDimension(R$styleable.BubbleLayout_bl_arrowWidth, a(8.0f, context));
        this.f22172i = obtainStyledAttributes.getDimension(R$styleable.BubbleLayout_bl_arrowHeight, a(8.0f, context));
        this.f22171h = obtainStyledAttributes.getDimension(R$styleable.BubbleLayout_bl_cornersRadius, 0.0f);
        this.j = obtainStyledAttributes.getDimension(R$styleable.BubbleLayout_bl_arrowPosition, a(12.0f, context));
        this.k = obtainStyledAttributes.getColor(R$styleable.BubbleLayout_bl_bubbleColor, -1);
        this.l = obtainStyledAttributes.getDimension(R$styleable.BubbleLayout_bl_strokeWidth, n);
        this.m = obtainStyledAttributes.getColor(R$styleable.BubbleLayout_bl_strokeColor, -7829368);
        this.f22168e = ArrowDirection.fromInt(obtainStyledAttributes.getInt(R$styleable.BubbleLayout_tb_bl_arrowDirection, ArrowDirection.LEFT.getValue()));
        obtainStyledAttributes.recycle();
        c();
    }
}
