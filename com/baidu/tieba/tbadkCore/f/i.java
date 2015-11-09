package com.baidu.tieba.tbadkCore.f;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i extends CustomMessageListener {
    final /* synthetic */ e dcL;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public i(e eVar, int i) {
        super(i);
        this.dcL = eVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        d dVar;
        d dVar2;
        d dVar3;
        d dVar4;
        d dVar5;
        if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001361) {
            dVar = this.dcL.dcF;
            if (dVar != null) {
                dVar2 = this.dcL.dcF;
                if (dVar2.getDayNightView() != null) {
                    dVar3 = this.dcL.dcF;
                    if (dVar3.ML()) {
                        dVar5 = this.dcL.dcF;
                        dVar5.getDayNightView().setVisibility(0);
                    } else {
                        dVar4 = this.dcL.dcF;
                        dVar4.getDayNightView().setVisibility(8);
                    }
                    this.dcL.ayd();
                }
            }
        }
    }
}
