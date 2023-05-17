package com.baidu.tieba;

import android.view.View;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
/* loaded from: classes7.dex */
public interface t27 {

    /* loaded from: classes7.dex */
    public interface a {
        void a(View view2, f37<?> f37Var, e37<?, ?> e37Var);
    }

    /* loaded from: classes7.dex */
    public interface b {
        void a(@NonNull f37<?> f37Var);
    }

    /* loaded from: classes7.dex */
    public interface c {
        void a(@NonNull f37<?> f37Var, @NonNull e37<?, ?> e37Var, int i);

        void b(@NonNull RecyclerView recyclerView);
    }

    /* loaded from: classes7.dex */
    public interface d {
        boolean a(View view2, f37<?> f37Var, e37<?, ?> e37Var);
    }

    void c(b bVar);

    void e(c cVar);

    void i(a aVar);
}
