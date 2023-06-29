package com.baidu.tieba;

import android.os.Bundle;
/* loaded from: classes7.dex */
public interface n30<T> {
    void onError(int i, Throwable th, Bundle bundle);

    void onResult(T t, Bundle bundle);
}
