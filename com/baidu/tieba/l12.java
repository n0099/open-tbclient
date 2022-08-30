package com.baidu.tieba;

import android.os.Handler;
import android.os.Looper;
import androidx.annotation.NonNull;
import com.baidu.tieba.k12;
/* loaded from: classes4.dex */
public interface l12<T extends k12> {
    void a(@NonNull Handler handler);

    void b(T t);

    Looper getLooper();
}
