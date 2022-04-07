package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import androidx.annotation.NonNull;
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
/* loaded from: classes4.dex */
public final class BitmapTransitionOptions extends TransitionOptions<BitmapTransitionOptions, Bitmap> {
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

    @NonNull
    public static BitmapTransitionOptions with(@NonNull TransitionFactory<Bitmap> transitionFactory) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65537, null, transitionFactory)) == null) ? new BitmapTransitionOptions().transition(transitionFactory) : (BitmapTransitionOptions) invokeL.objValue;
    }

    @NonNull
    public static BitmapTransitionOptions withCrossFade() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? new BitmapTransitionOptions().crossFade() : (BitmapTransitionOptions) invokeV.objValue;
    }

    @NonNull
    public static BitmapTransitionOptions withWrapped(@NonNull TransitionFactory<Drawable> transitionFactory) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65542, null, transitionFactory)) == null) ? new BitmapTransitionOptions().transitionUsing(transitionFactory) : (BitmapTransitionOptions) invokeL.objValue;
    }

    @NonNull
    public BitmapTransitionOptions crossFade() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? crossFade(new DrawableCrossFadeFactory.Builder()) : (BitmapTransitionOptions) invokeV.objValue;
    }

    @NonNull
    public BitmapTransitionOptions transitionUsing(@NonNull TransitionFactory<Drawable> transitionFactory) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, transitionFactory)) == null) ? transition(new BitmapTransitionFactory(transitionFactory)) : (BitmapTransitionOptions) invokeL.objValue;
    }

    @NonNull
    public static BitmapTransitionOptions withCrossFade(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(65539, null, i)) == null) ? new BitmapTransitionOptions().crossFade(i) : (BitmapTransitionOptions) invokeI.objValue;
    }

    @NonNull
    public BitmapTransitionOptions crossFade(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i)) == null) ? crossFade(new DrawableCrossFadeFactory.Builder(i)) : (BitmapTransitionOptions) invokeI.objValue;
    }

    @NonNull
    public static BitmapTransitionOptions withCrossFade(@NonNull DrawableCrossFadeFactory drawableCrossFadeFactory) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65541, null, drawableCrossFadeFactory)) == null) ? new BitmapTransitionOptions().crossFade(drawableCrossFadeFactory) : (BitmapTransitionOptions) invokeL.objValue;
    }

    @NonNull
    public BitmapTransitionOptions crossFade(@NonNull DrawableCrossFadeFactory drawableCrossFadeFactory) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, drawableCrossFadeFactory)) == null) ? transitionUsing(drawableCrossFadeFactory) : (BitmapTransitionOptions) invokeL.objValue;
    }

    @NonNull
    public static BitmapTransitionOptions withCrossFade(@NonNull DrawableCrossFadeFactory.Builder builder) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, builder)) == null) ? new BitmapTransitionOptions().crossFade(builder) : (BitmapTransitionOptions) invokeL.objValue;
    }

    @NonNull
    public BitmapTransitionOptions crossFade(@NonNull DrawableCrossFadeFactory.Builder builder) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, builder)) == null) ? transitionUsing(builder.build()) : (BitmapTransitionOptions) invokeL.objValue;
    }
}
