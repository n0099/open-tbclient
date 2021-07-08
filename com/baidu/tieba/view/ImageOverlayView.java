package com.baidu.tieba.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.annotation.ColorRes;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes4.dex */
public class ImageOverlayView extends ViewGroup {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public int f22114e;

    /* renamed from: f  reason: collision with root package name */
    public int f22115f;

    /* renamed from: g  reason: collision with root package name */
    public int f22116g;

    /* renamed from: h  reason: collision with root package name */
    public int f22117h;

    /* renamed from: i  reason: collision with root package name */
    public int f22118i;
    public int j;
    public int k;
    public a l;
    public int m;
    public boolean n;
    public Paint o;
    public int p;
    public RectF q;
    public int r;

    /* loaded from: classes4.dex */
    public interface a {
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ImageOverlayView(Context context) {
        this(context, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public void a(int i2, int i3, int i4, int i5, int i6, int i7) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6), Integer.valueOf(i7)}) == null) {
            this.f22114e = i2;
            this.f22115f = i2;
            this.f22116g = i3;
            this.f22117h = i4;
            this.f22118i = i5;
            this.j = i6;
            this.k = i7;
            b();
        }
    }

    public final void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            for (int i2 = 0; i2 < this.f22114e; i2++) {
                HeadImageView headImageView = new HeadImageView(getContext());
                headImageView.setLayoutParams(new ViewGroup.LayoutParams(this.f22116g, this.f22117h));
                headImageView.setIsRound(true);
                headImageView.setBorderSurroundContent(true);
                headImageView.setDrawBorder(true);
                headImageView.setAutoChangeStyle(true);
                headImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
                headImageView.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
                headImageView.setPlaceHolder(1);
                addView(headImageView);
            }
        }
    }

    public final void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            Paint paint = new Paint();
            this.o = paint;
            paint.setAntiAlias(true);
            this.o.setStyle(Paint.Style.STROKE);
        }
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.o.setColor(SkinManager.getColor(this.j));
            for (int i2 = 0; i2 < getChildCount(); i2++) {
                View childAt = getChildAt(i2);
                if (childAt instanceof HeadImageView) {
                    ((HeadImageView) childAt).setPlaceHolder(1);
                }
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        View childAt;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, canvas) == null) {
            super.dispatchDraw(canvas);
            this.o.setColor(SkinManager.getColor(this.j));
            this.o.setStrokeWidth(this.f22118i);
            int i2 = this.r;
            if (i2 == 0) {
                for (int i3 = 1; i3 < this.f22115f && i3 < getChildCount() && (childAt = getChildAt(i3)) != null; i3++) {
                    float f2 = this.f22118i * 0.5f;
                    if (childAt instanceof HeadImageView) {
                        this.q.set(childAt.getLeft() - f2, childAt.getTop() - f2, childAt.getRight() + f2, childAt.getBottom() + f2);
                        canvas.drawArc(this.q, -90.0f, 180.0f, false, this.o);
                    }
                }
            } else if (i2 == 1) {
                int i4 = this.p;
                if (i4 <= 0) {
                    i4 = this.j;
                }
                this.p = i4;
                float f3 = this.f22118i * 0.5f;
                float f4 = this.f22116g / 2.0f;
                float acos = ((float) ((Math.acos((((f4 * 2.0f) - this.k) / 2.0f) / f4) / 3.141592653589793d) * 180.0d)) - 180.0f;
                float abs = Math.abs(2.0f * acos);
                int i5 = 0;
                int i6 = this.n ? 0 : this.f22115f - 1;
                while (i5 < this.f22115f) {
                    View childAt2 = getChildAt(i5);
                    if (childAt2 instanceof HeadImageView) {
                        this.q.set(childAt2.getLeft() - f3, childAt2.getTop() - f3, childAt2.getRight() + f3, childAt2.getBottom() + f3);
                        if (i5 == i6) {
                            this.o.setColor(SkinManager.getColor(this.p));
                        } else {
                            this.o.setColor(SkinManager.getColor(this.j));
                        }
                        canvas.drawArc(this.q, i5 == i6 ? 0.0f : acos, i5 == i6 ? 360.0f : abs, false, this.o);
                    }
                    i5++;
                }
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        int paddingLeft;
        int paddingTop;
        int i6;
        View childAt;
        View childAt2;
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeCommon(1048581, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5)}) != null) {
            return;
        }
        if (this.n) {
            paddingLeft = getPaddingLeft() + this.f22118i;
            paddingTop = getPaddingTop();
            i6 = this.f22118i;
        } else {
            paddingLeft = getPaddingLeft() + ((this.f22115f - 1) * (this.f22116g - this.k)) + this.f22118i;
            paddingTop = getPaddingTop();
            i6 = this.f22118i;
        }
        int i7 = paddingTop + i6;
        int i8 = 0;
        while (true) {
            int i9 = this.f22115f;
            if (i8 < i9) {
                if (i8 >= getChildCount() || (childAt2 = getChildAt(i8)) == null) {
                    return;
                }
                childAt2.setVisibility(0);
                if (this.n) {
                    childAt2.layout(paddingLeft, i7, this.f22116g + paddingLeft, this.f22117h + i7);
                    paddingLeft += this.f22116g - this.k;
                } else {
                    childAt2.layout(paddingLeft, i7, this.f22116g + paddingLeft, this.f22117h + i7);
                    paddingLeft -= this.f22116g - this.k;
                }
                i8++;
            } else {
                while (i9 < this.f22114e && i9 < getChildCount() && (childAt = getChildAt(i9)) != null) {
                    childAt.setVisibility(8);
                    i9++;
                }
                return;
            }
        }
    }

    @Override // android.view.View
    public void onMeasure(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048582, this, i2, i3) == null) {
            int i4 = this.f22118i;
            if (this.r == 1) {
                i4 *= 2;
            }
            int paddingLeft = getPaddingLeft() + getPaddingRight() + i4;
            int i5 = this.f22115f;
            setMeasuredDimension(ViewGroup.resolveSize((paddingLeft + (this.f22116g * i5)) - ((i5 - 1) * this.k), i2), ViewGroup.resolveSize(getPaddingTop() + getPaddingBottom() + this.f22117h + (this.f22118i * 2), i3));
        }
    }

    public void setData(List<String> list) {
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, list) == null) {
            this.f22115f = Math.min(this.f22114e, ListUtils.getCount(list));
            for (int i2 = 0; i2 < this.f22115f; i2++) {
                HeadImageView headImageView = (HeadImageView) getChildAt(i2);
                if (headImageView != null && (str = (String) ListUtils.getItem(list, (list.size() - i2) - 1)) != null) {
                    if (this.m == 12) {
                        headImageView.J(str, 12, this.f22116g, this.f22117h, false);
                    } else {
                        headImageView.J(str, 10, this.f22116g, this.f22117h, false);
                    }
                }
            }
            requestLayout();
        }
    }

    public void setFirstImageStrokeColor(@ColorRes int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2) == null) {
            this.p = i2;
        }
    }

    public void setImageClickListener(a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, aVar) == null) {
            this.l = aVar;
        }
    }

    public void setLoadImageType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048586, this, i2) == null) {
            this.m = i2;
        }
    }

    public void setOrientation(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048587, this, z) == null) {
            this.n = z;
        }
    }

    public void setStrokeStyle(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048588, this, i2) == null) {
            this.r = i2;
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ImageOverlayView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
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
                this((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ImageOverlayView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.m = 10;
        this.n = false;
        this.r = 0;
        c();
        this.q = new RectF();
    }
}
