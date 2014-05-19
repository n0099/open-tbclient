package com.baidu.tieba.person.post;

import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.BdListView;
/* loaded from: classes.dex */
public class y {
    BdListView a;
    TextView b;
    ProgressBar c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public y(View view) {
        this.a = (BdListView) view.findViewById(com.baidu.tieba.r.list);
        this.b = (TextView) view.findViewById(com.baidu.tieba.r.no_post_view);
        this.c = (ProgressBar) view.findViewById(com.baidu.tieba.r.progress);
    }
}
