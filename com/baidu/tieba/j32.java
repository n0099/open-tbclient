package com.baidu.tieba;

import android.os.Handler;
import android.os.Looper;
import androidx.annotation.NonNull;
import com.baidu.tieba.i32;
/* loaded from: classes4.dex */
public interface j32<T extends i32> {
    void a(@NonNull Handler handler);

    void b(T t);

    Looper getLooper();
}
