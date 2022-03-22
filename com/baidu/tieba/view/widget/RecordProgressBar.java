package com.baidu.tieba.view.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import c.a.d.f.p.n;
import c.a.p0.q4.n.a;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class RecordProgressBar extends View implements c.a.p0.q4.n.a, Runnable {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;

    /* renamed from: b  reason: collision with root package name */
    public int f37113b;

    /* renamed from: c  reason: collision with root package name */
    public int f37114c;

    /* renamed from: d  reason: collision with root package name */
    public int f37115d;

    /* renamed from: e  reason: collision with root package name */
    public int f37116e;

    /* renamed from: f  reason: collision with root package name */
    public int f37117f;

    /* renamed from: g  reason: collision with root package name */
    public int f37118g;

    /* renamed from: h  reason: collision with root package name */
    public Paint f37119h;
    public Paint i;
    public Paint j;
    public List<Float> k;
    public long l;
    public int m;
    public int n;
    public boolean o;
    public int p;
    public boolean q;
    public boolean r;
    public a.InterfaceC1343a s;
    public float t;

    /* loaded from: classes6.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ RecordProgressBar a;

        public a(RecordProgressBar recordProgressBar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {recordProgressBar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = recordProgressBar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                RecordProgressBar recordProgressBar = this.a;
                int i = recordProgressBar.p;
                if (i <= 0) {
                    recordProgressBar.q = true;
                } else if (i >= 255) {
                    recordProgressBar.q = false;
                }
                RecordProgressBar recordProgressBar2 = this.a;
                if (recordProgressBar2.q) {
                    recordProgressBar2.p += 50;
                } else {
                    recordProgressBar2.p -= 50;
                }
                this.a.invalidate();
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public RecordProgressBar(Context context) {
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
            this.o = false;
            if (this.k.size() > 0) {
                List<Float> list = this.k;
                list.remove(list.size() - 1);
                this.t = getProgress();
                invalidate();
            }
            a.InterfaceC1343a interfaceC1343a = this.s;
            if (interfaceC1343a != null) {
                interfaceC1343a.b(this.t);
            }
        }
    }

    @Override // c.a.p0.q4.n.a
    public boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.o : invokeV.booleanValue;
    }

    public final void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            postDelayed(new a(this), 100L);
            int i = this.p;
            if (i <= 0) {
                this.f37119h.setAlpha(0);
            } else if (i >= 255) {
                this.f37119h.setAlpha(255);
            } else {
                this.f37119h.setAlpha(i);
            }
        }
    }

    public final void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            a.InterfaceC1343a interfaceC1343a = this.s;
            postDelayed(this, (interfaceC1343a == null || !(interfaceC1343a.a() == 0.5f || this.s.a() == 0.33333334f)) ? 50L : 25L);
        }
    }

    @Override // c.a.p0.q4.n.a
    public int getMaxDuration() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.n : invokeV.intValue;
    }

    @Override // c.a.p0.q4.n.a
    public float getProgress() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            float f2 = 0.0f;
            for (Float f3 : this.k) {
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.k.size() : invokeV.intValue;
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
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, canvas) == null) {
            super.onDraw(canvas);
            if (this.n <= 0) {
                return;
            }
            float f2 = 0.0f;
            canvas.drawRoundRect(new RectF(0.0f, 0.0f, getWidth(), getHeight()), 20.0f, 20.0f, this.j);
            float width = (getWidth() * 1.0f) / this.n;
            if (!this.r) {
                int i = 1;
                while (true) {
                    if (i >= this.n) {
                        break;
                    } else if (i == this.m) {
                        this.j.setColor(this.f37116e);
                        float f3 = width * i;
                        canvas.drawRect(f3, 0.0f, f3 + this.a, getHeight(), this.j);
                        this.j.setColor(this.f37118g);
                        break;
                    } else {
                        i++;
                    }
                }
            }
            for (int i2 = 0; i2 < this.k.size(); i2++) {
                if (this.o && i2 == this.k.size() - 1) {
                    this.f37119h.setColor(this.f37115d);
                    c();
                } else {
                    this.f37119h.setColor(this.f37114c);
                }
                if (i2 != 0) {
                    float f4 = f2 * width;
                    f2 += this.k.get(i2).floatValue();
                    canvas.drawRect(f4, 0.0f, f2 * width, getHeight(), this.f37119h);
                } else if (Build.VERSION.SDK_INT >= 21) {
                    float f5 = f2 * width;
                    f2 += this.k.get(i2).floatValue();
                    canvas.drawRoundRect(f5, 0.0f, f2 * width, getHeight(), 20.0f, 20.0f, this.f37119h);
                } else {
                    float f6 = f2 * width;
                    f2 += this.k.get(i2).floatValue();
                    canvas.drawRect(f6, 0.0f, f2 * width, getHeight(), this.f37119h);
                }
                if (i2 == 0 && getProgress() >= 0.2f) {
                    float f7 = f2 * width;
                    canvas.drawRect(f7 - this.f37113b, 0.0f, f7, getHeight(), this.f37119h);
                }
                if (i2 < this.k.size() - 1 || this.l == 0) {
                    float f8 = f2 * width;
                    canvas.drawRect(f8 - this.f37113b, 0.0f, f8, getHeight(), this.i);
                }
            }
        }
    }

    @Override // c.a.p0.q4.n.a
    public void reset() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            this.l = 0L;
            removeCallbacks(this);
            this.k.clear();
            this.o = false;
            this.t = getProgress();
            invalidate();
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048586, this) == null) || this.l == 0 || this.k.size() == 0) {
            return;
        }
        a.InterfaceC1343a interfaceC1343a = this.s;
        if (interfaceC1343a != null) {
            interfaceC1343a.onProgress(this.t);
        }
        if (this.t >= this.n) {
            a.InterfaceC1343a interfaceC1343a2 = this.s;
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
        if (interceptable == null || interceptable.invokeZ(1048587, this, z) == null) {
            this.r = z;
        }
    }

    @Override // c.a.p0.q4.n.a
    public void setMaxDuration(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048588, this, i) == null) {
            this.n = i;
        }
    }

    @Override // c.a.p0.q4.n.a
    public void setMinDuration(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048589, this, i) == null) {
            this.m = i;
        }
    }

    @Override // c.a.p0.q4.n.a
    public void setOnProgressListener(a.InterfaceC1343a interfaceC1343a) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, interfaceC1343a) == null) {
            this.s = interfaceC1343a;
        }
    }

    public void setProgress(List<Float> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, list) == null) {
            this.k = list;
            invalidate();
        }
    }

    @Override // c.a.p0.q4.n.a
    public void setShowDeleteLastTip(boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048593, this, z) == null) || this.o == z) {
            return;
        }
        this.o = z;
        invalidate();
    }

    @Override // c.a.p0.q4.n.a
    public void start() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            this.l = System.currentTimeMillis();
            this.k.add(Float.valueOf(0.0f));
            d();
        }
    }

    @Override // c.a.p0.q4.n.a
    public void stop() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            this.l = 0L;
            removeCallbacks(this);
            invalidate();
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public RecordProgressBar(Context context, @Nullable AttributeSet attributeSet) {
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
    public RecordProgressBar(Context context, @Nullable AttributeSet attributeSet, int i) {
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
        this.k = new ArrayList();
        this.p = 255;
        this.q = false;
        this.t = 0.0f;
        this.f37114c = getContext().getResources().getColor(R.color.CAM_X0302);
        this.f37115d = getContext().getResources().getColor(R.color.CAM_X0301);
        this.f37117f = getContext().getResources().getColor(R.color.CAM_X0313);
        this.f37118g = getContext().getResources().getColor(R.color.CAM_X0615);
        this.f37116e = getContext().getResources().getColor(R.color.CAM_X0312);
        this.a = n.d(context, 2.0f);
        this.f37113b = n.d(context, 2.0f);
        n.d(context, 6.0f);
        Paint paint = new Paint();
        this.j = paint;
        paint.setColor(this.f37118g);
        this.f37119h = new Paint();
        Paint paint2 = new Paint();
        this.i = paint2;
        paint2.setColor(this.f37117f);
    }

    @Override // c.a.p0.q4.n.a
    public void setProgress(long j) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeJ(1048591, this, j) == null) || this.k.size() <= 0) {
            return;
        }
        List<Float> list = this.k;
        list.set(list.size() - 1, Float.valueOf(((float) j) / 1000.0f));
        this.t = getProgress();
        postInvalidate();
    }
}
