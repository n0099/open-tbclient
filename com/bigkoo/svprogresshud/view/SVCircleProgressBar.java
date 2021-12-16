package com.bigkoo.svprogresshud.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bigkoo.svprogresshud.R;
/* loaded from: classes2.dex */
public class SVCircleProgressBar extends View {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int FILL = 1;
    public static final int STROKE = 0;
    public transient /* synthetic */ FieldHolder $fh;
    public int max;
    public Paint paint;
    public int progress;
    public int roundColor;
    public int roundProgressColor;
    public float roundWidth;
    public int style;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public SVCircleProgressBar(Context context) {
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

    public int getCircleColor() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.roundColor : invokeV.intValue;
    }

    public int getCircleProgressColor() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.roundProgressColor : invokeV.intValue;
    }

    public synchronized int getMax() {
        InterceptResult invokeV;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            synchronized (this) {
                i2 = this.max;
            }
            return i2;
        }
        return invokeV.intValue;
    }

    public synchronized int getProgress() {
        InterceptResult invokeV;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            synchronized (this) {
                i2 = this.progress;
            }
            return i2;
        }
        return invokeV.intValue;
    }

    public float getRoundWidth() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.roundWidth : invokeV.floatValue;
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, canvas) == null) {
            super.onDraw(canvas);
            int width = getWidth() / 2;
            float f2 = width;
            int i3 = (int) (f2 - (this.roundWidth / 2.0f));
            this.paint.setAntiAlias(true);
            this.paint.setColor(this.roundColor);
            this.paint.setStyle(Paint.Style.STROKE);
            this.paint.setStrokeWidth(this.roundWidth);
            canvas.drawCircle(f2, f2, i3, this.paint);
            this.paint.setStrokeWidth(this.roundWidth);
            this.paint.setColor(this.roundProgressColor);
            float f3 = width - i3;
            float f4 = width + i3;
            RectF rectF = new RectF(f3, f3, f4, f4);
            int i4 = this.style;
            if (i4 == 0) {
                this.paint.setStyle(Paint.Style.STROKE);
                canvas.drawArc(rectF, 270.0f, (this.progress * 360) / this.max, false, this.paint);
            } else if (i4 != 1) {
            } else {
                this.paint.setStyle(Paint.Style.FILL_AND_STROKE);
                if (this.progress != 0) {
                    canvas.drawArc(rectF, 270.0f, (i2 * 360) / this.max, true, this.paint);
                }
            }
        }
    }

    public void setCircleColor(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048582, this, i2) == null) {
            this.roundColor = i2;
        }
    }

    public void setCircleProgressColor(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i2) == null) {
            this.roundProgressColor = i2;
        }
    }

    public synchronized void setMax(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2) == null) {
            synchronized (this) {
                if (i2 >= 0) {
                    this.max = i2;
                } else {
                    throw new IllegalArgumentException("max not less than 0");
                }
            }
        }
    }

    public synchronized void setProgress(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048585, this, i2) == null) {
            synchronized (this) {
                if (i2 >= 0) {
                    if (i2 > this.max) {
                        i2 = this.max;
                    }
                    if (i2 <= this.max) {
                        this.progress = i2;
                        postInvalidate();
                    }
                } else {
                    throw new IllegalArgumentException("progress not less than 0");
                }
            }
        }
    }

    public void setRoundWidth(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048586, this, f2) == null) {
            this.roundWidth = f2;
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public SVCircleProgressBar(Context context, AttributeSet attributeSet) {
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
    public SVCircleProgressBar(Context context, AttributeSet attributeSet, int i2) {
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
        this.paint = new Paint();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.SVCircleProgressBar);
        this.roundColor = obtainStyledAttributes.getColor(R.styleable.SVCircleProgressBar_svprogress_roundColor, -16776961);
        this.roundProgressColor = obtainStyledAttributes.getColor(R.styleable.SVCircleProgressBar_svprogress_roundProgressColor, -7829368);
        this.roundWidth = obtainStyledAttributes.getDimension(R.styleable.SVCircleProgressBar_svprogress_roundWidth, 5.0f);
        this.max = obtainStyledAttributes.getInteger(R.styleable.SVCircleProgressBar_svprogress_max, 100);
        this.style = obtainStyledAttributes.getInt(R.styleable.SVCircleProgressBar_svprogress_style, 0);
        obtainStyledAttributes.recycle();
    }
}
