package com.baidu.tieba.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import androidx.annotation.Nullable;
import c.a.e.e.p.l;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class BottomShadowLinearLayout extends LinearLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public int f57960e;

    /* renamed from: f  reason: collision with root package name */
    public int f57961f;

    /* renamed from: g  reason: collision with root package name */
    public float f57962g;

    /* renamed from: h  reason: collision with root package name */
    public float f57963h;

    /* renamed from: i  reason: collision with root package name */
    public Paint f57964i;

    /* renamed from: j  reason: collision with root package name */
    public Paint f57965j;
    public RectF k;
    public RectF l;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public BottomShadowLinearLayout(Context context) {
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
            this.f57964i = paint;
            paint.reset();
            this.f57964i.setAntiAlias(true);
            this.f57964i.setStyle(Paint.Style.FILL);
            this.f57964i.setDither(true);
            Paint paint2 = new Paint();
            this.f57965j = paint2;
            paint2.reset();
            this.f57965j.setAntiAlias(true);
            this.f57965j.setStyle(Paint.Style.FILL);
            this.f57965j.setDither(true);
            this.f57962g = l.g(context, R.dimen.ds20);
            this.f57963h = l.g(context, R.dimen.ds25);
            setLayerType(1, this.f57964i);
            onChangeSkinType();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, canvas) == null) || this.f57960e <= 0 || this.f57961f <= 0) {
            return;
        }
        if (this.k == null) {
            this.k = new RectF(0.0f, 0.0f, this.f57960e, this.f57961f - this.f57963h);
        }
        RectF rectF = this.k;
        float f2 = this.f57962g;
        canvas.drawRoundRect(rectF, f2, f2, this.f57964i);
        if (this.l == null) {
            this.l = new RectF(0.0f, 0.0f, this.f57960e, this.f57961f / 2);
        }
        canvas.drawRect(this.l, this.f57965j);
        super.dispatchDraw(canvas);
    }

    public void onChangeSkinType() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.f57964i.setColor(SkinManager.getColor(R.color.CAM_X0207));
            this.f57965j.setColor(SkinManager.getColor(R.color.CAM_X0207));
            this.f57964i.setShadowLayer(25.0f, 0.0f, 0.0f, SkinManager.getColor(R.color.CAM_X0805));
        }
    }

    @Override // android.widget.LinearLayout, android.view.View
    public void onMeasure(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048579, this, i2, i3) == null) {
            super.onMeasure(i2, i3);
            this.f57960e = getMeasuredWidth();
            this.f57961f = getMeasuredHeight();
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public BottomShadowLinearLayout(Context context, @Nullable AttributeSet attributeSet) {
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
    public BottomShadowLinearLayout(Context context, @Nullable AttributeSet attributeSet, int i2) {
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
