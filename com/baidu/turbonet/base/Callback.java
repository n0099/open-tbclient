package com.baidu.turbonet.base;

import com.baidu.turbonet.base.annotations.CalledByNative;
/* loaded from: classes5.dex */
public abstract class Callback<T> {
    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: java.lang.Object */
    /* JADX WARN: Multi-variable type inference failed */
    @CalledByNative
    private void onResultFromNative(Object obj) {
        a(obj);
    }

    public abstract void a(T t);

    @CalledByNative
    private void onResultFromNative(boolean z) {
        a(Boolean.valueOf(z));
    }

    @CalledByNative
    private void onResultFromNative(int i2) {
        a(Integer.valueOf(i2));
    }
}
