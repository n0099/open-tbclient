package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ct extends CustomMessageListener {
    final /* synthetic */ cp emB;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ct(cp cpVar, int i) {
        super(i);
        this.emB = cpVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        List list;
        com.baidu.tieba.pb.data.f fVar;
        if (customResponsedMessage == null) {
            return;
        }
        list = this.emB.bSf;
        if (!com.baidu.tbadk.core.util.x.q(list)) {
            return;
        }
        this.emB.aaQ();
        cp cpVar = this.emB;
        fVar = this.emB.ejb;
        cpVar.b(fVar);
    }
}
