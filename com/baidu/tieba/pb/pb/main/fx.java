package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class fx extends CustomMessageListener {
    final /* synthetic */ fm epr;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public fx(fm fmVar, int i) {
        super(i);
        this.epr = fmVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        cq cqVar;
        cq cqVar2;
        if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2005016) {
            cqVar = this.epr.enG;
            if (cqVar != null) {
                cqVar2 = this.epr.enG;
                cqVar2.notifyDataSetChanged();
            }
        }
    }
}
