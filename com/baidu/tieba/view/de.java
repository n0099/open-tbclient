package com.baidu.tieba.view;

import android.view.View;
import android.widget.AbsListView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class de implements AbsListView.RecyclerListener {
    private int a;

    public de(int i) {
        this.a = 0;
        this.a = i;
    }

    @Override // android.widget.AbsListView.RecyclerListener
    public final void onMovedToScrapHeap(View view) {
        View findViewById = view.findViewById(this.a);
        if (findViewById != null && (findViewById instanceof UserIconBox)) {
            ((UserIconBox) findViewById).a(null, 0, 0, 0, 0);
        }
    }
}
