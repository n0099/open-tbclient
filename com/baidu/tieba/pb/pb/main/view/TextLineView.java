package com.baidu.tieba.pb.pb.main.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.widget.TextView;
import c.a.d.f.p.n;
import c.a.o0.r.v.c;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class TextLineView extends TextView {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Paint a;

    /* renamed from: b  reason: collision with root package name */
    public int f35074b;

    /* renamed from: c  reason: collision with root package name */
    public int f35075c;

    /* renamed from: d  reason: collision with root package name */
    public int f35076d;

    /* renamed from: e  reason: collision with root package name */
    public int f35077e;

    /* renamed from: f  reason: collision with root package name */
    public int f35078f;

    /* renamed from: g  reason: collision with root package name */
    public RectF f35079g;

    /* renamed from: h  reason: collision with root package name */
    public int f35080h;
    public int i;
    public int j;
    public int k;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TextLineView(Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
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
            if (this.a == null) {
                this.a = new Paint();
            }
            this.a.setAntiAlias(true);
            this.a.setStyle(Paint.Style.FILL);
            if (isSelected()) {
                this.a.setColor(SkinManager.getColor(R.color.transparent));
            } else {
                this.a.setColor(SkinManager.getColor(R.color.transparent));
            }
        }
    }

    public void b(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) {
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
            if (this.f35079g == null) {
                this.f35079g = new RectF();
            }
            RectF rectF = this.f35079g;
            int i = this.j;
            int i2 = this.i;
            int i3 = this.f35076d;
            rectF.set(i + 0, (i2 - i3) - this.f35074b, this.f35080h - i, i2 - i3);
            RectF rectF2 = this.f35079g;
            int i4 = this.k;
            canvas.drawRoundRect(rectF2, i4, i4, this.a);
        }
    }

    @Override // android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIII(1048579, this, i, i2, i3, i4) == null) {
            super.onSizeChanged(i, i2, i3, i4);
            this.f35080h = i;
            this.i = i2;
            this.j = (i - this.f35078f) / 2;
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, new int[]{R.attr.obfuscated_res_0x7f0400ea, R.attr.obfuscated_res_0x7f0400eb, R.attr.obfuscated_res_0x7f0400ec, R.attr.obfuscated_res_0x7f0400ed, R.attr.obfuscated_res_0x7f040621, R.attr.obfuscated_res_0x7f040623});
        this.f35074b = obtainStyledAttributes.getDimensionPixelSize(2, 0);
        this.f35075c = obtainStyledAttributes.getDimensionPixelSize(3, 0);
        this.f35076d = obtainStyledAttributes.getDimensionPixelSize(0, 0);
        this.f35077e = obtainStyledAttributes.getColor(4, SkinManager.getColor(R.color.CAM_X0105));
        obtainStyledAttributes.getColor(5, SkinManager.getColor(R.color.CAM_X0108));
        setPadding(getPaddingLeft(), getPaddingTop(), getPaddingRight(), getPaddingBottom() + this.f35075c + this.f35074b + this.f35076d);
        setTextColor(this.f35077e);
        this.f35078f = n.f(context, R.dimen.obfuscated_res_0x7f0702d6);
        this.f35079g = new RectF();
        this.k = n.f(getContext(), R.dimen.obfuscated_res_0x7f070224);
        obtainStyledAttributes.recycle();
    }
}
