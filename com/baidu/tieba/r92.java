package com.baidu.tieba;

import android.os.Handler;
import android.os.Looper;
import androidx.annotation.NonNull;
import com.baidu.tieba.q92;
/* loaded from: classes7.dex */
public interface r92<T extends q92> {
    void a(@NonNull Handler handler);

    void b(T t);

    Looper getLooper();
}
