package com.baidu.tieba.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import androidx.annotation.Nullable;
import c.a.d.f.p.n;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class ShadowLinearLayout extends LinearLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public int f47799e;

    /* renamed from: f  reason: collision with root package name */
    public int f47800f;

    /* renamed from: g  reason: collision with root package name */
    public float f47801g;

    /* renamed from: h  reason: collision with root package name */
    public float f47802h;

    /* renamed from: i  reason: collision with root package name */
    public float f47803i;

    /* renamed from: j  reason: collision with root package name */
    public float f47804j;
    public float k;
    public float l;
    public Paint m;
    public Path n;
    public RectF o;
    public RectF p;
    public RectF q;
    public RectF r;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ShadowLinearLayout(Context context) {
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

    public final void a(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, context) == null) {
            Paint paint = new Paint();
            this.m = paint;
            paint.reset();
            this.m.setAntiAlias(true);
            this.m.setStyle(Paint.Style.FILL);
            this.m.setDither(true);
            this.k = n.f(context, R.dimen.ds20);
            float f2 = n.f(context, R.dimen.ds25);
            this.l = f2;
            this.f47801g = f2;
            this.f47802h = f2;
            this.n = new Path();
            setLayerType(1, this.m);
            onChangeSkinType();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, canvas) == null) || this.f47799e <= 0 || this.f47800f <= 0) {
            return;
        }
        this.n.moveTo(this.f47801g, this.f47802h + this.k);
        if (this.o == null) {
            float f2 = this.f47801g;
            float f3 = this.f47802h;
            float f4 = this.k;
            this.o = new RectF(f2, f3, (f4 * 2.0f) + f2, (f4 * 2.0f) + f3);
        }
        this.n.arcTo(this.o, 180.0f, 90.0f, false);
        this.n.lineTo(this.f47803i - this.k, this.f47802h);
        if (this.p == null) {
            float f5 = this.f47803i;
            float f6 = this.k;
            float f7 = this.f47802h;
            this.p = new RectF(f5 - (f6 * 2.0f), f7, f5, (f6 * 2.0f) + f7);
        }
        this.n.arcTo(this.p, 270.0f, 90.0f, false);
        this.n.lineTo(this.f47803i, this.f47804j - this.k);
        if (this.q == null) {
            float f8 = this.f47803i;
            float f9 = this.k;
            float f10 = this.f47804j;
            this.q = new RectF(f8 - (f9 * 2.0f), f10 - (f9 * 2.0f), f8, f10);
        }
        this.n.arcTo(this.q, 0.0f, 90.0f, false);
        this.n.lineTo(this.f47801g + this.k, this.f47804j);
        if (this.r == null) {
            float f11 = this.f47801g;
            float f12 = this.f47804j;
            float f13 = this.k;
            this.r = new RectF(f11, f12 - (f13 * 2.0f), (f13 * 2.0f) + f11, f12);
        }
        this.n.arcTo(this.r, 90.0f, 90.0f, false);
        this.n.lineTo(this.f47801g, this.f47802h + this.k);
        canvas.drawPath(this.n, this.m);
        super.dispatchDraw(canvas);
    }

    public void onChangeSkinType() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.m.setColor(SkinManager.getColor(R.color.CAM_X0211));
            this.m.setShadowLayer(25.0f, 0.0f, 0.0f, SkinManager.getColor(R.color.CAM_X0805));
        }
    }

    @Override // android.widget.LinearLayout, android.view.View
    public void onMeasure(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048579, this, i2, i3) == null) {
            super.onMeasure(i2, i3);
            this.f47799e = getMeasuredWidth();
            int measuredHeight = getMeasuredHeight();
            this.f47800f = measuredHeight;
            int i4 = this.f47799e;
            if (i4 <= 0 || measuredHeight <= 0) {
                return;
            }
            float f2 = this.l;
            this.f47803i = i4 - f2;
            this.f47804j = measuredHeight - f2;
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
    public ShadowLinearLayout(Context context, @Nullable AttributeSet attributeSet, int i2) {
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
        a(context);
    }
}
