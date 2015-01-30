package com.baidu.tieba.personInfo;

import android.text.TextUtils;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.newFriends.ResponseNewFriendUpdateUiMsg;
/* loaded from: classes.dex */
class k extends CustomMessageListener {
    final /* synthetic */ PersonInfoActivity bJY;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public k(PersonInfoActivity personInfoActivity, int i) {
        super(i);
        this.bJY = personInfoActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        v vVar;
        v vVar2;
        ae aeVar;
        v vVar3;
        v vVar4;
        if (customResponsedMessage instanceof ResponseNewFriendUpdateUiMsg) {
            ResponseNewFriendUpdateUiMsg responseNewFriendUpdateUiMsg = (ResponseNewFriendUpdateUiMsg) customResponsedMessage;
            if (responseNewFriendUpdateUiMsg.getAction() == -1) {
                String content = responseNewFriendUpdateUiMsg.getContent();
                if (!TextUtils.isEmpty(content)) {
                    long friendId = responseNewFriendUpdateUiMsg.getFriendId();
                    long a = com.baidu.adp.lib.g.c.a(TbadkCoreApplication.getCurrentAccount(), 0L);
                    ReplyInfo replyInfo = new ReplyInfo();
                    replyInfo.setUserId(a);
                    replyInfo.setFriendId(friendId);
                    replyInfo.setMessage(content);
                    vVar3 = this.bJY.bJN;
                    vVar3.abV().getReplyInfo().add(replyInfo);
                    vVar4 = this.bJY.bJN;
                    vVar4.acc();
                }
            } else if (responseNewFriendUpdateUiMsg.getAction() == 0) {
                vVar = this.bJY.bJN;
                if (vVar.abV() != null) {
                    vVar2 = this.bJY.bJN;
                    vVar2.abV().setIsFriend(1);
                    aeVar = this.bJY.bJO;
                    aeVar.ach();
                }
            }
        }
    }
}
