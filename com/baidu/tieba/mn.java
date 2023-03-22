package com.baidu.tieba;

import android.view.ViewGroup;
import java.util.List;
/* loaded from: classes5.dex */
public interface mn<V extends ViewGroup> {
    void addAdapters(List<tm> list);

    List<gn> getData();

    hn getListAdapter();

    V getListView();

    void setData(List<? extends gn> list);
}
