package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class co extends CustomMessageListener {
    final /* synthetic */ ck ewv;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public co(ck ckVar, int i) {
        super(i);
        this.ewv = ckVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        List list;
        com.baidu.tieba.pb.data.h hVar;
        if (customResponsedMessage == null) {
            return;
        }
        list = this.ewv.bYT;
        if (!com.baidu.tbadk.core.util.x.t(list)) {
            return;
        }
        this.ewv.aex();
        ck ckVar = this.ewv;
        hVar = this.ewv.esP;
        ckVar.b(hVar);
    }
}
