package com.baidu.tieba.imMessageCenter.im.selectfriend;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.data.ShareFromGameCenterMsgData;
/* loaded from: classes2.dex */
class d extends CustomMessageListener {
    private final /* synthetic */ long cam;
    private final /* synthetic */ String can;
    final /* synthetic */ c dfU;
    private final /* synthetic */ String val$name;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(c cVar, int i, long j, String str, String str2) {
        super(i);
        this.dfU = cVar;
        this.cam = j;
        this.val$name = str;
        this.can = str2;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        SelectFriendActivity selectFriendActivity;
        if (customResponsedMessage != null && customResponsedMessage.getData() != null && customResponsedMessage.getCmd() == 2001261) {
            selectFriendActivity = this.dfU.dfT;
            selectFriendActivity.a((ShareFromGameCenterMsgData) customResponsedMessage.getData(), this.cam, this.val$name, this.can);
        }
    }
}
