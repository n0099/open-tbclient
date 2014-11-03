package com.baidu.tieba.person.post;

import android.content.Context;
import android.view.View;
import android.widget.ProgressBar;
import com.baidu.adp.widget.ListView.BdListView;
/* loaded from: classes.dex */
public class ab {
    com.baidu.tbadk.core.view.o ahX = null;
    BdListView azI;
    ProgressBar bEt;

    public BdListView ET() {
        return this.azI;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ab(Context context, View view) {
        this.azI = (BdListView) view.findViewById(com.baidu.tieba.v.list);
        this.bEt = (ProgressBar) view.findViewById(com.baidu.tieba.v.progress);
    }
}
