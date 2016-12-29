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
public class c extends CustomMessageListener {
    final /* synthetic */ b dYC;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(b bVar, int i) {
        super(i);
        this.dYC = bVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        dc dcVar;
        dc dcVar2;
        dc dcVar3;
        com.baidu.tbadk.core.data.ad graffitiInfo;
        dc dcVar4;
        int a;
        dcVar = this.dYC.dYA;
        if (dcVar != null) {
            dcVar2 = this.dYC.dYA;
            if (dcVar2.aKH() != null && customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.graffiti.k)) {
                com.baidu.tieba.graffiti.k kVar = (com.baidu.tieba.graffiti.k) customResponsedMessage.getData();
                String threadId = kVar.getThreadId();
                if (!TextUtils.isEmpty(threadId)) {
                    dcVar3 = this.dYC.dYA;
                    if (threadId.equals(dcVar3.getThreadID()) && (graffitiInfo = kVar.getGraffitiInfo()) != null && graffitiInfo.qj()) {
                        dcVar4 = this.dYC.dYA;
                        com.baidu.tbadk.core.data.ae aKa = dcVar4.aKH().aKa();
                        if (aKa != null) {
                            List<com.baidu.tbadk.core.data.ad> items = aKa.getItems();
                            if (items == null) {
                                items = new ArrayList<>();
                            }
                            a = this.dYC.a(graffitiInfo.getUid(), items);
                            if (a >= 0) {
                                com.baidu.tbadk.core.util.x.d(items, a);
                            }
                            items.add(0, graffitiInfo);
                        }
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_GRAFFITI_LIST_CHANGED, aKa));
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_RECORDER_RESET_CMD));
                    }
                }
            }
        }
    }
}
