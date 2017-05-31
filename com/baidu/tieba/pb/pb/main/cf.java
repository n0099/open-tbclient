package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes.dex */
class cf extends CustomMessageListener {
    final /* synthetic */ PbActivity enc;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public cf(PbActivity pbActivity, int i) {
        super(i);
        this.enc = pbActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        com.baidu.tbadk.editortools.pb.c cVar;
        fx fxVar;
        fx fxVar2;
        com.baidu.tbadk.editortools.pb.c cVar2;
        if (customResponsedMessage != null) {
            cVar = this.enc.emh;
            if (cVar != null) {
                fxVar2 = this.enc.elU;
                cVar2 = this.enc.emh;
                fxVar2.gz(cVar2.CS());
            }
            fxVar = this.enc.elU;
            fxVar.gA(false);
        }
    }
}
