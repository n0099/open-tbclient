package com.baidu.tieba;

import android.os.Handler;
import android.os.Looper;
import androidx.annotation.NonNull;
import com.baidu.tieba.nb2;
/* loaded from: classes7.dex */
public interface ob2<T extends nb2> {
    void a(@NonNull Handler handler);

    void b(T t);

    Looper getLooper();
}
