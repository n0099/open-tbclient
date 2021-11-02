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
import b.a.r0.k2.z.e;
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
import com.baidu.tbadk.core.util.UrlManager;
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
/* loaded from: classes9.dex */
public class FallingView extends FrameLayout {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int FIRST_CONTENT_TYPE = 0;
    public static final int REPLAY_CONTENT_TYPE = 1;
    public static final int SEND_REPLAY_TYPE = 2;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public TbImageView f52865e;

    /* renamed from: f  reason: collision with root package name */
    public View f52866f;

    /* renamed from: g  reason: collision with root package name */
    public View f52867g;

    /* renamed from: h  reason: collision with root package name */
    public View f52868h;

    /* renamed from: i  reason: collision with root package name */
    public TextView f52869i;
    public final List<b.a.r0.k2.z.e> j;
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
    public final ConcurrentLinkedQueue<k> u;
    public l v;
    public final Runnable w;
    public final Runnable x;
    public View.OnClickListener y;

    /* loaded from: classes9.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ FallingView f52870e;

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
            this.f52870e = fallingView;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f52870e.invalidate();
            }
        }
    }

    /* loaded from: classes9.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ FallingView f52871e;

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
            this.f52871e = fallingView;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f52871e.u();
            }
        }
    }

    /* loaded from: classes9.dex */
    public class c extends BaseBitmapDataSubscriber {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ TbPageContext f52872a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ b.a.q0.u.a f52873b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ int f52874c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ FallingView f52875d;

