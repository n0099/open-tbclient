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
    final /* synthetic */ b euh;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(b bVar, int i) {
        super(i);
        this.euh = bVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        dj djVar;
        dj djVar2;
        dj djVar3;
        dj djVar4;
        int b;
        djVar = this.euh.euf;
        if (djVar != null) {
            djVar2 = this.euh.euf;
            if (djVar2.aQK() != null && customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.graffiti.c)) {
                com.baidu.tieba.graffiti.c cVar = (com.baidu.tieba.graffiti.c) customResponsedMessage.getData();
                String threadId = cVar.getThreadId();
                com.baidu.tbadk.core.data.ae alP = cVar.alP();
                if (alP != null && !TextUtils.isEmpty(threadId)) {
                    djVar3 = this.euh.euf;
                    if (threadId.equals(djVar3.getThreadID())) {
                        djVar4 = this.euh.euf;
                        com.baidu.tbadk.core.data.af aQb = djVar4.aQK().aQb();
                        if (aQb != null) {
                            List<com.baidu.tbadk.core.data.ae> items = aQb.getItems();
                            if (items == null) {
                                items = new ArrayList<>();
                            }
                            b = this.euh.b(alP.getGid(), items);
                            if (b >= 0 && com.baidu.tbadk.core.util.x.d(items, b) != null) {
                                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_GRAFFITI_LIST_CHANGED, aQb));
                                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_RECORDER_RESET_CMD));
                            }
                        }
                    }
                }
            }
        }
    }
}
