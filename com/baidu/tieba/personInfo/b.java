package com.baidu.tieba.personInfo;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes.dex */
class b extends CustomMessageListener {
    final /* synthetic */ PersonInfoActivity cue;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(PersonInfoActivity personInfoActivity, int i) {
        super(i);
        this.cue = personInfoActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        if (customResponsedMessage == null || customResponsedMessage.getCmd() != 2001124) {
            return;
        }
        this.cue.d(customResponsedMessage);
    }
}