        public c(FallingView fallingView, TbPageContext tbPageContext, b.a.q0.u.a aVar, int i2) {
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
            this.f52875d = fallingView;
            this.f52872a = tbPageContext;
            this.f52873b = aVar;
            this.f52874c = i2;
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
                this.f52875d.w(this.f52872a, this.f52873b, bitmap, this.f52874c);
            }
        }
    }

    /* loaded from: classes9.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ TbPageContext f52876e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ b.a.q0.u.a f52877f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ int f52878g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ FallingView f52879h;

        public d(FallingView fallingView, TbPageContext tbPageContext, b.a.q0.u.a aVar, int i2) {
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
            this.f52879h = fallingView;
            this.f52876e = tbPageContext;
            this.f52877f = aVar;
            this.f52878g = i2;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            b.a.q0.u.a aVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f52876e == null || (aVar = this.f52877f) == null) {
                return;
            }
            if (!UtilHelper.isMatchScheme(this.f52876e.getPageActivity(), aVar.g(), this.f52877f.f())) {
                UrlManager urlManager = UrlManager.getInstance();
                TbPageContext<?> tbPageContext = this.f52876e;
                urlManager.dealOneLink(tbPageContext, new String[]{"http://tieba.baidu.com/mo/q/checkurl?url=" + b.a.e.e.p.k.getUrlEncode(this.f52877f.h())});
            }
            TiebaStatic.log(new StatisticItem("c14126").param("obj_type", this.f52878g).param("uid", TbadkCoreApplication.getCurrentAccount()));
            ThirdStatisticHelper.sendReq(this.f52877f.c());
        }
    }

    /* loaded from: classes9.dex */
    public class e implements ValueAnimator.AnimatorUpdateListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ FallingView f52880e;

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
            this.f52880e = fallingView;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, valueAnimator) == null) {
                if (this.f52880e.f52867g.getVisibility() != 0) {
                    this.f52880e.f52867g.setVisibility(0);
                }
                int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                ViewGroup.LayoutParams layoutParams = this.f52880e.f52867g.getLayoutParams();
                layoutParams.width = intValue;
                this.f52880e.f52867g.setLayoutParams(layoutParams);
            }
        }
    }

    /* loaded from: classes9.dex */
    public class f extends AnimatorListenerAdapter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ FallingView f52881e;

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
            this.f52881e = fallingView;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLZ(1048576, this, animator, z) == null) {
                this.f52881e.f52865e.setScaleX(1.0f);
                this.f52881e.f52865e.setScaleY(1.0f);
            }
        }
    }

    /* loaded from: classes9.dex */
    public class g extends AnimatorListenerAdapter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ FallingView f52882e;

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
            this.f52882e = fallingView;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, animator) == null) {
                this.f52882e.t();
            }
        }
    }

    /* loaded from: classes9.dex */
    public class h extends AnimatorListenerAdapter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ FallingView f52883e;

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
            this.f52883e = fallingView;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, animator) == null) || this.f52883e.t.isStarted() || this.f52883e.o) {
                return;
            }
            this.f52883e.t.start();
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, animator) == null) {
                this.f52883e.p = true;
            }
        }
    }

    /* loaded from: classes9.dex */
    public class i extends AnimatorListenerAdapter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ValueAnimator f52884e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ FallingView f52885f;

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
            this.f52885f = fallingView;
            this.f52884e = valueAnimator;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, animator) == null) {
                this.f52884e.cancel();
                this.f52885f.s.start();
            }
        }
    }

    /* loaded from: classes9.dex */
    public static class j implements TypeEvaluator<PointF> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final PointF f52886a;

        /* renamed from: b  reason: collision with root package name */
        public final PointF f52887b;

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
            this.f52886a = pointF;
            this.f52887b = pointF2;
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
                return new PointF((int) ((pointF.x * Math.pow(d2, 3.0d)) + (this.f52886a.x * 3.0f * f2 * Math.pow(d2, 2.0d)) + (this.f52887b.x * 3.0f * Math.pow(d3, 2.0d) * d2) + (pointF2.x * Math.pow(d3, 3.0d))), (int) ((pointF.y * Math.pow(d2, 3.0d)) + (this.f52886a.y * 3.0f * f2 * Math.pow(d2, 2.0d)) + (this.f52887b.y * 3.0f * Math.pow(d3, 2.0d) * d2) + (pointF2.y * Math.pow(d3, 3.0d))));
            }
            return (PointF) invokeCommon.objValue;
        }
    }

    /* loaded from: classes9.dex */
    public static class k {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final b.a.q0.u.a f52888a;

        /* renamed from: b  reason: collision with root package name */
        public final TbPageContext<?> f52889b;

        /* renamed from: c  reason: collision with root package name */
        public final int f52890c;

        public k(b.a.q0.u.a aVar, TbPageContext<?> tbPageContext, int i2) {
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
            this.f52888a = aVar;
            this.f52889b = tbPageContext;
            this.f52890c = i2;
        }
    }

    /* loaded from: classes9.dex */
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
            if (this.j.size() > 0) {
                this.o = false;
                for (int i2 = 0; i2 < this.j.size(); i2++) {
                    this.o = this.j.get(i2).b(canvas, this.q) || this.o;
                }
                if (this.o) {
                    postDelayed(this.w, (currentTimeMillis + 5) - System.currentTimeMillis());
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
            if (this.f52866f.getVisibility() != 0) {
                return super.dispatchTouchEvent(motionEvent);
            }
            if (motionEvent.getAction() == 0 && l(this.f52866f, motionEvent.getX(), motionEvent.getY())) {
                View.OnClickListener onClickListener = this.y;
                if (onClickListener != null) {
                    onClickListener.onClick(this.f52866f);
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
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.n : invokeV.booleanValue;
    }

    public final void j(b.a.r0.k2.z.e eVar, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048579, this, eVar, i2) == null) {
            if (this.l == 0) {
                this.l = b.a.e.e.p.l.k(this.k);
            }
            if (this.m == 0) {
                this.m = b.a.e.e.p.l.i(this.k);
            }
            this.j.clear();
            for (int i3 = 0; i3 < i2; i3++) {
                b.a.r0.k2.z.e eVar2 = new b.a.r0.k2.z.e(eVar.f19895i, this.l, this.m);
                eVar2.f19891e = (-i3) * 180;
                this.j.add(eVar2);
            }
        }
    }

    public final boolean k(b.a.q0.u.a aVar, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048580, this, aVar, i2)) == null) {
            if (aVar == null) {
                return false;
            }
            try {
                if (i2 == 2) {
                    int k2 = b.a.q0.s.e0.b.j().k("key_pb_commont_egg_limlit_a", 0);
                    if (TbSingleton.getInstance().getAdVertiSementData() != null && k2 < TbSingleton.getInstance().getAdVertiSementData().a()) {
                        b.a.q0.s.e0.b.j().v("key_pb_commont_egg_limlit_a", k2 + 1);
                        return true;
                    }
                } else {
                    String p = b.a.q0.s.e0.b.j().p("key_pb_commont_egg_limlit_bc", new JSONObject().toString());
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
                        b.a.q0.s.e0.b.j().x("key_pb_commont_egg_limlit_bc", jSONObject.toString());
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
            View inflate = LayoutInflater.from(context).inflate(b.a.r0.k2.j.falling_click_view, (ViewGroup) null, false);
            this.f52866f = inflate;
            this.f52867g = inflate.findViewById(b.a.r0.k2.i.expand_layout);
            this.f52868h = this.f52866f.findViewById(b.a.r0.k2.i.expand_image);
            this.f52869i = (TextView) this.f52866f.findViewById(b.a.r0.k2.i.expand_text);
            this.f52865e = (TbImageView) this.f52866f.findViewById(b.a.r0.k2.i.click_image);
            b.a.q0.s.u.c d2 = b.a.q0.s.u.c.d(this.f52867g);
            d2.n(b.a.r0.k2.l.J_X01);
            d2.f(b.a.r0.k2.f.CAM_X0608);
            b.a.q0.s.u.c d3 = b.a.q0.s.u.c.d(this.f52869i);
            d3.A(b.a.r0.k2.l.F_X01);
            d3.v(b.a.r0.k2.f.CAM_X0101);
            b.a.q0.s.u.c d4 = b.a.q0.s.u.c.d(this.f52868h);
            d4.n(b.a.r0.k2.l.J_X01);
            d4.f(b.a.r0.k2.f.CAM_X0317);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
            this.f52865e.setConrers(15);
            this.f52865e.setPadding(b.a.e.e.p.l.g(context, b.a.r0.k2.g.tbds10), b.a.e.e.p.l.g(context, b.a.r0.k2.g.tbds5), b.a.e.e.p.l.g(context, b.a.r0.k2.g.tbds10), b.a.e.e.p.l.g(context, b.a.r0.k2.g.tbds5));
            this.f52865e.setPlaceHolder(2);
            addView(this.f52866f, layoutParams);
            Paint paint = new Paint();
            this.q = paint;
            paint.setDither(true);
            this.f52865e.setLayerType(1, null);
        }
    }

    public /* synthetic */ void o(ValueAnimator valueAnimator) {
        float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        TbImageView tbImageView = this.f52865e;
        tbImageView.setPivotX(tbImageView.getWidth() / 2);
        TbImageView tbImageView2 = this.f52865e;
        tbImageView2.setPivotY(tbImageView2.getHeight() / 2);
        this.f52865e.setScaleX(floatValue);
        this.f52865e.setScaleY(floatValue);
    }

    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048585, this, i2, i3) == null) {
            super.onMeasure(i2, i3);
            int s = s(1000, i3);
            int s2 = s(600, i2);
            setMeasuredDimension(s2, s);
            this.l = s2;
            this.m = s;
        }
    }

    public /* synthetic */ void p(ValueAnimator valueAnimator) {
        PointF pointF = (PointF) valueAnimator.getAnimatedValue();
        this.f52866f.setX(pointF.x);
        this.f52866f.setY(pointF.y);
    }

    public /* synthetic */ void q(ValueAnimator valueAnimator) {
        float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        TbImageView tbImageView = this.f52865e;
        tbImageView.setPivotX(tbImageView.getWidth() / 2);
        TbImageView tbImageView2 = this.f52865e;
        tbImageView2.setPivotY(tbImageView2.getHeight() / 2);
        this.f52865e.setScaleX(floatValue);
        this.f52865e.setScaleY(floatValue);
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
            this.v = lVar;
        }
    }

    public void startFalling(b.a.q0.u.a aVar, TbPageContext<?> tbPageContext, int i2, boolean z) {
        l lVar;
        l lVar2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048590, this, new Object[]{aVar, tbPageContext, Integer.valueOf(i2), Boolean.valueOf(z)}) == null) {
            if (z) {
                stopAllViews();
                if (!v(aVar, tbPageContext, i2) || (lVar2 = this.v) == null) {
                    return;
                }
                lVar2.onAnimationStart();
            } else if (this.n) {
                this.u.add(new k(aVar, tbPageContext, i2));
            } else if (!v(aVar, tbPageContext, i2) || (lVar = this.v) == null) {
            } else {
                lVar.onAnimationStart();
            }
        }
    }

    public void stopAllViews() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            this.n = false;
            this.p = false;
            this.j.clear();
            removeCallbacks(this.w);
            removeCallbacks(this.x);
            this.f52866f.setVisibility(8);
            this.f52867g.setVisibility(8);
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

    public final void t() {
        l lVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            stopAllViews();
            k poll = this.u.poll();
            if (poll != null) {
                if (v(poll.f52888a, poll.f52889b, poll.f52890c) || (lVar = this.v) == null) {
                    return;
                }
                lVar.onAnimationEnd();
                return;
            }
            l lVar2 = this.v;
            if (lVar2 != null) {
                lVar2.onAnimationEnd();
            }
        }
    }

    public final void u() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            if (this.f52866f.getVisibility() != 0) {
                this.f52866f.setVisibility(0);
            }
            ValueAnimator ofFloat = ValueAnimator.ofFloat(1.0f, 1.2f);
            ofFloat.setDuration(600L);
            ofFloat.setRepeatMode(2);
            ofFloat.setRepeatCount(-1);
            ofFloat.setInterpolator(new AccelerateInterpolator());
            ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: b.a.r0.k2.z.c
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
            int i2 = b.a.e.e.p.l.i(this.k);
            float k2 = b.a.e.e.p.l.k(this.k);
            PointF pointF = new PointF(((3.0f * k2) / 4.0f) - (this.f52865e.getWidth() / 2), (-i2) / 4.0f);
            float f2 = i2;
            ValueAnimator ofObject = ValueAnimator.ofObject(new j(new PointF(b.a.e.e.p.l.g(this.k, b.a.r0.k2.g.tbds50), b.a.e.e.p.l.g(this.k, b.a.r0.k2.g.tbds400)), new PointF((k2 / 2.0f) - b.a.e.e.p.l.g(this.k, b.a.r0.k2.g.tbds50), f2 - b.a.e.e.p.l.g(this.k, b.a.r0.k2.g.tbds655))), pointF, new PointF(b.a.e.e.p.l.g(this.k, b.a.r0.k2.g.tbds0), f2 - b.a.e.e.p.l.g(this.k, b.a.r0.k2.g.tbds552)));
            ofObject.setDuration(5000L);
            ofObject.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: b.a.r0.k2.z.d
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
            ValueAnimator ofInt = ValueAnimator.ofInt(0, m(this.f52867g));
            ofInt.setInterpolator(new LinearInterpolator());
            ofInt.setDuration(500L);
            ofInt.addUpdateListener(new e(this));
            ValueAnimator ofFloat2 = ValueAnimator.ofFloat(1.0f, 0.8f);
            ofFloat2.setDuration(600L);
            ofFloat2.setInterpolator(new AccelerateInterpolator());
            ofFloat2.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: b.a.r0.k2.z.b
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

    public final boolean v(b.a.q0.u.a aVar, TbPageContext<?> tbPageContext, int i2) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(1048594, this, aVar, tbPageContext, i2)) == null) {
            if (k(aVar, i2)) {
                if (!StringUtils.isNull(aVar.d())) {
                    String d2 = aVar.d();
                    if (d2.length() > 10) {
                        d2 = d2.substring(0, 9) + "...";
                    }
                    this.f52869i.setText(d2);
                } else {
                    this.f52869i.setText(this.k.getString(b.a.r0.k2.l.check_immediately));
                }
                this.f52865e.startLoad(aVar.j(), 10, false);
                Fresco.getImagePipeline().fetchDecodedImage(ImageRequestBuilder.newBuilderWithSource(Uri.parse(aVar.i())).setProgressiveRenderingEnabled(true).build(), this.k).subscribe(new c(this, tbPageContext, aVar, i2), CallerThreadExecutor.getInstance());
                return true;
            }
            return false;
        }
        return invokeLLI.booleanValue;
    }

    public final void w(TbPageContext<?> tbPageContext, b.a.q0.u.a aVar, Bitmap bitmap, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLI(1048595, this, tbPageContext, aVar, bitmap, i2) == null) {
            final Random random = new Random();
            e.b bVar = new e.b(bitmap);
            bVar.p(b.a.e.e.p.l.g(TbadkCoreApplication.getInst(), b.a.r0.k2.g.tbds8), true);
            bVar.o(b.a.e.e.p.l.g(TbadkCoreApplication.getInst(), b.a.r0.k2.g.tbds200), b.a.e.e.p.l.g(TbadkCoreApplication.getInst(), b.a.r0.k2.g.tbds200), true);
            bVar.m(b.a.e.e.p.l.g(TbadkCoreApplication.getInst(), b.a.r0.k2.g.tbds100), b.a.e.e.p.l.g(TbadkCoreApplication.getInst(), b.a.r0.k2.g.tbds100));
            bVar.n(new e.c() { // from class: b.a.r0.k2.z.a
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // b.a.r0.k2.z.e.c
                public final float a() {
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    return (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) ? FallingView.r(random) : invokeV.floatValue;
                }
            });
            bVar.q(b.a.e.e.p.l.g(TbadkCoreApplication.getInst(), b.a.r0.k2.g.tbds40), true, true);
            j(bVar.l(), 19);
            postDelayed(this.x, 1500L);
            this.n = true;
            invalidate();
            TiebaStatic.log(new StatisticItem("c14125").param("obj_type", i2).param("uid", TbadkCoreApplication.getCurrentAccount()));
            ThirdStatisticHelper.sendReq(aVar.l());
            this.y = new d(this, tbPageContext, aVar, i2);
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
        this.j = new ArrayList();
        this.n = false;
        this.o = false;
        this.p = false;
        this.u = new ConcurrentLinkedQueue<>();
        this.w = new a(this);
        this.x = new b(this);
        this.k = context;
        n(context);
    }
}
