package com.baidu.tieba.tbadkCore.location;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tieba.tbadkCore.location.d;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g extends CustomMessageListener {
    final /* synthetic */ d dYU;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g(d dVar, int i) {
        super(i);
        this.dYU = dVar;
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
                this.dYU.hW(false);
                this.dYU.bp(responsedSelectLocation.getName(), responsedSelectLocation.getScreatString());
                bVar3 = this.dYU.dYO;
                if (bVar3 != null) {
                    bVar4 = this.dYU.dYO;
                    bVar4.fv(responsedSelectLocation.getName());
                    return;
                }
                return;
            }
            this.dYU.hW(true);
            bVar = this.dYU.dYO;
            if (bVar != null) {
                bVar2 = this.dYU.dYO;
                bVar2.DB();
            }
        }
    }
}
