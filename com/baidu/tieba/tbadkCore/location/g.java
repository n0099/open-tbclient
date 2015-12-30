package com.baidu.tieba.tbadkCore.location;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tieba.tbadkCore.location.d;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g extends CustomMessageListener {
    final /* synthetic */ d dIU;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g(d dVar, int i) {
        super(i);
        this.dIU = dVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        d.b bVar;
        d.b bVar2;
        d.b bVar3;
        d.b bVar4;
        if (customResponsedMessage instanceof ResponsedSelectLocation) {
            ResponsedSelectLocation responsedSelectLocation = (ResponsedSelectLocation) customResponsedMessage;
            if (responsedSelectLocation.isShowLocation()) {
                this.dIU.hv(false);
                this.dIU.be(responsedSelectLocation.getName(), responsedSelectLocation.getScreatString());
                bVar3 = this.dIU.dIO;
                if (bVar3 != null) {
                    bVar4 = this.dIU.dIO;
                    bVar4.fx(responsedSelectLocation.getName());
                    return;
                }
                return;
            }
            this.dIU.hv(true);
            bVar = this.dIU.dIO;
            if (bVar != null) {
                bVar2 = this.dIU.dIO;
                bVar2.Cl();
            }
        }
    }
}
