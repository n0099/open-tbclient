package com.baidu.tieba;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;
/* loaded from: classes8.dex */
public interface u67 {
    void d(@NonNull RecyclerView recyclerView, boolean z);

    void f(@NonNull RecyclerView recyclerView);

    void j(y67 y67Var);

    void notifyDataSetChanged();

    void setList(List<? extends h77<?>> list);
}
