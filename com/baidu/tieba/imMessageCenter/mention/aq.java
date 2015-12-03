package com.baidu.tieba.imMessageCenter.mention;

import android.text.TextUtils;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.tieba.imMessageCenter.mention.ap;
import com.baidu.tieba.n;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aq extends com.baidu.adp.framework.listener.e {
    final /* synthetic */ ap ceP;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public aq(ap apVar, int i) {
        super(i);
        this.ceP = apVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(SocketResponsedMessage socketResponsedMessage) {
        bc bcVar;
        bc bcVar2;
        bc bcVar3;
        ap.a aVar;
        bc bcVar4;
        bc bcVar5;
        if (socketResponsedMessage == null || !(socketResponsedMessage instanceof CheckPostResponseMessage)) {
            bcVar = this.ceP.cep;
            bcVar.showToast(n.i.neterror);
            return;
        }
        CheckPostResponseMessage checkPostResponseMessage = (CheckPostResponseMessage) socketResponsedMessage;
        if (checkPostResponseMessage.hasError()) {
            if (!TextUtils.isEmpty(checkPostResponseMessage.getErrorString())) {
                bcVar5 = this.ceP.cep;
                bcVar5.showToast(checkPostResponseMessage.getErrorString());
                return;
            }
            bcVar4 = this.ceP.cep;
            bcVar4.showToast(n.i.neterror);
            return;
        }
        long forumId = checkPostResponseMessage.getForumId();
        long postState = checkPostResponseMessage.getPostState();
        long quoteId = checkPostResponseMessage.getQuoteId();
        long repostId = checkPostResponseMessage.getRepostId();
        if (postState == 1) {
            aVar = this.ceP.ceO;
            aVar.c(forumId, quoteId, repostId);
        } else if (postState == 0) {
            bcVar3 = this.ceP.cep;
            bcVar3.showToast(n.i.thread_delete_tip);
        } else if (postState == -1) {
            bcVar2 = this.ceP.cep;
            bcVar2.showToast(n.i.thread_shield_tip);
        }
    }
}
