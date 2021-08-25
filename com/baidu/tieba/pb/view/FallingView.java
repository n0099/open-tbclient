package com.baidu.tieba.pb.view;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.net.Uri;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.LinearInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import c.a.e.e.p.k;
import c.a.e.e.p.l;
import c.a.q0.i2.p.f;
import c.a.q0.i3.e0;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UrlManager;
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
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class FallingView extends FrameLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public TbImageView f55503e;

    /* renamed from: f  reason: collision with root package name */
    public final List<f> f55504f;

    /* renamed from: g  reason: collision with root package name */
    public final Context f55505g;

    /* renamed from: h  reason: collision with root package name */
    public int f55506h;

    /* renamed from: i  reason: collision with root package name */
    public int f55507i;

    /* renamed from: j  reason: collision with root package name */
    public boolean f55508j;
    public Paint k;
    public AnimatorSet l;
    public e m;
    public final Runnable n;
    public final Runnable o;

    /* loaded from: classes7.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ FallingView f55509e;

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
            this.f55509e = fallingView;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f55509e.invalidate();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ FallingView f55510e;

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
            this.f55510e = fallingView;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f55510e.n();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c extends BaseBitmapDataSubscriber {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ TbPageContext f55511a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ c.a.p0.u.a f55512b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ int f55513c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ FallingView f55514d;

        public c(FallingView fallingView, TbPageContext tbPageContext, c.a.p0.u.a aVar, int i2) {
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
            this.f55514d = fallingView;
            this.f55511a = tbPageContext;
            this.f55512b = aVar;
            this.f55513c = i2;
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
                this.f55514d.o(this.f55511a, this.f55512b, bitmap, this.f55513c);
                if (this.f55514d.m != null) {
                    this.f55514d.m.onAnimationStart();
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class d extends AnimatorListenerAdapter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ValueAnimator f55515e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ ValueAnimator f55516f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ FallingView f55517g;

        public d(FallingView fallingView, ValueAnimator valueAnimator, ValueAnimator valueAnimator2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fallingView, valueAnimator, valueAnimator2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f55517g = fallingView;
            this.f55515e = valueAnimator;
            this.f55516f = valueAnimator2;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, animator) == null) {
                this.f55515e.cancel();
                this.f55516f.cancel();
            }
        }
    }

    /* loaded from: classes7.dex */
    public interface e {
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

    public static /* synthetic */ float k(Random random) {
        return (random.nextInt(2) * 0.1f) + 0.8f;
    }

    public static /* synthetic */ void l(TbPageContext tbPageContext, c.a.p0.u.a aVar, int i2, View view) {
        if (tbPageContext == null) {
            return;
        }
        UrlManager urlManager = UrlManager.getInstance();
        urlManager.dealOneLink(tbPageContext, new String[]{"http://tieba.baidu.com/mo/q/checkurl?url=" + k.getUrlEncode(aVar.e())});
        TiebaStatic.log(new StatisticItem("c14126").param("obj_type", i2).param("uid", TbadkCoreApplication.getCurrentAccount()));
        e0.a(aVar.c());
    }

    public final void d(f fVar, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048576, this, fVar, i2) == null) {
            if (this.f55506h == 0) {
                this.f55506h = l.k(this.f55505g);
            }
            if (this.f55507i == 0) {
                this.f55507i = l.i(this.f55505g);
            }
            this.f55504f.clear();
            for (int i3 = 0; i3 < i2; i3++) {
                f fVar2 = new f(fVar.f20170i, this.f55506h, this.f55507i);
                fVar2.f20166e = (-i3) * 180;
                this.f55504f.add(fVar2);
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, canvas) == null) {
            long currentTimeMillis = System.currentTimeMillis();
            super.dispatchDraw(canvas);
            if (this.f55504f.size() > 0) {
                boolean z = false;
                for (int i2 = 0; i2 < this.f55504f.size(); i2++) {
                    z = this.f55504f.get(i2).b(canvas, this.k) || z;
                }
                if (z) {
                    postDelayed(this.n, (currentTimeMillis + 5) - System.currentTimeMillis());
                    return;
                }
                this.f55508j = false;
                e eVar = this.m;
                if (eVar != null) {
                    eVar.onAnimationEnd();
                }
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, motionEvent)) == null) {
            if (motionEvent.getAction() == 0 && f(this.f55503e, motionEvent.getX(), motionEvent.getY())) {
                if (this.f55503e.getOnClickListener() != null) {
                    this.f55503e.getOnClickListener().onClick(this.f55503e);
                    return true;
                }
                return true;
            }
            return super.dispatchTouchEvent(motionEvent);
        }
        return invokeL.booleanValue;
    }

    public final boolean e(c.a.p0.u.a aVar, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048579, this, aVar, i2)) == null) {
            if (aVar == null) {
                return false;
            }
            try {
                if (i2 == 2) {
                    int k = c.a.p0.s.d0.b.j().k("key_pb_commont_egg_limlit_a", 0);
                    if (TbSingleton.getInstance().getAdVertiSementData() != null && k < TbSingleton.getInstance().getAdVertiSementData().a()) {
                        c.a.p0.s.d0.b.j().v("key_pb_commont_egg_limlit_a", k + 1);
                        return true;
                    }
                } else {
                    String p = c.a.p0.s.d0.b.j().p("key_pb_commont_egg_limlit_bc", new JSONObject().toString());
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
                        c.a.p0.s.d0.b.j().x("key_pb_commont_egg_limlit_bc", jSONObject.toString());
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

    public final boolean f(View view, float f2, float f3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048580, this, new Object[]{view, Float.valueOf(f2), Float.valueOf(f3)})) == null) {
            float x = view.getX();
            float y = view.getY();
            return f2 >= x && f2 <= x + ((float) view.getWidth()) && f3 >= y && f3 <= y + ((float) view.getHeight());
        }
        return invokeCommon.booleanValue;
    }

    public final void g(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, context) == null) {
            this.f55503e = new TbImageView(context);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(l.g(context, R.dimen.tbds220), l.g(context, R.dimen.tbds220), 1);
            this.f55503e.setPadding(l.g(context, R.dimen.tbds20), l.g(context, R.dimen.tbds20), l.g(context, R.dimen.tbds20), l.g(context, R.dimen.tbds20));
            this.f55503e.setScaleType(ImageView.ScaleType.FIT_XY);
            this.f55503e.setPlaceHolder(2);
            this.f55503e.setVisibility(8);
            addView(this.f55503e, layoutParams);
            Paint paint = new Paint();
            this.k = paint;
            paint.setDither(true);
            setLayerType(1, null);
        }
    }

    public /* synthetic */ void h(ValueAnimator valueAnimator) {
        float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        TbImageView tbImageView = this.f55503e;
        tbImageView.setPivotX(tbImageView.getWidth() / 2);
        TbImageView tbImageView2 = this.f55503e;
        tbImageView2.setPivotY(tbImageView2.getHeight() / 2);
        this.f55503e.setScaleX(floatValue);
        this.f55503e.setScaleY(floatValue);
    }

    public /* synthetic */ void i(ValueAnimator valueAnimator) {
        this.f55503e.setX(((Integer) valueAnimator.getAnimatedValue()).intValue());
    }

    public boolean isFalling() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.f55508j : invokeV.booleanValue;
    }

    public /* synthetic */ void j(ValueAnimator valueAnimator) {
        this.f55503e.setY(((Integer) valueAnimator.getAnimatedValue()).intValue());
    }

    public final int m(int i2, int i3) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(1048586, this, i2, i3)) == null) {
            int mode = View.MeasureSpec.getMode(i3);
            int size = View.MeasureSpec.getSize(i3);
            return mode == 1073741824 ? size : mode == Integer.MIN_VALUE ? Math.min(i2, size) : i2;
        }
        return invokeII.intValue;
    }

    public final void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            if (this.f55503e.getVisibility() != 0) {
                this.f55503e.setVisibility(0);
            }
            ValueAnimator ofFloat = ValueAnimator.ofFloat(1.0f, 1.2f);
            ofFloat.setDuration(600L);
            ofFloat.setRepeatMode(2);
            ofFloat.setRepeatCount(-1);
            ofFloat.setInterpolator(new AccelerateInterpolator());
            ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: c.a.q0.i2.p.e
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, valueAnimator) == null) {
                        FallingView.this.h(valueAnimator);
                    }
                }
            });
            int i2 = l.i(this.f55505g);
            int k = l.k(this.f55505g);
            int width = this.f55503e.getWidth() / 2;
            ValueAnimator ofInt = ValueAnimator.ofInt(((k * 3) / 8) - width, ((k * 5) / 8) - width);
            ofInt.setDuration(2000L);
            ofInt.setRepeatMode(2);
            ofInt.setRepeatCount(-1);
            ofInt.setInterpolator(new AccelerateInterpolator());
            ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: c.a.q0.i2.p.c
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, valueAnimator) == null) {
                        FallingView.this.i(valueAnimator);
                    }
                }
            });
            ValueAnimator ofInt2 = ValueAnimator.ofInt((-i2) / 4, (i2 * 7) / 6);
            ofInt2.setDuration(7500L);
            ofInt2.setInterpolator(new LinearInterpolator());
            ofInt2.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: c.a.q0.i2.p.d
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, valueAnimator) == null) {
                        FallingView.this.j(valueAnimator);
                    }
                }
            });
            ofInt2.addListener(new d(this, ofFloat, ofInt));
            AnimatorSet animatorSet = this.l;
            if (animatorSet != null && animatorSet.isRunning()) {
                this.l.cancel();
            }
            AnimatorSet animatorSet2 = new AnimatorSet();
            this.l = animatorSet2;
            animatorSet2.playTogether(ofInt2, ofInt, ofFloat);
            this.l.start();
        }
    }

    public final void o(final TbPageContext<?> tbPageContext, final c.a.p0.u.a aVar, Bitmap bitmap, final int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLI(1048588, this, tbPageContext, aVar, bitmap, i2) == null) {
            final Random random = new Random();
            f.b bVar = new f.b(bitmap);
            bVar.p(l.g(TbadkCoreApplication.getInst(), R.dimen.tbds8), true);
            bVar.o(l.g(TbadkCoreApplication.getInst(), R.dimen.tbds200), l.g(TbadkCoreApplication.getInst(), R.dimen.tbds200), true);
            bVar.m(l.g(TbadkCoreApplication.getInst(), R.dimen.tbds100), l.g(TbadkCoreApplication.getInst(), R.dimen.tbds100));
            bVar.n(new f.c() { // from class: c.a.q0.i2.p.b
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // c.a.q0.i2.p.f.c
                public final float a() {
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    return (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) ? FallingView.k(random) : invokeV.floatValue;
                }
            });
            bVar.q(l.g(TbadkCoreApplication.getInst(), R.dimen.tbds40), true, true);
            d(bVar.l(), 19);
            postDelayed(this.o, 1500L);
            this.f55508j = true;
            invalidate();
            TiebaStatic.log(new StatisticItem("c14125").param("obj_type", i2).param("uid", TbadkCoreApplication.getCurrentAccount()));
            e0.a(aVar.i());
            this.f55503e.setOnClickListener(new View.OnClickListener() { // from class: c.a.q0.i2.p.a
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                        FallingView.l(TbPageContext.this, aVar, i2, view);
                    }
                }
            });
        }
    }

    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048589, this, i2, i3) == null) {
            super.onMeasure(i2, i3);
            int m = m(1000, i3);
            int m2 = m(600, i2);
            setMeasuredDimension(m2, m);
            this.f55506h = m2;
            this.f55507i = m;
        }
    }

    public void setAnimationListener(e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, eVar) == null) {
            this.m = eVar;
        }
    }

    public boolean showByLimit(c.a.p0.u.a aVar, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048591, this, aVar, i2)) == null) {
            if (aVar == null) {
                return false;
            }
            try {
                if (i2 == 2) {
                    int k = c.a.p0.s.d0.b.j().k("key_pb_commont_egg_limlit_a", 0);
                    if (TbSingleton.getInstance().getAdVertiSementData() != null && k < TbSingleton.getInstance().getAdVertiSementData().a()) {
                        return true;
                    }
                } else {
                    String p = c.a.p0.s.d0.b.j().p("key_pb_commont_egg_limlit_bc", new JSONObject().toString());
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

    public void start(c.a.p0.u.a aVar, TbPageContext<?> tbPageContext, int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLI(1048592, this, aVar, tbPageContext, i2) == null) && e(aVar, i2)) {
            this.f55503e.startLoad(aVar.g(), 10, false);
            Fresco.getImagePipeline().fetchDecodedImage(ImageRequestBuilder.newBuilderWithSource(Uri.parse(aVar.f())).setProgressiveRenderingEnabled(true).build(), this.f55505g).subscribe(new c(this, tbPageContext, aVar, i2), CallerThreadExecutor.getInstance());
        }
    }

    public void stopAllViews() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            this.f55508j = false;
            this.f55504f.clear();
            removeCallbacks(this.n);
            removeCallbacks(this.o);
            this.f55503e.setVisibility(8);
            AnimatorSet animatorSet = this.l;
            if (animatorSet != null) {
                animatorSet.cancel();
            }
            e eVar = this.m;
            if (eVar != null) {
                eVar.onAnimationEnd();
            }
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
        this.f55504f = new ArrayList();
        this.f55508j = false;
        this.n = new a(this);
        this.o = new b(this);
        this.f55505g = context;
        g(context);
    }
}
