package com.baidu.tieba;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import com.angcyo.tablayout.DslTabLayout;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes7.dex */
public class p0 extends j0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final DslTabLayout s;
    public Drawable t;
    public int u;
    public int v;
    public int w;
    public int x;

    public p0(DslTabLayout tabLayout) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tabLayout};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        Intrinsics.checkNotNullParameter(tabLayout, "tabLayout");
        this.s = tabLayout;
        this.u = -1;
        this.v = -1;
    }

    @Override // com.baidu.tieba.j0
    public GradientDrawable M() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            GradientDrawable M = super.M();
            this.t = z();
            return M;
        }
        return (GradientDrawable) invokeV.objValue;
    }

    @Override // com.baidu.tieba.j0, com.angcyo.tablayout.AbsDslDrawable, android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        Drawable drawable;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, canvas) == null) {
            Intrinsics.checkNotNullParameter(canvas, "canvas");
            View currentItemView = this.s.getCurrentItemView();
            if (currentItemView != null) {
                ViewGroup.LayoutParams layoutParams = currentItemView.getLayoutParams();
                if (layoutParams instanceof DslTabLayout.LayoutParams) {
                    drawable = ((DslTabLayout.LayoutParams) layoutParams).e();
                    if (drawable == null) {
                        drawable = this.t;
                    }
                } else {
                    drawable = this.t;
                }
                if (drawable != null) {
                    int i = this.u;
                    if (i != -2) {
                        if (i == -1) {
                            i = currentItemView.getMeasuredWidth();
                        }
                    } else {
                        i = drawable.getIntrinsicWidth();
                    }
                    int i2 = i + this.w;
                    int i3 = this.v;
                    if (i3 != -2) {
                        if (i3 == -1) {
                            i3 = currentItemView.getMeasuredHeight();
                        }
                    } else {
                        i3 = drawable.getIntrinsicHeight();
                    }
                    int i4 = i3 + this.x;
                    int left = currentItemView.getLeft() + ((currentItemView.getRight() - currentItemView.getLeft()) / 2);
                    int top = currentItemView.getTop() + ((currentItemView.getBottom() - currentItemView.getTop()) / 2);
                    int i5 = i2 / 2;
                    int i6 = i4 / 2;
                    drawable.setBounds(left - i5, top - i6, left + i5, top + i6);
                    drawable.draw(canvas);
                    canvas.save();
                    if (this.s.k()) {
                        canvas.translate(currentItemView.getLeft(), 0.0f);
                    } else {
                        canvas.translate(0.0f, currentItemView.getTop());
                    }
                    currentItemView.draw(canvas);
                    canvas.restore();
                }
            }
        }
    }

    @Override // com.angcyo.tablayout.AbsDslDrawable
    public void k(Context context, AttributeSet attributeSet) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, context, attributeSet) == null) {
            Intrinsics.checkNotNullParameter(context, "context");
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, ve7.DslTabLayout);
            Intrinsics.checkNotNullExpressionValue(obtainStyledAttributes, "context.obtainStyledAttr…R.styleable.DslTabLayout)");
            this.t = obtainStyledAttributes.getDrawable(63);
            this.u = obtainStyledAttributes.getLayoutDimension(66, this.u);
            this.v = obtainStyledAttributes.getLayoutDimension(64, this.v);
            this.w = obtainStyledAttributes.getDimensionPixelOffset(67, this.w);
            this.x = obtainStyledAttributes.getDimensionPixelOffset(65, this.x);
            obtainStyledAttributes.recycle();
            if (this.t == null && A()) {
                M();
            }
        }
    }
}
