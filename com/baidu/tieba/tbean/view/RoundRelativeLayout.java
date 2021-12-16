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
/* loaded from: classes12.dex */
public class RoundRelativeLayout extends RelativeLayout {
    public static /* synthetic */ Interceptable $ic;
    public static final int l;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public float f49920e;

    /* renamed from: f  reason: collision with root package name */
    public Shape f49921f;

    /* renamed from: g  reason: collision with root package name */
    public Paint f49922g;

    /* renamed from: h  reason: collision with root package name */
    public Paint f49923h;

    /* renamed from: i  reason: collision with root package name */
    public RectF f49924i;

    /* renamed from: j  reason: collision with root package name */
    public Paint f49925j;

    /* renamed from: k  reason: collision with root package name */
    public int f49926k;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1360331784, "Lcom/baidu/tieba/tbean/view/RoundRelativeLayout;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1360331784, "Lcom/baidu/tieba/tbean/view/RoundRelativeLayout;");
                return;
            }
        }
        l = R.color.black_alpha4;
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

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, canvas) == null) {
            int saveCount = canvas.getSaveCount();
            canvas.save();
            RectF rectF = this.f49924i;
            float f2 = this.f49920e;
            canvas.drawRoundRect(rectF, f2, f2, this.f49925j);
            super.dispatchDraw(canvas);
            Shape shape = this.f49921f;
            if (shape != null) {
                shape.draw(canvas, this.f49922g);
            }
            RectF rectF2 = this.f49924i;
            float f3 = this.f49920e;
            canvas.drawRoundRect(rectF2, f3, f3, this.f49923h);
            if (saveCount < 1 || saveCount > canvas.getSaveCount()) {
                return;
            }
            canvas.restoreToCount(saveCount);
        }
    }

    @Override // android.widget.RelativeLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5)}) == null) {
            super.onLayout(z, i2, i3, i4, i5);
            if (z) {
                if (this.f49921f == null) {
                    float[] fArr = new float[8];
                    Arrays.fill(fArr, 0.0f);
                    float dimension = ((float) getPaddingLeft()) <= getResources().getDimension(R.dimen.tbds8) ? getResources().getDimension(R.dimen.tbds8) : getPaddingLeft();
                    float dimension2 = ((float) getPaddingRight()) <= getResources().getDimension(R.dimen.tbds8) ? getResources().getDimension(R.dimen.tbds8) : getPaddingRight();
                    float paddingTop = getPaddingTop() <= 0 ? 1.0f : getPaddingTop();
                    float dimension3 = ((float) getPaddingBottom()) <= getResources().getDimension(R.dimen.tbds8) ? getResources().getDimension(R.dimen.tbds8) : getPaddingBottom();
                    RectF rectF = new RectF(dimension, paddingTop, dimension2, dimension3);
                    float[] fArr2 = new float[8];
                    Arrays.fill(fArr2, this.f49920e);
                    this.f49921f = new RoundRectShape(fArr, rectF, fArr2);
                    this.f49924i.set(dimension, paddingTop, getWidth() - dimension2, getHeight() - dimension3);
                }
                this.f49921f.resize(getWidth(), getHeight());
            }
        }
    }

    public void setBgColorRes(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) {
            this.f49926k = i2;
            if (i2 != 0) {
                this.f49925j.setColor(getContext().getResources().getColor(this.f49926k));
                invalidate();
            }
        }
    }

    public void setRadius(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048579, this, f2) == null) {
            this.f49920e = f2;
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
    public RoundRelativeLayout(Context context, AttributeSet attributeSet, int i2) {
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
        this.f49920e = 0.0f;
        setLayerType(1, null);
        Paint paint = new Paint();
        this.f49922g = paint;
        paint.setAntiAlias(true);
        this.f49922g.setColor(-1);
        this.f49922g.setStyle(Paint.Style.FILL);
        this.f49922g.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
        Paint paint2 = new Paint();
        this.f49923h = paint2;
        paint2.setAntiAlias(true);
        this.f49923h.setColor(0);
        this.f49923h.setStyle(Paint.Style.FILL);
        this.f49923h.setShadowLayer(getResources().getDimension(R.dimen.tbds5), 0.0f, getResources().getDimension(R.dimen.tbds8), getResources().getColor(l));
        this.f49923h.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OVER));
        this.f49924i = new RectF();
        Paint paint3 = new Paint();
        this.f49925j = paint3;
        paint3.setAntiAlias(true);
        this.f49925j.setColor(-1);
        this.f49922g.setStyle(Paint.Style.FILL);
    }
}
