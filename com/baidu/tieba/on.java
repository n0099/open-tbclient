package com.baidu.tieba;

import android.view.ViewGroup;
import java.util.List;
/* loaded from: classes5.dex */
public interface on<V extends ViewGroup> {
    void addAdapters(List<vm> list);

    List<in> getData();

    jn getListAdapter();

    V getListView();

    void setData(List<? extends in> list);
}
