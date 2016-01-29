package com.baidu.tieba.screenlocknotify;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i extends CustomMessageListener {
    final /* synthetic */ f dHz;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public i(f fVar, int i) {
        super(i);
        this.dHz = fVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        if (customResponsedMessage != null) {
            if (customResponsedMessage.getCmd() == 2013006 || customResponsedMessage.getCmd() == 2013002 || customResponsedMessage.getCmd() == 2013004) {
                this.dHz.processServerMsg(customResponsedMessage);
            }
        }
    }
}
