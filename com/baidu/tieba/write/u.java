package com.baidu.tieba.write;

import android.content.Context;
import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class u implements View.OnClickListener {
    final /* synthetic */ FeedBackTopListView a;
    private final /* synthetic */ String b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public u(FeedBackTopListView feedBackTopListView, String str) {
        this.a = feedBackTopListView;
        this.b = str;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        Context context;
        com.baidu.adp.framework.c a = com.baidu.adp.framework.c.a();
        context = this.a.a;
        a.a(new com.baidu.adp.framework.message.a(2004001, new com.baidu.tbadk.core.b.af(context).a(this.b, null, "feed_back")));
    }
}
