package com.baidu.tieba;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;
/* loaded from: classes8.dex */
public interface wa7 {
    void d(@NonNull RecyclerView recyclerView, boolean z);

    void f(@NonNull RecyclerView recyclerView);

    void j(ab7 ab7Var);

    void notifyDataSetChanged();

    void setList(List<? extends jb7<?>> list);
}
