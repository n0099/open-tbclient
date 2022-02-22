package com.baidu.wallet.paysdk.ui.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.RectF;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.view.animation.Transformation;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.dxmpay.apollon.utils.ResUtils;
/* loaded from: classes2.dex */
public class PayLoadingImageViewNew extends View {
    public static /* synthetic */ Interceptable $ic = null;
    public static String TAG = "PayLoadingImageViewNew";
    public transient /* synthetic */ FieldHolder $fh;
    public PathMeasure a;

    /* renamed from: b  reason: collision with root package name */
    public Paint f52654b;

    /* renamed from: c  reason: collision with root package name */
    public Paint f52655c;

    /* renamed from: d  reason: collision with root package name */
    public Path f52656d;

    /* renamed from: e  reason: collision with root package name */
    public int f52657e;

    /* renamed from: f  reason: collision with root package name */
    public int f52658f;
    public int flag;

    /* renamed from: g  reason: collision with root package name */
    public int f52659g;

    /* renamed from: h  reason: collision with root package name */
    public final RectF f52660h;

    /* renamed from: i  reason: collision with root package name */
    public Path f52661i;

    /* renamed from: j  reason: collision with root package name */
    public Animation f52662j;
    public Handler k;
    public int strokeWidth;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1021260418, "Lcom/baidu/wallet/paysdk/ui/widget/PayLoadingImageViewNew;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1021260418, "Lcom/baidu/wallet/paysdk/ui/widget/PayLoadingImageViewNew;");
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PayLoadingImageViewNew(Context context) {
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
        this.flag = 0;
        this.strokeWidth = 4;
        this.f52660h = new RectF();
        this.f52661i = new Path();
        a();
    }

