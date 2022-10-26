package com.bumptech.glide.load.engine.bitmap_recycle;
/* loaded from: classes7.dex */
public interface ArrayPool {
    public static final int STANDARD_BUFFER_SIZE_BYTES = 65536;

    void clearMemory();

    Object get(int i, Class cls);

    Object getExact(int i, Class cls);

    void put(Object obj);

    @Deprecated
    void put(Object obj, Class cls);

    void trimMemory(int i);
}
