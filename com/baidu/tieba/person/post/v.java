package com.baidu.tieba.person.post;

import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.BdListView;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
public class v {

    /* renamed from: a  reason: collision with root package name */
    BdListView f2267a;
    TextView b;
    ProgressBar c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public v(View view) {
        this.f2267a = (BdListView) view.findViewById(R.id.list);
        this.b = (TextView) view.findViewById(R.id.no_post_view);
        this.c = (ProgressBar) view.findViewById(R.id.progress);
    }
}
