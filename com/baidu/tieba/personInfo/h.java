package com.baidu.tieba.personInfo;

import android.text.TextUtils;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.newFriends.ResponseNewFriendUpdateUiMsg;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class h extends CustomMessageListener {
    final /* synthetic */ d cWV;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h(d dVar, int i) {
        super(i);
        this.cWV = dVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        bb bbVar;
        be beVar;
        bb bbVar2;
        be beVar2;
        bb bbVar3;
        bb bbVar4;
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
                    bbVar3 = this.cWV.cRx;
                    bbVar3.aqp().getReplyInfo().add(replyInfo);
                    bbVar4 = this.cWV.cRx;
                    bbVar4.aqu();
                }
            } else if (responseNewFriendUpdateUiMsg.getAction() == 0) {
                bbVar = this.cWV.cRx;
                if (bbVar.aqp() != null) {
                    beVar = this.cWV.cWi;
                    if (beVar != null) {
                        bbVar2 = this.cWV.cRx;
                        bbVar2.aqp().setIsFriend(1);
                        beVar2 = this.cWV.cWi;
                        beVar2.aqQ();
                    }
                }
            }
        }
    }
}
