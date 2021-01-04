package com.baidu.tieba.imMessageCenter.mention.base;

import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.adp.widget.ListView.BdRecyclerView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.R;
/* loaded from: classes2.dex */
public class DeviderLineDecoration extends RecyclerView.ItemDecoration {
    private int dividerHeight;

    public DeviderLineDecoration() {
        if (this.dividerHeight <= 0) {
            this.dividerHeight = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds16);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
        int viewLayoutPosition = ((RecyclerView.LayoutParams) view.getLayoutParams()).getViewLayoutPosition();
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
