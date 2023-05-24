package com.baidu.tieba;

import android.view.View;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
/* loaded from: classes7.dex */
public interface u27 {

    /* loaded from: classes7.dex */
    public interface a {
        void a(View view2, g37<?> g37Var, f37<?, ?> f37Var);
    }

    /* loaded from: classes7.dex */
    public interface b {
        void a(@NonNull g37<?> g37Var);
    }

    /* loaded from: classes7.dex */
    public interface c {
        void a(@NonNull g37<?> g37Var, @NonNull f37<?, ?> f37Var, int i);

        void b(@NonNull RecyclerView recyclerView);
    }

    /* loaded from: classes7.dex */
    public interface d {
        boolean a(View view2, g37<?> g37Var, f37<?, ?> f37Var);
    }

    void c(b bVar);

    void e(c cVar);

    void i(a aVar);
}
