package com.bumptech.glide.request.transition;

import android.content.Context;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.request.transition.ViewTransition;
/* loaded from: classes11.dex */
public class ViewAnimationFactory<R> implements TransitionFactory<R> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Transition<R> transition;
    public final ViewTransition.ViewTransitionAnimationFactory viewTransitionAnimationFactory;

    /* loaded from: classes11.dex */
    public static class ConcreteViewTransitionAnimationFactory implements ViewTransition.ViewTransitionAnimationFactory {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final Animation animation;

        public ConcreteViewTransitionAnimationFactory(Animation animation) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {animation};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.animation = animation;
        }

        @Override // com.bumptech.glide.request.transition.ViewTransition.ViewTransitionAnimationFactory
        public Animation build(Context context) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, context)) == null) ? this.animation : (Animation) invokeL.objValue;
        }
    }

    /* loaded from: classes11.dex */
    public static class ResourceViewTransitionAnimationFactory implements ViewTransition.ViewTransitionAnimationFactory {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final int animationId;

        public ResourceViewTransitionAnimationFactory(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.animationId = i2;
        }

        @Override // com.bumptech.glide.request.transition.ViewTransition.ViewTransitionAnimationFactory
        public Animation build(Context context) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, context)) == null) ? AnimationUtils.loadAnimation(context, this.animationId) : (Animation) invokeL.objValue;
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ViewAnimationFactory(Animation animation) {
        this(new ConcreteViewTransitionAnimationFactory(animation));
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {animation};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                this((ViewTransition.ViewTransitionAnimationFactory) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    @Override // com.bumptech.glide.request.transition.TransitionFactory
    public Transition<R> build(DataSource dataSource, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048576, this, dataSource, z)) == null) {
            if (dataSource != DataSource.MEMORY_CACHE && z) {
                if (this.transition == null) {
                    this.transition = new ViewTransition(this.viewTransitionAnimationFactory);
                }
                return this.transition;
            }
            return NoTransition.get();
        }
        return (Transition) invokeLZ.objValue;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ViewAnimationFactory(int i2) {
        this(new ResourceViewTransitionAnimationFactory(i2));
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i2)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                this((ViewTransition.ViewTransitionAnimationFactory) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public ViewAnimationFactory(ViewTransition.ViewTransitionAnimationFactory viewTransitionAnimationFactory) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {viewTransitionAnimationFactory};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.viewTransitionAnimationFactory = viewTransitionAnimationFactory;
    }
}
