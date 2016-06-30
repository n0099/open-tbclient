package com.baidu.tieba.pb.pb.a;

import android.text.TextUtils;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.data.az;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class t extends CustomMessageListener {
    final /* synthetic */ e dML;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public t(e eVar, int i) {
        super(i);
        this.dML = eVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        com.baidu.tieba.pb.data.h hVar;
        com.baidu.tieba.pb.data.h hVar2;
        com.baidu.tieba.pb.data.h hVar3;
        com.baidu.tieba.pb.data.h hVar4;
        if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof az)) {
            az azVar = (az) customResponsedMessage.getData();
            if (!TextUtils.isEmpty(azVar.getId()) && azVar.getPraise() != null) {
                hVar = this.dML.dMC;
                if (hVar != null) {
                    hVar2 = this.dML.dMC;
                    if (hVar2.aDO() != null) {
                        hVar3 = this.dML.dMC;
                        if (!TextUtils.isEmpty(hVar3.aDO().getId())) {
                            String id = azVar.getId();
                            hVar4 = this.dML.dMC;
                            if (!id.equals(hVar4.aDO().getId())) {
                            }
                        }
                    }
                }
            }
        }
    }
}
