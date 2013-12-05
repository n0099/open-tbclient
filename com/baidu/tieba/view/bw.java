package com.baidu.tieba.view;

import android.view.View;
import android.widget.AbsListView;
/* loaded from: classes.dex */
class bw implements AbsListView.RecyclerListener {

    /* renamed from: a  reason: collision with root package name */
    private int f2683a;

    public bw(int i) {
        this.f2683a = 0;
        this.f2683a = i;
    }

    @Override // android.widget.AbsListView.RecyclerListener
    public void onMovedToScrapHeap(View view) {
        View findViewById = view.findViewById(this.f2683a);
        if (findViewById != null && (findViewById instanceof UserIconBox)) {
            ((UserIconBox) findViewById).a(null, 0, 0, 0, 0);
        }
    }
}
