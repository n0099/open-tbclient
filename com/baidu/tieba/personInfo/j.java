package com.baidu.tieba.personInfo;

import android.text.TextUtils;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.newFriends.ResponseNewFriendUpdateUiMsg;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class j extends CustomMessageListener {
    final /* synthetic */ f this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public j(f fVar, int i) {
        super(i);
        this.this$0 = fVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        bg bgVar;
        bj bjVar;
        bg bgVar2;
        bj bjVar2;
        bg bgVar3;
        bg bgVar4;
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
                    bgVar3 = this.this$0.dyP;
                    bgVar3.aDD().getReplyInfo().add(replyInfo);
                    bgVar4 = this.this$0.dyP;
                    bgVar4.aDI();
                }
            } else if (responseNewFriendUpdateUiMsg.getAction() == 0) {
                bgVar = this.this$0.dyP;
                if (bgVar.aDD() != null) {
                    bjVar = this.this$0.dFA;
                    if (bjVar != null) {
                        bgVar2 = this.this$0.dyP;
                        bgVar2.aDD().setIsFriend(1);
                        bjVar2 = this.this$0.dFA;
                        bjVar2.aEm();
                    }
                }
            }
        }
    }
}
