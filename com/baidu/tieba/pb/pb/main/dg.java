package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class dg extends CustomMessageListener {
    final /* synthetic */ dc exj;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public dg(dc dcVar, int i) {
        super(i);
        this.exj = dcVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        List list;
        com.baidu.tieba.pb.data.f fVar;
        if (customResponsedMessage == null) {
            return;
        }
        list = this.exj.cgf;
        if (!com.baidu.tbadk.core.util.z.t(list)) {
            return;
        }
        this.exj.afv();
        dc dcVar = this.exj;
        fVar = this.exj.eta;
        dcVar.a(fVar, false);
    }
}
