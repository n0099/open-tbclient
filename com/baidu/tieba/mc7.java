package com.baidu.tieba;

import android.view.View;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
/* loaded from: classes7.dex */
public interface mc7 {

    /* loaded from: classes7.dex */
    public interface a {
        void a(View view2, yc7<?> yc7Var, xc7<?, ?> xc7Var);
    }

    /* loaded from: classes7.dex */
    public interface b {
        void a(@NonNull yc7<?> yc7Var, int i);
    }

    /* loaded from: classes7.dex */
    public interface c {
        void a(@NonNull yc7<?> yc7Var, @NonNull xc7<?, ?> xc7Var, int i);

        void b(@NonNull RecyclerView recyclerView);
    }

    /* loaded from: classes7.dex */
    public interface d {
        boolean a(View view2, yc7<?> yc7Var, xc7<?, ?> xc7Var);
    }

    /* loaded from: classes7.dex */
    public interface e {
        void a(@NonNull Object obj);
    }

    void c(b bVar);

    void e(c cVar);

    void i(a aVar);

    void k(e eVar);
}
