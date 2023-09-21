package com.baidu.tieba;

import android.os.Handler;
import android.os.Looper;
import androidx.annotation.NonNull;
import com.baidu.tieba.qb2;
/* loaded from: classes7.dex */
public interface rb2<T extends qb2> {
    void a(@NonNull Handler handler);

    void b(T t);

    Looper getLooper();
}
