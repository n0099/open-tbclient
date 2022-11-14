package com.baidu.tieba;

import android.os.Handler;
import android.os.Looper;
import androidx.annotation.NonNull;
import com.baidu.tieba.p42;
/* loaded from: classes5.dex */
public interface q42<T extends p42> {
    void a(@NonNull Handler handler);

    void b(T t);

    Looper getLooper();
}
