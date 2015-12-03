package com.baidu.tieba.personInfo;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class u extends CustomMessageListener {
    final /* synthetic */ d cSn;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public u(d dVar, int i) {
        super(i);
        this.cSn = dVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        aw awVar;
        az azVar;
        az azVar2;
        az azVar3;
        aw awVar2;
        az azVar4;
        if (customResponsedMessage != null) {
            awVar = this.cSn.cMT;
            awVar.apr();
            azVar = this.cSn.cRH;
            if (azVar != null) {
                azVar2 = this.cSn.cRH;
                if (azVar2.cTA != null) {
                    azVar3 = this.cSn.cRH;
                    com.baidu.tieba.person.a.b bVar = azVar3.cTA;
                    awVar2 = this.cSn.cMT;
                    bVar.J(awVar2.getDataList());
                    azVar4 = this.cSn.cRH;
                    azVar4.cTA.notifyDataSetChanged();
                }
            }
        }
    }
}
