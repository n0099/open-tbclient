package com.baidu.tieba;

import android.view.View;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
/* loaded from: classes8.dex */
public interface v67 {

    /* loaded from: classes8.dex */
    public interface a {
        void a(View view2, h77<?> h77Var, g77<?, ?> g77Var);
    }

    /* loaded from: classes8.dex */
    public interface b {
        void a(@NonNull h77<?> h77Var, int i);
    }

    /* loaded from: classes8.dex */
    public interface c {
        void a(@NonNull h77<?> h77Var, @NonNull g77<?, ?> g77Var, int i);

        void b(@NonNull RecyclerView recyclerView);
    }

    /* loaded from: classes8.dex */
    public interface d {
        boolean a(View view2, h77<?> h77Var, g77<?, ?> g77Var);
    }

    /* loaded from: classes8.dex */
    public interface e {
        void a(@NonNull Object obj);
    }

    void c(b bVar);

    void e(c cVar);

    void i(a aVar);

    void k(e eVar);
}
