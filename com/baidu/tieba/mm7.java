package com.baidu.tieba;

import androidx.annotation.FloatRange;
import androidx.fragment.app.FragmentActivity;
import com.baidu.tieba.lm7;
import java.util.List;
/* loaded from: classes7.dex */
public interface mm7<T extends lm7> {
    void a(@FloatRange(from = 0.0d, to = 1.0d) float f, float f2);

    void b(FragmentActivity fragmentActivity);

    void c(boolean z);

    void d(List<? extends km7<T>> list);

    void e(T t);

    void f();

    void g();
}
