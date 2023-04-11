package com.baidu.tieba;

import android.view.ViewGroup;
import java.util.List;
/* loaded from: classes5.dex */
public interface nn<V extends ViewGroup> {
    void addAdapters(List<um> list);

    List<hn> getData();

    in getListAdapter();

    V getListView();

    void setData(List<? extends hn> list);
}
