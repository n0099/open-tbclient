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
import com.baidu.tieba.f6a;
import com.baidu.tieba.lg5;
import com.baidu.tieba.n95;
import com.baidu.tieba.o75;
import com.baidu.tieba.pb9;
import com.baidu.tieba.ui;
import com.baidu.tieba.vi;
import com.baidu.tieba.wx4;
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
/* loaded from: classes7.dex */
public class PbFallingView extends FrameLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int A;
    public int B;
    public TbImageView a;
    public View b;
    public View c;
    public View d;
    public TextView e;
    public final List<pb9> f;
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
    public final ConcurrentLinkedQueue<s> q;
    public r r;
    public View s;
    public View t;
    public ImageView u;
    public TextView v;
    public q w;
    public final Runnable x;
    public final Runnable y;
    public View.OnClickListener z;

    /* loaded from: classes7.dex */
    public interface q {
        void onClick();
    }

    /* loaded from: classes7.dex */
    public interface r {
        void onAnimationEnd();

        void onAnimationStart();
    }

    /* loaded from: classes7.dex */
    public class a extends AnimatorListenerAdapter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbFallingView a;

        public a(PbFallingView pbFallingView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbFallingView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = pbFallingView;
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

    /* loaded from: classes7.dex */
    public class b extends AnimatorListenerAdapter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbFallingView a;

        public b(PbFallingView pbFallingView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbFallingView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = pbFallingView;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(1048576, this, animator) != null) {
                return;
            }
            this.a.v();
        }
    }

    /* loaded from: classes7.dex */
    public class c extends AnimatorListenerAdapter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbFallingView a;

        public c(PbFallingView pbFallingView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbFallingView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = pbFallingView;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, animator) == null) && !this.a.p.isStarted() && !this.a.k) {
                this.a.p.start();
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, animator) != null) {
                return;
            }
            this.a.l = true;
        }
    }

    /* loaded from: classes7.dex */
    public class d extends AnimatorListenerAdapter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ int a;
        public final /* synthetic */ PbFallingView b;

        public d(PbFallingView pbFallingView, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbFallingView, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = pbFallingView;
            this.a = i;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(1048576, this, animator) != null) {
                return;
            }
            this.b.B = 2;
            TiebaStatic.log(new StatisticItem("c14125").param("obj_type", this.a).param("obj_locate", this.b.B).param("uid", TbadkCoreApplication.getCurrentAccount()));
        }
    }

    /* loaded from: classes7.dex */
    public class e extends AnimatorListenerAdapter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ValueAnimator a;
        public final /* synthetic */ PbFallingView b;

        public e(PbFallingView pbFallingView, ValueAnimator valueAnimator) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbFallingView, valueAnimator};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = pbFallingView;
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

    /* loaded from: classes7.dex */
    public class f implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbFallingView a;

        public f(PbFallingView pbFallingView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbFallingView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = pbFallingView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                n95.m().A("key_pb_falling_ad_feedback_click_time", System.currentTimeMillis());
                this.a.C();
                if (this.a.w != null) {
                    this.a.w.onClick();
                    TiebaStatic.log(new StatisticItem("c14126").param("obj_type", this.a.A).param("obj_locate", 3).param("uid", TbadkCoreApplication.getCurrentAccount()));
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class g implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbFallingView a;

        public g(PbFallingView pbFallingView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbFallingView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = pbFallingView;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.invalidate();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class h implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbFallingView a;

        public h(PbFallingView pbFallingView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbFallingView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = pbFallingView;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                PbFallingView pbFallingView = this.a;
                pbFallingView.w(pbFallingView.A);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class i extends BaseBitmapDataSubscriber {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ TbPageContext a;
        public final /* synthetic */ lg5 b;
        public final /* synthetic */ int c;
        public final /* synthetic */ PbFallingView d;

        @Override // com.facebook.datasource.BaseDataSubscriber
        public void onFailureImpl(DataSource<CloseableReference<CloseableImage>> dataSource) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, dataSource) == null) {
            }
        }

        public i(PbFallingView pbFallingView, TbPageContext tbPageContext, lg5 lg5Var, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbFallingView, tbPageContext, lg5Var, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.d = pbFallingView;
            this.a = tbPageContext;
            this.b = lg5Var;
            this.c = i;
        }

        @Override // com.facebook.imagepipeline.datasource.BaseBitmapDataSubscriber
        public void onNewResultImpl(Bitmap bitmap) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bitmap) != null) {
                return;
            }
            this.d.B(this.a, this.b, bitmap, this.c);
        }
    }

    /* loaded from: classes7.dex */
    public class j implements pb9.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Random a;
        public final /* synthetic */ PbFallingView b;

        public j(PbFallingView pbFallingView, Random random) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbFallingView, random};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = pbFallingView;
            this.a = random;
        }

        @Override // com.baidu.tieba.pb9.c
        public float a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return (this.a.nextInt(2) * 0.1f) + 0.8f;
            }
            return invokeV.floatValue;
        }
    }

    /* loaded from: classes7.dex */
    public class k implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ TbPageContext a;
        public final /* synthetic */ lg5 b;
        public final /* synthetic */ int c;
        public final /* synthetic */ PbFallingView d;

        public k(PbFallingView pbFallingView, TbPageContext tbPageContext, lg5 lg5Var, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbFallingView, tbPageContext, lg5Var, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.d = pbFallingView;
            this.a = tbPageContext;
            this.b = lg5Var;
            this.c = i;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            lg5 lg5Var;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && this.a != null && (lg5Var = this.b) != null) {
                if (!UtilHelper.isMatchScheme(this.a.getPageActivity(), lg5Var.g(), this.b.f())) {
                    TbPageContext tbPageContext = this.a;
                    f6a.a(tbPageContext, wx4.a + ui.getUrlEncode(this.b.h()));
                }
                TiebaStatic.log(new StatisticItem("c14126").param("obj_type", this.c).param("obj_locate", this.d.B).param("uid", TbadkCoreApplication.getCurrentAccount()));
                ThirdStatisticHelper.sendReq(this.b.c());
            }
        }
    }

    /* loaded from: classes7.dex */
    public class l implements ValueAnimator.AnimatorUpdateListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbFallingView a;

        public l(PbFallingView pbFallingView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbFallingView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = pbFallingView;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, valueAnimator) == null) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                this.a.a.setPivotX(this.a.a.getWidth() / 2);
                this.a.a.setPivotY(this.a.a.getHeight() / 2);
                this.a.a.setScaleX(floatValue);
                this.a.a.setScaleY(floatValue);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class m implements ValueAnimator.AnimatorUpdateListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbFallingView a;

        public m(PbFallingView pbFallingView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbFallingView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = pbFallingView;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, valueAnimator) == null) {
                PointF pointF = (PointF) valueAnimator.getAnimatedValue();
                this.a.b.setX(pointF.x);
                this.a.b.setY(pointF.y);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class n implements ValueAnimator.AnimatorUpdateListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbFallingView a;

        public n(PbFallingView pbFallingView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbFallingView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = pbFallingView;
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

    /* loaded from: classes7.dex */
    public class o implements ValueAnimator.AnimatorUpdateListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbFallingView a;

        public o(PbFallingView pbFallingView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbFallingView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = pbFallingView;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, valueAnimator) == null) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                this.a.a.setPivotX(this.a.a.getWidth() / 2);
                this.a.a.setPivotY(this.a.a.getHeight() / 2);
                this.a.a.setScaleX(floatValue);
                this.a.a.setScaleY(floatValue);
            }
        }
    }

    /* loaded from: classes7.dex */
    public static class p implements TypeEvaluator<PointF> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final PointF a;
        public final PointF b;

        public p(PointF pointF, PointF pointF2) {
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

    /* loaded from: classes7.dex */
    public static class s {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final lg5 a;
        public final TbPageContext<?> b;
        public final int c;

        public s(lg5 lg5Var, TbPageContext<?> tbPageContext, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {lg5Var, tbPageContext, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = lg5Var;
            this.b = tbPageContext;
            this.c = i;
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public PbFallingView(@NonNull Context context) {
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

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public PbFallingView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
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

    public final void o(pb9 pb9Var, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048581, this, pb9Var, i2) == null) {
            if (this.h == 0) {
                this.h = vi.l(this.g);
            }
            if (this.i == 0) {
                this.i = vi.j(this.g);
            }
            this.f.clear();
            for (int i3 = 0; i3 < i2; i3++) {
                pb9 pb9Var2 = new pb9(pb9Var.i, this.h, this.i);
                pb9Var2.e = (-i3) * 180;
                this.f.add(pb9Var2);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PbFallingView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i2) {
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
        this.x = new g(this);
        this.y = new h(this);
        this.A = -1;
        this.B = -1;
        this.g = context;
        s(context);
    }

    public final boolean z(lg5 lg5Var, TbPageContext<?> tbPageContext, int i2) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(1048595, this, lg5Var, tbPageContext, i2)) == null) {
            if (!p(lg5Var, i2)) {
                return false;
            }
            this.B = 1;
            if (!StringUtils.isNull(lg5Var.d())) {
                String d2 = lg5Var.d();
                if (d2.length() > 10) {
                    d2 = d2.substring(0, 9) + "...";
                }
                this.e.setText(d2);
            } else {
                this.e.setText(this.g.getString(R.string.check_immediately));
            }
            this.a.N(lg5Var.j(), 10, false);
            Fresco.getImagePipeline().fetchDecodedImage(ImageRequestBuilder.newBuilderWithSource(Uri.parse(lg5Var.i())).setProgressiveRenderingEnabled(true).build(), this.g).subscribe(new i(this, tbPageContext, lg5Var, i2), CallerThreadExecutor.getInstance());
            return true;
        }
        return invokeLLI.booleanValue;
    }

    public final int r(View view2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, view2)) == null) {
            view2.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
            return view2.getMeasuredWidth();
        }
        return invokeL.intValue;
    }

    public void setAnimationListener(r rVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, rVar) == null) {
            this.r = rVar;
        }
    }

    public void setFallingFeedbackListener(q qVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, qVar) == null) {
            this.w = qVar;
        }
    }

    public final void y(lg5 lg5Var) {
        View view2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, lg5Var) == null) {
            if (lg5Var != null && !lg5Var.o() && (view2 = this.s) != null) {
                view2.setVisibility(8);
                return;
            }
            View view3 = this.s;
            if (view3 != null) {
                view3.setVisibility(0);
            }
        }
    }

    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048582, this, i2, i3) == null) {
            super.onMeasure(i2, i3);
            int u = u(1000, i3);
            int u2 = u(600, i2);
            setMeasuredDimension(u2, u);
            this.h = u2;
            this.i = u;
        }
    }

    public final int u(int i2, int i3) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(1048590, this, i2, i3)) == null) {
            int mode = View.MeasureSpec.getMode(i3);
            int size = View.MeasureSpec.getSize(i3);
            if (mode == 1073741824) {
                return size;
            }
            if (mode == Integer.MIN_VALUE) {
                return Math.min(i2, size);
            }
            return i2;
        }
        return invokeII.intValue;
    }

    public void A(lg5 lg5Var, TbPageContext<?> tbPageContext, int i2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{lg5Var, tbPageContext, Integer.valueOf(i2), Boolean.valueOf(z)}) == null) {
            if (z) {
                C();
                if (z(lg5Var, tbPageContext, i2)) {
                    y(lg5Var);
                    r rVar = this.r;
                    if (rVar != null) {
                        rVar.onAnimationStart();
                    }
                }
            } else if (this.j) {
                this.q.add(new s(lg5Var, tbPageContext, i2));
            } else if (z(lg5Var, tbPageContext, i2)) {
                y(lg5Var);
                r rVar2 = this.r;
                if (rVar2 != null) {
                    rVar2.onAnimationStart();
                }
            }
        }
    }

    public final void B(TbPageContext<?> tbPageContext, lg5 lg5Var, Bitmap bitmap, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, tbPageContext, lg5Var, bitmap, i2) == null) {
            Random random = new Random();
            pb9.b bVar = new pb9.b(bitmap);
            bVar.o(vi.g(TbadkCoreApplication.getInst(), R.dimen.tbds8), true);
            bVar.n(vi.g(TbadkCoreApplication.getInst(), R.dimen.tbds200), vi.g(TbadkCoreApplication.getInst(), R.dimen.tbds200), true);
            bVar.l(vi.g(TbadkCoreApplication.getInst(), R.dimen.tbds100), vi.g(TbadkCoreApplication.getInst(), R.dimen.tbds100));
            bVar.m(new j(this, random));
            bVar.p(true, true);
            pb9 k2 = bVar.k();
            this.A = i2;
            o(k2, 19);
            postDelayed(this.y, 1500L);
            this.j = true;
            invalidate();
            TiebaStatic.log(new StatisticItem("c14125").param("obj_type", i2).param("obj_locate", this.B).param("uid", TbadkCoreApplication.getCurrentAccount()));
            ThirdStatisticHelper.sendReq(lg5Var.l());
            this.z = new k(this, tbPageContext, lg5Var, i2);
        }
    }

    public void C() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
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

    public final void v() {
        int i2;
        r rVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            C();
            s poll = this.q.poll();
            if (poll != null) {
                boolean z = z(poll.a, poll.b, poll.c);
                View view2 = this.s;
                if (z) {
                    i2 = 0;
                } else {
                    i2 = 8;
                }
                view2.setVisibility(i2);
                if (z) {
                    y(poll.a);
                } else {
                    this.s.setVisibility(8);
                }
                if (!z && (rVar = this.r) != null) {
                    rVar.onAnimationEnd();
                    return;
                }
                return;
            }
            r rVar2 = this.r;
            if (rVar2 != null) {
                rVar2.onAnimationEnd();
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, canvas) == null) {
            long currentTimeMillis = System.currentTimeMillis();
            super.dispatchDraw(canvas);
            if (this.f.size() > 0) {
                this.k = false;
                for (int i2 = 0; i2 < this.f.size(); i2++) {
                    if (!this.f.get(i2).b(canvas, this.m) && !this.k) {
                        z = false;
                    } else {
                        z = true;
                    }
                    this.k = z;
                }
                if (this.k) {
                    postDelayed(this.x, (currentTimeMillis + 5) - System.currentTimeMillis());
                    return;
                }
                ValueAnimator valueAnimator = this.p;
                if (valueAnimator != null && !valueAnimator.isStarted() && this.l) {
                    this.p.start();
                }
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, motionEvent)) == null) {
            if (this.b.getVisibility() != 0) {
                return super.dispatchTouchEvent(motionEvent);
            }
            if (motionEvent.getAction() == 0 && q(this.b, motionEvent.getX(), motionEvent.getY())) {
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

    public final boolean p(lg5 lg5Var, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048583, this, lg5Var, i2)) == null) {
            if (lg5Var == null || StringHelper.isTaday(n95.m().o("key_pb_falling_ad_feedback_click_time", 0L))) {
                return false;
            }
            try {
                if (i2 == 2) {
                    int n2 = n95.m().n("key_pb_commont_egg_limlit_a", 0);
                    if (TbSingleton.getInstance().getAdVertiSementData() != null && n2 < TbSingleton.getInstance().getAdVertiSementData().a()) {
                        n95.m().z("key_pb_commont_egg_limlit_a", n2 + 1);
                        return true;
                    }
                } else {
                    String s2 = n95.m().s("key_pb_commont_egg_limlit_bc", new JSONObject().toString());
                    if (TextUtils.isEmpty(lg5Var.b())) {
                        return false;
                    }
                    JSONObject jSONObject = new JSONObject(s2);
                    JSONArray jSONArray = new JSONArray();
                    JSONArray optJSONArray = jSONObject.optJSONArray(lg5Var.b());
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
                        jSONObject.remove(lg5Var.b());
                        jSONObject.put(lg5Var.b(), jSONArray);
                        n95.m().B("key_pb_commont_egg_limlit_bc", jSONObject.toString());
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

    public final boolean q(View view2, float f2, float f3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{view2, Float.valueOf(f2), Float.valueOf(f3)})) == null) {
            float x = view2.getX();
            float y = view2.getY();
            if (f2 >= x && f2 <= x + view2.getWidth() && f3 >= y && f3 <= y + view2.getHeight()) {
                return true;
            }
            return false;
        }
        return invokeCommon.booleanValue;
    }

    public final void s(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, context) == null) {
            View inflate = LayoutInflater.from(context).inflate(R.layout.obfuscated_res_0x7f0d02c8, (ViewGroup) null, false);
            this.b = inflate;
            this.c = inflate.findViewById(R.id.expand_layout);
            this.d = this.b.findViewById(R.id.obfuscated_res_0x7f090a84);
            this.e = (TextView) this.b.findViewById(R.id.expand_text);
            this.a = (TbImageView) this.b.findViewById(R.id.obfuscated_res_0x7f09070f);
            o75 d2 = o75.d(this.c);
            d2.o(R.string.J_X01);
            d2.f(R.color.CAM_X0608);
            o75 d3 = o75.d(this.e);
            d3.C(R.string.F_X01);
            d3.w(R.color.CAM_X0101);
            o75 d4 = o75.d(this.d);
            d4.o(R.string.J_X01);
            d4.f(R.color.CAM_X0317);
            ViewGroup.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
            this.a.setConrers(15);
            this.a.setPadding(vi.g(context, R.dimen.tbds10), vi.g(context, R.dimen.tbds5), vi.g(context, R.dimen.tbds10), vi.g(context, R.dimen.tbds5));
            this.a.setPlaceHolder(2);
            addView(this.b, layoutParams);
            View inflate2 = LayoutInflater.from(context).inflate(R.layout.obfuscated_res_0x7f0d02c7, (ViewGroup) null, false);
            this.s = inflate2;
            this.t = inflate2.findViewById(R.id.obfuscated_res_0x7f0900da);
            this.u = (ImageView) this.s.findViewById(R.id.obfuscated_res_0x7f090ac4);
            this.v = (TextView) this.s.findViewById(R.id.obfuscated_res_0x7f090ac3);
            x();
            DrawableSelector.make().trRadius(vi.g(getContext(), R.dimen.tbds26)).brRadius(vi.g(getContext(), R.dimen.tbds26)).defaultColor(R.color.CAM_X0624).into(this.t);
            FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-2, -2);
            layoutParams2.gravity = 3;
            WebPManager.setPureDrawable(this.u, R.drawable.obfuscated_res_0x7f0808a0, R.color.CAM_X0101, null);
            o75.d(this.v).w(R.color.CAM_X0101);
            this.s.setY(vi.j(this.g) - vi.g(this.g, R.dimen.tbds720));
            addView(this.s, layoutParams2);
            Paint paint = new Paint();
            this.m = paint;
            paint.setDither(true);
            this.a.setLayerType(1, null);
        }
    }

    public boolean t() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            return this.j;
        }
        return invokeV.booleanValue;
    }

    public final void x() {
        View view2;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048593, this) != null) || (view2 = this.s) == null) {
            return;
        }
        view2.setOnClickListener(new f(this));
    }

    public final void w(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048592, this, i2) == null) {
            if (this.b.getVisibility() != 0) {
                this.b.setVisibility(0);
            }
            ValueAnimator ofFloat = ValueAnimator.ofFloat(1.0f, 1.2f);
            ofFloat.setDuration(600L);
            ofFloat.setRepeatMode(2);
            ofFloat.setRepeatCount(-1);
            ofFloat.setInterpolator(new AccelerateInterpolator());
            ofFloat.addUpdateListener(new l(this));
            int j2 = vi.j(this.g);
            float l2 = vi.l(this.g);
            PointF pointF = new PointF(((3.0f * l2) / 4.0f) - (this.a.getWidth() / 2), (-j2) / 4.0f);
            float f2 = j2;
            ValueAnimator ofObject = ValueAnimator.ofObject(new p(new PointF(vi.g(this.g, R.dimen.tbds50), vi.g(this.g, R.dimen.tbds400)), new PointF((l2 / 2.0f) - vi.g(this.g, R.dimen.tbds50), f2 - vi.g(this.g, R.dimen.tbds655))), pointF, new PointF(vi.g(this.g, R.dimen.tbds0), f2 - vi.g(this.g, R.dimen.tbds552)));
            ofObject.setDuration(5000L);
            ofObject.addUpdateListener(new m(this));
            ValueAnimator ofInt = ValueAnimator.ofInt(0, r(this.c));
            ofInt.setInterpolator(new LinearInterpolator());
            ofInt.setDuration(500L);
            ofInt.addUpdateListener(new n(this));
            ValueAnimator ofFloat2 = ValueAnimator.ofFloat(1.0f, 0.8f);
            ofFloat2.setDuration(600L);
            ofFloat2.setInterpolator(new AccelerateInterpolator());
            ofFloat2.addUpdateListener(new o(this));
            ofFloat2.addListener(new a(this));
            ValueAnimator valueAnimator = this.p;
            if (valueAnimator != null && valueAnimator.isStarted()) {
                this.p.cancel();
            }
            ValueAnimator ofInt2 = ValueAnimator.ofInt(0);
            this.p = ofInt2;
            ofInt2.setDuration(3000L);
            this.p.addListener(new b(this));
            AnimatorSet animatorSet = this.n;
            if (animatorSet != null && animatorSet.isStarted()) {
                this.n.cancel();
            }
            AnimatorSet animatorSet2 = this.o;
            if (animatorSet2 != null && animatorSet2.isStarted()) {
                this.o.cancel();
            }
            ofInt.addListener(new c(this));
            AnimatorSet animatorSet3 = new AnimatorSet();
            this.o = animatorSet3;
            animatorSet3.addListener(new d(this, i2));
            this.o.playSequentially(ofFloat2, ofInt);
            ofObject.addListener(new e(this, ofFloat));
            AnimatorSet animatorSet4 = new AnimatorSet();
            this.n = animatorSet4;
            animatorSet4.playTogether(ofObject, ofFloat);
            this.n.start();
        }
    }
}
