package com.baidu.tieba.recommendfrs;

import android.view.View;
import android.widget.AbsListView;
import com.baidu.tieba.recommendfrs.personalize.a.j;
import com.baidu.tieba.recommendfrs.personalize.a.r;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class l implements AbsListView.RecyclerListener {
    final /* synthetic */ f dXY;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(f fVar) {
        this.dXY = fVar;
    }

    @Override // android.widget.AbsListView.RecyclerListener
    public void onMovedToScrapHeap(View view) {
        if (view != null) {
            if (view.getTag() instanceof r.a) {
                ((r.a) view.getTag()).eby.stopPlay();
            } else if (view.getTag() instanceof j.a) {
                ((j.a) view.getTag()).ebn.stopPlay();
            }
        }
    }
}
