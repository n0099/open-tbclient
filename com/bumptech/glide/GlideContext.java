package com.bumptech.glide;

import android.content.Context;
import android.content.ContextWrapper;
import android.os.Handler;
import android.os.Looper;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.VisibleForTesting;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bumptech.glide.load.engine.Engine;
import com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool;
import com.bumptech.glide.request.RequestOptions;
import com.bumptech.glide.request.target.ImageViewTargetFactory;
import com.bumptech.glide.request.target.ViewTarget;
import java.util.Map;
/* loaded from: classes12.dex */
public class GlideContext extends ContextWrapper {
    public static /* synthetic */ Interceptable $ic;
    @VisibleForTesting
    public static final TransitionOptions<?, ?> DEFAULT_TRANSITION_OPTIONS;
    public transient /* synthetic */ FieldHolder $fh;
    public final ArrayPool arrayPool;
    public final RequestOptions defaultRequestOptions;
    public final Map<Class<?>, TransitionOptions<?, ?>> defaultTransitionOptions;
    public final Engine engine;
    public final ImageViewTargetFactory imageViewTargetFactory;
    public final int logLevel;
    public final Handler mainHandler;
    public final Registry registry;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(675187326, "Lcom/bumptech/glide/GlideContext;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(675187326, "Lcom/bumptech/glide/GlideContext;");
                return;
            }
        }
        DEFAULT_TRANSITION_OPTIONS = new GenericTransitionOptions();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GlideContext(@NonNull Context context, @NonNull ArrayPool arrayPool, @NonNull Registry registry, @NonNull ImageViewTargetFactory imageViewTargetFactory, @NonNull RequestOptions requestOptions, @NonNull Map<Class<?>, TransitionOptions<?, ?>> map, @NonNull Engine engine, int i2) {
        super(context.getApplicationContext());
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, arrayPool, registry, imageViewTargetFactory, requestOptions, map, engine, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.arrayPool = arrayPool;
        this.registry = registry;
        this.imageViewTargetFactory = imageViewTargetFactory;
        this.defaultRequestOptions = requestOptions;
        this.defaultTransitionOptions = map;
        this.engine = engine;
        this.logLevel = i2;
        this.mainHandler = new Handler(Looper.getMainLooper());
    }

    @NonNull
    public <X> ViewTarget<ImageView, X> buildImageViewTarget(@NonNull ImageView imageView, @NonNull Class<X> cls) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, imageView, cls)) == null) ? this.imageViewTargetFactory.buildTarget(imageView, cls) : (ViewTarget) invokeLL.objValue;
    }

    @NonNull
    public ArrayPool getArrayPool() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.arrayPool : (ArrayPool) invokeV.objValue;
    }

    public RequestOptions getDefaultRequestOptions() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.defaultRequestOptions : (RequestOptions) invokeV.objValue;
    }

    @NonNull
    public <T> TransitionOptions<?, T> getDefaultTransitionOptions(@NonNull Class<T> cls) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, cls)) == null) {
            TransitionOptions<?, T> transitionOptions = (TransitionOptions<?, T>) this.defaultTransitionOptions.get(cls);
            if (transitionOptions == null) {
                for (Map.Entry<Class<?>, TransitionOptions<?, ?>> entry : this.defaultTransitionOptions.entrySet()) {
                    if (entry.getKey().isAssignableFrom(cls)) {
                        transitionOptions = (TransitionOptions<?, T>) entry.getValue();
                    }
                }
            }
            return transitionOptions == null ? (TransitionOptions<?, T>) DEFAULT_TRANSITION_OPTIONS : transitionOptions;
        }
        return (TransitionOptions) invokeL.objValue;
    }

    @NonNull
    public Engine getEngine() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.engine : (Engine) invokeV.objValue;
    }

    public int getLogLevel() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.logLevel : invokeV.intValue;
    }

    @NonNull
    public Handler getMainHandler() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.mainHandler : (Handler) invokeV.objValue;
    }

    @NonNull
    public Registry getRegistry() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.registry : (Registry) invokeV.objValue;
    }
}
