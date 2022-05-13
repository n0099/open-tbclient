package com.baidu.tieba.tbean.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.graphics.drawable.shapes.RoundRectShape;
import android.graphics.drawable.shapes.Shape;
import android.util.AttributeSet;
import android.widget.RelativeLayout;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Arrays;
/* loaded from: classes4.dex */
public class RoundRelativeLayout extends RelativeLayout {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int h = 2131100696;
    public transient /* synthetic */ FieldHolder $fh;
    public float a;
    public Shape b;
    public Paint c;
    public Paint d;
    public RectF e;
    public Paint f;
    public int g;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1360331784, "Lcom/baidu/tieba/tbean/view/RoundRelativeLayout;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1360331784, "Lcom/baidu/tieba/tbean/view/RoundRelativeLayout;");
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public RoundRelativeLayout(Context context) {
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

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, canvas) == null) {
            int saveCount = canvas.getSaveCount();
            canvas.save();
            RectF rectF = this.e;
            float f = this.a;
            canvas.drawRoundRect(rectF, f, f, this.f);
            super.dispatchDraw(canvas);
            Shape shape = this.b;
            if (shape != null) {
                shape.draw(canvas, this.c);
            }
            RectF rectF2 = this.e;
            float f2 = this.a;
            canvas.drawRoundRect(rectF2, f2, f2, this.d);
            if (saveCount < 1 || saveCount > canvas.getSaveCount()) {
                return;
            }
            canvas.restoreToCount(saveCount);
        }
    }

    @Override // android.widget.RelativeLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)}) == null) {
            super.onLayout(z, i, i2, i3, i4);
            if (z) {
                if (this.b == null) {
                    float[] fArr = new float[8];
                    Arrays.fill(fArr, 0.0f);
                    float dimension = ((float) getPaddingLeft()) <= getResources().getDimension(R.dimen.tbds8) ? getResources().getDimension(R.dimen.tbds8) : getPaddingLeft();
                    float dimension2 = ((float) getPaddingRight()) <= getResources().getDimension(R.dimen.tbds8) ? getResources().getDimension(R.dimen.tbds8) : getPaddingRight();
                    float paddingTop = getPaddingTop() <= 0 ? 1.0f : getPaddingTop();
                    float dimension3 = ((float) getPaddingBottom()) <= getResources().getDimension(R.dimen.tbds8) ? getResources().getDimension(R.dimen.tbds8) : getPaddingBottom();
                    RectF rectF = new RectF(dimension, paddingTop, dimension2, dimension3);
                    float[] fArr2 = new float[8];
                    Arrays.fill(fArr2, this.a);
                    this.b = new RoundRectShape(fArr, rectF, fArr2);
                    this.e.set(dimension, paddingTop, getWidth() - dimension2, getHeight() - dimension3);
                }
                this.b.resize(getWidth(), getHeight());
            }
        }
    }

    public void setBgColorRes(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i) == null) {
            this.g = i;
            if (i != 0) {
                this.f.setColor(getContext().getResources().getColor(this.g));
                invalidate();
            }
        }
    }

    public void setRadius(float f) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048579, this, f) == null) {
            this.a = f;
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public RoundRelativeLayout(Context context, AttributeSet attributeSet) {
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
    public RoundRelativeLayout(Context context, AttributeSet attributeSet, int i) {
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
        this.a = 0.0f;
        setLayerType(1, null);
        Paint paint = new Paint();
        this.c = paint;
        paint.setAntiAlias(true);
        this.c.setColor(-1);
        this.c.setStyle(Paint.Style.FILL);
        this.c.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
        Paint paint2 = new Paint();
        this.d = paint2;
        paint2.setAntiAlias(true);
        this.d.setColor(0);
        this.d.setStyle(Paint.Style.FILL);
        this.d.setShadowLayer(getResources().getDimension(R.dimen.tbds5), 0.0f, getResources().getDimension(R.dimen.tbds8), getResources().getColor(h));
        this.d.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OVER));
        this.e = new RectF();
        Paint paint3 = new Paint();
        this.f = paint3;
        paint3.setAntiAlias(true);
        this.f.setColor(-1);
        this.c.setStyle(Paint.Style.FILL);
    }
}
