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
    final /* synthetic */ b dij;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(b bVar, int i) {
        super(i);
        this.dij = bVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        cw cwVar;
        cw cwVar2;
        cw cwVar3;
        cw cwVar4;
        int d;
        cwVar = this.dij.dih;
        if (cwVar != null) {
            cwVar2 = this.dij.dih;
            if (cwVar2.axY() != null && customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.graffiti.c)) {
                com.baidu.tieba.graffiti.c cVar = (com.baidu.tieba.graffiti.c) customResponsedMessage.getData();
                String threadId = cVar.getThreadId();
                com.baidu.tbadk.core.data.u Ya = cVar.Ya();
                if (Ya != null && !TextUtils.isEmpty(threadId)) {
                    cwVar3 = this.dij.dih;
                    if (threadId.equals(cwVar3.getThreadID())) {
                        cwVar4 = this.dij.dih;
                        com.baidu.tbadk.core.data.v axq = cwVar4.axY().axq();
                        if (axq != null) {
                            List<com.baidu.tbadk.core.data.u> items = axq.getItems();
                            if (items == null) {
                                items = new ArrayList<>();
                            }
                            d = this.dij.d(Ya.getGid(), items);
                            if (d >= 0 && com.baidu.tbadk.core.util.y.d(items, d) != null) {
                                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_GRAFFITI_LIST_CHANGED, axq));
                                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_RECORDER_RESET_CMD));
                            }
                        }
                    }
                }
            }
        }
    }
}
