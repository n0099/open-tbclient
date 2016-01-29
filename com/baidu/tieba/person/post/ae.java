package com.baidu.tieba.person.post;

import android.content.Context;
import android.view.View;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class ae {
    BdListView NE;
    com.baidu.tbadk.core.view.o mNoDataView = null;

    public BdListView OQ() {
        return this.NE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ae(Context context, View view) {
        this.NE = (BdListView) view.findViewById(t.g.list);
    }
}
