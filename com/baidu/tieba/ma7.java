package com.baidu.tieba;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;
/* loaded from: classes7.dex */
public interface ma7 {
    void c(@NonNull RecyclerView recyclerView, boolean z);

    void e(@NonNull RecyclerView recyclerView);

    void i(qa7 qa7Var);

    void notifyDataSetChanged();

    void setList(List<? extends za7<?>> list);
}
