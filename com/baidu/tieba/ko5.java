package com.baidu.tieba;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.text.style.ReplacementSpan;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class ko5 extends ReplacementSpan {
    public static /* synthetic */ Interceptable $ic;
    public static final int j;
    public static final int k;
    public static final int l;
    public static final int m;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;
    public int b;
    public int c;
    public int d;
    public int e;
    public int f;
    public int g;
    public int h;
    public int i;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947919832, "Lcom/baidu/tieba/ko5;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947919832, "Lcom/baidu/tieba/ko5;");
                return;
            }
        }
        j = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds5);
        k = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds11);
        l = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds12);
        m = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds44);
    }

    public ko5(jo5 jo5Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {jo5Var};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = TbadkCoreApplication.getInst().getResources().getColor(R.color.white_alpha100);
        this.b = R.color.CAM_X0305;
        this.c = j;
        this.d = k;
        this.e = m;
        this.f = 0;
        this.g = l;
        this.h = 0;
        if (jo5Var != null) {
            this.a = jo5Var.a;
            this.b = jo5Var.b;
            this.c = jo5Var.c;
            this.e = jo5Var.d;
            this.d = jo5Var.e;
            this.f = jo5Var.f;
            this.g = jo5Var.g;
            this.h = jo5Var.h;
        }
    }

    @Override // android.text.style.ReplacementSpan
    public void draw(Canvas canvas, CharSequence charSequence, int i, int i2, float f, int i3, int i4, int i5, Paint paint) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{canvas, charSequence, Integer.valueOf(i), Integer.valueOf(i2), Float.valueOf(f), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), paint}) == null) {
            canvas.save();
            canvas.translate(0.0f, this.h);
            paint.setColor(SkinManager.getColor(this.b));
            paint.setAntiAlias(true);
            float descent = this.e - (paint.descent() - paint.ascent());
            float f2 = i4;
            RectF rectF = new RectF(this.f + f, (paint.ascent() + f2) - descent, this.f + f + this.i + (this.d * 2), paint.descent() + f2);
            int i6 = this.c;
            canvas.drawRoundRect(rectF, i6, i6, paint);
            paint.setColor(this.a);
            canvas.drawText(charSequence, i, i2, this.d + f + this.f, f2 - (descent / 2.0f), paint);
            canvas.restore();
        }
    }

    @Override // android.text.style.ReplacementSpan
    public int getSize(Paint paint, CharSequence charSequence, int i, int i2, Paint.FontMetricsInt fontMetricsInt) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{paint, charSequence, Integer.valueOf(i), Integer.valueOf(i2), fontMetricsInt})) == null) {
            int measureText = (int) paint.measureText(charSequence, i, i2);
            this.i = measureText;
            return measureText + (this.d * 2) + this.f + this.g;
        }
        return invokeCommon.intValue;
    }
}
