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
        bp bpVar;
        bs bsVar;
        bp bpVar2;
        bs bsVar2;
        bp bpVar3;
        bp bpVar4;
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
                    bpVar3 = this.this$0.eht;
                    bpVar3.aMy().getReplyInfo().add(replyInfo);
                    bpVar4 = this.this$0.eht;
                    bpVar4.aMD();
                }
            } else if (responseNewFriendUpdateUiMsg.getAction() == 0) {
                bpVar = this.this$0.eht;
                if (bpVar.aMy() != null) {
                    bsVar = this.this$0.eoE;
                    if (bsVar != null) {
                        bpVar2 = this.this$0.eht;
                        bpVar2.aMy().setIsFriend(1);
                        bsVar2 = this.this$0.eoE;
                        bsVar2.aNg();
                    }
                }
            }
        }
    }
}
