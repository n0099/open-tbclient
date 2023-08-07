package com.baidu.tieba;

import android.os.Handler;
import android.os.Looper;
import androidx.annotation.NonNull;
import com.baidu.tieba.ib2;
/* loaded from: classes6.dex */
public interface jb2<T extends ib2> {
    void a(@NonNull Handler handler);

    void b(T t);

    Looper getLooper();
}
