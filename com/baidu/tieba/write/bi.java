package com.baidu.tieba.write;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tieba.selectpoi.ResponsedSelectLocation;
/* loaded from: classes.dex */
class bi extends CustomMessageListener {
    final /* synthetic */ WriteActivity bUm;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public bi(WriteActivity writeActivity, int i) {
        super(i);
        this.bUm = writeActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        com.baidu.tieba.location.d dVar;
        com.baidu.tieba.editortool.j jVar;
        com.baidu.tieba.location.d dVar2;
        com.baidu.tieba.location.d dVar3;
        com.baidu.tieba.editortool.j jVar2;
        if (customResponsedMessage instanceof ResponsedSelectLocation) {
            ResponsedSelectLocation responsedSelectLocation = (ResponsedSelectLocation) customResponsedMessage;
            if (responsedSelectLocation.isShowLocation()) {
                dVar2 = this.bUm.ayB;
                dVar2.dx(false);
                dVar3 = this.bUm.ayB;
                dVar3.gL(responsedSelectLocation.getName());
                jVar2 = this.bUm.bTT;
                jVar2.j(2, responsedSelectLocation.getName());
                return;
            }
            dVar = this.bUm.ayB;
            dVar.dx(true);
            jVar = this.bUm.bTT;
            jVar.setLocationInfoViewState(0);
        }
    }
}
