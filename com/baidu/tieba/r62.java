package com.baidu.tieba;

import android.os.Handler;
import android.os.Looper;
import androidx.annotation.NonNull;
import com.baidu.tieba.q62;
/* loaded from: classes8.dex */
public interface r62<T extends q62> {
    void a(@NonNull Handler handler);

    void b(T t);

    Looper getLooper();
}
