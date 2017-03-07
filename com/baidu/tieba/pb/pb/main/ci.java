package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes.dex */
class ci extends CustomMessageListener {
    final /* synthetic */ PbActivity elO;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ci(PbActivity pbActivity, int i) {
        super(i);
        this.elO = pbActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        fa faVar;
        fa faVar2;
        fa faVar3;
        faVar = this.elO.ekM;
        if (faVar != null) {
            faVar2 = this.elO.ekM;
            if (faVar2.aMX() != null) {
                faVar3 = this.elO.ekM;
                faVar3.aMX().notifyDataSetChanged();
            }
        }
    }
}
