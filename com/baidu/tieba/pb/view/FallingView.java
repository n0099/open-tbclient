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
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import c.a.d.f.p.m;
import c.a.s0.s2.z.e;
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
/* loaded from: classes12.dex */
public class FallingView extends FrameLayout {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int FIRST_CONTENT_TYPE = 0;
    public static final int REPLAY_CONTENT_TYPE = 1;
    public static final int SEND_REPLAY_TYPE = 2;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public TbImageView f48543e;

    /* renamed from: f  reason: collision with root package name */
    public View f48544f;

    /* renamed from: g  reason: collision with root package name */
    public View f48545g;

    /* renamed from: h  reason: collision with root package name */
    public View f48546h;

    /* renamed from: i  reason: collision with root package name */
    public TextView f48547i;

    /* renamed from: j  reason: collision with root package name */
    public TextView f48548j;

    /* renamed from: k  reason: collision with root package name */
    public final List<c.a.s0.s2.z.e> f48549k;
    public final Context l;
    public int m;
    public int n;
    public boolean o;
    public boolean p;
    public boolean q;
    public Paint r;
    public AnimatorSet s;
    public AnimatorSet t;
    public ValueAnimator u;
    public final ConcurrentLinkedQueue<k> v;
    public l w;
    public final Runnable x;
    public final Runnable y;
    public View.OnClickListener z;

    /* loaded from: classes12.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ FallingView f48550e;

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
            this.f48550e = fallingView;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f48550e.invalidate();
            }
        }
    }

    /* loaded from: classes12.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ FallingView f48551e;

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
            this.f48551e = fallingView;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f48551e.u();
            }
        }
    }

    /* loaded from: classes12.dex */
    public class c extends BaseBitmapDataSubscriber {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ TbPageContext f48552e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ c.a.r0.u.a f48553f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ int f48554g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ FallingView f48555h;

