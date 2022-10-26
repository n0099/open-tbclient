package com.bumptech.glide.load.model;
/* loaded from: classes7.dex */
public interface ModelLoaderFactory {
    ModelLoader build(MultiModelLoaderFactory multiModelLoaderFactory);

    void teardown();
}
