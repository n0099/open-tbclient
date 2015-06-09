package com.baidu.tieba.person.post;

import android.content.Context;
import android.view.View;
import android.widget.ProgressBar;
import com.baidu.adp.widget.ListView.BdListView;
/* loaded from: classes.dex */
public class aa {
    ProgressBar bUK;
    BdListView mBdListView;
    com.baidu.tbadk.core.view.x mNoDataView = null;

    public BdListView getBdListView() {
        return this.mBdListView;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public aa(Context context, View view) {
        this.mBdListView = (BdListView) view.findViewById(com.baidu.tieba.q.list);
        this.bUK = (ProgressBar) view.findViewById(com.baidu.tieba.q.progress);
    }
}
