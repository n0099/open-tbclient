package com.baidu.tieba;

import androidx.annotation.Nullable;
import com.baidu.adp.widget.ListView.TypeAdapter;
/* loaded from: classes5.dex */
public interface ln<T> extends hn<T> {
    int b(int i, int i2);

    tm<gn, TypeAdapter.ViewHolder> c(gn gnVar);

    void notifyItemChanged(int i);

    void notifyItemChanged(int i, @Nullable Object obj);
}
