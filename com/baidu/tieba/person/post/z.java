package com.baidu.tieba.person.post;

import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.BdListView;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
public class z {
    BdListView a;
    TextView b;
    ProgressBar c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public z(View view) {
        this.a = (BdListView) view.findViewById(R.id.list);
        this.b = (TextView) view.findViewById(R.id.no_post_view);
        this.c = (ProgressBar) view.findViewById(R.id.progress);
    }
}
