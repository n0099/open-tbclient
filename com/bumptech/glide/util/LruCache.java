package com.bumptech.glide.util;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
/* loaded from: classes6.dex */
public class LruCache<T, Y> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final Map<T, Y> cache;
    public long currentSize;
    public final long initialMaxSize;
    public long maxSize;

    public LruCache(long j) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Long.valueOf(j)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.cache = new LinkedHashMap(100, 0.75f, true);
        this.initialMaxSize = j;
        this.maxSize = j;
    }

    private void evict() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65537, this) == null) {
            trimToSize(this.maxSize);
        }
    }

    public void clearMemory() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            trimToSize(0L);
        }
    }

    public synchronized boolean contains(@NonNull T t) {
        InterceptResult invokeL;
        boolean containsKey;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, t)) == null) {
            synchronized (this) {
                containsKey = this.cache.containsKey(t);
            }
            return containsKey;
        }
        return invokeL.booleanValue;
    }

    @Nullable
    public synchronized Y get(@NonNull T t) {
        InterceptResult invokeL;
        Y y;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, t)) == null) {
            synchronized (this) {
                y = this.cache.get(t);
            }
            return y;
        }
        return (Y) invokeL.objValue;
    }

    public synchronized int getCount() {
        InterceptResult invokeV;
        int size;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            synchronized (this) {
                size = this.cache.size();
            }
            return size;
        }
        return invokeV.intValue;
    }

    public synchronized long getCurrentSize() {
        InterceptResult invokeV;
        long j;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            synchronized (this) {
                j = this.currentSize;
            }
            return j;
        }
        return invokeV.longValue;
    }

    public synchronized long getMaxSize() {
        InterceptResult invokeV;
        long j;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            synchronized (this) {
                j = this.maxSize;
            }
            return j;
        }
        return invokeV.longValue;
    }

    public int getSize(@Nullable Y y) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, y)) == null) {
            return 1;
        }
        return invokeL.intValue;
    }

    public void onItemEvicted(@NonNull T t, @Nullable Y y) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048583, this, t, y) == null) {
        }
    }

    @Nullable
    public synchronized Y put(@NonNull T t, @Nullable Y y) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, t, y)) == null) {
            synchronized (this) {
                long size = getSize(y);
                if (size >= this.maxSize) {
                    onItemEvicted(t, y);
                    return null;
                }
                if (y != null) {
                    this.currentSize += size;
                }
                Y put = this.cache.put(t, y);
                if (put != null) {
                    this.currentSize -= getSize(put);
                    if (!put.equals(y)) {
                        onItemEvicted(t, put);
                    }
                }
                evict();
                return put;
            }
        }
        return (Y) invokeLL.objValue;
    }

    @Nullable
    public synchronized Y remove(@NonNull T t) {
        InterceptResult invokeL;
        Y remove;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, t)) == null) {
            synchronized (this) {
                remove = this.cache.remove(t);
                if (remove != null) {
                    this.currentSize -= getSize(remove);
                }
            }
            return remove;
        }
        return (Y) invokeL.objValue;
    }

    public synchronized void setSizeMultiplier(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048586, this, f2) == null) {
            synchronized (this) {
                if (f2 >= 0.0f) {
                    this.maxSize = Math.round(((float) this.initialMaxSize) * f2);
                    evict();
                } else {
                    throw new IllegalArgumentException("Multiplier must be >= 0");
                }
            }
        }
    }

    public synchronized void trimToSize(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048587, this, j) == null) {
            synchronized (this) {
                while (this.currentSize > j) {
                    Iterator<Map.Entry<T, Y>> it = this.cache.entrySet().iterator();
                    Map.Entry<T, Y> next = it.next();
                    Y value = next.getValue();
                    this.currentSize -= getSize(value);
                    T key = next.getKey();
                    it.remove();
                    onItemEvicted(key, value);
                }
            }
        }
    }
}
