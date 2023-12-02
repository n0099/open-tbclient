package com.baidu.tieba;

import android.os.Handler;
import android.os.Looper;
import androidx.annotation.NonNull;
import com.baidu.tieba.u62;
/* loaded from: classes8.dex */
public interface v62<T extends u62> {
    void a(@NonNull Handler handler);

    void b(T t);

    Looper getLooper();
}
