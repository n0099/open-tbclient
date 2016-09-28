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
    final /* synthetic */ b eox;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(b bVar, int i) {
        super(i);
        this.eox = bVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        dh dhVar;
        dh dhVar2;
        dh dhVar3;
        dh dhVar4;
        int b;
        dhVar = this.eox.eov;
        if (dhVar != null) {
            dhVar2 = this.eox.eov;
            if (dhVar2.aOR() != null && customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.graffiti.c)) {
                com.baidu.tieba.graffiti.c cVar = (com.baidu.tieba.graffiti.c) customResponsedMessage.getData();
                String threadId = cVar.getThreadId();
                com.baidu.tbadk.core.data.ac ajU = cVar.ajU();
                if (ajU != null && !TextUtils.isEmpty(threadId)) {
                    dhVar3 = this.eox.eov;
                    if (threadId.equals(dhVar3.getThreadID())) {
                        dhVar4 = this.eox.eov;
                        com.baidu.tbadk.core.data.ad aOi = dhVar4.aOR().aOi();
                        if (aOi != null) {
                            List<com.baidu.tbadk.core.data.ac> items = aOi.getItems();
                            if (items == null) {
                                items = new ArrayList<>();
                            }
                            b = this.eox.b(ajU.getGid(), items);
                            if (b >= 0 && com.baidu.tbadk.core.util.y.d(items, b) != null) {
                                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_GRAFFITI_LIST_CHANGED, aOi));
                                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_RECORDER_RESET_CMD));
                            }
                        }
                    }
                }
            }
        }
    }
}
