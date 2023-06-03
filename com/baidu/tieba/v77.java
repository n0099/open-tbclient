package com.baidu.tieba;

import android.view.View;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
/* loaded from: classes8.dex */
public interface v77 {

    /* loaded from: classes8.dex */
    public interface a {
        void a(View view2, h87<?> h87Var, g87<?, ?> g87Var);
    }

    /* loaded from: classes8.dex */
    public interface b {
        void a(@NonNull h87<?> h87Var);
    }

    /* loaded from: classes8.dex */
    public interface c {
        void a(@NonNull h87<?> h87Var, @NonNull g87<?, ?> g87Var, int i);

        void b(@NonNull RecyclerView recyclerView);
    }

    /* loaded from: classes8.dex */
    public interface d {
        boolean a(View view2, h87<?> h87Var, g87<?, ?> g87Var);
    }

    void c(b bVar);

    void e(c cVar);

    void i(a aVar);
}
