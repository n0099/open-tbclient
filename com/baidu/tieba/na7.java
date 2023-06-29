package com.baidu.tieba;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.graphics.Xfermode;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class na7 implements ma7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;
    public View b;
    public Paint c;
    public RectF d;
    public RectF e;
    public RectF f;
    public Path g;
    public Path h;
    public Xfermode i;
    public float[] j;
    public float[] k;
    public int l;
    public int m;
    public int n;
    public float o;
    public float p;
    public float q;
    public float r;
    public float s;

    public na7() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static float a(@NonNull Context context, float f) {
        InterceptResult invokeLF;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLF = interceptable.invokeLF(65537, null, context, f)) == null) {
            return f * context.getResources().getDisplayMetrics().density;
        }
        return invokeLF.floatValue;
    }

    public final void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            float[] fArr = this.j;
            float f = this.p;
            float f2 = this.o;
            float f3 = f - f2;
            fArr[1] = f3;
            fArr[0] = f3;
            float f4 = this.q;
            float f5 = f4 - f2;
            fArr[3] = f5;
            fArr[2] = f5;
            float f6 = this.s;
            float f7 = f6 - f2;
            fArr[5] = f7;
            fArr[4] = f7;
            float f8 = this.r;
            float f9 = f8 - f2;
            fArr[7] = f9;
            fArr[6] = f9;
            float[] fArr2 = this.k;
            float f10 = f - (f2 / 2.0f);
            fArr2[1] = f10;
            fArr2[0] = f10;
            float f11 = f4 - (f2 / 2.0f);
            fArr2[3] = f11;
            fArr2[2] = f11;
            float f12 = f6 - (f2 / 2.0f);
            fArr2[5] = f12;
            fArr2[4] = f12;
            float f13 = f8 - (f2 / 2.0f);
            fArr2[7] = f13;
            fArr2[6] = f13;
        }
    }

    @Override // com.baidu.tieba.ma7
    public void f(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, i2) == null) {
            this.l = i;
            this.m = i2;
            b();
            RectF rectF = this.d;
            if (rectF != null) {
                float f = this.o;
                rectF.set(f, f, i - f, i2 - f);
            }
            RectF rectF2 = this.e;
            if (rectF2 != null) {
                float f2 = this.o;
                rectF2.set(f2 / 2.0f, f2 / 2.0f, i - (f2 / 2.0f), i2 - (f2 / 2.0f));
            }
            RectF rectF3 = this.f;
            if (rectF3 != null) {
                rectF3.set(0.0f, 0.0f, i, i2);
            }
        }
    }

    @Override // com.baidu.tieba.oa7
    public void setStrokeWidthColor(float f, int i) {
        Context context;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(1048593, this, new Object[]{Float.valueOf(f), Integer.valueOf(i)}) != null) || (context = this.a) == null) {
            return;
        }
        this.o = a(context, f);
        this.n = i;
        if (this.b != null) {
            f(this.l, this.m);
            this.b.invalidate();
        }
    }

    @Override // com.baidu.tieba.ma7
    public void g(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, canvas) == null) {
            this.c.reset();
            this.g.reset();
            this.c.setAntiAlias(true);
            this.c.setStyle(Paint.Style.FILL);
            this.c.setXfermode(this.i);
            this.g.addRoundRect(this.d, this.j, Path.Direction.CCW);
            if (Build.VERSION.SDK_INT >= 23) {
                this.h.reset();
                this.h.addRect(this.f, Path.Direction.CCW);
                this.h.op(this.g, Path.Op.DIFFERENCE);
                canvas.drawPath(this.h, this.c);
            } else {
                canvas.drawPath(this.g, this.c);
            }
            this.c.setXfermode(null);
            canvas.restore();
            this.c.setXfermode(null);
            if (this.o > 0.0f) {
                this.c.setStyle(Paint.Style.STROKE);
                this.c.setStrokeWidth(this.o);
                this.c.setColor(this.n);
                this.g.reset();
                this.g.addRoundRect(this.e, this.k, Path.Direction.CCW);
                canvas.drawPath(this.g, this.c);
            }
        }
    }

    @Override // com.baidu.tieba.ma7
    public void k(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, canvas) == null) {
            canvas.saveLayer(this.d, null, 31);
        }
    }

    @Override // com.baidu.tieba.oa7
    public void setRadius(float f) {
        Context context;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeF(1048581, this, f) != null) || (context = this.a) == null) {
            return;
        }
        float a = a(context, f);
        this.p = a;
        this.q = a;
        this.r = a;
        this.s = a;
        if (this.b != null) {
            f(this.l, this.m);
            this.b.invalidate();
        }
    }

    @Override // com.baidu.tieba.oa7
    public void setRadiusBottom(float f) {
        Context context;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeF(1048583, this, f) != null) || (context = this.a) == null) {
            return;
        }
        float a = a(context, f);
        this.r = a;
        this.s = a;
        if (this.b != null) {
            f(this.l, this.m);
            this.b.invalidate();
        }
    }

    @Override // com.baidu.tieba.oa7
    public void setRadiusBottomLeft(float f) {
        Context context;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeF(InputDeviceCompat.SOURCE_TOUCHPAD, this, f) != null) || (context = this.a) == null) {
            return;
        }
        this.r = a(context, f);
        if (this.b != null) {
            f(this.l, this.m);
            this.b.invalidate();
        }
    }

    @Override // com.baidu.tieba.oa7
    public void setRadiusBottomRight(float f) {
        Context context;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeF(1048585, this, f) != null) || (context = this.a) == null) {
            return;
        }
        this.s = a(context, f);
        if (this.b != null) {
            f(this.l, this.m);
            this.b.invalidate();
        }
    }

    @Override // com.baidu.tieba.oa7
    public void setRadiusLeft(float f) {
        Context context;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeF(1048586, this, f) != null) || (context = this.a) == null) {
            return;
        }
        float a = a(context, f);
        this.p = a;
        this.r = a;
        if (this.b != null) {
            f(this.l, this.m);
            this.b.invalidate();
        }
    }

    @Override // com.baidu.tieba.oa7
    public void setRadiusRight(float f) {
        Context context;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeF(1048587, this, f) != null) || (context = this.a) == null) {
            return;
        }
        float a = a(context, f);
        this.q = a;
        this.s = a;
        if (this.b != null) {
            f(this.l, this.m);
            this.b.invalidate();
        }
    }

    @Override // com.baidu.tieba.oa7
    public void setRadiusTop(float f) {
        Context context;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeF(1048588, this, f) != null) || (context = this.a) == null) {
            return;
        }
        float a = a(context, f);
        this.p = a;
        this.q = a;
        if (this.b != null) {
            f(this.l, this.m);
            this.b.invalidate();
        }
    }

    @Override // com.baidu.tieba.oa7
    public void setRadiusTopLeft(float f) {
        Context context;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeF(1048589, this, f) != null) || (context = this.a) == null) {
            return;
        }
        this.p = a(context, f);
        if (this.b != null) {
            f(this.l, this.m);
            this.b.invalidate();
        }
    }

    @Override // com.baidu.tieba.oa7
    public void setRadiusTopRight(float f) {
        Context context;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeF(1048590, this, f) != null) || (context = this.a) == null) {
            return;
        }
        this.q = a(context, f);
        if (this.b != null) {
            f(this.l, this.m);
            this.b.invalidate();
        }
    }

    @Override // com.baidu.tieba.oa7
    public void setStrokeColor(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048591, this, i) == null) {
            this.n = i;
            if (this.b != null) {
                f(this.l, this.m);
                this.b.invalidate();
            }
        }
    }

    @Override // com.baidu.tieba.oa7
    public void setStrokeWidth(float f) {
        Context context;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeF(1048592, this, f) != null) || (context = this.a) == null) {
            return;
        }
        this.o = a(context, f);
        if (this.b != null) {
            f(this.l, this.m);
            this.b.invalidate();
        }
    }

    @Override // com.baidu.tieba.ma7
    public void m(Context context, AttributeSet attributeSet, View view2) {
        PorterDuff.Mode mode;
        float f;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048580, this, context, attributeSet, view2) == null) {
            if (view2.getBackground() == null) {
                view2.setBackgroundColor(Color.parseColor("#00000000"));
            }
            view2.setLayerType(0, null);
            this.a = context;
            this.b = view2;
            this.j = new float[8];
            this.k = new float[8];
            this.c = new Paint();
            this.d = new RectF();
            this.e = new RectF();
            this.f = new RectF();
            this.g = new Path();
            this.h = new Path();
            if (Build.VERSION.SDK_INT >= 23) {
                mode = PorterDuff.Mode.DST_OUT;
            } else {
                mode = PorterDuff.Mode.DST_IN;
            }
            this.i = new PorterDuffXfermode(mode);
            this.n = -1;
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, e57.RoundCorner);
            if (obtainStyledAttributes == null) {
                return;
            }
            float dimension = obtainStyledAttributes.getDimension(4, 0.0f);
            float dimension2 = obtainStyledAttributes.getDimension(3, dimension);
            float dimension3 = obtainStyledAttributes.getDimension(5, dimension);
            float dimension4 = obtainStyledAttributes.getDimension(9, dimension);
            float dimension5 = obtainStyledAttributes.getDimension(1, dimension);
            int i = (dimension4 > 0.0f ? 1 : (dimension4 == 0.0f ? 0 : -1));
            if (i > 0) {
                f = dimension4;
            } else {
                f = dimension2;
            }
            this.p = obtainStyledAttributes.getDimension(8, f);
            if (i <= 0) {
                dimension4 = dimension3;
            }
            this.q = obtainStyledAttributes.getDimension(10, dimension4);
            int i2 = (dimension5 > 0.0f ? 1 : (dimension5 == 0.0f ? 0 : -1));
            if (i2 > 0) {
                dimension2 = dimension5;
            }
            this.r = obtainStyledAttributes.getDimension(0, dimension2);
            if (i2 > 0) {
                dimension3 = dimension5;
            }
            this.s = obtainStyledAttributes.getDimension(2, dimension3);
            this.o = obtainStyledAttributes.getDimension(7, 0.0f);
            this.n = obtainStyledAttributes.getColor(6, this.n);
            obtainStyledAttributes.recycle();
        }
    }

    @Override // com.baidu.tieba.oa7
    public void setRadius(float f, float f2, float f3, float f4) {
        Context context;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(1048582, this, new Object[]{Float.valueOf(f), Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4)}) != null) || (context = this.a) == null) {
            return;
        }
        this.p = a(context, f);
        this.q = a(this.a, f2);
        this.r = a(this.a, f3);
        this.s = a(this.a, f4);
        if (this.b != null) {
            f(this.l, this.m);
            this.b.invalidate();
        }
    }
}
