package com.baidu.tieba.recommendfrs;

import android.view.View;
import android.widget.AbsListView;
import com.baidu.tieba.recommendfrs.personalize.a.j;
import com.baidu.tieba.recommendfrs.personalize.a.r;
/* loaded from: classes.dex */
class k implements AbsListView.RecyclerListener {
    final /* synthetic */ f dVf;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(f fVar) {
        this.dVf = fVar;
    }

    @Override // android.widget.AbsListView.RecyclerListener
    public void onMovedToScrapHeap(View view) {
        if (view != null) {
            if (view.getTag() instanceof r.a) {
                ((r.a) view.getTag()).dYr.stopPlay();
            } else if (view.getTag() instanceof j.a) {
                ((j.a) view.getTag()).dYg.stopPlay();
            }
        }
    }
}
