package com.bumptech.glide;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bumptech.glide.request.transition.NoTransition;
import com.bumptech.glide.request.transition.TransitionFactory;
import com.bumptech.glide.request.transition.ViewAnimationFactory;
import com.bumptech.glide.request.transition.ViewPropertyAnimationFactory;
import com.bumptech.glide.request.transition.ViewPropertyTransition;
import com.bumptech.glide.util.Preconditions;
/* loaded from: classes7.dex */
public abstract class TransitionOptions implements Cloneable {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TransitionFactory transitionFactory;

    private TransitionOptions self() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65537, this)) == null) ? this : (TransitionOptions) invokeV.objValue;
    }

    public TransitionOptions() {
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
        this.transitionFactory = NoTransition.getFactory();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* renamed from: clone */
    public final TransitionOptions m74clone() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            try {
                return (TransitionOptions) super.clone();
            } catch (CloneNotSupportedException e) {
                throw new RuntimeException(e);
            }
        }
        return (TransitionOptions) invokeV.objValue;
    }

    public final TransitionOptions dontTransition() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return transition(NoTransition.getFactory());
        }
        return (TransitionOptions) invokeV.objValue;
    }

    public final TransitionFactory getTransitionFactory() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.transitionFactory;
        }
        return (TransitionFactory) invokeV.objValue;
    }

    public final TransitionOptions transition(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048580, this, i)) == null) {
            return transition(new ViewAnimationFactory(i));
        }
        return (TransitionOptions) invokeI.objValue;
    }

    public final TransitionOptions transition(TransitionFactory transitionFactory) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, transitionFactory)) == null) {
            this.transitionFactory = (TransitionFactory) Preconditions.checkNotNull(transitionFactory);
            return self();
        }
        return (TransitionOptions) invokeL.objValue;
    }

    public final TransitionOptions transition(ViewPropertyTransition.Animator animator) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, animator)) == null) {
            return transition(new ViewPropertyAnimationFactory(animator));
        }
        return (TransitionOptions) invokeL.objValue;
    }
}
