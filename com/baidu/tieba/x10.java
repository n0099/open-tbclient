package com.baidu.tieba;

import android.os.Bundle;
/* loaded from: classes6.dex */
public interface x10<T> {
    void onError(int i, Throwable th, Bundle bundle);

    void onResult(T t, Bundle bundle);
}
