package com.bumptech.glide.util;

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
public class LruCache {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final Map cache;
    public long currentSize;
    public final long initialMaxSize;
    public long maxSize;

    public int getSize(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, obj)) == null) {
            return 1;
        }
        return invokeL.intValue;
    }

    public void onItemEvicted(Object obj, Object obj2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048583, this, obj, obj2) == null) {
        }
    }

    /* loaded from: classes7.dex */
    public final class Entry {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final int size;
        public final Object value;

        public Entry(Object obj, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {obj, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.value = obj;
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
                    Iterator it = this.cache.entrySet().iterator();
                    Map.Entry entry = (Map.Entry) it.next();
                    Entry entry2 = (Entry) entry.getValue();
                    this.currentSize -= entry2.size;
                    Object key = entry.getKey();
                    it.remove();
                    onItemEvicted(key, entry2.value);
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

    public synchronized boolean contains(Object obj) {
        InterceptResult invokeL;
        boolean containsKey;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, obj)) == null) {
            synchronized (this) {
                containsKey = this.cache.containsKey(obj);
            }
            return containsKey;
        }
        return invokeL.booleanValue;
    }

    public synchronized Object get(Object obj) {
        InterceptResult invokeL;
        Object obj2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, obj)) == null) {
            synchronized (this) {
                Entry entry = (Entry) this.cache.get(obj);
                if (entry != null) {
                    obj2 = entry.value;
                } else {
                    obj2 = null;
                }
            }
            return obj2;
        }
        return invokeL.objValue;
    }

    public synchronized Object remove(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, obj)) == null) {
            synchronized (this) {
                Entry entry = (Entry) this.cache.remove(obj);
                if (entry == null) {
                    return null;
                }
                this.currentSize -= entry.size;
                return entry.value;
            }
        }
        return invokeL.objValue;
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

    public synchronized Object put(Object obj, Object obj2) {
        InterceptResult invokeLL;
        Entry entry;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, obj, obj2)) == null) {
            synchronized (this) {
                int size = getSize(obj2);
                long j = size;
                Object obj3 = null;
                if (j >= this.maxSize) {
                    onItemEvicted(obj, obj2);
                    return null;
                }
                if (obj2 != null) {
                    this.currentSize += j;
                }
                Map map = this.cache;
                if (obj2 == null) {
                    entry = null;
                } else {
                    entry = new Entry(obj2, size);
                }
                Entry entry2 = (Entry) map.put(obj, entry);
                if (entry2 != null) {
                    this.currentSize -= entry2.size;
                    if (!entry2.value.equals(obj2)) {
                        onItemEvicted(obj, entry2.value);
                    }
                }
                evict();
                if (entry2 != null) {
                    obj3 = entry2.value;
                }
                return obj3;
            }
        }
        return invokeLL.objValue;
    }
}