    public int dip2px(float f2) {
        InterceptResult invokeF;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeF = interceptable.invokeF(1048576, this, f2)) == null) ? (int) ((f2 * getContext().getResources().getDisplayMetrics().density) + 0.5f) : invokeF.intValue;
    }

    @Override // android.view.View
    public void onAttachedToWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            super.onAttachedToWindow();
            startAnimation();
        }
    }

    @Override // android.view.View
    public void onDetachedFromWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            super.onDetachedFromWindow();
            stopAnimation();
        }
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, canvas) == null) {
            super.onDraw(canvas);
            int i2 = this.f52659g;
            if (i2 == 0) {
                return;
            }
            if (this.f52656d == null) {
                float dip2px = (i2 - dip2px(this.strokeWidth)) / 2.0f;
                RectF rectF = this.f52660h;
                int i3 = this.f52657e;
                rectF.left = i3 - dip2px;
                int i4 = this.f52658f;
                rectF.top = i4 - dip2px;
                rectF.right = i3 + dip2px;
                rectF.bottom = i4 + dip2px;
                Path path = new Path();
                this.f52656d = path;
                path.addArc(this.f52660h, 225.0f, 359.9f);
                this.f52656d.rLineTo(0.0f, 0.0f);
                this.a = new PathMeasure(this.f52656d, false);
            }
            canvas.drawPath(this.f52661i, this.f52654b);
            canvas.save();
        }
    }

    @Override // android.view.View
    public void onMeasure(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048580, this, i2, i3) == null) {
            super.onMeasure(i2, i3);
            if (getMeasuredWidth() > getHeight()) {
                this.f52659g = getMeasuredHeight();
            } else {
                this.f52659g = getMeasuredWidth();
            }
            int i4 = this.f52659g;
            this.f52657e = i4 / 2;
            this.f52658f = i4 / 2;
        }
    }

    public void startAnimation() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            stopAnimation();
            this.flag = 0;
            a(0.0f, 1.0f, 800L);
        }
    }

    public void stopAnimation() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            clearAnimation();
        }
    }

    private void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65542, this) == null) {
            Paint paint = new Paint();
            this.f52654b = paint;
            paint.setAntiAlias(true);
            this.f52654b.setColor(ResUtils.getColor(getContext(), "wallet_fp_main_327de7"));
            this.f52654b.setStrokeWidth(dip2px(this.strokeWidth));
            this.f52654b.setStyle(Paint.Style.STROKE);
            this.f52654b.setStrokeJoin(Paint.Join.ROUND);
            this.f52654b.setStrokeCap(Paint.Cap.ROUND);
            Paint paint2 = new Paint();
            this.f52655c = paint2;
            paint2.setAntiAlias(true);
            this.f52655c.setColor(-16777216);
            this.f52655c.setStrokeWidth(dip2px(this.strokeWidth));
            this.f52655c.setStyle(Paint.Style.STROKE);
            this.f52655c.setStrokeJoin(Paint.Join.ROUND);
            this.f52655c.setStrokeCap(Paint.Cap.ROUND);
            this.k = new Handler(this) { // from class: com.baidu.wallet.paysdk.ui.widget.PayLoadingImageViewNew.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ PayLoadingImageViewNew a;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.a = this;
                }

                @Override // android.os.Handler
                public void handleMessage(Message message) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, message) == null) {
                        super.handleMessage(message);
                        this.a.f52662j.start();
                        String str = PayLoadingImageViewNew.TAG;
                    }
                }
            };
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PayLoadingImageViewNew(Context context, AttributeSet attributeSet) {
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
        this.flag = 0;
        this.strokeWidth = 4;
        this.f52660h = new RectF();
        this.f52661i = new Path();
        a();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PayLoadingImageViewNew(Context context, AttributeSet attributeSet, int i2) {
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
        this.flag = 0;
        this.strokeWidth = 4;
        this.f52660h = new RectF();
        this.f52661i = new Path();
        a();
    }

    private Animation a(float f2, float f3, long j2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3), Long.valueOf(j2)})) == null) {
            Animation animation = new Animation(this) { // from class: com.baidu.wallet.paysdk.ui.widget.PayLoadingImageViewNew.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ PayLoadingImageViewNew a;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.a = this;
                }

                @Override // android.view.animation.Animation
                public void applyTransformation(float f4, Transformation transformation) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeCommon(1048576, this, new Object[]{Float.valueOf(f4), transformation}) == null) {
                        PayLoadingImageViewNew payLoadingImageViewNew = this.a;
                        if (payLoadingImageViewNew.a != null) {
                            payLoadingImageViewNew.f52661i.reset();
                            float length = this.a.a.getLength() * f4;
                            PayLoadingImageViewNew payLoadingImageViewNew2 = this.a;
                            if (payLoadingImageViewNew2.flag % 2 != 0) {
                                payLoadingImageViewNew2.a.getSegment(0.0f, length, payLoadingImageViewNew2.f52661i, true);
                            } else {
                                PathMeasure pathMeasure = payLoadingImageViewNew2.a;
                                pathMeasure.getSegment(pathMeasure.getLength() - length, this.a.a.getLength(), this.a.f52661i, true);
                            }
                            String str = PayLoadingImageViewNew.TAG;
                            String str2 = "currentLength " + length;
                            this.a.f52661i.rLineTo(0.0f, 0.0f);
                        }
                        this.a.invalidate();
                    }
                }
            };
            this.f52662j = animation;
            animation.setAnimationListener(new Animation.AnimationListener(this) { // from class: com.baidu.wallet.paysdk.ui.widget.PayLoadingImageViewNew.3
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ PayLoadingImageViewNew a;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.a = this;
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, animation2) == null) {
                    }
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation animation2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, animation2) == null) {
                        this.a.flag++;
                    }
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(Animation animation2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_SEND_USER_MSG, this, animation2) == null) {
                    }
                }
            });
            this.f52662j.setInterpolator(new LinearInterpolator());
            this.f52662j.setDuration(j2);
            this.f52662j.setRepeatMode(2);
            this.f52662j.setRepeatCount(-1);
            startAnimation(this.f52662j);
            return this.f52662j;
        }
        return (Animation) invokeCommon.objValue;
    }
}
