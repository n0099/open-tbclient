package com.baidu.tieba.tblauncher;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.data.NewsNotifyMessage;
/* loaded from: classes.dex */
class o extends CustomMessageListener {
    final /* synthetic */ MainTabActivity this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public o(MainTabActivity mainTabActivity, int i) {
        super(i);
        this.this$0 = mainTabActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        ae aeVar;
        ae aeVar2;
        if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001124 && (customResponsedMessage instanceof NewsNotifyMessage)) {
            NewsNotifyMessage newsNotifyMessage = (NewsNotifyMessage) customResponsedMessage;
            int a = MainTabActivity.a(newsNotifyMessage);
            if (!com.baidu.tbadk.coreExtra.messageCenter.c.zh().zC()) {
                a -= newsNotifyMessage.getMsgOfficialMerge();
            }
            if (a == 0) {
                aeVar2 = this.this$0.fGw;
                aeVar2.a(true, false, 0);
                return;
            }
            aeVar = this.this$0.fGw;
            aeVar.a(true, true, a);
        }
    }
}
