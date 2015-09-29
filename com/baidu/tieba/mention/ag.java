package com.baidu.tieba.mention;

import android.text.TextUtils;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.tieba.i;
import com.baidu.tieba.mention.af;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ag extends com.baidu.adp.framework.listener.e {
    final /* synthetic */ af caC;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ag(af afVar, int i) {
        super(i);
        this.caC = afVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(SocketResponsedMessage socketResponsedMessage) {
        SingleMentionActivity singleMentionActivity;
        SingleMentionActivity singleMentionActivity2;
        SingleMentionActivity singleMentionActivity3;
        af.a aVar;
        SingleMentionActivity singleMentionActivity4;
        SingleMentionActivity singleMentionActivity5;
        if (socketResponsedMessage == null || !(socketResponsedMessage instanceof CheckPostResponseMessage)) {
            singleMentionActivity = this.caC.caA;
            singleMentionActivity.showToast(i.h.neterror);
            return;
        }
        CheckPostResponseMessage checkPostResponseMessage = (CheckPostResponseMessage) socketResponsedMessage;
        if (checkPostResponseMessage.hasError()) {
            if (!TextUtils.isEmpty(checkPostResponseMessage.getErrorString())) {
                singleMentionActivity5 = this.caC.caA;
                singleMentionActivity5.showToast(checkPostResponseMessage.getErrorString());
                return;
            }
            singleMentionActivity4 = this.caC.caA;
            singleMentionActivity4.showToast(i.h.neterror);
            return;
        }
        long forumId = checkPostResponseMessage.getForumId();
        long postState = checkPostResponseMessage.getPostState();
        long quoteId = checkPostResponseMessage.getQuoteId();
        long repostId = checkPostResponseMessage.getRepostId();
        if (postState == 1) {
            aVar = this.caC.caB;
            aVar.d(forumId, quoteId, repostId);
        } else if (postState == 0) {
            singleMentionActivity3 = this.caC.caA;
            singleMentionActivity3.showToast(i.h.thread_delete_tip);
        } else if (postState == -1) {
            singleMentionActivity2 = this.caC.caA;
            singleMentionActivity2.showToast(i.h.thread_shield_tip);
        }
    }
}
