package com.baidu.tieba.view.anniversary.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import androidx.core.view.InputDeviceCompat;
import c.a.q0.s.u.a;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Arrays;
/* loaded from: classes11.dex */
public class MaxureLayerView extends View {
    public static /* synthetic */ Interceptable $ic;
    public static final int t;
    public static final int u;
    public static final int v;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public int f50420e;

    /* renamed from: f  reason: collision with root package name */
    public Paint f50421f;

    /* renamed from: g  reason: collision with root package name */
    public Paint f50422g;

    /* renamed from: h  reason: collision with root package name */
    public Paint f50423h;

    /* renamed from: i  reason: collision with root package name */
    public Paint f50424i;

    /* renamed from: j  reason: collision with root package name */
    public int f50425j;

    /* renamed from: k  reason: collision with root package name */
    public int f50426k;
    public float l;
    public boolean m;
    public int n;
    public float o;
    public Path p;
    public RectF q;
    public Path r;
    public RectF s;

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
        t = UtilHelper.getDimenPixelSize(R.dimen.tbds21);
        u = UtilHelper.getDimenPixelSize(R.dimen.tbds42);
        v = UtilHelper.getDimenPixelSize(R.dimen.tbds1);
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    public void a(AttributeSet attributeSet) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, attributeSet) == null) {
            Paint paint = new Paint();
            this.f50421f = paint;
            paint.setStrokeWidth(0.0f);
            this.f50421f.setAntiAlias(true);
            Paint paint2 = new Paint();
            this.f50422g = paint2;
            paint2.setAntiAlias(true);
            this.f50422g.setStyle(Paint.Style.FILL);
            Paint paint3 = new Paint();
            this.f50423h = paint3;
            paint3.setStyle(Paint.Style.FILL);
            Paint paint4 = new Paint();
            this.f50424i = paint4;
            paint4.setStyle(Paint.Style.FILL);
            setTextColor(this.f50426k);
            setTextSize(this.l);
            setLayerColor(this.f50420e);
        }
    }

    public final float[] b(float f2) {
        InterceptResult invokeF;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeF = interceptable.invokeF(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, f2)) == null) {
            float[] fArr = new float[8];
            Arrays.fill(fArr, f2);
            return fArr;
        }
        return (float[]) invokeF.objValue;
    }

    public int getProgress() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f50425j : invokeV.intValue;
    }

    public boolean isError() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f50425j < 0 : invokeV.booleanValue;
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        int i2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, canvas) == null) || (i2 = this.f50425j) > 100 || i2 < 0) {
            return;
        }
        this.p.reset();
        this.q.right = getWidth();
        this.q.bottom = getHeight();
        this.p.addRoundRect(this.q, a.y(this.n), Path.Direction.CW);
        canvas.clipPath(this.p);
        float f2 = 1.0f - ((100 - i2) / 100.0f);
        canvas.drawRect(0.0f, f2 * getHeight(), getWidth(), (getHeight() * f2) + v, this.f50424i);
        canvas.drawRect(0.0f, (f2 * getHeight()) + v, getWidth(), getHeight(), this.f50423h);
        if (this.m) {
            this.r.reset();
            this.s.left = ((getWidth() - this.f50421f.measureText(this.f50425j + "%")) / 2.0f) - u;
            this.s.right = ((getWidth() + this.f50421f.measureText(this.f50425j + "%")) / 2.0f) + u;
            this.s.top = ((getHeight() - (this.f50421f.descent() + this.f50421f.ascent())) / 2.0f) + t;
            this.s.bottom = ((getHeight() + (this.f50421f.descent() + this.f50421f.ascent())) / 2.0f) - t;
            this.r.addRoundRect(this.s, b(this.o), Path.Direction.CW);
            canvas.clipPath(this.r);
            canvas.drawRect(((getWidth() - this.f50421f.measureText(this.f50425j + "%")) / 2.0f) - u, ((getHeight() - (this.f50421f.descent() + this.f50421f.ascent())) / 2.0f) + t, ((getWidth() + this.f50421f.measureText(this.f50425j + "%")) / 2.0f) + u, ((getHeight() + (this.f50421f.descent() + this.f50421f.ascent())) / 2.0f) - t, this.f50423h);
            canvas.drawText(this.f50425j + "%", (getWidth() - this.f50421f.measureText(this.f50425j + "%")) / 2.0f, (getHeight() - (this.f50421f.descent() + this.f50421f.ascent())) / 2.0f, this.f50421f);
        }
    }

    public void reset() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.f50425j = 0;
            this.f50423h.setColor(this.f50420e);
            postInvalidate();
        }
    }

    public MaxureLayerView setHasText(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048582, this, z)) == null) {
            this.m = z;
            postInvalidate();
            return this;
        }
        return (MaxureLayerView) invokeZ.objValue;
    }

    public MaxureLayerView setLayerColor(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048583, this, i2)) == null) {
            this.f50420e = i2;
            this.f50423h.setColor(i2);
            postInvalidate();
            return this;
        }
        return (MaxureLayerView) invokeI.objValue;
    }

    public MaxureLayerView setLayerLineColor(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2)) == null) {
            this.f50424i.setColor(i2);
            postInvalidate();
            return this;
        }
        return (MaxureLayerView) invokeI.objValue;
    }

    public void setProgress(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048585, this, i2) == null) {
            if (i2 >= 0) {
                if (i2 >= 100) {
                    i2 = 100;
                }
                this.f50425j = i2;
                setLayerColor(this.f50420e);
                postInvalidate();
                return;
            }
            throw new IllegalArgumentException("progress not less than 0");
        }
    }

    public MaxureLayerView setTextBackColor(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048586, this, i2)) == null) {
            this.f50422g.setColor(i2);
            postInvalidate();
            return this;
        }
        return (MaxureLayerView) invokeI.objValue;
    }

    public MaxureLayerView setTextColor(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048587, this, i2)) == null) {
            this.f50426k = i2;
            this.f50421f.setColor(i2);
            postInvalidate();
            return this;
        }
        return (MaxureLayerView) invokeI.objValue;
    }

    public MaxureLayerView setTextSize(float f2) {
        InterceptResult invokeF;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeF = interceptable.invokeF(1048588, this, f2)) == null) {
            this.f50421f.setTextSize(f2);
            postInvalidate();
            return this;
        }
        return (MaxureLayerView) invokeF.objValue;
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MaxureLayerView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65539, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65539, newInitContext);
                return;
            }
        }
        this.n = R.string.J_X06;
        this.o = UtilHelper.getDimenPixelSize(R.dimen.tbds16);
        this.p = new Path();
        this.q = new RectF();
        this.r = new Path();
        this.s = new RectF();
        a(attributeSet);
    }
}
