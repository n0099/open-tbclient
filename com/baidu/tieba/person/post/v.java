package com.baidu.tieba.person.post;

import android.content.Context;
import android.view.View;
import android.widget.ProgressBar;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tieba.i;
/* loaded from: classes.dex */
public class v {
    ProgressBar clr;
    BdListView mBdListView;
    com.baidu.tbadk.core.view.u mNoDataView = null;

    public BdListView getBdListView() {
        return this.mBdListView;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public v(Context context, View view) {
        this.mBdListView = (BdListView) view.findViewById(i.f.list);
        this.clr = (ProgressBar) view.findViewById(i.f.progress);
    }
}
