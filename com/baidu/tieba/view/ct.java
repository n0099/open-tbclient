package com.baidu.tieba.view;

import android.content.Context;
import android.view.View;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
public final class ct extends cs {
    public ct(Context context) {
        super(context);
    }

    @Override // com.baidu.adp.widget.ListView.a, com.baidu.adp.widget.ListView.d
    public final View a() {
        return a(g().getString(R.string.pull_view_pull_more), g().getString(R.string.pull_view_release_more), null);
    }
}
