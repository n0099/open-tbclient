package com.bumptech.glide.load.resource.drawable;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bumptech.glide.TransitionOptions;
import com.bumptech.glide.request.transition.DrawableCrossFadeFactory;
import com.bumptech.glide.request.transition.TransitionFactory;
/* loaded from: classes7.dex */
public final class DrawableTransitionOptions extends TransitionOptions {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public DrawableTransitionOptions() {
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

    public static DrawableTransitionOptions withCrossFade() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            return new DrawableTransitionOptions().crossFade();
        }
        return (DrawableTransitionOptions) invokeV.objValue;
    }

    public DrawableTransitionOptions crossFade() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return crossFade(new DrawableCrossFadeFactory.Builder());
        }
        return (DrawableTransitionOptions) invokeV.objValue;
    }

    public static DrawableTransitionOptions with(TransitionFactory transitionFactory) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, transitionFactory)) == null) {
            return (DrawableTransitionOptions) new DrawableTransitionOptions().transition(transitionFactory);
        }
        return (DrawableTransitionOptions) invokeL.objValue;
    }

    public static DrawableTransitionOptions withCrossFade(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65539, null, i)) == null) {
            return new DrawableTransitionOptions().crossFade(i);
        }
        return (DrawableTransitionOptions) invokeI.objValue;
    }

    public DrawableTransitionOptions crossFade(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i)) == null) {
            return crossFade(new DrawableCrossFadeFactory.Builder(i));
        }
        return (DrawableTransitionOptions) invokeI.objValue;
    }

    public static DrawableTransitionOptions withCrossFade(DrawableCrossFadeFactory.Builder builder) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, builder)) == null) {
            return new DrawableTransitionOptions().crossFade(builder);
        }
        return (DrawableTransitionOptions) invokeL.objValue;
    }

    public DrawableTransitionOptions crossFade(DrawableCrossFadeFactory.Builder builder) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, builder)) == null) {
            return crossFade(builder.build());
        }
        return (DrawableTransitionOptions) invokeL.objValue;
    }

    public static DrawableTransitionOptions withCrossFade(DrawableCrossFadeFactory drawableCrossFadeFactory) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, drawableCrossFadeFactory)) == null) {
            return new DrawableTransitionOptions().crossFade(drawableCrossFadeFactory);
        }
        return (DrawableTransitionOptions) invokeL.objValue;
    }

    public DrawableTransitionOptions crossFade(DrawableCrossFadeFactory drawableCrossFadeFactory) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, drawableCrossFadeFactory)) == null) {
            return (DrawableTransitionOptions) transition(drawableCrossFadeFactory);
        }
        return (DrawableTransitionOptions) invokeL.objValue;
    }
}
