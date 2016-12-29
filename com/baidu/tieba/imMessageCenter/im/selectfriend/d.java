package com.baidu.tieba.imMessageCenter.im.selectfriend;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.data.ShareFromGameCenterMsgData;
/* loaded from: classes.dex */
class d extends CustomMessageListener {
    private final /* synthetic */ long bDw;
    private final /* synthetic */ String bDx;
    final /* synthetic */ c dbv;
    private final /* synthetic */ String val$name;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(c cVar, int i, long j, String str, String str2) {
        super(i);
        this.dbv = cVar;
        this.bDw = j;
        this.val$name = str;
        this.bDx = str2;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        SelectFriendActivity selectFriendActivity;
        if (customResponsedMessage != null && customResponsedMessage.getData() != null && customResponsedMessage.getCmd() == 2001261) {
            selectFriendActivity = this.dbv.dbu;
            selectFriendActivity.a((ShareFromGameCenterMsgData) customResponsedMessage.getData(), this.bDw, this.val$name, this.bDx);
        }
    }
}
