package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class cu extends CustomMessageListener {
    final /* synthetic */ cq ejI;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public cu(cq cqVar, int i) {
        super(i);
        this.ejI = cqVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        List list;
        com.baidu.tieba.pb.data.f fVar;
        if (customResponsedMessage == null) {
            return;
        }
        list = this.ejI.bKZ;
        if (!com.baidu.tbadk.core.util.w.s(list)) {
            return;
        }
        this.ejI.ZT();
        cq cqVar = this.ejI;
        fVar = this.ejI.egj;
        cqVar.b(fVar);
    }
}
