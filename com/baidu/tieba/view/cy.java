package com.baidu.tieba.view;

import android.view.View;
import android.widget.AbsListView;
/* loaded from: classes.dex */
class cy implements AbsListView.RecyclerListener {
    private int a;

    public cy(int i) {
        this.a = 0;
        this.a = i;
    }

    @Override // android.widget.AbsListView.RecyclerListener
    public void onMovedToScrapHeap(View view) {
        View findViewById = view.findViewById(this.a);
        if (findViewById != null && (findViewById instanceof UserIconBox)) {
            ((UserIconBox) findViewById).a(null, 0, 0, 0, 0);
        }
    }
}
