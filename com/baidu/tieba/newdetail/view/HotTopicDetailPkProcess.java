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
import c.a.e.e.p.l;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
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
    public static int o;
    public static int p;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public int f54417e;

    /* renamed from: f  reason: collision with root package name */
    public int f54418f;

    /* renamed from: g  reason: collision with root package name */
    public Paint f54419g;

    /* renamed from: h  reason: collision with root package name */
    public int f54420h;

    /* renamed from: i  reason: collision with root package name */
    public int f54421i;

    /* renamed from: j  reason: collision with root package name */
    public float f54422j;
    public RectF k;
    public Path l;
    public int m;
    public ValueAnimator n;

    /* loaded from: classes7.dex */
    public class a implements ValueAnimator.AnimatorUpdateListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ HotTopicDetailPkProcess f54423e;

        public a(HotTopicDetailPkProcess hotTopicDetailPkProcess) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hotTopicDetailPkProcess};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f54423e = hotTopicDetailPkProcess;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, valueAnimator) == null) {
                this.f54423e.setProcess(((Float) valueAnimator.getAnimatedValue()).floatValue(), false);
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
        o = l.g(TbadkCoreApplication.getInst(), R.dimen.tbds22);
        p = l.g(TbadkCoreApplication.getInst(), R.dimen.tbds10);
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f54417e = 3;
        this.f54422j = 50.0f;
        this.k = new RectF();
        this.l = new Path();
        f();
    }

    public final void a(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048576, this, f2) == null) {
            ValueAnimator valueAnimator = this.n;
            if (valueAnimator != null) {
                valueAnimator.cancel();
            }
            ValueAnimator ofFloat = ValueAnimator.ofFloat(this.f54422j / 100.0f, f2);
            this.n = ofFloat;
            ofFloat.setDuration(300L);
            this.n.setInterpolator(new AccelerateDecelerateInterpolator());
            this.n.addUpdateListener(new a(this));
            this.n.start();
        }
    }

    public final void b(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, canvas) == null) {
            this.f54419g.setColor(this.f54420h);
            RectF rectF = this.k;
            int i2 = o;
            rectF.set(0.0f, 0.0f, i2, i2);
            canvas.drawArc(this.k, 90.0f, 180.0f, true, this.f54419g);
            RectF rectF2 = this.k;
            int i3 = o;
            rectF2.set(i3 / 2, 0.0f, this.m, i3);
            canvas.drawRect(this.k, this.f54419g);
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

    public final void d(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, canvas) == null) {
            this.f54419g.setColor(this.f54421i);
            RectF rectF = this.k;
            int i2 = this.f54418f;
            int i3 = o;
            rectF.set(i2 - i3, 0.0f, i2, i3);
            canvas.drawArc(this.k, -90.0f, 180.0f, true, this.f54419g);
            RectF rectF2 = this.k;
            int i4 = this.m;
            int i5 = o;
            rectF2.set(i4 + i5 + p, 0.0f, this.f54418f - (i5 / 2), i5);
            canvas.drawRect(this.k, this.f54419g);
        }
    }

    public final void e(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, canvas) == null) {
            this.f54419g.setColor(this.f54420h);
            this.l.reset();
            this.l.moveTo(this.m, o);
            this.l.lineTo(this.m + o, 0.0f);
            this.l.lineTo(this.m, 0.0f);
            this.l.close();
            canvas.drawPath(this.l, this.f54419g);
            this.f54419g.setColor(this.f54421i);
            this.l.reset();
            this.l.moveTo(this.m + p, o);
            Path path = this.l;
            int i2 = this.m + p;
            int i3 = o;
            path.lineTo(i2 + i3, i3);
            this.l.lineTo(this.m + p + o, 0.0f);
            this.l.close();
            canvas.drawPath(this.l, this.f54419g);
        }
    }

    public final void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            Paint paint = new Paint(1);
            this.f54419g = paint;
            paint.setStyle(Paint.Style.FILL_AND_STROKE);
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048582, this, i2) == null) || this.f54417e == i2) {
            return;
        }
        this.f54420h = SkinManager.getColor(R.color.CAM_X0308);
        this.f54421i = SkinManager.getColor(R.color.CAM_X0303);
        if (this.f54417e != 3) {
            invalidate();
        }
        this.f54417e = i2;
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, canvas) == null) {
            super.onDraw(canvas);
            if (this.f54418f <= 0) {
                return;
            }
            c(canvas);
        }
    }

    @Override // android.view.View
    public void onMeasure(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2, i3) == null) {
            setMeasuredDimension(View.getDefaultSize(getSuggestedMinimumWidth(), i2), o);
        }
    }

    @Override // android.view.View
    public void onSizeChanged(int i2, int i3, int i4, int i5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIII(1048585, this, i2, i3, i4, i5) == null) {
            super.onSizeChanged(i2, i3, i4, i5);
            this.f54418f = i2;
            int i6 = o;
            this.m = ((int) ((((i2 - i6) - (p + i6)) * this.f54422j) / 100.0f)) + (i6 / 2);
        }
    }

    public void setProcess(@FloatRange(from = 0.0d, to = 1.0d) float f2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048586, this, new Object[]{Float.valueOf(f2), Boolean.valueOf(z)}) == null) {
            if (f2 < 0.0f) {
                f2 = 0.0f;
            }
            if (f2 > 1.0f) {
                f2 = 1.0f;
            }
            if (!z) {
                float f3 = f2 * 100.0f;
                this.f54422j = f3;
                int i2 = this.f54418f;
                int i3 = o;
                this.m = ((int) ((((i2 - i3) - (p + i3)) * f3) / 100.0f)) + (i3 / 2);
                invalidate();
                return;
            }
            a(f2);
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.f54417e = 3;
        this.f54422j = 50.0f;
        this.k = new RectF();
        this.l = new Path();
        f();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HotTopicDetailPkProcess(Context context, @Nullable AttributeSet attributeSet, int i2) {
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
        this.f54417e = 3;
        this.f54422j = 50.0f;
        this.k = new RectF();
        this.l = new Path();
        f();
    }
}
