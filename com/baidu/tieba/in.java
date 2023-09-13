package com.baidu.tieba;

import android.view.ViewGroup;
import java.util.List;
/* loaded from: classes6.dex */
public interface in<V extends ViewGroup> {
    void addAdapters(List<pm> list);

    List<cn> getData();

    dn getListAdapter();

    V getListView();

    void setData(List<? extends cn> list);
}
