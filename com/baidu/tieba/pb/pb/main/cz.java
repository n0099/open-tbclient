package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class cz extends CustomMessageListener {
    final /* synthetic */ cv eod;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public cz(cv cvVar, int i) {
        super(i);
        this.eod = cvVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        List list;
        com.baidu.tieba.pb.data.f fVar;
        if (customResponsedMessage == null) {
            return;
        }
        list = this.eod.bXW;
        if (!com.baidu.tbadk.core.util.x.r(list)) {
            return;
        }
        this.eod.abE();
        cv cvVar = this.eod;
        fVar = this.eod.ekc;
        cvVar.a(fVar, false);
    }
}
