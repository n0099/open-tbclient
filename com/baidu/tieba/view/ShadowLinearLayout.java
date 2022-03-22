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
    public int a;

    /* renamed from: b  reason: collision with root package name */
    public int f36966b;

    /* renamed from: c  reason: collision with root package name */
    public float f36967c;

    /* renamed from: d  reason: collision with root package name */
    public float f36968d;

    /* renamed from: e  reason: collision with root package name */
    public float f36969e;

    /* renamed from: f  reason: collision with root package name */
    public float f36970f;

    /* renamed from: g  reason: collision with root package name */
    public float f36971g;

    /* renamed from: h  reason: collision with root package name */
    public float f36972h;
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

    public final void a(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, context) == null) {
            Paint paint = new Paint();
            this.i = paint;
            paint.reset();
            this.i.setAntiAlias(true);
            this.i.setStyle(Paint.Style.FILL);
            this.i.setDither(true);
            this.f36971g = n.f(context, R.dimen.obfuscated_res_0x7f0701d5);
            float f2 = n.f(context, R.dimen.obfuscated_res_0x7f07027e);
            this.f36972h = f2;
            this.f36967c = f2;
            this.f36968d = f2;
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
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, canvas) == null) || this.a <= 0 || this.f36966b <= 0) {
            return;
        }
        this.j.moveTo(this.f36967c, this.f36968d + this.f36971g);
        if (this.k == null) {
            float f2 = this.f36967c;
            float f3 = this.f36968d;
            float f4 = this.f36971g;
            this.k = new RectF(f2, f3, (f4 * 2.0f) + f2, (f4 * 2.0f) + f3);
        }
        this.j.arcTo(this.k, 180.0f, 90.0f, false);
        this.j.lineTo(this.f36969e - this.f36971g, this.f36968d);
        if (this.l == null) {
            float f5 = this.f36969e;
            float f6 = this.f36971g;
            float f7 = this.f36968d;
            this.l = new RectF(f5 - (f6 * 2.0f), f7, f5, (f6 * 2.0f) + f7);
        }
        this.j.arcTo(this.l, 270.0f, 90.0f, false);
        this.j.lineTo(this.f36969e, this.f36970f - this.f36971g);
        if (this.m == null) {
            float f8 = this.f36969e;
            float f9 = this.f36971g;
            float f10 = this.f36970f;
            this.m = new RectF(f8 - (f9 * 2.0f), f10 - (f9 * 2.0f), f8, f10);
        }
        this.j.arcTo(this.m, 0.0f, 90.0f, false);
        this.j.lineTo(this.f36967c + this.f36971g, this.f36970f);
        if (this.n == null) {
            float f11 = this.f36967c;
            float f12 = this.f36970f;
            float f13 = this.f36971g;
            this.n = new RectF(f11, f12 - (f13 * 2.0f), (f13 * 2.0f) + f11, f12);
        }
        this.j.arcTo(this.n, 90.0f, 90.0f, false);
        this.j.lineTo(this.f36967c, this.f36968d + this.f36971g);
        canvas.drawPath(this.j, this.i);
        super.dispatchDraw(canvas);
    }

    @Override // android.widget.LinearLayout, android.view.View
    public void onMeasure(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048579, this, i, i2) == null) {
            super.onMeasure(i, i2);
            this.a = getMeasuredWidth();
            int measuredHeight = getMeasuredHeight();
            this.f36966b = measuredHeight;
            int i3 = this.a;
            if (i3 <= 0 || measuredHeight <= 0) {
                return;
            }
            float f2 = this.f36972h;
            this.f36969e = i3 - f2;
            this.f36970f = measuredHeight - f2;
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
}
