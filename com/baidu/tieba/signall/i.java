package com.baidu.tieba.signall;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes.dex */
class i extends CustomMessageListener {
    final /* synthetic */ SignAllForumActivity cQx;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public i(SignAllForumActivity signAllForumActivity, int i) {
        super(i);
        this.cQx = signAllForumActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        Integer num;
        z zVar;
        if (customResponsedMessage != null && (num = (Integer) customResponsedMessage.getData()) != null && num.intValue() == 2) {
            zVar = this.cQx.cQp;
            zVar.atV().setHasPrivilege(true);
        }
    }
}
