package com.baidu.tieba.write.video;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tieba.tbadkCore.location.ResponsedSelectLocation;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b extends CustomMessageListener {
    final /* synthetic */ WriteLocationView fAu;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(WriteLocationView writeLocationView, int i) {
        super(i);
        this.fAu = writeLocationView;
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
                dVar2 = this.fAu.avY;
                dVar2.kY(false);
                dVar3 = this.fAu.avY;
                dVar3.ca(responsedSelectLocation.getName(), responsedSelectLocation.getScreatString());
                this.fAu.c(2, true, responsedSelectLocation.getName());
                return;
            }
            dVar = this.fAu.avY;
            dVar.kY(true);
            this.fAu.c(0, true, null);
        }
    }
}
