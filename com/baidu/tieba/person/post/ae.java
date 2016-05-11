package com.baidu.tieba.person.post;

import android.content.Context;
import android.view.View;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class ae {
    BdListView Ed;
    com.baidu.tbadk.core.view.q mNoDataView = null;

    public BdListView PC() {
        return this.Ed;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ae(Context context, View view) {
        this.Ed = (BdListView) view.findViewById(t.g.list);
    }
}
