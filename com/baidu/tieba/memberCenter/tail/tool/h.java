package com.baidu.tieba.memberCenter.tail.tool;

import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.ListAdapter;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tieba.R;
/* loaded from: classes9.dex */
public class h {
    BdListView WV;

    public h(ViewGroup viewGroup) {
        this.WV = (BdListView) viewGroup.findViewById(R.id.tail_tool_listview);
        View view = new View(viewGroup.getContext());
        view.setLayoutParams(new AbsListView.LayoutParams(-1, (int) viewGroup.getContext().getResources().getDimension(R.dimen.ds30)));
        this.WV.addHeaderView(view);
    }

    public void c(b bVar) {
        this.WV.setAdapter((ListAdapter) bVar);
    }
}
