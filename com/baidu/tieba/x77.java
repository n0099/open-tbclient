package com.baidu.tieba;

import android.view.View;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
/* loaded from: classes8.dex */
public interface x77 {

    /* loaded from: classes8.dex */
    public interface a {
        void a(View view2, j87<?> j87Var, i87<?, ?> i87Var);
    }

    /* loaded from: classes8.dex */
    public interface b {
        void a(@NonNull j87<?> j87Var);
    }

    /* loaded from: classes8.dex */
    public interface c {
        void a(@NonNull j87<?> j87Var, @NonNull i87<?, ?> i87Var, int i);

        void b(@NonNull RecyclerView recyclerView);
    }

    /* loaded from: classes8.dex */
    public interface d {
        boolean a(View view2, j87<?> j87Var, i87<?, ?> i87Var);
    }

    void c(b bVar);

    void e(c cVar);

    void i(a aVar);
}
