package com.bumptech.glide.load.engine;

import androidx.annotation.NonNull;
import androidx.core.util.Pools;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bumptech.glide.util.Preconditions;
import com.bumptech.glide.util.pool.FactoryPools;
import com.bumptech.glide.util.pool.StateVerifier;
/* loaded from: classes11.dex */
public final class LockedResource<Z> implements Resource<Z>, FactoryPools.Poolable {
    public static /* synthetic */ Interceptable $ic;
    public static final Pools.Pool<LockedResource<?>> POOL;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean isLocked;
    public boolean isRecycled;
    public final StateVerifier stateVerifier;
    public Resource<Z> toWrap;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(935272460, "Lcom/bumptech/glide/load/engine/LockedResource;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(935272460, "Lcom/bumptech/glide/load/engine/LockedResource;");
                return;
            }
        }
        POOL = FactoryPools.threadSafe(20, new FactoryPools.Factory<LockedResource<?>>() { // from class: com.bumptech.glide.load.engine.LockedResource.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                    }
                }
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.bumptech.glide.util.pool.FactoryPools.Factory
            public LockedResource<?> create() {
                InterceptResult invokeV;
                Interceptable interceptable2 = $ic;
                return (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) ? new LockedResource<>() : (LockedResource) invokeV.objValue;
            }
        });
    }

    public LockedResource() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.stateVerifier = StateVerifier.newInstance();
    }

    private void init(Resource<Z> resource) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, this, resource) == null) {
            this.isRecycled = false;
            this.isLocked = true;
            this.toWrap = resource;
        }
    }

    @NonNull
    public static <Z> LockedResource<Z> obtain(Resource<Z> resource) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, resource)) == null) {
            LockedResource<Z> lockedResource = (LockedResource) Preconditions.checkNotNull(POOL.acquire());
            lockedResource.init(resource);
            return lockedResource;
        }
        return (LockedResource) invokeL.objValue;
    }

    private void release() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this) == null) {
            this.toWrap = null;
            POOL.release(this);
        }
    }

    @Override // com.bumptech.glide.load.engine.Resource
    @NonNull
    public Z get() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.toWrap.get() : (Z) invokeV.objValue;
    }

    @Override // com.bumptech.glide.load.engine.Resource
    @NonNull
    public Class<Z> getResourceClass() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.toWrap.getResourceClass() : (Class) invokeV.objValue;
    }

    @Override // com.bumptech.glide.load.engine.Resource
    public int getSize() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.toWrap.getSize() : invokeV.intValue;
    }

    @Override // com.bumptech.glide.util.pool.FactoryPools.Poolable
    @NonNull
    public StateVerifier getVerifier() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.stateVerifier : (StateVerifier) invokeV.objValue;
    }

    @Override // com.bumptech.glide.load.engine.Resource
    public synchronized void recycle() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            synchronized (this) {
                this.stateVerifier.throwIfRecycled();
                this.isRecycled = true;
                if (!this.isLocked) {
                    this.toWrap.recycle();
                    release();
                }
            }
        }
    }

    public synchronized void unlock() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            synchronized (this) {
                this.stateVerifier.throwIfRecycled();
                if (this.isLocked) {
                    this.isLocked = false;
                    if (this.isRecycled) {
                        recycle();
                    }
                } else {
                    throw new IllegalStateException("Already unlocked");
                }
            }
        }
    }
}
