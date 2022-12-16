package com.baidu.tieba.view.anniversary.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tieba.R;
import com.baidu.tieba.pw4;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Arrays;
/* loaded from: classes6.dex */
public class MaxureLayerView extends View {
    public static /* synthetic */ Interceptable $ic;
    public static final int p;
    public static final int q;
    public static final int r;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;
    public Paint b;
    public Paint c;
    public Paint d;
    public Paint e;
    public int f;
    public int g;
    public float h;
    public boolean i;
    public int j;
    public float k;
    public Path l;
    public RectF m;
    public Path n;
    public RectF o;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-365729928, "Lcom/baidu/tieba/view/anniversary/view/MaxureLayerView;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-365729928, "Lcom/baidu/tieba/view/anniversary/view/MaxureLayerView;");
                return;
            }
        }
        p = UtilHelper.getDimenPixelSize(R.dimen.tbds21);
        q = UtilHelper.getDimenPixelSize(R.dimen.tbds42);
        r = UtilHelper.getDimenPixelSize(R.dimen.tbds1);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public MaxureLayerView(Context context) {
        this(context, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public MaxureLayerView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65538, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MaxureLayerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i)};
            interceptable.invokeUnInit(65539, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65539, newInitContext);
                return;
            }
        }
        this.j = R.string.J_X06;
        this.k = UtilHelper.getDimenPixelSize(R.dimen.tbds16);
        this.l = new Path();
        this.m = new RectF();
        this.n = new Path();
        this.o = new RectF();
        a(attributeSet);
    }

    public void a(AttributeSet attributeSet) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, attributeSet) == null) {
            Paint paint = new Paint();
            this.b = paint;
            paint.setStrokeWidth(0.0f);
            this.b.setAntiAlias(true);
            Paint paint2 = new Paint();
            this.c = paint2;
            paint2.setAntiAlias(true);
            this.c.setStyle(Paint.Style.FILL);
            Paint paint3 = new Paint();
            this.d = paint3;
            paint3.setStyle(Paint.Style.FILL);
            Paint paint4 = new Paint();
            this.e = paint4;
            paint4.setStyle(Paint.Style.FILL);
            g(this.g);
            h(this.h);
            d(this.a);
        }
    }

    public final float[] b(float f) {
        InterceptResult invokeF;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeF = interceptable.invokeF(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, f)) == null) {
            float[] fArr = new float[8];
            Arrays.fill(fArr, f);
            return fArr;
        }
        return (float[]) invokeF.objValue;
    }

    public MaxureLayerView c(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z)) == null) {
            this.i = z;
            postInvalidate();
            return this;
        }
        return (MaxureLayerView) invokeZ.objValue;
    }

    public MaxureLayerView d(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i)) == null) {
            this.a = i;
            this.d.setColor(i);
            postInvalidate();
            return this;
        }
        return (MaxureLayerView) invokeI.objValue;
    }

    public MaxureLayerView e(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048580, this, i)) == null) {
            this.e.setColor(i);
            postInvalidate();
            return this;
        }
        return (MaxureLayerView) invokeI.objValue;
    }

    public MaxureLayerView f(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048581, this, i)) == null) {
            this.c.setColor(i);
            postInvalidate();
            return this;
        }
        return (MaxureLayerView) invokeI.objValue;
    }

    public MaxureLayerView g(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048582, this, i)) == null) {
            this.g = i;
            this.b.setColor(i);
            postInvalidate();
            return this;
        }
        return (MaxureLayerView) invokeI.objValue;
    }

    public MaxureLayerView h(float f) {
        InterceptResult invokeF;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeF = interceptable.invokeF(InputDeviceCompat.SOURCE_TOUCHPAD, this, f)) == null) {
            this.b.setTextSize(f);
            postInvalidate();
            return this;
        }
        return (MaxureLayerView) invokeF.objValue;
    }

    public void setProgress(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048586, this, i) == null) {
            if (i >= 0) {
                if (i >= 100) {
                    i = 100;
                }
                this.f = i;
                d(this.a);
                postInvalidate();
                return;
            }
            throw new IllegalArgumentException("progress not less than 0");
        }
    }

    public int getProgress() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.f;
        }
        return invokeV.intValue;
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        int i;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048585, this, canvas) == null) && (i = this.f) <= 100 && i >= 0) {
            this.l.reset();
            this.m.right = getWidth();
            this.m.bottom = getHeight();
            this.l.addRoundRect(this.m, pw4.z(this.j), Path.Direction.CW);
            canvas.clipPath(this.l);
            float f = 1.0f - ((100 - i) / 100.0f);
            canvas.drawRect(0.0f, f * getHeight(), getWidth(), (getHeight() * f) + r, this.e);
            canvas.drawRect(0.0f, (f * getHeight()) + r, getWidth(), getHeight(), this.d);
            if (this.i) {
                this.n.reset();
                this.o.left = ((getWidth() - this.b.measureText(this.f + "%")) / 2.0f) - q;
                this.o.right = ((getWidth() + this.b.measureText(this.f + "%")) / 2.0f) + q;
                this.o.top = ((getHeight() - (this.b.descent() + this.b.ascent())) / 2.0f) + p;
                this.o.bottom = ((getHeight() + (this.b.descent() + this.b.ascent())) / 2.0f) - p;
                this.n.addRoundRect(this.o, b(this.k), Path.Direction.CW);
                canvas.clipPath(this.n);
                canvas.drawRect(((getWidth() - this.b.measureText(this.f + "%")) / 2.0f) - q, ((getHeight() - (this.b.descent() + this.b.ascent())) / 2.0f) + p, ((getWidth() + this.b.measureText(this.f + "%")) / 2.0f) + q, ((getHeight() + (this.b.descent() + this.b.ascent())) / 2.0f) - p, this.d);
                canvas.drawText(this.f + "%", (getWidth() - this.b.measureText(this.f + "%")) / 2.0f, (getHeight() - (this.b.descent() + this.b.ascent())) / 2.0f, this.b);
            }
        }
    }
}
