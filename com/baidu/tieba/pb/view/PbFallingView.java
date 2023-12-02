package com.baidu.tieba.pb.view;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PointF;
import android.net.Uri;
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
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.elementsMaven.EMManager;
import com.baidu.tbadk.core.sharedPref.SharedPrefHelper;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.ThirdStatisticHelper;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.core.util.tbselector.selector.DrawableSelector;
import com.baidu.tbadk.data.AdverSegmentData;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.c6a;
import com.baidu.tieba.cs4;
import com.baidu.tieba.d6a;
import com.baidu.tieba.h5b;
import com.baidu.tieba.ky5;
import com.baidu.tieba.r6a;
import com.baidu.tieba.rd;
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
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ConcurrentLinkedQueue;
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
    public final List<r6a> f;
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
    public final ConcurrentLinkedQueue<r> q;
    public q r;
    public View s;
    public View t;
    public ImageView u;
    public TextView v;
    public o w;
    public final Runnable x;
    public final p y;
    public View.OnClickListener z;

    /* loaded from: classes7.dex */
    public interface o {
        void onClick();
    }

    /* loaded from: classes7.dex */
    public interface q {
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

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(1048576, this, animator) != null) {
                return;
            }
            this.a.s();
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
    public class c extends AnimatorListenerAdapter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ int a;
        public final /* synthetic */ AdverSegmentData b;
        public final /* synthetic */ PbFallingView c;

        public c(PbFallingView pbFallingView, int i, AdverSegmentData adverSegmentData) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbFallingView, Integer.valueOf(i), adverSegmentData};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = pbFallingView;
            this.a = i;
            this.b = adverSegmentData;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(1048576, this, animator) != null) {
                return;
            }
            this.c.B = 2;
            StatisticItem param = new StatisticItem("c14125").param("obj_type", this.a).param("obj_locate", this.c.B).param("uid", TbadkCoreApplication.getCurrentAccount());
            AdverSegmentData adverSegmentData = this.b;
            if (adverSegmentData != null) {
                ky5.a.b(param, adverSegmentData.activityId, adverSegmentData.mDisplayAdIcon, adverSegmentData.getViewStatisticsUrl());
            }
            TiebaStatic.log(param);
        }
    }

    /* loaded from: classes7.dex */
    public class d extends AnimatorListenerAdapter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ValueAnimator a;
        public final /* synthetic */ PbFallingView b;

        public d(PbFallingView pbFallingView, ValueAnimator valueAnimator) {
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
    public class e implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbFallingView a;

        public e(PbFallingView pbFallingView) {
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
                SharedPrefHelper.getInstance().putLong("key_pb_falling_ad_feedback_click_time", System.currentTimeMillis());
                this.a.z();
                if (this.a.w != null) {
                    this.a.w.onClick();
                    TiebaStatic.log(new StatisticItem("c14126").param("obj_type", this.a.A).param("obj_locate", 3).param("uid", TbadkCoreApplication.getCurrentAccount()));
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class f implements Runnable {
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

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.invalidate();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class g extends BaseBitmapDataSubscriber {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ TbPageContext a;
        public final /* synthetic */ AdverSegmentData b;
        public final /* synthetic */ int c;
        public final /* synthetic */ PbFallingView d;

        @Override // com.facebook.datasource.BaseDataSubscriber
        public void onFailureImpl(DataSource<CloseableReference<CloseableImage>> dataSource) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, dataSource) == null) {
            }
        }

        public g(PbFallingView pbFallingView, TbPageContext tbPageContext, AdverSegmentData adverSegmentData, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbFallingView, tbPageContext, adverSegmentData, Integer.valueOf(i)};
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
            this.b = adverSegmentData;
            this.c = i;
        }

        @Override // com.facebook.imagepipeline.datasource.BaseBitmapDataSubscriber
        public void onNewResultImpl(Bitmap bitmap) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bitmap) != null) {
                return;
            }
            this.d.y(this.a, this.b, bitmap, this.c);
        }
    }

    /* loaded from: classes7.dex */
    public class h implements r6a.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Random a;
        public final /* synthetic */ PbFallingView b;

        public h(PbFallingView pbFallingView, Random random) {
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

        @Override // com.baidu.tieba.r6a.c
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
    public class i implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ TbPageContext a;
        public final /* synthetic */ AdverSegmentData b;
        public final /* synthetic */ int c;
        public final /* synthetic */ PbFallingView d;

        public i(PbFallingView pbFallingView, TbPageContext tbPageContext, AdverSegmentData adverSegmentData, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbFallingView, tbPageContext, adverSegmentData, Integer.valueOf(i)};
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
            this.b = adverSegmentData;
            this.c = i;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            AdverSegmentData adverSegmentData;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && this.a != null && (adverSegmentData = this.b) != null) {
                String jumpExternalScheme = adverSegmentData.getJumpExternalScheme();
                if (!UtilHelper.isMatchScheme(this.a.getPageActivity(), jumpExternalScheme, this.b.getJumpExternalPackageName())) {
                    TbPageContext tbPageContext = this.a;
                    h5b.a(tbPageContext, cs4.a + rd.getUrlEncode(this.b.getJumpLink()));
                    jumpExternalScheme = this.b.getJumpLink();
                }
                String str = jumpExternalScheme;
                StatisticItem param = new StatisticItem("c14126").param("obj_type", this.c).param("obj_locate", this.d.B).param("uid", TbadkCoreApplication.getCurrentAccount());
                ky5.a aVar = ky5.a;
                AdverSegmentData adverSegmentData2 = this.b;
                aVar.a(param, adverSegmentData2.activityId, adverSegmentData2.mDisplayAdIcon, adverSegmentData2.getClickStatisticsUrl(), str);
                TiebaStatic.log(param);
                ThirdStatisticHelper.sendReq(this.b.getClickStatisticsUrl());
            }
        }
    }

    /* loaded from: classes7.dex */
    public class j implements ValueAnimator.AnimatorUpdateListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbFallingView a;

        public j(PbFallingView pbFallingView) {
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
    public class k implements ValueAnimator.AnimatorUpdateListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbFallingView a;

        public k(PbFallingView pbFallingView) {
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
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                this.a.a.setPivotX(this.a.a.getWidth() / 2);
                this.a.a.setPivotY(this.a.a.getHeight() / 2);
                this.a.a.setScaleX(floatValue);
                this.a.a.setScaleY(floatValue);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class n extends AnimatorListenerAdapter {
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
    public static class p implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final WeakReference<PbFallingView> a;
        public AdverSegmentData b;

        public p(PbFallingView pbFallingView) {
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
            this.a = new WeakReference<>(pbFallingView);
        }

        public /* synthetic */ p(PbFallingView pbFallingView, f fVar) {
            this(pbFallingView);
        }

        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.b = null;
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            PbFallingView pbFallingView;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) != null) || (pbFallingView = this.a.get()) == null) {
                return;
            }
            pbFallingView.t(pbFallingView.A, this.b);
        }
    }

    /* loaded from: classes7.dex */
    public static class r {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final AdverSegmentData a;
        public final TbPageContext<?> b;
        public final int c;

        public r(AdverSegmentData adverSegmentData, TbPageContext<?> tbPageContext, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {adverSegmentData, tbPageContext, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = adverSegmentData;
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

    public final void o(r6a r6aVar, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, r6aVar, i2) == null) {
            if (this.h == 0) {
                this.h = BdUtilHelper.getEquipmentWidth(this.g);
            }
            if (this.i == 0) {
                this.i = BdUtilHelper.getEquipmentHeight(this.g);
            }
            this.f.clear();
            for (int i3 = 0; i3 < i2; i3++) {
                r6a r6aVar2 = new r6a(r6aVar.i, this.h, this.i);
                r6aVar2.e = (-i3) * 180;
                this.f.add(r6aVar2);
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
        this.x = new f(this);
        this.y = new p(this, null);
        this.A = -1;
        this.B = -1;
        this.g = context;
        q(context);
    }

    public final boolean w(AdverSegmentData adverSegmentData, TbPageContext<?> tbPageContext, int i2) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(1048589, this, adverSegmentData, tbPageContext, i2)) == null) {
            if (!d6a.a(adverSegmentData, i2)) {
                return false;
            }
            this.B = 1;
            if (!StringUtils.isNull(adverSegmentData.getFloatingText())) {
                String floatingText = adverSegmentData.getFloatingText();
                if (floatingText.length() > 10) {
                    floatingText = floatingText.substring(0, 9) + "...";
                }
                this.e.setText(floatingText);
            } else {
                this.e.setText(this.g.getString(R.string.check_immediately));
            }
            this.a.startLoad(adverSegmentData.getPicClick(), 10, false);
            Fresco.getImagePipeline().fetchDecodedImage(ImageRequestBuilder.newBuilderWithSource(Uri.parse(adverSegmentData.getPic())).setProgressiveRenderingEnabled(true).build(), TbadkCoreApplication.getInst()).subscribe(new g(this, tbPageContext, adverSegmentData, i2), CallerThreadExecutor.getInstance());
            return true;
        }
        return invokeLLI.booleanValue;
    }

    public void setAnimationListener(q qVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, qVar) == null) {
            this.r = qVar;
        }
    }

    public void setFallingFeedbackListener(o oVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, oVar) == null) {
            this.w = oVar;
        }
    }

    public final void v(AdverSegmentData adverSegmentData) {
        View view2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, adverSegmentData) == null) {
            if (adverSegmentData != null && !adverSegmentData.isDisplayAdIcon() && (view2 = this.s) != null) {
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
        if (interceptable == null || interceptable.invokeII(1048579, this, i2, i3) == null) {
            super.onMeasure(i2, i3);
            int c2 = d6a.c(1000, i3);
            int c3 = d6a.c(600, i2);
            setMeasuredDimension(c3, c2);
            this.h = c3;
            this.i = c2;
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, canvas) == null) {
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
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, motionEvent)) == null) {
            if (this.b.getVisibility() != 0) {
                return super.dispatchTouchEvent(motionEvent);
            }
            if (motionEvent.getAction() == 0 && p(this.b, motionEvent.getX(), motionEvent.getY())) {
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

    public final boolean p(View view2, float f2, float f3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048580, this, new Object[]{view2, Float.valueOf(f2), Float.valueOf(f3)})) == null) {
            float x = view2.getX();
            float y = view2.getY();
            if (f2 >= x && f2 <= x + view2.getWidth() && f3 >= y && f3 <= y + view2.getHeight()) {
                return true;
            }
            return false;
        }
        return invokeCommon.booleanValue;
    }

    public final void q(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, context) == null) {
            View inflate = LayoutInflater.from(context).inflate(R.layout.obfuscated_res_0x7f0d02e7, (ViewGroup) null, false);
            this.b = inflate;
            this.c = inflate.findViewById(R.id.expand_layout);
            this.d = this.b.findViewById(R.id.obfuscated_res_0x7f090afb);
            this.e = (TextView) this.b.findViewById(R.id.expand_text);
            this.a = (TbImageView) this.b.findViewById(R.id.obfuscated_res_0x7f09076b);
            EMManager.from(this.c).setCorner(R.string.J_X01).setBackGroundColor(R.color.CAM_X0608);
            EMManager.from(this.e).setTextStyle(R.string.F_X01).setTextColor(R.color.CAM_X0101);
            EMManager.from(this.d).setCorner(R.string.J_X01).setBackGroundColor(R.color.CAM_X0317);
            ViewGroup.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
            this.a.setConrers(15);
            this.a.setPadding(BdUtilHelper.getDimens(context, R.dimen.tbds10), BdUtilHelper.getDimens(context, R.dimen.tbds5), BdUtilHelper.getDimens(context, R.dimen.tbds10), BdUtilHelper.getDimens(context, R.dimen.tbds5));
            this.a.setPlaceHolder(2);
            addView(this.b, layoutParams);
            View inflate2 = LayoutInflater.from(context).inflate(R.layout.obfuscated_res_0x7f0d02e6, (ViewGroup) null, false);
            this.s = inflate2;
            this.t = inflate2.findViewById(R.id.obfuscated_res_0x7f0900ee);
            this.u = (ImageView) this.s.findViewById(R.id.obfuscated_res_0x7f090b3d);
            this.v = (TextView) this.s.findViewById(R.id.obfuscated_res_0x7f090b3c);
            u();
            DrawableSelector.make().trRadius(BdUtilHelper.getDimens(getContext(), R.dimen.tbds26)).brRadius(BdUtilHelper.getDimens(getContext(), R.dimen.tbds26)).defaultColor(R.color.CAM_X0624).into(this.t);
            FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-2, -2);
            layoutParams2.gravity = 3;
            WebPManager.setPureDrawable(this.u, R.drawable.obfuscated_res_0x7f0808d2, R.color.CAM_X0101, null);
            EMManager.from(this.v).setTextColor(R.color.CAM_X0101);
            this.s.setY(BdUtilHelper.getEquipmentHeight(this.g) - BdUtilHelper.getDimens(this.g, R.dimen.tbds720));
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
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.j;
        }
        return invokeV.booleanValue;
    }

    public final void u() {
        View view2;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048587, this) != null) || (view2 = this.s) == null) {
            return;
        }
        view2.setOnClickListener(new e(this));
    }

    public final void s() {
        int i2;
        q qVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            z();
            r poll = this.q.poll();
            if (poll != null) {
                boolean w = w(poll.a, poll.b, poll.c);
                View view2 = this.s;
                if (w) {
                    i2 = 0;
                } else {
                    i2 = 8;
                }
                view2.setVisibility(i2);
                if (w) {
                    v(poll.a);
                } else {
                    this.s.setVisibility(8);
                }
                if (!w && (qVar = this.r) != null) {
                    qVar.onAnimationEnd();
                    return;
                }
                return;
            }
            q qVar2 = this.r;
            if (qVar2 != null) {
                qVar2.onAnimationEnd();
            }
        }
    }

    public void z() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            this.j = false;
            this.l = false;
            this.f.clear();
            removeCallbacks(this.x);
            this.y.a();
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

    public final void t(int i2, AdverSegmentData adverSegmentData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048586, this, i2, adverSegmentData) == null) {
            if (this.b.getVisibility() != 0) {
                this.b.setVisibility(0);
            }
            ValueAnimator ofFloat = ValueAnimator.ofFloat(1.0f, 1.2f);
            ofFloat.setDuration(600L);
            ofFloat.setRepeatMode(2);
            ofFloat.setRepeatCount(-1);
            ofFloat.setInterpolator(new AccelerateInterpolator());
            ofFloat.addUpdateListener(new j(this));
            int height = getHeight();
            float width = getWidth();
            PointF pointF = new PointF(((3.0f * width) / 4.0f) - (this.a.getWidth() / 2), (-height) / 4.0f);
            float f2 = height;
            ValueAnimator ofObject = ValueAnimator.ofObject(new c6a(new PointF(BdUtilHelper.getDimens(this.g, R.dimen.tbds50), BdUtilHelper.getDimens(this.g, R.dimen.tbds400)), new PointF((width / 2.0f) - BdUtilHelper.getDimens(this.g, R.dimen.tbds50), f2 - BdUtilHelper.getDimens(this.g, R.dimen.tbds655))), pointF, new PointF(BdUtilHelper.getDimens(this.g, R.dimen.tbds0), f2 - BdUtilHelper.getDimens(this.g, R.dimen.tbds552)));
            ofObject.setDuration(5000L);
            ofObject.addUpdateListener(new k(this));
            ValueAnimator ofInt = ValueAnimator.ofInt(0, d6a.b(this.c));
            ofInt.setInterpolator(new LinearInterpolator());
            ofInt.setDuration(500L);
            ofInt.addUpdateListener(new l(this));
            ValueAnimator ofFloat2 = ValueAnimator.ofFloat(1.0f, 0.8f);
            ofFloat2.setDuration(600L);
            ofFloat2.setInterpolator(new AccelerateInterpolator());
            ofFloat2.addUpdateListener(new m(this));
            ofFloat2.addListener(new n(this));
            ValueAnimator valueAnimator = this.p;
            if (valueAnimator != null && valueAnimator.isStarted()) {
                this.p.cancel();
            }
            ValueAnimator ofInt2 = ValueAnimator.ofInt(0);
            this.p = ofInt2;
            ofInt2.setDuration(3000L);
            this.p.addListener(new a(this));
            AnimatorSet animatorSet = this.n;
            if (animatorSet != null && animatorSet.isStarted()) {
                this.n.cancel();
            }
            AnimatorSet animatorSet2 = this.o;
            if (animatorSet2 != null && animatorSet2.isStarted()) {
                this.o.cancel();
            }
            ofInt.addListener(new b(this));
            AnimatorSet animatorSet3 = new AnimatorSet();
            this.o = animatorSet3;
            animatorSet3.addListener(new c(this, i2, adverSegmentData));
            this.o.playSequentially(ofFloat2, ofInt);
            ofObject.addListener(new d(this, ofFloat));
            AnimatorSet animatorSet4 = new AnimatorSet();
            this.n = animatorSet4;
            animatorSet4.playTogether(ofObject, ofFloat);
            this.n.start();
        }
    }

    public void x(AdverSegmentData adverSegmentData, TbPageContext<?> tbPageContext, int i2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048590, this, new Object[]{adverSegmentData, tbPageContext, Integer.valueOf(i2), Boolean.valueOf(z)}) == null) {
            if (z) {
                z();
                if (w(adverSegmentData, tbPageContext, i2)) {
                    v(adverSegmentData);
                    q qVar = this.r;
                    if (qVar != null) {
                        qVar.onAnimationStart();
                    }
                }
            } else if (this.j) {
                this.q.add(new r(adverSegmentData, tbPageContext, i2));
            } else if (w(adverSegmentData, tbPageContext, i2)) {
                v(adverSegmentData);
                q qVar2 = this.r;
                if (qVar2 != null) {
                    qVar2.onAnimationStart();
                }
            }
        }
    }

    public final void y(TbPageContext<?> tbPageContext, AdverSegmentData adverSegmentData, Bitmap bitmap, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLI(1048591, this, tbPageContext, adverSegmentData, bitmap, i2) == null) {
            Random random = new Random();
            r6a.b bVar = new r6a.b(bitmap);
            bVar.o(BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds8), true);
            bVar.n(BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds200), BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds200), true);
            bVar.l(BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds100), BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds100));
            bVar.m(new h(this, random));
            bVar.p(true, true);
            r6a k2 = bVar.k();
            this.A = i2;
            o(k2, 19);
            p pVar = this.y;
            pVar.b = adverSegmentData;
            postDelayed(pVar, 1500L);
            this.j = true;
            invalidate();
            StatisticItem param = new StatisticItem("c14125").param("obj_type", i2).param("obj_locate", this.B).param("uid", TbadkCoreApplication.getCurrentAccount());
            if (adverSegmentData != null) {
                ky5.a.b(param, adverSegmentData.activityId, adverSegmentData.mDisplayAdIcon, adverSegmentData.getViewStatisticsUrl());
            }
            TiebaStatic.log(param);
            ThirdStatisticHelper.sendReq(adverSegmentData.getViewStatisticsUrl());
            this.z = new i(this, tbPageContext, adverSegmentData, i2);
        }
    }
}
