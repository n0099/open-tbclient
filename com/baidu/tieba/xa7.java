package com.baidu.tieba;

import android.view.View;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
/* loaded from: classes8.dex */
public interface xa7 {

    /* loaded from: classes8.dex */
    public interface a {
        void a(View view2, jb7<?> jb7Var, ib7<?, ?> ib7Var);
    }

    /* loaded from: classes8.dex */
    public interface b {
        void a(@NonNull jb7<?> jb7Var, int i);
    }

    /* loaded from: classes8.dex */
    public interface c {
        void a(@NonNull jb7<?> jb7Var, @NonNull ib7<?, ?> ib7Var, int i);

        void b(@NonNull RecyclerView recyclerView);
    }

    /* loaded from: classes8.dex */
    public interface d {
        boolean a(View view2, jb7<?> jb7Var, ib7<?, ?> ib7Var);
    }

    /* loaded from: classes8.dex */
    public interface e {
        void a(@NonNull Object obj);
    }

    void b(b bVar);

    void e(c cVar);

    void i(a aVar);

    void k(e eVar);
}
