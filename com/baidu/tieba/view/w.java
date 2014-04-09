package com.baidu.tieba.view;

import android.app.Activity;
import android.view.View;
import com.baidu.tbadk.core.util.TiebaStatic;
/* loaded from: classes.dex */
final class w implements View.OnClickListener {
    final /* synthetic */ SearchBoxView a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public w(SearchBoxView searchBoxView) {
        this.a = searchBoxView;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        Activity activity;
        String str;
        Activity activity2;
        if (view.getId() == com.baidu.tieba.a.h.search_bg_layout) {
            activity = this.a.a;
            str = this.a.b;
            TiebaStatic.a(activity, str, "click", 1, new Object[0]);
            com.baidu.adp.framework.c a = com.baidu.adp.framework.c.a();
            activity2 = this.a.a;
            a.a(new com.baidu.adp.framework.message.a(2015002, new com.baidu.tbadk.core.frameworkData.a(activity2)));
        }
    }
}
