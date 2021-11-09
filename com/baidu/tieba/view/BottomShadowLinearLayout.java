package com.baidu.tieba.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import androidx.annotation.Nullable;
import b.a.e.e.p.l;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes9.dex */
public class BottomShadowLinearLayout extends LinearLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public int f55223e;

    /* renamed from: f  reason: collision with root package name */
    public int f55224f;

    /* renamed from: g  reason: collision with root package name */
    public float f55225g;

    /* renamed from: h  reason: collision with root package name */
    public float f55226h;

    /* renamed from: i  reason: collision with root package name */
    public Paint f55227i;
    public Paint j;
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
            this.f55227i = paint;
            paint.reset();
            this.f55227i.setAntiAlias(true);
            this.f55227i.setStyle(Paint.Style.FILL);
            this.f55227i.setDither(true);
            Paint paint2 = new Paint();
            this.j = paint2;
            paint2.reset();
            this.j.setAntiAlias(true);
            this.j.setStyle(Paint.Style.FILL);
            this.j.setDither(true);
            this.f55225g = l.g(context, R.dimen.ds20);
            this.f55226h = l.g(context, R.dimen.ds25);
            setLayerType(1, this.f55227i);
            onChangeSkinType();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, canvas) == null) || this.f55223e <= 0 || this.f55224f <= 0) {
            return;
        }
        if (this.k == null) {
            this.k = new RectF(0.0f, 0.0f, this.f55223e, this.f55224f - this.f55226h);
        }
        RectF rectF = this.k;
        float f2 = this.f55225g;
        canvas.drawRoundRect(rectF, f2, f2, this.f55227i);
        if (this.l == null) {
            this.l = new RectF(0.0f, 0.0f, this.f55223e, this.f55224f / 2);
        }
        canvas.drawRect(this.l, this.j);
        super.dispatchDraw(canvas);
    }

    public void onChangeSkinType() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.f55227i.setColor(SkinManager.getColor(R.color.CAM_X0207));
            this.j.setColor(SkinManager.getColor(R.color.CAM_X0207));
            this.f55227i.setShadowLayer(25.0f, 0.0f, 0.0f, SkinManager.getColor(R.color.CAM_X0805));
        }
    }

    @Override // android.widget.LinearLayout, android.view.View
    public void onMeasure(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048579, this, i2, i3) == null) {
            super.onMeasure(i2, i3);
            this.f55223e = getMeasuredWidth();
            this.f55224f = getMeasuredHeight();
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
