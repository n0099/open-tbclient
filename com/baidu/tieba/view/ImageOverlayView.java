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
/* loaded from: classes6.dex */
public class ImageOverlayView extends ViewGroup {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;
    public int b;
    public int c;
    public int d;
    public int e;
    public int f;
    public int g;
    public a h;
    public int i;
    public boolean j;
    public Paint k;
    public int l;
    public RectF m;
    public int n;

    /* loaded from: classes6.dex */
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
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

    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048582, this, i, i2) == null) {
            int i3 = this.e;
            if (this.n == 1) {
                i3 *= 2;
            }
            int paddingLeft = getPaddingLeft() + getPaddingRight() + i3;
            int i4 = this.b;
            setMeasuredDimension(ViewGroup.resolveSize((paddingLeft + (this.c * i4)) - ((i4 - 1) * this.g), i), ViewGroup.resolveSize(getPaddingTop() + getPaddingBottom() + this.d + (this.e * 2), i2));
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ImageOverlayView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.i = 10;
        this.j = false;
        this.n = 0;
        c();
        this.m = new RectF();
    }

    public void a(int i, int i2, int i3, int i4, int i5, int i6) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6)}) == null) {
            this.a = i;
            this.b = i;
            this.c = i2;
            this.d = i3;
            this.e = i4;
            this.f = i5;
            this.g = i6;
            b();
        }
    }

    public final void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            for (int i = 0; i < this.a; i++) {
                HeadImageView headImageView = new HeadImageView(getContext());
                headImageView.setLayoutParams(new ViewGroup.LayoutParams(this.c, this.d));
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
            this.k = paint;
            paint.setAntiAlias(true);
            this.k.setStyle(Paint.Style.STROKE);
        }
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.k.setColor(SkinManager.getColor(this.f));
            for (int i = 0; i < getChildCount(); i++) {
                View childAt = getChildAt(i);
                if (childAt instanceof HeadImageView) {
                    ((HeadImageView) childAt).setPlaceHolder(1);
                }
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        int i;
        float f;
        float f2;
        View childAt;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, canvas) == null) {
            super.dispatchDraw(canvas);
            this.k.setColor(SkinManager.getColor(this.f));
            this.k.setStrokeWidth(this.e);
            int i2 = this.n;
            if (i2 == 0) {
                for (int i3 = 1; i3 < this.b && i3 < getChildCount() && (childAt = getChildAt(i3)) != null; i3++) {
                    float f3 = this.e * 0.5f;
                    if (childAt instanceof HeadImageView) {
                        this.m.set(childAt.getLeft() - f3, childAt.getTop() - f3, childAt.getRight() + f3, childAt.getBottom() + f3);
                        canvas.drawArc(this.m, -90.0f, 180.0f, false, this.k);
                    }
                }
            } else if (i2 == 1) {
                int i4 = this.l;
                if (i4 <= 0) {
                    i4 = this.f;
                }
                this.l = i4;
                float f4 = this.e * 0.5f;
                float f5 = this.c / 2.0f;
                float acos = ((float) ((Math.acos((((f5 * 2.0f) - this.g) / 2.0f) / f5) / 3.141592653589793d) * 180.0d)) - 180.0f;
                float abs = Math.abs(2.0f * acos);
                if (this.j) {
                    i = 0;
                } else {
                    i = this.b - 1;
                }
                for (int i5 = 0; i5 < this.b; i5++) {
                    View childAt2 = getChildAt(i5);
                    if (childAt2 instanceof HeadImageView) {
                        this.m.set(childAt2.getLeft() - f4, childAt2.getTop() - f4, childAt2.getRight() + f4, childAt2.getBottom() + f4);
                        if (i5 == i) {
                            this.k.setColor(SkinManager.getColor(this.l));
                        } else {
                            this.k.setColor(SkinManager.getColor(this.f));
                        }
                        RectF rectF = this.m;
                        if (i5 == i) {
                            f = 0.0f;
                        } else {
                            f = acos;
                        }
                        if (i5 == i) {
                            f2 = 360.0f;
                        } else {
                            f2 = abs;
                        }
                        canvas.drawArc(rectF, f, f2, false, this.k);
                    }
                }
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int paddingLeft;
        int paddingTop;
        int i5;
        View childAt;
        View childAt2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)}) == null) {
            if (this.j) {
                paddingLeft = getPaddingLeft() + this.e;
                paddingTop = getPaddingTop();
                i5 = this.e;
            } else {
                paddingLeft = getPaddingLeft() + ((this.b - 1) * (this.c - this.g)) + this.e;
                paddingTop = getPaddingTop();
                i5 = this.e;
            }
            int i6 = paddingTop + i5;
            int i7 = 0;
            while (true) {
                int i8 = this.b;
                if (i7 < i8) {
                    if (i7 >= getChildCount() || (childAt2 = getChildAt(i7)) == null) {
                        return;
                    }
                    childAt2.setVisibility(0);
                    if (this.j) {
                        childAt2.layout(paddingLeft, i6, this.c + paddingLeft, this.d + i6);
                        paddingLeft += this.c - this.g;
                    } else {
                        childAt2.layout(paddingLeft, i6, this.c + paddingLeft, this.d + i6);
                        paddingLeft -= this.c - this.g;
                    }
                    i7++;
                } else {
                    while (i8 < this.a && i8 < getChildCount() && (childAt = getChildAt(i8)) != null) {
                        childAt.setVisibility(8);
                        i8++;
                    }
                    return;
                }
            }
        }
    }

    public void setData(List<String> list) {
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, list) == null) {
            this.b = Math.min(this.a, ListUtils.getCount(list));
            for (int i = 0; i < this.b; i++) {
                HeadImageView headImageView = (HeadImageView) getChildAt(i);
                if (headImageView != null && (str = (String) ListUtils.getItem(list, (list.size() - i) - 1)) != null) {
                    if (this.i == 12) {
                        headImageView.G(str, 12, this.c, this.d, false);
                    } else {
                        headImageView.G(str, 10, this.c, this.d, false);
                    }
                }
            }
            requestLayout();
        }
    }

    public void setFirstImageStrokeColor(@ColorRes int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i) == null) {
            this.l = i;
        }
    }

    public void setImageClickListener(a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, aVar) == null) {
            this.h = aVar;
        }
    }

    public void setLoadImageType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048586, this, i) == null) {
            this.i = i;
        }
    }

    public void setOrientation(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048587, this, z) == null) {
            this.j = z;
        }
    }

    public void setStrokeStyle(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048588, this, i) == null) {
            this.n = i;
        }
    }
}
