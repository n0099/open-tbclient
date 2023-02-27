package com.baidu.tieba;

import android.os.Handler;
import android.os.Looper;
import androidx.annotation.NonNull;
import com.baidu.tieba.w92;
/* loaded from: classes6.dex */
public interface x92<T extends w92> {
    void a(@NonNull Handler handler);

    void b(T t);

    Looper getLooper();
}
