package com.bumptech.glide.load.resource.bitmap;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bumptech.glide.TransitionOptions;
import com.bumptech.glide.request.transition.BitmapTransitionFactory;
import com.bumptech.glide.request.transition.DrawableCrossFadeFactory;
import com.bumptech.glide.request.transition.TransitionFactory;
/* loaded from: classes7.dex */
public final class BitmapTransitionOptions extends TransitionOptions {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public BitmapTransitionOptions() {
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

    public static BitmapTransitionOptions withCrossFade() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            return new BitmapTransitionOptions().crossFade();
        }
        return (BitmapTransitionOptions) invokeV.objValue;
    }

    public BitmapTransitionOptions crossFade() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return crossFade(new DrawableCrossFadeFactory.Builder());
        }
        return (BitmapTransitionOptions) invokeV.objValue;
    }

    public static BitmapTransitionOptions with(TransitionFactory transitionFactory) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, transitionFactory)) == null) {
            return (BitmapTransitionOptions) new BitmapTransitionOptions().transition(transitionFactory);
        }
        return (BitmapTransitionOptions) invokeL.objValue;
    }

    public static BitmapTransitionOptions withCrossFade(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65539, null, i)) == null) {
            return new BitmapTransitionOptions().crossFade(i);
        }
        return (BitmapTransitionOptions) invokeI.objValue;
    }

    public static BitmapTransitionOptions withWrapped(TransitionFactory transitionFactory) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, transitionFactory)) == null) {
            return new BitmapTransitionOptions().transitionUsing(transitionFactory);
        }
        return (BitmapTransitionOptions) invokeL.objValue;
    }

    public BitmapTransitionOptions crossFade(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i)) == null) {
            return crossFade(new DrawableCrossFadeFactory.Builder(i));
        }
        return (BitmapTransitionOptions) invokeI.objValue;
    }

    public BitmapTransitionOptions transitionUsing(TransitionFactory transitionFactory) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, transitionFactory)) == null) {
            return (BitmapTransitionOptions) transition(new BitmapTransitionFactory(transitionFactory));
        }
        return (BitmapTransitionOptions) invokeL.objValue;
    }

    public static BitmapTransitionOptions withCrossFade(DrawableCrossFadeFactory.Builder builder) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, builder)) == null) {
            return new BitmapTransitionOptions().crossFade(builder);
        }
        return (BitmapTransitionOptions) invokeL.objValue;
    }

    public BitmapTransitionOptions crossFade(DrawableCrossFadeFactory.Builder builder) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, builder)) == null) {
            return transitionUsing(builder.build());
        }
        return (BitmapTransitionOptions) invokeL.objValue;
    }

    public static BitmapTransitionOptions withCrossFade(DrawableCrossFadeFactory drawableCrossFadeFactory) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, drawableCrossFadeFactory)) == null) {
            return new BitmapTransitionOptions().crossFade(drawableCrossFadeFactory);
        }
        return (BitmapTransitionOptions) invokeL.objValue;
    }

    public BitmapTransitionOptions crossFade(DrawableCrossFadeFactory drawableCrossFadeFactory) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, drawableCrossFadeFactory)) == null) {
            return transitionUsing(drawableCrossFadeFactory);
        }
        return (BitmapTransitionOptions) invokeL.objValue;
    }
}
