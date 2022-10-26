package com.bumptech.glide.load.data;

import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
/* loaded from: classes7.dex */
public interface DataFetcher {

    /* loaded from: classes7.dex */
    public interface DataCallback {
        void onDataReady(Object obj);

        void onLoadFailed(Exception exc);
    }

    void cancel();

    void cleanup();

    Class getDataClass();

    DataSource getDataSource();

    void loadData(Priority priority, DataCallback dataCallback);
}
