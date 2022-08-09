package com.baidu.tieba.pb.pb.main.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.widget.TextView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.ms4;
import com.repackage.qi;
/* loaded from: classes4.dex */
public class TextLineView extends TextView {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Paint a;
    public int b;
    public int c;
    public int d;
    public int e;
    public int f;
    public RectF g;
    public int h;
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
                ms4 d = ms4.d(this);
                d.v(R.color.CAM_X0105);
                d.A(R.string.F_X02);
                return;
            }
            ms4 d2 = ms4.d(this);
            d2.v(R.color.CAM_X0108);
            d2.A(R.string.F_X01);
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
            if (this.g == null) {
                this.g = new RectF();
            }
            RectF rectF = this.g;
            int i = this.j;
            int i2 = this.i;
            int i3 = this.d;
            rectF.set(i + 0, (i2 - i3) - this.b, this.h - i, i2 - i3);
            RectF rectF2 = this.g;
            int i4 = this.k;
            canvas.drawRoundRect(rectF2, i4, i4, this.a);
        }
    }

    @Override // android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIII(1048579, this, i, i2, i3, i4) == null) {
            super.onSizeChanged(i, i2, i3, i4);
            this.h = i;
            this.i = i2;
            this.j = (i - this.f) / 2;
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
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, new int[]{R.attr.obfuscated_res_0x7f0400fa, R.attr.obfuscated_res_0x7f0400fb, R.attr.obfuscated_res_0x7f0400fc, R.attr.obfuscated_res_0x7f0400fd, R.attr.obfuscated_res_0x7f0406f4, R.attr.obfuscated_res_0x7f0406f6});
        this.b = obtainStyledAttributes.getDimensionPixelSize(2, 0);
        this.c = obtainStyledAttributes.getDimensionPixelSize(3, 0);
        this.d = obtainStyledAttributes.getDimensionPixelSize(0, 0);
        this.e = obtainStyledAttributes.getColor(4, SkinManager.getColor(R.color.CAM_X0105));
        obtainStyledAttributes.getColor(5, SkinManager.getColor(R.color.CAM_X0108));
        setPadding(getPaddingLeft(), getPaddingTop(), getPaddingRight(), getPaddingBottom() + this.c + this.b + this.d);
        setTextColor(this.e);
        this.f = qi.f(context, R.dimen.obfuscated_res_0x7f0702dd);
        this.g = new RectF();
        this.k = qi.f(getContext(), R.dimen.obfuscated_res_0x7f070224);
        obtainStyledAttributes.recycle();
    }
}
