package com.baidu.tieba.pb.pb.main.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.widget.TextView;
import b.a.q0.s.u.c;
import b.a.r0.k2.f;
import b.a.r0.k2.g;
import b.a.r0.k2.l;
import b.a.r0.k2.n;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes9.dex */
public class TextLineView extends TextView {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public Paint f53475e;

    /* renamed from: f  reason: collision with root package name */
    public int f53476f;

    /* renamed from: g  reason: collision with root package name */
    public int f53477g;

    /* renamed from: h  reason: collision with root package name */
    public int f53478h;

    /* renamed from: i  reason: collision with root package name */
    public int f53479i;
    public int j;
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
                d2.v(f.CAM_X0105);
                d2.A(l.F_X02);
                return;
            }
            c d3 = c.d(this);
            d3.v(f.CAM_X0108);
            d3.A(l.F_X01);
        }
    }

    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            if (this.f53475e == null) {
                this.f53475e = new Paint();
            }
            this.f53475e.setAntiAlias(true);
            this.f53475e.setStyle(Paint.Style.FILL);
            if (isSelected()) {
                this.f53475e.setColor(SkinManager.getColor(f.transparent));
            } else {
                this.f53475e.setColor(SkinManager.getColor(f.transparent));
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
            int i4 = this.f53478h;
            rectF.set(i2 + 0, (i3 - i4) - this.f53476f, this.l - i2, i3 - i4);
            RectF rectF2 = this.k;
            int i5 = this.o;
            canvas.drawRoundRect(rectF2, i5, i5, this.f53475e);
        }
    }

    @Override // android.view.View
    public void onSizeChanged(int i2, int i3, int i4, int i5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIII(1048579, this, i2, i3, i4, i5) == null) {
            super.onSizeChanged(i2, i3, i4, i5);
            this.l = i2;
            this.m = i3;
            this.n = (i2 - this.j) / 2;
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
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, n.TextLineView);
        this.f53476f = obtainStyledAttributes.getDimensionPixelSize(n.TextLineView_bottom_line_height, 0);
        this.f53477g = obtainStyledAttributes.getDimensionPixelSize(n.TextLineView_bottom_line_top_margin, 0);
        this.f53478h = obtainStyledAttributes.getDimensionPixelSize(n.TextLineView_bottom_line_bottom_margin, 0);
        this.f53479i = obtainStyledAttributes.getColor(n.TextLineView_text_selected_color, SkinManager.getColor(f.CAM_X0105));
        obtainStyledAttributes.getColor(n.TextLineView_text_unselected_color, SkinManager.getColor(f.CAM_X0108));
        setPadding(getPaddingLeft(), getPaddingTop(), getPaddingRight(), getPaddingBottom() + this.f53477g + this.f53476f + this.f53478h);
        setTextColor(this.f53479i);
        this.j = b.a.e.f.p.l.g(context, g.ds56);
        this.k = new RectF();
        this.o = b.a.e.f.p.l.g(getContext(), g.ds4);
        obtainStyledAttributes.recycle();
    }
}
