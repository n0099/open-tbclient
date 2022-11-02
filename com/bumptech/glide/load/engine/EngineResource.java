package com.bumptech.glide.load.engine;

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
/* loaded from: classes7.dex */
public class EngineResource<Z> implements Resource<Z> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int acquired;
    public final boolean isMemoryCacheable;
    public final boolean isRecyclable;
    public boolean isRecycled;
    public final Key key;
    public final ResourceListener listener;
    public final Resource<Z> resource;

    /* loaded from: classes7.dex */
    public interface ResourceListener {
        void onResourceReleased(Key key, EngineResource<?> engineResource);
    }

    public EngineResource(Resource<Z> resource, boolean z, boolean z2, Key key, ResourceListener resourceListener) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {resource, Boolean.valueOf(z), Boolean.valueOf(z2), key, resourceListener};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.resource = (Resource) Preconditions.checkNotNull(resource);
        this.isMemoryCacheable = z;
        this.isRecyclable = z2;
        this.key = key;
        this.listener = (ResourceListener) Preconditions.checkNotNull(resourceListener);
    }

    public synchronized void acquire() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            synchronized (this) {
                if (!this.isRecycled) {
                    this.acquired++;
                } else {
                    throw new IllegalStateException("Cannot acquire a recycled resource");
                }
            }
        }
    }

    @Override // com.bumptech.glide.load.engine.Resource
    @NonNull
    public Z get() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.resource.get();
        }
        return (Z) invokeV.objValue;
    }

    public Resource<Z> getResource() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.resource;
        }
        return (Resource) invokeV.objValue;
    }

    @Override // com.bumptech.glide.load.engine.Resource
    @NonNull
    public Class<Z> getResourceClass() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.resource.getResourceClass();
        }
        return (Class) invokeV.objValue;
    }

    @Override // com.bumptech.glide.load.engine.Resource
    public int getSize() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.resource.getSize();
        }
        return invokeV.intValue;
    }

    public boolean isMemoryCacheable() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.isMemoryCacheable;
        }
        return invokeV.booleanValue;
    }

    @Override // com.bumptech.glide.load.engine.Resource
    public synchronized void recycle() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            synchronized (this) {
                if (this.acquired <= 0) {
                    if (!this.isRecycled) {
                        this.isRecycled = true;
                        if (this.isRecyclable) {
                            this.resource.recycle();
                        }
                    } else {
                        throw new IllegalStateException("Cannot recycle a resource that has already been recycled");
                    }
                } else {
                    throw new IllegalStateException("Cannot recycle a resource while it is still acquired");
                }
            }
        }
    }

    public void release() {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            synchronized (this) {
                if (this.acquired > 0) {
                    z = true;
                    int i = this.acquired - 1;
                    this.acquired = i;
                    if (i != 0) {
                        z = false;
                    }
                } else {
                    throw new IllegalStateException("Cannot release a recycled or not yet acquired resource");
                }
            }
            if (z) {
                this.listener.onResourceReleased(this.key, this);
            }
        }
    }

    public synchronized String toString() {
        InterceptResult invokeV;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            synchronized (this) {
                str = "EngineResource{isMemoryCacheable=" + this.isMemoryCacheable + ", listener=" + this.listener + ", key=" + this.key + ", acquired=" + this.acquired + ", isRecycled=" + this.isRecycled + ", resource=" + this.resource + '}';
            }
            return str;
        }
        return (String) invokeV.objValue;
    }
}
