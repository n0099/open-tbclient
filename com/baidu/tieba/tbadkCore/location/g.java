package com.baidu.tieba.tbadkCore.location;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g extends CustomMessageListener {
    final /* synthetic */ d bYA;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g(d dVar, int i) {
        super(i);
        this.bYA = dVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        j jVar;
        j jVar2;
        j jVar3;
        j jVar4;
        if (customResponsedMessage instanceof ResponsedSelectLocation) {
            ResponsedSelectLocation responsedSelectLocation = (ResponsedSelectLocation) customResponsedMessage;
            if (responsedSelectLocation.isShowLocation()) {
                this.bYA.ex(false);
                this.bYA.aP(responsedSelectLocation.getName(), responsedSelectLocation.getScreatString());
                jVar3 = this.bYA.bYu;
                if (jVar3 != null) {
                    jVar4 = this.bYA.bYu;
                    jVar4.fu(responsedSelectLocation.getName());
                    return;
                }
                return;
            }
            this.bYA.ex(true);
            jVar = this.bYA.bYu;
            if (jVar != null) {
                jVar2 = this.bYA.bYu;
                jVar2.Fa();
            }
        }
    }
}
