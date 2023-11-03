package com.baidu.tieba;

import android.view.View;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
/* loaded from: classes7.dex */
public interface na7 {

    /* loaded from: classes7.dex */
    public interface a {
        void a(View view2, za7<?> za7Var, ya7<?, ?> ya7Var);
    }

    /* loaded from: classes7.dex */
    public interface b {
        void a(@NonNull za7<?> za7Var, int i);
    }

    /* loaded from: classes7.dex */
    public interface c {
        void a(@NonNull za7<?> za7Var, @NonNull ya7<?, ?> ya7Var, int i);

        void b(@NonNull RecyclerView recyclerView);
    }

    /* loaded from: classes7.dex */
    public interface d {
        boolean a(View view2, za7<?> za7Var, ya7<?, ?> ya7Var);
    }

    /* loaded from: classes7.dex */
    public interface e {
        void a(@NonNull Object obj);
    }

    void b(b bVar);

    void d(c cVar);

    void h(a aVar);

    void k(e eVar);
}
