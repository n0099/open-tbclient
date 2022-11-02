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
/* loaded from: classes7.dex */
public class LruCache<T, Y> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final Map<T, Entry<Y>> cache;
    public long currentSize;
    public final long initialMaxSize;
    public long maxSize;

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

    /* loaded from: classes7.dex */
    public static final class Entry<Y> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final int size;
        public final Y value;

        public Entry(Y y, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {y, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.value = y;
            this.size = i;
        }
    }

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

    public synchronized void trimToSize(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048587, this, j) == null) {
            synchronized (this) {
                while (this.currentSize > j) {
                    Iterator<Map.Entry<T, Entry<Y>>> it = this.cache.entrySet().iterator();
                    Map.Entry<T, Entry<Y>> next = it.next();
                    Entry<Y> value = next.getValue();
                    this.currentSize -= value.size;
                    T key = next.getKey();
                    it.remove();
                    onItemEvicted(key, value.value);
                }
            }
        }
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
                Entry<Y> entry = this.cache.get(t);
                if (entry != null) {
                    y = entry.value;
                } else {
                    y = null;
                }
            }
            return y;
        }
        return (Y) invokeL.objValue;
    }

    @Nullable
    public synchronized Y remove(@NonNull T t) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, t)) == null) {
            synchronized (this) {
                Entry<Y> remove = this.cache.remove(t);
                if (remove == null) {
                    return null;
                }
                this.currentSize -= remove.size;
                return remove.value;
            }
        }
        return (Y) invokeL.objValue;
    }

    public synchronized void setSizeMultiplier(float f) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048586, this, f) == null) {
            synchronized (this) {
                if (f >= 0.0f) {
                    this.maxSize = Math.round(((float) this.initialMaxSize) * f);
                    evict();
                } else {
                    throw new IllegalArgumentException("Multiplier must be >= 0");
                }
            }
        }
    }

    @Nullable
    public synchronized Y put(@NonNull T t, @Nullable Y y) {
        InterceptResult invokeLL;
        Entry<Y> entry;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, t, y)) == null) {
            synchronized (this) {
                int size = getSize(y);
                long j = size;
                Y y2 = null;
                if (j >= this.maxSize) {
                    onItemEvicted(t, y);
                    return null;
                }
                if (y != null) {
                    this.currentSize += j;
                }
                Map<T, Entry<Y>> map = this.cache;
                if (y == null) {
                    entry = null;
                } else {
                    entry = new Entry<>(y, size);
                }
                Entry<Y> put = map.put(t, entry);
                if (put != null) {
                    this.currentSize -= put.size;
                    if (!put.value.equals(y)) {
                        onItemEvicted(t, put.value);
                    }
                }
                evict();
                if (put != null) {
                    y2 = put.value;
                }
                return y2;
            }
        }
        return (Y) invokeLL.objValue;
    }
}
