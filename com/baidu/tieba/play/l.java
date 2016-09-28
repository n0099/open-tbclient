package com.baidu.tieba.play;

import android.view.View;
import android.widget.AbsListView;
/* loaded from: classes.dex */
class l implements AbsListView.RecyclerListener {
    final /* synthetic */ k eYE;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(k kVar) {
        this.eYE = kVar;
    }

    @Override // android.widget.AbsListView.RecyclerListener
    public void onMovedToScrapHeap(View view) {
        if (!this.eYE.bg(view) && (view.getTag() instanceof d)) {
            ((d) view.getTag()).stopPlay();
        }
    }
}
