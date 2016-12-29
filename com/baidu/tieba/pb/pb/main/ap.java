package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes.dex */
class ap extends CustomMessageListener {
    final /* synthetic */ PbActivity eah;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ap(PbActivity pbActivity, int i) {
        super(i);
        this.eah = pbActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        dc dcVar;
        com.baidu.tbadk.editortools.e.e eVar;
        er erVar;
        com.baidu.tbadk.editortools.e.e eVar2;
        er erVar2;
        er erVar3;
        com.baidu.tbadk.editortools.e.e eVar3;
        dcVar = this.eah.dYA;
        if (dcVar != null && customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Boolean) && !((Boolean) customResponsedMessage.getData()).booleanValue()) {
            eVar = this.eah.dZw;
            if (eVar != null) {
                erVar3 = this.eah.dZk;
                eVar3 = this.eah.dZw;
                erVar3.gH(eVar3.Di());
            }
            erVar = this.eah.dZk;
            erVar.aLD();
            eVar2 = this.eah.dZw;
            eVar2.Dl();
            erVar2 = this.eah.dZk;
            erVar2.awl();
        }
    }
}
