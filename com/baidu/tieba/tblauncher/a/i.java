package com.baidu.tieba.tblauncher.a;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i extends CustomMessageListener {
    final /* synthetic */ e ddy;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public i(e eVar, int i) {
        super(i);
        this.ddy = eVar;
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
            dVar = this.ddy.dds;
            if (dVar != null) {
                dVar2 = this.ddy.dds;
                if (dVar2.getDayNightView() != null) {
                    dVar3 = this.ddy.dds;
                    if (dVar3.Mz()) {
                        dVar5 = this.ddy.dds;
                        dVar5.getDayNightView().setVisibility(0);
                    } else {
                        dVar4 = this.ddy.dds;
                        dVar4.getDayNightView().setVisibility(8);
                    }
                    this.ddy.ayO();
                }
            }
        }
    }
}
