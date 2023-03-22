package com.baidu.tieba.view;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
import com.baidu.tieba.hi;
import com.baidu.tieba.jg;
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
    public Paint b;
    public Random c;
    public int d;
    public int e;
    public boolean f;
    public boolean g;
    public int h;
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
            if (interceptable != null && interceptable.invokeV(1048576, this) != null) {
                return;
            }
            this.a.b();
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
        this.c = new Random();
        this.d = 0;
        this.e = 8;
        this.f = false;
        this.g = true;
        this.k = new int[]{6, 3, 5, 10, 8, 6, 5, 3, 5, 10, 8, 6, 5, 3, 6, 3, 5, 10, 8, 6, 5, 3};
        this.l = hi.g(TbadkCoreApplication.getInst(), R.dimen.tbds5);
        this.m = R.color.CAM_X0302;
        this.n = new a(this);
        c();
        b();
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
        this.c = new Random();
        this.d = 0;
        this.e = 8;
        this.f = false;
        this.g = true;
        this.k = new int[]{6, 3, 5, 10, 8, 6, 5, 3, 5, 10, 8, 6, 5, 3, 6, 3, 5, 10, 8, 6, 5, 3};
        this.l = hi.g(TbadkCoreApplication.getInst(), R.dimen.tbds5);
        this.m = R.color.CAM_X0302;
        this.n = new a(this);
        c();
        b();
    }

    public void e(int i) {
        Paint paint;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048579, this, i) == null) && i != this.a && (paint = this.b) != null) {
            paint.setColor(SkinManager.getColor(this.m));
            invalidate();
            this.a = i;
        }
    }

    public void setCertainColumnCount(int i) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048585, this, i) == null) && i != 0) {
            this.d = i;
        }
    }

    public void setColumnColor(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048586, this, i) == null) {
            Paint paint = this.b;
            if (paint != null) {
                paint.setColor(SkinManager.getColor(i));
            }
            this.m = i;
        }
    }

    public void setColumnWidth(int i) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeI(1048587, this, i) != null) || i <= 0) {
            return;
        }
        this.l = i;
    }

    public final void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            if (this.f) {
                invalidate();
            }
            jg.a().removeCallbacks(this.n);
            if (!this.g) {
                jg.a().postDelayed(this.n, 250L);
            }
        }
    }

    public final void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            Paint paint = new Paint();
            this.b = paint;
            paint.setDither(true);
            this.b.setAntiAlias(true);
            this.b.setStyle(Paint.Style.FILL);
            this.b.setColor(SkinManager.getColor(this.m));
        }
    }

    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.f = true;
            this.g = true;
            b();
        }
    }

    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.f = true;
            this.g = false;
            b();
        }
    }

    @Override // android.view.View
    public void onDetachedFromWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            super.onDetachedFromWindow();
            jg.a().removeCallbacks(this.n);
        }
    }

    public final void d() {
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            RectF[] rectFArr = this.j;
            if (rectFArr == null || rectFArr.length != this.e) {
                this.j = new RectF[this.e];
            }
            for (int i2 = 0; i2 < this.e; i2++) {
                int i3 = this.l * i2 * 2;
                if (this.g) {
                    i = (int) ((1.0d - (this.k[i2 % 22] / 10.0d)) * this.i);
                } else {
                    int i4 = this.i;
                    if (i4 > 0) {
                        i = this.c.nextInt(i4);
                    } else {
                        i = 0;
                    }
                }
                int i5 = this.l + i3;
                int i6 = this.i;
                RectF[] rectFArr2 = this.j;
                if (rectFArr2[i2] == null) {
                    rectFArr2[i2] = new RectF(i3, i, i5, i6);
                } else {
                    rectFArr2[i2].set(i3, i, i5, i6);
                }
            }
        }
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, canvas) == null) {
            super.onDraw(canvas);
            if (this.f) {
                for (int i = 0; i < this.e; i++) {
                    d();
                    if (i < this.j.length) {
                        canvas.save();
                        canvas.translate(0.0f, -(this.j[i].top / 2.0f));
                        canvas.drawRoundRect(this.j[i], 10.0f, 10.0f, this.b);
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
            if (this.d > 0) {
                int mode = View.MeasureSpec.getMode(i);
                int i3 = this.l;
                int i4 = this.d;
                int i5 = i3 * ((i4 * 2) - 1);
                this.h = i5;
                this.e = i4;
                i = View.MeasureSpec.makeMeasureSpec(i5, mode);
            }
            super.onMeasure(i, i2);
            this.i = getMeasuredHeight();
            int measuredWidth = getMeasuredWidth();
            this.h = measuredWidth;
            if (this.d <= 0) {
                this.e = (measuredWidth / this.l) / 2;
            }
        }
    }
}
