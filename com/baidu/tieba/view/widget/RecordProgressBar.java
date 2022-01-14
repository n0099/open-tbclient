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
import c.a.t0.n4.m.a;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes13.dex */
public class RecordProgressBar extends View implements c.a.t0.n4.m.a, Runnable {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public int f49390e;

    /* renamed from: f  reason: collision with root package name */
    public int f49391f;

    /* renamed from: g  reason: collision with root package name */
    public int f49392g;

    /* renamed from: h  reason: collision with root package name */
    public int f49393h;

    /* renamed from: i  reason: collision with root package name */
    public int f49394i;

    /* renamed from: j  reason: collision with root package name */
    public int f49395j;
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
    public a.InterfaceC1254a w;
    public float x;

    /* loaded from: classes13.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ RecordProgressBar f49396e;

        public a(RecordProgressBar recordProgressBar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {recordProgressBar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f49396e = recordProgressBar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                RecordProgressBar recordProgressBar = this.f49396e;
                int i2 = recordProgressBar.t;
                if (i2 <= 0) {
                    recordProgressBar.u = true;
                } else if (i2 >= 255) {
                    recordProgressBar.u = false;
                }
                RecordProgressBar recordProgressBar2 = this.f49396e;
                if (recordProgressBar2.u) {
                    recordProgressBar2.t += 50;
                } else {
                    recordProgressBar2.t -= 50;
                }
                this.f49396e.invalidate();
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
            postDelayed(new a(this), 100L);
            int i2 = this.t;
            if (i2 <= 0) {
                this.l.setAlpha(0);
            } else if (i2 >= 255) {
                this.l.setAlpha(255);
            } else {
                this.l.setAlpha(i2);
            }
        }
    }

    public final void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            a.InterfaceC1254a interfaceC1254a = this.w;
            postDelayed(this, (interfaceC1254a == null || !(interfaceC1254a.a() == 0.5f || this.w.a() == 0.33333334f)) ? 50L : 25L);
        }
    }

    @Override // c.a.t0.n4.m.a
    public void deleteLast() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.s = false;
            if (this.o.size() > 0) {
                List<Float> list = this.o;
                list.remove(list.size() - 1);
                this.x = getProgress();
                invalidate();
            }
            a.InterfaceC1254a interfaceC1254a = this.w;
            if (interfaceC1254a != null) {
                interfaceC1254a.b(this.x);
            }
        }
    }

    @Override // c.a.t0.n4.m.a
    public int getMaxDuration() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.r : invokeV.intValue;
    }

    @Override // c.a.t0.n4.m.a
    public float getProgress() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            float f2 = 0.0f;
            for (Float f3 : this.o) {
                f2 += f3.floatValue();
            }
            return f2;
        }
        return invokeV.floatValue;
    }

    @Override // c.a.t0.n4.m.a
    public int getSlideNum() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.o.size() : invokeV.intValue;
    }

    @Override // c.a.t0.n4.m.a
    public boolean isShowingDeleteLastTip() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.s : invokeV.booleanValue;
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
            if (this.r <= 0) {
                return;
            }
            float f2 = 0.0f;
            canvas.drawRoundRect(new RectF(0.0f, 0.0f, getWidth(), getHeight()), 20.0f, 20.0f, this.n);
            float width = (getWidth() * 1.0f) / this.r;
            if (!this.v) {
                int i2 = 1;
                while (true) {
                    if (i2 >= this.r) {
                        break;
                    } else if (i2 == this.q) {
                        this.n.setColor(this.f49394i);
                        float f3 = width * i2;
                        canvas.drawRect(f3, 0.0f, f3 + this.f49390e, getHeight(), this.n);
                        this.n.setColor(this.k);
                        break;
                    } else {
                        i2++;
                    }
                }
            }
            for (int i3 = 0; i3 < this.o.size(); i3++) {
                if (this.s && i3 == this.o.size() - 1) {
                    this.l.setColor(this.f49393h);
                    a();
                } else {
                    this.l.setColor(this.f49392g);
                }
                if (i3 != 0) {
                    float f4 = f2 * width;
                    f2 += this.o.get(i3).floatValue();
                    canvas.drawRect(f4, 0.0f, f2 * width, getHeight(), this.l);
                } else if (Build.VERSION.SDK_INT >= 21) {
                    float f5 = f2 * width;
                    f2 += this.o.get(i3).floatValue();
                    canvas.drawRoundRect(f5, 0.0f, f2 * width, getHeight(), 20.0f, 20.0f, this.l);
                } else {
                    float f6 = f2 * width;
                    f2 += this.o.get(i3).floatValue();
                    canvas.drawRect(f6, 0.0f, f2 * width, getHeight(), this.l);
                }
                if (i3 == 0 && getProgress() >= 0.2f) {
                    float f7 = f2 * width;
                    canvas.drawRect(f7 - this.f49391f, 0.0f, f7, getHeight(), this.l);
                }
                if (i3 < this.o.size() - 1 || this.p == 0) {
                    float f8 = f2 * width;
                    canvas.drawRect(f8 - this.f49391f, 0.0f, f8, getHeight(), this.m);
                }
            }
        }
    }

    @Override // c.a.t0.n4.m.a
    public void reset() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
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
        if (!(interceptable == null || interceptable.invokeV(1048586, this) == null) || this.p == 0 || this.o.size() == 0) {
            return;
        }
        a.InterfaceC1254a interfaceC1254a = this.w;
        if (interfaceC1254a != null) {
            interfaceC1254a.onProgress(this.x);
        }
        if (this.x >= this.r) {
            a.InterfaceC1254a interfaceC1254a2 = this.w;
            if (interfaceC1254a2 != null) {
                interfaceC1254a2.onFinish();
                return;
            }
            return;
        }
        b();
    }

    public void setIsAbandonMin(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048587, this, z) == null) {
            this.v = z;
        }
    }

    @Override // c.a.t0.n4.m.a
    public void setMaxDuration(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048588, this, i2) == null) {
            this.r = i2;
        }
    }

    @Override // c.a.t0.n4.m.a
    public void setMinDuration(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048589, this, i2) == null) {
            this.q = i2;
        }
    }

    @Override // c.a.t0.n4.m.a
    public void setOnProgressListener(a.InterfaceC1254a interfaceC1254a) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, interfaceC1254a) == null) {
            this.w = interfaceC1254a;
        }
    }

    public void setProgress(List<Float> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, list) == null) {
            this.o = list;
            invalidate();
        }
    }

    @Override // c.a.t0.n4.m.a
    public void setShowDeleteLastTip(boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048593, this, z) == null) || this.s == z) {
            return;
        }
        this.s = z;
        invalidate();
    }

    @Override // c.a.t0.n4.m.a
    public void start() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            this.p = System.currentTimeMillis();
            this.o.add(Float.valueOf(0.0f));
            b();
        }
    }

    @Override // c.a.t0.n4.m.a
    public void stop() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            this.p = 0L;
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
    public RecordProgressBar(Context context, @Nullable AttributeSet attributeSet, int i2) {
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
        this.o = new ArrayList();
        this.t = 255;
        this.u = false;
        this.x = 0.0f;
        this.f49392g = getContext().getResources().getColor(R.color.CAM_X0302);
        this.f49393h = getContext().getResources().getColor(R.color.CAM_X0301);
        this.f49395j = getContext().getResources().getColor(R.color.CAM_X0313);
        this.k = getContext().getResources().getColor(R.color.CAM_X0615);
        this.f49394i = getContext().getResources().getColor(R.color.CAM_X0312);
        this.f49390e = n.d(context, 2.0f);
        this.f49391f = n.d(context, 2.0f);
        n.d(context, 6.0f);
        Paint paint = new Paint();
        this.n = paint;
        paint.setColor(this.k);
        this.l = new Paint();
        Paint paint2 = new Paint();
        this.m = paint2;
        paint2.setColor(this.f49395j);
    }

    @Override // c.a.t0.n4.m.a
    public void setProgress(long j2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeJ(1048591, this, j2) == null) || this.o.size() <= 0) {
            return;
        }
        List<Float> list = this.o;
        list.set(list.size() - 1, Float.valueOf(((float) j2) / 1000.0f));
        this.x = getProgress();
        postInvalidate();
    }
}
