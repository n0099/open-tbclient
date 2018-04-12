package com.baidu.tieba.imMessageCenter.mention.base;

import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import com.baidu.adp.widget.ListView.BdRecyclerView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.d;
/* loaded from: classes2.dex */
public class d extends RecyclerView.ItemDecoration {
    private int dividerHeight;

    public d() {
        if (this.dividerHeight <= 0) {
            this.dividerHeight = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.tbds16);
        }
    }

    @Override // android.support.v7.widget.RecyclerView.ItemDecoration
    public void getItemOffsets(Rect rect, View view2, RecyclerView recyclerView, RecyclerView.State state) {
        int viewLayoutPosition = ((RecyclerView.LayoutParams) view2.getLayoutParams()).getViewLayoutPosition();
        if (recyclerView instanceof BdRecyclerView) {
            int headerViewsCount = ((BdRecyclerView) recyclerView).getHeaderViewsCount();
            if (viewLayoutPosition >= 0 && viewLayoutPosition < headerViewsCount - 1) {
                rect.set(0, 0, 0, 0);
                return;
            }
        }
        rect.set(0, 0, 0, this.dividerHeight);
    }
}
