package com.baidu.tieba;

import android.os.Handler;
import android.os.Looper;
import androidx.annotation.NonNull;
import com.baidu.tieba.rb2;
/* loaded from: classes7.dex */
public interface sb2<T extends rb2> {
    void a(@NonNull Handler handler);

    void b(T t);

    Looper getLooper();
}
