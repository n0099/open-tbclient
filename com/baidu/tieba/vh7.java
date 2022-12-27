package com.baidu.tieba;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.text.style.ReplacementSpan;
import androidx.annotation.DimenRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class vh7 extends ReplacementSpan {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;
    public int b;
    public int c;
    public int d;
    public float e;
    public final RectF f;
    public final int g;
    public final int h;
    public float i;
    public float j;

    public vh7(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i), Integer.valueOf(i2)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = UtilHelper.getDimenPixelSize(R.dimen.tbds10);
        this.b = UtilHelper.getDimenPixelSize(R.dimen.tbds10);
        this.c = UtilHelper.getDimenPixelSize(R.dimen.tbds10);
        this.d = UtilHelper.getDimenPixelSize(R.dimen.tbds10);
        this.e = UtilHelper.getDimenPixelSize(R.dimen.tbds10);
        this.f = new RectF();
        this.g = i;
        this.h = i2;
    }

    public void a(@DimenRes int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
            this.d = UtilHelper.getDimenPixelSize(i);
        }
    }

    public void b(@DimenRes int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) {
            int dimenPixelSize = UtilHelper.getDimenPixelSize(i);
            this.a = dimenPixelSize;
            this.c = dimenPixelSize;
        }
    }

    public void c(@DimenRes int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i) == null) {
            this.i = UtilHelper.getDimenPixelSize(i);
        }
    }

    public void d(@DimenRes int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i) == null) {
            this.b = UtilHelper.getDimenPixelSize(i);
        }
    }

    @Override // android.text.style.ReplacementSpan
    public void draw(@NonNull Canvas canvas, CharSequence charSequence, int i, int i2, float f, int i3, int i4, int i5, @NonNull Paint paint) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{canvas, charSequence, Integer.valueOf(i), Integer.valueOf(i2), Float.valueOf(f), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), paint}) == null) {
            int color = paint.getColor();
            paint.setColor(this.g);
            this.f.set(f, i3 + this.b, ((int) (paint.measureText(charSequence, i, i2) + 0.5f)) + this.a + this.c + f, i5 - this.d);
            RectF rectF = this.f;
            float f2 = this.e;
            canvas.drawRoundRect(rectF, f2, f2, paint);
            paint.setColor(this.h);
            canvas.drawText(charSequence, i, i2, this.a + f, i4, paint);
            paint.setColor(color);
            paint.setTextSize(this.j);
        }
    }

    @Override // android.text.style.ReplacementSpan
    public int getSize(@NonNull Paint paint, CharSequence charSequence, int i, int i2, @Nullable Paint.FontMetricsInt fontMetricsInt) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048581, this, new Object[]{paint, charSequence, Integer.valueOf(i), Integer.valueOf(i2), fontMetricsInt})) == null) {
            this.j = paint.getTextSize();
            paint.setTextSize(this.i);
            return ((int) (paint.measureText(charSequence, i, i2) + 0.5f)) + this.a + this.c;
        }
        return invokeCommon.intValue;
    }
}
