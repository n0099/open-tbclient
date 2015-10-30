package com.baidu.tieba.tblauncher.a;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i extends CustomMessageListener {
    final /* synthetic */ e ddY;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public i(e eVar, int i) {
        super(i);
        this.ddY = eVar;
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
            dVar = this.ddY.ddS;
            if (dVar != null) {
                dVar2 = this.ddY.ddS;
                if (dVar2.getDayNightView() != null) {
                    dVar3 = this.ddY.ddS;
                    if (dVar3.Mv()) {
                        dVar5 = this.ddY.ddS;
                        dVar5.getDayNightView().setVisibility(0);
                    } else {
                        dVar4 = this.ddY.ddS;
                        dVar4.getDayNightView().setVisibility(8);
                    }
                    this.ddY.ayU();
                }
            }
        }
    }
}
