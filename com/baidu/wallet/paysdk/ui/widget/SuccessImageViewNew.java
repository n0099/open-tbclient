package com.baidu.wallet.paysdk.ui.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.view.animation.Transformation;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bumptech.glide.load.engine.GlideException;
import com.dxmpay.apollon.utils.ResUtils;
/* loaded from: classes10.dex */
public class SuccessImageViewNew extends View {
    public static /* synthetic */ Interceptable $ic = null;
    public static int ALLDegree = 359;
    public static int StatD = 310;
    public static String TAG = "SuccessImageViewNew";
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public PathMeasure f60502a;

    /* renamed from: b  reason: collision with root package name */
    public PathMeasure f60503b;

    /* renamed from: c  reason: collision with root package name */
    public Animation f60504c;

    /* renamed from: d  reason: collision with root package name */
    public Animation f60505d;

    /* renamed from: e  reason: collision with root package name */
    public Paint f60506e;

    /* renamed from: f  reason: collision with root package name */
    public float f60507f;

    /* renamed from: g  reason: collision with root package name */
    public float f60508g;

    /* renamed from: h  reason: collision with root package name */
    public float f60509h;

    /* renamed from: i  reason: collision with root package name */
    public float f60510i;
    public final RectF j;
    public Path k;
    public Path l;
    public Path m;
    public int n;
    public int o;
    public a p;

    /* loaded from: classes10.dex */
    public interface a {
        void a();
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-742756419, "Lcom/baidu/wallet/paysdk/ui/widget/SuccessImageViewNew;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-742756419, "Lcom/baidu/wallet/paysdk/ui/widget/SuccessImageViewNew;");
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SuccessImageViewNew(Context context) {
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
        this.f60502a = new PathMeasure();
        this.f60503b = new PathMeasure();
        this.j = new RectF();
        this.k = new Path();
        this.n = 0;
        this.o = StatD / ALLDegree;
        this.p = null;
        a();
    }

