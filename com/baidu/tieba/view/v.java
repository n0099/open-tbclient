package com.baidu.tieba.view;

import android.app.Activity;
import android.view.View;
/* loaded from: classes.dex */
final class v implements View.OnClickListener {
    final /* synthetic */ SearchBoxView a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public v(SearchBoxView searchBoxView) {
        this.a = searchBoxView;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        Activity activity;
        activity = this.a.a;
        com.baidu.adp.framework.c.a().a(new com.baidu.adp.framework.message.a(2001001, new com.baidu.tbadk.core.b.e(activity, 16003)));
    }
}
