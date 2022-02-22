package com.baidu.tieba.pb.view;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.TypeEvaluator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PointF;
import android.net.Uri;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.LinearInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import c.a.d.f.p.n;
import c.a.u0.u2.z.f;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.ThirdStatisticHelper;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.core.util.tbselector.selector.DrawableSelector;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.pb.view.FallingView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.facebook.common.executors.CallerThreadExecutor;
import com.facebook.common.references.CloseableReference;
import com.facebook.datasource.DataSource;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.imagepipeline.datasource.BaseBitmapDataSubscriber;
import com.facebook.imagepipeline.image.CloseableImage;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ConcurrentLinkedQueue;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes13.dex */
public class FallingView extends FrameLayout {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int FIRST_CONTENT_TYPE = 0;
    public static final int REPLAY_CONTENT_TYPE = 1;
    public static final int SEND_REPLAY_TYPE = 2;
    public transient /* synthetic */ FieldHolder $fh;
    public k A;
    public final Runnable B;
    public final Runnable C;
    public View.OnClickListener D;

    /* renamed from: e  reason: collision with root package name */
    public TbImageView f47112e;

    /* renamed from: f  reason: collision with root package name */
    public View f47113f;

    /* renamed from: g  reason: collision with root package name */
    public View f47114g;

    /* renamed from: h  reason: collision with root package name */
    public View f47115h;

    /* renamed from: i  reason: collision with root package name */
    public TextView f47116i;

    /* renamed from: j  reason: collision with root package name */
    public final List<c.a.u0.u2.z.f> f47117j;
    public final Context k;
    public int l;
    public int m;
    public boolean n;
    public boolean o;
    public boolean p;
    public Paint q;
    public AnimatorSet r;
    public AnimatorSet s;
    public ValueAnimator t;
    public final ConcurrentLinkedQueue<l> u;
    public m v;
    public View w;
    public View x;
    public ImageView y;
    public TextView z;

    /* loaded from: classes13.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ FallingView f47118e;

        public a(FallingView fallingView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fallingView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f47118e = fallingView;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f47118e.invalidate();
            }
        }
    }

    /* loaded from: classes13.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ FallingView f47119e;

        public b(FallingView fallingView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fallingView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f47119e = fallingView;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f47119e.v();
            }
        }
    }

    /* loaded from: classes13.dex */
    public class c extends BaseBitmapDataSubscriber {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ TbPageContext f47120e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ c.a.t0.u.a f47121f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ int f47122g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ FallingView f47123h;

        public c(FallingView fallingView, TbPageContext tbPageContext, c.a.t0.u.a aVar, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fallingView, tbPageContext, aVar, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f47123h = fallingView;
            this.f47120e = tbPageContext;
            this.f47121f = aVar;
            this.f47122g = i2;
        }

