package com.baidu.tieba;

import android.view.ViewGroup;
import java.util.List;
/* loaded from: classes8.dex */
public interface xn<V extends ViewGroup> {
    void addAdapters(List<en> list);

    List<rn> getData();

    sn getListAdapter();

    V getListView();

    void setData(List<? extends rn> list);
}
