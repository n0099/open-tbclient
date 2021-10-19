package com.baidu.tieba.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.graphics.drawable.shapes.RoundRectShape;
import android.graphics.drawable.shapes.Shape;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Arrays;
/* loaded from: classes7.dex */
public class RoundAndShadowLinearLayout extends LinearLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public float f58375e;

    /* renamed from: f  reason: collision with root package name */
    public Shape f58376f;

    /* renamed from: g  reason: collision with root package name */
    public Paint f58377g;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public RoundAndShadowLinearLayout(Context context) {
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

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, canvas) == null) {
            int saveCount = canvas.getSaveCount();
            canvas.save();
            super.dispatchDraw(canvas);
            Shape shape = this.f58376f;
            if (shape != null) {
                shape.draw(canvas, this.f58377g);
            }
            if (saveCount < 1 || saveCount > canvas.getSaveCount()) {
                return;
            }
            canvas.restoreToCount(saveCount);
        }
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5)}) == null) {
            super.onLayout(z, i2, i3, i4, i5);
            if (z) {
                if (this.f58376f == null) {
                    float[] fArr = new float[8];
                    Arrays.fill(fArr, 0.0f);
                    RectF rectF = new RectF(getPaddingLeft() <= 0 ? 0.1f : getPaddingLeft(), getPaddingTop() <= 0 ? 0.1f : getPaddingTop(), getPaddingRight() <= 0 ? 0.1f : getPaddingRight(), getPaddingBottom() > 0 ? getPaddingBottom() : 0.1f);
                    float[] fArr2 = new float[8];
                    Arrays.fill(fArr, 0.0f);
                    Arrays.fill(fArr2, this.f58375e);
                    this.f58376f = new RoundRectShape(fArr, rectF, fArr2);
                }
                this.f58376f.resize(getWidth(), getHeight());
            }
        }
    }

    public void setRadius(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(Constants.METHOD_SEND_USER_MSG, this, f2) == null) {
            this.f58375e = f2;
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public RoundAndShadowLinearLayout(Context context, AttributeSet attributeSet) {
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
    public RoundAndShadowLinearLayout(Context context, AttributeSet attributeSet, int i2) {
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
        this.f58375e = 0.0f;
        setLayerType(1, null);
        this.f58375e = getResources().getDimension(R.dimen.tbds32);
        Paint paint = new Paint();
        this.f58377g = paint;
        paint.setAntiAlias(true);
        this.f58377g.setColor(-7829368);
        this.f58377g.setStyle(Paint.Style.FILL);
        this.f58377g.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
    }
}
