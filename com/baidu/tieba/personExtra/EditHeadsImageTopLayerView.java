package com.baidu.tieba.personExtra;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class EditHeadsImageTopLayerView extends View {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public Paint f45689e;

    /* renamed from: f  reason: collision with root package name */
    public Paint f45690f;

    /* renamed from: g  reason: collision with root package name */
    public int f45691g;

    /* renamed from: h  reason: collision with root package name */
    public int f45692h;

    /* renamed from: i  reason: collision with root package name */
    public float f45693i;

    /* renamed from: j  reason: collision with root package name */
    public float f45694j;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public EditHeadsImageTopLayerView(Context context) {
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
        this.f45689e = null;
        this.f45690f = null;
        this.f45691g = 0;
        this.f45692h = 0;
        this.f45693i = 0.42857143f;
        this.f45694j = 1.0f;
        a();
    }

    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            Paint paint = new Paint();
            this.f45689e = paint;
            paint.setColor(-16777216);
            this.f45689e.setAlpha(153);
            Paint paint2 = new Paint();
            this.f45690f = paint2;
            paint2.setStyle(Paint.Style.STROKE);
            this.f45690f.setColor(-1);
        }
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, canvas) == null) {
            canvas.save();
            super.onDraw(canvas);
            canvas.restore();
            canvas.drawRect(0.0f, 0.0f, getWidth(), this.f45691g, this.f45689e);
            canvas.drawRect(0.0f, getHeight() - this.f45692h, getWidth(), getHeight(), this.f45689e);
            canvas.drawRect(1.0f, this.f45691g, getWidth() - 1, getHeight() - this.f45692h, this.f45690f);
        }
    }

    @Override // android.view.View
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5)}) == null) {
            super.onLayout(z, i2, i3, i4, i5);
            float width = this.f45694j * getWidth();
            if (width > getHeight()) {
                width = getHeight();
            }
            float f2 = (i5 - i3) - width;
            float f3 = this.f45693i;
            this.f45691g = (int) (f2 * f3);
            this.f45692h = (int) (f2 * (1.0f - f3));
        }
    }

    public void setLinePaintColor(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i2) == null) {
            Paint paint = this.f45690f;
            if (paint != null) {
                paint.setColor(i2);
            }
            invalidate();
        }
    }

    public void setLineWidth(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i2) == null) {
            Paint paint = this.f45690f;
            if (paint != null) {
                paint.setStrokeWidth(i2);
            }
            invalidate();
        }
    }

    public void setmCutHeightScale(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048581, this, f2) == null) {
            this.f45694j = f2;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public EditHeadsImageTopLayerView(Context context, AttributeSet attributeSet) {
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
        this.f45689e = null;
        this.f45690f = null;
        this.f45691g = 0;
        this.f45692h = 0;
        this.f45693i = 0.42857143f;
        this.f45694j = 1.0f;
        a();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public EditHeadsImageTopLayerView(Context context, AttributeSet attributeSet, int i2) {
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
        this.f45689e = null;
        this.f45690f = null;
        this.f45691g = 0;
        this.f45692h = 0;
        this.f45693i = 0.42857143f;
        this.f45694j = 1.0f;
        a();
    }
}
