package com.baidu.tieba;

import android.os.Handler;
import android.os.Looper;
import androidx.annotation.NonNull;
import com.baidu.tieba.o42;
/* loaded from: classes5.dex */
public interface p42<T extends o42> {
    void a(@NonNull Handler handler);

    void b(T t);

    Looper getLooper();
}
