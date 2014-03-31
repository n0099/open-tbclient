package com.baidu.tieba.view;

import android.content.Context;
import android.view.View;
/* loaded from: classes.dex */
public final class aa extends com.baidu.tbadk.core.view.q {
    public aa(Context context) {
        super(context);
    }

    @Override // com.baidu.adp.widget.ListView.c, com.baidu.adp.widget.ListView.f
    public final View a() {
        return a(g().getString(com.baidu.tieba.a.k.pull_view_pull_more), g().getString(com.baidu.tieba.a.k.pull_view_release_more), null);
    }
}
