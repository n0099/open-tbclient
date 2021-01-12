package com.baidu.tieba.memberCenter.tail.tool;

import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.ListAdapter;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tieba.R;
/* loaded from: classes8.dex */
public class h {
    BdListView WT;

    public h(ViewGroup viewGroup) {
        this.WT = (BdListView) viewGroup.findViewById(R.id.tail_tool_listview);
        View view = new View(viewGroup.getContext());
        view.setLayoutParams(new AbsListView.LayoutParams(-1, (int) viewGroup.getContext().getResources().getDimension(R.dimen.ds30)));
        this.WT.addHeaderView(view);
    }

    public void c(b bVar) {
        this.WT.setAdapter((ListAdapter) bVar);
    }
}
