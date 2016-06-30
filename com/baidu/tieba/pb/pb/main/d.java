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
    final /* synthetic */ b dOh;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(b bVar, int i) {
        super(i);
        this.dOh = bVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        dg dgVar;
        dg dgVar2;
        dg dgVar3;
        dg dgVar4;
        int b;
        dgVar = this.dOh.dOf;
        if (dgVar != null) {
            dgVar2 = this.dOh.dOf;
            if (dgVar2.aGh() != null && customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.graffiti.c)) {
                com.baidu.tieba.graffiti.c cVar = (com.baidu.tieba.graffiti.c) customResponsedMessage.getData();
                String threadId = cVar.getThreadId();
                com.baidu.tbadk.core.data.w aes = cVar.aes();
                if (aes != null && !TextUtils.isEmpty(threadId)) {
                    dgVar3 = this.dOh.dOf;
                    if (threadId.equals(dgVar3.getThreadID())) {
                        dgVar4 = this.dOh.dOf;
                        com.baidu.tbadk.core.data.x aFy = dgVar4.aGh().aFy();
                        if (aFy != null) {
                            List<com.baidu.tbadk.core.data.w> items = aFy.getItems();
                            if (items == null) {
                                items = new ArrayList<>();
                            }
                            b = this.dOh.b(aes.getGid(), items);
                            if (b >= 0 && com.baidu.tbadk.core.util.y.d(items, b) != null) {
                                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_GRAFFITI_LIST_CHANGED, aFy));
                                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_RECORDER_RESET_CMD));
                            }
                        }
                    }
                }
            }
        }
    }
}
