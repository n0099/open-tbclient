package com.baidu.tieba.view.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import c.a.q0.a4.l.a;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes7.dex */
public class RecordCircleProgressBar extends View implements c.a.q0.a4.l.a, Runnable {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public a.InterfaceC0746a A;
    public float B;
    public int C;
    public Runnable D;

    /* renamed from: e  reason: collision with root package name */
    public int f58329e;

    /* renamed from: f  reason: collision with root package name */
    public int f58330f;

    /* renamed from: g  reason: collision with root package name */
    public int f58331g;

    /* renamed from: h  reason: collision with root package name */
    public int f58332h;

    /* renamed from: i  reason: collision with root package name */
    public int f58333i;

    /* renamed from: j  reason: collision with root package name */
    public int f58334j;
    public int k;
    public int l;
    public int m;
    public int n;
    public int o;
    public Paint p;
    public Paint q;
    public Paint r;
    public List<Float> s;
    public long t;
    public int u;
    public int v;
    public boolean w;
    public int x;
    public boolean y;
    public boolean z;

    /* loaded from: classes7.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ RecordCircleProgressBar f58335e;

        public a(RecordCircleProgressBar recordCircleProgressBar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {recordCircleProgressBar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f58335e = recordCircleProgressBar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                RecordCircleProgressBar recordCircleProgressBar = this.f58335e;
                int i2 = recordCircleProgressBar.x;
                if (i2 <= 0) {
                    recordCircleProgressBar.y = true;
                } else if (i2 >= 255) {
                    recordCircleProgressBar.y = false;
                }
                RecordCircleProgressBar recordCircleProgressBar2 = this.f58335e;
                if (recordCircleProgressBar2.y) {
                    recordCircleProgressBar2.x += 50;
                } else {
                    recordCircleProgressBar2.x -= 50;
                }
                this.f58335e.invalidate();
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public RecordCircleProgressBar(Context context) {
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

    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            postDelayed(this.D, 100L);
            int i2 = this.x;
            if (i2 <= 0) {
                this.p.setAlpha(0);
            } else if (i2 >= 255) {
                this.p.setAlpha(255);
            } else {
                this.p.setAlpha(i2);
            }
        }
    }

    public final void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            a.InterfaceC0746a interfaceC0746a = this.A;
            postDelayed(this, (interfaceC0746a == null || !(interfaceC0746a.a() == 0.5f || this.A.a() == 0.33333334f)) ? 50L : 25L);
        }
    }

    @Override // c.a.q0.a4.l.a
    public void deleteLast() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.w = false;
            if (this.s.size() > 0) {
                List<Float> list = this.s;
                list.remove(list.size() - 1);
                this.B = getProgress();
                invalidate();
            }
            a.InterfaceC0746a interfaceC0746a = this.A;
            if (interfaceC0746a != null) {
                interfaceC0746a.b(this.B);
            }
        }
    }

    @Override // c.a.q0.a4.l.a
    public int getMaxDuration() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.v : invokeV.intValue;
    }

    @Override // c.a.q0.a4.l.a
    public float getProgress() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            float f2 = 0.0f;
            for (Float f3 : this.s) {
                f2 += f3.floatValue();
            }
            return f2;
        }
        return invokeV.floatValue;
    }

    @Override // c.a.q0.a4.l.a
    public int getSlideNum() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.s.size() : invokeV.intValue;
    }

    @Override // c.a.q0.a4.l.a
    public boolean isShowingDeleteLastTip() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.w : invokeV.booleanValue;
    }

    @Override // android.view.View
    public void onDetachedFromWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            super.onDetachedFromWindow();
            stop();
        }
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        float f2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, canvas) == null) {
            super.onDraw(canvas);
            if (this.v <= 0) {
                return;
            }
            RectF rectF = new RectF(getPaddingLeft() + this.C, getPaddingTop() + this.C, (getPaddingLeft() + this.f58331g) - this.C, (getPaddingTop() + this.f58331g) - this.C);
            this.r.setStyle(Paint.Style.FILL_AND_STROKE);
            canvas.drawOval(rectF, this.r);
            this.r.setStyle(Paint.Style.STROKE);
            float f3 = 360.0f / this.v;
            float f4 = (float) ((this.f58332h * 360) / ((this.f58331g + this.C) * 3.141592653589793d));
            if (!this.z) {
                int i2 = 1;
                while (true) {
                    if (i2 >= this.v) {
                        break;
                    } else if (i2 == this.u) {
                        this.r.setColor(this.m);
                        canvas.drawArc(rectF, (i2 * f3) - 90.0f, f4, false, this.r);
                        this.r.setColor(this.o);
                        break;
                    } else {
                        i2++;
                    }
                }
            }
            float f5 = 0.0f;
            for (int i3 = 0; i3 < this.s.size(); i3++) {
                if (this.w && i3 == this.s.size() - 1) {
                    this.p.setColor(this.l);
                    a();
                } else {
                    this.p.setColor(this.k);
                }
                canvas.drawArc(rectF, (f5 * f3) - 90.0f, this.s.get(i3).floatValue() * f3, false, this.p);
                f5 += this.s.get(i3).floatValue();
                float f6 = (float) ((this.f58333i * 360) / ((this.f58331g + this.C) * 3.141592653589793d));
                if (i3 != 0 || getProgress() < 0.2f) {
                    f2 = f6;
                } else {
                    f2 = f6;
                    canvas.drawArc(rectF, ((f5 * f3) - f6) - 90.0f, f6, false, this.p);
                }
                if (i3 < this.s.size() - 1 || this.t == 0) {
                    canvas.drawArc(rectF, ((f5 * f3) - f2) - 90.0f, f2, false, this.q);
                }
            }
        }
    }

    @Override // android.view.View
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048585, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5)}) == null) {
            super.onLayout(z, i2, i3, i4, i5);
            this.f58329e = ((i4 - i2) - getPaddingRight()) - getPaddingLeft();
            int paddingTop = ((i5 - i3) - getPaddingTop()) - getPaddingBottom();
            this.f58330f = paddingTop;
            this.f58331g = Math.min(this.f58329e, paddingTop);
        }
    }

    @Override // c.a.q0.a4.l.a
    public void reset() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            this.t = 0L;
            removeCallbacks(this);
            this.s.clear();
            this.w = false;
            this.B = getProgress();
            invalidate();
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048587, this) == null) || this.t == 0 || this.s.size() == 0) {
            return;
        }
        a.InterfaceC0746a interfaceC0746a = this.A;
        if (interfaceC0746a != null) {
            interfaceC0746a.onProgress(this.B);
        }
        if (this.B >= this.v) {
            a.InterfaceC0746a interfaceC0746a2 = this.A;
            if (interfaceC0746a2 != null) {
                interfaceC0746a2.onFinish();
                return;
            }
            return;
        }
        b();
    }

    public void setIsAbandonMin(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048588, this, z) == null) {
            this.z = z;
        }
    }

    @Override // c.a.q0.a4.l.a
    public void setMaxDuration(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048589, this, i2) == null) {
            this.v = i2;
        }
    }

    @Override // c.a.q0.a4.l.a
    public void setMinDuration(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048590, this, i2) == null) {
            this.u = i2;
        }
    }

    @Override // c.a.q0.a4.l.a
    public void setOnProgressListener(a.InterfaceC0746a interfaceC0746a) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, interfaceC0746a) == null) {
            this.A = interfaceC0746a;
        }
    }

    public void setProgress(List<Float> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, list) == null) {
            this.s = list;
            invalidate();
        }
    }

    @Override // c.a.q0.a4.l.a
    public void setShowDeleteLastTip(boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048594, this, z) == null) || this.w == z) {
            return;
        }
        this.w = z;
        invalidate();
    }

    @Override // c.a.q0.a4.l.a
    public void start() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            this.t = System.currentTimeMillis();
            this.s.add(Float.valueOf(0.0f));
            b();
        }
    }

    @Override // c.a.q0.a4.l.a
    public void stop() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
            this.t = 0L;
            removeCallbacks(this);
            removeCallbacks(this.D);
            invalidate();
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public RecordCircleProgressBar(Context context, @Nullable AttributeSet attributeSet) {
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
    public RecordCircleProgressBar(Context context, @Nullable AttributeSet attributeSet, int i2) {
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
        this.s = new ArrayList();
        this.x = 255;
        this.y = false;
        this.B = 0.0f;
        this.D = new a(this);
        this.k = getContext().getResources().getColor(R.color.CAM_X0302);
        this.l = getContext().getResources().getColor(R.color.CAM_X0301);
        this.n = getContext().getResources().getColor(R.color.CAM_X0313);
        this.o = getContext().getResources().getColor(R.color.CAM_X0619);
        this.m = getContext().getResources().getColor(R.color.CAM_X0302);
        this.f58332h = UtilHelper.getDimenPixelSize(R.dimen.tbds6);
        this.f58333i = UtilHelper.getDimenPixelSize(R.dimen.tbds6);
        int dimenPixelSize = UtilHelper.getDimenPixelSize(R.dimen.tbds16);
        this.f58334j = dimenPixelSize;
        this.C = dimenPixelSize / 2;
        Paint paint = new Paint();
        this.r = paint;
        paint.setAntiAlias(true);
        this.r.setStrokeWidth(this.f58334j);
        this.r.setStyle(Paint.Style.STROKE);
        this.r.setColor(this.o);
        Paint paint2 = new Paint();
        this.p = paint2;
        paint2.setAntiAlias(true);
        this.p.setStrokeWidth(this.f58334j);
        this.p.setStyle(Paint.Style.STROKE);
        Paint paint3 = new Paint();
        this.q = paint3;
        paint3.setAntiAlias(true);
        this.q.setStrokeWidth(this.f58334j);
        this.q.setStyle(Paint.Style.STROKE);
        this.q.setColor(this.n);
    }

    @Override // c.a.q0.a4.l.a
    public void setProgress(long j2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeJ(1048592, this, j2) == null) || this.s.size() <= 0) {
            return;
        }
        List<Float> list = this.s;
        list.set(list.size() - 1, Float.valueOf(((float) j2) / 1000.0f));
        this.B = getProgress();
        postInvalidate();
    }
}
