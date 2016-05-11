package com.baidu.tieba.imMessageCenter.mention;

import android.text.TextUtils;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.tieba.imMessageCenter.mention.as;
import com.baidu.tieba.t;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class at extends com.baidu.adp.framework.listener.e {
    final /* synthetic */ as cyU;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public at(as asVar, int i) {
        super(i);
        this.cyU = asVar;
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
            bfVar = this.cyU.cyq;
            bfVar.showToast(t.j.neterror);
            return;
        }
        CheckPostResponseMessage checkPostResponseMessage = (CheckPostResponseMessage) socketResponsedMessage;
        if (checkPostResponseMessage.hasError()) {
            if (!TextUtils.isEmpty(checkPostResponseMessage.getErrorString())) {
                bfVar5 = this.cyU.cyq;
                bfVar5.showToast(checkPostResponseMessage.getErrorString());
                return;
            }
            bfVar4 = this.cyU.cyq;
            bfVar4.showToast(t.j.neterror);
            return;
        }
        long forumId = checkPostResponseMessage.getForumId();
        long postState = checkPostResponseMessage.getPostState();
        long quoteId = checkPostResponseMessage.getQuoteId();
        long repostId = checkPostResponseMessage.getRepostId();
        if (postState == 1) {
            aVar = this.cyU.cyT;
            aVar.b(forumId, quoteId, repostId);
        } else if (postState == 0) {
            bfVar3 = this.cyU.cyq;
            bfVar3.showToast(t.j.thread_delete_tip);
        } else if (postState == -1) {
            bfVar2 = this.cyU.cyq;
            bfVar2.showToast(t.j.thread_shield_tip);
        }
    }
}
