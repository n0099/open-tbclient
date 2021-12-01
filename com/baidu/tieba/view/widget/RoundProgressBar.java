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
import com.baidu.tieba.R$styleable;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes11.dex */
public class RoundProgressBar extends View {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int FILL = 1;
    public static final int STROKE = 0;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public Paint f50572e;

    /* renamed from: f  reason: collision with root package name */
    public int f50573f;

    /* renamed from: g  reason: collision with root package name */
    public int f50574g;

    /* renamed from: h  reason: collision with root package name */
    public int f50575h;

    /* renamed from: i  reason: collision with root package name */
    public float f50576i;

    /* renamed from: j  reason: collision with root package name */
    public float f50577j;

    /* renamed from: k  reason: collision with root package name */
    public int f50578k;
    public int l;
    public boolean m;
    public int n;
    public RectF o;
    public a p;

    /* loaded from: classes11.dex */
    public interface a {
        void a(int i2);
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

    public synchronized int getMax() {
        InterceptResult invokeV;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            synchronized (this) {
                i2 = this.f50578k;
            }
            return i2;
        }
        return invokeV.intValue;
    }

    public synchronized int getProgress() {
        InterceptResult invokeV;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            synchronized (this) {
                i2 = this.l;
            }
            return i2;
        }
        return invokeV.intValue;
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, canvas) == null) {
            super.onDraw(canvas);
            int width = getWidth() / 2;
            float f2 = width;
            int i3 = (int) ((f2 - (this.f50577j / 2.0f)) - 5.0f);
            this.f50572e.setColor(this.f50573f);
            this.f50572e.setStyle(Paint.Style.STROKE);
            this.f50572e.setStrokeWidth(this.f50577j);
            this.f50572e.setAntiAlias(true);
            canvas.drawCircle(f2, f2, i3, this.f50572e);
            this.f50572e.setStrokeWidth(0.0f);
            this.f50572e.setColor(this.f50575h);
            this.f50572e.setTextSize(this.f50576i);
            this.f50572e.setTypeface(Typeface.DEFAULT_BOLD);
            int i4 = (int) ((this.l / this.f50578k) * 100.0f);
            float measureText = this.f50572e.measureText(i4 + "%");
            if (this.m && this.n == 0) {
                if (i4 == 0) {
                    i4 = 1;
                }
                canvas.drawText(i4 + "%", f2 - (measureText / 2.0f), f2 + (this.f50576i / 2.0f), this.f50572e);
            }
            this.f50572e.setStrokeWidth(this.f50577j);
            this.f50572e.setColor(this.f50574g);
            float f3 = width - i3;
            float f4 = width + i3;
            this.o.set(f3, f3, f4, f4);
            int i5 = this.n;
            if (i5 == 0) {
                this.f50572e.setStyle(Paint.Style.STROKE);
                canvas.drawArc(this.o, -90.0f, (this.l * 360) / this.f50578k, false, this.f50572e);
            } else if (i5 != 1) {
            } else {
                this.f50572e.setStyle(Paint.Style.FILL_AND_STROKE);
                if (this.l != 0) {
                    canvas.drawArc(this.o, -90.0f, (i2 * 360) / this.f50578k, true, this.f50572e);
                }
            }
        }
    }

    public synchronized void setMax(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i2) == null) {
            synchronized (this) {
                if (i2 >= 0) {
                    this.f50578k = i2;
                } else {
                    throw new IllegalArgumentException("max not less than 0");
                }
            }
        }
    }

    public void setOnProgressChangeListener(a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, aVar) == null) {
            this.p = aVar;
        }
    }

    public synchronized void setProgress(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i2) == null) {
            synchronized (this) {
                if (i2 >= 0) {
                    if (i2 > this.f50578k) {
                        i2 = this.f50578k;
                    }
                    if (i2 <= this.f50578k) {
                        this.l = i2;
                        if (this.p != null) {
                            this.p.a(i2);
                        }
                        postInvalidate();
                    }
                } else {
                    throw new IllegalArgumentException("progress not less than 0");
                }
            }
        }
    }

    public void setRoundProgressColor(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048582, this, i2) == null) {
            this.f50574g = i2;
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
    public RoundProgressBar(Context context, AttributeSet attributeSet, int i2) {
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
        this.f50572e = new Paint();
        this.o = new RectF();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.RoundProgressBar);
        this.f50573f = obtainStyledAttributes.getColor(R$styleable.RoundProgressBar_roundColor, getResources().getColor(R.color.CAM_X0607));
        this.f50574g = obtainStyledAttributes.getColor(R$styleable.RoundProgressBar_roundProgressColor, getResources().getColor(R.color.CAM_X0302));
        this.f50575h = obtainStyledAttributes.getColor(R$styleable.RoundProgressBar_roundTextColor, getResources().getColor(R.color.CAM_X0201));
        this.f50576i = obtainStyledAttributes.getDimension(R$styleable.RoundProgressBar_roundTextSize, UtilHelper.getDimenPixelSize(R.dimen.tbds10));
        this.f50577j = obtainStyledAttributes.getDimension(R$styleable.RoundProgressBar_roundWidth, UtilHelper.getDimenPixelSize(R.dimen.tbds7));
        this.f50578k = obtainStyledAttributes.getInteger(R$styleable.RoundProgressBar_roundMax, 100);
        this.m = obtainStyledAttributes.getBoolean(R$styleable.RoundProgressBar_textIsDisplayable, true);
        this.n = obtainStyledAttributes.getInt(R$styleable.RoundProgressBar_style, 0);
        obtainStyledAttributes.recycle();
    }
}
