package com.baidu.tieba.view;

import android.view.View;
import android.widget.AbsListView;
/* loaded from: classes.dex */
class bt implements AbsListView.RecyclerListener {

    /* renamed from: a  reason: collision with root package name */
    private int f2583a;

    public bt(int i) {
        this.f2583a = 0;
        this.f2583a = i;
    }

    @Override // android.widget.AbsListView.RecyclerListener
    public void onMovedToScrapHeap(View view) {
        View findViewById = view.findViewById(this.f2583a);
        if (findViewById != null && (findViewById instanceof UserIconBox)) {
            ((UserIconBox) findViewById).a(null, 0, 0, 0, 0);
        }
    }
}
