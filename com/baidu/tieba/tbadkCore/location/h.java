package com.baidu.tieba.tbadkCore.location;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class h extends CustomMessageListener {
    final /* synthetic */ e cpv;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h(e eVar, int i) {
        super(i);
        this.cpv = eVar;
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
                this.cpv.eR(false);
                this.cpv.aX(responsedSelectLocation.getName(), responsedSelectLocation.getScreatString());
                kVar3 = this.cpv.cpp;
                if (kVar3 != null) {
                    kVar4 = this.cpv.cpp;
                    kVar4.fF(responsedSelectLocation.getName());
                    return;
                }
                return;
            }
            this.cpv.eR(true);
            kVar = this.cpv.cpp;
            if (kVar != null) {
                kVar2 = this.cpv.cpp;
                kVar2.IR();
            }
        }
    }
}
