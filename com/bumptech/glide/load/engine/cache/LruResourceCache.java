package com.bumptech.glide.load.engine.cache;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.engine.cache.MemoryCache;
import com.bumptech.glide.util.LruCache;
/* loaded from: classes7.dex */
public class LruResourceCache extends LruCache implements MemoryCache {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public MemoryCache.ResourceRemovedListener listener;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LruResourceCache(long j) {
        super(j);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Long.valueOf(j)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super(((Long) newInitContext.callArgs[0]).longValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.bumptech.glide.util.LruCache
    public int getSize(Resource resource) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, resource)) == null) {
            if (resource == null) {
                return super.getSize((Object) null);
            }
            return resource.getSize();
        }
        return invokeL.intValue;
    }

    @Override // com.bumptech.glide.load.engine.cache.MemoryCache
    public /* bridge */ /* synthetic */ Resource remove(Key key) {
        return (Resource) super.remove((Object) key);
    }

    @Override // com.bumptech.glide.load.engine.cache.MemoryCache
    public void setResourceRemovedListener(MemoryCache.ResourceRemovedListener resourceRemovedListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, resourceRemovedListener) == null) {
            this.listener = resourceRemovedListener;
        }
    }

    @Override // com.bumptech.glide.load.engine.cache.MemoryCache
    public void trimMemory(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i) == null) {
            if (i >= 40) {
                clearMemory();
            } else if (i >= 20 || i == 15) {
                trimToSize(getMaxSize() / 2);
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.bumptech.glide.util.LruCache
    public void onItemEvicted(Key key, Resource resource) {
        MemoryCache.ResourceRemovedListener resourceRemovedListener;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, key, resource) == null) && (resourceRemovedListener = this.listener) != null && resource != null) {
            resourceRemovedListener.onResourceRemoved(resource);
        }
    }

    @Override // com.bumptech.glide.load.engine.cache.MemoryCache
    public /* bridge */ /* synthetic */ Resource put(Key key, Resource resource) {
        return (Resource) super.put((Object) key, (Object) resource);
    }
}
