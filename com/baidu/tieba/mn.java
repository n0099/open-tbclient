package com.baidu.tieba;

import androidx.annotation.Nullable;
import com.baidu.adp.widget.ListView.TypeAdapter;
/* loaded from: classes5.dex */
public interface mn<T> extends in<T> {
    int g(int i, int i2);

    um<hn, TypeAdapter.ViewHolder> h(hn hnVar);

    void notifyItemChanged(int i);

    void notifyItemChanged(int i, @Nullable Object obj);
}
