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
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.R;
import com.baidu.tieba.fra;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes8.dex */
public class RecordProgressBar extends View implements fra, Runnable {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;
    public int b;
    public int c;
    public int d;
    public int e;
    public int f;
    public int g;
    public Paint h;
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
    public fra.a s;
    public float t;

    /* loaded from: classes8.dex */
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

    @Override // com.baidu.tieba.fra
    public void setProgress(long j) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeJ(1048591, this, j) == null) && this.k.size() > 0) {
            List<Float> list = this.k;
            list.set(list.size() - 1, Float.valueOf(((float) j) / 1000.0f));
            this.t = getProgress();
            postInvalidate();
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
        this.c = getContext().getResources().getColor(R.color.CAM_X0302);
        this.d = getContext().getResources().getColor(R.color.CAM_X0301);
        this.f = getContext().getResources().getColor(R.color.CAM_X0313);
        this.g = getContext().getResources().getColor(R.color.CAM_X0615);
        this.e = getContext().getResources().getColor(R.color.CAM_X0312);
        this.a = BdUtilHelper.dip2px(context, 2.0f);
        this.b = BdUtilHelper.dip2px(context, 2.0f);
        BdUtilHelper.dip2px(context, 6.0f);
        Paint paint = new Paint();
        this.j = paint;
        paint.setColor(this.g);
        this.h = new Paint();
        Paint paint2 = new Paint();
        this.i = paint2;
        paint2.setColor(this.f);
    }

    @Override // com.baidu.tieba.fra
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
            fra.a aVar = this.s;
            if (aVar != null) {
                aVar.a(this.t);
            }
        }
    }

    public final void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            postDelayed(new a(this), 100L);
            int i = this.p;
            if (i <= 0) {
                this.h.setAlpha(0);
            } else if (i >= 255) {
                this.h.setAlpha(255);
            } else {
                this.h.setAlpha(i);
            }
        }
    }

    public final void d() {
        long j;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            fra.a aVar = this.s;
            if (aVar != null && (aVar.getSpeed() == 0.5f || this.s.getSpeed() == 0.33333334f)) {
                j = 25;
            } else {
                j = 50;
            }
            postDelayed(this, j);
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048586, this) == null) && this.l != 0 && this.k.size() != 0) {
            fra.a aVar = this.s;
            if (aVar != null) {
                aVar.onProgress(this.t);
            }
            if (this.t >= this.n) {
                fra.a aVar2 = this.s;
                if (aVar2 != null) {
                    aVar2.onFinish();
                    return;
                }
                return;
            }
            d();
        }
    }

    @Override // com.baidu.tieba.fra
    public boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.o;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.fra
    public int getMaxDuration() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.n;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tieba.fra
    public float getProgress() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            float f = 0.0f;
            for (Float f2 : this.k) {
                f += f2.floatValue();
            }
            return f;
        }
        return invokeV.floatValue;
    }

    @Override // com.baidu.tieba.fra
    public int getSlideNum() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.k.size();
        }
        return invokeV.intValue;
    }

    @Override // android.view.View
    public void onDetachedFromWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            super.onDetachedFromWindow();
            stop();
        }
    }

    @Override // com.baidu.tieba.fra
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

    @Override // com.baidu.tieba.fra
    public void start() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            this.l = System.currentTimeMillis();
            this.k.add(Float.valueOf(0.0f));
            d();
        }
    }

    @Override // com.baidu.tieba.fra
    public void stop() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            this.l = 0L;
            removeCallbacks(this);
            invalidate();
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
            float f = 0.0f;
            canvas.drawRoundRect(new RectF(0.0f, 0.0f, getWidth(), getHeight()), 20.0f, 20.0f, this.j);
            float width = (getWidth() * 1.0f) / this.n;
            if (!this.r) {
                int i = 1;
                while (true) {
                    if (i >= this.n) {
                        break;
                    } else if (i == this.m) {
                        this.j.setColor(this.e);
                        float f2 = width * i;
                        canvas.drawRect(f2, 0.0f, f2 + this.a, getHeight(), this.j);
                        this.j.setColor(this.g);
                        break;
                    } else {
                        i++;
                    }
                }
            }
            for (int i2 = 0; i2 < this.k.size(); i2++) {
                if (this.o && i2 == this.k.size() - 1) {
                    this.h.setColor(this.d);
                    c();
                } else {
                    this.h.setColor(this.c);
                }
                if (i2 != 0) {
                    float f3 = f * width;
                    f += this.k.get(i2).floatValue();
                    canvas.drawRect(f3, 0.0f, f * width, getHeight(), this.h);
                } else if (Build.VERSION.SDK_INT >= 21) {
                    float f4 = f * width;
                    f += this.k.get(i2).floatValue();
                    canvas.drawRoundRect(f4, 0.0f, f * width, getHeight(), 20.0f, 20.0f, this.h);
                } else {
                    float f5 = f * width;
                    f += this.k.get(i2).floatValue();
                    canvas.drawRect(f5, 0.0f, f * width, getHeight(), this.h);
                }
                if (i2 == 0 && getProgress() >= 0.2f) {
                    float f6 = f * width;
                    canvas.drawRect(f6 - this.b, 0.0f, f6, getHeight(), this.h);
                }
                if (i2 < this.k.size() - 1 || this.l == 0) {
                    float f7 = f * width;
                    canvas.drawRect(f7 - this.b, 0.0f, f7, getHeight(), this.i);
                }
            }
        }
    }

    public void setIsAbandonMin(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048587, this, z) == null) {
            this.r = z;
        }
    }

    @Override // com.baidu.tieba.fra
    public void setMaxDuration(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048588, this, i) == null) {
            this.n = i;
        }
    }

    @Override // com.baidu.tieba.fra
    public void setMinDuration(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048589, this, i) == null) {
            this.m = i;
        }
    }

    @Override // com.baidu.tieba.fra
    public void setOnProgressListener(fra.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, aVar) == null) {
            this.s = aVar;
        }
    }

    public void setProgress(List<Float> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, list) == null) {
            this.k = list;
            invalidate();
        }
    }

    @Override // com.baidu.tieba.fra
    public void setShowDeleteLastTip(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048593, this, z) == null) && this.o != z) {
            this.o = z;
            invalidate();
        }
    }
}
