package com.bumptech.glide.load.engine.bitmap_recycle;

import android.util.Log;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bumptech.glide.util.Preconditions;
import java.util.HashMap;
import java.util.Map;
import java.util.NavigableMap;
import java.util.TreeMap;
/* loaded from: classes7.dex */
public final class LruArrayPool implements ArrayPool {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int DEFAULT_SIZE = 4194304;
    @VisibleForTesting
    public static final int MAX_OVER_SIZE_MULTIPLE = 8;
    public static final int SINGLE_ARRAY_MAX_SIZE_DIVISOR = 2;
    public transient /* synthetic */ FieldHolder $fh;
    public final Map<Class<?>, ArrayAdapterInterface<?>> adapters;
    public int currentSize;
    public final GroupedLinkedMap<Key, Object> groupedMap;
    public final KeyPool keyPool;
    public final int maxSize;
    public final Map<Class<?>, NavigableMap<Integer, Integer>> sortedSizes;

    /* loaded from: classes7.dex */
    public static final class Key implements Poolable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public Class<?> arrayClass;
        public final KeyPool pool;
        public int size;

        public Key(KeyPool keyPool) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {keyPool};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.pool = keyPool;
        }

        public boolean equals(Object obj) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, obj)) == null) {
                if (obj instanceof Key) {
                    Key key = (Key) obj;
                    return this.size == key.size && this.arrayClass == key.arrayClass;
                }
                return false;
            }
            return invokeL.booleanValue;
        }

        public int hashCode() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                int i = this.size * 31;
                Class<?> cls = this.arrayClass;
                return i + (cls != null ? cls.hashCode() : 0);
            }
            return invokeV.intValue;
        }

        public void init(int i, Class<?> cls) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_SEND_USER_MSG, this, i, cls) == null) {
                this.size = i;
                this.arrayClass = cls;
            }
        }

        @Override // com.bumptech.glide.load.engine.bitmap_recycle.Poolable
        public void offer() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
                this.pool.offer(this);
            }
        }

        public String toString() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                return "Key{size=" + this.size + "array=" + this.arrayClass + '}';
            }
            return (String) invokeV.objValue;
        }
    }

    /* loaded from: classes7.dex */
    public static final class KeyPool extends BaseKeyPool<Key> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public KeyPool() {
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

        public Key get(int i, Class<?> cls) {
            InterceptResult invokeIL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeIL = interceptable.invokeIL(Constants.METHOD_SEND_USER_MSG, this, i, cls)) == null) {
                Key key = get();
                key.init(i, cls);
                return key;
            }
            return (Key) invokeIL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.bumptech.glide.load.engine.bitmap_recycle.BaseKeyPool
        public Key create() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? new Key(this) : (Key) invokeV.objValue;
        }
    }

    @VisibleForTesting
    public LruArrayPool() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.groupedMap = new GroupedLinkedMap<>();
        this.keyPool = new KeyPool();
        this.sortedSizes = new HashMap();
        this.adapters = new HashMap();
        this.maxSize = 4194304;
    }

    private void decrementArrayOfSize(int i, Class<?> cls) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(65538, this, i, cls) == null) {
            NavigableMap<Integer, Integer> sizesForAdapter = getSizesForAdapter(cls);
            Integer num = (Integer) sizesForAdapter.get(Integer.valueOf(i));
            if (num != null) {
                if (num.intValue() == 1) {
                    sizesForAdapter.remove(Integer.valueOf(i));
                    return;
                } else {
                    sizesForAdapter.put(Integer.valueOf(i), Integer.valueOf(num.intValue() - 1));
                    return;
                }
            }
            throw new NullPointerException("Tried to decrement empty size, size: " + i + ", this: " + this);
        }
    }

    private void evict() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65539, this) == null) {
            evictToSize(this.maxSize);
        }
    }

    private void evictToSize(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TRACKBALL, this, i) == null) {
            while (this.currentSize > i) {
                Object removeLast = this.groupedMap.removeLast();
                Preconditions.checkNotNull(removeLast);
                ArrayAdapterInterface adapterFromObject = getAdapterFromObject(removeLast);
                this.currentSize -= adapterFromObject.getArrayLength(removeLast) * adapterFromObject.getElementSizeInBytes();
                decrementArrayOfSize(adapterFromObject.getArrayLength(removeLast), removeLast.getClass());
                if (Log.isLoggable(adapterFromObject.getTag(), 2)) {
                    Log.v(adapterFromObject.getTag(), "evicted: " + adapterFromObject.getArrayLength(removeLast));
                }
            }
        }
    }

    private <T> ArrayAdapterInterface<T> getAdapterFromObject(T t) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65541, this, t)) == null) ? getAdapterFromType(t.getClass()) : (ArrayAdapterInterface) invokeL.objValue;
    }

    private <T> ArrayAdapterInterface<T> getAdapterFromType(Class<T> cls) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, this, cls)) == null) {
            IntegerArrayAdapter integerArrayAdapter = (ArrayAdapterInterface<T>) this.adapters.get(cls);
            if (integerArrayAdapter == null) {
                if (cls.equals(int[].class)) {
                    integerArrayAdapter = new IntegerArrayAdapter();
                } else if (cls.equals(byte[].class)) {
                    integerArrayAdapter = new ByteArrayAdapter();
                } else {
                    throw new IllegalArgumentException("No array pool found for: " + cls.getSimpleName());
                }
                this.adapters.put(cls, integerArrayAdapter);
            }
            return integerArrayAdapter;
        }
        return (ArrayAdapterInterface) invokeL.objValue;
    }

    @Nullable
    private <T> T getArrayForKey(Key key) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65543, this, key)) == null) ? (T) this.groupedMap.get(key) : (T) invokeL.objValue;
    }

    private <T> T getForKey(Key key, Class<T> cls) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65544, this, key, cls)) == null) {
            ArrayAdapterInterface<T> adapterFromType = getAdapterFromType(cls);
            T t = (T) getArrayForKey(key);
            if (t != null) {
                this.currentSize -= adapterFromType.getArrayLength(t) * adapterFromType.getElementSizeInBytes();
                decrementArrayOfSize(adapterFromType.getArrayLength(t), cls);
            }
            if (t == null) {
                if (Log.isLoggable(adapterFromType.getTag(), 2)) {
                    Log.v(adapterFromType.getTag(), "Allocated " + key.size + " bytes");
                }
                return adapterFromType.newArray(key.size);
            }
            return t;
        }
        return (T) invokeLL.objValue;
    }

    private NavigableMap<Integer, Integer> getSizesForAdapter(Class<?> cls) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, this, cls)) == null) {
            NavigableMap<Integer, Integer> navigableMap = this.sortedSizes.get(cls);
            if (navigableMap == null) {
                TreeMap treeMap = new TreeMap();
                this.sortedSizes.put(cls, treeMap);
                return treeMap;
            }
            return navigableMap;
        }
        return (NavigableMap) invokeL.objValue;
    }

    private boolean isNoMoreThanHalfFull() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65546, this)) == null) {
            int i = this.currentSize;
            return i == 0 || this.maxSize / i >= 2;
        }
        return invokeV.booleanValue;
    }

    private boolean isSmallEnoughForReuse(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(65547, this, i)) == null) ? i <= this.maxSize / 2 : invokeI.booleanValue;
    }

    private boolean mayFillRequest(int i, Integer num) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeIL = interceptable.invokeIL(65548, this, i, num)) == null) ? num != null && (isNoMoreThanHalfFull() || num.intValue() <= i * 8) : invokeIL.booleanValue;
    }

    @Override // com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool
    public synchronized void clearMemory() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            synchronized (this) {
                evictToSize(0);
            }
        }
    }

    @Override // com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool
    public synchronized <T> T get(int i, Class<T> cls) {
        InterceptResult invokeIL;
        Key key;
        T t;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, cls)) == null) {
            synchronized (this) {
                Integer ceilingKey = getSizesForAdapter(cls).ceilingKey(Integer.valueOf(i));
                if (mayFillRequest(i, ceilingKey)) {
                    key = this.keyPool.get(ceilingKey.intValue(), cls);
                } else {
                    key = this.keyPool.get(i, cls);
                }
                t = (T) getForKey(key, cls);
            }
            return t;
        }
        return (T) invokeIL.objValue;
    }

    public int getCurrentSize() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            int i = 0;
            for (Class<?> cls : this.sortedSizes.keySet()) {
                for (Integer num : this.sortedSizes.get(cls).keySet()) {
                    i += num.intValue() * ((Integer) this.sortedSizes.get(cls).get(num)).intValue() * getAdapterFromType(cls).getElementSizeInBytes();
                }
            }
            return i;
        }
        return invokeV.intValue;
    }

    @Override // com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool
    public synchronized <T> T getExact(int i, Class<T> cls) {
        InterceptResult invokeIL;
        T t;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048579, this, i, cls)) == null) {
            synchronized (this) {
                t = (T) getForKey(this.keyPool.get(i, cls), cls);
            }
            return t;
        }
        return (T) invokeIL.objValue;
    }

    @Override // com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool
    @Deprecated
    public <T> void put(T t, Class<T> cls) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048581, this, t, cls) == null) {
            put(t);
        }
    }

    @Override // com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool
    public synchronized void trimMemory(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048582, this, i) == null) {
            synchronized (this) {
                try {
                    if (i >= 40) {
                        clearMemory();
                    } else if (i >= 20 || i == 15) {
                        evictToSize(this.maxSize / 2);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    @Override // com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool
    public synchronized <T> void put(T t) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, t) == null) {
            synchronized (this) {
                Class<?> cls = t.getClass();
                ArrayAdapterInterface<T> adapterFromType = getAdapterFromType(cls);
                int arrayLength = adapterFromType.getArrayLength(t);
                int elementSizeInBytes = adapterFromType.getElementSizeInBytes() * arrayLength;
                if (isSmallEnoughForReuse(elementSizeInBytes)) {
                    Key key = this.keyPool.get(arrayLength, cls);
                    this.groupedMap.put(key, t);
                    NavigableMap<Integer, Integer> sizesForAdapter = getSizesForAdapter(cls);
                    Integer num = (Integer) sizesForAdapter.get(Integer.valueOf(key.size));
                    Integer valueOf = Integer.valueOf(key.size);
                    int i = 1;
                    if (num != null) {
                        i = 1 + num.intValue();
                    }
                    sizesForAdapter.put(valueOf, Integer.valueOf(i));
                    this.currentSize += elementSizeInBytes;
                    evict();
                }
            }
        }
    }

    public LruArrayPool(int i) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.groupedMap = new GroupedLinkedMap<>();
        this.keyPool = new KeyPool();
        this.sortedSizes = new HashMap();
        this.adapters = new HashMap();
        this.maxSize = i;
    }
}
