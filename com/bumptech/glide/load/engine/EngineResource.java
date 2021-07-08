package com.bumptech.glide.load.engine;

import android.os.Looper;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.util.Preconditions;
/* loaded from: classes5.dex */
public class EngineResource<Z> implements Resource<Z> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int acquired;
    public final boolean isCacheable;
    public final boolean isRecyclable;
    public boolean isRecycled;
    public Key key;
    public ResourceListener listener;
    public final Resource<Z> resource;

    /* loaded from: classes5.dex */
    public interface ResourceListener {
        void onResourceReleased(Key key, EngineResource<?> engineResource);
    }

    public EngineResource(Resource<Z> resource, boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {resource, Boolean.valueOf(z), Boolean.valueOf(z2)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.resource = (Resource) Preconditions.checkNotNull(resource);
        this.isCacheable = z;
        this.isRecyclable = z2;
    }

    public void acquire() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            if (!this.isRecycled) {
                if (Looper.getMainLooper().equals(Looper.myLooper())) {
                    this.acquired++;
                    return;
                }
                throw new IllegalThreadStateException("Must call acquire on the main thread");
            }
            throw new IllegalStateException("Cannot acquire a recycled resource");
        }
    }

    @Override // com.bumptech.glide.load.engine.Resource
    @NonNull
    public Z get() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.resource.get() : (Z) invokeV.objValue;
    }

    public Resource<Z> getResource() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.resource : (Resource) invokeV.objValue;
    }

    @Override // com.bumptech.glide.load.engine.Resource
    @NonNull
    public Class<Z> getResourceClass() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.resource.getResourceClass() : (Class) invokeV.objValue;
    }

    @Override // com.bumptech.glide.load.engine.Resource
    public int getSize() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.resource.getSize() : invokeV.intValue;
    }

    public boolean isCacheable() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.isCacheable : invokeV.booleanValue;
    }

    @Override // com.bumptech.glide.load.engine.Resource
    public void recycle() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            if (this.acquired <= 0) {
                if (!this.isRecycled) {
                    this.isRecycled = true;
                    if (this.isRecyclable) {
                        this.resource.recycle();
                        return;
                    }
                    return;
                }
                throw new IllegalStateException("Cannot recycle a resource that has already been recycled");
            }
            throw new IllegalStateException("Cannot recycle a resource while it is still acquired");
        }
    }

    public void release() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            if (this.acquired > 0) {
                if (Looper.getMainLooper().equals(Looper.myLooper())) {
                    int i2 = this.acquired - 1;
                    this.acquired = i2;
                    if (i2 == 0) {
                        this.listener.onResourceReleased(this.key, this);
                        return;
                    }
                    return;
                }
                throw new IllegalThreadStateException("Must call release on the main thread");
            }
            throw new IllegalStateException("Cannot release a recycled or not yet acquired resource");
        }
    }

    public void setResourceListener(Key key, ResourceListener resourceListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, key, resourceListener) == null) {
            this.key = key;
            this.listener = resourceListener;
        }
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return "EngineResource{isCacheable=" + this.isCacheable + ", listener=" + this.listener + ", key=" + this.key + ", acquired=" + this.acquired + ", isRecycled=" + this.isRecycled + ", resource=" + this.resource + '}';
        }
        return (String) invokeV.objValue;
    }
}
