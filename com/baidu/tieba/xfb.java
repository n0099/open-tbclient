package com.baidu.tieba;

import java.util.ArrayList;
/* loaded from: classes8.dex */
public interface xfb {

    /* loaded from: classes8.dex */
    public interface a {
        void onCompletion();

        boolean onError(int i, int i2, Object obj);

        boolean onInfo(int i, int i2, Object obj);
    }

    void release();

    void setListener(a aVar);

    void setSource(ArrayList<String> arrayList);

    void start();
}
