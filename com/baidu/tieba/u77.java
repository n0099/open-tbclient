package com.baidu.tieba;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;
/* loaded from: classes8.dex */
public interface u77 {
    void d(@NonNull RecyclerView recyclerView, boolean z);

    void f(@NonNull RecyclerView recyclerView);

    void j(y77 y77Var);

    void notifyDataSetChanged();

    void setList(List<? extends h87<?>> list);
}
