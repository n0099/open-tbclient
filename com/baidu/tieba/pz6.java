package com.baidu.tieba;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;
/* loaded from: classes6.dex */
public interface pz6 {
    void d(@NonNull RecyclerView recyclerView, boolean z);

    void f(@NonNull RecyclerView recyclerView);

    void j(tz6 tz6Var);

    void notifyDataSetChanged();

    void setList(List<? extends c07<?>> list);
}
