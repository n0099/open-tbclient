package com.baidu.tieba.personInfo;

import android.text.TextUtils;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.newFriends.ResponseNewFriendUpdateUiMsg;
/* loaded from: classes.dex */
class n extends CustomMessageListener {
    final /* synthetic */ PersonInfoActivity cmR;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public n(PersonInfoActivity personInfoActivity, int i) {
        super(i);
        this.cmR = personInfoActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        w wVar;
        w wVar2;
        ag agVar;
        w wVar3;
        w wVar4;
        if (customResponsedMessage instanceof ResponseNewFriendUpdateUiMsg) {
            ResponseNewFriendUpdateUiMsg responseNewFriendUpdateUiMsg = (ResponseNewFriendUpdateUiMsg) customResponsedMessage;
            if (responseNewFriendUpdateUiMsg.getAction() == -1) {
                String content = responseNewFriendUpdateUiMsg.getContent();
                if (!TextUtils.isEmpty(content)) {
                    long friendId = responseNewFriendUpdateUiMsg.getFriendId();
                    long c = com.baidu.adp.lib.g.b.c(TbadkCoreApplication.getCurrentAccount(), 0L);
                    ReplyInfo replyInfo = new ReplyInfo();
                    replyInfo.setUserId(c);
                    replyInfo.setFriendId(friendId);
                    replyInfo.setMessage(content);
                    wVar3 = this.cmR.cmF;
                    wVar3.ahM().getReplyInfo().add(replyInfo);
                    wVar4 = this.cmR.cmF;
                    wVar4.ahT();
                }
            } else if (responseNewFriendUpdateUiMsg.getAction() == 0) {
                wVar = this.cmR.cmF;
                if (wVar.ahM() != null) {
                    wVar2 = this.cmR.cmF;
                    wVar2.ahM().setIsFriend(1);
                    agVar = this.cmR.cmG;
                    agVar.ahZ();
                }
            }
        }
    }
}
