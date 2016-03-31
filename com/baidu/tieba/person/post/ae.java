package com.baidu.tieba.person.post;

import android.content.Context;
import android.view.View;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class ae {
    BdListView NL;
    com.baidu.tbadk.core.view.p mNoDataView = null;

    public BdListView QF() {
        return this.NL;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ae(Context context, View view) {
        this.NL = (BdListView) view.findViewById(t.g.list);
    }
}
