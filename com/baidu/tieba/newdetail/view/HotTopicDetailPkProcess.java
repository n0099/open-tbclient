package com.baidu.tieba.newdetail.view;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import androidx.annotation.FloatRange;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
import com.baidu.tieba.yi;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class HotTopicDetailPkProcess extends View {
    public static /* synthetic */ Interceptable $ic;
    public static int k;
    public static int l;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;
    public int b;
    public Paint c;
    public int d;
    public int e;
    public float f;
    public RectF g;
    public Path h;
    public int i;
    public ValueAnimator j;

    /* loaded from: classes7.dex */
    public class a implements ValueAnimator.AnimatorUpdateListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ HotTopicDetailPkProcess a;

        public a(HotTopicDetailPkProcess hotTopicDetailPkProcess) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hotTopicDetailPkProcess};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = hotTopicDetailPkProcess;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, valueAnimator) == null) {
                this.a.setProcess(((Float) valueAnimator.getAnimatedValue()).floatValue(), false);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(2057526808, "Lcom/baidu/tieba/newdetail/view/HotTopicDetailPkProcess;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(2057526808, "Lcom/baidu/tieba/newdetail/view/HotTopicDetailPkProcess;");
                return;
            }
        }
        k = yi.g(TbadkCoreApplication.getInst(), R.dimen.tbds22);
        l = yi.g(TbadkCoreApplication.getInst(), R.dimen.tbds10);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HotTopicDetailPkProcess(Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = 3;
        this.f = 50.0f;
        this.g = new RectF();
        this.h = new Path();
        f();
    }

    public final void a(float f) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048576, this, f) == null) {
            ValueAnimator valueAnimator = this.j;
            if (valueAnimator != null) {
                valueAnimator.cancel();
            }
            ValueAnimator ofFloat = ValueAnimator.ofFloat(this.f / 100.0f, f);
            this.j = ofFloat;
            ofFloat.setDuration(300L);
            this.j.setInterpolator(new AccelerateDecelerateInterpolator());
            this.j.addUpdateListener(new a(this));
            this.j.start();
        }
    }

    public final void d(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, canvas) == null) {
            this.c.setColor(this.e);
            RectF rectF = this.g;
            int i = this.b;
            int i2 = k;
            rectF.set(i - i2, 0.0f, i, i2);
            canvas.drawArc(this.g, -90.0f, 180.0f, true, this.c);
            RectF rectF2 = this.g;
            int i3 = this.i;
            int i4 = k;
            rectF2.set(i3 + i4 + l, 0.0f, this.b - (i4 / 2), i4);
            canvas.drawRect(this.g, this.c);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HotTopicDetailPkProcess(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
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
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.a = 3;
        this.f = 50.0f;
        this.g = new RectF();
        this.h = new Path();
        f();
    }

    public void setProcess(@FloatRange(from = 0.0d, to = 1.0d) float f, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048586, this, new Object[]{Float.valueOf(f), Boolean.valueOf(z)}) == null) {
            if (f < 0.0f) {
                f = 0.0f;
            }
            if (f > 1.0f) {
                f = 1.0f;
            }
            if (!z) {
                float f2 = f * 100.0f;
                this.f = f2;
                int i = this.b;
                int i2 = k;
                this.i = ((int) ((((i - i2) - (l + i2)) * f2) / 100.0f)) + (i2 / 2);
                invalidate();
                return;
            }
            a(f);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HotTopicDetailPkProcess(Context context, @Nullable AttributeSet attributeSet, int i) {
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
        this.a = 3;
        this.f = 50.0f;
        this.g = new RectF();
        this.h = new Path();
        f();
    }

    public final void b(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, canvas) == null) {
            this.c.setColor(this.d);
            RectF rectF = this.g;
            int i = k;
            rectF.set(0.0f, 0.0f, i, i);
            canvas.drawArc(this.g, 90.0f, 180.0f, true, this.c);
            RectF rectF2 = this.g;
            int i2 = k;
            rectF2.set(i2 / 2, 0.0f, this.i, i2);
            canvas.drawRect(this.g, this.c);
        }
    }

    public final void c(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, canvas) == null) {
            b(canvas);
            d(canvas);
            e(canvas);
        }
    }

    public void g(int i) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048582, this, i) == null) && this.a != i) {
            this.d = SkinManager.getColor(R.color.CAM_X0308);
            this.e = SkinManager.getColor(R.color.CAM_X0303);
            if (this.a != 3) {
                invalidate();
            }
            this.a = i;
        }
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, canvas) == null) {
            super.onDraw(canvas);
            if (this.b <= 0) {
                return;
            }
            c(canvas);
        }
    }

    public final void e(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, canvas) == null) {
            this.c.setColor(this.d);
            this.h.reset();
            this.h.moveTo(this.i, k);
            this.h.lineTo(this.i + k, 0.0f);
            this.h.lineTo(this.i, 0.0f);
            this.h.close();
            canvas.drawPath(this.h, this.c);
            this.c.setColor(this.e);
            this.h.reset();
            this.h.moveTo(this.i + l, k);
            Path path = this.h;
            int i = this.i + l;
            int i2 = k;
            path.lineTo(i + i2, i2);
            this.h.lineTo(this.i + l + k, 0.0f);
            this.h.close();
            canvas.drawPath(this.h, this.c);
        }
    }

    public final void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            Paint paint = new Paint(1);
            this.c = paint;
            paint.setStyle(Paint.Style.FILL_AND_STROKE);
            g(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(InputDeviceCompat.SOURCE_TOUCHPAD, this, i, i2) == null) {
            setMeasuredDimension(View.getDefaultSize(getSuggestedMinimumWidth(), i), k);
        }
    }

    @Override // android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIII(1048585, this, i, i2, i3, i4) == null) {
            super.onSizeChanged(i, i2, i3, i4);
            this.b = i;
            int i5 = k;
            this.i = ((int) ((((i - i5) - (l + i5)) * this.f) / 100.0f)) + (i5 / 2);
        }
    }
}
