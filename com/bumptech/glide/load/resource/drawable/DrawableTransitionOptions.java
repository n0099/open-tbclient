package com.bumptech.glide.load.resource.drawable;

import android.graphics.drawable.Drawable;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bumptech.glide.TransitionOptions;
import com.bumptech.glide.request.transition.DrawableCrossFadeFactory;
import com.bumptech.glide.request.transition.TransitionFactory;
/* loaded from: classes5.dex */
public final class DrawableTransitionOptions extends TransitionOptions<DrawableTransitionOptions, Drawable> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public DrawableTransitionOptions() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    @NonNull
    public static DrawableTransitionOptions with(@NonNull TransitionFactory<Drawable> transitionFactory) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65537, null, transitionFactory)) == null) ? new DrawableTransitionOptions().transition(transitionFactory) : (DrawableTransitionOptions) invokeL.objValue;
    }

    @NonNull
    public static DrawableTransitionOptions withCrossFade() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? new DrawableTransitionOptions().crossFade() : (DrawableTransitionOptions) invokeV.objValue;
    }

    @NonNull
    public DrawableTransitionOptions crossFade() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? crossFade(new DrawableCrossFadeFactory.Builder()) : (DrawableTransitionOptions) invokeV.objValue;
    }

    @NonNull
    public static DrawableTransitionOptions withCrossFade(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(65539, null, i2)) == null) ? new DrawableTransitionOptions().crossFade(i2) : (DrawableTransitionOptions) invokeI.objValue;
    }

    @NonNull
    public DrawableTransitionOptions crossFade(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2)) == null) ? crossFade(new DrawableCrossFadeFactory.Builder(i2)) : (DrawableTransitionOptions) invokeI.objValue;
    }

    @NonNull
    public static DrawableTransitionOptions withCrossFade(@NonNull DrawableCrossFadeFactory drawableCrossFadeFactory) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.AD_TEXT_ID, null, drawableCrossFadeFactory)) == null) ? new DrawableTransitionOptions().crossFade(drawableCrossFadeFactory) : (DrawableTransitionOptions) invokeL.objValue;
    }

    @NonNull
    public DrawableTransitionOptions crossFade(@NonNull DrawableCrossFadeFactory drawableCrossFadeFactory) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, drawableCrossFadeFactory)) == null) ? transition(drawableCrossFadeFactory) : (DrawableTransitionOptions) invokeL.objValue;
    }

    @NonNull
    public static DrawableTransitionOptions withCrossFade(@NonNull DrawableCrossFadeFactory.Builder builder) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, builder)) == null) ? new DrawableTransitionOptions().crossFade(builder) : (DrawableTransitionOptions) invokeL.objValue;
    }

    @NonNull
    public DrawableTransitionOptions crossFade(@NonNull DrawableCrossFadeFactory.Builder builder) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, builder)) == null) ? crossFade(builder.build()) : (DrawableTransitionOptions) invokeL.objValue;
    }
}
