package com.baidu.tieba.play;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.widget.SeekBar;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import c.a.r0.k3.c;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.R$styleable;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
@SuppressLint({"AppCompatCustomView"})
/* loaded from: classes7.dex */
public class LinearVideoLoadingSeekBar extends SeekBar {
    public static /* synthetic */ Interceptable $ic = null;
    public static final double LOADING_DURATION = 0.5d;
    public static final int LODING_VIEW_CHANGE_MSG = 1;
    public static final int MIN_COLOR_TRANSPARENCY = 30;
    public static final int REPEAT_COUNT = 30;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public int f56139e;

    /* renamed from: f  reason: collision with root package name */
    public int f56140f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f56141g;

    /* renamed from: h  reason: collision with root package name */
    public final int f56142h;

    /* renamed from: i  reason: collision with root package name */
    public Handler f56143i;

    /* loaded from: classes7.dex */
    public class a extends Handler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ LinearVideoLoadingSeekBar f56144a;

        public a(LinearVideoLoadingSeekBar linearVideoLoadingSeekBar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {linearVideoLoadingSeekBar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f56144a = linearVideoLoadingSeekBar;
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, message) == null) {
                super.handleMessage(message);
                this.f56144a.invalidate();
                if (this.f56144a.f56141g) {
                    sendEmptyMessageDelayed(1, 16L);
                }
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public LinearVideoLoadingSeekBar(Context context) {
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

    public final void b(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, canvas) == null) {
            int width = getWidth();
            int height = getHeight();
            int paddingTop = getPaddingTop();
            int paddingBottom = getPaddingBottom();
            Paint paint = new Paint();
            paint.setStyle(Paint.Style.FILL_AND_STROKE);
            paint.setAntiAlias(true);
            int i2 = this.f56139e + (width / 30);
            this.f56139e = i2;
            if (i2 >= width) {
                this.f56139e = 0;
            }
            paint.setColor(c.a(this.f56142h, width == 0 ? 1.0f : Math.max(255 - ((this.f56139e * 255) / width), 30) / 255.0f));
            paint.setStrokeWidth(this.f56140f);
            float f2 = width / 2.0f;
            int i3 = this.f56139e;
            float f3 = ((height - paddingBottom) + paddingTop) / 2.0f;
            canvas.drawLine(f2 - (i3 / 2.0f), f3, f2 + (i3 / 2.0f), f3, paint);
        }
    }

    @Override // android.widget.ProgressBar, android.view.View
    public void onDetachedFromWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            super.onDetachedFromWindow();
            this.f56143i.removeCallbacksAndMessages(null);
        }
    }

    @Override // android.widget.AbsSeekBar, android.widget.ProgressBar, android.view.View
    public synchronized void onDraw(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, canvas) == null) {
            synchronized (this) {
                if (this.f56141g) {
                    b(canvas);
                } else {
                    super.onDraw(canvas);
                }
            }
        }
    }

    public void setLoading(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048579, this, z) == null) {
            this.f56141g = z;
            if (z) {
                this.f56139e = 0;
                this.f56143i.sendEmptyMessageDelayed(1, 33L);
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public LinearVideoLoadingSeekBar(@NonNull Context context, @Nullable AttributeSet attributeSet) {
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
    public LinearVideoLoadingSeekBar(@NonNull Context context, @Nullable AttributeSet attributeSet, int i2) {
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
        this.f56139e = 0;
        this.f56140f = 1;
        this.f56141g = false;
        this.f56143i = new a(this);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.LinearVideoLoadingSeekBar);
        this.f56142h = obtainStyledAttributes.getColor(R$styleable.LinearVideoLoadingSeekBar_progressColor, -16777216);
        this.f56140f = obtainStyledAttributes.getDimensionPixelSize(R$styleable.LinearVideoLoadingSeekBar_loadingViewHeight, this.f56140f);
        obtainStyledAttributes.recycle();
    }
}
