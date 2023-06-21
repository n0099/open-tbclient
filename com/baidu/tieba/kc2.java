package com.baidu.tieba;

import android.os.Handler;
import android.os.Looper;
import androidx.annotation.NonNull;
import com.baidu.tieba.jc2;
/* loaded from: classes6.dex */
public interface kc2<T extends jc2> {
    void a(@NonNull Handler handler);

    void b(T t);

    Looper getLooper();
}
