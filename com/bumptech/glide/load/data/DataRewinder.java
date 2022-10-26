package com.bumptech.glide.load.data;

import java.io.IOException;
/* loaded from: classes7.dex */
public interface DataRewinder {

    /* loaded from: classes7.dex */
    public interface Factory {
        DataRewinder build(Object obj);

        Class getDataClass();
    }

    void cleanup();

    Object rewindAndGet() throws IOException;
}
