package com.baidu.tieba.pb.pb.main;

import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import java.util.ArrayList;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d extends CustomMessageListener {
    final /* synthetic */ b dYC;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(b bVar, int i) {
        super(i);
        this.dYC = bVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        dc dcVar;
        dc dcVar2;
        dc dcVar3;
        dc dcVar4;
        int b;
        dcVar = this.dYC.dYA;
        if (dcVar != null) {
            dcVar2 = this.dYC.dYA;
            if (dcVar2.aKH() != null && customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.graffiti.c)) {
                com.baidu.tieba.graffiti.c cVar = (com.baidu.tieba.graffiti.c) customResponsedMessage.getData();
                String threadId = cVar.getThreadId();
                com.baidu.tbadk.core.data.ad agq = cVar.agq();
                if (agq != null && !TextUtils.isEmpty(threadId)) {
                    dcVar3 = this.dYC.dYA;
                    if (threadId.equals(dcVar3.getThreadID())) {
                        dcVar4 = this.dYC.dYA;
                        com.baidu.tbadk.core.data.ae aKa = dcVar4.aKH().aKa();
                        if (aKa != null) {
                            List<com.baidu.tbadk.core.data.ad> items = aKa.getItems();
                            if (items == null) {
                                items = new ArrayList<>();
                            }
                            b = this.dYC.b(agq.getGid(), items);
                            if (b >= 0 && com.baidu.tbadk.core.util.x.d(items, b) != null) {
                                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_GRAFFITI_LIST_CHANGED, aKa));
                                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_RECORDER_RESET_CMD));
                            }
                        }
                    }
                }
            }
        }
    }
}
