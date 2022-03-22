package com.baidu.tieba.view.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import c.a.p0.q4.n.a;
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
/* loaded from: classes6.dex */
public class RecordCircleProgressBar extends View implements c.a.p0.q4.n.a, Runnable {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;

    /* renamed from: b  reason: collision with root package name */
    public int f37097b;

    /* renamed from: c  reason: collision with root package name */
    public int f37098c;

    /* renamed from: d  reason: collision with root package name */
    public int f37099d;

    /* renamed from: e  reason: collision with root package name */
    public int f37100e;

    /* renamed from: f  reason: collision with root package name */
    public int f37101f;

    /* renamed from: g  reason: collision with root package name */
    public int f37102g;

    /* renamed from: h  reason: collision with root package name */
    public int f37103h;
    public int i;
    public int j;
    public int k;
    public Paint l;
    public Paint m;
    public Paint n;
    public List<Float> o;
    public long p;
    public int q;
    public int r;
    public boolean s;
    public int t;
    public boolean u;
    public boolean v;
    public a.InterfaceC1343a w;
    public float x;
    public int y;
    public Runnable z;

    /* loaded from: classes6.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ RecordCircleProgressBar a;

        public a(RecordCircleProgressBar recordCircleProgressBar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {recordCircleProgressBar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = recordCircleProgressBar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                RecordCircleProgressBar recordCircleProgressBar = this.a;
                int i = recordCircleProgressBar.t;
                if (i <= 0) {
                    recordCircleProgressBar.u = true;
                } else if (i >= 255) {
                    recordCircleProgressBar.u = false;
                }
                RecordCircleProgressBar recordCircleProgressBar2 = this.a;
                if (recordCircleProgressBar2.u) {
                    recordCircleProgressBar2.t += 50;
                } else {
                    recordCircleProgressBar2.t -= 50;
                }
                this.a.invalidate();
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    @Override // c.a.p0.q4.n.a
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.s = false;
            if (this.o.size() > 0) {
                List<Float> list = this.o;
                list.remove(list.size() - 1);
                this.x = getProgress();
                invalidate();
            }
            a.InterfaceC1343a interfaceC1343a = this.w;
            if (interfaceC1343a != null) {
                interfaceC1343a.b(this.x);
            }
        }
    }

    @Override // c.a.p0.q4.n.a
    public boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.s : invokeV.booleanValue;
    }

    public final void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            postDelayed(this.z, 100L);
            int i = this.t;
            if (i <= 0) {
                this.l.setAlpha(0);
            } else if (i >= 255) {
                this.l.setAlpha(255);
            } else {
                this.l.setAlpha(i);
            }
        }
    }

    public final void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            a.InterfaceC1343a interfaceC1343a = this.w;
            postDelayed(this, (interfaceC1343a == null || !(interfaceC1343a.a() == 0.5f || this.w.a() == 0.33333334f)) ? 50L : 25L);
        }
    }

    @Override // c.a.p0.q4.n.a
    public int getMaxDuration() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.r : invokeV.intValue;
    }

    @Override // c.a.p0.q4.n.a
    public float getProgress() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            float f2 = 0.0f;
            for (Float f3 : this.o) {
                f2 += f3.floatValue();
            }
            return f2;
        }
        return invokeV.floatValue;
    }

    @Override // c.a.p0.q4.n.a
    public int getSlideNum() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.o.size() : invokeV.intValue;
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
            if (this.r <= 0) {
                return;
            }
            RectF rectF = new RectF(getPaddingLeft() + this.y, getPaddingTop() + this.y, (getPaddingLeft() + this.f37098c) - this.y, (getPaddingTop() + this.f37098c) - this.y);
            this.n.setStyle(Paint.Style.FILL_AND_STROKE);
            canvas.drawOval(rectF, this.n);
            this.n.setStyle(Paint.Style.STROKE);
            float f3 = 360.0f / this.r;
            float f4 = (float) ((this.f37099d * 360) / ((this.f37098c + this.y) * 3.141592653589793d));
            if (!this.v) {
                int i = 1;
                while (true) {
                    if (i >= this.r) {
                        break;
                    } else if (i == this.q) {
                        this.n.setColor(this.i);
                        canvas.drawArc(rectF, (i * f3) - 90.0f, f4, false, this.n);
                        this.n.setColor(this.k);
                        break;
                    } else {
                        i++;
                    }
                }
            }
            float f5 = 0.0f;
            for (int i2 = 0; i2 < this.o.size(); i2++) {
                if (this.s && i2 == this.o.size() - 1) {
                    this.l.setColor(this.f37103h);
                    c();
                } else {
                    this.l.setColor(this.f37102g);
                }
                canvas.drawArc(rectF, (f5 * f3) - 90.0f, this.o.get(i2).floatValue() * f3, false, this.l);
                f5 += this.o.get(i2).floatValue();
                float f6 = (float) ((this.f37100e * 360) / ((this.f37098c + this.y) * 3.141592653589793d));
                if (i2 != 0 || getProgress() < 0.2f) {
                    f2 = f6;
                } else {
                    f2 = f6;
                    canvas.drawArc(rectF, ((f5 * f3) - f6) - 90.0f, f6, false, this.l);
                }
                if (i2 < this.o.size() - 1 || this.p == 0) {
                    canvas.drawArc(rectF, ((f5 * f3) - f2) - 90.0f, f2, false, this.m);
                }
            }
        }
    }

    @Override // android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048585, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)}) == null) {
            super.onLayout(z, i, i2, i3, i4);
            this.a = ((i3 - i) - getPaddingRight()) - getPaddingLeft();
            int paddingTop = ((i4 - i2) - getPaddingTop()) - getPaddingBottom();
            this.f37097b = paddingTop;
            this.f37098c = Math.min(this.a, paddingTop);
        }
    }

    @Override // c.a.p0.q4.n.a
    public void reset() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            this.p = 0L;
            removeCallbacks(this);
            this.o.clear();
            this.s = false;
            this.x = getProgress();
            invalidate();
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048587, this) == null) || this.p == 0 || this.o.size() == 0) {
            return;
        }
        a.InterfaceC1343a interfaceC1343a = this.w;
        if (interfaceC1343a != null) {
            interfaceC1343a.onProgress(this.x);
        }
        if (this.x >= this.r) {
            a.InterfaceC1343a interfaceC1343a2 = this.w;
            if (interfaceC1343a2 != null) {
                interfaceC1343a2.onFinish();
                return;
            }
            return;
        }
        d();
    }

    public void setIsAbandonMin(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048588, this, z) == null) {
            this.v = z;
        }
    }

    @Override // c.a.p0.q4.n.a
    public void setMaxDuration(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048589, this, i) == null) {
            this.r = i;
        }
    }

    @Override // c.a.p0.q4.n.a
    public void setMinDuration(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048590, this, i) == null) {
            this.q = i;
        }
    }

    @Override // c.a.p0.q4.n.a
    public void setOnProgressListener(a.InterfaceC1343a interfaceC1343a) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, interfaceC1343a) == null) {
            this.w = interfaceC1343a;
        }
    }

    public void setProgress(List<Float> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, list) == null) {
            this.o = list;
            invalidate();
        }
    }

    @Override // c.a.p0.q4.n.a
    public void setShowDeleteLastTip(boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048594, this, z) == null) || this.s == z) {
            return;
        }
        this.s = z;
        invalidate();
    }

    @Override // c.a.p0.q4.n.a
    public void start() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            this.p = System.currentTimeMillis();
            this.o.add(Float.valueOf(0.0f));
            d();
        }
    }

    @Override // c.a.p0.q4.n.a
    public void stop() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
            this.p = 0L;
            removeCallbacks(this);
            removeCallbacks(this.z);
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RecordCircleProgressBar(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.o = new ArrayList();
        this.t = 255;
        this.u = false;
        this.x = 0.0f;
        this.z = new a(this);
        this.f37102g = getContext().getResources().getColor(R.color.CAM_X0302);
        this.f37103h = getContext().getResources().getColor(R.color.CAM_X0301);
        this.j = getContext().getResources().getColor(R.color.CAM_X0313);
        this.k = getContext().getResources().getColor(R.color.CAM_X0619);
        this.i = getContext().getResources().getColor(R.color.CAM_X0302);
        this.f37099d = UtilHelper.getDimenPixelSize(R.dimen.tbds6);
        this.f37100e = UtilHelper.getDimenPixelSize(R.dimen.tbds6);
        int dimenPixelSize = UtilHelper.getDimenPixelSize(R.dimen.tbds16);
        this.f37101f = dimenPixelSize;
        this.y = dimenPixelSize / 2;
        Paint paint = new Paint();
        this.n = paint;
        paint.setAntiAlias(true);
        this.n.setStrokeWidth(this.f37101f);
        this.n.setStyle(Paint.Style.STROKE);
        this.n.setColor(this.k);
        Paint paint2 = new Paint();
        this.l = paint2;
        paint2.setAntiAlias(true);
        this.l.setStrokeWidth(this.f37101f);
        this.l.setStyle(Paint.Style.STROKE);
        Paint paint3 = new Paint();
        this.m = paint3;
        paint3.setAntiAlias(true);
        this.m.setStrokeWidth(this.f37101f);
        this.m.setStyle(Paint.Style.STROKE);
        this.m.setColor(this.j);
    }

    @Override // c.a.p0.q4.n.a
    public void setProgress(long j) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeJ(1048592, this, j) == null) || this.o.size() <= 0) {
            return;
        }
        List<Float> list = this.o;
        list.set(list.size() - 1, Float.valueOf(((float) j) / 1000.0f));
        this.x = getProgress();
        postInvalidate();
    }
}
