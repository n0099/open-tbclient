package com.baidu.tieba.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Shader;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import androidx.annotation.Nullable;
import c.a.d.f.p.n;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
import com.baidu.tieba.R$styleable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes13.dex */
public class EmotionButton extends View {
    public static /* synthetic */ Interceptable $ic;
    public static final int t;
    public static int u;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public int f49072e;

    /* renamed from: f  reason: collision with root package name */
    public int f49073f;

    /* renamed from: g  reason: collision with root package name */
    public int f49074g;

    /* renamed from: h  reason: collision with root package name */
    public int f49075h;

    /* renamed from: i  reason: collision with root package name */
    public int f49076i;

    /* renamed from: j  reason: collision with root package name */
    public int f49077j;
    public Paint k;
    public TextPaint l;
    public RectF m;
    public int n;
    public int o;
    public LinearGradient p;
    public LinearGradient q;
    public String r;
    public float s;

    /* loaded from: classes13.dex */
    public class a implements View.OnTouchListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ EmotionButton f49078e;

        public a(EmotionButton emotionButton) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {emotionButton};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f49078e = emotionButton;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view, motionEvent)) == null) {
                if (motionEvent.getAction() == 0 || motionEvent.getAction() == 1) {
                    int unused = EmotionButton.u = motionEvent.getAction();
                    this.f49078e.invalidate();
                    return false;
                }
                return false;
            }
            return invokeLL.booleanValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-406081878, "Lcom/baidu/tieba/view/EmotionButton;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-406081878, "Lcom/baidu/tieba/view/EmotionButton;");
                return;
            }
        }
        t = n.f(TbadkCoreApplication.getInst(), R.dimen.tbds3);
        u = 1;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public EmotionButton(Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        d(context);
    }

    public final void b(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, canvas) == null) {
            this.k.setShader(this.p);
            this.k.setShadowLayer(t, 2.0f, 2.0f, this.f49072e);
            if (this.m == null) {
                this.m = new RectF();
            }
            RectF rectF = this.m;
            rectF.left = 5.0f;
            rectF.top = 10.0f;
            rectF.right = this.n - 5;
            rectF.bottom = this.o - 10;
            canvas.drawRoundRect(rectF, 15.0f, 15.0f, this.k);
            if (TextUtils.isEmpty(this.r)) {
                return;
            }
            Paint.FontMetrics fontMetrics = this.l.getFontMetrics();
            canvas.drawText(this.r, this.m.centerX(), (int) ((this.m.centerY() - (fontMetrics.top / 2.0f)) - (fontMetrics.bottom / 2.0f)), this.l);
        }
    }

    public final void c(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, canvas) == null) {
            this.k.setShader(this.q);
            this.k.setShadowLayer(t, 2.0f, 2.0f, this.f49075h);
            if (this.m == null) {
                this.m = new RectF();
            }
            RectF rectF = this.m;
            rectF.left = 5.0f;
            rectF.top = 10.0f;
            rectF.right = this.n - 5;
            rectF.bottom = this.o - 10;
            canvas.drawRoundRect(rectF, 15.0f, 15.0f, this.k);
            if (TextUtils.isEmpty(this.r)) {
                return;
            }
            Paint.FontMetrics fontMetrics = this.l.getFontMetrics();
            canvas.drawText(this.r, this.m.centerX(), (int) ((this.m.centerY() - (fontMetrics.top / 2.0f)) - (fontMetrics.bottom / 2.0f)), this.l);
        }
    }

    public final void d(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, context) == null) {
            this.f49072e = SkinManager.getColor(R.color.cp_link_tip_a_alpha50);
            this.f49073f = SkinManager.getColor(R.color.CAM_X0302);
            this.f49074g = SkinManager.getColor(R.color.CAM_X0303);
            this.f49075h = SkinManager.getColor(R.color.cp_link_tip_a_alpha50);
            this.f49076i = SkinManager.getColor(R.color.cp_link_tip_a_alpha50);
            this.f49077j = SkinManager.getColor(R.color.cp_link_tip_b_alpha50);
            Paint paint = new Paint();
            this.k = paint;
            paint.setStyle(Paint.Style.FILL);
            TextPaint textPaint = new TextPaint(1);
            this.l = textPaint;
            textPaint.setTextSize(this.s);
            this.l.setStyle(Paint.Style.FILL);
            this.l.setTextAlign(Paint.Align.CENTER);
            this.l.setColor(SkinManager.getColor(R.color.CAM_X0101));
            setOnTouchListener(new a(this));
        }
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, canvas) == null) {
            if (u == 0) {
                c(canvas);
            } else {
                b(canvas);
            }
        }
    }

    @Override // android.view.View
    public void onMeasure(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048580, this, i2, i3) == null) {
            super.onMeasure(i2, i3);
            int mode = View.MeasureSpec.getMode(i2);
            int size = View.MeasureSpec.getSize(i2);
            int mode2 = View.MeasureSpec.getMode(i3);
            int size2 = View.MeasureSpec.getSize(i3);
            if (mode == Integer.MIN_VALUE && mode2 == Integer.MIN_VALUE) {
                setMeasuredDimension(200, 200);
            } else if (mode == Integer.MIN_VALUE) {
                setMeasuredDimension(200, size2);
            } else if (mode2 == Integer.MIN_VALUE) {
                setMeasuredDimension(size, 200);
            }
        }
    }

    @Override // android.view.View
    public void onSizeChanged(int i2, int i3, int i4, int i5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIII(1048581, this, i2, i3, i4, i5) == null) {
            super.onSizeChanged(i2, i3, i4, i5);
            this.n = i2;
            this.o = i3;
            this.p = new LinearGradient(5.0f, 10.0f, this.n - 5, this.o - 10, this.f49074g, this.f49073f, Shader.TileMode.MIRROR);
            this.q = new LinearGradient(5.0f, 10.0f, this.n - 5, this.o - 10, this.f49077j, this.f49076i, Shader.TileMode.MIRROR);
        }
    }

    public void setText(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, str) == null) {
            this.r = str;
            invalidate();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public EmotionButton(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.EmotionButton);
        this.r = obtainStyledAttributes.getString(R$styleable.EmotionButton_text);
        this.s = obtainStyledAttributes.getDimension(R$styleable.EmotionButton_ebTextSize, n.f(context, R.dimen.tbds44));
        obtainStyledAttributes.recycle();
        d(context);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public EmotionButton(Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65539, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65539, newInitContext);
                return;
            }
        }
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.EmotionButton);
        this.r = obtainStyledAttributes.getString(R$styleable.EmotionButton_text);
        this.s = obtainStyledAttributes.getDimension(R$styleable.EmotionButton_ebTextSize, n.f(context, R.dimen.tbds44));
        obtainStyledAttributes.recycle();
        d(context);
    }
}
