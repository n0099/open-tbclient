package com.baidu.tieba.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
import com.baidu.tieba.ii;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class ShadowLinearLayout extends LinearLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;
    public int b;
    public float c;
    public float d;
    public float e;
    public float f;
    public float g;
    public float h;
    public Paint i;
    public Path j;
    public RectF k;
    public RectF l;
    public RectF m;
    public RectF n;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ShadowLinearLayout(Context context) {
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
    public ShadowLinearLayout(Context context, @Nullable AttributeSet attributeSet) {
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

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ShadowLinearLayout(Context context, @Nullable AttributeSet attributeSet, int i) {
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
        a(context);
    }

    public final void a(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, context) == null) {
            Paint paint = new Paint();
            this.i = paint;
            paint.reset();
            this.i.setAntiAlias(true);
            this.i.setStyle(Paint.Style.FILL);
            this.i.setDither(true);
            this.g = ii.g(context, R.dimen.obfuscated_res_0x7f0701d5);
            float g = ii.g(context, R.dimen.obfuscated_res_0x7f070288);
            this.h = g;
            this.c = g;
            this.d = g;
            this.j = new Path();
            setLayerType(1, this.i);
            b();
        }
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.i.setColor(SkinManager.getColor(R.color.CAM_X0211));
            this.i.setShadowLayer(25.0f, 0.0f, 0.0f, SkinManager.getColor(R.color.CAM_X0805));
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, canvas) == null) && this.a > 0 && this.b > 0) {
            this.j.moveTo(this.c, this.d + this.g);
            if (this.k == null) {
                float f = this.c;
                float f2 = this.d;
                float f3 = this.g;
                this.k = new RectF(f, f2, (f3 * 2.0f) + f, (f3 * 2.0f) + f2);
            }
            this.j.arcTo(this.k, 180.0f, 90.0f, false);
            this.j.lineTo(this.e - this.g, this.d);
            if (this.l == null) {
                float f4 = this.e;
                float f5 = this.g;
                float f6 = this.d;
                this.l = new RectF(f4 - (f5 * 2.0f), f6, f4, (f5 * 2.0f) + f6);
            }
            this.j.arcTo(this.l, 270.0f, 90.0f, false);
            this.j.lineTo(this.e, this.f - this.g);
            if (this.m == null) {
                float f7 = this.e;
                float f8 = this.g;
                float f9 = this.f;
                this.m = new RectF(f7 - (f8 * 2.0f), f9 - (f8 * 2.0f), f7, f9);
            }
            this.j.arcTo(this.m, 0.0f, 90.0f, false);
            this.j.lineTo(this.c + this.g, this.f);
            if (this.n == null) {
                float f10 = this.c;
                float f11 = this.f;
                float f12 = this.g;
                this.n = new RectF(f10, f11 - (f12 * 2.0f), (f12 * 2.0f) + f10, f11);
            }
            this.j.arcTo(this.n, 90.0f, 90.0f, false);
            this.j.lineTo(this.c, this.d + this.g);
            canvas.drawPath(this.j, this.i);
            super.dispatchDraw(canvas);
        }
    }

    @Override // android.widget.LinearLayout, android.view.View
    public void onMeasure(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048579, this, i, i2) == null) {
            super.onMeasure(i, i2);
            this.a = getMeasuredWidth();
            int measuredHeight = getMeasuredHeight();
            this.b = measuredHeight;
            int i3 = this.a;
            if (i3 > 0 && measuredHeight > 0) {
                float f = this.h;
                this.e = i3 - f;
                this.f = measuredHeight - f;
            }
        }
    }
}
