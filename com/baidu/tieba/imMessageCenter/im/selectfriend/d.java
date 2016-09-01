package com.baidu.tieba.imMessageCenter.im.selectfriend;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.data.ShareFromGameCenterMsgData;
/* loaded from: classes.dex */
class d extends CustomMessageListener {
    private final /* synthetic */ long bSY;
    private final /* synthetic */ String bSZ;
    final /* synthetic */ c dry;
    private final /* synthetic */ String val$name;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(c cVar, int i, long j, String str, String str2) {
        super(i);
        this.dry = cVar;
        this.bSY = j;
        this.val$name = str;
        this.bSZ = str2;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        SelectFriendActivity selectFriendActivity;
        if (customResponsedMessage != null && customResponsedMessage.getData() != null && customResponsedMessage.getCmd() == 2001268) {
            selectFriendActivity = this.dry.drx;
            selectFriendActivity.a((ShareFromGameCenterMsgData) customResponsedMessage.getData(), this.bSY, this.val$name, this.bSZ);
        }
    }
}
