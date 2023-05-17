package com.baidu.tieba;

import androidx.annotation.Nullable;
import com.baidu.adp.widget.ListView.TypeAdapter;
/* loaded from: classes8.dex */
public interface wn<T> extends sn<T> {
    int g(int i, int i2);

    en<rn, TypeAdapter.ViewHolder> h(rn rnVar);

    void notifyItemChanged(int i);

    void notifyItemChanged(int i, @Nullable Object obj);
}
