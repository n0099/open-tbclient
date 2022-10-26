package com.bumptech.glide.load.engine.bitmap_recycle;
/* loaded from: classes7.dex */
public interface ArrayAdapterInterface {
    int getArrayLength(Object obj);

    int getElementSizeInBytes();

    String getTag();

    Object newArray(int i);
}
