package com.baidu.tieba.person.post;

import android.content.Context;
import android.view.View;
import android.widget.ProgressBar;
import com.baidu.adp.widget.ListView.BdListView;
/* loaded from: classes.dex */
public class aa {
    com.baidu.tbadk.core.view.o ahO = null;
    BdListView azz;
    ProgressBar bEf;

    public BdListView ER() {
        return this.azz;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public aa(Context context, View view) {
        this.azz = (BdListView) view.findViewById(com.baidu.tieba.v.list);
        this.bEf = (ProgressBar) view.findViewById(com.baidu.tieba.v.progress);
    }
}
