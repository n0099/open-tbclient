package com.baidu.tieba;

import android.view.ViewGroup;
import java.util.List;
/* loaded from: classes6.dex */
public interface vn<V extends ViewGroup> {
    void a(List<cn> list);

    List<pn> getData();

    qn getListAdapter();

    V getListView();

    void setData(List<? extends pn> list);
}
