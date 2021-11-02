package com.baidu.wallet.base.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.apollon.utils.DisplayUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes10.dex */
public class GridLayout extends ViewGroup {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: a  reason: collision with root package name */
    public static final int f57546a = 3;

    /* renamed from: b  reason: collision with root package name */
    public static final int f57547b = 1;

    /* renamed from: c  reason: collision with root package name */
    public static final int f57548c = 1;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: d  reason: collision with root package name */
    public int f57549d;

    /* renamed from: e  reason: collision with root package name */
    public int f57550e;

    /* renamed from: f  reason: collision with root package name */
    public int f57551f;

    /* renamed from: g  reason: collision with root package name */
    public RectF f57552g;

    /* renamed from: h  reason: collision with root package name */
    public Paint f57553h;

    /* renamed from: i  reason: collision with root package name */
    public Integer f57554i;
    public int j;
    public int k;
    public Paint l;
    public Integer m;
    public RectF n;
    public int o;

    /* loaded from: classes10.dex */
    public static class LayoutParams extends ViewGroup.LayoutParams {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public int f57555a;

        /* renamed from: b  reason: collision with root package name */
        public int f57556b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public LayoutParams(int i2, int i3) {
            super(i2, i3);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i2), Integer.valueOf(i3)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i4 = newInitContext.flag;
                if ((i4 & 1) != 0) {
                    int i5 = i4 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super(((Integer) objArr2[0]).intValue(), ((Integer) objArr2[1]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public LayoutParams(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {layoutParams};
                interceptable.invokeUnInit(65538, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((ViewGroup.LayoutParams) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65538, newInitContext);
                    return;
                }
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {context, attributeSet};
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GridLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f57554i = null;
        this.j = 0;
        this.k = 0;
        this.m = null;
        this.n = new RectF();
        this.o = 0;
        a();
    }

    private void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65538, this) == null) {
            this.f57549d = 3;
            this.f57550e = DisplayUtils.dip2px(getContext(), 1.0f);
            this.f57551f = DisplayUtils.dip2px(getContext(), 1.0f);
            this.f57552g = new RectF();
            this.f57553h = new Paint();
            this.l = new Paint();
            this.n = new RectF();
        }
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, canvas) == null) {
            super.onDraw(canvas);
            if (this.m != null && getChildCount() > this.f57549d && this.f57551f > 0) {
                float height = getChildAt(getChildCount() - 1).getHeight();
                for (int i2 = 1; i2 < Math.ceil((getChildCount() * 1.0f) / this.f57549d); i2++) {
                    RectF rectF = this.n;
                    rectF.left = this.j;
                    int i3 = this.f57551f;
                    float f2 = i2;
                    rectF.top = (getPaddingTop() + ((i3 + height) * f2)) - i3;
                    this.n.right = getWidth() - this.j;
                    this.n.bottom = getPaddingTop() + ((this.f57551f + height) * f2);
                    canvas.drawRect(this.n, this.l);
                }
            }
            if (this.m != null && this.f57549d > 1 && this.f57550e > 0) {
                float width = getChildAt(getChildCount() - 1).getWidth();
                for (int i4 = 1; i4 < this.f57549d; i4++) {
                    RectF rectF2 = this.n;
                    int i5 = this.f57550e;
                    float f3 = i4;
                    rectF2.left = (getPaddingLeft() + ((i5 + width) * f3)) - i5;
                    RectF rectF3 = this.n;
                    rectF3.top = this.k;
                    rectF3.right = getPaddingLeft() + ((this.f57550e + width) * f3);
                    this.n.bottom = getHeight() - this.k;
                    canvas.drawRect(this.n, this.l);
                }
            }
            if (getChildCount() % this.f57549d == 0 || this.f57554i == null) {
                return;
            }
            View childAt = getChildAt(getChildCount() - 1);
            this.f57552g.set(childAt.getLeft() + childAt.getWidth() + this.f57550e, childAt.getTop(), getLeft() + getWidth(), getTop() + getHeight());
            this.f57553h.setColor(this.f57554i.intValue());
            canvas.drawRect(this.f57552g, this.f57553h);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5)}) == null) {
            int childCount = getChildCount();
            for (int i6 = 0; i6 < childCount; i6++) {
                View childAt = getChildAt(i6);
                if (childAt.getVisibility() != 8) {
                    LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                    int i7 = layoutParams.f57555a;
                    int i8 = layoutParams.f57556b;
                    childAt.layout(i7, i8, ((ViewGroup.LayoutParams) layoutParams).width + i7, ((ViewGroup.LayoutParams) layoutParams).height + i8);
                }
            }
        }
    }

    @Override // android.view.View
    @SuppressLint({"DrawAllocation"})
    public void onMeasure(int i2, int i3) {
        LayoutParams layoutParams;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(Constants.METHOD_SEND_USER_MSG, this, i2, i3) == null) {
            int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(i3), 0);
            int size = (View.MeasureSpec.getSize(i2) - getPaddingLeft()) - getPaddingRight();
            int childCount = getChildCount();
            int i4 = this.f57550e;
            int i5 = this.f57549d;
            int i6 = (size - (i4 * (i5 - 1))) / i5;
            int paddingLeft = getPaddingLeft();
            int paddingTop = getPaddingTop();
            int i7 = 0;
            int i8 = 0;
            for (int i9 = 0; i9 < childCount; i9++) {
                View childAt = getChildAt(i9);
                if (childAt.getVisibility() != 8) {
                    measureChild(childAt, i2, makeMeasureSpec);
                    i8 = childAt.getMeasuredHeight();
                    if (this.o <= i8) {
                        this.o = i8;
                    }
                    childAt.measure(View.MeasureSpec.makeMeasureSpec(i6, 1073741824), View.MeasureSpec.makeMeasureSpec(this.o, 1073741824));
                    if ((i9 - i7) % this.f57549d == 0) {
                        paddingLeft = getPaddingLeft();
                        if (i9 != 0) {
                            paddingTop += this.o + this.f57551f;
                        }
                    } else {
                        paddingLeft += this.f57550e + i6;
                    }
                    if (childAt.getLayoutParams() != null && (childAt.getLayoutParams() instanceof LayoutParams)) {
                        layoutParams = (LayoutParams) childAt.getLayoutParams();
                    } else {
                        LayoutParams layoutParams2 = new LayoutParams(0, 0);
                        childAt.setLayoutParams(layoutParams2);
                        layoutParams = layoutParams2;
                    }
                    layoutParams.f57555a = paddingLeft;
                    layoutParams.f57556b = paddingTop;
                    ((ViewGroup.LayoutParams) layoutParams).width = i6;
                    ((ViewGroup.LayoutParams) layoutParams).height = this.o;
                } else {
                    i7++;
                }
            }
            int i10 = childCount - i7;
            int i11 = this.f57549d;
            int i12 = (i10 / i11) + (i10 % i11 != 0 ? 1 : 0);
            setMeasuredDimension(View.MeasureSpec.getSize(i2), (i8 * i12) + (this.f57551f * (i12 - 1)) + getPaddingTop() + getPaddingBottom());
        }
    }

    public void setColumnCount(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i2) == null) {
            this.f57549d = i2;
        }
    }

    public void setEmptyAreaColor(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i2) == null) {
            this.f57554i = Integer.valueOf(i2);
        }
    }

    public void setHorizontalSpacing(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i2) == null) {
            this.f57550e = i2;
        }
    }

    public void setSeparateLine(int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIII(1048582, this, i2, i3, i4) == null) {
            Integer valueOf = Integer.valueOf(i2);
            this.m = valueOf;
            this.j = i3;
            this.k = i4;
            this.l.setColor(valueOf.intValue());
        }
    }

    public void setVerticalSpacing(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i2) == null) {
            this.f57551f = i2;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GridLayout(Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f57554i = null;
        this.j = 0;
        this.k = 0;
        this.m = null;
        this.n = new RectF();
        this.o = 0;
        a();
    }
}
