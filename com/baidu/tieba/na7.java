package com.baidu.tieba;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;
/* loaded from: classes7.dex */
public interface na7 {
    void c(@NonNull RecyclerView recyclerView, boolean z);

    void e(@NonNull RecyclerView recyclerView);

    void i(ra7 ra7Var);

    void notifyDataSetChanged();

    void setList(List<? extends ab7<?>> list);
}
