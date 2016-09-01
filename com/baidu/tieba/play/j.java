package com.baidu.tieba.play;

import android.view.View;
import android.widget.AbsListView;
/* loaded from: classes.dex */
class j implements AbsListView.RecyclerListener {
    final /* synthetic */ i eWz;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(i iVar) {
        this.eWz = iVar;
    }

    @Override // android.widget.AbsListView.RecyclerListener
    public void onMovedToScrapHeap(View view) {
        if (!this.eWz.bi(view) && (view.getTag() instanceof d)) {
            ((d) view.getTag()).stopPlay();
        }
    }
}