    public int dip2px(float f2) {
        InterceptResult invokeF;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeF = interceptable.invokeF(1048576, this, f2)) == null) ? (int) ((f2 * getContext().getResources().getDisplayMetrics().density) + 0.5f) : invokeF.intValue;
    }

    @Override // android.view.View
    public void onDetachedFromWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            super.onDetachedFromWindow();
            stopAnim();
        }
    }

    @Override // android.view.View
    @SuppressLint({"DrawAllocation"})
    public void onDraw(Canvas canvas) {
        Path path;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, canvas) == null) {
            super.onDraw(canvas);
            if (this.f60509h == 0.0f) {
                return;
            }
            if (this.n == 1 && (path = this.m) != null) {
                canvas.drawPath(path, this.f60506e);
            }
            canvas.drawPath(this.k, this.f60506e);
            canvas.save();
        }
    }

    @Override // android.view.View
    public void onMeasure(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048579, this, i2, i3) == null) {
            super.onMeasure(i2, i3);
            if (getMeasuredWidth() > getMeasuredHeight()) {
                this.f60509h = getMeasuredHeight();
            } else {
                this.f60509h = getMeasuredWidth();
            }
            float f2 = this.f60509h;
            this.f60507f = f2 / 2.0f;
            this.f60508g = f2 / 2.0f;
            this.f60510i = (f2 - dip2px(4.0f)) / 2.0f;
            b();
        }
    }

    public void startAnimation(a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, aVar) == null) {
            stopAnim();
            this.p = aVar;
            a(0.0f, 1.0f, 250L);
        }
    }

    public void stopAnim() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            clearAnimation();
        }
    }

    private void b() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65547, this) == null) || this.f60509h == 0.0f) {
            return;
        }
        if (this.l == null) {
            RectF rectF = this.j;
            float f2 = this.f60507f;
            float f3 = this.f60510i;
            rectF.left = f2 - f3;
            float f4 = this.f60508g;
            rectF.top = f4 - f3;
            rectF.right = f2 + f3;
            rectF.bottom = f4 + f3;
            Path path = new Path();
            this.l = path;
            path.addArc(this.j, 0.0f, 320.0f);
            this.l.rLineTo(0.0f, 0.0f);
            this.f60503b = new PathMeasure(this.l, false);
        }
        if (this.m == null) {
            PathMeasure pathMeasure = new PathMeasure(this.l, true);
            String str = "path1 len" + pathMeasure.getLength();
            float[] fArr = new float[2];
            pathMeasure.getPosTan((pathMeasure.getLength() * 320.0f) / 359.0f, fArr, null);
            String str2 = "path1 pos" + fArr[0] + GlideException.IndentedAppendable.INDENT + fArr[1];
            Path path2 = new Path();
            this.m = path2;
            float f5 = (this.f60510i * 3.0f) / 7.0f;
            path2.moveTo(this.f60507f - f5, this.f60508g - ((2.0f * f5) / 5.0f));
            this.m.lineTo(this.f60507f, this.f60508g + ((f5 * 3.0f) / 5.0f));
            this.m.rMoveTo(0.0f, 0.0f);
            this.m.lineTo(fArr[0], fArr[1]);
            this.f60502a = new PathMeasure(this.m, false);
        }
    }

    private void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65543, this) == null) {
            Paint paint = new Paint();
            this.f60506e = paint;
            paint.setAntiAlias(true);
            this.f60506e.setColor(ResUtils.getColor(getContext(), "wallet_fp_main_327de7"));
            this.f60506e.setStrokeWidth(dip2px(4.0f));
            this.f60506e.setStyle(Paint.Style.STROKE);
            this.f60506e.setStrokeJoin(Paint.Join.ROUND);
            this.f60506e.setStrokeCap(Paint.Cap.ROUND);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SuccessImageViewNew(Context context, AttributeSet attributeSet) {
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
        this.f60502a = new PathMeasure();
        this.f60503b = new PathMeasure();
        this.j = new RectF();
        this.k = new Path();
        this.n = 0;
        this.o = StatD / ALLDegree;
        this.p = null;
        a();
    }

    private void a(float f2, float f3, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65544, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3), Long.valueOf(j)}) == null) {
            Animation animation = new Animation(this) { // from class: com.baidu.wallet.paysdk.ui.widget.SuccessImageViewNew.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ SuccessImageViewNew f60511a;

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
                    this.f60511a = this;
                }

                @Override // android.view.animation.Animation
                public void applyTransformation(float f4, Transformation transformation) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeCommon(1048576, this, new Object[]{Float.valueOf(f4), transformation}) == null) {
                        SuccessImageViewNew successImageViewNew = this.f60511a;
                        if (successImageViewNew.f60504c != null) {
                            successImageViewNew.k.reset();
                            float length = this.f60511a.f60502a.getLength();
                            float f5 = f4 * length;
                            SuccessImageViewNew successImageViewNew2 = this.f60511a;
                            successImageViewNew2.f60502a.getSegment(0.0f, f5, successImageViewNew2.k, true);
                            String str = SuccessImageViewNew.TAG;
                            String str2 = "length " + length + "currentLength " + f5;
                            this.f60511a.k.rLineTo(0.0f, 0.0f);
                        }
                        this.f60511a.invalidate();
                    }
                }
            };
            this.f60504c = animation;
            animation.setAnimationListener(new Animation.AnimationListener(this, j) { // from class: com.baidu.wallet.paysdk.ui.widget.SuccessImageViewNew.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ long f60512a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ SuccessImageViewNew f60513b;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, Long.valueOf(j)};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f60513b = this;
                    this.f60512a = j;
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, animation2) == null) {
                        this.f60513b.n = 1;
                        this.f60513b.b(0.0f, 1.0f, this.f60512a);
                    }
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation animation2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, animation2) == null) {
                    }
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(Animation animation2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_SEND_USER_MSG, this, animation2) == null) {
                    }
                }
            });
            this.f60504c.setInterpolator(new AccelerateDecelerateInterpolator());
            this.f60504c.setDuration(j);
            this.f60504c.setRepeatCount(0);
            startAnimation(this.f60504c);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SuccessImageViewNew(Context context, AttributeSet attributeSet, int i2) {
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
        this.f60502a = new PathMeasure();
        this.f60503b = new PathMeasure();
        this.j = new RectF();
        this.k = new Path();
        this.n = 0;
        this.o = StatD / ALLDegree;
        this.p = null;
        a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(float f2, float f3, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65548, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3), Long.valueOf(j)}) == null) {
            Animation animation = new Animation(this) { // from class: com.baidu.wallet.paysdk.ui.widget.SuccessImageViewNew.3
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ SuccessImageViewNew f60514a;

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
                    this.f60514a = this;
                }

                @Override // android.view.animation.Animation
                public void applyTransformation(float f4, Transformation transformation) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeCommon(1048576, this, new Object[]{Float.valueOf(f4), transformation}) == null) {
                        SuccessImageViewNew successImageViewNew = this.f60514a;
                        if (successImageViewNew.f60505d != null) {
                            successImageViewNew.k.reset();
                            float length = this.f60514a.f60503b.getLength();
                            float f5 = f4 * length;
                            SuccessImageViewNew successImageViewNew2 = this.f60514a;
                            successImageViewNew2.f60503b.getSegment(length - f5, length, successImageViewNew2.k, true);
                            String str = SuccessImageViewNew.TAG;
                            String str2 = "length " + length + "currentLengthCircle " + f5;
                            this.f60514a.k.rLineTo(0.0f, 0.0f);
                        }
                        this.f60514a.invalidate();
                    }
                }
            };
            this.f60505d = animation;
            animation.setAnimationListener(new Animation.AnimationListener(this) { // from class: com.baidu.wallet.paysdk.ui.widget.SuccessImageViewNew.4
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ SuccessImageViewNew f60515a;

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
                    this.f60515a = this;
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation2) {
                    Interceptable interceptable2 = $ic;
                    if (!(interceptable2 == null || interceptable2.invokeL(1048576, this, animation2) == null) || this.f60515a.p == null) {
                        return;
                    }
                    this.f60515a.p.a();
                    this.f60515a.p = null;
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation animation2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, animation2) == null) {
                    }
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(Animation animation2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_SEND_USER_MSG, this, animation2) == null) {
                    }
                }
            });
            this.f60505d.setInterpolator(new LinearInterpolator());
            this.f60505d.setDuration(j);
            this.f60505d.setRepeatCount(0);
            startAnimation(this.f60505d);
        }
    }
}
