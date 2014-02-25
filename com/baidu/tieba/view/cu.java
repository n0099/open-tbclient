package com.baidu.tieba.view;

import android.content.Context;
import android.view.View;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
public class cu extends ct {
    public cu(Context context) {
        super(context);
    }

    @Override // com.baidu.adp.widget.ListView.a, com.baidu.adp.widget.ListView.d
    public View a() {
        return a(h().getString(R.string.pull_view_pull_more), h().getString(R.string.pull_view_release_more), null);
    }
}
