package com.baidu.tieba.imMessageCenter.mention;

import android.text.TextUtils;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.tieba.imMessageCenter.mention.ReplyMeModel;
import com.baidu.tieba.w;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public class ar extends com.baidu.adp.framework.listener.e {
    final /* synthetic */ ReplyMeModel dmT;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ar(ReplyMeModel replyMeModel, int i) {
        super(i);
        this.dmT = replyMeModel;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(SocketResponsedMessage socketResponsedMessage) {
        ReplyMessageActivity replyMessageActivity;
        ReplyMessageActivity replyMessageActivity2;
        ReplyMessageActivity replyMessageActivity3;
        ReplyMeModel.a aVar;
        ReplyMessageActivity replyMessageActivity4;
        ReplyMessageActivity replyMessageActivity5;
        if (socketResponsedMessage == null || !(socketResponsedMessage instanceof CheckPostResponseMessage)) {
            replyMessageActivity = this.dmT.dmR;
            replyMessageActivity.showToast(w.l.neterror);
            return;
        }
        CheckPostResponseMessage checkPostResponseMessage = (CheckPostResponseMessage) socketResponsedMessage;
        if (checkPostResponseMessage.hasError()) {
            if (!TextUtils.isEmpty(checkPostResponseMessage.getErrorString())) {
                replyMessageActivity5 = this.dmT.dmR;
                replyMessageActivity5.showToast(checkPostResponseMessage.getErrorString());
                return;
            }
            replyMessageActivity4 = this.dmT.dmR;
            replyMessageActivity4.showToast(w.l.neterror);
            return;
        }
        long forumId = checkPostResponseMessage.getForumId();
        long postState = checkPostResponseMessage.getPostState();
        long quoteId = checkPostResponseMessage.getQuoteId();
        long repostId = checkPostResponseMessage.getRepostId();
        if (postState == 1) {
            aVar = this.dmT.dmS;
            aVar.b(forumId, quoteId, repostId);
        } else if (postState == 0) {
            replyMessageActivity3 = this.dmT.dmR;
            replyMessageActivity3.showToast(w.l.thread_delete_tip);
        } else if (postState == -1) {
            replyMessageActivity2 = this.dmT.dmR;
            replyMessageActivity2.showToast(w.l.thread_shield_tip);
        }
    }
}
