package com.baidu.tieba;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;
/* loaded from: classes8.dex */
public interface w77 {
    void d(@NonNull RecyclerView recyclerView, boolean z);

    void f(@NonNull RecyclerView recyclerView);

    void j(a87 a87Var);

    void notifyDataSetChanged();

    void setList(List<? extends j87<?>> list);
}
