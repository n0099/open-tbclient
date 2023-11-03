package com.baidu.tieba;

import android.view.ViewGroup;
import java.util.List;
/* loaded from: classes8.dex */
public interface ui<V extends ViewGroup> {
    void addAdapters(List<bi> list);

    List<oi> getData();

    pi getListAdapter();

    V getListView();

    void setData(List<? extends oi> list);
}
