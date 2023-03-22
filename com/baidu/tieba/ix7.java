package com.baidu.tieba;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.animation.LinearInterpolator;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class ix7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes5.dex */
    public static class c {
        public static /* synthetic */ Interceptable $ic;
        public static ValueAnimator b;
        public transient /* synthetic */ FieldHolder $fh;
        public final Handler a;

        /* loaded from: classes5.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ View a;
            public final /* synthetic */ int b;
            public final /* synthetic */ int c;
            public final /* synthetic */ c d;

            public a(c cVar, View view2, int i, int i2) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {cVar, view2, Integer.valueOf(i), Integer.valueOf(i2)};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i3 = newInitContext.flag;
                    if ((i3 & 1) != 0) {
                        int i4 = i3 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.d = cVar;
                this.a = view2;
                this.b = i;
                this.c = i2;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.d.b(this.a, this.b, this.c, true);
                }
            }
        }

        /* loaded from: classes5.dex */
        public class b implements ValueAnimator.AnimatorUpdateListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ View a;

            public b(c cVar, View view2) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {cVar, view2};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = view2;
            }

            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, valueAnimator) == null) {
                    float intValue = (((Integer) valueAnimator.getAnimatedValue()).intValue() % 1000.0f) / 1000.0f;
                    if (intValue > 0.5d) {
                        intValue = 1.0f - intValue;
                    }
                    float f = (intValue * 2.0f * 0.20000005f) + 1.0f;
                    this.a.setScaleX(f);
                    this.a.setScaleY(f);
                }
            }
        }

        /* renamed from: com.baidu.tieba.ix7$c$c  reason: collision with other inner class name */
        /* loaded from: classes5.dex */
        public class C0302c implements Animator.AnimatorListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ View a;
            public final /* synthetic */ int b;
            public final /* synthetic */ int c;
            public final /* synthetic */ c d;

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, animator) == null) {
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048579, this, animator) == null) {
                }
            }

            public C0302c(c cVar, View view2, int i, int i2) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {cVar, view2, Integer.valueOf(i), Integer.valueOf(i2)};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i3 = newInitContext.flag;
                    if ((i3 & 1) != 0) {
                        int i4 = i3 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.d = cVar;
                this.a = view2;
                this.b = i;
                this.c = i2;
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, animator) == null) {
                    this.a.setScaleX(1.0f);
                    this.a.setScaleY(1.0f);
                    this.d.b(this.a, this.b, this.c, false);
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, animator) == null) {
                    this.a.setScaleX(1.0f);
                    this.a.setScaleY(1.0f);
                    this.d.b(this.a, this.b, this.c, false);
                }
            }
        }

        public c() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = new Handler(Looper.getMainLooper());
        }

        public void c() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                ValueAnimator valueAnimator = b;
                if (valueAnimator != null) {
                    valueAnimator.cancel();
                }
                b = null;
                this.a.removeCallbacksAndMessages(null);
            }
        }

        public void a(View view2, int i, int i2, boolean z) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view2, Integer.valueOf(i), Integer.valueOf(i2), Boolean.valueOf(z)}) == null) && view2 != null && i != 0) {
                c();
                b(view2, i, i2, z);
            }
        }

        public void b(View view2, int i, int i2, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{view2, Integer.valueOf(i), Integer.valueOf(i2), Boolean.valueOf(z)}) == null) {
                if (!z) {
                    this.a.postDelayed(new a(this, view2, i, i2), i2);
                    return;
                }
                ValueAnimator ofInt = ValueAnimator.ofInt(0, i);
                b = ofInt;
                ofInt.setDuration(i);
                b.addUpdateListener(new b(this, view2));
                b.setInterpolator(new LinearInterpolator());
                b.addListener(new C0302c(this, view2, i, i2));
                b.start();
            }
        }
    }

    /* loaded from: classes5.dex */
    public static class a extends AnimatorListenerAdapter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ View a;
        public final /* synthetic */ AnimatorListenerAdapter b;

        public a(View view2, AnimatorListenerAdapter animatorListenerAdapter) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {view2, animatorListenerAdapter};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = view2;
            this.b = animatorListenerAdapter;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            AnimatorListenerAdapter animatorListenerAdapter;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, animator) == null) && (animatorListenerAdapter = this.b) != null) {
                animatorListenerAdapter.onAnimationCancel(animator);
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            AnimatorListenerAdapter animatorListenerAdapter;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, animator) == null) && (animatorListenerAdapter = this.b) != null) {
                animatorListenerAdapter.onAnimationEnd(animator);
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, animator) == null) {
                super.onAnimationStart(animator);
                this.a.setVisibility(0);
                AnimatorListenerAdapter animatorListenerAdapter = this.b;
                if (animatorListenerAdapter != null) {
                    animatorListenerAdapter.onAnimationStart(animator);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public static class b extends AnimatorListenerAdapter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ View a;
        public final /* synthetic */ AnimatorListenerAdapter b;

        public b(View view2, AnimatorListenerAdapter animatorListenerAdapter) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {view2, animatorListenerAdapter};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = view2;
            this.b = animatorListenerAdapter;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, animator) == null) {
                this.a.setVisibility(8);
                this.a.setAlpha(0.0f);
                AnimatorListenerAdapter animatorListenerAdapter = this.b;
                if (animatorListenerAdapter != null) {
                    animatorListenerAdapter.onAnimationCancel(animator);
                }
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, animator) == null) {
                this.a.setVisibility(8);
                this.a.setAlpha(0.0f);
                AnimatorListenerAdapter animatorListenerAdapter = this.b;
                if (animatorListenerAdapter != null) {
                    animatorListenerAdapter.onAnimationEnd(animator);
                }
            }
        }
    }

    public static void a(View view2, AnimatorListenerAdapter animatorListenerAdapter) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65536, null, view2, animatorListenerAdapter) == null) {
            b(view2, animatorListenerAdapter, 300L);
        }
    }

    public static void c(View view2, AnimatorListenerAdapter animatorListenerAdapter) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65538, null, view2, animatorListenerAdapter) == null) {
            d(view2, animatorListenerAdapter, 300L);
        }
    }

    public static void b(View view2, AnimatorListenerAdapter animatorListenerAdapter, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65537, null, new Object[]{view2, animatorListenerAdapter, Long.valueOf(j)}) == null) {
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view2, View.ALPHA, 0.0f);
            ofFloat.setDuration(j);
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(view2, View.TRANSLATION_Y, 0.0f, view2.getMeasuredHeight());
            ofFloat2.setDuration(j);
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.playTogether(ofFloat2, ofFloat);
            animatorSet.addListener(new b(view2, animatorListenerAdapter));
            animatorSet.start();
        }
    }

    public static void d(View view2, AnimatorListenerAdapter animatorListenerAdapter, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65539, null, new Object[]{view2, animatorListenerAdapter, Long.valueOf(j)}) == null) {
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view2, View.ALPHA, 1.0f);
            ofFloat.setDuration(j);
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(view2, View.TRANSLATION_Y, view2.getMeasuredHeight(), 0.0f);
            ofFloat2.setDuration(j);
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.playTogether(ofFloat2, ofFloat);
            animatorSet.addListener(new a(view2, animatorListenerAdapter));
            animatorSet.start();
        }
    }
}
