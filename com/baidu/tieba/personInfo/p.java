package com.baidu.tieba.personInfo;

import android.text.TextUtils;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.newFriends.ResponseNewFriendUpdateUiMsg;
/* loaded from: classes.dex */
class p extends CustomMessageListener {
    final /* synthetic */ PersonInfoActivity cue;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public p(PersonInfoActivity personInfoActivity, int i) {
        super(i);
        this.cue = personInfoActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        y yVar;
        y yVar2;
        aj ajVar;
        y yVar3;
        y yVar4;
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
                    yVar3 = this.cue.ctR;
                    yVar3.akp().getReplyInfo().add(replyInfo);
                    yVar4 = this.cue.ctR;
                    yVar4.akw();
                }
            } else if (responseNewFriendUpdateUiMsg.getAction() == 0) {
                yVar = this.cue.ctR;
                if (yVar.akp() != null) {
                    yVar2 = this.cue.ctR;
                    yVar2.akp().setIsFriend(1);
                    ajVar = this.cue.ctS;
                    ajVar.akC();
                }
            }
        }
    }
}
