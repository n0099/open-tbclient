package com.baidu.tieba.tbadkCore.location;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class h extends CustomMessageListener {
    final /* synthetic */ e ctN;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h(e eVar, int i) {
        super(i);
        this.ctN = eVar;
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
                this.ctN.fi(false);
                this.ctN.bc(responsedSelectLocation.getName(), responsedSelectLocation.getScreatString());
                kVar3 = this.ctN.ctH;
                if (kVar3 != null) {
                    kVar4 = this.ctN.ctH;
                    kVar4.gi(responsedSelectLocation.getName());
                    return;
                }
                return;
            }
            this.ctN.fi(true);
            kVar = this.ctN.ctH;
            if (kVar != null) {
                kVar2 = this.ctN.ctH;
                kVar2.JY();
            }
        }
    }
}
