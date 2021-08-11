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
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.dxmpay.apollon.utils.ResUtils;
/* loaded from: classes8.dex */
public class PayLoadingImageViewNew extends View {
    public static /* synthetic */ Interceptable $ic = null;
    public static String TAG = "PayLoadingImageViewNew";
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public PathMeasure f62903a;

    /* renamed from: b  reason: collision with root package name */
    public Paint f62904b;

    /* renamed from: c  reason: collision with root package name */
    public Paint f62905c;

    /* renamed from: d  reason: collision with root package name */
    public Path f62906d;

    /* renamed from: e  reason: collision with root package name */
    public int f62907e;

    /* renamed from: f  reason: collision with root package name */
    public int f62908f;
    public int flag;

    /* renamed from: g  reason: collision with root package name */
    public int f62909g;

    /* renamed from: h  reason: collision with root package name */
    public final RectF f62910h;

    /* renamed from: i  reason: collision with root package name */
    public Path f62911i;

    /* renamed from: j  reason: collision with root package name */
    public Animation f62912j;
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
        this.f62910h = new RectF();
        this.f62911i = new Path();
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
            int i2 = this.f62909g;
            if (i2 == 0) {
                return;
            }
            if (this.f62906d == null) {
                float dip2px = (i2 - dip2px(this.strokeWidth)) / 2.0f;
                RectF rectF = this.f62910h;
                int i3 = this.f62907e;
                rectF.left = i3 - dip2px;
                int i4 = this.f62908f;
                rectF.top = i4 - dip2px;
                rectF.right = i3 + dip2px;
                rectF.bottom = i4 + dip2px;
                Path path = new Path();
                this.f62906d = path;
                path.addArc(this.f62910h, 225.0f, 359.9f);
                this.f62906d.rLineTo(0.0f, 0.0f);
                this.f62903a = new PathMeasure(this.f62906d, false);
            }
            canvas.drawPath(this.f62911i, this.f62904b);
            canvas.save();
        }
    }

    @Override // android.view.View
    public void onMeasure(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048580, this, i2, i3) == null) {
            super.onMeasure(i2, i3);
            if (getMeasuredWidth() > getHeight()) {
                this.f62909g = getMeasuredHeight();
            } else {
                this.f62909g = getMeasuredWidth();
            }
            int i4 = this.f62909g;
            this.f62907e = i4 / 2;
            this.f62908f = i4 / 2;
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
        if (interceptable == null || interceptable.invokeV(AdIconUtil.BAIDU_LOGO_ID, this) == null) {
            Paint paint = new Paint();
            this.f62904b = paint;
            paint.setAntiAlias(true);
            this.f62904b.setColor(ResUtils.getColor(getContext(), "wallet_fp_main_327de7"));
            this.f62904b.setStrokeWidth(dip2px(this.strokeWidth));
            this.f62904b.setStyle(Paint.Style.STROKE);
            this.f62904b.setStrokeJoin(Paint.Join.ROUND);
            this.f62904b.setStrokeCap(Paint.Cap.ROUND);
            Paint paint2 = new Paint();
            this.f62905c = paint2;
            paint2.setAntiAlias(true);
            this.f62905c.setColor(-16777216);
            this.f62905c.setStrokeWidth(dip2px(this.strokeWidth));
            this.f62905c.setStyle(Paint.Style.STROKE);
            this.f62905c.setStrokeJoin(Paint.Join.ROUND);
            this.f62905c.setStrokeCap(Paint.Cap.ROUND);
            this.k = new Handler(this) { // from class: com.baidu.wallet.paysdk.ui.widget.PayLoadingImageViewNew.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ PayLoadingImageViewNew f62913a;

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
                    this.f62913a = this;
                }

                @Override // android.os.Handler
                public void handleMessage(Message message) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, message) == null) {
                        super.handleMessage(message);
                        this.f62913a.f62912j.start();
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
        this.f62910h = new RectF();
        this.f62911i = new Path();
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
        this.f62910h = new RectF();
        this.f62911i = new Path();
        a();
    }

    private Animation a(float f2, float f3, long j2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3), Long.valueOf(j2)})) == null) {
            Animation animation = new Animation(this) { // from class: com.baidu.wallet.paysdk.ui.widget.PayLoadingImageViewNew.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ PayLoadingImageViewNew f62914a;

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
                    this.f62914a = this;
                }

                @Override // android.view.animation.Animation
                public void applyTransformation(float f4, Transformation transformation) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeCommon(1048576, this, new Object[]{Float.valueOf(f4), transformation}) == null) {
                        PayLoadingImageViewNew payLoadingImageViewNew = this.f62914a;
                        if (payLoadingImageViewNew.f62903a != null) {
                            payLoadingImageViewNew.f62911i.reset();
                            float length = this.f62914a.f62903a.getLength() * f4;
                            PayLoadingImageViewNew payLoadingImageViewNew2 = this.f62914a;
                            if (payLoadingImageViewNew2.flag % 2 != 0) {
                                payLoadingImageViewNew2.f62903a.getSegment(0.0f, length, payLoadingImageViewNew2.f62911i, true);
                            } else {
                                PathMeasure pathMeasure = payLoadingImageViewNew2.f62903a;
                                pathMeasure.getSegment(pathMeasure.getLength() - length, this.f62914a.f62903a.getLength(), this.f62914a.f62911i, true);
                            }
                            String str = PayLoadingImageViewNew.TAG;
                            String str2 = "currentLength " + length;
                            this.f62914a.f62911i.rLineTo(0.0f, 0.0f);
                        }
                        this.f62914a.invalidate();
                    }
                }
            };
            this.f62912j = animation;
            animation.setAnimationListener(new Animation.AnimationListener(this) { // from class: com.baidu.wallet.paysdk.ui.widget.PayLoadingImageViewNew.3
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ PayLoadingImageViewNew f62915a;

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
                    this.f62915a = this;
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
                        this.f62915a.flag++;
                    }
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(Animation animation2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_SEND_USER_MSG, this, animation2) == null) {
                    }
                }
            });
            this.f62912j.setInterpolator(new LinearInterpolator());
            this.f62912j.setDuration(j2);
            this.f62912j.setRepeatMode(2);
            this.f62912j.setRepeatCount(-1);
            startAnimation(this.f62912j);
            return this.f62912j;
        }
        return (Animation) invokeCommon.objValue;
    }
}
