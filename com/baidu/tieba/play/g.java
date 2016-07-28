package com.baidu.tieba.play;

import android.view.View;
import android.widget.AbsListView;
/* loaded from: classes.dex */
class g implements AbsListView.RecyclerListener {
    final /* synthetic */ f ePr;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(f fVar) {
        this.ePr = fVar;
    }

    @Override // android.widget.AbsListView.RecyclerListener
    public void onMovedToScrapHeap(View view) {
        if (view.getTag() instanceof d) {
            ((d) view.getTag()).stopPlay();
        }
    }
}
