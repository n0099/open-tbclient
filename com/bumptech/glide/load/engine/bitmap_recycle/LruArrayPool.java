package com.bumptech.glide.load.engine.bitmap_recycle;

import android.util.Log;
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
    public static final int MAX_OVER_SIZE_MULTIPLE = 8;
    public static final int SINGLE_ARRAY_MAX_SIZE_DIVISOR = 2;
    public transient /* synthetic */ FieldHolder $fh;
    public final Map adapters;
    public int currentSize;
    public final GroupedLinkedMap groupedMap;
    public final KeyPool keyPool;
    public final int maxSize;
    public final Map sortedSizes;

    /* loaded from: classes7.dex */
    public final class Key implements Poolable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public Class arrayClass;
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
                if (!(obj instanceof Key)) {
                    return false;
                }
                Key key = (Key) obj;
                if (this.size != key.size || this.arrayClass != key.arrayClass) {
                    return false;
                }
                return true;
            }
            return invokeL.booleanValue;
        }

        public int hashCode() {
            InterceptResult invokeV;
            int i;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                int i2 = this.size * 31;
                Class cls = this.arrayClass;
                if (cls != null) {
                    i = cls.hashCode();
                } else {
                    i = 0;
                }
                return i2 + i;
            }
            return invokeV.intValue;
        }

        @Override // com.bumptech.glide.load.engine.bitmap_recycle.Poolable
        public void offer() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
                this.pool.offer(this);
            }
        }

        public void init(int i, Class cls) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_SEND_USER_MSG, this, i, cls) == null) {
                this.size = i;
                this.arrayClass = cls;
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
    public final class KeyPool extends BaseKeyPool {
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

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.bumptech.glide.load.engine.bitmap_recycle.BaseKeyPool
        public Key create() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return new Key(this);
            }
            return (Key) invokeV.objValue;
        }

        public Key get(int i, Class cls) {
            InterceptResult invokeIL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeIL = interceptable.invokeIL(Constants.METHOD_SEND_USER_MSG, this, i, cls)) == null) {
                Key key = (Key) get();
                key.init(i, cls);
                return key;
            }
            return (Key) invokeIL.objValue;
        }
    }

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
        this.groupedMap = new GroupedLinkedMap();
        this.keyPool = new KeyPool();
        this.sortedSizes = new HashMap();
        this.adapters = new HashMap();
        this.maxSize = 4194304;
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
        this.groupedMap = new GroupedLinkedMap();
        this.keyPool = new KeyPool();
        this.sortedSizes = new HashMap();
        this.adapters = new HashMap();
        this.maxSize = i;
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

    private ArrayAdapterInterface getAdapterFromType(Class cls) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, this, cls)) == null) {
            ArrayAdapterInterface arrayAdapterInterface = (ArrayAdapterInterface) this.adapters.get(cls);
            if (arrayAdapterInterface == null) {
                if (cls.equals(int[].class)) {
                    arrayAdapterInterface = new IntegerArrayAdapter();
                } else if (cls.equals(byte[].class)) {
                    arrayAdapterInterface = new ByteArrayAdapter();
                } else {
                    throw new IllegalArgumentException("No array pool found for: " + cls.getSimpleName());
                }
                this.adapters.put(cls, arrayAdapterInterface);
            }
            return arrayAdapterInterface;
        }
        return (ArrayAdapterInterface) invokeL.objValue;
    }

    private void decrementArrayOfSize(int i, Class cls) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(65538, this, i, cls) == null) {
            NavigableMap sizesForAdapter = getSizesForAdapter(cls);
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

    private Object getForKey(Key key, Class cls) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65544, this, key, cls)) == null) {
            ArrayAdapterInterface adapterFromType = getAdapterFromType(cls);
            Object arrayForKey = getArrayForKey(key);
            if (arrayForKey != null) {
                this.currentSize -= adapterFromType.getArrayLength(arrayForKey) * adapterFromType.getElementSizeInBytes();
                decrementArrayOfSize(adapterFromType.getArrayLength(arrayForKey), cls);
            }
            if (arrayForKey == null) {
                if (Log.isLoggable(adapterFromType.getTag(), 2)) {
                    Log.v(adapterFromType.getTag(), "Allocated " + key.size + " bytes");
                }
                return adapterFromType.newArray(key.size);
            }
            return arrayForKey;
        }
        return invokeLL.objValue;
    }

    private void evict() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65539, this) == null) {
            evictToSize(this.maxSize);
        }
    }

    private boolean isNoMoreThanHalfFull() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65546, this)) == null) {
            int i = this.currentSize;
            if (i != 0 && this.maxSize / i < 2) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
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

    private ArrayAdapterInterface getAdapterFromObject(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, this, obj)) == null) {
            return getAdapterFromType(obj.getClass());
        }
        return (ArrayAdapterInterface) invokeL.objValue;
    }

    private Object getArrayForKey(Key key) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, this, key)) == null) {
            return this.groupedMap.get(key);
        }
        return invokeL.objValue;
    }

    private NavigableMap getSizesForAdapter(Class cls) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, this, cls)) == null) {
            NavigableMap navigableMap = (NavigableMap) this.sortedSizes.get(cls);
            if (navigableMap == null) {
                TreeMap treeMap = new TreeMap();
                this.sortedSizes.put(cls, treeMap);
                return treeMap;
            }
            return navigableMap;
        }
        return (NavigableMap) invokeL.objValue;
    }

    private boolean isSmallEnoughForReuse(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65547, this, i)) == null) {
            if (i <= this.maxSize / 2) {
                return true;
            }
            return false;
        }
        return invokeI.booleanValue;
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

    private boolean mayFillRequest(int i, Integer num) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(65548, this, i, num)) == null) {
            if (num != null && (isNoMoreThanHalfFull() || num.intValue() <= i * 8)) {
                return true;
            }
            return false;
        }
        return invokeIL.booleanValue;
    }

    @Override // com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool
    public synchronized Object getExact(int i, Class cls) {
        InterceptResult invokeIL;
        Object forKey;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048579, this, i, cls)) == null) {
            synchronized (this) {
                forKey = getForKey(this.keyPool.get(i, cls), cls);
            }
            return forKey;
        }
        return invokeIL.objValue;
    }

    @Override // com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool
    @Deprecated
    public void put(Object obj, Class cls) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048581, this, obj, cls) == null) {
            put(obj);
        }
    }

    @Override // com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool
    public synchronized Object get(int i, Class cls) {
        InterceptResult invokeIL;
        Key key;
        Object forKey;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, cls)) == null) {
            synchronized (this) {
                Integer num = (Integer) getSizesForAdapter(cls).ceilingKey(Integer.valueOf(i));
                if (mayFillRequest(i, num)) {
                    key = this.keyPool.get(num.intValue(), cls);
                } else {
                    key = this.keyPool.get(i, cls);
                }
                forKey = getForKey(key, cls);
            }
            return forKey;
        }
        return invokeIL.objValue;
    }

    public int getCurrentSize() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            int i = 0;
            for (Class cls : this.sortedSizes.keySet()) {
                for (Integer num : ((NavigableMap) this.sortedSizes.get(cls)).keySet()) {
                    i += num.intValue() * ((Integer) ((NavigableMap) this.sortedSizes.get(cls)).get(num)).intValue() * getAdapterFromType(cls).getElementSizeInBytes();
                }
            }
            return i;
        }
        return invokeV.intValue;
    }

    @Override // com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool
    public synchronized void put(Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, obj) == null) {
            synchronized (this) {
                Class<?> cls = obj.getClass();
                ArrayAdapterInterface adapterFromType = getAdapterFromType(cls);
                int arrayLength = adapterFromType.getArrayLength(obj);
                int elementSizeInBytes = adapterFromType.getElementSizeInBytes() * arrayLength;
                if (!isSmallEnoughForReuse(elementSizeInBytes)) {
                    return;
                }
                Key key = this.keyPool.get(arrayLength, cls);
                this.groupedMap.put(key, obj);
                NavigableMap sizesForAdapter = getSizesForAdapter(cls);
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
