package com.baidu.tieba;

import android.os.Handler;
import android.os.Looper;
import androidx.annotation.NonNull;
import com.baidu.tieba.t42;
/* loaded from: classes6.dex */
public interface u42<T extends t42> {
    void a(@NonNull Handler handler);

    void b(T t);

    Looper getLooper();
}
