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
/* loaded from: classes12.dex */
public class AudioAnimationView extends View {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public int f50945e;

    /* renamed from: f  reason: collision with root package name */
    public Paint f50946f;

    /* renamed from: g  reason: collision with root package name */
    public Random f50947g;

    /* renamed from: h  reason: collision with root package name */
    public int f50948h;

    /* renamed from: i  reason: collision with root package name */
    public int f50949i;

    /* renamed from: j  reason: collision with root package name */
    public boolean f50950j;

    /* renamed from: k  reason: collision with root package name */
    public boolean f50951k;
    public int l;
    public int m;
    public RectF[] n;
    public int[] o;
    public int p;
    public int q;
    public final Runnable r;

    /* loaded from: classes12.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ AudioAnimationView f50952e;

        public a(AudioAnimationView audioAnimationView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {audioAnimationView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f50952e = audioAnimationView;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f50952e.b();
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f50945e = 3;
        this.f50947g = new Random();
        this.f50948h = 0;
        this.f50949i = 8;
        this.f50950j = false;
        this.f50951k = true;
        this.o = new int[]{6, 3, 5, 10, 8, 6, 5, 3, 5, 10, 8, 6, 5, 3, 6, 3, 5, 10, 8, 6, 5, 3};
        this.p = n.f(TbadkCoreApplication.getInst(), R.dimen.tbds5);
        this.q = R.color.CAM_X0302;
        this.r = new a(this);
        c();
        b();
    }

    public final void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            if (this.f50950j) {
                invalidate();
            }
            e.a().removeCallbacks(this.r);
            if (this.f50951k) {
                return;
            }
            e.a().postDelayed(this.r, 250L);
        }
    }

    public final void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            Paint paint = new Paint();
            this.f50946f = paint;
            paint.setDither(true);
            this.f50946f.setAntiAlias(true);
            this.f50946f.setStyle(Paint.Style.FILL);
            this.f50946f.setColor(SkinManager.getColor(this.q));
        }
    }

    public final void d() {
        int nextInt;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            RectF[] rectFArr = this.n;
            if (rectFArr == null || rectFArr.length != this.f50949i) {
                this.n = new RectF[this.f50949i];
            }
            for (int i2 = 0; i2 < this.f50949i; i2++) {
                int i3 = this.p * i2 * 2;
                if (this.f50951k) {
                    nextInt = (int) ((1.0d - (this.o[i2 % 22] / 10.0d)) * this.m);
                } else {
                    int i4 = this.m;
                    nextInt = i4 > 0 ? this.f50947g.nextInt(i4) : 0;
                }
                int i5 = this.p + i3;
                int i6 = this.m;
                RectF[] rectFArr2 = this.n;
                if (rectFArr2[i2] == null) {
                    rectFArr2[i2] = new RectF(i3, nextInt, i5, i6);
                } else {
                    rectFArr2[i2].set(i3, nextInt, i5, i6);
                }
            }
        }
    }

    public void onChangeSkinType(int i2) {
        Paint paint;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048579, this, i2) == null) || i2 == this.f50945e || (paint = this.f50946f) == null) {
            return;
        }
        paint.setColor(SkinManager.getColor(this.q));
        invalidate();
        this.f50945e = i2;
    }

    @Override // android.view.View
    public void onDetachedFromWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            super.onDetachedFromWindow();
            e.a().removeCallbacks(this.r);
        }
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, canvas) == null) {
            super.onDraw(canvas);
            if (this.f50950j) {
                for (int i2 = 0; i2 < this.f50949i; i2++) {
                    d();
                    if (i2 < this.n.length) {
                        canvas.save();
                        canvas.translate(0.0f, -(this.n[i2].top / 2.0f));
                        canvas.drawRoundRect(this.n[i2], 10.0f, 10.0f, this.f50946f);
                        canvas.restore();
                    }
                }
            }
        }
    }

    @Override // android.view.View
    @SuppressLint({"DrawAllocation"})
    public void onMeasure(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048582, this, i2, i3) == null) {
            if (this.f50948h > 0) {
                int mode = View.MeasureSpec.getMode(i2);
                int i4 = this.p;
                int i5 = this.f50948h;
                int i6 = i4 * ((i5 * 2) - 1);
                this.l = i6;
                this.f50949i = i5;
                i2 = View.MeasureSpec.makeMeasureSpec(i6, mode);
            }
            super.onMeasure(i2, i3);
            this.m = getMeasuredHeight();
            int measuredWidth = getMeasuredWidth();
            this.l = measuredWidth;
            if (this.f50948h <= 0) {
                this.f50949i = (measuredWidth / this.p) / 2;
            }
        }
    }

    public void resetStartState() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.f50950j = true;
            this.f50951k = true;
            b();
        }
    }

    public void setCertainColumnCount(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2) == null) || i2 == 0) {
            return;
        }
        this.f50948h = i2;
    }

    public void setColumnColor(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048585, this, i2) == null) {
            Paint paint = this.f50946f;
            if (paint != null) {
                paint.setColor(SkinManager.getColor(i2));
            }
            this.q = i2;
        }
    }

    public void setColumnWidth(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048586, this, i2) == null) || i2 <= 0) {
            return;
        }
        this.p = i2;
    }

    public void start() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            this.f50950j = true;
            this.f50951k = false;
            b();
        }
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f50945e = 3;
        this.f50947g = new Random();
        this.f50948h = 0;
        this.f50949i = 8;
        this.f50950j = false;
        this.f50951k = true;
        this.o = new int[]{6, 3, 5, 10, 8, 6, 5, 3, 5, 10, 8, 6, 5, 3, 6, 3, 5, 10, 8, 6, 5, 3};
        this.p = n.f(TbadkCoreApplication.getInst(), R.dimen.tbds5);
        this.q = R.color.CAM_X0302;
        this.r = new a(this);
        c();
        b();
    }
}
