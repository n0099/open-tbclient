package com.baidu.tieba.person.post;

import android.content.Context;
import android.view.View;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tieba.u;
/* loaded from: classes.dex */
public class ai {
    BdListView Ei;
    com.baidu.tbadk.core.view.q mNoDataView = null;

    public BdListView Vi() {
        return this.Ei;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ai(Context context, View view) {
        this.Ei = (BdListView) view.findViewById(u.g.list);
    }
}
