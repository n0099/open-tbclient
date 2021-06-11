package com.bumptech.glide.load.engine.bitmap_recycle;

import android.util.Log;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.bumptech.glide.util.Preconditions;
import java.util.HashMap;
import java.util.Map;
import java.util.NavigableMap;
import java.util.TreeMap;
/* loaded from: classes6.dex */
public final class LruArrayPool implements ArrayPool {
    public static final int DEFAULT_SIZE = 4194304;
    @VisibleForTesting
    public static final int MAX_OVER_SIZE_MULTIPLE = 8;
    public static final int SINGLE_ARRAY_MAX_SIZE_DIVISOR = 2;
    public final Map<Class<?>, ArrayAdapterInterface<?>> adapters;
    public int currentSize;
    public final GroupedLinkedMap<Key, Object> groupedMap;
    public final KeyPool keyPool;
    public final int maxSize;
    public final Map<Class<?>, NavigableMap<Integer, Integer>> sortedSizes;

    /* loaded from: classes6.dex */
    public static final class Key implements Poolable {
        public Class<?> arrayClass;
        public final KeyPool pool;
        public int size;

        public Key(KeyPool keyPool) {
            this.pool = keyPool;
        }

        public boolean equals(Object obj) {
            if (obj instanceof Key) {
                Key key = (Key) obj;
                return this.size == key.size && this.arrayClass == key.arrayClass;
            }
            return false;
        }

        public int hashCode() {
            int i2 = this.size * 31;
            Class<?> cls = this.arrayClass;
            return i2 + (cls != null ? cls.hashCode() : 0);
        }

        public void init(int i2, Class<?> cls) {
            this.size = i2;
            this.arrayClass = cls;
        }

        @Override // com.bumptech.glide.load.engine.bitmap_recycle.Poolable
        public void offer() {
            this.pool.offer(this);
        }

        public String toString() {
            return "Key{size=" + this.size + "array=" + this.arrayClass + '}';
        }
    }

    /* loaded from: classes6.dex */
    public static final class KeyPool extends BaseKeyPool<Key> {
        public Key get(int i2, Class<?> cls) {
            Key key = get();
            key.init(i2, cls);
            return key;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.bumptech.glide.load.engine.bitmap_recycle.BaseKeyPool
        public Key create() {
            return new Key(this);
        }
    }

    @VisibleForTesting
    public LruArrayPool() {
        this.groupedMap = new GroupedLinkedMap<>();
        this.keyPool = new KeyPool();
        this.sortedSizes = new HashMap();
        this.adapters = new HashMap();
        this.maxSize = 4194304;
    }

    private void decrementArrayOfSize(int i2, Class<?> cls) {
        NavigableMap<Integer, Integer> sizesForAdapter = getSizesForAdapter(cls);
        Integer num = (Integer) sizesForAdapter.get(Integer.valueOf(i2));
        if (num != null) {
            if (num.intValue() == 1) {
                sizesForAdapter.remove(Integer.valueOf(i2));
                return;
            } else {
                sizesForAdapter.put(Integer.valueOf(i2), Integer.valueOf(num.intValue() - 1));
                return;
            }
        }
        throw new NullPointerException("Tried to decrement empty size, size: " + i2 + ", this: " + this);
    }

    private void evict() {
        evictToSize(this.maxSize);
    }

    private void evictToSize(int i2) {
        while (this.currentSize > i2) {
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

    private <T> ArrayAdapterInterface<T> getAdapterFromObject(T t) {
        return getAdapterFromType(t.getClass());
    }

    private <T> ArrayAdapterInterface<T> getAdapterFromType(Class<T> cls) {
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

    @Nullable
    private <T> T getArrayForKey(Key key) {
        return (T) this.groupedMap.get(key);
    }

    private <T> T getForKey(Key key, Class<T> cls) {
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

    private NavigableMap<Integer, Integer> getSizesForAdapter(Class<?> cls) {
        NavigableMap<Integer, Integer> navigableMap = this.sortedSizes.get(cls);
        if (navigableMap == null) {
            TreeMap treeMap = new TreeMap();
            this.sortedSizes.put(cls, treeMap);
            return treeMap;
        }
        return navigableMap;
    }

    private boolean isNoMoreThanHalfFull() {
        int i2 = this.currentSize;
        return i2 == 0 || this.maxSize / i2 >= 2;
    }

    private boolean isSmallEnoughForReuse(int i2) {
        return i2 <= this.maxSize / 2;
    }

    private boolean mayFillRequest(int i2, Integer num) {
        return num != null && (isNoMoreThanHalfFull() || num.intValue() <= i2 * 8);
    }

    @Override // com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool
    public synchronized void clearMemory() {
        evictToSize(0);
    }

    @Override // com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool
    public synchronized <T> T get(int i2, Class<T> cls) {
        Key key;
        Integer ceilingKey = getSizesForAdapter(cls).ceilingKey(Integer.valueOf(i2));
        if (mayFillRequest(i2, ceilingKey)) {
            key = this.keyPool.get(ceilingKey.intValue(), cls);
        } else {
            key = this.keyPool.get(i2, cls);
        }
        return (T) getForKey(key, cls);
    }

    public int getCurrentSize() {
        int i2 = 0;
        for (Class<?> cls : this.sortedSizes.keySet()) {
            for (Integer num : this.sortedSizes.get(cls).keySet()) {
                i2 += num.intValue() * ((Integer) this.sortedSizes.get(cls).get(num)).intValue() * getAdapterFromType(cls).getElementSizeInBytes();
            }
        }
        return i2;
    }

    @Override // com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool
    public synchronized <T> T getExact(int i2, Class<T> cls) {
        return (T) getForKey(this.keyPool.get(i2, cls), cls);
    }

    @Override // com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool
    @Deprecated
    public <T> void put(T t, Class<T> cls) {
        put(t);
    }

    @Override // com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool
    public synchronized void trimMemory(int i2) {
        try {
            if (i2 >= 40) {
                clearMemory();
            } else if (i2 >= 20 || i2 == 15) {
                evictToSize(this.maxSize / 2);
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool
    public synchronized <T> void put(T t) {
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
            int i2 = 1;
            if (num != null) {
                i2 = 1 + num.intValue();
            }
            sizesForAdapter.put(valueOf, Integer.valueOf(i2));
            this.currentSize += elementSizeInBytes;
            evict();
        }
    }

    public LruArrayPool(int i2) {
        this.groupedMap = new GroupedLinkedMap<>();
        this.keyPool = new KeyPool();
        this.sortedSizes = new HashMap();
        this.adapters = new HashMap();
        this.maxSize = i2;
    }
}
