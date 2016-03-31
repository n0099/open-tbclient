package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes.dex */
class bi extends CustomMessageListener {
    final /* synthetic */ PbActivity dht;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public bi(PbActivity pbActivity, int i) {
        super(i);
        this.dht = pbActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        com.baidu.tbadk.editortools.d.e eVar;
        eu euVar;
        eu euVar2;
        com.baidu.tbadk.editortools.d.e eVar2;
        if (customResponsedMessage != null) {
            eVar = this.dht.dgP;
            if (eVar != null) {
                euVar2 = this.dht.dgF;
                eVar2 = this.dht.dgP;
                euVar2.eL(eVar2.DT());
            }
            euVar = this.dht.dgF;
            euVar.eM(false);
        }
    }
}
