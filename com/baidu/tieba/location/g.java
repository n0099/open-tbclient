package com.baidu.tieba.location;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tieba.selectpoi.ResponsedSelectLocation;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g extends CustomMessageListener {
    final /* synthetic */ d blV;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g(d dVar, int i) {
        super(i);
        this.blV = dVar;
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
                this.blV.dx(false);
                this.blV.gL(responsedSelectLocation.getName());
                jVar3 = this.blV.blP;
                if (jVar3 != null) {
                    jVar4 = this.blV.blP;
                    jVar4.eZ(responsedSelectLocation.getName());
                    return;
                }
                return;
            }
            this.blV.dx(true);
            jVar = this.blV.blP;
            if (jVar != null) {
                jVar2 = this.blV.blP;
                jVar2.EH();
            }
        }
    }
}
