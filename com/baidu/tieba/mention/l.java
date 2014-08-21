package com.baidu.tieba.mention;

import android.content.Context;
import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tieba.data.FeedData;
import java.util.List;
/* loaded from: classes.dex */
class l implements View.OnClickListener {
    final /* synthetic */ k a;
    private FeedData b;

    private l(k kVar) {
        this.a = kVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ l(k kVar, l lVar) {
        this(kVar);
    }

    public void a(FeedData feedData) {
        this.b = feedData;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int i;
        Context context;
        Context context2;
        Context context3;
        if (this.b != null) {
            if (!FeedData.TYPE_ZAN.equals(this.b.getPraiseItemType())) {
                i = this.a.h;
                if (i == 1) {
                    MessageManager messageManager = MessageManager.getInstance();
                    context2 = this.a.a;
                    messageManager.sendMessage(new CustomMessage(2002001, new com.baidu.tbadk.core.atomData.a(context2, this.b.getReplyer().getUserId(), this.b.getReplyer().getName_show(), this.b.getReplyer().getPortrait(), this.b.getFname(), false, "reply_pg")));
                    return;
                }
                MessageManager messageManager2 = MessageManager.getInstance();
                context = this.a.a;
                messageManager2.sendMessage(new CustomMessage(2002001, new com.baidu.tbadk.core.atomData.a(context, this.b.getReplyer().getUserId(), this.b.getReplyer().getName_show(), this.b.getReplyer().getPortrait(), this.b.getFname(), false, "at_me")));
                return;
            }
            List<com.baidu.tieba.data.y> praiseList = this.b.getPraiseList();
            if (praiseList != null && praiseList.size() > 0) {
                com.baidu.tieba.data.y yVar = praiseList.get(0);
                MessageManager messageManager3 = MessageManager.getInstance();
                context3 = this.a.a;
                messageManager3.sendMessage(new CustomMessage(2002001, new com.baidu.tbadk.core.atomData.a(context3, yVar.a(), yVar.c(), yVar.d(), this.b.getFname(), false, "reply_pg")));
            }
        }
    }
}
