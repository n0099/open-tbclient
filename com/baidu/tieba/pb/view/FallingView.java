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
import com.baidu.tieba.a28;
import com.baidu.tieba.f15;
import com.baidu.tieba.hs8;
import com.baidu.tieba.os4;
import com.baidu.tieba.pb.view.FallingView;
import com.baidu.tieba.qi;
import com.baidu.tieba.ri;
import com.baidu.tieba.tu4;
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
/* loaded from: classes5.dex */
public class FallingView extends FrameLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int A;
    public int B;
    public TbImageView a;
    public View b;
    public View c;
    public View d;
    public TextView e;
    public final List<a28> f;
    public final Context g;
    public int h;
    public int i;
    public boolean j;
    public boolean k;
    public boolean l;
    public Paint m;
    public AnimatorSet n;
    public AnimatorSet o;
    public ValueAnimator p;
    public final ConcurrentLinkedQueue<m> q;
    public n r;
    public View s;
    public View t;
    public ImageView u;
    public TextView v;
    public l w;
    public final Runnable x;
    public final Runnable y;
    public View.OnClickListener z;

    /* loaded from: classes5.dex */
    public class a extends AnimatorListenerAdapter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ValueAnimator a;
        public final /* synthetic */ FallingView b;

        public a(FallingView fallingView, ValueAnimator valueAnimator) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fallingView, valueAnimator};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = fallingView;
            this.a = valueAnimator;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, animator) == null) {
                this.a.cancel();
                this.b.o.start();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FallingView a;

        public b(FallingView fallingView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fallingView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = fallingView;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.invalidate();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FallingView a;

        public c(FallingView fallingView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fallingView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = fallingView;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                FallingView fallingView = this.a;
                fallingView.z(fallingView.A);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class d extends BaseBitmapDataSubscriber {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ TbPageContext a;
        public final /* synthetic */ f15 b;
        public final /* synthetic */ int c;
        public final /* synthetic */ FallingView d;

        public d(FallingView fallingView, TbPageContext tbPageContext, f15 f15Var, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fallingView, tbPageContext, f15Var, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.d = fallingView;
            this.a = tbPageContext;
            this.b = f15Var;
            this.c = i;
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
                this.d.E(this.a, this.b, bitmap, this.c);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class e implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ TbPageContext a;
        public final /* synthetic */ f15 b;
        public final /* synthetic */ int c;
        public final /* synthetic */ FallingView d;

        public e(FallingView fallingView, TbPageContext tbPageContext, f15 f15Var, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fallingView, tbPageContext, f15Var, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.d = fallingView;
            this.a = tbPageContext;
            this.b = f15Var;
            this.c = i;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            f15 f15Var;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view2) == null) || this.a == null || (f15Var = this.b) == null) {
                return;
            }
            if (!UtilHelper.isMatchScheme(this.a.getPageActivity(), f15Var.g(), this.b.f())) {
                TbPageContext tbPageContext = this.a;
                hs8.a(tbPageContext, "https://tieba.baidu.com/mo/q/checkurl?url=" + qi.getUrlEncode(this.b.h()));
            }
            TiebaStatic.log(new StatisticItem("c14126").param("obj_type", this.c).param("obj_locate", this.d.B).param("uid", TbadkCoreApplication.getCurrentAccount()));
            ThirdStatisticHelper.sendReq(this.b.c());
        }
    }

    /* loaded from: classes5.dex */
    public class f implements ValueAnimator.AnimatorUpdateListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FallingView a;

        public f(FallingView fallingView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fallingView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = fallingView;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, valueAnimator) == null) {
                if (this.a.c.getVisibility() != 0) {
                    this.a.c.setVisibility(0);
                }
                int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                ViewGroup.LayoutParams layoutParams = this.a.c.getLayoutParams();
                layoutParams.width = intValue;
                this.a.c.setLayoutParams(layoutParams);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class g extends AnimatorListenerAdapter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FallingView a;

        public g(FallingView fallingView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fallingView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = fallingView;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLZ(1048576, this, animator, z) == null) {
                this.a.a.setScaleX(1.0f);
                this.a.a.setScaleY(1.0f);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class h extends AnimatorListenerAdapter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FallingView a;

        public h(FallingView fallingView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fallingView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = fallingView;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, animator) == null) {
                this.a.y();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class i extends AnimatorListenerAdapter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FallingView a;

        public i(FallingView fallingView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fallingView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = fallingView;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, animator) == null) || this.a.p.isStarted() || this.a.k) {
                return;
            }
            this.a.p.start();
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, animator) == null) {
                this.a.l = true;
            }
        }
    }

    /* loaded from: classes5.dex */
    public class j extends AnimatorListenerAdapter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ int a;
        public final /* synthetic */ FallingView b;

        public j(FallingView fallingView, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fallingView, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = fallingView;
            this.a = i;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, animator) == null) {
                this.b.B = 2;
                TiebaStatic.log(new StatisticItem("c14125").param("obj_type", this.a).param("obj_locate", this.b.B).param("uid", TbadkCoreApplication.getCurrentAccount()));
            }
        }
    }

    /* loaded from: classes5.dex */
    public static class k implements TypeEvaluator<PointF> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final PointF a;
        public final PointF b;

        public k(PointF pointF, PointF pointF2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pointF, pointF2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = pointF;
            this.b = pointF2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.animation.TypeEvaluator
        /* renamed from: a */
        public PointF evaluate(float f, PointF pointF, PointF pointF2) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{Float.valueOf(f), pointF, pointF2})) == null) {
                double d = 1.0f - f;
                double d2 = f;
                return new PointF((int) ((pointF.x * Math.pow(d, 3.0d)) + (this.a.x * 3.0f * f * Math.pow(d, 2.0d)) + (this.b.x * 3.0f * Math.pow(d2, 2.0d) * d) + (pointF2.x * Math.pow(d2, 3.0d))), (int) ((pointF.y * Math.pow(d, 3.0d)) + (this.a.y * 3.0f * f * Math.pow(d, 2.0d)) + (this.b.y * 3.0f * Math.pow(d2, 2.0d) * d) + (pointF2.y * Math.pow(d2, 3.0d))));
            }
            return (PointF) invokeCommon.objValue;
        }
    }

    /* loaded from: classes5.dex */
    public interface l {
        void onClick();
    }

    /* loaded from: classes5.dex */
    public static class m {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final f15 a;
        public final TbPageContext<?> b;
        public final int c;

        public m(f15 f15Var, TbPageContext<?> tbPageContext, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {f15Var, tbPageContext, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = f15Var;
            this.b = tbPageContext;
            this.c = i;
        }
    }

    /* loaded from: classes5.dex */
    public interface n {
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

    public static /* synthetic */ float w(Random random) {
        return (random.nextInt(2) * 0.1f) + 0.8f;
    }

    public final void A() {
        View view2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (view2 = this.s) == null) {
            return;
        }
        view2.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.x18
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            @Override // android.view.View.OnClickListener
            public final void onClick(View view3) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, view3) == null) {
                    FallingView.this.v(view3);
                }
            }
        });
    }

    public final void B(f15 f15Var) {
        View view2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, f15Var) == null) {
            if (f15Var != null && !f15Var.n() && (view2 = this.s) != null) {
                view2.setVisibility(8);
                return;
            }
            View view3 = this.s;
            if (view3 != null) {
                view3.setVisibility(0);
            }
        }
    }

    public final boolean C(f15 f15Var, TbPageContext<?> tbPageContext, int i2) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(Constants.METHOD_SEND_USER_MSG, this, f15Var, tbPageContext, i2)) == null) {
            if (n(f15Var, i2)) {
                this.B = 1;
                if (!StringUtils.isNull(f15Var.d())) {
                    String d2 = f15Var.d();
                    if (d2.length() > 10) {
                        d2 = d2.substring(0, 9) + StringHelper.STRING_MORE;
                    }
                    this.e.setText(d2);
                } else {
                    this.e.setText(this.g.getString(R.string.obfuscated_res_0x7f0f03b4));
                }
                this.a.K(f15Var.j(), 10, false);
                Fresco.getImagePipeline().fetchDecodedImage(ImageRequestBuilder.newBuilderWithSource(Uri.parse(f15Var.i())).setProgressiveRenderingEnabled(true).build(), this.g).subscribe(new d(this, tbPageContext, f15Var, i2), CallerThreadExecutor.getInstance());
                return true;
            }
            return false;
        }
        return invokeLLI.booleanValue;
    }

    public void D(f15 f15Var, TbPageContext<?> tbPageContext, int i2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{f15Var, tbPageContext, Integer.valueOf(i2), Boolean.valueOf(z)}) == null) {
            if (z) {
                F();
                if (C(f15Var, tbPageContext, i2)) {
                    B(f15Var);
                    n nVar = this.r;
                    if (nVar != null) {
                        nVar.onAnimationStart();
                    }
                }
            } else if (this.j) {
                this.q.add(new m(f15Var, tbPageContext, i2));
            } else if (C(f15Var, tbPageContext, i2)) {
                B(f15Var);
                n nVar2 = this.r;
                if (nVar2 != null) {
                    nVar2.onAnimationStart();
                }
            }
        }
    }

    public final void E(TbPageContext<?> tbPageContext, f15 f15Var, Bitmap bitmap, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLI(1048580, this, tbPageContext, f15Var, bitmap, i2) == null) {
            final Random random = new Random();
            a28.b bVar = new a28.b(bitmap);
            bVar.p(ri.f(TbadkCoreApplication.getInst(), R.dimen.tbds8), true);
            bVar.o(ri.f(TbadkCoreApplication.getInst(), R.dimen.tbds200), ri.f(TbadkCoreApplication.getInst(), R.dimen.tbds200), true);
            bVar.m(ri.f(TbadkCoreApplication.getInst(), R.dimen.tbds100), ri.f(TbadkCoreApplication.getInst(), R.dimen.tbds100));
            bVar.n(new a28.c() { // from class: com.baidu.tieba.w18
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // com.baidu.tieba.a28.c
                public final float a() {
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    return (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) ? FallingView.w(random) : invokeV.floatValue;
                }
            });
            bVar.q(ri.f(TbadkCoreApplication.getInst(), R.dimen.tbds40), true, true);
            a28 l2 = bVar.l();
            this.A = i2;
            m(l2, 19);
            postDelayed(this.y, 1500L);
            this.j = true;
            invalidate();
            TiebaStatic.log(new StatisticItem("c14125").param("obj_type", i2).param("obj_locate", this.B).param("uid", TbadkCoreApplication.getCurrentAccount()));
            ThirdStatisticHelper.sendReq(f15Var.l());
            this.z = new e(this, tbPageContext, f15Var, i2);
        }
    }

    public void F() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.j = false;
            this.l = false;
            this.f.clear();
            removeCallbacks(this.x);
            removeCallbacks(this.y);
            this.b.setVisibility(8);
            this.c.setVisibility(8);
            this.s.setVisibility(8);
            AnimatorSet animatorSet = this.n;
            if (animatorSet != null) {
                animatorSet.cancel();
            }
            AnimatorSet animatorSet2 = this.o;
            if (animatorSet2 != null) {
                animatorSet2.cancel();
            }
            ValueAnimator valueAnimator = this.p;
            if (valueAnimator != null) {
                valueAnimator.cancel();
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, canvas) == null) {
            long currentTimeMillis = System.currentTimeMillis();
            super.dispatchDraw(canvas);
            if (this.f.size() > 0) {
                this.k = false;
                for (int i2 = 0; i2 < this.f.size(); i2++) {
                    this.k = this.f.get(i2).b(canvas, this.m) || this.k;
                }
                if (this.k) {
                    postDelayed(this.x, (currentTimeMillis + 5) - System.currentTimeMillis());
                    return;
                }
                ValueAnimator valueAnimator = this.p;
                if (valueAnimator == null || valueAnimator.isStarted() || !this.l) {
                    return;
                }
                this.p.start();
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, motionEvent)) == null) {
            if (this.b.getVisibility() != 0) {
                return super.dispatchTouchEvent(motionEvent);
            }
            if (motionEvent.getAction() == 0 && o(this.b, motionEvent.getX(), motionEvent.getY())) {
                View.OnClickListener onClickListener = this.z;
                if (onClickListener != null) {
                    onClickListener.onClick(this.b);
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
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.s : (View) invokeV.objValue;
    }

    public final void m(a28 a28Var, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048585, this, a28Var, i2) == null) {
            if (this.h == 0) {
                this.h = ri.k(this.g);
            }
            if (this.i == 0) {
                this.i = ri.i(this.g);
            }
            this.f.clear();
            for (int i3 = 0; i3 < i2; i3++) {
                a28 a28Var2 = new a28(a28Var.i, this.h, this.i);
                a28Var2.e = (-i3) * 180;
                this.f.add(a28Var2);
            }
        }
    }

    public final boolean n(f15 f15Var, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048586, this, f15Var, i2)) == null) {
            if (f15Var == null || StringHelper.isTaday(tu4.k().m("key_pb_falling_ad_feedback_click_time", 0L))) {
                return false;
            }
            try {
                if (i2 == 2) {
                    int l2 = tu4.k().l("key_pb_commont_egg_limlit_a", 0);
                    if (TbSingleton.getInstance().getAdVertiSementData() != null && l2 < TbSingleton.getInstance().getAdVertiSementData().a()) {
                        tu4.k().w("key_pb_commont_egg_limlit_a", l2 + 1);
                        return true;
                    }
                } else {
                    String q = tu4.k().q("key_pb_commont_egg_limlit_bc", new JSONObject().toString());
                    if (TextUtils.isEmpty(f15Var.b())) {
                        return false;
                    }
                    JSONObject jSONObject = new JSONObject(q);
                    JSONArray jSONArray = new JSONArray();
                    JSONArray optJSONArray = jSONObject.optJSONArray(f15Var.b());
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
                        jSONObject.remove(f15Var.b());
                        jSONObject.put(f15Var.b(), jSONArray);
                        tu4.k().y("key_pb_commont_egg_limlit_bc", jSONObject.toString());
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

    public final boolean o(View view2, float f2, float f3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048587, this, new Object[]{view2, Float.valueOf(f2), Float.valueOf(f3)})) == null) {
            float x = view2.getX();
            float y = view2.getY();
            return f2 >= x && f2 <= x + ((float) view2.getWidth()) && f3 >= y && f3 <= y + ((float) view2.getHeight());
        }
        return invokeCommon.booleanValue;
    }

    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048588, this, i2, i3) == null) {
            super.onMeasure(i2, i3);
            int x = x(1000, i3);
            int x2 = x(600, i2);
            setMeasuredDimension(x2, x);
            this.h = x2;
            this.i = x;
        }
    }

    public final int p(View view2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048589, this, view2)) == null) {
            view2.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
            return view2.getMeasuredWidth();
        }
        return invokeL.intValue;
    }

    public final void q(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, context) == null) {
            View inflate = LayoutInflater.from(context).inflate(R.layout.obfuscated_res_0x7f0d0288, (ViewGroup) null, false);
            this.b = inflate;
            this.c = inflate.findViewById(R.id.obfuscated_res_0x7f090943);
            this.d = this.b.findViewById(R.id.obfuscated_res_0x7f090940);
            this.e = (TextView) this.b.findViewById(R.id.obfuscated_res_0x7f090944);
            this.a = (TbImageView) this.b.findViewById(R.id.obfuscated_res_0x7f090638);
            os4 d2 = os4.d(this.c);
            d2.n(R.string.J_X01);
            d2.f(R.color.CAM_X0608);
            os4 d3 = os4.d(this.e);
            d3.A(R.string.F_X01);
            d3.v(R.color.CAM_X0101);
            os4 d4 = os4.d(this.d);
            d4.n(R.string.J_X01);
            d4.f(R.color.CAM_X0317);
            ViewGroup.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
            this.a.setConrers(15);
            this.a.setPadding(ri.f(context, R.dimen.tbds10), ri.f(context, R.dimen.tbds5), ri.f(context, R.dimen.tbds10), ri.f(context, R.dimen.tbds5));
            this.a.setPlaceHolder(2);
            addView(this.b, layoutParams);
            View inflate2 = LayoutInflater.from(context).inflate(R.layout.obfuscated_res_0x7f0d0287, (ViewGroup) null, false);
            this.s = inflate2;
            this.t = inflate2.findViewById(R.id.obfuscated_res_0x7f0900c1);
            this.u = (ImageView) this.s.findViewById(R.id.obfuscated_res_0x7f09097e);
            this.v = (TextView) this.s.findViewById(R.id.obfuscated_res_0x7f09097d);
            A();
            DrawableSelector.make().trRadius(ri.f(getContext(), R.dimen.tbds26)).brRadius(ri.f(getContext(), R.dimen.tbds26)).defaultColor(R.color.CAM_X0624).into(this.t);
            FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-2, -2);
            layoutParams2.gravity = 3;
            WebPManager.setPureDrawable(this.u, R.drawable.obfuscated_res_0x7f0806f3, R.color.CAM_X0101, null);
            os4.d(this.v).v(R.color.CAM_X0101);
            this.s.setY(ri.i(this.g) - ri.f(this.g, R.dimen.tbds720));
            addView(this.s, layoutParams2);
            Paint paint = new Paint();
            this.m = paint;
            paint.setDither(true);
            this.a.setLayerType(1, null);
        }
    }

    public boolean r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? this.j : invokeV.booleanValue;
    }

    public /* synthetic */ void s(ValueAnimator valueAnimator) {
        float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        TbImageView tbImageView = this.a;
        tbImageView.setPivotX(tbImageView.getWidth() / 2);
        TbImageView tbImageView2 = this.a;
        tbImageView2.setPivotY(tbImageView2.getHeight() / 2);
        this.a.setScaleX(floatValue);
        this.a.setScaleY(floatValue);
    }

    public void setAnimationListener(n nVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, nVar) == null) {
            this.r = nVar;
        }
    }

    public void setFallingFeedbackListener(l lVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, lVar) == null) {
            this.w = lVar;
        }
    }

    public /* synthetic */ void t(ValueAnimator valueAnimator) {
        float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        TbImageView tbImageView = this.a;
        tbImageView.setPivotX(tbImageView.getWidth() / 2);
        TbImageView tbImageView2 = this.a;
        tbImageView2.setPivotY(tbImageView2.getHeight() / 2);
        this.a.setScaleX(floatValue);
        this.a.setScaleY(floatValue);
    }

    public /* synthetic */ void u(ValueAnimator valueAnimator) {
        PointF pointF = (PointF) valueAnimator.getAnimatedValue();
        this.b.setX(pointF.x);
        this.b.setY(pointF.y);
    }

    public /* synthetic */ void v(View view2) {
        tu4.k().x("key_pb_falling_ad_feedback_click_time", System.currentTimeMillis());
        F();
        l lVar = this.w;
        if (lVar != null) {
            lVar.onClick();
            TiebaStatic.log(new StatisticItem("c14126").param("obj_type", this.A).param("obj_locate", 3).param("uid", TbadkCoreApplication.getCurrentAccount()));
        }
    }

    public final int x(int i2, int i3) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(1048598, this, i2, i3)) == null) {
            int mode = View.MeasureSpec.getMode(i3);
            int size = View.MeasureSpec.getSize(i3);
            return mode == 1073741824 ? size : mode == Integer.MIN_VALUE ? Math.min(i2, size) : i2;
        }
        return invokeII.intValue;
    }

    public final void y() {
        n nVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048599, this) == null) {
            F();
            m poll = this.q.poll();
            if (poll != null) {
                boolean C = C(poll.a, poll.b, poll.c);
                this.s.setVisibility(C ? 0 : 8);
                if (C) {
                    B(poll.a);
                } else {
                    this.s.setVisibility(8);
                }
                if (C || (nVar = this.r) == null) {
                    return;
                }
                nVar.onAnimationEnd();
                return;
            }
            n nVar2 = this.r;
            if (nVar2 != null) {
                nVar2.onAnimationEnd();
            }
        }
    }

    public final void z(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048600, this, i2) == null) {
            if (this.b.getVisibility() != 0) {
                this.b.setVisibility(0);
            }
            ValueAnimator ofFloat = ValueAnimator.ofFloat(1.0f, 1.2f);
            ofFloat.setDuration(600L);
            ofFloat.setRepeatMode(2);
            ofFloat.setRepeatCount(-1);
            ofFloat.setInterpolator(new AccelerateInterpolator());
            ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.y18
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, valueAnimator) == null) {
                        FallingView.this.t(valueAnimator);
                    }
                }
            });
            int i3 = ri.i(this.g);
            float k2 = ri.k(this.g);
            PointF pointF = new PointF(((3.0f * k2) / 4.0f) - (this.a.getWidth() / 2), (-i3) / 4.0f);
            float f2 = i3;
            ValueAnimator ofObject = ValueAnimator.ofObject(new k(new PointF(ri.f(this.g, R.dimen.tbds50), ri.f(this.g, R.dimen.tbds400)), new PointF((k2 / 2.0f) - ri.f(this.g, R.dimen.tbds50), f2 - ri.f(this.g, R.dimen.tbds655))), pointF, new PointF(ri.f(this.g, R.dimen.tbds0), f2 - ri.f(this.g, R.dimen.tbds552)));
            ofObject.setDuration(5000L);
            ofObject.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.z18
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, valueAnimator) == null) {
                        FallingView.this.u(valueAnimator);
                    }
                }
            });
            ValueAnimator ofInt = ValueAnimator.ofInt(0, p(this.c));
            ofInt.setInterpolator(new LinearInterpolator());
            ofInt.setDuration(500L);
            ofInt.addUpdateListener(new f(this));
            ValueAnimator ofFloat2 = ValueAnimator.ofFloat(1.0f, 0.8f);
            ofFloat2.setDuration(600L);
            ofFloat2.setInterpolator(new AccelerateInterpolator());
            ofFloat2.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.v18
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, valueAnimator) == null) {
                        FallingView.this.s(valueAnimator);
                    }
                }
            });
            ofFloat2.addListener(new g(this));
            ValueAnimator valueAnimator = this.p;
            if (valueAnimator != null && valueAnimator.isStarted()) {
                this.p.cancel();
            }
            ValueAnimator ofInt2 = ValueAnimator.ofInt(0);
            this.p = ofInt2;
            ofInt2.setDuration(3000L);
            this.p.addListener(new h(this));
            AnimatorSet animatorSet = this.n;
            if (animatorSet != null && animatorSet.isStarted()) {
                this.n.cancel();
            }
            AnimatorSet animatorSet2 = this.o;
            if (animatorSet2 != null && animatorSet2.isStarted()) {
                this.o.cancel();
            }
            ofInt.addListener(new i(this));
            AnimatorSet animatorSet3 = new AnimatorSet();
            this.o = animatorSet3;
            animatorSet3.addListener(new j(this, i2));
            this.o.playSequentially(ofFloat2, ofInt);
            ofObject.addListener(new a(this, ofFloat));
            AnimatorSet animatorSet4 = new AnimatorSet();
            this.n = animatorSet4;
            animatorSet4.playTogether(ofObject, ofFloat);
            this.n.start();
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
        this.f = new ArrayList();
        this.j = false;
        this.k = false;
        this.l = false;
        this.q = new ConcurrentLinkedQueue<>();
        this.x = new b(this);
        this.y = new c(this);
        this.A = -1;
        this.B = -1;
        this.g = context;
        q(context);
    }
}
