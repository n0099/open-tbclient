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
import c.a.r0.u2.p.f;
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
import com.baidu.tieba.R;
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
/* loaded from: classes6.dex */
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
    public TbImageView f45520e;

    /* renamed from: f  reason: collision with root package name */
    public View f45521f;

    /* renamed from: g  reason: collision with root package name */
    public View f45522g;

    /* renamed from: h  reason: collision with root package name */
    public View f45523h;

    /* renamed from: i  reason: collision with root package name */
    public TextView f45524i;

    /* renamed from: j  reason: collision with root package name */
    public final List<c.a.r0.u2.p.f> f45525j;
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

    /* loaded from: classes6.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ FallingView f45526e;

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
            this.f45526e = fallingView;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f45526e.invalidate();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ FallingView f45527e;

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
            this.f45527e = fallingView;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f45527e.v();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class c extends BaseBitmapDataSubscriber {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ TbPageContext f45528e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ c.a.q0.t.a f45529f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ int f45530g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ FallingView f45531h;

        public c(FallingView fallingView, TbPageContext tbPageContext, c.a.q0.t.a aVar, int i2) {
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
            this.f45531h = fallingView;
            this.f45528e = tbPageContext;
            this.f45529f = aVar;
            this.f45530g = i2;
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
                this.f45531h.z(this.f45528e, this.f45529f, bitmap, this.f45530g);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ TbPageContext f45532e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ c.a.q0.t.a f45533f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ int f45534g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ FallingView f45535h;

        public d(FallingView fallingView, TbPageContext tbPageContext, c.a.q0.t.a aVar, int i2) {
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
            this.f45535h = fallingView;
            this.f45532e = tbPageContext;
            this.f45533f = aVar;
            this.f45534g = i2;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            c.a.q0.t.a aVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f45532e == null || (aVar = this.f45533f) == null) {
                return;
            }
            if (!UtilHelper.isMatchScheme(this.f45532e.getPageActivity(), aVar.g(), this.f45533f.f())) {
                TbPageContext tbPageContext = this.f45532e;
                c.a.r0.j4.a.a(tbPageContext, "http://tieba.baidu.com/mo/q/checkurl?url=" + c.a.d.f.p.m.getUrlEncode(this.f45533f.h()));
            }
            TiebaStatic.log(new StatisticItem("c14126").param("obj_type", this.f45534g).param("uid", TbadkCoreApplication.getCurrentAccount()));
            ThirdStatisticHelper.sendReq(this.f45533f.c());
        }
    }

    /* loaded from: classes6.dex */
    public class e implements ValueAnimator.AnimatorUpdateListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ FallingView f45536e;

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
            this.f45536e = fallingView;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, valueAnimator) == null) {
                if (this.f45536e.f45522g.getVisibility() != 0) {
                    this.f45536e.f45522g.setVisibility(0);
                }
                int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                ViewGroup.LayoutParams layoutParams = this.f45536e.f45522g.getLayoutParams();
                layoutParams.width = intValue;
                this.f45536e.f45522g.setLayoutParams(layoutParams);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class f extends AnimatorListenerAdapter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ FallingView f45537e;

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
            this.f45537e = fallingView;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLZ(1048576, this, animator, z) == null) {
                this.f45537e.f45520e.setScaleX(1.0f);
                this.f45537e.f45520e.setScaleY(1.0f);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class g extends AnimatorListenerAdapter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ FallingView f45538e;

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
            this.f45538e = fallingView;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, animator) == null) {
                this.f45538e.u();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class h extends AnimatorListenerAdapter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ FallingView f45539e;

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
            this.f45539e = fallingView;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, animator) == null) || this.f45539e.t.isStarted() || this.f45539e.o) {
                return;
            }
            this.f45539e.t.start();
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, animator) == null) {
                this.f45539e.p = true;
            }
        }
    }

    /* loaded from: classes6.dex */
    public class i extends AnimatorListenerAdapter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ValueAnimator f45540e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ FallingView f45541f;

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
            this.f45541f = fallingView;
            this.f45540e = valueAnimator;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, animator) == null) {
                this.f45540e.cancel();
                this.f45541f.s.start();
            }
        }
    }

    /* loaded from: classes6.dex */
    public static class j implements TypeEvaluator<PointF> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final PointF a;

        /* renamed from: b  reason: collision with root package name */
        public final PointF f45542b;

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
            this.f45542b = pointF2;
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
                return new PointF((int) ((pointF.x * Math.pow(d2, 3.0d)) + (this.a.x * 3.0f * f2 * Math.pow(d2, 2.0d)) + (this.f45542b.x * 3.0f * Math.pow(d3, 2.0d) * d2) + (pointF2.x * Math.pow(d3, 3.0d))), (int) ((pointF.y * Math.pow(d2, 3.0d)) + (this.a.y * 3.0f * f2 * Math.pow(d2, 2.0d)) + (this.f45542b.y * 3.0f * Math.pow(d3, 2.0d) * d2) + (pointF2.y * Math.pow(d3, 3.0d))));
            }
            return (PointF) invokeCommon.objValue;
        }
    }

    /* loaded from: classes6.dex */
    public interface k {
        void onClick();
    }

    /* loaded from: classes6.dex */
    public static class l {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final c.a.q0.t.a a;

        /* renamed from: b  reason: collision with root package name */
        public final TbPageContext<?> f45543b;

        /* renamed from: c  reason: collision with root package name */
        public final int f45544c;

        public l(c.a.q0.t.a aVar, TbPageContext<?> tbPageContext, int i2) {
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
            this.f45543b = tbPageContext;
            this.f45544c = i2;
        }
    }

    /* loaded from: classes6.dex */
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
            if (this.f45525j.size() > 0) {
                this.o = false;
                for (int i2 = 0; i2 < this.f45525j.size(); i2++) {
                    this.o = this.f45525j.get(i2).b(canvas, this.q) || this.o;
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
            if (this.f45521f.getVisibility() != 0) {
                return super.dispatchTouchEvent(motionEvent);
            }
            if (motionEvent.getAction() == 0 && l(this.f45521f, motionEvent.getX(), motionEvent.getY())) {
                View.OnClickListener onClickListener = this.D;
                if (onClickListener != null) {
                    onClickListener.onClick(this.f45521f);
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

    public final void j(c.a.r0.u2.p.f fVar, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048580, this, fVar, i2) == null) {
            if (this.l == 0) {
                this.l = n.k(this.k);
            }
            if (this.m == 0) {
                this.m = n.i(this.k);
            }
            this.f45525j.clear();
            for (int i3 = 0; i3 < i2; i3++) {
                c.a.r0.u2.p.f fVar2 = new c.a.r0.u2.p.f(fVar.f24093i, this.l, this.m);
                fVar2.f24089e = (-i3) * 180;
                this.f45525j.add(fVar2);
            }
        }
    }

    public final boolean k(c.a.q0.t.a aVar, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048581, this, aVar, i2)) == null) {
            if (aVar == null || StringHelper.isTaday(c.a.q0.r.j0.b.k().m("key_pb_falling_ad_feedback_click_time", 0L))) {
                return false;
            }
            try {
                if (i2 == 2) {
                    int l2 = c.a.q0.r.j0.b.k().l("key_pb_commont_egg_limlit_a", 0);
                    if (TbSingleton.getInstance().getAdVertiSementData() != null && l2 < TbSingleton.getInstance().getAdVertiSementData().a()) {
                        c.a.q0.r.j0.b.k().w("key_pb_commont_egg_limlit_a", l2 + 1);
                        return true;
                    }
                } else {
                    String q = c.a.q0.r.j0.b.k().q("key_pb_commont_egg_limlit_bc", new JSONObject().toString());
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
                        c.a.q0.r.j0.b.k().y("key_pb_commont_egg_limlit_bc", jSONObject.toString());
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
            View inflate = LayoutInflater.from(context).inflate(R.layout.falling_click_view, (ViewGroup) null, false);
            this.f45521f = inflate;
            this.f45522g = inflate.findViewById(R.id.expand_layout);
            this.f45523h = this.f45521f.findViewById(R.id.expand_image);
            this.f45524i = (TextView) this.f45521f.findViewById(R.id.expand_text);
            this.f45520e = (TbImageView) this.f45521f.findViewById(R.id.click_image);
            c.a.q0.r.v.c d2 = c.a.q0.r.v.c.d(this.f45522g);
            d2.n(R.string.J_X01);
            d2.f(R.color.CAM_X0608);
            c.a.q0.r.v.c d3 = c.a.q0.r.v.c.d(this.f45524i);
            d3.A(R.string.F_X01);
            d3.v(R.color.CAM_X0101);
            c.a.q0.r.v.c d4 = c.a.q0.r.v.c.d(this.f45523h);
            d4.n(R.string.J_X01);
            d4.f(R.color.CAM_X0317);
            ViewGroup.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
            this.f45520e.setConrers(15);
            this.f45520e.setPadding(n.f(context, R.dimen.tbds10), n.f(context, R.dimen.tbds5), n.f(context, R.dimen.tbds10), n.f(context, R.dimen.tbds5));
            this.f45520e.setPlaceHolder(2);
            addView(this.f45521f, layoutParams);
            View inflate2 = LayoutInflater.from(context).inflate(R.layout.falling_ad_label, (ViewGroup) null, false);
            this.w = inflate2;
            this.x = inflate2.findViewById(R.id.ad_label_layout);
            this.y = (ImageView) this.w.findViewById(R.id.falling_ad_feedback_img);
            this.z = (TextView) this.w.findViewById(R.id.falling_ad_content);
            w();
            DrawableSelector.make().trRadius(n.f(getContext(), R.dimen.tbds26)).brRadius(n.f(getContext(), R.dimen.tbds26)).defaultColor(R.color.CAM_X0624).into(this.x);
            FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-2, -2);
            layoutParams2.gravity = 3;
            WebPManager.setPureDrawable(this.y, R.drawable.icon_falling_ad_close, R.color.CAM_X0101, null);
            c.a.q0.r.v.c.d(this.z).v(R.color.CAM_X0101);
            this.w.setY(n.i(this.k) - n.f(this.k, R.dimen.tbds720));
            addView(this.w, layoutParams2);
            Paint paint = new Paint();
            this.q = paint;
            paint.setDither(true);
            this.f45520e.setLayerType(1, null);
        }
    }

    public /* synthetic */ void o(ValueAnimator valueAnimator) {
        float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        TbImageView tbImageView = this.f45520e;
        tbImageView.setPivotX(tbImageView.getWidth() / 2);
        TbImageView tbImageView2 = this.f45520e;
        tbImageView2.setPivotY(tbImageView2.getHeight() / 2);
        this.f45520e.setScaleX(floatValue);
        this.f45520e.setScaleY(floatValue);
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
        this.f45521f.setX(pointF.x);
        this.f45521f.setY(pointF.y);
    }

    public /* synthetic */ void q(ValueAnimator valueAnimator) {
        float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        TbImageView tbImageView = this.f45520e;
        tbImageView.setPivotX(tbImageView.getWidth() / 2);
        TbImageView tbImageView2 = this.f45520e;
        tbImageView2.setPivotY(tbImageView2.getHeight() / 2);
        this.f45520e.setScaleX(floatValue);
        this.f45520e.setScaleY(floatValue);
    }

    public /* synthetic */ void r(View view) {
        c.a.q0.r.j0.b.k().x("key_pb_falling_ad_feedback_click_time", System.currentTimeMillis());
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

    public void startFalling(c.a.q0.t.a aVar, TbPageContext<?> tbPageContext, int i2, boolean z) {
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
            this.f45525j.clear();
            removeCallbacks(this.B);
            removeCallbacks(this.C);
            this.f45521f.setVisibility(8);
            this.f45522g.setVisibility(8);
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
                boolean y = y(poll.a, poll.f45543b, poll.f45544c);
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
            if (this.f45521f.getVisibility() != 0) {
                this.f45521f.setVisibility(0);
            }
            ValueAnimator ofFloat = ValueAnimator.ofFloat(1.0f, 1.2f);
            ofFloat.setDuration(600L);
            ofFloat.setRepeatMode(2);
            ofFloat.setRepeatCount(-1);
            ofFloat.setInterpolator(new AccelerateInterpolator());
            ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: c.a.r0.u2.p.b
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
            PointF pointF = new PointF(((3.0f * k2) / 4.0f) - (this.f45520e.getWidth() / 2), (-i2) / 4.0f);
            float f2 = i2;
            ValueAnimator ofObject = ValueAnimator.ofObject(new j(new PointF(n.f(this.k, R.dimen.tbds50), n.f(this.k, R.dimen.tbds400)), new PointF((k2 / 2.0f) - n.f(this.k, R.dimen.tbds50), f2 - n.f(this.k, R.dimen.tbds655))), pointF, new PointF(n.f(this.k, R.dimen.tbds0), f2 - n.f(this.k, R.dimen.tbds552)));
            ofObject.setDuration(5000L);
            ofObject.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: c.a.r0.u2.p.d
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
            ValueAnimator ofInt = ValueAnimator.ofInt(0, m(this.f45522g));
            ofInt.setInterpolator(new LinearInterpolator());
            ofInt.setDuration(500L);
            ofInt.addUpdateListener(new e(this));
            ValueAnimator ofFloat2 = ValueAnimator.ofFloat(1.0f, 0.8f);
            ofFloat2.setDuration(600L);
            ofFloat2.setInterpolator(new AccelerateInterpolator());
            ofFloat2.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: c.a.r0.u2.p.c
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
        view.setOnClickListener(new View.OnClickListener() { // from class: c.a.r0.u2.p.e
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

    public final void x(c.a.q0.t.a aVar) {
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

    public final boolean y(c.a.q0.t.a aVar, TbPageContext<?> tbPageContext, int i2) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(1048599, this, aVar, tbPageContext, i2)) == null) {
            if (k(aVar, i2)) {
                if (!StringUtils.isNull(aVar.d())) {
                    String d2 = aVar.d();
                    if (d2.length() > 10) {
                        d2 = d2.substring(0, 9) + "...";
                    }
                    this.f45524i.setText(d2);
                } else {
                    this.f45524i.setText(this.k.getString(R.string.check_immediately));
                }
                this.f45520e.startLoad(aVar.j(), 10, false);
                Fresco.getImagePipeline().fetchDecodedImage(ImageRequestBuilder.newBuilderWithSource(Uri.parse(aVar.i())).setProgressiveRenderingEnabled(true).build(), this.k).subscribe(new c(this, tbPageContext, aVar, i2), CallerThreadExecutor.getInstance());
                return true;
            }
            return false;
        }
        return invokeLLI.booleanValue;
    }

    public final void z(TbPageContext<?> tbPageContext, c.a.q0.t.a aVar, Bitmap bitmap, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLI(1048600, this, tbPageContext, aVar, bitmap, i2) == null) {
            final Random random = new Random();
            f.b bVar = new f.b(bitmap);
            bVar.p(n.f(TbadkCoreApplication.getInst(), R.dimen.tbds8), true);
            bVar.o(n.f(TbadkCoreApplication.getInst(), R.dimen.tbds200), n.f(TbadkCoreApplication.getInst(), R.dimen.tbds200), true);
            bVar.m(n.f(TbadkCoreApplication.getInst(), R.dimen.tbds100), n.f(TbadkCoreApplication.getInst(), R.dimen.tbds100));
            bVar.n(new f.c() { // from class: c.a.r0.u2.p.a
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // c.a.r0.u2.p.f.c
                public final float a() {
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    return (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) ? FallingView.s(random) : invokeV.floatValue;
                }
            });
            bVar.q(n.f(TbadkCoreApplication.getInst(), R.dimen.tbds40), true, true);
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
        this.f45525j = new ArrayList();
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
