package com.baidu.tieba.imMessageCenter.mention.base;

import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import com.baidu.adp.widget.ListView.BdRecyclerView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.R;
/* loaded from: classes4.dex */
public class d extends RecyclerView.ItemDecoration {
    private int gXM;

    public d() {
        if (this.gXM <= 0) {
            this.gXM = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds16);
        }
    }

    @Override // android.support.v7.widget.RecyclerView.ItemDecoration
    public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
        int viewLayoutPosition = ((RecyclerView.LayoutParams) view.getLayoutParams()).getViewLayoutPosition();
        if (recyclerView instanceof BdRecyclerView) {
            int headerViewsCount = ((BdRecyclerView) recyclerView).getHeaderViewsCount();
            if (viewLayoutPosition >= 0 && viewLayoutPosition < headerViewsCount - 1) {
                rect.set(0, 0, 0, 0);
                return;
            }
        }
        rect.set(0, 0, 0, this.gXM);
    }
}
