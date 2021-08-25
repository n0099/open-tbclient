package com.baidu.wallet.base.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.internal.view.SupportMenu;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.apollon.utils.DisplayUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class GridHasFocusLayout extends ViewGroup {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: a  reason: collision with root package name */
    public static final int f60287a = 3;

    /* renamed from: b  reason: collision with root package name */
    public static final int f60288b = 1;

    /* renamed from: c  reason: collision with root package name */
    public static final int f60289c = 1;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: d  reason: collision with root package name */
    public int f60290d;

    /* renamed from: e  reason: collision with root package name */
    public int f60291e;

    /* renamed from: f  reason: collision with root package name */
    public int f60292f;

    /* renamed from: g  reason: collision with root package name */
    public RectF f60293g;

    /* renamed from: h  reason: collision with root package name */
    public Paint f60294h;

    /* renamed from: i  reason: collision with root package name */
    public Integer f60295i;

    /* renamed from: j  reason: collision with root package name */
    public int f60296j;
    public boolean k;
    public Paint l;

    /* loaded from: classes8.dex */
    public static class LayoutParams extends ViewGroup.LayoutParams {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public int f60297a;

        /* renamed from: b  reason: collision with root package name */
        public int f60298b;

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
    public GridHasFocusLayout(Context context, AttributeSet attributeSet) {
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
        this.f60295i = null;
        this.f60296j = -1;
        this.k = true;
        this.l = new Paint();
        a();
    }

    private void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65538, this) == null) {
            this.f60290d = 3;
            this.f60291e = DisplayUtils.dip2px(getContext(), 1.0f);
            this.f60292f = DisplayUtils.dip2px(getContext(), 1.0f);
            this.f60293g = new RectF();
            this.f60294h = new Paint();
            this.l.setColor(SupportMenu.CATEGORY_MASK);
        }
    }

    private void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this) == null) {
            this.f60296j = -1;
            invalidate();
        }
    }

    public void addSelectionView(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
        }
    }

    public void configFocusPaintColor(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) {
            this.l.setColor(i2);
        }
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, canvas) == null) {
            super.onDraw(canvas);
            a(canvas);
            if (getChildCount() % this.f60290d == 0 || this.f60295i == null) {
                return;
            }
            View childAt = getChildAt(getChildCount() - 1);
            this.f60293g.set(childAt.getLeft() + childAt.getWidth() + this.f60291e, childAt.getTop(), getLeft() + getWidth(), getTop() + getHeight());
            this.f60294h.setColor(this.f60295i.intValue());
            canvas.drawRect(this.f60293g, this.f60294h);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5)}) == null) {
            int childCount = getChildCount();
            for (int i6 = 0; i6 < childCount; i6++) {
                View childAt = getChildAt(i6);
                if (childAt.getVisibility() != 8) {
                    LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                    int i7 = layoutParams.f60297a;
                    int i8 = layoutParams.f60298b;
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
        if (interceptable == null || interceptable.invokeII(1048580, this, i2, i3) == null) {
            int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(i3), 0);
            int size = (View.MeasureSpec.getSize(i2) - getPaddingLeft()) - getPaddingRight();
            int childCount = getChildCount();
            int i4 = size - (this.k ? this.f60291e * 2 : 0);
            int i5 = this.f60291e;
            int i6 = this.f60290d;
            int i7 = (i4 - (i5 * (i6 - 1))) / i6;
            int paddingLeft = getPaddingLeft();
            int paddingTop = getPaddingTop();
            int i8 = 0;
            int i9 = 0;
            for (int i10 = 0; i10 < childCount; i10++) {
                View childAt = getChildAt(i10);
                if (childAt.getVisibility() != 8) {
                    measureChild(childAt, i2, makeMeasureSpec);
                    i9 = childAt.getMeasuredHeight();
                    childAt.measure(View.MeasureSpec.makeMeasureSpec(i7, 1073741824), View.MeasureSpec.makeMeasureSpec(i9, 1073741824));
                    if ((i10 - i8) % this.f60290d == 0) {
                        paddingLeft = getPaddingLeft() + (this.k ? this.f60291e : 0);
                        if (i10 != 0) {
                            paddingTop += this.f60292f + i9;
                        } else {
                            paddingTop = this.k ? this.f60292f : 0;
                        }
                    } else {
                        paddingLeft += this.f60291e + i7;
                    }
                    if (childAt.getLayoutParams() != null && (childAt.getLayoutParams() instanceof LayoutParams)) {
                        layoutParams = (LayoutParams) childAt.getLayoutParams();
                    } else {
                        LayoutParams layoutParams2 = new LayoutParams(0, 0);
                        childAt.setLayoutParams(layoutParams2);
                        layoutParams = layoutParams2;
                    }
                    layoutParams.f60297a = paddingLeft;
                    layoutParams.f60298b = paddingTop;
                    ((ViewGroup.LayoutParams) layoutParams).width = i7;
                    ((ViewGroup.LayoutParams) layoutParams).height = i9;
                } else {
                    i8++;
                }
            }
            int i11 = childCount - i8;
            int i12 = this.f60290d;
            int i13 = (i11 / i12) + (i11 % i12 == 0 ? 0 : 1);
            int i14 = this.f60292f;
            setMeasuredDimension(View.MeasureSpec.getSize(i2), (i9 * i13) + ((i13 - 1) * i14) + (this.k ? i14 * 2 : 0));
        }
    }

    public void setColumnCount(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i2) == null) {
            this.f60290d = i2;
        }
    }

    public void setEmptyAreaColor(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048582, this, i2) == null) {
            this.f60295i = Integer.valueOf(i2);
        }
    }

    public void setHorizontalSpacing(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i2) == null) {
            this.f60291e = i2;
        }
    }

    public void setSelection(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2) == null) {
            this.f60296j = i2;
            invalidate();
        }
    }

    public void setVerticalSpacing(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048585, this, i2) == null) {
            this.f60292f = i2;
        }
    }

    public void showSideLine(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048586, this, z) == null) {
            this.k = z;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GridHasFocusLayout(Context context) {
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
        this.f60295i = null;
        this.f60296j = -1;
        this.k = true;
        this.l = new Paint();
        a();
    }

    private void a(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, this, canvas) == null) {
            this.l.setStrokeWidth(this.f60291e);
            int i2 = this.f60296j;
            if (i2 < 0 || i2 >= getChildCount()) {
                return;
            }
            View childAt = getChildAt(this.f60296j);
            float left = childAt.getLeft() - (this.k ? this.f60292f : 0);
            float top = childAt.getTop() - (this.k ? this.f60291e : 0);
            float left2 = ((childAt.getLeft() + childAt.getWidth()) + (this.k ? this.f60292f : 0)) - 1;
            float top2 = ((childAt.getTop() + childAt.getHeight()) + 0) - 1;
            canvas.drawLine(left, top, left, top2, this.l);
            canvas.drawLine(left, top2, left2, top2, this.l);
            canvas.drawLine(left, top, left2, top, this.l);
            canvas.drawLine(left2, top, left2, top2, this.l);
        }
    }
}
