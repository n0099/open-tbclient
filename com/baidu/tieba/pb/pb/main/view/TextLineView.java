package com.baidu.tieba.pb.pb.main.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.widget.TextView;
import c.a.d.f.p.n;
import c.a.q0.r.v.c;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class TextLineView extends TextView {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public Paint f45294e;

    /* renamed from: f  reason: collision with root package name */
    public int f45295f;

    /* renamed from: g  reason: collision with root package name */
    public int f45296g;

    /* renamed from: h  reason: collision with root package name */
    public int f45297h;

    /* renamed from: i  reason: collision with root package name */
    public int f45298i;

    /* renamed from: j  reason: collision with root package name */
    public int f45299j;
    public RectF k;
    public int l;
    public int m;
    public int n;
    public int o;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TextLineView(Context context) {
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
    }

    private void setTextSelectedUI(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65538, this, z) == null) {
            if (z) {
                c d2 = c.d(this);
                d2.v(R.color.CAM_X0105);
                d2.A(R.string.F_X02);
                return;
            }
            c d3 = c.d(this);
            d3.v(R.color.CAM_X0108);
            d3.A(R.string.F_X01);
        }
    }

    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            if (this.f45294e == null) {
                this.f45294e = new Paint();
            }
            this.f45294e.setAntiAlias(true);
            this.f45294e.setStyle(Paint.Style.FILL);
            if (isSelected()) {
                this.f45294e.setColor(SkinManager.getColor(R.color.transparent));
            } else {
                this.f45294e.setColor(SkinManager.getColor(R.color.transparent));
            }
        }
    }

    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) {
            setTextSelectedUI(isSelected());
            a();
            invalidate();
        }
    }

    @Override // android.widget.TextView, android.view.View
    public void onDraw(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, canvas) == null) {
            super.onDraw(canvas);
            a();
            if (this.k == null) {
                this.k = new RectF();
            }
            RectF rectF = this.k;
            int i2 = this.n;
            int i3 = this.m;
            int i4 = this.f45297h;
            rectF.set(i2 + 0, (i3 - i4) - this.f45295f, this.l - i2, i3 - i4);
            RectF rectF2 = this.k;
            int i5 = this.o;
            canvas.drawRoundRect(rectF2, i5, i5, this.f45294e);
        }
    }

    @Override // android.view.View
    public void onSizeChanged(int i2, int i3, int i4, int i5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIII(1048579, this, i2, i3, i4, i5) == null) {
            super.onSizeChanged(i2, i3, i4, i5);
            this.l = i2;
            this.m = i3;
            this.n = (i2 - this.f45299j) / 2;
        }
    }

    @Override // android.widget.TextView, android.view.View
    public void setSelected(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048580, this, z) == null) {
            super.setSelected(z);
            setTextSelectedUI(z);
            invalidate();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TextLineView(Context context, AttributeSet attributeSet) {
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
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, new int[]{R.attr.bottom_line_bottom_margin, R.attr.bottom_line_color, R.attr.bottom_line_height, R.attr.bottom_line_top_margin, R.attr.text_selected_color, R.attr.text_unselected_color});
        this.f45295f = obtainStyledAttributes.getDimensionPixelSize(2, 0);
        this.f45296g = obtainStyledAttributes.getDimensionPixelSize(3, 0);
        this.f45297h = obtainStyledAttributes.getDimensionPixelSize(0, 0);
        this.f45298i = obtainStyledAttributes.getColor(4, SkinManager.getColor(R.color.CAM_X0105));
        obtainStyledAttributes.getColor(5, SkinManager.getColor(R.color.CAM_X0108));
        setPadding(getPaddingLeft(), getPaddingTop(), getPaddingRight(), getPaddingBottom() + this.f45296g + this.f45295f + this.f45297h);
        setTextColor(this.f45298i);
        this.f45299j = n.f(context, R.dimen.ds56);
        this.k = new RectF();
        this.o = n.f(getContext(), R.dimen.ds4);
        obtainStyledAttributes.recycle();
    }
}
