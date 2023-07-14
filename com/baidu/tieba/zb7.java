package com.baidu.tieba;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;
/* loaded from: classes8.dex */
public interface zb7 {
    void d(@NonNull RecyclerView recyclerView, boolean z);

    void f(@NonNull RecyclerView recyclerView);

    void j(dc7 dc7Var);

    void notifyDataSetChanged();

    void setList(List<? extends mc7<?>> list);
}
