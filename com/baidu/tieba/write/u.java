package com.baidu.tieba.write;

import android.content.Context;
import android.view.View;
import com.baidu.tieba.pb.NewPbActivity;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class u implements View.OnClickListener {
    final /* synthetic */ FeedBackTopListView a;
    private final /* synthetic */ String b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public u(FeedBackTopListView feedBackTopListView, String str) {
        this.a = feedBackTopListView;
        this.b = str;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Context context;
        context = this.a.a;
        NewPbActivity.a(context, this.b, (String) null, "feed_back");
    }
}
