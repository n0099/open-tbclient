package com.baidu.tieba.write.video;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tieba.tbadkCore.location.ResponsedSelectLocation;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b extends CustomMessageListener {
    final /* synthetic */ WriteLocationView fax;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(WriteLocationView writeLocationView, int i) {
        super(i);
        this.fax = writeLocationView;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        com.baidu.tieba.tbadkCore.location.d dVar;
        com.baidu.tieba.tbadkCore.location.d dVar2;
        com.baidu.tieba.tbadkCore.location.d dVar3;
        if (customResponsedMessage instanceof ResponsedSelectLocation) {
            ResponsedSelectLocation responsedSelectLocation = (ResponsedSelectLocation) customResponsedMessage;
            if (responsedSelectLocation.isShowLocation()) {
                dVar2 = this.fax.art;
                dVar2.jA(false);
                dVar3 = this.fax.art;
                dVar3.bM(responsedSelectLocation.getName(), responsedSelectLocation.getScreatString());
                this.fax.b(2, true, responsedSelectLocation.getName());
                return;
            }
            dVar = this.fax.art;
            dVar.jA(true);
            this.fax.b(0, true, null);
        }
    }
}
