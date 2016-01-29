package com.baidu.tieba.write.write;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tieba.tbadkCore.location.ResponsedSelectLocation;
/* loaded from: classes.dex */
class be extends CustomMessageListener {
    final /* synthetic */ WriteActivity ets;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public be(WriteActivity writeActivity, int i) {
        super(i);
        this.ets = writeActivity;
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
                dVar2 = this.ets.auU;
                dVar2.hW(false);
                dVar3 = this.ets.auU;
                dVar3.bp(responsedSelectLocation.getName(), responsedSelectLocation.getScreatString());
                this.ets.a(2, true, responsedSelectLocation.getName());
                return;
            }
            dVar = this.ets.auU;
            dVar.hW(true);
            this.ets.a(0, true, (String) null);
        }
    }
}
