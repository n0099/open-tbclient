package com.baidu.tieba;

import android.os.Handler;
import android.os.Looper;
import androidx.annotation.NonNull;
import com.baidu.tieba.v32;
/* loaded from: classes6.dex */
public interface w32<T extends v32> {
    void a(@NonNull Handler handler);

    void b(T t);

    Looper getLooper();
}
