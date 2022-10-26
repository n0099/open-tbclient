package com.baidu.tieba;

import android.view.ViewGroup;
import java.util.List;
/* loaded from: classes4.dex */
public interface ko<V extends ViewGroup> {
    void a(List<rn> list);

    List<eo> getData();

    fo getListAdapter();

    V getListView();

    void setData(List<? extends eo> list);
}
