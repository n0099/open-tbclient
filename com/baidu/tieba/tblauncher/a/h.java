package com.baidu.tieba.tblauncher.a;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class h extends CustomMessageListener {
    final /* synthetic */ d cVQ;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h(d dVar, int i) {
        super(i);
        this.cVQ = dVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        c cVar;
        c cVar2;
        c cVar3;
        c cVar4;
        c cVar5;
        if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001361) {
            cVar = this.cVQ.cVK;
            if (cVar != null) {
                cVar2 = this.cVQ.cVK;
                if (cVar2.getDayNightView() != null) {
                    cVar3 = this.cVQ.cVK;
                    if (cVar3.MA()) {
                        cVar5 = this.cVQ.cVK;
                        cVar5.getDayNightView().setVisibility(0);
                    } else {
                        cVar4 = this.cVQ.cVK;
                        cVar4.getDayNightView().setVisibility(8);
                    }
                    this.cVQ.aww();
                }
            }
        }
    }
}
