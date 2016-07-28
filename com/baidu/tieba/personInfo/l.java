package com.baidu.tieba.personInfo;

import android.text.TextUtils;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.newFriends.ResponseNewFriendUpdateUiMsg;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class l extends CustomMessageListener {
    final /* synthetic */ h this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public l(h hVar, int i) {
        super(i);
        this.this$0 = hVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        bn bnVar;
        bq bqVar;
        bn bnVar2;
        bq bqVar2;
        bn bnVar3;
        bn bnVar4;
        if (customResponsedMessage instanceof ResponseNewFriendUpdateUiMsg) {
            ResponseNewFriendUpdateUiMsg responseNewFriendUpdateUiMsg = (ResponseNewFriendUpdateUiMsg) customResponsedMessage;
            if (responseNewFriendUpdateUiMsg.getAction() == -1) {
                String content = responseNewFriendUpdateUiMsg.getContent();
                if (!TextUtils.isEmpty(content)) {
                    long friendId = responseNewFriendUpdateUiMsg.getFriendId();
                    long c = com.baidu.adp.lib.h.b.c(TbadkCoreApplication.getCurrentAccount(), 0L);
                    ReplyInfo replyInfo = new ReplyInfo();
                    replyInfo.setUserId(c);
                    replyInfo.setFriendId(friendId);
                    replyInfo.setMessage(content);
                    bnVar3 = this.this$0.ers;
                    bnVar3.aPD().getReplyInfo().add(replyInfo);
                    bnVar4 = this.this$0.ers;
                    bnVar4.aPI();
                }
            } else if (responseNewFriendUpdateUiMsg.getAction() == 0) {
                bnVar = this.this$0.ers;
                if (bnVar.aPD() != null) {
                    bqVar = this.this$0.eAu;
                    if (bqVar != null) {
                        bnVar2 = this.this$0.ers;
                        bnVar2.aPD().setIsFriend(1);
                        bqVar2 = this.this$0.eAu;
                        bqVar2.aQj();
                    }
                }
            }
        }
    }
}
