package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes.dex */
class j extends CustomMessageListener {
    final /* synthetic */ PbActivity enc;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public j(PbActivity pbActivity, int i) {
        super(i);
        this.enc = pbActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        fx fxVar;
        fx fxVar2;
        fx fxVar3;
        fxVar = this.enc.elU;
        if (fxVar != null) {
            fxVar2 = this.enc.elU;
            if (fxVar2.aMu() != null) {
                fxVar3 = this.enc.elU;
                fxVar3.aMu().notifyDataSetChanged();
            }
        }
    }
}
