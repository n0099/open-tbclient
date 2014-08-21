package com.baidu.tieba.view;

import android.content.Context;
import android.view.View;
/* loaded from: classes.dex */
public class y extends com.baidu.tbadk.core.view.v {
    public y(Context context) {
        super(context);
    }

    @Override // com.baidu.adp.widget.ListView.c, com.baidu.adp.widget.ListView.f
    public View a() {
        return a(h().getString(com.baidu.tieba.x.pull_view_pull_more), h().getString(com.baidu.tieba.x.pull_view_release_more), null);
    }
}
