package com.baidu.tieba.person;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class dv extends CustomMessageListener {
    final /* synthetic */ dt a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public dv(dt dtVar, int i) {
        super(i);
        this.a = dtVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    /* renamed from: a */
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        dw dwVar;
        dw dwVar2;
        dw dwVar3;
        dw dwVar4;
        if (customResponsedMessage != null && (customResponsedMessage instanceof ResponseLocalPersonListMessage)) {
            com.baidu.tieba.data.am data2 = ((ResponseLocalPersonListMessage) customResponsedMessage).getData2();
            if (data2 != null) {
                dwVar3 = this.a.h;
                if (dwVar3 != null) {
                    dwVar4 = this.a.h;
                    dwVar4.a(data2, true);
                    return;
                }
                return;
            }
            dwVar = this.a.h;
            if (dwVar != null) {
                dwVar2 = this.a.h;
                dwVar2.a("", true);
            }
        }
    }
}
