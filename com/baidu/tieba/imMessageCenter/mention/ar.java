package com.baidu.tieba.imMessageCenter.mention;

import android.text.TextUtils;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.tieba.imMessageCenter.mention.aq;
import com.baidu.tieba.n;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ar extends com.baidu.adp.framework.listener.e {
    final /* synthetic */ aq ciT;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ar(aq aqVar, int i) {
        super(i);
        this.ciT = aqVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(SocketResponsedMessage socketResponsedMessage) {
        bd bdVar;
        bd bdVar2;
        bd bdVar3;
        aq.a aVar;
        bd bdVar4;
        bd bdVar5;
        if (socketResponsedMessage == null || !(socketResponsedMessage instanceof CheckPostResponseMessage)) {
            bdVar = this.ciT.ciq;
            bdVar.showToast(n.j.neterror);
            return;
        }
        CheckPostResponseMessage checkPostResponseMessage = (CheckPostResponseMessage) socketResponsedMessage;
        if (checkPostResponseMessage.hasError()) {
            if (!TextUtils.isEmpty(checkPostResponseMessage.getErrorString())) {
                bdVar5 = this.ciT.ciq;
                bdVar5.showToast(checkPostResponseMessage.getErrorString());
                return;
            }
            bdVar4 = this.ciT.ciq;
            bdVar4.showToast(n.j.neterror);
            return;
        }
        long forumId = checkPostResponseMessage.getForumId();
        long postState = checkPostResponseMessage.getPostState();
        long quoteId = checkPostResponseMessage.getQuoteId();
        long repostId = checkPostResponseMessage.getRepostId();
        if (postState == 1) {
            aVar = this.ciT.ciS;
            aVar.c(forumId, quoteId, repostId);
        } else if (postState == 0) {
            bdVar3 = this.ciT.ciq;
            bdVar3.showToast(n.j.thread_delete_tip);
        } else if (postState == -1) {
            bdVar2 = this.ciT.ciq;
            bdVar2.showToast(n.j.thread_shield_tip);
        }
    }
}
