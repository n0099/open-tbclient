package com.baidu.tieba.mention;

import android.text.TextUtils;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.tieba.i;
import com.baidu.tieba.mention.ae;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class af extends com.baidu.adp.framework.listener.e {
    final /* synthetic */ ae bWi;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public af(ae aeVar, int i) {
        super(i);
        this.bWi = aeVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(SocketResponsedMessage socketResponsedMessage) {
        SingleMentionActivity singleMentionActivity;
        SingleMentionActivity singleMentionActivity2;
        SingleMentionActivity singleMentionActivity3;
        ae.a aVar;
        SingleMentionActivity singleMentionActivity4;
        SingleMentionActivity singleMentionActivity5;
        if (socketResponsedMessage == null || !(socketResponsedMessage instanceof CheckPostResponseMessage)) {
            singleMentionActivity = this.bWi.bWg;
            singleMentionActivity.showToast(i.C0057i.neterror);
            return;
        }
        CheckPostResponseMessage checkPostResponseMessage = (CheckPostResponseMessage) socketResponsedMessage;
        if (checkPostResponseMessage.hasError()) {
            if (!TextUtils.isEmpty(checkPostResponseMessage.getErrorString())) {
                singleMentionActivity5 = this.bWi.bWg;
                singleMentionActivity5.showToast(checkPostResponseMessage.getErrorString());
                return;
            }
            singleMentionActivity4 = this.bWi.bWg;
            singleMentionActivity4.showToast(i.C0057i.neterror);
            return;
        }
        long forumId = checkPostResponseMessage.getForumId();
        long postState = checkPostResponseMessage.getPostState();
        long quoteId = checkPostResponseMessage.getQuoteId();
        long repostId = checkPostResponseMessage.getRepostId();
        if (postState == 1) {
            aVar = this.bWi.bWh;
            aVar.d(forumId, quoteId, repostId);
        } else if (postState == 0) {
            singleMentionActivity3 = this.bWi.bWg;
            singleMentionActivity3.showToast(i.C0057i.thread_delete_tip);
        } else if (postState == -1) {
            singleMentionActivity2 = this.bWi.bWg;
            singleMentionActivity2.showToast(i.C0057i.thread_shield_tip);
        }
    }
}
