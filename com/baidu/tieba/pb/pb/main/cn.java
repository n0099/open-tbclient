package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class cn extends CustomMessageListener {
    final /* synthetic */ cj eaQ;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public cn(cj cjVar, int i) {
        super(i);
        this.eaQ = cjVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        List list;
        com.baidu.tieba.pb.data.f fVar;
        if (customResponsedMessage == null) {
            return;
        }
        list = this.eaQ.bEG;
        if (!com.baidu.tbadk.core.util.x.t(list)) {
            return;
        }
        this.eaQ.YR();
        cj cjVar = this.eaQ;
        fVar = this.eaQ.dXl;
        cjVar.b(fVar);
    }
}
