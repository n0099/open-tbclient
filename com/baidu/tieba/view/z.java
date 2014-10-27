package com.baidu.tieba.view;

import android.content.Context;
import android.view.View;
/* loaded from: classes.dex */
public class z extends com.baidu.tbadk.core.view.y {
    public z(Context context) {
        super(context);
    }

    @Override // com.baidu.adp.widget.ListView.d, com.baidu.adp.widget.ListView.i
    public View hA() {
        return c(getContext().getString(com.baidu.tieba.y.pull_view_pull_more), getContext().getString(com.baidu.tieba.y.pull_view_release_more), null);
    }
}
