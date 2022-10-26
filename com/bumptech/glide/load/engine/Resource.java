package com.bumptech.glide.load.engine;
/* loaded from: classes7.dex */
public interface Resource {
    Object get();

    Class getResourceClass();

    int getSize();

    void recycle();
}
