package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ck extends CustomMessageListener {
    final /* synthetic */ ch ecD;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ck(ch chVar, int i) {
        super(i);
        this.ecD = chVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        List list;
        com.baidu.tieba.pb.data.h hVar;
        if (customResponsedMessage == null) {
            return;
        }
        list = this.ecD.bKC;
        if (!com.baidu.tbadk.core.util.y.t(list)) {
            return;
        }
        this.ecD.Yk();
        ch chVar = this.ecD;
        hVar = this.ecD.dYM;
        chVar.b(hVar);
    }
}
