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
        bf bfVar;
        bi biVar;
        bf bfVar2;
        bi biVar2;
        bf bfVar3;
        bf bfVar4;
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
                    bfVar3 = this.this$0.dvN;
                    bfVar3.aDf().getReplyInfo().add(replyInfo);
                    bfVar4 = this.this$0.dvN;
                    bfVar4.aDk();
                }
            } else if (responseNewFriendUpdateUiMsg.getAction() == 0) {
                bfVar = this.this$0.dvN;
                if (bfVar.aDf() != null) {
                    biVar = this.this$0.dCt;
                    if (biVar != null) {
                        bfVar2 = this.this$0.dvN;
                        bfVar2.aDf().setIsFriend(1);
                        biVar2 = this.this$0.dCt;
                        biVar2.aDM();
                    }
                }
            }
        }
    }
}
