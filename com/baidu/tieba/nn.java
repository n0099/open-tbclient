package com.baidu.tieba;

import androidx.annotation.Nullable;
import com.baidu.adp.widget.ListView.TypeAdapter;
/* loaded from: classes5.dex */
public interface nn<T> extends jn<T> {
    int g(int i, int i2);

    vm<in, TypeAdapter.ViewHolder> h(in inVar);

    void notifyItemChanged(int i);

    void notifyItemChanged(int i, @Nullable Object obj);
}
