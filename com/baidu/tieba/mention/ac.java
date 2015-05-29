package com.baidu.tieba.mention;

import android.text.TextUtils;
import com.baidu.adp.framework.message.SocketResponsedMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ac extends com.baidu.adp.framework.listener.e {
    final /* synthetic */ ab bGq;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ac(ab abVar, int i) {
        super(i);
        this.bGq = abVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(SocketResponsedMessage socketResponsedMessage) {
        SingleMentionActivity singleMentionActivity;
        SingleMentionActivity singleMentionActivity2;
        SingleMentionActivity singleMentionActivity3;
        ad adVar;
        SingleMentionActivity singleMentionActivity4;
        SingleMentionActivity singleMentionActivity5;
        if (socketResponsedMessage == null || !(socketResponsedMessage instanceof CheckPostResponseMessage)) {
            singleMentionActivity = this.bGq.bGo;
            singleMentionActivity.showToast(com.baidu.tieba.t.neterror);
            return;
        }
        CheckPostResponseMessage checkPostResponseMessage = (CheckPostResponseMessage) socketResponsedMessage;
        if (checkPostResponseMessage.hasError()) {
            if (!TextUtils.isEmpty(checkPostResponseMessage.getErrorString())) {
                singleMentionActivity5 = this.bGq.bGo;
                singleMentionActivity5.showToast(checkPostResponseMessage.getErrorString());
                return;
            }
            singleMentionActivity4 = this.bGq.bGo;
            singleMentionActivity4.showToast(com.baidu.tieba.t.neterror);
            return;
        }
        long forumId = checkPostResponseMessage.getForumId();
        long postState = checkPostResponseMessage.getPostState();
        long quoteId = checkPostResponseMessage.getQuoteId();
        long repostId = checkPostResponseMessage.getRepostId();
        if (postState == 1) {
            adVar = this.bGq.bGp;
            adVar.a(forumId, quoteId, repostId);
        } else if (postState == 0) {
            singleMentionActivity3 = this.bGq.bGo;
            singleMentionActivity3.showToast(com.baidu.tieba.t.thread_delete_tip);
        } else if (postState == -1) {
            singleMentionActivity2 = this.bGq.bGo;
            singleMentionActivity2.showToast(com.baidu.tieba.t.thread_shield_tip);
        }
    }
}
