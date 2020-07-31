package com.baidu.turbonet.base;

import com.baidu.turbonet.base.annotations.CalledByNative;
/* loaded from: classes19.dex */
public abstract class Callback<T> {
    public abstract void onResult(T t);

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: java.lang.Object */
    /* JADX WARN: Multi-variable type inference failed */
    @CalledByNative
    private void onResultFromNative(Object obj) {
        onResult(obj);
    }

    @CalledByNative
    private void onResultFromNative(boolean z) {
        onResult(Boolean.valueOf(z));
    }

    @CalledByNative
    private void onResultFromNative(int i) {
        onResult(Integer.valueOf(i));
    }
}
