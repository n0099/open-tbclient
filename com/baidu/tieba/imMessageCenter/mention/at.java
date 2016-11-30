package com.baidu.tieba.imMessageCenter.mention;

import android.text.TextUtils;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.tieba.imMessageCenter.mention.as;
import com.baidu.tieba.r;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class at extends com.baidu.adp.framework.listener.e {
    final /* synthetic */ as dzV;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public at(as asVar, int i) {
        super(i);
        this.dzV = asVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(SocketResponsedMessage socketResponsedMessage) {
        bf bfVar;
        bf bfVar2;
        bf bfVar3;
        as.a aVar;
        bf bfVar4;
        bf bfVar5;
        if (socketResponsedMessage == null || !(socketResponsedMessage instanceof CheckPostResponseMessage)) {
            bfVar = this.dzV.dzq;
            bfVar.showToast(r.j.neterror);
            return;
        }
        CheckPostResponseMessage checkPostResponseMessage = (CheckPostResponseMessage) socketResponsedMessage;
        if (checkPostResponseMessage.hasError()) {
            if (!TextUtils.isEmpty(checkPostResponseMessage.getErrorString())) {
                bfVar5 = this.dzV.dzq;
                bfVar5.showToast(checkPostResponseMessage.getErrorString());
                return;
            }
            bfVar4 = this.dzV.dzq;
            bfVar4.showToast(r.j.neterror);
            return;
        }
        long forumId = checkPostResponseMessage.getForumId();
        long postState = checkPostResponseMessage.getPostState();
        long quoteId = checkPostResponseMessage.getQuoteId();
        long repostId = checkPostResponseMessage.getRepostId();
        if (postState == 1) {
            aVar = this.dzV.dzU;
            aVar.b(forumId, quoteId, repostId);
        } else if (postState == 0) {
            bfVar3 = this.dzV.dzq;
            bfVar3.showToast(r.j.thread_delete_tip);
        } else if (postState == -1) {
            bfVar2 = this.dzV.dzq;
            bfVar2.showToast(r.j.thread_shield_tip);
        }
    }
}
