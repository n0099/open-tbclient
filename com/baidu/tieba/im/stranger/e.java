package com.baidu.tieba.im.stranger;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.newFriends.ResponseNewFriendUpdateUiMsg;
/* loaded from: classes.dex */
class e extends CustomMessageListener {
    /* JADX INFO: Access modifiers changed from: package-private */
    public e(int i) {
        super(i);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    /* renamed from: a */
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001178 && (customResponsedMessage instanceof ResponseNewFriendUpdateUiMsg)) {
            ResponseNewFriendUpdateUiMsg responseNewFriendUpdateUiMsg = (ResponseNewFriendUpdateUiMsg) customResponsedMessage;
            long friendId = responseNewFriendUpdateUiMsg.getFriendId();
            int action = responseNewFriendUpdateUiMsg.getAction();
            if (action == 0) {
                a.a(new StringBuilder(String.valueOf(friendId)).toString(), 1);
            } else if (action == 1) {
                a.a(new StringBuilder(String.valueOf(friendId)).toString());
            }
        }
    }
}
