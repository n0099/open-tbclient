package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes.dex */
class ap extends CustomMessageListener {
    final /* synthetic */ PbActivity evL;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ap(PbActivity pbActivity, int i) {
        super(i);
        this.evL = pbActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        dj djVar;
        com.baidu.tbadk.editortools.e.e eVar;
        ey eyVar;
        com.baidu.tbadk.editortools.e.e eVar2;
        ey eyVar2;
        ey eyVar3;
        com.baidu.tbadk.editortools.e.e eVar3;
        djVar = this.evL.euf;
        if (djVar != null && customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Boolean) && !((Boolean) customResponsedMessage.getData()).booleanValue()) {
            eVar = this.evL.evb;
            if (eVar != null) {
                eyVar3 = this.evL.euP;
                eVar3 = this.evL.evb;
                eyVar3.gX(eVar3.Dz());
            }
            eyVar = this.evL.euP;
            eyVar.aRJ();
            eVar2 = this.evL.evb;
            eVar2.DC();
            eyVar2 = this.evL.euP;
            eyVar2.aCY();
        }
    }
}
