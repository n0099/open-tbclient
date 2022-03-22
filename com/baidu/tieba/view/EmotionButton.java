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
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class EmotionButton extends View {
    public static /* synthetic */ Interceptable $ic;
    public static final int p;
    public static int q;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;

    /* renamed from: b  reason: collision with root package name */
    public int f36837b;

    /* renamed from: c  reason: collision with root package name */
    public int f36838c;

    /* renamed from: d  reason: collision with root package name */
    public int f36839d;

    /* renamed from: e  reason: collision with root package name */
    public int f36840e;

    /* renamed from: f  reason: collision with root package name */
    public int f36841f;

    /* renamed from: g  reason: collision with root package name */
    public Paint f36842g;

    /* renamed from: h  reason: collision with root package name */
    public TextPaint f36843h;
    public RectF i;
    public int j;
    public int k;
    public LinearGradient l;
    public LinearGradient m;
    public String n;
    public float o;

    /* loaded from: classes6.dex */
    public class a implements View.OnTouchListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ EmotionButton a;

        public a(EmotionButton emotionButton) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {emotionButton};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = emotionButton;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view, motionEvent)) == null) {
                if (motionEvent.getAction() == 0 || motionEvent.getAction() == 1) {
                    int unused = EmotionButton.q = motionEvent.getAction();
                    this.a.invalidate();
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
        p = n.f(TbadkCoreApplication.getInst(), R.dimen.tbds3);
        q = 1;
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
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
            this.f36842g.setShader(this.l);
            this.f36842g.setShadowLayer(p, 2.0f, 2.0f, this.a);
            if (this.i == null) {
                this.i = new RectF();
            }
            RectF rectF = this.i;
            rectF.left = 5.0f;
            rectF.top = 10.0f;
            rectF.right = this.j - 5;
            rectF.bottom = this.k - 10;
            canvas.drawRoundRect(rectF, 15.0f, 15.0f, this.f36842g);
            if (TextUtils.isEmpty(this.n)) {
                return;
            }
            Paint.FontMetrics fontMetrics = this.f36843h.getFontMetrics();
            canvas.drawText(this.n, this.i.centerX(), (int) ((this.i.centerY() - (fontMetrics.top / 2.0f)) - (fontMetrics.bottom / 2.0f)), this.f36843h);
        }
    }

    public final void c(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, canvas) == null) {
            this.f36842g.setShader(this.m);
            this.f36842g.setShadowLayer(p, 2.0f, 2.0f, this.f36839d);
            if (this.i == null) {
                this.i = new RectF();
            }
            RectF rectF = this.i;
            rectF.left = 5.0f;
            rectF.top = 10.0f;
            rectF.right = this.j - 5;
            rectF.bottom = this.k - 10;
            canvas.drawRoundRect(rectF, 15.0f, 15.0f, this.f36842g);
            if (TextUtils.isEmpty(this.n)) {
                return;
            }
            Paint.FontMetrics fontMetrics = this.f36843h.getFontMetrics();
            canvas.drawText(this.n, this.i.centerX(), (int) ((this.i.centerY() - (fontMetrics.top / 2.0f)) - (fontMetrics.bottom / 2.0f)), this.f36843h);
        }
    }

    public final void d(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, context) == null) {
            this.a = SkinManager.getColor(R.color.cp_link_tip_a_alpha50);
            this.f36837b = SkinManager.getColor(R.color.CAM_X0302);
            this.f36838c = SkinManager.getColor(R.color.CAM_X0303);
            this.f36839d = SkinManager.getColor(R.color.cp_link_tip_a_alpha50);
            this.f36840e = SkinManager.getColor(R.color.cp_link_tip_a_alpha50);
            this.f36841f = SkinManager.getColor(R.color.cp_link_tip_b_alpha50);
            Paint paint = new Paint();
            this.f36842g = paint;
            paint.setStyle(Paint.Style.FILL);
            TextPaint textPaint = new TextPaint(1);
            this.f36843h = textPaint;
            textPaint.setTextSize(this.o);
            this.f36843h.setStyle(Paint.Style.FILL);
            this.f36843h.setTextAlign(Paint.Align.CENTER);
            this.f36843h.setColor(SkinManager.getColor(R.color.CAM_X0101));
            setOnTouchListener(new a(this));
        }
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, canvas) == null) {
            if (q == 0) {
                c(canvas);
            } else {
                b(canvas);
            }
        }
    }

    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048580, this, i, i2) == null) {
            super.onMeasure(i, i2);
            int mode = View.MeasureSpec.getMode(i);
            int size = View.MeasureSpec.getSize(i);
            int mode2 = View.MeasureSpec.getMode(i2);
            int size2 = View.MeasureSpec.getSize(i2);
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
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIII(1048581, this, i, i2, i3, i4) == null) {
            super.onSizeChanged(i, i2, i3, i4);
            this.j = i;
            this.k = i2;
            this.l = new LinearGradient(5.0f, 10.0f, this.j - 5, this.k - 10, this.f36838c, this.f36837b, Shader.TileMode.MIRROR);
            this.m = new LinearGradient(5.0f, 10.0f, this.j - 5, this.k - 10, this.f36841f, this.f36840e, Shader.TileMode.MIRROR);
        }
    }

    public void setText(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, str) == null) {
            this.n = str;
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, new int[]{R.attr.obfuscated_res_0x7f0401d2, R.attr.obfuscated_res_0x7f0405f8});
        this.n = obtainStyledAttributes.getString(1);
        this.o = obtainStyledAttributes.getDimension(0, n.f(context, R.dimen.tbds44));
        obtainStyledAttributes.recycle();
        d(context);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public EmotionButton(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i)};
            interceptable.invokeUnInit(65539, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65539, newInitContext);
                return;
            }
        }
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, new int[]{R.attr.obfuscated_res_0x7f0401d2, R.attr.obfuscated_res_0x7f0405f8});
        this.n = obtainStyledAttributes.getString(1);
        this.o = obtainStyledAttributes.getDimension(0, n.f(context, R.dimen.tbds44));
        obtainStyledAttributes.recycle();
        d(context);
    }
}
