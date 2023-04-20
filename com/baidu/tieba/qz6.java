package com.baidu.tieba;

import android.view.View;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
/* loaded from: classes6.dex */
public interface qz6 {

    /* loaded from: classes6.dex */
    public interface a {
        void a(View view2, c07<?> c07Var, b07<?, ?> b07Var);
    }

    /* loaded from: classes6.dex */
    public interface b {
        void a(@NonNull c07<?> c07Var);
    }

    /* loaded from: classes6.dex */
    public interface c {
        void a(@NonNull c07<?> c07Var, @NonNull b07<?, ?> b07Var, int i);

        void b(@NonNull RecyclerView recyclerView);
    }

    /* loaded from: classes6.dex */
    public interface d {
        boolean a(View view2, c07<?> c07Var, b07<?, ?> b07Var);
    }

    void c(b bVar);

    void e(c cVar);

    void i(a aVar);
}
