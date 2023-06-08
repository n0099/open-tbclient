package com.baidu.tieba;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.view.animation.DecelerateInterpolator;
import android.widget.ProgressBar;
import androidx.constraintlayout.motion.widget.Key;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.ref.WeakReference;
/* loaded from: classes7.dex */
public class pl6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ObjectAnimator a;
    public ObjectAnimator b;

    /* loaded from: classes7.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes7.dex */
    public static class b extends AnimatorListenerAdapter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final WeakReference<ProgressBar> a;

        public b(ProgressBar progressBar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {progressBar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = new WeakReference<>(progressBar);
        }

        public /* synthetic */ b(ProgressBar progressBar, a aVar) {
            this(progressBar);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            ProgressBar progressBar;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, animator) == null) && (progressBar = this.a.get()) != null) {
                progressBar.setProgress(0);
                rm6.f(progressBar, 8);
                progressBar.setAlpha(1.0f);
            }
        }
    }

    /* loaded from: classes7.dex */
    public static class c implements ValueAnimator.AnimatorUpdateListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final WeakReference<ProgressBar> a;

        public c(ProgressBar progressBar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {progressBar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = new WeakReference<>(progressBar);
        }

        public /* synthetic */ c(ProgressBar progressBar, a aVar) {
            this(progressBar);
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            ProgressBar progressBar;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, valueAnimator) == null) && (progressBar = this.a.get()) != null) {
                float animatedFraction = valueAnimator.getAnimatedFraction();
                int progress = progressBar.getProgress();
                progressBar.setProgress((int) (progress + ((100 - progress) * animatedFraction)));
            }
        }
    }

    public pl6() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            ObjectAnimator objectAnimator = this.a;
            if (objectAnimator != null) {
                objectAnimator.cancel();
            }
            this.a = null;
            ObjectAnimator objectAnimator2 = this.b;
            if (objectAnimator2 != null) {
                objectAnimator2.cancel();
            }
            this.b = null;
        }
    }

    public void a(ProgressBar progressBar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, progressBar) == null) {
            ObjectAnimator objectAnimator = this.b;
            if (objectAnimator != null) {
                objectAnimator.cancel();
            }
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(progressBar, Key.ALPHA, 1.0f, 0.0f);
            this.b = ofFloat;
            ofFloat.setDuration(150L);
            this.b.setInterpolator(new DecelerateInterpolator());
            this.b.addUpdateListener(new c(progressBar, null));
            this.b.addListener(new b(progressBar, null));
            this.b.start();
        }
    }

    public void b(ProgressBar progressBar, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, progressBar, i) == null) {
            ObjectAnimator objectAnimator = this.a;
            if (objectAnimator == null) {
                ObjectAnimator ofInt = ObjectAnimator.ofInt(progressBar, "progress", 0);
                this.a = ofInt;
                ofInt.setDuration(100L);
                this.a.setInterpolator(new DecelerateInterpolator());
            } else {
                objectAnimator.cancel();
            }
            this.a.setIntValues(progressBar.getProgress(), i);
            this.a.start();
        }
    }
}
