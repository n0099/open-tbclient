package com.baidu.tieba;

import android.view.ViewGroup;
import java.util.List;
/* loaded from: classes8.dex */
public interface vi<V extends ViewGroup> {
    void addAdapters(List<ci> list);

    List<pi> getData();

    qi getListAdapter();

    V getListView();

    void setData(List<? extends pi> list);
}
