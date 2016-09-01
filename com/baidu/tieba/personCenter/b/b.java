package com.baidu.tieba.personCenter.b;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.data.j;
import com.baidu.tieba.personCenter.g.g;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b extends CustomMessageListener {
    final /* synthetic */ a eDm;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(a aVar, int i) {
        super(i);
        this.eDm = aVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        j jVar;
        g gVar;
        if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof j) && (jVar = (j) customResponsedMessage.getData()) != null) {
            gVar = this.eDm.eDd;
            gVar.pw(jVar.rc());
        }
    }
}
