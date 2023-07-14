package com.baidu.tieba;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.view.View;
import android.widget.ImageView;
import com.airbnb.lottie.LottieAnimationView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.live.interfaces.like.ILiveLikeView;
import com.baidu.searchbox.live.interfaces.like.LiveLikeAnimatorCallback;
import com.baidu.tieba.medialive.like.HeartSurfaceView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class p49 implements ILiveLikeView {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public float a;
    public int b;
    public float c;

    /* loaded from: classes7.dex */
    public class a implements ValueAnimator.AnimatorUpdateListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ LottieAnimationView a;

        public a(p49 p49Var, LottieAnimationView lottieAnimationView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {p49Var, lottieAnimationView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = lottieAnimationView;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, valueAnimator) == null) {
                this.a.setProgress(((Float) valueAnimator.getAnimatedValue()).floatValue());
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements HeartSurfaceView.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ LiveLikeAnimatorCallback a;

        public b(p49 p49Var, LiveLikeAnimatorCallback liveLikeAnimatorCallback) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {p49Var, liveLikeAnimatorCallback};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = liveLikeAnimatorCallback;
        }

        @Override // com.baidu.tieba.medialive.like.HeartSurfaceView.e
        public void a(int i, int i2) {
            LiveLikeAnimatorCallback liveLikeAnimatorCallback;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeII(1048576, this, i, i2) == null) && (liveLikeAnimatorCallback = this.a) != null) {
                liveLikeAnimatorCallback.onAnimLocation(0, i, i2);
            }
        }
    }

    public p49() {
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
        this.a = 1.0f;
        this.b = 500;
        this.c = 0.4f;
    }

    @Override // com.baidu.searchbox.live.interfaces.like.ILiveLikeView
    public View getLikeAnimatorView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            LottieAnimationView lottieAnimationView = new LottieAnimationView(AppRuntime.getAppContext());
            lottieAnimationView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            lottieAnimationView.setAnimation("lottie/liveshow_video_like_explosion.json");
            return lottieAnimationView;
        }
        return (View) invokeV.objValue;
    }

    @Override // com.baidu.searchbox.live.interfaces.like.ILiveLikeView
    public View getLikeView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            HeartSurfaceView heartSurfaceView = new HeartSurfaceView(AppRuntime.getAppContext());
            heartSurfaceView.setUpResNormalMode();
            heartSurfaceView.setZOrderOnTop(true);
            heartSurfaceView.getHolder().setFormat(-3);
            return heartSurfaceView;
        }
        return (View) invokeV.objValue;
    }

    @Override // com.baidu.searchbox.live.interfaces.like.ILiveLikeView
    public void addLikeAnimation(View view2, int i) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLI(1048576, this, view2, i) == null) && (view2 instanceof HeartSurfaceView)) {
            ((HeartSurfaceView) view2).p(i);
        }
    }

    @Override // com.baidu.searchbox.live.interfaces.like.ILiveLikeView
    public void setAnimatorListener(View view2, Animator.AnimatorListener animatorListener) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048581, this, view2, animatorListener) == null) && (view2 instanceof LottieAnimationView)) {
            ((LottieAnimationView) view2).addAnimatorListener(animatorListener);
        }
    }

    @Override // com.baidu.searchbox.live.interfaces.like.ILiveLikeView
    public void setLikeAnimatorListener(View view2, LiveLikeAnimatorCallback liveLikeAnimatorCallback) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048582, this, view2, liveLikeAnimatorCallback) == null) && (view2 instanceof LottieAnimationView)) {
            ((HeartSurfaceView) view2).setAnimateEndListener(new b(this, liveLikeAnimatorCallback));
        }
    }

    @Override // com.baidu.searchbox.live.interfaces.like.ILiveLikeView
    public View getLikeRippleView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            LottieAnimationView lottieAnimationView = new LottieAnimationView(AppRuntime.getAppContext());
            lottieAnimationView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            lottieAnimationView.setAnimation("lottie/liveshow_video_like_bg.json");
            ValueAnimator ofFloat = ValueAnimator.ofFloat(this.c, this.a);
            ofFloat.setDuration(this.b);
            ofFloat.addUpdateListener(new a(this, lottieAnimationView));
            lottieAnimationView.setTag(ofFloat);
            return lottieAnimationView;
        }
        return (View) invokeV.objValue;
    }

    @Override // com.baidu.searchbox.live.interfaces.like.ILiveLikeView
    public void playAnimation(View view2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048580, this, view2) == null) && (view2 instanceof LottieAnimationView)) {
            ((LottieAnimationView) view2).playAnimation();
        }
    }

    @Override // com.baidu.searchbox.live.interfaces.like.ILiveLikeView
    public void startRipple(View view2) {
        Object tag;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048583, this, view2) == null) && (view2 instanceof LottieAnimationView) && (tag = view2.getTag()) != null && (tag instanceof ValueAnimator)) {
            ((ValueAnimator) tag).start();
        }
    }
}
