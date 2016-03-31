package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes.dex */
class am extends CustomMessageListener {
    final /* synthetic */ PbActivity dht;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public am(PbActivity pbActivity, int i) {
        super(i);
        this.dht = pbActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        df dfVar;
        com.baidu.tbadk.editortools.d.e eVar;
        eu euVar;
        com.baidu.tbadk.editortools.d.e eVar2;
        eu euVar2;
        eu euVar3;
        com.baidu.tbadk.editortools.d.e eVar3;
        dfVar = this.dht.dfV;
        if (dfVar != null && customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Boolean) && !((Boolean) customResponsedMessage.getData()).booleanValue()) {
            eVar = this.dht.dgP;
            if (eVar != null) {
                euVar3 = this.dht.dgF;
                eVar3 = this.dht.dgP;
                euVar3.eL(eVar3.DT());
            }
            euVar = this.dht.dgF;
            euVar.ayk();
            eVar2 = this.dht.dgP;
            eVar2.DW();
            euVar2 = this.dht.dgF;
            euVar2.amI();
        }
    }
}
