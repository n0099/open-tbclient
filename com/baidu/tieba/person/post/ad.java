package com.baidu.tieba.person.post;

import android.content.Context;
import android.view.View;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tieba.n;
/* loaded from: classes.dex */
public class ad {
    BdListView mBdListView;
    com.baidu.tbadk.core.view.o mNoDataView = null;

    public BdListView getBdListView() {
        return this.mBdListView;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ad(Context context, View view) {
        this.mBdListView = (BdListView) view.findViewById(n.g.list);
    }
}
