package com.baidu.tieba.write;

import android.content.Context;
import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
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
        MessageManager messageManager = MessageManager.getInstance();
        context = this.a.a;
        messageManager.sendMessage(new CustomMessage(2006001, new com.baidu.tbadk.core.atomData.as(context).a(this.b, null, "feed_back")));
    }
}
