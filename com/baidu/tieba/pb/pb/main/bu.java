package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes.dex */
class bu extends CustomMessageListener {
    final /* synthetic */ PbActivity eah;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public bu(PbActivity pbActivity, int i) {
        super(i);
        this.eah = pbActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        com.baidu.tbadk.editortools.e.e eVar;
        er erVar;
        er erVar2;
        com.baidu.tbadk.editortools.e.e eVar2;
        if (customResponsedMessage != null) {
            eVar = this.eah.dZw;
            if (eVar != null) {
                erVar2 = this.eah.dZk;
                eVar2 = this.eah.dZw;
                erVar2.gH(eVar2.Di());
            }
            erVar = this.eah.dZk;
            erVar.gI(false);
        }
    }
}
