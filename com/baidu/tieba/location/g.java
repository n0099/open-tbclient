package com.baidu.tieba.location;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tieba.selectpoi.ResponsedSelectLocation;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g extends CustomMessageListener {
    final /* synthetic */ d bmj;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g(d dVar, int i) {
        super(i);
        this.bmj = dVar;
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
                this.bmj.dx(false);
                this.bmj.gL(responsedSelectLocation.getName());
                jVar3 = this.bmj.bmd;
                if (jVar3 != null) {
                    jVar4 = this.bmj.bmd;
                    jVar4.eZ(responsedSelectLocation.getName());
                    return;
                }
                return;
            }
            this.bmj.dx(true);
            jVar = this.bmj.bmd;
            if (jVar != null) {
                jVar2 = this.bmj.bmd;
                jVar2.EJ();
            }
        }
    }
}
