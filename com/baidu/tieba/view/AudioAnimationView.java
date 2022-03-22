package com.baidu.tieba.view;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import androidx.core.view.InputDeviceCompat;
import c.a.d.f.m.e;
import c.a.d.f.p.n;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Random;
/* loaded from: classes6.dex */
public class AudioAnimationView extends View {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;

    /* renamed from: b  reason: collision with root package name */
    public Paint f36799b;

    /* renamed from: c  reason: collision with root package name */
    public Random f36800c;

    /* renamed from: d  reason: collision with root package name */
    public int f36801d;

    /* renamed from: e  reason: collision with root package name */
    public int f36802e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f36803f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f36804g;

    /* renamed from: h  reason: collision with root package name */
    public int f36805h;
    public int i;
    public RectF[] j;
    public int[] k;
    public int l;
    public int m;
    public final Runnable n;

    /* loaded from: classes6.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AudioAnimationView a;

        public a(AudioAnimationView audioAnimationView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {audioAnimationView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = audioAnimationView;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.b();
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AudioAnimationView(Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = 3;
        this.f36800c = new Random();
        this.f36801d = 0;
        this.f36802e = 8;
        this.f36803f = false;
        this.f36804g = true;
        this.k = new int[]{6, 3, 5, 10, 8, 6, 5, 3, 5, 10, 8, 6, 5, 3, 6, 3, 5, 10, 8, 6, 5, 3};
        this.l = n.f(TbadkCoreApplication.getInst(), R.dimen.tbds5);
        this.m = R.color.CAM_X0302;
        this.n = new a(this);
        c();
        b();
    }

    public final void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            if (this.f36803f) {
                invalidate();
            }
            e.a().removeCallbacks(this.n);
            if (this.f36804g) {
                return;
            }
            e.a().postDelayed(this.n, 250L);
        }
    }

    public final void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            Paint paint = new Paint();
            this.f36799b = paint;
            paint.setDither(true);
            this.f36799b.setAntiAlias(true);
            this.f36799b.setStyle(Paint.Style.FILL);
            this.f36799b.setColor(SkinManager.getColor(this.m));
        }
    }

    public final void d() {
        int nextInt;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            RectF[] rectFArr = this.j;
            if (rectFArr == null || rectFArr.length != this.f36802e) {
                this.j = new RectF[this.f36802e];
            }
            for (int i = 0; i < this.f36802e; i++) {
                int i2 = this.l * i * 2;
                if (this.f36804g) {
                    nextInt = (int) ((1.0d - (this.k[i % 22] / 10.0d)) * this.i);
                } else {
                    int i3 = this.i;
                    nextInt = i3 > 0 ? this.f36800c.nextInt(i3) : 0;
                }
                int i4 = this.l + i2;
                int i5 = this.i;
                RectF[] rectFArr2 = this.j;
                if (rectFArr2[i] == null) {
                    rectFArr2[i] = new RectF(i2, nextInt, i4, i5);
                } else {
                    rectFArr2[i].set(i2, nextInt, i4, i5);
                }
            }
        }
    }

    public void e(int i) {
        Paint paint;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048579, this, i) == null) || i == this.a || (paint = this.f36799b) == null) {
            return;
        }
        paint.setColor(SkinManager.getColor(this.m));
        invalidate();
        this.a = i;
    }

    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.f36803f = true;
            this.f36804g = true;
            b();
        }
    }

    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.f36803f = true;
            this.f36804g = false;
            b();
        }
    }

    @Override // android.view.View
    public void onDetachedFromWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            super.onDetachedFromWindow();
            e.a().removeCallbacks(this.n);
        }
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, canvas) == null) {
            super.onDraw(canvas);
            if (this.f36803f) {
                for (int i = 0; i < this.f36802e; i++) {
                    d();
                    if (i < this.j.length) {
                        canvas.save();
                        canvas.translate(0.0f, -(this.j[i].top / 2.0f));
                        canvas.drawRoundRect(this.j[i], 10.0f, 10.0f, this.f36799b);
                        canvas.restore();
                    }
                }
            }
        }
    }

    @Override // android.view.View
    @SuppressLint({"DrawAllocation"})
    public void onMeasure(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(InputDeviceCompat.SOURCE_TOUCHPAD, this, i, i2) == null) {
            if (this.f36801d > 0) {
                int mode = View.MeasureSpec.getMode(i);
                int i3 = this.l;
                int i4 = this.f36801d;
                int i5 = i3 * ((i4 * 2) - 1);
                this.f36805h = i5;
                this.f36802e = i4;
                i = View.MeasureSpec.makeMeasureSpec(i5, mode);
            }
            super.onMeasure(i, i2);
            this.i = getMeasuredHeight();
            int measuredWidth = getMeasuredWidth();
            this.f36805h = measuredWidth;
            if (this.f36801d <= 0) {
                this.f36802e = (measuredWidth / this.l) / 2;
            }
        }
    }

    public void setCertainColumnCount(int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048585, this, i) == null) || i == 0) {
            return;
        }
        this.f36801d = i;
    }

    public void setColumnColor(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048586, this, i) == null) {
            Paint paint = this.f36799b;
            if (paint != null) {
                paint.setColor(SkinManager.getColor(i));
            }
            this.m = i;
        }
    }

    public void setColumnWidth(int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048587, this, i) == null) || i <= 0) {
            return;
        }
        this.l = i;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AudioAnimationView(Context context, AttributeSet attributeSet) {
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
        this.a = 3;
        this.f36800c = new Random();
        this.f36801d = 0;
        this.f36802e = 8;
        this.f36803f = false;
        this.f36804g = true;
        this.k = new int[]{6, 3, 5, 10, 8, 6, 5, 3, 5, 10, 8, 6, 5, 3, 6, 3, 5, 10, 8, 6, 5, 3};
        this.l = n.f(TbadkCoreApplication.getInst(), R.dimen.tbds5);
        this.m = R.color.CAM_X0302;
        this.n = new a(this);
        c();
        b();
    }
}