        public c(FallingView fallingView, TbPageContext tbPageContext, c.a.r0.u.a aVar, int i2) {
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
            this.f48555h = fallingView;
            this.f48552e = tbPageContext;
            this.f48553f = aVar;
            this.f48554g = i2;
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
                this.f48555h.w(this.f48552e, this.f48553f, bitmap, this.f48554g);
            }
        }
    }

    /* loaded from: classes12.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ TbPageContext f48556e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ c.a.r0.u.a f48557f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ int f48558g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ FallingView f48559h;

        public d(FallingView fallingView, TbPageContext tbPageContext, c.a.r0.u.a aVar, int i2) {
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
            this.f48559h = fallingView;
            this.f48556e = tbPageContext;
            this.f48557f = aVar;
            this.f48558g = i2;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            c.a.r0.u.a aVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f48556e == null || (aVar = this.f48557f) == null) {
                return;
            }
            if (!UtilHelper.isMatchScheme(this.f48556e.getPageActivity(), aVar.g(), this.f48557f.f())) {
                TbPageContext tbPageContext = this.f48556e;
                c.a.s0.h4.a.a(tbPageContext, "http://tieba.baidu.com/mo/q/checkurl?url=" + c.a.d.f.p.l.getUrlEncode(this.f48557f.h()));
            }
            TiebaStatic.log(new StatisticItem("c14126").param("obj_type", this.f48558g).param("uid", TbadkCoreApplication.getCurrentAccount()));
            ThirdStatisticHelper.sendReq(this.f48557f.c());
        }
    }

    /* loaded from: classes12.dex */
    public class e implements ValueAnimator.AnimatorUpdateListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ FallingView f48560e;

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
            this.f48560e = fallingView;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, valueAnimator) == null) {
                if (this.f48560e.f48545g.getVisibility() != 0) {
                    this.f48560e.f48545g.setVisibility(0);
                }
                int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                ViewGroup.LayoutParams layoutParams = this.f48560e.f48545g.getLayoutParams();
                layoutParams.width = intValue;
                this.f48560e.f48545g.setLayoutParams(layoutParams);
            }
        }
    }

    /* loaded from: classes12.dex */
    public class f extends AnimatorListenerAdapter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ FallingView f48561e;

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
            this.f48561e = fallingView;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLZ(1048576, this, animator, z) == null) {
                this.f48561e.f48543e.setScaleX(1.0f);
                this.f48561e.f48543e.setScaleY(1.0f);
            }
        }
    }

    /* loaded from: classes12.dex */
    public class g extends AnimatorListenerAdapter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ FallingView f48562e;

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
            this.f48562e = fallingView;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, animator) == null) {
                this.f48562e.t();
            }
        }
    }

    /* loaded from: classes12.dex */
    public class h extends AnimatorListenerAdapter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ FallingView f48563e;

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
            this.f48563e = fallingView;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, animator) == null) || this.f48563e.u.isStarted() || this.f48563e.p) {
                return;
            }
            this.f48563e.u.start();
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, animator) == null) {
                this.f48563e.q = true;
            }
        }
    }

    /* loaded from: classes12.dex */
    public class i extends AnimatorListenerAdapter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ValueAnimator f48564e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ FallingView f48565f;

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
            this.f48565f = fallingView;
            this.f48564e = valueAnimator;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, animator) == null) {
                this.f48564e.cancel();
                this.f48565f.t.start();
            }
        }
    }

    /* loaded from: classes12.dex */
    public static class j implements TypeEvaluator<PointF> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final PointF a;

        /* renamed from: b  reason: collision with root package name */
        public final PointF f48566b;

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
            this.f48566b = pointF2;
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
                return new PointF((int) ((pointF.x * Math.pow(d2, 3.0d)) + (this.a.x * 3.0f * f2 * Math.pow(d2, 2.0d)) + (this.f48566b.x * 3.0f * Math.pow(d3, 2.0d) * d2) + (pointF2.x * Math.pow(d3, 3.0d))), (int) ((pointF.y * Math.pow(d2, 3.0d)) + (this.a.y * 3.0f * f2 * Math.pow(d2, 2.0d)) + (this.f48566b.y * 3.0f * Math.pow(d3, 2.0d) * d2) + (pointF2.y * Math.pow(d3, 3.0d))));
            }
            return (PointF) invokeCommon.objValue;
        }
    }

    /* loaded from: classes12.dex */
    public static class k {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final c.a.r0.u.a a;

        /* renamed from: b  reason: collision with root package name */
        public final TbPageContext<?> f48567b;

        /* renamed from: c  reason: collision with root package name */
        public final int f48568c;

        public k(c.a.r0.u.a aVar, TbPageContext<?> tbPageContext, int i2) {
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
            this.f48567b = tbPageContext;
            this.f48568c = i2;
        }
    }

    /* loaded from: classes12.dex */
    public interface l {
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

    public static /* synthetic */ float r(Random random) {
        return (random.nextInt(2) * 0.1f) + 0.8f;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, canvas) == null) {
            long currentTimeMillis = System.currentTimeMillis();
            super.dispatchDraw(canvas);
            if (this.f48549k.size() > 0) {
                this.p = false;
                for (int i2 = 0; i2 < this.f48549k.size(); i2++) {
                    this.p = this.f48549k.get(i2).b(canvas, this.r) || this.p;
                }
                if (this.p) {
                    postDelayed(this.x, (currentTimeMillis + 5) - System.currentTimeMillis());
                    return;
                }
                ValueAnimator valueAnimator = this.u;
                if (valueAnimator == null || valueAnimator.isStarted() || !this.q) {
                    return;
                }
                this.u.start();
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, motionEvent)) == null) {
            if (this.f48544f.getVisibility() != 0) {
                return super.dispatchTouchEvent(motionEvent);
            }
            if (motionEvent.getAction() == 0 && l(this.f48544f, motionEvent.getX(), motionEvent.getY())) {
                View.OnClickListener onClickListener = this.z;
                if (onClickListener != null) {
                    onClickListener.onClick(this.f48544f);
                    return true;
                }
                return true;
            }
            return super.dispatchTouchEvent(motionEvent);
        }
        return invokeL.booleanValue;
    }

    public boolean isFalling() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.o : invokeV.booleanValue;
    }

    public final void j(c.a.s0.s2.z.e eVar, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048579, this, eVar, i2) == null) {
            if (this.m == 0) {
                this.m = m.k(this.l);
            }
            if (this.n == 0) {
                this.n = m.i(this.l);
            }
            this.f48549k.clear();
            for (int i3 = 0; i3 < i2; i3++) {
                c.a.s0.s2.z.e eVar2 = new c.a.s0.s2.z.e(eVar.f23558i, this.m, this.n);
                eVar2.f23554e = (-i3) * 180;
                this.f48549k.add(eVar2);
            }
        }
    }

    public final boolean k(c.a.r0.u.a aVar, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048580, this, aVar, i2)) == null) {
            if (aVar == null) {
                return false;
            }
            try {
                if (i2 == 2) {
                    int k2 = c.a.r0.s.g0.b.j().k("key_pb_commont_egg_limlit_a", 0);
                    if (TbSingleton.getInstance().getAdVertiSementData() != null && k2 < TbSingleton.getInstance().getAdVertiSementData().a()) {
                        c.a.r0.s.g0.b.j().v("key_pb_commont_egg_limlit_a", k2 + 1);
                        return true;
                    }
                } else {
                    String p = c.a.r0.s.g0.b.j().p("key_pb_commont_egg_limlit_bc", new JSONObject().toString());
                    if (TextUtils.isEmpty(aVar.b())) {
                        return false;
                    }
                    JSONObject jSONObject = new JSONObject(p);
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
                        c.a.r0.s.g0.b.j().x("key_pb_commont_egg_limlit_bc", jSONObject.toString());
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
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048581, this, new Object[]{view, Float.valueOf(f2), Float.valueOf(f3)})) == null) {
            float x = view.getX();
            float y = view.getY();
            return f2 >= x && f2 <= x + ((float) view.getWidth()) && f3 >= y && f3 <= y + ((float) view.getHeight());
        }
        return invokeCommon.booleanValue;
    }

    public final int m(View view) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, view)) == null) {
            view.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
            return view.getMeasuredWidth();
        }
        return invokeL.intValue;
    }

    public final void n(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, context) == null) {
            View inflate = LayoutInflater.from(context).inflate(c.a.s0.s2.j.falling_click_view, (ViewGroup) null, false);
            this.f48544f = inflate;
            this.f48545g = inflate.findViewById(c.a.s0.s2.i.expand_layout);
            this.f48546h = this.f48544f.findViewById(c.a.s0.s2.i.expand_image);
            this.f48547i = (TextView) this.f48544f.findViewById(c.a.s0.s2.i.expand_text);
            this.f48543e = (TbImageView) this.f48544f.findViewById(c.a.s0.s2.i.click_image);
            c.a.r0.s.v.c d2 = c.a.r0.s.v.c.d(this.f48545g);
            d2.n(c.a.s0.s2.l.J_X01);
            d2.f(c.a.s0.s2.f.CAM_X0608);
            c.a.r0.s.v.c d3 = c.a.r0.s.v.c.d(this.f48547i);
            d3.A(c.a.s0.s2.l.F_X01);
            d3.v(c.a.s0.s2.f.CAM_X0101);
            c.a.r0.s.v.c d4 = c.a.r0.s.v.c.d(this.f48546h);
            d4.n(c.a.s0.s2.l.J_X01);
            d4.f(c.a.s0.s2.f.CAM_X0317);
            ViewGroup.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
            this.f48543e.setConrers(15);
            this.f48543e.setPadding(m.f(context, c.a.s0.s2.g.tbds10), m.f(context, c.a.s0.s2.g.tbds5), m.f(context, c.a.s0.s2.g.tbds10), m.f(context, c.a.s0.s2.g.tbds5));
            this.f48543e.setPlaceHolder(2);
            addView(this.f48544f, layoutParams);
            TextView textView = new TextView(context);
            this.f48548j = textView;
            textView.setGravity(17);
            this.f48548j.setIncludeFontPadding(false);
            this.f48548j.setText(c.a.s0.s2.l.advert_label);
            this.f48548j.setPadding(m.f(context, c.a.s0.s2.g.M_W_X004), m.f(context, c.a.s0.s2.g.L_X05), m.f(context, c.a.s0.s2.g.M_W_X004), m.f(context, c.a.s0.s2.g.L_X05));
            c.a.r0.s.v.c d5 = c.a.r0.s.v.c.d(this.f48548j);
            d5.n(c.a.s0.s2.l.J_X15);
            d5.v(c.a.s0.s2.f.CAM_X0101);
            d5.z(c.a.s0.s2.g.T_X09);
            d5.f(c.a.s0.s2.f.CAM_X0902);
            FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-2, -2);
            this.f48548j.setVisibility(8);
            layoutParams2.gravity = 85;
            layoutParams2.bottomMargin = m.f(context, c.a.s0.s2.g.tbds144);
            addView(this.f48548j, layoutParams2);
            Paint paint = new Paint();
            this.r = paint;
            paint.setDither(true);
            this.f48543e.setLayerType(1, null);
        }
    }

    public /* synthetic */ void o(ValueAnimator valueAnimator) {
        float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        TbImageView tbImageView = this.f48543e;
        tbImageView.setPivotX(tbImageView.getWidth() / 2);
        TbImageView tbImageView2 = this.f48543e;
        tbImageView2.setPivotY(tbImageView2.getHeight() / 2);
        this.f48543e.setScaleX(floatValue);
        this.f48543e.setScaleY(floatValue);
    }

    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048585, this, i2, i3) == null) {
            super.onMeasure(i2, i3);
            int s = s(1000, i3);
            int s2 = s(600, i2);
            setMeasuredDimension(s2, s);
            this.m = s2;
            this.n = s;
        }
    }

    public /* synthetic */ void p(ValueAnimator valueAnimator) {
        PointF pointF = (PointF) valueAnimator.getAnimatedValue();
        this.f48544f.setX(pointF.x);
        this.f48544f.setY(pointF.y);
    }

    public /* synthetic */ void q(ValueAnimator valueAnimator) {
        float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        TbImageView tbImageView = this.f48543e;
        tbImageView.setPivotX(tbImageView.getWidth() / 2);
        TbImageView tbImageView2 = this.f48543e;
        tbImageView2.setPivotY(tbImageView2.getHeight() / 2);
        this.f48543e.setScaleX(floatValue);
        this.f48543e.setScaleY(floatValue);
    }

    public final int s(int i2, int i3) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(1048588, this, i2, i3)) == null) {
            int mode = View.MeasureSpec.getMode(i3);
            int size = View.MeasureSpec.getSize(i3);
            return mode == 1073741824 ? size : mode == Integer.MIN_VALUE ? Math.min(i2, size) : i2;
        }
        return invokeII.intValue;
    }

    public void setAnimationListener(l lVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, lVar) == null) {
            this.w = lVar;
        }
    }

    public void startFalling(c.a.r0.u.a aVar, TbPageContext<?> tbPageContext, int i2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048590, this, new Object[]{aVar, tbPageContext, Integer.valueOf(i2), Boolean.valueOf(z)}) == null) {
            if (z) {
                stopAllViews();
                if (v(aVar, tbPageContext, i2)) {
                    this.f48548j.setVisibility(0);
                    l lVar = this.w;
                    if (lVar != null) {
                        lVar.onAnimationStart();
                    }
                }
            } else if (this.o) {
                this.v.add(new k(aVar, tbPageContext, i2));
            } else if (v(aVar, tbPageContext, i2)) {
                this.f48548j.setVisibility(0);
                l lVar2 = this.w;
                if (lVar2 != null) {
                    lVar2.onAnimationStart();
                }
            }
        }
    }

    public void stopAllViews() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            this.o = false;
            this.q = false;
            this.f48549k.clear();
            removeCallbacks(this.x);
            removeCallbacks(this.y);
            this.f48544f.setVisibility(8);
            this.f48545g.setVisibility(8);
            this.f48548j.setVisibility(8);
            AnimatorSet animatorSet = this.s;
            if (animatorSet != null) {
                animatorSet.cancel();
            }
            AnimatorSet animatorSet2 = this.t;
            if (animatorSet2 != null) {
                animatorSet2.cancel();
            }
            ValueAnimator valueAnimator = this.u;
            if (valueAnimator != null) {
                valueAnimator.cancel();
            }
        }
    }

    public final void t() {
        l lVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            stopAllViews();
            k poll = this.v.poll();
            if (poll != null) {
                boolean v = v(poll.a, poll.f48567b, poll.f48568c);
                this.f48548j.setVisibility(v ? 0 : 8);
                if (v || (lVar = this.w) == null) {
                    return;
                }
                lVar.onAnimationEnd();
                return;
            }
            l lVar2 = this.w;
            if (lVar2 != null) {
                lVar2.onAnimationEnd();
            }
        }
    }

    public final void u() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            if (this.f48544f.getVisibility() != 0) {
                this.f48544f.setVisibility(0);
            }
            ValueAnimator ofFloat = ValueAnimator.ofFloat(1.0f, 1.2f);
            ofFloat.setDuration(600L);
            ofFloat.setRepeatMode(2);
            ofFloat.setRepeatCount(-1);
            ofFloat.setInterpolator(new AccelerateInterpolator());
            ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: c.a.s0.s2.z.c
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
            int i2 = m.i(this.l);
            float k2 = m.k(this.l);
            PointF pointF = new PointF(((3.0f * k2) / 4.0f) - (this.f48543e.getWidth() / 2), (-i2) / 4.0f);
            float f2 = i2;
            ValueAnimator ofObject = ValueAnimator.ofObject(new j(new PointF(m.f(this.l, c.a.s0.s2.g.tbds50), m.f(this.l, c.a.s0.s2.g.tbds400)), new PointF((k2 / 2.0f) - m.f(this.l, c.a.s0.s2.g.tbds50), f2 - m.f(this.l, c.a.s0.s2.g.tbds655))), pointF, new PointF(m.f(this.l, c.a.s0.s2.g.tbds0), f2 - m.f(this.l, c.a.s0.s2.g.tbds552)));
            ofObject.setDuration(5000L);
            ofObject.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: c.a.s0.s2.z.d
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
            ValueAnimator ofInt = ValueAnimator.ofInt(0, m(this.f48545g));
            ofInt.setInterpolator(new LinearInterpolator());
            ofInt.setDuration(500L);
            ofInt.addUpdateListener(new e(this));
            ValueAnimator ofFloat2 = ValueAnimator.ofFloat(1.0f, 0.8f);
            ofFloat2.setDuration(600L);
            ofFloat2.setInterpolator(new AccelerateInterpolator());
            ofFloat2.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: c.a.s0.s2.z.b
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
            ValueAnimator valueAnimator = this.u;
            if (valueAnimator != null && valueAnimator.isStarted()) {
                this.u.cancel();
            }
            ValueAnimator ofInt2 = ValueAnimator.ofInt(0);
            this.u = ofInt2;
            ofInt2.setDuration(3000L);
            this.u.addListener(new g(this));
            AnimatorSet animatorSet = this.s;
            if (animatorSet != null && animatorSet.isStarted()) {
                this.s.cancel();
            }
            AnimatorSet animatorSet2 = this.t;
            if (animatorSet2 != null && animatorSet2.isStarted()) {
                this.t.cancel();
            }
            ofInt.addListener(new h(this));
            AnimatorSet animatorSet3 = new AnimatorSet();
            this.t = animatorSet3;
            animatorSet3.playSequentially(ofFloat2, ofInt);
            ofObject.addListener(new i(this, ofFloat));
            AnimatorSet animatorSet4 = new AnimatorSet();
            this.s = animatorSet4;
            animatorSet4.playTogether(ofObject, ofFloat);
            this.s.start();
        }
    }

    public final boolean v(c.a.r0.u.a aVar, TbPageContext<?> tbPageContext, int i2) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(1048594, this, aVar, tbPageContext, i2)) == null) {
            if (k(aVar, i2)) {
                if (!StringUtils.isNull(aVar.d())) {
                    String d2 = aVar.d();
                    if (d2.length() > 10) {
                        d2 = d2.substring(0, 9) + "...";
                    }
                    this.f48547i.setText(d2);
                } else {
                    this.f48547i.setText(this.l.getString(c.a.s0.s2.l.check_immediately));
                }
                this.f48543e.startLoad(aVar.j(), 10, false);
                Fresco.getImagePipeline().fetchDecodedImage(ImageRequestBuilder.newBuilderWithSource(Uri.parse(aVar.i())).setProgressiveRenderingEnabled(true).build(), this.l).subscribe(new c(this, tbPageContext, aVar, i2), CallerThreadExecutor.getInstance());
                return true;
            }
            return false;
        }
        return invokeLLI.booleanValue;
    }

    public final void w(TbPageContext<?> tbPageContext, c.a.r0.u.a aVar, Bitmap bitmap, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLI(1048595, this, tbPageContext, aVar, bitmap, i2) == null) {
            final Random random = new Random();
            e.b bVar = new e.b(bitmap);
            bVar.p(m.f(TbadkCoreApplication.getInst(), c.a.s0.s2.g.tbds8), true);
            bVar.o(m.f(TbadkCoreApplication.getInst(), c.a.s0.s2.g.tbds200), m.f(TbadkCoreApplication.getInst(), c.a.s0.s2.g.tbds200), true);
            bVar.m(m.f(TbadkCoreApplication.getInst(), c.a.s0.s2.g.tbds100), m.f(TbadkCoreApplication.getInst(), c.a.s0.s2.g.tbds100));
            bVar.n(new e.c() { // from class: c.a.s0.s2.z.a
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // c.a.s0.s2.z.e.c
                public final float a() {
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    return (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) ? FallingView.r(random) : invokeV.floatValue;
                }
            });
            bVar.q(m.f(TbadkCoreApplication.getInst(), c.a.s0.s2.g.tbds40), true, true);
            j(bVar.l(), 19);
            postDelayed(this.y, 1500L);
            this.o = true;
            invalidate();
            TiebaStatic.log(new StatisticItem("c14125").param("obj_type", i2).param("uid", TbadkCoreApplication.getCurrentAccount()));
            ThirdStatisticHelper.sendReq(aVar.l());
            this.z = new d(this, tbPageContext, aVar, i2);
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
        this.f48549k = new ArrayList();
        this.o = false;
        this.p = false;
        this.q = false;
        this.v = new ConcurrentLinkedQueue<>();
        this.x = new a(this);
        this.y = new b(this);
        this.l = context;
        n(context);
    }
}
