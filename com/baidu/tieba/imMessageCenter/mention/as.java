package com.baidu.tieba.imMessageCenter.mention;

import android.text.TextUtils;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.tieba.imMessageCenter.mention.ar;
import com.baidu.tieba.t;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class as extends com.baidu.adp.framework.listener.e {
    final /* synthetic */ ar cxV;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public as(ar arVar, int i) {
        super(i);
        this.cxV = arVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(SocketResponsedMessage socketResponsedMessage) {
        be beVar;
        be beVar2;
        be beVar3;
        ar.a aVar;
        be beVar4;
        be beVar5;
        if (socketResponsedMessage == null || !(socketResponsedMessage instanceof CheckPostResponseMessage)) {
            beVar = this.cxV.cxs;
            beVar.showToast(t.j.neterror);
            return;
        }
        CheckPostResponseMessage checkPostResponseMessage = (CheckPostResponseMessage) socketResponsedMessage;
        if (checkPostResponseMessage.hasError()) {
            if (!TextUtils.isEmpty(checkPostResponseMessage.getErrorString())) {
                beVar5 = this.cxV.cxs;
                beVar5.showToast(checkPostResponseMessage.getErrorString());
                return;
            }
            beVar4 = this.cxV.cxs;
            beVar4.showToast(t.j.neterror);
            return;
        }
        long forumId = checkPostResponseMessage.getForumId();
        long postState = checkPostResponseMessage.getPostState();
        long quoteId = checkPostResponseMessage.getQuoteId();
        long repostId = checkPostResponseMessage.getRepostId();
        if (postState == 1) {
            aVar = this.cxV.cxU;
            aVar.b(forumId, quoteId, repostId);
        } else if (postState == 0) {
            beVar3 = this.cxV.cxs;
            beVar3.showToast(t.j.thread_delete_tip);
        } else if (postState == -1) {
            beVar2 = this.cxV.cxs;
            beVar2.showToast(t.j.thread_shield_tip);
        }
    }
}
