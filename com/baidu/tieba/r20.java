package com.baidu.tieba;

import android.os.Bundle;
/* loaded from: classes6.dex */
public interface r20<T> {
    void onError(int i, Throwable th, Bundle bundle);

    void onResult(T t, Bundle bundle);
}
