package com.baidu.tieba;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;
/* loaded from: classes7.dex */
public interface s27 {
    void d(@NonNull RecyclerView recyclerView, boolean z);

    void f(@NonNull RecyclerView recyclerView);

    void j(w27 w27Var);

    void notifyDataSetChanged();

    void setList(List<? extends f37<?>> list);
}