        @Override // com.facebook.datasource.BaseDataSubscriber
        public void onFailureImpl(DataSource<CloseableReference<CloseableImage>> dataSource) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, dataSource) == null) {
            }
        }

        @Override // com.facebook.imagepipeline.datasource.BaseBitmapDataSubscriber
        public void onNewResultImpl(Bitmap bitmap) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bitmap) == null) {
                this.f47123h.z(this.f47120e, this.f47121f, bitmap, this.f47122g);
            }
        }
    }

    /* loaded from: classes13.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ TbPageContext f47124e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ c.a.t0.u.a f47125f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ int f47126g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ FallingView f47127h;

        public d(FallingView fallingView, TbPageContext tbPageContext, c.a.t0.u.a aVar, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fallingView, tbPageContext, aVar, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f47127h = fallingView;
            this.f47124e = tbPageContext;
            this.f47125f = aVar;
            this.f47126g = i2;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            c.a.t0.u.a aVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f47124e == null || (aVar = this.f47125f) == null) {
                return;
            }
            if (!UtilHelper.isMatchScheme(this.f47124e.getPageActivity(), aVar.g(), this.f47125f.f())) {
                TbPageContext tbPageContext = this.f47124e;
                c.a.u0.l4.a.a(tbPageContext, "http://tieba.baidu.com/mo/q/checkurl?url=" + c.a.d.f.p.m.getUrlEncode(this.f47125f.h()));
            }
            TiebaStatic.log(new StatisticItem("c14126").param("obj_type", this.f47126g).param("uid", TbadkCoreApplication.getCurrentAccount()));
            ThirdStatisticHelper.sendReq(this.f47125f.c());
        }
    }

    /* loaded from: classes13.dex */
    public class e implements ValueAnimator.AnimatorUpdateListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ FallingView f47128e;

        public e(FallingView fallingView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fallingView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f47128e = fallingView;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, valueAnimator) == null) {
                if (this.f47128e.f47114g.getVisibility() != 0) {
                    this.f47128e.f47114g.setVisibility(0);
                }
                int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                ViewGroup.LayoutParams layoutParams = this.f47128e.f47114g.getLayoutParams();
                layoutParams.width = intValue;
                this.f47128e.f47114g.setLayoutParams(layoutParams);
            }
        }
    }

    /* loaded from: classes13.dex */
    public class f extends AnimatorListenerAdapter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ FallingView f47129e;

        public f(FallingView fallingView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fallingView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f47129e = fallingView;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLZ(1048576, this, animator, z) == null) {
                this.f47129e.f47112e.setScaleX(1.0f);
                this.f47129e.f47112e.setScaleY(1.0f);
            }
        }
    }

    /* loaded from: classes13.dex */
    public class g extends AnimatorListenerAdapter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ FallingView f47130e;

        public g(FallingView fallingView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fallingView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f47130e = fallingView;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, animator) == null) {
                this.f47130e.u();
            }
        }
    }

    /* loaded from: classes13.dex */
    public class h extends AnimatorListenerAdapter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ FallingView f47131e;

        public h(FallingView fallingView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fallingView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f47131e = fallingView;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, animator) == null) || this.f47131e.t.isStarted() || this.f47131e.o) {
                return;
            }
            this.f47131e.t.start();
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, animator) == null) {
                this.f47131e.p = true;
            }
        }
    }

    /* loaded from: classes13.dex */
    public class i extends AnimatorListenerAdapter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ValueAnimator f47132e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ FallingView f47133f;

        public i(FallingView fallingView, ValueAnimator valueAnimator) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fallingView, valueAnimator};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f47133f = fallingView;
            this.f47132e = valueAnimator;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, animator) == null) {
                this.f47132e.cancel();
                this.f47133f.s.start();
            }
        }
    }

    /* loaded from: classes13.dex */
    public static class j implements TypeEvaluator<PointF> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final PointF a;

        /* renamed from: b  reason: collision with root package name */
        public final PointF f47134b;

        public j(PointF pointF, PointF pointF2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pointF, pointF2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = pointF;
            this.f47134b = pointF2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.animation.TypeEvaluator
        /* renamed from: a */
        public PointF evaluate(float f2, PointF pointF, PointF pointF2) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{Float.valueOf(f2), pointF, pointF2})) == null) {
                double d2 = 1.0f - f2;
                double d3 = f2;
                return new PointF((int) ((pointF.x * Math.pow(d2, 3.0d)) + (this.a.x * 3.0f * f2 * Math.pow(d2, 2.0d)) + (this.f47134b.x * 3.0f * Math.pow(d3, 2.0d) * d2) + (pointF2.x * Math.pow(d3, 3.0d))), (int) ((pointF.y * Math.pow(d2, 3.0d)) + (this.a.y * 3.0f * f2 * Math.pow(d2, 2.0d)) + (this.f47134b.y * 3.0f * Math.pow(d3, 2.0d) * d2) + (pointF2.y * Math.pow(d3, 3.0d))));
            }
            return (PointF) invokeCommon.objValue;
        }
    }

    /* loaded from: classes13.dex */
    public interface k {
        void onClick();
    }

    /* loaded from: classes13.dex */
    public static class l {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final c.a.t0.u.a a;

        /* renamed from: b  reason: collision with root package name */
        public final TbPageContext<?> f47135b;

        /* renamed from: c  reason: collision with root package name */
        public final int f47136c;

        public l(c.a.t0.u.a aVar, TbPageContext<?> tbPageContext, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, tbPageContext, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = aVar;
            this.f47135b = tbPageContext;
            this.f47136c = i2;
        }
    }

    /* loaded from: classes13.dex */
    public interface m {
        void onAnimationEnd();

        void onAnimationStart();
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public FallingView(@NonNull Context context) {
        this(context, null, 0);
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
                this((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public static /* synthetic */ float s(Random random) {
        return (random.nextInt(2) * 0.1f) + 0.8f;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, canvas) == null) {
            long currentTimeMillis = System.currentTimeMillis();
            super.dispatchDraw(canvas);
            if (this.f47117j.size() > 0) {
                this.o = false;
                for (int i2 = 0; i2 < this.f47117j.size(); i2++) {
                    this.o = this.f47117j.get(i2).b(canvas, this.q) || this.o;
                }
                if (this.o) {
                    postDelayed(this.B, (currentTimeMillis + 5) - System.currentTimeMillis());
                    return;
                }
                ValueAnimator valueAnimator = this.t;
                if (valueAnimator == null || valueAnimator.isStarted() || !this.p) {
                    return;
                }
                this.t.start();
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, motionEvent)) == null) {
            if (this.f47113f.getVisibility() != 0) {
                return super.dispatchTouchEvent(motionEvent);
            }
            if (motionEvent.getAction() == 0 && l(this.f47113f, motionEvent.getX(), motionEvent.getY())) {
                View.OnClickListener onClickListener = this.D;
                if (onClickListener != null) {
                    onClickListener.onClick(this.f47113f);
                    return true;
                }
                return true;
            }
            return super.dispatchTouchEvent(motionEvent);
        }
        return invokeL.booleanValue;
    }

    public View getAdLabelContainerView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.w : (View) invokeV.objValue;
    }

    public boolean isFalling() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.n : invokeV.booleanValue;
    }

    public final void j(c.a.u0.u2.z.f fVar, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048580, this, fVar, i2) == null) {
            if (this.l == 0) {
                this.l = n.k(this.k);
            }
            if (this.m == 0) {
                this.m = n.i(this.k);
            }
            this.f47117j.clear();
            for (int i3 = 0; i3 < i2; i3++) {
                c.a.u0.u2.z.f fVar2 = new c.a.u0.u2.z.f(fVar.f24178i, this.l, this.m);
                fVar2.f24174e = (-i3) * 180;
                this.f47117j.add(fVar2);
            }
        }
    }

    public final boolean k(c.a.t0.u.a aVar, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048581, this, aVar, i2)) == null) {
            if (aVar == null || StringHelper.isTaday(c.a.t0.s.j0.b.k().m("key_pb_falling_ad_feedback_click_time", 0L))) {
                return false;
            }
            try {
                if (i2 == 2) {
                    int l2 = c.a.t0.s.j0.b.k().l("key_pb_commont_egg_limlit_a", 0);
                    if (TbSingleton.getInstance().getAdVertiSementData() != null && l2 < TbSingleton.getInstance().getAdVertiSementData().a()) {
                        c.a.t0.s.j0.b.k().w("key_pb_commont_egg_limlit_a", l2 + 1);
                        return true;
                    }
                } else {
                    String q = c.a.t0.s.j0.b.k().q("key_pb_commont_egg_limlit_bc", new JSONObject().toString());
                    if (TextUtils.isEmpty(aVar.b())) {
                        return false;
                    }
                    JSONObject jSONObject = new JSONObject(q);
                    JSONArray jSONArray = new JSONArray();
                    JSONArray optJSONArray = jSONObject.optJSONArray(aVar.b());
                    if (optJSONArray != null) {
                        for (int i3 = 0; i3 < optJSONArray.length(); i3++) {
                            long optLong = optJSONArray.optLong(i3);
                            if (StringHelper.isTaday(optLong)) {
                                jSONArray.put(optLong);
                            }
                        }
                    }
                    if (TbSingleton.getInstance().getAdVertiSementData() != null && jSONArray.length() < TbSingleton.getInstance().getAdVertiSementData().b()) {
                        jSONArray.put(System.currentTimeMillis());
                        jSONObject.remove(aVar.b());
                        jSONObject.put(aVar.b(), jSONArray);
                        c.a.t0.s.j0.b.k().y("key_pb_commont_egg_limlit_bc", jSONObject.toString());
                        return true;
                    }
                }
            } catch (Exception e2) {
                BdLog.e(e2);
            }
            return false;
        }
        return invokeLI.booleanValue;
    }

    public final boolean l(View view, float f2, float f3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048582, this, new Object[]{view, Float.valueOf(f2), Float.valueOf(f3)})) == null) {
            float x = view.getX();
            float y = view.getY();
            return f2 >= x && f2 <= x + ((float) view.getWidth()) && f3 >= y && f3 <= y + ((float) view.getHeight());
        }
        return invokeCommon.booleanValue;
    }

    public final int m(View view) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, view)) == null) {
            view.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
            return view.getMeasuredWidth();
        }
        return invokeL.intValue;
    }

    public final void n(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, context) == null) {
            View inflate = LayoutInflater.from(context).inflate(c.a.u0.u2.j.falling_click_view, (ViewGroup) null, false);
            this.f47113f = inflate;
            this.f47114g = inflate.findViewById(c.a.u0.u2.i.expand_layout);
            this.f47115h = this.f47113f.findViewById(c.a.u0.u2.i.expand_image);
            this.f47116i = (TextView) this.f47113f.findViewById(c.a.u0.u2.i.expand_text);
            this.f47112e = (TbImageView) this.f47113f.findViewById(c.a.u0.u2.i.click_image);
            c.a.t0.s.v.c d2 = c.a.t0.s.v.c.d(this.f47114g);
            d2.n(c.a.u0.u2.l.J_X01);
            d2.f(c.a.u0.u2.f.CAM_X0608);
            c.a.t0.s.v.c d3 = c.a.t0.s.v.c.d(this.f47116i);
            d3.A(c.a.u0.u2.l.F_X01);
            d3.v(c.a.u0.u2.f.CAM_X0101);
            c.a.t0.s.v.c d4 = c.a.t0.s.v.c.d(this.f47115h);
            d4.n(c.a.u0.u2.l.J_X01);
            d4.f(c.a.u0.u2.f.CAM_X0317);
            ViewGroup.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
            this.f47112e.setConrers(15);
            this.f47112e.setPadding(n.f(context, c.a.u0.u2.g.tbds10), n.f(context, c.a.u0.u2.g.tbds5), n.f(context, c.a.u0.u2.g.tbds10), n.f(context, c.a.u0.u2.g.tbds5));
            this.f47112e.setPlaceHolder(2);
            addView(this.f47113f, layoutParams);
            View inflate2 = LayoutInflater.from(context).inflate(c.a.u0.u2.j.falling_ad_label, (ViewGroup) null, false);
            this.w = inflate2;
            this.x = inflate2.findViewById(c.a.u0.u2.i.ad_label_layout);
            this.y = (ImageView) this.w.findViewById(c.a.u0.u2.i.falling_ad_feedback_img);
            this.z = (TextView) this.w.findViewById(c.a.u0.u2.i.falling_ad_content);
            w();
            DrawableSelector.make().trRadius(n.f(getContext(), c.a.u0.u2.g.tbds26)).brRadius(n.f(getContext(), c.a.u0.u2.g.tbds26)).defaultColor(c.a.u0.u2.f.CAM_X0624).into(this.x);
            FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-2, -2);
            layoutParams2.gravity = 3;
            WebPManager.setPureDrawable(this.y, c.a.u0.u2.h.icon_falling_ad_close, c.a.u0.u2.f.CAM_X0101, null);
            c.a.t0.s.v.c.d(this.z).v(c.a.u0.u2.f.CAM_X0101);
            this.w.setY(n.i(this.k) - n.f(this.k, c.a.u0.u2.g.tbds720));
            addView(this.w, layoutParams2);
            Paint paint = new Paint();
            this.q = paint;
            paint.setDither(true);
            this.f47112e.setLayerType(1, null);
        }
    }

    public /* synthetic */ void o(ValueAnimator valueAnimator) {
        float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        TbImageView tbImageView = this.f47112e;
        tbImageView.setPivotX(tbImageView.getWidth() / 2);
        TbImageView tbImageView2 = this.f47112e;
        tbImageView2.setPivotY(tbImageView2.getHeight() / 2);
        this.f47112e.setScaleX(floatValue);
        this.f47112e.setScaleY(floatValue);
    }

    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048586, this, i2, i3) == null) {
            super.onMeasure(i2, i3);
            int t = t(1000, i3);
            int t2 = t(600, i2);
            setMeasuredDimension(t2, t);
            this.l = t2;
            this.m = t;
        }
    }

    public /* synthetic */ void p(ValueAnimator valueAnimator) {
        PointF pointF = (PointF) valueAnimator.getAnimatedValue();
        this.f47113f.setX(pointF.x);
        this.f47113f.setY(pointF.y);
    }

    public /* synthetic */ void q(ValueAnimator valueAnimator) {
        float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        TbImageView tbImageView = this.f47112e;
        tbImageView.setPivotX(tbImageView.getWidth() / 2);
        TbImageView tbImageView2 = this.f47112e;
        tbImageView2.setPivotY(tbImageView2.getHeight() / 2);
        this.f47112e.setScaleX(floatValue);
        this.f47112e.setScaleY(floatValue);
    }

    public /* synthetic */ void r(View view) {
        c.a.t0.s.j0.b.k().x("key_pb_falling_ad_feedback_click_time", System.currentTimeMillis());
        stopAllViews();
        k kVar = this.A;
        if (kVar != null) {
            kVar.onClick();
        }
    }

    public void setAnimationListener(m mVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, mVar) == null) {
            this.v = mVar;
        }
    }

    public void setFallingFeedbackListener(k kVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, kVar) == null) {
            this.A = kVar;
        }
    }

    public void startFalling(c.a.t0.u.a aVar, TbPageContext<?> tbPageContext, int i2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048592, this, new Object[]{aVar, tbPageContext, Integer.valueOf(i2), Boolean.valueOf(z)}) == null) {
            if (z) {
                stopAllViews();
                if (y(aVar, tbPageContext, i2)) {
                    x(aVar);
                    m mVar = this.v;
                    if (mVar != null) {
                        mVar.onAnimationStart();
                    }
                }
            } else if (this.n) {
                this.u.add(new l(aVar, tbPageContext, i2));
            } else if (y(aVar, tbPageContext, i2)) {
                x(aVar);
                m mVar2 = this.v;
                if (mVar2 != null) {
                    mVar2.onAnimationStart();
                }
            }
        }
    }

    public void stopAllViews() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            this.n = false;
            this.p = false;
            this.f47117j.clear();
            removeCallbacks(this.B);
            removeCallbacks(this.C);
            this.f47113f.setVisibility(8);
            this.f47114g.setVisibility(8);
            this.w.setVisibility(8);
            AnimatorSet animatorSet = this.r;
            if (animatorSet != null) {
                animatorSet.cancel();
            }
            AnimatorSet animatorSet2 = this.s;
            if (animatorSet2 != null) {
                animatorSet2.cancel();
            }
            ValueAnimator valueAnimator = this.t;
            if (valueAnimator != null) {
                valueAnimator.cancel();
            }
        }
    }

    public final int t(int i2, int i3) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(1048594, this, i2, i3)) == null) {
            int mode = View.MeasureSpec.getMode(i3);
            int size = View.MeasureSpec.getSize(i3);
            return mode == 1073741824 ? size : mode == Integer.MIN_VALUE ? Math.min(i2, size) : i2;
        }
        return invokeII.intValue;
    }

    public final void u() {
        m mVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            stopAllViews();
            l poll = this.u.poll();
            if (poll != null) {
                boolean y = y(poll.a, poll.f47135b, poll.f47136c);
                this.w.setVisibility(y ? 0 : 8);
                if (y) {
                    x(poll.a);
                } else {
                    this.w.setVisibility(8);
                }
                if (y || (mVar = this.v) == null) {
                    return;
                }
                mVar.onAnimationEnd();
                return;
            }
            m mVar2 = this.v;
            if (mVar2 != null) {
                mVar2.onAnimationEnd();
            }
        }
    }

    public final void v() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
            if (this.f47113f.getVisibility() != 0) {
                this.f47113f.setVisibility(0);
            }
            ValueAnimator ofFloat = ValueAnimator.ofFloat(1.0f, 1.2f);
            ofFloat.setDuration(600L);
            ofFloat.setRepeatMode(2);
            ofFloat.setRepeatCount(-1);
            ofFloat.setInterpolator(new AccelerateInterpolator());
            ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: c.a.u0.u2.z.b
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, valueAnimator) == null) {
                        FallingView.this.o(valueAnimator);
                    }
                }
            });
            int i2 = n.i(this.k);
            float k2 = n.k(this.k);
            PointF pointF = new PointF(((3.0f * k2) / 4.0f) - (this.f47112e.getWidth() / 2), (-i2) / 4.0f);
            float f2 = i2;
            ValueAnimator ofObject = ValueAnimator.ofObject(new j(new PointF(n.f(this.k, c.a.u0.u2.g.tbds50), n.f(this.k, c.a.u0.u2.g.tbds400)), new PointF((k2 / 2.0f) - n.f(this.k, c.a.u0.u2.g.tbds50), f2 - n.f(this.k, c.a.u0.u2.g.tbds655))), pointF, new PointF(n.f(this.k, c.a.u0.u2.g.tbds0), f2 - n.f(this.k, c.a.u0.u2.g.tbds552)));
            ofObject.setDuration(5000L);
            ofObject.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: c.a.u0.u2.z.d
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, valueAnimator) == null) {
                        FallingView.this.p(valueAnimator);
                    }
                }
            });
            ValueAnimator ofInt = ValueAnimator.ofInt(0, m(this.f47114g));
            ofInt.setInterpolator(new LinearInterpolator());
            ofInt.setDuration(500L);
            ofInt.addUpdateListener(new e(this));
            ValueAnimator ofFloat2 = ValueAnimator.ofFloat(1.0f, 0.8f);
            ofFloat2.setDuration(600L);
            ofFloat2.setInterpolator(new AccelerateInterpolator());
            ofFloat2.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: c.a.u0.u2.z.c
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, valueAnimator) == null) {
                        FallingView.this.q(valueAnimator);
                    }
                }
            });
            ofFloat2.addListener(new f(this));
            ValueAnimator valueAnimator = this.t;
            if (valueAnimator != null && valueAnimator.isStarted()) {
                this.t.cancel();
            }
            ValueAnimator ofInt2 = ValueAnimator.ofInt(0);
            this.t = ofInt2;
            ofInt2.setDuration(3000L);
            this.t.addListener(new g(this));
            AnimatorSet animatorSet = this.r;
            if (animatorSet != null && animatorSet.isStarted()) {
                this.r.cancel();
            }
            AnimatorSet animatorSet2 = this.s;
            if (animatorSet2 != null && animatorSet2.isStarted()) {
                this.s.cancel();
            }
            ofInt.addListener(new h(this));
            AnimatorSet animatorSet3 = new AnimatorSet();
            this.s = animatorSet3;
            animatorSet3.playSequentially(ofFloat2, ofInt);
            ofObject.addListener(new i(this, ofFloat));
            AnimatorSet animatorSet4 = new AnimatorSet();
            this.r = animatorSet4;
            animatorSet4.playTogether(ofObject, ofFloat);
            this.r.start();
        }
    }

    public final void w() {
        View view;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048597, this) == null) || (view = this.w) == null) {
            return;
        }
        view.setOnClickListener(new View.OnClickListener() { // from class: c.a.u0.u2.z.e
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, view2) == null) {
                    FallingView.this.r(view2);
                }
            }
        });
    }

    public final void x(c.a.t0.u.a aVar) {
        View view;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048598, this, aVar) == null) {
            if (aVar != null && !aVar.n() && (view = this.w) != null) {
                view.setVisibility(8);
                return;
            }
            View view2 = this.w;
            if (view2 != null) {
                view2.setVisibility(0);
            }
        }
    }

    public final boolean y(c.a.t0.u.a aVar, TbPageContext<?> tbPageContext, int i2) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(1048599, this, aVar, tbPageContext, i2)) == null) {
            if (k(aVar, i2)) {
                if (!StringUtils.isNull(aVar.d())) {
                    String d2 = aVar.d();
                    if (d2.length() > 10) {
                        d2 = d2.substring(0, 9) + "...";
                    }
                    this.f47116i.setText(d2);
                } else {
                    this.f47116i.setText(this.k.getString(c.a.u0.u2.l.check_immediately));
                }
                this.f47112e.startLoad(aVar.j(), 10, false);
                Fresco.getImagePipeline().fetchDecodedImage(ImageRequestBuilder.newBuilderWithSource(Uri.parse(aVar.i())).setProgressiveRenderingEnabled(true).build(), this.k).subscribe(new c(this, tbPageContext, aVar, i2), CallerThreadExecutor.getInstance());
                return true;
            }
            return false;
        }
        return invokeLLI.booleanValue;
    }

    public final void z(TbPageContext<?> tbPageContext, c.a.t0.u.a aVar, Bitmap bitmap, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLI(1048600, this, tbPageContext, aVar, bitmap, i2) == null) {
            final Random random = new Random();
            f.b bVar = new f.b(bitmap);
            bVar.p(n.f(TbadkCoreApplication.getInst(), c.a.u0.u2.g.tbds8), true);
            bVar.o(n.f(TbadkCoreApplication.getInst(), c.a.u0.u2.g.tbds200), n.f(TbadkCoreApplication.getInst(), c.a.u0.u2.g.tbds200), true);
            bVar.m(n.f(TbadkCoreApplication.getInst(), c.a.u0.u2.g.tbds100), n.f(TbadkCoreApplication.getInst(), c.a.u0.u2.g.tbds100));
            bVar.n(new f.c() { // from class: c.a.u0.u2.z.a
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // c.a.u0.u2.z.f.c
                public final float a() {
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    return (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) ? FallingView.s(random) : invokeV.floatValue;
                }
            });
            bVar.q(n.f(TbadkCoreApplication.getInst(), c.a.u0.u2.g.tbds40), true, true);
            j(bVar.l(), 19);
            postDelayed(this.C, 1500L);
            this.n = true;
            invalidate();
            TiebaStatic.log(new StatisticItem("c14125").param("obj_type", i2).param("uid", TbadkCoreApplication.getCurrentAccount()));
            ThirdStatisticHelper.sendReq(aVar.l());
            this.D = new d(this, tbPageContext, aVar, i2);
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public FallingView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
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
    public FallingView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i2) {
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
        this.f47117j = new ArrayList();
        this.n = false;
        this.o = false;
        this.p = false;
        this.u = new ConcurrentLinkedQueue<>();
        this.B = new a(this);
        this.C = new b(this);
        this.k = context;
        n(context);
    }
}
