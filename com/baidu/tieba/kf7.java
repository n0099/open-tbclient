package com.baidu.tieba;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.graphics.drawable.GradientDrawable;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewPropertyAnimator;
import android.widget.FrameLayout;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tieba.forum.ForumLog;
import com.baidu.tieba.forum.bubble.ForumFloatBubble;
import com.baidu.tieba.forum.widget.TbBottomSheetView;
import com.baidu.tieba.forum.widget.TbNestedScrollView;
import com.baidu.tieba.fp7;
import com.baidu.tieba.log.TbLog;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashSet;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes7.dex */
public final class kf7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final ForumFloatBubble a;
    public final int b;
    public ViewPropertyAnimator c;
    public TbBottomSheetView d;
    public View e;
    public fp7 f;
    public b g;

    /* loaded from: classes7.dex */
    public static final class a extends AnimatorListenerAdapter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ kf7 a;

        public a(kf7 kf7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {kf7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = kf7Var;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, animator) == null) {
                super.onAnimationEnd(animator);
                this.a.d();
            }
        }
    }

    /* loaded from: classes7.dex */
    public static final class b implements fp7 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ kf7 a;

        public b(kf7 kf7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {kf7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = kf7Var;
        }

        @Override // com.baidu.tieba.fp7
        public void a(TbNestedScrollView tbNestedScrollView, int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLII(1048576, this, tbNestedScrollView, i, i2) == null) {
                fp7.a.a(this, tbNestedScrollView, i, i2);
            }
        }

        @Override // com.baidu.tieba.fp7
        public void b(TbNestedScrollView v, int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, v, i, i2) == null) {
                Intrinsics.checkNotNullParameter(v, "v");
                this.a.e();
            }
        }
    }

    /* loaded from: classes7.dex */
    public static final class c implements fp7 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ View a;
        public final /* synthetic */ TbBottomSheetView b;
        public final /* synthetic */ int c;

        public c(View view2, TbBottomSheetView tbBottomSheetView, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {view2, tbBottomSheetView, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = view2;
            this.b = tbBottomSheetView;
            this.c = i;
        }

        @Override // com.baidu.tieba.fp7
        public void b(TbNestedScrollView v, int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, v, i, i2) == null) {
                Intrinsics.checkNotNullParameter(v, "v");
                this.a.setTranslationY(((Math.abs(this.b.getScrollY()) + this.b.getTop()) - this.a.getHeight()) + this.c);
            }
        }

        @Override // com.baidu.tieba.fp7
        public void a(TbNestedScrollView tbNestedScrollView, int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLII(1048576, this, tbNestedScrollView, i, i2) == null) {
                fp7.a.a(this, tbNestedScrollView, i, i2);
            }
        }
    }

    public kf7(ForumFloatBubble bubble) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bubble};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        Intrinsics.checkNotNullParameter(bubble, "bubble");
        this.a = bubble;
        this.b = UtilHelper.getDimenPixelSize(R.dimen.tbds36);
        this.g = new b(this);
    }

    public final void h(hf7 data) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, data) == null) {
            Intrinsics.checkNotNullParameter(data, "data");
            this.a.b(data);
            TbLog b2 = ForumLog.b.b();
            b2.i("BubbleHolder", "show forum guide bubble : " + data.b());
        }
    }

    public static final void b(kf7 this$0, TbBottomSheetView target) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65537, null, this$0, target) == null) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(target, "$target");
            this$0.a.setTranslationY(((Math.abs(target.getScrollY()) + target.getTop()) - this$0.a.getHeight()) - this$0.b);
            this$0.a.animate().alpha(1.0f).setDuration(150L).start();
        }
    }

    public final void a(ViewGroup parent, final TbBottomSheetView target) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, parent, target) == null) {
            Intrinsics.checkNotNullParameter(parent, "parent");
            Intrinsics.checkNotNullParameter(target, "target");
            if (this.a.getParent() != null) {
                return;
            }
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
            layoutParams.gravity = 1;
            this.a.setAlpha(0.0f);
            parent.addView(this.a, layoutParams);
            target.post(new Runnable() { // from class: com.baidu.tieba.cf7
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // java.lang.Runnable
                public final void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        kf7.b(kf7.this, target);
                    }
                }
            });
            target.getListeners().add(this.g);
        }
    }

    public static final void f(kf7 this$0, ValueAnimator valueAnimator) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65538, null, this$0, valueAnimator) == null) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Object animatedValue = valueAnimator.getAnimatedValue();
            if (animatedValue != null) {
                float floatValue = ((Float) animatedValue).floatValue();
                View view2 = this$0.e;
                if (view2 != null) {
                    view2.setAlpha(1 - floatValue);
                    return;
                }
                return;
            }
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Float");
        }
    }

    public static final void j(kf7 this$0, View shadow, TbBottomSheetView target, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLI(65539, null, this$0, shadow, target, i) == null) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(shadow, "$shadow");
            Intrinsics.checkNotNullParameter(target, "$target");
            if (this$0.a.getParent() != null) {
                shadow.setTranslationY(((Math.abs(target.getScrollY()) + target.getTop()) - shadow.getHeight()) + i);
                shadow.setVisibility(0);
            }
        }
    }

    public final void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            ViewPropertyAnimator viewPropertyAnimator = this.c;
            if (viewPropertyAnimator != null) {
                viewPropertyAnimator.setUpdateListener(null);
            }
            ViewPropertyAnimator viewPropertyAnimator2 = this.c;
            if (viewPropertyAnimator2 != null) {
                viewPropertyAnimator2.setListener(null);
            }
            ViewPropertyAnimator viewPropertyAnimator3 = this.c;
            if (viewPropertyAnimator3 != null) {
                viewPropertyAnimator3.cancel();
            }
        }
    }

    public final void d() {
        HashSet<fp7> listeners;
        TbBottomSheetView tbBottomSheetView;
        HashSet<fp7> listeners2;
        ViewGroup viewGroup;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            c();
            if (this.a.getParent() != null) {
                ViewParent parent = this.a.getParent();
                if (parent instanceof ViewGroup) {
                    viewGroup = (ViewGroup) parent;
                } else {
                    viewGroup = null;
                }
                if (viewGroup != null) {
                    viewGroup.removeView(this.a);
                }
                ForumLog.b.b().i("BubbleHolder", "detach forum guide bubble");
            }
            View view2 = this.e;
            if (view2 != null) {
                view2.setVisibility(8);
            }
            fp7 fp7Var = this.f;
            if (fp7Var != null && (tbBottomSheetView = this.d) != null && (listeners2 = tbBottomSheetView.getListeners()) != null) {
                listeners2.remove(fp7Var);
            }
            TbBottomSheetView tbBottomSheetView2 = this.d;
            if (tbBottomSheetView2 != null && (listeners = tbBottomSheetView2.getListeners()) != null) {
                listeners.remove(this.g);
            }
        }
    }

    public final void e() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048579, this) != null) || this.c != null) {
            return;
        }
        ViewPropertyAnimator duration = this.a.animate().alpha(0.0f).setUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.bf7
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, valueAnimator) == null) {
                    kf7.f(kf7.this, valueAnimator);
                }
            }
        }).setListener(new a(this)).setDuration(150L);
        duration.start();
        this.c = duration;
    }

    public final void g(int i) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeI(1048580, this, i) != null) || this.a.getParent() == null) {
            return;
        }
        this.a.a();
    }

    public final void i(final View shadow, final TbBottomSheetView target, final int i, String themeColor) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLIL(1048582, this, shadow, target, i, themeColor) == null) {
            Intrinsics.checkNotNullParameter(shadow, "shadow");
            Intrinsics.checkNotNullParameter(target, "target");
            Intrinsics.checkNotNullParameter(themeColor, "themeColor");
            this.d = target;
            this.e = shadow;
            int f = tua.f(themeColor);
            shadow.setBackground(new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, new int[]{tua.a(f, 0.0f), tua.a(f, 0.85f), f}));
            target.post(new Runnable() { // from class: com.baidu.tieba.af7
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // java.lang.Runnable
                public final void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        kf7.j(kf7.this, shadow, target, i);
                    }
                }
            });
            fp7 fp7Var = this.f;
            if (fp7Var != null) {
                target.getListeners().remove(fp7Var);
            }
            c cVar = new c(shadow, target, i);
            target.getListeners().add(cVar);
            this.f = cVar;
        }
    }
}
