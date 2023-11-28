package com.baidu.tieba;

import androidx.annotation.Nullable;
import com.baidu.adp.widget.ListView.TypeAdapter;
/* loaded from: classes8.dex */
public interface ui<T> extends qi<T> {
    int g(int i, int i2);

    ci<pi, TypeAdapter.ViewHolder> h(pi piVar);

    void notifyItemChanged(int i);

    void notifyItemChanged(int i, @Nullable Object obj);
}
