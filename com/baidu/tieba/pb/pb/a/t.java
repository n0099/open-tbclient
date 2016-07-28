package com.baidu.tieba.pb.pb.a;

import android.text.TextUtils;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.data.be;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class t extends CustomMessageListener {
    final /* synthetic */ e dYX;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public t(e eVar, int i) {
        super(i);
        this.dYX = eVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        com.baidu.tieba.pb.data.h hVar;
        com.baidu.tieba.pb.data.h hVar2;
        com.baidu.tieba.pb.data.h hVar3;
        com.baidu.tieba.pb.data.h hVar4;
        if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof be)) {
            be beVar = (be) customResponsedMessage.getData();
            if (!TextUtils.isEmpty(beVar.getId()) && beVar.qp() != null) {
                hVar = this.dYX.dYM;
                if (hVar != null) {
                    hVar2 = this.dYX.dYM;
                    if (hVar2.aGY() != null) {
                        hVar3 = this.dYX.dYM;
                        if (!TextUtils.isEmpty(hVar3.aGY().getId())) {
                            String id = beVar.getId();
                            hVar4 = this.dYX.dYM;
                            if (!id.equals(hVar4.aGY().getId())) {
                            }
                        }
                    }
                }
            }
        }
    }
}
