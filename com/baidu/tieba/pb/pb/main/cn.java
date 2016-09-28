package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class cn extends CustomMessageListener {
    final /* synthetic */ cj eqG;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public cn(cj cjVar, int i) {
        super(i);
        this.eqG = cjVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        List list;
        com.baidu.tieba.pb.data.h hVar;
        if (customResponsedMessage == null) {
            return;
        }
        list = this.eqG.bVL;
        if (!com.baidu.tbadk.core.util.y.t(list)) {
            return;
        }
        this.eqG.adk();
        cj cjVar = this.eqG;
        hVar = this.eqG.emS;
        cjVar.b(hVar);
    }
}
