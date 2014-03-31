package com.baidu.tieba.person.post;

import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.BdListView;
/* loaded from: classes.dex */
public final class x {
    BdListView a;
    TextView b;
    ProgressBar c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public x(View view) {
        this.a = (BdListView) view.findViewById(com.baidu.tieba.a.h.list);
        this.b = (TextView) view.findViewById(com.baidu.tieba.a.h.no_post_view);
        this.c = (ProgressBar) view.findViewById(com.baidu.tieba.a.h.progress);
    }
}
