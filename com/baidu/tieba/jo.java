package com.baidu.tieba;

import android.view.ViewGroup;
import java.util.List;
/* loaded from: classes5.dex */
public interface jo<V extends ViewGroup> {
    void a(List<qn> list);

    List<Cdo> getData();

    eo getListAdapter();

    V getListView();

    void setData(List<? extends Cdo> list);
}
