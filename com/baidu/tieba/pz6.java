package com.baidu.tieba;

import android.view.View;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
/* loaded from: classes5.dex */
public interface pz6 {

    /* loaded from: classes5.dex */
    public interface a {
        void a(View view2, b07<?> b07Var, a07<?, ?> a07Var);
    }

    /* loaded from: classes5.dex */
    public interface b {
        void a(@NonNull b07<?> b07Var);
    }

    /* loaded from: classes5.dex */
    public interface c {
        void a(@NonNull b07<?> b07Var, @NonNull a07<?, ?> a07Var, int i);

        void b(@NonNull RecyclerView recyclerView);
    }

    /* loaded from: classes5.dex */
    public interface d {
        boolean a(View view2, b07<?> b07Var, a07<?, ?> a07Var);
    }

    void c(b bVar);

    void e(c cVar);

    void i(a aVar);
}
