package com.baidu.tieba.tbadkCore.location;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class h extends CustomMessageListener {
    final /* synthetic */ e ctM;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h(e eVar, int i) {
        super(i);
        this.ctM = eVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        k kVar;
        k kVar2;
        k kVar3;
        k kVar4;
        if (customResponsedMessage instanceof ResponsedSelectLocation) {
            ResponsedSelectLocation responsedSelectLocation = (ResponsedSelectLocation) customResponsedMessage;
            if (responsedSelectLocation.isShowLocation()) {
                this.ctM.fi(false);
                this.ctM.bc(responsedSelectLocation.getName(), responsedSelectLocation.getScreatString());
                kVar3 = this.ctM.ctG;
                if (kVar3 != null) {
                    kVar4 = this.ctM.ctG;
                    kVar4.gi(responsedSelectLocation.getName());
                    return;
                }
                return;
            }
            this.ctM.fi(true);
            kVar = this.ctM.ctG;
            if (kVar != null) {
                kVar2 = this.ctM.ctG;
                kVar2.JX();
            }
        }
    }
}
