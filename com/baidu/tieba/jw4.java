package com.baidu.tieba;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.text.style.ReplacementSpan;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class jw4 extends ReplacementSpan {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;
    public RectF b;
    public final int c;
    public final int d;
    public final int e;
    public final int f;
    public final int g;
    public final int h;
    public final int i;
    public final float j;
    public final int k;

    /* loaded from: classes4.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes4.dex */
    public static final class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int a;
        public int b;
        public int c;
        public int d;
        public int e;
        public int f;
        public int g;
        public float h;
        public int i;

        public b() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = R.dimen.T_X10;
            this.b = SkinManager.getColor(R.color.CAM_X0101);
            this.e = SkinManager.getColor(R.color.CAM_X0302);
        }

        public jw4 j() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? new jw4(this, null) : (jw4) invokeV.objValue;
        }

        public b k(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i)) == null) {
                this.e = i;
                return this;
            }
            return (b) invokeI.objValue;
        }

        public b l(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i)) == null) {
                this.i = i;
                return this;
            }
            return (b) invokeI.objValue;
        }

        public b m(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i)) == null) {
                this.c = i;
                return this;
            }
            return (b) invokeI.objValue;
        }

        public b n(float f) {
            InterceptResult invokeF;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeF = interceptable.invokeF(1048580, this, f)) == null) {
                this.h = f;
                return this;
            }
            return (b) invokeF.objValue;
        }

        public b o(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048581, this, i)) == null) {
                this.f = i;
                return this;
            }
            return (b) invokeI.objValue;
        }

        public b p(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048582, this, i)) == null) {
                this.d = i;
                return this;
            }
            return (b) invokeI.objValue;
        }

        public b q(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048583, this, i)) == null) {
                this.a = i;
                return this;
            }
            return (b) invokeI.objValue;
        }

        public b r(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i)) == null) {
                this.b = i;
                return this;
            }
            return (b) invokeI.objValue;
        }
    }

    public /* synthetic */ jw4(b bVar, a aVar) {
        this(bVar);
    }

    public final void a(Canvas canvas, CharSequence charSequence, int i, int i2, float f, float f2, Paint paint) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{canvas, charSequence, Integer.valueOf(i), Integer.valueOf(i2), Float.valueOf(f), Float.valueOf(f2), paint}) == null) {
            paint.setColor(this.g);
            paint.setAntiAlias(true);
            paint.setStyle(Paint.Style.FILL);
            Paint.FontMetricsInt fontMetricsInt = paint.getFontMetricsInt();
            if (ps4.b(charSequence.subSequence(i, i2))) {
                ps4.a(fontMetricsInt, (int) paint.getTextSize());
            }
            RectF rectF = new RectF(f, fontMetricsInt.ascent + f2, ((this.a + f) - this.h) - this.i, (f2 + fontMetricsInt.descent) - this.k);
            this.b = rectF;
            float f3 = this.j;
            canvas.drawRoundRect(rectF, f3, f3, paint);
        }
    }

    public final void b(Canvas canvas, CharSequence charSequence, int i, int i2, float f, float f2, Paint paint) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{canvas, charSequence, Integer.valueOf(i), Integer.valueOf(i2), Float.valueOf(f), Float.valueOf(f2), paint}) == null) {
            paint.setColor(this.d);
            paint.setTextSize(ri.f(TbadkApplication.getInst(), this.c));
            Paint.FontMetrics fontMetrics = paint.getFontMetrics();
            float centerY = this.b.centerY();
            float f3 = fontMetrics.descent;
            canvas.drawText(charSequence.subSequence(i, i2).toString(), f + this.e, (centerY + ((f3 - fontMetrics.ascent) / 2.0f)) - f3, paint);
        }
    }

    @Override // android.text.style.ReplacementSpan
    public void draw(@NonNull Canvas canvas, CharSequence charSequence, int i, int i2, float f, int i3, int i4, int i5, @NonNull Paint paint) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{canvas, charSequence, Integer.valueOf(i), Integer.valueOf(i2), Float.valueOf(f), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), paint}) == null) {
            float f2 = i4;
            a(canvas, charSequence, i, i2, f, f2, paint);
            b(canvas, charSequence, i, i2, f, f2, paint);
        }
    }

    @Override // android.text.style.ReplacementSpan
    public int getSize(@NonNull Paint paint, CharSequence charSequence, int i, int i2, @Nullable Paint.FontMetricsInt fontMetricsInt) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{paint, charSequence, Integer.valueOf(i), Integer.valueOf(i2), fontMetricsInt})) == null) {
            float textSize = paint.getTextSize();
            paint.setTextSize(ri.f(TbadkApplication.getInst(), this.c));
            this.a = ((int) paint.measureText(charSequence, i, i2)) + this.e + this.f + this.h + this.i;
            paint.setTextSize(textSize);
            return this.a;
        }
        return invokeCommon.intValue;
    }

    public jw4(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.c = bVar.a;
        this.d = bVar.b;
        this.g = bVar.e;
        this.e = bVar.c;
        this.f = bVar.d;
        this.i = bVar.g;
        this.h = bVar.f;
        this.j = bVar.h;
        this.k = bVar.i;
    }
}
