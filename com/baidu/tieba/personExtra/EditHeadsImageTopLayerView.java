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
/* loaded from: classes5.dex */
public class EditHeadsImageTopLayerView extends View {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Paint a;

    /* renamed from: b  reason: collision with root package name */
    public Paint f35395b;

    /* renamed from: c  reason: collision with root package name */
    public int f35396c;

    /* renamed from: d  reason: collision with root package name */
    public int f35397d;

    /* renamed from: e  reason: collision with root package name */
    public float f35398e;

    /* renamed from: f  reason: collision with root package name */
    public float f35399f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public EditHeadsImageTopLayerView(Context context) {
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
        this.a = null;
        this.f35395b = null;
        this.f35396c = 0;
        this.f35397d = 0;
        this.f35398e = 0.42857143f;
        this.f35399f = 1.0f;
        a();
    }

    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            Paint paint = new Paint();
            this.a = paint;
            paint.setColor(-16777216);
            this.a.setAlpha(153);
            Paint paint2 = new Paint();
            this.f35395b = paint2;
            paint2.setStyle(Paint.Style.STROKE);
            this.f35395b.setColor(-1);
        }
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, canvas) == null) {
            canvas.save();
            super.onDraw(canvas);
            canvas.restore();
            canvas.drawRect(0.0f, 0.0f, getWidth(), this.f35396c, this.a);
            canvas.drawRect(0.0f, getHeight() - this.f35397d, getWidth(), getHeight(), this.a);
            canvas.drawRect(1.0f, this.f35396c, getWidth() - 1, getHeight() - this.f35397d, this.f35395b);
        }
    }

    @Override // android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)}) == null) {
            super.onLayout(z, i, i2, i3, i4);
            float width = this.f35399f * getWidth();
            if (width > getHeight()) {
                width = getHeight();
            }
            float f2 = (i4 - i2) - width;
            float f3 = this.f35398e;
            this.f35396c = (int) (f2 * f3);
            this.f35397d = (int) (f2 * (1.0f - f3));
        }
    }

    public void setLinePaintColor(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i) == null) {
            Paint paint = this.f35395b;
            if (paint != null) {
                paint.setColor(i);
            }
            invalidate();
        }
    }

    public void setLineWidth(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i) == null) {
            Paint paint = this.f35395b;
            if (paint != null) {
                paint.setStrokeWidth(i);
            }
            invalidate();
        }
    }

    public void setmCutHeightScale(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048581, this, f2) == null) {
            this.f35399f = f2;
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
        this.a = null;
        this.f35395b = null;
        this.f35396c = 0;
        this.f35397d = 0;
        this.f35398e = 0.42857143f;
        this.f35399f = 1.0f;
        a();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public EditHeadsImageTopLayerView(Context context, AttributeSet attributeSet, int i) {
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
        this.a = null;
        this.f35395b = null;
        this.f35396c = 0;
        this.f35397d = 0;
        this.f35398e = 0.42857143f;
        this.f35399f = 1.0f;
        a();
    }
}
