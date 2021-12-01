package com.bumptech.glide;

import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bumptech.glide.TransitionOptions;
import com.bumptech.glide.request.transition.NoTransition;
import com.bumptech.glide.request.transition.TransitionFactory;
import com.bumptech.glide.request.transition.ViewAnimationFactory;
import com.bumptech.glide.request.transition.ViewPropertyAnimationFactory;
import com.bumptech.glide.request.transition.ViewPropertyTransition;
import com.bumptech.glide.util.Preconditions;
/* loaded from: classes12.dex */
public abstract class TransitionOptions<CHILD extends TransitionOptions<CHILD, TranscodeType>, TranscodeType> implements Cloneable {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TransitionFactory<? super TranscodeType> transitionFactory;

    public TransitionOptions() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.transitionFactory = NoTransition.getFactory();
    }

    private CHILD self() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65537, this)) == null) ? this : (CHILD) invokeV.objValue;
    }

    @NonNull
    public final CHILD dontTransition() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? transition(NoTransition.getFactory()) : (CHILD) invokeV.objValue;
    }

    public final TransitionFactory<? super TranscodeType> getTransitionFactory() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.transitionFactory : (TransitionFactory) invokeV.objValue;
    }

    @NonNull
    public final CHILD transition(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048580, this, i2)) == null) ? transition(new ViewAnimationFactory(i2)) : (CHILD) invokeI.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* renamed from: clone */
    public final CHILD m98clone() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            try {
                return (CHILD) super.clone();
            } catch (CloneNotSupportedException e2) {
                throw new RuntimeException(e2);
            }
        }
        return (CHILD) invokeV.objValue;
    }

    @NonNull
    public final CHILD transition(@NonNull ViewPropertyTransition.Animator animator) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, animator)) == null) ? transition(new ViewPropertyAnimationFactory(animator)) : (CHILD) invokeL.objValue;
    }

    @NonNull
    public final CHILD transition(@NonNull TransitionFactory<? super TranscodeType> transitionFactory) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, transitionFactory)) == null) {
            this.transitionFactory = (TransitionFactory) Preconditions.checkNotNull(transitionFactory);
            return self();
        }
        return (CHILD) invokeL.objValue;
    }
}
