package com.bumptech.glide;

import android.content.Context;
import android.content.ContextWrapper;
import android.widget.ImageView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.Engine;
import com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool;
import com.bumptech.glide.request.RequestOptions;
import com.bumptech.glide.request.target.ImageViewTargetFactory;
import com.bumptech.glide.request.target.ViewTarget;
import java.util.List;
import java.util.Map;
/* loaded from: classes7.dex */
public class GlideContext extends ContextWrapper {
    public static /* synthetic */ Interceptable $ic;
    public static final TransitionOptions DEFAULT_TRANSITION_OPTIONS;
    public transient /* synthetic */ FieldHolder $fh;
    public final ArrayPool arrayPool;
    public final List defaultRequestListeners;
    public RequestOptions defaultRequestOptions;
    public final Glide.RequestOptionsFactory defaultRequestOptionsFactory;
    public final Map defaultTransitionOptions;
    public final Engine engine;
    public final GlideExperiments experiments;
    public final ImageViewTargetFactory imageViewTargetFactory;
    public final int logLevel;
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

    public ArrayPool getArrayPool() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.arrayPool;
        }
        return (ArrayPool) invokeV.objValue;
    }

    public List getDefaultRequestListeners() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.defaultRequestListeners;
        }
        return (List) invokeV.objValue;
    }

    public synchronized RequestOptions getDefaultRequestOptions() {
        InterceptResult invokeV;
        RequestOptions requestOptions;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            synchronized (this) {
                if (this.defaultRequestOptions == null) {
                    this.defaultRequestOptions = (RequestOptions) this.defaultRequestOptionsFactory.build().lock();
                }
                requestOptions = this.defaultRequestOptions;
            }
            return requestOptions;
        }
        return (RequestOptions) invokeV.objValue;
    }

    public Engine getEngine() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.engine;
        }
        return (Engine) invokeV.objValue;
    }

    public GlideExperiments getExperiments() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.experiments;
        }
        return (GlideExperiments) invokeV.objValue;
    }

    public int getLogLevel() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.logLevel;
        }
        return invokeV.intValue;
    }

    public Registry getRegistry() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return this.registry;
        }
        return (Registry) invokeV.objValue;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GlideContext(Context context, ArrayPool arrayPool, Registry registry, ImageViewTargetFactory imageViewTargetFactory, Glide.RequestOptionsFactory requestOptionsFactory, Map map, List list, Engine engine, GlideExperiments glideExperiments, int i) {
        super(context.getApplicationContext());
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r3;
            Object[] objArr = {context, arrayPool, registry, imageViewTargetFactory, requestOptionsFactory, map, list, engine, glideExperiments, Integer.valueOf(i)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.arrayPool = arrayPool;
        this.registry = registry;
        this.imageViewTargetFactory = imageViewTargetFactory;
        this.defaultRequestOptionsFactory = requestOptionsFactory;
        this.defaultRequestListeners = list;
        this.defaultTransitionOptions = map;
        this.engine = engine;
        this.experiments = glideExperiments;
        this.logLevel = i;
    }

    public ViewTarget buildImageViewTarget(ImageView imageView, Class cls) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, imageView, cls)) == null) {
            return this.imageViewTargetFactory.buildTarget(imageView, cls);
        }
        return (ViewTarget) invokeLL.objValue;
    }

    public TransitionOptions getDefaultTransitionOptions(Class cls) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, cls)) == null) {
            TransitionOptions transitionOptions = (TransitionOptions) this.defaultTransitionOptions.get(cls);
            if (transitionOptions == null) {
                for (Map.Entry entry : this.defaultTransitionOptions.entrySet()) {
                    if (((Class) entry.getKey()).isAssignableFrom(cls)) {
                        transitionOptions = (TransitionOptions) entry.getValue();
                    }
                }
            }
            if (transitionOptions == null) {
                return DEFAULT_TRANSITION_OPTIONS;
            }
            return transitionOptions;
        }
        return (TransitionOptions) invokeL.objValue;
    }
}
