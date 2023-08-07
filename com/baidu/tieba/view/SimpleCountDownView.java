package com.baidu.tieba.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.os.CountDownTimer;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.View;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tieba.R;
import com.baidu.tieba.yda;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.gson.internal.bind.TypeAdapters;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
@Metadata(d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0013\u0018\u00002\u00020\u0001:\u0001AB\u001b\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u001a\u0010+\u001a\u00020,2\u0006\u0010-\u001a\u00020)2\b\u0010.\u001a\u0004\u0018\u00010/H\u0002J\u001a\u00100\u001a\u00020,2\b\u0010.\u001a\u0004\u0018\u00010/2\u0006\u00101\u001a\u00020\u0012H\u0002J\u001a\u00102\u001a\u00020\u000b2\u0006\u00103\u001a\u00020)2\b\u0010.\u001a\u0004\u0018\u00010/H\u0002J\b\u00104\u001a\u00020,H\u0002J\u0006\u00105\u001a\u00020,J\u0012\u00106\u001a\u00020,2\b\u0010.\u001a\u0004\u0018\u00010/H\u0014J\u0018\u00107\u001a\u00020,2\u0006\u00108\u001a\u00020\u00122\u0006\u00109\u001a\u00020\u0012H\u0014J(\u0010:\u001a\u00020,2\u0006\u0010;\u001a\u00020\b2\u0006\u0010<\u001a\u00020\b2\u0006\u0010=\u001a\u00020\b2\u0006\u0010>\u001a\u00020\bH\u0002J\u001a\u0010?\u001a\u00020,2\u0006\u0010@\u001a\u00020\b2\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u001aR\u000e\u0010\u0007\u001a\u00020\bX\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bX\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\bX\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\bX\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\bX\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u001eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010 \u001a\u0004\u0018\u00010!X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\"\u001a\b\u0012\u0004\u0012\u00020\b0#X\u0082\u0004¢\u0006\u0004\n\u0002\u0010$R\u000e\u0010%\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020\u001eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010(\u001a\b\u0012\u0004\u0012\u00020)0#X\u0082\u0004¢\u0006\u0004\n\u0002\u0010*¨\u0006B"}, d2 = {"Lcom/baidu/tieba/view/SimpleCountDownView;", "Landroid/view/View;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "dayInMillis", "", "hourInMills", "margining", "", "millsCountDown", "minuteInMills", "radius", "rect", "Landroid/graphics/RectF;", "rectColor", "", "rectHeight", "rectPaint", "Landroid/graphics/Paint;", "rectWidth", "secInMills", "timeColor", "timeFinishListener", "Lcom/baidu/tieba/view/SimpleCountDownView$OnTimeFinishListener;", "timeHeight", "timeOffsetY", "timePaint", "Landroid/text/TextPaint;", "timeSize", "timer", "Landroid/os/CountDownTimer;", "times", "", "[Ljava/lang/Long;", "unitColor", "unitPaint", "unitSize", "units", "", "[Ljava/lang/String;", "drawTimeInRect", "", "time", "canvas", "Landroid/graphics/Canvas;", "drawTimeUnit", "index", "drawUnit", "unit", "initPaints", "onChangeSkin", "onDraw", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "setTime", "day", "hour", TypeAdapters.AnonymousClass27.MINUTE, TypeAdapters.AnonymousClass27.SECOND, "start", "endTime", "OnTimeFinishListener", "tbadkcore_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes8.dex */
public final class SimpleCountDownView extends View {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final int a;
    public final long b;
    public final long c;
    public final long d;
    public final long e;
    public final long f;
    public final RectF g;
    public final Paint h;
    public final TextPaint i;
    public final TextPaint j;
    public float k;
    public float l;
    public float m;
    public float n;
    public float o;
    public int p;
    public int q;
    public int r;
    public float s;
    public float t;
    public final Long[] u;
    public final String[] v;
    public CountDownTimer w;

    /* loaded from: classes8.dex */
    public interface a {
        void onFinish();
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public SimpleCountDownView(Context context) {
        this(context, null, 2, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue(), (DefaultConstructorMarker) objArr2[3]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* loaded from: classes8.dex */
    public static final class b extends CountDownTimer {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SimpleCountDownView a;
        public final /* synthetic */ a b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(long j, SimpleCountDownView simpleCountDownView, a aVar, long j2) {
            super(j, j2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Long.valueOf(j), simpleCountDownView, aVar, Long.valueOf(j2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super(((Long) objArr2[0]).longValue(), ((Long) objArr2[1]).longValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = simpleCountDownView;
            this.b = aVar;
        }

        @Override // android.os.CountDownTimer
        public void onFinish() {
            a aVar;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && (aVar = this.b) != null) {
                aVar.onFinish();
            }
        }

        @Override // android.os.CountDownTimer
        public void onTick(long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j) == null) {
                this.a.k(j / this.a.c, (j % this.a.c) / this.a.d, ((j % this.a.c) % this.a.d) / this.a.e, (((j % this.a.c) % this.a.d) % this.a.e) / this.a.f);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public SimpleCountDownView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        Intrinsics.checkNotNullParameter(context, "context");
        this.a = UtilHelper.getDimenPixelSize(R.dimen.tbds2);
        this.b = 1000L;
        this.c = 86400000L;
        this.d = 3600000L;
        this.e = 60000L;
        this.f = 1000L;
        this.g = new RectF();
        this.h = new Paint(1);
        this.i = new TextPaint(1);
        this.j = new TextPaint(1);
        this.k = this.i.descent() + this.i.ascent();
        this.l = BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds31);
        this.m = BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds39);
        this.n = BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds5);
        this.o = BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), R.dimen.M_W_X001);
        this.p = R.color.CAM_X0101;
        this.q = R.color.CAM_X0101;
        this.r = R.color.CAM_X0602;
        this.s = BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), R.dimen.T_X12);
        this.t = BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), R.dimen.T_X10);
        this.u = new Long[]{0L, 0L, 0L, 0L};
        this.v = new String[]{"天", "时", "分", "秒"};
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, yda.SimpleCountDownView);
        this.p = obtainStyledAttributes.getResourceId(1, this.p);
        this.q = obtainStyledAttributes.getResourceId(7, this.q);
        this.r = obtainStyledAttributes.getResourceId(2, this.r);
        this.o = obtainStyledAttributes.getDimension(0, this.o);
        this.s = obtainStyledAttributes.getDimension(6, this.s);
        this.t = obtainStyledAttributes.getDimension(8, this.t);
        this.l = obtainStyledAttributes.getDimension(5, this.l);
        this.m = obtainStyledAttributes.getDimension(3, this.m);
        this.n = obtainStyledAttributes.getDimension(4, this.n);
        obtainStyledAttributes.recycle();
        RectF rectF = this.g;
        rectF.left = 0.0f;
        rectF.top = 0.0f;
        rectF.right = this.l;
        rectF.bottom = this.m;
        i();
        this.k = this.i.descent() + this.i.ascent();
    }

    public /* synthetic */ SimpleCountDownView(Context context, AttributeSet attributeSet, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i & 2) != 0 ? null : attributeSet);
    }

    public final void f(String str, Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, str, canvas) == null) {
            float measureText = this.i.measureText(str);
            if (canvas != null) {
                float width = this.g.width() - measureText;
                float f = 2;
                canvas.drawText(str, width / f, (this.g.height() - this.k) / f, this.i);
            }
        }
    }

    public final float h(String str, Canvas canvas) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, canvas)) == null) {
            if (canvas != null) {
                canvas.drawText(str, 0.0f, ((this.g.height() - this.k) / 2) - this.a, this.j);
            }
            return this.j.measureText(str);
        }
        return invokeLL.floatValue;
    }

    public final void l(long j, a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJL(1048582, this, j, aVar) == null) {
            CountDownTimer countDownTimer = this.w;
            if (countDownTimer != null) {
                countDownTimer.cancel();
            }
            b bVar = new b(j - System.currentTimeMillis(), this, aVar, this.b);
            this.w = bVar;
            if (bVar != null) {
                bVar.start();
            }
        }
    }

    public final void g(Canvas canvas, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, canvas, i) == null) {
            if (canvas != null) {
                RectF rectF = this.g;
                float f = this.n;
                canvas.drawRoundRect(rectF, f, f, this.h);
            }
            long j = 10;
            f(String.valueOf(this.u[i].longValue() / j), canvas);
            if (canvas != null) {
                canvas.translate(this.l + this.o, 0.0f);
            }
            if (canvas != null) {
                RectF rectF2 = this.g;
                float f2 = this.n;
                canvas.drawRoundRect(rectF2, f2, f2, this.h);
            }
            f(String.valueOf(this.u[i].longValue() % j), canvas);
            if (canvas != null) {
                canvas.translate(this.l + this.o, 0.0f);
            }
            float h = h(this.v[i], canvas);
            if (canvas != null) {
                canvas.translate(h + this.o, 0.0f);
            }
        }
    }

    public final void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.h.setColor(SkinManager.getColor(this.r));
            TextPaint textPaint = this.i;
            textPaint.setColor(SkinManager.getColor(this.p));
            textPaint.setTypeface(Typeface.DEFAULT_BOLD);
            textPaint.setTextSize(this.s);
            TextPaint textPaint2 = this.j;
            textPaint2.setColor(SkinManager.getColor(this.q));
            textPaint2.setTextSize(this.t);
        }
    }

    public final void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            i();
            invalidate();
        }
    }

    public final void k(long j, long j2, long j3, long j4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{Long.valueOf(j), Long.valueOf(j2), Long.valueOf(j3), Long.valueOf(j4)}) == null) {
            this.u[0] = Long.valueOf(j);
            this.u[1] = Long.valueOf(j2);
            this.u[2] = Long.valueOf(j3);
            this.u[3] = Long.valueOf(j4);
            invalidate();
        }
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, canvas) == null) {
            Long[] lArr = this.u;
            if (lArr.length != this.v.length) {
                if (!TbadkCoreApplication.getInst().isDebugMode()) {
                    return;
                }
                throw new IllegalArgumentException("time size is not equals to unit size");
            }
            int length = lArr.length;
            for (int i = 0; i < length; i++) {
                g(canvas, i);
            }
        }
    }

    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(InputDeviceCompat.SOURCE_TOUCHPAD, this, i, i2) == null) {
            super.onMeasure(i, i2);
            float width = (this.g.width() * 8) + (this.o * 11);
            int length = this.v.length;
            for (int i3 = 0; i3 < length; i3++) {
                width += this.j.measureText(this.v[i3]);
            }
            setMeasuredDimension((int) width, (int) this.g.height());
        }
    }
}
