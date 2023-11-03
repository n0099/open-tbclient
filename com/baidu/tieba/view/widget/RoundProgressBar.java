package com.baidu.tieba.view.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.view.View;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tieba.R;
import com.baidu.tieba.g16;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class RoundProgressBar extends View {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Paint a;
    public int b;
    public int c;
    public int d;
    public float e;
    public float f;
    public int g;
    public int h;
    public boolean i;
    public int j;
    public RectF k;
    public a l;

    /* loaded from: classes8.dex */
    public interface a {
        void a(int i);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public RoundProgressBar(Context context) {
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

    public synchronized void setProgress(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i) == null) {
            synchronized (this) {
                if (i >= 0) {
                    if (i > this.g) {
                        i = this.g;
                    }
                    if (i <= this.g) {
                        this.h = i;
                        if (this.l != null) {
                            this.l.a(i);
                        }
                        postInvalidate();
                    }
                } else {
                    throw new IllegalArgumentException("progress not less than 0");
                }
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public RoundProgressBar(Context context, AttributeSet attributeSet) {
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
    public RoundProgressBar(Context context, AttributeSet attributeSet, int i) {
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
        this.a = new Paint();
        this.k = new RectF();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, g16.RoundProgressBar);
        this.b = obtainStyledAttributes.getColor(2, getResources().getColor(R.color.CAM_X0607));
        this.c = obtainStyledAttributes.getColor(5, getResources().getColor(R.color.CAM_X0302));
        this.d = obtainStyledAttributes.getColor(9, getResources().getColor(R.color.CAM_X0201));
        this.e = obtainStyledAttributes.getDimension(11, UtilHelper.getDimenPixelSize(R.dimen.tbds10));
        this.f = obtainStyledAttributes.getDimension(12, UtilHelper.getDimenPixelSize(R.dimen.tbds7));
        this.g = obtainStyledAttributes.getInteger(3, 100);
        this.i = obtainStyledAttributes.getBoolean(15, true);
        this.j = obtainStyledAttributes.getInt(13, 0);
        obtainStyledAttributes.recycle();
    }

    public synchronized int getMax() {
        InterceptResult invokeV;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            synchronized (this) {
                i = this.g;
            }
            return i;
        }
        return invokeV.intValue;
    }

    public synchronized int getProgress() {
        InterceptResult invokeV;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            synchronized (this) {
                i = this.h;
            }
            return i;
        }
        return invokeV.intValue;
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, canvas) == null) {
            super.onDraw(canvas);
            int width = getWidth() / 2;
            float f = width;
            int i2 = (int) ((f - (this.f / 2.0f)) - 5.0f);
            this.a.setColor(this.b);
            this.a.setStyle(Paint.Style.STROKE);
            this.a.setStrokeWidth(this.f);
            this.a.setAntiAlias(true);
            canvas.drawCircle(f, f, i2, this.a);
            this.a.setStrokeWidth(0.0f);
            this.a.setColor(this.d);
            this.a.setTextSize(this.e);
            this.a.setTypeface(Typeface.DEFAULT_BOLD);
            int i3 = (int) ((this.h / this.g) * 100.0f);
            float measureText = this.a.measureText(i3 + "%");
            if (this.i && this.j == 0) {
                if (i3 == 0) {
                    i3 = 1;
                }
                canvas.drawText(i3 + "%", f - (measureText / 2.0f), f + (this.e / 2.0f), this.a);
            }
            this.a.setStrokeWidth(this.f);
            this.a.setColor(this.c);
            float f2 = width - i2;
            float f3 = width + i2;
            this.k.set(f2, f2, f3, f3);
            int i4 = this.j;
            if (i4 != 0) {
                if (i4 == 1) {
                    this.a.setStyle(Paint.Style.FILL_AND_STROKE);
                    if (this.h != 0) {
                        canvas.drawArc(this.k, -90.0f, (i * 360) / this.g, true, this.a);
                        return;
                    }
                    return;
                }
                return;
            }
            this.a.setStyle(Paint.Style.STROKE);
            canvas.drawArc(this.k, -90.0f, (this.h * 360) / this.g, false, this.a);
        }
    }

    public synchronized void setMax(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i) == null) {
            synchronized (this) {
                if (i >= 0) {
                    this.g = i;
                } else {
                    throw new IllegalArgumentException("max not less than 0");
                }
            }
        }
    }

    public void setOnProgressChangeListener(a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, aVar) == null) {
            this.l = aVar;
        }
    }

    public void setRoundProgressColor(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048582, this, i) == null) {
            this.c = i;
        }
    }
}
